package com.springbok.priorities.authorization;

import com.springbok.priorities.dao.UserDao;

public class Authorizer {
  
  public static String getAuthorizationCode(String username, String password) {
    String authCode = "";
    if (UserDao.getUserID(username, password) != null) {
      authCode = "IamAuthorized";
    }
    return authCode;
  }

  public static boolean checkAuthorization(String authCode) {
    if (authCode.equals("IamAuthorized")) {
      return true;
    }
    return false;
  }
}