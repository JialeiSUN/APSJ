package apsj.ws.classes;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

import classes.Session;

public interface SessionServiceRemote {

	@WebMethod(action="urn:insert",operationName="insertSession")
	public @WebResult(name="insertResponse")
		boolean insertSession(@WebParam(name="Session")
									Session Session);
	
	@WebMethod(action="urn:update",operationName="UpdateSession")
	public @WebResult(name="updateResponse")
		boolean updateSession(@WebParam(name="Session")
										Session Session);
	
	@WebMethod(action="urn:view",operationName="ViewSession")
	public @WebResult(name="viewResponse")
		ArrayList<Session> viewSession(); 
	
	@WebMethod(action="urn:delete",operationName="DeleteSession")
	public @WebResult(name="viewResponse")
		boolean deleteSession(@WebParam(name="SessionId")
										Integer id); 

	
	@WebMethod(action="urn:",operationName="DeleteSession")
	public @WebResult(name="viewResponse")
		Session viewSessionById(@WebParam(name="SessionId")
										Integer id); 
	
	
	@WebMethod(action="urn:",operationName="CountSession")
	public @WebResult(name="viewResponse")
		int countSession();
	
	
}
