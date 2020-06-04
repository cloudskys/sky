package com.heyou.entity.housebase.vo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/6 15:07
 * @Version: 1.0
 */
public class JielvRateTypeVO implements Serializable {

    private Integer	rateTypeId;//价格类型编号
    private String	rateTypeCn;//价格类型中文名
    private String	rateTypeEn;//价格类型英文名

    public Integer getRateTypeId() {
        return rateTypeId;
    }

    public void setRateTypeId(Integer rateTypeId) {
        this.rateTypeId = rateTypeId;
    }

    public String getRateTypeCn() {
        return rateTypeCn;
    }

    public void setRateTypeCn(String rateTypeCn) {
        this.rateTypeCn = rateTypeCn;
    }

    public String getRateTypeEn() {
        return rateTypeEn;
    }

    public void setRateTypeEn(String rateTypeEn) {
        this.rateTypeEn = rateTypeEn;
    }
}
