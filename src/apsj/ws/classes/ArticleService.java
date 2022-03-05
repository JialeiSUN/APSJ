package apsj.ws.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Article;
import classes.Categorie;
import classes.Connexion;

import javax.jws.WebService;


@WebService(targetNamespace="http://apsj.ws.classes/article",endpointInterface="apsj.ws.classes.ArticleServiceRemote")
public class ArticleService implements ArticleServiceRemote {

	private Connexion sqlconnexion;
	public ArticleService() {
		sqlconnexion = new Connexion();		
	}

	//START CUD methods
	//Insert an Article in the database
	@Override
	public boolean insertArticle(Article Article) {
		String prix=String.valueOf(Article.getPrix());
		/*String sql = "insert into Article values (" + Article.getArticleId().toString() + ", "+ Article.getLibelle()+ ", "+ Article.getMarque()
		+", "+ prix + ", "+ Article.getCategorie().toString();*/
		java.sql.Statement s = null;
		try {
			Connection conn = sqlconnexion.conn;
			s= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try { 
            //Query to retrieve the contents of the employee_data table
            String query = "select * from Article";
            //Executing the query
            ResultSet rs = s.executeQuery(query);
            rs.beforeFirst();
            rs.moveToInsertRow();
            rs.updateString(1, Article.getArticleId().toString());
            rs.updateString(2, Article.getLibelle());
            rs.updateString(3, Article.getMarque());
            rs.updateString(4, prix);
            rs.updateString(5, Article.getCategorie().toString());
            //Deleting a column from the ResultSet object
            rs.insertRow();        
        	return true;
        }
        catch (SQLException e) {
			e.printStackTrace();
			return false;
		}  
	}


	//Update an existing Article
	@Override
	public boolean updateArticle(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteArticle(Integer id) {
		String sql = "select * from Article where id_a = "+ id.toString();
		java.sql.Statement s = null;
		try {
			Connection conn = sqlconnexion.conn;
			s= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try { 
        	ResultSet rs= s.executeQuery(sql);
        	rs.next();
        	rs.deleteRow();
        	return true;
        }
        catch (SQLException e) {
			e.printStackTrace();
			return false;
		}        
	}
	
	//END CUD methods
	
	
	//START Reading methods
	//return the total number of Articles stored in database
	@Override
	public int countArticle() {
		String sql = "select count * from Article";
		java.sql.Statement s = null;
		try {
			Connection conn = sqlconnexion.conn;
			s= conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try { 
        	ResultSet rs= s.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
        	return columnsNumber;
        }
        catch (SQLException e) {
			e.printStackTrace();
		}        
        return -1;
	}
	
	
	//return the total number of Articles stored in database for a specific category	
	@Override
	public int countArticleCategorie(Categorie categorie) {
		String sql = "select count * from Article where categorie = '"+ categorie.toString()+ "'";
		java.sql.Statement s = null;
		try {
			Connection conn = sqlconnexion.conn;
			s= conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try { 
        	ResultSet rs= s.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
        	return columnsNumber;
        }
        catch (SQLException e) {
			e.printStackTrace();
		}        
        return -1;
	}
	
	
	//returns the list of all Articles
	@Override
	public ArrayList<Article> viewArticle() {
		ArrayList<Article> result= new ArrayList<Article>();
		String sql = "select * from Article";
        java.sql.Statement s = null;
		try {
			Connection conn = sqlconnexion.conn;
			s= conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try {
			ResultSet rs= s.executeQuery(sql);
			while (rs.next()) {
					Article a = new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),Categorie.valueOf(rs.getString(5))); 
			        result.add(a);
		    }
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result;
    }
	
	
	//returns the list of all Articles for a specific category
	@Override
	public ArrayList<Article> viewArticleCategorie(Categorie categorie) {
		ArrayList<Article> result= new ArrayList<Article>();
		String sql = "select * from Article where categorie = '"+ categorie.toString()+ "'";
        java.sql.Statement s = null;
		try {
			Connection conn = sqlconnexion.conn;
			s= conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try {
			ResultSet rs= s.executeQuery(sql);
			while (rs.next()) {
					Article a = new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),Categorie.valueOf(rs.getString(5))); 
			        result.add(a);
		    }
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result;
	}

	@Override
	public Article viewArticleById(Integer id) {
		Article result = new Article();
		String sql = "select * from Article where id_a = "+ id.toString();
        java.sql.Statement s = null;
		try {
			Connection conn = sqlconnexion.conn;
			s= conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try {
			ResultSet rs= s.executeQuery(sql);
			while(rs.next()) {
				result= new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),Categorie.valueOf(rs.getString(5))); 
			}
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result;
	}

}
