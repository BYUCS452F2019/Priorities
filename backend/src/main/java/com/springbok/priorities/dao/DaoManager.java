package com.springbok.priorities.dao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.List;

import com.springbok.priorities.models.DBTable;

import java.util.ArrayList;

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
    stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
    ResultSet resultSet = stmt.getGeneratedKeys();
    if (resultSet.next()) {
      id = resultSet.getString(0);
    }
    conn.commit();

    DaoManager.closeConnection(conn);
    return id;
  }

  public static <T> T getObject(Class<T> type, String sql) throws Exception {
    List<T> list = DaoManager.getObjects(type, sql);
    return list.get(0);
  }

  public static <T> List<T> getObjects(Class<T> type, String sql) throws Exception {
    List<T> list = new ArrayList<T>();
    Connection conn = DaoManager.getConnection();
    Statement stmt = conn.createStatement();
    ResultSet result = stmt.executeQuery(sql);
    while (result.next()) {
      T t = type.getDeclaredConstructor().newInstance();
      loadResultSetIntoObject(result, t);// Point 4
      list.add(t);
    }
    conn.commit();
    DaoManager.closeConnection(conn);
    return list;
  }

  private static void loadResultSetIntoObject(ResultSet resultSet, Object object) throws Exception {
    Class<?> zclass = object.getClass();
    for (Field field : zclass.getDeclaredFields()) {
      field.setAccessible(true);
      DBTable column = field.getAnnotation(DBTable.class);
      Object value = resultSet.getObject(column.columnName());
      Class<?> type = field.getType();
      if (isPrimitive(type)) {// check primitive type(Point 5)
        Class<?> boxed = boxPrimitiveClass(type);// box if primitive(Point 6)
        value = boxed.cast(value);
      }
      field.set(object, value);
    }
  }

  private static boolean isPrimitive(Class<?> type) {
    return (type == int.class || type == long.class || type == double.class || type == float.class
        || type == boolean.class || type == byte.class || type == char.class || type == short.class);
  }

  private static Class<?> boxPrimitiveClass(Class<?> type) {
    if (type == int.class) {
      return Integer.class;
    } else if (type == long.class) {
      return Long.class;
    } else if (type == double.class) {
      return Double.class;
    } else if (type == float.class) {
      return Float.class;
    } else if (type == boolean.class) {
      return Boolean.class;
    } else if (type == byte.class) {
      return Byte.class;
    } else if (type == char.class) {
      return Character.class;
    } else if (type == short.class) {
      return Short.class;
    } else {
      String string = "class '" + type.getName() + "' is not a primitive";
      throw new IllegalArgumentException(string);
    }
  }

  public static String getObjectID(String sql) throws SQLException {
    String id = "";
    Connection conn = DaoManager.getConnection();
    Statement stmt = conn.createStatement();
    stmt.execute(sql);
    ResultSet result = stmt.executeQuery(sql);
    while (result.next()) {
      id = result.getString(0);
    }
    conn.commit();
    DaoManager.closeConnection(conn);
    return id;
  }
}