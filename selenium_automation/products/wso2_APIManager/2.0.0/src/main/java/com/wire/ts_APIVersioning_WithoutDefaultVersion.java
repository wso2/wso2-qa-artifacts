package com.wire;

import java.util.HashMap;
import java.util.List;

import com.virtusa.isq.vtaf.aspects.VTAFRecoveryMethods;
import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import com.virtusa.isq.vtaf.runtime.VTAFTestListener;


/**
 *  Class ts_APIVersioning_WithoutDefaultVersion implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APIVersioning_WithoutDefaultVersion extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APIM_10.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_10")
    public Object[][] dataTable_tc_APIM_10() {     	
    	return this.getDataTable("APIVersioning_WithoutDefaultVersion","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_10.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_10")
    public final void tc_APIM_10(final String APIVersioning_WithoutDefaultVersion_apiName, final String APIVersioning_WithoutDefaultVersion_apiContext, final String APIVersioning_WithoutDefaultVersion_apiVersionOne, final String APIVersioning_WithoutDefaultVersion_apiVersionTwo, final String APIVersioning_WithoutDefaultVersion_apiVisibilityPublic, final String APIVersioning_WithoutDefaultVersion_apiImage, final String APIVersioning_WithoutDefaultVersion_apiTagName, final String APIVersioning_WithoutDefaultVersion_productionEndpoint, final String APIVersioning_WithoutDefaultVersion_sandboxEndpoint, final String APIVersioning_WithoutDefaultVersion_numberOfUsersZero, final String APIVersioning_WithoutDefaultVersion_statusCreated, final String APIVersioning_WithoutDefaultVersion_statusPublished, final String APIVersioning_WithoutDefaultVersion_statusDeprecated, final String APIVersioning_WithoutDefaultVersion_publisherOneOfTenantOneOrAdmin, final String APIVersioning_WithoutDefaultVersion_adminOrTenantOnePublisherUserOne, final String APIVersioning_WithoutDefaultVersion_adminOrTenantOnePublisherOnePassword, final String APIVersioning_WithoutDefaultVersion_storeOneOfTenantOneOrAdmin, final String APIVersioning_WithoutDefaultVersion_serverNameDomainOne, final String APIVersioning_WithoutDefaultVersion_urlPatternForPostAndPut, final String APIVersioning_WithoutDefaultVersion_urlPatternForGetDeleteAndHead, final String APIVersioning_WithoutDefaultVersion_applicationName, final String APIVersioning_WithoutDefaultVersion_applicationDiscription, final String APIVersioning_WithoutDefaultVersion_keyTypeToInvoke, final String APIVersioning_WithoutDefaultVersion_postPayloadContext, final String APIVersioning_WithoutDefaultVersion_postCustomerNameFromPayloadContext, final String APIVersioning_WithoutDefaultVersion_postResponseHeaders, final String APIVersioning_WithoutDefaultVersion_getCustomerName, final String APIVersioning_WithoutDefaultVersion_getResponseHeaders, final String APIVersioning_WithoutDefaultVersion_putCustomerName, final String APIVersioning_WithoutDefaultVersion_getCustomerNameForPutVerification, final String APIVersioning_WithoutDefaultVersion_getResponseHeadersForPutVerification, final String APIVersioning_WithoutDefaultVersion_deleteResponseHeaders, final String APIVersioning_WithoutDefaultVersion_invokeTypeProduction, final String APIVersioning_WithoutDefaultVersion_invokeTypeSandbox, final String APIVersioning_WithoutDefaultVersion_tierType, final String APIVersioning_WithoutDefaultVersion_numberOfUsersOne, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//APIM2-10: Create a copy of an API successfully
    	writeToReport("Start of test case APIM2_10");
    	//Navigate to Publisher
    	/*
    	NavigateToURL
    	 url=APIPublisherLogin
    	 param_publisherURL=@URLs_publisherURL
    	 ms=@pauseTimes_fourSeconds
    	*/
    	//use application key login
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIVersioning_WithoutDefaultVersion_adminOrTenantOnePublisherUserOne,APIVersioning_WithoutDefaultVersion_adminOrTenantOnePublisherOnePassword,pauseTimes_fiveSeconds);
    	lib_Common.bc_APIPublisher_AddAPI_DesignPhaseToInvoke(this, APIVersioning_WithoutDefaultVersion_apiName,APIVersioning_WithoutDefaultVersion_apiContext,APIVersioning_WithoutDefaultVersion_apiVersionOne,APIVersioning_WithoutDefaultVersion_apiVisibilityPublic,APIVersioning_WithoutDefaultVersion_apiImage,APIVersioning_WithoutDefaultVersion_apiTagName,APIVersioning_WithoutDefaultVersion_urlPatternForPostAndPut,APIVersioning_WithoutDefaultVersion_urlPatternForGetDeleteAndHead,pauseTimes_threeSeconds,pauseTimes_fiveSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	lib_Common.bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(this, APIVersioning_WithoutDefaultVersion_productionEndpoint,keyWords_keyWordYes,APIVersioning_WithoutDefaultVersion_sandboxEndpoint,keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fiveSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	lib_Common.bc_APIPublisher_AddAPI_ManageToInvoke(this, keyWords_keyWordNo,keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fiveSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	//Retrive the above created API name and version
    	String APIName = retrieveString("key_APINameDesign");
    	String APIversion = retrieveString("key_APIVersion");
    	waitForElement("APIPublisherHome.lnk_APIs",pauseTimes_sixSeconds);
    	lib_Common.bc_APIPublisherSearch(this, APIName,APIName,APIVersioning_WithoutDefaultVersion_apiVersionOne,pauseTimes_fourSeconds);
    	//verify the availability of API created
    	checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName,false,"");
    	//Go inside the API
    	click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
    	//wait for content load
    	waitForElement("APIPublisherBrowse.lnk_Overview",pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.lnk_Overview");
    	waitForElement("APIPublisherBrowse.btn_CreateNewVersion",pauseTimes_fiveSeconds);
    	//creating new copy of published API
    	click("APIPublisherBrowse.btn_CreateNewVersion");
    	checkElementPresent("APIPublisherBrowse.tf_NewVersion",false,"");
    	checkElementPresent("Browse_Overview.chk_DefaultVersion",false,"");
    	checkElementPresent("APIPublisherBrowse.btn_done",false,"");
    	checkElementPresent("Browse_Overview.btn_CancelNewVersion",false,"");
    	type("APIPublisherBrowse.tf_NewVersion",APIVersioning_WithoutDefaultVersion_apiVersionTwo);
    	waitForElement("APIPublisherBrowse.btn_done",pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.btn_done");
    	pause(pauseTimes_sixSeconds);
    	//cannot see "New API version is created successfully" message.
    	lib_Common.bc_APIPublisherSearchWithNameVersionAndStatus(this, pauseTimes_fiveSeconds,APIName,APIName,APIVersioning_WithoutDefaultVersion_apiVersionTwo,APIVersioning_WithoutDefaultVersion_statusCreated);
    	//***************************************************************
    	if(APIVersioning_WithoutDefaultVersion_serverNameDomainOne.equals("TenantOne")){
    	String varPublisherUserName = retrieveString("keyTenantOnePublisherUserOne");
    	//Verify the API Name/Version/Creator/Number of uers/API status
    	waitForElement("APIPublisherBrowse.ele_lblVersionAndUser","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersioning_WithoutDefaultVersion_apiVersionTwo + "_PARAM," + "param_creater_PARAM:" + varPublisherUserName,pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblVersionAndUser","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersioning_WithoutDefaultVersion_apiVersionTwo + "_PARAM," + "param_creater_PARAM:" + varPublisherUserName,false,"");
    	checkElementPresent("APIPublisherBrowse.ele_lblUsers","param_version_PARAM:" + APIVersioning_WithoutDefaultVersion_apiVersionTwo + "_PARAM," + "param_users_PARAM:" + APIVersioning_WithoutDefaultVersion_numberOfUsersZero,false,"");
    	checkElementPresent("APIPublisherBrowse.ele_lblStatus","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersioning_WithoutDefaultVersion_apiVersionTwo + "_PARAM," + "param_creater_PARAM:" + varPublisherUserName + "_PARAM," + "param_status_PARAM:" + APIVersioning_WithoutDefaultVersion_statusCreated,false,"");
    	} else if(APIVersioning_WithoutDefaultVersion_serverNameDomainOne.equals("Admin")){
    	String varPublisherAdminUserName = retrieveString("keyAdminPublisherUserOne");
    	//Verify the API Name/Version/Creator/Number of uers/API status
    	checkElementPresent("APIPublisherBrowse.ele_lblVersionAndUser","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersioning_WithoutDefaultVersion_apiVersionTwo + "_PARAM," + "param_creater_PARAM:" + varPublisherAdminUserName,false,"");
    	checkElementPresent("APIPublisherBrowse.ele_lblUsers","param_version_PARAM:" + APIVersioning_WithoutDefaultVersion_apiVersionTwo + "_PARAM," + "param_users_PARAM:" + APIVersioning_WithoutDefaultVersion_numberOfUsersZero,false,"");
    	checkElementPresent("APIPublisherBrowse.ele_lblStatus","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersioning_WithoutDefaultVersion_apiVersionTwo + "_PARAM," + "param_creater_PARAM:" + varPublisherAdminUserName + "_PARAM," + "param_status_PARAM:" + APIVersioning_WithoutDefaultVersion_statusCreated,false,"");
    	}
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of test case APIM2_10");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}