package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.jsons;
import ballerina.lang.messages;
import MessageRouting.MessageFiltering.Endpoints as endpoints;

@http:BasePath{value: "/jsonpathmultiplecasewithdefault"}
service JSONPathMultipleCaseWithDefaultService {

    @http:POST{}
    @http:Path{value:"/"}
    resource JSONPathMultipleCaseWithDefaultResource (message m) {
        http:ClientConnector jsonEP = create http:ClientConnector(endpoints:jsonEPurl);
        json jsonMsg = messages:getJsonPayload(m);
        string nameString = jsons:getString(jsonMsg, "$.name");
	    messages:setStringPayload( m, nameString);
        message response = {};
        
        // If name is 'nyse' then message routed to the backend, if not message discarded
        if (nameString == "IBM") {
             messages:setStringPayload( m, "Case01 IBM");
             response = http:ClientConnector.post(jsonEP, "/", m);
            
        } else if (nameString == "WSO2") {
             messages:setStringPayload( m, "Case02 WSO2");
             response = http:ClientConnector.post(jsonEP, "/", m);
            
        } else if (nameString == "Oracle") {
             messages:setStringPayload( m, "Case03 Oracle");
             response = http:ClientConnector.post(jsonEP, "/", m);
            
        } else {
             response = http:ClientConnector.post(jsonEP, "/", m);
        }
        reply response;
        
    }
}
