package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.system;
import ballerina.lang.jsons;

@http:BasePath {value:"/jsonStocks"}
service JSONStockQuoteService {
    
    @http:POST{}
@http:Path{value:"/"}
    resource JSONStockQuoteResource (message m) {
	string stock = messages:getStringPayload(m);
	system:println("simpleStockQuote = " + stock);
        message response = {};
        json payload = {"Stock":"", "value":"127.50"};
        jsons:set(payload, "$.Stock", stock);
        messages:setJsonPayload(response, payload);
        reply response;
        
    }
    
}
