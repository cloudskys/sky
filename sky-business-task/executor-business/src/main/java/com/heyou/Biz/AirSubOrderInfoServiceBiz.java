package com.heyou.Biz;

import com.heyou.dao.airOrder.AirSubOrderInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 18:52
 * @Version: 1.0
 */
@Component
public class AirSubOrderInfoServiceBiz {

    @Autowired
    private AirSubOrderInfoDAO airSubOrderInfoDAO;

    public int updateOrderState(String orderNo,int orderState){
        return airSubOrderInfoDAO.updateOrderState(orderNo,orderState);
    }

}
