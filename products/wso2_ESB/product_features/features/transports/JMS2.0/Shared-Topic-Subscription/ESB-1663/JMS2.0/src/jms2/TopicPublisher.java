package jms2;

/**
 * Created by asankav on 2/5/16.
 */


        import java.util.Properties;

        import javax.jms.Connection;
        import javax.jms.ConnectionFactory;
        import javax.jms.MessageProducer;
        import javax.jms.Session;
        import javax.jms.TextMessage;
        import javax.jms.Topic;
        import javax.naming.Context;
        import javax.naming.InitialContext;

public class TopicPublisher {
    private static final String DEFAULT_CONNECTION_FACTORY = "TopicConnectionFactory";
    private static final String DEFAULT_DESTINATION = "/topic/exampleTopic";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";
    private static final String PROVIDER_URL = "jnp://localhost:1099";
    // Set up all the default values
    private static final String param = "IBM";

    public static void main(final String[] args) {
        try {
            runExample();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean runExample() throws Exception {
        Connection connection = null;
        Context initialContext = null;
        try {
            // /Step 1. Create an initial context to perform the JNDI lookup.
            // Set up the namingContext for the JNDI lookup
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

            // Step 6. Create a Message Producer
            MessageProducer producer = session.createProducer(topic);

            System.out.println("Publishing 5 messages to topic/exampleTopic");
            for (int i = 0; i < 5; i++) {

                // Step 7. Create a Text Message
                TextMessage message = session.createTextMessage(getMessage());

                // Step 8. Send the Message
                producer.send(message);
            }

            return true;
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

    private static double getRandom(double base, double varience, boolean onlypositive) {
        double rand = Math.random();
        return (base + (rand > 0.5 ? 1 : -1) * varience * base * rand) *
                (onlypositive ? 1 : rand > 0.5 ? 1 : -1);
    }

    private static String getMessage() {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <soapenv:Header/>\n" + "<soapenv:Body>\n" +
                "<m:placeOrder xmlns:m=\"http://services.samples\">\n" + "    <m:order>\n" +
                "        <m:price>" + getRandom(100, 0.9, true) + "</m:price>\n" +
                "        <m:quantity>" + (int) getRandom(10000, 1.0, true) + "</m:quantity>\n" +
                "        <m:symbol>" + param + "</m:symbol>\n" + "    </m:order>\n" +
                "</m:placeOrder>" + "   </soapenv:Body>\n" + "</soapenv:Envelope>";
    }
}
