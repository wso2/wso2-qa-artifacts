import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class MBTopicSubscriber {

    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String CF_NAME = "qpidConnectionfactory";
    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";

    //Hostname
    private static String CARBON_DEFAULT_HOSTNAME = "localhost";
    //Port of MB
    private static String CARBON_DEFAULT_PORT = "5672";

    //Topic Name
    String topicName = "TestTopic";
    //For tenants' topic : Should include tenant domain
    //String topicName = "dilshani.wso2.com/TestTopic2";
    //For hierarchical topics
    // String topicName = "Games.Cricket.dayandnight";

    //For super tenant
    String userName = "admin";
    String password = "admin";

    //For tenants : User name will be created using username with tenant domain
    //String userName ="dilshani!dilshani.wso2.com";
    //String password ="dilshani";

    //Subscription ID/Name
    String subscriptionName ="subscriber1";
    //Subscription ID/Name for tenants : Should include tenant domain
    //String subscriptionNameTenant ="dilshani.wso2.com/subscriber1";

    public static void main(String[] args) throws NamingException, JMSException {
        MBTopicSubscriber durableTopicSubscriber = new MBTopicSubscriber();
        durableTopicSubscriber.subscribe();
    }

    public void subscribe() throws NamingException, JMSException {
        Properties properties = new Properties();
        System.setProperty("AndesAckWaitTimeOut", "500");
        properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(userName, password));
        System.out.println("getTCPConnectionURL(userName,password) = " + getTCPConnectionURL(userName, password)+topicName+CARBON_DEFAULT_HOSTNAME);
        InitialContext ctx = new InitialContext(properties);
        // Lookup connection factory
        TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup(CF_NAME);
        TopicConnection topicConnection = connFactory.createTopicConnection();
        topicConnection.start();
        TopicSession topicSession =
                topicConnection.createTopicSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        Topic topic = topicSession.createTopic(topicName);

        //For durable subscriptions
        javax.jms.TopicSubscriber topicSubscriber = topicSession.createDurableSubscriber(topic,subscriptionName);

        //For non durable subscriptions
        //javax.jms.TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);

        int count=1;

        while(true){
            Message message = topicSubscriber.receive();
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String msgID=textMessage.getStringProperty("msgID");
                System.out.println(count+ ":::::Message Content:::::: " + textMessage.getText()+"::Listen To:::"+topicName+":::Recieved From IP:::"+CARBON_DEFAULT_HOSTNAME+":::::With msgID:::"+msgID);

                count++;
            }
        }

        //This subscriber going to listen to the topic continously.
        // topicSession.close();
        //  topicConnection.close();
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
