#READ ME for *HTTP-EP-With-500-510-StatusCode_responses.xml* Mock Service#

This SOAPUI Project contains a mock Rest service which sends HTTP status codes 500,501, 502, 503, 504, 505 and 507. The service supports both GET and POST requests.

##Starting the SOAPUI Mock Service##

1. Download  HTTP_EP_With_500-600_Status_Codes.xml
2. Open SOAPUI and GO to File -> Import Project and import the above downloaded project.
3. Expand the project in the Project Pane and right click on *HTTP_Response_codes* mock service and Select Show MOCKRest Service Editor.
4. Now click the green arow to start the mock service


**Structure of the API call**

`http://<IP/HOST>:<SOAPUI_SERVER_PORT>/<METHOD>_<RESPONSE_CODE>`

e.g : http://10.100.5.112:8080/get_507

**Invoking a GET resource with HTTP 500 Response.**

http://localhost:8080/get_500

Following response body will be sent

*Internal Server Error - CODE 500 is Sent as the Response*

**Invoking a GET resource with HTTP 501 Response.**

http://localhost:8080/get_501

Following response body will be sent as the respon with the response code

*Not Implemented - CODE 501 is Sent as the Response*

**Sending a POST request for HTTP 500 response**

Following response body will be sent with the body along with the status code.

*Internal Server Error - CODE 500 is Sent as the Response for the POST request*



