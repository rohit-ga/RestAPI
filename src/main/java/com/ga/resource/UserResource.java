package com.ga.resource;

import java.net.URI;
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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.ga.model.User;
import com.ga.service.UserService;

@Path("user")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    UserService userService;

    public UserResource() {
        userService = new UserService();
    }
    
ClientConfig config = new ClientConfig();
Client client = ClientBuilder.newClient(config);

WebTarget target = client.target(getBaseURI());

WebTarget response = target.path("rest");

private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:9091/RestJerseyAPI/").build();
}

    @POST
    public String registerUser(User user) {
//      registration for new user
        return userService.registerUser(user);
    }

    @POST
    @Path("login")
    public String loginUser(User user) {
//      to login
        return userService.loginUser(user.getEmail(), user.getPassword());
    }

    @GET
    @Path("list")
    public List<User> getAllUser() {
//      get list of users
        return userService.getAllUser();
    }

    @GET
    @Path("{userID}")
    public User getUserById(@PathParam("userID") int id) {
//      pass id and get user's details
        return userService.getUserById(id);
    }

    @DELETE
    @Path("delete/{userID}")
    public String deleteUserById(@QueryParam("userID") int id) {
//        pass id and delete user
        return userService.deleteUserById(id);
    }

    @POST
    @Path("update/{userID}")
    public String updateUser(@PathParam("userID") int id, User user) {
//        update user's general details
        return userService.updateUser(id, user);
    }

    @POST
    @Path("add")
    @Consumes("application/x-www-form-urlencoded")
    public String addUser(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
            @FormParam("contact") String contact, @FormParam("email") String email,
            @FormParam("password") String password) {
//        pass user's details by html page and save in DB
        return userService.addUser(firstName, lastName, contact, email, password);

    }

    @GET
    @Path("query")
    public User getUserDetails(@QueryParam("email") String email) {
//        pass user's email and get required details of the user
        return userService.getUserDetails(email);
    }

}