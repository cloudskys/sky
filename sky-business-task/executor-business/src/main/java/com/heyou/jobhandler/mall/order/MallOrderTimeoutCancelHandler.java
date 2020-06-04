package com.heyou.jobhandler.mall.order;

import com.heyou.service.mall.order.IMallOrderService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Description:
 * @Author: zxe
 * @Time: 2020/3/31 17:15
 * @Version: 1.0
 */
@JobHandler(value = "mallOrderTimeoutCancelHandler")
@Component
public class MallOrderTimeoutCancelHandler extends IJobHandler {

    @Autowired
    private IMallOrderService mallOrderService;


    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        int timeoutCancelTime = 30;
        if (null != params && 0 < params.length) {
            if (StringUtils.hasText(params[1])) {
                timeoutCancelTime = Integer.parseInt(params[1]);
            }
        }
        mallOrderService.mallOrderTimeoutCancel(timeoutCancelTime);
        return ReturnT.SUCCESS;
    }
}
