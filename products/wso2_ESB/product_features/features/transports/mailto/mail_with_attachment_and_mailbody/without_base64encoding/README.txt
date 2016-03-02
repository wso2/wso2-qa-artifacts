How to execute the scenario

1. Create a proxy service with the given configuration in MailProxyText.xml
2. Send a request through soapUI to the proxy service with the request message given in the request.xml
3. An email should be sent to the email address specified in the proxy configuration with
a) An attachment with the symbol "IBM"
b) With the mail subject "Sample Mail" and message body saying "This text will appear in mail body"
