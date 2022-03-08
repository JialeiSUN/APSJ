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

import apsj.ws.classes.CommandeService;
import classes.Commande;
import rest.todo.dao.TodoDao;

@Path("/commandes")
public class CommandesRessources {

	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    
    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertCommande(Commande Commande) {
        CommandeService a= new CommandeService();
    	Boolean result = a.insertCommande(Commande);
        return result.toString();
    }
    
    
    @PATCH
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCommande(Commande Commande) {
        CommandeService a= new CommandeService();
    	Boolean result = a.updateCommande(Commande);
        return result.toString();
    }
    
    
    //Deletes a a specific Commande 
    @GET
    @Path("/id/{id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCommande(@PathParam("id") Integer id) {
        Boolean result;
    	CommandeService a= new CommandeService();
    	result = a.deleteCommande(id);
        if (result.equals(true)) {
        	return "L'Commande "+ id.toString()+ " a bien été supprimé";
        }
        else {
        	return "L'Commande "+ id.toString()+ " n'a pas été supprimé";
        }
    }   
    
 // Return the list of Commandes to the user in the browser in JSON format
    @GET
    @Produces({MediaType.APPLICATION_JSON })
    public String getCommandes() {
        List<Commande> todos = new ArrayList<Commande>();
        CommandeService a= new CommandeService();
        todos = a.viewCommande();
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
    public String getCommandesForAnId(@PathParam("id") Integer id) {
        Commande Commande = new Commande();
    	CommandeService a= new CommandeService();
    	Commande = a.viewCommandeById(id);
        String result = Commande.toString();
        return result;
    }   

    // returns the number of Commandes
    // Use http://localhost:8080/com.vogella.jersey.todo/rest/Commandes/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = TodoDao.instance.getModel().size();
        return "il y a " + String.valueOf(count);
    }
}
