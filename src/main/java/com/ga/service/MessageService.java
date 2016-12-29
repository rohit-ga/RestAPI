package com.ga.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ga.model.Message;

public class MessageService {

    private Map<Long, Message> messages = new HashMap<Long, Message>();

    public MessageService() {
        messages.put(1L, new Message(1, "Good morning from Rohit", "Rohit"));
        messages.put(2L, new Message(2, "Hi team from Rathi", "Rathi"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message editMessage(Message message) {
        if (message.getId() > 0) {
            messages.put(message.getId(), message);
            return message;
        }
        return null;
    }

    public Message deleteMessage(long id) {
        return messages.remove(id);
    }

}