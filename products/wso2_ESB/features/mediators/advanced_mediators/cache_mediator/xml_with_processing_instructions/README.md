#How to handle XML body with processing instructions#

##Steps to verify the scenario##

1. Download WSO2 ESB from [1]
2. Extract it to a folder of your choice
3. Deploy the proxy service from the file system (Drop the CacheProxy.xml to $ESB_HOME/repository/deployment/server/synapse-configs/default/proxy-services)
4. Send a request to the Proxy service. The request payload is available in request.xml

`
E.g.:- curl -X POST -d @request.xml https://10.100.1.11:8243/services/PF -v -k
`
[1] - http://wso2.com/products/enterprise-service-bus/
