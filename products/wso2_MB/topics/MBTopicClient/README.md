WSO2 Message Broker Topic Client
================================

Building the project:
run the following command from the project root
    mvn clean package
    
Command Reference:

Receiving Messages:
java -jar target/MBTopicClient.jar receive <IP> <PORT> <USERNAME> <PASSWORD> <TOPIC> ''

Sending Messages:
java -jar target/MBTopicClient.jar send <IP> <PORT> <USERNAME> <PASSWORD> <TOPIC> <Number of Requests> <sleepTime> <msgSize (1KB, 100KB, 500KB, 1mb, 5mb, 10mb)>
    

Running a simple scenario:
1. Start the topic receiver
    java -jar target/MBTopicClient.jar receive localhost 5672 admin admin TOPIC1 ''
    
2. Start the topic publisher
    java -jar target/MBTopicClient.jar send localhost 5672 admin admin TOPIC1 100 0 1KB