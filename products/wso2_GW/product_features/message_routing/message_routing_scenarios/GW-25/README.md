Applies To	: WSO2 GW 1.0.0

Testcase	: https://testlink.wso2.com/linkto.php?tprojectPrefix=GW&item=testcase&id=GW-25

Created by	: Asanthi Kulasinghe


DESCRIPTION
===========

To test the ability of WSO2 Gateway to pass headers along with the request.

INSTRUCTIONS
============

1. Copy request.xml to the path where the Curl command is executed.

2. Start a WSO2 Application Server with a port offset of 10 . Make sure the web application 'jaxrs_content_negotiation' is built and deployed on the server. [1]

3. The testcase can be executed by adding the route to camel-context.xml as well as by hot deploying the route in a seperate file.

	To execute the test case by deploying the route via camel-context.xml
	   - Replace <GW_home>/conf/camel/camel-context.xml file with camel-context.xml
	   - Restart the server

	To execute the test case by hot deploying the route
	   - Remove the above route from <GW_home>/conf/camel/camel-context.xml
	   - Restart the server 
	   - Copy passheader.xml to <GW_home>/conf/camel/ 

4. Run the following curl commands to see the same service returning different responses based on the 'Accept' header specified.

	curl -v -X GET http://localhost:9090/gw/customerGetXML/123
	curl -v -X GET http://localhost:9090/gw/customerGetJSON/123

[1] https://docs.wso2.com/display/AS521/JAX-RS+Sample+on+Content+Negotiation
