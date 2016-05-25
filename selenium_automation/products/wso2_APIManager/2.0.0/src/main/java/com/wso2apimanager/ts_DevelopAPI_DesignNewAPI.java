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
 *  Class ts_DevelopAPI_DesignNewAPI implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_DevelopAPI_DesignNewAPI extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APIM_757.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_757")
    public Object[][] dataTable_tc_APIM_757() {     	
    	return this.getDataTable("developAPI_DesignNewAPI","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_757.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_757")
    public final void tc_APIM_757(final String developAPI_DesignNewAPI_APIName, final String developAPI_DesignNewAPI_APIContext, final String developAPI_DesignNewAPI_APIVersion, final String developAPI_DesignNewAPI_publisherUserOne, final String developAPI_DesignNewAPI_adminOrTenantOnePublisherUserOne, final String developAPI_DesignNewAPI_adminOrTenantOnePublisherUserOnePassword, final String developAPI_DesignNewAPI_storeUserOne, final String developAPI_DesignNewAPI_APITagName, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	writeToReport("Start of tc_APIM_757");
    	//publisher login
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,developAPI_DesignNewAPI_adminOrTenantOnePublisherUserOne,developAPI_DesignNewAPI_adminOrTenantOnePublisherUserOnePassword,pauseTimes_sixSeconds);
    	//setting varibales to loops
    	int varCountOne = 0;
    	int varCountTwo = 0;
    	int varCountThree = 0;
    	int varCountFour = 0;
    	int varCountFive = 0;
    	int varCountSix = 0;
    	//start creating APIs using loops to check the alphabatical order
    	for(;varCountOne<4;varCountOne++){
    	//CreateAPI upto design Stage
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_threeSeconds);
    	//Type API Name
    	String varAPIName = "CC"+generateData("String",3)+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPIName);
    	//Type API contest
    	String APIcontest = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontest);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_sixSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	}
    	pause(pauseTimes_threeSeconds);
    	for(;varCountTwo<4;varCountTwo++){
    	//CreateAPI upto design Stage
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fiveSeconds);
    	//Type API Name
    	String varAPIName = "BB"+generateData("String",3)+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPIName);
    	//Type API contest
    	String APIcontest = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontest);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_fiveSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_fiveSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	}
    	pause(pauseTimes_threeSeconds);
    	for(;varCountThree<4;varCountThree++){
    	//CreateAPI upto design Stage
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fiveSeconds);
    	//Type API Name
    	String varAPIName = "AA"+generateData("String",3)+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPIName);
    	//Type API contest
    	String APIcontest = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontest);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_fiveSeconds);
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_fiveSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	}
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	//verifing there are 12 APIs in the page
    	int APICount = getObjectCount("APIPublisherHome.ele_APIWindow");          
    	//check weather the APIs are in the alphabatical order
    	checkSorting("APIPublisherHome.ele_lblAPISquare","string","alphabetically","ascending",false,"");
    	//create another set of APIs
    	for(;varCountFour<4;varCountFour++){
    	//CreateAPI upto design Stage
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fiveSeconds);
    	//Type API Name
    	String varAPIName = "FF"+generateData("String",3)+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPIName);
    	//Type API contest
    	String APIcontest = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontest);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_fiveSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_fiveSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	}
    	pause(pauseTimes_threeSeconds);
    	//create another set of APIs
    	for(;varCountFive<4;varCountFive++){
    	//CreateAPI upto design Stage
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fiveSeconds);
    	//Type API Name
    	String varAPIName = "EE"+generateData("String",3)+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPIName);
    	//Type API contest
    	String APIcontest = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontest);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_fiveSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_fiveSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	}
    	pause(pauseTimes_threeSeconds);
    	for(;varCountSix<4;varCountSix++){
    	//CreateAPI upto design Stage
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fiveSeconds);
    	//Type API Name
    	String varAPIName = "DD"+generateData("String",3)+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPIName);
    	//Type API contest
    	String APIcontest = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontest);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_fiveSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_fiveSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	}
    	click("APIPublisherHome.ele_lblAPIs");
    	click("APIPublisherHome.ele_GotoNextPage");
    	pause(pauseTimes_threeSeconds);
    	//verifing there are 12 APIs in the page
    	int APICountTwo = getObjectCount("APIPublisherHome.ele_APIWindow");          
    	writeToReport(APICountTwo);
    	//check weather the APIs are in the Alphabatical order
    	checkSorting("APIPublisherHome.ele_lblAPISquare","string","alphabetically","ascending",false,"");
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("Start of tc_APIM_757");
    } 
    	

    /**
     * Data provider for Test case tc_APIM_758.
     * @return data table
     */
    @DataProvider(name = "tc_APIM_758")
    public Object[][] dataTable_tc_APIM_758() {     	
    	return this.getDataTable("developAPI_DesignNewAPI","keyWords","pauseTimes","URLs");
    }

    /**
     * Data driven test case tc_APIM_758.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIM_758")
    public final void tc_APIM_758(final String developAPI_DesignNewAPI_APIName, final String developAPI_DesignNewAPI_APIContext, final String developAPI_DesignNewAPI_APIVersion, final String developAPI_DesignNewAPI_publisherUserOne, final String developAPI_DesignNewAPI_adminOrTenantOnePublisherUserOne, final String developAPI_DesignNewAPI_adminOrTenantOnePublisherUserOnePassword, final String developAPI_DesignNewAPI_storeUserOne, final String developAPI_DesignNewAPI_APITagName, final String keyWords_keyWordYes, final String keyWords_keyWordNo, final String keyWords_keyWordPost, final String keyWords_keyWordPatch, final String keyWords_keyWordGet, final String keyWords_keyWordPut, final String keyWords_keyWordHead, final String keyWords_keyWordDelete, final String keyWords_numericValueTwoHundred, final String keyWords_numericValueTwoHundredAndFour, final String keyWords_numericValueOne, final String keyWords_numericValueTwo, final String keyWords_keyWordNull, final String keyWords_keyWordNoContent, final String keyWords_keyWordTrue, final String keyWords_keyWordFalse, final String pauseTimes_oneSecond, final String pauseTimes_twoSeconds, final String pauseTimes_threeSeconds, final String pauseTimes_fourSeconds, final String pauseTimes_fiveSeconds, final String pauseTimes_sixSeconds, final String pauseTimes_sevenSeconds, final String pauseTimes_eightSeconds, final String pauseTimes_nineSeconds, final String pauseTimes_tenSeconds, final String pauseTimes_elevenSeconds, final String pauseTimes_twelveSeconds, final String pauseTimes_thirteenSeconds, final String pauseTimes_fourteenSeconds, final String pauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	writeToReport("Start of tc_APIM_758");
    	//publisher login
    	lib_Common.bc_Login_APIPublisher(this, URLs_publisherURL,developAPI_DesignNewAPI_adminOrTenantOnePublisherUserOne,developAPI_DesignNewAPI_adminOrTenantOnePublisherUserOnePassword,pauseTimes_sixSeconds);
    	//Set variables for loops
    	int varCountOne = 0;
    	int varCountTwo = 0;
    	int varCountThree = 0;
    	int varCountFour = 0;
    	//create APIs With letter B to check the alphabatical order
    	for(;varCountOne<5;varCountOne++){
    	//CreateAPI upto design Stage
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_threeSeconds);
    	//Type API Name
    	String varAPINameOne = "BB"+generateData("String",3)+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameOne);
    	//Type API contest
    	String APIcontestOne = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontestOne);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_sixSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	}
    	pause(pauseTimes_threeSeconds);
    	//create APIs With letter A  to check the alphabatical order
    	for(;varCountTwo<6;varCountTwo++){
    	//CreateAPI upto design Stage
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_threeSeconds);
    	//Type API Name
    	String varAPINameTwo = "AA"+generateData("String",3)+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameTwo);
    	//Type API contest
    	String APIcontestTwo = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontestTwo);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_sixSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	}
    	pause(pauseTimes_threeSeconds);
    	//create APIs With letter E to check the alphabatical order
    	for(;varCountThree<5;varCountThree++){
    	//CreateAPI upto design Stage
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_threeSeconds);
    	//Type API Name
    	String varAPINameThree = "EE"+generateData("String",3)+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameThree);
    	//Type API contest
    	String APIcontestThree = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontestThree);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_sixSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	}
    	pause(pauseTimes_threeSeconds);
    	//create APIs With letter F to check the alphabatical order
    	for(;varCountFour<7;varCountFour++){
    	//CreateAPI upto design Stage
    	click("APIPublisherHome.ele_lblAPIs");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_threeSeconds);
    	//Type API Name
    	String varAPINameFour = "FF"+generateData("String",3)+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameFour);
    	//Type API contest
    	String APIcontestFour = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontestFour);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_sixSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_sixSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_fiveSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	}
    	click("APIPublisherHome.ele_lblAPIs");
    	//create another two APIS to delete
    	waitForElementEnable("APIPublisherHome.lnk_Add");
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fiveSeconds);
    	//Type API Name
    	String varAPINameFive = "CC"+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameFive);
    	//Type API contest
    	String APIcontestFive = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontestFive);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_fiveSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_fiveSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_sixSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	waitForElementEnable("APIPublisherHome.lnk_Add");
    	click("APIPublisherHome.lnk_Add");
    	clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
    	click("APIPublisherAdd.btn_StartCreating");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.tf_APIName",pauseTimes_fiveSeconds);
    	//Type API Name
    	String varAPINameSix = "DD"+developAPI_DesignNewAPI_APIName+generateData("int",3);
    	type("APIPublisherAdd.tf_APIName",varAPINameSix);
    	//Type API contest
    	String APIcontestSix = "api"+generateData("int",5);
    	type("APIPublisherAdd.tf_APIContext",APIcontestSix);
    	type("APIPublisherAdd.tf_APIVersion",developAPI_DesignNewAPI_APIVersion);
    	type("APIPublisherAdd.tf_Tags",developAPI_DesignNewAPI_APITagName+"\n");
    	click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:" + keyWords_keyWordTrue);
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Save",pauseTimes_fiveSeconds);
    	//click save and verify warning
    	clickAt("APIPublisherAdd.btn_Save","0,0");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",pauseTimes_fiveSeconds);
    	checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
    	//waiting for content load
    	waitForElement("APIPublisherAdd.btn_Yes",pauseTimes_sixSeconds);
    	click("APIPublisherAdd.btn_Yes");
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	pause(pauseTimes_twoSeconds);
    	checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
    	type("APIPublisherHome.tf_APISearch",varAPINameFive);
    	click("APIPublisherHome.btn_Search");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	waitForElement("APIPublisherBrowse.btn_deleteAPI","param_APIName_PARAM:" + varAPINameFive,pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_deleteAPI","param_APIName_PARAM:" + varAPINameFive);
    	waitForElement("APIPublisherBrowse.btn_Yes",pauseTimes_threeSeconds);
    	click("APIPublisherBrowse.btn_Yes");
    	pause(pauseTimes_fourSeconds);
    	click("APIPublisherHome.ele_lblAPIs");
    	pause(pauseTimes_threeSeconds);
    	checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPINameSix,false,"");
    	pause(pauseTimes_threeSeconds);
    	//verifying 12 APIS Appear in the page
    	int APICountOne = getObjectCount("APIPublisherHome.ele_APIWindow");          
    	writeToReport(APICountOne);
    	//check weather the APIs are in the alphabatical order
    	checkSorting("APIPublisherHome.ele_lblAPISquare","string","alphabetically","ascending",false,"");
    	//wait for content load
    	pause(pauseTimes_threeSeconds);
    	click("APIPublisherHome.ele_GotoNextPage");
    	pause(pauseTimes_threeSeconds);
    	pause(pauseTimes_threeSeconds);
    	//verifying 12 APIS Appear in the page
    	int APICountTwo = getObjectCount("APIPublisherHome.ele_APIWindow");          
    	writeToReport(APICountTwo);
    	//check weather the APIs are in the alphabatical order
    	checkSorting("APIPublisherHome.ele_lblAPISquare","string","alphabetically","ascending",false,"");
    	lib_Common.bc_DeleteAPI(this, pauseTimes_threeSeconds);
    	writeToReport("Start of tc_APIM_758");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}