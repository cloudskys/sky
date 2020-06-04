package com.heyou.entity.airOrder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhj
 * @since 2019-07-16
 */
@Table(name = "ins_order_info")
public class InsOrderInfo implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
    /**
     * 聚合大订单编号
     */
	private String orderNo;
    /**
     * 保险总销售价
     */
	private BigDecimal insuranceSellPrice;
	/**
	 * 保险总成本价
	 */
	private BigDecimal insurancePrice;
    /**
     * 订单状态
     */
	private Integer orderState;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 创建人
     */
	private Integer createUser;
    /**
     * 修改人
     */
	private Integer updateUser;
    /**
     * 修改时间
     */
	private Date updateTime;

	public InsOrderInfo(Integer id, BigDecimal insuranceSellPrice, BigDecimal insurancePrice) {
		this.id = id;
		this.insuranceSellPrice = insuranceSellPrice;
		this.insurancePrice = insurancePrice;
	}

	public InsOrderInfo() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getInsuranceSellPrice() {
		return insuranceSellPrice;
	}

	public void setInsuranceSellPrice(BigDecimal insuranceSellPrice) {
		this.insuranceSellPrice = insuranceSellPrice;
	}

	public BigDecimal getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(BigDecimal insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
