package apsj.ws.classes;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import classes.Commande;
import classes.Categorie;
import classes.Commande;

@WebService(name="Commande",targetNamespace="http://apsj.ws.classes/commande")
public interface CommandeServiceRemote {

	@WebMethod(action="urn:insert",operationName="insertCommande")
	public @WebResult(name="insertResponse")
		boolean insertCommande(@WebParam(name="Commande")
									Commande Commande);
	
	@WebMethod(action="urn:update",operationName="UpdateCommande")
	public @WebResult(name="updateResponse")
		boolean updateCommande(@WebParam(name="Commande")
										Commande Commande);
	
	@WebMethod(action="urn:view",operationName="ViewCommande")
	public @WebResult(name="viewResponse")
		ArrayList<Commande> viewCommande(); 
	
	@WebMethod(action="urn:delete",operationName="DeleteCommande")
	public @WebResult(name="viewResponse")
		boolean deleteCommande(@WebParam(name="CommandeId")
										Integer id); 

	
	@WebMethod(action="urn:",operationName="DeleteCommande")
	public @WebResult(name="viewResponse")
		Commande viewCommandeById(@WebParam(name="CommandeId")
										Integer id); 
	
	
	@WebMethod(action="urn:",operationName="CountCommande")
	public @WebResult(name="viewResponse")
		int countCommande();

	
}
