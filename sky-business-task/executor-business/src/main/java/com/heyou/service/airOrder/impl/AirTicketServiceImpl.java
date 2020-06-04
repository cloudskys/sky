package com.heyou.service.airOrder.impl;

import com.heyou.Biz.*;
import com.heyou.entity.airOrder.AirOrderInfoVo;
import com.heyou.enumeration.AirTicketOrderEnum;
import com.heyou.service.airOrder.IAirTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 18:50
 * @Version: 1.0
 */
@Service
public class AirTicketServiceImpl implements IAirTicketService {

    @Autowired
    private AirOrderHeadInfoServiceBiz airOrderHeadInfoServiceBiz;
    @Autowired
    private AirOrderInfoServiceBiz airOrderInfoServiceBiz;
    @Autowired
    private AirSubOrderInfoServiceBiz airSubOrderInfoServiceBiz;
    @Autowired
    private AirTypeReleatedInfoServiceBiz airTypeReleatedInfoServiceBiz;
    @Autowired
    private InsOrderInfoServiceBiz insOrderInfoServiceBiz;
    @Autowired
    private InsTypeReleatedInfoServiceBiz insTypeReleatedInfoServiceBiz;
    @Autowired
    private InsSubOrderInfoServiceBiz insSubOrderInfoServiceBiz;

    @Override
    public int updateOrderState(String orderNo) {
        int num = 0;
        //修改大聚合订单表订单状态
        airOrderHeadInfoServiceBiz.updateOrderState(orderNo, AirTicketOrderEnum.AirOrderStateEnum.CANCEL.getValue());
        //修改机票主订单
        airOrderInfoServiceBiz.updateOrderState(orderNo,AirTicketOrderEnum.AirOrderStateEnum.CANCEL.getValue());
        //查询出第三方子订单集合
        List<String> thirdOrderNoList = airTypeReleatedInfoServiceBiz.getThirdOrderNo(orderNo);
        for (String thirdOrderNo :thirdOrderNoList) {
            num = airSubOrderInfoServiceBiz.updateOrderState(thirdOrderNo,AirTicketOrderEnum.AirOrderStateEnum.CANCEL.getValue());
        }
        //修改保险主单编号
        insOrderInfoServiceBiz.updateOrderState(orderNo,AirTicketOrderEnum.InsuranceOrderStateEnum.CANCEL.getValue());
        //查询保险关联表主键id
        List<Integer> isOrderNoList = insTypeReleatedInfoServiceBiz.getThirdOrderNo(orderNo);
        for (Integer releatedId :isOrderNoList) {
            //修改保险子单状态
            num = insSubOrderInfoServiceBiz.updateOrderStateByReleatedId(releatedId,AirTicketOrderEnum.InsuranceOrderStateEnum.CANCEL.getValue());
        }
        return num;
    }

    @Override
    public List<AirOrderInfoVo> getWaitCancelOrderNo() {
        return airOrderHeadInfoServiceBiz.getWaitCancelOrderNo();
    }
}
