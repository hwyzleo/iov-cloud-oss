package net.hwyz.iov.cloud.oss.service.infrastructure.external;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import lombok.RequiredArgsConstructor;
import net.hwyz.iov.cloud.oss.service.domain.external.service.ExCosService;
import org.springframework.stereotype.Service;

import java.net.URL;

/**
 * 外部腾讯云COS服务实现类
 *
 * @author hwyz_leo
 */
@Service
@RequiredArgsConstructor
public class ExCosServiceImpl implements ExCosService {

    final COSClient cosClient;

    @Override
    public URL generatePresignedUrl(String bucketName, String key, HttpMethodName method) {
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, key, method);
        return cosClient.generatePresignedUrl(request);
    }
}
