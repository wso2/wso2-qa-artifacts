package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.xmls;
import MessageRouting.MessageFiltering.Endpoints as endpoints;
import ballerina.lang.strings;


@http:config {basePath:"/caseinsensitivefilter"}
service<http> CaseInsensitiveFilter {

    @http:POST{}
    @http:Path{value:"/"}
    resource CaseInsensitiveResource(message m) {
        xml incomingPayload = messages:getXmlPayload(m);
	http:ClientConnector stockEP = create http:ClientConnector(endpoints:stockEPurl);
	
        // If the stock symbol is 'foo' then route to the backend, if not discard.
        string stockValue = xmls:getString(incomingPayload,"//getQuote/symbol/text()");
        messages:setStringPayload( m,stockValue);
        message response = {};

        if (strings:equalsIgnoreCase(stockValue,"foo")) {
             response  = http:ClientConnector.post(stockEP, "/", m);
            
        }  
        else {
             string errorpayload = "Message do not meet the filter criteria";
            messages:setStringPayload(response,errorpayload);
        }

        reply response;
    }
}
