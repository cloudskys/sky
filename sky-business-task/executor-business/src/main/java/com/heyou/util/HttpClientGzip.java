package com.heyou.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.eclipse.jetty.http.HttpHeader;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/6 15:25
 * @Version: 1.0
 */
public class HttpClientGzip {

    private static Logger logger = Logger.getLogger(HttpClientGzip.class);

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static String doGet(String message, String strURL) throws Exception {
        String strResult = "";
        URL url;
        try {
            url = new URL(strURL.trim());
            HttpURLConnection con = (HttpURLConnection)url.openConnection();// 建立针对该URL的连接
            con.setRequestMethod("GET");
            con.setUseCaches(false);// 不使用缓存
            con.setDoInput(true);// 允许输入
            con.setDoOutput(true);// 允许输出
            //con.setConnectTimeout(5000);
            //con.setReadTimeout(5000);
            con.setRequestProperty("Content-Type", "text/html;charset=UTF-8");
            con.setRequestProperty("Accept-Encoding", "gzip");//请求头部设置gzip
            con.connect();
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
            out.write(message);
            out.flush();
            out.close();
            Reader reader = null;
            if ("GZIP".equals(con.getContentEncoding()) || "gzip".equals(con.getContentEncoding())) {
                //gzip解压
                reader = new InputStreamReader(new GZIPInputStream(con.getInputStream()), "utf-8");
            } else {
                reader = new InputStreamReader(con.getInputStream(), "utf-8");
            }
            StringBuilder sb = new StringBuilder();
            while (true) {
                int ch = reader.read();
                if (ch==-1) {
                    break;
                }

                sb.append((char)ch);
            }
            reader.close();
            strResult = sb.toString();
        } catch (MalformedURLException e) {
            throw new Exception("url连接失败");
        } catch (IOException e) {
            throw new Exception("读取出错");
        }
        return strResult;
    }

    public static void doGet(String strURL) throws Exception {
        CloseableHttpResponse response = null;
        try {
            HttpRequestBase httpRequestBase = new HttpGet(strURL);
            httpRequestBase.addHeader(HttpHeader.CONTENT_TYPE.asString(), "application/json;charset=UTF-8");

            RequestConfig.Builder builder = RequestConfig.custom()
                .setSocketTimeout(20000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .setTargetPreferredAuthSchemes(Collections.singletonList(AuthSchemes.BASIC));
            httpRequestBase.setConfig(builder.build());

            response = httpClient.execute(httpRequestBase);
            //请求错误，响应结果为null
            if (response == null) {
                throw new IllegalStateException("http返回为null！");
            }
            int statusCode = response.getStatusLine().getStatusCode();
            //状态码不是200
            if (statusCode != HttpStatus.SC_OK) {
                throw new Exception("网络异常");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("关闭http请求流异常", e);
                }
            }
        }
    }

}
