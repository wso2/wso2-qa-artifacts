package org.wso2.qa.mb;/*
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

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length == 4) {

                String hostname = args[0];
                String port = args[1];
                String username = args[2];
                String password = args[3];

                    System.out.println("######################################################");
                    System.out.println("connection details : " + hostname + ":" + port);
                    System.out.println("######################################################");

                    TempQueueSubscriber subscriber = new TempQueueSubscriber();
                    subscriber.receiveMessages(hostname,port,username,password);

            }else{
                System.out.println("Missing arguements hence Executing with default Parameters!!!");
                TempQueueSubscriber subscriber = new TempQueueSubscriber();
                subscriber.receiveMessages("localhost","5672","admin","admin");
            }
        } catch (Exception ex) {
            System.out.println("Error executing client : " + ex);
            System.out.println("Example Usage : ");
            System.out.println("java -jar target/MBTempQSubscriber.jar <IP> <PORT> <USERNAME> <PASSWORD>");
        }
    }
}