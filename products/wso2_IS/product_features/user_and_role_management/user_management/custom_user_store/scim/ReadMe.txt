ReadMe

The ReadMe covers the script that is used for creating a single user on identity server via Scim
Test cases covered are IDENTITY-136 and IDENTITY-137

Preconditions
=================
1.Please add the mysql jar to repository/components/lib

2.point the master-datasouce.xml to a mysql db and source the following two files
i).wso2is-5.1.0/dbscripts/mysql.sql
ii).wso2is-5.1.0/dbscripts/identity/mysql.sql

3.start the server with a default offset 

Running the script
==================
1.Update the user parameter for user and group prior to running each test run
2.invoke the jmeter script




	


