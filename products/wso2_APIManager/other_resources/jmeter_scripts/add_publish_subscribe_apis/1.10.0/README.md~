-------------------------------------------------------------------------

    Script Name:- APIM_add_publish_subscribe.jmx
    Author:- Pubudu D.P.
    Supported Product:- API-M 1.10.0

Description:
- This script logs into the publisher > creates an API > Publishes the API to the store > Subscribes to the API in store > Logs out from publisher
- The above sequence is executed for super tenant and another tenant which is mentioned in pre-condition

Pre-Conditions:
- A tenant should be created prior to the execution

Server Parameter Variables:
- pubserver - domain of the API-M publisher 
- store server - domain of the API-M store
- server - domain of the API-M gateway worker node
- port -  https servlet transport port (9443) with the server's port offset (If running on a distributed setup leave this blank)
- apiname - desired api name

User Parameters:
- Provide usernaname and passsword of the super tenant (User 1 column) user and tenant user (User 2 column)
- applicationId - for super tenant application id =1 , other tenants check provide the relevant application id.

Create API Test (HTTP Request):
- Change the details the created API is populated with as required.

Loop Controller1 (Loop Controller):
- Handles the login part for super tenant and sub tenant (Loop Controller =1 logs in to both super tenant and sub tenant at once with respective users) (DO NOT CHANGE) 

Loop Controller2 (Loop Controller): 
- Determines how many APIs to be created under each tenant
	
APIcounter (Counter):
- Used to generate unique API name

NameID (Counter):
- Used to generate unique API name

-----------------------------------------------------------------------------


