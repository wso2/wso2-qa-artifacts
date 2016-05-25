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
 *  Class ts_APIVersioning_Default_Version implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APIVersioning_Default_Version extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APIM_4.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_4")
    public Object[][] dataTable_tc_APIM_4() {     	
    	return this.getDataTable("APIVersioning_Default_Version","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_4.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_4")
    public final void tc_APIM_4(final String APIVersioning_Default_Version_apiName, final String APIVersioning_Default_Version_apiContext, final String APIVersioning_Default_Version_apiVersionOne, final String APIVersioning_Default_Version_apiVersionTwo, final String APIVersioning_Default_Version_apiVersionThree, final String APIVersioning_Default_Version_apiVersionFour, final String APIVersioning_Default_Version_apiVersionFive, final String APIVersioning_Default_Version_apiVisibilityPublic, final String APIVersioning_Default_Version_apiImage, final String APIVersioning_Default_Version_apiTagName, final String APIVersioning_Default_Version_productionEndpoint, final String APIVersioning_Default_Version_sandboxEndpoint, final String APIVersioning_Default_Version_numberOfUsersZero, final String APIVersioning_Default_Version_statusCreated, final String APIVersioning_Default_Version_statusPublished, final String APIVersioning_Default_Version_statusDeprecated, final String APIVersioning_Default_Version_publisherOneOfTenantOneOrAdmin, final String APIVersioning_Default_Version_adminOrTenantOnePublisherUserOne, final String APIVersioning_Default_Version_adminOrTenantOnePublisherOnePassword, final String APIVersioning_Default_Version_storeOneOfTenantOneOrAdmin, final String APIVersioning_Default_Version_adminOrTenantOneStoreUserOne, final String APIVersioning_Default_Version_adminOrTenantOneStoreUserOnePassword, final String APIVersioning_Default_Version_serverNameDomainOne, final String APIVersioning_Default_Version_urlPatternForPostAndPut, final String APIVersioning_Default_Version_urlPatternForGetDeleteAndHead, final String APIVersioning_Default_Version_applicationName, final String APIVersioning_Default_Version_applicationDiscription, final String APIVersioning_Default_Version_keyTypeToInvoke, final String APIVersioning_Default_Version_postPayloadContext, final String APIVersioning_Default_Version_postCustomerNameFromPayloadContext, final String APIVersioning_Default_Version_postResponseHeaders, final String APIVersioning_Default_Version_getCustomerName, final String APIVersioning_Default_Version_getResponseHeaders, final String APIVersioning_Default_Version_putCustomerName, final String APIVersioning_Default_Version_getCustomerNameForPutVerification, final String APIVersioning_Default_Version_getResponseHeadersForPutVerification, final String APIVersioning_Default_Version_deleteResponseHeaders, final String APIVersioning_Default_Version_DefaultApplication, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	writeToReport("Start Of TC APIM_4");
    	//Creation of API
    	//Loging to the publisher using the created credentials
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIVersioning_Default_Version_adminOrTenantOnePublisherUserOne,APIVersioning_Default_Version_adminOrTenantOnePublisherOnePassword,pauseTimes_fourSeconds);
    	lib_Common.bc_APIPublisher_AddAPI_DesignPhaseToInvoke(this, APIVersioning_Default_Version_apiName,APIVersioning_Default_Version_apiContext,APIVersioning_Default_Version_apiVersionOne,APIVersioning_Default_Version_apiVisibilityPublic,APIVersioning_Default_Version_apiImage,APIVersioning_Default_Version_apiTagName,APIVersioning_Default_Version_urlPatternForPostAndPut,APIVersioning_Default_Version_urlPatternForGetDeleteAndHead,pauseTimes_fourSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	String APIcontext = retrieveString("key_apiContextDesign");
    	lib_Common.bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(this, APIVersioning_Default_Version_productionEndpoint,keyWords_keyWordYes,APIVersioning_Default_Version_sandboxEndpoint,keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	lib_Common.bc_APIPublisher_AddAPI_ManageToInvoke(this, keyWords_keyWordYes,keyWords_keyWordNo,"",pauseTimes_fourSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	String APIName = retrieveString("key_APINameDesign");
    	lib_Common.bc_APIPublisherSearch(this, APIName,APIName,APIVersioning_Default_Version_apiVersionOne,pauseTimes_sixSeconds);
    	//Click API name with specific version 1.0.0
    	waitForElement("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_APIVersion_PARAM:" + APIVersioning_Default_Version_apiVersionOne + "_PARAM," + "param_APIName_PARAM:" + APIName,pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_APIVersion_PARAM:" + APIVersioning_Default_Version_apiVersionOne + "_PARAM," + "param_APIName_PARAM:" + APIName);
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.btn_CreateNewVersion",pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherBrowse.btn_CreateNewVersion",false,"");
    	click("APIPublisherBrowse.btn_CreateNewVersion");
    	/*
    	WaitForElement
    	 object=Browse_Overview.btn_CreateNewVersion
    	 ms=@pauseTimes_sixSeconds
    	//verify that the overview page contains the create button
    	CheckElementPresent
    	 object=Browse_Overview.btn_CreateNewVersion
    	 stopOnFailure=false
    	 customErrorMessage=
    	Click
    	 object=Browse_Overview.btn_CreateNewVersion
    	*/
    	//Wait for content load
    	waitForElement("Browse_Overview.tf_ToVersion",pauseTimes_sixSeconds);
    	//verify that to version tab has expanded successfully and its contents are available
    	checkElementPresent("Browse_Overview.tf_ToVersion",false,"");
    	checkElementPresent("Browse_Overview.chk_DefaultVersion",false,"");
    	checkElementPresent("Browse_Overview.btn_Done",false,"");
    	checkElementPresent("Browse_Overview.btn_CancelNewVersion",false,"");
    	//Type new version - version two
    	type("Browse_Overview.tf_ToVersion",APIVersioning_Default_Version_apiVersionTwo);
    	//Wait for content load
    	waitForElement("Browse_Overview.chk_DefaultVersion",pauseTimes_eightSeconds);
    	click("Browse_Overview.chk_DefaultVersion");
    	//Wait for content load
    	waitForElement("Browse_Overview.btn_Done",pauseTimes_sixSeconds);
    	click("Browse_Overview.btn_Done");
    	//Cannot verify the new version added message due to application bug
    	//Wait for content load
    	waitForElement("APIPublisherHome.lnk_APIs",pauseTimes_tenSeconds);
    	//Verify redirected to browse page
    	checkElementPresent("APIPublisherHome.lnk_APIs",false,"");
    	if(APIVersioning_Default_Version_serverNameDomainOne.equals("TenantOne")){
    	String var_Provider = retrieveString("keyTenantOnePublisherUserOne");
    	store("key_domain","String",var_Provider);
    	} else if(APIVersioning_Default_Version_serverNameDomainOne.equals("Admin")){
    	String var_Provider = retrieveString("keyAdminPublisherUserOne");
    	store("key_domain","String",var_Provider);
    	}
    	String var_Provider = retrieveString("key_domain");
    	lib_Common.bc_APIPublisherSearch(this, APIName,APIName,APIVersioning_Default_Version_apiVersionTwo,pauseTimes_fourSeconds);
    	//Verify the overall api details in browse page
    	checkElementPresent("APIPublisherBrowse.lnk_APINameOverall","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersioning_Default_Version_apiVersionTwo + "_PARAM," + "param_provider_PARAM:" + var_Provider + "_PARAM," + "param_numberOfUsers_PARAM:" + APIVersioning_Default_Version_numberOfUsersZero + "_PARAM," + "param_status_PARAM:" + APIVersioning_Default_Version_statusCreated,false,"");
    	//Navigate to Api Life Cycle tab
    	click("APIPublisherBrowse.lnk_APINameOverall","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersioning_Default_Version_apiVersionTwo + "_PARAM," + "param_provider_PARAM:" + var_Provider + "_PARAM," + "param_numberOfUsers_PARAM:" + APIVersioning_Default_Version_numberOfUsersZero + "_PARAM," + "param_status_PARAM:" + APIVersioning_Default_Version_statusCreated);
    	//Wait for content load
    	waitForElement("APIPublisherBrowse.btn_Lifecycle",pauseTimes_sixSeconds);
    	//verify the availability of Lifestyle tab
    	checkElementPresent("APIPublisherBrowse.btn_Lifecycle",false,"");
    	click("APIPublisherBrowse.btn_Lifecycle");
    	//***********************************************************
    	waitForElement("APIPublisherBrowse.btn_StatePublish",pauseTimes_sixSeconds);
    	//Publish the API hence it would be visible in store section
    	click("APIPublisherBrowse.btn_StatePublish");
    	//No checkboxes are avilable under life cycle tab in server pack 2.0.0
    	//The below parts were neglected as per change
    	/*
    	//Wait for content load
    	WaitForElement
    	 object=browseLifecycle.ele_ddSelectState
    	 ms=@pauseTimes_sixSeconds
    	Pause
    	 ms=@pauseTimes_fourSeconds
    	Select
    	 object=browseLifecycle.ele_ddSelectState
    	 selectLocator=@APIVersioning_Default_Version_statusPublished
    	//check weather Propagate Changes To API Gateway is un-checked
    	If
    	 expression=checkElementPresent("browseLifecycle.chk_PropagateChangesToAPIGateway")
    	 WaitForElement
    	  object=browseLifecycle.chk_PropagateChangesToAPIGateway
    	  ms=@pauseTimes_sixSeconds
    	 Click
    	  object=browseLifecycle.chk_PropagateChangesToAPIGateway
    	EndIf
    	WaitForElement
    	 object=browseLifecycle.ele_lblUpdateSuccessMessage
    	 ms=@pauseTimes_sixSeconds
    	Click
    	 object=browseLifecycle.btn_Update
    	*/
    	checkElementPresent("browseLifecycle.ele_lblUpdateSuccessMessage",false,"");
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_fourSeconds);
    	lib_Common.bc_SelectServer(this, APIVersioning_Default_Version_serverNameDomainOne);
    	lib_Common.bc_Login_APIStore(this, APIVersioning_Default_Version_adminOrTenantOneStoreUserOne,APIVersioning_Default_Version_adminOrTenantOneStoreUserOnePassword,pauseTimes_threeSeconds,pauseTimes_sixSeconds);
    	lib_Common.bc_APIStoreSearch(this, APIName,APIName,APIVersioning_Default_Version_apiVersionTwo,pauseTimes_fourSeconds);
    	/*
    	WaitForElement
    	 object=APIStoreHome.lnk_APINameStore
    	 param_APIName=@APIName
    	 ms=@pauseTimes_sixSeconds
    	CheckElementPresent
    	 object=APIStoreHome.lnk_APINameStore
    	 param_APIName=@APIName
    	 stopOnFailure=false
    	 customErrorMessage=
    	*/
    	click("APIStoreHome.lnk_APINameStoreWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionTwo);
    	//**************************************************************
    	if(APIVersioning_Default_Version_serverNameDomainOne.equals("TenantOne")){
    	String var_providerDomain[] = var_Provider.split("[@]");
    	//Wait for content load
    	waitForElement("APIStoreAPIs.ele_lblProductionUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionTwo,pauseTimes_sixSeconds);
    	//verify sandbox and production url with and witout version
    	checkElementPresent("APIStoreAPIs.ele_lblProductionUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionTwo,false,"");
    	checkElementPresent("APIStoreAPIs.ele_lblProductionDefaultUrl","param_provider_PARAM:" + var_providerDomain[1] + "_PARAM," + "param_APIName_PARAM:" + APIName,false,"");
    	checkElementPresent("APIStoreAPIs.ele_lblSandboxUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionTwo,false,"");
    	checkElementPresent("APIStoreAPIs.ele_lblSandboxDefaultUrl","param_provider_PARAM:" + var_providerDomain[1] + "_PARAM," + "param_APIName_PARAM:" + APIName,false,"");
    	//verify the API with previous version is available and verify the default url
    	lib_Common.bc_APIStoreSearch(this, APIName,APIName,APIVersioning_Default_Version_apiVersionOne,pauseTimes_sixSeconds);
    	//verify the  availability of API with older version
    	checkElementPresent("APIStoreHome.lnk_APINameStoreWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionOne,false,"");
    	click("APIStoreHome.lnk_APINameStoreWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionOne);
    	//Wait for content load
    	waitForElement("APIStoreAPIs.ele_lblProductionUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionOne,pauseTimes_sixSeconds);
    	//verify sandbox and production url with version and non availability of Default api
    	checkElementPresent("APIStoreAPIs.ele_lblProductionUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionOne,false,"");
    	if(checkElementPresent("APIStoreAPIs.ele_lblProductionDefaultUrl","param_provider_PARAM:" +var_providerDomain[1]+"_PARAM"+"param_APIName_PARAM:" + APIName)){
    	fail("Default production url is available under API innitial version");
    	}
    	checkElementPresent("APIStoreAPIs.ele_lblSandboxUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionOne,false,"");
    	if(checkElementPresent("APIStoreAPIs.ele_lblSandboxDefaultUrl","param_provider_PARAM:" + var_providerDomain[1]+"_PARAM"+"param_APIName_PARAM:" + APIName)){
    	fail("Default sandbox url is available under API innitial version");
    	}
    	}
    	if(APIVersioning_Default_Version_serverNameDomainOne.equals("Admin")){
    	//Wait for content load
    	waitForElement("APIStoreAPIs.ele_lblProductionUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionTwo,pauseTimes_sixSeconds);
    	//verify sandbox and production url with and witout version
    	checkElementPresent("APIStoreAPIs.ele_lblProductionUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionTwo,false,"");
    	checkElementPresent("APIStoreAPIs.ele_lblProductionDefaultUrlAdmin","param_APIName_PARAM:" + APIName,false,"");
    	/*
    	CheckElementPresent
    	  object=APIStoreAPIs.ele_lblProductionDefaultUrl
    	  param_provider=@var_Provider
    	  param_APIName=@APIName
    	  stopOnFailure=false
    	  customErrorMessage=
    	*/
    	checkElementPresent("APIStoreAPIs.ele_lblSandboxUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionTwo,false,"");
    	checkElementPresent("APIStoreAPIs.ele_lblSandboxDefaultUrlAdmin","param_APIName_PARAM:" + APIName,false,"");
    	/*
    	CheckElementPresent
    	  object=APIStoreAPIs.ele_lblSandboxDefaultUrl
    	  param_provider=@var_Provider
    	  param_APIName=@APIName
    	  stopOnFailure=false
    	  customErrorMessage=
    	*/
    	//verify the API with previous version is available and verify the default url
    	lib_Common.bc_APIStoreSearch(this, APIName,APIName,APIVersioning_Default_Version_apiVersionOne,pauseTimes_sixSeconds);
    	//verify the  availability of API with older version
    	checkElementPresent("APIStoreHome.lnk_APINameStoreWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionOne,false,"");
    	click("APIStoreHome.lnk_APINameStoreWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionOne);
    	//Wait for content load
    	waitForElement("APIStoreAPIs.ele_lblProductionUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionOne,pauseTimes_sevenSeconds);
    	//verify sandbox and production url with version and non availability of Default api
    	checkElementPresent("APIStoreAPIs.ele_lblProductionUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionOne,false,"");
    	if(checkElementPresent("APIStoreAPIs.ele_lblProductionDefaultUrl","param_provider_PARAM:" +var_Provider+"_PARAM"+"param_APIName_PARAM:" + APIName)){
    	fail("Default production url is available under API innitial version");
    	}
    	checkElementPresent("APIStoreAPIs.ele_lblSandboxUrlWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionNumber_PARAM:" + APIVersioning_Default_Version_apiVersionOne,false,"");
    	if(checkElementPresent("APIStoreAPIs.ele_lblSandboxDefaultUrl","param_provider_PARAM:" + var_Provider+"_PARAM"+"param_APIName_PARAM:" + APIName)){
    	fail("Default sandbox url is available under API innitial version");
    	}
    	}
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_fiveSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End Of TC APIM_4");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}