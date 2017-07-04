###### **Product Version** - APIM 2.1.0 Version
###### **Scenario** - Create and publish APIs
&nbsp;
#### **Description**
This script can be used to create and publish multiple APIs in APIM and useful for a long running test scenario. The number of APIs to create can be configured using the "NUM" in the apipublisher.sh
 

 #### **Invoking Scenario**
1. Download and Start APIM 2.1.0 Pack
2. Open the script file and provide the number APIs that you want to create under "NUM".
3. Go to the script location and run the script using following command
```
sh apipublisher.sh
```
4. Log in to publisher using "_https://<HOST>:<PORT>/publisher_" URL
5. Verify whether the APIs are created and in "PUBLISHED" status

**Note** - This script is configured to run with default port offset and admin user. You can adjust the script to create multiple APIs by configuring the script with your environment details (host, port, username, password, APIName etc.)
