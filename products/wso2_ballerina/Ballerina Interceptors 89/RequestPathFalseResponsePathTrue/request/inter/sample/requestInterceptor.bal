package inter.sample;
import ballerina.lang.system;
import ballerina.utils.logger;
import ballerina.net.http;

function requestInterceptor (message m) (boolean, message) {
    string msg = "--Request path interceptor: Intereceptor was hit.--";
    http:setStatusCode(m,401);
    system:println(msg);
    logger:info(msg);
    return false, m;
}
