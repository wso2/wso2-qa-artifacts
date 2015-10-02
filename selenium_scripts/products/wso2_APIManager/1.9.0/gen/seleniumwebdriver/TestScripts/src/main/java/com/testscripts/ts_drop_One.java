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
 *  Class ts_drop_One implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_drop_One extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_Scenario_1.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_1")
    public Object[][] dataTable_tc_Scenario_1() {     	
    	return this.getDataTable("Login","URLs","Scenario_1");
    }

    /**
     * Data driven test case tc_Scenario_1.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_1")
    public final void tc_Scenario_1(final String Login_adminUserName, final String Login_adminPassword, final String Login_userName, final String Login_password, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_1_APIVersion, final String Scenario_1_ApiName, final String Scenario_1_nonImagrPath, final String Scenario_1_APIImagePath, final String Scenario_1_APIURLPattern, final String Scenario_1_imagePath, final String Scenario_1_textPath, final String Scenario_1_serverName, final String Scenario_1_UrlPattern, final String Scenario_1_verbGET, final String Scenario_1_verbPOST, final String Scenario_1_verb_PUT, final String Scenario_1_verb_DELETE, final String Scenario_1_newUser, final String Scenario_1_newUserPasswd, final String Scenario_1_Role, final String Scenario_1_visibilityPublic, final String Scenario_1_VisibilityRestrictedByRole, final String Scenario_1_ProductionEndpointUrl) throws Exception {	
    	testCase.APIM_20(this, Login_userName,Login_password,Scenario_1_APIVersion,Scenario_1_nonImagrPath,Scenario_1_APIImagePath,Scenario_1_APIURLPattern,Scenario_1_ApiName,URLs_publisherURL);
    	testCase.APIM_21(this, Scenario_1_ApiName);
    	testCase.APIM_53(this, Scenario_1_ApiName);
    	testCase.APIM_217(this, Scenario_1_ApiName,Scenario_1_imagePath,Scenario_1_textPath,Scenario_1_serverName,URLs_storeURL);
    	testCase.APIM_22(this, Scenario_1_verbPOST,Scenario_1_UrlPattern,Scenario_1_verb_DELETE,Scenario_1_verbGET,Scenario_1_UrlPattern,Scenario_1_verbGET,Scenario_1_ApiName,Scenario_1_serverName,URLs_publisherURL,URLs_storeURL);
    	testCase.APIM_276(this, Scenario_1_ApiName,Scenario_1_visibilityPublic,Scenario_1_serverName,Login_userName,Login_password,URLs_publisherURL,URLs_storeURL);
    	testCase.APIM_280(this, Scenario_1_ApiName,Scenario_1_VisibilityRestrictedByRole,URLs_publisherURL);
    	testCase.APIM_278(this, Scenario_1_ApiName,Scenario_1_VisibilityRestrictedByRole,Login_userName,"",Login_userName,Login_password,"","","","",URLs_publisherURL);
    	testCase.APIM_55(this, Scenario_1_ApiName,Scenario_1_ProductionEndpointUrl);
    } 
    	

    /**
     * Data provider for Test case tc_Scenario_3.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_3")
    public Object[][] dataTable_tc_Scenario_3() {     	
    	return this.getDataTable("Login","URLs","Scenario_1","Scenario_2","Scenario_3");
    }

    /**
     * Data driven test case tc_Scenario_3.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_3")
    public final void tc_Scenario_3(final String Login_adminUserName, final String Login_adminPassword, final String Login_userName, final String Login_password, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_1_APIVersion, final String Scenario_1_ApiName, final String Scenario_1_nonImagrPath, final String Scenario_1_APIImagePath, final String Scenario_1_APIURLPattern, final String Scenario_1_imagePath, final String Scenario_1_textPath, final String Scenario_1_serverName, final String Scenario_1_UrlPattern, final String Scenario_1_verbGET, final String Scenario_1_verbPOST, final String Scenario_1_verb_PUT, final String Scenario_1_verb_DELETE, final String Scenario_1_newUser, final String Scenario_1_newUserPasswd, final String Scenario_1_Role, final String Scenario_1_visibilityPublic, final String Scenario_1_VisibilityRestrictedByRole, final String Scenario_1_ProductionEndpointUrl, final String Scenario_2_APIVersion, final String Scenario_2_ApiName1, final String Scenario_2_APIName2, final String Scenario_2_imagePath, final String Scenario_2_serverName, final String Scenario_2_UrlPattern, final String Scenario_2_EndPointType_Http, final String Scenario_2_productionEndpointUrl, final String Scenario_2_tagName, final String Scenario_3_InvalidUrl, final String Scenario_3_validUrl, final String Scenario_3_EndpointSecurityScheme, final String Scenario_3_endpointUsername, final String Scenario_3_endpointPassword, final String Scenario_3_severName, final String Scenario_3_newVersion, final String Scenario_3_alreadyExistingVersion, final String Scenario_3_tagName) throws Exception {	
    	testCase.APIM_29(this, Login_userName,Login_password,Scenario_1_ApiName,Scenario_3_validUrl,Scenario_3_InvalidUrl,URLs_publisherURL);
    	testCase.APIM_32(this, Scenario_3_EndpointSecurityScheme,Scenario_3_endpointUsername,Scenario_3_endpointPassword);
    	testCase.APIM_33(this, Scenario_3_validUrl,Scenario_3_severName,Scenario_1_ApiName,URLs_storeURL);
    	testCase.APIM_4A(this, Scenario_1_ApiName,Scenario_3_newVersion,URLs_publisherURL);
    	testCase.APIM_5A(this, Scenario_1_ApiName,Scenario_3_alreadyExistingVersion);
    } 
    	

    /**
     * Data provider for Test case tc_CreateUserAndAssignRoles.
     * @return data table
     */
    @DataProvider(name = "tc_CreateUserAndAssignRoles")
    public Object[][] dataTable_tc_CreateUserAndAssignRoles() {     	
    	return this.getDataTable("CreateUserAndAssignRoles","Login","URLs");
    }

    /**
     * Data driven test case tc_CreateUserAndAssignRoles.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_CreateUserAndAssignRoles")
    public final void tc_CreateUserAndAssignRoles(final String CreateUserAndAssignRoles_newUserName, final String CreateUserAndAssignRoles_newPassword, final String CreateUserAndAssignRoles_roleName, final String CreateUserAndAssignRoles_role, final String CreateUserAndAssignRoles_role1, final String CreateUserAndAssignRoles_role2, final String CreateUserAndAssignRoles_user1, final String CreateUserAndAssignRoles_user2, final String CreateUserAndAssignRoles_userPassword, final String Login_adminUserName, final String Login_adminPassword, final String Login_userName, final String Login_password, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//Creating user using admin loging and
    	Common.bc_CreateUserAndAssignRoles(this, Login_adminUserName,Login_adminPassword,CreateUserAndAssignRoles_newUserName,CreateUserAndAssignRoles_newPassword,CreateUserAndAssignRoles_newPassword,CreateUserAndAssignRoles_roleName,CreateUserAndAssignRoles_role,URLs_carbonURL);
    } 
    	

    /**
     * Data provider for Test case tc_Scenario_2.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_2")
    public Object[][] dataTable_tc_Scenario_2() {     	
    	return this.getDataTable("Login","URLs","Scenario_1","Scenario_2");
    }

    /**
     * Data driven test case tc_Scenario_2.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_2")
    public final void tc_Scenario_2(final String Login_adminUserName, final String Login_adminPassword, final String Login_userName, final String Login_password, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_1_APIVersion, final String Scenario_1_ApiName, final String Scenario_1_nonImagrPath, final String Scenario_1_APIImagePath, final String Scenario_1_APIURLPattern, final String Scenario_1_imagePath, final String Scenario_1_textPath, final String Scenario_1_serverName, final String Scenario_1_UrlPattern, final String Scenario_1_verbGET, final String Scenario_1_verbPOST, final String Scenario_1_verb_PUT, final String Scenario_1_verb_DELETE, final String Scenario_1_newUser, final String Scenario_1_newUserPasswd, final String Scenario_1_Role, final String Scenario_1_visibilityPublic, final String Scenario_1_VisibilityRestrictedByRole, final String Scenario_1_ProductionEndpointUrl, final String Scenario_2_APIVersion, final String Scenario_2_ApiName1, final String Scenario_2_APIName2, final String Scenario_2_imagePath, final String Scenario_2_serverName, final String Scenario_2_UrlPattern, final String Scenario_2_EndPointType_Http, final String Scenario_2_productionEndpointUrl, final String Scenario_2_tagName) throws Exception {	
    	testCase.APIM_23(this, Login_userName,Login_password,Scenario_2_APIVersion,Scenario_2_imagePath,Scenario_2_UrlPattern,Scenario_2_ApiName1,Scenario_2_serverName,Scenario_2_tagName,URLs_publisherURL,URLs_storeURL);
    	testCase.APIM_24(this, Scenario_1_ApiName,Scenario_2_EndPointType_Http,Scenario_2_productionEndpointUrl,Scenario_2_serverName,URLs_publisherURL,URLs_storeURL);
    	testCase.APIM_25(this, Login_userName,Login_password,Scenario_2_serverName,Scenario_1_ApiName,URLs_storeURL);
    	testCase.APIM_26(this, Login_userName,Login_password,Scenario_2_serverName,Scenario_1_ApiName,URLs_storeURL);
    	testCase.APIM_27(this, Login_userName,Login_password,Scenario_2_serverName,Scenario_2_imagePath,Scenario_2_APIVersion,Scenario_2_tagName,Scenario_2_APIName2,URLs_publisherURL,URLs_storeURL);
    } 
    	

    /**
     * Data provider for Test case tc_Scenario_4.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_4")
    public Object[][] dataTable_tc_Scenario_4() {     	
    	return this.getDataTable("Login","URLs","Scenario_4");
    }

    /**
     * Data driven test case tc_Scenario_4.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_4")
    public final void tc_Scenario_4(final String Login_adminUserName, final String Login_adminPassword, final String Login_userName, final String Login_password, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_4_APIName, final String Scenario_4_ProductionEndpointUrl, final String Scenario_4_ValidProductionEndpointUrl, final String Scenario_4_SandboxEndpointUrl, final String Scenario_4_ValidSandboxEndpointUrl, final String Scenario_4_User, final String Scenario_4_Role, final String Scenario_4_newUsername, final String Scenario_4_newPassword, final String Scenario_4_imagePath, final String Scenario_4_tagName, final String Scenario_4_versionName, final String Scenario_4_serverName, final String Scenario_4_urlPattern, final String Scenario_4_nonImagePath) throws Exception {	
    	testCase.APIM_34(this, Login_userName,Login_password,Scenario_4_versionName,Scenario_4_imagePath,Scenario_4_urlPattern,Scenario_4_APIName,Scenario_4_tagName,URLs_publisherURL);
    	testCase.APIM_39(this, Scenario_4_APIName,Scenario_4_ValidSandboxEndpointUrl,Scenario_4_ValidProductionEndpointUrl);
    	testCase.APIM_2A(this, Login_userName,Login_password,Scenario_4_User,Scenario_4_newPassword,Scenario_4_newPassword,Scenario_4_APIName,Scenario_4_imagePath,Scenario_4_versionName,Scenario_4_tagName,Scenario_4_serverName,URLs_storeURL,URLs_publisherURL,URLs_carbonURL,Scenario_4_newUsername,Scenario_4_Role);
    	testCase.APIM_3A(this, Login_userName,Login_password,Scenario_4_APIName,Scenario_4_serverName,Scenario_4_versionName,URLs_storeURL);
    } 
    	

    /**
     * Data provider for Test case tc_Scenario_5.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_5")
    public Object[][] dataTable_tc_Scenario_5() {     	
    	return this.getDataTable("Login","URLs","Scenario_5");
    }

    /**
     * Data driven test case tc_Scenario_5.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_5")
    public final void tc_Scenario_5(final String Login_adminUserName, final String Login_adminPassword, final String Login_userName, final String Login_password, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_5_userName, final String Scenario_5_password, final String Scenario_5_APIName, final String Scenario_5_APIVersion, final String Scenario_5_ImagePath, final String Scenario_5_tagName, final String Scenario_5_productionEndpoint, final String Scenario_5_sandBoxEndpoint, final String Scenario_5_stateCreated, final String Scenario_5_stateBlocked, final String Scenario_5_statePublished, final String Scenario_5_statePrototyped, final String Scenario_5_stateDeprecated, final String Scenario_5_stateRetired, final String Scenario_5_newVersion1, final String Scenario_5_newVersion2, final String Scenario_5_newVersion3, final String Scenario_5_newVersion4, final String Scenario_5_newVersion5, final String Scenario_5_newVersion6, final String Scenario_5_usersCount, final String Scenario_5_APIstatus, final String Scenario_5_docName, final String Scenario_5_uploadDocLocation, final String Scenario_5_docSummary, final String Scenario_5_updateSummary, final String Scenario_5_URLLink, final String Scenario_5_URLLink2, final String Scenario_5_serverName, final String Scenario_5_othername, final String Scenario_5_otherName2, final String Scenario_5_docName2, final String Scenario_5_downloadFilePath, final String Scenario_5_updateSummary2, final String Scenario_5_updateSummary3, final String Scenario_5_editContent1, final String Scenario_5_editContent2, final String Scenario_5_editContent3) throws Exception {	
    	testCase.APIM_127(this, Scenario_5_userName,Scenario_5_password,URLs_publisherURL,Scenario_5_ImagePath,Scenario_5_APIVersion,Scenario_5_tagName,Scenario_5_APIName,Scenario_5_stateBlocked,Scenario_5_newVersion1,Login_userName,Scenario_5_usersCount,Scenario_5_APIstatus,Scenario_5_productionEndpoint,Scenario_5_sandBoxEndpoint);
    	testCase.APIM_122(this, Scenario_5_stateCreated,Scenario_5_newVersion2,Login_userName,Scenario_5_APIName,Scenario_5_APIstatus,Scenario_5_usersCount);
    	testCase.APIM_123(this, Scenario_5_statePublished,Scenario_5_newVersion3,Login_userName,Scenario_5_APIName,Scenario_5_APIstatus,Scenario_5_usersCount);
    	testCase.APIM_124(this, Scenario_5_statePrototyped,Scenario_5_newVersion4,Login_userName,Scenario_5_APIName,Scenario_5_APIstatus,Scenario_5_usersCount);
    	testCase.APIM_125(this, Scenario_5_stateDeprecated,Scenario_5_newVersion5,Login_userName,Scenario_5_APIName,Scenario_5_APIstatus,Scenario_5_usersCount);
    	testCase.APIM_126(this, Scenario_5_stateRetired,Scenario_5_newVersion6,Login_userName,Scenario_5_APIName,Scenario_5_APIstatus,Scenario_5_usersCount);
    	testCase.APIM_419(this, Scenario_5_APIName,Scenario_5_docName,Scenario_5_uploadDocLocation,Scenario_5_docSummary,Scenario_5_updateSummary,Scenario_5_URLLink,Scenario_5_newVersion2,Scenario_5_serverName,Scenario_5_othername,Scenario_5_docName2,URLs_storeURL,Scenario_5_statePublished,URLs_publisherURL,Scenario_5_downloadFilePath,Login_userName,Login_password);
    	testCase.APIM_418(this, Scenario_5_docName,Scenario_5_updateSummary2,Scenario_5_URLLink2,Scenario_5_APIName,Scenario_5_othername,Scenario_5_newVersion2,Scenario_5_serverName,URLs_storeURL,URLs_publisherURL,Scenario_5_otherName2);
    	testCase.APIM_417(this, URLs_publisherURL,Scenario_5_docName,Scenario_5_URLLink,Scenario_5_updateSummary3,Scenario_5_URLLink2,Scenario_5_serverName,Scenario_5_APIName,Scenario_5_newVersion2,URLs_storeURL);
    	testCase.APIM_416(this, Scenario_5_docName,Scenario_5_URLLink,Scenario_5_serverName,Scenario_5_APIName,Scenario_5_newVersion2,Scenario_5_updateSummary2,Scenario_5_URLLink2,URLs_publisherURL,URLs_storeURL);
    	testCase.APIM_415(this, Scenario_5_docName,Scenario_5_URLLink,Scenario_5_updateSummary2,Scenario_5_URLLink2,Scenario_5_newVersion2,Scenario_5_APIName,Scenario_5_serverName,URLs_publisherURL,URLs_storeURL);
    	testCase.APIM_414(this, Scenario_5_URLLink,Scenario_5_docName,Scenario_5_updateSummary3,Scenario_5_URLLink2,Scenario_5_serverName,Scenario_5_APIName,Scenario_5_newVersion2,URLs_publisherURL,URLs_storeURL);
    	testCase.APIM_413(this, Scenario_5_othername,Scenario_5_docName,Scenario_5_updateSummary3,Scenario_5_editContent1,Scenario_5_serverName,Scenario_5_APIName,Scenario_5_newVersion2,URLs_storeURL,URLs_publisherURL);
    	testCase.APIM_412(this, Scenario_5_docName,Scenario_5_editContent2,Scenario_5_serverName,Scenario_5_APIName,Scenario_5_newVersion2,URLs_publisherURL,URLs_storeURL,Scenario_5_updateSummary3);
    	testCase.APIM_411(this, Scenario_5_docName,Scenario_5_editContent3,Scenario_5_APIName,Scenario_5_serverName,Scenario_5_newVersion2,URLs_publisherURL,URLs_storeURL,Scenario_5_updateSummary3);
    	testCase.APIM_128(this, Scenario_5_APIName,Scenario_5_APIVersion,URLs_publisherURL);
    	testCase.APIM_131(this, Scenario_5_APIName);
    	testCase.APIM_349(this, Scenario_5_APIName);
    } 
    	

    /**
     * Data provider for Test case tc_Scenario_6.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_6")
    public Object[][] dataTable_tc_Scenario_6() {     	
    	return this.getDataTable("Login","URLs","Scenario_6");
    }

    /**
     * Data driven test case tc_Scenario_6.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_6")
    public final void tc_Scenario_6(final String Login_adminUserName, final String Login_adminPassword, final String Login_userName, final String Login_password, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_6_APIName, final String Scenario_6_APIVersion, final String Scenario_6_ImagePath, final String Scenario_6_tagName, final String Scenario_6_urlPattern, final String Scenario_6_urlPatterSC, final String Scenario_6_utlPatternUriTemplate, final String Scenario_6_urlPatternComplex, final String Scenario_6_productionEndPointJaxRS, final String Scenario_6_verbGet, final String Scenario_6_verbPost, final String Scenario_6_verbPut, final String Scenario_6_verbDelete, final String Scenario_6_ScopeKey1, final String Scenario_6_scopeKey2, final String Scenario_6_scopeKey3, final String Scenario_6_scopeKey4, final String Scenario_6_ScopeKey5, final String Scenario_6_scopeKey6, final String Scenario_6_scopeKey7, final String Scenario_6_scopeKey8, final String Scenario_6_scopeName1, final String Scenario_6_scopeName2, final String Scenario_6_scopeName3, final String Scenario_6_scopeName4, final String Scenario_6_scopeName5, final String Scenario_6_scopeName6, final String Scenario_6_scopeName7, final String Scenario_6_scopeName8, final String Scenario_6_scopeDescription, final String Scenario_6_roleName, final String Scenario_6_userName, final String Scenario_6_password, final String Scenario_6_docName) throws Exception {	
    	testCase.APIM_175(this, Scenario_6_ImagePath,Scenario_6_APIVersion,Scenario_6_tagName,Scenario_6_APIName,Scenario_6_productionEndPointJaxRS,Scenario_6_urlPattern,Scenario_6_verbGet,Scenario_6_verbPost,Scenario_6_verbPut,Scenario_6_verbDelete,Scenario_6_ScopeKey1,Scenario_6_scopeName1,Scenario_6_scopeKey2,Scenario_6_scopeKey3,Scenario_6_scopeKey4,Scenario_6_scopeName2,Scenario_6_scopeName3,Scenario_6_scopeName4,"",Scenario_6_userName,Scenario_6_password,Scenario_6_password,"",Login_adminUserName,Login_adminPassword,URLs_publisherURL,URLs_carbonURL,Login_adminUserName,Login_adminPassword,Scenario_6_roleName);
    	testCase.APIM_170(this, Scenario_6_APIName,Scenario_6_ScopeKey1,Scenario_6_scopeName1,Scenario_6_scopeDescription);
    	testCase.APIM_168(this);
    	testCase.APIM_166(this, Scenario_6_ScopeKey5,Scenario_6_scopeName5);
    	testCase.APIM_167(this, Scenario_6_scopeKey6,Scenario_6_scopeName6,Scenario_6_APIName);
    	testCase.APIM_169(this, Scenario_6_scopeKey7,Scenario_6_scopeName7);
    	testCase.APIM_171(this, Scenario_6_APIName,Scenario_6_scopeKey6,Scenario_6_scopeName6);
    	testCase.APIM_173(this);
    	testCase.APIM_176(this, Scenario_6_scopeName1,Scenario_6_scopeName2,Scenario_6_scopeName3,Scenario_6_scopeName4,Scenario_6_scopeName5,Scenario_6_scopeName6,Scenario_6_ScopeKey1);
    	testCase.APIM_174(this, Scenario_6_APIName);
    	testCase.APIM_177(this, Scenario_6_verbPost,Scenario_6_APIName,Scenario_6_verbGet,Scenario_6_scopeName5,Scenario_6_scopeName6,Scenario_6_ScopeKey1,Scenario_6_scopeKey2);
    	testCase.APIM_73(this, Scenario_6_APIName,Scenario_6_urlPatterSC,Scenario_6_verbGet,Scenario_6_verbPost);
    	testCase.APIM_74(this, Scenario_6_APIName,Scenario_6_utlPatternUriTemplate,Scenario_6_verbGet,Scenario_6_verbPost);
    	testCase.APIM_75(this, Scenario_6_APIName,Scenario_6_utlPatternUriTemplate,Scenario_6_verbGet,Scenario_6_verbPost,Scenario_6_verbPut,Scenario_6_verbDelete);
    	testCase.APIM_78(this, Scenario_6_urlPatternComplex,Scenario_6_APIName,Scenario_6_verbGet,Scenario_6_verbPost);
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}