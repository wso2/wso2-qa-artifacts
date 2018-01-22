
/*
 *
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 * /
 */

package ttl.RedeliveryDelayWithTTL.Queues;

import util.ConfigUtil;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Sends messages to a queue
 */
public class SendToQueue {

    ConfigUtil config = new ConfigUtil();

    public String QPID_ICF = config.getProperty("QPID_ICF");
    private String CF_NAME_PREFIX = config.getProperty("CF_NAME_PREFIX");
    private String QUEUE_NAME_PREFIX = config.getProperty("QUEUE_NAME_PREFIX");
    private String CF_NAME = config.getProperty("CF_NAME");
    String userName = config.getProperty("userName");
    String password = config.getProperty("password");
    private String CARBON_CLIENT_ID = config.getProperty("CARBON_CLIENT_ID");
    private String CARBON_VIRTUAL_HOST_NAME = config.getProperty("CARBON_VIRTUAL_HOST_NAME");
    private String CARBON_DEFAULT_HOSTNAME = config.getProperty("CARBON_DEFAULT_HOSTNAME");
    private String CARBON_DEFAULT_PORT = config.getProperty("CARBON_DEFAULT_PORT");
    String queueName = "RedeliveryDelayQueue2";

    public static void main(String[] args) throws NamingException, JMSException {
        SendToQueue queueSender = new SendToQueue();
        queueSender.sendMessages();
    }

    public void sendMessages() throws NamingException, JMSException {


        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(userName, password));
        properties.put(QUEUE_NAME_PREFIX + queueName, queueName);

        Properties properties2 = new Properties();
        properties2.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties2.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(userName, password));


        System.out.println("getTCPConnectionURL(userName,password) = " + getTCPConnectionURL(userName, password));
        InitialContext ctx = new InitialContext(properties);


        // Lookup connection factory
        QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup(CF_NAME);
        QueueConnection queueConnection = connFactory.createQueueConnection();
        queueConnection.start();
        QueueSession queueSession = queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        Queue queue = (Queue) ctx.lookup(queueName);
        javax.jms.QueueSender queueSender = queueSession.createSender(queue);

        //Sending messages with incremental TTL values
        for (int i = 1; i <= 5; i = i + 1) {
            TextMessage textMessage1 = queueSession.createTextMessage("This is a message with an incremental TTL value :" + 60000 + " ms.");
            queueSender.send(textMessage1, DeliveryMode.PERSISTENT, 4, 60000);
        }

        queueSession.close();
        queueConnection.close();

    }

    public String getTCPConnectionURL(String username, String password) {

        return new StringBuffer()
                .append("amqp://").append(username).append(":").append(password)
                .append("@").append(CARBON_CLIENT_ID)
                .append("/").append(CARBON_VIRTUAL_HOST_NAME)
                .append("?brokerlist='tcp://").append(CARBON_DEFAULT_HOSTNAME).append(":").append(CARBON_DEFAULT_PORT).append("'")
                .toString();
    }

}
