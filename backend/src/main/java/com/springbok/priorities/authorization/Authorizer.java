package com.springbok.priorities.authorization;

import com.springbok.priorities.dao.UserDao;

public class Authorizer {
  
  public static Integer getAuthorizationCode(String email, String password) {
    return UserDao.getUserID(email, password);
  }

  public static boolean checkAuthorization(Integer authCode) {
    return true;
  }
}