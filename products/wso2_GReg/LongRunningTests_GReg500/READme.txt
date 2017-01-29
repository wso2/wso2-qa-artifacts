1. Long Running Tests:-

- AccessRestServiceList.jmx - Accesses rest services list time to time
- AccessRestServicePermaLink.jmx  Clicks on rest service permalink (There should be already an existing rest service in Greg and reference to this webservice should be updated on .jmx file)
- AccessWSDLServiceList.jmx - Accesses WSDL link time to time
- AccessWSDLServicePermaLink.jmx - Clicks on WSDL service permalink (There should be an existing WSDL service in GReg and reference to this WSDL should be updated on .jmx file)
- CreateRestService.jmx - Creates rest web services with incremental version numbers in timely manner (Please update the counter values if needed)
- CreateWSDL.jmx - Creates WSDL with incremental version numbers in timely manner (Please update the counter values if needed)
- PublisherStoreLogin.jmx - Logs in to Publisher and Store for Governance Regisrty

2. Load Tests:-
- ZipFileUploadWSDL.jmx - Uploads the biz.zip file in to Governance Registry. this .zip file contains a wsdl file and it's dependencies. Test case should be run on UI mode.

