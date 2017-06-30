# README
**Author :** Dilshani Subasinghe

### Description
This folder contains four java classes for MB Queue subscribing, MB Queue publishing, MB Topic publishing and MB Topic subscribing.

### Setup 

    Product Version: WS02 MB 3.2

### Contents
  - MBQueuePublisher.java - This class use for publishing messages to an queue created in WSO2 MB (Cover all publishing scenarios to an queue)
  - MBQueueSubscriber.java - This class use for subscribing messages of queue created in WSO2 MB (Cover all subscribing scenarios to an queue)
  - MBTopicPublisher.java - This class use for publishing messages to a topic created in WSO2 MB (Cover all publishing scenarios to a topic)
  - MBTopicSubscriber.java - This class use for subscribing messages of a topic created in WSO2 MB (Cover all subscribing scenarios to a topic)
  
### Class Parameters
Here describe main parameters according to the class. Other than that, you can check inline comments for the parameters which vary according to the use case.

1. MBQueuePublisher.java
  - CARBON_DEFAULT_HOSTNAME - Default hostname is "localhost". If you are using remote MB, use hostname accordingly.
  - CARBON_DEFAULT_PORT - Default port MB is "5672". If you changed the offset of MB, change the port accordingly.
  - publishMsgCount - Number of messages going to publish
  - queueName - Name of the queue going to publish
  - MESSAGE_WITH_HEADER - Message which is going to publish to queue
  
2. MBQueueSubscriber.java 
  - CARBON_DEFAULT_HOSTNAME - Default hostname is "localhost". If you are using remote MB, use hostname accordingly.
  - CARBON_DEFAULT_PORT - Default port MB is "5672". If you changed the offset of MB, change the port accordingly.
  - msgCount - Number of messages going to subscribe (After recieving this number of messages, connection going to close)
  - queueName - Name of the queue going to subscribe
Note: When you are running subscriber for queue, it should be already available in MB (This is not needed after MB 4.0 release)
  
3. MBTopicPublisher.java 
  - CARBON_DEFAULT_HOSTNAME - Default hostname is "localhost". If you are using remote MB, use hostname accordingly.
  - CARBON_DEFAULT_PORT - Default port MB is "5672". If you changed the offset of MB, change the port accordingly.
  - publishMsgCount - Number of messages going to publish
  - topicName - Name of the topic going to publish
  - MESSAGE_WITH_HEADER - Message which is going to publish to topic
  
4. MBTopicSubscriber.java 
  - CARBON_DEFAULT_HOSTNAME - Default hostname is "localhost". If you are using remote MB, use hostname accordingly.
  - CARBON_DEFAULT_PORT - Default port MB is "5672". If you changed the offset of MB, change the port accordingly.
  - subscriptionName - When creating durable subscribers, unique subcription name should be given to identify the subscription
  - topicName - Name of the topic going to subscribe
Note: When you are running subscriber for topic, it should be already available in MB (This is not needed after MB 4.0 release)
    
### Pre-conditions

- Add Broker Profile client jars in to the java project as dependencies.        
Ex: andes-client-3.0.1.jar, geronimo-jms_1.1_spec-1.1.0.wso2v1.jar, org.wso2.securevault-1.0.0-wso2v2.jar

### Execution steps
1. Create a java project and add java classes with dependencies (Dependencies jars mentioned in pre-conditions)
2. Run java class.
Note: When you are running java class you can find comments in those classes. According to that, you can uncomment relevant scenarios and implement them.




