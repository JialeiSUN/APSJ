package apsj.ws.resources;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.process.internal.RequestScoped;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import apsj.ws.classes.UserService;
import classes.Persone;
import classes.User;
import rest.todo.dao.TodoDao;
import rest.todo.model.Todo;
@RequestScoped
@Path("/users")
@Consumes({"application/json","application/xml"})
@Produces({"application/json","application/xml"})
public class UsersResource {
	
    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserFromEmail(@PathParam("email") String email) {
    	User user = new User();
    	UserService u = new UserService();
    	user = u.findUserByEmail(email);
    	 Gson gson = new Gson();
       	 String json = gson.toJson(user.tomap());
         return json;
    }
    
    //Returns the characteristics of a specific Article 
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getArticlesForAnId(@PathParam("id") Integer id) {
    	User user = new User();
    	UserService u = new UserService();
    	user = u.findUserById(id);
   	 Gson gson = new Gson();
   	 String json = gson.toJson(user.tomap());
       return json;
    }
    
    @POST
    @Path("/signup")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addUser( User user)
             {  
    	Gson gson = new Gson();
      	String json = gson.toJson(user.tomap());
        return json; 
        }
    
    @POST
    @Path("/test")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String testPersone(Persone persone) {
    	String response = "hello" + persone.getNom() + " " + persone.getPrenom();
    	System.out.println(response);
    	return response;
    }


    
}
