package com.heyou.entity.housebase.vo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/6 15:10
 * @Version: 1.0
 */
public class JielvImageVO implements Serializable {

    private Integer	imageId;	//图片编号
    private String	type;		//图片类型			见常量列表
    private String	roomTypeIds;//图片关联房型		一张图片可能对应多个房型，多个逗号分隔。
    private String	thumbUrl;	//缩略图地址
    private String	imageUrl;	//图片地址
    private Integer	imageLogo;	//是否带水印			0有水印logo 1无水印logo
    private Integer	imageSize;	//图片规格		图片规格0:未分类、1:350*350、2:550*412、3:640*960

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoomTypeIds() {
        return roomTypeIds;
    }

    public void setRoomTypeIds(String roomTypeIds) {
        this.roomTypeIds = roomTypeIds;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getImageLogo() {
        return imageLogo;
    }

    public void setImageLogo(Integer imageLogo) {
        this.imageLogo = imageLogo;
    }

    public Integer getImageSize() {
        return imageSize;
    }

    public void setImageSize(Integer imageSize) {
        this.imageSize = imageSize;
    }
}
