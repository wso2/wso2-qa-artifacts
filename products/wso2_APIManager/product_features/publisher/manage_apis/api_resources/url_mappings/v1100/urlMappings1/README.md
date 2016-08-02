**Author :** Sewmini Jayaweera

**Date :** 01/02/2016 

**Related test suite :** https://testlink.wso2.com/linkto.php?tprojectPrefix=APIM2&item=testsuite&id=13269

#### Purpose of the artifact: 
This artifact is created to verify whether accurate URL mappings get picked up for the requested API resoruce paths, when there are different types of URL mappings defined in the system.

#### Deployment steps: 
1. Start API Manager 1.10.0 server.
2. Log into publisher with admin user (a user who has permission to create and publish APIs).
3. Create an API by selecting the 'I have an Existing API' option in API Publisher and importing the "url_mapping_swagger.json" swagger file.
4. After importing, use 'url_mapping' as the API context before moving to the 'Implement' stage.
5. In the 'Implement' stage, select 'Prototyped API' panel, select 'Inline' as the 'Implementation Method' and click the 'Deploy as a Prototype' button.

#### Notes: 
This artifact is created on API manager 1.10.0 version.  
