package com.heyou.service.mall.order.impl;

import com.heyou.constant.ApiRequestConstant;
import com.heyou.core.http.HttpClientUtil;
import com.heyou.core.http.param.RequestParam;
import com.heyou.service.mall.order.IMallOrderService;
import com.heyou.util.MD5TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商城订单定时任务
 */
@Slf4j
@Service
public class MallOrderServiceImpl implements IMallOrderService {
    @Value("${mall.api.domain}")
    private String mallApiDomain;
    @Autowired
    private HttpClientUtil httpClientUtil;

    /**
     * 订单24小时之内没有支付完成自动撤销订单
     */
    @Override
    public void productOrderTask() {
        try {
            RequestParam requestParam = new RequestParam();
            requestParam.setHttpMethod(HttpMethod.GET.name());
            requestParam.setDomain(mallApiDomain);
            requestParam.setBasePath(ApiRequestConstant.ORDER_TASK_BASE_PATH);
            requestParam.setPath(ApiRequestConstant.PRODUCT_ORDER_TASK_PATH);
            requestParam.setHead(MD5TokenUtil.tokenHeader(requestParam.getPath()));
            httpClientUtil.doHttpRequest(requestParam);
        } catch (Exception e) {
           log.error("订单24小时之内没有支付完成自动撤销订单失败",e);
        }
    }

    /**
     * 代理订单24*3小时之内没有支付完成自动撤销订单
     */
    @Override
    public void agentOrderTask() {
        try {
            RequestParam requestParam = new RequestParam();
            requestParam.setHttpMethod(HttpMethod.GET.name());
            requestParam.setDomain(mallApiDomain);
            requestParam.setBasePath(ApiRequestConstant.ORDER_TASK_BASE_PATH);
            requestParam.setPath(ApiRequestConstant.AGENT_ORDER_TASK_PATH);
            requestParam.setHead(MD5TokenUtil.tokenHeader(requestParam.getPath()));
            httpClientUtil.doHttpRequest(requestParam);
        } catch (Exception e) {
            log.error("代理订单24*3小时之内没有支付完成自动撤销订单失败",e);
        }
    }

    /**
     * 秒杀订单30分钟之内没有支付完成自动取消订单
     */
    @Override
    public void secKillOrderTask() {
        try {
            RequestParam requestParam = new RequestParam();
            requestParam.setHttpMethod(HttpMethod.GET.name());
            requestParam.setDomain(mallApiDomain);
            requestParam.setBasePath(ApiRequestConstant.ORDER_TASK_BASE_PATH);
            requestParam.setPath(ApiRequestConstant.SECKILL_ORDER_TASK_PATH);
            requestParam.setHead(MD5TokenUtil.tokenHeader(requestParam.getPath()));
            httpClientUtil.doHttpRequest(requestParam);
        } catch (Exception e) {
            log.error("秒杀订单30分钟之内没有支付完成自动取消订单失败",e);
        }
    }

    /**
     * 商品7天未确认收货自动确认收货
     */
    @Override
    public void waitConfirReceiptTask() {
        try {
            RequestParam requestParam = new RequestParam();
            requestParam.setHttpMethod(HttpMethod.POST.name());
            requestParam.setDomain(mallApiDomain);
            requestParam.setBasePath(ApiRequestConstant.ORDER_TASK_BASE_PATH);
            requestParam.setPath(ApiRequestConstant.WAIT_CONFIR_RECEIPT_TASK_PATH);
            requestParam.setHead(MD5TokenUtil.tokenHeader(requestParam.getPath()));
            httpClientUtil.doHttpRequest(requestParam);
        } catch (Exception e) {
            log.error("商品7天未确认收货自动确认收货失败",e);
        }
    }

	/**
	 * 预分润调用任务（每天跑一次），捡漏数据。重新触发调用预分润接口
	 */
    @Override
    public void preProfitValue() {
        RequestParam requestParam = new RequestParam();
        requestParam.setHttpMethod(HttpMethod.GET.name());
        requestParam.setDomain(mallApiDomain);
        requestParam.setBasePath(ApiRequestConstant.ORDER_TASK_BASE_PATH);
        requestParam.setPath(ApiRequestConstant.PRE_PROFIT_PATH);
        requestParam.setHead(MD5TokenUtil.tokenHeader(requestParam.getPath()));
        httpClientUtil.doHttpRequest(requestParam);
    }

    @Override
    public void mallOrderTimeoutCancel(int timeoutCancelTime) {
        RequestParam requestParam = new RequestParam();
        requestParam.setHttpMethod(HttpMethod.GET.name());
        requestParam.setDomain(mallApiDomain);
        requestParam.setBasePath(ApiRequestConstant.ORDER_TASK_BASE_PATH);
        requestParam.setPath(ApiRequestConstant.MALL_ORDER_TIMEOUT_CANCEL);
        requestParam.setHead(MD5TokenUtil.tokenHeader(requestParam.getPath()));
        Map<String, Object> map = requestParam.getQuery();
        map.put("timeoutCancelTime", timeoutCancelTime);
        requestParam.setQuery(map);
        httpClientUtil.doHttpRequest(requestParam);
    }

}