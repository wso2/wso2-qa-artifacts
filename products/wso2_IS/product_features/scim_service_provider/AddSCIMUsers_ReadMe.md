# Script: AddSCIMUsers.jmx

Author: Nadeesha

Description:- This testcase creates SCIM users giving the SCIM endpoint https://localhost:9443/wso2/scim/users

## Pre-Conditions:-
- WSO2 IS 5.0.1
- In user-mgt.xml for the user-store configuration property "<Property name="SCIMEnabled">true</Property>" should be enabled.
- Restart the server


Notes:-

- This script was originally written to execute for IS 5.1.0 

Curl command as follows if you are going to add this manually giving the SCIM endpoint :
curl -v -k --user admin:admin --data "{"schemas":[],"name":{"familyName":"gunasinghe","givenName":"hasinitg"},"userName":"hasinitg","password":"hasinitg","emails":[{"primary":true,"value":"hasini_home.com","type":"home"},{"value":"hasini_work.com","type":"work"}]}" --header "Content-Type:application/json" https://localhost:9443/wso2/scim/Users
 