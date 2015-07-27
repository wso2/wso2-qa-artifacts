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

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Properties;

public class QueueMessageConsumer {
    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String CF_NAME = "qpidConnectionfactory";
    QueueSession queueSession;
    QueueConnection queueConnection;
    Util util = new Util();
    String userName = "admin";
    String password = "admin";

    ArrayList<long[]> msgList = new ArrayList<long[]>();
    long[] messageDetails;
    //private ArrayList<MessageDetails> messageDetailsArrayList = new ArrayList<MessageDetails>(3);
    long totalLatencyDiff = 0;
    long lowCap = 0;
    long highCap = 0;
    double throughput = 0;

    public void receiveMessages(String hostname, String port, String queueName, String totalMessages, String lowLimit, String upLimit) throws NamingException, JMSException, JMSException {

        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties.put(CF_NAME_PREFIX + CF_NAME, util.getTCPConnectionURL(hostname, port, userName, password));
        properties.put("queue." + queueName, queueName);
        System.setProperty("AndesAckWaitTimeOut", "100000");

        InitialContext ctx = new InitialContext(properties);

        QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup(CF_NAME);
        queueConnection = connFactory.createQueueConnection();
        queueConnection.start();

        queueSession = queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);

        Queue queue = (Queue) ctx.lookup(queueName);
        javax.jms.MessageConsumer queueReceiver;

        queueReceiver = queueSession.createConsumer(queue);

        try {
            int count = 1;
            int totalMsgs = Integer.parseInt(totalMessages);

            while (count <= totalMsgs) {
                TextMessage message = (TextMessage) queueReceiver.receive();
                messageDetails = new long[]{count, message.getLongProperty("timestamp"), System.currentTimeMillis()};
                msgList.add(messageDetails);

                if (count % 100 == 0) {
                    System.out.println(util.getCurrentTimeStamp() + "|MESSAGE RECEIVED|Message Length:" + message.getText().length() + "|Current Message Count [" + count + "]");
                }
                count++;
            }

            // calculation functions
            for (long[] messageDetails : msgList) {

                int counter = (int) messageDetails[0];
                long startTime = messageDetails[1];
                long endTime = messageDetails[2];

                long msgLatency = endTime - startTime;
                totalLatencyDiff = +msgLatency;

                if (counter == Integer.parseInt(lowLimit)) {
                    lowCap = startTime;
                }
                if (counter == Integer.parseInt(upLimit)) {
                    highCap = endTime;
                }
            }

            double totMessages = Double.parseDouble(totalMessages);
            double avgLatency = (totalLatencyDiff / totMessages);

            double mesageCount = Integer.parseInt(upLimit) - Integer.parseInt(lowLimit);
            long timeGapinMilis = highCap - lowCap;
            double elapsedTime = timeGapinMilis / 1000;
            throughput = mesageCount / elapsedTime;

            System.out.println("");
            System.out.println("============= Summary =============");
            System.out.println("Total Number of Messages : " + totalMessages);
            System.out.println("Message Throughput : " + throughput + " msg/sec");
            System.out.println("Average Latency : " + avgLatency + " mil. secs");
            System.out.println("===================================");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            queueReceiver.close();
            queueSession.close();
            queueConnection.stop();
            queueConnection.close();
        }
    }
}
