package com.heyou.Biz;

import com.heyou.dao.airOrder.AirOrderHeadInfoDAO;
import com.heyou.entity.airOrder.AirOrderInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 18:02
 * @Version: 1.0
 */
@Component
public class AirOrderHeadInfoServiceBiz {

    @Autowired
    private AirOrderHeadInfoDAO airOrderHeadInfoDAO;

    public int updateOrderState(String orderNo, int orderState){
        return airOrderHeadInfoDAO.updateOrderState(orderNo,orderState);
    }

    public List<AirOrderInfoVo> getWaitCancelOrderNo() {
        return airOrderHeadInfoDAO.getWaitCancelOrderNo();
    }
}
