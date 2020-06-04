/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AgentInfoDao
 * Author:   Administrator
 * Date:     2020/1/3 14:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.heyou.dao.agent;

import com.heyou.entity.agent.AgentInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: Administrator
 * @Time: 2020/1/3 14:40
 * @Version: 1.0
 */
@Repository("agentInfoDao")
public interface AgentInfoDao extends Mapper<AgentInfo> {

    public List<AgentInfo> selectAgentInfosByBirth();

}
