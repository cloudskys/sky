package com.heyou.service.houseorder;

import com.heyou.entity.houseorder.po.OrderInfoPO;
import com.heyou.entity.housebase.vo.OrderInfoVO;
import java.util.List;

public interface IOrderInfoService {

    List<OrderInfoPO> findAllWaitConfirmOrder();


}
