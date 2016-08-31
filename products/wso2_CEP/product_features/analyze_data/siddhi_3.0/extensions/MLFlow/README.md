Product Version - Complex Event Processor 4.0.0

##### Pre-requisites
1. Machine Learning features should be installed in the CEP setup  
(refer : *https://docs.wso2.com/display/CEP400/Installing+Machine+Learner+Features* for instructions on installing ML features for CEP )

### Steps to create event flows in super admin

1. Go to *<CEP HOME>/repository/deployment/server*
2. Copy given files in to relevant locations
	* eventpublishers
	* eventreceivers
	* eventstreams
	* executionplans

Note - Edit the ml file path in executionplan to your ml model. Given ml model (downloaded-ml-model) is taken from the default ml model attached in ML product'.

3. Run jmeter and open the testscript attached (MLevents.jmx)

   configuring the jmeter script
   	* Add server name or IP
	* For 'HTTP requests' send events using 9763 port
	* For 'HTTPS requests' send events using 
		- port-9443
		- protocol -'https'
		- Add Authorization details 

4. Results should be logged in the terminal 



### Steps to create event flows in tenant 



1. Create a tenant 

2. Go to *<CEP HOME>/repository/tenants/*
 There should be a folder created for the tenant id

 
3. Copy given files in to relevant locations inside the 'tenant id' folder (ex:<CEP HOME>/repository/tenants/1/)
	* eventpublishers
	* eventreceivers
	* eventstreams
	* executionplans

Note - Edit the ml file path in executionplan to your ml model. Given ml model (downloaded-ml-model) is taken from the default ml model attached in ML product'.

4. Run jmeter and open the testscript attached (MLevents.jmx)

   configuring the jmeter script
	* Path in the HTTP Request should be like /endpoints/t/**<tenant domain>**/tReceiver (ex:/endpoints/t/test.com/tReceiver)
	* Add server name or IP
	* For 'HTTP requests' send events using 9763 port
	* For 'HTTPS requests' send events using 
		- port-9443
		- protocol -'https'
		- Add Authorization details 

5. Results should be logged in the terminal 
