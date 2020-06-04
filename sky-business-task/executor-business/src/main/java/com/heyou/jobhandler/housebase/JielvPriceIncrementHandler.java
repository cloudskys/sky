package com.heyou.jobhandler.housebase;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heyou.entity.housebase.vo.JielvChangedHotelVO;
import com.heyou.entity.housebase.vo.JielvSourceData;
import com.heyou.service.housebase.IJielvInfoService;
import com.heyou.service.housebase.IJielvSourceDataService;
import com.heyou.util.Contants;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.xxl.job.core.biz.model.ReturnT.FAIL;
import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/7 14:34
 * @Version: 1.0
 */
@JobHandler(value = "jielvPriceIncrementHandler" )
@Component
public class JielvPriceIncrementHandler extends IJobHandler {

    @Autowired
    private IJielvSourceDataService jielvSourceDataService;
    @Autowired
    private IJielvInfoService jielvInfoService;
    @Resource(name = "amqpTemplate")
    private RabbitTemplate rabbitTemplate;

    @Override
    public ReturnT<String> execute(String ...param){
        String result = jielvInfoService.getHotelPriceIncrement();
        if (StringUtils.isNotBlank(result)){
            JSONObject jsonObject = JSONObject.parseObject(result);
            int code = jsonObject.getIntValue("code");
            if(code == 0 ){
                jsonObject = jsonObject.getJSONObject("result").getJSONObject("changedPrice");
                JSONArray jsonArray = jsonObject.getJSONArray("changedHotels");
                List<JielvChangedHotelVO> changedHotelList = JSONObject.parseArray(JSONObject.toJSONString(jsonArray),JielvChangedHotelVO.class);
                if(changedHotelList!=null && changedHotelList.size()>0){
                    for(JielvChangedHotelVO vo:changedHotelList){
                        if(vo.getType() == 1 ){//1:变价变条款
                            updateSourceData(vo.getHotelId(),0,1);
                        }else if (vo.getType() == 2){//2:变价
                            updateSourceData(vo.getHotelId(),0,2);
                        }else if (vo.getType() == 3){//3:变条款
                            updateSourceData(vo.getHotelId(),1,3);
                        }else if(vo.getType() == 99){//99:更新该酒店全量缓存
                            rabbitTemplate.convertAndSend(Contants.exchange,Contants.delJielvHotelKey,vo.getHotelId());
                        }
                    }
                }
            }else{
                ReturnT<String> fail = FAIL;
                fail.setMsg("code="+jsonObject.getInteger("code")+",message:"+jsonObject.getString("errorMsg"));
                return fail;
            }
        }
        return SUCCESS;
    }

    public void updateSourceData(int hotelId,int state,int type) {
        Integer sourceId =  jielvSourceDataService.getIdByHotelId(hotelId);
        if(sourceId !=null && sourceId > 0){
            Map<String,Object> resultMap = jielvSourceDataService.getHotelPrice(hotelId);
            JielvSourceData sourceData = new JielvSourceData();
            sourceData.setId(sourceId);
            sourceData.setType(type);
            sourceData.setHotelId(hotelId);
            sourceData.setUpdateTime(new Date());
            sourceData.setState(state);
            if(resultMap.get("rooms") !=null){
                sourceData.setRoomRatePlan((String) resultMap.get("rooms"));
            }
            if(resultMap.get("bookingRules") !=null){
                sourceData.setBookingRules((String) resultMap.get("bookingRules"));
            }
            if(resultMap.get("refundRules") !=null){
                sourceData.setRefundRules((String) resultMap.get("refundRules"));
            }
            jielvSourceDataService.updateSourceDate(sourceData);
        }
    }




}
