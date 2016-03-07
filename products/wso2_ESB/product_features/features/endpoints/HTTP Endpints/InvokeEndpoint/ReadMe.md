# HTTP Endpoints Invoke 

1. Unzip "pizzashop-rs_1.0.zip" file and paste to App Server (5.2.1)  webapps folder (AS_HOME/repository/deployment/server/webapps)
2. Create a proxy service with HTTP endpoint as per "proxyConfig.xml"
3. Send following soap request to proxy service:

### Request:
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header/>
   <soapenv:Body>
      <pizza>
         <name>Meat Sizzler</name>
         <price>500.0</price>
         <toppings>
            <topping>
               <id>9999</id>
               <name>Steak</name>
               <extraPrice>4.00</extraPrice>
               <category>NONVEG</category>
            </topping>
            <topping>
               <id>9998</id>
               <name>Sun Dried Tomato</name>
               <extraPrice>4.00</extraPrice>
               <category>VEGETARIAN</category>
            </topping>
            <topping>
               <id>9997</id>
               <name>Mixed Peppers</name>
               <extraPrice>3.00</extraPrice>
               <category>VEGETARIAN</category>
            </topping>
            <topping>
               <id>9996</id>
               <name>Cajun Chicken</name>
               <extraPrice>3.00</extraPrice>
               <category>NONVEG</category>
            </topping>
            <topping>
               <id>9995</id>
               <name>Chorizo Sausage</name>
               <extraPrice>4.00</extraPrice>
               <category>NONVEG</category>
            </topping>
         </toppings>
      </pizza>
   </soapenv:Body>
</soapenv:Envelope>
```

### Response:
```
HTTP/1.1 200 OK
Content-Type: application/json
Date: Thu, 30 Jan 2014 09:05:00 GMT
Server: WSO2-PassThrough-HTTP
Transfer-Encoding: chunk
```
