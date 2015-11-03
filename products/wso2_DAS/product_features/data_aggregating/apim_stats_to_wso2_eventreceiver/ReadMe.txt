Scenario
=========
In this scenario the event receiver, APIM_Stat.xml will listen to wso2 events for each invocation of an API. The receiver will then pass the collected events to the org.wso2.apimgt.statistics.request_1.0.0 and publish the received events on the console using logger event publisher.

Preconditions
=============
1.Start the API Manager 1.9 with an offset
2.DAS should be up and running

steps
======
1.Add the event streams org.wso2.apimgt.statistics.request_1.0.0.json to path <das-home>/repository/deployment/server/eventstreams

2.Add the event receiver ex: APIM_Stat.xml to <das-home>/repository/deployment/server/eventreceiver

3.Add the Logger_Publisher.xml to <das-home>/repository/deployment/server/eventpublisher

4.Invoke the API and publish events into DAS

5.Check the logger publisher
