package com.heyou.entity.mall.order.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qiang.chao
 * @description 订单退款提醒
 * @date 2019/9/17
 **/
@Data
public class OrderRefundSmsRemindVO implements Serializable {

    private static final long serialVersionUID = 8099885976610017346L;

    private Integer orderId;

    /**
     * @Description: 商家标识
     *
     * @author qiang.chao
     * @date 2019/9/17
    **/
    private Integer shopId;

    /**
     * @Description: 商家名称
     *
     * @author qiang.chao
     * @date 2019/9/17
    **/
    private String shopName;

    /**
     * @Description: 商家电话
     *
     * @author qiang.chao
     * @date 2019/9/17
    **/
    private String  sellerMobile;

    /**
     * @Description: 买家电话
     *
     * @author qiang.chao
     * @date 2019/9/17
    **/
    private String buyerMobile;

    /**
     * @Description: 订单编号
     *
     * @author qiang.chao
     * @date 2019/9/17
    **/
    private String orderNo;

    /**
     * @Description: 退款编号
     *
     * @author qiang.chao
     * @date 2019/9/17
    **/
    @JsonSerialize(using = ToStringSerializer.class)
    private Long refundNo;

    /**
     * @Description: 子订单标识
     *
     * @author qiang.chao
     * @date 2019/9/18
    **/
    private Integer orderProductId;
}
