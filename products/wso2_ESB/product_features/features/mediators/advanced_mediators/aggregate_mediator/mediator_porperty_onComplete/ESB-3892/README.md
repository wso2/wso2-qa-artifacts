Author :Asanka Vithanage
Related public jira : https://wso2.org/jira/browse/ESBJAVA-4792
Related test case : https://testlink.wso2.com/linkto.php?tprojectPrefix=ESB&item=testcase&id=ESB-3892

Purpose of the artifact:
This artifact is created to verify that aggregate mediator doesn’t accept the message after  the timeout. In this case we are specially verifying aggregate mediator used with Iterator mediator.

 Deployment steps

Unzip and start ESB 4.9.0 pack.
Navigate to <ESB_HOME>/ bin folder
Run wso2server.sh file in order to start the server.
Copy timeoutIterator.xml file into <ESB_HOME>/repository/deployment/server/synapse-configs/default/proxy-services folder.


Note :-
When the artifacts successfully deployed you should be able to see a proxyservice with name “timeoutIterator”
