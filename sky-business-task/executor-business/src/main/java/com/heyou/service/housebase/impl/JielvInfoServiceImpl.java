package com.heyou.service.housebase.impl;

import com.alibaba.fastjson.JSON;
import com.heyou.config.JielvHotelRatePlanConfig;
import com.heyou.config.JielvInitHotelInfoConfig;
import com.heyou.config.JielvInithotelDetailConfig;
import com.heyou.config.JielvPriceIncrementConfig;
import com.heyou.dao.houseorder.ExceptionRecordDao;
import com.heyou.entity.houseorder.po.ExceptionRecord;
import com.heyou.jobhandler.housebase.JielvParam;
import com.heyou.service.housebase.IJielvInfoService;
import com.heyou.util.Contants;
import com.heyou.util.HttpClientGzip;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/3/6 17:00
 * @Version: 1.0
 */
@Service
public class JielvInfoServiceImpl implements IJielvInfoService {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private JielvParam jielvParam;
    @Autowired
    private JielvInithotelDetailConfig jielvInithotelDetailConfig;
    @Autowired
    private JielvHotelRatePlanConfig jielvHotelRatePlanConfig;
    @Autowired
    private JielvInitHotelInfoConfig jielvInitHotelInfoConfig;
    @Autowired
    private JielvPriceIncrementConfig jielvPriceIncrementConfig;
    @Autowired
    private ExceptionRecordDao orderExcepLogDao;

    @Override
    public String getHotelPrice(int hotelId) {
        String url = jielvHotelRatePlanConfig.getHostPort() + jielvHotelRatePlanConfig.getUrl();
        String requestParam = getHotelRatePlanParam(hotelId);
        String result = null;
        try {
            result = HttpClientGzip.doGet("",url+ Contants.reqData+requestParam);
        } catch (Exception e) {
            logger.error("请求捷旅酒店查询酒店价格超时或网络异常", e);
            ExceptionRecord exceptionRecord = new ExceptionRecord();
            exceptionRecord.setOrderNo(null);
            exceptionRecord.setExcepMsg("请求捷旅酒店查询酒店价格超时或网络异常!");
            exceptionRecord.setCallMethod(url);
            exceptionRecord.setParams(JSON.toJSONString(Contants.reqData+requestParam));
            exceptionRecord.setExcepSort("jielv");
            exceptionRecord.setReqMode("get");
            exceptionRecord.setLevel(1);
            exceptionRecord.setProcessState(0);
            exceptionRecord.setCreateTime(new Date());
            orderExcepLogDao.insertExceptionRecord(exceptionRecord);
        }
        return result;
    }

    @Override
    public String getHotelDetail(int hotelId){
        String requestParam = getHotelDetailParam(hotelId);
        String url = jielvInithotelDetailConfig.getHostPort() + jielvInithotelDetailConfig.getUrl();
        String result = null;
        try {
            result = HttpClientGzip.doGet("",url+ Contants.reqData+requestParam);
        } catch (Exception e) {
            logger.error("请求捷旅酒店查询酒店详情超时或网络异常", e);
            ExceptionRecord exceptionRecord = new ExceptionRecord();
            exceptionRecord.setOrderNo(null);
            exceptionRecord.setExcepMsg("请求捷旅酒店查询酒店详情超时或网络异常!");
            exceptionRecord.setCallMethod(url);
            exceptionRecord.setParams(JSON.toJSONString(Contants.reqData+requestParam));
            exceptionRecord.setExcepSort("jielv");
            exceptionRecord.setReqMode("get");
            exceptionRecord.setLevel(2);
            exceptionRecord.setProcessState(0);
            exceptionRecord.setCreateTime(new Date());
            orderExcepLogDao.insertExceptionRecord(exceptionRecord);
        }
        return result;
    }

