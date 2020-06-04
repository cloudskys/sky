package com.heyou.dao.airOrder;

import com.heyou.entity.airOrder.InsTypeReleatedLogInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface InsTypeReleatedLogInfoDAO extends Mapper<InsTypeReleatedLogInfo> {
    List<InsTypeReleatedLogInfo> getAllInsTypeReleatedlogInfos(@Param("state") Integer state, @Param("num") Integer num);
}
