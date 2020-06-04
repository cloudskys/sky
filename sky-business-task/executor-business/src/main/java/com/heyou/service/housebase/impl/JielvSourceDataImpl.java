package com.heyou.service.housebase.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.heyou.config.JielvSystemConfig;
import com.heyou.dao.housebase.IJielvSourceDataDao;
import com.heyou.entity.housebase.vo.*;
import com.heyou.service.housebase.IJielvInfoService;
import com.heyou.service.housebase.IJielvSourceDataService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/22 10:54
 * @Version: 1.0
 */
@Service
public class JielvSourceDataImpl implements IJielvSourceDataService {

    @Autowired
    private IJielvSourceDataDao jielvSourceDataDao;
    @Autowired
    private IJielvInfoService jielvInfoService;
    @Autowired
    private JielvSystemConfig jielvSystemConfig;


    @Transactional
    @Override
    public int insertSourceDate(JielvSourceData data) {
        return jielvSourceDataDao.insertSelective(data);
    }

    @Transactional
    @Override
    public int updateSourceDate(JielvSourceData data) {
        return jielvSourceDataDao.updateByPrimaryKeySelective(data);
    }

    @Override
    public Integer getIdByHotelId(int hotelId) {
        return jielvSourceDataDao.jielvSourceDataDao(hotelId);
    }

    @Override
    public void getHotelDetailInfo(int hotelId, Integer sourceId, int type) {
        JielvSourceData sourceData = new JielvSourceData();
        sourceData.setUpdateTime(new Date());
        sourceData.setState(0);
        sourceData.setHotelId(hotelId);
        sourceData.setType(type);
        String result = jielvInfoService.getHotelDetail(hotelId);
        if(StringUtils.isNotBlank(result)){
            JSONObject jsonObject = JSONObject.parseObject(result);
            int code = jsonObject.getIntValue("code");
            if(code == 0){
                jsonObject = jsonObject.getJSONObject("result");
                JSONArray hotelDetailListStr = jsonObject.getJSONArray("hotelDetailList");
                jsonObject = (JSONObject) hotelDetailListStr.get(0);
                Map<String,Object> jsonMap = JSONObject.parseObject(jsonObject.toJSONString(),new TypeReference<Map<String, Object>>(){});
                JSONObject hotelInfoObject = (JSONObject) jsonMap.get("hotelInfo");
                //得到hotelinfo对象
                if(hotelInfoObject != null){
                    sourceData.setHotelInfo(hotelInfoObject.toJSONString());
                }

                //得到房型对象并赋值给hotelinfo对象
                JSONArray roomTypeListJson = (JSONArray) jsonMap.get("roomTypeList");
                if(roomTypeListJson!=null && roomTypeListJson.size()>0){
                    sourceData.setRoomType(JSONObject.toJSONString(roomTypeListJson));
                }
                //格类型信息
                JSONArray rateTypeJson = (JSONArray) jsonMap.get("rateTypeList");
                if(rateTypeJson!=null && rateTypeJson.size()>0){
                    sourceData.setRateType(JSONObject.toJSONString(rateTypeJson));
                }
                //图片集合
                JSONArray imageJson = (JSONArray) jsonMap.get("imageList");
                if(imageJson!=null && imageJson.size()>0){
                    sourceData.setImageList(JSONObject.toJSONString(imageJson));
                }
                //获取酒店产品组和价格
                Map<String,Object> resultMap = getHotelPrice(hotelId);
                if(resultMap !=null && resultMap.size() > 0){
                    if(resultMap.get("rooms") !=null){
                        sourceData.setRoomRatePlan((String) resultMap.get("rooms"));
                    }
                    if(resultMap.get("bookingRules") !=null){
                        sourceData.setBookingRules((String) resultMap.get("bookingRules"));
                    }
                    if(resultMap.get("refundRules") !=null){
                        sourceData.setRefundRules((String) resultMap.get("refundRules"));
                    }
                }

                if(sourceId == null ){//新增入库
                    sourceData.setCreateTime(new Date());
                    if(StringUtils.isBlank(sourceData.getRoomRatePlan())){
                        sourceData.setRoomRatePlan("0");
                    }
                    insertSourceDate(sourceData);
                }else{//修改
                    sourceData.setId(sourceId);
                    updateSourceDate(sourceData);
                }


            }
        }
    }

