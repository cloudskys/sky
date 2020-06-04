package com.heyou.Biz;

import com.heyou.dao.airOrder.InsOrderInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 18:59
 * @Version: 1.0
 */
@Component
public class InsOrderInfoServiceBiz {

    @Autowired
    private InsOrderInfoDAO insOrderInfoDAO;

    public int updateOrderState(String orderNo,int orderState){
        return insOrderInfoDAO.updateOrderState(orderNo,orderState);
    }
}
