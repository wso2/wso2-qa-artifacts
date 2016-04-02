import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

/**
 * Created by dilshani on 3/24/16.
 */
public class QueueListener {
    private static final String DEFAULT_CONNECTION_FACTORY = "QueueConnectionFactory";
    private static final String DEFAULT_DESTINATION = "queue/mySampleQueue";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";
    private static final String PROVIDER_URL = "jnp://localhost:1099";

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
            // Step 1. Create an initial context to perform the JNDI lookup.
            final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
            initialContext = new InitialContext(env);

            // Step 2. perform a lookup on the Queue
            Queue queue = (Queue) initialContext.lookup(DEFAULT_DESTINATION);

            // Step 3. perform a lookup on the Connection Factory
            ConnectionFactory cf =
                    (ConnectionFactory) initialContext.lookup(DEFAULT_CONNECTION_FACTORY);

            // Step 4. Create a JMS Connection
            connection = cf.createConnection();

            // Step 5. Create a JMS Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Step 6. Create a JMS Message Consumer
            MessageConsumer messageConsumer =
                    session.createConsumer(queue);

            // Step 7. Start the Connection
            connection.start();
            System.out.println("JMS consumer stated on the queue " + DEFAULT_DESTINATION +
                    "\n");

            //Clear the queue, if there is any previous messages in the queue
            TextMessage tempMessage;
            do{
                tempMessage = (TextMessage) messageConsumer.receive(1);
            } while(tempMessage != null);

            // Step 8. Receive the message
            TextMessage firstMessage = (TextMessage) messageConsumer.receive();
            long first = System.currentTimeMillis();
            System.out.println("Consumer received message: [ "+new Timestamp(new Date(first).getTime())+" ] " + firstMessage.getText() + "\n");

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
