package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.xmls;

@http:BasePath{value: "/xpathNameSpacefilter"}
service xpathNameSpacefilter {

    @http:POST{}
    @http:Path{value:"/"}
    resource XPathNameSpaceResource(message m) {
        http:ClientConnector stockEP = create http:ClientConnector("http://localhost:9000/services/SimpleStockQuoteService");
        string stockQuote = "IBM";
        xml incomingPayload = messages:getXmlPayload(m);
        map namespace = {"ser":"http://services.samples","xsd":"http://services.samples/xsd"};
        // filter messages based on stock name
        string stock = xmls:getStringWithNamespace(incomingPayload, "//ser:getQuote/ser:request/xsd:symbol/text()", namespace);
        message response = {};

        if (stockQuote == stock) {
            response = http:ClientConnector.post(stockEP, "/", m);
            
        } else {
            
            string errorpayload = "Message do not meet the filter criteria";
            messages:setStringPayload(response, errorpayload);
            
        }

        reply response;
    }
}
