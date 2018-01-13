package ttl.RedeliveryDelayWithTTL.Topics;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by pubudup on 9/9/16.
 */
public class SendToTopic {

    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String QUEUE_NAME_PREFIX = "queue.";
    private static final String CF_NAME = "qpidConnectionfactory";
    String userName = "admin";
    String password = "admin";
    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";
    private static String CARBON_DEFAULT_HOSTNAME = "localhost";
    private static String CARBON_DEFAULT_PORT = "5672";
    String topicName = "RedeliveryDelayTopic1";



    public static void main(String[] args) throws NamingException, JMSException {
        SendToTopic topicSender = new SendToTopic();
        topicSender.sendMessages();
    }

    public void sendMessages() throws NamingException, JMSException {

        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(userName, password));
        System.out.println("getTCPConnectionURL(userName,password) = " + getTCPConnectionURL(userName, password));
        InitialContext ctx = new InitialContext(properties);
        // Lookup connection factory
        TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup(CF_NAME);
        TopicConnection topicConnection = connFactory.createTopicConnection();
        topicConnection.start();
        TopicSession topicSession = topicConnection.createTopicSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        // Send message
        Topic topic = topicSession.createTopic(topicName);
        javax.jms.TopicPublisher topicPublisher = topicSession.createPublisher(topic);

        //sending 100 messages to the above created topic here

        for (int i=1; i<=5; i=i+1)
        {
            TextMessage textMessage = topicSession.createTextMessage("This is a message with a TTL value :" + 1000 + " ms.");
            topicPublisher.send(textMessage,DeliveryMode.PERSISTENT,4,1000);
            TextMessage textMessage1 = topicSession.createTextMessage("This is a message with a TTL value :" + 40000 + " ms.");
            topicPublisher.send(textMessage1,DeliveryMode.PERSISTENT,4,40000);
        }

        topicSession.close();
        topicConnection.close();


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

