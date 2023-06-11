package feeManagement;

import java.sql.*;

public class DBConnection {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
