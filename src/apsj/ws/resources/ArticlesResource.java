 package apsj.ws.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import javax.ws.rs.core.UriInfo;

import apsj.ws.classes.ArticleService;
import classes.Article;
import classes.Categorie;
import rest.todo.dao.TodoDao;
import rest.todo.model.Todo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/// Will map the resource to the URL articles
@Path("/articles")
 public class ArticlesResource {

	
	private String categorie;
	
	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of articles to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Article> getTodosBrowser() {
        List<Article> todos = new ArrayList<Article>();
        //todos.addAll(TodoDao.instance.getModel().values());
        return todos;
    }
    
    
    //Deletes a a specific article 
    @GET
    @Path("/id/{id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteArticle(@PathParam("id") Integer id) {
        Boolean result;
    	ArticleService a= new ArticleService();
    	result = a.deleteArticle(id);
        if (result.equals(true)) {
        	return "L'article "+ id.toString()+ " a bien été supprimé";
        }
        else {
        	return "L'article "+ id.toString()+ " n'a pas été supprimé";
        }
    }   
    
 // Return the list of articles to the user in the browser in JSON format
    @GET
    @Produces({MediaType.APPLICATION_JSON })
    public String getArticles() {
        List<Article> todos = new ArrayList<Article>();
        ArticleService a= new ArticleService();
        todos = a.viewArticle();
        String result ="";
        for(int i=0;i<todos.size();i++) {
        	result+=todos.get(i).toString();
        }
        return result;
    }
    
  //Returns the list of articles for a specific category
    @GET
    @Path("/{categorie}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getArticlesForACategory(@PathParam("categorie") Categorie categorie) {
    	List<Article> todos = new ArrayList<Article>();
        ArticleService a= new ArticleService();
        todos = a.viewArticleCategorie(categorie);
        String result ="";
        for(int i=0;i<todos.size();i++) {
        	result+=todos.get(i).toString();
        }
        return result;
    }
    
    //Returns the characteristics of a specific Article 
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getArticlesForAnId(@PathParam("id") Integer id) {
        Article article = new Article();
    	ArticleService a= new ArticleService();
    	article = a.viewArticleById(id);
        String result = article.toString();
        return result;
    }   

    // returns the number of articles
    // Use http://localhost:8080/com.vogella.jersey.todo/rest/articles/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = TodoDao.instance.getModel().size();
        return "il y a " + String.valueOf(count);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newTodo(@FormParam("id") String id,
            @FormParam("summary") String summary,
            @FormParam("description") String description,
            @Context HttpServletResponse servletResponse) throws IOException {
        Todo todo = new Todo(id, summary);
        if (description != null) {
            todo.setDescription(description);
        }
        TodoDao.instance.getModel().put(id, todo);

        servletResponse.sendRedirect("../create_todo.html");
    }

    // Defines that the next path parameter after todos is
    // treated as a parameter and passed to the TodoResources
    // Allows to type http://localhost:8080/rest.todo/rest/todos/1
    // 1 will be treaded as parameter todo and passed to TodoResource
    @Path("{todo}")
    public TodoResource getTodo(@PathParam("todo") String id) {
        return new TodoResource(uriInfo, request, id);
    }
}
