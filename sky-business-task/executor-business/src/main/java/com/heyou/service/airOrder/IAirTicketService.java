package com.heyou.service.airOrder;

import com.heyou.entity.airOrder.AirOrderInfoVo;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 18:48
 * @Version: 1.0
 */
public interface IAirTicketService {

    int updateOrderState(String orderNo);

    List<AirOrderInfoVo> getWaitCancelOrderNo();

}
