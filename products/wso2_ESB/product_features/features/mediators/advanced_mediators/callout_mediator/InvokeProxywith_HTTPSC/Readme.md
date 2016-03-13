# Handling HTTP_SC in callout mediator

### Steps to verify the scenario

1. Download WSO2 ESB from [1]
2. Extract it to a folder of your choice
3. Create  a proxy service as per attahced "FetchHTTPSCWithCalloutMediator.xml"
4. Place the getQuote.xml file where you run the curl command
5. Execute the Curl command
> curl -v -d @getQuote.xml -H "Content-Type: text/xml; charset=utf-8" -H "SOAPAction:urn:getQuote" http://localhost:8280/services/HTTPSCProxy 


###### [1]: http://wso2.com/products/enterprise-service-bus/
