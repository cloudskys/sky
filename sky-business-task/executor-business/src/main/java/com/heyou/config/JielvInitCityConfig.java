package com.heyou.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/7 12:28
 * @Version: 1.0
 */
@Component
public class JielvInitCityConfig {

    @Value("${jielv.host.port}")
    private String hostPort;

    @Value("${jielv.init.city.url}")
    private String url;

    @Value("${jielv.init.city.pageSize}")
    private int pageSize;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }
}
