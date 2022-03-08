package apsj.ws.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import apsj.ws.classes.SessionService;
import classes.Session;
import rest.todo.dao.TodoDao;



@Path("/sessions")
public class SessionsRessources {

	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertSession(Session Session) {
        SessionService a= new SessionService();
    	Boolean result = a.insertSession(Session);
        return result.toString();
    }
    
    
    @PATCH
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateSession(Session Session) {
        SessionService a= new SessionService();
    	Boolean result = a.updateSession(Session);
        return result.toString();
    }
    
    
    //Deletes a a specific Session 
    @GET
    @Path("/id/{id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteSession(@PathParam("id") Integer id) {
        Boolean result;
    	SessionService a= new SessionService();
    	result = a.deleteSession(id);
        if (result.equals(true)) {
        	return "L'Session "+ id.toString()+ " a bien été supprimé";
        }
        else {
        	return "L'Session "+ id.toString()+ " n'a pas été supprimé";
        }
    }   
    
 // Return the list of Sessions to the user in the browser in JSON format
    @GET
    @Produces({MediaType.APPLICATION_JSON })
    public String getSessions() {
        List<Session> todos = new ArrayList<Session>();
        SessionService a= new SessionService();
        todos = a.viewSession();
        String json = "[";
        Gson gson = new Gson();
        for(int i=0;i<todos.size();i++) {
        	if(i!=(todos.size()-1)) {
        		json+= gson.toJson(todos.get(i).toMap())+",";
        	}
        	else {
        		json+= gson.toJson(todos.get(i).toMap());
        	}
        }
        return json+"]";
    }
    
    //Returns the characteristics of a specific Command 
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSessionsForAnId(@PathParam("id") Integer id) {
        Session Session = new Session();
    	SessionService a= new SessionService();
    	Session = a.viewSessionById(id);
        String result = Session.toString();
        return result;
    }   

    // returns the number of Sessions
    // Use http://localhost:8080/com.vogella.jersey.todo/rest/Sessions/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = TodoDao.instance.getModel().size();
        return "il y a " + String.valueOf(count);
    }
	
}
