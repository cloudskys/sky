package com.heyou.jobhandler.housebase;

import com.heyou.config.JielvSystemConfig;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/6 15:28
 * @Version: 1.0
 */
@Service
public class JielvParam {

    @Autowired
    private  JielvSystemConfig jielvSystemConfig;

    public  Map<String,Object> getJielvSystemParam(){
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

}
