SOAP Client to REST Backend service using HTTP End point
=========================================================
Step:

1. Start "axis2Server" from samples and deploy "SimpleStockQuoteService"
Step 2: Create a HTTP end point (say, HTTPEndPoint, Ref Synap1.xml)
Step 3: Create a pass through proxy (Say TestProxy, Ref Synap2.xml)
Step 4: Place TCPMon between Client & WSO2 ESB and WSO2 ESB & Back End Service for monitoring
Step 5: Invoke the Client request from the AXIS2CLIENT folder ($ESB_HOME/samples/axis2Client)
e.g. ant stockquote -Dsymbol=IBM -Dmode=quote -Daddurl=http://localhost:8281/services/TestProxy
Step 6: The backend service resposnses can be monitored through TCPMon

Note: This is for HTTP Method 'POST' only as it is using a SOAP request. If you want to configure for the rest of the methods such as GET|PUT, etc change the method value as apprpriate.

<http uri-template="https://localhost:9100/{uri.var.path}/{uri.var.name}" method="get">

Also this can be invoked and verified for https as well. However due to encription TCPMon cannot be use for monitoring. Tools such as Wireshark with Fidler might be helpful for HTTPS traffic analysing.

To Verify PUT|PUSH|DELETE methods need to use the sample JAXRS Basic service.

Step 1. Ref[1] for configuration and use HTTP Endpoint instead of address end point
step 2. Send SOAP request for PUSH|PUT|DELETE methods using soapUI. Ref[2]
step 3: HTTP Methods and relevant Synapses used.
GET	- Synap3.xml (Relevant Passthorugh Proxy Server Synapse Ref Synap7.xml)
DELETE	- Synap4.xml (Relevant Passthorugh Proxy Server Synapse Ref Synap7.xml)
PUT	- Synap5.xml (Relevant Passthorugh Proxy Server Synapse Ref Synap8.xml)
POST	- Synap6.xml (Relevant Passthorugh Proxy Server Synapse Ref Synap8.xml)

1. http://docs.wso2.org/wiki/display/ESB460/Using+REST+with+a+Proxy+Service
2. http://docs.wso2.org/wiki/display/AS501/JAX-RS+Basics


