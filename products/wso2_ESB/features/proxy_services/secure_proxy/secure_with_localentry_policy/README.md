# Securing Proxy Services using policies added as Local Entries

**Description:-** This test case coveres the scenario of invoking a Proxy service which is secured using a policy stored as a Local Entry in ESB.

**Pre-Conditions:-**

* An WSO2 ESB service should be up and running

**How to test the scenario:-**

* Add the content given under <localEntry> tag of server-policy.xml 

OR

drop the server-policy.xml to $ESB_HOME/repository/deployment/server/synapse-configs/default/local-entries folder and let it hotdeploy.

* Create a proxy service with the configuration given in SecPolicyWithLocalEntryProxy.xml

* Once deployed, secure the proxy service with the server-policy.xml Local entry policy so that the configuration looks like what's given below

```python
   <proxy name="SecPolicyWithLocalEntryProxy"
          transports="https"
          startOnLoad="true"
          trace="disable">
      <description/>
      <target>
         <endpoint>
            <address uri="http://localhost:9000/services/SimpleStockQuoteService"/>
         </endpoint>
         <outSequence>
            <send/>
         </outSequence>
      </target>
      <policy key="server-policy"/>
      <parameter name="ScenarioID">scenario1</parameter>
      <enableSec/>
   </proxy>
```

* Now invoke the proxy service with the correct credentials. You can also use the given soapUI project - SecPolicyWithLocalEntryProxy-soapui-project.xml and invoke the proxy service.

Once invoked, you should get the expected response from ESB.


## Refer below for the entire synapse configuration used in this sample

```python
<?xml version="1.0" encoding="UTF-8"?>
<definitions xmlns="http://ws.apache.org/ns/synapse">
   <registry provider="org.wso2.carbon.mediation.registry.WSO2Registry">
      <parameter name="cachableDuration">15000</parameter>
   </registry>
   <proxy name="SecPolicyWithLocalEntryProxy"
          transports="https"
          startOnLoad="true"
          trace="disable">
      <description/>
      <target>
         <endpoint>
            <address uri="http://localhost:9000/services/SimpleStockQuoteService"/>
         </endpoint>
         <outSequence>
            <send/>
         </outSequence>
      </target>
      <policy key="server-policy"/>
      <parameter name="ScenarioID">scenario1</parameter>
      <enableSec/>
   </proxy>
   <localEntry key="server-policy">
      <wsp:Policy xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy"
                  xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"
                  wsu:Id="UTOverTransport">
         <wsp:ExactlyOne>
            <wsp:All>
               <sp:TransportBinding xmlns:sp="http://schemas.xmlsoap.org/ws/2005/07/securitypolicy">
                  <wsp:Policy>
                     <sp:TransportToken>
                        <wsp:Policy>
                           <sp:HttpsToken RequireClientCertificate="true"/>
                        </wsp:Policy>
                     </sp:TransportToken>
                     <sp:AlgorithmSuite>
                        <wsp:Policy>
                           <sp:Basic256/>
                        </wsp:Policy>
                     </sp:AlgorithmSuite>
                     <sp:Layout>
                        <wsp:Policy>
                           <sp:Lax/>
                        </wsp:Policy>
                     </sp:Layout>
                  </wsp:Policy>
               </sp:TransportBinding>
               <rampart:RampartConfig xmlns:rampart="http://ws.apache.org/rampart/policy">
                  <rampart:encryptionUser>useReqSigCert</rampart:encryptionUser>
                  <rampart:timestampPrecisionInMilliseconds>true</rampart:timestampPrecisionInMilliseconds>
                  <rampart:timestampTTL>300</rampart:timestampTTL>
                  <rampart:timestampMaxSkew>300</rampart:timestampMaxSkew>
                  <rampart:tokenStoreClass>org.wso2.carbon.security.util.SecurityTokenStore</rampart:tokenStoreClass>
                  <rampart:nonceLifeTime>300</rampart:nonceLifeTime>
               </rampart:RampartConfig>
            </wsp:All>
         </wsp:ExactlyOne>
      </wsp:Policy>
      <description/>
   </localEntry>
   <sequence name="fault">
      <log level="full">
         <property name="MESSAGE" value="Executing default 'fault' sequence"/>
         <property name="ERROR_CODE" expression="get-property('ERROR_CODE')"/>
         <property name="ERROR_MESSAGE" expression="get-property('ERROR_MESSAGE')"/>
      </log>
      <drop/>
   </sequence>
   <sequence name="main">
      <in>
         <log level="full"/>
         <filter source="get-property('To')" regex="http://localhost:9000.*">
            <send/>
         </filter>
      </in>
      <out>
         <send/>
      </out>
      <description>The main sequence for the message mediation</description>
   </sequence>
</definitions>
```