#!/bin/bash
ssh -i $1 $2@$3 'pgrep -f '$4' | xargs /bin/kill -9';
ssh -i $1 $2@$3 'echo $?';
