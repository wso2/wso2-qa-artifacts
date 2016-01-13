# **Read me to check the JSON support for payload factory mediator in outsequence of ESB**

**Author :** Nayomi

**Steps in brief :** 

-  Create a REST mock service using SoapUI
-  Create a ESB proxy
-  Invoke the ESB proxy


#### **Create a REST mock service using SoapUI**

You can do this either by starting from scratch by following below mentioned steps, or you can import the already created Mock service soapUI project named mockservice.xml from soapUI.

**Creating Mock Service from scratch**
-Open soapUI.
- Select 'File > New REST Project'.
- Provide a URL i.e. http://localhost/mockservice1 and click OK and it would open up a 'Request Editor'.
- Now right click on the request from the project tree and select 'Add to REST mock service' option.
- Enter a name of your choice for the mock service and click OK. It would open up mock service editor in running mode.
- From the mock service editor, click on 'OnRequest Script' and copy and paste the below script in the middle text box.

NOTE: Change the path of the jsonresponse.json file in the below script to point to the correct file on your file system.

```
import javax.servlet.http.HttpServletResponse
import com.eviware.soapui.support.Tools
def response = mockRequest.httpResponse
File file = new File("/home/nayomi/Downloads/wso2esb-4.9.0-ALPHA5/jsonresponse.json")
FileInputStream fin = new FileInputStream(file)
response.setStatus( HttpServletResponse.SC_OK )
long length = file.length();
response.setContentLength( ( int )length );
response.setContentType("application/json;charset=utf-8" );
Tools.readAndWrite( fin, length, response.getOutputStream() );
fin.close();
return new com.eviware.soapui.impl.wsdl.mock.WsdlMockResult(mockRequest)
```
- Stop the running mock service & click on 'Set options for this MockService' icon.
- Specify the port as 5555 and leave the rest of the values as they are and click OK.
- Then start the mock service (you can check the response by typing as localhost:5555/mockservice1).

And now your mock service is ready!

**Import the already created Mock service project**

- Open soapUI.
- Select 'File > Import Project'.
- Select the file mockservice.xml and it would open up the already created soapUI project.
- Click on the mock service project, go to 'OnRequest Script' tab and change the path of the jsonresponse.json file.
- Start the mock service & your service will be started.
- Now access the service from the URL http://localhost:5555/mockservice1.


#### **Create a ESB proxy**

Now deploy the singleresponse.xml proxy service in WSO2 ESB. Before you do, make sure to edit the endpoint configuration to point to the mock service which you created in the above step, so that it looks like below.
```
   <endpoint>
     <address uri="http://localhost:5555/mockservice1"/>
   </endpoint>

```

#### **Invoke the ESB proxy**

- Finally invoke the proxy using below curl command.

`curl -v -X GET "http://localhost:8280/services/singleresponse"`

- If you use a TCPMon you will see the response as below.

```
{
   "location_response" : 
   {
      "name" : "Biaggio Cafe",
      "tags" : ["bar","restaurant","food","establishment"]
   }
}
```
- Also, you can access http://localhost:8280/services/singleresponse by browser and see the above formatted json message.







