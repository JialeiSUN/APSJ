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
	
	@Override
	public boolean insertArticle(Article Article) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateArticle(int id) {
		// TODO Auto-generated method stub
		return false;
	}

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
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
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
	public boolean deleteArticle(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Article> viewArticleCategorie(Categorie categorie) {
		ArrayList<Article> result= new ArrayList<Article>();
		String myCategorie= categorie.toString();
		String sql = "select * from Article where categorie = '"+ myCategorie+ "'";
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

}
