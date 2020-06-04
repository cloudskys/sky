package com.heyou.entity.mall.order.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 取消订单
 */
@Data
public class OrderCancelVO implements Serializable {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 线下支付数量
     */
    private int offlineOrderNum;

    /**
     * 创建时间
     */
    private Date createDate;
}
