Applies To	: WSO2 GW 1.0.0

Testcase	: https://testlink.wso2.com/linkto.php?tprojectPrefix=GW&item=testcase&id=GW-1

Created by	: Asanthi Kulasinghe


DESCRIPTION
===========

To test the ability to invoke REST endpoints via a route deployed on WSO2 Gateway.
 
INSTRUCTIONS
============

1. Copy request.xml to the path where the Curl command is executed.

2. Start WSO2 Application Server with a port offset of 10.Make sure the web application 'jaxrs_basic' is available.

3. The testcase can be executed by adding the route to camel-context.xml as well as by hot deploying the route in a seperate file.

	To execute the test case by deploying the route via camel-context.xml
	   - Replace <GW_home>/conf/camel/camel-context.xml file with camel-context.xml
	   - Restart the server
	  
	To execute the test case by hot deploying the route
	   - Remove the routes from <GW_home>/conf/camel/camel-context.xml
	   - Restart the server 
	   - Copy rest.xml to <GW_home>/conf/camel/ 
	  
4. Execute the following commands to test support for different HTTP methods

	curl -v -X GET http://localhost:9090/gw/customerGet/123 
	curl -v -X POST http://localhost:9090/gw/customerAdd -d "<Customer><name>TestCustomer2</name></Customer>"  -H "Content-Type: text/xml"
	curl -v -X PUT http://localhost:9090/gw/customerUpdate -d "<Customer><id>131</id><name>Custo
	curl -v -X DELETE http://localhost:9090/gw/customerDel/129

