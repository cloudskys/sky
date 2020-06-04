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
@Table(name = "air_type_releated_info")
public class AirTypeReleatedInfo implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
    /**
     * 机票主单id
     */
	private Integer airTicketId;
    /**
     * 第三方订单编号
     */
	private String thirdSubOrderNo;
    /**
     * 第三方订单结算金额（成本）
     */
	private BigDecimal subPrice;
    /**
     * 乘机人类型  1.成人  2.儿童
     */
	private Integer crewType;

	public AirTypeReleatedInfo(){}

	public AirTypeReleatedInfo(Integer id, Integer crewType) {
		this.id = id;
		this.crewType = crewType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAirTicketId() {
		return airTicketId;
	}

	public void setAirTicketId(Integer airTicketId) {
		this.airTicketId = airTicketId;
	}

	public String getThirdSubOrderNo() {
		return thirdSubOrderNo;
	}

	public void setThirdSubOrderNo(String thirdSubOrderNo) {
		this.thirdSubOrderNo = thirdSubOrderNo;
	}

	public BigDecimal getSubPrice() {
		return subPrice;
	}

	public void setSubPrice(BigDecimal subPrice) {
		this.subPrice = subPrice;
	}

	public Integer getCrewType() {
		return crewType;
	}

	public void setCrewType(Integer crewType) {
		this.crewType = crewType;
	}
}
