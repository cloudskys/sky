/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AgentMessage
 * Author:   Administrator
 * Date:     2020/1/3 16:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.heyou.entity.agent;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Administrator
 * @Time: 2020/1/3 16:43
 * @Version: 1.0
 */
public class AgentMessage implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 代理手机号
     */
    private String phone;

    /**
     * 代理姓名
     */
    private String name;

    /**
     * 代理性别，1-男，2-女
     */
    private Integer sex;

    public AgentMessage() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "AgentMessage{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
