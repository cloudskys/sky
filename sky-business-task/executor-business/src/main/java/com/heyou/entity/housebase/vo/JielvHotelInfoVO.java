package com.heyou.entity.housebase.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/6 14:46
 * @Version: 1.0
 */
public class JielvHotelInfoVO implements Serializable {

    private Integer id ;
    private Integer hotelId;//酒店编号
    private String	themeType;//酒店主题				vacation	见常量列表
    private String	hotelNameCn;//酒店中文名称			无
    private String	hotelNameEn;//酒店英文名称			无
    private String	star;//酒店星级				无	见常量列表
    private String	addressCn;//中文地址				无
    private String	addressEn;//英文地址				无
    private Integer	countryId;//国家编号				70007
    private Integer	stateId;//省份编号				70017
    private Integer	cityId;//城市编号				70002
    private String	phone;//酒店总机					0755123456789
    private String	longitude;//经度						119.8636
    private String	latitude;//纬度						31.4368
    private String	fax	;//传真						00623-61761868
    private String	email;//邮箱
    private String	postCode;//邮编号
    private String	checkPolicy;//酒店入离政策				入住时间:14点以后，离店时间:12点以前
    private String	childrenPolicy;//儿童政策					不接受18岁以下客人单独入住。
    private String	petPolicy;//宠物政策					不可携带宠物。
    private String	establishmentDate;//开业时间
    private String	renovationDate;//装修时间
    private String	hotelGroup;//集团
    private String	hotelBrand;//品牌
    private String	facilities;//酒店设施					11|12|13|14|15|17|18|19|20|22|23|24|21|73
    private String	cardType;//信用卡						Master,VISA,JCB,UnionPay,
    private Double	minPrice;//酒店最低价					0
    private String	introduceCn;//酒店中文介绍
    private String	introduceEn;//酒店英文介绍
    private Integer	instantConfirmation;//是否即时确认			无	0:全部、1:即时确认、2:待查
    private Integer	sellType;//是否热销酒店			无
    private String	updateTime;//修改时间				无	yyyy-MM-dd hh:mm:ss
    private JielvHotelRatePlan jielvHotelRatePlan;//产品对象

    private List<JielvImageVO> jielvImageList;
    private List<JielvRateTypeVO> jielvRateTypeList;
    private List<JielvRoomTypeVO> jielvRoomTypeList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JielvHotelRatePlan getJielvHotelRatePlan() {
        return jielvHotelRatePlan;
    }

    public void setJielvHotelRatePlan(JielvHotelRatePlan jielvHotelRatePlan) {
        this.jielvHotelRatePlan = jielvHotelRatePlan;
    }

    public List<JielvImageVO> getJielvImageList() {
        return jielvImageList;
    }

    public void setJielvImageList(List<JielvImageVO> jielvImageList) {
        this.jielvImageList = jielvImageList;
    }

    public List<JielvRateTypeVO> getJielvRateTypeList() {
        return jielvRateTypeList;
    }

    public void setJielvRateTypeList(List<JielvRateTypeVO> jielvRateTypeList) {
        this.jielvRateTypeList = jielvRateTypeList;
    }

    public List<JielvRoomTypeVO> getJielvRoomTypeList() {
        return jielvRoomTypeList;
    }

    public void setJielvRoomTypeList(List<JielvRoomTypeVO> jielvRoomTypeList) {
        this.jielvRoomTypeList = jielvRoomTypeList;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getHotelNameCn() {
        return hotelNameCn;
    }

    public void setHotelNameCn(String hotelNameCn) {
        this.hotelNameCn = hotelNameCn;
    }

    public String getHotelNameEn() {
        return hotelNameEn;
    }

    public void setHotelNameEn(String hotelNameEn) {
        this.hotelNameEn = hotelNameEn;
    }

    public String getAddressCn() {
        return addressCn;
    }

    public void setAddressCn(String addressCn) {
        this.addressCn = addressCn;
    }

    public String getAddressEn() {
        return addressEn;
    }

    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getInstantConfirmation() {
        return instantConfirmation;
    }

    public void setInstantConfirmation(Integer instantConfirmation) {
        this.instantConfirmation = instantConfirmation;
    }

    public Integer getSellType() {
        return sellType;
    }

    public void setSellType(Integer sellType) {
        this.sellType = sellType;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getThemeType() {
        return themeType;
    }

    public void setThemeType(String themeType) {
        this.themeType = themeType;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCheckPolicy() {
        return checkPolicy;
    }

    public void setCheckPolicy(String checkPolicy) {
        this.checkPolicy = checkPolicy;
    }

    public String getChildrenPolicy() {
        return childrenPolicy;
    }

    public void setChildrenPolicy(String childrenPolicy) {
        this.childrenPolicy = childrenPolicy;
    }

    public String getPetPolicy() {
        return petPolicy;
    }

    public void setPetPolicy(String petPolicy) {
        this.petPolicy = petPolicy;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getRenovationDate() {
        return renovationDate;
    }

    public void setRenovationDate(String renovationDate) {
        this.renovationDate = renovationDate;
    }

    public String getHotelGroup() {
        return hotelGroup;
    }

    public void setHotelGroup(String hotelGroup) {
        this.hotelGroup = hotelGroup;
    }

    public String getHotelBrand() {
        return hotelBrand;
    }

    public void setHotelBrand(String hotelBrand) {
        this.hotelBrand = hotelBrand;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public String getIntroduceCn() {
        return introduceCn;
    }

    public void setIntroduceCn(String introduceCn) {
        this.introduceCn = introduceCn;
    }

    public String getIntroduceEn() {
        return introduceEn;
    }

    public void setIntroduceEn(String introduceEn) {
        this.introduceEn = introduceEn;
    }
}
