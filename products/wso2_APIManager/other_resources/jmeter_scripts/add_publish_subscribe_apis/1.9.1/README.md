This folder will contain all the JMeter scripts used while testing API Manager

-----------------------------------------------------------------------------------------
Script: APIM_add_publish.jmx
Author: Evanthika
Modified by: Pubudu

Description:- This testcase creates an api with the same name under two different tenant domains, publishes to the relevant store section and subscribes to the published apis.

Server Parameters:-
server - ip address of the server
port - 9443 if running with offset 0
apiname - desired API name

Other variables:-
- In order to set the number of created APIs set the value of Test Plan --> Loop Controller => Loop count to a desired number

Pre-Conditions:-
- There should be a tenant domain with postfix 'evan.com'
- evan.com domain should have an admin user created with credentials provided in User Parameters section User_2 column


Notes:-
- This script was originally written to execute for API manager 1.9.0
- Due to the modifications in 1.9.1, following parameters had been added to the 'Create API' http request
	1. endpoint_type
	2. endpoint_config
	3. production_endpoints
	4. sandbox_endpoints
	5. endpointType

