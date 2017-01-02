package com.ga.service;

import java.util.List;

import com.ga.dao.UserDao;
import com.ga.model.User;

public class UserService {

//    private Set<User> users = UserDao.registerUser();
//    private List<User> userList = UserDao.getAllUser();
        UserDao userDao = new UserDao();
    public UserService() {
    }

    public String registerUser(User user) {

        return userDao.registerUser(user);
//        user.setId(users.size() + 1);
//        users.add(user);
//        return "Registered Successfully";
    }

    public String loginUser(String email, String password) {
     
        return userDao.loginUser(email,password);
        /*boolean flag = true;
        for (User user1 : users) {
            if (user1.getEmail().equals(email) && user1.getPassword().equals(password)) {
                flag = false;
                return "Login successfull";
            }
        }
        if (flag) {
            return "Wrong credential";
        }
        return null;*/
    }

    public List<User> getAllUser() {

        return userDao.getAllUser();
    }

    public String checkUserToDelete(int id) {

        return userDao.checkUserToDelete(id);
    }

    public User checkUserToUpdate(int id) {

        if(id<=0){
            return new User("Invalid UserID");
        } else {
            return userDao.checkUserToUpdate(id);
        }
    }

    public String updateUser(int id, User user) {
        User user1 = new User("firstName", "lastName", "contact", "email", "password");
        return userDao.updateUser(id,user1);
    }

}