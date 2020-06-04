package com.heyou.entity.housebase.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/9 13:34
 * @Version: 1.0
 */
public class JielvHotelRatePlan implements Serializable {

    private Integer hotelId ;

    private List<Room> rooms;

    private List<BookingRule> bookingRules;

    private List<RefundRule> refundRules;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }


    public List<BookingRule> getBookingRules() {
        return bookingRules;
    }

    public void setBookingRules(List<BookingRule> bookingRules) {
        this.bookingRules = bookingRules;
    }

    public List<RefundRule> getRefundRules() {
        return refundRules;
    }

    public void setRefundRules(List<RefundRule> refundRules) {
        this.refundRules = refundRules;
    }
}
