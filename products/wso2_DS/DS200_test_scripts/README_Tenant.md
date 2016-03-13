## Read Me for DS200_Test_Script_Tenant

This test script can be used to create different types of dashboards for any user in a tenant's domain. The test creates a dashboard with default and anonymous views. The default view contains 7 different gadgets and anonymous view contains 3 gadgets. Then, the user browses the default and anonymous views.

### Follow the below steps to run the test plan

##### Run the DS200_Test_Script_Tenant.jmx
1. Open Jmeter and navigate to File -> Open and browse the DS200_Test_Script_Tenant.jmx file
2. Configure the user defined variables accordingly. (Descriptions of the variables are given)
3. Also, add the hostname and the port in HTTP Request Defaults.
4. Then, run the test plan.

You can browse the portal as https://<hostname:port>/portal and verify the dashboard created.

**Note**

 - This script can be used directly for long running tests as the dashboard name is created uniquely. (the counter appends a unique value at the end of each dashboard name)
 - This script cannot be created when SSO feature is enabled
