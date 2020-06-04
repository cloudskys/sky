package com.heyou.jobhandler.airOrder;

import com.heyou.entity.airOrder.InsTypeReleatedLogInfo;
import com.heyou.service.airOrder.IInsTypeReleatedLogInfoService;
import com.heyou.util.Contants;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.collections.Lists;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * 〈更新保险信息〉
 *
 * @author shihao.cheng@ijiuyue.com
 * @create 2019/8/21 09:43
 * @since 1.0.0
 */
@JobHandler(value = "updateInsOrderHandler")
@Component
public class UpdateInsOrderHandler extends IJobHandler {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IInsTypeReleatedLogInfoService insTypeReleatedLogInfoService;

    @Resource(name = "rabbitInsTemplate")
    private RabbitTemplate rabbitTemplate;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        logger.info("======================更新保单接口开始执行");
        List<InsTypeReleatedLogInfo> infos = insTypeReleatedLogInfoService.getAllInsTypeReleatedlogInfos(0, 0);

        List<InsTypeReleatedLogInfo> logs;
        for (int i=infos.size()-1; i>=0; i--) {
            logs = new ArrayList<>();
            logs.add(infos.get(i));
            for(int j=i-1; j>=0; j--) {
                if (infos.get(j).getInsuranceId().equals(infos.get(i).getInsuranceId())) {
                    logs.add(infos.get(j));
                    infos.remove(j);
                    i--;
                } else {
                    break;
                }
            }
            rabbitTemplate.convertAndSend(Contants.insOrderexchange, Contants.insOrderKey, logs);
        }

        return SUCCESS;
    }
}
