package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	private static Connection connection = null;
	
	private ConnectionManager() {

	}

	public static Connection getConnection() {
		if (connection == null) {
			System.out.println("\nCreating a new connection...\n");
			connection = makeConnection();
		}
		return connection;
	}
	
	private static Connection makeConnection() {
		Properties prop = new Properties();
		String file = "mysql.config";
		try {
			
			FileInputStream infile = new FileInputStream(file);
			prop.load(infile);
			return DriverManager.getConnection(prop.getProperty("db.url"),
											   prop.getProperty("db.user"),
											   prop.getProperty("db.pass"));
	    } catch (SQLException ex) {
	    	throw new RuntimeException("Error connecting to the database", ex);
	    } catch (FileNotFoundException ex) {
	    	throw new RuntimeException("The configuration file was not found", ex);
	    } catch (IOException ex) {
			throw new RuntimeException("Error has occurred", ex);
		}
	}
	
	public static void close() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("\nConnection Closed...\n");
			} catch (SQLException ex) {
				throw new RuntimeException("Error closing the connection", ex);
			} finally {
				connection = null;
			}
		}
	}
}
