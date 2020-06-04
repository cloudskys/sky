package com.heyou.service.houseorder.impl;

import com.heyou.dao.houseorder.IInstallOrderDao;
import com.heyou.entity.houseorder.po.InstallOrderInfo;
import com.heyou.entity.houseorder.vo.InstallOrderInfoVo;
import com.heyou.service.houseorder.IInstallOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/6/28 11:34
 * @Version: 1.0
 */
@Service
public class InstallOrderServiceImpl implements IInstallOrderService {

    @Autowired
    private IInstallOrderDao installOrderDao;

    @Override
    public List<String> getUnfinishedInstallOrder() {
        return installOrderDao.getUnfinishedInstallOrder();
    }
}
