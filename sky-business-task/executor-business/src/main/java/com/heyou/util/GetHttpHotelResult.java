package com.heyou.util;

import com.alibaba.fastjson.JSON;
import com.heyou.config.JielvSystemConfig;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/11 15:46
 * @Version: 1.0
 */
@Service
public class GetHttpHotelResult {

    @Autowired
    private JielvSystemConfig jielvSystemConfig;

    public Map<String,Object> getJielvSystemParam(){
        String appkey = jielvSystemConfig.getAppkey();
        String secretKey = jielvSystemConfig.getSecretKey();
        long timestamp = System.currentTimeMillis()+1000*60*5;
        String version = jielvSystemConfig.getVersion();
        //head
        Map<String,Object> head = new HashMap<String, Object>();
        head.put("appKey",appkey);
        head.put("timestamp",timestamp);
        head.put("sign", getSing(appkey,secretKey,String.valueOf(timestamp)));
        head.put("version",version );
        return head;
    }

    public  String getSing(String appKey,String secretKey,String timestamp){
        StringBuilder md5Builder = new StringBuilder();
        md5Builder.append(secretKey).append(appKey);
        String key = DigestUtils.md5Hex(md5Builder.toString()).toLowerCase();
        String sing = DigestUtils.md5Hex(key+timestamp).toLowerCase();
        return  sing;
    }

    public  String getHotelDetailParam(int hotelId){
        //data
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("hotelId",hotelId);
        data.put("params","1,2,3,4");
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("head",getJielvSystemParam());
        param.put("data",data);
        //convert
        String result = JSON.toJSONString(param);
        return result;
    }

    public  String getHotelListParam(int pageNo,int pageSize){
        //data
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("countryId","70007");
        data.put("pageIndex",pageNo);
        data.put("pageSize",pageSize);
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("head",getJielvSystemParam());
        param.put("data",data);
        //convert
        String result = JSON.toJSONString(param);
        return result;
    }



}


