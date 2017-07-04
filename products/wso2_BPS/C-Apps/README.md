###### **Product Version** - Business Process Server 3.6.0, Enterprise Integrator 6.1.0
###### **Related testcases** - EI6-4722 , EI6-4873
&nbsp;
##### **Test Scenario** -
This is to verify that a bpel process secured through a developer studio can be successfully deployed to BPS server. Given bpel process is secured with username token policy and the access is granter for any user belongs to '**admin**' role and '**BPSRole**'
##### **Test Description**
1. Start BPS server
2. Create a role named 'BPSRole' and 'TestRole' with relevant permission
3. Create two users and assign those users for the roles created above. (ex: _UserA -> BPSRole_ and _UserB -> TestRole_ )
4. Go to 'Manage' -> 'Carbon Applications' -> 'Add'
5. Select the given 'UTSecuredBPEL_1.0.0.car' file and deploy it 

##### **Verify the Scenario**
If the deployment is successful, "SecuredAdderProcess" bpel service will appear under the services and the security policy 'UTSecurity.xml' will appear in the governance registry.

To invoke the service, import the attached soap project to SoapUI. (Edit the endpoint of the service depending on your environement)
1. Give two numbers in the request and invoke the service - Service invocation should failed as the authentication details not provided
2. Configure the following request properties* for a user belongs to _'admin'_ role and _'RPSRole'_ role, and invoke the service - Service invocations should be successful
3. Configure the following reqest properties* for a user belongs to _'TestRole'_ role and invoke the service  - Service invocation should failed

*Request roperties
 username
Password
WSS-Password Type = PasswordText
WSS TimeToLive = 100


