package com.heyou.dao.airOrder;

import com.heyou.entity.airOrder.AirOrderHeadInfo;
import com.heyou.entity.airOrder.AirOrderInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 18:10
 * @Version: 1.0
 */
@Repository
public interface AirOrderHeadInfoDAO extends Mapper<AirOrderHeadInfo> {

    int updateOrderState(@Param("orderNo")String orderNo,@Param("orderState")int orderState);

    List<AirOrderInfoVo> getWaitCancelOrderNo();
}
