package com.heyou.entity.housebase.vo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/9 13:44
 * @Version: 1.0
 */
public class BookingRule implements Serializable {

    private	String	bookingRuleId;//预订条款编号
    private	String	startDate;//开始日期
    private	String	endDate;//结束日期
    private	Integer	minAmount;//预订最少数量
    private	Integer	maxAmount;//预订最多数量
    private	Integer	minDays;//最少入住天数
    private	Integer	maxDays;//最多入住天数
    private	Integer	minAdvHours;//最少提前预订时间
    private	Integer	maxAdvHours;//最大提前预订时间
    private	String	weekSet;//有效星期
    private	String	startTime;//每日开始销售时间
    private	String	endTime;//每日结束销售时间
    private	String	bookingNotices;//预订说明

    public String getBookingRuleId() {
        return bookingRuleId;
    }

    public void setBookingRuleId(String bookingRuleId) {
        this.bookingRuleId = bookingRuleId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getMinDays() {
        return minDays;
    }

    public void setMinDays(Integer minDays) {
        this.minDays = minDays;
    }

    public Integer getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(Integer maxDays) {
        this.maxDays = maxDays;
    }

    public Integer getMinAdvHours() {
        return minAdvHours;
    }

    public void setMinAdvHours(Integer minAdvHours) {
        this.minAdvHours = minAdvHours;
    }

    public Integer getMaxAdvHours() {
        return maxAdvHours;
    }

    public void setMaxAdvHours(Integer maxAdvHours) {
        this.maxAdvHours = maxAdvHours;
    }

    public String getWeekSet() {
        return weekSet;
    }

    public void setWeekSet(String weekSet) {
        this.weekSet = weekSet;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBookingNotices() {
        return bookingNotices;
    }

    public void setBookingNotices(String bookingNotices) {
        this.bookingNotices = bookingNotices;
    }
}
