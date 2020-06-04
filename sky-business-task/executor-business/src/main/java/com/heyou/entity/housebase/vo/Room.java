package com.heyou.entity.housebase.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/9 13:37
 * @Version: 1.0
 */
public class Room implements Serializable {

    private String roomTypeId ;

    private List<RatePlans> ratePlans;


    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public List<RatePlans> getRatePlans() {
        return ratePlans;
    }

    public void setRatePlans(List<RatePlans> ratePlans) {
        this.ratePlans = ratePlans;
    }
}
