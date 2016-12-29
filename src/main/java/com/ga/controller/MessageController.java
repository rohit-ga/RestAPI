package com.ga.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ga.model.Message;
import com.ga.service.MessageService;

@Path("message")
public class MessageController {

    MessageService messageService = new MessageService();

    @GET
    @Path("/x")
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/j")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessagesInJsonFormat() {
        return messageService.getAllMessages();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessages(Message message) {
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message editMessage(@PathParam("messageId") long id, Message message) {
        message.setId(id);
        return messageService.editMessage(message);
    }

    @DELETE
    @Path("delete/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteMessage(@PathParam("messageId") long id) {
        return messageService.deleteMessage(id);
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long id) {
        return messageService.deleteMessage(id);
    }

}