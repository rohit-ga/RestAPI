package com.ga.dao;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ga.model.Message;
import com.ga.model.User;

public class UserDaoStatic {

    private static Map<Long, Message> messages = new HashMap<Long, Message>();
    private static Set<User> users = new LinkedHashSet<User>();
    private static List<User> userList = UserDaoStatic.getAllUser();

    public Map<Long, Message> getMessages() {

        return messages;
    }

    public static Set<User> registerUser() {

        return users;
    }

    public static List<User> getAllUser() {

        return userList;
    }

}
