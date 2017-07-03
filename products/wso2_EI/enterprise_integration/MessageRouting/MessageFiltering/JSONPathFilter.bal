package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.jsons;
import ballerina.lang.messages;
import MessageRouting.MessageFiltering.Endpoints as endpoints;

@http:config {basePath:"/jsonpathfilter"}
service<http> JSONPathFilter {
    
    @http:POST{}
    @http:Path{value:"/"}
    resource JSONPathResource (message m) {
	http:ClientConnector jsonEP = create http:ClientConnector(endpoints:jsonEPurl);
        string nyseString = "nyse";
        json jsonMsg = messages:getJsonPayload(m);
        string nameString = jsons:getString(jsonMsg, "$.name");
	messages:setStringPayload( m, nameString);
        message response = {};
        
        // If name is 'nyse' then message routed to the backend, if not message discarded
        if (nameString == nyseString) {
            response = http:ClientConnector.post(jsonEP, "/", m);
            
        }
        reply response;
        
    }
    
}
