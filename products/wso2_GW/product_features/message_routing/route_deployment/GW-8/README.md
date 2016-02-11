Applies To	: WSO2 GW 1.0.0
Created by	: Asanthi Kulasinghe

DESCRIPTION
===========
To test the ability to WSO2 Gateway to load message routing configurations from route files included in <Gateway_Home>/conf/camel/ folder other than camel-context.xml

INSTRUCTIONS
============

1. Copy request.xml to the path where the Curl command is executed.

2. Start WSO2 Application Server with port offset set to 10.Make sure the axis2 service 'HelloService' is available on the server.

3. Copy new_route.xml to <GW_home>/conf/camel/ 

4. Start the server

5. Run the following curl command to test the deployed route.

	curl http://localhost:9090/test  -d @request.xml  -H "SOAPAction: urn::greet" -H "Content-Type: text/xml"
