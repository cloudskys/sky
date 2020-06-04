package com.heyou.dao.houseorder;

import com.heyou.entity.houseorder.po.OrderInfoPO;
import com.heyou.entity.housebase.vo.OrderInfoVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface IOrderInfoDao extends Mapper<OrderInfoPO> {


    List<OrderInfoPO> findAllWaitConfirmOrder();
}
