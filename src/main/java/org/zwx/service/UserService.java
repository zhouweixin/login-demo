package org.zwx.service;

import org.springframework.stereotype.Service;
import org.zwx.domain.User;
import org.zwx.exception.GlobalException;
import org.zwx.exception.ExceptionEnum;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public void register(User user) {
        if (user == null) {
            throw GlobalException.newException(ExceptionEnum.USER_CAN_NOT_EMPTY);
        }

        checkName(user.getName());
        checkPassword(user.getPassword());

        if (user.getEmail() != null && !user.getEmail().matches(".*@.*\\.com")) {
            throw GlobalException.newException(ExceptionEnum.EMAIL_INVALID);
        }

        if (users.stream().anyMatch(u -> user.getName().equals(u.getName()))) {
            throw GlobalException.newException(ExceptionEnum.NAME_DUPLICATE);
        }

        user.setId(users.size() + 1);
        users.add(user);
    }

    public User login(String name, String password) {
        checkName(name);
        checkPassword(password);

        return users.stream().filter(user->name.equals(user.getName()) && password.equals(user.getPassword()))
                .findFirst().orElseThrow(()->GlobalException.newException(ExceptionEnum.NAME_OR_PASSWORD_INCORRECT));
    }

    private void checkName(String name) {
        if (name == null || "".equals(name)) {
            throw GlobalException.newException(ExceptionEnum.NAME_CAN_NOT_EMPTY);
        }

        if (!name.matches("[A-Za-z0-9_]{3,10}")) {
            throw GlobalException.newException(ExceptionEnum.NAME_INVALID);
        }
    }

    private void checkPassword(String password) {
        if (password == null || "".equals(password)) {
            throw GlobalException.newException(ExceptionEnum.PASSWORD_CAN_NOT_EMPTY);
        }

        if (!password.matches(".{5,12}")) {
            throw GlobalException.newException(ExceptionEnum.PASSWORD_INVALID);
        }
    }
}
