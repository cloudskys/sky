package com.heyou.service.mall.order;

public interface IOrderTaskService {

    /**
     * 发货提醒
     */
    void sendOrderRemindMsg();

    /**
     * 退款
     */
    void autoRefundExceedUnDeliver();

    /**
     * 申请退货提醒
     */
    void applySendRemindMsg();

    /**
     * 仲裁
     */
    void applyUnRespAutoArbitrate();

}
