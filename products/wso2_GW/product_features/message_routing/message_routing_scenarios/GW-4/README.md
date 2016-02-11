Applies To	: WSO2 GW 1.0.0
Created by	: Asanthi Kulasinghe
Testcase	: https://testlink.wso2.com/linkto.php?tprojectPrefix=GW&item=testcase&id=GW-4

DESCRIPTION
===========

To test the ability of WSO2 Gateway to perform load balanced routing.

INSTRUCTIONS
============

1. Copy request.xml to the path where the Curl command is executed.

2. Start 3 WSO2 Application Server instances with port offset 10, 20 and 30. Make sure the axis2 service 'HelloService' is available on all 3 servers.

3. The testcase can be executed by adding the route to camel-context.xml as well as by hot deploying the route in a seperate file.

	To execute the test case by deploying the route via camel-context.xml
	   - Replace <GW_home>/conf/camel/camel-context.xml file with camel-context.xml
	   - Restart the server

	To execute the test case by hot deploying the route
	   - Remove the above route from <GW_home>/conf/camel/camel-context.xml
	   - Restart the server 
	   - Copy  loadbalanced.xml to <GW_home>/conf/camel/ 

4. Run the following curl command repeatedly to see the load balanced endpoints being invoked according to the order specified in the route (based on the round robin algorythm)
	
	curl http://localhost:9090/loadbalanced  -d @request.xml  -H "SOAPAction: urn::greet" -H "Content-Type: text/xml"
