/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AgentInfoHandler
 * Author:   Administrator
 * Date:     2020/1/3 15:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.heyou.jobhandler.agent;

import com.heyou.service.agent.IAgentInfoService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.xxl.job.core.biz.model.ReturnT.FAIL;
import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * @Description: 代理生日短信
 * @Author: Administrator
 * @Time: 2020/1/3 15:17
 * @Version: 1.0
 */
@JobHandler(value = "agentInfoHandler")
@Component
public class AgentInfoHandler extends IJobHandler {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IAgentInfoService agentInfoService;


    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        logger.info("给代理发送生日短信job开始...");
        try {
            agentInfoService.sendSmsToAgent();
        } catch (Exception e) {
            logger.error("给代理发送生日短信job异常", e);
            return FAIL;
        }
        return SUCCESS;
    }
}
