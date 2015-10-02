ReadMe
======

- Offsets used in the sample setup as follow. Please update the ports according to your setup
	- ESB481 > offset 0
	- APIM160 > offset 2
	- AS521 > offset 1

- As the Backend service, Echo Service & JaxRS Basic sample (which are available in Application Server by default) are used.

- Sample APIs in 'sample_api' folder are pointed to above mentioned backend services accordingly.

- Following curls commands will invoke the services via ESB & APIM.
	curl -v -k http://localhost:8280/reqapi/jrsbapi/1.0.0/customerservice/customers -d "<Customer><name>Jack</name></Customer>" -H "Content-Type:application/xml" -H "ClientKey: VNmIXOIyuWTvEW00FfoSzsfSgXYa" -H "ClientSecret: U0sNOfP0SBvhcAtfMlcDdKaDAjQa"
	curl -v -k -X POST -d @echo-request.xml -H 'Content-Type: Application/xml' -H 'ClientKey: VNmIXOIyuWTvEW00FfoSzsfSgXYa' -H 'ClientSecret: U0sNOfP0SBvhcAtfMlcDdKaDAjQa' https://localhost:8243/reqapi/echoapi/1.0.0

	NOTE : 	- Please replace 'ClientKey' & 'ClientSecret' 
		- Need to create 'echo-request.xml' in the same location that using above echo curl with following in the body.
			      <p:echoInt xmlns:p="http://echo.services.core.carbon.wso2.org">
			        <in>1</in>
			      </p:echoInt>

- Format of the URL you need invoke as follows,
	http://<host_ip_esb>:<port_esb>/<esb_api_context>/<apim_api_context>/<apim_api_version>/<apim_api_resource_postfix>
	http://localhost:8280/reqapi/jrsbapi/1.0.0/customerservice/customers


