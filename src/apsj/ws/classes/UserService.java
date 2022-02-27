package apsj.ws.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebService;

import classes.Connexion;
import classes.Role;
import classes.User;
@WebService(targetNamespace="http://apsj.ws.classes/user",endpointInterface="apsj.ws.classes.UserServiceRemote")
public class UserService implements UserServiceRemote {
	private Connexion sqlconnexion;
	public UserService() {
		sqlconnexion = new Connexion();		
	}
	@Override
	public boolean insertUser(User User) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		User result = new User();
		String sql = "select * from User where id_user = " + id.toString();
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
				result= new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),Role.valueOf(rs.getString(8))); 
			}
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		User result = new User();
		String sql = "select * from User where email = " + email.toString();
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
				result= new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),Role.valueOf(rs.getString(8))); 
			}
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
