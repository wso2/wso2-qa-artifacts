# **This folder includes the artifacts that explains of the Simple ESB proxy which forwards the call to a Weblogic 12.1.2 Server**

Follow the steps below to perform the scenario.

1.First you have to download weblogic server and install it in your machine.(refer https://redstack.wordpress.com/2010/05/20/installing-weblogic-server-10-3-3-on-ubuntu-64-bit/)

2.Start the Weblogic server using below command.
```
$ cd /home/mark/Oracle/Middleware/user_projects/domains/base_domain/startWebLogic.sh
```
3.Deploy the HelloWorld.war file in weblogic server.(Refer http://onlineappsdba.com/index.php/2008/08/12/deploy-application-on-oracle-weblogic-server/)

4.Start the wso2 ESB and create the HelloWorldProxy and enable it's wire logs.(use HelloWorldProxy in this folder).
(Enable wire logs in ESB server : refer http://ruchirawageesha.blogspot.com/2012/07/wso2-esb-enable-wire-level-logs.html)

5.Invoke the ESB proxy using below curl command.
```
curl -v -X GET "http://nayomi-ThinkPad-T540p:8280/services/HelloProxy"
```
6.ESB logs should display the response as below.
```
[2015-11-02 13:55:05,909]  INFO - LogMediator To: http://www.w3.org/2005/08/addressing/anonymous, WSAction: , SOAPAction: , MessageID: urn:uuid:ae31a2be-b80f-4930-be15-0ac24936b35b, Direction: response, Envelope: <?xml version='1.0' encoding='utf-8'?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"><soapenv:Body><html>
<head>
<title>Hello World (Servlet Example)</title>
</head>
<body>
<h1 align="center">Hello World (Servlet Example)</h1>
<p>Hello World</p>
</body>
</html></soapenv:Body></soapenv:Envelope>
```
7.Curl command prompt should show the response as below too.
```
> GET /services/test HTTP/1.1
> User-Agent: curl/7.35.0
> Host: nayomi-ThinkPad-T540p:8280
> Accept: */*
>
< HTTP/1.1 200 OK
< Content-Type: text/html;charset=ISO-8859-1
< Date: Mon, 02 Nov 2015 08:23:36 GMT
< Transfer-Encoding: chunked
<
<html>
<head>
<title>Hello World (Servlet Example)</title>
</head>
<body>
<h1 align="center">Hello World (Servlet Example)</h1>
<p>Hello World</p>
</body>
</html>
``` 
