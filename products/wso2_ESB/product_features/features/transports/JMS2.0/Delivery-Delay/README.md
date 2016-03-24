This folder contain configuration files used when testing new JMS 2.0 feature called "Message Delivery Delay"
## synapse.xml

##### Description:
This synapse.xml file contains two proxy services which were used in testing scenarios.

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

- Update the following in the ESB_HOME/repository/conf/axis2/axis2.xml
```sh
<transportSender name="jms" class="org.apache.axis2.transport.jms.JMSSender">
<parameter name="myQueueConnectionFactory" locked="false">
<parameter name="java.naming.factory.initial" locked = "false">org.jnp.interfaces.NamingContextFactory</parameter>
<parameter name="java.naming.provider.url" locked="false">jnp://localhost:1099</parameter>
<parameter name="transport.jms.ConnectionFactoryJNDIName" locked="false">QueueConnectionFactory</parameter>
<parameter name="transport.jms.ConnectionFactoryType" locked="false">queue</parameter>
<parameter name="transport.jms.Destination">queue/mySampleQueue</parameter>
<parameter name="transport.jms.JMSSpecVersion">2.0</parameter>
               </parameter>

<parameter name="default" locked="false">
<parameter name="java.naming.factory.initial" locked = "false">org.jnp.interfaces.NamingContextFactory</parameter>
<parameter name="java.naming.provider.url" locked="false">jnp://localhost:1099</parameter>
<parameter name="transport.jms.ConnectionFactoryJNDIName" locked="false">QueueConnectionFactory</parameter>
<parameter name="transport.jms.ConnectionFactoryType" locked="false">queue</parameter>
<parameter name="transport.jms.Destination">queue/mySampleQueue</parameter>
<parameter name="transport.jms.JMSSpecVersion">2.0</parameter>
                    </parameter>
</transportSender>
```

##### Steps:
1) Start ESB 
> Navigate to $ESB_HOME/bin
```sh
$ sh wso2server.sh
```
2) Navigate to Source View (Home > Manage > Service Bus	> Source View)
3) Add synapse.xml configurations through source view and "Update" it.
4) Run JMS Message consumer which will consume messages from the queue which the two proxy servers are producing. (Ex: Run QueueConsumer.java class )
5) Invoke two proxy services
Ex:
```sh
$ ant stockquote -Daddurl=http://localhost:8280/services/JMSDelivery -Dmode=placeorder -Dsymbol=MSFT && ant stockquote -Daddurl=http://localhost:8280/services/JMSDeliveryDelayed -Dmode=placeorder -Dsymbol=MSFT
```

## QueueConsumer.java
##### Description:
This is JMS Consumer class which will consume messages from the queue which the two proxy servers are producing.

##### Preconditions:
Change hostname (Ex:localhost) if HornetQ running in a remote server.
```sh
private static final String PROVIDER_URL = "jnp://localhost:1099";
```
##### Steps:
1) Run this java class.





