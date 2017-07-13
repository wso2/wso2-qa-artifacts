package inter.sample;
import ballerina.lang.messages;
import ballerina.lang.system;
import ballerina.utils.logger;
import ballerina.lang.jsons;

function requestInterceptor (message m) (boolean, message) {
    message msg = {};
    json chainmsg = messages:getJsonPayload(m);
    chainmsg.value = "Interceptor 5 was hit.";
    string out = jsons:toString(chainmsg);
    system:println(out);
    logger:info(out);
    messages:setJsonPayload(msg,chainmsg);
    return true, msg;
}
