package apsj.ws.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import apsj.ws.classes.UserService;
import classes.User;

@Path("/users")
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
}
