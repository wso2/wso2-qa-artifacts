package org.wso2.mbtest.queue.TemporaryQueues;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by yasassri on 10/15/15.
 */
public class TempQueueSubscriber {


    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String CF_NAME = "qpidConnectionfactory";

    String userName = "admin";
    String password = "admin";
    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";
    private static String CARBON_DEFAULT_HOSTNAME = "localhost";
    private static String CARBON_DEFAULT_PORT = "5672";


    public static void main(String[] args) throws NamingException, JMSException, InterruptedException {
        TempQueueSubscriber queueReceiver = new TempQueueSubscriber()   ;
        queueReceiver.receiveMessages();
    }

    public void receiveMessages() throws NamingException, JMSException, InterruptedException {

        for (int j = 0; j < 1; j++) {
            Thread.sleep(100);
            Properties properties = new Properties();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
            properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(userName, password));
            properties.put("queue." + queueName, queueName);
            System.out.println("getTCPConnectionURL(userName,password) = " + getTCPConnectionURL(userName, password));
            InitialContext ctx = new InitialContext(properties);

            // Lookup connection factory
            QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup(CF_NAME);
            QueueConnection queueConnection = connFactory.createQueueConnection();
            queueConnection.start();

            QueueSession queueSession = queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);

            TemporaryQueue tempDestination = queueSession.createTemporaryQueue();
            System.out.println("TEMP Q NAME  : " +tempDestination.getQueueName());

            MessageConsumer queueReceiver = queueSession.createConsumer(tempDestination);
            int count = 1;

            while (true) {

                TextMessage message = (TextMessage) queueReceiver.receive();
                String msgID = message.getStringProperty("msgID");
                System.out.println(count + "Message : " + message.getText() + ":::Subscribe to queue::" + queueName + ":::Subscribe From IP:::" + CARBON_DEFAULT_HOSTNAME + "::::With MsgID::" + msgID);

                count++;
            }

        }
    }

    public String getTCPConnectionURL(String username, String password) {
        // amqp://{username}:{password}@carbon/carbon?brokerlist='tcp://{hostname}:{port}'
        return new StringBuffer()
                .append("amqp://").append(username).append(":").append(password)
                .append("@").append(CARBON_CLIENT_ID)
                .append("/").append(CARBON_VIRTUAL_HOST_NAME)
                .append("?brokerlist='tcp://").append(CARBON_DEFAULT_HOSTNAME).append(":").append(CARBON_DEFAULT_PORT).append("'")
                .toString();
    }
}



