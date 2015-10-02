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
package org.wso2.qa.mb;

public class Main {

    public static void main(String[] args) {
        try {
            if (args[0] != null) {

                String messagingMode = args[0];
                String hostname = args[1];
                String port = args[2];
                String username = args[3];
                String password = args[4];
                String topic = args[5];

                if (messagingMode.equalsIgnoreCase("send")) {

                    String numberOfRequest = args[6];
                    String sleepTime = args[7];
                    String msgSize = args[8];

                    System.out.println("######################################################");
                    System.out.println("messaging mode :  " + messagingMode);
                    System.out.println("connection details : " + hostname + ":" + port);
                    System.out.println("topic name : " + topic);
                    System.out.println("number of requests : " + numberOfRequest);
                    System.out.println("publish frequency : " + (double) 1000 / Integer.parseInt(sleepTime));
                    System.out.println("message Size : " + msgSize);
                    System.out.println("######################################################");

                    TopicPublisher topicPublisher = new TopicPublisher();
                    topicPublisher.publishMessage(hostname, port, topic, numberOfRequest, sleepTime, msgSize);

                } else if (messagingMode.equalsIgnoreCase("receive")) {

                    String numberOfRequest = args[6];

                    System.out.println("######################################################");
                    System.out.println("messaging mode :  " + messagingMode);
                    System.out.println("connection details : " + hostname + ":" + port);
                    System.out.println("topic name : " + topic);
                    System.out.println("number of requests to consume : " + numberOfRequest);
                    System.out.println("######################################################");

                    TopicSubscriber topicSubscriber = new TopicSubscriber();
                    topicSubscriber.SubsribeMessage(hostname, port, topic, username, password);

                } else {
                    System.out.println("Invalid Input");
                    System.out.println("Example Usage : ");
                    System.out.println("java -jar target/MBTopicClient.jar send <IP> <PORT> <USERNAME> <PASSWORD> <TOPIC> <Number of Requests> <sleepTime> <msgSize (1KB, 100KB, 500KB, 1mb, 5mb, 10mb)>");
                    System.out.println("java -jar target/MBTopicClient.jar receive <IP> <PORT> <USERNAME> <PASSWORD> <TOPIC> ''");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error executing client : " + ex);
            System.out.println("Example Usage : ");
            System.out.println("java -jar target/MBTopicClient.jar send <IP> <PORT> <USERNAME> <PASSWORD> <TOPIC> <Number of Requests> <sleepTime> <msgSize (1KB, 100KB, 500KB, 1mb, 5mb, 10mb)>");
            System.out.println("java -jar target/MBTopicClient.jar receive <IP> <PORT> <USERNAME> <PASSWORD> <TOPIC> ''");

        }
    }
}