    @Override
    public void initHotelStaticInfo(int hotelId, Integer sourceId, int type) {
        JielvSourceData sourceData = new JielvSourceData();
        sourceData.setUpdateTime(new Date());
        sourceData.setState(0);
        sourceData.setHotelId(hotelId);
        sourceData.setType(type);
        String result = jielvInfoService.getHotelDetail(hotelId);
        if(StringUtils.isNotBlank(result)){
            JSONObject jsonObject = JSONObject.parseObject(result);
            int code = jsonObject.getIntValue("code");
            if(code == 0){
                jsonObject = jsonObject.getJSONObject("result");
                JSONArray hotelDetailListStr = jsonObject.getJSONArray("hotelDetailList");
                jsonObject = (JSONObject) hotelDetailListStr.get(0);
                Map<String,Object> jsonMap = JSONObject.parseObject(jsonObject.toJSONString(),new TypeReference<Map<String, Object>>(){});
                JSONObject hotelInfoObject = (JSONObject) jsonMap.get("hotelInfo");
                //得到hotelinfo对象
                if(hotelInfoObject != null){
                    sourceData.setHotelInfo(hotelInfoObject.toJSONString());
                }

                //得到房型对象并赋值给hotelinfo对象
                JSONArray roomTypeListJson = (JSONArray) jsonMap.get("roomTypeList");
                if(roomTypeListJson!=null && roomTypeListJson.size()>0){
                    sourceData.setRoomType(JSONObject.toJSONString(roomTypeListJson));
                }
                //格类型信息
                JSONArray rateTypeJson = (JSONArray) jsonMap.get("rateTypeList");
                if(rateTypeJson!=null && rateTypeJson.size()>0){
                    sourceData.setRateType(JSONObject.toJSONString(rateTypeJson));
                }
                //图片集合
                JSONArray imageJson = (JSONArray) jsonMap.get("imageList");
                if(imageJson!=null && imageJson.size()>0){
                    sourceData.setImageList(JSONObject.toJSONString(imageJson));
                }

                if(sourceId == null ){//新增入库
                    sourceData.setCreateTime(new Date());
                    if(StringUtils.isBlank(sourceData.getRoomRatePlan())){
                        sourceData.setRoomRatePlan("0");
                    }
                    insertSourceDate(sourceData);
                }else{//修改
                    sourceData.setId(sourceId);
                    updateSourceDate(sourceData);
                }


            }
        }
    }

    @Override
    public Map<String, Object> getHotelPrice(int hotelId) {
        Map<String,Object> priceMap = new HashMap<String, Object>();
        String priceStr = jielvInfoService.getHotelPrice(hotelId);
        if(StringUtils.isNotBlank(priceStr)){
            priceMap = returnHotelMinPrice(priceStr);
        }
        return priceMap;
    }

    @Override
    public List<JielvSourceData> getUndisposedSourceDateInfo() {
        return jielvSourceDataDao.getUndisposedSourceDateInfo();
    }

    @Override
    public List<Integer> getAllJielvHotelId() {
        return jielvSourceDataDao.getAllJielvHotelId();
    }

    @Override
    public int deleteObsoleteNightlyRate(String delDete) {
        return jielvSourceDataDao.deleteObsoleteNightlyRate(delDete);
    }

