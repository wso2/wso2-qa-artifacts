package org.wso2.qa.mb;

import org.wso2.qa.util.Util;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class TopicPublisher {

    public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final String CF_NAME = "qpidConnectionfactory";
    private static String CARBON_CLIENT_ID = "carbon";
    private static String CARBON_VIRTUAL_HOST_NAME = "carbon";
    Util util = new Util();
    String userName = "admin";
    String password = "admin";

    public void publishMessage(String hostname, String port, String topicName, String requests, String sleep, String msgSize) throws NamingException, JMSException, InterruptedException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(hostname, port, userName, password));
        System.out.println("getTCPConnectionURL(userName,password) = " + getTCPConnectionURL(hostname, port, userName, password));
        System.setProperty("qpid.flow_control_wait_failure", "30000");

        InitialContext ctx = new InitialContext(properties);

        // Lookup connection factory
        TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup(CF_NAME);
        TopicConnection topicConnection = connFactory.createTopicConnection();
        topicConnection.start();

        TopicSession topicSession = topicConnection.createTopicSession(false, QueueSession.AUTO_ACKNOWLEDGE);

        // Send message
        Topic topic = topicSession.createTopic(topicName);
        javax.jms.TopicPublisher topicPublisher = topicSession.createPublisher(topic);

        //publishing 100 number of messages
        int i;
        int numberOfRequests = Integer.parseInt(requests);

        String msg = "MB Sample Topic";
        if (msgSize != null) {
            msg = readFile(msgSize);
        }
        long sleepTime = Long.parseLong(sleep);
        String startTime = util.getCurrentTimeStamp();
        long lStartTime = System.currentTimeMillis();
        for (i = 1; i <= numberOfRequests; i++) {

            // create the message to send
            TextMessage textMessage = topicSession.createTextMessage(msg + " [" + i + "]");
//            if (messageSelector != null) {
//                textMessage.setJMSType(messageSelector);
//            }
            System.out.println(util.getCurrentTimeStamp() + " - publishing topic [" + i + "] with message length : " + textMessage.getText().length());
            topicPublisher.publish(textMessage);
            if (sleepTime > 0) {
                Thread.sleep(sleepTime);
            }
        }

        i--;
        System.out.println("Total Published topics count ::: " + i);

        topicPublisher.close();
        topicSession.close();
        topicConnection.close();

        String stopTime = util.getCurrentTimeStamp();
        long lEndTime = System.currentTimeMillis();
        long difference = lEndTime - lStartTime;
        System.out.println("========== Summary ==========");
        System.out.println("Start Time : " + startTime);
        System.out.println("End Time : " + stopTime);
        System.out.println("Total number of requests : " + numberOfRequests);
        double elapsedTime = (double) difference / 1000;
        System.out.println("Total elapsed time : " + elapsedTime + " secs.");
        System.out.println("Publisher TPS : " + (numberOfRequests / elapsedTime) + " msg/sec");
        System.out.println("=============================");

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
        }
        return output;
    }
}
