
## Read Me for MB_300_Queue_Test_Plan

There are 2 jmeter scripts in this package which contain JMS publisher and JMS subscriber sample requests.
   * MB_300_Queue_Publisher_Test_Plan.jmx - used to publish messages to queues registered under WSO2 Message Broker
   * MB_300_Queue_Subscriber_Test_Plan.jmx - used to subscribe messages of queues registered under WSO2 Message Broker.
  
### Follow the below steps to run the test plan

##### 1. Copy the below jar files from <MB_HOME>/clent-lib to <JMETER_HOME>/lib folder
   * andes-client-3.0.1.jar
   * geronimo-jms_1.1_spec-1.1.0.wso2v1.jar
   * org.wso2.securevault-1.0.0-wso2v2.jar
  
##### 2. Configure the resources/jndi.properties file. 
   * Follow the inline comments in the file in order to configure it.
  
##### 3. Run the MB_300_Queue_Publisher_Test_Plan.jmx
1. Open Jmeter and navigate to File -> Open and browse the MB_300_Queue_Publisher_Test_Plan.jmx file
2. Configure the user defined variables in MB_300_Queue_Publisher_Test_Plan accordingly
   * jndipath (Path to the resources/jndi.properties file)
   * filepath (Path to the resources/sample_5KB_msg.xml which is used when sending a Byte message in Queue-Publisher-JMS-Message-Types Thread group)
3. Then, run the required requests by enabling the relavant Thread group

##### 4. Run the MB_300_Queue_Subscriber_Test_Plan.jmx

1. Open another Jmeter instance and navigate to File -> Open and browse the MB_300_Queue_Subscriber_Test_Plan.jmx file
2. Configure the user defined variables in MB_300_Queue_Subscriber_Test_Plan accordingly
   * jndipath (Path to the resources/jndi.properties file)
3. Then, run the required requests by enabling the relavant Thread group

