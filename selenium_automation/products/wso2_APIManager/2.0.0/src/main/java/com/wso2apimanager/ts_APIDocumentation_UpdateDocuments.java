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
 *  Class ts_APIDocumentation_UpdateDocuments implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APIDocumentation_UpdateDocuments extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APIM_100.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_100")
    public Object[][] dataTable_tc_APIM_100() {     	
    	return this.getDataTable("APIDocumentation_UpdateDocuments","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_100.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_100")
    public final void tc_APIM_100(final String APIDocumentation_UpdateDocuments_domain, final String APIDocumentation_UpdateDocuments_apiName, final String APIDocumentation_UpdateDocuments_apiContext, final String APIDocumentation_UpdateDocuments_apiVersion, final String APIDocumentation_UpdateDocuments_docName, final String APIDocumentation_UpdateDocuments_ProductionEndPoint, final String APIDocumentation_UpdateDocuments_SandBoxEndPoint, final String APIDocumentation_UpdateDocuments_sourseUrl, final String APIDocumentation_UpdateDocuments_docSummery, final String APIDocumentation_UpdateDocuments_docSummeryTwo, final String APIDocumentation_UpdateDocuments_APIStatus, final String APIDocumentation_UpdateDocuments_adminOrTenantOnePublisherUserOne, final String APIDocumentation_UpdateDocuments_adminOrTenantOnePublisherUserOnePassword, final String APIDocumentation_UpdateDocuments_adminOrTenantOneStoreUserOne, final String APIDocumentation_UpdateDocuments_adminOrTenantOneStoreUserOnePassword, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	writeToReport("start of tc APIM-100");
    	//publisher login
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_UpdateDocuments_adminOrTenantOnePublisherUserOne,APIDocumentation_UpdateDocuments_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	//Create Another API Without using loop
    	click("APIPublisherHome.ele_lblAPIs");
    	waitForElementEnable("APIPublisherHome.lnk_Add");
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fourSeconds);
    	//Type API Name
    	String varAPINameOne = APIDocumentation_UpdateDocuments_apiName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameOne);
    	//Type API contest
    	String APIcontestTwo = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontestTwo);
    	type("APIPublisherAdd.tf_APIVersion",APIDocumentation_UpdateDocuments_apiVersion);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_NextImplement");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	//wait for content load
    	pause(pauseTimes_sixSeconds);
    	clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
    	type("APIPublisherBrowse.tf_ProductionEndPoint",APIDocumentation_UpdateDocuments_ProductionEndPoint);
    	type("APIPublisherBrowse.tf_SandBoxEndPoint",APIDocumentation_UpdateDocuments_SandBoxEndPoint);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_NextManage");
    	//wait for content load
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.chk_Unlimited");
    	//wait for content load
    	pause(pauseTimes_twoSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	clickAt("APIPublisherBrowse.btn_SaveAndPublish","0,0");
    	//wait for content load
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.btn_GoToOverview");
    	waitForElement("APIPublisherHome.ele_lblAPIs",pauseTimes_sixSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_twoSeconds);
    	String publisherUserName = retrieveString(APIDocumentation_UpdateDocuments_adminOrTenantOnePublisherUserOne);
    	checkElementPresent("APIPublisherBrowse.ele_lblStatus","param_APIName_PARAM:" + varAPINameOne + "_PARAM," + "param_version_PARAM:" + APIDocumentation_UpdateDocuments_apiVersion + "_PARAM," + "param_creater_PARAM:" + publisherUserName + "_PARAM," + "param_status_PARAM:" + APIDocumentation_UpdateDocuments_APIStatus,false,"");
    	click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameOne + "_PARAM," + "param_APIVersion_PARAM:" + APIDocumentation_UpdateDocuments_apiVersion + "_PARAM," + "param_APIName_PARAM:" + varAPINameOne);
    	waitForElement("Browse_Doc.lnk_Doc",pauseTimes_fourSeconds);
    	click("Browse_Doc.lnk_Doc");
    	waitForElement("Browse_Doc.btn_AddNewDocument",pauseTimes_threeSeconds);
    	click("Browse_Doc.btn_AddNewDocument");
    	String varDocName = APIDocumentation_UpdateDocuments_docName+generateData("int",3);
    	type("Browse_Doc.tf_DocName",varDocName);
    	type("Browse_Doc.tf_Summary",APIDocumentation_UpdateDocuments_docSummery);
    	click("Browse_Doc.rdo_PublicForum");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	//rdo_inactiveInLine object captured with disabled property
    	checkElementPresent("Browse_Doc.rdo_inactiveInLine",false,"");
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of tc_APIM_100");
    } 
    	

    /**
     * Data provider for Test case tc_APIM_997.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_997")
    public Object[][] dataTable_tc_APIM_997() {     	
    	return this.getDataTable("APIDocumentation_UpdateDocuments","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_997.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_997")
    public final void tc_APIM_997(final String APIDocumentation_UpdateDocuments_domain, final String APIDocumentation_UpdateDocuments_apiName, final String APIDocumentation_UpdateDocuments_apiContext, final String APIDocumentation_UpdateDocuments_apiVersion, final String APIDocumentation_UpdateDocuments_docName, final String APIDocumentation_UpdateDocuments_ProductionEndPoint, final String APIDocumentation_UpdateDocuments_SandBoxEndPoint, final String APIDocumentation_UpdateDocuments_sourseUrl, final String APIDocumentation_UpdateDocuments_docSummery, final String APIDocumentation_UpdateDocuments_docSummeryTwo, final String APIDocumentation_UpdateDocuments_APIStatus, final String APIDocumentation_UpdateDocuments_adminOrTenantOnePublisherUserOne, final String APIDocumentation_UpdateDocuments_adminOrTenantOnePublisherUserOnePassword, final String APIDocumentation_UpdateDocuments_adminOrTenantOneStoreUserOne, final String APIDocumentation_UpdateDocuments_adminOrTenantOneStoreUserOnePassword, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	writeToReport("start od tc_APIM_997");
    	//login to API Publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIDocumentation_UpdateDocuments_adminOrTenantOnePublisherUserOne,APIDocumentation_UpdateDocuments_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	//Create up tp publish stage
    	click("APIPublisherHome.ele_lblAPIs");
    	waitForElementEnable("APIPublisherHome.lnk_Add");
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fourSeconds);
    	//Type API Name
    	String varAPINameOne = APIDocumentation_UpdateDocuments_apiName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameOne);
    	//Type API contest
    	String varContext = APIDocumentation_UpdateDocuments_apiContext+generateData("int",3);
    	type("APIPublisherAdd.tf_APIContext",varContext);
    	type("APIPublisherAdd.tf_APIVersion",APIDocumentation_UpdateDocuments_apiVersion);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_NextImplement");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	//wait for content load
    	pause(pauseTimes_sixSeconds);
    	clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
    	type("APIPublisherBrowse.tf_ProductionEndPoint",APIDocumentation_UpdateDocuments_ProductionEndPoint);
    	type("APIPublisherBrowse.tf_SandBoxEndPoint",APIDocumentation_UpdateDocuments_SandBoxEndPoint);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_NextManage");
    	//wait for content load
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.chk_Unlimited");
    	//wait for content load
    	pause(pauseTimes_twoSeconds);
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	clickAt("APIPublisherBrowse.btn_SaveAndPublish","0,0");
    	//wait for content load
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.btn_GoToOverview");
    	waitForElement("APIPublisherHome.ele_lblAPIs",pauseTimes_sixSeconds);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_twoSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameOne + "_PARAM," + "param_APIVersion_PARAM:" + APIDocumentation_UpdateDocuments_apiVersion + "_PARAM," + "param_APIName_PARAM:" + varAPINameOne);
    	waitForElement("Browse_Doc.lnk_Doc",pauseTimes_fourSeconds);
    	click("Browse_Doc.lnk_Doc");
    	waitForElement("Browse_Doc.btn_AddNewDocument",pauseTimes_threeSeconds);
    	click("Browse_Doc.btn_AddNewDocument");
    	String varDocName = APIDocumentation_UpdateDocuments_docName+generateData("int",3);
    	type("Browse_Doc.tf_DocName",varDocName);
    	type("Browse_Doc.tf_Summary",APIDocumentation_UpdateDocuments_docSummery);
    	click("Browse_Doc.rdo_HowTo");
    	click("Browse_Doc.rdo_Inline");
    	click("Browse_Doc.btn_AddDocument");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameOne + "_PARAM," + "param_APIVersion_PARAM:" + APIDocumentation_UpdateDocuments_apiVersion + "_PARAM," + "param_APIName_PARAM:" + varAPINameOne);
    	waitForElement("Browse_Doc.lnk_Doc",pauseTimes_fourSeconds);
    	click("Browse_Doc.lnk_Doc");
    	//wait for content load
    	pause(pauseTimes_twoSeconds);
    	click("Browse_Doc.btn_Update","param_DocName_PARAM:" + varDocName);
    	//check wether the summery can be edited
    	checkObjectProperty("Browse_Doc.tf_Summary","PROPERTYPRESENT","disabled|false",false,"summery not editable");
    	type("Browse_Doc.tf_Summary",APIDocumentation_UpdateDocuments_docSummeryTwo);
    	//check wether the type can be edited
    	checkObjectProperty("Browse_Doc.rdo_SampleAndSDK","PROPERTYPRESENT","disabled|false",false,"type not editable");
    	pause(pauseTimes_twoSeconds);
    	//check wether the sourse can be edited
    	checkObjectProperty("Browse_Doc.rdo_URL","PROPERTYPRESENT","disabled|false",false,"Sourse not editable");
    	click("Browse_Doc.rdo_URL");
    	type("Browse_Doc.tf_URL",APIDocumentation_UpdateDocuments_sourseUrl);
    	click("Browse_Doc.btn_UpdateCreatedDoc");
    	//wait for content load
    	pause(pauseTimes_twoSeconds);
    	click("Browse_Doc.btn_View","param_docName_PARAM:" + varDocName);
    	//wait for content load
    	pause(pauseTimes_sixSeconds);
    	//focus into new window
    	selectWindow("Browse_Doc.newWindow1");
    	//close newly opend window
    	closeWindow();
    	switchUser("default");
    	//focus to main window
    	selectWindow("Browse_Doc.defaultWindow");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	//move to store
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_fourSeconds);
    	lib_Common.bc_SelectServer(this, APIDocumentation_UpdateDocuments_domain);
    	//wait for content load
    	pause(pauseTimes_fiveSeconds);
    	//Login to API store
    	lib_Common.bc_Login_APIStore(this, APIDocumentation_UpdateDocuments_adminOrTenantOneStoreUserOne,APIDocumentation_UpdateDocuments_adminOrTenantOneStoreUserOnePassword,pauseTimes_threeSeconds,pauseTimes_sixSeconds);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	type("APIStoreHome.tf_APISearchStore",varAPINameOne);
    	click("APIStoreHome.btn_SearchButtonStore");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + varAPINameOne);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIStoreHome.lnk_Documents");
    	checkElementPresent("APIStoreDocumentation.lnk_HowTo",false,"");
    	checkElementPresent("APIStoreDocumentation.ele_lblDocumentName","param_DocName_PARAM:" + varDocName,false,"");
    	checkElementPresent("APIStoreDocumentation.lnk_Summery","param_Summery_PARAM:" + APIDocumentation_UpdateDocuments_docSummeryTwo,false,"");
    	checkElementPresent("APIStoreDocumentation.lnk_URL","param_URL_PARAM:" + APIDocumentation_UpdateDocuments_sourseUrl,false,"null");
    	click("APIStoreDocumentation.lnk_URL","param_URL_PARAM:" + APIDocumentation_UpdateDocuments_sourseUrl);
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	selectWindow("Browse_Doc.newWindow1");
    	closeWindow();
    	switchUser("default");
    	selectWindow("Browse_Doc.defaultWindow");
    	//wait for content load
    	pause(pauseTimes_twoSeconds);
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_fourSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of tc_APIM_997");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}