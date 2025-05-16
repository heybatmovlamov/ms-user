package com.msuser.controller;

import com.msuser.model.request.UserRequest;
import com.msuser.model.response.UserView;
import com.msuser.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserView> createUser(@Valid UserRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserView> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findUserByName(email));
    }
}
