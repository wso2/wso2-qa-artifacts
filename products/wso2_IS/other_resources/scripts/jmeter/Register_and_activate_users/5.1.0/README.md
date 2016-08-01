------------------------------------------------------------------------------

    Script Name:- RegisterUsersAndActivate_IS510.jmx
    Author: Asanthi Kulasinghe
    Supported Product: Identiy Server 5.1.0


Description:
- This script can be used to register users and activate user accounts.
- User creation is handled in multiple threads, each thread contributing to the creation of one user.
- The flow is as follows
     	Log in to the server
     	Register a user
     	Set Challenge question of a user
     	Confirm user self registration and activate the user account, 2 minutes after account creation
     
Pre-Condition:
- Account confirmation and mail sending should be enabled in Identity servers (Instructions can be under 'Environment Setup Instructions' below)
- If you are running this script for a tenant in IS 5.1.0 make sure to add challange questions for that tenant prior to running this script. This is not necessary for the super tenant.
  Eg : Challenge question ID : http://wso2.org/claims/challengeQuestion1
       Challenge question : Favorite food ?

Script Parameters:

Alter the thread group parameters as required.

User details (User Defined Variables)
- userNamePrefix : Prefix for user names
- password 	 : User account password
- tenantDomain   : The tenant domain in which users should be created.
- email          : Email accout to which the account confirmation mail is sent

Server details (User Defined Variables)
- server : server host and ip seperated with a colon

HTTP Authorization Manager 
- Username  : Tenant admin's username
- Password  : Tenant admin's password

------------------------------------------------------------------------------

    Script Name:- RegisterUsersAndActivate_IS510_From_File.jmx
    Author: Asanthi Kulasinghe
    Supported Product: Identiy Server 5.1.0


Description:
- This script can be used to register users and activate user accounts by reading user account details from file.
- The purpose of this script is to make the task of setting challenge questions and account activation independent of the user registration script. 
- There are 3 loop controllers to invoke the 3 operations , account creation , setting the challenge question and account activation.
      User Creation Loop Controller
      SetChallengeQuestionOfUser Loop Controller
      ConfirmUserRegistration Loop Controller
  When 'User Creation Loop Controller' is invoked 'User name' and 'confirmation code' are written to a file 
  When 'SetChallengeQuestionOfUser Loop Controller' and 'ConfirmUserRegistration Loop Controller' are invoked, they use the data from the above file.
- Therefore these 3 loop controllers  can be run together or you can disable the following loop controllers and run them later using the details of user accounts created by the 'User Creation Loop Controller'
      SetChallengeQuestionOfUser Loop Controller
      ConfirmUserRegistration Loop Controller
     
Pre-Condition:
- Account confirmation and mail sending should be enabled in Identity servers (Instructions can be under 'Environment Setup Instructions' below)
- If you are running this script for a tenant in IS 5.1.0 make sure to add challange questions for that tenant prior to running this script. This is not necessary for the super tenant.
  Eg : Challenge question ID : http://wso2.org/claims/challengeQuestion1
       Challenge question : Favorite food ?

Script Parameters:

Alter the thread group parameters as required.

User details (User Defined Variables)
- userNamePrefix : Prefix for user names
- tenantDomain   : The tenant domain in which users should be created.
- email          : Email accout to which the account confirmation mail is sent
- maxUsers       : Number of user accounts to be created

Server details (User Defined Variables)
- server : server host and ip seperated with a colon
- codeFilePath   : Give a file name and a location here. This file will be used to store user account confirmation codes against the user name. Make sure to delete the existing file, if you run this script for a new set of users.

HTTP Authorization Manager 
- Username  : Tenant admin's username
- Password  : Tenant admin's password

------------------------------------------------------------------------------

	Environment Setup Instructions :



1. Enable following event listener in <IS_HOME>/repository/conf/identity/identity.xml  

    <EventListener type="org.wso2.carbon.user.core.listener.UserOperationEventListener" name="org.wso2.carbon.identity.mgt.IdentityMgtEventListener" orderId="50" enable="true"/>

2.  Enable/disable following properties in <IS_HOME>/repository/conf/identity/identity­-mgt.properties
-   Notification.Sending.Internally.Managed=true
-   Authentication.Policy.Account.Lock.On.Creation=true
-   Notification.Expire.Time=7200
-   Notification.Sending.Enable=true
-   Authentication.Policy.Enable=true
-   Captcha.Verification.Internally.Managed=false

3.  Add the following formatter in <IS_HOME>/repository/conf/axis/axis2.xml 

    <messageFormatter contentType="text/html" class="org.apache.axis2.transport.http.ApplicationXMLFormatter"/>

4.  Enable mailto transport sender in <IS_HOME>/repository/conf/axis/axis2.xml 

  	 <transportSender name="mailto" class="org.apache.axis2.transport.mail.MailTransportSender">
  	     <parameter name="mail.smtp.from">sender_email@gmail.com</parameter>
  	     <parameter name="mail.smtp.user">sender_email@gmail.com</parameter>
  	     <parameter name="mail.smtp.password">sender_email_password</parameter>
  	     <parameter name="mail.smtp.host">smtp.gmail.com</parameter>
  	     <parameter name="mail.smtp.port">587</parameter>
  	     <parameter name="mail.smtp.starttls.enable">true</parameter>
  	     <parameter name="mail.smtp.auth">true</parameter>
  	 </transportSender>

