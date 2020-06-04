package com.heyou.entity.houseorder.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
 * @describe 产品订单 
 * @author xs
 * @version v1.0
 * @date 2019-1-16 19:21:35
 */
public class OrderInfoPO implements Serializable {

	private static final long serialVersionUID = 1L;

    // 订单号 
    private String orderNo;
    // 捷旅订单编号
    private String jieLvOrderCode;
    // 下单开始时间
    private Timestamp createBegin;


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

    public Timestamp getCreateBegin() {
        return createBegin;
    }

    public void setCreateBegin(Timestamp createBegin) {
        this.createBegin = createBegin;
    }

}