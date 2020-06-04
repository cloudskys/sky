package com.heyou.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/7 12:45
 * @Version: 1.0
 */
@Component
public class JielvSystemConfig {

    @Value("${jielv.appkey}")
    private String appkey;

    @Value("${jielv.secretKey}")
    private String secretKey;

    @Value("${jielv.version}")
    private String version;

    @Value("${jielv.price.raisePrice}")
    private Double raisePrice;

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Double getRaisePrice() {
        return raisePrice;
    }

    public void setRaisePrice(Double raisePrice) {
        this.raisePrice = raisePrice;
    }
}
