package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.xmls;
import MessageRouting.MessageFiltering.Endpoints as endpoints;

@http:BasePath{value: "/xpathmultiplecasewithdefault"}
service XpathMultipleCaseWithDefaultService {

    @http:POST{}
    @http:Path{value:"/"}
    resource XpathMultipleCaseWithDefaultResource (message m) {
	xml incomingPayload = messages:getXmlPayload(m);
	http:ClientConnector stockEP = create http:ClientConnector(endpoints:stockEPurl);
	
        // If the stock symbol is 'foo' then route to the backend, if not discard.
        string stockValue = xmls:getString(incomingPayload, "//getQuote/symbol/text()");
        messages:setStringPayload( m, stockValue);
        message response = {};

        if (stockValue == "IBM") {
             messages:setStringPayload( m, "Case01 IBM");
             response = http:ClientConnector.post(stockEP, "/", m);
            
        } else if (stockValue == "WSO2") {
             messages:setStringPayload( m, "Case02 WSO2");
             response = http:ClientConnector.post(stockEP, "/", m);
            
        } else if (stockValue == "Oracle") {
             messages:setStringPayload( m, "Case03 Oracle");
             response = http:ClientConnector.post(stockEP, "/", m);
            
        } else {
             response = http:ClientConnector.post(stockEP, "/", m);
        }

        reply response;
    }
    
}
