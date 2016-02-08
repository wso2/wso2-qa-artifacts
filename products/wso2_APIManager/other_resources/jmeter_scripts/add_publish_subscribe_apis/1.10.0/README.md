README

-------------------------------------------------------------------------
Script Name:- APIM_add_publish_FINAL.jmx
Author:- Pubudu D.P.
Supported Product:- API-M 1.10.0

About:-

This script logs into the publisher > creates an API > Publishes the API to the store > Subscribes to the API in store > Logs out from publisher

The above sequence is executed for super tenant and another tenant which is mentioned in pre-condition


Pre-Conditions:- 

- A tenant should be created prior to the execution



Server Parameter variables:-

pubserver - domain of the API-M publisher 
store server - domain of the API-M store
server - domain of the API-M gateway worker node
port - (if running locally with offset =0 provide the usual 9443. if running on a distributed setup then leave blank.)
apiname - desired api name

User Parameters
provide usernaname and passsword of the super tenant user and tenant user
applicationId - for super tenant application id =1 , other tenants check provide the relevant application id.


Loop Controller1 (DO NOT CHANGE) - Handles the login part for super tenant and sub tenant (Loop Controller =1 logs in to both super tenant and sub tenant at once with respective users)

Loop Controller2 - Determines how many APIs to be created under each tenant

APIcounter - Used to generate unique API name
NameID - Used to generate unique API name



-----------------------------------------------------------------------------


