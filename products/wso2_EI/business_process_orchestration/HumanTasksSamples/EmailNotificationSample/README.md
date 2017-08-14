# README
**Author :** Dilshani Subasinghe

### Description
This folder contains sample for BPS Human task email notifications which will trigger mail due to a defined deadline.
 * taskDeadlineWithNotifications.zip

### Setup 

    Product Version: WS02 BPS 3.6.0, WSO2 EI 6.2.0

### Contents

  - ClaimsApprovalTask.ht
  - ClaimsApprovalTaskService.wsdl
 
Note: Deploy ClaimReminderService and ClaimService
    
### Pre-conditions

- Enable email notifications in BPS. 
Refer: https://docs.wso2.com/display/BPS360/Enabling+Email+and+SMS+Notifications+for+Human+Tasks

### Execution steps
1. Start business process profile 
2. Login in to carbon console (Ex: https://localhost:9443/carbon/)
3. Create roles as "regionalClerks","regionalManager" and "clerksManager"
4. Create users for the respective roles and assign those users to the roles.
5. Deploy sample in human tasks.

There will be two services as follows;
- ClaimReminderService and ClaimService

#### ClaimReminderService
-    This service will directly create notifications

Sample request to invoke service
```
<body>
   <p:notify xmlns:p="http://www.example.com/claims/">
      <!--Exactly 1 occurrence-->
      <firstname>Dilshani</firstname>
      <!--Exactly 1 occurrence-->
      <lastname>Subasinghe</lastname>
   </p:notify>
</body>
``` 


#### ClaimService
- This service will create humn notification. When we start notification via "HumanTask Explorer", it may consider deadline condition

According to this sample, param called "amount" should be less than "10000". It is defined in "ClaimsApprovalTask.ht" as follows;
```
<htd:condition>
<![CDATA[htd:getInput("ClaimApprovalRequest")/test10:amount < 10000]]>	
</htd:condition>
```
If you don't need any condition, it can define as follows;
```
 <htd:condition>
		 <![CDATA[true()]]>	
 </htd:condition> 
```
If that condition going to meet, it will going to escalate after given time as follows: It is one minute in the sample.
```
<htd:for>PT1M</htd:for>
```
After the escalation, mail should be receive.
#### Note: 
- Mail address should be support third party mail servers. Otherwise you may not receive the mail. 

Sample request to invoke service

```
<body>
   <p:ClaimApprovalData xmlns:p="http://www.example.com/claims/schema">
      <!--Exactly 1 occurrence-->
      <p:cust>
         <!--Exactly 1 occurrence-->
         <p:id>001</p:id>
         <!--Exactly 1 occurrence-->
         <p:firstname>Dilshani</p:firstname>
         <!--Exactly 1 occurrence-->
         <p:lastname>Subasinghe</p:lastname>
      </p:cust>
      <!--Exactly 1 occurrence-->
      <p:amount>10</p:amount>
      <!--Exactly 1 occurrence-->
      <p:region>TEST</p:region>
      <!--Exactly 1 occurrence-->
      <p:priority>2</p:priority>
   </p:ClaimApprovalData>
</body>
```

For more references: https://docs.wso2.com/display/EI620/Claims+Approval+Task+with+Deadline+Sample

Enhanced above sample to support email notifications.



