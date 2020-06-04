package com.heyou.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/7 12:51
 * @Version: 1.0
 */
@Configuration
public class JielvInithotelDetailConfig {

    @Value("${jielv.host.port}")
    private String hostPort;

    @Value("${jielv.init.hotelDetail.url}")
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
