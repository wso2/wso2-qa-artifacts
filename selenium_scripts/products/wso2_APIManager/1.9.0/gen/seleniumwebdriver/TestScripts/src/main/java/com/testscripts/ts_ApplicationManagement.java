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
    	return this.getDataTable("URLs","AddEditDeleteApplications");
    }

    /**
     * Data driven test case tc_Add_Edit_Delete_Manage_Applications.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Add_Edit_Delete_Manage_Applications")
    public final void tc_Add_Edit_Delete_Manage_Applications(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String AddEditDeleteApplications_domain, final String AddEditDeleteApplications_InvalidAppName, final String AddEditDeleteApplications_ThrottlingTier, final String AddEditDeleteApplications_CallBackURL, final String AddEditDeleteApplications_Description, final String AddEditDeleteApplications_ValidNameTwo, final String AddEditDeleteApplications_ValidAppNameThree, final String AddEditDeleteApplications_ApplicationName, final String AddEditDeleteApplications_ApplicationWithSubscription, final String AddEditDeleteApplications_AppNameFour, final String AddEditDeleteApplications_AppNameFive, final String AddEditDeleteApplications_EditTier, final String AddEditDeleteApplications_EditCallBackURL, final String AddEditDeleteApplications_EditDescription, final String AddEditDeleteApplications_ApplicationNameOne, final String AddEditDeleteApplications_ApplicationNameTwo, final String AddEditDeleteApplications_ProductionEndPontJaxRS, final String AddEditDeleteApplications_tag, final String AddEditDeleteApplications_APIContest, final String AddEditDeleteApplications_APIName) throws Exception {	
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
    	String varAPINameOne = retrieveString("keyAPIName");
    	//Delete created API
    	lib_Common.bc_DeleteAPI(this, varAPINameOne,URLs_publisherURL);
    	writeToReport("End of the Test Suite AddEditDeleteManageApplications");
    } 
    	

    /**
     * Test case tc_ApplicationSharing.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_ApplicationSharing() throws Exception {
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}