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
 *  Class ts_Scopes implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_Scopes extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_Scope.
     * @return data table
     */
    @DataProvider(name = "tc_Scope")
    public Object[][] dataTable_tc_Scope() {     	
    	return this.getDataTable("URLs","Scope","PauseTimes");
    }

    /**
     * Data driven test case tc_Scope.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Scope")
    public final void tc_Scope(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Scope_domain, final String Scope_APIImagePath, final String Scope_ProductionEndPontJaxRS, final String Scope_URLPattern, final String Scope_verbMethodGET, final String Scope_verbMethodPOST, final String Scope_verbMethodPUT, final String Scope_verbMethodDELETE, final String Scope_userAdmin, final String Scope_AdminPasswd, final String Scope_roleName, final String Scope_scopeKeyOne, final String Scope_tag, final String Scope_scopeNameOne, final String Scope_scopeKeyTwo, final String Scope_scopeNameTwo, final String Scope_scopeKeyThree, final String Scope_scopeNameThree, final String Scope_scopeKeyFour, final String Scope_scopeNameFour, final String Scope_InvalidKey, final String Scope_ScopeDescription, final String Scope_ScopeKeyFive, final String Scope_ScopeNameFive, final String Scope_ScopeKeySix, final String Scope_ScopeNameSix, final String Scope_scopeKeySeven, final String Scope_scopeNameSeven, final String Scope_APIName, final String Scope_APIContest, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of Test Suite Scope");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,Scope_domain,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_175(this, Scope_ProductionEndPontJaxRS,Scope_URLPattern,Scope_verbMethodGET,Scope_verbMethodPOST,Scope_verbMethodPUT,Scope_verbMethodDELETE,"",URLs_publisherURL,Scope_userAdmin,Scope_AdminPasswd,Scope_scopeKeyOne,Scope_tag,Scope_scopeNameOne,Scope_scopeKeyTwo,Scope_scopeNameTwo,Scope_scopeKeyThree,Scope_scopeNameThree,Scope_scopeKeyFour,Scope_scopeNameFour,Scope_APIName,Scope_APIContest,Scope_domain,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_170(this, Scope_InvalidKey,Scope_ScopeDescription,URLs_publisherURL,Scope_domain,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_168(this, PauseTimes_eightSeconds);
    	lib_TestCase.APIM_166(this, Scope_ScopeKeyFive,Scope_ScopeNameFive,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_167(this, Scope_ScopeKeySix,Scope_ScopeNameSix,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_169(this, Scope_scopeKeySeven,Scope_scopeNameSeven,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_171(this, Scope_ScopeKeySix,Scope_ScopeNameSix,PauseTimes_eightSeconds);
    	lib_TestCase.APIM_173(this, PauseTimes_eightSeconds);
    	lib_TestCase.APIM_176(this);
    	lib_TestCase.APIM_174(this, PauseTimes_fourSeconds);
    	lib_TestCase.APIM_177(this, PauseTimes_eightSeconds);
    	//retrieve  API name
    	String varAPINameScope = retrieveString("keyAPIName");
    	//delete created API
    	lib_Common.bc_DeleteAPI(this, varAPINameScope,URLs_publisherURL,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	writeToReport("End of Test Suite Scope");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}