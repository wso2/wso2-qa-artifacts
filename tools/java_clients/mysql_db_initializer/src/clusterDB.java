/*
 * Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class clusterDB {

    // Database URL and script file name
    static final String dbUrl = "localhost";
    static String scriptFilePath = "script.sql";
    
    //  Database credentials
    static final String username = "root";
    static final String passWd = "wso2";
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    

    public static void main(String[] args) {
        mysqlDbInitializer(dbUrl,username,passWd);
    }

    public static void mysqlDbInitializer(String dbURL,String username,String passWd){
        Connection conn = null;
        String dbUrl = "jdbc:mysql://"+dbURL+"/";
        try{
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(dbUrl, username, passWd);
            ScriptRunner runner = new ScriptRunner(conn, false, true);
            runner.runScript(new BufferedReader(new FileReader(scriptFilePath)));

            System.out.println("Databases created successfully!!!");
        }catch(SQLException e){
            //Handle errors for JDBC
            e.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
