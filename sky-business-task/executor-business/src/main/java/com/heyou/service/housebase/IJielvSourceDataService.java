package com.heyou.service.housebase;

import com.heyou.entity.housebase.vo.JielvSourceData;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/22 10:53
 * @Version: 1.0
 */
public interface IJielvSourceDataService {

    int insertSourceDate(JielvSourceData data);

    int updateSourceDate(JielvSourceData data);

    Integer getIdByHotelId(int hotelId);

    //酒店id，本地库数据源id，变价增量对应的类型：变价、变条款、等
    void getHotelDetailInfo(int hotelId,Integer sourceId,int type);

    void initHotelStaticInfo(int hotelId,Integer sourceId,int type);

    Map<String,Object> getHotelPrice(int hotelId);

    List<JielvSourceData> getUndisposedSourceDateInfo();

    List<Integer> getAllJielvHotelId();

    int deleteObsoleteNightlyRate(String delDete);
}
