/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.cloud.sky.manager.netty.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cloud.sky.manager.manager.service.LoadBalanceService;
import com.cloud.sky.manager.model.LoadBalanceInfo;
import com.cloud.sky.manager.netty.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 获取负载模块信息
 * @author LCN on 2017/11/11
 */
@Service(value = "glb")
public class ActionGLBServiceImpl implements IActionService {


	@Autowired
	private LoadBalanceService loadBalanceService;


	@Override
	public String execute(String channelAddress, String key, JSONObject params) {
		String res;
		String groupId = params.getString("g");
		String k = params.getString("k");

		LoadBalanceInfo loadBalanceInfo = loadBalanceService.get(groupId, k);
		if (loadBalanceInfo == null) {
			res = "";
		} else {
			res = loadBalanceInfo.getData();
		}
		return res;
	}
}
