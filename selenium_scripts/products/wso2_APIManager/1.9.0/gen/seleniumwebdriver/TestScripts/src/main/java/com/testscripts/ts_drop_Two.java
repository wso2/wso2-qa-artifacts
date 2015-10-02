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
 *  Class ts_drop_Two implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_drop_Two extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_AdminAndTenantUserCreation.
     * @return data table
     */
    @DataProvider(name = "tc_AdminAndTenantUserCreation")
    public Object[][] dataTable_tc_AdminAndTenantUserCreation() {     	
    	return this.getDataTable("CreateTenant_CreateUserAndAssignRoles","CreateUserAndAssignRoles","Login","URLs");
    }

    /**
     * Data driven test case tc_AdminAndTenantUserCreation.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_AdminAndTenantUserCreation")
    public final void tc_AdminAndTenantUserCreation(final String CreateTenant_CreateUserAndAssignRoles_domain, final String CreateTenant_CreateUserAndAssignRoles_firstName, final String CreateTenant_CreateUserAndAssignRoles_lastName, final String CreateTenant_CreateUserAndAssignRoles_adminUserName, final String CreateTenant_CreateUserAndAssignRoles_adminPassword, final String CreateTenant_CreateUserAndAssignRoles_email, final String CreateTenant_CreateUserAndAssignRoles_newTenantUsername, final String CreateTenant_CreateUserAndAssignRoles_newTenantPassword, final String CreateTenant_CreateUserAndAssignRoles_newUserName, final String CreateTenant_CreateUserAndAssignRoles_roleName, final String CreateTenant_CreateUserAndAssignRoles_role, final String CreateTenant_CreateUserAndAssignRoles_role1, final String CreateTenant_CreateUserAndAssignRoles_role2, final String CreateTenant_CreateUserAndAssignRoles_user1, final String CreateTenant_CreateUserAndAssignRoles_user2, final String CreateTenant_CreateUserAndAssignRoles_Userpassword, final String CreateUserAndAssignRoles_newUserName, final String CreateUserAndAssignRoles_newPassword, final String CreateUserAndAssignRoles_roleName, final String CreateUserAndAssignRoles_role, final String CreateUserAndAssignRoles_role1, final String CreateUserAndAssignRoles_role2, final String CreateUserAndAssignRoles_user1, final String CreateUserAndAssignRoles_user2, final String CreateUserAndAssignRoles_userPassword, final String Login_adminUserName, final String Login_adminPassword, final String Login_userName, final String Login_password, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	Common.bc_CreateSuperUsers(this, CreateUserAndAssignRoles_role1,Login_adminUserName,Login_adminPassword,URLs_carbonURL,CreateUserAndAssignRoles_user1,CreateUserAndAssignRoles_userPassword,CreateUserAndAssignRoles_userPassword,"",CreateUserAndAssignRoles_user2,CreateUserAndAssignRoles_userPassword,CreateUserAndAssignRoles_userPassword,CreateUserAndAssignRoles_role2);
    	Common.bc_CreateTenant(this, Login_adminUserName,Login_adminPassword,CreateTenant_CreateUserAndAssignRoles_domain,CreateTenant_CreateUserAndAssignRoles_firstName,CreateTenant_CreateUserAndAssignRoles_lastName,CreateTenant_CreateUserAndAssignRoles_adminUserName,CreateTenant_CreateUserAndAssignRoles_adminPassword,CreateTenant_CreateUserAndAssignRoles_email,URLs_carbonURL);
    	String newTenantUsername = retrieveString("keynewTenantUsername");
    	Common.bc_CreateTenantUsers(this, newTenantUsername,CreateTenant_CreateUserAndAssignRoles_adminPassword,URLs_carbonURL,CreateTenant_CreateUserAndAssignRoles_Userpassword,CreateTenant_CreateUserAndAssignRoles_Userpassword,"",CreateTenant_CreateUserAndAssignRoles_role1,CreateTenant_CreateUserAndAssignRoles_user1,CreateTenant_CreateUserAndAssignRoles_Userpassword,CreateTenant_CreateUserAndAssignRoles_Userpassword,"",CreateTenant_CreateUserAndAssignRoles_role2,CreateTenant_CreateUserAndAssignRoles_user2);
    } 
    	

    /**
     * Data provider for Test case tc_Scenario_8.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_8")
    public Object[][] dataTable_tc_Scenario_8() {     	
    	return this.getDataTable("URLs","Scenario_8");
    }

    /**
     * Data driven test case tc_Scenario_8.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_8")
    public final void tc_Scenario_8(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_8_UseName, final String Scenario_8_Password, final String Scenario_8_UserNameStore, final String Scenario_8_PasswordStore, final String Scenario_8_ApiImagePath, final String Scenario_8_ApiVersion, final String Scenario_8_TagName, final String Scenario_8_ApiName, final String Scenario_8_ProductionEndPoint, final String Scenario_8_SandBoxEndPoint, final String Scenario_8_DocNameInvalid, final String Scenario_8_DocName, final String Scenario_8_DocSummery, final String Scenario_8_SourceUrl, final String Scenario_8_ServerName, final String Scenario_8_DocName2, final String Scenario_8_TextEdit, final String Scenario_8_DocNameInvalid2, final String Scenario_8_DocName3, final String Scenario_8_DocName4, final String Scenario_8_UploadFilePath, final String Scenario_8_DownloadFilePath, final String Scenario_8_DocName5, final String Scenario_8_EditContent1, final String Scenario_8_DocName6, final String Scenario_8_DocName7, final String Scenario_8_EditContent2, final String Scenario_8_VisibilityValue, final String Scenario_8_VisibilityValue2, final String Scenario_8_VisibilityValue3, final String Scenario_8_DocSummery2, final String Scenario_8_UploadFilePath2, final String Scenario_8_DownloadFilePath2, final String Scenario_8_TableColumnType, final String Scenario_8_downImag) throws Exception {	
    	testCase.APIM_95(this, Scenario_8_UseName,Scenario_8_Password,URLs_publisherURL,Scenario_8_ApiImagePath,Scenario_8_ApiVersion,Scenario_8_TagName,Scenario_8_ApiName,Scenario_8_ProductionEndPoint,Scenario_8_SandBoxEndPoint,Scenario_8_DocNameInvalid,Scenario_8_DocName,Scenario_8_DocSummery,Scenario_8_SourceUrl,URLs_storeURL,Scenario_8_UserNameStore,Scenario_8_PasswordStore,Scenario_8_ServerName);
    	testCase.APIM_90(this, Scenario_8_ApiName);
    	testCase.APIM_91(this, Scenario_8_DocName2,Scenario_8_DocSummery,Scenario_8_ServerName,Scenario_8_UserNameStore,Scenario_8_PasswordStore,Scenario_8_ApiName,Scenario_8_ApiVersion,Scenario_8_TextEdit,URLs_storeURL,URLs_publisherURL);
    	testCase.APIM_92(this, Scenario_8_DocNameInvalid,Scenario_8_SourceUrl,Scenario_8_DocNameInvalid2,Scenario_8_DocName3,URLs_publisherURL,Scenario_8_UserNameStore,Scenario_8_PasswordStore,Scenario_8_ApiName,Scenario_8_ApiVersion,URLs_storeURL,Scenario_8_ServerName);
    	testCase.APIM_93(this, Scenario_8_ApiName,Scenario_8_DocName4,Scenario_8_UploadFilePath,Scenario_8_DocSummery,URLs_storeURL,Scenario_8_UserNameStore,Scenario_8_PasswordStore,Scenario_8_DownloadFilePath,Scenario_8_ServerName,Scenario_8_ApiVersion,URLs_publisherURL,Scenario_8_downImag);
    	testCase.APIM_94(this, Scenario_8_ApiName,Scenario_8_DocName5,Scenario_8_DocSummery,Scenario_8_EditContent1,Scenario_8_ApiVersion,URLs_storeURL,Scenario_8_ServerName,Scenario_8_UserNameStore,Scenario_8_PasswordStore,URLs_publisherURL);
    	testCase.APIM_347(this, Scenario_8_DocName5,Scenario_8_ApiName);
    	testCase.APIM_165(this, Scenario_8_DocName7,Scenario_8_EditContent2,Scenario_8_ApiName,Scenario_8_ApiVersion,Scenario_8_ServerName,Scenario_8_UserNameStore,Scenario_8_PasswordStore,URLs_storeURL,URLs_publisherURL);
    	testCase.APIM_113(this, Scenario_8_DocName,Scenario_8_SourceUrl,Scenario_8_ApiName);
    	testCase.APIM_112(this, Scenario_8_DocName,Scenario_8_ApiVersion,Scenario_8_EditContent1,Scenario_8_DocSummery,URLs_publisherURL,Scenario_8_ApiName,Scenario_8_ServerName,URLs_storeURL,Scenario_8_TableColumnType);
    	/*
    	Call
    	 businessComponent=testCase.APIM_114
    	 param_summery=@Scenario_8_DocSummery
    	 param_URL=@Scenario_8_SourceUrl
    	 param_visibilityValue=@Scenario_8_VisibilityValue
    	 param_docName=@Scenario_8_DocName
    	 param_APIName=@Scenario_8_ApiName
    	 param_serverName=@Scenario_8_ServerName
    	 param_visibilityValue2=@Scenario_8_VisibilityValue2
    	 param_summery2=@Scenario_8_DocSummery2
    	 param_visibilityValue3=@Scenario_8_VisibilityValue3
    	 param_uploadDocLocation2=@Scenario_8_UploadFilePath2
    	 param_storeURL=@URLs_storeURL
    	 param_usernameStore=@Scenario_8_UserNameStore
    	 param_passwordStore=@Scenario_8_PasswordStore
    	 param_APIVersion=@Scenario_8_ApiVersion
    	 param_publisherURL=@URLs_publisherURL
    	 param_uploadDocLocation=@Scenario_8_UploadFilePath
    	 param_DownloadFilePath2=@Scenario_8_DownloadFilePath2
    	 param_DownloadFilePath=@Scenario_8_DownloadFilePath
    	*/
    } 
    	

    /**
     * Data provider for Test case tc_Scenario_7.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_7")
    public Object[][] dataTable_tc_Scenario_7() {     	
    	return this.getDataTable("Login","URLs","Scenario_7");
    }

    /**
     * Data driven test case tc_Scenario_7.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_7")
    public final void tc_Scenario_7(final String Login_adminUserName, final String Login_adminPassword, final String Login_userName, final String Login_password, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_7_userName, final String Scenario_7_password, final String Scenario_7_userNameStore, final String Scenario_7_passwordStore, final String Scenario_7_APIName, final String Scenario_7_APIVersion, final String Scenario_7_tagName, final String Scenario_7_ProductionPointUrl, final String Scenario_7_ImagePath, final String Scenario_7_filetoUpload, final String Scenario_7_downloadFile, final String Scenario_7_serverName, final String Scenario_7_docName, final String Scenario_7_DocName1, final String Scenario_7_docName2, final String Scenario_7_docName3, final String Scenario_7_docName4, final String Scenario_7_docName5, final String Scenario_7_docName6, final String Scenario_7_docName7, final String Scenario_7_docName8, final String Scenario_7_docName9, final String Scenario_7_docName10, final String Scenario_7_docName11, final String Scenario_7_invalidDocName, final String Scenario_7_docNameWithSpace, final String Scenario_7_summary, final String Scenario_7_content, final String Scenario_7_howTo, final String Scenario_7_howToUpperCase, final String Scenario_7_SampleSdk, final String Scenario_7_SamplesUpper, final String Scenario_7_PublicForum, final String Scenario_7_publicUpper, final String Scenario_7_SupportForum, final String Scenario_7_supportUpper, final String Scenario_7_Other, final String Scenario_7_otherUpper, final String Scenario_7_inline, final String Scenario_7_url, final String Scenario_7_file, final String Scenario_7_testUrl, final String Scenario_7_otherValue, final String Scenario_7_downImag) throws Exception {	
    	testCase.APIM_6A(this, Scenario_7_ImagePath,Scenario_7_APIVersion,Scenario_7_tagName,Scenario_7_APIName,Scenario_7_ProductionPointUrl,Scenario_7_docName,URLs_publisherURL,Scenario_7_userName,Scenario_7_password);
    	testCase.APIM_116(this, Scenario_7_APIName,Scenario_7_DocName1,Scenario_7_howTo,Scenario_7_docName2,Scenario_7_SampleSdk,Scenario_7_docName3,Scenario_7_PublicForum,Scenario_7_docName4,Scenario_7_SupportForum,Scenario_7_docName5,Scenario_7_Other,Scenario_7_Other,Scenario_7_testUrl,URLs_publisherURL,Scenario_7_otherUpper,Scenario_7_supportUpper,Scenario_7_publicUpper,Scenario_7_SamplesUpper,Scenario_7_howToUpperCase,Scenario_7_url);
    	testCase.APIM_105(this, Scenario_7_docName6,Scenario_7_summary,Scenario_7_Other,Scenario_7_Other,Scenario_7_file,Scenario_7_filetoUpload,Scenario_7_downloadFile,URLs_storeURL,Scenario_7_APIName,URLs_publisherURL,Scenario_7_otherUpper,Scenario_7_serverName,Scenario_7_downImag,Scenario_7_userNameStore,Scenario_7_passwordStore);
    	testCase.APIM_104(this, Scenario_7_invalidDocName,Scenario_7_APIName,Scenario_7_Other,Scenario_7_invalidDocName,Scenario_7_docName7,Scenario_7_summary,Scenario_7_howTo,Scenario_7_url,Scenario_7_Other,Scenario_7_testUrl,URLs_publisherURL,Scenario_7_otherUpper);
    	testCase.APIM_103(this, Scenario_7_APIName,Scenario_7_docNameWithSpace,Scenario_7_summary,Scenario_7_Other,Scenario_7_otherValue,Scenario_7_APIVersion,Scenario_7_content,URLs_storeURL,Scenario_7_serverName,URLs_publisherURL,Scenario_7_otherUpper);
    	testCase.APIM_102(this, Scenario_7_APIName,Scenario_7_docName,Scenario_7_summary,Scenario_7_SupportForum,Scenario_7_otherValue,Scenario_7_url,Scenario_7_file,Scenario_7_filetoUpload,Scenario_7_downloadFile,URLs_storeURL,URLs_publisherURL,Scenario_7_serverName,Scenario_7_supportUpper);
    	testCase.APIM_101(this, Scenario_7_url,Scenario_7_APIName,Scenario_7_docName8,Scenario_7_summary,Scenario_7_SupportForum,Scenario_7_testUrl,URLs_publisherURL,Scenario_7_serverName,URLs_storeURL,Scenario_7_supportUpper);
    	testCase.APIM_100(this, Scenario_7_APIName,Scenario_7_PublicForum,Scenario_7_inline,URLs_publisherURL,Scenario_7_docName9,Scenario_7_summary,Scenario_7_publicUpper);
    	testCase.APIM_99(this, Scenario_7_APIName,Scenario_7_PublicForum,Scenario_7_summary,Scenario_7_docName9,Scenario_7_file,Scenario_7_filetoUpload,Scenario_7_downloadFile,Scenario_7_serverName,URLs_publisherURL,URLs_storeURL,Scenario_7_publicUpper);
    	testCase.APIM_98(this, Scenario_7_APIName,Scenario_7_url,Scenario_7_docName10,Scenario_7_summary,Scenario_7_PublicForum,Scenario_7_testUrl,Scenario_7_serverName,URLs_storeURL,URLs_publisherURL,Scenario_7_publicUpper);
    	testCase.APIM_96(this, URLs_publisherURL,Scenario_7_APIName,Scenario_7_docName11,Scenario_7_summary,Scenario_7_SampleSdk,Scenario_7_SamplesUpper,Scenario_7_downloadFile,Scenario_7_serverName,URLs_storeURL,Scenario_7_filetoUpload,Scenario_7_file);
    } 
    	

    /**
     * Data provider for Test case tc_Scenario_9.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_9")
    public Object[][] dataTable_tc_Scenario_9() {     	
    	return this.getDataTable("URLs","Scenario_9");
    }

    /**
     * Data driven test case tc_Scenario_9.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_9")
    public final void tc_Scenario_9(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_9_userName, final String Scenario_9_password, final String Scenario_9_userNameStore, final String Scenario_9_passwordStore, final String Scenario_9_APIImagePath, final String Scenario_9_APIVersion, final String Scenario_9_tagName, final String Scenario_9_APIName, final String Scenario_9_productionEndPoint, final String Scenario_9_sandBoxEndpoint, final String Scenario_9_DocName, final String Scenario_9_OtherTypeDoc1, final String Scenario_9_OtherTypeDoc2, final String Scenario_9_OtherTypeDoc3, final String Scenario_9_otherName, final String Scenario_9_URL1, final String Scenario_9_docLocationOtherType, final String Scenario_9_serverName, final String Scenario_9_URL2, final String Scenario_9_supportForumDoc1, final String Scenario_9_supportForumDoc2, final String Scenario_9_docLocationSupport, final String Scenario_9_PublicForumDoc1, final String Scenario_9_PublicForumDoc2, final String Scenario_9_docLocationPublic, final String Scenario_9_URL3, final String Scenario_9_SampleSDKDoc1, final String Scenario_9_SampleSDKDoc2, final String Scenario_9_SampleSDKDoc3, final String Scenario_9_URL4, final String Scenario_9_DocLocationSampleSDK, final String Scenario_9_howToDoc1, final String Scenario_9_howToDoc2, final String Scenario_9_howToDoc3, final String Scenario_9_URL5, final String Scenario_9_docLocationHowTo) throws Exception {	
    	//APIM-115: User should get validation message when trying to update document having an empty source URL
    	testCase.APIM_115(this, Scenario_9_userName,Scenario_9_password,URLs_publisherURL,Scenario_9_APIImagePath,Scenario_9_APIVersion,Scenario_9_tagName,Scenario_9_APIName,Scenario_9_productionEndPoint,Scenario_9_DocName,Scenario_9_sandBoxEndpoint);
    	//APIM-121: Check whether documents of type other get deleted successfully.
    	testCase.APIM_121(this, Scenario_9_APIName,Scenario_9_OtherTypeDoc1,Scenario_9_OtherTypeDoc2,Scenario_9_OtherTypeDoc3,Scenario_9_otherName,Scenario_9_URL1,Scenario_9_docLocationOtherType,Scenario_9_serverName,URLs_storeURL,Scenario_9_userNameStore,Scenario_9_passwordStore,URLs_publisherURL);
    	//APIM-120: Check whether documents of type 'support forum' get deleted successfully.
    	testCase.APIM_120(this, Scenario_9_APIName,Scenario_9_supportForumDoc1,Scenario_9_supportForumDoc2,Scenario_9_URL2,Scenario_9_docLocationSupport,Scenario_9_serverName,URLs_storeURL,URLs_publisherURL);
    	//APIM-119: Check whether documents of type 'public forum' get deleted successfully.
    	testCase.APIM_119(this, Scenario_9_PublicForumDoc1,Scenario_9_PublicForumDoc2,Scenario_9_URL3,Scenario_9_docLocationPublic,Scenario_9_serverName,URLs_storeURL,Scenario_9_APIName,URLs_publisherURL);
    	//APIM-118: Check whether documents of type 'public forum' get deleted successfully.
    	testCase.APIM_118(this, Scenario_9_SampleSDKDoc1,Scenario_9_SampleSDKDoc2,Scenario_9_SampleSDKDoc3,Scenario_9_URL4,Scenario_9_DocLocationSampleSDK,Scenario_9_serverName,URLs_storeURL,URLs_publisherURL,Scenario_9_APIName);
    	//APIM-117: Check whether documents of type how to get deleted successfully.
    	testCase.APIM_117(this, Scenario_9_howToDoc1,Scenario_9_howToDoc2,Scenario_9_howToDoc3,Scenario_9_URL5,Scenario_9_docLocationHowTo,Scenario_9_serverName,URLs_storeURL,Scenario_9_APIName,URLs_publisherURL);
    } 
    	

    /**
     * Data provider for Test case tc_Scenario_10.
     * @return data table
     */
    @DataProvider(name = "tc_Scenario_10")
    public Object[][] dataTable_tc_Scenario_10() {     	
    	return this.getDataTable("Login","URLs","Scenario_10");
    }

    /**
     * Data driven test case tc_Scenario_10.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scenario_10")
    public final void tc_Scenario_10(final String Login_adminUserName, final String Login_adminPassword, final String Login_userName, final String Login_password, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scenario_10_userName, final String Scenario_10_password, final String Scenario_10_userNameStore, final String Scenario_10_passwordStore, final String Scenario_10_APIName, final String Scenario_10_ApiVersion, final String Scenario_10_ImagePath, final String Scenario_10_tagName, final String Scenario_10_vergGet, final String Scenario_10_verbPost, final String Scenario_10_verbPut, final String Scenario_10_verbOption, final String Scenario_10_productionEndpointUrl, final String Scenario_10_Application, final String Scenario_10_ApplicationUser, final String Scenario_10_applicationAndApplicationUser, final String Scenario_10_none, final String Scenario_10_newVersion, final String Scenario_10_serverName, final String Scenario_10_ApplicationName, final String Scenario_10_ThrottlingTier, final String Scenario_10_callBackUrl, final String Scenario_10_description, final String Scenario_10_ApplicationName1, final String Scenario_10_ApplicationName2, final String Scenario_10_InvalidAppName, final String Scenario_10_ValidAppName, final String Scenario_10_ValidAppName3, final String Scenario_10_AppName4, final String Scenario_10_AppName5, final String Scenario_10_EditTier, final String Scenario_10_EditCallBackURL, final String Scenario_10_EditDescription, final String Scenario_10_TokenValue1, final String Scenario_10_TokenValue2) throws Exception {	
    	testCase.APIM_422(this, Scenario_10_userName,Scenario_10_password,URLs_publisherURL,Scenario_10_APIName,Scenario_10_ApiVersion,Scenario_10_ImagePath,Scenario_10_tagName,Scenario_10_vergGet,Scenario_10_verbPost,Scenario_10_verbPut,Scenario_10_verbOption,Scenario_10_productionEndpointUrl,Scenario_10_Application,Scenario_10_ApplicationUser,Scenario_10_applicationAndApplicationUser,Scenario_10_none,Scenario_10_newVersion);
    	testCase.APIM_195(this, URLs_storeURL,Scenario_10_serverName,Scenario_10_userNameStore,Scenario_10_passwordStore);
    	testCase.APIM_196(this);
    	testCase.APIM_202(this, Scenario_10_ApplicationName,Scenario_10_ThrottlingTier,"","",Scenario_10_ApplicationName);
    	testCase.APIM_204(this, Scenario_10_ApplicationName);
    	testCase.APIM_201(this);
    	testCase.APIM_198(this);
    	testCase.APIM_197(this, Scenario_10_ApplicationName1,Scenario_10_ThrottlingTier,Scenario_10_callBackUrl,Scenario_10_description);
    	testCase.APIM_199(this, Scenario_10_ThrottlingTier,Scenario_10_callBackUrl,Scenario_10_description,Scenario_10_ApplicationName2);
    	testCase.APIM_200(this, Scenario_10_InvalidAppName,Scenario_10_ThrottlingTier,Scenario_10_callBackUrl,Scenario_10_description,Scenario_10_ValidAppName,Scenario_10_ValidAppName3);
    	testCase.APIM_206(this, Scenario_10_AppName4,Scenario_10_ThrottlingTier,Scenario_10_callBackUrl,Scenario_10_description);
    	testCase.APIM_205(this, Scenario_10_AppName4,Scenario_10_AppName5,Scenario_10_EditTier,Scenario_10_EditCallBackURL,Scenario_10_EditDescription);
    	testCase.APIM_207(this, Scenario_10_AppName5,Scenario_10_TokenValue1,Scenario_10_TokenValue2);
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}