package com.heyou.dao.airOrder;

import com.heyou.entity.airOrder.InsSubOrderInfo;
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
public interface InsSubOrderInfoDAO extends Mapper<InsSubOrderInfo> {

    int updateOrderStateByReleatedId(@Param("releatedId") Integer orderNo, @Param("orderState") int orderState);

}