package com.springbok.priorities.command.daofactory;

import com.springbok.priorities.command.mongodao.MongoPriorityDao;
import com.springbok.priorities.command.mongodao.MongoTaskDao;
import com.springbok.priorities.command.mongodao.MongoUserDao;
import com.springbok.priorities.sqldao.SQLPriorityDao;
import com.springbok.priorities.sqldao.SQLTaskDao;
import com.springbok.priorities.sqldao.SQLUserDao;

public class DaoFactory {
    public static String DAOTYPE = "noSQL";

    public static PriorityDaoInterface getPriorityDao() {
        if (DAOTYPE.equals("noSQL")) {
            return new MongoPriorityDao();
        } else {
            return new SQLPriorityDao();
        }
    }

    public static UserDaoInterface getUserDao() {
        if (DAOTYPE.equals("noSQL")) {
            return new MongoUserDao();
        } else {
            return new SQLUserDao();
        }
    }

    public static TaskDaoInterface getTaskDao() {
        if (DAOTYPE.equals("noSQL")) {
            return new MongoTaskDao();
        } else {
            return new SQLTaskDao();
        }
    }
}