    @Override
    public String getHotelInfoList(int pageNo,String isConfirm) {
        String requestParam = getHotelListParam(pageNo,jielvInitHotelInfoConfig.getPageSize(),isConfirm);
        String url = jielvInitHotelInfoConfig.getHostPort() + jielvInitHotelInfoConfig.getUrl() ;
        System.out.println(url+ Contants.reqData+requestParam);
        String result = null;
        try {
            result = HttpClientGzip.doGet("",url+ Contants.reqData+requestParam);
        } catch (Exception e) {
            logger.error("请求捷旅酒店查询酒店列表超时或网络异常", e);
            ExceptionRecord exceptionRecord = new ExceptionRecord();
            exceptionRecord.setOrderNo(null);
            exceptionRecord.setExcepMsg("请求捷旅酒店查询酒店列表超时或网络异常!");
            exceptionRecord.setCallMethod(url);
            exceptionRecord.setParams(JSON.toJSONString(Contants.reqData+requestParam));
            exceptionRecord.setExcepSort("jielv");
            exceptionRecord.setReqMode("get");
            exceptionRecord.setLevel(2);
            exceptionRecord.setProcessState(0);
            exceptionRecord.setCreateTime(new Date());
            orderExcepLogDao.insertExceptionRecord(exceptionRecord);
        }
        return result;
    }

    @Override
    public String getHotelPriceIncrement() {
        String requestParam = getPriceIncrementParam();
        String url = jielvPriceIncrementConfig.getHostPort() + jielvPriceIncrementConfig.getUrl();
        String result = null;
        try {
            result = HttpClientGzip.doGet("",url+ Contants.reqData+requestParam);
        } catch (Exception e) {
            logger.error("请求捷旅酒店查询增量酒店价格超时或网络异常", e);
            ExceptionRecord exceptionRecord = new ExceptionRecord();
            exceptionRecord.setOrderNo(null);
            exceptionRecord.setExcepMsg("请求捷旅酒店查询增量酒店价格超时或网络异常!");
            exceptionRecord.setCallMethod(url);
            exceptionRecord.setParams(JSON.toJSONString(Contants.reqData+requestParam));
            exceptionRecord.setExcepSort("jielv");
            exceptionRecord.setReqMode("get");
            exceptionRecord.setLevel(1);
            exceptionRecord.setProcessState(0);
            exceptionRecord.setCreateTime(new Date());
            orderExcepLogDao.insertExceptionRecord(exceptionRecord);
        }
        return result;
    }

    public  String getPriceIncrementParam(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = format.format(new Date());
        //data
        Map<String,Object> data = new HashMap<String, Object>();
        String updateTime = null;
        try {
            updateTime = URLEncoder.encode(timeStr,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        data.put("updateTime",updateTime);
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("head", jielvParam.getJielvSystemParam());
        param.put("data",data);
        //convert
        String result = JSON.toJSONString(param);
        return result;
    }

    public  String getHotelListParam(int pageNo,int pageSize,String isConfirm){
        //data
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("countryId","70007");
        data.put("pageIndex",pageNo);
        data.put("pageSize",pageSize);
        if(StringUtils.isNotBlank(isConfirm)){
            data.put("isConfirm",Integer.valueOf(isConfirm));
        }
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("head",jielvParam.getJielvSystemParam());
        param.put("data",data);
        //convert
        String result = JSON.toJSONString(param);
        return result;
    }

    public  String getHotelDetailParam(int hotelId){
        //data
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("hotelId",hotelId);
        data.put("params","1,2,3,4");
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("head",jielvParam.getJielvSystemParam());
        param.put("data",data);
        //convert
        String result = JSON.toJSONString(param);
        return result;
    }

    public String getHotelRatePlanParam(int hotelId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        String checkInDate = sdf.format(ca.getTime());
        ca.add(Calendar.DATE, 30);// num为增加的天数，可以改变的
        Date currdate = ca.getTime();
        String checkOutDate = sdf.format(currdate);
        //data
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("hotelId",hotelId);
        data.put("checkInDate",checkInDate);
        data.put("checkOutDate",checkOutDate);
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("head",jielvParam.getJielvSystemParam());
        param.put("data",data);
        //convert
        String result = JSON.toJSONString(param);
        return result;
    }

}
