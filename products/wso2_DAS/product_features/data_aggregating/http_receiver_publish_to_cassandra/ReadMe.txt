Scenario
============
This scenario looks at how we can connect to an external cassandra. In this scenario, DAS will receive HTTP events sent via JMeter or Curl using HTTP event receiver and pass to the streamx_1.0.0. The captured events are then sent from the  event publisher to the external Cassandra. 

Preconditions
1.An external Cassandra should be started
2.Cassandra related jars should be added to repository/components/lib
3.DAS should be up and running

Steps
=====
1.Add the event streams streamx_1.0.0.json to path <das-home>/repository/deployment/server/eventstreams

2.Add the http_input.xml event receiver to <das-home>/repository/deployment/server/eventreceiver

3.Add the CassandraOutputEventAdapter.xml to <das-home>/repository/deployment/server/eventpublisher

4.Send events to the HTTP event receiver using the a specific payload

<events>
    <event>
        <payloadData>
            <id>50</id>
            <name>data4</name>
        </payloadData>
    </event>
</events>

5.Access the external cassandra and view the details

