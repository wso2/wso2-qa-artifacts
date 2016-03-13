Applies To	: WSO2 GW 1.0.0

Test case	: https://testlink.wso2.com/linkto.php?tprojectPrefix=GW&item=testcase&id=GW-33

Created by	: Asanthi Kulasinghe


DESCRIPTION
===========

To test the ability of WSO2 Gateway to give priority to route definitions in custom route files over route definitions in camel-context.xml, when routes with the same routeId exist in both camel-context.xml and a custom route file. (Using 2 different endpoints in the 2 route configurations containing the same routeId)

INSTRUCTIONS
============

1. Copy request.xml to the path where the Curl command is executed.

2. Start 2 WSO2 Application Servers instances with port offsets set to 10 and 20. Make sure the axis2 service 'HelloService' is available on both servers.

3. Replace <GW_home>/conf/camel/camel-context.xml file with camel-context.xml

4. Copy test_route.xml to <GW_home>/conf/camel/ 

5. Restart the server

6. Setup a tcpmon to intercept the calls between

    	Gateway and the Application server with port offset 10 : Forward calls to port 1010 to 9773
    	Gateway and the Application server with port offset 20 : Forward calls to port 2020 to 9783

7. Run the following curl command to observe the route in the custom route file being invoked.

	curl http://localhost:9090/test_route  -d @request.xml  -H "SOAPAction: urn::greet" -H "Content-Type: text/xml"

