#!/bin/bash
ssh -i $1 $2@$3 'kill -9'$4' ;';
