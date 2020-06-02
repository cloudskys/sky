/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (wangiegie@gmail.com)
 *
 */

package com.cloud.sky.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * @author lengleng
 * @date 2018/7/1
 * 路由限流配置
 */
@Configuration
public class RateLimiterConfiguration {
	/**
	 * ip限流
	 * @return
	 */
	@Bean(value = "remoteAddrKeyResolver")
	@Primary
	public KeyResolver remoteAddrKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
	}

	/**
	 * 接口限流
	 * @return
	 */
	@Bean(value = "apiKeyResolver")
	KeyResolver apiKeyResolver() {
		//按URL限流,即以每秒内请求数按URL分组统计，超出限流的url请求都将返回429状态
		return exchange -> Mono.just(exchange.getRequest().getPath().value());
	}

	/**
	 * 用户限流
	 * @return
	 */
	@Bean(value = "userKeyResolver")
	KeyResolver userKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
	}
}
