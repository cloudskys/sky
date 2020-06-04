package com.heyou.dao.airOrder;

import com.heyou.entity.airOrder.InsTypeReleatedInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author lhj
 * @since 2019-07-16
 */
@Repository
public interface InsTypeReleatedInfoDAO extends Mapper<InsTypeReleatedInfo> {

    List<Integer> getThirdOrderNo(String orderNo);

}