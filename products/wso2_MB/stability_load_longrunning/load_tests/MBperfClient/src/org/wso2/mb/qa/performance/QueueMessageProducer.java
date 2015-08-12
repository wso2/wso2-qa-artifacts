package org.wso2.mb.qa.performance;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class QueueMessageProducer {

    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String QUEUE_NAME_PREFIX = "queue.";
    private static final String CF_NAME = "qpidConnectionfactory";
    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";
    QueueConnection queueConnection;
    QueueSession queueSession;
    QueueSender queueSender;
    Util util = new Util();
    String userName = "admin";
    String password = "admin";

    public void sendMessages(String hostname, String port, String queue, String requests, String msgSize) throws NamingException, JMSException, InterruptedException {

        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(hostname, port, userName, password));
        properties.put(QUEUE_NAME_PREFIX + queue, queue);
        System.setProperty("qpid.flow_control_wait_failure", "30000");

        InitialContext ctx = new InitialContext(properties);

        System.out.println("TCP ConnectionURL :: " + getTCPConnectionURL(hostname, port, userName, password));

        String startTime = util.getCurrentTimeStamp();
        int numberOfRequests = Integer.parseInt(requests);

        QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup(CF_NAME);
        queueConnection = connFactory.createQueueConnection();
        queueConnection.start();


        queueSession = queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        Queue queues = (Queue) ctx.lookup(queue);

        queueSender = queueSession.createSender(queues);
        String msg = "Sample MB Message";
        if (msgSize != null) {
            msg = readFile(msgSize);
        }

        long lStartTime = System.currentTimeMillis();
        try {
            int i;
            for (i = 1; i <= numberOfRequests; i++) {

                TextMessage textMessage = queueSession.createTextMessage(msg);
                textMessage.setLongProperty("timestamp", System.currentTimeMillis());
                if (i % 100 == 0) {
                    System.out.println(util.getCurrentTimeStamp() + "|sending message [" + i + "]|message length " + textMessage.getText().length());
                }
                queueSender.send(textMessage);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            queueSender.close();
            queueSession.close();
            queueConnection.close();
            String stopTime = util.getCurrentTimeStamp();
            long lEndTime = System.currentTimeMillis();
            long difference = lEndTime - lStartTime;
            System.out.println("========== Summary ==========");
            System.out.println("Start Time : " + startTime);
            System.out.println("End Time : " + stopTime);
            System.out.println("Total number of requests : " + numberOfRequests);
            double elapsedTime = (double) difference / 1000;
            System.out.println("Total elapsed time : " + elapsedTime + " secs.");
            System.out.println("Producer TPS : " + numberOfRequests / elapsedTime + " msg/sec");
            System.out.println("=============================");
        }

        System.exit(0);
    }

    public String getTCPConnectionURL(String host, String port, String username, String password) {
        return new StringBuffer()
                .append("amqp://").append(username).append(":").append(password)
                .append("@").append(CARBON_CLIENT_ID)
                .append("/").append(CARBON_VIRTUAL_HOST_NAME)
                .append("?brokerlist='tcp://").append(host).append(":").append(port).append("'")
                .toString();
    }

    private String readFile(String inputFileSize) {
        String output = "";
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("resources/sample_" + inputFileSize + "_msg.xml");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                output += strLine;
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return output;
    }
}

