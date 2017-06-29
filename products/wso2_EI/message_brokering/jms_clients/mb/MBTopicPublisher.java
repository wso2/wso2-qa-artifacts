import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class MBTopicPublisher {
    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String CF_NAME = "qpidConnectionfactory";
    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";

    //Message count going to publish
    int pubMsgCount=10;

    //Hostname
    private static String CARBON_DEFAULT_HOSTNAME = "localhost";
    //Port of MB
    private static String CARBON_DEFAULT_PORT = "5672";

    //Topic Name
    String topicName = "TestTopic";
    //For tenants' topic : Should include tenant domain
    //String topicName = "dilshani.wso2.com/TestQueue";
    //For hierarchical topics
    // String topicName = "Games.Cricket.dayandnight";

    //For super tenant
    String userName = "admin";
    String password = "admin";

    //For tenants : User name will be created using username with tenant domain
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

    private static double getRandom(double base, double varience, boolean onlypositive) {
        double rand = Math.random();
        return (base + (rand > 0.5 ? 1 : -1) * varience * base * rand) *
                (onlypositive ? 1 : rand > 0.5 ? 1 : -1);
    }
    public static void main(String[] args) throws NamingException, JMSException {
        MBTopicPublisher topicPublisher = new MBTopicPublisher();
        topicPublisher.publishMessage();
    }
    public void publishMessage() throws NamingException, JMSException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(userName, password));
        System.out.println("getTCPConnectionURL(userName,password) = " + getTCPConnectionURL(userName, password));
        InitialContext ctx = new InitialContext(properties);
        // Lookup connection factory
        TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup(CF_NAME);
        TopicConnection topicConnection = connFactory.createTopicConnection();
        topicConnection.start();
        TopicSession topicSession =
                topicConnection.createTopicSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        // Send message
        Topic topic = topicSession.createTopic(topicName);

        for(Integer i=1;i<=pubMsgCount;i=i+1){
            // create the message to send
            TextMessage message = topicSession.createTextMessage(MESSAGE_WITH_HEADER);
            message.setStringProperty("msgID", i.toString());
            javax.jms.TopicPublisher topicPublisher = topicSession.createPublisher(topic);
            topicPublisher.publish(message);
            System.out.println("Publishing Test Message "+i+"::Published From IP::"+CARBON_DEFAULT_HOSTNAME);
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
