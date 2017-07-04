#!/bin/bash
export PATH=$PATH:/usr/local/

#You can define the userName and password here (Supertenant Domain and Tenant Domain)
curl -X POST -c cookies http://localhost:9763/publisher/site/blocks/user/login/ajax/login.jag -d 'action=login&username=admin&password=admin'
Y=1
#The number of APIs that you want to creat should be defined here
NUM=10;

while [ "$Y" -le $NUM ]
do
curl -X POST -b cookies http://localhost:9763/publisher/site/blocks/item-add/ajax/add.jag -d "action=addAPI&name=TestPhoneVerification$Y&context=/testphoneverify$Y&version=1.0.0&visibility=public&description=Verify a phone number&tags=phone,mobile,multimedia&endpointType=nonsecured&tiersCollection=Unlimited&http_checked=http&https_checked=https"  -d 'swagger={"paths" : {"/estimate/" : {"get" : {"x-auth-type" : "Application%20%26%20Application%20User", "x-throttling-tier" : "Unlimited", "responses" : {"200" : {}}, "parameters" : [{"name" : "id", "paramType" : "path", "required" : false, "type" : "string", "description" : "Phone Number", "in" : "path"}]}}}, "swagger" : "2.0", "x-wso2-security" : {"apim" : {"x-wso2-scopes" : [{"description" : "", "name" : "read_number", "roles" : "admin", "key" : "read_number"}]}}, "info" : {"title" : "SampleApi", "version" : "1.0.0"}}' -d'endpoint_config={"production_endpoints":{"url":"http://ws.cdyne.com/phoneverify/phoneverify.asmx","config":null},"endpoint_type":"http"}';

curl -X POST -b cookies 'http://localhost:9763/publisher/site/blocks/life-cycles/ajax/life-cycles.jag' -d "action=updateStatus&name=TestPhoneVerification$Y&version=1.0.0&provider=admin&status=PUBLISHED&publishToGateway=true&requireResubscription=true";

	Y=$(($Y+1))

	#time between API creations
	sleep 5
done
