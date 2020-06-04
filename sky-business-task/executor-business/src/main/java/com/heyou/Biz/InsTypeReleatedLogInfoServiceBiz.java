package com.heyou.Biz;

import com.heyou.dao.airOrder.InsTypeReleatedLogInfoDAO;
import com.heyou.entity.airOrder.InsTypeReleatedLogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈〉
 *
 * @author shihao.cheng@ijiuyue.com
 * @create 2019/8/21 9:18
 * @since 1.0.0
 */
@Component
public class InsTypeReleatedLogInfoServiceBiz {

    @Autowired
    private InsTypeReleatedLogInfoDAO insTypeReleatedlogInfoDAO;

    /**
     * 查询保险日志表
     * @param state
     * @param num
     * @return
     */
    public List<InsTypeReleatedLogInfo> getAllInsTypeReleatedlogInfos(Integer state, Integer num) {
        return insTypeReleatedlogInfoDAO.getAllInsTypeReleatedlogInfos(state, num);
    }

}