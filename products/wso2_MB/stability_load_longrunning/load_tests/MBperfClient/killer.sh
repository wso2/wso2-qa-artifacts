#!/bin/bash

echo "Killing All Clients..."
ps -ef | grep MBperfTest.jar | awk '{print $2}'| xargs kill -9
sleep 3
echo "Removing logs..."
rm logs/*
