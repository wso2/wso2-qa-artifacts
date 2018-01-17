#!/bin/bash
#finds wso2 product prodess in provided location and kills it. Then restarts the server after a defined time period. Continues to do this until the script is stopped.
DOWNTIME=1m
UPTIME=1m
SERVERHOME=/home/pubudup/Documents/WSO2_Products/MB/320/M2/25Aug/n1/wso2mb-3.2.0-M2/bin
while [ true ]
do
PID=`ps -ef | grep $SERVERHOME | awk '{ print $2 }'`
kill -9 $PID
echo WSO2 server killed
sleep $DOWNTIME
cd $SERVERHOME
sh wso2server.sh start
echo WSO2 server started in background
sleep $UPTIME
done

