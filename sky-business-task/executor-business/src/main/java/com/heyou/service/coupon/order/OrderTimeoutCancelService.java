package com.heyou.service.coupon.order;

import com.heyou.util.HttpClientGzip;
import groovy.util.logging.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description: 超时自动取消
 * @Author: ZXE
 * @Time: 2020/2/18 15:12
 * @Version: 1.0
 */
@Slf4j
@Service
public class OrderTimeoutCancelService {

    private Logger logger = Logger.getLogger(this.getClass());

    @Value("${service.address.url}")
    private String serviceAddress;

    public void autoCancelOrder() {
        try {
            String url = serviceAddress  + "/coupon-api/task/order/auto-cancel";
            logger.info("autoCancelOrder task request:"+ url);
            HttpClientGzip.doGet(url);
            logger.info("autoCancelOrder task success");
        } catch (Exception e) {
            logger.error("autoCancelOrder task error:"+ e);
        }
    }
}
