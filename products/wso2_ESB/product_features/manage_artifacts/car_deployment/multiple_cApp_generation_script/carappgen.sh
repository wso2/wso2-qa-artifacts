#!/bin/bash

i=1
mkdir bulk
while test $i != 500
do
mkdir main
mkdir main/testProxy_${i}-1.0.0
sed 's/testProxy/testProxy_'$i'/g' testProxy-1.0.0.xml > ./main/testProxy_${i}-1.0.0/testProxy_${i}-1.0.0.xml
sed -e 's/testProxy/testProxy_'$i'/g' -e 's/testProxy-1.0.0.xml/testProxy_'$i'-1.0.0.xml/g'  artifact.xml > ./main/testProxy_${i}-1.0.0/artifact.xml
sed -e 's/testCar/testCar_'$i'/g' -e 's/testProxy/testProxy_'$i'/g' artifacts.xml > ./main/artifacts.xml

cd ./main
jar -cvf testCar_${i}.car *

mv testCar_${i}.car ../bulk

i=`expr $i + 1
`
cd ../
rm -rf main


done



