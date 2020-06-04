package com.heyou.entity.houseorder.po;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InstallOrderInfo implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 订单id
     */
    private String orderNo;

    /**
     * 安装服务id
     */
    private Integer serviceId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 商品编号
     */
    private Integer productId;

    /**
     * 安装内容
     */
    private String product;

    /**
     * 安装数量
     */
    private Integer installNum;

    /**
     * 安装费用
     */
    private BigDecimal installFee;

    /**
     * 附加费用
     */
    private BigDecimal additionalFee;

    /**
     * 总费用
     */
    private BigDecimal totalFee;

    /**
     * 空跑率
     */
    private String emptyRunRate;

    /**
     * 订单状态
     */
    private Integer orderState;

    /**
     * 下单时间
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

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getInstallNum() {
        return installNum;
    }

    public void setInstallNum(Integer installNum) {
        this.installNum = installNum;
    }

    public BigDecimal getInstallFee() {
        return installFee;
    }

    public void setInstallFee(BigDecimal installFee) {
        this.installFee = installFee;
    }

    public BigDecimal getAdditionalFee() {
        return additionalFee;
    }

    public void setAdditionalFee(BigDecimal additionalFee) {
        this.additionalFee = additionalFee;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getEmptyRunRate() {
        return emptyRunRate;
    }

    public void setEmptyRunRate(String emptyRunRate) {
        this.emptyRunRate = emptyRunRate;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}