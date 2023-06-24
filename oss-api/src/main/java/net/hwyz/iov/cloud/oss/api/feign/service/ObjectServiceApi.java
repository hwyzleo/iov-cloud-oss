package net.hwyz.iov.cloud.oss.api.feign.service;

import net.hwyz.iov.cloud.oss.api.contract.PreSignedUrl;
import net.hwyz.iov.cloud.oss.api.contract.request.GeneratePreSignedUrlRequest;

/**
 * 对象相关服务接口
 *
 * @author hwyz_leo
 */
public interface ObjectServiceApi {

    /**
     * 生成预签名地址
     *
     * @param request 生成预签名地址请求
     * @return 预签名地址
     */
    PreSignedUrl generatePreSignedUrl(GeneratePreSignedUrlRequest request);

}
