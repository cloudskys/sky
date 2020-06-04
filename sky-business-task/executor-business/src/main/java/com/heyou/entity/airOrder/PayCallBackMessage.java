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
@Table(name = "p_pay_callback_message")
public class PayCallBackMessage implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
    /**
     * 订单号
     */
	private String orderNo;
    /**
     * 支付类型
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
     * 支付时间
     */
	private Date payTime;
    /**
     * 订单支付金额
     */
	private BigDecimal price;
    /**
     * 消息状态
     */
	private Integer state;
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

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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
