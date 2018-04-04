package inter.sample;
import ballerina.lang.messages;
import ballerina.lang.jsons;
import ballerina.utils.logger;
import ballerina.lang.system;
import ballerina.net.http;
import ballerina.lang.strings;

function requestInterceptor (message m) (boolean, message) {
    http:ClientConnector bankService = create http:ClientConnector("http://localhost:9090/interceptorbackend");
    message msg = {};
    string context = http:getRequestURL(m);
    if (strings:equalsIgnoreCase(context, "/interceptorbackend/"))
    {
	msg = m;
        system:println("bypassing interceptor.");
    }
    else{
    message response = http:ClientConnector.get(bankService, "/", msg);
    json payload = messages:getJsonPayload(response);
    string out = "Client Connector GET: Interceptor was hit.";
    string j = jsons:toString(payload);
    system:println(out);
    logger:info(j);
    messages:setJsonPayload(msg,payload);
    }

    return true, msg;
}
