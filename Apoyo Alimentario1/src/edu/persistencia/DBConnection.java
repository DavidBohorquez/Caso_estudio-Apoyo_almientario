package edu.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection connection;

	public DBConnection() {
		connection = null;
	}

	/*
	 * public Connection conectarDB() { try {
	 * 
	 * Class.forName("oracle.jdbc.driver.OracleDriver");
	 * 
	 * } catch (ClassNotFoundException e) { e.printStackTrace(); }
	 * 
	 * try { System.out.println("DB_CONNECTION"); connection =
	 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
	 * "consulta_resultados", "user123");
	 * 
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * if (connection != null) {
	 * System.out.println("Successfullly connected to Oracle DB"); } else {
	 * System.out.println("Failed to connect to Oracle DB"); }
	 * 
	 * return connection; }
	 */

	public void close() {
		try {
			connection.close();
		} catch (SQLException localSQLException) {
		}
	}

	public Connection conectarDBUser(String user, String pass) {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", user, pass);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("Successfullly connected to Oracle DB");
		} else {
			System.out.println("Failed to connect to Oracle DB");
		}

		System.out.println("return connection");

		return connection;
	}

	public void setConnection(Connection cn) {
		connection = cn;
	}

}
