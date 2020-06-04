package com.heyou.jobhandler.airOrder;

import com.heyou.entity.airOrder.AirLogInfo;
import com.heyou.entity.airOrder.PayCallBackMessage;
import com.heyou.service.airOrder.IAirLogInfoService;
import com.heyou.service.airOrder.IPayCallBackMessageService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 19:43
 * @Version: 1.0
 */
@JobHandler(value = "payMessageCheckHandler")
@Component
public class PayMessageCheckHandler  extends IJobHandler {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IAirLogInfoService airLogInfoService;
    @Autowired
    private IPayCallBackMessageService payCallBackMessageService;


    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        logger.info("===============监控支付回调开始");

        List<PayCallBackMessage> waitDisposeMessage = payCallBackMessageService.getWaitDisposeMessage();

        for (PayCallBackMessage message : waitDisposeMessage) {
            AirLogInfo airLogInfo = new AirLogInfo();
            airLogInfo.setIdentificationNo(message.getOrderNo());
            airLogInfo.setErrorMessage("该订单已经处理超时、未成功给第三方付款！请及时处理！");
            airLogInfo.setLevel(1);
            airLogInfo.setState(1);
            airLogInfoService.add(airLogInfo);
            PayCallBackMessage payCallBackMessage = new PayCallBackMessage();
            payCallBackMessage.setId(message.getId());
            //设置消息状态为 已人工处理
            payCallBackMessage.setState(6);
            payCallBackMessageService.updateState(payCallBackMessage);
        }

        return SUCCESS;
    }
}
