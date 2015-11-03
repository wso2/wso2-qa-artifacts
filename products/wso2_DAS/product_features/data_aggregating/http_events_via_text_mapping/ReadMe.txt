Scenario
============
DAS will receive HTTP events sent via JMeter or Curl using HTTP event receiver and pass to the org.wso2.event.sensor.stream_1.0.0. The receiver has been configured with mapping to identify the text payload that is pushed via the http event receiver. The events will be processed from the event stream and  published on the console on logger publisher.


Steps
=====
1.Add the event streams org.wso2.event.sensor.stream_1.0.0.json to path <das-home>/repository/deployment/server/eventstreams

2.Add the httpReceiver.xml event receiver to <das-home>/repository/deployment/server/eventreceiver

3.Add the Logger_Publisher.xml to <das-home>/repository/deployment/server/eventpublisher

4.Send events to the HTTP event receiver using the a specific payload using jmeter or curl command

meta_timestamp:4354643,
meta_isPowerSaverEnabled:true,
meta_sensorId:50,
meta_sensorName:data4,
correlation_longitude:5.443435,
correlation_latitude:4.504343,
humidity:9.8,
sensorValue:90.34344

5.Check events published on console using logger

