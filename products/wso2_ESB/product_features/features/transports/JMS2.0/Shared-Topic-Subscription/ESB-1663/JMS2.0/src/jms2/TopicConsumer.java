package jms2;

/**
 * Created by asankav on 2/5/16.
 */


    import java.util.Properties;
    import javax.jms.Connection;
    import javax.jms.ConnectionFactory;
    import javax.jms.MessageConsumer;
    import javax.jms.Session;
    import javax.jms.TextMessage;
    import javax.jms.Topic;
    import javax.naming.Context;
    import javax.naming.InitialContext;

public class TopicConsumer {
    private static final String DEFAULT_CONNECTION_FACTORY = "TopicConnectionFactory";
    private static final String DEFAULT_DESTINATION = "/topic/exampleTopic";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";
    private static final String PROVIDER_URL = "jnp://localhost:1099";
    private static final String SUBSCRIPTION_NAME = "mySubscription";

    public static void main(final String[] args) {
        try {
            runExample();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runExample() throws Exception {
        Connection connection = null;
        Context initialContext = null;
        try {
            // /Step 1. Create an initial context to perform the JNDI lookup.
            final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
            initialContext = new InitialContext(env);

            // Step 2. perform a lookup on the topic
            Topic topic = (Topic) initialContext.lookup(DEFAULT_DESTINATION);

            // Step 3. perform a lookup on the Connection Factory
            ConnectionFactory cf =
                    (ConnectionFactory) initialContext.lookup(DEFAULT_CONNECTION_FACTORY);

            // Step 4. Create a JMS Connection
            connection = cf.createConnection();

            // Step 5. Create a JMS Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Step 6. Create a JMS Message Consumer
            MessageConsumer messageConsumer =
                    session.createSharedConsumer(topic, SUBSCRIPTION_NAME);

            // Step 7. Start the Connection
            connection.start();
            System.out.println("Shared message consumer started on topic: " + DEFAULT_DESTINATION +
                    "\n");

            // Step 8. Receive the message
            TextMessage messageReceived = null;
            while (true) {
                messageReceived = (TextMessage) messageConsumer.receive();
                System.out.println("Consumer received message: " + messageReceived.getText() + "\n");
            }

        } finally {
            // Step 9. Close JMS resources
            if (connection != null) {
                connection.close();
            }

            // Also the initialContext
            if (initialContext != null) {
                initialContext.close();
            }
        }
    }
}

