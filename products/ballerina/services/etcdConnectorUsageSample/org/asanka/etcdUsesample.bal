

import ballerina.lang.jsons;
import ballerina.lang.xmls;
import ballerina.lang.messages;
import ballerina.lang.strings;
import ballerina.net.http;
import ballerina.utils;


connector etcd (string etcdURL, string username, string password, string apiVersion) {
    http:ClientConnector etcdEP = create http:ClientConnector("http://127.0.0.1:2379");
    string encodedBasicAuthHeaderValue;
    string path;
    message request={};
    message response={};

    action getValue(etcd t, string key) (message) {
	if ((strings:length(username) > 0) && (strings:length(password) > 0) ){
	    encodedBasicAuthHeaderValue = utils:base64encode(username + ":" + password);
	    messages:setHeader(request, "Authorization", "Basic " + encodedBasicAuthHeaderValue);
	}
	path = "/" + apiVersion + "/keys/" + key;
        response = http:ClientConnector.get(etcdEP, path, request);
        return response;
    }

    action setKeyValue(etcd t, string key, string value) (message) {
	if ((strings:length(username) > 0) && (strings:length(password) > 0) ){
	    encodedBasicAuthHeaderValue = utils:base64encode(username + ":" + password);
	    messages:setHeader(request, "Authorization", "Basic " + encodedBasicAuthHeaderValue);
	}
	messages:setStringPayload(request, "value=" + value);
	messages:setHeader(request, "Content-Type", "application/x-www-form-urlencoded");
	path = "/" + apiVersion + "/keys/" + key;
	response = http:ClientConnector.put(etcdEP, path, request);
	return response;
    }

    action updateValue(etcd t, string key, string value) (message) {
	if ((strings:length(username) > 0) && (strings:length(password) > 0) ){
	    encodedBasicAuthHeaderValue = utils:base64encode(username + ":" + password);
	    messages:setHeader(request, "Authorization", "Basic " + encodedBasicAuthHeaderValue);
	}
	messages:setStringPayload(request, "value=" + value);
	messages:setHeader(request, "Content-Type", "application/x-www-form-urlencoded");
	path = "/" + apiVersion + "/keys/" + key;
	response = http:ClientConnector.put(etcdEP, path, request);
	return response;
    }

    action deleteKey(etcd t, string key) (message) {
	if ((strings:length(username) > 0) && (strings:length(password) > 0) ){
	    encodedBasicAuthHeaderValue = utils:base64encode(username + ":" + password);
	    messages:setHeader(request, "Authorization", "Basic " + encodedBasicAuthHeaderValue);
	}
	path = "/" + apiVersion + "/keys/" + key;
	response = http:ClientConnector.delete(etcdEP, path, request);
	return response;
     }

    action createDir(etcd t, string dir) (message) {
	if ((strings:length(username) > 0) && (strings:length(password) > 0) ){
	    encodedBasicAuthHeaderValue = utils:base64encode(username + ":" + password);
	    messages:setHeader(request, "Authorization", "Basic " + encodedBasicAuthHeaderValue);
	}
	path = "/" + apiVersion + "/keys/" + dir;
	response = http:ClientConnector.put(etcdEP, path, request);
	return response;
    }

    action listDir(etcd t, string dir, string recursive) (message) {
	if ((strings:length(username) > 0) && (strings:length(password) > 0) ){
	    encodedBasicAuthHeaderValue = utils:base64encode(username + ":" + password);
	    messages:setHeader(request, "Authorization", "Basic " + encodedBasicAuthHeaderValue);
	}
	path = "/" + apiVersion + "/keys" + dir + "?" + recursive;
        response = http:ClientConnector.get(etcdEP, path, request);
	return response;
    }

    action deleteDir(etcd t, string dir, string recursive) (message) {
	if ((strings:length(username) > 0) && (strings:length(password) > 0) ){
	    encodedBasicAuthHeaderValue = utils:base64encode(username + ":" + password);
	    messages:setHeader(request, "Authorization", "Basic " + encodedBasicAuthHeaderValue);
	}
	path = "/" + apiVersion + "/keys" + dir + "?" + recursive;
        response = http:ClientConnector.delete(etcdEP, path, request);
	return response;
    }
}


@http:BasePath {value:"/etcdUsesample"}
service stockService {

    @http:POST{}
    resource stock (message m) {
      http:ClientConnector stockEP = create http:ClientConnector("http://localhost:9000");
      etcd etcdConnector = create etcd("http://127.0.0.1:2379", "root", "test123", "v2");

      message etcdResponse;
      json etcdJSONResponse;
      message reponse={};
      message mn={};
      message previousMessage={};
      json incomingJsonMessage;
      string stringmessage;
      xml payload;
      string symbol="";

      incomingJsonMessage= messages:getJsonPayload(m);
      symbol=jsons:getString(incomingJsonMessage,"$.symbol");



  payload=`<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services.samples" xmlns:xsd="http://services.samples/xsd">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:getQuote>
         <!--Optional:-->
         <ser:request>
            <!--Optional:-->
            <xsd:symbol>?</xsd:symbol>
         </ser:request>
      </ser:getQuote>
   </soapenv:Body>
</soapenv:Envelope>`;

        map xmlnamespaheaders={"soapenv":"http://schemas.xmlsoap.org/soap/envelope/", "ser":"http://services.samples", "xsd":"http://services.samples/xsd"};

        xmls:set(payload,"/soapenv:Envelope/soapenv:Body/ser:getQuote/ser:request/xsd:symbol/text()",symbol,xmlnamespaheaders);

        messages:setXmlPayload(mn,payload);
        messages:addHeader(mn, "SOAPAction","urn:getQuote");
        messages:setHeader(mn, "Content-Type","text/xml;charset=UTF-8");
        messages:addHeader(mn, "Accept-Encoding","gzip,deflate");



        reponse = http:ClientConnector.post(stockEP, "/services/SimpleStockQuoteService.SimpleStockQuoteServiceHttpSoap11Endpoint", mn);

        previousMessage=etcd.getValue(etcdConnector,symbol);
        stringmessage=messages:getStringPayload(previousMessage);
        if(strings:length(stringmessage)>0){
          etcd.deleteKey(etcdConnector,symbol);
        }

        etcdResponse = etcd.setKeyValue(etcdConnector,symbol,messages:getStringPayload(reponse));
        etcdJSONResponse = messages:getJsonPayload(etcdResponse);


        mn= etcd.getValue(etcdConnector,symbol);
        reply mn;


    }
}
