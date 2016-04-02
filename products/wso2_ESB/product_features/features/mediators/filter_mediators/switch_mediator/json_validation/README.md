This folder contain synapse.xml which is used when testing ESB Switch mediator with JSON.
#### synapse.xml

##### Description:
This synapse.xml file contains a sequence which contains switch mediator with JSON path and Proxy service which invoke particular sequence.

##### Steps:
1) Start ESB 
> Navigate to $ESB_HOME/bin
```sh
$ sh wso2server.sh
```
2) Navigate to Source View (Home > Manage > Service Bus	> Source View)
3) Add synapse.xml configurations through source view and "Update" it.
4) Invoke proxy service. (Can use sample JSON client)
> Ex: Navigate to $ESB_HOME/samples/axis2Client/
```sh
$ ant jsonclient -Daddurl=http://localhost:8280/services/jsonProxy -Dsymbol=DELL
```
##### Expected Outcome:
According to value given to symbol (-Dsymbol), it will log relevant log properties.

Ex: When give the Symbol as DELL (-Dsymbol=DELL)
```sh
[2016-03-26 09:40:05,705]INFO - LogMediator To: /services/jsonProxy, MessageID: urn:uuid:cf042ccd-caec-425c-95dc-2abde4f67a78, Direction: request, Payload: {"getQuote":{"request":{"symbol":"DELL"}}}
[2016-03-26 09:40:05,706]INFO - LogMediator To: /services/jsonProxy, MessageID: urn:uuid:cf042ccd-caec-425c-95dc-2abde4f67a78, Direction: request, DELL = =========Symbol is DELL======, Payload: {"getQuote":{"request":{"symbol":"DELL"}}}
```
