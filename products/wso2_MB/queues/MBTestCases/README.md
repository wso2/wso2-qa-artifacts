# README

**Author :** Pubudu D.P

**Last modified by :** N/A

**Related public jira :** N/A

**Related testcase :** Tbd


###Description
This is a simple java project created to test the functionality of Time to Live feature related to queues. For this project to work you have to make sure the following jar files are being added to your java project using desired IDE. These jar files could be found at [$MB_HOME]/client-lib/

andes-client-3.1.9.jar  
geronimo-jms_1.1_spec-1.1.0.wso2v1.jar  
log4j-1.2.13.jar  
slf4j-1.5.10.wso2v1.jar

###Setup
This project should work perfectly with a Message Broker 3.2.0 M2 standlone pack

> Product Version: 3.2.0. M2


### Contents 
MBTestCases java project. (Initially created with IntellijIDEA)

### Script parameters
N/A


### Pre-conditions
- Checkout the project from github repo
- Open the project with Intellij IDEA
- Go to Build from top panel
- Click on 'Make Project' option




### Execution steps

1. Start a standalone Message Broker 3.2.0 M2 pack 
2. Open the class 'QueuesSendDefault'
3. Right click on the class and select "Run" option (This should create the queue called 'DefaultQueue' and subscribe to that queue)
4. Open the class 'QueuesReceiveDefault'
5. Right click on the class and select "Run" option (This should create send messages to the 'DefaultQueue' with defined TTL values)


### Expected Outcome
1. A log should be printed in QueueReceiveDefault output to inform the sent messages are being received to the subscriber (You can change the TTL values and try out the behavior.)

### Post-Conditions
- N/A
