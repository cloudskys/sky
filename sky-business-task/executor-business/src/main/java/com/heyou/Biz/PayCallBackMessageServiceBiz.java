package com.heyou.Biz;

import com.heyou.dao.airOrder.PayCallBackMessageDAO;
import com.heyou.entity.airOrder.PayCallBackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/17 19:54
 * @Version: 1.0
 */
@Component
public class PayCallBackMessageServiceBiz {

    @Autowired
    private PayCallBackMessageDAO payCallBackMessageDAO;

    public List<PayCallBackMessage> getWaitDisposeMessage() {
        return payCallBackMessageDAO.getWaitDisposeMessage();
    }

    public int updateState(PayCallBackMessage payCallBackMessage) {
        return payCallBackMessageDAO.updateByPrimaryKeySelective(payCallBackMessage);
    }
}
