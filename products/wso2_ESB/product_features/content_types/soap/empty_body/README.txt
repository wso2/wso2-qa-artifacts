This proxy service will check if the message body is blank or not

1. add the CheckBodyProxy.xml proxy service.

2. Invoke this service with
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.carbon.wso2.org">
   <soapenv:Header/>
   <soapenv:Body>
   </soapenv:Body>
</soapenv:Envelope>

3. check again with some content in the body
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.carbon.wso2.org">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:echoString>
         <ser:s>Test</ser:s>
      </ser:echoString>
   </soapenv:Body>
</soapenv:Envelope>
