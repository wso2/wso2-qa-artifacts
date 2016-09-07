package ttl.Queues;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by pubudup on 9/7/16.
 */
public class ZeroTTLSend {

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
    String queueName = "DefaultQueue";

    public static void main(String[] args) throws NamingException, JMSException {
        ZeroTTLSend queueSender = new ZeroTTLSend();
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
        QueueSession queueSession =  queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE );//

        Queue queue = (Queue)ctx.lookup(queueName);

        javax.jms.QueueSender queueSender = queueSession.createSender(queue);



        //Sending messages with TTL value as 0.


        for (int TTL=1000; TTL<=20000; TTL=TTL+1000)
        {
            TextMessage textMessage = queueSession.createTextMessage("This is a message with a TTL value of 0ms.");
            queueSender.send(textMessage,DeliveryMode.PERSISTENT,4,0);
        }



        queueSession.close();
        queueConnection.close();


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
