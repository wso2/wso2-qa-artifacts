package MessageRouting.MessageSplitting;

import ballerina.net.http;
import ballerina.lang.messages;
import ballerina.lang.xmls;

@http:BasePath{value: "/xpathsplitcreatepayload"}
service xpathSplitCreatePayloadService {

    @http:POST{}
    @http:Path{value:"/"}
    resource xpathSplitCreatePayloadResource(message m) {
        http:ClientConnector stockEP = create http:ClientConnector("http://localhost:9000/services/SimpleStockQuoteService");
       xml incomingPayload = messages:getXmlPayload(m);
       map namespace = {"m0":"http://services.samples"};
       int sliptcount = (int) xmls:getStringWithNamespace(incomingPayload,"count(//m0:getQuote/m0:request)",namespace);
       
       xml payload = xmls:parse("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:m0=\"http://services.samples\"><soapenv:Header/><soapenv:Body><m0:getQuote></m0:getQuote></soapenv:Body></soapenv:Envelope>");
 
       message response = {};
       message Clientresponse = {};
       int i = 1;
       while (i <= sliptcount) {
           xml resp = xmls:copy(payload);
           xml body = xmls:selectChildren(resp,"{http://schemas.xmlsoap.org/soap/envelope/}Body");
           xml getQuote = xmls:selectChildren(body,"{http://services.samples}getQuote");

           string stock = xmls:getStringWithNamespace(incomingPayload,"//m0:getQuote/m0:request[" + i + "]",namespace);

           xml stockXml = xmls:parse(stock);
           xmls:setChildren(getQuote,stockXml);
           messages:setXmlPayload(m,resp);
           messages:removeHeader(m, "Content-Type");
	       messages:addHeader(m, "Content-Type", "text/xml;charset=UTF-8");
           response = http:ClientConnector.post(stockEP, "/", m);
         i = i + 1;
       }

       reply Clientresponse;
    }
}
