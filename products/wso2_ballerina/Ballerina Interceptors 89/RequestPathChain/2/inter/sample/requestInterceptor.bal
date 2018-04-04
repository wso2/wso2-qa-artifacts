package inter.sample;
import ballerina.lang.messages;
import ballerina.lang.jsons;
import ballerina.utils.logger;
import ballerina.lang.system;

function requestInterceptor (message m) (boolean, message) {
    message msg = {};
    json chainmsg = messages:getJsonPayload(m);
    chainmsg.value = "Interceptor 2 was hit.";
    messages:setJsonPayload(msg,chainmsg);
    string out = jsons:toString(chainmsg);
    system:println(out);
    logger:info(out);

    return true, msg;
}
