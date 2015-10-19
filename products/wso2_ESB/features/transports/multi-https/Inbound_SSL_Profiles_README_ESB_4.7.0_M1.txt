(1) Assign more IP addresses to a physical device.

We will be using three addresses to associate distinct SSL context with.
 
192.168.1.2
192.168.1.3
192.168.1.4

Add those addressed to an existing network interface (wlan0 in my case). 

---
root@ubuntu:~# ip addr add 192.168.1.2/24 dev wlan0 label wlan0:0
root@ubuntu:~# ip addr add 192.168.1.3/24 dev wlan0 label wlan0:1
root@ubuntu:~# ip addr add 192.168.1.4/24 dev wlan0 label wlan0:2
root@ubuntu:~# ip addr show 
2: wlan0: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc mq state UP qlen 1000
    link/ether c4:85:08:1a:91:8b brd ff:ff:ff:ff:ff:ff
    inet 192.168.1.121/24 brd 192.168.1.255 scope global wlan0
    inet 192.168.1.2/24 scope global secondary wlan0:0
    inet 192.168.1.3/24 scope global secondary wlan0:0
    inet 192.168.1.4/24 scope global secondary wlan0:0
    inet6 fe80::c685:8ff:fe1a:918b/64 scope link 
       valid_lft forever preferred_lft forever
---

(2) Add host entries to /etc/hosts

---
192.168.1.2 testhost1
192.168.1.3 testhost2
192.168.1.4 testhost3
---

Make sure all addresses respond to ping.

(2) Generate a SSL certificate for each IP address.

Certificate Details:
        Serial Number: 13642278243717938869 (0xbd531bc863d8feb5)
        Validity
            Not Before: Feb 12 14:05:20 2013 GMT
            Not After : Feb 12 14:05:20 2014 GMT
        Subject:
            countryName               = CH
            stateOrProvinceName       = ZH
            organizationName          = OK2C
            commonName                = testhost1
        X509v3 extensions:
            X509v3 Basic Constraints: 
                CA:FALSE
            X509v3 Subject Key Identifier: 
                90:CD:AE:2D:8A:EA:0E:9A:5E:B1:9F:02:DB:38:CE:00:D1:64:E8:89
            X509v3 Authority Key Identifier: 
                keyid:80:74:26:CE:27:3D:66:A3:83:1F:68:BA:2E:59:02:7D:B8:4E:95:42

            X509v3 Subject Alternative Name: 
                email:root@testhost1

Certificate Details:
        Serial Number: 13642278243717938870 (0xbd531bc863d8feb6)
        Validity
            Not Before: Feb 12 14:08:07 2013 GMT
            Not After : Feb 12 14:08:07 2014 GMT
        Subject:
            countryName               = CH
            stateOrProvinceName       = ZH
            organizationName          = OK2C
            commonName                = testhost2
        X509v3 extensions:
            X509v3 Basic Constraints: 
                CA:FALSE
            X509v3 Subject Key Identifier: 
                93:E5:04:83:86:6B:8E:D6:6F:61:A4:C1:F9:9D:EE:80:50:3A:89:43
            X509v3 Authority Key Identifier: 
                keyid:80:74:26:CE:27:3D:66:A3:83:1F:68:BA:2E:59:02:7D:B8:4E:95:42

            X509v3 Subject Alternative Name: 
                email:root@testhost2

Certificate Details:
        Serial Number: 13642278243717938871 (0xbd531bc863d8feb7)
        Validity
            Not Before: Feb 12 14:11:25 2013 GMT
            Not After : Feb 12 14:11:25 2014 GMT
        Subject:
            countryName               = CH
            stateOrProvinceName       = ZH
            organizationName          = OK2C
            commonName                = testhost3
        X509v3 extensions:
            X509v3 Basic Constraints: 
                CA:FALSE
            X509v3 Subject Key Identifier: 
                2B:F3:01:94:AC:9A:0C:81:37:2C:7B:62:EC:0C:10:F8:99:17:20:56
            X509v3 Authority Key Identifier: 
                keyid:80:74:26:CE:27:3D:66:A3:83:1F:68:BA:2E:59:02:7D:B8:4E:95:42

            X509v3 Subject Alternative Name: 
                email:root@testhost3

(5) Store testhost key material in PKCS12 format.

(6) Generate a test user certificate to be used for client authentication with one of the test hosts.

