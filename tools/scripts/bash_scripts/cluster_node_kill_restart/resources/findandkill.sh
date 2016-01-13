#!/bin/bash
ssh -i $1 $2@$3 'kill -15 $(pgrep -f '$4')';
ssh -i $1 $2@$3 'echo $?';
