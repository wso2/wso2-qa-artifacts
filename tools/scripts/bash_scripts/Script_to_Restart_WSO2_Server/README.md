# README

**Author :** Pubudu D.P

**Last modified by :** N/A
**Related public jira :** N/A

**Related testcases :** N/A

**Deprecated :** N/A


###Description
This script finds the Process ID of a particular WSO2 product running at a given directory. Stops the server, waits for a predefined time, then starts the server, waits for a pre-defined time, and continues process. This script can be run on each cluster node while testing in progress and use to test the stability of the cluster and how load balancing works between nodes. 

###Setup
Can be used on a stand alone setup as well as in a cluster

> Product Version: Common for Generic WSO2 products (ESB,API-M,MB,etc)


### Contents 
  - restart.sh


### Script parameters
DOWNTIME = Once the server is killed, script sleeps for the defined time. You can provide the DOWNTIME in minutes . eg DOWNTIME=2m.
UPTIME = Once the server is started, script sleeps for the defined time. In other words, server runs for the length defined in UPTIME. eg UPTIME=10m


### Pre-conditions
- Update the absolute path to your [$HOME]/bin location in line 7 and 11 of the script prior to execution



### Execution steps

1. Place the script in [$HOME]/bin directory of your WSO2 product.
2. Goto [$HOME]/bin directory.
3. Execute nohup sh restart.sh & command. This will start the script in background.
4. Execute tail -f nohup to check the script status.



### Expected Outcome
1. WSO2 server should be restarted time to time as per the defined time intervals in DOWNTIME and UPTIME


### Post-Conditions
- To stop the script you have to find the process id and kill it. eg:- ps -ef | grep restart.sh. Then kill -9 PID
