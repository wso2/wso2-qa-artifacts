# README

This artifact is written to demonstrate the use of filter mediator. This filter mediator will read property "Action" from the message context and will direct the request to the relevant endpoint depending on the value set as Action.

> Note: This particular sample is tested with WSO2 ESB 5.0.0 M2 and WSO2 AS 530


### Contents 
  - Sequences: filter_1.xml
  - Proxy service: FilterMediator_1.xml
  - Axis2 Service: MenuFilterService.aar
  
### Preconditions
- ESB server should be up and running
- Axis2 service should be deployed in WSO2 AS

### Steps
- Deploy the given sequence in WSO2 ESB
- Deploy the given proxy service in WSO2 ESB by changing endpoint to refer the deployed axis2 service.
- Invoke the proxy service


### Expected Outcome
When following request is sent, the getMacMenu service will be called because the Action property consists of getMacMenu
Request
```sh
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sam="http://sample.wso2.org">
   <soapenv:Header/>
   <soapenv:Body>
      <sam:getMacMenu/>
   </soapenv:Body>
</soapenv:Envelope>
```
Console
```sh
[2016-04-01 16:26:15,415]  INFO - LogMediator To: /services/FilterMediator_1.FilterMediator_1HttpSoap11Endpoint, WSAction: urn:getMacMenu, SOAPAction: urn:getMacMenu, MessageID: urn:uuid:772bb749-ec69-4beb-bbf0-0a2cff7d1866, Direction: request, Envelope: <?xml version='1.0' encoding='utf-8'?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sam="http://sample.wso2.org"><soapenv:Body>
      <sam:getMacMenu/>
   </soapenv:Body></soapenv:Envelope>
```
When below request is sent, the getOtherMenu service will be called, because the Action property consists of getOtherMenu
```sh
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sam="http://sample.wso2.org">
   <soapenv:Header/>
   <soapenv:Body>
      <sam:getOtherMenu/>
   </soapenv:Body>
</soapenv:Envelope>
```
Console
```sh
[2016-04-01 16:58:11,656]  INFO - LogMediator To: /services/FilterMediator_1.FilterMediator_1HttpSoap11Endpoint, WSAction: urn:getOtherMenu, SOAPAction: urn:getOtherMenu, MessageID: urn:uuid:6705b803-685b-4409-b34d-de2a46a8ddaa, Direction: request, Envelope: <?xml version='1.0' encoding='utf-8'?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sam="http://sample.wso2.org"><soapenv:Body>
      <sam:getOtherMenu/>
   </soapenv:Body></soapenv:Envelope>
```
