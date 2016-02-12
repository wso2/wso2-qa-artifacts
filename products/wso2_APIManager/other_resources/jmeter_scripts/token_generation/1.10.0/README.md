README
------------------------------------------------------------------------------

Script Name:- RenewToken.jmx
Author: Pubudu D.P
Supported Product: API-M 1.10.0


Description:
This script logs into the store > creates an App > generates a number of access tokens with a defined validity period > Stores the access tokens in a .csv file > Renews the access tokens for every x minues > Overwrites the .csv file with updated access tokens.

Pre-Condition:
An API should be created and published (WSO2 Application server should be running)

Script Parameters:
	pubserver - publisher domain
	storeserver - store domain
	port - https servlet transport port (9443) with the server's port offset (If running on a clustered setup provide the port exposed by the load balancer)
	httpsport - https port - 9443 for default pack / 443 for nginx)
	username - username
	password - password
	applicationname - desired application name
	tokenFilePath - file path where the tokens are stored
	keyFilePath - file path where consumer key/secret  pairs are stored
	max - number of applications of which tokens need to be renewed
	apiname - context of the api which needs to subscribe to the relevent application

Debug Sampler => Constant Timer:	
	Thread Delay (in milli seconds) - Determines how often access tokens are renewed

------------------------------------------------------------------------------

Script Name: InvokeApiWithTokenFromFile.jmx
Author: Pubudu D.P
Supported Product: API-M 1.10.0

Description:
This script reads the top most token from the 'token.csv' file created by 'RenewToken.jmx' and invokes the api continuously using that token.
This script and 'RenewTokenFinal_FINAL.jmx' are meant to be run parallelly, so that the api invocation will continue while the tokens are being renewed for a specific application.

Pre-Condition:
An API  with the endpoint pointed to the Echo service on WSO2 Application server should be created and published (WSO2 Application server should be running)
RenewToken.jmx should be already being executed and the access tokens should have been regenerated for the first time.

User Defined Parameters:
	server - gateway host
	port - http synapse transport port (8280) with the server's port offset 
	tokenFilePath - file path where the tokens are stored
	api - context of the api being invoked

CSV Data Set Config:
	Filename - Provide token.csv file path used in 'RenewToken.jmx' script to store access tokens


