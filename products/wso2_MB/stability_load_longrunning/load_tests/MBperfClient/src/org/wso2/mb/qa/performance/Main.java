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
package org.wso2.mb.qa.performance;

import javax.jms.JMSException;
import javax.naming.NamingException;

public class Main {

    public static void main(String[] args) throws JMSException, NamingException {

        try {

            if (args[0] != null) {

                String messageType = args[0];
                String mode = args[1];
                String HOSTNAME = args[2];
                String PORT = args[3];
                String QT = args[4];
                String numberOfRequest = args[5];
                String sleepTime = args[6];
                String msgSize = null;
                if (args.length > 7) {
                    msgSize = args[7];
                }

                if (messageType.equalsIgnoreCase("QUEUE")) {

                    if (mode.equals("send")) {

                        QueueMessageProducer queueSender = new QueueMessageProducer();
                        queueSender.sendMessages(HOSTNAME, PORT, QT, numberOfRequest, msgSize);

                    } else if (mode.equals("receive")) {

                        QueueMessageConsumer queueReceiver = new QueueMessageConsumer();
                        queueReceiver.receiveMessages(HOSTNAME, PORT, QT, numberOfRequest, sleepTime, msgSize);

                    } else {

                        System.out.println("no operation found");

                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error executing client : " + e);
            e.printStackTrace();
            System.out.println("Example Usage : ");
            System.out.println("Queues:");
            System.out.println("java -jar MBSimpleClient.jar queue send <IP> <PORT> <QUEUE> <Number of Requests> <sleepTime> <msgSize (1KB, 100KB, 500KB, 1mb, 5mb, 10mb)> <message selector JMS type>");
            System.out.println("java -jar MBSimpleClient.jar queue receive <IP> <PORT> <QUEUE> '' '' '' <message selector JMS type>");
        }
    }
}
