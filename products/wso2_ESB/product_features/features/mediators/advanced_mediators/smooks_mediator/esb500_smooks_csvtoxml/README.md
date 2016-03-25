# README

Smooks mediator can be used to handle many conversion scenarios and this particular artifact converts a CSV file to XML
> Note: This particular sample is tested with WSO2 ESB 5.0.0 M2 
### Contents 

  - Smooks configuration file : smooksconfig.xml
  - Proxy service: Smooks1.xml
  - CSV file: smooks.csv

### Preconditions
- VFS transport should be enabled in ESB
- Local folder locations should be created as in, out and fail

### Steps
- Upload the given smooks configuration file to governance registry
- Deploy the given proxy service in ESB by appropriatly changing following vfs parameters to reflect the in, out and fail locations
```sh
parameter name="transport.vfs.FileURI
parameter name="transport.vfs.MoveAfterFailure
parameter name="transport.vfs.MoveAfterProcess
```
- Place the given csv file in the folder defined by "transport.vfs.FileURI" parameter

### Sample console output
```sh
<?xml version='1.0' encoding='utf-8'?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"><soapenv:Body><people><person number="1"><firstname>Chathurika</firstname><lastname>Erandi</lastname><gender>Female</gender><age>30</age><country>Sri Lanka</country></person><person number="2"><firstname>Naleen</firstname><lastname>Perera</lastname><gender>Male</gender><age>35</age><country>Sri Lanka</country></person></people></soapenv:Body></soapenv:Envelope>
```
