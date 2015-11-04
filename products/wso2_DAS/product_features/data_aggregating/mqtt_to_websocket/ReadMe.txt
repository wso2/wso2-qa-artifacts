Scenario
===========
In this scenario, DAS collects events that are sent to the MQTT event receiver, these events are then pushed to the mystream_in stream and the execution planner will collect a up to 5 events and pass the events to the out stream. The event publisher will connect to the external web socket consumer and publish the events.

Preconditions
=============
1.Mqtt jar mqtt-client-0.4.0.jar should be added to <das-home>/repository/components/lib

2.MQTT broker such as HiveMQ should be started

3.MQTT Client should be started and connected to the broker

4.Web socket consumer should be started using the command  ant -Dport=9099 -Dsn=0069
[Note: for the web socket consumer we can use the consumer that is available within the CEP400 pack wso2cep-4.0.0/samples/consumers/websocket]


Steps
======
1.Add the event streams mystream_in_1.0.0.json and mystream_out_1.0.0.json to path <das-home>/repository/deployment/server/eventstreams

2.Add the event receiver ex: mqtt_input.xml to <das-home>/repository/deployment/server/eventreceiver

3.Add the execution planner  ex: ExecutionPlan.siddhiql to <das-home>/repository/deployment/server/executionplans

4.Add the websocket.xml to <das-home>/repository/deployment/server/eventpublisher.
[The websocket.server.url should be given as : ws://<host-name/your-IP>:9099/events/ since we are using the consumer available with CEP]

5.Add the topic of the event receiver to an MQTT client ex:mqtt_topic and push a message

6.Access the MQTT client and push a message to the subscribed topic ex:mqtt_topic

meta_id:70,
id:70,
val1:100,
val2:100,
val3:50,
val4:4,
val5:70,
val6:45,
val7:100,
val8:4,
val9:70,
val10:70,
name1:data5,
name2:data2,
name3:data3,
name4:data2,
name5:data1

Note: All published events should be visible on the websocket console
