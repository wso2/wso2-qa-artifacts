package com.wso2apimanager;

import java.util.HashMap;
import java.util.List;

import com.virtusa.isq.vtaf.aspects.VTAFRecoveryMethods;
import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import com.virtusa.isq.vtaf.runtime.VTAFTestListener;


/**
 *  Class ts_APILifecycleManagement_APIStates_Deprecated implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APILifecycleManagement_APIStates_Deprecated extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APIM_609.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_609")
    public Object[][] dataTable_tc_APIM_609() {     	
    	return this.getDataTable("APILifecycleManagement_APIStates_Deprecated","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_609.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_609")
    public final void tc_APIM_609(final String APILifecycleManagement_APIStates_Deprecated_APIName, final String APILifecycleManagement_APIStates_Deprecated_APIContext, final String APILifecycleManagement_APIStates_Deprecated_APIVersion, final String APILifecycleManagement_APIStates_Deprecated_tagName, final String APILifecycleManagement_APIStates_Deprecated_productionEndPoint, final String APILifecycleManagement_APIStates_Deprecated_sandBoxEndpoint, final String APILifecycleManagement_APIStates_Deprecated_APIStatePublished, final String APILifecycleManagement_APIStates_Deprecated_tenantOrAdmin, final String APILifecycleManagement_APIStates_Deprecated_tenantOrAdminStoreOne, final String APILifecycleManagement_APIStates_Deprecated_adminOrTenantOneStoreUserOne, final String APILifecycleManagement_APIStates_Deprecated_adminOrTenantOneStoreUserOnePassword, final String APILifecycleManagement_APIStates_Deprecated_defaultApplication, final String APILifecycleManagement_APIStates_Deprecated_tenantOrAdminPublisherOne, final String APILifecycleManagement_APIStates_Deprecated_adminOrTenantOnePublisherUserOne, final String APILifecycleManagement_APIStates_Deprecated_adminOrTenantOnePublisherOnePassword, final String APILifecycleManagement_APIStates_Deprecated_APIStateDeprecated, final String APILifecycleManagement_APIStates_Deprecated_numberOfUsersZero, final String APILifecycleManagement_APIStates_Deprecated_tenantOrAdminStoreTwo, final String APILifecycleManagement_APIStates_Deprecated_yes, final String APILifecycleManagement_APIStates_Deprecated_no, final String APILifecycleManagement_APIStates_Deprecated_APIvisibility, final String APILifecycleManagement_APIStates_Deprecated_urlPatternForPostAndPut, final String APILifecycleManagement_APIStates_Deprecated_urlPatternForGetDeleteAndHead, final String APILifecycleManagement_APIStates_Deprecated_numberOfUsersOne, final String APILifecycleManagement_APIStates_Deprecated_keyTypeToInvokeProduction, final String APILifecycleManagement_APIStates_Deprecated_keyTypeToInvokeSandBox, final String APILifecycleManagement_APIStates_Deprecated_buttonNamePost, final String APILifecycleManagement_APIStates_Deprecated_postPayloadContext, final String APILifecycleManagement_APIStates_Deprecated_CustomerNameOne, final String APILifecycleManagement_APIStates_Deprecated_CustomerNameTwo, final String APILifecycleManagement_APIStates_Deprecated_ResponseCodeTwoHundred, final String APILifecycleManagement_APIStates_Deprecated_ResponseHeaders, final String APILifecycleManagement_APIStates_Deprecated_buttonNameGet, final String APILifecycleManagement_APIStates_Deprecated_buttonNamePut, final String APILifecycleManagement_APIStates_Deprecated_ResponseBodyNoContent, final String APILifecycleManagement_APIStates_Deprecated_buttonNameHead, final String APILifecycleManagement_APIStates_Deprecated_ResponseHeadersNull, final String APILifecycleManagement_APIStates_Deprecated_buttonNameDelete, final String APILifecycleManagement_APIStates_Deprecated_deleteResponseHeaders, final String APILifecycleManagement_APIStates_Deprecated_ResponCodeTwoHundredAndFourForDeleteVerification, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//Restriction of new suscriptions for depricated APIs
    	//When an API is depricated, it should not be available on store or new subscribers to subscribe
    	writeToReport("Start of executing APIM2_609");
    	//Create new API up to Published state
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APILifecycleManagement_APIStates_Deprecated_adminOrTenantOnePublisherUserOne,APILifecycleManagement_APIStates_Deprecated_adminOrTenantOnePublisherOnePassword,pauseTimes_fourSeconds);
    	lib_Common.bc_APIPublisher_AddAPI_DesignPhaseToInvoke(this, APILifecycleManagement_APIStates_Deprecated_APIName,APILifecycleManagement_APIStates_Deprecated_APIContext,APILifecycleManagement_APIStates_Deprecated_APIVersion,APILifecycleManagement_APIStates_Deprecated_APIvisibility,"",APILifecycleManagement_APIStates_Deprecated_tagName,APILifecycleManagement_APIStates_Deprecated_urlPatternForPostAndPut,APILifecycleManagement_APIStates_Deprecated_urlPatternForGetDeleteAndHead,pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	lib_Common.bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(this, APILifecycleManagement_APIStates_Deprecated_productionEndPoint,keyWords_keyWordYes,APILifecycleManagement_APIStates_Deprecated_sandBoxEndpoint,keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	lib_Common.bc_APIPublisher_AddAPI_ManageToInvoke(this, keyWords_keyWordNo,keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	//Change state in to deprecated
    	String varAPINameDesign = retrieveString("key_APINameDesign");
    	/*
    	Click
    	 object=APIPublisherHome.lnk_Browse
    	*/
    	click("APIPublisherHome.lnk_APIs");
    	lib_Common.bc_APIPublisherSearch(this, varAPINameDesign,varAPINameDesign,APILifecycleManagement_APIStates_Deprecated_APIVersion,pauseTimes_fourSeconds);
    	/*
    	//wait for content load
    	WaitForElement
    	 object=APIPublisherHome.tf_APISearch
    	 ms=@pauseTimes_fiveSeconds
    	Type
    	 object=APIPublisherHome.tf_APISearch
    	 text=@varAPINameDesign
    	Click
    	 object=APIPublisherHome.btn_Search
    	*/
    	//wait for content load
    	waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPINameDesign,pauseTimes_fiveSeconds);
    	click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPINameDesign);
    	//wait for content load
    	waitForElement("APIPublisherBrowse.btn_Lifecycle",pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.btn_Lifecycle");
    	/*
    	//wait for content load
    	WaitForElement
    	 object=APIPublisherBrowse.ele_ddState
    	 ms=@pauseTimes_fiveSeconds
    	Select
    	 object=APIPublisherBrowse.ele_ddState
    	 selectLocator=@param_APIStateDeprecated
    	*/
    	click("APIPublisherBrowse.btn_StateDeprecate");
    	/*
    	//wait for content load

    	WaitForElement
    	 object=APIPublisherBrowse.btn_UpdateState
    	 ms=@pauseTimes_fiveSeconds
    	Click
    	 object=APIPublisherBrowse.btn_UpdateState
    	*/
    	//wait for content load
    	waitForElement("APIPublisherBrowse.ele_lblStateChangeMessage",pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblStateChangeMessage",false,"");
    	click("APIPublisherHome.lnk_APIs");
    	/*
    	Click
    	 object=APIPublisherHome.lnk_Browse
    	*/
    	//waiting for content load
    	waitForElement("APIPublisherHome.tf_APISearch",pauseTimes_eightSeconds);
    	type("APIPublisherHome.tf_APISearch",varAPINameDesign);
    	waitForElement("APIPublisherHome.btn_Search",pauseTimes_fiveSeconds);
    	click("APIPublisherHome.btn_Search");
    	//Verify the API Name/Version/Creator/Number of uers/API status
    	if(APILifecycleManagement_APIStates_Deprecated_tenantOrAdmin.equals("TenantOne")){
    	String varPublisherUserName = retrieveString("keyTenantOnePublisherUserOne");
    	waitForElement("APIPublisherHome.btn_Search",pauseTimes_fiveSeconds);
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.btn_Search");
    	//Verify the API Name/Version/Creator/Number of uers/API status
    	checkElementPresent("APIPublisherBrowse.ele_lblStatus","param_APIName_PARAM:" + varAPINameDesign + "_PARAM," + "param_version_PARAM:" + APILifecycleManagement_APIStates_Deprecated_APIVersion + "_PARAM," + "param_creater_PARAM:" + varPublisherUserName + "_PARAM," + "param_status_PARAM:" + APILifecycleManagement_APIStates_Deprecated_APIStateDeprecated,false,"");
    	} else if(APILifecycleManagement_APIStates_Deprecated_tenantOrAdmin.equals("Admin")){
    	String varPublisherAdminUserName = retrieveString("keyAdminPublisherUserOne");
    	waitForElement("APIPublisherHome.btn_Search",pauseTimes_fiveSeconds);
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.btn_Search");
    	//Verify the API Name/Version/Creator/Number of uers/API status
    	checkElementPresent("APIPublisherBrowse.ele_lblStatus","param_APIName_PARAM:" + varAPINameDesign + "_PARAM," + "param_version_PARAM:" + APILifecycleManagement_APIStates_Deprecated_APIVersion + "_PARAM," + "param_creater_PARAM:" + varPublisherAdminUserName + "_PARAM," + "param_status_PARAM:" + APILifecycleManagement_APIStates_Deprecated_APIStateDeprecated,false,"");
    	}
    	//Navigate to store for subsription
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_fourSeconds);
    	lib_Common.bc_SelectServer(this, APILifecycleManagement_APIStates_Deprecated_tenantOrAdmin);
    	lib_Common.bc_Login_APIStore(this, APILifecycleManagement_APIStates_Deprecated_adminOrTenantOneStoreUserOne,APILifecycleManagement_APIStates_Deprecated_adminOrTenantOneStoreUserOnePassword,pauseTimes_threeSeconds,pauseTimes_sixSeconds);
    	/*
    	Call
    	 businessComponent=lib_Common.bc_StoreLogin
    	 param_TenanrOrAdmin=@param_TenantOrAdminStoreTwo
    	 param_pauseThreeSeconds=@param_pauseThreeSeconds
    	 param_pauseFourSeconds=@param_pauseFourSeconds
    	 param_pauseSixSeconds=@param_pauseSixSeconds
    	 param_pauseEightSeconds=@param_pauseEightSeconds
    	*/
    	//waiting for content load
    	waitForElement("APIStoreHome.tf_APISearchStore",pauseTimes_fourSeconds);
    	type("APIStoreHome.tf_APISearchStore",varAPINameDesign);
    	click("APIStoreHome.btn_SearchButtonStore");
    	if(checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + varAPINameDesign)){
    	fail("API is available");
    	}
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_sixSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of executing APIM2_609");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}