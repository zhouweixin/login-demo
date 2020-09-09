package org.zwx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.zwx.domain.User;
import org.zwx.service.UserService;
import org.zwx.util.Result;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(Result.success(null));
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(String name, String password) {
        return ResponseEntity.ok(Result.success(userService.login(name, password)));
    }
}
