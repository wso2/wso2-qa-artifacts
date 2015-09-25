Introduction
------------
* This script will create defined number of APIs (Variables > no_of_api_to_create) with a specified prefix (Variables > api_prefix), and will subscribe to them (Variables > no_of_api_to_subscribe)

* Then it will get the list of subscribed APIs, and will invoke them defined number of cycles (api_invoke_count) Randomly, using a list of Access Tokens.

Pre-requisites
--------------
* Start an Application Server (which has JaxRS-Basic sample by default). 
* According to the JaxRS-Basic sample endpoint details, parameters in "addAPI" http request need to be updated.

Steps to execute the script
---------------------------

* Startup and API Manager 1.6.0 instance and create an API pointing to the JAX-RS endpoint which was mentioned in pre-requisites section above.

* Set the following variables according to your environment 
	# [Application ID] - This script will subscribe the APIs to Default Application. If you want to use a different app, update the Application ID in JMeter script > Variables > application_id
    # You need to set the Provider & Subscriber in JMeter script > Variables.
	# [IPs/Ports] - Publisher, Store and Gateway ports & ips need to set in JMeter script > Variables.
	# [API parameters] - Values in Variables > 'new_api_version', 'new_api_provider', and 'api_tier' will consider when creating APIs.

* Access tokes will be read from a list of Access tokens, and steps to configure it as follows.
	   > Subscribe to Default Application (Or to the application you want), and generate production keys.
	   > Open usertokenadd100.sql in gedit. Find and replace the value of "CONSUMER_KEY" in all the entries with the CONSUMER_KEY you generate in previous step.
	   > Source the usertokenadd100.sql script to your API Manager database. Varify the table for entered values
	   > Copy "user_tokens.csv" file to preferred location (ex. same location of script) and update the path to the file in JMeter script > Variables > production_access_token_list_path

NOTE : It is adviced to use a Unique 'api_prefix' for every run (or You can update the starting values of counters if you need to use the sam` prefix)

NOTE : Not tested with Multi-tenancy.

Known Issue : When it come to EOF if CSV, Access Token will pass as <EOF>, and that will fail a request after every 100 invocations.
