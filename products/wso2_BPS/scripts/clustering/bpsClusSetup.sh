#!/bin/bash

#script to copy config files
#script assumes there is no config changes
#The file should be placed in ~/xxx/xx/xx/ directory

# ------------ FUNCTION ---------------
# User confirmation to copy between manager and worker node
bdate(){
        clear
        echo -e "\033[40;32m--- Pls Provide the build date in the format XX-MMM e.g. 7jan ---\033[5m"
        read bdate
	PACK_DIR="/home/wso2/4.2.0/packs/""$bdate"
        mkdir -p $PACK_DIR
	return $bdate

}


build(){
        clear
        echo -e "\033[40;32m--- DOWNLOAD BUILD? YES/NO ---\033[5m"
        echo -e "\033[40;33m1.YES\033[m"
        echo -e "\033[40;33m2.NO \033[m"
        read choice
	echo $choice

	if [ "$choice" == "1" ];then
		clear
		echo -e "\033[40;33mPls provide the complete url of the build\033[m"
		read url
		echo $bdate
		PACK_DIR="/home/wso2/4.2.0/packs/""$bdate"
		wget -v -r -O $PACK_DIR/wso2bps-3.2.0.zip $url
	else
		echo -e "Download not initiated"
	fi

}

nodeChoice(){
        clear
        echo -e "\033[40;32m--- PROVIDE # TO COPY THE CONFIG FILE ---\033[5m"
        echo -e "\033[40;33m1.Manager\033[m"
        echo -e "\033[40;33m2.Worker1 \033[m"
	echo -e "\033[40;33m3.Worker2 \033[m"
	echo -e "\033[40;33m4.EXIT \033[m"
        read UserConf

        if [ "$UserConf" == "1" -o "$UserConf" == "2" -o "$UserConf" == "3" -o "$UserConf" == "4" ]; then
                return $UserConf
        else
                echo -e "\033[40;34mIn-appropriate choice \033[m"
                nodeChoice
        fi
}

#Main script start here
echo -e "\033[40;32m--- This script assumes  ---\033[5m"
echo -e "\033[40;32m--- * Manager and Worker1 nodes run in 192.168.18.17 ---\033[5m"
echo -e "\033[40;32m--- * Worker2 node runs in 192.168.18.20 ---\033[5m"
echo -e "\033[40;32m--- * Required conf files for clustering backed up in /home/wso2/4.2.0/BPS320/conf/ location \033[5m"
echo -e "==========================================================================================="
echo -e ""
echo -e ""
echo -e "Press ENTER to continue ....."
read a


bdate
build
UserConf=0
nodeChoice

#set -o verbose


