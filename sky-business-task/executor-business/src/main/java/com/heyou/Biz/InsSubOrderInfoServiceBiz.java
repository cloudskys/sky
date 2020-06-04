package com.heyou.Biz;

import com.heyou.dao.airOrder.InsSubOrderInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 19:06
 * @Version: 1.0
 */
@Component
public class InsSubOrderInfoServiceBiz {

    @Autowired
    private InsSubOrderInfoDAO insSubOrderInfoDAO;

    public int updateOrderStateByReleatedId(Integer releatedId,int orderState){
        return insSubOrderInfoDAO.updateOrderStateByReleatedId(releatedId,orderState);
    }

}
