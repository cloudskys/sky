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
 * 代理订单24*3小时之内没有支付完成自动撤销订单
 */

@Slf4j
@Service
@JobHandler(value = "agentOrderPayCancelHandler")
public class AgentOrderPayCancelHandler extends IJobHandler {
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
        log.info("代理订单24*3小时之内没有支付完成自动撤销订单start");
        mallOrderService.agentOrderTask();
        log.info("代理订单24*3小时之内没有支付完成自动撤销订单end");
        return SUCCESS;
    }
}
