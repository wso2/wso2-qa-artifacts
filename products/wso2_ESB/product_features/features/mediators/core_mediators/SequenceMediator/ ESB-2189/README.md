This folder will contain configuration files used when running ESB-2189 test case under ESB Sequence mediator.
#### synapse.xml

##### Description:
This test case will consider about invoking a pre-defined sequence using a dynamic key. Therefore sequence should create seperately and refer it from ESB sequence mediator via dynamic key.

##### Preconditions:
  - Create a sequence in a seperate xml file and add it to a local folder. (That xml file also included in this folder > "dynamic_seq_2.xml"). 
    
> Note: This xml file added to ESB pack > "repository/samples/resources/sequence"
 

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
6) Run axis2 Client with the reference link "http://localhost:8280/services/dynamicKeySeq"

Ex: ant stockquote -Daddurl=http://localhost:8280/services/dynamicKeySeq -Dmode=placeorder

#### dynamic_seq_2.xml

##### Description:
This file will create a seperate sequence which will take dynamically by sequence mediator.

##### Preconditions:
Add this file to "$ESB_HOME/repository/samples/resources/sequence/"






