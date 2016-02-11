Applies To	: WSO2 GW 1.0.0

Testcase	: https://testlink.wso2.com/linkto.php?tprojectPrefix=GW&item=testcase&id=GW-26

Created by	: Asanthi Kulasinghe


DESCRIPTION
===========

To test the ability to  perform simple passthrough routing via WSO2 Gateway.
 
INSTRUCTIONS
============

1. Copy request.xml to the path where the Curl command is executed.

2. Start WSO2 Application Server with port offsets set to 10. Make sure the axis2 service 'HelloService' is available on the server.

3. The testcase can be executed by adding the route to camel-context.xml as well as by hot deploying the route in a seperate file.

	To execute the test case by deploying the route via camel-context.xml
	   - Replace <GW_home>/conf/camel/camel-context.xml file with camel-context.xml
	   - Restart the server
	   
	To execute the test case by hot deploying the route
	   - Remove the route from <GW_home>/conf/camel/camel-context.xml
	   - Restart the server 
	   - Copy simple-passthrough.xml to <GW_home>/conf/camel/ 
	   
4. Execute the following curl command.
	curl http://localhost:9090/simple_passthrough  -d @request.xml  -H "SOAPAction: urn::greet" -H "Content-Type: text/xml"
