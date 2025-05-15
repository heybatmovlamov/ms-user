package com.msuser.controller;

import com.msuser.model.request.UserRequest;
import com.msuser.model.response.UserView;
import com.msuser.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserView> createUser(@Valid UserRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }
}
