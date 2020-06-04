package com.heyou.service.airOrder.impl;

import com.heyou.Biz.InsTypeReleatedLogInfoServiceBiz;
import com.heyou.entity.airOrder.InsTypeReleatedLogInfo;
import com.heyou.service.airOrder.IInsTypeReleatedLogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈〉
 *
 * @author shihao.cheng@ijiuyue.com
 * @create 2019/8/21 9:20
 * @since 1.0.0
 */
@Service
public class InsTypeReleatedLogInfoServiceImpl implements IInsTypeReleatedLogInfoService {

    @Autowired
    private InsTypeReleatedLogInfoServiceBiz insTypeReleatedLogInfoServiceBiz;

    @Override
    public List<InsTypeReleatedLogInfo> getAllInsTypeReleatedlogInfos(Integer state, Integer num) {
        return insTypeReleatedLogInfoServiceBiz.getAllInsTypeReleatedlogInfos(state, num);
    }
}
