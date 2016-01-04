package com.wso2_apimanager;

import java.util.HashMap;
import java.util.List;

import com.virtusa.isq.vtaf.aspects.VTAFRecoveryMethods;
import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import com.virtusa.isq.vtaf.runtime.VTAFTestListener;


/**
 *  Class ts_ApplicationManagement implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_ApplicationManagement extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_Add_Edit_Delete_Manage_Applications.
     * @return data table
     */
    @DataProvider(name = "tc_Add_Edit_Delete_Manage_Applications")
    public Object[][] dataTable_tc_Add_Edit_Delete_Manage_Applications() {     	
    	return this.getDataTable("URLs","AddEditDeleteApplications");
    }

    /**
     * Data driven test case tc_Add_Edit_Delete_Manage_Applications.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Add_Edit_Delete_Manage_Applications")
    public final void tc_Add_Edit_Delete_Manage_Applications(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String AddEditDeleteApplications_domain, final String AddEditDeleteApplications_InvalidAppName, final String AddEditDeleteApplications_ThrottlingTier, final String AddEditDeleteApplications_CallBackURL, final String AddEditDeleteApplications_Description, final String AddEditDeleteApplications_ValidNameTwo, final String AddEditDeleteApplications_ValidAppNameThree, final String AddEditDeleteApplications_ApplicationName, final String AddEditDeleteApplications_ApplicationWithSubscription, final String AddEditDeleteApplications_AppNameFour, final String AddEditDeleteApplications_AppNameFive, final String AddEditDeleteApplications_EditTier, final String AddEditDeleteApplications_EditCallBackURL, final String AddEditDeleteApplications_EditDescription, final String AddEditDeleteApplications_ApplicationNameOne, final String AddEditDeleteApplications_ApplicationNameTwo, final String AddEditDeleteApplications_ProductionEndPontJaxRS, final String AddEditDeleteApplications_tag, final String AddEditDeleteApplications_APIContest, final String AddEditDeleteApplications_APIName, final String AddEditDeleteApplications_tenantOrAdminStoreOne, final String AddEditDeleteApplications_serverNameDomainOne, final String AddEditDeleteApplications_AppDescription, final String AddEditDeleteApplications_Edit, final String AddEditDeleteApplications_Delete, final String AddEditDeleteApplications_active, final String AddEditDeleteApplications_NewApplication, final String AddEditDeleteApplications_Statistics, final String AddEditDeleteApplications_silver, final String AddEditDeleteApplications_newCallbackUrl, final String AddEditDeleteApplications_newDescription) throws Exception {	
    	writeToReport("Start of the Test Suite AddEditDeleteManageApplications");
    	writeToReport("Start  Executing tc_Add_Edit_Delete_Manage_Applications");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,AddEditDeleteApplications_domain);
    	lib_TestCase.APIM_195(this, AddEditDeleteApplications_APIName,AddEditDeleteApplications_APIContest,AddEditDeleteApplications_tag,AddEditDeleteApplications_ProductionEndPontJaxRS,URLs_storeURL,AddEditDeleteApplications_domain,URLs_publisherURL);
    	lib_TestCase.APIM_196(this);
    	lib_TestCase.APIM_202(this, AddEditDeleteApplications_ApplicationName,AddEditDeleteApplications_ThrottlingTier,"","",AddEditDeleteApplications_ApplicationName);
    	lib_TestCase.APIM_204(this, AddEditDeleteApplications_ApplicationName);
    	lib_TestCase.APIM_201(this);
    	lib_TestCase.APIM_198(this);
    	lib_TestCase.APIM_197(this, AddEditDeleteApplications_ApplicationNameOne,AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_Description);
    	lib_TestCase.APIM_199(this, AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_Description,AddEditDeleteApplications_ApplicationNameTwo);
    	lib_TestCase.APIM_200(this, AddEditDeleteApplications_InvalidAppName,AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_Description,AddEditDeleteApplications_ValidNameTwo,AddEditDeleteApplications_ValidAppNameThree);
    	lib_TestCase.APIM_206(this, AddEditDeleteApplications_AppNameFour,AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_Description);
    	lib_TestCase.APIM_205(this, AddEditDeleteApplications_AppNameFour,AddEditDeleteApplications_AppNameFive,AddEditDeleteApplications_EditTier,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_EditDescription);
    	lib_TestCase.APIM2_646(this, URLs_storeURL,AddEditDeleteApplications_serverNameDomainOne,AddEditDeleteApplications_tenantOrAdminStoreOne,AddEditDeleteApplications_ApplicationName,AddEditDeleteApplications_AppDescription,"yes",AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_active,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_Edit,AddEditDeleteApplications_Delete);
    	lib_TestCase.APIM2_650(this, URLs_storeURL,AddEditDeleteApplications_serverNameDomainOne,AddEditDeleteApplications_NewApplication,AddEditDeleteApplications_ApplicationName,AddEditDeleteApplications_AppDescription,AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL);
    	lib_TestCase.APIM2_659(this, AddEditDeleteApplications_serverNameDomainOne,URLs_storeURL,AddEditDeleteApplications_Statistics,AddEditDeleteApplications_serverNameDomainOne);
    	//APIM2_659 won't run in tenant mode
    	if(AddEditDeleteApplications_domain.equals("Tenant")){
    	writeToReport("Test case canont execute in Tenant mode because need to perform in Forum");
    	writeToReport("End of the Test Suite AddEditDeleteManageApplications");
    	} else {
    	lib_TestCase.APIM2_651(this, AddEditDeleteApplications_silver,AddEditDeleteApplications_newCallbackUrl,AddEditDeleteApplications_newDescription,URLs_storeURL,AddEditDeleteApplications_serverNameDomainOne,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_AppDescription,AddEditDeleteApplications_ApplicationName);
    	lib_TestCase.APIM2_653(this, URLs_storeURL,AddEditDeleteApplications_serverNameDomainOne,AddEditDeleteApplications_ApplicationName,AddEditDeleteApplications_AppDescription,"yes",AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL);
    	String varAPINameOne = retrieveString("keyAPIName");
    	//Delete created API
    	lib_Common.bc_DeleteAPI(this, varAPINameOne,URLs_publisherURL);
    	writeToReport("End of the Test Suite AddEditDeleteManageApplications");
    	}
    } 
    	

    /**
     * Data provider for Test case tc_ApplicationSharing.
     * @return data table
     */
    @DataProvider(name = "tc_ApplicationSharing")
    public Object[][] dataTable_tc_ApplicationSharing() {     	
    	return this.getDataTable("Common","ApplicationSharing");
    }

    /**
     * Data driven test case tc_ApplicationSharing.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_ApplicationSharing")
    public final void tc_ApplicationSharing(final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String ApplicationSharing_adminOrTenantOne, final String ApplicationSharing_applicationName, final String ApplicationSharing_description, final String ApplicationSharing_yes, final String ApplicationSharing_no, final String ApplicationSharing_userName, final String ApplicationSharing_password, final String ApplicationSharing_firstName, final String ApplicationSharing_lastName, final String ApplicationSharing_email, final String ApplicationSharing_organizationName, final String ApplicationSharing_address, final String ApplicationSharing_country, final String ApplicationSharing_landPhone, final String ApplicationSharing_mobilePhone, final String ApplicationSharing_IM, final String ApplicationSharing_URL, final String ApplicationSharing_organizationTwo, final String ApplicationSharing_adminStoreUserOne) throws Exception {	
    	writeToReport("Start of tc_ApplicationSharing");
    	lib_TestCase.APIM2_661(this, ApplicationSharing_adminOrTenantOne,Common_storeURL,ApplicationSharing_applicationName,ApplicationSharing_description,ApplicationSharing_yes,ApplicationSharing_no,ApplicationSharing_userName,ApplicationSharing_password,ApplicationSharing_firstName,ApplicationSharing_lastName,ApplicationSharing_email,ApplicationSharing_organizationName,ApplicationSharing_address,ApplicationSharing_country,ApplicationSharing_landPhone,ApplicationSharing_mobilePhone,ApplicationSharing_IM,ApplicationSharing_URL);
    	lib_TestCase.APIM2_663(this, ApplicationSharing_organizationTwo,Common_superAdminUserName,Common_superAdminPassword,Common_carbonURL,ApplicationSharing_password,ApplicationSharing_adminOrTenantOne,Common_storeURL);
    	lib_TestCase.APIM2_754(this, ApplicationSharing_password,ApplicationSharing_applicationName,ApplicationSharing_description,ApplicationSharing_no,Common_storeURL,ApplicationSharing_adminOrTenantOne,ApplicationSharing_adminStoreUserOne);
    	writeToReport("End of tc_ApplicationSharing");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}