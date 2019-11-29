package com.springbok.priorities.authorization;

import com.springbok.priorities.daofactory.DaoFactory;

public class Authorizer {
  
  public static Integer getAuthorizationCode(String email, String password) {
    return DaoFactory.getUserDao().getUserID(email, password);
  }

  public static boolean checkAuthorization(Integer authCode) {
    return true;
  }
}