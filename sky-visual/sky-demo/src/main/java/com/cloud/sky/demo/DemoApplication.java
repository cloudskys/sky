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

package com.cloud.sky.demo;

import java.util.concurrent.*;


public class DemoApplication {

	private static final int THREAD_COUNT = 30;//总共的线程数
	//private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
	private static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10000);
	private static RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
	private static ThreadPoolExecutor threadPool =new ThreadPoolExecutor(10, 15, 600,TimeUnit.SECONDS, queue, handler);
	private static Semaphore semaphore = new Semaphore(10);//可以并发执行的线程数


	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			final int j=i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();//acquire()获取一个许可证
						/**
						 * 要执行的代码块
						 */
						System.out.println(j+"zl");
						semaphore.release();//使用完之后调用release()归还许可证
					} catch (InterruptedException e) {
					}
				}
			});
		}
		threadPool.shutdown();

	}

}
