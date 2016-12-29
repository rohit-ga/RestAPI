package com.ga.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class TestController {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String printMessage() {
        return "This is the method from printMessage():- ";
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String sendMessage() {
        return "This is the message from sendMessage():- ";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String putMessage(){
        return "This is the message from putMessage():- ";
    }

}