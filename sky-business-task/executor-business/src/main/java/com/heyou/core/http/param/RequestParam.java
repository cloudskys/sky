package com.heyou.core.http.param;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class RequestParam implements Serializable {

    //请求url
    private String url;
    //域名
    private String domain;
    //前缀
    private String basePath;
    //请求path
    private String path;
    //请求contentType
    private String contentType;
    //请求httpMethod,get,post
    private String httpMethod;
    //会话超时时间，默认60s
    private int socketTimeout = 60;
    //请求超时时间，默认10s
    private int connTimeout = 10;
    //连接池获取连接/创建连接超时时间，默认3s
    private int connReqTimeout = 3;
    //结果化参数
    private String bodyJson;
    private Map<String,Object> head = new HashMap<>();
    private Map<String,Object> query = new HashMap<>();
    private Map<String,Object> body = new HashMap<>();

    public String getUrl() {
        if (this.url != null && !this.url.isEmpty()){
            return this.url;
        }
        StringBuilder builder = new StringBuilder();
        if (this.domain != null){
            builder.append(this.domain);
        }
        if (this.basePath != null){
            builder.append(this.basePath);
        }
        if (this.path != null){
            builder.append(this.path);
        }
        return builder.toString();
    }
}
