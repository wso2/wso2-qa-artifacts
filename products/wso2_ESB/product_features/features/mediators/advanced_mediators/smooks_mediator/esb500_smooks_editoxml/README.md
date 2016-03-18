# README

Smooks mediator can be used to handle many conversion scenarios and this particular artifact converts a EDI file to XML. Then transforms the XML to match what is expected from the backend. Afterwards iterates and sends requests to the backend service.
> Note: This particular sample is tested with WSO2 ESB 5.0.0 M2 and WSO2 AS 530
### Contents 

  - Smooks configuration file : smooks-config.xml
  - Proxy service: Smooks3.xml
  - EDI file: edidata.edi
  - EDI to xml mapping file: mymapping.xml
  - XSLT transformation file: Transformation.xsl
  - Axis2 service file

### Preconditions
- VFS transport should be enabled in ESB
- Local folder locations should be created as in, out and fail
- Upload the .aar file to WSO2 AS

### Steps
- Upload the given smooks configuration file to governance registry
- Upload the given XSLT transformation file to governance registry
- Place the EDI to XML mapping file inside <product_home>/repository/samples/resources/smooks folder
- Change the IP address of the given endpoints in the proxy service
- Deploy the given proxy service in ESB by appropriatly changing following vfs parameters to reflect the in, out and fail locations
```sh
parameter name="transport.vfs.FileURI
parameter name="transport.vfs.MoveAfterFailure
parameter name="transport.vfs.MoveAfterProcess
```
- Place the given edi file in the folder defined by "transport.vfs.FileURI" parameter
