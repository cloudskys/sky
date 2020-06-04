package com.heyou.dao.houseorder;

import com.heyou.entity.houseorder.po.InstallOrderInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/6/28 11:34
 * @Version: 1.0
 */
@Repository
public interface IInstallOrderDao extends Mapper<InstallOrderInfo> {

    List<String> getUnfinishedInstallOrder();

}
