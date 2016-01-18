README

-------------------------------------------------------------------------
Script Name:- APIM_add_publish_FINAL.jmx
Author:- Pubudu D.P.
Supported Product:- API-M 1.10.0

Pre-Conditions:- 

- Following parameter variables should be 
- A tenant should be created prior to the execution



Server Parameter variables:-

pubserver - domain of the API-M publisher 
store server - domain of the API-M store
server - domain of the API-M gateway worker node
port - (if running locally with offset =0 provide the usual 9443. Otherwise leave blank)
apiname - desired api name

User Parameters
provide usernaname and passsword of the super tenant user and tenant user
applicationId - for super tenant application id =1 , other tenants check provide the relevant application id.


About:-

This script logs into the publisher > creates an API > Publishes the API to the store > Subscribes to the API in store > Logs out from publisher

The bbove sequence is executed for super tenant and another tenant which is mentioned in pre-condition

-----------------------------------------------------------------------------


