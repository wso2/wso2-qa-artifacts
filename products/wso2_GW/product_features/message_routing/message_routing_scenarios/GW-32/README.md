Applies To	: WSO2 GW 1.0.0
Created by	: Asanthi Kulasinghe

DESCRIPTION
===========

To test the ability of WSO2 Gateway to perform service chaining among SOAP backends. 
** Note that message mediation in this scenario is not handled by the gateway. WSO2 ESB constructs the SOAP request expected by the second backend.

INSTRUCTIONS
============

1. Copy request.xml to the path where the Curl command is executed.

2. Start 2 WSO2 Application Server instances with port offset 10 and 20. Make sure the axis2 service 'HelloService' is available on both servers.

3. Start a WSO2 ESB server with port offset 1. Copy the content of esb_source_definition.xml to its source view. 

4. The testcase can be executed by adding the route to camel-context.xml as well as by hot deploying the route in a seperate file.

	To execute the test case by deploying the route via camel-context.xml
	   - Replace <GW_home>/conf/camel/camel-context.xml file with camel-context.xml
	   - Restart the server

	To execute the test case by hot deploying the route
	   - Remove the above route from <GW_home>/conf/camel/camel-context.xml
	   - Restart the server 
	   - Copy servicechaining_soap.xml to <GW_home>/conf/camel/ 

5. Run the following curl command to invoke the route. 

	curl -v http://localhost:9090/servicechaining_soap -d @request1.xml  -H "SOAPAction: urn:echoInt" -H "Content-Type: application/xml"
