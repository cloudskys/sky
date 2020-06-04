package com.heyou.jobhandler.coupon.order;

import com.heyou.service.coupon.order.OrderTimeoutCancelService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 券订单
 * @Description: 订单超时取消
 * @Author: ZXE
 * @Time: 2020/2/18 12:44
 * @Version: 1.0
 */
@JobHandler(value = "orderTimeoutCancelHandler")
@Component
public class OrderTimeoutCancelHandler extends IJobHandler {

    @Autowired
    private OrderTimeoutCancelService orderTimeoutCancelService;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        orderTimeoutCancelService.autoCancelOrder();
        return ReturnT.SUCCESS;
    }
}
