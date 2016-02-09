README

------------------------------------------------------------------------------

Script Name:- RenewTokenFinal_FINAL.jmx
Author:- Pubudu D.P
Supported Product:- API-M 1.10.0

Pre-Condition:-
- Echo service API should be created and published to the store (WSO2 Application server is required to be running)

About:-

This script logs into the store > creates an App > generates a number of access tokens with a defined validity period > Stores the access tokens in a .csv file > Renews the access tokens for every x minues > Overwrites the .csv file with updated access tokens.

Script Parameters:-
pubserver:- publisher domain
storeserver:- store domain
<<<<<<< HEAD
port: If running on a standalone setup provide the https servlet port. If running on a clustered setup provide nginx port
=======
port: (http port:- 8080 for default pack / 80 for nginx)
>>>>>>> dd527d7ad931e1776ac48756301e38bfa25e4319
httpsport:- (https port - 9443 for default pack / 443 for nginx)
apiname:- desired API name
username:- username
password:- password
applicationname:- desired application name
tokenFilePath:- file path of tokens to be store
keyFilePath:- file path of consumer key/secret to be stored
<<<<<<< HEAD
max:- number of keys to be generated. This value also creates the same number of applications. I.E an application per key.
=======
max:- number of keys to be generated
>>>>>>> dd527d7ad931e1776ac48756301e38bfa25e4319

------------------------------------------------------------------------------

Script Name:- InvokeNewToken.jmx
Author:- Pubudu D.P
Supported Product:- API-M 1.10.0

Pre-Condition:-
- Echo service API should be created and published to the store (WSO2 Application server is required to be running)
<<<<<<< HEAD
- When creating the Echo service API, please provide the API context as 'echoservice'
- RenewTokenFinal_FINAL.jmx should be already being executed and the access tokens should have been regenerated for the first time.



CSV Data Set Config:-
Filename:- Provide .csv file name used in 'RenewTokenFinal_FINAL.jmx' script to store access tokens

Other:-
Continues to refresh tokens forever > Loop count determines how many times the keys will be renewed within intervals.
=======
- RenewTokenFinal_FINAL.jmx should be already being executed and the access tokens should have been regenerated for the first time.


CSV Data Set Config:-
Filename:- Provide .csv file name used in 'RenewTokenFinal_FINAL.jmx' script to store access tokens
>>>>>>> dd527d7ad931e1776ac48756301e38bfa25e4319
