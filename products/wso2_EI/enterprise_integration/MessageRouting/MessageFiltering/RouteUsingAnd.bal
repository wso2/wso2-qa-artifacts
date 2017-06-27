package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.jsons;
import MessageRouting.MessageFiltering.Endpoints as endpoints;

@http:BasePath{value: "/routeusingand"}
service UseANDService {

    @http:POST{}
    @http:Path{value:"/"}
    resource UseANDDResource (message m) {
	http:ClientConnector jsonEP = create http:ClientConnector(endpoints:jsonEPurl);
        string exchangeString = "nasdaq";
        string stockString = "IBM";
        json jsonMsg = messages:getJsonPayload(m);
	string exchange = messages:getHeader(m, "exchange");
        string stockvalue = jsons:getString(jsonMsg, "$.name");
	messages:setStringPayload( m, stockvalue);
        message response = {};
        
        // If stock name = "IBM" and exchange = "nasdaq" process the message
        	if (stockvalue == stockString && exchange == exchangeString) {
                response = http:ClientConnector.post(jsonEP, "/", m);
            
        }
	else {

               string errorpayload = "Message do not meet the filter criteria";
               messages:setStringPayload(response, errorpayload);
        }
        reply response;
        
    }
    
}
