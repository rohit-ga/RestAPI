package com.ga.database;

import java.util.HashMap;
import java.util.Map;

import com.ga.model.Message;
import com.ga.model.User;

public class Database {

    private static Map<Long, Message> messages = new HashMap<Long, Message>();
    private static Map<Long, User> users = new HashMap<Long, User>();
    
    public static Map<Long, Message> getMessages() {
        return messages;
        
    }
    
    public static Map<Long, User> getUser() {
        return users;
    }

}
