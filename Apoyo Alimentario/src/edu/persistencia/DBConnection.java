package edu.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	protected Connection connection;
	
	public DBConnection() {
		connection = null;
	}
	
	public Connection conectarDB() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:" + "xe", "system", "blueplayer10");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		if (connection != null) {
			System.out.println("nSuccessfullly connected to Oracle DB");
		} else {
			System.out.println("nFailed to connect to Oracle DB");
		}
		
		return connection;
	}
	
	/*public static void main() {
		System.out.println("RUN!!!!!!!!!!!!!!!!!!");
		new DBConnection().conectarDB();
	}*/

}
