package apsj.ws.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Commande;
import classes.Connexion;

public class CommandeService implements CommandeServiceRemote {

	
	private Connexion sqlconnexion;
	public CommandeService() {
		sqlconnexion = new Connexion();		
	}
	
	@Override
	public boolean insertCommande(Commande Commande) {
		String id = String.valueOf(Commande.getId());
		String ref = String.valueOf(Commande.getREF_User());
		String total=String.valueOf(Commande.getTotal());
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
            String query = "select * from Commande";
            //Executing the query
            ResultSet rs = s.executeQuery(query);
            rs.beforeFirst();
            rs.moveToInsertRow();
            rs.updateString(1, id);
            rs.updateString(2, ref);
            rs.updateString(3, total);
            //Deleting a column from the ResultSet object
            rs.insertRow();        
        	return true;
        }
        catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCommande(Commande Commande) {
		String id = String.valueOf(Commande.getId());
		String ref = String.valueOf(Commande.getREF_User());
		String total=String.valueOf(Commande.getTotal());
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
            String query = "select * from Commande where id_commande = "+ id;
            //Executing the query
            ResultSet rs = s.executeQuery(query);
            rs.beforeFirst();
            //Updating the values of the Commande
            while(rs.next()){
                rs.updateString(2, ref);
                rs.updateString(3, total);
               rs.updateRow();
            };
            return true;
        }
        catch (SQLException e) {
			e.printStackTrace();
			return false;
		}  
	}

	@Override
	public ArrayList<Commande> viewCommande() {
		ArrayList<Commande> result= new ArrayList<Commande>();
		String sql = "select * from Commande";
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
					Commande a = new Commande(rs.getInt(1),rs.getInt(2),rs.getInt(3)); 
			        result.add(a);
		    }
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result;		
	}

	@Override
	public boolean deleteCommande(Integer id) {
		String sql = "select * from Commande where id_commande = "+ id.toString();
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

	@Override
	public Commande viewCommandeById(Integer id) {
		Commande result = new Commande();
		String sql = "select * from Commande where id_commande = "+ id.toString();
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
				result= new Commande(rs.getInt(1),rs.getInt(2),rs.getInt(3)); 
			}
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result;
	}

	@Override
	public int countCommande() {
		String sql = "select count * from Commande";
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
}
