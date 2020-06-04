package com.heyou.entity.housebase.vo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/7 13:19
 * @Version: 1.0
 */
public class JielvCityVO implements Serializable {

    private Integer  countryId;//国家编号
    private String	 countryCn;//国家中文名
    private String	 countryEn;//国家英文名
    private Integer  stateId;//省份编号
    private String	 stateCn;//省份中文名
    private String	 stateEn;//省份英文名
    private Integer  cityId;//城市编号
    private String	 cityCn;//城市中文名
    private String	 cityEn;//城市英文名

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryCn() {
        return countryCn;
    }

    public void setCountryCn(String countryCn) {
        this.countryCn = countryCn;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateCn() {
        return stateCn;
    }

    public void setStateCn(String stateCn) {
        this.stateCn = stateCn;
    }

    public String getStateEn() {
        return stateEn;
    }

    public void setStateEn(String stateEn) {
        this.stateEn = stateEn;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityCn() {
        return cityCn;
    }

    public void setCityCn(String cityCn) {
        this.cityCn = cityCn;
    }

    public String getCityEn() {
        return cityEn;
    }

    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }
}
