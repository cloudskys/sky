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
 * 预分润调用任务（每天跑一次），捡漏数据。重新触发调用预分润接口
 */

@Slf4j
@Service
@JobHandler(value = "preProfitHandler")
public class PreProfitHandler extends IJobHandler {
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
        log.info("捡漏数据。重新触发调用预分润接口开始");
        try {
            mallOrderService.preProfitValue();
        } catch (Exception e) {
            log.error("捡漏数据。重新触发调用预分润接口异常",e);
        }
        log.info("捡漏数据。重新触发调用预分润接口结束");
        return SUCCESS;
    }
}
