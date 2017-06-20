package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.xmls;
import MessageRouting.MessageFiltering.Endpoints as endpoints;


@http:BasePath{value: "/xpathspecialcharachterfilter"}
service xpathwithoSpeacialCharachterFilter {

    @http:POST{}
    @http:Path{value:"/"}
    resource xpathwithoutNameSpaceResource(message m) {
        xml incomingPayload = messages:getXmlPayload(m);
	http:ClientConnector stockEP = create http:ClientConnector(endpoints:stockEPurl);
	
        // If the stock symbol is 'bar' then route to the backend, if not discard.
        string stockValue = xmls:getString(incomingPayload, "//stock[@id<3 and @id>1]/text()");
        messages:setStringPayload( m, stockValue);
        message response = {};

        if (stockValue == "bar") {
             response = http:ClientConnector.post(stockEP, "/", m);
            
        }  
        else {
             string errorpayload = "Message do not meet the filter criteria";
            messages:setStringPayload(response, errorpayload);
        }

        reply response;
    }
}
