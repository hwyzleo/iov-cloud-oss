package net.hwyz.iov.cloud.oss.service.infrastructure.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.tencentcloudapi.common.profile.Region.Shanghai;

/**
 * 腾讯云COS配置类
 *
 * @author hwyz_leo
 */
@Slf4j
@Configuration
public class CosConfiguration {

    @Value("${sp.cos.secret-id}")
    private String secretId;
    @Value("${sp.cos.secret-key}")
    private String secretKey;

    @Bean
    public COSClient cosClient() {
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        Region region = new Region(Shanghai.getValue());
        ClientConfig clientConfig = new ClientConfig(region);
        clientConfig.setHttpProtocol(HttpProtocol.https);
        clientConfig.setMaxErrorRetry(3);
        return new COSClient(cred, clientConfig);
    }

}
