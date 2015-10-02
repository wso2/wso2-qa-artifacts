1. Configure both ESB and AS using [1]
2. Moidy the HCCProxyService in ESB to suite our need
a. Add the property just below the In Sequence since we haven't expect a reply after placing the aggregated message to JMS queue.
<property name="FORCE_SC_ACCEPTED" value="true" scope="axis2"/>

b. Add an end point, say aggregateEP" for JMS message routing to ACTMQ, here we used ActiveMQ.
e.g.

<endpoint xmlns="http://ws.apache.org/ns/synapse" name="aggregateEP">
   <address uri="jms:/ACTMQ?transport.jms.DestinationType=queue&transport.jms.ContentTypeProperty=Content-Type&java.naming.provider.url=tcp://localhost:61616&java.naming.factory.initial=org.apache.activemq.jndi.ActiveMQInitialContextFactory&transport.jms.ConnectionFactoryJNDIName=QueueConnectionFactory">
      <suspendOnFailure>
         <progressionFactor>1.0</progressionFactor>
      </suspendOnFailure>
      <markForSuspension>
         <retriesBeforeSuspension>0</retriesBeforeSuspension>
         <retryDelay>0</retryDelay>
      </markForSuspension>
   </address>
</endpoint>

Note: JMS should be enabled and configured for ActiveMQ.

c. From the Out Sequence define a JMS end point to route the final aggregated response


<outSequence>
         -----
	 ------
               </log>
               <log level="full" separator=","/>
               <send>
                  <endpoint key="aggregateEP"/>
               </send>
            </onComplete>
         </aggregate>
      </outSequence>


Refer modified Synapse HCCProxyService.xml.

1. http://wso2.com/library/articles/2012/11/enterprise-service-integration-wso2-esb