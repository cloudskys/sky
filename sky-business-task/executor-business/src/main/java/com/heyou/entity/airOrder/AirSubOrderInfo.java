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
@Table(name = "air_sub_order_info")
public class AirSubOrderInfo implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
    /**
     * 机票类型关联表id
     */
	private Integer airTicketReleatedId;
    /**
     * 第三方子单编号
     */
	private String thirdSubOrderNo;
    /**
     * 乘机人姓名
     */
	private String name;
    /**
     * 性别  1，男 2 女
     */
	private Integer sex;
    /**
     * 生日
     */
	private String birthday;
    /**
     * 证件类型
     */
	private Integer identityType;
    /**
     * 证件号
     */
	private String identityNo;
    /**
     * 乘机人类型 1 成人 2 儿童 3 婴儿
     */
	private Integer crewType;
    /**
     * 手机号
     */
	private String phoneNum;
	/**
	 * 票面价格
	 */
	private BigDecimal price;
	/**
	 * 销售价
	 */
	private BigDecimal sellPrice;
	/**
	 * 成本价
	 */
	private BigDecimal costPrice;
    /**
     * 机建
     */
	private Integer airportTax;
    /**
     * 燃油费
     */
	private Integer fuelTax;
    /**
     * 返点 0.1 =0.1%
     */
	private BigDecimal commisionPoint;
    /**
     * 定额
     */
	private BigDecimal commisionMoney;
    /**
     * 手续费
     */
	private BigDecimal payFee;
    /**
     * 订单状态
     */
	private Integer orderState;
    /**
     * 创建人
     */
	private Integer createUser;
    /**
     * 修改人
     */
	private Integer updateUser;
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

	public Integer getAirTicketReleatedId() {
		return airTicketReleatedId;
	}

	public void setAirTicketReleatedId(Integer airTicketReleatedId) {
		this.airTicketReleatedId = airTicketReleatedId;
	}

	public String getThirdSubOrderNo() {
		return thirdSubOrderNo;
	}

	public void setThirdSubOrderNo(String thirdSubOrderNo) {
		this.thirdSubOrderNo = thirdSubOrderNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getIdentityType() {
		return identityType;
	}

	public void setIdentityType(Integer identityType) {
		this.identityType = identityType;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public Integer getCrewType() {
		return crewType;
	}

	public void setCrewType(Integer crewType) {
		this.crewType = crewType;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	public Integer getAirportTax() {
		return airportTax;
	}

	public void setAirportTax(Integer airportTax) {
		this.airportTax = airportTax;
	}

	public Integer getFuelTax() {
		return fuelTax;
	}

	public void setFuelTax(Integer fuelTax) {
		this.fuelTax = fuelTax;
	}

	public BigDecimal getCommisionPoint() {
		return commisionPoint;
	}

	public void setCommisionPoint(BigDecimal commisionPoint) {
		this.commisionPoint = commisionPoint;
	}

	public BigDecimal getCommisionMoney() {
		return commisionMoney;
	}

	public void setCommisionMoney(BigDecimal commisionMoney) {
		this.commisionMoney = commisionMoney;
	}

	public BigDecimal getPayFee() {
		return payFee;
	}

	public void setPayFee(BigDecimal payFee) {
		this.payFee = payFee;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
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
