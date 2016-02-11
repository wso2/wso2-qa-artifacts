Applies To	: WSO2 GW 1.0.0
Created by	: Asanthi Kulasinghe

DESCRIPTION
===========

To test the ability of WSO2 Gateway to define custom error messages and associate them with exceptions.

INSTRUCTIONS
============

1. Copy request.xml to the path where the Curl command is executed.

2. The testcase can be executed by adding the route to camel-context.xml as well as by hot deploying the route in a seperate file.

	To execute the test case by deploying the route via camel-context.xml
	   - Replace <GW_home>/conf/camel/camel-context.xml file with camel-context.xml
	   - Restart the server

	To execute the test case by hot deploying the route
	   - Remove the above route from <GW_home>/conf/camel/camel-context.xml
	   - Restart the server 
	   - Copy custom_error_route.xml to <GW_home>/conf/camel/ 

3. Run the following curl command to execute the route to see the custom error message b eing thrown.
   ** Note that the backend server is not started here, in order to throw the relevent exception.
	
	curl http://localhost:9090/custom_error_route  -d @request.xml -H "SOAPAction: urn:greet" -H "Content-Type: text/xml"

