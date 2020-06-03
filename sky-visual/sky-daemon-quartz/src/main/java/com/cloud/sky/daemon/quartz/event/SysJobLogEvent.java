/*
 *    Copyright (c) 2018-2025,  All rights reserved.
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
 * Author:  (wangiegie@gmail.com)
 */

package com.cloud.sky.daemon.quartz.event;

import com.cloud.sky.daemon.quartz.entity.SysJobLog;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author frwcloud
 * 定时任务日志多线程事件
 */
@Getter
@AllArgsConstructor
public class SysJobLogEvent {
	private final SysJobLog sysJobLog;
}
