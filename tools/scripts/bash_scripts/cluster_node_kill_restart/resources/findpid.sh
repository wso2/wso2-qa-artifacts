#!/bin/bash
ssh -i $1 $2@$3 'pgrep -f '$4;
