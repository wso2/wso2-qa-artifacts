This artifact can be used to create 500 topics and also it provides 500 subscribers ( one subscriber will subscribe to one topic). The publisher script can be used to publish messages to all 500 topics that is created. The subscribers are configured to be durable subscribers.

### Steps

- Open the jndi.properties file and provide the Message broker url ( if you have a cluster you can provide each topic to be connected to your desired broker node )
- Open the 500DurableTopicSubsribers.jmx from JMeter and provide the location the jndi.properties file to the User defined variable - JNDIproviderURL
- Run the JMeter script. It should successfully connect 500 durable subscribers to the broker instance/ cluster.
- Open the 500TopicPublishers.jmx it and provide the jndi.properties file configured in the first step.
- Run the publisher script it will publish 100 messages to each topic. ( you can configure the number of messages to be published in the User defined variable - numberOfMsgs 
