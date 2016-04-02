This folder contain synapse.xml which is used when testing ESB Header mediator. 
#### synapse.xml

##### Description:
This synapse.xml file contains all sequences and relevant proxy services used when testing ESB Header mediator.

##### Steps:
1) Deploy sample service "SimpleStockQuote" if you didn't. 
> How ?    
> Navigate to $ESB_HOME/sample/axis2Server/src/SimpleStockQuoteService/).
> Deploy service.  Run following command to deploy.
```sh
$ ant
```

2) Start axis2 server
> Note : Sample axis2 server can be find in $ESB_HOME/sample/axis2Server/
```sh
$ sh axis2server.sh
```

3) Start ESB 
> Navigate to $ESB_HOME/bin
```sh
$ sh wso2server.sh
```

4) Navigate to Source View (Home > Manage > Service Bus	> Source View)
5) Add synapse.xml configurations through source view and "Update" it.
6) Invoke proxy services according to the testing scenario. (Can use SOAP UI or Axis2 client)
Ex: ant stockquote -Daddurl=http://localhost:8280/services/inlineXMLHeader -Dmode=placeorder







