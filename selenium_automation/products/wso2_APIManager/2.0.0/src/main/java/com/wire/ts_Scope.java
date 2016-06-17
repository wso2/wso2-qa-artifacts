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
 *  Class ts_Scope implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_Scope extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APIM_762.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_762")
    public Object[][] dataTable_tc_APIM_762() {     	
    	return this.getDataTable("keyWords","pauseTimes","URLs","scope");
    }

    /**
     * Data driven test case tc_APIM_762.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_762")
    public final void tc_APIM_762(final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String scope_domain, final String scope_adminOrTenantOnePublisherUserOne, final String scope_adminOrTenantOnePublisherOnePassword, final String scope_APIImagePath, final String scope_ProductionEndPontJaxRS, final String scope_sandboxEndPointJaxRS, final String scope_URLPattern, final String scope_verbMethodGET, final String scope_verbMethodPOST, final String scope_verbMethodPUT, final String scope_verbMethodDELETE, final String scope_userAdmin, final String scope_AdminPasswd, final String scope_roleName, final String scope_scopeKeyOne, final String scope_tag, final String scope_scopeNameOne, final String scope_scopeKeyTwo, final String scope_scopeNameTwo, final String scope_scopeKeyThree, final String scope_scopeNameThree, final String scope_scopeKeyFour, final String scope_scopeNameFour, final String scope_InvalidKey, final String scope_ScopeDescription, final String scope_ScopeKeyFive, final String scope_ScopeNameFive, final String scope_ScopeKeySix, final String scope_ScopeNameSix, final String scope_scopeKeySeven, final String scope_scopeNameSeven, final String scope_APIName, final String scope_APIContest) throws Exception {	
    	//APIM-762: Check whether compulsory fields are marked with a red star.
    	writeToReport("Start of executing APIM_762");
    	//Start of precondition
    	//Login to publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,scope_adminOrTenantOnePublisherUserOne,scope_adminOrTenantOnePublisherOnePassword,pauseTimes_fourSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	String APIversion = "v1.0."+generateData("int",1);
    	lib_Common.bc_CreateAPI_DesignStage(this, scope_APIName,scope_APIContest,APIversion,scope_tag,pauseTimes_twoSeconds,pauseTimes_sixSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.lnk_NextImplement",pauseTimes_eightSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	//check the load time
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	lib_Common.bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(this, scope_ProductionEndPontJaxRS,keyWords_keyWordNo,"",keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	//End of precondition
    	waitForElement("Scopes.btn_AddScope",pauseTimes_twelveSeconds);
    	click("Scopes.btn_AddScope");
    	checkElementPresent("Scopes.ele_lblscopeKeyRequiredAstrix",false,"");
    	checkElementPresent("Scopes.ele_lblScopeNameRequiredAstrix",false,"");
    	waitForElement("Scopes.btn_Close",pauseTimes_eightSeconds);
    	click("Scopes.btn_Close");
    	writeToReport("End of Execution APIM_762");
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    } 
    	

    /**
     * Data provider for Test case tc_APIM_763.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_763")
    public Object[][] dataTable_tc_APIM_763() {     	
    	return this.getDataTable("keyWords","pauseTimes","URLs","scope");
    }

    /**
     * Data driven test case tc_APIM_763.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_763")
    public final void tc_APIM_763(final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String scope_domain, final String scope_adminOrTenantOnePublisherUserOne, final String scope_adminOrTenantOnePublisherOnePassword, final String scope_APIImagePath, final String scope_ProductionEndPontJaxRS, final String scope_sandboxEndPointJaxRS, final String scope_URLPattern, final String scope_verbMethodGET, final String scope_verbMethodPOST, final String scope_verbMethodPUT, final String scope_verbMethodDELETE, final String scope_userAdmin, final String scope_AdminPasswd, final String scope_roleName, final String scope_scopeKeyOne, final String scope_tag, final String scope_scopeNameOne, final String scope_scopeKeyTwo, final String scope_scopeNameTwo, final String scope_scopeKeyThree, final String scope_scopeNameThree, final String scope_scopeKeyFour, final String scope_scopeNameFour, final String scope_InvalidKey, final String scope_ScopeDescription, final String scope_ScopeKeyFive, final String scope_ScopeNameFive, final String scope_ScopeKeySix, final String scope_ScopeNameSix, final String scope_scopeKeySeven, final String scope_scopeNameSeven, final String scope_APIName, final String scope_APIContest) throws Exception {	
    	//APIM-763: User should be able to add scopes in the manage stage when creating an API
    	writeToReport("Start of executing APIM_763");
    	//Start of precondition
    	//Login to publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,scope_adminOrTenantOnePublisherUserOne,scope_adminOrTenantOnePublisherOnePassword,pauseTimes_fourSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	String APIversion = "v1.0."+generateData("int",1);
    	lib_Common.bc_CreateAPI_DesignStage(this, scope_APIName,scope_APIContest,APIversion,scope_tag,pauseTimes_twoSeconds,pauseTimes_sixSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.lnk_NextImplement",pauseTimes_eightSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	//check the load time
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	lib_Common.bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(this, scope_ProductionEndPontJaxRS,keyWords_keyWordNo,"",keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	//End of precondition
    	//*******************************************************
    	waitForElement("Scopes.btn_AddScope",pauseTimes_tenSeconds);
    	lib_Common.bc_SelectTiers(this, pauseTimes_sixSeconds);
    	//set varibles
    	String varScopeKeyOne = scope_scopeKeyOne+generateData("int",3);
    	String varScopeNameOne = scope_scopeNameOne+generateData("int",3);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	click("Scopes.btn_AddScope");
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	//Type scope key
    	type("Scopes.tf_ScopeKey",varScopeKeyOne);
    	//Type scope name
    	type("Scopes.tf_ScopeName",varScopeNameOne);
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_eightSeconds);
    	click("Scopes.btn_SubmitScope");
    	//save API and again check manage page using edit view. Added scope should be visible successfully.
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyOne,false,"");
    	click("APIPublisherBrowse.btn_Save1");
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyOne,false,"");
    	writeToReport("End of Execution APIM_763");
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    } 
    	

    /**
     * Data provider for Test case tc_APIM_764.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_764")
    public Object[][] dataTable_tc_APIM_764() {     	
    	return this.getDataTable("keyWords","pauseTimes","URLs","scope");
    }

    /**
     * Data driven test case tc_APIM_764.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_764")
    public final void tc_APIM_764(final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String scope_domain, final String scope_adminOrTenantOnePublisherUserOne, final String scope_adminOrTenantOnePublisherOnePassword, final String scope_APIImagePath, final String scope_ProductionEndPontJaxRS, final String scope_sandboxEndPointJaxRS, final String scope_URLPattern, final String scope_verbMethodGET, final String scope_verbMethodPOST, final String scope_verbMethodPUT, final String scope_verbMethodDELETE, final String scope_userAdmin, final String scope_AdminPasswd, final String scope_roleName, final String scope_scopeKeyOne, final String scope_tag, final String scope_scopeNameOne, final String scope_scopeKeyTwo, final String scope_scopeNameTwo, final String scope_scopeKeyThree, final String scope_scopeNameThree, final String scope_scopeKeyFour, final String scope_scopeNameFour, final String scope_InvalidKey, final String scope_ScopeDescription, final String scope_ScopeKeyFive, final String scope_ScopeNameFive, final String scope_ScopeKeySix, final String scope_ScopeNameSix, final String scope_scopeKeySeven, final String scope_scopeNameSeven, final String scope_APIName, final String scope_APIContest) throws Exception {	
    	//APIM-764: Check whether user can add scope to a created API using edit view.
    	writeToReport("Start of executing APIM_764");
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,scope_adminOrTenantOnePublisherUserOne,scope_adminOrTenantOnePublisherOnePassword,pauseTimes_fourSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	String APIversion = "v1.0."+generateData("int",1);
    	lib_Common.bc_CreateAPI_DesignStage(this, scope_APIName,scope_APIContest,APIversion,scope_tag,pauseTimes_twoSeconds,pauseTimes_sixSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.lnk_NextImplement",pauseTimes_eightSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	//check the load time
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	lib_Common.bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(this, scope_ProductionEndPontJaxRS,keyWords_keyWordNo,"",keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	lib_Common.bc_SelectTiers(this, pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.btn_SaveManageAPI");
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	click("APIPublisherBrowse.btn_SaveAndPublish");
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	checkElementPresent("APIPublisherBrowse.btn_Close",false,"");
    	waitForElement("APIPublisherBrowse.btn_Close",pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.btn_Close");
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordFalse,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordFalse);
    	click("APIPublisherHome.lnk_APIs");
    	String varAPINameOne = retrieveString("var_APIName");
    	lib_Common.bc_APIPublisherSearch(this, varAPINameOne,varAPINameOne,APIversion,pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameOne + "_PARAM," + "param_APIVersion_PARAM:" + APIversion + "_PARAM," + "param_APIName_PARAM:" + varAPINameOne);
    	waitForElement("APIPublisherBrowse.lnk_Edit",pauseTimes_eightSeconds);
    	click("APIPublisherBrowse.lnk_Edit");
    	//waiting for content load
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.lnk_NextImplement",pauseTimes_eightSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	//check the load time
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	waitForElement("APIPublisherAdd.lnk_NextManage",pauseTimes_tenSeconds);
    	click("APIPublisherAdd.lnk_NextManage");
    	String varScopeKeyOne = scope_scopeKeyOne+generateData("int",3);
    	String varScopeNameOne = scope_scopeNameOne+generateData("int",3);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	click("Scopes.btn_AddScope");
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	//Type scope key
    	type("Scopes.tf_ScopeKey",varScopeKeyOne);
    	//Type scope name
    	type("Scopes.tf_ScopeName",varScopeNameOne);
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_eightSeconds);
    	click("Scopes.btn_SubmitScope");
    	//save API and again check manage page using edit view. Added scope should be visible successfully.
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyOne,false,"");
    	click("APIPublisherBrowse.btn_Save1");
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyOne,false,"");
    	writeToReport("End of executing APIM_764");
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    } 
    	

    /**
     * Data provider for Test case tc_APIM_765.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_765")
    public Object[][] dataTable_tc_APIM_765() {     	
    	return this.getDataTable("keyWords","pauseTimes","URLs","scope");
    }

    /**
     * Data driven test case tc_APIM_765.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_765")
    public final void tc_APIM_765(final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String scope_domain, final String scope_adminOrTenantOnePublisherUserOne, final String scope_adminOrTenantOnePublisherOnePassword, final String scope_APIImagePath, final String scope_ProductionEndPontJaxRS, final String scope_sandboxEndPointJaxRS, final String scope_URLPattern, final String scope_verbMethodGET, final String scope_verbMethodPOST, final String scope_verbMethodPUT, final String scope_verbMethodDELETE, final String scope_userAdmin, final String scope_AdminPasswd, final String scope_roleName, final String scope_scopeKeyOne, final String scope_tag, final String scope_scopeNameOne, final String scope_scopeKeyTwo, final String scope_scopeNameTwo, final String scope_scopeKeyThree, final String scope_scopeNameThree, final String scope_scopeKeyFour, final String scope_scopeNameFour, final String scope_InvalidKey, final String scope_ScopeDescription, final String scope_ScopeKeyFive, final String scope_ScopeNameFive, final String scope_ScopeKeySix, final String scope_ScopeNameSix, final String scope_scopeKeySeven, final String scope_scopeNameSeven, final String scope_APIName, final String scope_APIContest) throws Exception {	
    	//APIM-765: Check whether user gets a validation message for empty compulsory fields.
    	writeToReport("Start of TC APIM_765");
    	//Login to publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,scope_adminOrTenantOnePublisherUserOne,scope_adminOrTenantOnePublisherOnePassword,pauseTimes_fourSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	String APIversion = "v1.0."+generateData("int",1);
    	lib_Common.bc_CreateAPI_DesignStage(this, scope_APIName,scope_APIContest,APIversion,scope_tag,pauseTimes_twoSeconds,pauseTimes_sixSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.lnk_NextImplement",pauseTimes_eightSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	//check the load time
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	lib_Common.bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(this, scope_ProductionEndPontJaxRS,keyWords_keyWordNo,"",keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	//End of precondition
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	waitForElement("Scopes.btn_AddScope",pauseTimes_twelveSeconds);
    	pause(pauseTimes_threeSeconds);
    	click("Scopes.btn_AddScope");
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_fiveSeconds);
    	pause(pauseTimes_threeSeconds);
    	click("Scopes.btn_SubmitScope");
    	//Verify the Field Errors
    	checkElementPresent("Scopes.ele_lblRequiredFieldError",false,"");
    	waitForElement("Scopes.ele_lblRequiredFieldError2",pauseTimes_eightSeconds);
    	checkElementPresent("Scopes.ele_lblRequiredFieldError2",false,"");
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	String varScopeKeySeven = scope_scopeKeyOne+generateData("int",2);
    	//give only scope key and click on 'add scope' button. User should get compulsory field validation message for scope name and roles.
    	type("Scopes.tf_ScopeKey",varScopeKeySeven);
    	click("Scopes.btn_SubmitScope");
    	checkElementPresent("Scopes.ele_lblRequiredFieldErrorScomeName",false,"");
    	/*
    	CheckElementPresent
    	 object=Scopes.ele_lblRequiredFieldError2
    	 stopOnFailure=false
    	 customErrorMessage=
    	*/
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	//Give scope key, scope name and click 'add scope' button. User should get a compulsory field validation error for roles field.
    	type("Scopes.tf_ScopeKey",varScopeKeySeven);
    	waitForElement("Scopes.tf_ScopeName",pauseTimes_eightSeconds);
    	String varScopeNameSeven = scope_scopeKeyOne+generateData("int",2);
    	//Give scope ey, scope name and roles and click 'add scope' button User should be able to successfully add scope and added scope with given information should be listed above 'add scopes' button.
    	type("Scopes.tf_ScopeName",varScopeNameSeven);
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_eightSeconds);
    	click("Scopes.btn_SubmitScope");
    	//Verify Submitted Scopes
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeySeven,false,"");
    	waitForElement("Scopes.btn_Close",pauseTimes_eightSeconds);
    	click("Scopes.btn_Close");
    	writeToReport("End of TC APIM_765");
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    } 
    	

    /**
     * Data provider for Test case tc_APIM_766.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_766")
    public Object[][] dataTable_tc_APIM_766() {     	
    	return this.getDataTable("keyWords","pauseTimes","URLs","scope");
    }

    /**
     * Data driven test case tc_APIM_766.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_766")
    public final void tc_APIM_766(final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String scope_domain, final String scope_adminOrTenantOnePublisherUserOne, final String scope_adminOrTenantOnePublisherOnePassword, final String scope_APIImagePath, final String scope_ProductionEndPontJaxRS, final String scope_sandboxEndPointJaxRS, final String scope_URLPattern, final String scope_verbMethodGET, final String scope_verbMethodPOST, final String scope_verbMethodPUT, final String scope_verbMethodDELETE, final String scope_userAdmin, final String scope_AdminPasswd, final String scope_roleName, final String scope_scopeKeyOne, final String scope_tag, final String scope_scopeNameOne, final String scope_scopeKeyTwo, final String scope_scopeNameTwo, final String scope_scopeKeyThree, final String scope_scopeNameThree, final String scope_scopeKeyFour, final String scope_scopeNameFour, final String scope_InvalidKey, final String scope_ScopeDescription, final String scope_ScopeKeyFive, final String scope_ScopeNameFive, final String scope_ScopeKeySix, final String scope_ScopeNameSix, final String scope_scopeKeySeven, final String scope_scopeNameSeven, final String scope_APIName, final String scope_APIContest) throws Exception {	
    	//APIM-766: Check whether user gets an validation message when trying to add scopes with duplicate key.
    	writeToReport("Start of Execution APIM_766");
    	//Start of precondition
    	//Login to publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,scope_adminOrTenantOnePublisherUserOne,scope_adminOrTenantOnePublisherOnePassword,pauseTimes_fourSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	String APIversion = "v1.0."+generateData("int",1);
    	lib_Common.bc_CreateAPI_DesignStage(this, scope_APIName,scope_APIContest,APIversion,scope_tag,pauseTimes_twoSeconds,pauseTimes_sixSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.lnk_NextImplement",pauseTimes_eightSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	//check the load time
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	lib_Common.bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(this, scope_ProductionEndPontJaxRS,keyWords_keyWordNo,"",keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	waitForElement("Scopes.btn_AddScope",pauseTimes_tenSeconds);
    	lib_Common.bc_SelectTiers(this, pauseTimes_sixSeconds);
    	//set varibles
    	String varScopeKeyOne = scope_scopeKeyOne+generateData("int",3);
    	String varScopeNameOne = scope_scopeNameOne+generateData("int",3);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	click("Scopes.btn_AddScope");
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	//Type scope key
    	type("Scopes.tf_ScopeKey",varScopeKeyOne);
    	//Type scope name
    	type("Scopes.tf_ScopeName",varScopeNameOne);
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_eightSeconds);
    	click("Scopes.btn_SubmitScope");
    	//save API and again check manage page using edit view. Added scope should be visible successfully.
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyOne,false,"");
    	pause(pauseTimes_threeSeconds);
    	click("Scopes.btn_AddScope");
    	//End of precondition
    	String varScopeNameTwo = scope_scopeNameOne+generateData("int",2);
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	type("Scopes.tf_ScopeKey",varScopeKeyOne);
    	type("Scopes.tf_ScopeName",varScopeNameTwo);
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_eightSeconds);
    	click("Scopes.btn_SubmitScope");
    	//Give duplicate scope key and scope name, specify rolse and description and click 'add scope' User should get a validation message saying scope already exists or similar.
    	checkElementPresent("Scopes.ele_lblAlreadyExistError","scopeKey_PARAM:" + varScopeKeyOne,false,"");
    	waitForElement("Scopes.btn_OK",pauseTimes_nineSeconds);
    	click("Scopes.btn_OK");
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_threeSeconds);
    	writeToReport("endTestCase");
    	writeToReport("End of Execution APIM_766");
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    } 
    	

    /**
     * Data provider for Test case tc_APIM_767.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_767")
    public Object[][] dataTable_tc_APIM_767() {     	
    	return this.getDataTable("keyWords","pauseTimes","URLs","scope");
    }

    /**
     * Data driven test case tc_APIM_767.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_767")
    public final void tc_APIM_767(final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String scope_domain, final String scope_adminOrTenantOnePublisherUserOne, final String scope_adminOrTenantOnePublisherOnePassword, final String scope_APIImagePath, final String scope_ProductionEndPontJaxRS, final String scope_sandboxEndPointJaxRS, final String scope_URLPattern, final String scope_verbMethodGET, final String scope_verbMethodPOST, final String scope_verbMethodPUT, final String scope_verbMethodDELETE, final String scope_userAdmin, final String scope_AdminPasswd, final String scope_roleName, final String scope_scopeKeyOne, final String scope_tag, final String scope_scopeNameOne, final String scope_scopeKeyTwo, final String scope_scopeNameTwo, final String scope_scopeKeyThree, final String scope_scopeNameThree, final String scope_scopeKeyFour, final String scope_scopeNameFour, final String scope_InvalidKey, final String scope_ScopeDescription, final String scope_ScopeKeyFive, final String scope_ScopeNameFive, final String scope_ScopeKeySix, final String scope_ScopeNameSix, final String scope_scopeKeySeven, final String scope_scopeNameSeven, final String scope_APIName, final String scope_APIContest) throws Exception {	
    	//APIM-767: Check whether user can exit from the define scope window by clicking on the 'x' sign on the window
    	writeToReport("Start of executing APIM_767");
    	//Start of precondition
    	//Login to publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,scope_adminOrTenantOnePublisherUserOne,scope_adminOrTenantOnePublisherOnePassword,pauseTimes_fourSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	String APIversion = "v1.0."+generateData("int",1);
    	lib_Common.bc_CreateAPI_DesignStage(this, scope_APIName,scope_APIContest,APIversion,scope_tag,pauseTimes_twoSeconds,pauseTimes_sixSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.lnk_NextImplement",pauseTimes_eightSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	//check the load time
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	lib_Common.bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(this, scope_ProductionEndPontJaxRS,keyWords_keyWordNo,"",keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	waitForElement("Scopes.btn_AddScope",pauseTimes_tenSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//End of precondition
    	click("Scopes.btn_AddScope");
    	waitForElement("Scopes.btn_topXClose",pauseTimes_eightSeconds);
    	click("Scopes.btn_topXClose");
    	waitForElement("Scopes.ele_lblResources",pauseTimes_eightSeconds);
    	checkElementPresent("Scopes.ele_lblResources",false,"");
    	writeToReport("End of Execution APIM_767");
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    } 
    	

    /**
     * Data provider for Test case tc_APIM_768.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_768")
    public Object[][] dataTable_tc_APIM_768() {     	
    	return this.getDataTable("keyWords","pauseTimes","URLs","scope");
    }

    /**
     * Data driven test case tc_APIM_768.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_768")
    public final void tc_APIM_768(final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String scope_domain, final String scope_adminOrTenantOnePublisherUserOne, final String scope_adminOrTenantOnePublisherOnePassword, final String scope_APIImagePath, final String scope_ProductionEndPontJaxRS, final String scope_sandboxEndPointJaxRS, final String scope_URLPattern, final String scope_verbMethodGET, final String scope_verbMethodPOST, final String scope_verbMethodPUT, final String scope_verbMethodDELETE, final String scope_userAdmin, final String scope_AdminPasswd, final String scope_roleName, final String scope_scopeKeyOne, final String scope_tag, final String scope_scopeNameOne, final String scope_scopeKeyTwo, final String scope_scopeNameTwo, final String scope_scopeKeyThree, final String scope_scopeNameThree, final String scope_scopeKeyFour, final String scope_scopeNameFour, final String scope_InvalidKey, final String scope_ScopeDescription, final String scope_ScopeKeyFive, final String scope_ScopeNameFive, final String scope_ScopeKeySix, final String scope_ScopeNameSix, final String scope_scopeKeySeven, final String scope_scopeNameSeven, final String scope_APIName, final String scope_APIContest) throws Exception {	
    	//APIM-768: Check whether scopes get loaded successfully into the scope selection drop down in front of resource
    	writeToReport("Start of executing APIM_768");
    	//Start of Precondition
    	//Start of precondition
    	//Login to publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,scope_adminOrTenantOnePublisherUserOne,scope_adminOrTenantOnePublisherOnePassword,pauseTimes_fourSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	String APIversion = "v1.0."+generateData("int",1);
    	lib_Common.bc_CreateAPI_DesignStage(this, scope_APIName,scope_APIContest,APIversion,scope_tag,pauseTimes_twoSeconds,pauseTimes_sixSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.lnk_NextImplement",pauseTimes_eightSeconds);
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	//check the load time
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	lib_Common.bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(this, scope_ProductionEndPontJaxRS,keyWords_keyWordNo,"",keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	//End of precondition
    	waitForElement("Scopes.btn_AddScope",pauseTimes_tenSeconds);
    	//scope one
    	String varScopeKeyOne = scope_scopeKeyOne+generateData("int",3);
    	String varScopeNameOne = scope_scopeNameOne+generateData("int",3);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	click("Scopes.btn_AddScope");
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	//Type scope key
    	type("Scopes.tf_ScopeKey",varScopeKeyOne);
    	//Type scope name
    	type("Scopes.tf_ScopeName",varScopeNameOne);
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_eightSeconds);
    	click("Scopes.btn_SubmitScope");
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyOne,false,"");
    	//scope two
    	String varScopeKeyTwo = scope_scopeKeyTwo+generateData("int",3);
    	String varScopeNameTwo = scope_scopeNameTwo+generateData("int",3);
    	click("Scopes.btn_AddScope");
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	//Type scope key
    	type("Scopes.tf_ScopeKey",varScopeKeyTwo);
    	//Type scope name
    	type("Scopes.tf_ScopeName",varScopeNameTwo);
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_eightSeconds);
    	click("Scopes.btn_SubmitScope");
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyTwo,false,"");
    	//scope three
    	String varScopeKeyThree = scope_scopeKeyThree+generateData("int",3);
    	String varScopeNameThree = scope_scopeNameThree+generateData("int",3);
    	click("Scopes.btn_AddScope");
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	//Type scope key
    	type("Scopes.tf_ScopeKey",varScopeKeyThree);
    	//Type scope name
    	type("Scopes.tf_ScopeName",varScopeNameThree);
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_eightSeconds);
    	click("Scopes.btn_SubmitScope");
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyThree,false,"");
    	//scope Four
    	String varScopeKeyFour = scope_scopeKeyFour+generateData("int",3);
    	String varScopeNameFour = scope_scopeNameFour+generateData("int",3);
    	click("Scopes.btn_AddScope");
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	//Type scope key
    	type("Scopes.tf_ScopeKey",varScopeKeyFour);
    	//Type scope name
    	type("Scopes.tf_ScopeName",varScopeNameFour);
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_eightSeconds);
    	click("Scopes.btn_SubmitScope");
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyFour,false,"");
    	//scope Five
    	String varScopeKeyFive = scope_ScopeKeyFive+generateData("int",3);
    	String varScopeNameFive = scope_ScopeNameFive+generateData("int",3);
    	click("Scopes.btn_AddScope");
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	//Type scope key
    	type("Scopes.tf_ScopeKey",varScopeKeyFive);
    	//Type scope name
    	type("Scopes.tf_ScopeName",varScopeNameFive);
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_eightSeconds);
    	click("Scopes.btn_SubmitScope");
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyFive,false,"");
    	//scope Six
    	String varScopeKeySix = scope_ScopeKeySix+generateData("int",3);
    	String varScopeNameSix = scope_ScopeNameSix+generateData("int",3);
    	click("Scopes.btn_AddScope");
    	waitForElement("Scopes.tf_ScopeKey",pauseTimes_eightSeconds);
    	//Type scope key
    	type("Scopes.tf_ScopeKey",varScopeKeySix);
    	//Type scope name
    	type("Scopes.tf_ScopeName",varScopeNameSix);
    	waitForElement("Scopes.btn_SubmitScope",pauseTimes_eightSeconds);
    	click("Scopes.btn_SubmitScope");
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeySix,false,"");
    	//End of precondition
    	/*
    	Retrieve
    	 key=keyScopeKeyOne
    	 var=varScopeKeyOne
    	 type=String
    	Retrieve
    	 key=keyScopeOne
    	 var=varScopeNameOne
    	 type=String
    	Retrieve
    	 key=keyScopeTwo
    	 var=varScopeNameTwo
    	 type=String
    	Retrieve
    	 key=keyScopeThree
    	 var=varScopeNameThree
    	 type=String
    	Retrieve
    	 key=keyScopeFour
    	 var=varScopeNameFour
    	 type=String
    	Retrieve
    	 key=keyScopeFive
    	 var=varScopeNameFive
    	 type=String
    	Retrieve
    	 key=keyScopeName
    	 var=varScopeNameSix
    	 type=String
    	*/
    	waitForElement("Scopes.btn_Scope","param_verbMethodName_PARAM:" + keyWords_keyWordPost,pauseTimes_twelveSeconds);
    	click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + keyWords_keyWordPost);
    	//Verify already added Scope names
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameOne,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameTwo,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameThree,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFour,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFive,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameSix,false,"");
    	/*
    	CheckObjectProperty
    	 object=Scopes.ele_ddScope
    	 propertyname=ALLOPTIONS
    	 expectedValue=varScopeNameOne,varScopeNameTwo,varScopeNameThree,varScopeNameFour,varScopeNameFive,varScopeNameSix
    	 stopOnFailure=false
    	 customErrorMessage=
    	*/
    	click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + keyWords_keyWordPut);
    	//Verify already added Scope names
    	click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + keyWords_keyWordPost);
    	//Verify already added Scope names
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameOne,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameTwo,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameThree,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFour,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFive,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameSix,false,"");
    	/*
    	CheckObjectProperty
    	 object=Scopes.ele_ddScope
    	 propertyname=ALLOPTIONS
    	 expectedValue=varScopeNameOne,varScopeNameTwo,varScopeNameThree,varScopeNameFour,varScopeNameFive,varScopeNameSix
    	 stopOnFailure=false
    	 customErrorMessage=
    	*/
    	click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + keyWords_keyWordGet);
    	//Verify already added Scope names
    	click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + keyWords_keyWordPost);
    	//Verify already added Scope names
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameOne,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameTwo,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameThree,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFour,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFive,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameSix,false,"");
    	/*
    	CheckObjectProperty
    	 object=Scopes.ele_ddScope
    	 propertyname=ALLOPTIONS
    	 expectedValue=varScopeNameOne,varScopeNameTwo,varScopeNameThree,varScopeNameFour,varScopeNameFive,varScopeNameSix
    	 stopOnFailure=false
    	 customErrorMessage=
    	*/
    	click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + keyWords_keyWordDelete);
    	//Verify already added Scope names
    	click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + keyWords_keyWordPost);
    	//Verify already added Scope names
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameOne,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameTwo,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameThree,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFour,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFive,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameSix,false,"");
    	/*
    	CheckObjectProperty
    	 object=Scopes.ele_ddScope
    	 propertyname=ALLOPTIONS
    	 expectedValue=varScopeNameOne,varScopeNameTwo,varScopeNameThree,varScopeNameFour,varScopeNameFive,varScopeNameSix
    	 stopOnFailure=false
    	 customErrorMessage=
    	*/
    	click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + keyWords_keyWordPatch);
    	//Verify already added Scope names
    	click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + keyWords_keyWordPost);
    	//Verify already added Scope names
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameOne,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameTwo,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameThree,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFour,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFive,false,"");
    	checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameSix,false,"");
    	/*
    	CheckObjectProperty
    	 object=Scopes.ele_ddScope
    	 propertyname=ALLOPTIONS
    	 expectedValue=varScopeNameOne,varScopeNameTwo,varScopeNameThree,varScopeNameFour,varScopeNameFive,varScopeNameSix
    	 stopOnFailure=false
    	 customErrorMessage=
    	*/
    	writeToReport("End of Execution APIM_768");
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    } 
    	

    /**
     * Data provider for Test case tc_APIM_769.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_769")
    public Object[][] dataTable_tc_APIM_769() {     	
    	return this.getDataTable("keyWords","pauseTimes","URLs","scope");
    }

    /**
     * Data driven test case tc_APIM_769.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_769")
    public final void tc_APIM_769(final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String scope_domain, final String scope_adminOrTenantOnePublisherUserOne, final String scope_adminOrTenantOnePublisherOnePassword, final String scope_APIImagePath, final String scope_ProductionEndPontJaxRS, final String scope_sandboxEndPointJaxRS, final String scope_URLPattern, final String scope_verbMethodGET, final String scope_verbMethodPOST, final String scope_verbMethodPUT, final String scope_verbMethodDELETE, final String scope_userAdmin, final String scope_AdminPasswd, final String scope_roleName, final String scope_scopeKeyOne, final String scope_tag, final String scope_scopeNameOne, final String scope_scopeKeyTwo, final String scope_scopeNameTwo, final String scope_scopeKeyThree, final String scope_scopeNameThree, final String scope_scopeKeyFour, final String scope_scopeNameFour, final String scope_InvalidKey, final String scope_ScopeDescription, final String scope_ScopeKeyFive, final String scope_ScopeNameFive, final String scope_ScopeKeySix, final String scope_ScopeNameSix, final String scope_scopeKeySeven, final String scope_scopeNameSeven, final String scope_APIName, final String scope_APIContest) throws Exception {	
    	//APIM-769: Check whether user can exit from the define scope window by clicking close button
    	writeToReport("Start of executing APIM_769");
    	//Start of precondition
    	//Login to publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,scope_adminOrTenantOnePublisherUserOne,scope_adminOrTenantOnePublisherOnePassword,pauseTimes_fourSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	String APIversion = "v1.0."+generateData("int",1);
    	lib_Common.bc_CreateAPI_DesignStage(this, scope_APIName,scope_APIContest,APIversion,scope_tag,pauseTimes_twoSeconds,pauseTimes_sixSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.lnk_NextImplement",pauseTimes_eightSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	//check the load time
    	for(int TotalCount=5;TotalCount>0;TotalCount--){
    	if(!checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
    	TotalCount = 0;
    	break;
    	} else {
    	if(TotalCount==1){
    	fail("Load Time Was Above Fifteen Seconds");
    	}
    	}
    	pause(pauseTimes_threeSeconds);
    	}
    	lib_Common.bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(this, scope_ProductionEndPontJaxRS,keyWords_keyWordNo,"",keyWords_keyWordNo,"",pauseTimes_threeSeconds,pauseTimes_fourSeconds,pauseTimes_sixSeconds,pauseTimes_eightSeconds);
    	waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,pauseTimes_nineSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	waitForElement("Scopes.btn_AddScope",pauseTimes_tenSeconds);
    	click("Scopes.btn_AddScope");
    	checkElementPresent("Scopes.tf_ScopeKey",false,"");
    	//End of precondition
    	pause(pauseTimes_threeSeconds);
    	//wait for load
    	waitForElement("Scopes.btn_Close",pauseTimes_sixSeconds);
    	click("Scopes.btn_Close");
    	//Verify navigate to manage section
    	checkElementPresent("APIPublisherAdd.btn_SavePublish",false,"");
    	writeToReport("End of executing APIM_769");
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}