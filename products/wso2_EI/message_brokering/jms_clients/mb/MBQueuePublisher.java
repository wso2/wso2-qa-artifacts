import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class MBQueuePublisher {
    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String QUEUE_NAME_PREFIX = "queue.";
    private static final String CF_NAME = "qpidConnectionfactory";
    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";

    //Hostname
    private static String CARBON_DEFAULT_HOSTNAME = "localhost";
    //Port of MB
    private static String CARBON_DEFAULT_PORT = "5672";

    //Queue Name
    String queueName = "TestQueue3";
    //For tenants' queue
    //String queueName = "dilshani.wso2.com/TestQueue";

    //Number of messages going to publish
    int publishMsgCount=100;

    //For super tenant
    String userName = "admin";
    String password = "admin";

    //For tenants
    //String userName ="dilshani!dilshani.wso2.com";
    //String password ="dilshani";

    //Message going to publish
    private static final String param = "IBM";
    private static final String MESSAGE_WITH_HEADER =
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "<soapenv:Header/>\n" +
                    "<soapenv:Body>\n" +
                    "<m:placeOrder xmlns:m=\"http://services.samples\">\n" +
                    "<m:order>\n" +
                    "<m:price>" +
                    getRandom(100, 0.9, true) +
                    "</m:price>\n" +
                    "<m:quantity>" +
                    (int) getRandom(10000, 1.0, true) +
                    "</m:quantity>\n" +
                    "<m:symbol>" +
                    param +
                    "</m:symbol>\n" +
                    "</m:order>\n" +
                    "</m:placeOrder>" +
                    "</soapenv:Body>\n"+
                    "</soapenv:Envelope>";

    public static void main(String[] args) throws NamingException, JMSException, InterruptedException {
        MBQueuePublisher queueSender = new MBQueuePublisher();
        queueSender.sendMessages();
    }

    public void sendMessages() throws NamingException, JMSException, InterruptedException {

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
        QueueSession queueSession =  queueConnection.createQueueSession(false,QueueSession.AUTO_ACKNOWLEDGE);

        Queue queue = (Queue)ctx.lookup(queueName);
        javax.jms.QueueSender queueSender = queueSession.createSender(queue);

        for(Integer i=1;i<=publishMsgCount;i=i+1){
            TextMessage textMessage = queueSession.createTextMessage(MESSAGE_WITH_HEADER);
            textMessage.setStringProperty("msgID", i.toString());

            //Set this property to use for message selectors.
            textMessage.setLongProperty("releaseYear", 1990);

            queueSender.send(textMessage);
            System.out.println("Publishing Test Message "+i+"::Published From IP::"+CARBON_DEFAULT_HOSTNAME);

            //Configure interval between messages
            //Thread.sleep(5000);
        }

        queueSender.close();
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

    private static double getRandom(double base, double varience, boolean onlypositive) {
        double rand = Math.random();
        return (base + (rand > 0.5 ? 1 : -1) * varience * base * rand) *
                (onlypositive ? 1 : rand > 0.5 ? 1 : -1);
    }
}
