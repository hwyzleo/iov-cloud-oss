package net.hwyz.iov.cloud.oss.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

@Rollback
@ActiveProfiles("dev")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    protected HttpHeaders newHttpHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("clientId", "client");
        return headers;
    }

}
