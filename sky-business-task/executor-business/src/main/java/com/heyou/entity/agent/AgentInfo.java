/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AgentInfo
 * Author:   Administrator
 * Date:     2020/1/3 14:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.heyou.entity.agent;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description:
 * @Author: Administrator
 * @Time: 2020/1/3 14:41
 * @Version: 1.0
 */
public class AgentInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private Integer agentId;

    private Integer chainUid;

    private String agentPhone;

    private String name;

    private Integer agentType;

    private String identity;

    private Integer sex;

    public AgentInfo() {
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getChainUid() {
        return chainUid;
    }

    public void setChainUid(Integer chainUid) {
        this.chainUid = chainUid;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAgentType() {
        return agentType;
    }

    public void setAgentType(Integer agentType) {
        this.agentType = agentType;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "AgentInfo{" +
                "agentId=" + agentId +
                ", chainUid=" + chainUid +
                ", agentPhone='" + agentPhone + '\'' +
                ", name='" + name + '\'' +
                ", agentType=" + agentType +
                ", identity='" + identity + '\'' +
                ", sex=" + sex +
                '}';
    }
}
