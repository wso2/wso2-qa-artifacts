# README

This artifact is written to demonstrate the behaviour of REST_URL_POSTFIX when the context consists of non standard characters such as spaces. The non standard characters are encoded before sending to the back end so that the URI is in the standard format expected by RFC] Uniform Resource Identifier (URI): Generic Syntax (http://tools.ietf.org/html/rfc3986)

> Note: This particular sample is tested with WSO2 ESB 5.0.0 Beta and WSO2 AS 5.3.0


### Contents 
  - Sequences: test_seq_1.xml
  - API: TestAPI.xml
  - Rest Service: SampleRestService.war
  
### Preconditions
- ESB server should be up and running
- Rest Service should be deployed in WSO2 AS


### Steps
- Deploy the given sequence in WSO2 ESB after changing the ip address accordingly
- Deploy the given API in WSO2 ESB
- Invoke the API with the following request
```sh
Request: GET
http://<ip>:8280/testapi?id=1&name=jane&address=wso2
```
### Expected Outcome
When following request is sent, the REST_URI_POSTFIX is appended after encoding. This can be observed in the console, when wire logs are enabled

```sh
Sample console output
[2016-05-20 15:13:42,549] DEBUG - wire HTTP-Sender I/O dispatcher-1 << "GET /SampleRestService/restservice/TestUserService/user/users%20address/address%20new/2016.05?id=1&name=jane&address=wso2 HTTP/1.1[\r][\n]"
```
