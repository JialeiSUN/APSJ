package apsj.ws.classes;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import classes.Article;
import classes.Categorie;


@WebService(name="Article",targetNamespace="http://apsj.ws.classes/article")
public interface ArticleServiceRemote {
	
	@WebMethod(action="urn:insert",operationName="insertArticle")
	public @WebResult(name="insertResponse")
		boolean insertArticle(@WebParam(name="Article")
									Article Article);
	
	@WebMethod(action="urn:update",operationName="UpdateArticle")
	public @WebResult(name="updateResponse")
		boolean updateArticle(@WebParam(name="ArticleId")
										Integer id);
	
	@WebMethod(action="urn:view",operationName="ViewArticle")
	public @WebResult(name="viewResponse")
		ArrayList<Article> viewArticle(); 
	
	@WebMethod(action="urn:delete",operationName="DeleteArticle")
	public @WebResult(name="viewResponse")
		boolean deleteArticle(@WebParam(name="ArticleId")
										Integer id); 
	
	@WebMethod(action="urn:",operationName="DeleteArticle")
	public @WebResult(name="viewResponse")
		ArrayList<Article> viewArticleCategorie(@WebParam(name="ArticleCategorie")
										Categorie categorie); 
	
	@WebMethod(action="urn:",operationName="DeleteArticle")
	public @WebResult(name="viewResponse")
		Article viewArticleById(@WebParam(name="ArticleId")
										Integer id); 
	
	
	@WebMethod(action="urn:",operationName="CountArticle")
	public @WebResult(name="viewResponse")
		int countArticle();
	
	@WebMethod(action="urn:",operationName="CountArticle")
	public @WebResult(name="viewResponse")
		int countArticleCategorie(@WebParam(name="ArticleCategorie") Categorie categorie);

}
