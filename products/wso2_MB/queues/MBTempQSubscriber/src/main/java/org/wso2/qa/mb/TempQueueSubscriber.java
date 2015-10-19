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

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class TempQueueSubscriber {

        public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
        private static final String CF_NAME_PREFIX = "connectionfactory.";
        private static final String CF_NAME = "qpidConnectionfactory";

        private static String CARBON_CLIENT_ID = "carbon";
        private static String CARBON_VIRTUAL_HOST_NAME = "carbon";
        private static String CARBON_DEFAULT_HOSTNAME = "localhost";
        private static String CARBON_DEFAULT_PORT = "5672";


      public void receiveMessages(String hostName, String port, String userName, String passWord) throws NamingException, JMSException, InterruptedException {
                CARBON_DEFAULT_PORT = port;
                CARBON_DEFAULT_HOSTNAME = hostName;
                Properties properties = new Properties();
                properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
                properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(userName, passWord));
                //properties.put("queue." + queueName, queueName);
                System.out.println("getTCPConnectionURL(userName,password) = " + getTCPConnectionURL(userName, passWord));
                InitialContext ctx = new InitialContext(properties);

                // Lookup connection factory
                QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup(CF_NAME);
                QueueConnection queueConnection = connFactory.createQueueConnection();
                queueConnection.start();

                QueueSession queueSession = queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);

                TemporaryQueue tempDestination = queueSession.createTemporaryQueue();
                System.out.println("This is Temporary Queue Subscriber, Temporary queues are valid up until the sessions is active, " +
                        "when the subscriber closes the connection the Queue should get deleted");
                System.out.println("\nTEMP Q NAME  : " +tempDestination.getQueueName());
                System.out.println("\nPublish some messages to TEMP Q : " +tempDestination.getQueueName());


                MessageConsumer queueReceiver = queueSession.createConsumer(tempDestination);
                int count = 1;

                while (true) {

                    TextMessage message = (TextMessage) queueReceiver.receive();
                    String msgID = message.getStringProperty("msgID");
                    System.out.println(count + " Message : " + message.getText() + ":::Temp Queue Name ::" + tempDestination + "::::With MsgID::" + msgID);
                    count++;
                }
        }
        private String getTCPConnectionURL(String username, String password) {
            // amqp://{username}:{password}@carbon/carbon?brokerlist='tcp://{hostname}:{port}'
            return new StringBuffer()
                    .append("amqp://").append(username).append(":").append(password)
                    .append("@").append(CARBON_CLIENT_ID)
                    .append("/").append(CARBON_VIRTUAL_HOST_NAME)
                    .append("?brokerlist='tcp://").append(CARBON_DEFAULT_HOSTNAME).append(":").append(CARBON_DEFAULT_PORT).append("'")
                    .toString();
        }
}
