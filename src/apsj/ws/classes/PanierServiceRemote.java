package apsj.ws.classes;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

import classes.Panier;

public interface PanierServiceRemote {

	@WebMethod(action="urn:insert",operationName="insertPanier")
	public @WebResult(name="insertResponse")
		boolean insertPanier(@WebParam(name="Panier")
									Panier Panier);
	
	@WebMethod(action="urn:update",operationName="UpdatePanier")
	public @WebResult(name="updateResponse")
		boolean updatePanier(@WebParam(name="Panier")
										Panier Panier);
	
	@WebMethod(action="urn:view",operationName="ViewPanier")
	public @WebResult(name="viewResponse")
		ArrayList<Panier> viewPanier(); 
	
	@WebMethod(action="urn:delete",operationName="DeletePanier")
	public @WebResult(name="viewResponse")
		boolean deletePanier(@WebParam(name="PanierId")
										Integer id); 

	
	@WebMethod(action="urn:",operationName="DeletePanier")
	public @WebResult(name="viewResponse")
		Panier viewPanierById(@WebParam(name="PanierId")
										Integer id); 
	
	
	@WebMethod(action="urn:",operationName="CountPanier")
	public @WebResult(name="viewResponse")
		int countPanier();
}
