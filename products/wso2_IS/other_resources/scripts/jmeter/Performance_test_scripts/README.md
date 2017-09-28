-------------------------------------------------------------------------

    Supported Product:- IS 5.4.0

### Description:

- These scripts are used for IS performance testing.

### Test Data Creation
- The following scripts are used for test data preparation.

| Script | Description |
| ------ | ------ |
| TestData-AddOAuthApps.jmx | To add OAuth Applications for OAuth and OIDC scenarios |
| TestData-AddOtherApps.jmx | To add Service provider application required for SAML2 and PassiveSTS testing |
| TestData-AddSuperTenantUsers.jmx |  To add super tenant users to test user authentication |
|  TestData-AddTenantsAndTenantUsers.jmx| To add super tenant users to test user authentication |
| TestData-PublishXACMLPolicies.jmx | To add and publish XACML policies to test XACML |
| TestData-Write_Tokens.jmx | To write tokens to a .csv file to test token generation using refresh token, token revocation and token introspection |


### Test Scripts

| Category | Script | Test data scripts(s)/ requirements | IS Configurations |
| ------ | ------ | ------ | ------ |
| Authentication | AuthenticateSuperTenantUser.jmx |TestData-AddSuperTenantUsers.jmx  |    |
|  | AuthenticateTenantUser.jmx | TestData-AddTenantsAndTenantUsers.jmx |  |
| OAuth2 |OAuth_Password.jmx  |TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx |  |
|  | OAuth_ClientCredentials.jmx |TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx  |  |
|  | OAuth_AuthCode_Redirect_SkipConsent.jmx |TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx  | identity.xml : SkipUserConsent=true | 
|  |OAuth_AuthCode_Redirect_WithConsent.jmx  | TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx |  |
|  | OAuth_Implicit_Redirect_WithConsent.jmx | TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx |  |
|  |OAuth_Implicit_Redirect_SkipConsent.jmx   |  TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx | identity.xml : SkipUserConsent=true |
|  | OAuth_RefreshToken.jmx  |  TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx / TestData-Write_Tokens.jmx | identity.xml : RenewRefreshTokenForRefreshGrant=false |
|  | OAuth_TokenIntrospection.jmx | TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx / TestData-Write_Tokens.jmx |  |
|  | OAuth_RevokeToken.jmx | TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx / TestData-Write_Tokens.jmx   |  |
|OIDC  | OIDC_AuthCode_Redirect_SkipConsent.jmx | TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx |identity.xml : SkipUserConsent=true |
|  | OIDC_AuthCode_Redirect_WithConsent.jmx |TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx  |  |
|  |OIDC_OAuth_AuthCode_RequestPath_SkipConsent.jmx  | TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx | identity.xml : SkipUserConsent=true |
|  | OIDC_Implicit_Redirect_WithConsent.jmx |TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx  |  |
|  |OIDC_Implicit_Redirect_SkipConsent.jmx  |TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx  | identity.xml : identity.xml : SkipUserConsent=true |
|  | OIDC_Implicit_RequestPath_SkipConsent.jmx |TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx  | identity.xml : SkipUserConsent=true |
|  |OIDC_UserInfoEndpoint.jmx   |TestData-AddSuperTenantUsers.jmx / TestData-AddOAuthApps.jmx / TestData-Write_Tokens.jmx   |  |
| STS | PassiveSTS.jmx | TestData-AddSuperTenantUsers.jmx / TestData-AddOtherApps.jmx |  |
| SAML| SAML2-SSO-RedirectBinding.jmx | TestData-AddSuperTenantUsers.jmx / TestData-AddOtherApps.jmx |  |
|  |SAML2-SSO-RequestPathAuthentication.jmx | TestData-AddSuperTenantUsers.jmx / TestData-AddOtherApps.jmx |  |
| SCIM1 |SCIM-Add-user.jmx  | Publish an OAuth app and Generate an access token with infinite expiration time |  |
|  |SCIM-Update-user.jmx  |SCIM-Add-user.jmx / Publish an OAuth app and Generate an access token with infinite expiration time |  |
|  |SCIM-Add-Get-Update.jmx  | Publish an OAuth app and Generate an access token with infinite expiration time |  |
 SCIM2 |SCIM2-Add-user.jmx  | Publish an OAuth app and Generate an access token with infinite expiration time |  Disable "org.wso2.carbon.identity.scim.common.listener.SCIMUserOperationListener and enable "org.wso2.carbon.identity.scim2.common.listener.SCIMUserOperationListener"|
|  |SCIM2-Update-user.jmx  |SCIM2-Add-user.jmx  / Publish an OAuth app and Generate an access token with infinite expiration time |Disable "org.wso2.carbon.identity.scim.common.listener.SCIMUserOperationListener and enable "org.wso2.carbon.identity.scim2.common.listener.SCIMUserOperationListener"  |
|  |SCIM2-Add-Get-Update.jmx  | Publish an OAuth app and Generate an access token with infinite expiration time  | Disable "org.wso2.carbon.identity.scim.common.listener.SCIMUserOperationListener and enable "org.wso2.carbon.identity.scim2.common.listener.SCIMUserOperationListener" |
| XACML | XACML-SingleRequest.jmx |Publish a single policy using TestData-PublishXACMLPolicies.jmx  |  |
|  | XACML-MultipleRequests.jmx |Use scripts provided in http://xacmlinfo.org/2013/10/15/xacml-pdp-performance-testing/ and create and publish 10000 policies |  |



### Configuring Jmeter script variables for test execution

- Each script contains the following 3 types of variable Test variables groups. Alter these variable values accordingly.
    * Test variables : To alter the thread count / user count etc
    * Server variables : To alter the Identity server host / port etc 
    * User defined variables - Defines the user name prefixes , SP prefixes , OAuth tokens etc required to run the tests (Not necessary to alter unless the corresponding values in test data scripts are altered)


-----------------------------------------------------------------------------

