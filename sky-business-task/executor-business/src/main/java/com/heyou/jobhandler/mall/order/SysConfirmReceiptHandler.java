package com.heyou.jobhandler.mall.order;

import com.heyou.service.mall.order.IMallOrderService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * 商品7天未确认收货自动确认收货
 */

@Slf4j
@Service
@JobHandler(value = "sysConfirmReceiptHandler")
public class SysConfirmReceiptHandler extends IJobHandler {
    @Autowired
    private IMallOrderService mallOrderService;

    /**
     * job handler
     *
     * @param params
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        log.info("商品7天未确认收货自动确认收货start");
        mallOrderService.waitConfirReceiptTask();
        log.info("商品7天未确认收货自动确认收货end");
        return SUCCESS;
    }
}
