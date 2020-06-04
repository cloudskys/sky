package com.heyou.entity.houseorder.po;

import java.io.Serializable;
import java.util.Date;

public class ExceptionRecord implements Serializable {

    private Integer id;

    private String orderNo;  //订单号

    private String excepMsg;  //异常信息

    private Date createTime;//创建时间

    private String callMethod;  //方法名

    private String params;  //参数

    private int level; //日志级别

    private int processState;//处理状态

    private String excepSort;//异常分类

    private String reqMode;   //请求方式



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

    public String getExcepMsg() {
        return excepMsg;
    }

    public void setExcepMsg(String excepMsg) {
        this.excepMsg = excepMsg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCallMethod() {
        return callMethod;
    }

    public void setCallMethod(String callMethod) {
        this.callMethod = callMethod;
    }
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getProcessState() {
        return processState;
    }

    public void setProcessState(int processState) {
        this.processState = processState;
    }

    public String getExcepSort() {
        return excepSort;
    }

    public void setExcepSort(String excepSort) {
        this.excepSort = excepSort;
    }

    public String getReqMode() {
        return reqMode;
    }

    public void setReqMode(String reqMode) {
        this.reqMode = reqMode;
    }
}
