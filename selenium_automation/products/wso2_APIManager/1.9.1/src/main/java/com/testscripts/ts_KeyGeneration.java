package com.testscripts;

import java.util.HashMap;
import java.util.List;

import com.virtusa.isq.vtaf.aspects.VTAFRecoveryMethods;
import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import com.virtusa.isq.vtaf.runtime.VTAFTestListener;


/**
 *  Class ts_KeyGeneration implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_KeyGeneration extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_Key_Generation_With_Scopes.
     * @return data table
     */
    @DataProvider(name = "tc_Key_Generation_With_Scopes")
    public Object[][] dataTable_tc_Key_Generation_With_Scopes() {     	
    	return this.getDataTable("URLs","Key_Generation_With_Scopes","KeyWords","PauseTimes");
    }

    /**
     * Data driven test case tc_Key_Generation_With_Scopes.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Key_Generation_With_Scopes")
    public final void tc_Key_Generation_With_Scopes(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Key_Generation_With_Scopes_APIName, final String Key_Generation_With_Scopes_APIContext, final String Key_Generation_With_Scopes_APIVersion, final String Key_Generation_With_Scopes_tagName, final String Key_Generation_With_Scopes_storeRole, final String Key_Generation_With_Scopes_verbMethodNameGet, final String Key_Generation_With_Scopes_tier, final String Key_Generation_With_Scopes_productionEndPoint, final String Key_Generation_With_Scopes_sandBoxEndPoint, final String Key_Generation_With_Scopes_appName, final String Key_Generation_With_Scopes_verbMethodNamePost, final String Key_Generation_With_Scopes_domain, final String Key_Generation_With_Scopes_publisher, final String Key_Generation_With_Scopes_store, final String KeyWords_keyWordYes, final String KeyWords_keyWordNo, final String KeyWords_keyWordPost, final String KeyWords_keyWordGet, final String KeyWords_keyWordPut, final String KeyWords_keyWordHead, final String KeyWords_keyWordDelete, final String KeyWords_numericValueTwoHundred, final String KeyWords_numericValueTwoHundredAndFour, final String KeyWords_numericValueOne, final String KeyWords_numericValueTwo, final String KeyWords_keyWordNull, final String KeyWords_keyWordNoContent, final String KeyWords_keyWordTrue, final String KeyWords_keyWordFalse, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of executing tc_Key_Generation_With_Scopes");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,Key_Generation_With_Scopes_publisher,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_360(this, Key_Generation_With_Scopes_APIName,Key_Generation_With_Scopes_storeRole,Key_Generation_With_Scopes_verbMethodNameGet,URLs_storeURL,Key_Generation_With_Scopes_APIContext,Key_Generation_With_Scopes_APIContext,Key_Generation_With_Scopes_tagName,Key_Generation_With_Scopes_productionEndPoint,Key_Generation_With_Scopes_sandBoxEndPoint,Key_Generation_With_Scopes_appName,Key_Generation_With_Scopes_domain,Key_Generation_With_Scopes_store,PauseTimes_eightSeconds,PauseTimes_fourSeconds,PauseTimes_threeSeconds,PauseTimes_sixSeconds,KeyWords_numericValueOne);
    	lib_TestCase.APIM_361(this, Key_Generation_With_Scopes_APIName,URLs_storeURL,Key_Generation_With_Scopes_verbMethodNamePost,URLs_publisherURL,Key_Generation_With_Scopes_storeRole,Key_Generation_With_Scopes_domain,PauseTimes_fourSeconds,PauseTimes_eightSeconds,KeyWords_numericValueOne,KeyWords_numericValueTwo);
    	lib_TestCase.APIM_362(this, URLs_publisherURL,Key_Generation_With_Scopes_APIName,URLs_storeURL,Key_Generation_With_Scopes_storeRole,Key_Generation_With_Scopes_domain,PauseTimes_fourSeconds,PauseTimes_eightSeconds,KeyWords_numericValueOne,KeyWords_numericValueTwo);
    	String varAPIName = retrieveString("keyAPIName");
    	String varAPIVersion = retrieveString("keyAPIVersion");
    	String varAPPName = retrieveString("keyAPPName");
    	lib_Common.bc_UnSubscribeDeleteAPIMultiUser(this, URLs_storeURL,varAPIName,varAPIVersion,URLs_publisherURL,varAPPName,Key_Generation_With_Scopes_domain,Key_Generation_With_Scopes_store,PauseTimes_twoSeconds,PauseTimes_fourSeconds);
    	writeToReport("End of executing tc_Key_Generation_With_Scopes");
    } 
    	

    /**
     * Data provider for Test case tc_New_Key_Generation.
     * @return data table
     */
    @DataProvider(name = "tc_New_Key_Generation")
    public Object[][] dataTable_tc_New_Key_Generation() {     	
    	return this.getDataTable("URLs","NewKeyGeneration","PauseTimes");
    }

    /**
     * Data driven test case tc_New_Key_Generation.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_New_Key_Generation")
    public final void tc_New_Key_Generation(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String NewKeyGeneration_domain, final String NewKeyGeneration_APINameOne, final String NewKeyGeneration_APIOneContext, final String NewKeyGeneration_APIOneVersion, final String NewKeyGeneration_APIOneTagName, final String NewKeyGeneration_APIOneImagePath, final String NewKeyGeneration_APIOneDescription, final String NewKeyGeneration_APIOneURLPattern, final String NewKeyGeneration_productionEndPoint, final String NewKeyGeneration_sandBoxEndPoint, final String NewKeyGeneration_appName, final String NewKeyGeneration_tokenValue, final String NewKeyGeneration_throttlingTier, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of ts_NewKeyGeneration");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,NewKeyGeneration_domain,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_207(this, NewKeyGeneration_APINameOne,NewKeyGeneration_productionEndPoint,NewKeyGeneration_APIOneContext,NewKeyGeneration_APIOneTagName,NewKeyGeneration_APIOneImagePath,NewKeyGeneration_APIOneVersion,NewKeyGeneration_sandBoxEndPoint,NewKeyGeneration_appName,NewKeyGeneration_tokenValue,NewKeyGeneration_tokenValue,URLs_storeURL,NewKeyGeneration_throttlingTier,NewKeyGeneration_domain,PauseTimes_eightSeconds,PauseTimes_fourSeconds);
    	String varAPIName = retrieveString("keyAPIName");
    	String varAPIVersion = retrieveString("keyAPIVersion");
    	String varAPPName = retrieveString("keyAPPName");
    	lib_Common.bc_UnSubscribeDeleteAPI(this, URLs_storeURL,varAPIName,varAPIVersion,URLs_publisherURL,varAPPName,NewKeyGeneration_domain,PauseTimes_threeSeconds,PauseTimes_fiveSeconds);
    	writeToReport("End of ts_NewKeyGeneration.");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}