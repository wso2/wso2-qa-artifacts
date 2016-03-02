#Verification of HTTP HEAD method#

##Introduction##

Artifacts attached herewith are used to test HTTP Head Method.

##Steps##

1. Build and deploy the following samples on Application server.
       `https://docs.wso2.com/display/AS521/JAX-RS+Basics
       https://docs.wso2.com/display/AS521/JAX-RS+Advanced`

2. Start Application Server

3. Change IP and Ports in synapse configurations to match the Application Server IP and port.

4. Change the IP in the test script to the IP and Port of ESB.

5. Deploy all the synapse configurations in <ESB_HOME>/repository/deployment/server/synapse-configs/default/api

6. Open the test script on Jmeter an execute it.
