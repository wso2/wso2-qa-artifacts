import ballerina.lang.messages;
import ballerina.lang.strings;
import ballerina.net.http;
import ballerina.lang.system;
import ballerina.lang.jsons;

@http:config{basePath:"/interceptorbackend"}
service<http> CustomerMgtService {

    @http:GET{}
    @http:POST{}
    @http:Path {value:"/"}
    resource customers (message m) {
        json payload = {};
        string httpMethod = http:getMethod(m);
        if (strings:equalsIgnoreCase(httpMethod, "GET")) {
            payload = {"Status":"backened was hit with a GET"};

        }
        else {
            json j = messages:getJsonPayload(m);
            system:println(jsons:toString(j));
            payload = {"Status":"backend was hit with a POST"};

        }
        message response = {};
        messages:setJsonPayload(response, payload);
        reply response;

    }

}
