package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public static Connection CONN;

	/**
	 * Setup connection to database
	 */
	public static void connectToDatabase() {
		try {
			CONN = DriverManager.getConnection(
					"jdbc:mysql://localhost/contacts", "root", "890612lcy");
			System.out.println("Connection successfully established");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
//			System.err.println("Connection Error");
		}
	}

	/**
	 * Close database connection 
	 */
	public static void closeConn() {
		try {
			if (CONN != null) {
				CONN.close();
			}
			System.out.println("Connection is closed");
		} catch (SQLException ex) {
			System.out.println("error in closing connection");
		}

	}

}
