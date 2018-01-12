package ttl.RedeliveryDelayWithTTL.Queues;

import org.wso2.andes.jms.Session;

import javax.jms.*;
import javax.jms.MessageConsumer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by pubudup on 9/9/16.
 */
public class ReceiveFromQueue {

    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String CF_NAME = "qpidConnectionfactory";
    String userName = "admin";
    String password = "admin";
    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";
    private static String CARBON_DEFAULT_HOSTNAME = "localhost";
    private static String CARBON_DEFAULT_PORT = "5672";
    String queueName = "RedeliveryDelayQueue2";


    public static void main(String[] args) throws NamingException, JMSException {
        ReceiveFromQueue queueReceiver = new ReceiveFromQueue();
        queueReceiver.receiveMessages();
    }

    public void receiveMessages() throws NamingException, JMSException {


        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(userName, password));
        properties.put("queue."+ queueName,queueName);
        System.setProperty("AndesRedeliveryDelay", "10000");
        System.setProperty("AndesAckWaitTimeOut","1000");
        System.out.println("getTCPConnectionURL(userName,password) = " + getTCPConnectionURL(userName, password));
        InitialContext ctx = new InitialContext(properties);

        // Lookup connection factory
        QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup(CF_NAME);
        QueueConnection queueConnection = connFactory.createQueueConnection();
        queueConnection.start();

        QueueSession queueSession =queueConnection.createQueueSession(false, Session.PER_MESSAGE_ACKNOWLEDGE );

        Queue queue =  (Queue) ctx.lookup(queueName);
        MessageConsumer queueReceiver =  queueSession.createConsumer(queue);
        int count=1;

        while(true) {

            TextMessage message = (TextMessage) queueReceiver.receive();

            System.out.println("::Message Count::" + count + ":::::::::::::Received message with content::::::::::::" + message.getText());

            count++;
        }



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
