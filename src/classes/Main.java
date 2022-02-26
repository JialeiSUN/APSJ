package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
public class Main {

	public static void main(String[] args) {
		Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://20.107.32.158:3306/apsj";
            String username = "test2";
            String ps = "sun1234";
            try {
				conn = DriverManager.getConnection(url,username,ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
            if (conn!= null) {
                System.out.println("sucess");
               String sql = "select * from Article";
               java.sql.Statement s = null;
			try {
				s = conn.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
               try {
				ResultSet rs= s.executeQuery(sql);
				int i=1;
				while (rs.next()) {
	                System.out.println(rs.getString(3));
	                i++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
            }
            else {
                System.out.println("error");
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	}
