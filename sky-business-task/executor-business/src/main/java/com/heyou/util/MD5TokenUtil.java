package com.heyou.util;

import com.alibaba.fastjson.JSONObject;
import com.heyou.util.base64.Base64;

import java.util.HashMap;
import java.util.Map;

public class MD5TokenUtil {

    private static final String HF_TOKEN_KEY = "HF_TOKEN_V1";

    public static Map<String,Object> tokenHeader(String path){
        Map<String,Object> header = new HashMap<>();
        header.put("timestamp",System.currentTimeMillis());
        header.put("tokenKey",HF_TOKEN_KEY);
        header.put("path",new String(Base64.encodeBase64(path.getBytes())));
        String sign = DigestUtils.md5Hex(JSONObject.toJSONString(header));
        header.put("sign",sign);
        header.remove("tokenKey");
        return header;
    }
}
