package com.heyou.entity.housebase.vo;

import java.io.Serializable;


/**
 * @describe 产品订单 
 * @author xs
 * @version v1.0
 * @date 2019-1-16 19:21:35
 */
public class OrderInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

    // 订单号 
    private String orderNo;
    // 捷旅订单编号
    private String jieLvOrderCode;
    // 下单开始时间
    private String createBegin;
    // 下单结束时间
    private String createEnd;
    // 订单状态
    private Integer orderStatus;

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getJieLvOrderCode() {
        return jieLvOrderCode;
    }

    public void setJieLvOrderCode(String jieLvOrderCode) {
        this.jieLvOrderCode = jieLvOrderCode;
    }

    public String getCreateBegin() {
        return createBegin;
    }

    public void setCreateBegin(String createBegin) {
        this.createBegin = createBegin;
    }

    public String getCreateEnd() {
        return createEnd;
    }

    public void setCreateEnd(String createEnd) {
        this.createEnd = createEnd;
    }
}