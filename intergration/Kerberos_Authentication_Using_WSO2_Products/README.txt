NOTE : The client and the steps are same as mentioned in [1]

1) Copy the config files found inside kerberos/IS/conf to the conf directory of Identity Server (IS 5.0.0).
If you change the config files manually, there are changes in following files...
	- krb5.con : Change the encryption types, realm and domain names to match with our requirement.
	- embedded-ldap.xml : Enable KDC server and preAuthenticationTimeStampEnabled property.
	- user-mgt.xml : Enable KDC in default ldap userstore manager.

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
	- carbon.xml : Change the port offset
	- jaas.conf : Add this file to ESB_HOME/repository/conf/security folder.
	- krb5.conf : Add this file to ESB_HOME/repository/conf/security folder.

5) Start ESB and secure echo service with kerberos authentication (policy no 16). provide "echo/localhost@WSO2.ORG" as service principla name and the correct password.

6) Run the client. If the client can sucessfully access the service, the response should be
<ns:echoStringResponse xmlns:ns="http://echo.services.core.carbon.wso2.org"><return>Hello Pavithra !!!!!!</return></ns:echoStringResponse>

************
Limitations
************

1) When running the client with jdk7, you'll observe following error.

TID: [0] [ESB] [2015-06-03 14:13:10,490] ERROR {org.apache.axis2.transport.http.AxisServlet} -  sun.security.krb5.EncryptedData.reset([BZ)[B {org.apache.axis2.transport.http.AxisServlet}
java.lang.NoSuchMethodError: sun.security.krb5.EncryptedData.reset([BZ)[B
        at org.apache.ws.security.kerberos.KrbTicketDecoder.decryptTicket(KrbTicketDecoder.java:105)
        at org.apache.ws.security.kerberos.KrbTicketDecoder.parseApReq(KrbTicketDecoder.java:90)
        at org.apache.ws.security.kerberos.KrbTicketDecoder.parseServiceTicket(KrbTicketDecoder.java:67)
        at org.apache.ws.security.kerberos.KrbTicketDecoder.getSessionKey(KrbTicketDecoder.java:50)
        at org.apache.ws.security.processor.KerberosTokenProcessor.getSessionKey(KerberosTokenProcessor.java:493)
        at org.apache.ws.security.processor.KerberosTokenProcessor.verifyXMLSignature(KerberosTokenProcessor.java:297)
        at org.apache.ws.security.processor.SignatureProcessor.verifyXMLSignature(SignatureProcessor.java:308)
        at org.apache.ws.security.processor.SignatureProcessor.handleToken(SignatureProcessor.java:124)

So please make sure to run the client with jdk6.

[1] http://wso2.com/library/articles/2012/07/kerberos-authentication-using-wso2-products/
