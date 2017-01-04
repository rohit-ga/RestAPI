package com.ga.service;

import java.util.List;

import com.ga.dao.UserDao;
import com.ga.model.User;

public class UserService {

    UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public String registerUser(User user) {

        return userDao.registerUser(user);
    }

    public String loginUser(String email, String password) {

        return userDao.loginUser(email, password);
    }

    public List<User> getAllUser() {

        return userDao.getAllUser();
    }

    public String deleteUserById(int id) {

        return userDao.deleteUserById(id);
    }

    public User getUserById(int id) {

        if (id <= 0) {
            return new User("Invalid UserID");
        } else {
            return userDao.getUserById(id);
        }
    }

    public String updateUser(int id, User user) {

        User user1 = getUserById(id);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setContact(user.getContact());

        return userDao.updateUser(id, user1);
    }

    public User getUserDetails(String email) {

        return userDao.getUserDetails(email);
    }

    public String addUser(String firstName, String lastName, String contact, String email, String password) {

        User user1 = new User(firstName, lastName, contact, email, password);
        return userDao.addUser(user1);
    }

}