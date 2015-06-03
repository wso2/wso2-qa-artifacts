NOTE : The client and the steps are same as mentioned in [1]

1) Copy the config files found inside kerberos/IS/conf to the conf directory of Identity Server (IS 5.0.0).
If you change the config files manually, there are changes in following files...
	- jaas.conf
	- krb5.con
	- embedded-ldap.xml
	- user-mgt.xml

2) Create a user in identity server
e.g
user name : pavithra
password : qazqaz

3) Create a service principal
service principal name : echo/localhost
password : wsxwsx

4) Change the configuration files in ESB 4.8.1
Either copy the config files inside kerberos/ESB/conf to the conf directory of ESB
or
change following configuration files
	- carbon.xml
	- jaas.conf
	- krb5.conf

5) Start ESB and secure echo service with kerberos authentication (policy no 16). provide "echo/localhost@WSO2.ORG" as service principla name and the correct password.

6) Run the client. If the client can sucessfully access the service, the response should be
<ns:echoStringResponse xmlns:ns="http://echo.services.core.carbon.wso2.org"><return>Hello Pavithra !!!!!!</return></ns:echoStringResponse>

[1] http://wso2.com/library/articles/2012/07/kerberos-authentication-using-wso2-products/
