package com.heyou.jobhandler.mall.order;

import com.heyou.service.mall.order.IOrderTaskService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@JobHandler("autoRefundExceedUnDeliverHandler")
public class AutoRefundExceedUnDeliverHandler extends IJobHandler {

    @Autowired
    private IOrderTaskService orderTaskService;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        log.info("------------------autoRefundExceedUnDeliverHandler start--------------------");
//        orderTaskService.autoRefundExceedUnDeliver();
        log.info("------------------autoRefundExceedUnDeliverHandler end--------------------");
        return ReturnT.SUCCESS;
    }
}
