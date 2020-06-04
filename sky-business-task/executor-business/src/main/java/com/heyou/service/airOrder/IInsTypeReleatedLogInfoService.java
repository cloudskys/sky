package com.heyou.service.airOrder;

import com.heyou.entity.airOrder.InsTypeReleatedLogInfo;

import java.util.List;

/**
 * 〈〉
 *
 * @author shihao.cheng@ijiuyue.com
 * @create 2019/8/21 9:20
 * @since 1.0.0
 */
public interface IInsTypeReleatedLogInfoService {

    List<InsTypeReleatedLogInfo> getAllInsTypeReleatedlogInfos(Integer state, Integer num);

}
