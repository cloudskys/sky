package com.heyou.jobhandler.user;

import com.heyou.service.flowmaster.InitFlowMasterService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qiang.chao
 * @date 2020/5/14
 **/
@JobHandler(value = "initFlowMasterHandler")
@Component
public class InitFlowMasterHandler extends IJobHandler {

    @Autowired
    private InitFlowMasterService initFlowMasterService;

    /**
     * job handler
     *
     * @param params
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        initFlowMasterService.initFlowMaster();
        return ReturnT.SUCCESS;
    }
}
