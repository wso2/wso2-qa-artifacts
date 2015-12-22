#Introduction#

The script uses APIs based on the following services that are shipped with WSO2 Application server

1) jaxrs_basic : https://docs.wso2.com/display/AS521/JAX-RS+Basics
2) jaxrs_starbucks_service :https://docs.wso2.com/display/AS521/JAX-RS+Advanced
3) jaxrs_content_negotiation :https://docs.wso2.com/display/AS521/JAX-RS+Sample+on+Content+Negotiation
4) HelloService : Available by default
5) echo : Available by default

##How to deploy services##

Follow 'https://docs.wso2.com/display/AS521/Building+and+Running+JAX-RS+Samples' build and deploy services 1) , 2) & 3) on WSO2 Application Servier.

##Steps on running the scripts##

1. Create APIs pointing to the required service.

2. Replace the variables under 'Common Variables' with appropriate values.

3. Replace the variables under 'Variables' of each back end service specific thread group with appropriate values.

##Token related Invocations:##

The section 'Token Related Invocations' contain the following
`- Generate Access token based on Resource Owner Grant type
- Generate Access token based on Client Credentials Grant type
- Generate Access token based on SAML2 Bearer token
- Refresh access token
- Revoke access token`
Enable token related invocations based on the requirement.




