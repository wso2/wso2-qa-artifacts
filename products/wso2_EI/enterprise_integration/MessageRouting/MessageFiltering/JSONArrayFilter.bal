package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.jsons;
import ballerina.lang.messages;
import MessageRouting.MessageFiltering.Endpoints as endpoints;

@http:config {basePath:"/jsonarrayfilter"}
service<http> JSONArrayFilterServie {
    
    @http:POST{}
    @http:Path{value:"/"}
    resource JSONArrayFilterResource (message m) {
	http:ClientConnector jsonEP = create http:ClientConnector(endpoints:jsonEPurl);
        string stocksymbol = "WSO2";
        json jsonMsg = messages:getJsonPayload(m);
        string symbol = jsons:getString(jsonMsg, "$.Stocks[1].symbol");
        messages:setStringPayload( m, symbol);
        message response = {};
        
        // If symbol is 'WSO2' then message routed to the backend, if not message discarded
        if (symbol == stocksymbol) {
            response = http:ClientConnector.post(jsonEP, "/", m);
            
        }
        reply response;
        
    }
    
}
