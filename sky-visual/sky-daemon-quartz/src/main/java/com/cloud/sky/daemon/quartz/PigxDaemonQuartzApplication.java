package com.cloud.sky.daemon.quartz;

import com.cloud.sky.common.security.annotation.EnablePigxFeignClients;
import com.cloud.sky.common.security.annotation.EnablePigxResourceServer;
import com.cloud.sky.common.swagger.annotation.EnablePigxSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author frwcloud
 * @date 2019/01/23
 * 定时任务模块
 */
@EnablePigxSwagger2
@SpringCloudApplication
@EnablePigxFeignClients
@EnablePigxResourceServer
public class PigxDaemonQuartzApplication {

	public static void main(String[] args) {
		SpringApplication.run(PigxDaemonQuartzApplication.class, args);
	}
}
