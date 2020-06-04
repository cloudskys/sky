package com.heyou.dao.airOrder;

import com.heyou.entity.airOrder.AirOrderInfo;
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
public interface AirOrderInfoDAO extends Mapper<AirOrderInfo> {

    public int updateOrderState(@Param("orderNo") String orderNo, @Param("orderState") int orderState);

}