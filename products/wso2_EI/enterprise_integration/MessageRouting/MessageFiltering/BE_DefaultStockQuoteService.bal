package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.xmls;
import ballerina.lang.system;

@http:config {basePath:"/defaultStockQuote"}
service<http> defaultStockQuote {

    @http:POST{}
    @http:Path{value:"/"}
    resource stocks(message m) {
	string stock = messages:getStringPayload(m);
        system:println("defaultStockQuote = " + stock);
        message response = {};
        xml payload = xmls:parse("<DefaultstockQuoteResponse><symbol>test</symbol><price>170.00</price><volume>20</volume></DefaultstockQuoteResponse>");
        xmls:setString(payload,"//DefaultstockQuoteResponse/symbol/text()",stock);
        messages:setXmlPayload(response, payload);
        reply response;
    }
}
