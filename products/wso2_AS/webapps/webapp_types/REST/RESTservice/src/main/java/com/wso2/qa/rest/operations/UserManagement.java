package com.wso2.qa.rest.operations;

import com.wso2.qa.rest.h2.H2Connector;
import org.json.simple.JSONObject;

import java.util.Random;

public class UserManagement {

    H2Connector h2Connector = new H2Connector();

    public String getUsers() {
        String userList = null;
//        Connection connection = h2Connector.getDBConnection();
//        Statement getAllUsers = null;

//        try {
//            connection.setAutoCommit(false);
//
//            ResultSet resultSet = getAllUsers.executeQuery("SELECT * FROM USER_MANAGEMENT");
//            while (resultSet.next()) {
//                userList = "{"+resultSet.getString("name")+"},";
//            }
//
//            getAllUsers.close();
//            connection.commit();
//        } catch (SQLException sqlEx) {
//            sqlEx.printStackTrace();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            connection.close();
//        }
        return userList;
    }

    public Double getRandomSalary(){
        Random random = new Random();
        return random.nextDouble();
    }
}
