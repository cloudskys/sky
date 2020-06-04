package com.heyou.entity.airOrder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhj
 * @since 2019-07-16
 */
@Table(name = "air_log_info")
public class AirLogInfo implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
    /**
     * 第三方请求返回码
     */
	private String rsCode;
	/**
     * 我方请求唯一标识
     */
	private String identificationNo;
    /**
     * 已知的错误信息
     */
	private String rsMessage;
    /**
     * 业务数据
     */
	private String rsData;
    /**
     * 错误异常日志
     */
	private String errorMessage;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 日志描述
     */
	private String description;
    /**
     * 请求描述
     */
	private String requestDescription;
	/**
	 * 日志等级，为1 时会报警
	 */
	private Integer level;

	/**
	 * 异常日志状态
	 */
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRsCode() {
		return rsCode;
	}

	public void setRsCode(String rsCode) {
		this.rsCode = rsCode;
	}

	public String getIdentificationNo() {
		return identificationNo;
	}

	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}

	public String getRsMessage() {
		return rsMessage;
	}

	public void setRsMessage(String rsMessage) {
		this.rsMessage = rsMessage;
	}

	public String getRsData() {
		return rsData;
	}

	public void setRsData(String rsData) {
		this.rsData = rsData;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequestDescription() {
		return requestDescription;
	}

	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
