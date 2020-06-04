package com.heyou.service.houseorder.impl;


import com.heyou.dao.houseorder.IOrderInfoDao;
import com.heyou.entity.houseorder.po.OrderInfoPO;
import com.heyou.entity.housebase.vo.OrderInfoVO;
import com.heyou.service.houseorder.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderInfoServiceImpl implements IOrderInfoService {
    @Autowired
    public IOrderInfoDao orderInfoDao;

    @Override
    public List<OrderInfoPO> findAllWaitConfirmOrder() {
        return orderInfoDao.findAllWaitConfirmOrder();
    }
}



