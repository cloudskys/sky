package com.heyou.Biz;

import com.heyou.dao.airOrder.AirOrderInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 18:14
 * @Version: 1.0
 */
@Component
public class AirOrderInfoServiceBiz {
    @Autowired
    private AirOrderInfoDAO airOrderInfoDAO;

    public int updateOrderState(String orderNo,int orderState) {
        return airOrderInfoDAO.updateOrderState(orderNo,orderState);
    }

}
