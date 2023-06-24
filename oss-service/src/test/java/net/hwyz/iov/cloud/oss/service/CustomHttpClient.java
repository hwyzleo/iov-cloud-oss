package net.hwyz.iov.cloud.oss.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 自定义HttpClient
 *
 * @author hwyz_leo
 */
public class CustomHttpClient {

    private static HttpClient httpClient;

    private CustomHttpClient() {
    }

    public static HttpClient get() {
        if (httpClient == null) {
            synchronized (CustomHttpClient.class) {
                if (httpClient == null) {
                    RequestConfig requestConfig = RequestConfig.custom()
                            .setConnectTimeout(1000)
                            .setConnectionRequestTimeout(5000)
                            .setSocketTimeout(20000)
                            .build();
                    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(60000, TimeUnit.MILLISECONDS);
                    cm.setMaxTotal(50);
                    cm.setDefaultMaxPerRoute(50);
                    httpClient = HttpClients.custom()
                            .setDefaultRequestConfig(requestConfig)
                            .setConnectionManager(cm)
                            .disableAutomaticRetries()
                            .build();
                }
            }
        }
        return httpClient;
    }

    /**
     * GET请求
     *
     * @param url 地址
     * @return 响应
     * @throws URISyntaxException
     * @throws IOException
     */
    public static HttpResponse get(String url) throws URISyntaxException, IOException {
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(new URI(url));
        return get().execute(httpGet);
    }

    /**
     * GET请求
     *
     * @param url 地址
     * @return 响应
     * @throws URISyntaxException
     * @throws IOException
     */
    public static HttpResponse get(String url, Map<String, String> params) throws URISyntaxException, IOException {
        HttpGet httpGet = new HttpGet();
        URIBuilder builder = new URIBuilder(url);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.setParameter(entry.getKey(), entry.getValue());
            }
        }
        httpGet.setURI(builder.build());
        return get().execute(httpGet);
    }

    /**
     * POST请求
     *
     * @param url  地址
     * @param body 内容
     * @return 响应
     * @throws URISyntaxException
     * @throws IOException
     */
    public static HttpResponse post(String url, String body) throws URISyntaxException, IOException {
        HttpPost httpPost = new HttpPost();
        httpPost.setURI(new URI(url));
        httpPost.setEntity(new StringEntity(body, StandardCharsets.UTF_8));
        httpPost.setHeader("Content-Type", "application/json");
        return get().execute(httpPost);
    }

    /**
     * PUT请求
     *
     * @param url  地址
     * @param body 内容
     * @return 响应
     * @throws URISyntaxException
     * @throws IOException
     */
    public static HttpResponse put(String url, String body) throws URISyntaxException, IOException {
        HttpPut httpPut = new HttpPut();
        httpPut.setURI(new URI(url));
        httpPut.setEntity(new StringEntity(body, StandardCharsets.UTF_8));
        httpPut.setHeader("Content-Type", "application/json");
        return get().execute(httpPut);
    }

    /**
     * PUT请求
     *
     * @param url  地址
     * @return 响应
     * @throws URISyntaxException
     * @throws IOException
     */
    public static HttpResponse put(String url, File file, ContentType contentType) throws URISyntaxException, IOException {
        HttpPut httpPut = new HttpPut();
        httpPut.setURI(new URI(url));
        httpPut.setEntity(new FileEntity(file, contentType));
        httpPut.setHeader("Content-Type", "application/json");
        return get().execute(httpPut);
    }

    /**
     * DELETE请求
     *
     * @param url 地址
     * @return 响应
     * @throws URISyntaxException
     * @throws IOException
     */
    public static HttpResponse delete(String url) throws URISyntaxException, IOException {
        HttpDelete httpDelete = new HttpDelete();
        httpDelete.setURI(new URI(url));
        return get().execute(httpDelete);
    }

}
