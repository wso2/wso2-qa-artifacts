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
 *  Class ts_CreateAPIForExistingSoapEndpoint implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_CreateAPIForExistingSoapEndpoint extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_CreateAPIForExistingSoapEndpoint.
     * @return data table
     */
    @DataProvider(name = "tc_CreateAPIForExistingSoapEndpoint")
    public Object[][] dataTable_tc_CreateAPIForExistingSoapEndpoint() {     	
    	return this.getDataTable("URLs","WithoutDefaultVersion","KeyWords","CreateAPIForExistingSoapEndpoint","PauseTimes");
    }

    /**
     * Data driven test case tc_CreateAPIForExistingSoapEndpoint.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_CreateAPIForExistingSoapEndpoint")
    public final void tc_CreateAPIForExistingSoapEndpoint(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String WithoutDefaultVersion_apiName, final String WithoutDefaultVersion_apiContext, final String WithoutDefaultVersion_apiVersionOne, final String WithoutDefaultVersion_apiVersionTwo, final String WithoutDefaultVersion_apiVisibilityPublic, final String WithoutDefaultVersion_apiImage, final String WithoutDefaultVersion_apiTagName, final String WithoutDefaultVersion_productionEndpoint, final String WithoutDefaultVersion_sandboxEndpoint, final String WithoutDefaultVersion_numberOfUsersZero, final String WithoutDefaultVersion_statusCreated, final String WithoutDefaultVersion_statusPublished, final String WithoutDefaultVersion_statusDeprecated, final String WithoutDefaultVersion_publisherOneOfTenantOneOrAdmin, final String WithoutDefaultVersion_storeOneOfTenantOneOrAdmin, final String WithoutDefaultVersion_serverNameDomainOne, final String WithoutDefaultVersion_urlPatternForPostAndPut, final String WithoutDefaultVersion_urlPatternForGetDeleteAndHead, final String WithoutDefaultVersion_applicationName, final String WithoutDefaultVersion_applicationDiscription, final String WithoutDefaultVersion_keyTypeToInvoke, final String WithoutDefaultVersion_postPayloadContext, final String WithoutDefaultVersion_postCustomerNameFromPayloadContext, final String WithoutDefaultVersion_postResponseHeaders, final String WithoutDefaultVersion_getCustomerName, final String WithoutDefaultVersion_getResponseHeaders, final String WithoutDefaultVersion_putCustomerName, final String WithoutDefaultVersion_getCustomerNameForPutVerification, final String WithoutDefaultVersion_getResponseHeadersForPutVerification, final String WithoutDefaultVersion_deleteResponseHeaders, final String WithoutDefaultVersion_invokeTypeProduction, final String WithoutDefaultVersion_invokeTypeSandbox, final String WithoutDefaultVersion_tierType, final String WithoutDefaultVersion_numberOfUsersOne, final String KeyWords_keyWordYes, final String KeyWords_keyWordNo, final String KeyWords_keyWordPost, final String KeyWords_keyWordGet, final String KeyWords_keyWordPut, final String KeyWords_keyWordHead, final String KeyWords_keyWordDelete, final String KeyWords_numericValueTwoHundred, final String KeyWords_numericValueTwoHundredAndFour, final String KeyWords_numericValueOne, final String KeyWords_numericValueTwo, final String KeyWords_keyWordNull, final String KeyWords_keyWordNoContent, final String KeyWords_keyWordTrue, final String KeyWords_keyWordFalse, final String CreateAPIForExistingSoapEndpoint_apiName, final String CreateAPIForExistingSoapEndpoint_apiVersionOne, final String CreateAPIForExistingSoapEndpoint_apiVisibilityPublic, final String CreateAPIForExistingSoapEndpoint_apiImage, final String CreateAPIForExistingSoapEndpoint_apiTagName, final String CreateAPIForExistingSoapEndpoint_WSDLUrl, final String CreateAPIForExistingSoapEndpoint_storeOneOfTenantOneOrAdmin, final String CreateAPIForExistingSoapEndpoint_applicationName, final String CreateAPIForExistingSoapEndpoint_tierType, final String CreateAPIForExistingSoapEndpoint_numericValueTwoHundred, final String CreateAPIForExistingSoapEndpoint_publisherOneOfTenantOneOrAdmin, final String CreateAPIForExistingSoapEndpoint_payloadContext, final String CreateAPIForExistingSoapEndpoint_productionEndpoint, final String CreateAPIForExistingSoapEndpoint_soapAction, final String CreateAPIForExistingSoapEndpoint_serverNameDomainOne, final String CreateAPIForExistingSoapEndpoint_keywordEnabled, final String CreateAPIForExistingSoapEndpoint_cacheTimeout, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of CreateAPIForExistingSoapEndpoint.");
    	lib_TestCase.APIM2_3(this, URLs_publisherURL,CreateAPIForExistingSoapEndpoint_publisherOneOfTenantOneOrAdmin,CreateAPIForExistingSoapEndpoint_apiName,CreateAPIForExistingSoapEndpoint_apiVersionOne,CreateAPIForExistingSoapEndpoint_apiVisibilityPublic,CreateAPIForExistingSoapEndpoint_apiImage,CreateAPIForExistingSoapEndpoint_apiTagName,CreateAPIForExistingSoapEndpoint_WSDLUrl,CreateAPIForExistingSoapEndpoint_productionEndpoint,KeyWords_keyWordNo,"",KeyWords_keyWordNo,KeyWords_keyWordNo,KeyWords_keyWordNo,KeyWords_keyWordNo,"",URLs_storeURL,CreateAPIForExistingSoapEndpoint_serverNameDomainOne,CreateAPIForExistingSoapEndpoint_storeOneOfTenantOneOrAdmin,CreateAPIForExistingSoapEndpoint_applicationName,CreateAPIForExistingSoapEndpoint_tierType,KeyWords_keyWordPost,CreateAPIForExistingSoapEndpoint_payloadContext,KeyWords_numericValueTwoHundred,CreateAPIForExistingSoapEndpoint_soapAction,PauseTimes_twoSeconds,PauseTimes_threeSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds,CreateAPIForExistingSoapEndpoint_keywordEnabled,CreateAPIForExistingSoapEndpoint_cacheTimeout);
    	writeToReport("End of CreateAPIForExistingSoapEndpoint.");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}