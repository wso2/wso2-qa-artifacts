package MessageRouting.MessageSplitting;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.xmls;
import ballerina.lang.system;

@http:config {basePath:"/xpathsplitterwithoutnamespace"}
service<http> xpathSplitwithoutNameSpaceService {

    @http:POST{}
    @http:Path{value:"/"}
    resource xpathSplitwithoutNameSpaceResource(message m) {
        xml incomingPayload = messages:getXmlPayload(m);
	int sliptcount;
        sliptcount, _ = <int> xmls:getString(incomingPayload, "count(//StockDetails/Stocks)");
        
        message response = {};
        int i = 1;
        while (i <= sliptcount) {
            string stock = xmls:getString(incomingPayload, "//StockDetails/Stocks[" + i + "]");
            system:println(stock);
            i = i + 1;
        }

        reply response;
    }
}
