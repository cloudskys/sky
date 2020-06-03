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
 * Neither the name of the cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.cloud.sky.codegen;

import com.cloud.sky.common.datasource.annotation.EnableDynamicDataSource;
import com.cloud.sky.common.security.annotation.EnablePigxFeignClients;
import com.cloud.sky.common.security.annotation.EnablePigxResourceServer;
import com.cloud.sky.common.swagger.annotation.EnablePigxSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author lengleng
 * @date 2018/07/29
 * 代码生成模块
 */
@EnableDynamicDataSource
@EnablePigxSwagger2
@SpringCloudApplication
@EnablePigxFeignClients
@EnablePigxResourceServer
public class PigxCodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PigxCodeGenApplication.class, args);
	}
}
