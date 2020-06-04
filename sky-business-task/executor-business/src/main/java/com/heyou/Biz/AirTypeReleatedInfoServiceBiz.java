package com.heyou.Biz;

import com.heyou.dao.airOrder.AirTypeReleatedInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 18:56
 * @Version: 1.0
 */
@Component
public class AirTypeReleatedInfoServiceBiz {

    @Autowired
    private AirTypeReleatedInfoDAO airTypeReleatedInfoDAO;

    public List<String> getThirdOrderNo(String orderNo){
        return airTypeReleatedInfoDAO.getThirdOrderNo(orderNo);
    }

}
