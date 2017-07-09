
import ballerina.lang.jsons;
import ballerina.lang.messages;
import ballerina.lang.strings;
import ballerina.net.http;

@http:BasePath {value:"/modules"}
service modules {

    @http:POST{}
    @http:Path{value:"/checkModule"}
    resource checkModule (message mod){
    http:ClientConnector merchentEP = create http:ClientConnector("http://localhost:9090/paymentrouter");
    message respns={};
    message incoming = mod;
    json jtest={};
    string module;
    boolean istrue = false;
    string[] modules;
    json failedRspns={};
    json jIncoming={};
    string merchantService = "null";
    map merchantPool={"sampath":"/sampath","ezcash":"/ezcash","hnb":"/hnb","starpoint":"/starpoint"};
    int i;
    //available payment modules
    modules = ["sampath","ezcash", "hnb", "starpoint"];

    //message rebuild due to limitations/bug
    jIncoming = messages:getJsonPayload(mod);
    module = jsons:getString(jIncoming,"$.paymode");
    messages:setJsonPayload(incoming,jIncoming);

    //iterator
    i = 0;
        //while(i < arrays:length(modules)){
    while(i < modules.length){


            //check payment module exists
            if(strings:equalsIgnoreCase(module,modules[i])){
                istrue=true;
                merchantService = (string)merchantPool[module];
                break;
             }
            else{
                istrue=false;
            }
            i=i+1;
        }
    //check whether the merchant-service got assigned
    if(merchantService=="null"){

        failedRspns = {"status":"failed","description":"Non-existing Merchant, Pleae contact Administrator."};
        messages:setJsonPayload(respns,failedRspns);
    }else{
           //send the message to relevant merchant.
           respns = http:ClientConnector.post(merchentEP, merchantService, incoming);

    }

    reply respns;
   }

}

@http:BasePath {value:"/paymentgw"}
service paymentgw {
    @http:POST{}
    @http:Path{value:"/pay"}
    resource paymentapi (message m){
        http:ClientConnector modEP = create http:ClientConnector("http://localhost:9090/modules");
        message response={};
        message request;
        json modrespns;
        string mode;
        json jMsg;

        //get the reponse from modules/checkModule endpoint
        response = http:ClientConnector.post(modEP, "/checkModule", m);
        //temp code
        reply response;
    }

}


@http:BasePath {value:"/paymentrouter"}
service router {

    @http:POST{}
    @http:Path{value:"/hnb"}
    resource paymentapih (message m){
        message response = {};
        json jMsg;
        jMsg = {"status":"success"};
        messages:setJsonPayload(response, jMsg);
        reply response;
    }

    @http:POST{}
    @http:Path{value:"/ezcash"}
    resource paymentapiez (message m){
        message response = {};
        json jMsg;
        jMsg = {"status":"success"};

        messages:setJsonPayload(response, jMsg);
        reply response;
    }

    @http:POST{}
    @http:Path{value:"/starpoint"}
    resource paymentapisp (message m){
        message response = {};
        json jMsg;
        jMsg = {"status":"success"};

        messages:setJsonPayload(response, jMsg);
        reply response;
    }

    @http:POST{}
    @http:Path{value:"/sampath"}
    resource paymentapism (message m){
        message response = {};
        json jMsg;

        jMsg = {"status":"success"};

        messages:setJsonPayload(response, jMsg);
        reply response;
    }



}
