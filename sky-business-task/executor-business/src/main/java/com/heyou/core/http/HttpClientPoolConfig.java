package com.heyou.core.http;

import com.heyou.core.http.security.TrustAnyManager;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.security.KeyManagementException;

@Component
public class HttpClientPoolConfig {

    //设置连接池最大连接为3000
    private static final int POOL_MAX_TOTAL = 200;
    //默认每个host可用连接为500
    private static final int DEFAULT_MAX_PER_ROUTE = 50;


    @Bean(name = "httpClient", destroyMethod = "close")
    CloseableHttpClient httpClient() throws KeyManagementException{
        return buildCloseableHttpClient();
    }

    /**
     * 构建HttpClient连接池
     * @return
     * @throws KeyManagementException
     */
    private CloseableHttpClient buildCloseableHttpClient() throws KeyManagementException {
        SSLContext sslcontext = SSLContexts.createDefault();
        //设置https客户端信任万能证书
        sslcontext.init(null, new TrustManager[]{new TrustAnyManager()}, null);
        SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(sslcontext, NoopHostnameVerifier.INSTANCE);
        //注册请求方式，根据URL自动请求
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", ssf)
                .build();
        //创建Http连接池
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        connectionManager.setMaxTotal(POOL_MAX_TOTAL);
        connectionManager.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE);
        return HttpClients.custom()
                .setConnectionManager(connectionManager)
//                .setConnectionReuseStrategy(NoConnectionReuseStrategy.INSTANCE)
                .disableAutomaticRetries()//设置请求失败不重试
                .build();
    }
}
