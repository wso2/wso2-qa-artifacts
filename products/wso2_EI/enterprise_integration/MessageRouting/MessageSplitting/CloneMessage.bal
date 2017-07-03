package MessageRouting.MessageSplitting;

import ballerina.net.http;
import ballerina.lang.messages;

@http:config {basePath:"/clone"}
service<http> cloneService {

   @http:POST{}
   @http:Path{value:"/"}
   resource cloneResource(message m) {
       http:ClientConnector stockEP1 = create http:ClientConnector("http://localhost:9000/services/SimpleStockQuoteService");
       http:ClientConnector stockEP2 = create http:ClientConnector("http://localhost:9001/services/SimpleStockQuoteService");
       http:ClientConnector stockEP3 = create http:ClientConnector("http://localhost:9003/services/SimpleStockQuoteService");
       xml incomingPayload = messages:getXmlPayload(m);
       message msg1  = messages:clone(m);
       message response = {};
       
       response = http:ClientConnector.post(stockEP1, "/", msg1);
       response = http:ClientConnector.post(stockEP2, "/", msg1);
       response = http:ClientConnector.post(stockEP3, "/", msg1);


       reply response;
   }
}
