# README

This artifact is written to demonstrate the use of dynamic timeout value configuration. The value intended to be used as the timeout is taken by reading a local entry.

> Note: This particular sample is tested with WSO2 ESB 5.0.0 Alpha


### Contents 
  - Sequences: timout_test_seq.xml
  - API: TimoutTestAPI.xml
  - SOAP Mock Rest Service: REST-Project-1-soapui-project.xml
  - Local Entry: timeout.xml
  
### Preconditions
- ESB server should be up and running
- Soap Mock Service should be opened through SOAP UI and started (this mock service has a response delay of 20000ms)

### Steps
- Deploy the given local entry in WSO2 ESB
- Deploy the given sequence in WSO2 ESB after changing the ip address of the mock service accordingly
- Deploy the given API in WSO2 ESB
- Invoke the API
```sh
Example Request
http://10.100.5.63:8280/testapi
```
### Expected Outcome
When following request is sent, the value sent as the value given in the local entry will be used as the timeout value. The console will indicate the timeout value as below

```sh
Sample console output
2016-05-06 12:13:52,868]  WARN - TimeoutHandler Expiring message ID : urn:uuid:93536e47-7673-44f4-a3a6-e4e91ff0a75f; dropping message after timeout of : 5 seconds
```
