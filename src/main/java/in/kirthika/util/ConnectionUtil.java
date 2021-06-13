package in.kirthika.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	private ConnectionUtil() {
		// Default constructor
	}

	/**
	 * This method creates a database connection.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static String driverClass = System.getenv("spring.datasource.driver-class-name");
	private static String url = System.getenv("spring.datasource.url");
	private static String username = System.getenv("spring.datasource.username");
	private static String password = System.getenv("spring.datasource.password");

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName(driverClass);

		return DriverManager.getConnection(url, username, password);
	}

	public static void close(Statement statement, Connection con) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
