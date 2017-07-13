package inter.sample;
import ballerina.lang.messages;
import ballerina.lang.jsons;
import ballerina.utils.logger;
import ballerina.lang.system;
import ballerina.net.http;
import ballerina.lang.strings;

function requestInterceptor (message m) (boolean, message) {
    http:ClientConnector bankService = create http:ClientConnector("http://localhost:9090/interceptorbackend");
    string context = http:getRequestURL(m);
    if (strings:equalsIgnoreCase(context, "/interceptorbackend/"))
    {
       system:println("bypassing interceptor.");
    }
    else{
    string requestpayload = messages:getHeader(m,"UDPX");
    json stat = {"val1":"test","udpx":"PLACEHOLDER"};
    stat.udpx = requestpayload;
    message msg = {};
    messages:setJsonPayload(msg,stat);
    message response = http:ClientConnector.post(bankService, "/", msg);
    json payload = messages:getJsonPayload(response);
    string out = "Client Connector POST: Interceptor was hit.";
    string j = jsons:toString(payload);
    system:println(out);
    logger:info(j);
    }

    return true, m;
}
