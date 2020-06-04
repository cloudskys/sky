package com.heyou.service.houseorder;

import com.heyou.entity.houseorder.po.InstallOrderInfo;
import com.heyou.entity.houseorder.vo.InstallOrderInfoVo;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/6/28 11:33
 * @Version: 1.0
 */
public interface IInstallOrderService {

    List<String> getUnfinishedInstallOrder();

}
