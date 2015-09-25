
- This script will create defined number of APIs (Variables > no_of_api_to_create) with a specified prefix (Variables > api_prefix), and will subscribe to them (Variables > no_of_api_to_subscribe)
- Then it will generate random numbers to generate subscribed APIs, and will invoke them defined number of cycles (Variables > api_invoke_count) Randomly, on all 3 Gateway nodes (GW1, GW2, GW3), using the Access Token of subscribed aplication (Variables > access_token).
- API will create based on JaxRS-Basic sample in Application Server. As a prerequisist, need to start a Application Server (which has JaxRS-Basic sample by default). According to the JaxRS-Basic sample endpoint details, parameters in "addAPI" http request need to be updated.
- This script will subscribe the APIs to Default Application. If you want to use a different app, update the Application id in jmeter script > Variables > application_id
- You need to set the Provider & Subscriber in jmeter script > Variables.
- Publisher, Store and Gateway ports & ips need to set in jmeter script > Variables.
- Values in Variables > 'new_api_version', 'new_api_provider', and 'api_tier' will consider when creating APIs.

NOTE : It is adviced to use a Unique 'api_prefix' for every run (or You can update the starting values of counters if you need to use the same prefix)

NOTE : Have to Alter URLs when using with Multi-tenancy.

.

