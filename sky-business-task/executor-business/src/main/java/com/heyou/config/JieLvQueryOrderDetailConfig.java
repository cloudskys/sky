package com.heyou.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class JieLvQueryOrderDetailConfig {

    @Value("${jielv.host.api.port}")
    private String hostPort;

    @Value("${jielv.query.order.url}")
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
