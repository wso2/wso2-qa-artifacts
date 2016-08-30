Author :Asanka Vithanage
Related public jira : 
Related test case : https://testlink.wso2.com/linkto.php?tprojectPrefix=ESB&item=testcase&id=ESB-3891

Purpose of the artifact:
This artifact is created to verify that aggregate mediator can successfully aggregate the content of many response messages

Deployment steps:

Unzip and start ESB 4.9.0 pack.
Navigate to <ESB_HOME>/ bin folder
Run wso2server.sh file in order to start the server.
Copy aggregateMediatorTestProxy.xml file into <ESB_HOME>/repository/deployment/server/synapse-configs/default/proxy-services folder.


Note :
When the artifacts successfully deployed you should be able to see a proxyservice with name “aggregateMediatorTestProxy”
