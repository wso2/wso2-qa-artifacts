package org.wso2.mb.qa.performance;/*
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Properties;

public class Util {

    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";
    Properties prop = new Properties();
    InputStream input = null;

    public String getTCPConnectionURL(String host, String port, String username, String password) {
        return new StringBuffer()
                .append("amqp://").append(username).append(":").append(password)
                .append("@").append(CARBON_CLIENT_ID)
                .append("/").append(CARBON_VIRTUAL_HOST_NAME)
                .append("?brokerlist='tcp://").append(host).append(":").append(port).append("'")
                .toString();
    }

    public String getCurrentTimeStamp() {
        java.util.Date date = new java.util.Date();
        return new Timestamp(date.getTime()).toString();
    }

    public String getProperty(String key) throws IOException {
        String property;
        try {
            input = new FileInputStream("mbsimpleclient.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            property = prop.getProperty(key);

            return property;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

    }
}