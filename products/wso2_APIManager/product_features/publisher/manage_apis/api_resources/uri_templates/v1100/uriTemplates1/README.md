**Author :** Sewmini Jayaweera

**Date :** 01/02/2016 

**Related test suite :** https://testlink.wso2.com/linkto.php?tprojectPrefix=APIM&item=testsuite&id=13270

#### Purpose of the artifact: 
This artifact is created to verify whether accurate URI templates get picked up for the requested API resoruce paths, when there are different types of URI templates defined in the system.

#### Deployment steps: 
1. Start API Manager 1.10.0 server.
2. Log into publisher with admin user (a user who has permission to create and publish APIs).
3. Create an API by selecting the 'I have an Existing API' option in API Publisher and importing the "URI_template_swagger.json" swagger file.
4. After importing, use 'uri_template' as the API context before moving to the 'Implement' stage.
5. In the 'Implement' stage, select 'Prototyped API' panel, select 'Inline' as the 'Implementation Method' and click the 'Deploy as a Prototype' button.

#### Notes: 
This artifact is created on API manager 1.10.0 version.  
