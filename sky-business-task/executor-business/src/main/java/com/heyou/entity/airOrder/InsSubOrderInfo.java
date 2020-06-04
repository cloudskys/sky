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
@Table(name = "ins_sub_order_info")
public class InsSubOrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
    /**
     * 保险关联表主表主键id
     */
	private Integer insTypeReleatedId;
	/**
     * 第三方订单号
     */
	private String thirdOrderNo;
    /**
     * 保险信息快照表
     */
	private Integer insProductId;
    /**
     * 保险产品id
     */
    private String productId;
    /**
     * 保险产品id
     */
    private String productName;
    /**
     * 保险产品id
     */
    private String productType;
    /**
     * 保险产品id
     */
    private String productTypeName;
	/**
	 * 保险销售价
	 */
	private BigDecimal sellPrice;
	/**
	 * 保险成本价
	 */
	private BigDecimal costPrice;
    /**
     * 被保人姓名
     */
	private String name;
    /**
     * 证件类型
     */
	private Integer certType;
    /**
     * 证件号
     */
	private String certCode;
    /**
     * 被保人手机号
     */
	private String mobile;
    /**
     * 保险起保时间
     */
	private String beginDate;
    /**
     * 保险结束时间
     */
	private String endDate;
    /**
     * 性别1.男，2.女
     */
	private Integer sex;
    /**
     * 出生日期
     */
	private String birthday;
	/**
	 * 保险类型名称
	 */
	private String className;
    /**
     * 保险类型 航意险（含航联险）=1 人身意外险=2（暂无） 旅游险=3 家财险=4 航延险=6交通意外险=7
     */
	private Integer insuranceType;
    /**
     * 航班号
     */
	private String flightNo;
    /**
     * 旅行出发地
     */
	private String startAddress;
    /**
     * 旅行目的地
     */
	private String endAddress;
    /**
     * PNR如果是航意险、航延险填写 pnr
     */
	private String pnr;
    /**
     * 票号
     */
	private String ticketNo;
    /**
     * 保险编号
     */
	private String insuranceNo;
    /**
     * 投保状态 =0 未投保 =1 已投保 2= 投保失 败
     */
	private Integer orderState;
    /**
     * 投保失败原因
     */
	private String insureFailedMsg;
    /**
     * 退保状态
     */
	private Integer refundInsureStatus;
    /**
     * 退保失败原因
     */
	private String refundInsureFailedMsg;
	/**
	 * 特别说明（暂用理赔说明解释字段）
	 */
	private String specialNote;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInsTypeReleatedId() {
		return insTypeReleatedId;
	}

	public void setInsTypeReleatedId(Integer insTypeReleatedId) {
		this.insTypeReleatedId = insTypeReleatedId;
	}

	public String getThirdOrderNo() {
		return thirdOrderNo;
	}

	public void setThirdOrderNo(String thirdOrderNo) {
		this.thirdOrderNo = thirdOrderNo;
	}

	public Integer getInsProductId() {
		return insProductId;
	}

	public void setInsProductId(Integer insProductId) {
		this.insProductId = insProductId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(Integer insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getStartAddress() {
		return startAddress;
	}

	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	public String getEndAddress() {
		return endAddress;
	}

	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public String getInsureFailedMsg() {
		return insureFailedMsg;
	}

	public void setInsureFailedMsg(String insureFailedMsg) {
		this.insureFailedMsg = insureFailedMsg;
	}

	public Integer getRefundInsureStatus() {
		return refundInsureStatus;
	}

	public void setRefundInsureStatus(Integer refundInsureStatus) {
		this.refundInsureStatus = refundInsureStatus;
	}

	public String getRefundInsureFailedMsg() {
		return refundInsureFailedMsg;
	}

	public void setRefundInsureFailedMsg(String refundInsureFailedMsg) {
		this.refundInsureFailedMsg = refundInsureFailedMsg;
	}

	public String getSpecialNote() {
		return specialNote;
	}

	public void setSpecialNote(String specialNote) {
		this.specialNote = specialNote;
	}
}
