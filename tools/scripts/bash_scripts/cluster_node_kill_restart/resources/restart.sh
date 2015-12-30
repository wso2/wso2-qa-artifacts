#!/bin/bash
SENTINAL=0;

#create jmxterm input file
ssh -i $1 $2@$3 'echo run restart -b org.wso2.carbon:type=ServerAdmin -d org.wso2.carbon -m > input';
if [ "$?" != 0 ]; then
	SENTINAL=1;
fi

scp -i $1 $4/jmxterm-1.0-alpha-4-uber.jar $2@$3:/home/$2;
if [ "$?" != 0 ]; then
	SENTINAL=1; 
fi

if [ $SENTINAL = 0 ]; then
	 ssh -i $1 $2@$3 'java -jar jmxterm-1.0-alpha-4-uber.jar -i input -l localhost:9999 -p admin -u admin -v brief -n';
	 if [ "$?" = 0 ]; then
		echo Server restarted on $3;
	 fi
	 
else
  	 echo ERROR;
fi

