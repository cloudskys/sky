package com.heyou.service.mall.order;

/**
 * 商城订单定时任务
 */
public interface IMallOrderService {
    /**
     * 订单24小时之内没有支付完成自动撤销订单
     */
    void productOrderTask();

    /**
     * 代理订单24*3小时之内没有支付完成自动撤销订单
     */
    void agentOrderTask();

    /**
     * 秒杀订单30分钟之内没有支付完成自动取消订单
     */
    void secKillOrderTask();

    /**
     * 商品7天未确认收货自动确认收货
     */
    void waitConfirReceiptTask();

	/**
	 * 预分润调用任务（每天跑一次），捡漏数据。重新触发调用预分润接口
	 */
	void preProfitValue();

    /**
     * 商城订单-超时取消
     * @param timeoutCancelTime
     */
    void mallOrderTimeoutCancel(int timeoutCancelTime);
}
