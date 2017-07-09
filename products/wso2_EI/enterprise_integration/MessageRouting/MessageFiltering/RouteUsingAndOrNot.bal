package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.jsons;
import MessageRouting.MessageFiltering.Endpoints as endpoints;
import ballerina.lang.strings;

@http:config {basePath:"/routeusingandornot"}
service<http> UseAndOrNotService {

    @http:POST{}
    @http:Path{value:"/"}
    resource UseAndOrNotResource (message m) {
	http:ClientConnector jsonEP = create http:ClientConnector(endpoints:jsonEPurl);
        json jsonMsg = messages:getJsonPayload(m);
        string requesturl = http:getRequestURL(m);
        string urlexists;
        urlexists, _ = <string> strings:contains(requesturl, "routeusingandor");
	    string exchange = messages:getHeader(m, "exchange");
	    string requestor = messages:getHeader(m, "requestor");
	    float price;
        price, _ = <float> jsons:getString(jsonMsg, "$.Stocks[0].price");
        string stockvalue = jsons:getString(jsonMsg, "$.Stocks[0].symbol");
	    
	    messages:setStringPayload( m, stockvalue);
        message response = {};
        
        // If requestor not euqal "Peter" then process the message 
        if (requestor != "Peter" ) {
            
            // If stock url contains "routeusingandor" AND stockvalue = "IBM" 
            if (urlexists == "true" && stockvalue == "IBM" ) {
                
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
            
        } else {
            string errorpayload = "You do not have permission to execute";
            messages:setStringPayload(response, errorpayload);
        }
        	
        reply response;
        
    }
    
}
