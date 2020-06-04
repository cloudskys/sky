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
 * 秒杀订单30分钟之内没有支付完成自动取消订单
 */

@Slf4j
@Service
@JobHandler(value = "secKillOrderPayCancelHandler")
public class SecKillOrderPayCancelHandler extends IJobHandler {
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
        log.info("秒杀订单30分钟之内没有支付完成自动取消订单start");
//        mallOrderService.secKillOrderTask();
        log.info("秒杀订单30分钟之内没有支付完成自动取消订单end");
        return SUCCESS;
    }
}
