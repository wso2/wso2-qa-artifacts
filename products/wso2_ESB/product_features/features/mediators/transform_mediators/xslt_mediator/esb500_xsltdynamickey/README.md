# README

This artifact is written to demonstrate the use of xslt mediator with dynamic key. The property mediator is used in conjuction with xslt mediator to achieve this. 

> Note: This particular sample is tested with WSO2 ESB 5.0.0 M2 and WSO2 AS 530


### Contents 
  - XSLT transformation file: XSLTTransformer.xsl
  - sequences: xslt_seq_1.xml
  - Proxy service: XsltProxy1.xml
  - Axis2 Service: InfoParser.aar


### Preconditions
- Upload the .aar file to WSO2 AS
- Place the XSLT transformation file inside <ESB_Home>/repository/samples/resources/transform folder

### Steps
- Change the registry provider to "org.wso2.carbon.mediation.registry.ESBRegistry" from "org.wso2.carbon.mediation.registry.WSO2Registry" in WSO2_ESB synapse configuration
- Add the following entry to registry provider section
```sh
<parameter name="root">file:repository/samples/resources/</parameter>
```
After adding the registry provider section should be as following
```sh
 <registry provider="org.wso2.carbon.mediation.registry.ESBRegistry">
        <parameter name="root">file:repository/samples/resources/</parameter>
        <parameter name="cachableDuration">15000</parameter>
    </registry>
```

- Deploy the given sequence in WSO2 ESB
- Deploy the given proxy service in WSO2 ESB by changing endpoint ip address pointing to the deployed InfoParser service
- Invoke the proxy service


### Expected Outcome
Similar log entries should be visible indicating the request sent to backend
```sh
<?xml version='1.0' encoding='UTF-8'?>
<soapenv:Envelope
    xmlns:soapenv="http://www.w3.org/2003/05/soap-envelope">
    <soapenv:Body>
        <p:welcomePerson
            xmlns:p="http://test.wso2.org">
            <!--0 to 1 occurrence-->
            <xs:name
                xmlns:xs="http://test.wso2.org">test
            </xs:name>
            <!--0 to 1 occurrence-->
            <xs:address
                xmlns:xs="http://test.wso2.org">add
            </xs:address>
            <!--0 to 1 occurrence-->
            <xs:age
                xmlns:xs="http://test.wso2.org">23
            </xs:age>
        </p:welcomePerson>
    </soapenv:Body>
</soapenv:Envelope>
```
Similar log entry should be visible after transformation (actual request sent to backend)
```sh
<?xml version='1.0' encoding='UTF-8'?>
<soapenv:Envelope
    xmlns:soapenv="http://www.w3.org/2003/05/soap-envelope">
    <soapenv:Body>
        <p:welcomePerson
            xmlns:p="http://test.wso2.org">
            <!--0 to 1 occurrence-->
            <xs:name
                xmlns:xs="http://test.wso2.org">test
            </xs:name>
            <!--0 to 1 occurrence-->
            <xs:address
                xmlns:xs="http://test.wso2.org">add
            </xs:address>
            <!--0 to 1 occurrence-->
        </p:welcomePerson>
    </soapenv:Body>
</soapenv:Envelope>
```
Since the request is not in the format expected by the backend, the request will fail.
