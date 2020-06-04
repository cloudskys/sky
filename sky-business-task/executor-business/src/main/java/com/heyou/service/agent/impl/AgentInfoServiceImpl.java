/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AgentInfoServiceImpl
 * Author:   Administrator
 * Date:     2020/1/3 15:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.heyou.service.agent.impl;

import com.alibaba.fastjson.JSON;
import com.heyou.dao.agent.AgentInfoDao;
import com.heyou.entity.agent.AgentInfo;
import com.heyou.entity.agent.AgentMessage;
import com.heyou.service.agent.IAgentInfoService;
import com.heyou.util.CardAge;
import com.heyou.util.Contants;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Description:
 * @Author: Administrator
 * @Time: 2020/1/3 15:22
 * @Version: 1.0
 */
@Service("agentInfoService")
public class AgentInfoServiceImpl implements IAgentInfoService {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private AgentInfoDao agentInfoDao;

    @Autowired
    @Qualifier("rabbitTemplateAgent")
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendSmsToAgent() {
        logger.info("给代理发送生日短信service开始...");
        List<AgentInfo> list = agentInfoDao.selectAgentInfosByBirth();
        if (null == list || list.isEmpty()) {
            logger.info("当前没有代理是今天生日...");
            return;
        }
       /* Map<String, Map<String, String>> map = new HashMap<>();*/
        Map<String, Object> map = new HashMap<>();
       List<AgentMessage> mesList = new ArrayList<>();
        for (AgentInfo agentInfo : list) {
            logger.info("今天生日的代理信息:" + agentInfo.toString());
            AgentMessage agentMessage = new AgentMessage();
            agentMessage.setPhone(agentInfo.getAgentPhone());
            agentMessage.setName(agentInfo.getName());
            Integer sex = 1;
            try {
                if (agentInfo.getIdentity().length() == 15) {
                    sex = Integer.parseInt(CardAge.identityCard15(agentInfo.getIdentity()).get("sex").toString());
                } else if (agentInfo.getIdentity().length() == 18) {
                    sex = Integer.parseInt(CardAge.identityCard18(agentInfo.getIdentity()).get("sex").toString());
                }
            } catch (Exception e) {
                logger.error("根据身份证号获取性别异常...", e);
                sex = agentInfo.getSex() == 0 ? 1 : agentInfo.getSex();
            }
            agentMessage.setSex(sex);
            mesList.add(agentMessage);
            //innerMap.put(agentInfo.getAgentPhone(), agentInfo.getName());
        }
        map.put("birthdayMap", mesList);
        logger.info("==============================消息json字符串:" + JSON.toJSONString(map));
        rabbitTemplate.convertAndSend(Contants.agentExchange, Contants.agentKey, map);
    }

}
