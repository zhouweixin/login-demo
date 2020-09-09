package org.zwx.service;

import org.junit.jupiter.api.Test;
import org.zwx.domain.User;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService userService = new UserService();

    @Test
    void register() {
        List<User> users = Arrays.asList(
                new User("", "", ""),
                new User("", "", ""),
                new User("", "", ""));
        for (User user : users) {
            userService.register(user);
        }
    }
}