import ballerina.lang.messages;
import ballerina.net.http;
import ballerina.lang.jsons;
import ballerina.lang.system;
import ballerina.utils.logger;

@http:config {basePath:"/hello"}
service<http> helloWorldTwo {

    @http:GET{}
    @http:Path {value:"/"}
    resource sayHello (message m) {
        message response = {};
	//fetching the json passed through the request path interceptors
        json j = messages:getJsonPayload(m);
	string out = jsons:toString(j);
	logger:info(out);
	system:println(out);
	messages:setJsonPayload(response,j);
        reply response;
    
    }
    
}
