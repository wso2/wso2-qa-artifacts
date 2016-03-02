Applies To	: WSO2 GW 1.0.0

Test case	: https://testlink.wso2.com/linkto.php?tprojectPrefix=GW&item=testcase&id=GW-9

Created by	: Asanthi Kulasinghe


DESCRIPTION
===========

To test the ability of WSO2 Gateway to give priority to route definitions in custom route files over route definitions in camel-context.xml, when routes with the same routeId exist in both camel-context.xml and a custom route file. (By associating a custom error handler with the route in the custom route file)

INSTRUCTIONS
============

1. Copy request.xml to the path where the Curl command is executed.

2. Replace <GW_home>/conf/camel/camel-context.xml file with camel-context.xml

3. Copy custom_error_route.xml to <GW_home>/conf/camel/ 

4. Restart the server

5. Run the following curl command to observe the route in the custom route file (associated with the custom error handler) being invoked.
   ** Note that the backend server is not started here, in order to throw the relevent exception.

	curl http://localhost:9090/test_route  -d @request.xml  -H "SOAPAction: urn::greet" -H "Content-Type: text/xml"

