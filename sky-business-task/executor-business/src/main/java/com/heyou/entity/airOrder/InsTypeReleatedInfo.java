package com.heyou.entity.airOrder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhj
 * @since 2019-07-16
 */
@Table(name = "ins_type_releated_info")
public class InsTypeReleatedInfo implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
    /**
     * 保险主单id
     */
	private Integer insuranceId;
    /**
     * 保险类型订单号
     */
	private String insuranceTypeOrderNo;
    /**
     * 第三方订单号
     */
	private String thirdOrderNo;
    /**
     * 订单成本价
     */
	private BigDecimal orderPrice;
	/**
     * 订单销售价
     */
	private BigDecimal orderSellPrice;
    /**
     * 保险类型
     */
	private Integer insuranceType;

	/**
	 * 投保人姓名
	 */
	private String insPerson;

	/**
	 * 投保人电话
	 */
	private String phone;
	/**
	 * 投保人出生日期
	 */
	private String birthday;
	/**
	 * 投保人证件类型
	 */
	private Integer certType;
	/**
	 * 投保人证件号
	 */
	private String certCode;
	/**
	 * 订单变更通知url
	 */
	private String orderUrl;
	/**
	 * 支付类型
	 */
	private Integer payType;
	/**
	 * 支付时间
	 */
	private String payTime;
	/**
	 * 第三方支付交易号
	 */
	private String payTradeNo;

	public InsTypeReleatedInfo(){

	}

	public InsTypeReleatedInfo(Integer id, BigDecimal orderPrice) {
		this.id = id;
		this.orderPrice = orderPrice;
	}

    public InsTypeReleatedInfo(Integer id, Integer payType, String payTime, String payTradeNo) {
	    this.id = id ;
        this.payType = payType;
        this.payTime = payTime;
        this.payTradeNo = payTradeNo;
    }

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

	public String getInsuranceTypeOrderNo() {
		return insuranceTypeOrderNo;
	}

	public void setInsuranceTypeOrderNo(String insuranceTypeOrderNo) {
		this.insuranceTypeOrderNo = insuranceTypeOrderNo;
	}

	public String getThirdOrderNo() {
		return thirdOrderNo;
	}

	public void setThirdOrderNo(String thirdOrderNo) {
		this.thirdOrderNo = thirdOrderNo;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public BigDecimal getOrderSellPrice() {
		return orderSellPrice;
	}

	public void setOrderSellPrice(BigDecimal orderSellPrice) {
		this.orderSellPrice = orderSellPrice;
	}

	public Integer getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(Integer insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getInsPerson() {
		return insPerson;
	}

	public void setInsPerson(String insPerson) {
		this.insPerson = insPerson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getCertType() {
		return certType;
	}

	public void setCertType(Integer certType) {
		this.certType = certType;
	}

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

	public String getOrderUrl() {
		return orderUrl;
	}

	public void setOrderUrl(String orderUrl) {
		this.orderUrl = orderUrl;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getPayTradeNo() {
		return payTradeNo;
	}

	public void setPayTradeNo(String payTradeNo) {
		this.payTradeNo = payTradeNo;
	}
}
