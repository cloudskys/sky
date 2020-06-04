package com.heyou.core.http;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.heyou.core.http.param.RequestParam;
import com.heyou.core.http.resp.ReturnResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.eclipse.jetty.http.HttpHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by ly
 */
@Slf4j
@Component
public class HttpClientUtil {

    private final static String CHARSET_UTF8 = "UTF-8";

    @Autowired
    private CloseableHttpClient httpClientPool;

    private ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();


    /**
     * http请求方法
     */
    public ReturnResponse doHttpRequest(RequestParam requestParam){
        //默认请求类型
        ReturnResponse returnResponse;
        CloseableHttpResponse response = null;
        try{
            HttpRequestBase httpRequestBase;
            if (HttpMethod.POST.name().equalsIgnoreCase(requestParam.getHttpMethod())){
                httpRequestBase = doHttpPost(requestParam);
            }else {
                httpRequestBase = doHttpGet(requestParam);
            }
            //添加请求头跟请求参数配置
            addHeaderAndConfig(httpRequestBase,requestParam);
            response = httpClientPool.execute(httpRequestBase);
            //请求错误，响应结果为null
            if(response == null){
                throw new IllegalStateException("http返回为null！");
            }
            int statusCode = response.getStatusLine().getStatusCode();
            //状态码不是200
            if (statusCode != HttpStatus.SC_OK) {
                throw new IllegalStateException("http返回状态码不为200！HttpStatus=" + statusCode + ",errorMessage=" + response.getStatusLine().getReasonPhrase());
            }
            HttpEntity entity = response.getEntity();
            //响应的报文为空
            if(entity == null){
                throw new IllegalStateException("http返回为null！");
            }
            String result = EntityUtils.toString(entity,CHARSET_UTF8);
            log.info("path={}，请求返回数据 = {}",requestParam.getPath(),result);
            returnResponse = objectMapper.readValue(result,ReturnResponse.class);;
            EntityUtils.consume(entity);
            if (returnResponse == null || !returnResponse.checkSuccess()){
                throw new IllegalStateException(" 调用服务返回报文状态错误,result = " + result);
            }
        }catch(Exception e){
            throw new IllegalStateException("http请求异常.",e);
        }finally {
            closeResponse(response);
        }
        return returnResponse;
    }


    /**
     * 设置请求头跟请求参数配置
     * @param httpRequestBase
     */
    private void addHeaderAndConfig(HttpRequestBase httpRequestBase, RequestParam requestParam){
        httpRequestBase.addHeader(HttpHeader.CONTENT_TYPE.asString(),requestParam.getContentType());
        Map<String,Object> head = requestParam.getHead();
        if (MapUtils.isNotEmpty(head)){
            for (Map.Entry<String,Object> entry : head.entrySet()){
                String k = entry.getKey();
                Object v = entry.getValue();
                if (v != null){
                    httpRequestBase.addHeader(k,v.toString());
                }
            }
//            head.forEach((k, v) -> {
//                if (v != null) {
//                    httpRequestBase.addHeader(k, v.toString());
//                }
//            });
        }
        RequestConfig.Builder builder = RequestConfig.custom()
                .setSocketTimeout(requestParam.getSocketTimeout() * 1000)
                .setConnectTimeout(requestParam.getConnTimeout() * 1000)
                .setConnectionRequestTimeout(requestParam.getConnReqTimeout() * 1000)
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .setTargetPreferredAuthSchemes(Collections.singletonList(AuthSchemes.BASIC));
        httpRequestBase.setConfig(builder.build());
    }

    /**
    * get请求
    */
    private HttpGet doHttpGet(RequestParam requestParam){
        Map<String,Object> query = requestParam.getQuery();
    	if(MapUtils.isNotEmpty(query)){
			return new HttpGet(buildUrlWithEncode(requestParam.getUrl(),query));
    	}else{
    		return new HttpGet(requestParam.getUrl());
    	}
    }

    /**
     * httpPost方式请求
     * @return
     */
    private HttpPost doHttpPost(RequestParam requestParam) throws IOException{
        HttpPost httpPost = new HttpPost();
        Map<String,Object> query = requestParam.getQuery();
        String url = requestParam.getUrl();
        if (MapUtils.isNotEmpty(query)){
            httpPost.setURI(URI.create(buildUrlWithEncode(url,query)));
        }else {
            httpPost.setURI(URI.create(url));
        }
        if (StringUtils.isNotEmpty(requestParam.getBodyJson())){
            StringEntity entity = new StringEntity(requestParam.getBodyJson(),CHARSET_UTF8);
            entity.setContentType(requestParam.getContentType());
            httpPost.setEntity(entity);
        }else {
            Map<String,Object> body = requestParam.getBody();
            if (MapUtils.isNotEmpty(body)){
                List<NameValuePair> valuePairs = getNameValuePairArr(body);
                httpPost.setEntity(new UrlEncodedFormEntity(valuePairs, CHARSET_UTF8));
            }
        }
        return httpPost;
    }

    /**
     * post请求构建key=value参数
     * @param parasMap
     * @return
     */
    private List<NameValuePair> getNameValuePairArr(Map<String, Object> parasMap) {
        List<NameValuePair> valuePairs = new ArrayList<>();
        for (Entry<String, Object> parasEntry : parasMap.entrySet()) {
            String parasName = parasEntry.getKey();
            Object parasValue = parasEntry.getValue();
            if (parasValue == null){
                valuePairs.add(new BasicNameValuePair(parasName, null));
            }else {
                valuePairs.add(new BasicNameValuePair(parasName, parasValue.toString()));
            }
        }
        return valuePairs;
    }


    private String buildUrlWithEncode(String url, Map<String, Object> param){
        if (MapUtils.isEmpty(param)){
            return url;
        }
        StringBuilder newUrl = new StringBuilder(url + "?");
        List<NameValuePair> nameValuePairArr = getNameValuePairArr(param);
        String urlFormat = URLEncodedUtils.format(nameValuePairArr, CHARSET_UTF8);
        newUrl.append(urlFormat);
        return newUrl.toString();
    }


    /**
     * 关闭请求流
     * @param response
     */
    private void closeResponse(CloseableHttpResponse response){
        if (response != null){
            try{
                response.close();
            }catch (IOException e){
                log.error("关闭http请求流异常",e);
            }
        }
    }
}
