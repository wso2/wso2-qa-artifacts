Introduction
------------

This scenario will verify whether JSON path evaluation can be done using custom sequences

Steps
-----
1. Create a sequence with the config given in log_in_message.xml file and save under /_system/governance/apimgt/customsequences/in in the registry
 
2. Create an API with the sequence created above
 
a) Login to API Publisher and create an API
b) Specify all required data
c) From Manage tab, tick the checkbox Message Mediation Policies and select the sequence log_in_message which you created in the previou step.
d) Save and publish the API

3. Subscriber to an application
a) Login to the API Store
b) Subscribe to the API

4. Invoke the API
	
Run the Jmeter script named API_invoke-JaxrsService.jmx and check the backend logs

5. You should see the ID which you passed from the request, being printed from the Log mediator

[2015-09-30 13:46:14,358]  INFO - LogMediator To: /api2/1.0.0/customerservice/customers, MessageID: urn:uuid:a652fa98-f9e2-4ee9-be52-a1f45c0ed920, Direction: request, id = 2AA737C2A066172356FA7F9F37ABCB6A
