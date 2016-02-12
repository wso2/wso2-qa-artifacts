-------------------------------------------------------------------------

    Script: APIM_add_publish.jmx
    Author: Evanthika
    Modified by: Pubudu

Description:
- This script creates an api with the same name under two different tenant domains, publishes to the relevant store section and subscribes to the published apis.

Notes:
- This script was originally written to execute for API manager 1.9.0
- Due to the modifications in 1.9.1, following parameters had been added to the 'Create API' http request
	* endpoint_type
	* endpoint_config
	* production_endpoints
	* sandbox_endpoints
	* endpointType

Pre-Conditions:
- There should be a tenant domain with postfix 'evan.com'
- evan.com domain should have an admin user created with credentials provided in User Parameters section User_2 column

Server Parameters:
   * server - ip address of the server
   * port - Give the https servlet transport port (9443) with the server's port offset 
   * apiname - desired API name

User Parameters:
   * Provide usernaname and passsword of the super tenant (User 1 column) user and tenant user (User 2 column)
   * applicationId - for super tenant application id =1 , other tenants check provide the relevant application id.

Create API (HTTP Request):
  * Change the details the created API is populated with as required.

Loop Controller1 (Loop Controller):
- * Change the 'Loop Count' to determine the number of API's to be created
	

-------------------------------------------------------------------------
