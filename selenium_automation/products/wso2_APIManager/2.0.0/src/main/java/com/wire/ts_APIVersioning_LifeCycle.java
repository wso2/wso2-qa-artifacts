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
 *  Class ts_APIVersioning_LifeCycle implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APIVersioning_LifeCycle extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APIM_501.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_501")
    public Object[][] dataTable_tc_APIM_501() {     	
    	return this.getDataTable("APIVersioning_LifeCycle","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_501.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_501")
    public final void tc_APIM_501(final String APIVersioning_LifeCycle_APIVersion, final String APIVersioning_LifeCycle_APIName, final String APIVersioning_LifeCycle_newVersionOne, final String APIVersioning_LifeCycle_stateCreated, final String APIVersioning_LifeCycle_statePrototyped, final String APIVersioning_LifeCycle_APIContext, final String APIVersioning_LifeCycle_publisherOneOfTenantOneOrAdmin, final String APIVersioning_LifeCycle_StoreOneOfTenantOneOrAdmin, final String APIVersioning_LifeCycle_adminOrTenantOnePublisherUserOne, final String APIVersioning_LifeCycle_adminOrTenantOnePublisherUserOnePassword, final String APIVersioning_LifeCycle_productionEndpoint, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	writeToReport("Start of tc APIM_501");
    	//Log in to API publisher
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,APIVersioning_LifeCycle_adminOrTenantOnePublisherUserOne,APIVersioning_LifeCycle_adminOrTenantOnePublisherUserOnePassword,pauseTimes_fourSeconds);
    	String varUserName = retrieveString(APIVersioning_LifeCycle_adminOrTenantOnePublisherUserOne);
    	//Start creating API
    	click("APIPublisherHome.ele_lblAPIs");
    	waitForElementEnable("APIPublisherHome.lnk_Add");
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fiveSeconds);
    	//Type API Name
    	String varAPINameOne = APIVersioning_LifeCycle_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameOne);
    	//Type API contest
    	String APIcontestOne = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontestOne);
    	type("APIPublisherAdd.tf_APIVersion",APIVersioning_LifeCycle_APIVersion);
    	click("APIPublisherBrowse.btn_NextImplement");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	//wait for content load
    	pause(pauseTimes_fiveSeconds);
    	clickAt("APIPublisherBrowse.ele_lblPrototype","0,0");
    	waitForElement("APIPublisherBrowse.tf_prototypeEndpoint",pauseTimes_sixSeconds);
    	type("APIPublisherBrowse.tf_prototypeEndpoint",APIVersioning_LifeCycle_productionEndpoint);
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_DeployAsPrototype");
    	//wait for content load
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherBrowse.btn_GoToOverview");
    	waitForElement("APIPublisherHome.ele_lblAPIs",pauseTimes_threeSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	checkElementPresent("APIPublisherBrowse.ele_lblStatus","param_APIName_PARAM:" + varAPINameOne + "_PARAM," + "param_version_PARAM:" + APIVersioning_LifeCycle_APIVersion + "_PARAM," + "param_creater_PARAM:" + varUserName + "_PARAM," + "param_status_PARAM:" + APIVersioning_LifeCycle_statePrototyped,false,"");
    	click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPINameOne);
    	//Start creating a New version of a API
    	click("APIPublisherBrowse.btn_CreateNewVersion");
    	waitForElement("APIPublisherBrowse.tf_NewVersion",pauseTimes_threeSeconds);
    	type("APIPublisherBrowse.tf_NewVersion",APIVersioning_LifeCycle_newVersionOne);
    	waitForElement("APIPublisherBrowse.btn_done",pauseTimes_fourSeconds);
    	click("APIPublisherBrowse.btn_done");
    	waitForElement("APIPublisherHome.ele_lblAPIs",pauseTimes_threeSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_sixSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	checkElementPresent("APIPublisherBrowse.ele_lblStatus","param_APIName_PARAM:" + varAPINameOne + "_PARAM," + "param_version_PARAM:" + APIVersioning_LifeCycle_newVersionOne + "_PARAM," + "param_creater_PARAM:" + varUserName + "_PARAM," + "param_status_PARAM:" + APIVersioning_LifeCycle_stateCreated,false,"");
    	//wait for content load
    	pause(pauseTimes_fourSeconds);
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("End of tc APIM_501");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}