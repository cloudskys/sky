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
@Table(name = "air_order_info")
public class AirOrderInfo implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
    /**
     * 聚合大订单编号
     */
	private String orderNo;
	/**
	 * 机票总销售价
	 */
	private BigDecimal airTicketSellPrice;
	/**
	 * 机票总成本价
	 */
	private BigDecimal airTicketPrice;
    /**
     * 第三方订单编号
     */
	private String thirdOrderNo;
    /**
     * 航班号
     */
	private String flightNo;
    /**
     * 起飞机场三字码
     */
	private String depCode;
    /**
     * 到达机场
     */
	private String arrCode;
    /**
     * 起飞时间
     */
	private String depTime;
    /**
     * 到达时间
     */
	private String arrTime;
    /**
     * 成人舱位
     */
	private String cabin;
    /**
     * 儿童舱位
     */
	private String chdCabin;
	/**
	 * 服务级别，1.头等舱，2.。。。
	 */
	private Integer cabinClass;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 修改时间
     */
	private Date updateTime;
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
	 * 航程类型
	 */
	private String routeType;
	/**
	 * 出发航站楼
	 */
	private String depJetquay;
	/**
	 * 到达航站楼
	 */
	private String arrJetquay;

	public AirOrderInfo(){}

	public AirOrderInfo(Integer id, BigDecimal airTicketSellPrice) {
		this.id = id ;
		this.airTicketSellPrice = airTicketSellPrice;
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

	public String getThirdOrderNo() {
		return thirdOrderNo;
	}

	public void setThirdOrderNo(String thirdOrderNo) {
		this.thirdOrderNo = thirdOrderNo;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public String getArrCode() {
		return arrCode;
	}

	public void setArrCode(String arrCode) {
		this.arrCode = arrCode;
	}

	public String getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public String getCabin() {
		return cabin;
	}

	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

	public String getChdCabin() {
		return chdCabin;
	}

	public void setChdCabin(String chdCabin) {
		this.chdCabin = chdCabin;
	}

	public Integer getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(Integer cabinClass) {
		this.cabinClass = cabinClass;
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

	public String getRouteType() {
		return routeType;
	}

	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}

	public String getDepJetquay() {
		return depJetquay;
	}

	public void setDepJetquay(String depJetquay) {
		this.depJetquay = depJetquay;
	}

	public String getArrJetquay() {
		return arrJetquay;
	}

	public void setArrJetquay(String arrJetquay) {
		this.arrJetquay = arrJetquay;
	}
}
