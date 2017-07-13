package inter.sample;
import ballerina.lang.system;
import ballerina.lang.jsons;
import ballerina.lang.messages;
import ballerina.utils.logger;

function responseInterceptor (message m) (boolean, message) {
    json chainmsg = {"value":"Interceptor 1 was hit."};
    message msg = {};
    messages:setJsonPayload(msg,chainmsg);
    string out = jsons:toString(chainmsg);
    system:println(out);
    logger:info(out);

    return true, msg;

}

