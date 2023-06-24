package net.hwyz.iov.cloud.oss.service.domain.external.service;

import com.qcloud.cos.http.HttpMethodName;

import java.net.URL;

/**
 * 外部腾讯云COS服务
 *
 * @author hwyz_leo
 */
public interface ExCosService {

    URL generatePresignedUrl(String bucketName, String key, HttpMethodName method);

}
