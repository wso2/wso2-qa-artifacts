#Introduction#

SlowService.aar serves requests with a delay of 45 seconds.
slowServiceProxy.xml spilts the request and sends the request to the server running on the port which corresponds to the value passed along with each request.

#How to verify the scenario#
1. Deploy slowServiceProxy.xml in <ESB_HOME>/repository/deployment/server/synapse-configs/default/proxy-services
2. Deploy SlowService.aar on Application Server or multiple application servers.
3. Invoke the proxy service with the following request. 

The value for parameter 'x' should correspond with the port of the server hosting SlowService.aar 

`<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.wso2.com">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:echoString1>
         <ser:x>9764</ser:x>
         <ser:x>9765</ser:x>
         <ser:x>9766</ser:x>
        </ser:echoString1>
   </soapenv:Body>
</soapenv:Envelope>`
