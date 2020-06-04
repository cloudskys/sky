package com.heyou.entity.housebase.vo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/9 13:48
 * @Version: 1.0
 */
public class RefundRule implements Serializable {

    private String refundRuleId;

    private Integer refundRuleType;

    private Integer refundRuleHours;

    private Integer deductType;

    public String getRefundRuleId() {
        return refundRuleId;
    }

    public void setRefundRuleId(String refundRuleId) {
        this.refundRuleId = refundRuleId;
    }

    public Integer getRefundRuleType() {
        return refundRuleType;
    }

    public void setRefundRuleType(Integer refundRuleType) {
        this.refundRuleType = refundRuleType;
    }

    public Integer getRefundRuleHours() {
        return refundRuleHours;
    }

    public void setRefundRuleHours(Integer refundRuleHours) {
        this.refundRuleHours = refundRuleHours;
    }

    public Integer getDeductType() {
        return deductType;
    }

    public void setDeductType(Integer deductType) {
        this.deductType = deductType;
    }

    @Override
    public String toString() {
        return "RefundRule{" +
                "refundRuleId='" + refundRuleId + '\'' +
                ", refundRuleType=" + refundRuleType +
                ", refundRuleHours=" + refundRuleHours +
                ", deductType=" + deductType +
                '}';
    }
}
