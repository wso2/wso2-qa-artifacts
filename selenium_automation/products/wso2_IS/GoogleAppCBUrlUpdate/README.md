# GoogleAppCBUrlUpdate
## This project is to automate updating 'Authorized redirect URI' url which is in Google web app's credentials section.

#### Problem:
When someone uses goolge as an external IDP of Identity Server, he has to configure google client web app from google developer console.
While do the above configuration, the Authorized redirect URI should be provided. When the user log in to the Identity Server via google credentials,
it will be matched the IDP ACS url with above configured Authorized redirect URI.
In a case where the server's url is dynamic and not known early, user has to update the 'Authorized redirect URI' url as it matches with IDP's ACS url.

#### Solution:
We can use this project as a solution to automate updating 'Authorized redirect URI' on existing google client web app.

#### Steps
- Make sure you are using latest versions of brower, java, maven in your system.
- Download compatible browser's driver(ex:geckodriver for firefox, chromedriver for googleChrome) and set a system variable for it.
  Refer: http://www.seleniumhq.org/download >> Third Party Browser Drivers
- If you are not using latest dependencies of testng, selenium or browser driver please use compatible versions of dependency combination accordingly
- Change the properties in src/test/resources/testng.xml accordingly.

Thank You.
chaminda@wso2.com