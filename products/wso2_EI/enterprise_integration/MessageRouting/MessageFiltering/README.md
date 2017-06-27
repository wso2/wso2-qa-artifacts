#### **Description**
Sample scenarios related to message filtering based on following criteria;
1. based on the JSONPath - JSONPathFilter.bal
2. based on JSONPath when the request contains a json array - JSONArrayFilter.bal
3. based on the XPath without namespace - XPathwithoutNameSpace.bal
4. based on the XPath with namespace - XPathNameSpaceFilter.bal
5. based on the Xpath when request contains attributes - XPathwithAttributes.bal
6. based on any of the maching xpath criteria - AnyMatchingXPathFilter.bal
7. based on the XPath when xpath contains '<' and '>' charachters - XPathwithspecialcharachters.bal
8. based on the header value - HeaderBasedFilter.bal
9. based on query paramter - QueryparamBasedFilter.bal
10. based on maching conditions with AND opertaion - RouteUsingAnd.bal
11. based on maching conditions with OR opertaion - RouteUsingOR.bal
12. based on maching conditions with AND & OR opertaions - RouteUsingAndOr.bal
13. based on maching conditions with AND, OR & NOT opertaions - RouteUsingAndOrNot.bal
14. when multiple cases exists for a matching Xpath - XPathMultipleCaseWithDefaultCase.bal
15. when multiple cases exists for a matching JOSNpath - JSONPathMultipleCaseWithDefaultCase.bal
16. based on the case sensitivity of the value - NonCaseSensitiveFilter.bal


#### **How to run this sample**

Download the samples and go to 'enterprise_integration' directory. Then execute "<Ballerina_HOME>/bin/ballerina run service MessageRouting/MessageFiltering/"


#### **Invoking the services**

##### **Service 01** - JSONPathFilter.bal
If name is "nyse" then message goes to the BE, else message dropped
> _Request_ - http://localhost:9090/jsonpathfilter 

> _Payload_ - {"name" : "nyse"}

##### **Service 02** - JSONArrayFilter.bal
If symbol of the second element in stock array is "WSO2" then message goes to the BE, else message dropped
> _Request_ - http://localhost:9090/jsonarrayfilter 

> _Payload_ - 
```
{
  "StockExchange": "NASDAQ",
  "Country" : "London",
  "address"  : {
    "streetAddress": "naist street",
    "city"         : "Nara",
    "postalCode"   : "630-0192"
  },
  "Stocks": [
    {
      "symbol"  : "IBM",
      "price": "189.00"
    },
    {
      "symbol"  : "WSO2",
      "price": "230.18"
    }
  ]
}
```

##### **Service 03** - XPathwithoutNameSpace.bal
If symbol is "foo" then message goes to the BE, else message dropped

> _Request_ - http://localhost:9090/xpathwithoutNameSpacefilter 

> _Payload_ - ```<getQuote><symbol>foo</symbol></getQuote>```

##### **Service 04** - XPathNameSpaceFilter.bal
If symbol is "IBM" then message goes to the BE, else message dropped
> _Request_ - http://localhost:9090/xpathNameSpacefilter 

> _Header_ - SOAPAction:urn:getQuote , Content-Type:text/xml;charset=UTF-8

> _Payload_ - 

```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services.samples" xmlns:xsd="http://services.samples/xsd">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:getQuote>
         <!--Optional:-->
         <ser:request>
            <!--Optional:-->
            <xsd:symbol>IBM</xsd:symbol>
         </ser:request>
      </ser:getQuote>
   </soapenv:Body>
</soapenv:Envelope> 
```

##### **Service 05** - XPathwithAttributes.bal
If stock name of the id '3' is "WSO2" then message goes to the BE, else message dropped

> _Request_ - http://localhost:9090/xpathwithattributesfilter 

> _Payload_ - 
```
<getQuote>
<stock id="1">foo</stock>
<stock id="2">bar</stock>
<stock id="3">IBM</stock>
<stock id="4">WSO2</stock>
</getQuote>
```


##### **Service 06** - AnyMatchingXPathFilter.bal
If 'ID' of the given xml equals to '990' then message processed, else message dropped
> _Request_ - http://localhost:9090/anymatchingxpathfilter 


