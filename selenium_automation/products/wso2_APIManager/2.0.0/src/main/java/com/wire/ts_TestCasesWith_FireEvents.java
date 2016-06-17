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
 *  Class ts_TestCasesWith_FireEvents implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_TestCasesWith_FireEvents extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APIM_730.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_730")
    public Object[][] dataTable_tc_APIM_730() {     	
    	return this.getDataTable("testCasesWith_FireEvents","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_730.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_730")
    public final void tc_APIM_730(final String testCasesWith_FireEvents_adminOrTenantOnePublisherUserOne, final String testCasesWith_FireEvents_adminOrTenantOnePublisherUserOnePassword, final String testCasesWith_FireEvents_adminOrTenantOneStoreUserOne, final String testCasesWith_FireEvents_adminOrTenantOneStoreUserOnePassword, final String testCasesWith_FireEvents_apiName, final String testCasesWith_FireEvents_apiVersion, final String testCasesWith_FireEvents_apiTagName, final String testCasesWith_FireEvents_apiContext, final String testCasesWith_FireEvents_downImag, final String testCasesWith_FireEvents_downloadFilePathSwagger, final String testCasesWith_FireEvents_downloadFilePathJson, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//APIM-730: Download swagger definition in YAML formatl
    	writeToReport("Start Executing APIM-730");
    	//loging to publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,testCasesWith_FireEvents_adminOrTenantOnePublisherUserOne,testCasesWith_FireEvents_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	//Create sample API
    	lib_Common.bc_CreateAPI_DesignStage(this, testCasesWith_FireEvents_apiName,testCasesWith_FireEvents_apiContext,testCasesWith_FireEvents_apiVersion,testCasesWith_FireEvents_apiTagName,pauseTimes_twoSeconds,pauseTimes_sixSeconds);
    	//retrieving API name
    	String varAPIName_APIM_731 = retrieveString("var_APIName");
    	//Search API to click
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	//waiting for content load
    	waitForElement("APIPublisherHome.tf_APISearch",pauseTimes_sixSeconds);
    	pause(pauseTimes_sixSeconds);
    	type("APIPublisherHome.tf_APISearch",varAPIName_APIM_731);
    	//waiting for content load
    	pause(pauseTimes_sixSeconds);
    	waitForElement("APIPublisherHome.btn_Search",pauseTimes_sixSeconds);
    	click("APIPublisherHome.btn_Search");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPIName_APIM_731,pauseTimes_sixSeconds);
    	//Click on Particular API
    	click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPIName_APIM_731);
    	//click on edit
    	click("APIPublisherBrowse.lnk_Edit");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.btn_EditSource",pauseTimes_sixSeconds);
    	//click on edit source
    	clickAt("APIPublisherBrowse.btn_EditSource","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.frm_SwaggerEditIframe",pauseTimes_sixSeconds);
    	//Select frame to go inside
    	selectFrame("APIPublisherBrowse.frm_SwaggerEditIframe");
    	//select downlaod YAML
    	click("APIPublisherBrowse.btn_SwaggerFile");
    	//Download the YMAL format file
    	click("APIPublisherBrowse.btn_DownloadYAML");
    	//Handling popup for fire fox browser
    	String DownloadPopupOne = testCasesWith_FireEvents_downImag;
    	if(checkImagePresent(DownloadPopupOne,false)){
    	fireEvent("KEY%key=alt+s",pauseTimes_fourSeconds);
    	fireEvent("KEY%key=alt+a",pauseTimes_fourSeconds);
    	fireEvent("KEY%key=\n",pauseTimes_fourSeconds);
    	}
    	pause(pauseTimes_sixSeconds);
    	//Check downloaded file
    	checkFileInfo(testCasesWith_FireEvents_downloadFilePathSwagger,"EXIST",false,"");
    	int temp = 0;java.io.File f = new java.io.File(testCasesWith_FireEvents_downloadFilePathSwagger);f.delete();;
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_threeSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End Executing APIM2-730");
    } 
    	

    /**
     * Data provider for Test case tc_APIM_731.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_731")
    public Object[][] dataTable_tc_APIM_731() {     	
    	return this.getDataTable("testCasesWith_FireEvents","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_731.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_731")
    public final void tc_APIM_731(final String testCasesWith_FireEvents_adminOrTenantOnePublisherUserOne, final String testCasesWith_FireEvents_adminOrTenantOnePublisherUserOnePassword, final String testCasesWith_FireEvents_adminOrTenantOneStoreUserOne, final String testCasesWith_FireEvents_adminOrTenantOneStoreUserOnePassword, final String testCasesWith_FireEvents_apiName, final String testCasesWith_FireEvents_apiVersion, final String testCasesWith_FireEvents_apiTagName, final String testCasesWith_FireEvents_apiContext, final String testCasesWith_FireEvents_downImag, final String testCasesWith_FireEvents_downloadFilePathSwagger, final String testCasesWith_FireEvents_downloadFilePathJson, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//APIM2-731: Download swagger definition in JSON formal
    	writeToReport("Start Executing APIM-731");
    	//loging to publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,testCasesWith_FireEvents_adminOrTenantOnePublisherUserOne,testCasesWith_FireEvents_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	//Create sample API
    	lib_Common.bc_CreateAPI_DesignStage(this, testCasesWith_FireEvents_apiName,testCasesWith_FireEvents_apiContext,testCasesWith_FireEvents_apiVersion,testCasesWith_FireEvents_apiTagName,pauseTimes_twoSeconds,pauseTimes_sixSeconds);
    	//retrieving API name
    	String varAPIName_APIM_731 = retrieveString("var_APIName");
    	//click on API
    	click("APIPublisherHome.lnk_APIs");
    	//waiting for content load
    	pause(pauseTimes_sixSeconds);
    	waitForElement("APIPublisherHome.tf_APISearch",pauseTimes_sixSeconds);
    	pause(pauseTimes_sixSeconds);
    	type("APIPublisherHome.tf_APISearch",varAPIName_APIM_731);
    	//waiting for content load
    	waitForElement("APIPublisherHome.btn_Search",pauseTimes_sixSeconds);
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherHome.btn_Search");
    	//waiting for content load
    	pause(pauseTimes_sixSeconds);
    	waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPIName_APIM_731,pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPIName_APIM_731);
    	//click on edit
    	click("APIPublisherBrowse.lnk_Edit");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.btn_EditSource",pauseTimes_sixSeconds);
    	//click on edit source
    	clickAt("APIPublisherBrowse.btn_EditSource","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.frm_SwaggerEditIframe",pauseTimes_sixSeconds);
    	selectFrame("APIPublisherBrowse.frm_SwaggerEditIframe");
    	//select downlaod JSON
    	click("APIPublisherBrowse.btn_SwaggerFile");
    	click("APIPublisherBrowse.btn_DownloadJSON");
    	pause(pauseTimes_sixSeconds);
    	//Handling popup for fire fox browser
    	String downImagePopup1 = testCasesWith_FireEvents_downImag;
    	if(checkImagePresent(downImagePopup1,false)){
    	fireEvent("KEY%key=alt+s",pauseTimes_fourSeconds);
    	/*
    	FireEvent
    	  event=KEY%key=alt+a
    	  waitTime=@pauseTimes_fourSeconds
    	*/
    	fireEvent("KEY%key=\n",pauseTimes_fourSeconds);
    	}
    	pause(pauseTimes_sixSeconds);
    	//Check downloaded file
    	checkFileInfo(testCasesWith_FireEvents_downloadFilePathJson,"EXIST",false,"");
    	int temp = 0;java.io.File f = new java.io.File(testCasesWith_FireEvents_downloadFilePathJson);f.delete();;
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_fourSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End Executing APIM-731");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}