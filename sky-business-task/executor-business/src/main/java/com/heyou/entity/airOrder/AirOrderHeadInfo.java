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
@Table(name = "air_order_head_info")
public class AirOrderHeadInfo implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
    /**
     * 订单号
     */
	private String orderNo;
    /**
     * 业务类型
     */
	private String orderBizCategory;
    /**
     * 支付申请号
     */
	private String payApplyNo;
    /**
     * 支付方式
     */
	private String payMode;
    /**
     * 订单实付现金金额
     */
	private BigDecimal price;
	/**
	 * 订单总销售价
	 */
	private BigDecimal orderSellPrice;
	/**
	 * 订单总成本价
	 */
	private BigDecimal orderPrice;
    /**
     * 机票总销售价
     */
	private BigDecimal airTicketSellPrice;
	/**
     * 机票总成本价
     */
	private BigDecimal airTicketPrice;
	/**
	 * 保险总销售价
	 */
	private BigDecimal insuranceSellPrice;
    /**
     * 保险总成本价
     */
	private BigDecimal insurancePrice;
    /**
     * 创建人下单人user_id
     */
	private Integer userId;
    /**
     * 修改人user_id
     */
	private Integer updateUser;
    /**
     * 订单状态
     */
	private Integer orderState;
    /**
     * 支付时间
     */
	private Date paymentTime;
    /**
     * 修改时间
     */
	private Date updateTime;
    /**
     * 创建时间
     */
	private Date createTime;
	/**
	 * 订单联系人
	 */
	private String name;
	/**
	 * 订单联系电话
	 */
	private String phone;
	/**
	 * 供应商
	 */
	private String supplier;

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

	public String getOrderBizCategory() {
		return orderBizCategory;
	}

	public void setOrderBizCategory(String orderBizCategory) {
		this.orderBizCategory = orderBizCategory;
	}

	public String getPayApplyNo() {
		return payApplyNo;
	}

	public void setPayApplyNo(String payApplyNo) {
		this.payApplyNo = payApplyNo;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getOrderSellPrice() {
		return orderSellPrice;
	}

	public void setOrderSellPrice(BigDecimal orderSellPrice) {
		this.orderSellPrice = orderSellPrice;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public BigDecimal getAirTicketSellPrice() {
		return airTicketSellPrice;
	}

	public void setAirTicketSellPrice(BigDecimal airTicketSellPrice) {
		this.airTicketSellPrice = airTicketSellPrice;
	}

	public BigDecimal getAirTicketPrice() {
		return airTicketPrice;
	}

	public void setAirTicketPrice(BigDecimal airTicketPrice) {
		this.airTicketPrice = airTicketPrice;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
}
