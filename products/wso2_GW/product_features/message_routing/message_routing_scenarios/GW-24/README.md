Applies To	: WSO2 GW 1.0.0

Testcase	: https://testlink.wso2.com/linkto.php?tprojectPrefix=GW&item=testcase&id=GW-24

Created by	: Asanthi Kulasinghe


DESCRIPTION
===========

To test the ability of WSO2 Gateway to perform service chaining among REST backends expecting different headers passed along with the request.

INSTRUCTIONS
============

1. Copy request.xml to the path where the Curl command is executed.

2. Start a WSO2 Application Server with a port offset of 10. Make sure the web application 'jaxrs_basic' is available on the server.

3. The testcase can be executed by adding the route to camel-context.xml as well as by hot deploying the route in a seperate file.

	To execute the test case by deploying the route via camel-context.xml
	   - Replace <GW_home>/conf/camel/camel-context.xml file with camel-context.xml
	   - Restart the server

	To execute the test case by hot deploying the route
	   - Remove the above route from <GW_home>/conf/camel/camel-context.xml
	   - Restart the server 
	   - Copy servicechaining.xml to <GW_home>/conf/camel/ 

4. Run the following curl command to invoke the route. 

	curl -v -X GET http://localhost:9090/gw/customerGet/123
