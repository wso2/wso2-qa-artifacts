# README

XSLT transformations can be used transform a request or a response accordingly. This artifact transforms a request so that a element will be removed from the given request thus the request will fail

> Note: This particular sample is tested with WSO2 ESB 5.0.0 M2 and WSO2 AS 530

### Contents 

  - XSLT transformation file: XsltTransformer.xsl
  - Axis2 service file
  - Proxy service

### Preconditions
- Upload the .aar file to WSO2 AS

### Steps
- Upload the given XSLT transformation file to governance registry
- Change the IP address of the given endpoints in the proxy service
- Deploy the given proxy service in ESB 
- Invoke the service
