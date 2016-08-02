**Author :** Sewmini Jayaweera

**Related public jira :** https://wso2.org/jira/browse/ESBJAVA-2907

**Related test case :** https://testlink.wso2.com/linkto.php?tprojectPrefix=ESB&item=testcase&id=ESB-1301

#### Purpose of the artifact:
This articat is created to verify that different types of property values (OM, STRING, DOUBLE, BOOLEAN, INTEGER) that comes with the message are preserved in In memory store successfully. 

#### Deployment steps

1. Unzip and start ESB 4.9.0 pack.
2. Navigate to <ESB_HOME>/ bin folder 
3. Run wso2server.sh file in order to start the server.
4. Copy sequences/AProcessorSequence.xml file into <ESB_HOME>/repository/deployment/server/synapse-configs/default/sequences folder.
5. Copy 'api' folder into <ESB_HOME>/repository/deployment/server/synapse-configs/default folder.
6. Copy 'message-stores' folder into <ESB_HOME>/repository/deployment/server/synapse-configs/default folder. 
7. Copy 'message-processors' folder into <ESB_HOME>/repository/deployment/server/synapse-configs/default folder.

###### Note :-
When all artefacts are successfully deployed you should be able to see; 

- An API having API name "ESBJAVA2907"
- Sequence having sequence name "AProcessorSequence"
- In memory message store named "AMessageStore".
- Message processor having message processor name "AMessageProcessor" and type "Message Sampling Processor".