# README

**Author :** Pubudu D.P

**Last modified by :** N/A

**Related public jira :** N/A

**Related testcases :** N/A

**Deprecated :** [This is an optional field. Please provide the product version when the artifact is deprecated]


###Description
This scenario contains two Jmeter scripts, Publisher.jmx, Subscriber.jmx and relevant JNDI file. 

Subscriber script creates 2 Queues, 2 Topics, 2 Topics with Durable subscribers, 1 Topic with Shared subscribers.

Publisher script sends messages for above mentioned topics and Queues continuously.

Naming convention used in scripts
Q - Queue
T - Topic
D - Durable Topic
ST - Topic with Shared Subscribers
N - Node
S - Subscriber

###Setup

This script can be executed on a stand alone setup as well as a distributed setup. It is recommended to run the script against a 2 node Message Broker cluster.



> Product Version: MB 3.2.0


### Contents 
  - Subsriber.jmx
  - Publisher.jmx
  - jndiqueues.properties

### Script parameters
[Specify each parameter/variable of your script and provide a brief description about each parameter/variable.]

jndipath - Point this to the location of 'jndiqueues.properties' file in both Subsriber.jmx and Publisher.jmx scripts.


### Pre-conditions
- jndipath should be updated in both Publisher.jmx and Subscriber.jmx scripts
- Shared subscriptions should be enabled in [$HOME]/repository/conf/broker.xml for Shared subscriptions to work. (Set 'maximumRedeliveryAttempts' to true before you start the MB nodes for all nodes.)


### Execution steps

1. Execute the Subscriber.jmx script
2. Make sure all the Queues and Topics mentioned in jndiqueues.properties file are created in MB cluster
3. Start the Publisher.jmx script. This will start publishing messages to each Queue and Topic created. 


### Expected Outcome
1. Queues and Topics should receive the published messages


### Post-Conditions
- N/A
- N/A
