package org.zwx.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.zwx.domain.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    void register() {
        User user = new User("周威信", "123456", "123456@qq.com");
        ResponseEntity<?> register = userController.register(user);
        Assertions.assertEquals(HttpStatus.OK, register.getStatusCode());
    }
}