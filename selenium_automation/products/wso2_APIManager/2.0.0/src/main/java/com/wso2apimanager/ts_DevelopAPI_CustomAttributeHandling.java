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
 *  Class ts_DevelopAPI_CustomAttributeHandling implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_DevelopAPI_CustomAttributeHandling extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APIM_702.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_702")
    public Object[][] dataTable_tc_APIM_702() {     	
    	return this.getDataTable("developAPI_CustomAttributeHandling","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_702.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_702")
    public final void tc_APIM_702(final String developAPI_CustomAttributeHandling_tenantOrAdminPublisherOne, final String developAPI_CustomAttributeHandling_domain, final String developAPI_CustomAttributeHandling_adminOrTenantPublisherUserOne, final String developAPI_CustomAttributeHandling_adminOrTenantPublisherUserOnePassword, final String developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThree, final String developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThreePassword, final String developAPI_CustomAttributeHandling_StoreUserOne, final String developAPI_CustomAttributeHandling_StoreUserOnePassword, final String developAPI_CustomAttributeHandling_APIName, final String developAPI_CustomAttributeHandling_APIContext, final String developAPI_CustomAttributeHandling_APITag, final String developAPI_CustomAttributeHandling_Description, final String developAPI_CustomAttributeHandling_URLPattern, final String developAPI_CustomAttributeHandling_verbMethodGET, final String developAPI_CustomAttributeHandling_ProductionEndPontJaxRS, final String developAPI_CustomAttributeHandling_SandboxEndpoint, final String developAPI_CustomAttributeHandling_ResponseCaching, final String developAPI_CustomAttributeHandling_jasonFileName, final String developAPI_CustomAttributeHandling_APIVersionOne, final String developAPI_CustomAttributeHandling_APIvisibility, final String developAPI_CustomAttributeHandling_APIImageName, final String developAPI_CustomAttributeHandling_urlPatternForPostAndPut, final String developAPI_CustomAttributeHandling_urlPatternForGetDeleteAndHead, final String developAPI_CustomAttributeHandling_cacheTimeForTimeOut, final String developAPI_CustomAttributeHandling_StoreOneOfTenanrOrAdmin, final String developAPI_CustomAttributeHandling_serverNameDomainOne, final String developAPI_CustomAttributeHandling_keywordEnabled, final String developAPI_CustomAttributeHandling_invalidRoleToVisible, final String developAPI_CustomAttributeHandling_numberOfUsersZero, final String developAPI_CustomAttributeHandling_statusPublished, final String developAPI_CustomAttributeHandling_statusCreadted, final String developAPI_CustomAttributeHandling_resourseTierLevel, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//APIM2-702: Save an API at Design stage
    	writeToReport("Start  Executing APIM2-702");
    	//call Login_APIPublisher bc
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThree,developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThreePassword,pauseTimes_fourSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	waitForElementEnable("APIPublisherHome.lnk_Add");
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fourSeconds);
    	//Type API Name
    	String varAPIName = developAPI_CustomAttributeHandling_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPIName);
    	//Type API contest
    	type("APIPublisherAdd.tf_APIContext",developAPI_CustomAttributeHandling_APIContext+generateData("int",3));
    	String varAPIVersion = developAPI_CustomAttributeHandling_APIVersionOne;
    	//Store API Name and Version
    	if(developAPI_CustomAttributeHandling_tenantOrAdminPublisherOne.equals("TenantOnePublisherOne")){
    	store("keyTenantAPIVersion","String",varAPIVersion);
    	store("keyTenantAPIName","String",varAPIName);
    	} else if(developAPI_CustomAttributeHandling_tenantOrAdminPublisherOne.equals("AdminPublisherOne")){
    	store("keyAdminAPIVersion","String",varAPIVersion);
    	store("keyAdminAPIName","String",varAPIName);
    	}
    	//Type API Version
    	type("APIPublisherAdd.tf_APIVersion",varAPIVersion);
    	pause(pauseTimes_threeSeconds);
    	select("APIPublisherBrowse.ele_ddVisibility",developAPI_CustomAttributeHandling_APIvisibility);
    	//Type valid image path 
    	 java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator + developAPI_CustomAttributeHandling_APIImageName);
    	String entirePath = file.getAbsolutePath();
    	type("APIPublisherAdd.btn_BrowseImage",entirePath);
    	type("APIPublisherAdd.tf_Discription",developAPI_CustomAttributeHandling_Description);
    	int a = 0;
    	for(;a<15;a++){
    	//Genarate Tag Name
    	String TagName = developAPI_CustomAttributeHandling_APITag+"_"+generateData("int",3);
    	type("APIPublisherAdd.tf_Tags",TagName);
    	type("APIPublisherAdd.tf_Tags",TagName+org.openqa.selenium.Keys.ENTER);
    	pause(pauseTimes_twoSeconds);
    	}
    	clickAt("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,"0,0");
    	pause(pauseTimes_threeSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_sixSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_threeSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_threeSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	//waiting for content load
    	pause(pauseTimes_threeSeconds);
    	//Verifiy Design UI stay loaded
    	checkElementPresent("APIPublisherBrowse.ele_lblGeneralDetails",false,"");
    	pause(pauseTimes_fourSeconds);
    	//Go to browse page
    	click("APIPublisherHome.lnk_APIs");
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	pause(pauseTimes_threeSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherHome.tf_APISearch",pauseTimes_sixSeconds);
    	type("APIPublisherHome.tf_APISearch",varAPIName);
    	//waiting for content load
    	waitForElement("APIPublisherHome.btn_Search",pauseTimes_sixSeconds);
    	click("APIPublisherHome.btn_Search");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPIName,pauseTimes_sixSeconds);
    	//Verifing the API name and the virsion
    	checkElementPresent("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPIName + "_PARAM," + "param_APIVersion_PARAM:" + varAPIVersion + "_PARAM," + "param_APIName_PARAM:" + varAPIName,false,"");
    	click("APIPublisherBrowse.lnk_EditIcon");
    	//Check Design tab is available
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.ele_lblDesign",pauseTimes_fiveSeconds);
    	click("APIPublisherBrowse.ele_lblDesign");
    	//Verifing the Design tab is available
    	checkElementPresent("APIPublisherBrowse.ele_lblGeneralDetails",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.ele_ddVisibility",pauseTimes_sixSeconds);
    	//Select Restricted by roles option
    	select("APIPublisherBrowse.ele_ddVisibility","Restricted by roles");
    	click("APIPublisherBrowse.btn_Ok");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.tf_VisibilityToRole",pauseTimes_sixSeconds);
    	//Retrieve Role
    	if(developAPI_CustomAttributeHandling_StoreOneOfTenanrOrAdmin.equals("TenantOneStoreOne")){
    	//Retriveing Visibility Role
    	String varVisibilityToRole = retrieveString("KeyVisibilityRole");
    	//Store Visibility Role
    	store("varVisibilityToRoleOne","String",varVisibilityToRole);
    	//
    	} else if(developAPI_CustomAttributeHandling_StoreOneOfTenanrOrAdmin.equals("AdminStoreOne")){
    	//Retriveing Visibility Role
    	String varVisibilityToRole = retrieveString("KeyVisibilityRoleAdmin");
    	//Store Visibility Role
    	store("varVisibilityToRoleOne","String",varVisibilityToRole);
    	}
    	//Retriveing Visibility Role
    	String varVisibilityToRoleOneRetrieve = retrieveString("varVisibilityToRoleOne");
    	//Type valid Visibility Role
    	type("APIPublisherBrowse.tf_VisibilityToRole",varVisibilityToRoleOneRetrieve);
    	clickAt("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue,"0,0");
    	pause(pauseTimes_threeSeconds);
    	//Click on save button
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	pause(pauseTimes_fiveSeconds);
    	//Type invalid Visibility Role
    	type("APIPublisherBrowse.tf_VisibilityToRole",developAPI_CustomAttributeHandling_invalidRoleToVisible);
    	pause(pauseTimes_threeSeconds);
    	//Click on save button
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	pause(pauseTimes_fourSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.ele_lblInvalidImageError",pauseTimes_eightSeconds);
    	//Verifing the Error
    	checkElementPresent("APIPublisherBrowse.ele_lblInvalidImageError",false,"");
    	writeToReport("End of  Executing APIM2-702");
    } 
    	

    /**
     * Data provider for Test case tc_APIM_709.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_709")
    public Object[][] dataTable_tc_APIM_709() {     	
    	return this.getDataTable("developAPI_CustomAttributeHandling","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_709.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_709")
    public final void tc_APIM_709(final String developAPI_CustomAttributeHandling_tenantOrAdminPublisherOne, final String developAPI_CustomAttributeHandling_domain, final String developAPI_CustomAttributeHandling_adminOrTenantPublisherUserOne, final String developAPI_CustomAttributeHandling_adminOrTenantPublisherUserOnePassword, final String developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThree, final String developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThreePassword, final String developAPI_CustomAttributeHandling_StoreUserOne, final String developAPI_CustomAttributeHandling_StoreUserOnePassword, final String developAPI_CustomAttributeHandling_APIName, final String developAPI_CustomAttributeHandling_APIContext, final String developAPI_CustomAttributeHandling_APITag, final String developAPI_CustomAttributeHandling_Description, final String developAPI_CustomAttributeHandling_URLPattern, final String developAPI_CustomAttributeHandling_verbMethodGET, final String developAPI_CustomAttributeHandling_ProductionEndPontJaxRS, final String developAPI_CustomAttributeHandling_SandboxEndpoint, final String developAPI_CustomAttributeHandling_ResponseCaching, final String developAPI_CustomAttributeHandling_jasonFileName, final String developAPI_CustomAttributeHandling_APIVersionOne, final String developAPI_CustomAttributeHandling_APIvisibility, final String developAPI_CustomAttributeHandling_APIImageName, final String developAPI_CustomAttributeHandling_urlPatternForPostAndPut, final String developAPI_CustomAttributeHandling_urlPatternForGetDeleteAndHead, final String developAPI_CustomAttributeHandling_cacheTimeForTimeOut, final String developAPI_CustomAttributeHandling_StoreOneOfTenanrOrAdmin, final String developAPI_CustomAttributeHandling_serverNameDomainOne, final String developAPI_CustomAttributeHandling_keywordEnabled, final String developAPI_CustomAttributeHandling_invalidRoleToVisible, final String developAPI_CustomAttributeHandling_numberOfUsersZero, final String developAPI_CustomAttributeHandling_statusPublished, final String developAPI_CustomAttributeHandling_statusCreadted, final String developAPI_CustomAttributeHandling_resourseTierLevel, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//APIM2-709: Save an API at Imeplement stage
    	writeToReport("Start  Executing APIM2-709");
    	//Call Login APIPublisher BC
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThree,developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThreePassword,pauseTimes_fourSeconds);
    	//Retrieve API Name and Version
    	if(developAPI_CustomAttributeHandling_tenantOrAdminPublisherOne.equals("TenantOnePublisherOne")){
    	//Retrieve API Name
    	String var_APINameOne = retrieveString("keyTenantAPIName");
    	//Retrieve API Version
    	String var_APIVersionOne = retrieveString("keyTenantAPIVersion");
    	//Store API Name
    	store("var_APINameOneStore","String",var_APINameOne);
    	//Store API Version
    	store("var_APIVersionOneStore","String",var_APIVersionOne);
    	} else if(developAPI_CustomAttributeHandling_tenantOrAdminPublisherOne.equals("AdminPublisherOne")){
    	//Retrieve API Name
    	String var_APINameOne = retrieveString("keyAdminAPIName");
    	//Retrieve API Version
    	String var_APIVersionOne = retrieveString("keyAdminAPIVersion");
    	//Store API Name
    	store("var_APINameOneStore","String",var_APINameOne);
    	//Store API Version
    	store("var_APIVersionOneStore","String",var_APIVersionOne);
    	}
    	//Retrieve API Version
    	String var_APINameOneRetrieve = retrieveString("var_APINameOneStore");
    	//Retrieve API Version
    	String var_APIVersionOneRetrieve = retrieveString("var_APIVersionOneStore");
    	//wait for content load
    	waitForElement("APIPublisherHome.lnk_APIs",pauseTimes_sixSeconds);
    	//Go to browse page
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_APIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	//Search API name
    	type("APIPublisherHome.tf_APISearch",var_APINameOneRetrieve);
    	click("APIPublisherHome.btn_Search");
    	//wait for content load
    	pause(pauseTimes_sixSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + var_APINameOneRetrieve,pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.lnk_EditIcon");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.btn_NextImplement",pauseTimes_sixSeconds);
    	//click on next emplement
    	click("APIPublisherBrowse.btn_NextImplement");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.ele_lblManagedAPI",pauseTimes_sixSeconds);
    	//click on managed API
    	clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
    	//type production endpoint
    	type("APIPublisherBrowse.tf_ProductionEndPoint",developAPI_CustomAttributeHandling_ProductionEndPontJaxRS);
    	//type sandbox end point
    	type("APIPublisherBrowse.tf_sandboxEndpoint",developAPI_CustomAttributeHandling_SandboxEndpoint);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	pause(pauseTimes_threeSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.btn_Save",pauseTimes_sixSeconds);
    	//click on save
    	click("APIPublisherBrowse.btn_Save");
    	pause(pauseTimes_twoSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordFalse);
    	pause(pauseTimes_threeSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherHome.lnk_APIs",pauseTimes_sixSeconds);
    	//click on browse
    	click("APIPublisherHome.lnk_APIs");
    	//Search API name
    	type("APIPublisherHome.tf_APISearch",var_APINameOneRetrieve);
    	click("APIPublisherHome.btn_Search");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + var_APINameOneRetrieve + "_PARAM," + "param_APIVersion_PARAM:" + var_APIVersionOneRetrieve + "_PARAM," + "param_APIName_PARAM:" + var_APINameOneRetrieve,pauseTimes_sixSeconds);
    	//Verifing the API name, Status and the virsion
    	checkElementPresent("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + var_APINameOneRetrieve + "_PARAM," + "param_APIVersion_PARAM:" + var_APIVersionOneRetrieve + "_PARAM," + "param_APIName_PARAM:" + var_APINameOneRetrieve,false,"");
    	click("APIPublisherBrowse.lnk_EditIcon");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	//Verifing Design and Implement are activated
    	waitForElement("APIPublisherBrowse.ele_lblDesign",pauseTimes_threeSeconds);
    	//Verifiy Design tab is available
    	click("APIPublisherBrowse.ele_lblDesign");
    	checkElementPresent("APIPublisherBrowse.ele_lblGeneralDetails",false,"");
    	//Verifiy Implement tab is available
    	click("APIPublisherBrowse.ele_lblImplement");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.ele_lblManagedAPI",pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblManagedAPI",false,"");
    	writeToReport("End of  Executing APIM2-709");
    } 
    	

    /**
     * Data provider for Test case tc_APIM_717.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_717")
    public Object[][] dataTable_tc_APIM_717() {     	
    	return this.getDataTable("developAPI_CustomAttributeHandling","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_717.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_717")
    public final void tc_APIM_717(final String developAPI_CustomAttributeHandling_tenantOrAdminPublisherOne, final String developAPI_CustomAttributeHandling_domain, final String developAPI_CustomAttributeHandling_adminOrTenantPublisherUserOne, final String developAPI_CustomAttributeHandling_adminOrTenantPublisherUserOnePassword, final String developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThree, final String developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThreePassword, final String developAPI_CustomAttributeHandling_StoreUserOne, final String developAPI_CustomAttributeHandling_StoreUserOnePassword, final String developAPI_CustomAttributeHandling_APIName, final String developAPI_CustomAttributeHandling_APIContext, final String developAPI_CustomAttributeHandling_APITag, final String developAPI_CustomAttributeHandling_Description, final String developAPI_CustomAttributeHandling_URLPattern, final String developAPI_CustomAttributeHandling_verbMethodGET, final String developAPI_CustomAttributeHandling_ProductionEndPontJaxRS, final String developAPI_CustomAttributeHandling_SandboxEndpoint, final String developAPI_CustomAttributeHandling_ResponseCaching, final String developAPI_CustomAttributeHandling_jasonFileName, final String developAPI_CustomAttributeHandling_APIVersionOne, final String developAPI_CustomAttributeHandling_APIvisibility, final String developAPI_CustomAttributeHandling_APIImageName, final String developAPI_CustomAttributeHandling_urlPatternForPostAndPut, final String developAPI_CustomAttributeHandling_urlPatternForGetDeleteAndHead, final String developAPI_CustomAttributeHandling_cacheTimeForTimeOut, final String developAPI_CustomAttributeHandling_StoreOneOfTenanrOrAdmin, final String developAPI_CustomAttributeHandling_serverNameDomainOne, final String developAPI_CustomAttributeHandling_keywordEnabled, final String developAPI_CustomAttributeHandling_invalidRoleToVisible, final String developAPI_CustomAttributeHandling_numberOfUsersZero, final String developAPI_CustomAttributeHandling_statusPublished, final String developAPI_CustomAttributeHandling_statusCreadted, final String developAPI_CustomAttributeHandling_resourseTierLevel, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//APIM2-717: Save an API at Manage stage
    	writeToReport("Start  Executing APIM2-717");
    	//call Login APIPublisher bc
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThree,developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThreePassword,pauseTimes_fourSeconds);
    	//Retrieve and Store API Name and Version
    	if(developAPI_CustomAttributeHandling_tenantOrAdminPublisherOne.equals("TenantOnePublisherOne")){
    	//Retrieve API Name
    	String var_APINameOne = retrieveString("keyTenantAPIName");
    	//Retrieve API Version
    	String var_APIVersionOne = retrieveString("keyTenantAPIVersion");
    	//Store API Name
    	store("var_APINameOneStore","String",var_APINameOne);
    	//Store API Version
    	store("var_APIVersionOneStore","String",var_APIVersionOne);
    	} else if(developAPI_CustomAttributeHandling_tenantOrAdminPublisherOne.equals("AdminPublisherOne")){
    	//Retrieve API Name
    	String var_APINameOne = retrieveString("keyAdminAPIName");
    	//Retrieve API Version
    	String var_APIVersionOne = retrieveString("keyAdminAPIVersion");
    	//Store API Name
    	store("var_APINameOneStore","String",var_APINameOne);
    	//Store API Version
    	store("var_APIVersionOneStore","String",var_APIVersionOne);
    	}
    	//Retrieve API Name
    	String var_APINameOneRetrieve = retrieveString("var_APINameOneStore");
    	//Retrieve API Version
    	String var_APIVersionOneRetrieve = retrieveString("var_APIVersionOneStore");
    	//Search API name
    	type("APIPublisherHome.tf_APISearch",var_APINameOneRetrieve);
    	//click on search button
    	click("APIPublisherHome.btn_Search");
    	//waiting for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.lnk_EditIcon");
    	//click on next implement
    	click("APIPublisherBrowse.ele_lblImplement");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.btn_NextManage",pauseTimes_sixSeconds);
    	//click on next manage
    	waitForElementEnable("APIPublisherBrowse.btn_NextManage");
    	click("APIPublisherBrowse.btn_NextManage");
    	//waiting for content load
    	waitForElementEnable("APIPublisherBrowse.ele_ddTierAvilability");
    	//select tiers
    	click("APIPublisherBrowse.ele_ddTierAvilability");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.chk_Unlimited",pauseTimes_oneSecond);
    	click("APIPublisherBrowse.chk_Unlimited");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.chk_Gold",pauseTimes_oneSecond);
    	click("APIPublisherBrowse.chk_Gold");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.chk_Silver",pauseTimes_oneSecond);
    	click("APIPublisherBrowse.chk_Silver");
    	waitForElement("APIPublisherBrowse.chk_Bronze",pauseTimes_oneSecond);
    	click("APIPublisherBrowse.chk_Bronze");
    	//waiting for content load
    	pause(pauseTimes_fourSeconds);
    	//select response caching
    	select("APIPublisherBrowse.ele_ddResponseCaching",developAPI_CustomAttributeHandling_ResponseCaching);
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.tf_APIMange_cacheTimeout",pauseTimes_sixSeconds);
    	type("APIPublisherBrowse.tf_APIMange_cacheTimeout",developAPI_CustomAttributeHandling_cacheTimeForTimeOut);
    	//Verifiy Resources specified under API definition
    	checkElementPresent("APIPublisherBrowse.ele_lblApiResources","param_APIResource_PARAM:" + keyWords_keyWordPost,false,"");
    	checkElementPresent("APIPublisherBrowse.ele_lblApiResources","param_APIResource_PARAM:" + keyWords_keyWordGet,false,"");
    	checkElementPresent("APIPublisherBrowse.ele_lblApiResources","param_APIResource_PARAM:" + keyWords_keyWordPut,false,"");
    	checkElementPresent("APIPublisherBrowse.ele_lblApiResources","param_APIResource_PARAM:" + keyWords_keyWordDelete,false,"");
    	checkElementPresent("APIPublisherBrowse.ele_lblApiResources","param_APIResource_PARAM:" + keyWords_keyWordPatch,false,"");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	pause(pauseTimes_threeSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.btn_SaveManageAPI",pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.btn_SaveManageAPI");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.btn_Close",pauseTimes_sixSeconds);
    	//API is successfully published
    	click("APIPublisherBrowse.btn_Close");
    	//Check Manage UI stay loaded
    	checkElementPresent("APIPublisherBrowse.ele_lblConfigurations",false,"");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordFalse);
    	pause(pauseTimes_threeSeconds);
    	//waiting for content load
    	waitForElement("APIPublisherHome.lnk_APIs",pauseTimes_sixSeconds);
    	//click on browse
    	click("APIPublisherHome.lnk_APIs");
    	//Search API name
    	type("APIPublisherHome.tf_APISearch",var_APINameOneRetrieve);
    	click("APIPublisherHome.btn_Search");
    	String var_UserName = retrieveString(developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThree);
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.lnk_APINameOverall","param_APIName_PARAM:" + var_APINameOneRetrieve + "_PARAM," + "param_version_PARAM:" + var_APIVersionOneRetrieve + "_PARAM," + "param_provider_PARAM:" + var_UserName + "_PARAM," + "param_numberOfUsers_PARAM:" + developAPI_CustomAttributeHandling_numberOfUsersZero+" Users" + "_PARAM," + "param_status_PARAM:" + developAPI_CustomAttributeHandling_statusCreadted,pauseTimes_fiveSeconds);
    	//Verifing the API name, Status and the virsion
    	checkElementPresent("APIPublisherBrowse.lnk_APINameOverall","param_APIName_PARAM:" + var_APINameOneRetrieve + "_PARAM," + "param_version_PARAM:" + var_APIVersionOneRetrieve + "_PARAM," + "param_provider_PARAM:" + var_UserName + "_PARAM," + "param_numberOfUsers_PARAM:" + developAPI_CustomAttributeHandling_numberOfUsersZero+" Users" + "_PARAM," + "param_status_PARAM:" + developAPI_CustomAttributeHandling_statusCreadted,false,"");
    	click("APIPublisherBrowse.lnk_EditIcon");
    	//waiting for content load
    	pause(pauseTimes_threeSeconds);
    	waitForElement("APIPublisherBrowse.ele_lblDesign",pauseTimes_threeSeconds);
    	//Verifiy Design tab is Available
    	click("APIPublisherBrowse.ele_lblDesign");
    	checkElementPresent("APIPublisherBrowse.ele_lblGeneralDetails",false,"");
    	//Verifiy Implement tab is Available
    	click("APIPublisherBrowse.ele_lblImplement");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.ele_lblManagedAPI",pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblManagedAPI",false,"");
    	click("APIPublisherBrowse.ele_lblDesign");
    	//Verifiy Manage tab is Available
    	click("APIPublisherBrowse.ele_lblManage");
    	//waiting for content load
    	waitForElement("APIPublisherBrowse.ele_lblConfigurations",pauseTimes_fourSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblConfigurations",false,"");
    	//Call Delete API BC
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End  Executing APIM2-717");
    } 
    	

    /**
     * Data provider for Test case tc_APIM_688.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_688")
    public Object[][] dataTable_tc_APIM_688() {     	
    	return this.getDataTable("developAPI_CustomAttributeHandling","keyWords","pauseTimes","URLs","common");
    }

    /**
     * Data driven test case tc_APIM_688.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_688")
    public final void tc_APIM_688(final String developAPI_CustomAttributeHandling_tenantOrAdminPublisherOne, final String developAPI_CustomAttributeHandling_domain, final String developAPI_CustomAttributeHandling_adminOrTenantPublisherUserOne, final String developAPI_CustomAttributeHandling_adminOrTenantPublisherUserOnePassword, final String developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThree, final String developAPI_CustomAttributeHandling_adminOrTenantOnePublisherUserThreePassword, final String developAPI_CustomAttributeHandling_StoreUserOne, final String developAPI_CustomAttributeHandling_StoreUserOnePassword, final String developAPI_CustomAttributeHandling_APIName, final String developAPI_CustomAttributeHandling_APIContext, final String developAPI_CustomAttributeHandling_APITag, final String developAPI_CustomAttributeHandling_Description, final String developAPI_CustomAttributeHandling_URLPattern, final String developAPI_CustomAttributeHandling_verbMethodGET, final String developAPI_CustomAttributeHandling_ProductionEndPontJaxRS, final String developAPI_CustomAttributeHandling_SandboxEndpoint, final String developAPI_CustomAttributeHandling_ResponseCaching, final String developAPI_CustomAttributeHandling_jasonFileName, final String developAPI_CustomAttributeHandling_APIVersionOne, final String developAPI_CustomAttributeHandling_APIvisibility, final String developAPI_CustomAttributeHandling_APIImageName, final String developAPI_CustomAttributeHandling_urlPatternForPostAndPut, final String developAPI_CustomAttributeHandling_urlPatternForGetDeleteAndHead, final String developAPI_CustomAttributeHandling_cacheTimeForTimeOut, final String developAPI_CustomAttributeHandling_StoreOneOfTenanrOrAdmin, final String developAPI_CustomAttributeHandling_serverNameDomainOne, final String developAPI_CustomAttributeHandling_keywordEnabled, final String developAPI_CustomAttributeHandling_invalidRoleToVisible, final String developAPI_CustomAttributeHandling_numberOfUsersZero, final String developAPI_CustomAttributeHandling_statusPublished, final String developAPI_CustomAttributeHandling_statusCreadted, final String developAPI_CustomAttributeHandling_resourseTierLevel, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String common_superAdminUserName, final String common_superAdminPassword, final String common_carbonURL, final String common_PublisherURL, final String common_storeURL) throws Exception {	
    	writeToReport("Start of tc APIM 688");
    	writeToReport("Start of Preconditions");
    	//Loging to API publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,developAPI_CustomAttributeHandling_adminOrTenantPublisherUserOne,developAPI_CustomAttributeHandling_adminOrTenantPublisherUserOnePassword,pauseTimes_fourSeconds);
    	//As a precondition create API and get the swagger url by getting the current URL
    	click("APIPublisherHome.ele_lblAPIs");
    	waitForElementEnable("APIPublisherHome.lnk_Add");
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fourSeconds);
    	//Type API Name
    	String varAPINameOne = developAPI_CustomAttributeHandling_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameOne);
    	//Type API contest
    	type("APIPublisherAdd.tf_APIContext",developAPI_CustomAttributeHandling_APIContext+generateData("int",3));
    	type("APIPublisherAdd.tf_APIVersion",developAPI_CustomAttributeHandling_APIVersionOne);
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_NextImplement");
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	pause(pauseTimes_sixSeconds);
    	clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
    	//Type Production endpoint
    	type("APIPublisherBrowse.tf_ProductionEndPoint",developAPI_CustomAttributeHandling_ProductionEndPontJaxRS);
    	//Type Sandbox endpoint
    	type("APIPublisherBrowse.tf_SandBoxEndPoint",developAPI_CustomAttributeHandling_SandboxEndpoint);
    	//Wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_NextManage");
    	//Wait for content load
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.chk_Unlimited");
    	//Wait for content load
    	pause(pauseTimes_twoSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_SaveAndPublish");
    	//Wait for content load
    	pause(pauseTimes_eightSeconds);
    	//Navigate to Store
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_fiveSeconds);
    	//Select domain
    	lib_Common.bc_SelectServer(this, developAPI_CustomAttributeHandling_domain);
    	//Type in API search text box
    	type("APIStoreHome.tf_APISearchStore",varAPINameOne);
    	click("APIStoreHome.btn_SearchButtonStore");
    	//Wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + varAPINameOne);
    	//Wait for content load
    	waitForElement("APIStoreAPIs.ele_tabAPIConsole",pauseTimes_fiveSeconds);
    	click("APIStoreAPIs.ele_tabAPIConsole");
    	//Wait for content load
    	waitForElement("APIStoreAPIConsole.lnk_swaggerJason",pauseTimes_threeSeconds);
    	click("APIStoreAPIConsole.lnk_swaggerJason");
    	//Wait for content load
    	pause(pauseTimes_fourSeconds);
    	selectWindow("Browse_Doc.window");
    	//Set variable to get the current URL
    	String var_jasonURL = getDriver().getCurrentUrl();
    	writeToReport("End of Preconditions");
    	//Navigate to publisher
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_fiveSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	//Wait for content load
    	pause(pauseTimes_twoSeconds);
    	waitForElement("APIPublisherHome.lnk_Add",pauseTimes_threeSeconds);
    	clickAt("APIPublisherHome.lnk_Add","0,0");
    	//Wait for content load
    	waitForElement("APIPublisherAdd.rdo_DesignNewAPI",pauseTimes_sixSeconds);
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	//Wait for content load
    	waitForElement("APIPublisherAdd.btn_StartCreating",pauseTimes_sixSeconds);
    	click("APIPublisherAdd.btn_StartCreating");
    	//Wait for content load
    	pause(pauseTimes_fourSeconds);
    	//Go to swagger section
    	click("APIPublisherAdd.btn_swaggerImport");
    	//Wait for content load
    	waitForElement("APIPublisherAdd.ele_lblimportAPIDefinition",pauseTimes_threeSeconds);
    	//Verify api definitionsection appear
    	checkElementPresent("APIPublisherAdd.ele_lblimportAPIDefinition",false,"");
    	click("APIPublisherAdd.rdo_uploadAPIDefinitionAs_swaggerUrl");
    	//Type the swagger URL
    	type("APIPublisherAdd.tf_uploadAPIDefinitionAs_swaggerUrl",var_jasonURL);
    	click("APIPublisherAdd.btn_importSwagger");
    	//Wait for content load
    	pause(pauseTimes_fourSeconds);
    	//Set variable to API name and API version
    	String varAPINAME = getStringProperty("APIPublisherAdd.tf_APIName","VALUE:");
    	String varAPIVERSION = getStringProperty("APIPublisherAdd.tf_APIVersion","VALUE:");
    	//Verifiy API design fields
    	if(varAPINameOne.equals(varAPINAME) && developAPI_CustomAttributeHandling_APIVersionOne.equals(varAPIVERSION)){
    	//Wait for content load
    	pause(pauseTimes_twoSeconds);
    	//API Definition : API resource URLs should be populated along with the relevant HTTP verb according to the definition
    	checkElementPresent("APIPublisherBrowse.ele_lblApiResources","param_APIResource_PARAM:" + keyWords_keyWordPost,false,"");
    	//Wait for content load
    	pause(pauseTimes_twoSeconds);
    	//API Definition : API resource URLs should be populated along with the relevant HTTP verb according to the definition
    	checkElementPresent("APIPublisherBrowse.ele_lblApiResources","param_APIResource_PARAM:" + keyWords_keyWordGet,false,"");
    	pause(pauseTimes_twoSeconds);
    	//API Definition : API resource URLs should be populated along with the relevant HTTP verb according to the definition
    	checkElementPresent("APIPublisherBrowse.ele_lblApiResources","param_APIResource_PARAM:" + keyWords_keyWordPut,false,"");
    	//Wait for content load
    	pause(pauseTimes_twoSeconds);
    	//API Definition : API resource URLs should be populated along with the relevant HTTP verb according to the definition
    	checkElementPresent("APIPublisherBrowse.ele_lblApiResources","param_APIResource_PARAM:" + keyWords_keyWordDelete,false,"");
    	//Wait for content load
    	pause(pauseTimes_twoSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblApiResources","param_APIResource_PARAM:" + keyWords_keyWordPatch,false,"");
    	//Wait for content load
    	pause(pauseTimes_twoSeconds);
    	//Generate API name again to type
    	String APIName = developAPI_CustomAttributeHandling_APIName+"_"+generateData("int",4);
    	type("APIPublisherAdd.tf_APIName",APIName);
    	pause(pauseTimes_fourteenSeconds);
    	type("APIPublisherAdd.tf_APIContext",developAPI_CustomAttributeHandling_APIContext+"_"+generateData("int",4));
    	//adding  resource verbs
    	click("APIPublisherAdd.chk_Put");
    	click("APIPublisherAdd.chk_Post");
    	type("APIPublisherAdd.tf_URLPattern",developAPI_CustomAttributeHandling_urlPatternForPostAndPut);
    	//Wait for content load
    	pause(pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Add");
    	pause(pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.chk_Get");
    	click("APIPublisherAdd.chk_Delete");
    	click("APIPublisherAdd.chk_Head");
    	pause(pauseTimes_fiveSeconds);
    	type("APIPublisherAdd.tf_URLPattern",developAPI_CustomAttributeHandling_urlPatternForGetDeleteAndHead);
    	//Wait for content load
    	pause(pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Add");
    	//Wait for content load
    	pause(pauseTimes_fiveSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	pause(pauseTimes_threeSeconds);
    	//Click next implement
    	click("APIPublisherAdd.lnk_NextImplement");
    	//Wait for content load
    	pause(pauseTimes_sixSeconds);
    	//Verify manage section
    	checkElementPresent("APIPublisherBrowse.ele_lblManagedAPI",false,"");
    	//Wait for content load
    	pause(pauseTimes_twoSeconds);
    	clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
    	//Type end points
    	type("APIPublisherBrowse.tf_ProductionEndPoint",developAPI_CustomAttributeHandling_ProductionEndPontJaxRS);
    	type("APIPublisherBrowse.tf_SandBoxEndPoint",developAPI_CustomAttributeHandling_SandboxEndpoint);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherAdd.lnk_NextManage");
    	//select tiers
    	//Wait for content load
    	pause(pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblConfigurations",false,"");
    	click("APIPublisherBrowse.ele_ddTierAvilability");
    	waitForElement("APIPublisherBrowse.chk_Unlimited",pauseTimes_oneSecond);
    	click("APIPublisherBrowse.chk_Unlimited");
    	waitForElement("APIPublisherBrowse.chk_Gold",pauseTimes_oneSecond);
    	click("APIPublisherBrowse.chk_Gold");
    	waitForElement("APIPublisherBrowse.chk_Silver",pauseTimes_oneSecond);
    	click("APIPublisherBrowse.chk_Silver");
    	waitForElement("APIPublisherBrowse.chk_Bronze",pauseTimes_oneSecond);
    	click("APIPublisherBrowse.chk_Bronze");
    	waitForElement("APIPublisherBrowse.ele_ddTierAvilability",pauseTimes_oneSecond);
    	click("APIPublisherBrowse.ele_ddTierAvilability");
    	//waiting for content load
    	pause(pauseTimes_fourSeconds);
    	//select response caching
    	select("APIPublisherBrowse.ele_ddResponseCaching",developAPI_CustomAttributeHandling_ResponseCaching);
    	//Wait for content load
    	waitForElement("APIPublisherBrowse.tf_APIMange_cacheTimeout",pauseTimes_sixSeconds);
    	type("APIPublisherBrowse.tf_APIMange_cacheTimeout",developAPI_CustomAttributeHandling_cacheTimeForTimeOut);
    	//Wait for content load
    	pause(pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblResourseTierLevel","param_APIResource_PARAM:" + keyWords_keyWordGet + "_PARAM," + "param_tierLevel_PARAM:" + developAPI_CustomAttributeHandling_resourseTierLevel,false,"");
    	//Wait for content load
    	pause(pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblResourseTierLevel","param_APIResource_PARAM:" + keyWords_keyWordDelete + "_PARAM," + "param_tierLevel_PARAM:" + developAPI_CustomAttributeHandling_resourseTierLevel,false,"");
    	//Wait for content load
    	pause(pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblResourseTierLevel","param_APIResource_PARAM:" + keyWords_keyWordHead + "_PARAM," + "param_tierLevel_PARAM:" + developAPI_CustomAttributeHandling_resourseTierLevel,false,"");
    	//Wait for content load
    	pause(pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblResourseTierLevel","param_APIResource_PARAM:" + keyWords_keyWordPost + "_PARAM," + "param_tierLevel_PARAM:" + developAPI_CustomAttributeHandling_resourseTierLevel,false,"");
    	//Wait for content load
    	pause(pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblResourseTierLevel","param_APIResource_PARAM:" + keyWords_keyWordPut + "_PARAM," + "param_tierLevel_PARAM:" + developAPI_CustomAttributeHandling_resourseTierLevel,false,"");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	pause(pauseTimes_threeSeconds);
    	//Wait for content load
    	pause(pauseTimes_fiveSeconds);
    	click("APIPublisherBrowse.btn_SaveAndPublish");
    	pause(pauseTimes_threeSeconds);
    	//A notification mentioning successful creation of API should be displayed with the following options.
    	//Keep editting APIs
    	//Go to API store
    	//API Overview
    	checkElementPresent("APIPublisherBrowse.btn_keepEditting",false,"");
    	//Wait for content load
    	pause(pauseTimes_twoSeconds);
    	checkElementPresent("APIPublisherBrowse.btn_GoToOverview",false,"");
    	//Wait for content load
    	pause(pauseTimes_twoSeconds);
    	checkElementPresent("APIPublisherBrowse.btn_gotoAPIStore",false,"");
    	//Wait for content load
    	pause(pauseTimes_twoSeconds);
    	//Wait for content load
    	pause(pauseTimes_tenSeconds);
    	writeToReport("End of tc APIM 688");
    	} else {
    	//delete the created API
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	fail("Name and version does not match");
    	}
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}