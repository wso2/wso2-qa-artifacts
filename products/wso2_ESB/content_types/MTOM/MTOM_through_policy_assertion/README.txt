Related public jira : 

https://wso2.org/jira/browse/ESBJAVA-3184

Steps (Same as mentioned in the jira) :

Steps to reproduce:
============
1. Create a pass through proxy in ESB-4.8.1
2. Enable UT or any security policy
3. Edit the policy in policy editor by adding the above policy assertion
<wsoma:OptimizedMimeSerialization xmlns:wsoma="http://schemas.xmlsoap.org/ws/2004/09/policy/optimizedmimeserialization"></wsoma:OptimizedMimeSerialization>
4. Save proxy
5. Invoke the service (can use the soapui project attached)

In response you should get correct multipart bondaries with multipart/related response.

HTTP/1.1 200 OK
Content-Type: multipart/related; boundary="MIMEBoundary_94016d506520d3ced527cbd8d639b2557bdfdb4af12a2898"; type="application/xop+xml"; start="<0.84016d506520d3ced527cbd8d639b2557bdfdb4af12a2898@apache.org>"; start-info="application/soap+xml"
Server: Jetty(6.1.26)
Date: Wed, 25 Jun 2014 21:09:32 GMT
Transfer-Encoding: chunked
Connection: close

--MIMEBoundary_94016d506520d3ced527cbd8d639b2557bdfdb4af12a2898
Content-Type: application/xop+xml; charset=utf-8; type="application/soap+xml"
Content-Transfer-Encoding: binary
Content-ID: <0.84016d506520d3ced527cbd8d639b2557bdfdb4af12a2898@apache.org>

<?xml version='1.0' encoding='utf-8'?><soapenv:Envelope xmlns:soapenv="http://www.w3.org/2003/05/soap-envelope"><soapenv:Header><wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" soapenv:mustUnderstand="true"><wsu:Timestamp xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" wsu:Id="Timestamp-2"><wsu:Created>2014-06-25T21:09:32.833Z</wsu:Created><wsu:Expires>2014-06-25T21:14:32.833Z</wsu:Expires></wsu:Timestamp></wsse:Security></soapenv:Header><soapenv:Body>
<ser:echoStringResponse xmlns:ser="http://service.carbon.wso2.org">
<!-Optional:->
<ser:return>?</ser:return>
</ser:echoStringResponse>
</soapenv:Body></soapenv:Envelope>
-MIMEBoundary_94016d506520d3ced527cbd8d639b2557bdfdb4af12a2898-


NOTE : Artifacts for both ESB 4.8.1 and 4.9.0 are available
