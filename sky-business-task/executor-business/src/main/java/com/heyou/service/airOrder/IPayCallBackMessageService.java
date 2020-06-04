package com.heyou.service.airOrder;

import com.heyou.entity.airOrder.PayCallBackMessage;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 19:45
 * @Version: 1.0
 */
public interface IPayCallBackMessageService {

    List<PayCallBackMessage> getWaitDisposeMessage();

    int updateState(PayCallBackMessage payCallBackMessage);

}
