This folder contain configuration files used when testing new JMS 2.0 feature called "JMSX Delivery Count"
## synapse.xml

##### Description:
This synapse.xml file contains relevant sequences, message store and inbound endpoint which were used in testing scenarios.

##### Preconditions:
1) JMS broker should be configured and Started (Ex:HornetQ).

- HornetQ can be downloaded from here http://hornetq.jboss.org/downloads
- Extract the .tar.gz and go to the directory <HornetQ_HOME>/config/stand-alone/non-clustered/
- Add the following to the hornetq-jms.xml
```sh
<connection-factory name="QueueConnectionFactory">
      <xa>false</xa>
      <connectors>
         <connector-ref connector-name="netty"/>
      </connectors>
      <entries>
         <entry name="/QueueConnectionFactory"/>
      </entries>
</connection-factory>

<connection-factory name="TopicConnectionFactory">
      <xa>false</xa>
      <connectors>
         <connector-ref connector-name="netty"/>
      </connectors>
      <entries>
         <entry name="/TopicConnectionFactory"/>
      </entries>
</connection-factory>

<queue name="wso2">
      <entry name="/queue/mySampleQueue"/>
</queue>

<topic name="sampleTopic">
      <entry name="/topic/exampleTopic"/>
</topic>
```
Now, start the HornetQ broker.
- Linux: Run the file <HornetQ_HOME>/bin/run.sh with root privileges.
```sh
$ sudo ./run.sh 
```
2) ESB should be configured with JMS broker (Ex: HornetQ).
- hornet-all-new.jar to <ESB_HOME>/repository/components/lib/directory
- Repleace geronimo-jms_1.1_spec-1.1.0.wso2v1.jar (<ESB_HOME>/lib/endorsed/) with javax.jms-api-2.0.1.jar

##### Steps:
1) Start ESB 
> Navigate to $ESB_HOME/bin
```sh
$ sh wso2server.sh
```
2) Navigate to Source View (Home > Manage > Service Bus	> Source View)
3) Add synapse.xml configurations through source view and "Update" it.
4) Publish messages to JMS queue. (Ex: Run SOAPPublisher.java)

## SOAPPublisher.java
##### Description:
This is a JMS publisher class which will publish SOAP messages to JMS Queue. 
##### Preconditions:
Change hostname (Ex:localhost) if HornetQ running in a remote server.
```sh
private static final String PROVIDER_URL = "jnp://localhost:1099";
```
##### Steps:
1) Run this java class.

## Subscriber.java
##### Description:
This is a JMS subscriber class which can retrieve messages from JMS queue.
When testing ESB behaviour as JMS subscriber, this class can be use to check behaviour of external JMS subscriber
##### Preconditions:
Change hostname (Ex:localhost) if HornetQ running in a remote server.
```sh
private static final String PROVIDER_URL = "jnp://localhost:1099";
```
##### Steps:
1) Run this java class.




