package net.hwyz.iov.cloud.oss.api.contract.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.hwyz.iov.cloud.oss.api.contract.enums.ObjectAccessPermission;

/**
 * 生成预签名地址请求
 *
 * @author hwyz_leo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratePreSignedUrlRequest {

    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 对象名称
     */
    private String objectName;
    /**
     * 对象访问权限
     */
    private ObjectAccessPermission permission;

}