Certificate Details:
        Serial Number: 13642278243717938872 (0xbd531bc863d8feb8)
        Validity
            Not Before: Feb 13 19:14:15 2013 GMT
            Not After : Feb 13 19:14:15 2014 GMT
        Subject:
            countryName               = CH
            stateOrProvinceName       = ZH
            organizationName          = OK2C
            commonName                = Test User
        X509v3 extensions:
            X509v3 Basic Constraints: 
                CA:FALSE
            X509v3 Subject Key Identifier: 
                70:43:FD:C5:4B:AE:1A:C5:AC:41:3E:79:8B:71:3A:A3:BD:45:1B:D2
            X509v3 Authority Key Identifier: 
                keyid:80:74:26:CE:27:3D:66:A3:83:1F:68:BA:2E:59:02:7D:B8:4E:95:42

            X509v3 Subject Alternative Name: 
                email:testuser@testdomain

(7) Store test user key material in format recognizable by curl by concatenating private key and key certificate

---
cat testuser.key testuser.crt > testuser.curl
---

(9) Generate JKS trust store containing Test Root CA certificate.

(10) Configure Synapse to use multi-profile listener with three profiles.

Configure 192.168.1.2 and 192.168.1.3 to not require client authentication. Configure 192.168.1.4 to trust Test Root CA only and to require client authentication. 

---
    <transportReceiver name="multi-https" class="org.apache.synapse.transport.nhttp.HttpCoreNIOMultiSSLListener">
    	<parameter name="port">8343</parameter>
    	<parameter name="non-blocking">true</parameter>
        <parameter name="SSLProfiles">
        	<profile>
                <bindAddress>192.168.1.2</bindAddress>
                <KeyStore>
                    <Location>/home/oleg/src/wso2.com/multiple-ssl-profiles/CA/testhost1.p12</Location>
                    <Type>PKCS12</Type>
                    <Password>test</Password>
                    <KeyPassword>test</KeyPassword>
                </KeyStore>
        	</profile>
        	<profile>
                <bindAddress>192.168.1.3</bindAddress>
                <KeyStore>
                    <Location>/home/oleg/src/wso2.com/multiple-ssl-profiles/CA/testhost2.p12</Location>
                    <Type>PKCS12</Type>
                    <Password>test</Password>
                    <KeyPassword>test</KeyPassword>
                </KeyStore>
        	</profile>
        	<profile>
                <bindAddress>192.168.1.4</bindAddress>
                <KeyStore>
                    <Location>/home/oleg/src/wso2.com/multiple-ssl-profiles/CA/testhost3.p12</Location>
                    <Type>PKCS12</Type>
                    <Password>test</Password>
                    <KeyPassword>test</KeyPassword>
                </KeyStore>
                <TrustStore>
                    <Location>/home/oleg/src/wso2.com/multiple-ssl-profiles/CA/testtrust.jks</Location>
                    <Type>JKS</Type>
                    <Password>nopassword</Password>
                </TrustStore>
                <SSLVerifyClient>require</SSLVerifyClient>
        	</profile>
		</parameter>
    </transportReceiver>
---

(11) Restart Synapse and make sure all SSL listener endpoints are properly configured and are active.

You should see the following INFO messages in the execution log 

---
...
2013-02-14 11:24:08,794 [-] [main]  INFO ListenerContextBuilder MULTI-HTTPS Loading Identity Keystore from : /home/oleg/src/wso2.com/multiple-ssl-profiles/CA/testhost1.p12
2013-02-14 11:24:08,947 [-] [main]  INFO ListenerContextBuilder MULTI-HTTPS Subject DN: CN=testhost1, O=OK2C, ST=ZH, C=CH
2013-02-14 11:24:08,948 [-] [main]  INFO ListenerContextBuilder MULTI-HTTPS Issuer DN: CN=Test CA Root, O=OK2C, ST=ZH, C=CH
2013-02-14 11:24:09,046 [-] [main]  INFO ListenerContextBuilder MULTI-HTTPS Loading Identity Keystore from : /home/oleg/src/wso2.com/multiple-ssl-profiles/CA/testhost2.p12
2013-02-14 11:24:09,058 [-] [main]  INFO ListenerContextBuilder MULTI-HTTPS Subject DN: CN=testhost2, O=OK2C, ST=ZH, C=CH
2013-02-14 11:24:09,059 [-] [main]  INFO ListenerContextBuilder MULTI-HTTPS Issuer DN: CN=Test CA Root, O=OK2C, ST=ZH, C=CH
2013-02-14 11:24:09,063 [-] [main]  INFO ListenerContextBuilder MULTI-HTTPS Loading Identity Keystore from : /home/oleg/src/wso2.com/multiple-ssl-profiles/CA/testhost3.p12
2013-02-14 11:24:09,083 [-] [main]  INFO ListenerContextBuilder MULTI-HTTPS Subject DN: CN=testhost3, O=OK2C, ST=ZH, C=CH
2013-02-14 11:24:09,083 [-] [main]  INFO ListenerContextBuilder MULTI-HTTPS Issuer DN: CN=Test CA Root, O=OK2C, ST=ZH, C=CH
2013-02-14 11:24:09,084 [-] [main]  INFO ListenerContextBuilder MULTI-HTTPS Loading Trust Keystore from : /home/oleg/src/wso2.com/multiple-ssl-profiles/CA/testtrust.jks
...
2013-02-14 11:24:09,259 [-] [main]  INFO HttpCoreNIOListener MULTI-HTTPS Listener started on testhost1:8343
2013-02-14 11:24:09,260 [-] [main]  INFO HttpCoreNIOListener MULTI-HTTPS Listener started on testhost2:8343
2013-02-14 11:24:09,260 [-] [main]  INFO HttpCoreNIOListener MULTI-HTTPS Listener started on testhost3:8343
---

