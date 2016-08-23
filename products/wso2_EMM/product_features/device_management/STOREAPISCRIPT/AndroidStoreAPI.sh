#!/bin/bash

APK="";
IMG="";
APPID="";
DEVID="";
OPP="";
CLIENTID="";
CLIENTSEC="";
OAUTH_BASIC_TOKEN="";
PUB_SCOPED_TOKEN="";
CRE_SCOPED_TOKEN="";
SUB_SCOPED_TOKEN="";

#REG OAUTH APP
OAUTH_RESP=$(curl -k -H "Content-Type: application/json" -X POST -d '{"owner":"admin","clientName":"admin_emm_store","grantType":"refresh_token password client_credentials","tokenScope":"prod"}' "https://$1:$2/dynamic-client-web/register")
CLIENTID=$(echo $OAUTH_RESP | cut -d "," -f4 | cut -c14-41)
CLIENTSEC=$(echo $OAUTH_RESP | cut -d "," -f2 | cut -c18-45)
OAUTH_BASIC_TOKEN=$(echo "$CLIENTID:$CLIENTSEC" | base64 | head -n 1);


#GEN CREATE SCOPED TOKEN
CRE_SCOPED_TOKEN=$(curl -k -d "grant_type=password&username=admin&password=admin&scope=appm:create" -H "Authorization: Basic $OAUTH_BASIC_TOKEN" -H "Content-Type: application/x-www-form-urlencoded" "https://$1:$2/oauth2/token" | cut -d "," -f1 | cut -c18-49) ;

#--------------------------
#   PREPING APP
#--------------------------


APK=$(curl -X POST -H "Content-Type: multipart/form-data" -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -F "file=@app-debug.apk" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobile/binaries" | cut -d "/" -f5 | cut -c1-19)

IMG=$(curl -X POST -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -H "Content-Type: multipart/form-data" -F "file=@TEST.jpg" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/static-contents?appType=mobileapp" | cut -d "/" -f5 | cut -c1-19)

OPP="oppst";

sed -i -- "s/APKHOLDER/$APK/g" payload.json ;
sed -i -- "s/IMGHOLDER/$IMG/g" payload.json ;
sed -i -- "s/OPPHOLDER/$OPP/g" payload.json ;

APPID=$(curl -X POST -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -H "Content-Type: application/json" -d @payload.json -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobileapp" | grep "visibleRoles" | cut -d "," -f6 | cut -c7-42)

echo "------- app id = $APPID ----------"

sed -i -- "s/$APK/APKHOLDER/g" payload.json ;
sed -i -- "s/$IMG/IMGHOLDER/g" payload.json ;
sed -i -- "s/$OPP/OPPHOLDER/g" payload.json ;

echo "------ generating publish scoped token ---------"
PUB_SCOPED_TOKEN=$(curl -k -d "grant_type=password&username=admin&password=admin&scope=appm:publish" -H "Authorization: Basic $OAUTH_BASIC_TOKEN" -H "Content-Type: application/x-www-form-urlencoded" "https://$1:$2/oauth2/token" | cut -d "," -f1 | cut -c18-49) ;

# CHANGING APP LC TO PUBLISH
curl -X POST -H "Authorization: Bearer $PUB_SCOPED_TOKEN" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobileapp/change-lifecycle?appId=$APPID&action=Submit%20for%20Review"

curl -X POST -H "Authorization: Bearer $PUB_SCOPED_TOKEN" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobileapp/change-lifecycle?appId=$APPID&action=Approve"

curl -X POST -H "Authorization: Bearer $PUB_SCOPED_TOKEN" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobileapp/change-lifecycle?appId=$APPID&action=Publish"

#GEN SUB TOKEN 
SUB_SCOPED_TOKEN=$(curl -k -d "grant_type=password&username=admin&password=admin&scope=appm:subscribe" -H "Authorization: Basic $OAUTH_BASIC_TOKEN" -H "Content-Type: application/x-www-form-urlencoded" "https://$1:$2/oauth2/token" | cut -d "," -f1 | cut -c18-49) ;


#REG DEVICE
curl -X POST -H "Authorization: Bearer $SUB_SCOPED_TOKEN" -H "Content-Type: application/json" -d @payload3.json -k "https://$1:$2/api/device-mgt/android/v1.0/devices"  

#INSTALL APP
sed -i -- "s/APHOLDER/$APPID/g" payload2.json ;

curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer $SUB_SCOPED_TOKEN" -d @payload2.json -k "https://$1:$2/api/appm/store/v1.0/apps/download" | grep "activityId"

if [ $? -gt 0 ]; then
        echo  "$(date) - App install error." >> errorlog.log ;
fi


#UNINSTALL APP

curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer $SUB_SCOPED_TOKEN" -d @payload2.json -k -v "https://$1:$2/api/appm/store/v1.0/apps/uninstallation" | grep "activityId"

if [ $? -gt 0 ]; then
        echo  "$(date) - App uninstall error." >> errorlog.log ;
fi

#RESET PAYLOAD
sed -i -- "s/$APPID/APHOLDER/g" payload2.json ;




#REMOTE INSTALL UNINSTALL

APK=$(curl -X POST -H "Content-Type: multipart/form-data" -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -F "file=@app-debug.apk" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobile/binaries" | cut -d "/" -f5 | cut -c1-19)

sed -i -- "s/APKHOLDER/$APK/g" payload5.json ;
sed -i -- "s/HOHOLDER/$1/g" payload5.json ;
sed -i -- "s/POHOLDER/$2/g" payload5.json ;
sed -i -- "s/APKHOLDER/$APK/g" payload6.json ;
sed -i -- "s/HOHOLDER/$1/g" payload6.json ;
sed -i -- "s/POHOLDER/$2/g" payload6.json ;



curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer $SUB_SCOPED_TOKEN" -d @payload5.json -k "https://$1:$2/api/device-mgt/android/v1.0/admin/devices/install-application" | grep "INSTALL_APPLICATION"

if [ $? -gt 0 ]; then
        echo  "$(date) - App remote install error." >> errorlog.log ;
fi

curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer $SUB_SCOPED_TOKEN" -d @payload6.json -k "https://$1:$2/api/device-mgt/android/v1.0/admin/devices/uninstall-application" | grep "UNINSTALL_APPLICATION"

if [ $? -gt 0 ]; then
        echo  "$(date) - App remote uninstall error." >> errorlog.log ;
fi

sed -i -- "s/$APK/APKHOLDER/g" payload5.json ;
sed -i -- "s/$1/HOHOLDER/g" payload5.json ;
sed -i -- "s/$2/POHOLDER/g" payload5.json ;
sed -i -- "s/$APK/APKHOLDER/g" payload6.json ;
sed -i -- "s/$1/HOHOLDER/g" payload6.json ;
sed -i -- "s/$2/POHOLDER/g" payload6.json ;



echo "-------- Script run complete. --------"

