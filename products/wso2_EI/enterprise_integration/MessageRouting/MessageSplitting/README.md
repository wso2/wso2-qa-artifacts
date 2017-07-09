###### **Product Version** - Tested on Ballerina 0.89 version
###### **Related testcases** - https://testlink.wso2.com/linkto.php?tprojectPrefix=EI7&item=testsuite&id=104368
&nbsp;
#### **Description**
These samples demonstrate the scenarios related to message splitting and cloning 
1. Split incoming message into different elements - JSONPathSplit.bal, XpathSplit.bal, XpathSplitwithoutNamespace.bal
2. Split incoming message into different elements and merge the content into the original message based on the given expression - XpathSplit&MergeToOriginal.bal
3. Split incoming message into different elements and create a new payload, including the split content - XpathSplit&CreatePayload.bal
4. Clone incoming message - CloneMessage.bal


#### **Pre-conditions**
Following service should be up and running before executing the above scenarios.
1. SimpleStockQuote Service - Start the SimpleStockQuote Service that bundles with the ESB500 product (Build SimpleStockQuoteService and then go to <ESB_HOME>/samples/axis2Server and execute sh axis2.sh to start the backend server)

#### **How to run this sample**

Download the samples and go to 'enterprise_integration' directory. Then execute "<Ballerina_HOME>/bin/ballerina run service MessageRouting/MessageSplitting/"


#### **Invoking the services**

##### **Service 01** - JSONPathSplit.bal
This service will split the incoming message based on the stocks as "[{"symbol":"IBM","price":"189.00"}][{"symbol":"WSO2","price":"230.18"}][{"symbol":"Oracle","price":"170.08"}]".

> _Request_ - http://localhost:9090/jsonpathsplitter 

> _HTTP Method_ - POST

> _Payload_ - 
``` 
{ 
  "StockDetails": {
    "StockExchange": "NASDAQ",
    "Country": "London",
    "address": {
      "streetAddress": "naist street",
      "city": "Nara",
      "postalCode": "630-0192"
    },
    "Stocks": [
      {
        "symbol": "IBM",
        "price": "189.00"
      },
      {
        "symbol": "WSO2",
        "price": "230.18"
      },
      {
        "symbol": "Oracle",
        "price": "170.08"
      }
      
    ]
  }
}
```

##### **Service 02** - XpathSplit.bal
This service will split the incoming message based on the symbol. (Check the product logs for the output)

> _Request_ - http://localhost:9090/xpathsplitter

> _HTTP Method_ - POST

> _Payload_ - 
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:m0="http://services.samples">
   <soapenv:Header/>
   <soapenv:Body>
      <m0:getQuote>
         <m0:request>
            <m0:symbol>Oracle</m0:symbol>
         </m0:request>
        <m0:request>
            <m0:symbol>WSO2</m0:symbol>
         </m0:request>
         <m0:request>
            <m0:symbol>IBM</m0:symbol>
         </m0:request>
      </m0:getQuote>
   </soapenv:Body>
</soapenv:Envelope>
```

##### **Service 03** - XpathSplitwithoutNamespace.bal
This service will split the incoming message based on the stocks. (Check the product logs for the output)

> _Request_ - http://localhost:9090/xpathsplitterwithoutnamespace

> _HTTP Method_ - POST

> _Payload_ - 
```
<StockDetails>
<StockExchange>NASDAQ</StockExchange>
<Country>London</Country>
    <address>
    <streetAddress>naist street</streetAddress>
    <city>Nara</city>
    <postalCode>630-0192</postalCode>
    </address>
    <Stocks>
        <symbol>IBM</symbol>
        <price>189.00</price>
    </Stocks>
    <Stocks>
        <symbol>WSO2</symbol>
        <price>230.18</price>
    </Stocks>
    <Stocks>
        <symbol>Oracle</symbol>
        <price>170.08</price>
    </Stocks>
</StockDetails> 
```
##### **Service 04** - XpathSplit&MergeToOriginal.bal
This service will split the incoming message based on the symbol and attach the split content to the original message and send to the 'SimpleStockQuoteService'. (Check the logs of 'SimpleStockQuoteService' to verify the service invocations)

> _Request_ - http://localhost:9090/xmlsliptmergedoriginal

> _HTTP Method_ - POST

> _PreRequisites_ - Deploy and Start the SimpleStockQuote Service 

> _Header_ - SOAPAction:urn:getQuote , Content-Type:text/xml;charset=UTF-8

> _Payload_ - 
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:m0="http://services.samples">
   <soapenv:Header/>
   <soapenv:Body>
      <m0:getQuote>
         <m0:request>
            <m0:symbol>IBM</m0:symbol>
         </m0:request>
        <m0:request>
            <m0:symbol>WSO2</m0:symbol>
         </m0:request>
         <m0:request>
            <m0:symbol>Oracle</m0:symbol>
         </m0:request>
      </m0:getQuote>
   </soapenv:Body>
</soapenv:Envelope>
```

##### **Service 05** - XpathSplit&CreatePayload.bal
This service will split the incoming message based on the symbol and create a new message using the split content and send to the 'SimpleStockQuoteService'. (Check the logs of 'SimpleStockQuoteService' to verify the service invocations)

> _Request_ - http://localhost:9090/xpathsplitcreatepayload

> _HTTP Method_ - POST

> _PreRequisites_ - Deploy and Start the SimpleStockQuote Service 

> _Header_ - SOAPAction:urn:getQuote , Content-Type:text/xml;charset=UTF-8

> _Payload_ - 
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:m0="http://services.samples">
   <soapenv:Header/>
   <soapenv:Body>
      <m0:getQuote>
         <m0:request>
            <m0:symbol>IBM</m0:symbol>
         </m0:request>
        <m0:request>
            <m0:symbol>WSO2</m0:symbol>
         </m0:request>
         <m0:request>
            <m0:symbol>Oracle</m0:symbol>
         </m0:request>
      </m0:getQuote>
   </soapenv:Body>
</soapenv:Envelope>
```

##### **Service 06** - CloneMessage.bal
This service will create clones of an incoming message and send to different backend services (Check the logs of 'SimpleStockQuoteService' to verify the service invocations)

> _Request_ - http://localhost:9090/clone

> _HTTP Method_ - POST

> _PreRequisites_ - Start multiple instances of SimpleStockQuote Service in following http ports (9000,9001,9003) ex: ./axis2server.sh -http 9001 -https 9005 -name MyServer1.

> _Header_ - SOAPAction:urn:getQuote , Content-Type:text/xml;charset=UTF-8

> _Payload_ - 
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:m0="http://services.samples">
   <soapenv:Header/>
   <soapenv:Body>
      <m0:getQuote>
         <m0:request>
            <m0:symbol>IBM</m0:symbol>
         </m0:request>
      </m0:getQuote>
   </soapenv:Body>
</soapenv:Envelope>
```
