# **These test artifacts can use for the long running testings of publishing mediation statistics from ESB to DAS**

Follow below steps to setup the long running test in DAS.

1. First, enable the mediation statistics of ESB_HOME/repository/conf/carbon.xml file.
```
<StatisticsReporterDisabled>false</StatisticsReporterDisabled>
```

2. Then start the ESB server and create a proxy using the attached ESB_proxy file.

3. Configure the Mediation Data Publisher Configuration in ESB to connect with the DAS server.
       
Refer : [Configure mediation data publisher](https://docs.wso2.com/display/BAM230/Setting+up+Mediation+Data+Agent#SettingupMediationDataAgent-ConfiguringtheBAMMediationDataAgentConfiguringMediationDataAgent) 

4. Create a JMeter script to invoke the ESB proxy using attached esb-proxy-invoke-script.jmx file.Follow below steps to open esb-proxy-invoke-script.jmx file using Apache JMeter.

  - Open JMeter using JMeter_HOME/bin/jmeter command.
  - Go to file -> open and open the .jmx file from the location where you have saved the esb-proxy-invoke-script.jmx file.
 
5. Start DAS server and send a single request from ESB to DAS by invoking the ESB proxy.Use below curl command.
```
curl -v -X GET "http://localhost:8280/services/<ESB proxy name>"
```
6. You will see a stream has published into DAS as attached _bam_mediation_stats_data_publisher_1.0.0.json_ file.Then persist it.
Create another stream as the attached esb_bam_mediation_stats_data_publisher_1.0.0.json file.

>the reason we create two streams because, esb publishes an attribute called "count" to DAS. The count attribute cannot be used in spark script since spark uses it as a keyword inside.
Therefore what we do is, create another stream similar to that and do an advanced mapping via the receiver.The second stream also should be the same as first stream publishing from ESB to DAS and only the count attribute name should be changed to another name.Then using the seocnd stream we can do spark scripts.

7. Create a receiver in DAS and do an advanced mapping between bam_mediation_stats_data_publisher_1.0.0 stream and esb_bam_mediation_stats_data_publisher_1.0.0 streams.
use the attached esb_mediation_stat_receiver.xml file.

Refer : [Advanced mapping between streams](https://docs.wso2.com/display/DAS300/Input+Mapping+Types)

8. Create a spark script to get the "IN" and "OUT" message counts using attached esb_mediation_stat_count_script file.

9. Now, the setup is ready for the long running of publishing ESB mediation statistics to DAS, run the Jmeter script.
 Change the Thread properties as , 
- Number of threads = 1000
- Ramp-up period = 1
- Loop count = forever
- Now, click on the run button.
                                


