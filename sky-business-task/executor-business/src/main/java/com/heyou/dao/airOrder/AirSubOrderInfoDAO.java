package com.heyou.dao.airOrder;

import com.heyou.entity.airOrder.AirSubOrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author lhj
 * @since 2019-07-16
 */
@Repository
public interface AirSubOrderInfoDAO extends Mapper<AirSubOrderInfo> {

    public int updateOrderState(@Param("orderNo") String orderNo, @Param("orderState") int orderState);

}