package com.heyou.entity.airOrder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈〉
 *
 * @author shihao.cheng@ijiuyue.com
 * @create 2019/8/20 18:41
 * @since 1.0.0
 */
@Table(name = "ins_type_releated_log_info")
public class InsTypeReleatedLogInfo implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 保险主单id
     */
    private Integer insuranceId;

    /**
     * 保险关联表主键id
     */
    private Integer insTypeReleatedId;

    /**
     * 保险成本价
     */
    private BigDecimal settlementPrice;

    /**
     * 状态(0未处理，1处理成功，2处理失败)
     */
    private Integer state;

    /**
     * 重试次数
     */
    private Integer num;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public Integer getInsTypeReleatedId() {
        return insTypeReleatedId;
    }

    public void setInsTypeReleatedId(Integer insTypeReleatedId) {
        this.insTypeReleatedId = insTypeReleatedId;
    }

    public BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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
}
