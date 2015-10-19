Integration scenario:
VFS -> JMS -> SOAP

VFS and JMS Transport should be enabled. ActiveMQ should be up and running. It uses a queue name ACTMQ.

1. Client Request will be save in a file using VFS (VFSAddrEPProxy.xml)
2. VFS to JMS (VFS2JMSProxy.xml)
3. JMS to BE Service (JMS2SOAP.xml)

Hot Deploy all 3 Proxy with the required changes for File location and ActiveMQ JMS Queue.

Invoke a 100 Client Request using Jmeter (VFS.jmx) or using SOAPUI

It should generate 100 quotes without undue delay.


Ref: 
http://nuwanwimalasekara.blogspot.com/2013/04/jms-proxy-service-using-wso2-esb.html