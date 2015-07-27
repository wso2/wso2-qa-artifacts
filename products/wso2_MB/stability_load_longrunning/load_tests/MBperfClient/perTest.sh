#!/bin/bash

# Nummber of consumers
CONSUMERS=4

# Number of producers
PRODUCERS=4

# Queue Name
QUEUE=QU001

# Consumer Parameters
# -------------------

# Number of requests to consume before exiting
REQUESTS=25000

# High and Low Values in which Latency is calculated against
LOW_CAP=5000
HIGH_CAP=23000

# Producer Parameters
# -------------------

# Number of requests to produce
TREQUESTS=26000

# sleep time between messages (keep 0)
SLEEP=0

# File size of the message
FILE=1KB

# MB Nodes
NODE[0]=10.179.146.158
NODE[1]=10.136.72.167
NODE[2]=10.187.62.130
NODE[3]=10.183.56.160

NODE_COUNT=${#NODE[@]}
# Kill All consumer clients
#echo "Kill All consumer Clients"
#ps -ef | grep MBperfTest.jar | grep receive | awk '{print $2}'| xargs kill -9
#sleep 3
#echo "Kill All producer Clients"
#ps -ef | grep MBperfTest.jar | grep send | awk '{print $2}'| xargs kill -9
#sleep 3

# clean all logs
rm logs/receiver*
rm logs/producer*

if [ "$CONSUMERS" != "0" ]; then
	echo "creating $CONSUMERS consumers"
	for i in `seq 1 $CONSUMERS`
	do
#		QUEUE="QU00$i"
		NODETOUSE=$(( $i % $NODE_COUNT ))
		echo "using Node : $NODETOUSE"
		if [ "$NODETOUSE" == "1" ];then
			java -jar out/artifacts/MBperfTest_jar/MBperfTest.jar queue receive ${NODE[0]} 5672 $QUEUE $REQUESTS $LOW_CAP $HIGH_CAP >> logs/receiver_node1_$i.log &
			sleep 1
		elif [ "$NODETOUSE" == "2" ];then
                        java -jar out/artifacts/MBperfTest_jar/MBperfTest.jar queue receive ${NODE[1]} 5672 $QUEUE $REQUESTS $LOW_CAP $HIGH_CAP >> logs/receiver_node2_$i.log &
                        sleep 1
		elif [ "$NODETOUSE" == "3" ];then
                        java -jar out/artifacts/MBperfTest_jar/MBperfTest.jar queue receive ${NODE[2]} 5672 $QUEUE $REQUESTS $LOW_CAP $HIGH_CAP >> logs/receiver_node3_$i.log &
                        sleep 1
		elif [ "$NODETOUSE" == "0" ];then
                        java -jar out/artifacts/MBperfTest_jar/MBperfTest.jar queue receive ${NODE[3]} 5672 $QUEUE $REQUESTS $LOW_CAP $HIGH_CAP >> logs/receiver_node4_$i.log &
                        sleep 1
		fi
	done
fi

if [ "$PRODUCERS" != "0" ]; then
	sleep 5
	echo "creating $PRODUCERS producers"
        for i in `seq 1 $PRODUCERS`
        do
#                QUEUE="QU00$i"
                NODETOUSE=$(( $i % $NODE_COUNT ))
		echo "using Node : $NODETOUSE"
                if [ "$NODETOUSE" == "1" ];then
                        java -jar out/artifacts/MBperfTest_jar/MBperfTest.jar queue send ${NODE[0]} 5672 $QUEUE $TREQUESTS $SLEEP $FILE >> logs/producer_node1_$i.log &
                        sleep 1
                elif [ "$NODETOUSE" == "2" ];then
                        java -jar out/artifacts/MBperfTest_jar/MBperfTest.jar queue send ${NODE[1]} 5672 $QUEUE $TREQUESTS $SLEEP $FILE >> logs/producer_node2_$i.log &
                        sleep 1
                elif [ "$NODETOUSE" == "3" ];then
                        java -jar out/artifacts/MBperfTest_jar/MBperfTest.jar queue send ${NODE[2]} 5672 $QUEUE $TREQUESTS $SLEEP $FILE >> logs/producer_node3_$i.log &
                        sleep 1
                elif [ "$NODETOUSE" == "0" ];then
                        java -jar out/artifacts/MBperfTest_jar/MBperfTest.jar queue send ${NODE[3]} 5672 $QUEUE $TREQUESTS $SLEEP $FILE >> logs/producer_node4_$i.log &
                        sleep 1
                fi
        done

fi
