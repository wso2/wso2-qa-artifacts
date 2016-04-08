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
 *  Class ts_APILifecycleManagement implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APILifecycleManagement extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_APILifeCycleManagement.
     * @return data table
     */
    @DataProvider(name = "tc_APILifeCycleManagement")
    public Object[][] dataTable_tc_APILifeCycleManagement() {     	
    	return this.getDataTable("URLs","APILifecycleManagement","DeleteAllApplicationsAndAPIsFromAllTenants","PauseTimes");
    }

    /**
     * Data driven test case tc_APILifeCycleManagement.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APILifeCycleManagement")
    public final void tc_APILifeCycleManagement(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String APILifecycleManagement_domain, final String APILifecycleManagement_APINameOne, final String APILifecycleManagement_APIOneContext, final String APILifecycleManagement_APIOneVersion, final String APILifecycleManagement_APIOneTagName, final String APILifecycleManagement_APIOneImagePath, final String APILifecycleManagement_APIOneDescription, final String APILifecycleManagement_APIOneURLPattern, final String APILifecycleManagement_productionEndPoint, final String APILifecycleManagement_sandBoxEndPoint, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainOneTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOrAdminPublisherUser, final String DeleteAllApplicationsAndAPIsFromAllTenants_DefaultApplication, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserThree, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainTwoTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainCondition, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminPublisherUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminPublisherUserOne, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of ts_APILifeCycleManagement");
    	lib_Common.bc_DeleteAllApplicationsAndAPIsFromAllTenants(this, URLs_storeURL,DeleteAllApplicationsAndAPIsFromAllTenants_DomainOneTenantOrAdmin,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserTwo,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserOne,URLs_publisherURL,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOrAdminPublisherUser,DeleteAllApplicationsAndAPIsFromAllTenants_DefaultApplication,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserThree,DeleteAllApplicationsAndAPIsFromAllTenants_DomainTwoTenantOrAdmin,DeleteAllApplicationsAndAPIsFromAllTenants_DomainCondition,DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminStoreUserOne,DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminPublisherUserOne,DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserOne,DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserTwo,DeleteAllApplicationsAndAPIsFromAllTenants_AdminPublisherUserOne,PauseTimes_sixSeconds,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	//login to the publisher
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,APILifecycleManagement_domain,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_21(this, APILifecycleManagement_APINameOne,APILifecycleManagement_APIOneContext,APILifecycleManagement_APIOneVersion,APILifecycleManagement_APIOneImagePath,APILifecycleManagement_APIOneTagName,APILifecycleManagement_APIOneURLPattern,PauseTimes_fourSeconds);
    	String varAPINameTwo = retrieveString("keyAPINameOne");
    	lib_Common.bc_DeleteAPI(this, varAPINameTwo,URLs_publisherURL,PauseTimes_threeSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	writeToReport("End of ts_APILifeCycleManagement");
    } 
    	

    /**
     * Data provider for Test case tc_APIStates_Created.
     * @return data table
     */
    @DataProvider(name = "tc_APIStates_Created")
    public Object[][] dataTable_tc_APIStates_Created() {     	
    	return this.getDataTable("URLs","APIStates_Created","KeyWords","PauseTimes");
    }

    /**
     * Data driven test case tc_APIStates_Created.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIStates_Created")
    public final void tc_APIStates_Created(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String APIStates_Created_apiName, final String APIStates_Created_apiContext, final String APIStates_Created_apiVersionOne, final String APIStates_Created_apiVisibilityPublic, final String APIStates_Created_apiImage, final String APIStates_Created_apiTagName, final String APIStates_Created_productionEndpoint, final String APIStates_Created_sandboxEndpoint, final String APIStates_Created_statusCreated, final String APIStates_Created_statusPublished, final String APIStates_Created_publisherOneOfTenantOneOrAdmin, final String APIStates_Created_storeOneOfTenantOneOrAdmin, final String APIStates_Created_serverNameDomainOne, final String APIStates_Created_urlPatternForPostAndPut, final String APIStates_Created_urlPatternForGetDeleteAndHead, final String APIStates_Created_applicationName, final String APIStates_Created_applicationNameInvoke, final String APIStates_Created_applicationDiscription, final String APIStates_Created_keyTypeToInvoke, final String APIStates_Created_postPayloadContext, final String APIStates_Created_postCustomerNameFromPayloadContext, final String APIStates_Created_postResponseHeaders, final String APIStates_Created_getCustomerName, final String APIStates_Created_getResponseHeaders, final String APIStates_Created_putCustomerName, final String APIStates_Created_getCustomerNameForPutVerification, final String APIStates_Created_getResponseHeadersForPutVerification, final String APIStates_Created_deleteResponseHeaders, final String APIStates_Created_invokeTypeProduction, final String APIStates_Created_invokeTypeSandbox, final String APIStates_Created_tierType, final String APIStates_Created_changeProductionEndPoint, final String APIStates_Created_apiNewVersion, final String APIStates_Created_noOfUsersZero, final String KeyWords_keyWordYes, final String KeyWords_keyWordNo, final String KeyWords_keyWordPost, final String KeyWords_keyWordGet, final String KeyWords_keyWordPut, final String KeyWords_keyWordHead, final String KeyWords_keyWordDelete, final String KeyWords_numericValueTwoHundred, final String KeyWords_numericValueTwoHundredAndFour, final String KeyWords_numericValueOne, final String KeyWords_numericValueTwo, final String KeyWords_keyWordNull, final String KeyWords_keyWordNoContent, final String KeyWords_keyWordTrue, final String KeyWords_keyWordFalse, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of executing tc_APIStates_Created");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,APIStates_Created_publisherOneOfTenantOneOrAdmin,PauseTimes_eightSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM2_459(this, APIStates_Created_apiName,APIStates_Created_apiContext,APIStates_Created_apiVersionOne,APIStates_Created_apiImage,APIStates_Created_apiTagName,APIStates_Created_urlPatternForPostAndPut,APIStates_Created_urlPatternForGetDeleteAndHead,APIStates_Created_productionEndpoint,KeyWords_keyWordNo,APIStates_Created_apiNewVersion,APIStates_Created_statusCreated,APIStates_Created_statusPublished,APIStates_Created_noOfUsersZero,APIStates_Created_statusPublished,URLs_storeURL,APIStates_Created_serverNameDomainOne,APIStates_Created_applicationName,APIStates_Created_tierType,APIStates_Created_invokeTypeSandbox,KeyWords_keyWordYes,KeyWords_keyWordPost,APIStates_Created_postPayloadContext,APIStates_Created_postCustomerNameFromPayloadContext,KeyWords_numericValueTwoHundred,APIStates_Created_postResponseHeaders,KeyWords_keyWordGet,APIStates_Created_getCustomerName,KeyWords_keyWordPut,APIStates_Created_putCustomerName,KeyWords_keyWordNoContent,KeyWords_keyWordGet,APIStates_Created_getCustomerNameForPutVerification,KeyWords_numericValueTwoHundred,APIStates_Created_getResponseHeadersForPutVerification,KeyWords_keyWordHead,KeyWords_keyWordNoContent,KeyWords_keyWordNull,KeyWords_keyWordDelete,KeyWords_keyWordNoContent,APIStates_Created_deleteResponseHeaders,KeyWords_keyWordGet,KeyWords_keyWordNoContent,KeyWords_numericValueTwoHundredAndFour,KeyWords_keyWordNull,APIStates_Created_invokeTypeProduction,APIStates_Created_storeOneOfTenantOneOrAdmin,APIStates_Created_apiVisibilityPublic,URLs_publisherURL,APIStates_Created_sandboxEndpoint,PauseTimes_fourSeconds,PauseTimes_eightSeconds,PauseTimes_threeSeconds);
    	writeToReport("End of executing tc_APIStates_Created");
    } 
    	

    /**
     * Data provider for Test case tc_APIStates_Retired.
     * @return data table
     */
    @DataProvider(name = "tc_APIStates_Retired")
    public Object[][] dataTable_tc_APIStates_Retired() {     	
    	return this.getDataTable("URLs","APIStates_Retired","PauseTimes");
    }

    /**
     * Data driven test case tc_APIStates_Retired.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIStates_Retired")
    public final void tc_APIStates_Retired(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String APIStates_Retired_APIName, final String APIStates_Retired_APIContext, final String APIStates_Retired_APIVersion, final String APIStates_Retired_tagName, final String APIStates_Retired_productionEndPoint, final String APIStates_Retired_sandBoxEndpoint, final String APIStates_Retired_APIStateRetired, final String APIStates_Retired_tenantOrAdminPublisherOne, final String APIStates_Retired_tenantOrAdmin, final String APIStates_Retired_tenantOrAdminStoreOne, final String APIStates_Retired_numberOfUser, final String APIStates_Retired_APIStatePublished, final String APIStates_Retired_APIvisibility, final String APIStates_Retired_urlPatternForPostAndPut, final String APIStates_Retired_urlPatternForGetDeleteAndHead, final String APIStates_Retired_yes, final String APIStates_Retired_no, final String APIStates_Retired_defaultApplication, final String APIStates_Retired_keyTypeToInvokeProduction, final String APIStates_Retired_keyTypeToInvokeSandBox, final String APIStates_Retired_buttonNamePost, final String APIStates_Retired_postPayloadContext, final String APIStates_Retired_CustomerNameOne, final String APIStates_Retired_CustomerNameTwo, final String APIStates_Retired_ResponseCodeTwoHundred, final String APIStates_Retired_ResponseHeaders, final String APIStates_Retired_buttonNameGet, final String APIStates_Retired_buttonNamePut, final String APIStates_Retired_ResponseBodyNoContent, final String APIStates_Retired_buttonNameHead, final String APIStates_Retired_ResponseHeadersNull, final String APIStates_Retired_buttonNameDelete, final String APIStates_Retired_deleteResponseHeaders, final String APIStates_Retired_ResponCodeTwoHundredAndFourForDeleteVerification, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of executing tc_APIStates_Retired");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,APIStates_Retired_tenantOrAdminPublisherOne,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_446(this, APIStates_Retired_APIName,APIStates_Retired_APIVersion,APIStates_Retired_APIVersion,APIStates_Retired_tagName,APIStates_Retired_productionEndPoint,APIStates_Retired_sandBoxEndpoint,APIStates_Retired_APIStateRetired,APIStates_Retired_tenantOrAdminPublisherOne,URLs_storeURL,APIStates_Retired_tenantOrAdmin,APIStates_Retired_tenantOrAdminStoreOne,APIStates_Retired_numberOfUser,APIStates_Retired_APIStatePublished,URLs_publisherURL,APIStates_Retired_APIvisibility,APIStates_Retired_urlPatternForPostAndPut,APIStates_Retired_urlPatternForGetDeleteAndHead,APIStates_Retired_yes,APIStates_Retired_no,APIStates_Retired_defaultApplication,PauseTimes_threeSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	writeToReport("End of executing tc_APIStates_Retired");
    } 
    	

    /**
     * Data provider for Test case tc_APIStates_Deprecated.
     * @return data table
     */
    @DataProvider(name = "tc_APIStates_Deprecated")
    public Object[][] dataTable_tc_APIStates_Deprecated() {     	
    	return this.getDataTable("URLs","APIStates_Deprecated","PauseTimes");
    }

    /**
     * Data driven test case tc_APIStates_Deprecated.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIStates_Deprecated")
    public final void tc_APIStates_Deprecated(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String APIStates_Deprecated_APIName, final String APIStates_Deprecated_APIContext, final String APIStates_Deprecated_APIVersion, final String APIStates_Deprecated_tagName, final String APIStates_Deprecated_productionEndPoint, final String APIStates_Deprecated_sandBoxEndpoint, final String APIStates_Deprecated_APIStatePublished, final String APIStates_Deprecated_tenantOrAdmin, final String APIStates_Deprecated_tenantOrAdminStoreOne, final String APIStates_Deprecated_defaultApplication, final String APIStates_Deprecated_tenantOrAdminPublisherOne, final String APIStates_Deprecated_APIStateDeprecated, final String APIStates_Deprecated_numberOfUsersZero, final String APIStates_Deprecated_tenantOrAdminStoreTwo, final String APIStates_Deprecated_yes, final String APIStates_Deprecated_no, final String APIStates_Deprecated_APIvisibility, final String APIStates_Deprecated_urlPatternForPostAndPut, final String APIStates_Deprecated_urlPatternForGetDeleteAndHead, final String APIStates_Deprecated_numberOfUsersOne, final String APIStates_Deprecated_keyTypeToInvokeProduction, final String APIStates_Deprecated_keyTypeToInvokeSandBox, final String APIStates_Deprecated_buttonNamePost, final String APIStates_Deprecated_postPayloadContext, final String APIStates_Deprecated_CustomerNameOne, final String APIStates_Deprecated_CustomerNameTwo, final String APIStates_Deprecated_ResponseCodeTwoHundred, final String APIStates_Deprecated_ResponseHeaders, final String APIStates_Deprecated_buttonNameGet, final String APIStates_Deprecated_buttonNamePut, final String APIStates_Deprecated_ResponseBodyNoContent, final String APIStates_Deprecated_buttonNameHead, final String APIStates_Deprecated_ResponseHeadersNull, final String APIStates_Deprecated_buttonNameDelete, final String APIStates_Deprecated_deleteResponseHeaders, final String APIStates_Deprecated_ResponCodeTwoHundredAndFourForDeleteVerification, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of executing tc_APIStates_Deprecated");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,APIStates_Deprecated_tenantOrAdminPublisherOne,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_443(this, APIStates_Deprecated_APIName,APIStates_Deprecated_APIContext,APIStates_Deprecated_APIVersion,APIStates_Deprecated_tagName,APIStates_Deprecated_productionEndPoint,APIStates_Deprecated_sandBoxEndpoint,APIStates_Deprecated_APIStatePublished,URLs_storeURL,APIStates_Deprecated_tenantOrAdmin,APIStates_Deprecated_tenantOrAdminStoreOne,APIStates_Deprecated_defaultApplication,URLs_publisherURL,APIStates_Deprecated_tenantOrAdminPublisherOne,APIStates_Deprecated_APIStateDeprecated,APIStates_Deprecated_numberOfUsersOne,APIStates_Deprecated_yes,APIStates_Deprecated_urlPatternForGetDeleteAndHead,APIStates_Deprecated_urlPatternForPostAndPut,APIStates_Deprecated_APIvisibility,APIStates_Deprecated_no,APIStates_Deprecated_keyTypeToInvokeProduction,APIStates_Deprecated_keyTypeToInvokeSandBox,APIStates_Deprecated_buttonNamePost,APIStates_Deprecated_postPayloadContext,APIStates_Deprecated_CustomerNameTwo,APIStates_Deprecated_ResponseCodeTwoHundred,APIStates_Deprecated_ResponseHeaders,APIStates_Deprecated_buttonNameGet,APIStates_Deprecated_CustomerNameTwo,APIStates_Deprecated_ResponseCodeTwoHundred,APIStates_Deprecated_ResponseHeaders,APIStates_Deprecated_buttonNamePut,APIStates_Deprecated_CustomerNameOne,APIStates_Deprecated_ResponseBodyNoContent,APIStates_Deprecated_ResponseCodeTwoHundred,APIStates_Deprecated_buttonNameGet,APIStates_Deprecated_CustomerNameOne,APIStates_Deprecated_ResponseCodeTwoHundred,APIStates_Deprecated_ResponseHeaders,APIStates_Deprecated_buttonNameHead,APIStates_Deprecated_ResponseCodeTwoHundred,APIStates_Deprecated_ResponseHeadersNull,APIStates_Deprecated_buttonNameDelete,APIStates_Deprecated_ResponseBodyNoContent,APIStates_Deprecated_ResponseCodeTwoHundred,APIStates_Deprecated_deleteResponseHeaders,APIStates_Deprecated_buttonNameGet,APIStates_Deprecated_ResponseBodyNoContent,APIStates_Deprecated_ResponCodeTwoHundredAndFourForDeleteVerification,APIStates_Deprecated_ResponseHeadersNull,PauseTimes_threeSeconds,PauseTimes_sixSeconds,PauseTimes_fourSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM2_609(this, APIStates_Deprecated_tenantOrAdminStoreTwo,APIStates_Deprecated_APIName,APIStates_Deprecated_APIContext,APIStates_Deprecated_APIVersion,APIStates_Deprecated_tagName,APIStates_Deprecated_productionEndPoint,APIStates_Deprecated_sandBoxEndpoint,APIStates_Deprecated_APIStatePublished,URLs_storeURL,APIStates_Deprecated_tenantOrAdmin,APIStates_Deprecated_tenantOrAdminPublisherOne,APIStates_Deprecated_APIStateDeprecated,APIStates_Deprecated_APIvisibility,APIStates_Deprecated_urlPatternForPostAndPut,APIStates_Deprecated_urlPatternForGetDeleteAndHead,APIStates_Deprecated_no,APIStates_Deprecated_yes,APIStates_Deprecated_numberOfUsersZero,URLs_publisherURL,PauseTimes_threeSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	writeToReport("End of executing tc_APIStates_Deprecated");
    } 
    	

    /**
     * Data provider for Test case tc_APIStates_Blocked.
     * @return data table
     */
    @DataProvider(name = "tc_APIStates_Blocked")
    public Object[][] dataTable_tc_APIStates_Blocked() {     	
    	return this.getDataTable("URLs","APIStates_Blocked","PauseTimes");
    }

    /**
     * Data driven test case tc_APIStates_Blocked.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIStates_Blocked")
    public final void tc_APIStates_Blocked(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String APIStates_Blocked_APIName, final String APIStates_Blocked_APIContext, final String APIStates_Blocked_APIVersion, final String APIStates_Blocked_tagName, final String APIStates_Blocked_productionEndPoint, final String APIStates_Blocked_sandBoxEndpoint, final String APIStates_Blocked_APIStateBlocked, final String APIStates_Blocked_tenantOrAdminPublisherOne, final String APIStates_Blocked_tenantOrAdmin, final String APIStates_Blocked_tenantOrAdminStoreOne, final String APIStates_Blocked_numberOfUser, final String APIStates_Blocked_APIStatePublished, final String APIStates_Blocked_APIvisibility, final String APIStates_Blocked_urlPatternForPostAndPut, final String APIStates_Blocked_urlPatternForGetDeleteAndHead, final String APIStates_Blocked_yes, final String APIStates_Blocked_no, final String APIStates_Blocked_defaultApplication, final String APIStates_Blocked_APIStateBlockedSimple, final String APIStates_Blocked_keyTypeToInvoke, final String APIStates_Blocked_buttonNamePost, final String APIStates_Blocked_postPayloadContext, final String APIStates_Blocked_errorMessage, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of executing tc_APIStates_Blocked");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,APIStates_Blocked_tenantOrAdminPublisherOne,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_441(this, APIStates_Blocked_APIStateBlocked,APIStates_Blocked_APIName,APIStates_Blocked_APIContext,APIStates_Blocked_APIVersion,APIStates_Blocked_APIvisibility,APIStates_Blocked_tagName,APIStates_Blocked_urlPatternForPostAndPut,APIStates_Blocked_urlPatternForGetDeleteAndHead,APIStates_Blocked_productionEndPoint,APIStates_Blocked_no,APIStates_Blocked_sandBoxEndpoint,APIStates_Blocked_yes,URLs_storeURL,APIStates_Blocked_tenantOrAdmin,APIStates_Blocked_tenantOrAdminStoreOne,APIStates_Blocked_defaultApplication,URLs_publisherURL,APIStates_Blocked_tenantOrAdminPublisherOne,APIStates_Blocked_numberOfUser,APIStates_Blocked_productionEndPoint,APIStates_Blocked_APIStateBlockedSimple,PauseTimes_threeSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	writeToReport("End of executing tc_APIStates_Blocked");
    } 
    	

    /**
     * Data provider for Test case tc_APIStates_Prototyped.
     * @return data table
     */
    @DataProvider(name = "tc_APIStates_Prototyped")
    public Object[][] dataTable_tc_APIStates_Prototyped() {     	
    	return this.getDataTable("URLs","APIStates_Protyped","PauseTimes");
    }

    /**
     * Data driven test case tc_APIStates_Prototyped.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIStates_Prototyped")
    public final void tc_APIStates_Prototyped(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String APIStates_Protyped_APIName, final String APIStates_Protyped_APIContext, final String APIStates_Protyped_APIVersion, final String APIStates_Protyped_tagName, final String APIStates_Protyped_productionEndPoint, final String APIStates_Protyped_sandBoxEndpoint, final String APIStates_Protyped_APIStatePrototyped, final String APIStates_Protyped_tenantOrAdminPublisherOne, final String APIStates_Protyped_tenantOrAdmin, final String APIStates_Protyped_tenantOrAdminStoreOne, final String APIStates_Protyped_numberOfUser, final String APIStates_Protyped_APIStatePublished, final String APIStates_Protyped_APIvisibility, final String APIStates_Protyped_urlPatternForPostAndPut, final String APIStates_Protyped_urlPatternForGetDeleteAndHead, final String APIStates_Protyped_yes, final String APIStates_Protyped_no, final String APIStates_Protyped_defaultApplication, final String APIStates_Protyped_APIStatePrototypedSimple, final String APIStates_Protyped_keyTypeToInvokeProduction, final String APIStates_Protyped_keyTypeToInvokeSandBox, final String APIStates_Protyped_buttonNamePost, final String APIStates_Protyped_postPayloadContext, final String APIStates_Protyped_CustomerNameOne, final String APIStates_Protyped_CustomerNameTwo, final String APIStates_Protyped_ResponseCodeTwoHundred, final String APIStates_Protyped_ResponseHeaders, final String APIStates_Protyped_buttonNameGet, final String APIStates_Protyped_buttonNamePut, final String APIStates_Protyped_ResponseBodyNoContent, final String APIStates_Protyped_buttonNameHead, final String APIStates_Protyped_ResponseHeadersNull, final String APIStates_Protyped_buttonNameDelete, final String APIStates_Protyped_deleteResponseHeaders, final String APIStates_Protyped_ResponCodeTwoHundredAndFourForDeleteVerification, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of executing tc_APIStates_Prototyped");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,APIStates_Protyped_tenantOrAdminPublisherOne,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_429(this, APIStates_Protyped_APIStatePrototyped,APIStates_Protyped_APIStatePrototypedSimple,APIStates_Protyped_APIName,APIStates_Protyped_APIContext,APIStates_Protyped_APIVersion,APIStates_Protyped_APIvisibility,APIStates_Protyped_tagName,APIStates_Protyped_urlPatternForPostAndPut,APIStates_Protyped_urlPatternForGetDeleteAndHead,APIStates_Protyped_productionEndPoint,APIStates_Protyped_sandBoxEndpoint,APIStates_Protyped_yes,APIStates_Protyped_no,URLs_storeURL,APIStates_Protyped_tenantOrAdmin,APIStates_Protyped_tenantOrAdminStoreOne,APIStates_Protyped_defaultApplication,URLs_publisherURL,APIStates_Protyped_numberOfUser,APIStates_Protyped_keyTypeToInvokeProduction,APIStates_Protyped_keyTypeToInvokeSandBox,APIStates_Protyped_buttonNamePost,APIStates_Protyped_postPayloadContext,APIStates_Protyped_CustomerNameTwo,APIStates_Protyped_ResponseCodeTwoHundred,APIStates_Protyped_ResponseHeaders,APIStates_Protyped_buttonNameGet,APIStates_Protyped_CustomerNameTwo,APIStates_Protyped_ResponseCodeTwoHundred,APIStates_Protyped_ResponseHeaders,APIStates_Protyped_buttonNamePut,APIStates_Protyped_CustomerNameOne,APIStates_Protyped_ResponseBodyNoContent,APIStates_Protyped_ResponseCodeTwoHundred,APIStates_Protyped_ResponseHeadersNull,APIStates_Protyped_buttonNameDelete,APIStates_Protyped_ResponseBodyNoContent,APIStates_Protyped_ResponseCodeTwoHundred,APIStates_Protyped_deleteResponseHeaders,APIStates_Protyped_buttonNameGet,APIStates_Protyped_ResponseBodyNoContent,APIStates_Protyped_ResponCodeTwoHundredAndFourForDeleteVerification,APIStates_Protyped_ResponseHeadersNull,APIStates_Protyped_ResponseCodeTwoHundred,APIStates_Protyped_buttonNameGet,APIStates_Protyped_CustomerNameOne,APIStates_Protyped_ResponseCodeTwoHundred,APIStates_Protyped_ResponseHeaders,APIStates_Protyped_buttonNameHead,APIStates_Protyped_yes,APIStates_Protyped_keyTypeToInvokeProduction,APIStates_Protyped_yes,APIStates_Protyped_yes,APIStates_Protyped_yes,APIStates_Protyped_ResponseBodyNoContent,APIStates_Protyped_yes,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds,PauseTimes_threeSeconds);
    	writeToReport("End of executing tc_APIStates_Prototyped");
    } 
    	

    /**
     * Data provider for Test case tc_APIStates_Published.
     * @return data table
     */
    @DataProvider(name = "tc_APIStates_Published")
    public Object[][] dataTable_tc_APIStates_Published() {     	
    	return this.getDataTable("URLs","APIStates_Published","PauseTimes");
    }

    /**
     * Data driven test case tc_APIStates_Published.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APIStates_Published")
    public final void tc_APIStates_Published(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String APIStates_Published_APIName, final String APIStates_Published_APIContext, final String APIStates_Published_APIVersion, final String APIStates_Published_tagName, final String APIStates_Published_productionEndPoint, final String APIStates_Published_sandBoxEndpoint, final String APIStates_Published_tenantOrAdminPublisherOne, final String APIStates_Published_tenantOrAdmin, final String APIStates_Published_tenantOrAdminStoreOne, final String APIStates_Published_numberOfUser, final String APIStates_Published_APIStatePublished, final String APIStates_Published_APIvisibility, final String APIStates_Published_urlPatternForPostAndPut, final String APIStates_Published_urlPatternForGetDeleteAndHead, final String APIStates_Published_yes, final String APIStates_Published_no, final String APIStates_Published_defaultApplication, final String APIStates_Published_keyTypeToInvokeProduction, final String APIStates_Published_keyTypeToInvokeSandBox, final String APIStates_Published_buttonNamePost, final String APIStates_Published_postPayloadContext, final String APIStates_Published_CustomerNameOne, final String APIStates_Published_CustomerNameTwo, final String APIStates_Published_ResponseCodeTwoHundred, final String APIStates_Published_ResponseHeaders, final String APIStates_Published_buttonNameGet, final String APIStates_Published_buttonNamePut, final String APIStates_Published_ResponseBodyNoContent, final String APIStates_Published_buttonNameHead, final String APIStates_Published_ResponseHeadersNull, final String APIStates_Published_buttonNameDelete, final String APIStates_Published_deleteResponseHeaders, final String APIStates_Published_ResponCodeTwoHundredAndFourForDeleteVerification, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of executing tc_APIStates_Published");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,APIStates_Published_tenantOrAdminPublisherOne,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_434(this, APIStates_Published_APIName,APIStates_Published_APIContext,APIStates_Published_APIVersion,APIStates_Published_APIvisibility,APIStates_Published_tagName,APIStates_Published_urlPatternForPostAndPut,APIStates_Published_urlPatternForGetDeleteAndHead,APIStates_Published_productionEndPoint,APIStates_Published_sandBoxEndpoint,APIStates_Published_yes,APIStates_Published_no,URLs_publisherURL,APIStates_Published_numberOfUser,APIStates_Published_APIStatePublished,URLs_storeURL,APIStates_Published_tenantOrAdmin,APIStates_Published_defaultApplication,APIStates_Published_keyTypeToInvokeProduction,APIStates_Published_keyTypeToInvokeSandBox,APIStates_Published_buttonNamePost,APIStates_Published_postPayloadContext,APIStates_Published_CustomerNameTwo,APIStates_Published_ResponseCodeTwoHundred,APIStates_Published_ResponseHeaders,APIStates_Published_buttonNameGet,APIStates_Published_CustomerNameTwo,APIStates_Published_ResponseCodeTwoHundred,APIStates_Published_ResponseHeaders,APIStates_Published_buttonNamePut,APIStates_Published_CustomerNameOne,APIStates_Published_ResponseBodyNoContent,APIStates_Published_ResponseCodeTwoHundred,APIStates_Published_ResponseHeadersNull,APIStates_Published_buttonNameDelete,APIStates_Published_ResponseBodyNoContent,APIStates_Published_ResponseCodeTwoHundred,APIStates_Published_deleteResponseHeaders,APIStates_Published_buttonNameGet,APIStates_Published_ResponseBodyNoContent,APIStates_Published_ResponCodeTwoHundredAndFourForDeleteVerification,APIStates_Published_ResponseHeadersNull,APIStates_Published_ResponseCodeTwoHundred,APIStates_Published_buttonNameGet,APIStates_Published_CustomerNameOne,APIStates_Published_ResponseCodeTwoHundred,APIStates_Published_ResponseHeaders,APIStates_Published_buttonNameHead,APIStates_Published_tenantOrAdminStoreOne,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds,PauseTimes_threeSeconds);
    	writeToReport("End of executing tc_APIStates_Published");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}