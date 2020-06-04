package com.heyou.jobhandler.housebase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heyou.entity.housebase.vo.*;
import com.heyou.service.housebase.IJielvSourceDataService;
import com.heyou.util.Contants;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/22 11:42
 * @Version: 1.0
 */
@JobHandler(value = "getUndisposedJielvSourceData")
@Component
public class GetUndisposedJielvSourceData  extends IJobHandler {

    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private IJielvSourceDataService jielvSourceDataService;
    @Resource(name = "amqpTemplate")
    private RabbitTemplate rabbitTemplate;

    @Override
    public ReturnT<String> execute(String... params) {
        logger.info("===============执行查询开始：....");
        List<JielvSourceData> sourceDataList = jielvSourceDataService.getUndisposedSourceDateInfo();
        logger.info("===============查询结果：...."+sourceDataList);
        if(sourceDataList !=null && sourceDataList.size() > 0){
            for(JielvSourceData data:sourceDataList){
                JielvSourceData updateSource = new JielvSourceData();
                updateSource.setState(1);
                updateSource.setId(data.getId());
                jielvSourceDataService.updateSourceDate(updateSource);
                int type = data.getType();
                switch (type){
                    case 1 ://变价变条款
                        JielvHotelRatePlan priceAndRule = returnJielvHotelRatePlan(data.getHotelId(),data.getRoomRatePlan(),data.getBookingRules(),data.getRefundRules());
                        if (priceAndRule != null) {
                            rabbitTemplate.convertAndSend(Contants.exchange,Contants.addOrUpdateJielvHotelPriceAndRuleKey,priceAndRule);
                        }
                        break;
                    case 2 ://变价
                        JielvHotelRatePlan price = returnJielvHotelRatePlan(data.getHotelId(),data.getRoomRatePlan(),data.getBookingRules(),data.getRefundRules());
                        if (price != null) {
                            rabbitTemplate.convertAndSend(Contants.exchange,Contants.addOrUpdateHotelPriceKey,price);
                        }
                        break;
                    case 3 ://变条款
                        JielvHotelRatePlan rule = returnJielvHotelRatePlan(data.getHotelId(),data.getRoomRatePlan(),data.getBookingRules(),data.getRefundRules());
                        if (rule != null) {
                            rabbitTemplate.convertAndSend(Contants.exchange,Contants.addOrUpdateJielvHotelRuleKey,rule);
                        }
                        break;
                    case 4 ://酒店基本静态信息
                        JielvHotelInfoVO staticInfo = returnJielvHotelInfo(data.getHotelInfo(),data.getRateType(),data.getRoomType(),data.getImageList());
                        if (staticInfo != null) {
                            rabbitTemplate.convertAndSend(Contants.exchange,Contants.updateJielvHotelStaticInfoKey,staticInfo);
                        }
                        break;
                    case 0:
                        JielvHotelInfoVO hotelAllInfo = returnJielvHotelInfo(data.getHotelInfo(),data.getRateType(),data.getRoomType(),data.getImageList());
                        if (hotelAllInfo != null) {
                            JielvHotelRatePlan rateplan = returnJielvHotelRatePlan(data.getHotelId(),data.getRoomRatePlan(),data.getBookingRules(),data.getRefundRules());
                            if (rateplan != null){
                                hotelAllInfo.setJielvHotelRatePlan(rateplan);
                            }
                            rabbitTemplate.convertAndSend(Contants.exchange,Contants.addOrUpdateJielvHotelAllKey,hotelAllInfo);
                        }
                        break;
                    case 99://修改酒店基本信息
                        int hotelId = data.getHotelId();
                        rabbitTemplate.convertAndSend(Contants.exchange,Contants.delJielvHotelKey,hotelId);
                        break;
                }
            }
        }
        return SUCCESS;
    }

    public JielvHotelInfoVO returnJielvHotelInfo(String hotelInfo,String rateType,String roomType,String imageList){
        JielvHotelInfoVO hotelInfoVO = new JielvHotelInfoVO();
        if (StringUtils.isNotBlank(hotelInfo)) {
            //拼装酒店对象
            hotelInfoVO = JSON.toJavaObject(JSONObject.parseObject(hotelInfo),JielvHotelInfoVO.class);
            if(StringUtils.isNotBlank(roomType)){//拼装房型信息
                List<JielvRoomTypeVO> jielvRoomTypeVOList = JSONObject.parseArray(roomType,JielvRoomTypeVO.class);
                if(jielvRoomTypeVOList != null && jielvRoomTypeVOList.size() > 0 ){
                    hotelInfoVO.setJielvRoomTypeList(jielvRoomTypeVOList);
                }
            }
            if(StringUtils.isNotBlank(rateType)){//拼装价格类型
                List<JielvRateTypeVO> jielvRateTypeVOList = JSONObject.parseArray(rateType,JielvRateTypeVO.class);
                if(jielvRateTypeVOList != null && jielvRateTypeVOList.size() > 0){
                    hotelInfoVO.setJielvRateTypeList(jielvRateTypeVOList);
                }
            }
            if(StringUtils.isNotBlank(imageList)){//拼装图片集合
                List<JielvImageVO> jielvImageVOList = JSONObject.parseArray(imageList,JielvImageVO.class);
                if(jielvImageVOList != null && jielvImageVOList.size() > 0){
                    hotelInfoVO.setJielvImageList(jielvImageVOList);
                }
            }

        }
        return hotelInfoVO;
    }

    public JielvHotelRatePlan returnJielvHotelRatePlan(int hotelId,String roomRatePlan,String bookingRule,String refundRule){
        JielvHotelRatePlan hotelRatePlan = new JielvHotelRatePlan();
        hotelRatePlan.setHotelId(hotelId);
        if(StringUtils.isNotBlank(roomRatePlan)){//拼装价格数组
            List<Room> roomList = JSONObject.parseArray(roomRatePlan,Room.class);
            if(roomList != null && roomList.size() > 0){
                hotelRatePlan.setRooms(roomList);
            }
        }
        if(StringUtils.isNotBlank(bookingRule)){//拼装预定条款
            List<BookingRule> bookingRuleList = JSONObject.parseArray(bookingRule,BookingRule.class);
            if(bookingRuleList != null && bookingRuleList.size() > 0){
                hotelRatePlan.setBookingRules(bookingRuleList);
            }
        }
        if(StringUtils.isNotBlank(refundRule)){//拼装取消条款
            List<RefundRule> refundRuleList = JSONObject.parseArray(refundRule,RefundRule.class);
            if(refundRuleList != null && refundRuleList.size() > 0 ){
                hotelRatePlan.setRefundRules(refundRuleList);
            }
        }
        return hotelRatePlan;
    }




}
