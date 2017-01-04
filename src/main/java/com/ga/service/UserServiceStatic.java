package com.ga.service;

import java.util.List;
import java.util.Set;

import com.ga.dao.UserDaoStatic;
import com.ga.model.User;

public class UserServiceStatic {

    private Set<User> users = UserDaoStatic.registerUser();

    public String registerUser(User user) {

        user.setId(users.size() + 1);
        users.add(user);
        return "Registered Successfully";
    }

    public String loginUser(String email, String password) {

        boolean flag = true;
        for (User user1 : users) {
            if (user1.getEmail().equals(email) && user1.getPassword().equals(password)) {
                flag = false;
                return "Login successfull";
            }
        }
        if (flag) {
            return "Wrong credential";
        }
        return null;

    }

    public List<User> getAllUser() {

        return UserDaoStatic.getAllUser();
    }

}
