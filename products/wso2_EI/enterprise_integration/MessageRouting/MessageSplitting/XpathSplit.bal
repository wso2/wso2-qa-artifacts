package MessageRouting.MessageSplitting;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.xmls;
import ballerina.lang.system;

@http:config {basePath:"/xpathsplitter"}
service<http> xpathSplitService {

   @http:POST{}
   @http:Path{value:"/"}
   resource xpathSplitResource(message m) {
       xml incomingPayload = messages:getXmlPayload(m);
       map namespace = {"m0":"http://services.samples"};
       int sliptcount;
       sliptcount, _ = <int> xmls:getStringWithNamespace(incomingPayload, "count(//m0:getQuote/m0:request)", namespace);

       message response = {};
       json beresponse = {"Response": "Success"};
       messages:setJsonPayload(response, beresponse);
       int i = 1;
       while (i <= sliptcount) {
           string stock = xmls:getStringWithNamespace(incomingPayload, "//m0:getQuote/m0:request[" + i + "]", namespace);
           system:println(stock);
          i = i + 1;
       }

       reply response;
   }
}
