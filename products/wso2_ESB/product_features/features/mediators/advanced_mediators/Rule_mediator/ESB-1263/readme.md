This folder contains the artifacts that can be used to test following scenario on ESB rule mediator.
### ESB Rule mediator reading rules from registry.

**Author :** Nayomi

Follow beow steps to check this scenario.

- Start ESB and build SimpleStockQuoteService.
> go to ESB_HOME -> samples -> axis2Server -> src ->SimpleStockQuoteService. and type "ant"

- Start the axis2server in ESB.
> type ESB_HOME/samples/axis2Server/axis2server.sh

- Cretae a ESB proxy using rule-mediator-proxy text file in this folder.
1. Go to Add -> proxy service -> custom proxy in ESB management console UI.
2. Click on switch to source view in custom proxy.
3. Copy and paste the content in rule-mediator-proxy text file.Save it.

- Upload the rule.drl file to config registry.
 1. Go to Browse -> config -> repository .
 2. Click on add resource.
 3. Upload the .drl file by clicking on browse button.
 4. Click on Add button and the rule.drl will be added to the config registry.
 
According to the rules that has included in the rule mediator, only requests that comes with symbol IBM will be passed to the "SimpleStockQuoteSerice" service and generate a stock value.

- Invoke the proxy service using below commands.
1. ant stockquote -Daddurl=https://nayomi-ThinkPad-T540p:8243/services/proxyService2 -Dsymbol=IBM
 > above command will generate the stock value for stockquote IBM.In axis2server logs, the log "Generating quote for : IBM" should be displayed.In ESB console logs, log mediator should be displyed the response message.

2. ant stockquote -Daddurl=https://nayomi-ThinkPad-T540p:8243/services/proxyService2 -Dsymbol=SUN
> above command should not generate any stock quote value and error sequence should be hit according to the rules of the rule mediator in proxy service.

3. Can run the above command for other symbols as well (MSFT, WSO2 etc...).And they should return the same responses like generated for symbol SUN.


