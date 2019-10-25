package com.springbok.priorities.dao;

import java.sql.*;

public class DaoManager {

  public static Connection getConnection() throws SQLException {
    Connection conn = null; 
    String url = "jdbc:mysql://localhost:3306/priorities";
    String user = "root";
    String password = "root";

    conn = DriverManager.getConnection(url, user, password);
    conn.setAutoCommit(false);
    return conn;
  }

  public static boolean closeConnection(Connection conn) throws SQLException {
      if (conn != null) {
        conn.close();
        return true;
      }
      return false;
    }
}