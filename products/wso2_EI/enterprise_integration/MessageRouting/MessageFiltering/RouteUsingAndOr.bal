package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.jsons;
import MessageRouting.MessageFiltering.Endpoints as endpoints;
import ballerina.lang.strings;

@http:config {basePath:"/routeusingandor"}
service<http> UseANDandORService {

    @http:POST{}
    @http:Path{value:"/"}
    resource UseANDandORResource (message m) {
	http:ClientConnector jsonEP = create http:ClientConnector(endpoints:jsonEPurl);
        json jsonMsg = messages:getJsonPayload(m);
        string requesturl = http:getRequestURL(m);
        boolean urlexists = strings:contains(requesturl, "routeusingandor");
	    string exchange = messages:getHeader(m, "exchange");
	    float price;
        price, _= <float> jsons:getString(jsonMsg, "$.Stocks[0].price");
        string stockvalue = jsons:getString(jsonMsg, "$.Stocks[0].symbol");
	    
	    messages:setStringPayload( m, stockvalue);
        message response = {};
        
        // If stock url contains "routeusingandor" AND stockvalue = "IBM" 
        	if (urlexists && stockvalue == "IBM" ) {
        	    // Verify whether price >= 180 OR exchange = "nasdaq"
        	    if (price >= 180.00 || exchange == "nasdaq" ){
        	        response = http:ClientConnector.post(jsonEP, "/", m);
        	    } else {
                    string errorpayload = "Message do not meet the filter criteria";
                    messages:setStringPayload(response, errorpayload);
                }
        }
	else {
               string errorpayload = "Message do not meet the filter criteria";
               messages:setStringPayload(response, errorpayload);
        }
        reply response;
        
    }
    
}
