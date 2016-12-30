package com.ga.service;

import java.util.List;
import java.util.Set;

import com.ga.database.Database;
import com.ga.model.User;

public class UserService {

    private Set<User> users = Database.getUser();
    private List<User> userList = Database.getAllUser();

    public UserService() {
    }

    public String registerUser(User user) {

        user.setId(users.size() + 1);
        users.add(user);
        return "Registered successful";
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

        return userList;
    }

}