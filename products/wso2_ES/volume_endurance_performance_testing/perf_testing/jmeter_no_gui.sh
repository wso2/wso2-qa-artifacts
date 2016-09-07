#! /usr/bin/env bash

# DOC : http://jmeter.apache.org/usermanual/get-started.html#options, https://blazemeter.com/blog/top-2-techniques-get-jmeter-test-results-non-gui-mode, 
#       http://jmeter.apache.org/usermanual/listeners.html#batch

JMETER_NO_GUI_HOME=/home/ubuntu/perf_test_es_2_1
if [ $# -gt 0 ]; then
        echo "Running $1 test....."
        result_name=$2 || "no_name"
        jmeter -n -t $1 -l $JMETER_NO_GUI_HOME/jmeter_results/$result_name-samples.jtl -j $JMETER_NO_GUI_HOME/jmeter_results/logs/run.log
else
        echo "No test specified for running"
fi