    public Map<String,Object> returnHotelMinPrice(String result){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        List<Integer> priceList = new ArrayList<Integer>();
        if(StringUtils.isNotBlank(result)){
            JSONObject jsonObject = JSONObject.parseObject(result);
            int code = jsonObject.getIntValue("code");
            if(code == 0){
                jsonObject = jsonObject.getJSONObject("result");
                JSONArray jsonArray = jsonObject.getJSONArray("hotelRatePlanList");
                String str = JSONObject.toJSONString(jsonArray);
                List<JielvHotelRatePlan> list = JSONObject.parseArray(str,JielvHotelRatePlan.class);
                List<Room> rooms = list.get(0).getRooms();
                //拿到预定条款id为key放进map，便利产品是从这里边拿
                List<BookingRule> bookingRules = list.get(0).getBookingRules();
                Map<String,Object> bookingMap = new HashMap<String,Object>();
                if(bookingRules !=null && bookingRules.size()>0){
                    resultMap.put("bookingRules",JSONObject.toJSONString(bookingRules));
                    for (BookingRule bookingRule:bookingRules){
                        bookingMap.put(bookingRule.getBookingRuleId(),bookingRule);
                    }
                }
                List<RefundRule> refundRules = list.get(0).getRefundRules();
                if(refundRules !=null && refundRules.size() > 0){
                    resultMap.put("refundRules",JSONObject.toJSONString(refundRules));
                }
                if(rooms !=null && rooms.size() > 0){
                    resultMap.put("rooms",JSONObject.toJSONString(rooms));
                    Double raisePrice = jielvSystemConfig.getRaisePrice();
                    if (raisePrice == null) {
                        raisePrice = 0.1;
                    }
                    for(Room room:rooms){//循环房型
                        String roomTypeId = room.getRoomTypeId();//房型id
                        List<RatePlans> ratePlans = room.getRatePlans();//房型产品集合
                        boolean getRoomPlan = false;
                        if(ratePlans !=null && ratePlans.size()> 0){
                            if (!getRoomPlan) {//  getRoomPlan 为false ，代表没拿到产品
                                for (RatePlans ratePlan:ratePlans) {//循环房型下的产品，然后智取一条
                                    if (!getRoomPlan) {
                                        if(ratePlan != null){
                                            List<NightlyRate> nightlyRates = ratePlan.getNightlyRates();
                                            //循环产品下的价格
                                            for(NightlyRate rate:nightlyRates){
                                                //1.判断房态，如果满房直接跳出取下一个产品
                                                if(rate.getStatus()!=null && rate.getStatus()==3){
                                                    break;
                                                }
                                                //2。取出预定条款id，如果空则取产品的预定条款id，要取预定条款的最小入住天数，如果大于1天则不取该产品
                                                String bookingRuleId = "";
                                                if(StringUtils.isNotBlank(rate.getBookingRuleId())){
                                                    bookingRuleId = rate.getBookingRuleId();
                                                }else{
                                                    if(StringUtils.isNotBlank(ratePlan.getBookingRuleId())){
                                                        bookingRuleId = ratePlan.getBookingRuleId();
                                                    }else{//如果产品，价格的预定条款都为空，直接跳出
                                                        break;
                                                    }
                                                }
                                                BookingRule bookingRule = (BookingRule) bookingMap.get(bookingRuleId);
                                                //如果条款空或最少不是入住一天直接跳出
                                                if(bookingRule == null || bookingRule.getMinAmount()!=1){
                                                    break;
                                                }else{
                                                    BigDecimal price = new BigDecimal(rate.getCose()).add(
                                                            new BigDecimal(rate.getCose()).multiply(new BigDecimal(raisePrice))
                                                    );
                                                    priceList.add(price.setScale(0,BigDecimal.ROUND_UP).intValue());
                                                    getRoomPlan = true;//代表该房型拿到产品，循环下一个房型
                                                    break;
                                                }

                                            }

                                        }
                                    } else {
                                        break;//已经取到一个产品后跳出
                                    }
                                }
                            }
                        }

                    }
                }
            }else{
                //请求错误码
            }

        }

        if(priceList!=null && priceList.size()>0){
            resultMap.put("minPrice",getMinPrice(priceList));
        }
        return resultMap;
    }

    public int getMinPrice(List<Integer> list){
        int minPrice = 0;
        for(int i = 0 ;i < list.size(); i ++){
            if(i == 0 ){
                minPrice = list.get(i);
            }else{
                if(minPrice > list.get(i)){//找出最低价
                    minPrice = list.get(i);
                }
            }
        }
        return minPrice;
    }

}
