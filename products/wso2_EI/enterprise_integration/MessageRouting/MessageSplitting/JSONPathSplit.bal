package MessageRouting.MessageSplitting;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.jsons;
import ballerina.lang.system;

@http:config {basePath:"/jsonpathsplitter"}
service<http> JOSNPathSplitService {

   @http:POST{}
   @http:Path{value:"/"}
   resource JOSNPathSplitResource(message m) {
       
      json jsonMsg = messages:getJsonPayload(m);
      json arraylengthjson = jsons:getJson(jsonMsg,"$..Stocks.length()");
      var arraylengthint, _ = (int) arraylengthjson[0];
      int arraylength  = arraylengthint - 1;

       message response = {};
        json beresponse = {"Response": "Success"};
        messages:setJsonPayload(response, beresponse);
        
       int i = 0;
       while (i <= arraylength) {
           json stock = jsons:getJson(jsonMsg, "$..Stocks[" + i + "]");
           system:println(stock);
          i = i + 1;
       }

       reply response;
   }
}
