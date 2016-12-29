package com.ga.service;

import java.util.HashMap;
import java.util.Map;

import com.ga.model.User;

public class UserService {
    
    private Map<Integer, User> users = new HashMap<Integer, User>();

    public UserService() {
        
        users.put(1, new User(101,"Rohit","Rathi","a@gmail.com","123","9889889898"));
    }

    public String registerUser(User user) {

        user.setId(users.size() + 1);
        users.put(user.getId(), user);
        return "Registration successfull.";
    }

    public String loginUser(User user) {
        if(user.getEmail().equals("a@gmail.com") && user.getPassword().equals("123")){
            return "Login successfull";
        }
             return "Wrong credential";
    }

}