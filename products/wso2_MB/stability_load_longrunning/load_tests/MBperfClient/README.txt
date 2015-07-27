###################################################################
	Message Broker Performance Test Client - README
###################################################################

NOTE: Please update the script before running

killer.sh
---------
to execute run
./killer.sh

perfTest.sh
-----------
Need to configure the script to test specification
to execute run
./perfTest.sh


Getting Statistics
------------------
When the performance run is done use the following commands to get the Average Performance Values.

TPS:
grep "TPS" logs/producer*;grep "TPS" logs/producer* | wc -l;grep "TPS" logs/producer* | awk '{s+=$4} END {print s/4}'

Throughput:
grep "Throughput" logs/*;grep "Throughput" logs/* | wc -l;grep "Throughput" logs/* | awk '{s+=$4} END {print s/4}'

Latency:
grep "Latency" logs/*; grep "Latency" logs/* | wc -l;grep "Latency" logs/* | awk '{s+=$4} END {print s/4}'
