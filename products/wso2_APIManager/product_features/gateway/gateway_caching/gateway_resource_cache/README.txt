Need to have WSO2AS with JaxRS_Basic sample application as the backend of API.

- Set HostName/IP & Ports for Gateways
- Create the API as "first_api1/1.0.0". Set the new_api_version (1.0.0), api_prefix (first_api), and api_name(1). 
- Set api_invoke_count to a bigger value such as 1000000.
- Set access_token which is relavant to the Subscriber in store.
- Set thread_duration to the duration you want to keep invoking the API.

Use "add_15000_customers_to_jaxrsBasic.jmx" to add 15000 customers to JaxRS_Basic sample
Use "Invoke_15000_different_urls_to_exhaust_resource_cache.jmx" to invoke JaxRS_Basic sample to get above created 15000 customers, with unique URLs.

