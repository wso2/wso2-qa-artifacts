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
 *  Class ts_APIDocumentation_DocumentVisibility implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APIDocumentation_DocumentVisibility extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APIM_1011.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_1011")
    public Object[][] dataTable_tc_APIM_1011() {     	
    	return this.getDataTable("pauseTimes","APIDocumentation_DocumentVisibility","URLs");
    }

    /**
     * Data driven test case tc_APIM_1011.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_1011")
    public final void tc_APIM_1011(final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String APIDocumentation_DocumentVisibility_domain, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwoPassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwoPassword, final String APIDocumentation_DocumentVisibility_APIName, final String APIDocumentation_DocumentVisibility_APINameOne, final String APIDocumentation_DocumentVisibility_APIVersion, final String APIDocumentation_DocumentVisibility_APITagName, final String APIDocumentation_DocumentVisibility_APIContext, final String APIDocumentation_DocumentVisibility_DocName, final String APIDocumentation_DocumentVisibility_DocVisibilitySameAsAPI, final String APIDocumentation_DocumentVisibility_DocVisibilityPrivate, final String APIDocumentation_DocumentVisibility_DocVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_APIVisibilityPublic, final String APIDocumentation_DocumentVisibility_APIVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_sandboxEndPoint, final String APIDocumentation_DocumentVisibility_productionEndPoint, final String APIDocumentation_DocumentVisibility_tenantOne, final String APIDocumentation_DocumentVisibility_tenantTwo, final String APIDocumentation_DocumentVisibility_imageName, final String APIDocumentation_DocumentVisibility_tagName, final String APIDocumentation_DocumentVisibility_keyWordDoc, final String APIDocumentation_DocumentVisibility_documentNameDocOne, final String APIDocumentation_DocumentVisibility_documentSummeryDocOne, final String APIDocumentation_DocumentVisibility_keyWordViewContent, final String APIDocumentation_DocumentVisibility_searchForDocumentKeyWordHello, final String APIDocumentation_DocumentVisibility_noMatchingResults, final String APIDocumentation_DocumentVisibility_keyWordAnonimous, final String APIDocumentation_DocumentVisibility_docSearchKeyWord, final String APIDocumentation_DocumentVisibility_docSearchKeyWordTwo, final String APIDocumentation_DocumentVisibility_SourceURL, final String APIDocumentation_DocumentVisibility_docSearchKeyWordThree, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//User searches without specifying a search term.
    	writeToReport("Start of excecuting APIM-1011");
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	lib_Common.bc_CreateAndPublishAPINew(this, APIDocumentation_DocumentVisibility_APIName,APIDocumentation_DocumentVisibility_APIContext,APIDocumentation_DocumentVisibility_APIVersion,APIDocumentation_DocumentVisibility_imageName,APIDocumentation_DocumentVisibility_APITagName,APIDocumentation_DocumentVisibility_productionEndPoint,APIDocumentation_DocumentVisibility_sandboxEndPoint,pauseTimes_twoSeconds,pauseTimes_sixSeconds,pauseTimes_fourSeconds);
    	pause(pauseTimes_sixSeconds);
    	waitForElement("APIPublisherHome.lnk_APIs",pauseTimes_twoSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	waitForElement("APIPublisherHome.tf_APISearch",pauseTimes_twoSeconds);
    	type("APIPublisherHome.tf_APISearch",APIDocumentation_DocumentVisibility_keyWordDoc);
    	click("APIPublisherHome.btn_Search");
    	checkElementPresent("APIPublisherHome.ele_lblSearchTermMissing",false,"");
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_threeSeconds);
    	lib_Common.bc_SelectServer(this, APIDocumentation_DocumentVisibility_domain);
    	lib_Common.bc_Login_APIStore(this, APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOnePassword,pauseTimes_threeSeconds,pauseTimes_sixSeconds);
    	waitForElement("APIStoreHome.tf_APISearchStore",pauseTimes_twoSeconds);
    	type("APIStoreHome.tf_APISearchStore",APIDocumentation_DocumentVisibility_keyWordDoc);
    	click("APIStoreHome.btn_SearchButtonStore");
    	checkElementPresent("APIStoreHome.ele_lblSearchMissing",false,"");
    	pause(pauseTimes_fourSeconds);
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_fourSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of excecuting APIM-1011");
    } 
    	

    /**
     * Data provider for Test case tc_APIM_1052.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_1052")
    public Object[][] dataTable_tc_APIM_1052() {     	
    	return this.getDataTable("URLs","pauseTimes","APIDocumentation_DocumentVisibility");
    }

    /**
     * Data driven test case tc_APIM_1052.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_1052")
    public final void tc_APIM_1052(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String APIDocumentation_DocumentVisibility_domain, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwoPassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwoPassword, final String APIDocumentation_DocumentVisibility_APIName, final String APIDocumentation_DocumentVisibility_APINameOne, final String APIDocumentation_DocumentVisibility_APIVersion, final String APIDocumentation_DocumentVisibility_APITagName, final String APIDocumentation_DocumentVisibility_APIContext, final String APIDocumentation_DocumentVisibility_DocName, final String APIDocumentation_DocumentVisibility_DocVisibilitySameAsAPI, final String APIDocumentation_DocumentVisibility_DocVisibilityPrivate, final String APIDocumentation_DocumentVisibility_DocVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_APIVisibilityPublic, final String APIDocumentation_DocumentVisibility_APIVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_sandboxEndPoint, final String APIDocumentation_DocumentVisibility_productionEndPoint, final String APIDocumentation_DocumentVisibility_tenantOne, final String APIDocumentation_DocumentVisibility_tenantTwo, final String APIDocumentation_DocumentVisibility_imageName, final String APIDocumentation_DocumentVisibility_tagName, final String APIDocumentation_DocumentVisibility_keyWordDoc, final String APIDocumentation_DocumentVisibility_documentNameDocOne, final String APIDocumentation_DocumentVisibility_documentSummeryDocOne, final String APIDocumentation_DocumentVisibility_keyWordViewContent, final String APIDocumentation_DocumentVisibility_searchForDocumentKeyWordHello, final String APIDocumentation_DocumentVisibility_noMatchingResults, final String APIDocumentation_DocumentVisibility_keyWordAnonimous, final String APIDocumentation_DocumentVisibility_docSearchKeyWord, final String APIDocumentation_DocumentVisibility_docSearchKeyWordTwo, final String APIDocumentation_DocumentVisibility_SourceURL, final String APIDocumentation_DocumentVisibility_docSearchKeyWordThree) throws Exception {	
    	//User does a content search with a keyword in a private document content
    	writeToReport("Start of execution of TC APIM2_1052");
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	lib_Common.bc_CreateAndPublishAPINew(this, APIDocumentation_DocumentVisibility_APIName,APIDocumentation_DocumentVisibility_APIContext,APIDocumentation_DocumentVisibility_APIVersion,APIDocumentation_DocumentVisibility_imageName,APIDocumentation_DocumentVisibility_APITagName,APIDocumentation_DocumentVisibility_productionEndPoint,APIDocumentation_DocumentVisibility_sandboxEndPoint,pauseTimes_twoSeconds,pauseTimes_sixSeconds,pauseTimes_fourSeconds);
    	pause(pauseTimes_sixSeconds);
    	String var_APINameOne = retrieveString("var_APIName");
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",var_APINameOne);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.btn_Search");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + var_APINameOne);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.lnk_Doc");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	//API1 document 1
    	click("Browse_Doc.btn_AddNewDocument");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("Browse_Doc.tf_DocName",APIDocumentation_DocumentVisibility_documentNameDocOne);
    	//Insert summery for document one
    	type("Browse_Doc.tf_Summary",APIDocumentation_DocumentVisibility_documentSummeryDocOne);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("Browse_Doc.rdo_HowTo",false,"");
    	click("Browse_Doc.rdo_HowTo");
    	//Set visibility level private
    	select("Browse_Doc.ele_ddVisibility",APIDocumentation_DocumentVisibility_DocVisibilityPrivate);
    	click("Browse_Doc.btn_AddDocument");
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne);
    	pause(pauseTimes_fourSeconds);
    	selectWindow("Browse_Doc.newWindow1");
    	//Verify API Version
    	checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	selectFrame("Browse_Doc.frame1");
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.tf_EditContent1");
    	pause(pauseTimes_fourSeconds);
    	type("Browse_Doc.tf_EditContent1",APIDocumentation_DocumentVisibility_docSearchKeyWordTwo);
    	pause(pauseTimes_fourSeconds);
    	selectFrame("Browse_Doc.frame_Parent");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_InlineDocumentEdit_save");
    	//wait for content load
    	selectFrame("Browse_Doc.frame_Parent");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_InlineDocumentEdit_saveAndClose");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	switchUser("default");
    	selectWindow("Browse_Doc.defaultWindow");
    	pause(pauseTimes_fourSeconds);
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",APIDocumentation_DocumentVisibility_searchForDocumentKeyWordHello);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.btn_Search");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	//verify the search results in publisher for key word One
    	//verify Document One name, Link to view / download, API name, API version, API provider
    	checkElementPresent("Browse_Doc.ele_lblDocumentSearchResult_DocumentName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_viewContent","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_keyWordViewContent_PARAM:" + APIDocumentation_DocumentVisibility_keyWordViewContent,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_APIName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APIName_PARAM:" + var_APINameOne,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_APINameWithVersion","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APIName_PARAM:" + var_APINameOne + "_PARAM," + "param_versionOfAPI_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	if(APIDocumentation_DocumentVisibility_domain.equals("TenantOne")){
    	String var_Provider = retrieveString("keyTenantOnePublisherUserOne");
    	store("key_domain","String",var_Provider);
    	} else if(APIDocumentation_DocumentVisibility_domain.equals("Admin")){
    	String var_Provider = retrieveString("keyAdminPublisherUserOne");
    	store("key_domain","String",var_Provider);
    	}
    	String var_Provider = retrieveString("key_domain");
    	checkElementPresent("Browse_Doc.ele_lblDocumentSearchResult_provider","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_provider_PARAM:" + var_Provider,false,"");
    	//Navigate to store URL
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,"2000");
    	lib_Common.bc_SelectServer(this, APIDocumentation_DocumentVisibility_domain);
    	lib_Common.bc_Login_APIStore(this, APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOnePassword,pauseTimes_threeSeconds,pauseTimes_sixSeconds);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
    	type("APIStoreHome.tf_APISearchStore",APIDocumentation_DocumentVisibility_docSearchKeyWord);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIStoreHome.btn_SearchButtonStore");
    	//verifu that No Matching Results message appears
    	checkElementPresent("APIStoreHome.ele_lblSearchTermIsMissing","param_searchTermIsMissing_PARAM:" + APIDocumentation_DocumentVisibility_noMatchingResults,false,"");
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_threeSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of execution of TC APIM2_1052");
    } 
    	

    /**
     * Data provider for Test case tc_APIM_1053.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_1053")
    public Object[][] dataTable_tc_APIM_1053() {     	
    	return this.getDataTable("pauseTimes","APIDocumentation_DocumentVisibility","URLs");
    }

    /**
     * Data driven test case tc_APIM_1053.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_1053")
    public final void tc_APIM_1053(final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String APIDocumentation_DocumentVisibility_domain, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwoPassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwoPassword, final String APIDocumentation_DocumentVisibility_APIName, final String APIDocumentation_DocumentVisibility_APINameOne, final String APIDocumentation_DocumentVisibility_APIVersion, final String APIDocumentation_DocumentVisibility_APITagName, final String APIDocumentation_DocumentVisibility_APIContext, final String APIDocumentation_DocumentVisibility_DocName, final String APIDocumentation_DocumentVisibility_DocVisibilitySameAsAPI, final String APIDocumentation_DocumentVisibility_DocVisibilityPrivate, final String APIDocumentation_DocumentVisibility_DocVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_APIVisibilityPublic, final String APIDocumentation_DocumentVisibility_APIVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_sandboxEndPoint, final String APIDocumentation_DocumentVisibility_productionEndPoint, final String APIDocumentation_DocumentVisibility_tenantOne, final String APIDocumentation_DocumentVisibility_tenantTwo, final String APIDocumentation_DocumentVisibility_imageName, final String APIDocumentation_DocumentVisibility_tagName, final String APIDocumentation_DocumentVisibility_keyWordDoc, final String APIDocumentation_DocumentVisibility_documentNameDocOne, final String APIDocumentation_DocumentVisibility_documentSummeryDocOne, final String APIDocumentation_DocumentVisibility_keyWordViewContent, final String APIDocumentation_DocumentVisibility_searchForDocumentKeyWordHello, final String APIDocumentation_DocumentVisibility_noMatchingResults, final String APIDocumentation_DocumentVisibility_keyWordAnonimous, final String APIDocumentation_DocumentVisibility_docSearchKeyWord, final String APIDocumentation_DocumentVisibility_docSearchKeyWordTwo, final String APIDocumentation_DocumentVisibility_SourceURL, final String APIDocumentation_DocumentVisibility_docSearchKeyWordThree, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//User searches for a document content which has "same as API visibility" visibility when API visibility is "Visible to my domain"
    	writeToReport("Start of execution of TC APIM2_1053");
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	//Creating and publishing API
    	click("APIPublisherHome.lnk_Add");
    	waitForElement("APIPublisherAdd.rdo_DesignNewAPI",pauseTimes_fourSeconds);
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	waitForElement("APIPublisherAdd.btn_StartCreating",pauseTimes_threeSeconds);
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_twoSeconds);
    	//genarate api name
    	String APIName = APIDocumentation_DocumentVisibility_APIName+"_"+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",APIName);
    	//Type API contest
    	String APIcontest = APIDocumentation_DocumentVisibility_APIContext+"_"+generateData("int",3);
    	type("APIPublisherAdd.tf_APIContext",APIcontest);
    	type("APIPublisherAdd.tf_APIVersion",APIDocumentation_DocumentVisibility_APIVersion);
    	//storeAPI version
    	store("var_APIVersion","String",APIDocumentation_DocumentVisibility_APIVersion);
    	//Genarate Tag Name
    	String TagName = APIDocumentation_DocumentVisibility_APITagName+"_"+generateData("int",3);
    	select("APIPublisherBrowse.ele_ddVisibility",APIDocumentation_DocumentVisibility_APIVisibilityVisibleToMyDomain);
    	pause(pauseTimes_threeSeconds);
    	type("APIPublisherAdd.tf_Tags",TagName);
    	type("APIPublisherAdd.tf_Tags",TagName+org.openqa.selenium.Keys.ENTER);
    	pause(pauseTimes_twoSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_fourSeconds);
    	//click save and verify warning
    	doubleClick("APIPublisherAdd.btn_Save");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_fourSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fourSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	pause(pauseTimes_sixSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.lnk_NextImplement",pauseTimes_threeSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	pause(pauseTimes_sixSeconds);
    	lib_Common.bc_PrototypeAPI(this, pauseTimes_fourSeconds);
    	pause(pauseTimes_sixSeconds);
    	clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherBrowse.tf_ProductionEndPoint",APIDocumentation_DocumentVisibility_productionEndPoint);
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherBrowse.tf_SandBoxEndPoint",APIDocumentation_DocumentVisibility_sandboxEndPoint);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true");
    	click("APIPublisherBrowse.btn_Save");
    	pause(pauseTimes_tenSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.btn_NextManage",pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.btn_NextManage");
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.ele_ddTierAvilability");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.chk_Gold",pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.chk_Gold");
    	click("APIPublisherBrowse.chk_Silver");
    	//Wait for content load
    	waitForElement("APIPublisherBrowse.btn_SaveAndPublish",pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.btn_SaveAndPublish");
    	pause(pauseTimes_sevenSeconds);
    	//Wait for content load
    	waitForElement("APIPublisherBrowse.btn_Close",pauseTimes_fourSeconds);
    	clickAt("APIPublisherBrowse.btn_Close","0,0");
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",APIName);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.btn_Search");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.lnk_Doc");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	//API1 document 1
    	click("Browse_Doc.btn_AddNewDocument");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("Browse_Doc.tf_DocName",APIDocumentation_DocumentVisibility_documentNameDocOne);
    	//Insert summery for document one
    	type("Browse_Doc.tf_Summary",APIDocumentation_DocumentVisibility_documentSummeryDocOne);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("Browse_Doc.rdo_HowTo",false,"");
    	click("Browse_Doc.rdo_HowTo");
    	//Set visibility level private
    	select("Browse_Doc.ele_ddVisibility",APIDocumentation_DocumentVisibility_DocVisibilitySameAsAPI);
    	click("Browse_Doc.btn_AddDocument");
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne);
    	pause(pauseTimes_fourSeconds);
    	selectWindow("Browse_Doc.newWindow1");
    	//Verify API Version
    	checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	selectFrame("Browse_Doc.frame1");
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.tf_EditContent1");
    	pause(pauseTimes_fourSeconds);
    	type("Browse_Doc.tf_EditContent1",APIDocumentation_DocumentVisibility_docSearchKeyWordTwo);
    	pause(pauseTimes_fourSeconds);
    	selectFrame("Browse_Doc.frame_Parent");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_InlineDocumentEdit_save");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	selectFrame("Browse_Doc.frame_Parent");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_InlineDocumentEdit_saveAndClose");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	switchUser("default");
    	selectWindow("Browse_Doc.defaultWindow");
    	pause(pauseTimes_fourSeconds);
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",APIDocumentation_DocumentVisibility_searchForDocumentKeyWordHello);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.btn_Search");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	//verify the search results in publisher for key word One
    	//verify Document One name, Link to view / download, API name, API version, API provider
    	checkElementPresent("Browse_Doc.ele_lblDocumentSearchResult_DocumentName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_viewContent","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_keyWordViewContent_PARAM:" + APIDocumentation_DocumentVisibility_keyWordViewContent,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_APIName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APIName_PARAM:" + APIName,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_APINameWithVersion","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionOfAPI_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	if(APIDocumentation_DocumentVisibility_domain.equals("TenantOne")){
    	String var_Provider = retrieveString("keyTenantOnePublisherUserOne");
    	store("key_domain","String",var_Provider);
    	} else if(APIDocumentation_DocumentVisibility_domain.equals("Admin")){
    	String var_Provider = retrieveString("keyAdminPublisherUserOne");
    	store("key_domain","String",var_Provider);
    	}
    	String var_Provider = retrieveString("key_domain");
    	checkElementPresent("Browse_Doc.ele_lblDocumentSearchResult_provider","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_provider_PARAM:" + var_Provider,false,"");
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_threeSeconds);
    	lib_Common.bc_SelectServer(this, APIDocumentation_DocumentVisibility_keyWordAnonimous);
    	waitForElement("APIStoreHome.tf_APISearchStore",pauseTimes_twoSeconds);
    	pause(pauseTimes_threeSeconds);
    	type("APIStoreHome.tf_APISearchStore",APIDocumentation_DocumentVisibility_docSearchKeyWord);
    	click("APIStoreHome.btn_SearchButtonStore");
    	checkElementPresent("APIStoreHome.ele_lblSearchTermIsMissing","param_searchTermIsMissing_PARAM:" + APIDocumentation_DocumentVisibility_noMatchingResults,false,"");
    	pause(pauseTimes_fourSeconds);
    	//Navigate to store URL
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,"2000");
    	lib_Common.bc_SelectServer(this, APIDocumentation_DocumentVisibility_domain);
    	lib_Common.bc_Login_APIStore(this, APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOnePassword,pauseTimes_threeSeconds,pauseTimes_sixSeconds);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
    	type("APIStoreHome.tf_APISearchStore",APIDocumentation_DocumentVisibility_docSearchKeyWord);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIStoreHome.btn_SearchButtonStore");
    	//wait for search content load
    	pause(pauseTimes_fourSeconds);
    	//verify the search results in store for key word One
    	//verify Document One name, Link to view / download, API name, API version, API provider
    	checkElementPresent("APIStoreHome.ele_lblDocumentSearchResult_documentName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne,false,"");
    	checkElementPresent("APIStoreHome.ele_lblDocumentSearchResult_documentSummary","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_summaryContent_PARAM:" + APIDocumentation_DocumentVisibility_documentSummeryDocOne,false,"");
    	checkElementPresent("APIStoreHome.lnk_documentSearchResult_viewContent","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne,false,"");
    	checkElementPresent("APIStoreHome.lnk_documentSearchResult_APINameOrVersion","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APINameOrVersion_PARAM:" + APIName,false,"");
    	checkElementPresent("APIStoreHome.lnk_documentSearchResult_APINameOrVersion","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APINameOrVersion_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	if(APIDocumentation_DocumentVisibility_domain.equals("TenantOne")){
    	String var_Providerone = retrieveString("keyTenantOnePublisherUserOne");
    	store("key_domainStore","String",var_Providerone);
    	} else if(APIDocumentation_DocumentVisibility_domain.equals("Admin")){
    	String var_Providerone = retrieveString("keyAdminPublisherUserOne");
    	store("key_domainStore","String",var_Providerone);
    	}
    	String var_ProviderStore = retrieveString("key_domainStore");
    	checkElementPresent("APIStoreHome.ele_lblDocumentSearchResult_provider","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_provider_PARAM:" + var_ProviderStore,false,"");
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_fourSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of excecuting APIM-1053");
    } 
    	

    /**
     * Data provider for Test case tc_APIM_1060.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_1060")
    public Object[][] dataTable_tc_APIM_1060() {     	
    	return this.getDataTable("APIDocumentation_UpdateDocuments","APIDocumentation_DocumentVisibility","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_1060.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_1060")
    public final void tc_APIM_1060(final String APIDocumentation_UpdateDocuments_domain, final String APIDocumentation_UpdateDocuments_apiName, final String APIDocumentation_UpdateDocuments_apiContext, final String APIDocumentation_UpdateDocuments_apiVersion, final String APIDocumentation_UpdateDocuments_docName, final String APIDocumentation_UpdateDocuments_ProductionEndPoint, final String APIDocumentation_UpdateDocuments_SandBoxEndPoint, final String APIDocumentation_UpdateDocuments_sourseUrl, final String APIDocumentation_UpdateDocuments_docSummery, final String APIDocumentation_UpdateDocuments_docSummeryTwo, final String APIDocumentation_UpdateDocuments_APIStatus, final String APIDocumentation_UpdateDocuments_adminOrTenantOnePublisherUserOne, final String APIDocumentation_UpdateDocuments_adminOrTenantOnePublisherUserOnePassword, final String APIDocumentation_UpdateDocuments_adminOrTenantOneStoreUserOne, final String APIDocumentation_UpdateDocuments_adminOrTenantOneStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_domain, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwoPassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwoPassword, final String APIDocumentation_DocumentVisibility_APIName, final String APIDocumentation_DocumentVisibility_APINameOne, final String APIDocumentation_DocumentVisibility_APIVersion, final String APIDocumentation_DocumentVisibility_APITagName, final String APIDocumentation_DocumentVisibility_APIContext, final String APIDocumentation_DocumentVisibility_DocName, final String APIDocumentation_DocumentVisibility_DocVisibilitySameAsAPI, final String APIDocumentation_DocumentVisibility_DocVisibilityPrivate, final String APIDocumentation_DocumentVisibility_DocVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_APIVisibilityPublic, final String APIDocumentation_DocumentVisibility_APIVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_sandboxEndPoint, final String APIDocumentation_DocumentVisibility_productionEndPoint, final String APIDocumentation_DocumentVisibility_tenantOne, final String APIDocumentation_DocumentVisibility_tenantTwo, final String APIDocumentation_DocumentVisibility_imageName, final String APIDocumentation_DocumentVisibility_tagName, final String APIDocumentation_DocumentVisibility_keyWordDoc, final String APIDocumentation_DocumentVisibility_documentNameDocOne, final String APIDocumentation_DocumentVisibility_documentSummeryDocOne, final String APIDocumentation_DocumentVisibility_keyWordViewContent, final String APIDocumentation_DocumentVisibility_searchForDocumentKeyWordHello, final String APIDocumentation_DocumentVisibility_noMatchingResults, final String APIDocumentation_DocumentVisibility_keyWordAnonimous, final String APIDocumentation_DocumentVisibility_docSearchKeyWord, final String APIDocumentation_DocumentVisibility_docSearchKeyWordTwo, final String APIDocumentation_DocumentVisibility_SourceURL, final String APIDocumentation_DocumentVisibility_docSearchKeyWordThree, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	writeToReport("start of tc_APIM_1060");
    	//Login to API publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	//Create  API to publish stage
    	click("APIPublisherHome.ele_lblAPIs");
    	waitForElementEnable("APIPublisherHome.lnk_Add");
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fourSeconds);
    	//Type API Name
    	String varAPINameOne = APIDocumentation_DocumentVisibility_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameOne);
    	String varAPIContext = APIDocumentation_DocumentVisibility_APIContext+generateData("int",3);
    	//Type API contest
    	type("APIPublisherAdd.tf_APIContext",varAPIContext);
    	type("APIPublisherAdd.tf_APIVersion",APIDocumentation_DocumentVisibility_APIVersion);
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_NextImplement");
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	pause(pauseTimes_sixSeconds);
    	clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
    	type("APIPublisherBrowse.tf_ProductionEndPoint",APIDocumentation_DocumentVisibility_productionEndPoint);
    	type("APIPublisherBrowse.tf_SandBoxEndPoint",APIDocumentation_DocumentVisibility_sandboxEndPoint);
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_NextManage");
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.chk_Unlimited");
    	pause(pauseTimes_twoSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	clickAt("APIPublisherBrowse.btn_SaveAndPublish","0,0");
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.btn_GoToOverview");
    	waitForElement("APIPublisherHome.ele_lblAPIs",pauseTimes_sixSeconds);
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	pause(pauseTimes_twoSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameOne + "_PARAM," + "param_APIVersion_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion + "_PARAM," + "param_APIName_PARAM:" + varAPINameOne);
    	waitForElement("Browse_Doc.lnk_Doc",pauseTimes_fourSeconds);
    	click("Browse_Doc.lnk_Doc");
    	waitForElement("Browse_Doc.btn_AddNewDocument",pauseTimes_threeSeconds);
    	click("Browse_Doc.btn_AddNewDocument");
    	String varDocName = APIDocumentation_DocumentVisibility_DocName+generateData("int",3);
    	type("Browse_Doc.tf_DocName",varDocName);
    	type("Browse_Doc.tf_Summary",APIDocumentation_DocumentVisibility_documentSummeryDocOne);
    	click("Browse_Doc.rdo_HowTo");
    	click("Browse_Doc.rdo_URL");
    	type("Browse_Doc.tf_URL",APIDocumentation_DocumentVisibility_SourceURL);
    	click("Browse_Doc.btn_AddDocument");
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	pause(pauseTimes_twoSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	type("APIPublisherHome.tf_APISearch",APIDocumentation_DocumentVisibility_docSearchKeyWordThree);
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.btn_Search");
    	pause(pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherHome.ele_lblNoMatchingAPI",false,"");
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_sixSeconds);
    	lib_Common.bc_SelectServer(this, APIDocumentation_DocumentVisibility_domain);
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",APIDocumentation_DocumentVisibility_docSearchKeyWordThree);
    	click("APIStoreHome.btn_SearchButtonStore");
    	pause(pauseTimes_twoSeconds);
    	click("APIStoreHome.btn_SearchButtonStore");
    	checkElementPresent("APIStoreHome.ele_lblNoMatchingAPI",false,"");
    	pause(pauseTimes_threeSeconds);
    	//login to API store
    	lib_Common.bc_Login_APIStore(this, APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOnePassword,pauseTimes_threeSeconds,pauseTimes_sixSeconds);
    	lib_Common.bc_SelectServer(this, APIDocumentation_DocumentVisibility_domain);
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",APIDocumentation_DocumentVisibility_docSearchKeyWordThree);
    	click("APIStoreHome.btn_SearchButtonStore");
    	pause(pauseTimes_twoSeconds);
    	click("APIStoreHome.btn_SearchButtonStore");
    	checkElementPresent("APIStoreHome.ele_lblNoMatchingAPI",false,"");
    	pause(pauseTimes_threeSeconds);
    	//move to API publisher
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_threeSeconds);
    	//delete APIS
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of tc_APIM_1060");
    } 
    	

    /**
     * Data provider for Test case tc_APIM_1055.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_1055")
    public Object[][] dataTable_tc_APIM_1055() {     	
    	return this.getDataTable("pauseTimes","URLs","APIDocumentation_DocumentVisibility");
    }

    /**
     * Data driven test case tc_APIM_1055.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_1055")
    public final void tc_APIM_1055(final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String APIDocumentation_DocumentVisibility_domain, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwoPassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwoPassword, final String APIDocumentation_DocumentVisibility_APIName, final String APIDocumentation_DocumentVisibility_APINameOne, final String APIDocumentation_DocumentVisibility_APIVersion, final String APIDocumentation_DocumentVisibility_APITagName, final String APIDocumentation_DocumentVisibility_APIContext, final String APIDocumentation_DocumentVisibility_DocName, final String APIDocumentation_DocumentVisibility_DocVisibilitySameAsAPI, final String APIDocumentation_DocumentVisibility_DocVisibilityPrivate, final String APIDocumentation_DocumentVisibility_DocVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_APIVisibilityPublic, final String APIDocumentation_DocumentVisibility_APIVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_sandboxEndPoint, final String APIDocumentation_DocumentVisibility_productionEndPoint, final String APIDocumentation_DocumentVisibility_tenantOne, final String APIDocumentation_DocumentVisibility_tenantTwo, final String APIDocumentation_DocumentVisibility_imageName, final String APIDocumentation_DocumentVisibility_tagName, final String APIDocumentation_DocumentVisibility_keyWordDoc, final String APIDocumentation_DocumentVisibility_documentNameDocOne, final String APIDocumentation_DocumentVisibility_documentSummeryDocOne, final String APIDocumentation_DocumentVisibility_keyWordViewContent, final String APIDocumentation_DocumentVisibility_searchForDocumentKeyWordHello, final String APIDocumentation_DocumentVisibility_noMatchingResults, final String APIDocumentation_DocumentVisibility_keyWordAnonimous, final String APIDocumentation_DocumentVisibility_docSearchKeyWord, final String APIDocumentation_DocumentVisibility_docSearchKeyWordTwo, final String APIDocumentation_DocumentVisibility_SourceURL, final String APIDocumentation_DocumentVisibility_docSearchKeyWordThree) throws Exception {	
    	//User searches for a document content for a document which is visibility is set to "visible to my domain".
    	writeToReport("Start of execution of TC APIM2_1055");
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	//Creating and publishing API
    	click("APIPublisherHome.lnk_Add");
    	waitForElement("APIPublisherAdd.rdo_DesignNewAPI",pauseTimes_fourSeconds);
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	waitForElement("APIPublisherAdd.btn_StartCreating",pauseTimes_threeSeconds);
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_twoSeconds);
    	//genarate api name
    	String APIName = APIDocumentation_DocumentVisibility_APIName+"_"+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",APIName);
    	//Type API contest
    	String APIcontest = APIDocumentation_DocumentVisibility_APIContext+"_"+generateData("int",3);
    	type("APIPublisherAdd.tf_APIContext",APIcontest);
    	type("APIPublisherAdd.tf_APIVersion",APIDocumentation_DocumentVisibility_APIVersion);
    	//storeAPI version
    	store("var_APIVersion","String",APIDocumentation_DocumentVisibility_APIVersion);
    	//Genarate Tag Name
    	String TagName = APIDocumentation_DocumentVisibility_APITagName+"_"+generateData("int",3);
    	select("APIPublisherBrowse.ele_ddVisibility",APIDocumentation_DocumentVisibility_APIVisibilityPublic);
    	pause(pauseTimes_threeSeconds);
    	type("APIPublisherAdd.tf_Tags",TagName);
    	type("APIPublisherAdd.tf_Tags",TagName+org.openqa.selenium.Keys.ENTER);
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_fourSeconds);
    	//click save and verify warning
    	doubleClick("APIPublisherAdd.btn_Save");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_fourSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fourSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	//waiting for content load
    	pause(pauseTimes_eightSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	pause(pauseTimes_sixSeconds);
    	lib_Common.bc_PrototypeAPI(this, pauseTimes_fourSeconds);
    	pause(pauseTimes_sixSeconds);
    	clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
    	pause(pauseTimes_twoSeconds);
    	type("APIPublisherBrowse.tf_ProductionEndPoint",APIDocumentation_DocumentVisibility_productionEndPoint);
    	pause(pauseTimes_threeSeconds);
    	type("APIPublisherBrowse.tf_SandBoxEndPoint",APIDocumentation_DocumentVisibility_sandboxEndPoint);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true");
    	pause(pauseTimes_twoSeconds);
    	click("APIPublisherBrowse.btn_Save");
    	pause(pauseTimes_sixSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.btn_NextManage",pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.btn_NextManage");
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.ele_ddTierAvilability");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.chk_Gold",pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.chk_Gold");
    	click("APIPublisherBrowse.chk_Silver");
    	//Wait for content load
    	waitForElement("APIPublisherBrowse.btn_SaveAndPublish",pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.btn_SaveAndPublish");
    	pause(pauseTimes_sixSeconds);
    	//Wait for content load
    	waitForElement("APIPublisherBrowse.btn_Close",pauseTimes_fourSeconds);
    	clickAt("APIPublisherBrowse.btn_Close","0,0");
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",APIName);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.btn_Search");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.lnk_Doc");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	//API1 document 1
    	click("Browse_Doc.btn_AddNewDocument");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("Browse_Doc.tf_DocName",APIDocumentation_DocumentVisibility_documentNameDocOne);
    	//Insert summery for document one
    	type("Browse_Doc.tf_Summary",APIDocumentation_DocumentVisibility_documentSummeryDocOne);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("Browse_Doc.rdo_HowTo",false,"");
    	click("Browse_Doc.rdo_HowTo");
    	//Set visibility level private
    	select("Browse_Doc.ele_ddVisibility",APIDocumentation_DocumentVisibility_DocVisibilityVisibleToMyDomain);
    	click("Browse_Doc.btn_AddDocument");
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne);
    	pause(pauseTimes_fourSeconds);
    	selectWindow("Browse_Doc.newWindow1");
    	//Verify API Version
    	checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	selectFrame("Browse_Doc.frame1");
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.tf_EditContent1");
    	pause(pauseTimes_fourSeconds);
    	type("Browse_Doc.tf_EditContent1",APIDocumentation_DocumentVisibility_docSearchKeyWordTwo);
    	pause(pauseTimes_fourSeconds);
    	selectFrame("Browse_Doc.frame_Parent");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_InlineDocumentEdit_save");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	selectFrame("Browse_Doc.frame_Parent");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_InlineDocumentEdit_saveAndClose");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	switchUser("default");
    	selectWindow("Browse_Doc.defaultWindow");
    	pause(pauseTimes_fourSeconds);
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",APIDocumentation_DocumentVisibility_searchForDocumentKeyWordHello);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.btn_Search");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	//verify the search results in publisher for key word One
    	//verify Document One name, Link to view / download, API name, API version, API provider
    	checkElementPresent("Browse_Doc.ele_lblDocumentSearchResult_DocumentName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_viewContent","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_keyWordViewContent_PARAM:" + APIDocumentation_DocumentVisibility_keyWordViewContent,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_APIName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APIName_PARAM:" + APIName,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_APINameWithVersion","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionOfAPI_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	if(APIDocumentation_DocumentVisibility_domain.equals("TenantOne")){
    	String var_Provider = retrieveString("keyTenantOnePublisherUserOne");
    	store("key_domain","String",var_Provider);
    	} else if(APIDocumentation_DocumentVisibility_domain.equals("Admin")){
    	String var_Provider = retrieveString("keyAdminPublisherUserOne");
    	store("key_domain","String",var_Provider);
    	}
    	String var_Provider = retrieveString("key_domain");
    	checkElementPresent("Browse_Doc.ele_lblDocumentSearchResult_provider","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_provider_PARAM:" + var_Provider,false,"");
    	//Navigate to the Store with anonymous User
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_threeSeconds);
    	lib_Common.bc_SelectServer(this, APIDocumentation_DocumentVisibility_domain);
    	waitForElement("APIStoreHome.tf_APISearchStore",pauseTimes_twoSeconds);
    	type("APIStoreHome.tf_APISearchStore",APIDocumentation_DocumentVisibility_docSearchKeyWord);
    	click("APIStoreHome.btn_SearchButtonStore");
    	checkElementPresent("APIStoreHome.ele_lblSearchTermIsMissing","param_searchTermIsMissing_PARAM:" + APIDocumentation_DocumentVisibility_noMatchingResults,false,"");
    	pause(pauseTimes_fourSeconds);
    	//Navigate to the Storewith Tenant Two User
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_threeSeconds);
    	lib_Common.bc_SelectServer(this, APIDocumentation_DocumentVisibility_keyWordAnonimous);
    	lib_Common.bc_Login_APIStore(this, APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOne,APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOnePassword,pauseTimes_threeSeconds,pauseTimes_sixSeconds);
    	waitForElement("APIStoreHome.tf_APISearchStore",pauseTimes_twoSeconds);
    	type("APIStoreHome.tf_APISearchStore",APIDocumentation_DocumentVisibility_docSearchKeyWord);
    	click("APIStoreHome.btn_SearchButtonStore");
    	checkElementPresent("APIStoreHome.ele_lblSearchTermIsMissing","param_searchTermIsMissing_PARAM:" + APIDocumentation_DocumentVisibility_noMatchingResults,false,"");
    	pause(pauseTimes_fourSeconds);
    	//Navigate to store URL
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,"2000");
    	lib_Common.bc_SelectServer(this, APIDocumentation_DocumentVisibility_domain);
    	lib_Common.bc_Login_APIStore(this, APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOnePassword,pauseTimes_threeSeconds,pauseTimes_sixSeconds);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
    	type("APIStoreHome.tf_APISearchStore",APIDocumentation_DocumentVisibility_docSearchKeyWord);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIStoreHome.btn_SearchButtonStore");
    	//wait for search content load
    	pause(pauseTimes_fourSeconds);
    	//verify the search results in store for key word One
    	//verify Document One name, Link to view / download, API name, API version, API provider
    	checkElementPresent("APIStoreHome.ele_lblDocumentSearchResult_documentName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne,false,"");
    	checkElementPresent("APIStoreHome.ele_lblDocumentSearchResult_documentSummary","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_summaryContent_PARAM:" + APIDocumentation_DocumentVisibility_documentSummeryDocOne,false,"");
    	checkElementPresent("APIStoreHome.lnk_documentSearchResult_viewContent","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne,false,"");
    	checkElementPresent("APIStoreHome.lnk_documentSearchResult_APINameOrVersion","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APINameOrVersion_PARAM:" + APIName,false,"");
    	checkElementPresent("APIStoreHome.lnk_documentSearchResult_APINameOrVersion","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APINameOrVersion_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	if(APIDocumentation_DocumentVisibility_domain.equals("TenantOne")){
    	String var_Providerone = retrieveString("keyTenantOnePublisherUserOne");
    	store("key_domainStore","String",var_Providerone);
    	} else if(APIDocumentation_DocumentVisibility_domain.equals("Admin")){
    	String var_Providerone = retrieveString("keyAdminPublisherUserOne");
    	store("key_domainStore","String",var_Providerone);
    	}
    	String var_ProviderStore = retrieveString("key_domainStore");
    	checkElementPresent("APIStoreHome.ele_lblDocumentSearchResult_provider","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_provider_PARAM:" + var_ProviderStore,false,"");
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_fourSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of excecuting APIM-1055");
    } 
    	

    /**
     * Data provider for Test case tc_APIM_1056.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_1056")
    public Object[][] dataTable_tc_APIM_1056() {     	
    	return this.getDataTable("pauseTimes","APIDocumentation_DocumentVisibility","URLs");
    }

    /**
     * Data driven test case tc_APIM_1056.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_1056")
    public final void tc_APIM_1056(final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String APIDocumentation_DocumentVisibility_domain, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserTwoPassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOne, final String APIDocumentation_DocumentVisibility_adminOrTenantTwoStoreUserOnePassword, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwo, final String APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwoPassword, final String APIDocumentation_DocumentVisibility_APIName, final String APIDocumentation_DocumentVisibility_APINameOne, final String APIDocumentation_DocumentVisibility_APIVersion, final String APIDocumentation_DocumentVisibility_APITagName, final String APIDocumentation_DocumentVisibility_APIContext, final String APIDocumentation_DocumentVisibility_DocName, final String APIDocumentation_DocumentVisibility_DocVisibilitySameAsAPI, final String APIDocumentation_DocumentVisibility_DocVisibilityPrivate, final String APIDocumentation_DocumentVisibility_DocVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_APIVisibilityPublic, final String APIDocumentation_DocumentVisibility_APIVisibilityVisibleToMyDomain, final String APIDocumentation_DocumentVisibility_sandboxEndPoint, final String APIDocumentation_DocumentVisibility_productionEndPoint, final String APIDocumentation_DocumentVisibility_tenantOne, final String APIDocumentation_DocumentVisibility_tenantTwo, final String APIDocumentation_DocumentVisibility_imageName, final String APIDocumentation_DocumentVisibility_tagName, final String APIDocumentation_DocumentVisibility_keyWordDoc, final String APIDocumentation_DocumentVisibility_documentNameDocOne, final String APIDocumentation_DocumentVisibility_documentSummeryDocOne, final String APIDocumentation_DocumentVisibility_keyWordViewContent, final String APIDocumentation_DocumentVisibility_searchForDocumentKeyWordHello, final String APIDocumentation_DocumentVisibility_noMatchingResults, final String APIDocumentation_DocumentVisibility_keyWordAnonimous, final String APIDocumentation_DocumentVisibility_docSearchKeyWord, final String APIDocumentation_DocumentVisibility_docSearchKeyWordTwo, final String APIDocumentation_DocumentVisibility_SourceURL, final String APIDocumentation_DocumentVisibility_docSearchKeyWordThree, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//User searches for document content of a blocked API.
    	writeToReport("Start of execution of TC APIM_1056");
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	//Creating and publishing API
    	click("APIPublisherHome.lnk_Add");
    	waitForElement("APIPublisherAdd.rdo_DesignNewAPI",pauseTimes_fourSeconds);
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	waitForElement("APIPublisherAdd.btn_StartCreating",pauseTimes_threeSeconds);
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_twoSeconds);
    	//genarate api name
    	String APIName = APIDocumentation_DocumentVisibility_APIName+"_"+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",APIName);
    	//Type API contest
    	String APIcontest = APIDocumentation_DocumentVisibility_APIContext+"_"+generateData("int",3);
    	type("APIPublisherAdd.tf_APIContext",APIcontest);
    	type("APIPublisherAdd.tf_APIVersion",APIDocumentation_DocumentVisibility_APIVersion);
    	//storeAPI version
    	store("var_APIVersion","String",APIDocumentation_DocumentVisibility_APIVersion);
    	//Genarate Tag Name
    	String TagName = APIDocumentation_DocumentVisibility_APITagName+"_"+generateData("int",3);
    	select("APIPublisherBrowse.ele_ddVisibility",APIDocumentation_DocumentVisibility_APIVisibilityPublic);
    	pause(pauseTimes_threeSeconds);
    	type("APIPublisherAdd.tf_Tags",TagName);
    	type("APIPublisherAdd.tf_Tags",TagName+org.openqa.selenium.Keys.ENTER);
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_fourSeconds);
    	//click save and verify warning
    	doubleClick("APIPublisherAdd.btn_Save");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_fourSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fourSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	//waiting for content load
    	pause(pauseTimes_eightSeconds);
    	click("APIPublisherAdd.lnk_NextImplement");
    	pause(pauseTimes_sixSeconds);
    	lib_Common.bc_PrototypeAPI(this, pauseTimes_fourSeconds);
    	pause(pauseTimes_fourSeconds);
    	clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
    	pause(pauseTimes_twoSeconds);
    	type("APIPublisherBrowse.tf_ProductionEndPoint",APIDocumentation_DocumentVisibility_productionEndPoint);
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherBrowse.tf_SandBoxEndPoint",APIDocumentation_DocumentVisibility_sandboxEndPoint);
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true");
    	click("APIPublisherBrowse.btn_Save");
    	pause(pauseTimes_sixSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.btn_NextManage",pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.btn_NextManage");
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.ele_ddTierAvilability");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.chk_Gold",pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.chk_Gold");
    	click("APIPublisherBrowse.chk_Silver");
    	//Wait for content load
    	waitForElement("APIPublisherBrowse.btn_SaveAndPublish",pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.btn_SaveAndPublish");
    	pause(pauseTimes_fourSeconds);
    	//Wait for content load
    	waitForElement("APIPublisherBrowse.btn_Close",pauseTimes_fourSeconds);
    	clickAt("APIPublisherBrowse.btn_Close","0,0");
    	pause(pauseTimes_fourSeconds);
    	//Adding documents for API
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",APIName);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.btn_Search");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.lnk_Doc");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	//API1 document 1
    	click("Browse_Doc.btn_AddNewDocument");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("Browse_Doc.tf_DocName",APIDocumentation_DocumentVisibility_documentNameDocOne);
    	//Insert summery for document one
    	type("Browse_Doc.tf_Summary",APIDocumentation_DocumentVisibility_documentSummeryDocOne);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("Browse_Doc.rdo_HowTo",false,"");
    	click("Browse_Doc.rdo_HowTo");
    	click("Browse_Doc.btn_AddDocument");
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne);
    	pause(pauseTimes_fourSeconds);
    	selectWindow("Browse_Doc.newWindow1");
    	//Verify API Version
    	checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	selectFrame("Browse_Doc.frame1");
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.tf_EditContent1");
    	pause(pauseTimes_fourSeconds);
    	type("Browse_Doc.tf_EditContent1",APIDocumentation_DocumentVisibility_docSearchKeyWordTwo);
    	pause(pauseTimes_fourSeconds);
    	selectFrame("Browse_Doc.frame_Parent");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_InlineDocumentEdit_save");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	selectFrame("Browse_Doc.frame_Parent");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("Browse_Doc.btn_InlineDocumentEdit_saveAndClose");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	switchUser("default");
    	selectWindow("Browse_Doc.defaultWindow");
    	pause(pauseTimes_fourSeconds);
    	//Login Using Publisher user and the check the document
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",APIDocumentation_DocumentVisibility_searchForDocumentKeyWordHello);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.btn_Search");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	//verify the search results in publisher for key word One
    	//verify Document One name, Link to view / download, API name, API version, API provider
    	checkElementPresent("Browse_Doc.ele_lblDocumentSearchResult_DocumentName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_viewContent","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_keyWordViewContent_PARAM:" + APIDocumentation_DocumentVisibility_keyWordViewContent,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_APIName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APIName_PARAM:" + APIName,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_APINameWithVersion","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionOfAPI_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	if(APIDocumentation_DocumentVisibility_domain.equals("TenantOne")){
    	String var_Provider = retrieveString("keyTenantOnePublisherUserOne");
    	store("key_domain","String",var_Provider);
    	} else if(APIDocumentation_DocumentVisibility_domain.equals("Admin")){
    	String var_Provider = retrieveString("keyAdminPublisherUserOne");
    	store("key_domain","String",var_Provider);
    	}
    	String var_Provider = retrieveString("key_domain");
    	checkElementPresent("Browse_Doc.ele_lblDocumentSearchResult_provider","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_provider_PARAM:" + var_Provider,false,"");
    	//Navigate to the Store with anonymous User
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_threeSeconds);
    	lib_Common.bc_SelectServer(this, APIDocumentation_DocumentVisibility_domain);
    	lib_Common.bc_Login_APIStore(this, APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwo,APIDocumentation_DocumentVisibility_adminOrTenantOneStoreUserTwoPassword,pauseTimes_threeSeconds,pauseTimes_sixSeconds);
    	waitForElement("APIStoreHome.tf_APISearchStore",pauseTimes_twoSeconds);
    	type("APIStoreHome.tf_APISearchStore",APIDocumentation_DocumentVisibility_docSearchKeyWord);
    	click("APIStoreHome.btn_SearchButtonStore");
    	//verify the search results in store for key word One
    	//verify Document One name, Link to view / download, API name, API version, API provider
    	checkElementPresent("APIStoreHome.ele_lblDocumentSearchResult_documentName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne,false,"");
    	checkElementPresent("APIStoreHome.ele_lblDocumentSearchResult_documentSummary","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_summaryContent_PARAM:" + APIDocumentation_DocumentVisibility_documentSummeryDocOne,false,"");
    	checkElementPresent("APIStoreHome.lnk_documentSearchResult_viewContent","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne,false,"");
    	checkElementPresent("APIStoreHome.lnk_documentSearchResult_APINameOrVersion","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APINameOrVersion_PARAM:" + APIName,false,"");
    	checkElementPresent("APIStoreHome.lnk_documentSearchResult_APINameOrVersion","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APINameOrVersion_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	if(APIDocumentation_DocumentVisibility_domain.equals("TenantOne")){
    	String var_Providerone = retrieveString("keyTenantOnePublisherUserOne");
    	store("key_domainStore","String",var_Providerone);
    	} else if(APIDocumentation_DocumentVisibility_domain.equals("Admin")){
    	String var_Providerone = retrieveString("keyAdminPublisherUserOne");
    	store("key_domainStore","String",var_Providerone);
    	}
    	String var_ProviderStore = retrieveString("key_domainStore");
    	checkElementPresent("APIStoreHome.ele_lblDocumentSearchResult_provider","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_provider_PARAM:" + var_ProviderStore,false,"");
    	pause(pauseTimes_fourSeconds);
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOne,APIDocumentation_DocumentVisibility_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",APIName);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.btn_Search");
    	click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.btn_Lifecycle");
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.btn_block");
    	pause(pauseTimes_fourSeconds);
    	checkElementPresent("Browse_Doc.ele_lblCurrentStatusBlock",false,"");
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("APIPublisherHome.tf_APISearch",APIDocumentation_DocumentVisibility_searchForDocumentKeyWordHello);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.btn_Search");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	//verify the search results in publisher for key word One
    	//verify Document One name, Link to view / download, API name, API version, API provider
    	checkElementPresent("Browse_Doc.ele_lblDocumentSearchResult_DocumentName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_viewContent","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_keyWordViewContent_PARAM:" + APIDocumentation_DocumentVisibility_keyWordViewContent,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_APIName","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APIName_PARAM:" + APIName,false,"");
    	checkElementPresent("Browse_Doc.lnk_documentSearchResult_APINameWithVersion","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_APIName_PARAM:" + APIName + "_PARAM," + "param_versionOfAPI_PARAM:" + APIDocumentation_DocumentVisibility_APIVersion,false,"");
    	if(APIDocumentation_DocumentVisibility_domain.equals("TenantOne")){
    	String var_ProviderTwo = retrieveString("keyTenantOnePublisherUserOne");
    	store("key_domain","String",var_ProviderTwo);
    	} else if(APIDocumentation_DocumentVisibility_domain.equals("Admin")){
    	String var_ProviderTwo = retrieveString("keyAdminPublisherUserOne");
    	store("key_domain","String",var_ProviderTwo);
    	}
    	String var_ProviderTwo = retrieveString("key_domain");
    	checkElementPresent("Browse_Doc.ele_lblDocumentSearchResult_provider","param_documentName_PARAM:" + APIDocumentation_DocumentVisibility_documentNameDocOne + "_PARAM," + "param_provider_PARAM:" + var_ProviderTwo,false,"");
    	//Navigate to the Store with anonymous User
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_threeSeconds);
    	lib_Common.bc_SelectServer(this, APIDocumentation_DocumentVisibility_keyWordAnonimous);
    	waitForElement("APIStoreHome.tf_APISearchStore",pauseTimes_twoSeconds);
    	type("APIStoreHome.tf_APISearchStore",APIDocumentation_DocumentVisibility_docSearchKeyWord);
    	click("APIStoreHome.btn_SearchButtonStore");
    	checkElementPresent("APIStoreHome.ele_lblSearchTermIsMissing","param_searchTermIsMissing_PARAM:" + APIDocumentation_DocumentVisibility_noMatchingResults,false,"");
    	pause(pauseTimes_fourSeconds);
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_twoSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of excecuting APIM-1056");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}