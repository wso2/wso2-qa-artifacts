-------------------------------------------------------------------------

    Script Name:- InvokeAPI_Http.jmx
    Author:- Pubudu D.P.
    Supported Product:- API-M 1.10.0


Description:
- The purpose of this script is to invoke an API concurrently using multiple threads using http port. This can be used as a long running test.

Pre-Conditions:
- An API  with the endpoint pointed to the Echo service on WSO2 Application server should be created and published (WSO2 Application server should be running)
- User should be subscribed to the API
- A permenant access token should be generated (by providing -1 as the expiration time)

User Defined Variables:
- server: server domain
- port -  http synapse transport port (8280) with the server's port offset 
- token: provide the permenant access token here
- api: context of the above api

Thread Group:
- Change 'Thread properties' as required.
------------------------------------------------------------------------------

    Script Name:- InvokeAPI_Https.jmx
    Author:- Pubudu D.P.
    Supported Product:- API-M 1.10.0


Description:
- The purpose of this script is to invoke an API concurrently using multiple threads using https port. This can be used as a long running test.

Pre-Condition:
- An API  with the endpoint pointed to the Echo service on WSO2 Application server should be created and published (WSO2 Application server should be running)
- User should be subscribed to the API
- User should be subscribed to the API
- A permenant access token should be generated (by providing -1 as the expiration time)

User Defined Variables:
- server: server domain
- port -  https synapse transport port (8243) with the server's port offset 
- token: provide the permenant token here
- api: context of the above api

Thread Group:
- Change 'Thread properties' as required.
------------------------------------------------------------------------------

