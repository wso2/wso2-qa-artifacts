package com.testscripts;

import java.util.HashMap;
import java.util.List;

import com.virtusa.isq.vtaf.aspects.VTAFRecoveryMethods;
import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import com.virtusa.isq.vtaf.runtime.VTAFTestListener;


/**
 *  Class ts_drop_Three implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_drop_Three extends SeleniumTestBase {

    String varAPINameOne;
    String varServerName;
    String varAPIVersion;
    String varAPIOneContext;
    String varAPIOneDescription;
    String varTenantOnePublisherUser;
    String varAdminPublisherUser;
    String varAPIOneSubContext;


    /**
     * Data provider for Test case tc_UserCreation.
     * @return data table
     */
    @DataProvider(name = "tc_UserCreation")
    public Object[][] dataTable_tc_UserCreation() {     	
    	return this.getDataTable("UserCreationTenants","UserCreationSuperAdmin");
    }

    /**
     * Data driven test case tc_UserCreation.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_UserCreation")
    public final void tc_UserCreation(final String UserCreationTenants_carbonURL, final String UserCreationTenants_superAdminUserName, final String UserCreationTenants_superAdminPassword, final String UserCreationTenants_tenantDomainOne, final String UserCreationTenants_tenantOneFirstName, final String UserCreationTenants_tenantOneLastName, final String UserCreationTenants_tenantOneAdminUserName, final String UserCreationTenants_tenantOneAdminPassword, final String UserCreationTenants_emailAddress, final String UserCreationTenants_tenantOneUserNameCreateAndPublisher, final String UserCreationTenants_tenantOneCreateAndPublisherUserPassword, final String UserCreationTenants_tenantOneCreateAndPublisherRoleName, final String UserCreationTenants_tenantOneUserNameSubscriber, final String UserCreationTenants_tenantOneStoreUserPassword, final String UserCreationTenants_tenantOneSubscriberRole, final String UserCreationTenants_tenantOneCreateAndPublisherRoleNameTwo, final String UserCreationTenants_tenantOneCreateAndPublisherUserTwoPassword, final String UserCreationTenants_tenantOneUserNameTwoCreateAndPublisher, final String UserCreationTenants_tenantOneStoreUserTwoPassword, final String UserCreationTenants_tenantOneSubscriberRoleTwo, final String UserCreationTenants_tenantOneUserNameTwoSubscriber, final String UserCreationTenants_tenantDomainTwo, final String UserCreationTenants_tenantTwoFirstName, final String UserCreationTenants_tenantTwoLastName, final String UserCreationTenants_tenantTwoAdminUserName, final String UserCreationTenants_tenantTwoAdminPassword, final String UserCreationTenants_tenantTwoCreateAndPublisherRoleOne, final String UserCreationTenants_tenantTwoUserNameOneCreateAndPublisher, final String UserCreationTenants_tenantTwoCreateAndPublisherUserOnePassword, final String UserCreationTenants_tenantTwoUserNameOneSubscriber, final String UserCreationTenants_tenantTwoStoreUserOnePassword, final String UserCreationTenants_tenantTwoSubscriberRoleOne, final String UserCreationTenants_storeUserWithSameRoleName, final String UserCreationTenants_storePasswordWithSameRole, final String UserCreationSuperAdmin_carbonURL, final String UserCreationSuperAdmin_superAdminUserName, final String UserCreationSuperAdmin_superAdminPassword, final String UserCreationSuperAdmin_publisherUserNameOne, final String UserCreationSuperAdmin_publiserPassword, final String UserCreationSuperAdmin_publisherRoleNameOne, final String UserCreationSuperAdmin_storeUserNameOne, final String UserCreationSuperAdmin_storePassword, final String UserCreationSuperAdmin_storeRoleNameOne, final String UserCreationSuperAdmin_publisherUserNameTwo, final String UserCreationSuperAdmin_publiserUserTwoPassword, final String UserCreationSuperAdmin_publisherRoleNameTwo, final String UserCreationSuperAdmin_storeUserNameTwo, final String UserCreationSuperAdmin_storeUserTwoPassword, final String UserCreationSuperAdmin_storeRoleNameTwo) throws Exception {	
    	//To all scenarios in release 3 Creating All Super admin user and Tenant Creation and Tenant user creations are included here..
    	//-------------Creating Tenant using Admin user------------------
    	Common.bc_CreateTenant(this, UserCreationTenants_superAdminUserName,UserCreationTenants_superAdminPassword,UserCreationTenants_tenantDomainOne,UserCreationTenants_tenantOneFirstName,UserCreationTenants_tenantOneLastName,UserCreationTenants_tenantOneAdminUserName,UserCreationTenants_tenantOneAdminPassword,UserCreationTenants_emailAddress,UserCreationTenants_carbonURL);
    	//-------------Create Tenant  Users using Tenant one domain-------------------
    	//Retriew tenant username
    	String newTenantUsername = retrieveString("keynewTenantUsername");
    	Common.bc_CreateTenantUsers(this, newTenantUsername,UserCreationTenants_tenantOneAdminPassword,UserCreationTenants_carbonURL,UserCreationTenants_tenantOneCreateAndPublisherUserPassword,UserCreationTenants_tenantOneCreateAndPublisherUserPassword,"",UserCreationTenants_tenantOneCreateAndPublisherRoleName,UserCreationTenants_tenantOneUserNameCreateAndPublisher,UserCreationTenants_tenantOneStoreUserPassword,UserCreationTenants_tenantOneStoreUserPassword,"",UserCreationTenants_tenantOneSubscriberRole,UserCreationTenants_tenantOneUserNameSubscriber);
    	//store  Tenant Created publisher user and stote user
    	store("keyDomainOne","String",UserCreationTenants_tenantDomainOne);
    	String varDomainOne = retrieveString("keyDomainOne");
    	//Store Tenant publisher user into Globle variable
    	varTenantOnePublisherUser = UserCreationTenants_tenantOneUserNameCreateAndPublisher+"@"+varDomainOne;
    	store("keyTenantOnePublisherUser","String",varTenantOnePublisherUser);
    	//Store admin publisher user into Globle variable
    	varAdminPublisherUser = UserCreationSuperAdmin_publisherUserNameOne;
    	store("keyAdminPublisherUser","String",varAdminPublisherUser);
    	//-------------------------Create admin users using Super Admin--------------------------------------------
    	Common.bc_CreateSuperUsers(this, UserCreationSuperAdmin_publisherRoleNameOne,UserCreationSuperAdmin_superAdminUserName,UserCreationSuperAdmin_superAdminPassword,UserCreationSuperAdmin_carbonURL,UserCreationSuperAdmin_publisherUserNameOne,UserCreationSuperAdmin_publiserPassword,UserCreationSuperAdmin_publiserPassword,"",UserCreationSuperAdmin_storeUserNameOne,UserCreationSuperAdmin_storePassword,UserCreationSuperAdmin_storePassword,UserCreationSuperAdmin_storeRoleNameOne);
    	//-------------------------create  another super admin user--------------------------------
    	Common.bc_CreateSuperUsers(this, UserCreationSuperAdmin_publisherRoleNameTwo,UserCreationSuperAdmin_superAdminUserName,UserCreationSuperAdmin_superAdminPassword,UserCreationSuperAdmin_carbonURL,UserCreationSuperAdmin_publisherUserNameTwo,UserCreationSuperAdmin_publiserUserTwoPassword,UserCreationSuperAdmin_publiserUserTwoPassword,"",UserCreationSuperAdmin_storeUserNameTwo,UserCreationSuperAdmin_storeUserTwoPassword,UserCreationSuperAdmin_storeUserTwoPassword,UserCreationSuperAdmin_storeRoleNameTwo);
    	//-----------------------------creating user with  same tenant domain---------------------------------------------------------------------
    	Common.bc_CreateTenantUsers(this, newTenantUsername,UserCreationTenants_tenantOneAdminPassword,UserCreationTenants_carbonURL,UserCreationTenants_tenantOneCreateAndPublisherUserTwoPassword,UserCreationTenants_tenantOneCreateAndPublisherUserTwoPassword,"",UserCreationTenants_tenantOneCreateAndPublisherRoleNameTwo,UserCreationTenants_tenantOneUserNameTwoCreateAndPublisher,UserCreationTenants_tenantOneStoreUserTwoPassword,UserCreationTenants_tenantOneStoreUserTwoPassword,"",UserCreationTenants_tenantOneSubscriberRoleTwo,UserCreationTenants_tenantOneUserNameTwoSubscriber);
    	//-------------------------------Create New  tenant and create create users---------------------------------------------------------------
    	Common.bc_CreateTenant(this, UserCreationTenants_superAdminUserName,UserCreationTenants_superAdminPassword,UserCreationTenants_tenantDomainTwo,UserCreationTenants_tenantTwoFirstName,UserCreationTenants_tenantTwoLastName,UserCreationTenants_tenantTwoAdminUserName,UserCreationTenants_tenantTwoAdminPassword,UserCreationTenants_emailAddress,UserCreationTenants_carbonURL);
    	//-------------Create Tenant  PublisherUser using Tenant one domain-------------------
    	String newTenantTwoUsername = retrieveString("keynewTenantUsername");
    	Common.bc_CreateTenantUsers(this, newTenantTwoUsername,UserCreationTenants_tenantTwoAdminPassword,UserCreationTenants_carbonURL,UserCreationTenants_tenantTwoCreateAndPublisherUserOnePassword,UserCreationTenants_tenantTwoCreateAndPublisherUserOnePassword,"",UserCreationTenants_tenantTwoCreateAndPublisherRoleOne,UserCreationTenants_tenantTwoUserNameOneCreateAndPublisher,UserCreationTenants_tenantTwoStoreUserOnePassword,UserCreationTenants_tenantTwoStoreUserOnePassword,"",UserCreationTenants_tenantTwoSubscriberRoleOne,UserCreationTenants_tenantTwoUserNameOneSubscriber);
    	//----------------Create store user from tenant two domain and give role name as tenant one store role name--------------
    	Common.bc_CreateStoreUser(this, newTenantTwoUsername,UserCreationTenants_tenantTwoAdminPassword,UserCreationTenants_carbonURL,UserCreationTenants_storeUserWithSameRoleName,UserCreationTenants_storePasswordWithSameRole,UserCreationTenants_storePasswordWithSameRole,"",UserCreationTenants_tenantOneSubscriberRole);
    } 
    	

    /**
     * Data provider for Test case tc_APICreation.
     * @return data table
     */
    @DataProvider(name = "tc_APICreation")
    public Object[][] dataTable_tc_APICreation() {     	
    	return this.getDataTable("UserCreationTenants","UserCreationSuperAdmin","APICreation");
    }

    /**
     * Data driven test case tc_APICreation.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APICreation")
    public final void tc_APICreation(final String UserCreationTenants_carbonURL, final String UserCreationTenants_superAdminUserName, final String UserCreationTenants_superAdminPassword, final String UserCreationTenants_tenantDomainOne, final String UserCreationTenants_tenantOneFirstName, final String UserCreationTenants_tenantOneLastName, final String UserCreationTenants_tenantOneAdminUserName, final String UserCreationTenants_tenantOneAdminPassword, final String UserCreationTenants_emailAddress, final String UserCreationTenants_tenantOneUserNameCreateAndPublisher, final String UserCreationTenants_tenantOneCreateAndPublisherUserPassword, final String UserCreationTenants_tenantOneCreateAndPublisherRoleName, final String UserCreationTenants_tenantOneUserNameSubscriber, final String UserCreationTenants_tenantOneStoreUserPassword, final String UserCreationTenants_tenantOneSubscriberRole, final String UserCreationTenants_tenantOneCreateAndPublisherRoleNameTwo, final String UserCreationTenants_tenantOneCreateAndPublisherUserTwoPassword, final String UserCreationTenants_tenantOneUserNameTwoCreateAndPublisher, final String UserCreationTenants_tenantOneStoreUserTwoPassword, final String UserCreationTenants_tenantOneSubscriberRoleTwo, final String UserCreationTenants_tenantOneUserNameTwoSubscriber, final String UserCreationTenants_tenantDomainTwo, final String UserCreationTenants_tenantTwoFirstName, final String UserCreationTenants_tenantTwoLastName, final String UserCreationTenants_tenantTwoAdminUserName, final String UserCreationTenants_tenantTwoAdminPassword, final String UserCreationTenants_tenantTwoCreateAndPublisherRoleOne, final String UserCreationTenants_tenantTwoUserNameOneCreateAndPublisher, final String UserCreationTenants_tenantTwoCreateAndPublisherUserOnePassword, final String UserCreationTenants_tenantTwoUserNameOneSubscriber, final String UserCreationTenants_tenantTwoStoreUserOnePassword, final String UserCreationTenants_tenantTwoSubscriberRoleOne, final String UserCreationTenants_storeUserWithSameRoleName, final String UserCreationTenants_storePasswordWithSameRole, final String UserCreationSuperAdmin_carbonURL, final String UserCreationSuperAdmin_superAdminUserName, final String UserCreationSuperAdmin_superAdminPassword, final String UserCreationSuperAdmin_publisherUserNameOne, final String UserCreationSuperAdmin_publiserPassword, final String UserCreationSuperAdmin_publisherRoleNameOne, final String UserCreationSuperAdmin_storeUserNameOne, final String UserCreationSuperAdmin_storePassword, final String UserCreationSuperAdmin_storeRoleNameOne, final String UserCreationSuperAdmin_publisherUserNameTwo, final String UserCreationSuperAdmin_publiserUserTwoPassword, final String UserCreationSuperAdmin_publisherRoleNameTwo, final String UserCreationSuperAdmin_storeUserNameTwo, final String UserCreationSuperAdmin_storeUserTwoPassword, final String UserCreationSuperAdmin_storeRoleNameTwo, final String APICreation_pulisherURL, final String APICreation_APINameOne, final String APICreation_APIOneContext, final String APICreation_APIOneVersion, final String APICreation_APIOneTagName, final String APICreation_APIOneImagePath, final String APICreation_APIOneDescription, final String APICreation_APIOneURLPattern, final String APICreation_ProductionEndPoint, final String APICreation_SandBoxEndPoint) throws Exception {	
    	//Create First API
    	//Retriew The Tenant user name & super user user names
    	String varTenantOnePublisherUser = retrieveString("keyTenantOnePublisherUser");
    	String varAdminPublisherUser = retrieveString("keyAdminPublisherUser");
    	Common.bc_CreateAPIAndPublish(this, varTenantOnePublisherUser,UserCreationTenants_tenantOneCreateAndPublisherUserPassword,APICreation_APINameOne,APICreation_APIOneContext,APICreation_APIOneVersion,APICreation_APIOneImagePath,APICreation_APIOneDescription,APICreation_ProductionEndPoint,APICreation_SandBoxEndPoint,APICreation_pulisherURL,APICreation_APIOneURLPattern);
    	Common.bc_CreateAPIAndPublish(this, varAdminPublisherUser,UserCreationSuperAdmin_publiserPassword,APICreation_APINameOne,APICreation_APIOneContext,APICreation_APIOneVersion,APICreation_APIOneImagePath,APICreation_APIOneDescription,APICreation_ProductionEndPoint,APICreation_SandBoxEndPoint,APICreation_pulisherURL,APICreation_APIOneURLPattern);
    	//Store API name in globle variable
    	varAPINameOne = APICreation_APINameOne;
    	store("keyAPIOneName","String",varAPINameOne);
    	//Store API version in globle variable
    	varAPIVersion = APICreation_APIOneVersion;
    	store("keyAPIVersion","String",varAPIVersion);
    	//Store API context in globle variable
    	varAPIOneContext = APICreation_APIOneContext;
    	store("keyAPIOneContext","String",varAPIOneContext);
    	//Store API description in globle variable
    	varAPIOneDescription = APICreation_APIOneDescription;
    	store("keyAPIOneDescription","String",varAPIOneDescription);
    	varAPIOneSubContext = APICreation_APIOneURLPattern;
    	store("keyAPIOneSubContext","String",varAPIOneSubContext);
    } 
    	

    /**
     * Data provider for Test case tc_Scenario_11.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_11")
    public Object[][] dataTable_tc_Scenario_11() {     	
    	return this.getDataTable("APICreation","URLs","Scenario_11");
    }

    /**
     * Data driven test case tc_Scenario_11.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_11")
    public final void tc_Scenario_11(final String APICreation_pulisherURL, final String APICreation_APINameOne, final String APICreation_APIOneContext, final String APICreation_APIOneVersion, final String APICreation_APIOneTagName, final String APICreation_APIOneImagePath, final String APICreation_APIOneDescription, final String APICreation_APIOneURLPattern, final String APICreation_ProductionEndPoint, final String APICreation_SandBoxEndPoint, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_11_userNamePublisher, final String Scenario_11_passwordPublisher, final String Scenario_11_userNameStore, final String Scenario_11_passwordStore, final String Scenario_11_serverName, final String Scenario_11_searchAPIProvider, final String Scenario_11_searchVersion, final String Scenario_11_searchDescription, final String Scenario_11_searchContext, final String Scenario_11_searchSubContext, final String Scenario_11_secrchDoc, final String Scenario_11_searchStatus, final String Scenario_11_statusCreated, final String Scenario_11_statusPublished, final String Scenario_11_statusBlocked, final String Scenario_11_statusRetire, final String Scenario_11_statusPrototyped, final String Scenario_11_statusDeprecated, final String Scenario_11_userCount, final String Scenario_11_storeRoleOne, final String Scenario_11_verbMethodNameGet, final String Scenario_11_verbMethodPost, final String Scenario_11_tier) throws Exception {	
    	//APIM-350: User Search added API by name
    	String varAPINameOne = retrieveString("keyAPIOneName");
    	String varAPIVersion = retrieveString("keyAPIVersion");
    	String varAPIOneContext = retrieveString("keyAPIOneContext");
    	String varAPIOneDescription = retrieveString("keyAPIOneDescription");
    	String varAPIOneSubContext = retrieveString("keyAPIOneSubContext");
    	testCase.APIM_350(this, Scenario_11_userNamePublisher,Scenario_11_passwordPublisher,URLs_publisherURL,varAPINameOne);
    	//APIM-351: User Search added API by provider name
    	testCase.APIM_351(this, Scenario_11_userNamePublisher,varAPINameOne,Scenario_11_searchAPIProvider);
    	//APIM-352: User Search added API by api version
    	testCase.APIM_352(this, Scenario_11_searchVersion,varAPIVersion,varAPINameOne);
    	//APIM-353: User should be able to search added API by context
    	testCase.APIM_353(this, Scenario_11_searchContext,varAPIOneContext,varAPINameOne);
    	//APIM-354: User search for API with upper case name
    	String varUppercaseName = varAPINameOne.toUpperCase();
    	String varLowercaseName = varAPINameOne.toLowerCase();
    	testCase.APIM_354(this, varUppercaseName,varAPINameOne,varLowercaseName);
    	//APIM-356: Successfully logged in user should be able search API by status
    	testCase.APIM_356(this, Scenario_11_statusCreated,Scenario_11_statusPublished,Scenario_11_statusBlocked,Scenario_11_statusRetire,Scenario_11_statusPrototyped,Scenario_11_statusDeprecated,varAPINameOne,Scenario_11_searchStatus);
    	//APIM-357: Successfully logged in user should be able search API by description
    	testCase.APIM_357(this, Scenario_11_searchDescription,varAPIOneDescription,varAPINameOne);
    	//APIM-358: Successfully logged in user should be able search API by subcontext
    	testCase.APIM_358(this, Scenario_11_searchSubContext,varAPIOneSubContext,varAPINameOne);
    	//APIM-359: Successfully logged in user should be able search API by documentation content
    	testCase.APIM_359(this, varAPINameOne,Scenario_11_secrchDoc);
    	//APIM-384: User should be able to see all API's in all stage on browse page
    	testCase.APIM_384(this, varAPINameOne,Scenario_11_statusPublished,varAPIVersion,Scenario_11_userNamePublisher,Scenario_11_userCount);
    	//APIM-393:Successfully logged in user should be able search with keywords that contains only part of the context name
    	testCase.APIM_393(this, URLs_storeURL,Scenario_11_serverName,Scenario_11_userNameStore,Scenario_11_passwordStore,varAPIOneContext,varAPINameOne,Scenario_11_searchContext);
    	//APIM-398: Successfully logged in user should be able search with keywords that contains only part of the provider name
    	testCase.APIM_398(this, Scenario_11_userNamePublisher,varAPINameOne,Scenario_11_searchAPIProvider);
    	//APIM-399:  Successfully logged in user should be able search API by description
    	testCase.APIM_399(this, Scenario_11_searchDescription,varAPIOneDescription,varAPINameOne);
    	//APIM-400: (Tenant specific) User search for API with lower case name
    	testCase.APIM_400(this, varLowercaseName,varAPINameOne);
    	//APIM-401:  User search for API with upper case name
    	testCase.APIM_401(this, varUppercaseName,varAPINameOne);
    	//APIM-402: User should be able to search added API by context
    	testCase.APIM_402(this, Scenario_11_searchContext,varAPIOneContext,varAPINameOne);
    	//APIM-403: User Search added API by name
    	testCase.APIM_403(this, varAPINameOne);
    	//APIM-404: User Search added API by api version
    	testCase.APIM_404(this, varAPIVersion,Scenario_11_searchVersion,varAPINameOne);
    	//APIM-360: A user should be able to assign a scope to a subscribed application and generate a new access token to a paticular scope
    	testCase.APIM_360(this, varAPINameOne,Scenario_11_storeRoleOne,Scenario_11_verbMethodNameGet,Scenario_11_serverName,URLs_storeURL,Scenario_11_userNameStore,Scenario_11_passwordStore,Scenario_11_tier,URLs_publisherURL);
    	//APIM-361: A user should be able to assign multiple scopes to a subscribed application and generate token
    	testCase.APIM_361(this, varAPINameOne,Scenario_11_serverName,URLs_storeURL,Scenario_11_verbMethodPost,URLs_publisherURL,Scenario_11_storeRoleOne);
    	//APIM-362: A user should be able to assign a scope to a subscribed application which the key is already generated and generate the token again for a scope
    	testCase.APIM_362(this, URLs_publisherURL,varAPINameOne,Scenario_11_serverName,URLs_storeURL,Scenario_11_storeRoleOne,Scenario_11_verbMethodNameGet,Scenario_11_userNamePublisher);
    	//APIM-427: Try to subscribe by a user who has only login permission
    	testCase.APIM_427(this, URLs_storeURL,Scenario_11_serverName,Scenario_11_passwordPublisher,Scenario_11_passwordPublisher);
    } 
    	

    /**
     * Data provider for Test case tc_Scenario_12.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_12")
    public Object[][] dataTable_tc_Scenario_12() {     	
    	return this.getDataTable("URLs","Scenario_11","Scenario_12");
    }

    /**
     * Data driven test case tc_Scenario_12.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_12")
    public final void tc_Scenario_12(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_11_userNamePublisher, final String Scenario_11_passwordPublisher, final String Scenario_11_userNameStore, final String Scenario_11_passwordStore, final String Scenario_11_serverName, final String Scenario_11_searchAPIProvider, final String Scenario_11_searchVersion, final String Scenario_11_searchDescription, final String Scenario_11_searchContext, final String Scenario_11_searchSubContext, final String Scenario_11_secrchDoc, final String Scenario_11_searchStatus, final String Scenario_11_statusCreated, final String Scenario_11_statusPublished, final String Scenario_11_statusBlocked, final String Scenario_11_statusRetire, final String Scenario_11_statusPrototyped, final String Scenario_11_statusDeprecated, final String Scenario_11_userCount, final String Scenario_11_storeRoleOne, final String Scenario_11_verbMethodNameGet, final String Scenario_11_verbMethodPost, final String Scenario_11_tier, final String Scenario_12_serverName, final String Scenario_12_userNamePublisher, final String Scenario_12_passwordPublisher, final String Scenario_12_tenantOneUserNameTwoCreateAndPublisher, final String Scenario_12_tenantOneCreateAndPublisherUserTwoPassword, final String Scenario_12_tenantOneUserNameSubscriber, final String Scenario_12_tenantOneSubscriberPassword, final String Scenario_12_tenantTwoUserNameOneSubscriber, final String Scenario_12_tenantTwoStoreUserOnePassword, final String Scenario_12_serverNameDomainTwo, final String Scenario_12_VisibilityToMyDomain, final String Scenario_12_visibilityPublic, final String Scenario_12_visibilityRestrictedToRole, final String Scenario_12_multipleRoles, final String Scenario_12_tenantOneSubscriberRole, final String Scenario_12_storeUserWithSameRoleName, final String Scenario_12_storePasswordWithSameRole, final String Scenario_12_tenantOneUserNameTwoSubscriber, final String Scenario_12_tenantOnePasswordSubscriberTwo, final String Scenario_12_subscriptionAvailableToCurrentTenantOnly, final String Scenario_12_applicationName, final String Scenario_12_subscriptionAvailableToAllTenant, final String Scenario_12_subscriptionAvailableToSpecificTenantOnly, final String Scenario_12_sameAsApivisibility, final String Scenario_12_privateApiVisibility, final String Scenario_12_apiVisibilityPublic, final String Scenario_12_apiVisibilityAsMyDomain, final String Scenario_12_apiVisibilityRestricted, final String Scenario_12_fileUploadLinkOne, final String Scenario_12_fileDownloadLinkTwo, final String Scenario_12_sourseUrlOne, final String Scenario_12_downImag) throws Exception {	
    	//Retriew API Name
    	String varAPINameOne = retrieveString("keyAPIOneName");
    	//APIM-60: Published APIs with public visibility can be viewed by all users
    	testCase.APIM_60(this, Scenario_12_serverName,URLs_storeURL,varAPINameOne,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_tenantOneSubscriberPassword,Scenario_12_tenantTwoUserNameOneSubscriber,Scenario_12_tenantTwoStoreUserOnePassword,Scenario_12_serverNameDomainTwo,Scenario_12_serverName);
    	//APIM-61: publish an API given 'visible to my domain' -users belong to other tenantsshould not be able to view
    	testCase.APIM_61(this, URLs_publisherURL,varAPINameOne,Scenario_12_VisibilityToMyDomain,Scenario_12_serverNameDomainTwo,URLs_storeURL,Scenario_12_tenantTwoUserNameOneSubscriber,Scenario_12_tenantTwoStoreUserOnePassword,Scenario_12_tenantTwoUserNameOneSubscriber,Scenario_12_tenantTwoStoreUserOnePassword,Scenario_12_userNamePublisher,Scenario_11_passwordPublisher,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_serverName);
    	//APIM-62: published api with visibility restricted to a role should visible to users with the particular role.
    	testCase.APIM_62(this, URLs_publisherURL,varAPINameOne,Scenario_12_visibilityRestrictedToRole,Scenario_12_serverName,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_tenantOneSubscriberPassword,Scenario_12_tenantTwoUserNameOneSubscriber,Scenario_12_tenantTwoStoreUserOnePassword,Scenario_12_tenantOneSubscriberRole,URLs_storeURL,Scenario_12_serverNameDomainTwo);
    	//APIM-64: API with visibility restricted to a role should not be visible to users belong to other tenants
    	testCase.APIM_64(this, varAPINameOne,Scenario_12_visibilityRestrictedToRole,Scenario_12_serverNameDomainTwo,URLs_storeURL,URLs_publisherURL,Scenario_12_storeUserWithSameRoleName,Scenario_12_storePasswordWithSameRole,Scenario_12_storeUserWithSameRoleName,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_serverName);
    	//APIM-65: publish an api with visibility restricted to multiple roles-only users with allowed roles can view.
    	testCase.APIM_65(this, URLs_publisherURL,Scenario_12_visibilityRestrictedToRole,Scenario_12_multipleRoles,Scenario_12_serverName,URLs_storeURL,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_tenantOneSubscriberPassword,varAPINameOne,Scenario_12_tenantOneUserNameTwoSubscriber,Scenario_12_tenantOnePasswordSubscriberTwo,Scenario_12_tenantTwoUserNameOneSubscriber);
    	//APIM-66: Publish an API given 'visible to my domain' -users belong to same tenant should be able to view.
    	testCase.APIM_66(this, URLs_publisherURL,varAPINameOne,Scenario_12_VisibilityToMyDomain,Scenario_12_serverName,URLs_storeURL,Scenario_12_tenantOneUserNameTwoSubscriber,Scenario_12_tenantOnePasswordSubscriberTwo,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_tenantOneSubscriberPassword);
    	//APIM-67: API with subscription available only to current tenant, allows current tenant user to subscribe
    	testCase.APIM_67(this, URLs_publisherURL,varAPINameOne,Scenario_12_visibilityPublic,Scenario_12_subscriptionAvailableToCurrentTenantOnly,Scenario_12_serverName,URLs_storeURL,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_tenantOneSubscriberPassword,Scenario_12_applicationName,Scenario_12_tenantOneUserNameTwoSubscriber);
    	//APIM-68: API with subscription available only to current tenant, not allow other tenant users to subscribe.
    	testCase.APIM_68(this, URLs_publisherURL,varAPINameOne,Scenario_12_serverNameDomainTwo,URLs_storeURL,Scenario_12_tenantTwoUserNameOneSubscriber,Scenario_12_tenantTwoStoreUserOnePassword,Scenario_12_serverName,Scenario_12_tenantOneUserNameSubscriber);
    	//APIM-71: APIs with subscription available to all tenants should allow users in other tenants to subscribe.
    	testCase.APIM_71(this, URLs_publisherURL,varAPINameOne,Scenario_12_subscriptionAvailableToAllTenant,Scenario_12_serverNameDomainTwo,URLs_storeURL,Scenario_12_tenantTwoUserNameOneSubscriber,Scenario_12_tenantTwoStoreUserOnePassword,Scenario_12_serverName);
    	//APIM-72: API with subscription available to specific tenants should allow subscription to specified tenants
    	testCase.APIM_72(this, URLs_publisherURL,varAPINameOne,Scenario_12_subscriptionAvailableToSpecificTenantOnly,Scenario_12_serverName,Scenario_12_serverName,URLs_storeURL,Scenario_12_serverNameDomainTwo,Scenario_12_tenantTwoUserNameOneSubscriber,Scenario_12_tenantTwoStoreUserOnePassword,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_tenantOneSubscriberPassword,Scenario_12_userNamePublisher);
    	String varAPIVersion = retrieveString("keyAPIVersion");
    	testCase.APIM_106(this, Scenario_12_userNamePublisher,Scenario_12_passwordPublisher,URLs_publisherURL,Scenario_12_sameAsApivisibility,Scenario_12_tenantOneUserNameTwoCreateAndPublisher,Scenario_12_tenantOneCreateAndPublisherUserTwoPassword,varAPIVersion,Scenario_12_serverName,Scenario_12_serverNameDomainTwo,Scenario_12_tenantTwoUserNameOneSubscriber,Scenario_12_tenantTwoStoreUserOnePassword,Scenario_12_fileUploadLinkOne,Scenario_12_fileDownloadLinkTwo,Scenario_12_sourseUrlOne,varAPINameOne,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_tenantOneSubscriberPassword,Scenario_12_sourseUrlOne,URLs_storeURL,Scenario_12_apiVisibilityPublic,Scenario_12_downImag);
    	//APIM-107: When user clicks on the '?' icon of the visibility field tip box should open.
    	testCase.APIM_107(this, Scenario_12_userNamePublisher,Scenario_12_passwordPublisher,URLs_publisherURL,varAPINameOne);
    	//APIM-108: Check doc visibility when it's given same as api visibility; api visibility = visible to my domain.
    	testCase.APIM_108(this, varAPINameOne,Scenario_12_apiVisibilityAsMyDomain,Scenario_12_sameAsApivisibility,varAPIVersion,Scenario_12_userNamePublisher,Scenario_12_tenantOneUserNameTwoCreateAndPublisher,Scenario_12_tenantOneCreateAndPublisherUserTwoPassword,Scenario_12_serverName,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_tenantOneSubscriberPassword,URLs_publisherURL,Scenario_12_passwordPublisher,Scenario_12_fileUploadLinkOne,Scenario_12_fileDownloadLinkTwo,URLs_storeURL,Scenario_12_sourseUrlOne,Scenario_12_sourseUrlOne);
    	//APIM-109: Check doc visibility when it's given same as api visibility; api visibility = restricted by role
    	testCase.APIM_109(this, Scenario_12_userNamePublisher,Scenario_12_passwordPublisher,URLs_publisherURL,varAPINameOne,Scenario_12_apiVisibilityRestricted,"T1StoreRole1",Scenario_12_sameAsApivisibility,varAPIVersion,URLs_storeURL,Scenario_12_serverName,Scenario_12_fileUploadLinkOne,Scenario_12_fileDownloadLinkTwo,Scenario_12_sourseUrlOne,Scenario_12_sourseUrlOne,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_tenantOneSubscriberPassword);
    	//APIM-110: Check document visibility when it's given as private.
    	testCase.APIM_110(this, Scenario_12_userNamePublisher,Scenario_12_passwordPublisher,URLs_publisherURL,varAPINameOne,Scenario_12_privateApiVisibility,Scenario_12_tenantOneUserNameTwoCreateAndPublisher,Scenario_12_tenantOneCreateAndPublisherUserTwoPassword,varAPIVersion,Scenario_12_fileUploadLinkOne,Scenario_12_fileDownloadLinkTwo,Scenario_12_sourseUrlOne,Scenario_12_sourseUrlOne,URLs_storeURL,Scenario_12_serverName,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_tenantOneSubscriberPassword);
    	//APIM-111: Check document visibility when it's given as 'Visible to my domain'.
    	testCase.APIM_111(this, Scenario_12_userNamePublisher,Scenario_12_passwordPublisher,varAPINameOne,Scenario_12_sameAsApivisibility,Scenario_12_tenantOneUserNameTwoCreateAndPublisher,Scenario_12_tenantOneCreateAndPublisherUserTwoPassword,varAPIVersion,URLs_storeURL,Scenario_12_serverName,Scenario_12_tenantOneUserNameSubscriber,Scenario_12_tenantOneSubscriberPassword,URLs_publisherURL,Scenario_12_fileUploadLinkOne,Scenario_12_sourseUrlOne,Scenario_12_sourseUrlOne,Scenario_12_fileDownloadLinkTwo);
    } 
    	

    /**
     * Data provider for Test case tc_DeleteAPI.
     * @return data table
     */
    @DataProvider(name = "tc_DeleteAPI")
    public Object[][] dataTable_tc_DeleteAPI() {     	
    	return this.getDataTable("UserCreationTenants","UserCreationSuperAdmin","APICreation");
    }

    /**
     * Data driven test case tc_DeleteAPI.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_DeleteAPI")
    public final void tc_DeleteAPI(final String UserCreationTenants_carbonURL, final String UserCreationTenants_superAdminUserName, final String UserCreationTenants_superAdminPassword, final String UserCreationTenants_tenantDomainOne, final String UserCreationTenants_tenantOneFirstName, final String UserCreationTenants_tenantOneLastName, final String UserCreationTenants_tenantOneAdminUserName, final String UserCreationTenants_tenantOneAdminPassword, final String UserCreationTenants_emailAddress, final String UserCreationTenants_tenantOneUserNameCreateAndPublisher, final String UserCreationTenants_tenantOneCreateAndPublisherUserPassword, final String UserCreationTenants_tenantOneCreateAndPublisherRoleName, final String UserCreationTenants_tenantOneUserNameSubscriber, final String UserCreationTenants_tenantOneStoreUserPassword, final String UserCreationTenants_tenantOneSubscriberRole, final String UserCreationTenants_tenantOneCreateAndPublisherRoleNameTwo, final String UserCreationTenants_tenantOneCreateAndPublisherUserTwoPassword, final String UserCreationTenants_tenantOneUserNameTwoCreateAndPublisher, final String UserCreationTenants_tenantOneStoreUserTwoPassword, final String UserCreationTenants_tenantOneSubscriberRoleTwo, final String UserCreationTenants_tenantOneUserNameTwoSubscriber, final String UserCreationTenants_tenantDomainTwo, final String UserCreationTenants_tenantTwoFirstName, final String UserCreationTenants_tenantTwoLastName, final String UserCreationTenants_tenantTwoAdminUserName, final String UserCreationTenants_tenantTwoAdminPassword, final String UserCreationTenants_tenantTwoCreateAndPublisherRoleOne, final String UserCreationTenants_tenantTwoUserNameOneCreateAndPublisher, final String UserCreationTenants_tenantTwoCreateAndPublisherUserOnePassword, final String UserCreationTenants_tenantTwoUserNameOneSubscriber, final String UserCreationTenants_tenantTwoStoreUserOnePassword, final String UserCreationTenants_tenantTwoSubscriberRoleOne, final String UserCreationTenants_storeUserWithSameRoleName, final String UserCreationTenants_storePasswordWithSameRole, final String UserCreationSuperAdmin_carbonURL, final String UserCreationSuperAdmin_superAdminUserName, final String UserCreationSuperAdmin_superAdminPassword, final String UserCreationSuperAdmin_publisherUserNameOne, final String UserCreationSuperAdmin_publiserPassword, final String UserCreationSuperAdmin_publisherRoleNameOne, final String UserCreationSuperAdmin_storeUserNameOne, final String UserCreationSuperAdmin_storePassword, final String UserCreationSuperAdmin_storeRoleNameOne, final String UserCreationSuperAdmin_publisherUserNameTwo, final String UserCreationSuperAdmin_publiserUserTwoPassword, final String UserCreationSuperAdmin_publisherRoleNameTwo, final String UserCreationSuperAdmin_storeUserNameTwo, final String UserCreationSuperAdmin_storeUserTwoPassword, final String UserCreationSuperAdmin_storeRoleNameTwo, final String APICreation_pulisherURL, final String APICreation_APINameOne, final String APICreation_APIOneContext, final String APICreation_APIOneVersion, final String APICreation_APIOneTagName, final String APICreation_APIOneImagePath, final String APICreation_APIOneDescription, final String APICreation_APIOneURLPattern, final String APICreation_ProductionEndPoint, final String APICreation_SandBoxEndPoint) throws Exception {	
    	//Retriew The Tenant user name & super user user names
    	String varTenantOnePublisherUser = retrieveString("keyTenantOnePublisherUser");
    	String varAdminPublisherUser = retrieveString("keyAdminPublisherUser");
    	Common.bc_DeleteAPI(this, APICreation_APINameOne,APICreation_pulisherURL,varTenantOnePublisherUser,UserCreationTenants_tenantOneCreateAndPublisherUserPassword,varAdminPublisherUser,UserCreationSuperAdmin_publiserPassword);
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}