package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://database-21.cgsyjtny2rf9.us-east-2.rds.amazonaws.com/WorldApp";
    public static final String USER = "admin";
    public static final String PASS = "admin123";
    
    public static Connection getConnection()
    {
      try {
          return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }
}