package com.heyou.service.housebase;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/3/6 16:58
 * @Version: 1.0
 */
public interface IJielvInfoService {

    String getHotelPrice(int hotelId);

    String getHotelDetail(int hotelId);

    String getHotelInfoList(int pageNo,String isConfirm);

    String getHotelPriceIncrement();

}
