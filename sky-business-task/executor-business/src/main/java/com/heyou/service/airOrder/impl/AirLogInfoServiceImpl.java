package com.heyou.service.airOrder.impl;

import com.heyou.dao.airOrder.AirLogInfoDAO;
import com.heyou.entity.airOrder.AirLogInfo;
import com.heyou.service.airOrder.IAirLogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/18 15:53
 * @Version: 1.0
 */
@Service
public class AirLogInfoServiceImpl implements IAirLogInfoService {

    @Autowired
    private AirLogInfoDAO airLogInfoDAO;

    @Override
    public int add(AirLogInfo airLogInfo) {
        return airLogInfoDAO.insert(airLogInfo);
    }
}
