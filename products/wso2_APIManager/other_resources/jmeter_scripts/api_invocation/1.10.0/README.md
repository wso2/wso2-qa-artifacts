README

Script Name:- InvokeAPI_Http.jmx
Author:- Pubudu D.P.
Supported Product:- API-M 1.10.0

About:-
The purpose of this script is to invoke an API concurrently using multiple threads using http port. This can be used as a long running test.

Pre-Condition:-
- Echo service API should be created and published to the store (WSO2 Application server is required to be running)
- User should be subscribed to the API
- A permenant access token should be generated (by providing -1 as the expiration time)


User Defined Variables:-
server:- server domain
port:- provide the http port (8280 for default pack)
token:- provide the permenant token here
------------------------------------------------------------------------------

Script Name:- InvokeAPI_Https.jmx
Author:- Pubudu D.P.
Supported Product:- API-M 1.10.0

Pre-Condition:-
- Echo service API should be created and published to the store (WSO2 Application server is required to be running)
- User should be subscribed to the API
- A permenant access token should be generated (by providing -1 as the expiration time)

About:-
The purpose of this script is to invoke an API concurrently using multiple threads using https port. This can be used as a long running test.

User Defined Variables:-
server:- server domain
port:- provide the http port (8243 for default pack)
token:- provide the permenant token here

------------------------------------------------------------------------------

