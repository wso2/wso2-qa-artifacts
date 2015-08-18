Ref[1]
Scenario: When there is a message transformation for example SOAP to JSON in outSequence and if the BE return a SOAP Fault should return the fault as a JSON message to client without throwing any clas cast exception, etc.

1.Deploy SOAPFault1.xml to check when SOAP Fault return from BE handle properly within ESB and return to client with the proper message format to client.

If this issue cannot be fixed then

2. Deploy SOAPFault2.xml has filter mediator where this has been hadnle explicitly within the proxy.


1. https://support.wso2.com/jira/browse/AMAPRODSPRT-17