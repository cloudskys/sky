package com.heyou.dao.housebase;

import com.heyou.entity.housebase.vo.JielvSourceData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/22 10:55
 * @Version: 1.0
 */
@Repository
public interface IJielvSourceDataDao  extends Mapper<JielvSourceData> {

    Integer jielvSourceDataDao(@Param("hotelId") int hotelId);
    List<JielvSourceData> getUndisposedSourceDateInfo();
    List<Integer> getAllJielvHotelId();

    int deleteObsoleteNightlyRate(@Param("delDate") String delDate);
}
