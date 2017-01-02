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

import com.ga.model.User;
import com.ga.service.UserService;

@Path("user")
public class UserController {

    UserService userService = new UserService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String registerUser(User user) {

        return userService.registerUser(user);
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String loginUser(User user) {

        return userService.loginUser(user.getEmail(), user.getPassword());
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUser() {

        return userService.getAllUser();
    }
    
    @GET
    @Path("/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public User checkUserToUpdate(@PathParam("userID") int id) {

        return userService.checkUserToUpdate(id);
    }
    
    @DELETE
    @Path("delete/{userID}")
    @Produces(MediaType.TEXT_PLAIN)
    public String checkUserToDelete(@PathParam("userID") int id){

        return userService.checkUserToDelete(id);
    }
    
    @POST
    @Path("update/{userID}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateUser(@PathParam("userID") int id,User user){

        return userService.updateUser(id,user);
    }
    
}