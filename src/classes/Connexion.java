package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

	public Connection conn;
	public Connexion() {
		this.conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://20.107.32.158:3306/apsj";
            String username = "test2";
            String ps = "sun1234";
            try {
				this.conn = DriverManager.getConnection(url,username,ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
            if (this.conn!= null) {
                System.out.println("sucess");
            }
            else {
                System.out.println("error");
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
}

/*String sql = "select * from Article";
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
			}*/