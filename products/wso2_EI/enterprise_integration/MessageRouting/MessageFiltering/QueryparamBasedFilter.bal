package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import MessageRouting.MessageFiltering.Endpoints as endpoints;

@http:BasePath{value: "/queryparamfilter"}
service queryparamFilterService {

    @http:GET{}
    @http:Path{value:"/"}
    resource queryparamFilterResource(message m, @http:QueryParam {value:"stockname"}string stockname) {
        http:ClientConnector stockEP = create http:ClientConnector(endpoints:stockEPurl);
	messages:setStringPayload( m, stockname);
        message response = {};

        if (stockname == "IBM") {
             response = http:ClientConnector.post(stockEP, "/", m);

        } else {
            string errorpayload = "Message do not meet the filter criteria";
            messages:setStringPayload(response, errorpayload);
        }

        reply response;
    }
}