(12) Prepare request message and store it in tmp.xml file.

---
<?xml version='1.0' encoding='UTF-8'?>
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Header xmlns:wsa="http://www.w3.org/2005/08/addressing">
      <wsa:To>http://localhost:9000/services/SimpleStockQuoteService</wsa:To>
      <wsa:MessageID>urn:uuid:18796751-bd3a-4c96-966a-e463b2dfc179</wsa:MessageID>
      <wsa:Action>urn:getQuote</wsa:Action>
    </soapenv:Header>
    <soapenv:Body>
      <m0:getQuote xmlns:m0="http://services.samples"><m0:request><m0:symbol>IBM</m0:symbol></m0:request></m0:getQuote>
   </soapenv:Body>
 </soapenv:Envelope>
---

(12) Execute a request against non-SSL listener using curl to make all components work correctly. Ensure the response content is correct.

---
curl -X POST -H 'Content-Type: text/xml; charset=UTF-8' -H 'SOAPAction: "urn:getQuote"' -d @tmp.xml -v http://localhost:8280/ 
---

(13) Execute a request against testhost1 SSL listener using curl without appropriate trust material.

---
curl -X POST -H 'Content-Type: text/xml; charset=UTF-8' -H 'SOAPAction: "urn:getQuote"' -d @tmp.xml -v https://testhost1:8343/
---

Make sure connection is rejected by the client due to failure to verify server identity. 

