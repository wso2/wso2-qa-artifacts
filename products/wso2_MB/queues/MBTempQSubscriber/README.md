WSO2 Message Broker Temporary Queue Subscriber
==============================================

Building the project: run the following command from the project root 

mvn clean install

Running the subscriber:

**With Default parameters**

java -jar target/MBTempQSubscriber.jar

**With Custom Parameters**

java -jar target/MBTempQSubscriber.jar localhost 5672 admin admin
