# REST Client

Prerequisites:
JDK 1.7
Maven 3+

You can build the project to generate a war file or start a standalone server through maven

> Build the project
	mvn clean package

 This will create a war file inside [project_home]/target put the artifact in tomcat or a WSO2 AS

> Standlaone Instance
	mvn clean jetty:run

 This will start a standalone server instance.


=============================================================================

Available Services:

Can be found at http://localhost:8080/RESTservice/

> User Management Service
Includes CRUD operations with GET,POST,PUT,DELETE
NOTE: includes a in-memory H2 db so please be aware of memory usage

> HTTP Status Service
GET HTTP Responses eg: 200 OK, 404 Not Found, etc.

> Delayed Response Service
Response gets delyed form backend

> Random Password Generation Service
Testing caching related scenarios
