## Read Me for DS200_Test_Script_SAML_SSO

This test script can be used to create different types of dashboards with SSO feature enabled for any user in the super tenant's domain. This test creates a dashboard with a banner layout and adds an image to the banner. The dashboard comprises of USA Map, USA Business Revenue and USA Social Media Usage gadgets all linked through events and also Publisher and Subscriber gadgets linked together.

### Follow the below steps to run the test plan

##### Run the DS200_Test_Script_SAML_SSO.jmx
1. Create a Service Provider and configure SSO according to the link below.
https://docs.wso2.com/display/DS200/Configuring+SSO+in+DS
2. Open Jmeter and navigate to File -> Open and browse the DS200_Test_Script_SAML_SSO.jmx file
3. Configure the user defined variables accordingly. (Descriptions of the variables are given)
4. Also, add the hostname and the port in HTTP Request Defaults.
5. Then, run the test plan.

**Note**

 - This script can be used directly for long running tests as the name of the dashboard is created uniquely. (the counter appends a unique value at the end of each dashboard name)
