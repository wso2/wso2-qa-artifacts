wso2ss1.5.0 smoke test automation project v1.0
=================================================

This is a browser based automation project for covering high level smoke test scenarios of wso2ss1.5.0 using selenium webdriver.
The project is able to run against three types of databases. If need to test against other db as H2, or oracle please refer [1]
Add more type of test as Functional or Regression for extending this test bed. Refer [2]
*Ant using here for running testng targets. Download and from http://ant.apache.org/bindownload.cgi and set ANT_HOME environment variable to the system once 
extracting downloaded archive. 
It is able to run tests in this project through even command line using ant. Ex:- > ant <targetName>
*TestNg is used as the unit test tool you can use junit instead. TestNg plugins are included inside <Project_Home>/lib folder and no need to download. 
Refer http://testng.org/doc/index.html for more info.

[1] Run RSS Manager test against H2,Oracle etc.
-Copy existing testng xml inside com.ss150.testxml into a new file; ex:- ss_test_oracle.xml
change parameters in it as relevant to H2 or oracle
-Add new target to build.xml into a new file; ex:- refer TestLogin_Mysql target and do changes accordingly. 


[2] Add more types of test
It may required performance, security or any other test type. Just add new class to com.ss150.test and add tests accordingly.
And add newly added class to testng xml, as new or existing tests.

All above descriptions are in very high-levl and also no need to follow the exactly the same and many other alternative ways are there.
And also this can integrate with jenkins or hudson kind CI tool easily for getting complete and more advance automation test framework. 
And it is possible to reuse this project as automation framework for any future test or browser base testing as well as other type
 since this is powered by selenium and java.

**All tools used with this project are free and open source and under Apache 2.0 License.

-Selenium WebDriver 2.44
-apache-ant-1.9.4
-testng-6.8.5
===================================================
© WSO2 QA Team