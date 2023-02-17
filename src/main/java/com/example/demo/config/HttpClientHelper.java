package com.example.demo.config;


import com.example.demo.controller.TestController;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Transactional
@Component
public class HttpClientHelper implements InitializingBean {

    private CloseableHttpClient client;


    @Autowired
    private TestController testController;


    public HttpClientHelper(){
        int a = 0;
    }



    @PostConstruct
    void init(){


        PoolingHttpClientConnectionManager m = new PoolingHttpClientConnectionManager();
        m.setDefaultMaxPerRoute(1);
        m.setMaxTotal(1000);

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(1000).setSocketTimeout(1000).build();

        client = HttpClients.custom().setConnectionManager(m).setDefaultRequestConfig(requestConfig).build();
    }

    public String get(String url){
        HttpGet get = new HttpGet(url);

        try {
            CloseableHttpResponse response = client.execute(get);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public static void main(String[] args) {
        HttpClientHelper client = new HttpClientHelper();
        client.init();
        for (int i = 0; i < 10; i++) {
            client.get("http://localhost:8081/sleep");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        int a = 0;
    }
}
