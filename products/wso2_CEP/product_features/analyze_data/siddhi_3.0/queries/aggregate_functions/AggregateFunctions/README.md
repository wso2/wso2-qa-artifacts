Product Version - Complex Event Processor 4.0.0
### Steps to create event flows in super admin

1. Go to <CEP HOME>/repository/deployment/server
2. Copy given files in to relevant locations
	-eventpublishers
	-eventreceivers
	-eventstreams
	-executionplans

Note - After added these files you can monitor whether these components getting deployed through the terminal.

3. Run jmeter and open the testscript attached (AggregateFunctions.jmx)

   configuring jmeter script
	-Add server name or IP
	-For 'HTTP requests' send events using 9763 port
	-For 'HTTPS requests' send events using 
		port-9443
		protocol -'https'
		Add Authorization details 

Note - If CEP setup in storm distributed cluster mode, make sure you send events to worker node

4. Results should be logged in the terminal 



### Steps to create event flows in tenant

1. Create a tenant 
2. Go to <CEP HOME>/repository/tenants/
 There should be a folder created for the tenant id

 
3. Copy given files in to relevant locations inside the 'tenant id' folder (ex:<CEP HOME>/repository/tenants/1/)
	-eventpublishers
	-eventreceivers
	-eventstreams
	-executionplans

Note - After added these files you can monitor whether these components getting deployed through the terminal.

4. Run jmeter and open the testscript attached (AggregateFunctions.jmx)

   configuring jmeter script
	-Path in the HTTP Request should be like /endpoints/t/<tenant domain>/tReceiver (ex:/endpoints/t/test.com/tReceiver)
	-Add server name or IP
	-For 'HTTP requests' send events using 9763 port
	-For 'HTTPS requests' send events using 
		port-9443
		protocol -'https'
		Add Authorization details 

Note - If CEP setup in storm distributed cluster mode, make sure you send events to worker node

5. Results should be logged in the terminal 
