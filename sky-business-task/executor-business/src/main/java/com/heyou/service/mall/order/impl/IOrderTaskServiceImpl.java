package com.heyou.service.mall.order.impl;

import com.heyou.constant.ApiRequestConstant;
import com.heyou.core.http.HttpClientUtil;
import com.heyou.core.http.param.RequestParam;
import com.heyou.service.mall.order.IOrderTaskService;
import com.heyou.util.MD5TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class IOrderTaskServiceImpl implements IOrderTaskService {

    @Value("${mall.api.domain}")
    private String mallApiDomain;
    @Autowired
    private HttpClientUtil httpClientUtil;

    @Override
    public void sendOrderRemindMsg() {
        RequestParam requestParam = new RequestParam();
        requestParam.setHttpMethod(HttpMethod.POST.name());
        requestParam.setDomain(mallApiDomain);
        requestParam.setBasePath(ApiRequestConstant.ORDER_TASK_BASE_PATH);
        requestParam.setPath(ApiRequestConstant.DELIVER_REMIND_MSG_SEND_PATH);
        requestParam.setHead(MD5TokenUtil.tokenHeader(requestParam.getPath()));
        requestParam.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpClientUtil.doHttpRequest(requestParam);
    }

    @Override
    public void autoRefundExceedUnDeliver() {
        RequestParam requestParam = new RequestParam();
        requestParam.setHttpMethod(HttpMethod.POST.name());
        requestParam.setDomain(mallApiDomain);
        requestParam.setBasePath(ApiRequestConstant.ORDER_TASK_BASE_PATH);
        requestParam.setPath(ApiRequestConstant.EXCEED_UN_DELIVER_AUTO_REFUND_PATH);
        requestParam.setHead(MD5TokenUtil.tokenHeader(requestParam.getPath()));
        requestParam.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpClientUtil.doHttpRequest(requestParam);
    }

    @Override
    public void applySendRemindMsg() {
        RequestParam requestParam = new RequestParam();
        requestParam.setHttpMethod(HttpMethod.POST.name());
        requestParam.setDomain(mallApiDomain);
        requestParam.setBasePath(ApiRequestConstant.ORDER_TASK_BASE_PATH);
        requestParam.setPath(ApiRequestConstant.APPLY_SEND_REMIND_MSG_PATH);
        requestParam.setHead(MD5TokenUtil.tokenHeader(requestParam.getPath()));
        requestParam.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpClientUtil.doHttpRequest(requestParam);
    }

    @Override
    public void applyUnRespAutoArbitrate() {
        RequestParam requestParam = new RequestParam();
        requestParam.setHttpMethod(HttpMethod.POST.name());
        requestParam.setDomain(mallApiDomain);
        requestParam.setBasePath(ApiRequestConstant.ORDER_TASK_BASE_PATH);
        requestParam.setPath(ApiRequestConstant.APPLY_UN_RESP_AUTO_ARBITRATE);
        requestParam.setHead(MD5TokenUtil.tokenHeader(requestParam.getPath()));
        requestParam.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpClientUtil.doHttpRequest(requestParam);
    }
}
