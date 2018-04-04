package inter.sample;
import ballerina.lang.system;
import ballerina.lang.jsons;
import ballerina.lang.messages;

function responseInterceptor (message m) (boolean, message) {
	system:println("Response interceptor was hit.");
        string out = jsons:toString(messages:getJsonPayload(m));
        system:println("Json payload accessed from within the interceptor "+out);
	return true, m; 
}

