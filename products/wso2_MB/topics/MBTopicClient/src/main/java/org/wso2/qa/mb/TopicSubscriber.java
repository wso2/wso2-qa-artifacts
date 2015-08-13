package org.wso2.qa.mb;

import org.wso2.qa.util.Util;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;


public class TopicSubscriber {

    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String CF_NAME = "qpidConnectionfactory";
    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";

    Util util = new Util();

    public void SubsribeMessage(String hostname, String port, String topicName, String userName, String password) throws NamingException, JMSException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(hostname, port, userName, password));
        System.setProperty("AndesAckWaitTimeOut", "120000");

        System.out.println("getTCPConnectionURL(userName,password) = " + getTCPConnectionURL(hostname, port, userName, password));
        InitialContext ctx = new InitialContext(properties);
        // Lookup connection factory
        TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup(CF_NAME);
        TopicConnection topicConnection = connFactory.createTopicConnection();
        topicConnection.start();
        TopicSession topicSession =
                topicConnection.createTopicSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        Topic topic = topicSession.createTopic(topicName);

        javax.jms.TopicSubscriber topicSubscriber;
        topicSubscriber = topicSession.createSubscriber(topic);

//        =================== Message Selector Related ======================
//        if (messageSelector != null) {
//            String jmsType = "JMSType = '" + messageSelector + "'";
//            System.out.println(jmsType);
//            topicSubscriber = topicSession.createSubscriber(topic, jmsType, false);
//        } else {
//            topicSubscriber = topicSession.createSubscriber(topic);
//        }

        int count = 1;
        try {
            while (true) {
                Message message = topicSubscriber.receive();
                if (message instanceof TextMessage) {
                    TextMessage message1 = (TextMessage) message;
                    System.out.println(util.getCurrentTimeStamp() + " [" + count + "] {MessageID:" + message.getJMSMessageID() +
                            ", contentLength:" + message1.getText().length() + ", topic:" + topicName + "}");
                }
                count++;
            }
        } catch (Exception ec) {
            ec.printStackTrace();
        } finally {
            topicSubscriber.close();
            topicSession.close();
            topicConnection.stop();
            topicConnection.close();
        }
    }

    public String getTCPConnectionURL(String host, String port, String username, String password) {
        return new StringBuffer()
                .append("amqp://").append(username).append(":").append(password)
                .append("@").append(CARBON_CLIENT_ID)
                .append("/").append(CARBON_VIRTUAL_HOST_NAME)
                .append("?brokerlist='tcp://").append(host).append(":").append(port).append("'")
                .toString();
    }
}
