package com.msuser.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ms-user",
        url = "${application.client.ms-auth.url}/v1/auth")
public interface AuthClient {


}
