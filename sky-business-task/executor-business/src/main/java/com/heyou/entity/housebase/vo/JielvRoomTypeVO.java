package com.heyou.entity.housebase.vo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/6 15:04
 * @Version: 1.0
 */
public class JielvRoomTypeVO implements Serializable {

    private	Integer	roomTypeId;		//房型编号
    private	String	roomTypeCn;		//客房中文名称
    private	String	roomTypeEn;		//客房英文名称
    private	String	bedType	;		//床型
    private	Integer	maximize;		//最大入住人数
    private	String	acreage	;		//房间面积
    private	String	bedWidth;		//床大小
    private	String	floorDistribute;//楼层
    private	String	facilities;	    //房型设施
    private	String	extraBedtState;	//是否允许加床
    private	Integer	bedCount;       //加床数量

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeCn() {
        return roomTypeCn;
    }

    public void setRoomTypeCn(String roomTypeCn) {
        this.roomTypeCn = roomTypeCn;
    }

    public String getRoomTypeEn() {
        return roomTypeEn;
    }

    public void setRoomTypeEn(String roomTypeEn) {
        this.roomTypeEn = roomTypeEn;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public Integer getMaximize() {
        return maximize;
    }

    public void setMaximize(Integer maximize) {
        this.maximize = maximize;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getBedWidth() {
        return bedWidth;
    }

    public void setBedWidth(String bedWidth) {
        this.bedWidth = bedWidth;
    }

    public String getFloorDistribute() {
        return floorDistribute;
    }

    public void setFloorDistribute(String floorDistribute) {
        this.floorDistribute = floorDistribute;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getExtraBedtState() {
        return extraBedtState;
    }

    public void setExtraBedtState(String extraBedtState) {
        this.extraBedtState = extraBedtState;
    }

    public Integer getBedCount() {
        return bedCount;
    }

    public void setBedCount(Integer bedCount) {
        this.bedCount = bedCount;
    }
}
