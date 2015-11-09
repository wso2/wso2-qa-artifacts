Scenario
=========
The event receiver mqtt_input listens on to the HiveMQ for events. When events are pushed from a MQTT client,the event receiver will collect those events and  then passed to the event stream mystream_in.
The  ExecutionPlan will send events out to  mystream_out_1.0.0 only after 50 events are collected. The output event adaptor will then write all received events into a RDBMS database table.

Preconditions
=============
1.Mqtt jar mqtt-client-0.4.0.jar should be added to <das-home>/repository/components/lib

2.MQTT broker such as HiveMQ should be started

3.mysql jar mysql-connector-java-5.1.21-bin.jar should be added to <das-home>/repository/components/lib

4.access to a mysql db should exist and a database called dasdb and  a table named tbldata should be created

tbldata | CREATE TABLE `tbldata` (
  `meta_id` int(10) DEFAULT NULL,
  `id` int(10) DEFAULT NULL,
  `val1` int(10) DEFAULT NULL,
  `val2` int(10) DEFAULT NULL,
  `val3` int(10) DEFAULT NULL,
  `val4` int(10) DEFAULT NULL,
  `val5` int(10) DEFAULT NULL,
  `val6` int(10) DEFAULT NULL,
  `val7` int(10) DEFAULT NULL,
  `val8` int(10) DEFAULT NULL,
  `val9` int(10) DEFAULT NULL,
  `val10` int(10) DEFAULT NULL,
  `name1` varchar(200) DEFAULT NULL,
  `name2` varchar(200) DEFAULT NULL,
  `name3` varchar(200) DEFAULT NULL,
  `name4` varchar(299) DEFAULT NULL,
  `name5` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |



steps
======
1.Add the event streams mystream_in_1.0.0.json and mystream_out_1.0.0.json to path <das-home>/repository/deployment/server/eventstreams

2.Add the event receiver ex: mqtt_input.xml to <das-home>/repository/deployment/server/eventreceiver

3.Add the execution planner  ex: ExecutionPlan.siddhiql to <das-home>/repository/deployment/server/executionplans

4.Add the rdbmsdata.xml to <das-home>/repository/deployment/server/eventpublisher

5.Add the topic of the event receiver to an MQTT client ex:mqtt_topic and push a message

<events>
    <event>
        <metaData>
            <id>70</id>
        </metaData>
        <payloadData>
            <id>100</id>
            <val1>4</val1>
            <val2>50</val2>
            <val3>45</val3>
            <val4>50</val4>
            <val5>45</val5>
            <val6>100</val6>
            <val7>45</val7>
            <val8>70</val8>
            <val9>50</val9>
            <val10>70</val10>
            <name1>data4</name1>
            <name2>data3</name2>
            <name3>data4</name3>
            <name4>data1</name4>
            <name5>data4</name5>
        </payloadData>
    </event>
</events>


6.Check the db table
