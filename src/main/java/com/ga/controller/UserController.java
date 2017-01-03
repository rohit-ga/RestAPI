package com.ga.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ga.model.User;
import com.ga.service.UserService;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    UserService userService;

    public UserController() {
        userService = new UserService();
    }

    @POST
    public String registerUser(User user) {

        return userService.registerUser(user);
    }

    @POST
    @Path("login")
    public String loginUser(User user) {

        return userService.loginUser(user.getEmail(), user.getPassword());
    }

    @GET
    @Path("list")
    public List<User> getAllUser() {

        return userService.getAllUser();
    }

    @GET
    @Path("{userID}")
    public User getUserById(@PathParam("userID") int id) {

        return userService.getUserById(id);
    }

    @DELETE
    @Path("delete/{userID}")
    public String deleteUserById(@QueryParam("userID") int id) {

        return userService.deleteUserById(id);
    }

    @POST
    @Path("update/{userID}")
    public String updateUser(@PathParam("userID") int id, User user) {

        return userService.updateUser(id, user);
    }

    @POST
    @Path("add")
    public String addUser(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
            @FormParam("contact") String contact, @FormParam("email") String email,
            @FormParam("password") String password) {
System.out.println("Controller formparam");
        return userService.addUser(firstName, lastName, contact, email, password);

    }

    @GET
    @Path("query")
    public User getUserDetails(@QueryParam("email") String email) {

        return userService.getUserDetails(email);
    }
    
    @GET
    @Path("/home")
    public String home() {

        return "adduser.html";
    }
    
}