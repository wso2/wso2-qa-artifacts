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
package com.wso2.qa.rest.h2;

import com.wso2.qa.rest.domain.Employees;

import java.sql.*;

public class H2Connector {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    // Add Employee
    public Boolean addEmployee(Employees employee) throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            String query = "INSERT INTO EMPLOYEE(id, fname, lname, salary, status)" +
                    " VALUES (" + employee.getEmployeeId() + "," +
                    "\'" + employee.getFirstName() + "\'," +
                    "\'" + employee.getLastName() + "\'," +
                    "" + employee.getSalary() + "," +
                    "\'" + employee.getStatus() + "\')";
            stmt.execute(query);

            stmt.close();
            connection.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            connection.close();
        }
    }

    // Get Employee
    public Employees getEmployee(int empId) throws SQLException {
        Connection connection = getDBConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("select * from EMPLOYEE where id = " + empId);
            ResultSet set = statement.executeQuery();

            Employees employee = new Employees();

            while (set.next()) {
                employee.setEmployeeId(set.getInt("id"));
                employee.setFirstName(set.getString("fname"));
                employee.setLastName(set.getString("lname"));
                employee.setSalary(set.getDouble("salary"));
                employee.setStatus(set.getString("status"));
            }
            statement.close();
            connection.commit();
            return employee;
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            connection.close();
        }
    }

    // Update Employee
    public Boolean updateEmployee(Employees employee) throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            String query = "UPDATE EMPLOYEE SET " +
                    "fname=\'" + employee.getFirstName() + "\'," +
                    "lname=\'" + employee.getLastName() + "\'," +
                    "salary=" + employee.getSalary() + "," +
                    "status=\'" + employee.getStatus() + "\'" +
                    "WHERE id = " + employee.getEmployeeId();
            stmt.execute(query);

            stmt.close();
            connection.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            connection.close();
        }
    }

    // Delete Employee
    public Boolean deleteEmployee(int employeeId) throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            String query = "DELETE FROM EMPLOYEE WHERE id = " + employeeId;
            stmt.execute(query);

            stmt.close();
            connection.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            connection.close();
        }
    }

    public void createTable() throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE EMPLOYEE(id int primary key, fname varchar(255), lname varchar(255), salary DOUBLE, status varchar(255))");
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    // This method will probably go unused.
    public void dropTable() throws SQLException {
        Connection connection = getDBConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("DROP TABLE EMPLOYEE");
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }


    // Create Database Connection
    public Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
