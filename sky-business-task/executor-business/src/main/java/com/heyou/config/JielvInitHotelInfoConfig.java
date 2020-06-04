package com.heyou.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/7 11:56
 * @Version: 1.0
 */
@Component
public class JielvInitHotelInfoConfig {

    @Value("${jielv.host.port}")
    private String hostPort;

    @Value("${jielv.init.hotelInfo.url}")
    private String url;

    @Value("${jielv.init.hotelInfo.pageSize}")
    private int pageSize;

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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
