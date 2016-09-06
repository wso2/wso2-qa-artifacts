package ttl.Queues;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by pubudup on 9/5/16.
 */
public class QueueSendDefault {
    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String QUEUE_NAME_PREFIX = "queue.";
    private static final String CF_NAME = "qpidConnectionfactory";
    String userName = "admin";
    String password = "admin";
    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";
    private static String CARBON_DEFAULT_HOSTNAME = "10.100.7.95";
    private static String CARBON_DEFAULT_PORT = "5672";
    String topicName = "DefaultQueue";

    public static void main(String[] args) throws NamingException, JMSException {
        QueueSendDefault queueSender = new QueueSendDefault();
        queueSender.sendMessages();
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


        //Sending a single message with a TTL range
        /*
        for (int TTL=1; TTL<=3000;TTL=TTL+1)
        {
            TextMessage textMessageSingle = topicSession.createTextMessage("This is a single message with TTL: "+TTL);
            topicPublisher.send(textMessageSingle,DeliveryMode.PERSISTENT,4, TTL);
        }
        */



        //Sending messages with small TTL values

        for (int TTL=1000; TTL<=5000; TTL=TTL+100)
        {
            TextMessage textMessage = topicSession.createTextMessage("This is a message with a small TTL value: " + TTL + " TTL is : "+ TTL);
            topicPublisher.send(textMessage,DeliveryMode.PERSISTENT,4,TTL);
        }



        topicSession.close();
        topicConnection.close();


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
