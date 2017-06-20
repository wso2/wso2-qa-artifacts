import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class MBQueueSubscriber {
    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String CF_NAME = "qpidConnectionfactory";
    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";

    //Hostname
    private static String CARBON_DEFAULT_HOSTNAME = "localhost";
    //Port of MB
    private static String CARBON_DEFAULT_PORT = "5672";

    ///Queue Name
    String queueName = "TestQueue";
    //For tenants' queue
    //String queueName = "dilshani.wso2.com/TestQueue";

    //For super tenant
    String userName = "admin";
    String password = "admin";

    //For tenants
    //String userName ="dilshani!dilshani.wso2.com";
    //String password ="dilshani";

    //Number of messages going to subscribe
    int msgCount=10000;

    public static void main(String[] args) throws NamingException, JMSException {
        MBQueueSubscriber queueReceiver = new MBQueueSubscriber();
        queueReceiver.receiveMessages();
    }

    public void receiveMessages() throws NamingException, JMSException {
        Properties properties = new Properties();
        //Set up andes ack wait time
        System.setProperty("AndesAckWaitTimeOut", "500");
        properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(userName, password));
        properties.put("queue."+ queueName,queueName);
        System.out.println("getTCPConnectionURL(userName,password) = " + getTCPConnectionURL(userName, password));
        InitialContext ctx = new InitialContext(properties);

        // Lookup connection factory
        QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup(CF_NAME);
        QueueConnection queueConnection = connFactory.createQueueConnection();
        queueConnection.start();

        QueueSession queueSession =queueConnection.createQueueSession(false,QueueSession.AUTO_ACKNOWLEDGE);

        //Receive message
        Queue queue =  (Queue) ctx.lookup(queueName);

        MessageConsumer queueReceiver =  queueSession.createConsumer(queue);
        //Message selector. Change "releaseYear < 1980" with relevant selector value
        //MessageConsumer queueReceiver = queueSession.createConsumer(queue, "releaseYear < 1980");

        int count=1;

        for(int i=0; i<msgCount;i++){
            TextMessage message = (TextMessage) queueReceiver.receive();
            String msgID=message.getStringProperty("msgID");
            System.out.println(count+ ":::::Message Content:::::: " + message.getText()+":::Subscribe to queue::"+queueName+":::Subscribe From IP:::"+CARBON_DEFAULT_HOSTNAME+"::::With MsgID::"+msgID);
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
