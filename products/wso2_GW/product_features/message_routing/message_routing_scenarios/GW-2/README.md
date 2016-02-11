Applies To	: WSO2 GW 1.0.0
Created by	: Asanthi Kulasinghe

DESCRIPTION
===========

To test the ability of WSO2 Gateway to perform header based routing.


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
	   - Copy http_headerbased.xml to <GW_home>/conf/camel/ 
	  
4. Test header based routing by executing the following curl commands.

	
	Existing route : Routed to the matching endpoint
		curl http://localhost:9090/http_headerbased  -d @request.xml -H "routeId:ep1" -H "SOAPAction: urn::greet" -H "Content-Type: text/xml"

 	Existing route : Routed to the matching endpoint
		curl http://localhost:9090/http_headerbased  -d @request.xml -H "routeId:ep2" -H "SOAPAction: urn::greet" -H "Content-Type: text/xml"

 	Non-existing route : Routed to the default endpoint
		curl http://localhost:9090/http_headerbased  -d @request.xml -H "routeId:ep3" -H "SOAPAction: urn::greet" -H "Content-Type: text/xml"

	Invocation without route : Routed to the default endpoint
		curl -v -X POST http://localhost:9090/http_headerbased  -d @request.xml  -H "SOAPAction: urn::greet" -H "Content-Type: text/xml"

