package net.hwyz.iov.cloud.oss.api.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 预签名地址
 *
 * @author hwyz_leo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreSignedUrl {

    /**
     * 上传地址
     */
    private String uploadUrl;
    /**
     * 对象Key
     */
    private String objectKey;

}
