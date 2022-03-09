package apsj.ws.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
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

import apsj.ws.classes.PanierService;
import classes.Panier;
import rest.todo.dao.TodoDao;


@Path("/paniers")
public class PaniersRessources {

	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertPanier(Panier Panier) {
        PanierService a= new PanierService();
    	Boolean result = a.insertPanier(Panier);
        return result.toString();
    }
    
    
    @PATCH
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePanier(Panier Panier) {
        PanierService a= new PanierService();
    	Boolean result = a.updatePanier(Panier);
        return result.toString();
    }
    
    
    //Deletes a a specific Panier 
    @DELETE
    @Path("/id/{id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String deletePanier(@PathParam("id") Integer id) {
        Boolean result;
    	PanierService a= new PanierService();
    	result = a.deletePanier(id);
        if (result.equals(true)) {
        	return "L'Panier "+ id.toString()+ " a bien été supprimé";
        }
        else {
        	return "L'Panier "+ id.toString()+ " n'a pas été supprimé";
        }
    }   
    
 // Return the list of Paniers to the user in the browser in JSON format
    @GET
    @Produces({MediaType.APPLICATION_JSON })
    public String getPaniers() {
        List<Panier> todos = new ArrayList<Panier>();
        PanierService a= new PanierService();
        todos = a.viewPanier();
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
    
    
 // Return the list of Paniers to the user in the browser in JSON format for a specific session
    @GET
    @Path("/session/{id}")
    @Produces({MediaType.APPLICATION_JSON })
    public String getPaniersBySession(@PathParam("id") Integer id) {
        List<Panier> todos = new ArrayList<Panier>();
        PanierService a= new PanierService();
        todos = a.ViewPanierBySession(id);
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
    
    //Returns the characteristics of a specific Panier 
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPaniersForAnId(@PathParam("id") Integer id) {
        Panier Panier = new Panier();
    	PanierService a= new PanierService();
    	Panier = a.viewPanierById(id);
        String result = Panier.toString();
        return result;
    }   

    // returns the number of Paniers
    // Use http://localhost:8080/com.vogella.jersey.todo/rest/Paniers/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = TodoDao.instance.getModel().size();
        return "il y a " + String.valueOf(count);
    }
	
}
