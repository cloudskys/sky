package com.heyou.Biz;

import com.heyou.dao.airOrder.InsTypeReleatedInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 19:02
 * @Version: 1.0
 */
@Component
public class InsTypeReleatedInfoServiceBiz {

    @Autowired
    private InsTypeReleatedInfoDAO insTypeReleatedInfoDAO;

    public List<Integer> getThirdOrderNo(String orderNo){
        return insTypeReleatedInfoDAO.getThirdOrderNo(orderNo);
    }

}
