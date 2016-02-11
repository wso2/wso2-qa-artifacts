Applies To	: WSO2 GW 1.0.0
Created by	: Asanthi Kulasinghe

DESCRIPTION
===========

To test the ability of WSO2 Gateway to give priority to the latest route definition when several custom route files, each containing a route with the same routeId is deployed.

INSTRUCTIONS
============

1. Copy request.xml to the path where the Curl command is executed.

2. Start 2 WSO2 Application Server with port offsets set to 10 and 20.Make sure the axis2 service 'HelloService' is available on both servers.

3. Start the Gateway Server.

4. Copy route1.xml to <GW_home>/conf/camel/

5. Run the following curl command to invoke the endpoint in the relevant route in route1.xml

	curl http://localhost:9090/customError  -d @request.xml  -H "SOAPAction: urn::greet" -H "Content-Type: text/xml"

6. Copy route2.xml to <GW_home>/conf/camel/

7. Run the above curl command again to to observe the endpoint in the route in route2.xml being invoked.

