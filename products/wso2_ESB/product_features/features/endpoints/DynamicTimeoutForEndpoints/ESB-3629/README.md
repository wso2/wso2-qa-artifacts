# README

This artifact is written to demonstrate the use of dynamic timeout value configuration. The value intended to be used as the timeout is taken by reading a query parameter.

> Note: This particular sample is tested with WSO2 ESB 5.0.0 Alpha


### Contents 
  - Sequences: timout_test_property_seq.xml
  - API: TimoutTestPropertyAPI.xml
  - SOAP Mock Rest Service: REST-Project-1-soapui-project.xml
  
### Preconditions
- ESB server should be up and running
- Soap Mock Service should be opened through SOAP UI and started (this mock service has a response delay of 20000ms)

### Steps
- Deploy the given sequence in WSO2 ESB after changing the ip address of the mock service accordingly
- Deploy the given API in WSO2 ESB
- Invoke the API while providing query parameters.
```sh
Example Request
http://10.100.5.63:8280/testpropertyapi?a=5000
```


### Expected Outcome
When following request is sent, the value sent as a query parameter will be read and used as the timeout value. The console will indicate the timeout value as below

```sh
Sample console output
2016-05-06 12:13:52,868]  WARN - TimeoutHandler Expiring message ID : urn:uuid:93536e47-7673-44f4-a3a6-e4e91ff0a75f; dropping message after timeout of : 5 seconds
```


