package apsj.ws.classes;

import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.User;

@WebService(name="Article",targetNamespace="http://apsj.ws.classes/users")
public interface UserServiceRemote {
	
	@WebMethod(action="urn:insert",operationName="insertUser")
	public @WebResult(name="insertResponse")
		boolean insertUser(@WebParam(name="User")
									User User);
	
	@WebMethod(action="urn:update",operationName="UpdateUser")
	public @WebResult(name="updateResponse")
		boolean updateUser(@WebParam(name="UserId")
										int id);
	
	@WebMethod(action="urn:delete",operationName="DeleteUser")
	public @WebResult(name="viewResponse")
		boolean deleteUser(@WebParam(name="UserId")
										int id); 
	@WebMethod(action="urn:view",operationName="ViewUser")
	public @WebResult(name="viewResponse")
	User findUserById(@WebParam(name="UserId")
		Integer id);  
	@WebMethod(action="urn:view",operationName="ViewUser")
	public @WebResult(name="viewResponse")
	User findUserByEmail(@WebParam(name="UserEmail")
		String email);

	void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;  
}