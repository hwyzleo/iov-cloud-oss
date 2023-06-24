package net.hwyz.iov.cloud.oss.service.api.facade.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.oss.api.contract.PreSignedUrl;
import net.hwyz.iov.cloud.oss.api.contract.request.GeneratePreSignedUrlRequest;
import net.hwyz.iov.cloud.oss.api.feign.service.ObjectServiceApi;
import net.hwyz.iov.cloud.oss.service.application.service.ObjectAppService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/service/object")
public class ObjectServiceController implements ObjectServiceApi {

    final ObjectAppService objectAppService;

    @Override
    @PostMapping("/action/generatePreSignedUrl")
    public PreSignedUrl generatePreSignedUrl(@RequestBody @Valid GeneratePreSignedUrlRequest request) {
        logger.info("服务[{}]生成对象[{}]预签名地址[{}]", request.getServiceName(), request.getObjectName(), request.getPermission());
        return objectAppService.generatePreSignedUrl(request.getServiceName(), request.getObjectName(), request.getPermission());
    }

}