> _Payload_ - 
```
(1) 
<EmployeePersonalDetails>
<ID>990</ID>
<Name>Peter</Name>
<Age>27</Age>
<City>Colombo</City>
</EmployeePersonalDetails>
(2) 
<EmployeeDepartmentInfo>
<ID>990</ID>
<Team>EI</Team>
<SubTeam>EE</SubTeam>
</EmployeeDepartmentInfo> 
```

##### **Service 07** - XPathwithspecialcharachters.bal
Select the message where the stock 'ID' less than 3 and more than 1, then process the message, else dropped the message
> _Request_ - http://localhost:9090/xpathspecialcharachterfilter 

> _Payload_ - 
```
<getQuote>
<stock id="1">foo</stock>
<stock id="2">bar</stock>
<stock id="3">IBM</stock>
<stock id="4">WSO2</stock>
</getQuote>
```

##### **Service 08** - HeaderBasedFilter.bal
If the 'name' header is 'IBM' then process the message, else message dropped
> _Request_ - http://localhost:9090/headerfilter

> _HTTP_Method_ - GET

> _Header_ - name : IBM

##### **Service 09** - QueryparamBasedFilter.bal
If the query parameter value is 'IBM' the process the message, else message dropped
> _Request_ - http://localhost:9090/queryparamfilter?stockname=IBM

> _HTTP_Method_ - GET


##### **Service 10** - RouteUsingAnd.bal
If the both ariterias met then process the message, else message dropped
> _Request_ - http://localhost:9090/routeusingand

> _Header_ - exchange : nasdaq

> _Payload_ - {"name" : "IBM"}

##### **Service 11** - RouteUsingOR.bal
If the request fulfils any of the given criteria then process the message, else message dropped
> _Request_ - http://localhost:9090/routeusingor

> _Header_ - exchange : nasdaq

> _Payload_ - {"name" : "IBM"}

##### **Service 12** - RouteUsingAndOr.bal
If stock url contains "routeusingandor" AND stockvalue = "IBM"  Then verify whether price >= 180 OR exchange = "nasdaq". if criteria met message processed, else message dropped
> _Request_ - http://localhost:9090/routeusingandor

> _Header_ - exchange : nasdaq

> _Payload_ - 
```
{   "StockExchange": "NASDAQ",
  "Country" : "London",
  "address"  : {
    "streetAddress": "naist street",
    "city"         : "Nara",
    "postalCode"   : "630-0192"
  },
  "Stocks": [     {
      "symbol"  : "IBM",
      "price": "189.00"
    },
    {
      "symbol"  : "WSO2",
      "price": "230.18"
    }   ]
}
```

##### **Service 13** - RouteUsingAndOrNot.bal
If the 'requestor' is not "Peter" then verify If stock url contains "routeusingandor" AND stockvalue = "IBM", Then verify whether price >= 180 OR exchange = "nasdaq". if criteria met message processed, else message dropped
> _Request_ - http://localhost:9090/routeusingandornot

> _Header_ - exchange : nasdaq , requestor : EITeam

> _Payload_ - 
```
{
  "StockExchange": "NASDAQ",
  "Country" : "London",
  "address"  : {
    "streetAddress": "naist street",
    "city"         : "Nara",
    "postalCode"   : "630-0192"
  },
  "Stocks": [
    {
      "symbol"  : "IBM",
      "price": "189.00"
    },
    {
      "symbol"  : "WSO2",
      "price": "230.18"
    }
  ]
}
```

##### **Service 14** - XPathMultipleCaseWithDefaultCase.bal
If multiple cases exists for a given xpath, direct to the correct case based on the value and process the message, else send the message to the default case.
> _Request_ - http://localhost:9090/xpathmultiplecasewithdefault

> _Payload_ - 
```
<getQuote>
    <symbol>IBM</symbol>
</getQuote>
```


##### **Service 15** - JSONPathMultipleCaseWithDefaultCase.bal
If multiple cases exists for a given xpath, direct to the correct case based on the value and process the message, else send the message to the default case.
> _Request_ - http://localhost:9090/jsonpathmultiplecasewithdefault

> _Payload_ -  {"name" : "WSO2"} 


##### **Service 16** - NonCaseSensitiveFilter.bal
If symbol is "foo/Foo/FOO" (without considering the casesensitivity of the extracted value) then message goes to the BE, else message dropped

> _Request_ - http://localhost:9090/caseinsensitivefilter 

> _Payload_ - ```<getQuote><symbol>FOO</symbol></getQuote>```
