##  Callout Mediator with source property and Target Property
### Steps to verify the scenario
1. Start WSO2 appserver (offset1) and use echo service url (ex: http://localhost:9764/services/echo)
2. Use the synapse configuration given in SourceXpath_TargetProperty.xml
3. Send 'echoInt' requests to http://localhost:8280/ using Soap UI. (Assune ESB has been started with offset=0 hence calling main sequence as http://localhost:8280/)
 ###### EchoInt Request as follows: 

 <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:echo="http://echo.services.core.carbon.wso2.org">
   <soapenv:Header/>
   <soapenv:Body>
      <echo:echoInt>
         <!--Optional:-->
         <in>1</in>
      </echo:echoInt>
   </soapenv:Body>
</soapenv:Envelope>

