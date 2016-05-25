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
 *  Class ts_ManageAPI_TagManagement implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_ManageAPI_TagManagement extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APIM_527.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_527")
    public Object[][] dataTable_tc_APIM_527() {     	
    	return this.getDataTable("manageAPI_TagManagement","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_527.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_527")
    public final void tc_APIM_527(final String manageAPI_TagManagement_domain, final String manageAPI_TagManagement_APIName, final String manageAPI_TagManagement_APIContext, final String manageAPI_TagManagement_tag, final String manageAPI_TagManagement_APIVersion, final String manageAPI_TagManagement_adminOrTenantOnePublisherUserOne, final String manageAPI_TagManagement_adminOrTenantOnePublisherUserOnePassword, final String manageAPI_TagManagement_adminOrTenantOneStoreUserOne, final String manageAPI_TagManagement_adminOrTenantOneStoreUserOnePassword, final String manageAPI_TagManagement_productionEndPoint, final String manageAPI_TagManagement_sandboxEndPoint, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	writeToReport("start of tc_APIM_527");
    	//Login to API publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,manageAPI_TagManagement_adminOrTenantOnePublisherUserOne,manageAPI_TagManagement_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	//Create Another API to publish stage
    	click("APIPublisherHome.ele_lblAPIs");
    	waitForElementEnable("APIPublisherHome.lnk_Add");
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fourSeconds);
    	//Type API Name
    	String varAPINameOne = manageAPI_TagManagement_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameOne);
    	String varAPIContext = manageAPI_TagManagement_APIContext+generateData("int",3);
    	//Type API contest
    	type("APIPublisherAdd.tf_APIContext",varAPIContext);
    	type("APIPublisherAdd.tf_APIVersion",manageAPI_TagManagement_APIVersion);
    	String varAPITagOne = manageAPI_TagManagement_tag+generateData("int",3);
    	String varAPITagTwo = manageAPI_TagManagement_tag+generateData("int",3);
    	String varAPITagThree = manageAPI_TagManagement_tag+generateData("int",3);
    	type("APIPublisherAdd.tf_Tags",varAPITagOne+"\n");
    	type("APIPublisherAdd.tf_Tags",varAPITagTwo+"\n");
    	type("APIPublisherAdd.tf_Tags",varAPITagThree+"\n");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_NextImplement");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	//wait for content load
    	pause(pauseTimes_sixSeconds);
    	clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
    	type("APIPublisherBrowse.tf_ProductionEndPoint",manageAPI_TagManagement_productionEndPoint);
    	type("APIPublisherBrowse.tf_SandBoxEndPoint",manageAPI_TagManagement_sandboxEndPoint);
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
    	navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + URLs_storeURL,pauseTimes_fourSeconds);
    	lib_Common.bc_SelectServer(this, manageAPI_TagManagement_domain);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIStoreAPIs.lnk_tags","param_tags_PARAM:" + varAPITagOne);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + varAPINameOne,false,"");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIStoreAPIs.lnk_tags","param_tags_PARAM:" + varAPITagTwo);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + varAPINameOne,false,"");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIStoreAPIs.lnk_tags","param_tags_PARAM:" + varAPITagThree);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + varAPINameOne,false,"");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	//Login to API store
    	lib_Common.bc_Login_APIStore(this, manageAPI_TagManagement_adminOrTenantOneStoreUserOne,manageAPI_TagManagement_adminOrTenantOneStoreUserOnePassword,pauseTimes_threeSeconds,pauseTimes_sixSeconds);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIStoreAPIs.lnk_tags","param_tags_PARAM:" + varAPITagOne);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + varAPINameOne,false,"");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIStoreAPIs.lnk_tags","param_tags_PARAM:" + varAPITagTwo);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + varAPINameOne,false,"");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIStoreAPIs.lnk_tags","param_tags_PARAM:" + varAPITagThree);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + varAPINameOne,false,"");
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,pauseTimes_threeSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of tc_APIM_527");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}