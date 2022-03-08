package apsj.ws.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Connexion;
import classes.Panier;

public class PanierService implements PanierServiceRemote {

	private Connexion sqlconnexion;
	public PanierService() {
		sqlconnexion = new Connexion();		
	}
	
	@Override
	public boolean insertPanier(Panier Panier) {
		String id = String.valueOf(Panier.getId());
		String ref_s = String.valueOf(Panier.getREF_Session());
		String ref_a=String.valueOf(Panier.getREF_Article());
		String qte=String.valueOf(Panier.getQuantite());

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
            String query = "select * from Panier";
            //Executing the query
            ResultSet rs = s.executeQuery(query);
            rs.beforeFirst();
            rs.moveToInsertRow();
            rs.updateString(1, id);
            rs.updateString(2, ref_s);
            rs.updateString(3, ref_a);
            rs.updateString(4, qte);
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
	public boolean updatePanier(Panier Panier) {
		String id = String.valueOf(Panier.getId());
		String ref_s = String.valueOf(Panier.getREF_Session());
		String ref_a=String.valueOf(Panier.getREF_Article());
		String qte=String.valueOf(Panier.getQuantite());
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
            String query = "select * from Panier where id_panier = "+ id;
            //Executing the query
            ResultSet rs = s.executeQuery(query);
            rs.beforeFirst();
            //Updating the values of the Panier
            while(rs.next()){
                rs.updateString(2, ref_s);
                rs.updateString(3, ref_a);
                rs.updateString(4, qte);
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
	public ArrayList<Panier> viewPanier() {
		ArrayList<Panier> result= new ArrayList<Panier>();
		String sql = "select * from Panier";
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
					Panier a = new Panier(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)); 
			        result.add(a);
		    }
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result;		
	}

	@Override
	public boolean deletePanier(Integer id) {
		String sql = "select * from Panier where id_panier = "+ id.toString();
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
	public Panier viewPanierById(Integer id) {
		Panier result = new Panier();
		String sql = "select * from Panier where id_panier = "+ id.toString();
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
				result= new Panier(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)); 
			}
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result;
	}

	@Override
	public int countPanier() {
		String sql = "select count * from Panier";
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
		return 0;
	}

}
