package apsj.ws.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Session;
import classes.Session;
import classes.Categorie;
import classes.Connexion;
import classes.Session;

public class SessionService implements SessionServiceRemote{

	private Connexion sqlconnexion;
	public SessionService() {
		sqlconnexion = new Connexion();		
	}
	
	@Override
	public boolean insertSession(Session Session) {
		String id = String.valueOf(Session.getId());
		String ref = String.valueOf(Session.getREF_User());
		String total=String.valueOf(Session.getTotal());
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
            String query = "select * from Session";
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
	public boolean updateSession(Session Session) {
		String id=String.valueOf(Session.getId());
		String ref=String.valueOf(Session.getREF_User());
		String total=String.valueOf(Session.getTotal());
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
            String query = "select * from Session where Id_Session = "+ id;
            //Executing the query
            ResultSet rs = s.executeQuery(query);
            rs.beforeFirst();
            //Updating the values of the Session
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
	public ArrayList<Session> viewSession() {
		ArrayList<Session> result= new ArrayList<Session>();
		String sql = "select * from Session";
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
					Session a = new Session(rs.getInt(1),rs.getInt(2),rs.getFloat(3)); 
			        result.add(a);
		    }
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result;
	}

	@Override
	public boolean deleteSession(Integer id) {
		String sql = "select * from Session where Id_Session = "+ id.toString();
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
	public Session viewSessionById(Integer id) {
		Session result = new Session();
		String sql = "select * from Session where Id_Session = "+ id.toString();
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
				result= new Session(rs.getInt(1),rs.getInt(2),rs.getFloat(3)); 
			}
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
        return result;
	}

	@Override
	public int countSession() {
		String sql = "select count * from Session";
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
