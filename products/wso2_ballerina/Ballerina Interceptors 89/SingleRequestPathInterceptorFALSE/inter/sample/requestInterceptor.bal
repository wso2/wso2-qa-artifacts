package inter.sample;
import ballerina.lang.system;
import ballerina.utils.logger;

function requestInterceptor (message m) (boolean, message) {
    string msg = "--Request path interceptor: Intereceptor was hit.--";
    system:println(msg);
    logger:info(msg);
    return false, m;
}
