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
 *  Class ts_SubscriptionRemoval implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_SubscriptionRemoval extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_SubscriptionRemoval.
     * @return data table
     */
    @DataProvider(name = "tc_SubscriptionRemoval")
    public Object[][] dataTable_tc_SubscriptionRemoval() {     	
    	return this.getDataTable("PauseTimes","URLs","subscriptionRemoval");
    }

    /**
     * Data driven test case tc_SubscriptionRemoval.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_SubscriptionRemoval")
    public final void tc_SubscriptionRemoval(final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String subscriptionRemoval_tenantOrAdmin, final String subscriptionRemoval_ApplicationName, final String subscriptionRemoval_TenantOneOrAdminPublisher, final String subscriptionRemoval_no, final String subscriptionRemoval_yes, final String subscriptionRemoval_keyTypeToInvokeproduction, final String subscriptionRemoval_postResponseCodeFourHundredAndThree, final String subscriptionRemoval_APIName, final String subscriptionRemoval_APIContext, final String subscriptionRemoval_APIVersion, final String subscriptionRemoval_APIvisibility, final String subscriptionRemoval_tagName, final String subscriptionRemoval_urlPatternForPostAndPut, final String subscriptionRemoval_urlPatternForGetDeleteAndHead, final String subscriptionRemoval_productionEndPoint, final String subscriptionRemoval_sandboxEndpoint, final String subscriptionRemoval_tenantOrAdminStoreOne, final String subscriptionRemoval_buttonNamePost, final String subscriptionRemoval_postPayloadContext, final String subscriptionRemoval_postCustomerNameFromPayloadContext) throws Exception {	
    	writeToReport("Start of ts_SubscriptionRemoval");
    	//login to the publisher
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,subscriptionRemoval_TenantOneOrAdminPublisher,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_573(this, subscriptionRemoval_tenantOrAdmin,URLs_storeURL,URLs_publisherURL,subscriptionRemoval_ApplicationName,subscriptionRemoval_TenantOneOrAdminPublisher,subscriptionRemoval_no,subscriptionRemoval_keyTypeToInvokeproduction,subscriptionRemoval_postResponseCodeFourHundredAndThree,subscriptionRemoval_APIName,subscriptionRemoval_APIContext,subscriptionRemoval_APIVersion,subscriptionRemoval_APIvisibility,subscriptionRemoval_tagName,subscriptionRemoval_urlPatternForPostAndPut,subscriptionRemoval_urlPatternForGetDeleteAndHead,subscriptionRemoval_productionEndPoint,subscriptionRemoval_sandboxEndpoint,subscriptionRemoval_tenantOrAdminStoreOne,subscriptionRemoval_buttonNamePost,subscriptionRemoval_postPayloadContext,subscriptionRemoval_postCustomerNameFromPayloadContext,subscriptionRemoval_postResponseCodeFourHundredAndThree,subscriptionRemoval_yes,subscriptionRemoval_postPayloadContext,subscriptionRemoval_yes,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_twoSeconds);
    	writeToReport("End of ts_SubscriptionRemoval");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}