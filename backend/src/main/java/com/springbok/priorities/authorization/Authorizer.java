package com.springbok.priorities.authorization;

public class Authorizer {
  
  public static String getAuthorizationCode(String username, String password) {
    return "Authorized";
  }

  public static boolean checkAuthorization(String authCode) {
    return true;
  }
}