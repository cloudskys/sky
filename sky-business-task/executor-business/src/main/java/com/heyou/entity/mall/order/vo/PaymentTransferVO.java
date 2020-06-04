package com.heyou.entity.mall.order.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * p_payment_transfer
 * @author 
 */
@Data
public class PaymentTransferVO implements Serializable {
    /**
     * 主健id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 转账时间
     */
    private Date transferTime;

    /**
     * 支付申请号
     */
    private String payApplyNo;

    /**
     * 转账总额
     */
    private BigDecimal transferTotalNum;

    /**
     * 审核状态：0-待审核，1-待复核，2-审核拒绝，3-复核拒绝，4-复核通过
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 审核人
     */
    private String auditUser;

    private Integer auditUserId;

    /**
     * 复核人
     */
    private String reauditUser;

    private Integer reauditUserId;

    private Integer uploadNumber;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    //收款人/户名
    private String payee;
    //账号
    private String bankAccount;
    //银行名
    private String bankName;
    //支行
    private String bankBranch;

    //分组id自增user_group_Id
    private Integer userGroupId;

    private static final long serialVersionUID = 1L;


}