package MessageRouting.MessageFiltering;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.xmls;
import ballerina.lang.system;
import ballerina.lang.errors;

@http:BasePath{value: "/anymatchingxpathfilter"}
service AnyMatchingXpathFilterService {

    @http:POST{}
    resource AnyMatchingXpathFilterResource(message m) {
        string empID = "990";
        string var1;
        string var2;
        message response = {};
        errors:Error e = {};
        xml incomingPayload = messages:getXmlPayload(m);

            try {
                var1 = xmls:getString(incomingPayload, "//EmployeeDepartmentInfo/ID/text()");
            } 
            catch (errors:Error ex) {
                system:println("xpath not exists.");
            }
            try {
                var2 = xmls:getString(incomingPayload, "//EmployeePersonalDetails/ID/text()");
            } 
            catch (errors:Error ex) {
                system:println("xpath not exists.");
            }
        
        if (var1 == empID || var2 == empID ) {
            string payload = "Welcome Peter";
            messages:setStringPayload(response, payload);
        } else {
            string errorpayload = "Please provide a valid employee ID";
            messages:setStringPayload(response, errorpayload);
        }
    reply response;
    }
}
