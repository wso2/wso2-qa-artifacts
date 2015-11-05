Scenario
===========
In this scenario looks at the use of soap event receiver to capture events into DAS. With this scenario, DAS collects events that are sent to the soap event receiver and pushes to the event stream mystream_in_1.0.0. The execution planner ExecutionPlan.siddhiql will send out events to the out stream after a window of 5 events are collected.  The events are then publishes those events on the console using the logger publisher.



Steps
======
1.Add the event streams mystream_in_1.0.0.json and mystream_out_1.0.0.json to path <das-home>/repository/deployment/server/eventstreams

2.Add the event receiver ex: soapreceiver.xml to <das-home>/repository/deployment/server/eventreceiver

3.Add the execution planner  ex: ExecutionPlan.siddhiql to <das-home>/repository/deployment/server/executionplans

4.Add the Logger_Publisher.xml to <das-home>/repository/deployment/server/eventpublisher.

5.publish an event by executing the curl command as shown below
 curl -v -X POST -H "Content-Type:application/xml"  -d@payload.xml "http://localhost:9763/services/soapreceiver/receive"


note: The payload.xml should have the payload as below
<events>
    <event>
        <metaData>
            <id>100</id>
        </metaData>
        <payloadData>
            <id>50</id>
            <val1>45</val1>
            <val2>70</val2>
            <val3>50</val3>
            <val4>100</val4>
            <val5>4</val5>
            <val6>4</val6>
            <val7>4</val7>
            <val8>50</val8>
            <val9>100</val9>
            <val10>70</val10>
            <name1>data1</name1>
            <name2>data2</name2>
            <name3>data2</name3>
            <name4>data2</name4>
            <name5>data2</name5>
        </payloadData>
    </event>
</events>
