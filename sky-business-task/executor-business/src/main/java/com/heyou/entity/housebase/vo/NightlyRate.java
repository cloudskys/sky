package com.heyou.entity.housebase.vo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/9 13:42
 * @Version: 1.0
 */
public class NightlyRate implements Serializable {

    private String	date;//日期
    private Double	cose;//价格
    private Integer	status;//房态
    private Integer	currentAlloment;//库存
    private Integer	breakfast;//早餐
    private String	bookingRuleId;//预订条款编号
    private String	refundRuleId;//取消条款编号

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getCose() {
        return cose;
    }

    public void setCose(Double cose) {
        this.cose = cose;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCurrentAlloment() {
        return currentAlloment;
    }

    public void setCurrentAlloment(Integer currentAlloment) {
        this.currentAlloment = currentAlloment;
    }

    public Integer getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Integer breakfast) {
        this.breakfast = breakfast;
    }

    public String getBookingRuleId() {
        return bookingRuleId;
    }

    public void setBookingRuleId(String bookingRuleId) {
        this.bookingRuleId = bookingRuleId;
    }

    public String getRefundRuleId() {
        return refundRuleId;
    }

    public void setRefundRuleId(String refundRuleId) {
        this.refundRuleId = refundRuleId;
    }
}