---
* About to connect() to testhost1 port 8343 (#0)
*   Trying 192.168.1.2...
* connected
* Connected to testhost1 (192.168.1.2) port 8343 (#0)
* successfully set certificate verify locations:
*   CAfile: none
  CApath: /etc/ssl/certs
* SSLv3, TLS handshake, Client hello (1):
* SSLv3, TLS handshake, Server hello (2):
* SSLv3, TLS handshake, CERT (11):
* SSLv3, TLS alert, Server hello (2):
* SSL certificate problem: unable to get local issuer certificate
* Closing connection #0
curl: (60) SSL certificate problem: unable to get local issuer certificate
---

(14) Execute a request against testhost1 SSL listener using curl with appropriate trust material.

---
curl -X POST -H 'Content-Type: text/xml; charset=UTF-8' -H 'SOAPAction: "urn:getQuote"' -d @tmp.xml --cacert CA/cacert.pem -v https://testhost1:8343/
---

Make sure the server's identity is correctly established and verified. 

---
* About to connect() to testhost1 port 8343 (#0)
*   Trying 192.168.1.2...
* connected
* Connected to testhost1 (192.168.1.2) port 8343 (#0)
* successfully set certificate verify locations:
*   CAfile: CA/cacert.pem
  CApath: /etc/ssl/certs
* SSLv3, TLS handshake, Client hello (1):
* SSLv3, TLS handshake, Server hello (2):
* SSLv3, TLS handshake, CERT (11):
* SSLv3, TLS handshake, Server key exchange (12):
* SSLv3, TLS handshake, Server finished (14):
* SSLv3, TLS handshake, Client key exchange (16):
* SSLv3, TLS change cipher, Client hello (1):
* SSLv3, TLS handshake, Finished (20):
* SSLv3, TLS change cipher, Client hello (1):
* SSLv3, TLS handshake, Finished (20):
* SSL connection using ECDHE-RSA-DES-CBC3-SHA
* Server certificate:
* 	 subject: C=CH; ST=ZH; O=OK2C; CN=testhost1
* 	 start date: 2013-02
* 	 expire date: 2014-02
* 	 common name: testhost1 (matched)
* 	 issuer: C=CH; S
* 	 SSL certificate verify ok.
---

(15) Execute a request against testhost2 multi SSL listener using curl with appropriate trust material.

---
curl -X POST -H 'Content-Type: text/xml; charset=UTF-8' -H 'SOAPAction: "urn:getQuote"' -d @tmp.xml --cacert CA/cacert.pem -v https://testhost2:8343
---

Make sure the server's identity is correctly established and verified. 

---
* About to connect() to testhost2 port 8343 (#0)
*   Trying 192.168.1.3...
* connected
* Connected to testhost2 (192.168.1.3) port 8343 (#0)
* successfully set certificate verify locations:
*   CAfile: CA/cacert.pem
  CApath: /etc/ssl/certs
* SSLv3, TLS handshake, Client hello (1):
* SSLv3, TLS handshake, Server hello (2):
* SSLv3, TLS handshake, CERT (11):
* SSLv3, TLS handshake, Server key exchange (12):
* SSLv3, TLS handshake, Server finished (14):
* SSLv3, TLS handshake, Client key exchange (16):
* SSLv3, TLS change cipher, Client hello (1):
* SSLv3, TLS handshake, Finished (20):
* SSLv3, TLS change cipher, Client hello (1):
* SSLv3, TLS handshake, Finished (20):
* SSL connection using ECDHE-RSA-DES-CBC3-SHA
* Server certificate:
* 	 subject: C=CH; ST=ZH; O=OK2C; CN=testhost2
* 	 start date: 2013-02
* 	 expire date: 2014-02
* 	 common name: testhost2 (matched)
* 	 issuer: C=CH; S
* 	 SSL certificate verify ok.
---

(16) Execute a request against testhost3 multi SSL listener using curl with appropriate trust material.

---
curl -X POST -H 'Content-Type: text/xml; charset=UTF-8' -H 'SOAPAction: "urn:getQuote"' -d @tmp.xml --cacert CA/cacert.pem -v https://testhost3:8343
---

Make sure the connection is rejected by the server due to the client failure to authenticate.

---
* About to connect() to testhost3 port 8343 (#0)
*   Trying 192.168.1.4...
* connected
* Connected to testhost3 (192.168.1.4) port 8343 (#0)
* successfully set certificate verify locations:
*   CAfile: CA/cacert.pem
  CApath: /etc/ssl/certs
* SSLv3, TLS handshake, Client hello (1):
* SSLv3, TLS handshake, Server hello (2):
* SSLv3, TLS handshake, CERT (11):
* SSLv3, TLS handshake, Server key exchange (12):
* SSLv3, TLS handshake, Request CERT (13):
* SSLv3, TLS handshake, Server finished (14):
* SSLv3, TLS handshake, CERT (11):
* SSLv3, TLS handshake, Client key exchange (16):
* SSLv3, TLS change cipher, Client hello (1):
* SSLv3, TLS handshake, Finished (20):
* Unknown SSL protocol error in connection to testhost3:8343 
* Closing connection #0
---

(17) Execute a request against testhost3 multi SSL listener using curl with appropriate trust material and user private key.

---
curl -X POST -H 'Content-Type: text/xml; charset=UTF-8' -H 'SOAPAction: "urn:getQuote"' -d @tmp.xml --cacert CA/cacert.pem --cert CA/testuser.curl:test -v https://testhost3:8343
---

Make sure the server's identity is correctly established and verified. 

---
* About to connect() to testhost3 port 8343 (#0)
*   Trying 192.168.1.4...
* connected
* Connected to testhost3 (192.168.1.4) port 8343 (#0)
* successfully set certificate verify locations:
*   CAfile: CA/cacert.pem
  CApath: /etc/ssl/certs
* SSLv3, TLS handshake, Client hello (1):
* SSLv3, TLS handshake, Server hello (2):
* SSLv3, TLS handshake, CERT (11):
* SSLv3, TLS handshake, Server key exchange (12):
* SSLv3, TLS handshake, Request CERT (13):
* SSLv3, TLS handshake, Server finished (14):
* SSLv3, TLS handshake, CERT (11):
* SSLv3, TLS handshake, Client key exchange (16):
* SSLv3, TLS handshake, CERT verify (15):
* SSLv3, TLS change cipher, Client hello (1):
* SSLv3, TLS handshake, Finished (20):
* SSLv3, TLS change cipher, Client hello (1):
* SSLv3, TLS handshake, Finished (20):
* SSL connection using ECDHE-RSA-DES-CBC3-SHA
* Server certificate:
* 	 subject: C=CH; ST=ZH; O=OK2C; CN=testhost3
* 	 start date: 2013-02
* 	 expire date: 2014-02
* 	 common name: testhost3 (matched)
* 	 issuer: C=CH; S
* 	 SSL certificate verify ok.
---
