package com.heyou.entity.housebase.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/22 10:39
 * @Version: 1.0
 */
public class JielvSourceData implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private Integer hotelId;
    private String hotelInfo;
    private String rateType;
    private String roomType;
    private String imageList;
    private String roomRatePlan;
    private String bookingRules;
    private String refundRules;
    private Date createTime;
    private Date updateTime;
    private Integer type;
    private int state;
    private BigDecimal minPrice;

    public Integer getId() {
        return id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelInfo(String hotelInfo) {
        this.hotelInfo = hotelInfo;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getImageList() {
        return imageList;
    }

    public void setImageList(String imageList) {
        this.imageList = imageList;
    }

    public String getRoomRatePlan() {
        return roomRatePlan;
    }

    public void setRoomRatePlan(String roomRatePlan) {
        this.roomRatePlan = roomRatePlan;
    }

    public String getBookingRules() {
        return bookingRules;
    }

    public void setBookingRules(String bookingRules) {
        this.bookingRules = bookingRules;
    }

    public String getRefundRules() {
        return refundRules;
    }

    public void setRefundRules(String refundRules) {
        this.refundRules = refundRules;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }
}
