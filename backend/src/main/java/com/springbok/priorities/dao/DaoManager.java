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


  public static String createObject(String sql) throws SQLException {
    String id = "";
    Connection conn = DaoManager.getConnection();
    Statement stmt = conn.createStatement();
    stmt.execute(sql);
    ResultSet resultSet = stmt.getGeneratedKeys();
    if (resultSet.next()) {
        id = resultSet.getString(0);
    }

    DaoManager.closeConnection(conn);
    return id;
  }

  public static Object getObject(String sql) throws SQLException {
    return null;
  }
}