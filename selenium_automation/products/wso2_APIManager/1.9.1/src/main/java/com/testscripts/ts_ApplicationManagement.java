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
    	return this.getDataTable("PauseTimes","URLs","AddEditDeleteApplications","DeleteAllApplicationsAndAPIsFromAllTenants");
    }

    /**
     * Data driven test case tc_Add_Edit_Delete_Manage_Applications.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Add_Edit_Delete_Manage_Applications")
    public final void tc_Add_Edit_Delete_Manage_Applications(final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String AddEditDeleteApplications_domain, final String AddEditDeleteApplications_InvalidAppName, final String AddEditDeleteApplications_ThrottlingTier, final String AddEditDeleteApplications_CallBackURL, final String AddEditDeleteApplications_Description, final String AddEditDeleteApplications_ValidNameTwo, final String AddEditDeleteApplications_ValidAppNameThree, final String AddEditDeleteApplications_ApplicationName, final String AddEditDeleteApplications_ApplicationWithSubscription, final String AddEditDeleteApplications_AppNameFour, final String AddEditDeleteApplications_AppNameFive, final String AddEditDeleteApplications_EditTier, final String AddEditDeleteApplications_EditCallBackURL, final String AddEditDeleteApplications_EditDescription, final String AddEditDeleteApplications_ApplicationNameOne, final String AddEditDeleteApplications_ApplicationNameTwo, final String AddEditDeleteApplications_ProductionEndPontJaxRS, final String AddEditDeleteApplications_tag, final String AddEditDeleteApplications_APIContest, final String AddEditDeleteApplications_APIName, final String AddEditDeleteApplications_tenantOrAdminStoreOne, final String AddEditDeleteApplications_serverNameDomainOne, final String AddEditDeleteApplications_AppDescription, final String AddEditDeleteApplications_Edit, final String AddEditDeleteApplications_Delete, final String AddEditDeleteApplications_active, final String AddEditDeleteApplications_NewApplication, final String AddEditDeleteApplications_Statistics, final String AddEditDeleteApplications_silver, final String AddEditDeleteApplications_newCallbackUrl, final String AddEditDeleteApplications_newDescription, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainOneTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOrAdminPublisherUser, final String DeleteAllApplicationsAndAPIsFromAllTenants_DefaultApplication, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserThree, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainTwoTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainCondition, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminPublisherUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminPublisherUserOne) throws Exception {	
    	writeToReport("Start  Executing tc_Add_Edit_Delete_Manage_Applications");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,AddEditDeleteApplications_domain,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_195(this, AddEditDeleteApplications_APIName,AddEditDeleteApplications_APIContest,AddEditDeleteApplications_tag,AddEditDeleteApplications_ProductionEndPontJaxRS,URLs_storeURL,AddEditDeleteApplications_domain,URLs_publisherURL,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_196(this);
    	lib_TestCase.APIM_202(this, AddEditDeleteApplications_ApplicationName,AddEditDeleteApplications_ThrottlingTier,"","",AddEditDeleteApplications_ApplicationName,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_201(this, PauseTimes_sixSeconds);
    	lib_TestCase.APIM_198(this, PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_197(this, AddEditDeleteApplications_ApplicationNameOne,AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_Description,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_199(this, AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_Description,AddEditDeleteApplications_ApplicationNameTwo,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_200(this, AddEditDeleteApplications_InvalidAppName,AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_Description,AddEditDeleteApplications_ValidNameTwo,AddEditDeleteApplications_ValidAppNameThree,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_206(this, AddEditDeleteApplications_AppNameFour,AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_Description,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_205(this, AddEditDeleteApplications_AppNameFour,AddEditDeleteApplications_AppNameFive,AddEditDeleteApplications_EditTier,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_EditDescription,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM2_646(this, URLs_storeURL,AddEditDeleteApplications_serverNameDomainOne,AddEditDeleteApplications_tenantOrAdminStoreOne,AddEditDeleteApplications_ApplicationName,AddEditDeleteApplications_AppDescription,"yes",AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_active,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_Edit,AddEditDeleteApplications_Delete,PauseTimes_sixSeconds,PauseTimes_eightSeconds,PauseTimes_eightSeconds,PauseTimes_sixSeconds);
    	lib_TestCase.APIM2_650(this, URLs_storeURL,AddEditDeleteApplications_serverNameDomainOne,AddEditDeleteApplications_NewApplication,AddEditDeleteApplications_ApplicationName,AddEditDeleteApplications_AppDescription,AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	lib_TestCase.APIM2_659(this, AddEditDeleteApplications_serverNameDomainOne,URLs_storeURL,AddEditDeleteApplications_Statistics,AddEditDeleteApplications_serverNameDomainOne,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	//APIM2_659 won't run in tenant mode
    	if(AddEditDeleteApplications_domain.equals("Tenant")){
    	writeToReport("Test case canont execute in Tenant mode because need to perform in Forum");
    	writeToReport("End of the Test Suite AddEditDeleteManageApplications");
    	} else {
    	lib_TestCase.APIM2_651(this, AddEditDeleteApplications_silver,AddEditDeleteApplications_newCallbackUrl,AddEditDeleteApplications_newDescription,URLs_storeURL,AddEditDeleteApplications_serverNameDomainOne,AddEditDeleteApplications_CallBackURL,AddEditDeleteApplications_AppDescription,AddEditDeleteApplications_ApplicationName,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	lib_TestCase.APIM2_653(this, URLs_storeURL,AddEditDeleteApplications_serverNameDomainOne,AddEditDeleteApplications_ApplicationName,AddEditDeleteApplications_AppDescription,"yes",AddEditDeleteApplications_ThrottlingTier,AddEditDeleteApplications_CallBackURL,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	String varAPINameOne = retrieveString("keyAPIName");
    	//Delete created API
    	lib_Common.bc_DeleteAPI(this, varAPINameOne,URLs_publisherURL,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	writeToReport("End of the Test Suite AddEditDeleteManageApplications");
    	}
    } 
    	

    /**
     * Data provider for Test case tc_ApplicationSharing.
     * @return data table
     */
    @DataProvider(name = "tc_ApplicationSharing")
    public Object[][] dataTable_tc_ApplicationSharing() {     	
    	return this.getDataTable("PauseTimes","Common","ApplicationSharing");
    }

    /**
     * Data driven test case tc_ApplicationSharing.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_ApplicationSharing")
    public final void tc_ApplicationSharing(final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds, final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String ApplicationSharing_adminOrTenantOne, final String ApplicationSharing_applicationName, final String ApplicationSharing_description, final String ApplicationSharing_yes, final String ApplicationSharing_no, final String ApplicationSharing_userName, final String ApplicationSharing_password, final String ApplicationSharing_firstName, final String ApplicationSharing_lastName, final String ApplicationSharing_email, final String ApplicationSharing_organizationName, final String ApplicationSharing_address, final String ApplicationSharing_country, final String ApplicationSharing_landPhone, final String ApplicationSharing_mobilePhone, final String ApplicationSharing_IM, final String ApplicationSharing_URL, final String ApplicationSharing_organizationTwo, final String ApplicationSharing_adminStoreUserOne, final String ApplicationSharing_sixSeconds) throws Exception {	
    	writeToReport("Start of tc_ApplicationSharing");
    	lib_TestCase.APIM2_661(this, ApplicationSharing_adminOrTenantOne,Common_storeURL,ApplicationSharing_applicationName,ApplicationSharing_description,ApplicationSharing_yes,ApplicationSharing_no,ApplicationSharing_userName,ApplicationSharing_password,ApplicationSharing_firstName,ApplicationSharing_lastName,ApplicationSharing_email,ApplicationSharing_organizationName,ApplicationSharing_address,ApplicationSharing_country,ApplicationSharing_landPhone,ApplicationSharing_mobilePhone,ApplicationSharing_IM,ApplicationSharing_URL,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	lib_TestCase.APIM2_663(this, ApplicationSharing_organizationTwo,Common_superAdminUserName,Common_superAdminPassword,Common_carbonURL,ApplicationSharing_password,ApplicationSharing_adminOrTenantOne,Common_storeURL,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	lib_TestCase.APIM2_754(this, ApplicationSharing_password,ApplicationSharing_applicationName,ApplicationSharing_description,ApplicationSharing_no,Common_storeURL,ApplicationSharing_adminOrTenantOne,ApplicationSharing_adminStoreUserOne,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	writeToReport("End of tc_ApplicationSharing");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}