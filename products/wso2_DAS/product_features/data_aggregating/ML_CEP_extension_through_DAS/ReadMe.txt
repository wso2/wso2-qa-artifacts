Scenario
=========
DAS will collect all HTTP type events that are sent to the event stream InputStream_1.0.0. The events are then sent to the execution planner. Within the execution plan the file downloaded-ml-model will be queried and processing will be done according to that model. Once the processing is done those events will be passed to PredictionStream1_1.0.0 and published on the console using the logger publisher

Preconditions
=============
1.Install the ML features within DAS using the below features

Machine Learner
Machine Learner
Machine Learner
Machine Learner
Machine Learner
Machine Learner
ML Siddhi Extension 

2.Place the downloaded-ml-model in any folder path

3.DAS should be started using -DdisableMLSparkCtx=true

Steps
======
1.Add the event streams InputStream_1.0.0.json and PredictionStream1_1.0.0.json to path <das-home>/repository/deployment/server/eventstreams

2.Add the event receiver ex: mlReceiver.xml to <das-home>/repository/deployment/server/eventreceiver

3.Add the execution planner  ex: ExecutionPlan.siddhiql to <das-home>/repository/deployment/server/executionplans
Note: update the path to the downloaded-ml-model based on your folder location

/* Enter a unique ExecutionPlan */
@Plan:name('ExecutionPlanML')

@Plan:trace('true')

@Import('InputStream:1.0.0')
define stream InputStream (NumPregnancies double, TSFT double, DPF double, BMI double, DBP double, PG2 double, SI2 double, Age double);


@Export('OutStream:1.0.0')
define stream OutStream (NumPregnancies double, TSFT double, DPF double, BMI double, DBP double, PG2 double, SI2 double, Age double, Class double);

from InputStream#ml:predict('file:////home/shavantha/projects/machinelerner/downloaded-ml-model', 'double')
select *
insert into OutStream;


4.Add the mlLogger.xml to <das-home>/repository/deployment/server/eventpublisher

5.Send a request using JMeter or curl to the event receiver

<events>
    <event>
        <payloadData>
            <NumPregnancies>4.504343</NumPregnancies>
            <TSFT>5.443435</TSFT>
            <DPF>4.504343</DPF>
            <BMI>5.443435</BMI>
            <DBP>1.23434</DBP>
            <PG2>90.34344</PG2>
            <SI2>5.443435</SI2>
            <Age>5.443435</Age>
        </payloadData>
    </event>
</events>

6.Check the logger publisher



















