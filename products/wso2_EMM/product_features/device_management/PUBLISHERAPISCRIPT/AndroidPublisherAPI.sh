#!/bin/bash

APK="";
IMG="";
APPID="";
OPP="";
CLIENTID="";
CLIENTSEC="";
OAUTH_BASIC_TOKEN="";
PUB_SCOPED_TOKEN="";
CRE_SCOPED_TOKEN="";


#REG OAUTH APP
OAUTH_RESP=$(curl -k -H "Content-Type: application/json" -X POST -d '{"owner":"admin","clientName":"admin_emm","grantType":"refresh_token password client_credentials","tokenScope":"prod"}' "https://$1:$2/dynamic-client-web/register")
CLIENTID=$(echo $OAUTH_RESP | cut -d "," -f4 | cut -c14-41)
CLIENTSEC=$(echo $OAUTH_RESP | cut -d "," -f2 | cut -c18-45)
OAUTH_BASIC_TOKEN=$(echo "$CLIENTID:$CLIENTSEC" | base64 | head -n 1);


#GEN CREATE TOKEN
CRE_SCOPED_TOKEN=$(curl -k -d "grant_type=password&username=admin&password=admin&scope=appm:create" -H "Authorization: Basic $OAUTH_BASIC_TOKEN" -H "Content-Type: application/x-www-form-urlencoded" "https://$1:$2/oauth2/token" | cut -d "," -f1 | cut -c18-49) ;


# UPLOAD APP
curl -X POST -H "Content-Type: multipart/form-data" -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -F "file=@app-debug.apk" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobile/binaries" | grep "com.example.dumiduh.h" ;

if [ $? -gt 0 ]; then
	echo  "$(date) - App upload error." >> errorlog.log ; 
fi

# UPLOAD BANNER
curl -X POST -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -H "Content-Type: multipart/form-data" -F "file=@TEST.jpg" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/static-contents?appType=mobileapp" | grep "/api/mobileapp/getfile/" ;

if [ $? -gt 0 ]; then
        echo  "$(date) - Banner upload error." >> errorlog.log ;
fi

# UPLOAD SCREENSHOT
curl -X POST -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -H "Content-Type: multipart/form-data" -F "file=@TEST.jpg" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/static-contents?appType=mobileapp" | grep "/api/mobileapp/getfile/" ;

if [ $? -gt 0 ]; then
        echo  "$(date) - Screenshot upload error." >> errorlog.log ;
fi

# UPLOAD ICON
curl -X POST -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -H "Content-Type: multipart/form-data" -F "file=@TEST.jpg" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/static-contents?appType=mobileapp" | grep "/api/mobileapp/getfile/" ;

if [ $? -gt 0 ]; then
        echo  "$(date) - Icon upload error." >> errorlog.log ;
fi

# CREATE APP
APK=$(curl -X POST -H "Content-Type: multipart/form-data" -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -F "file=@app-debug.apk" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobile/binaries" | cut -d "/" -f5 | cut -c1-19)

IMG=$(curl -X POST -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -H "Content-Type: multipart/form-data" -F "file=@TEST.jpg" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/static-contents?appType=mobileapp" | cut -d "/" -f5 | cut -c1-19)

OPP="create";

sed -i -- "s/APKHOLDER/$APK/g" payload.json ;
sed -i -- "s/IMGHOLDER/$IMG/g" payload.json ;
sed -i -- "s/OPPHOLDER/$OPP/g" payload.json ;

curl -X POST -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -H "Content-Type: application/json" -d @payload.json -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobileapp" | grep "visibleRoles" ;

if [ $? -gt 0 ]; then
        echo  "$(date) - App creation error." >> errorlog.log ;
fi


sed -i -- "s/$APK/APKHOLDER/g" payload.json ;
sed -i -- "s/$IMG/IMGHOLDER/g" payload.json ;
sed -i -- "s/$OPP/OPPHOLDER/g" payload.json ;

#--------------- -----------
#      publish scope tests
#---------------------------


APK=$(curl -X POST -H "Content-Type: multipart/form-data" -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -F "file=@app-debug.apk" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobile/binaries" | cut -d "/" -f5 | cut -c1-19)

IMG=$(curl -X POST -H "Authorization: Bearer $CRE_SCOPED_TOKEN" -H "Content-Type: multipart/form-data" -F "file=@TEST.jpg" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/static-contents?appType=mobileapp" | cut -d "/" -f5 | cut -c1-19)

OPP="approve";

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

#SUBMIT FOR REVIEW
curl -X POST -H "Authorization: Bearer $PUB_SCOPED_TOKEN" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobileapp/change-lifecycle?appId=$APPID&action=Submit%20for%20Review" | grep "Submit for Review"

if [ $? -gt 0 ]; then
        echo  "$(date) - error while submitting app for review." >> errorlog.log ;
fi


#APPROVE APP
curl -X POST -H "Authorization: Bearer $PUB_SCOPED_TOKEN" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobileapp/change-lifecycle?appId=$APPID&action=Approve" | grep "Approve"

if [ $? -gt 0 ]; then
        echo  "$(date) - error while approving app" >> errorlog.log ;
fi

#PUBLISH APP
curl -X POST -H "Authorization: Bearer $PUB_SCOPED_TOKEN" -k -v "https://$1:$2/api/appm/publisher/v1.0/apps/mobileapp/change-lifecycle?appId=$APPID&action=Publish" |  grep "Publish"

if [ $? -gt 0 ]; then
        echo  "$(date) - error while publishing app" >> errorlog.log ;
fi



echo "-------- Script run complete. --------"
