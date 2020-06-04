package com.heyou.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/7 12:54
 * @Version: 1.0
 */
@Component
public class JielvPriceIncrementConfig {

    @Value("${jielv.host.port}")
    private String hostPort;

    @Value("${jielv.init.priceIncrement.url}")
    private String url;


    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
