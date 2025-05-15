package com.msuser.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-user",
        url = "${application.client.ms-auth.url}/v1/auth")
public interface AuthClient {

    @PostMapping()
    String createPassword(@RequestParam String password);
}
