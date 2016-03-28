# README

This artifact is written to demonstrate the use of xslt mediator in converting json to xml

> Note: This particular sample is tested with WSO2 ESB 5.0.0 M2 and WSO2 AS 530


### Contents 
  - XSLT transformation file: jsontoxml.xslt
  - sequences: xslt_seq_10.xml
  - Proxy service: XsltProxy9.xml
  - Axis2 Service: InfoParser.aar


### Preconditions
- Upload the .aar file to WSO2 AS

### Steps
- Upload the given XSLT transformation file to governance registry of WSO2 ESB
- Deploy the given sequence in WSO2 ESB
- Deploy the given proxy service in WSO2 ESB by changing endpoint ip address accordingly.
- Use the below request to invoke the proxy service

```sh
Request URL: http://<ip of ESB server>:<port of ESB server>/services/XsltProxy9
E.g. Request URL: http://1.2.3.4:8280/services/XsltProxy9
Http Method: POST
Request body:
{  
    
      "welcomePerson":{  
         "name":"WSO2",
         "address":"test",
         "age":"21"
      }
   
}
Content type: application/json
```

### Expected Outcome
Similar log entries should be visible indicating conversion from JSON to XML
```sh
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"><soapenv:Body><jsonObject xmlns="http://test.wso2.org">
   <welcomePerson>
      <name>WSO2</name>
      <address>test</address>
      <age>21</age>
   </welcomePerson>
</jsonObject></soapenv:Body></soapenv:Envelope>
```
Similar log entry should be visible indicating further transformation as expected by the backend
```sh
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"><soapenv:Header><test:To xmlns:test="http://test.wso2.org">urn:welcomePerson</test:To></soapenv:Header><soapenv:Body><welcomePerson xmlns="http://test.wso2.org">
      <name>WSO2</name>
      <address>test</address>
      <age>21</age>
   </welcomePerson></soapenv:Body></soapenv:Envelope>
```
Finally the endpoint should be reached and following should be returned
```sh
HelloWSO2
```
