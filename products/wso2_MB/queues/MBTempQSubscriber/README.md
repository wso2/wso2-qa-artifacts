WSO2 Message Broker Temporary Queue Subscriber
==============================================

**Building the project** 

Run the following command from the project root 

mvn clean install

**Running the subscriber**

**With Default parameters**

java -jar target/MBTempQSubscriber.jar

**With Custom Parameters**

java -jar target/MBTempQSubscriber.jar <IP> <PORT> <USERNAME> <PASSWORD>

e.g : 
java -jar target/MBTempQSubscriber.jar 10.100.5.112 5672 admin admin
