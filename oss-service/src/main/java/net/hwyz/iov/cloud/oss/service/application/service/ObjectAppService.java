package net.hwyz.iov.cloud.oss.service.application.service;

import com.qcloud.cos.http.HttpMethodName;
import lombok.RequiredArgsConstructor;
import net.hwyz.iov.cloud.oss.api.contract.PreSignedUrl;
import net.hwyz.iov.cloud.oss.api.contract.enums.ObjectAccessPermission;
import net.hwyz.iov.cloud.oss.service.domain.external.service.ExCosService;
import org.springframework.stereotype.Service;

import java.net.URL;

/**
 * 对象应用服务类
 *
 * @author hwyz_leo
 */
@Service
@RequiredArgsConstructor
public class ObjectAppService {

    final ExCosService cosService;

    /**
     * 生成预签名地址
     *
     * @param serviceName 服务名称
     * @param objectName  对象名称
     * @param permission  对象访问权限
     * @return 预签名地址
     */
    public PreSignedUrl generatePreSignedUrl(String serviceName, String objectName, ObjectAccessPermission permission) {
        String objectKey = getObjectKey(serviceName, objectName);
        URL url = cosService.generatePresignedUrl(getBucketName(permission), objectKey, HttpMethodName.PUT);
        return PreSignedUrl.builder()
                .uploadUrl(url.toString())
                .objectKey(objectKey)
                .build();
    }

    /**
     * 根据对象访问权限返回对应的桶
     *
     * @param permission 对象访问权限
     * @return 对象桶
     */
    private String getBucketName(ObjectAccessPermission permission) {
        switch (permission) {
            default -> {
                return "iov-public-1253442587";
            }
        }
    }

    /**
     * 根据服务名与对象名称返回对象Key
     *
     * @param serviceName 服务名称
     * @param objectName  对象名称
     * @return 对象Key
     */
    private String getObjectKey(String serviceName, String objectName) {
        return serviceName + "/" + objectName;
    }

}
