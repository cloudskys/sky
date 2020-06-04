package com.heyou.entity.housebase.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/9 13:38
 * @Version: 1.0
 */
public class RatePlans implements Serializable {
    private String			keyId;//产品编号
    private String			keyName;//产品名称
    private String			bedName;//床型名称
    private Integer			maxOccupancy;//最大入住人数
    private String			currency;//币种
    private String			rateTypeId;//价格类型编号
    private Integer			paymentType;//付款类型
    private Integer			breakfast;//早餐
    private List<NightlyRate> nightlyRates;//间夜价格数组
    private String			bookingRuleId;//预订条款编号
    private String			refundRuleId;//取消条款编号
    private String			market;//适用市场
    private String          roomTypeId;//房型id

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getBedName() {
        return bedName;
    }

    public void setBedName(String bedName) {
        this.bedName = bedName;
    }

    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(Integer maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRateTypeId() {
        return rateTypeId;
    }

    public void setRateTypeId(String rateTypeId) {
        this.rateTypeId = rateTypeId;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Integer breakfast) {
        this.breakfast = breakfast;
    }

    public List<NightlyRate> getNightlyRates() {
        return nightlyRates;
    }

    public void setNightlyRates(List<NightlyRate> nightlyRates) {
        this.nightlyRates = nightlyRates;
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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