if [ "$UserConf" -eq "1" ] 
then

       echo -e "Going to remove existing pack and will unzip the latest build"
       echo -e "Press ENTER to continue....."
       read a 
       CONF_DIR='/home/wso2/4.2.0/BPS320/conf/Mgr'
       BPS_HOME="/home/wso2/4.2.0/BPS320/Mgr/""$bdate""/wso2bps-3.2.0"
       BPS_DIR="/home/wso2/4.2.0/BPS320/Mgr/""$bdate"
       PACK_DIR="/home/wso2/4.2.0/packs/""$bdate"
       rm -rf $BPS_HOME
       unzip $PACK_DIR/wso2bps-3.2.0 -d $BPS_DIR/
       cp -r $BPS_HOME/repository/conf $BPS_HOME/repository/confORG

       echo -e "Copying Configuration files ......"
       cp $CONF_DIR/bin/wso2server.sh $BPS_HOME/bin/
       cp $CONF_DIR/conf/axis2/axis2.xml $BPS_HOME/repository/conf/axis2/
       cp $CONF_DIR/conf/tomcat/catalina-server.xml $BPS_HOME/repository/conf/tomcat/
       cp $CONF_DIR/conf/datasources/master-datasources.xml $BPS_HOME/repository/conf/datasources/
       cp $CONF_DIR/conf/carbon.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/user-mgt.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/registry.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/bps.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/datasources.properties $BPS_HOME/repository/conf/
       cp $CONF_DIR/lib/* $BPS_HOME/repository/components/lib/
       cp $CONF_DIR/dropins/* $BPS_HOME/repository/components/dropins/
       echo -e "Done, Plz look for any erros"

       nodeChoice

fi

if [ "$UserConf" -eq "2" ]
then


       echo -e "Going to remove existing pack and will unzip the latest build"
       echo -e "Press ENTER to continue....."
       read a
       CONF_DIR='/home/wso2/4.2.0/BPS320/conf/Wrk'
       BPS_HOME="/home/wso2/4.2.0/BPS320/Wrk1/""$bdate""/wso2bps-3.2.0"
       BPS_DIR="/home/wso2/4.2.0/BPS320/Wrk1/""$bdate"
       PACK_DIR="/home/wso2/4.2.0/packs/""$bdate"
       rm -rf $BPS_HOME
       unzip $PACK_DIR/wso2bps-3.2.0 -d $BPS_DIR/
       cp -r $BPS_HOME/repository/conf $BPS_HOME/repository/confORG

       echo -e "Copying Configuration files ......"
       cp $CONF_DIR/bin/wso2server.sh $BPS_HOME/bin/
       cp $CONF_DIR/conf/axis2/axis2.xml $BPS_HOME/repository/conf/axis2/
       cp $CONF_DIR/conf/tomcat/catalina-server.xml $BPS_HOME/repository/conf/tomcat/
       cp $CONF_DIR/conf/datasources/master-datasources.xml $BPS_HOME/repository/conf/datasources/
       cp $CONF_DIR/conf/carbon.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/user-mgt.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/registry.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/bps.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/datasources.properties $BPS_HOME/repository/conf/
       cp $CONF_DIR/lib/* $BPS_HOME/repository/components/lib/
       cp $CONF_DIR/dropins/* $BPS_HOME/repository/components/dropins/
       echo -e "Done, Plz look for any erros"

       nodeChoice

fi


if [ "$UserConf" -eq "3" ]
then

       echo -e "Going to remove existing pack and will unzip the latest build"
       echo -e "Press ENTER to continue....."
       read a
       CONF_DIR='/home/wso2/4.2.0/BPS320/conf/Wrk'
       BPS_HOME="/home/wso2/4.2.0/BPS320/wrk2/""$bdate""/wso2bps-3.2.0"
       BPS_DIR="/home/wso2/4.2.0/BPS320/wrk2/""$bdate"
       PACK_DIR="/home/wso2/4.2.0/packs/""$bdate"
       rm -rf $BPS_HOME
       unzip $PACK_DIR/wso2bps-3.2.0 -d $BPS_DIR/
       cp -r $BPS_HOME/repository/conf $BPS_HOME/repository/confORG

       echo -e "Copying Configuration files ......"
       cp $CONF_DIR/bin/wso2server.sh $BPS_HOME/bin/
       cp $CONF_DIR/conf/axis2/axis2.xml $BPS_HOME/repository/conf/axis2/
       cp $CONF_DIR/conf/tomcat/catalina-server.xml $BPS_HOME/repository/conf/tomcat/
       cp $CONF_DIR/conf/datasources/master-datasources.xml $BPS_HOME/repository/conf/datasources/
       cp $CONF_DIR/conf/carbon.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/user-mgt.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/registry.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/bps.xml $BPS_HOME/repository/conf/
       cp $CONF_DIR/conf/datasources.properties $BPS_HOME/repository/conf/
       cp $CONF_DIR/lib/* $BPS_HOME/repository/components/lib/
       cp $CONF_DIR/dropins/* $BPS_HOME/repository/components/dropins/
       echo -e "Done, Plz look for any erros"

       nodeChoice


fi

if [ "$UserConf" -eq "4" ]
then
     clear
     echo -e "Thanks for using the script. Script will terminate now...."
     exit

fi
