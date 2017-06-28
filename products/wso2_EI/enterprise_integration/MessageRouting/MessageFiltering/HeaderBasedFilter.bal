package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import MessageRouting.MessageFiltering.Endpoints as endpoints;


@http:BasePath{value: "/headerfilter"}
service headerFilterService {

    @http:GET{}
    @http:Path{value:"/"}
    resource headerFilterResource(message m) {
	http:ClientConnector stockEP = create http:ClientConnector(endpoints:stockEPurl);
	
        // Filter messages based on the header value
	string headervalue = messages:getHeader(m, "name");
	messages:setStringPayload( m, headervalue);
        message response = {};

        if (headervalue == "IBM") {

             response = http:ClientConnector.post(stockEP, "/", m);
            
        }  
        else {
             string errorpayload = "Message do not meet the filter criteria";
             messages:setStringPayload(response, errorpayload);
        }

        reply response;
    }
}
