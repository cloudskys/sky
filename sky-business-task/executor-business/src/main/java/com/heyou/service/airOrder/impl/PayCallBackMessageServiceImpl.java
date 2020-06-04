package com.heyou.service.airOrder.impl;

import com.heyou.Biz.PayCallBackMessageServiceBiz;
import com.heyou.entity.airOrder.PayCallBackMessage;
import com.heyou.service.airOrder.IPayCallBackMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/17 19:54
 * @Version: 1.0
 */
@Service
public class PayCallBackMessageServiceImpl implements IPayCallBackMessageService {

    @Autowired
    private PayCallBackMessageServiceBiz payCallBackMessageServiceBiz;

    @Override
    public List<PayCallBackMessage> getWaitDisposeMessage() {
        return payCallBackMessageServiceBiz.getWaitDisposeMessage();
    }

    @Override
    public int updateState(PayCallBackMessage payCallBackMessage) {
        return payCallBackMessageServiceBiz.updateState(payCallBackMessage);
    }
}
