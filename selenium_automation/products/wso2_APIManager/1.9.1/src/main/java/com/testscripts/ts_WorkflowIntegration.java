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
 *  Class ts_WorkflowIntegration implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_WorkflowIntegration extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APISubscription.
     * @return data table
     */
    @DataProvider(name = "tc_APISubscription")
    public Object[][] dataTable_tc_APISubscription() {     	
    	return this.getDataTable("URLs","APISubscription","PauseTimes");
    }

    /**
     * Data driven test case tc_APISubscription.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APISubscription")
    public final void tc_APISubscription(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String APISubscription_domain, final String APISubscription_APIName, final String APISubscription_APIContext, final String APISubscription_APIVersion, final String APISubscription_APIImagePath, final String APISubscription_tagName, final String APISubscription_productionEndPoint, final String APISubscription_sandBoxEndPoint, final String APISubscription_appName, final String APISubscription_throttlingTier, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of executing tc_APISubscription");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,APISubscription_domain,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_2A(this, APISubscription_APIName,APISubscription_APIImagePath,APISubscription_APIVersion,APISubscription_tagName,URLs_storeURL,URLs_publisherURL,APISubscription_APIContext,APISubscription_productionEndPoint,APISubscription_sandBoxEndPoint,APISubscription_appName,APISubscription_domain,APISubscription_throttlingTier,PauseTimes_eightSeconds,PauseTimes_threeSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	writeToReport("End of executing tc_APISubscription");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}