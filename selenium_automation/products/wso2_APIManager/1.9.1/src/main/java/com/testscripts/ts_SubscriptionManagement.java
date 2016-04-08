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
 *  Class ts_SubscriptionManagement implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_SubscriptionManagement extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_DeprecatedAPIs.
     * @return data table
     */
    @DataProvider(name = "tc_DeprecatedAPIs")
    public Object[][] dataTable_tc_DeprecatedAPIs() {     	
    	return this.getDataTable("URLs","Common","DeprecatedAPIs","KeyWords","DeleteAllApplicationsAndAPIsFromAllTenants","PauseTimes");
    }

    /**
     * Data driven test case tc_DeprecatedAPIs.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_DeprecatedAPIs")
    public final void tc_DeprecatedAPIs(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String DeprecatedAPIs_apiName, final String DeprecatedAPIs_apiContext, final String DeprecatedAPIs_apiVersionOne, final String DeprecatedAPIs_apiVisibilityPublic, final String DeprecatedAPIs_apiImage, final String DeprecatedAPIs_apiTagName, final String DeprecatedAPIs_productionEndpoint, final String DeprecatedAPIs_sandboxEndpoint, final String DeprecatedAPIs_statusDeprecated, final String DeprecatedAPIs_publisherOneOfTenantOneOrAdmin, final String DeprecatedAPIs_storeOneOfTenantOneOrAdmin, final String DeprecatedAPIs_serverNameDomainOne, final String DeprecatedAPIs_urlPatternForPostAndPut, final String DeprecatedAPIs_urlPatternForGetDeleteAndHead, final String DeprecatedAPIs_applicationName, final String DeprecatedAPIs_applicationNameInvoke, final String DeprecatedAPIs_applicationDiscription, final String DeprecatedAPIs_keyTypeToInvoke, final String DeprecatedAPIs_postPayloadContext, final String DeprecatedAPIs_postCustomerNameFromPayloadContext, final String DeprecatedAPIs_postResponseHeaders, final String DeprecatedAPIs_getCustomerName, final String DeprecatedAPIs_getResponseHeaders, final String DeprecatedAPIs_putCustomerName, final String DeprecatedAPIs_getCustomerNameForPutVerification, final String DeprecatedAPIs_getResponseHeadersForPutVerification, final String DeprecatedAPIs_deleteResponseHeaders, final String DeprecatedAPIs_invokeTypeProduction, final String DeprecatedAPIs_invokeTypeSandbox, final String DeprecatedAPIs_tierType, final String DeprecatedAPIs_changeProductionEndPoint, final String KeyWords_keyWordYes, final String KeyWords_keyWordNo, final String KeyWords_keyWordPost, final String KeyWords_keyWordGet, final String KeyWords_keyWordPut, final String KeyWords_keyWordHead, final String KeyWords_keyWordDelete, final String KeyWords_numericValueTwoHundred, final String KeyWords_numericValueTwoHundredAndFour, final String KeyWords_numericValueOne, final String KeyWords_numericValueTwo, final String KeyWords_keyWordNull, final String KeyWords_keyWordNoContent, final String KeyWords_keyWordTrue, final String KeyWords_keyWordFalse, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainOneTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOrAdminPublisherUser, final String DeleteAllApplicationsAndAPIsFromAllTenants_DefaultApplication, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserThree, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainTwoTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainCondition, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminPublisherUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminPublisherUserOne, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of executing tc_DeprecatedAPIs");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,DeprecatedAPIs_publisherOneOfTenantOneOrAdmin,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_610(this, DeprecatedAPIs_apiName,DeprecatedAPIs_apiContext,DeprecatedAPIs_apiVersionOne,DeprecatedAPIs_apiVisibilityPublic,DeprecatedAPIs_apiImage,DeprecatedAPIs_apiTagName,DeprecatedAPIs_urlPatternForPostAndPut,DeprecatedAPIs_urlPatternForGetDeleteAndHead,URLs_publisherURL,URLs_storeURL,DeprecatedAPIs_serverNameDomainOne,DeprecatedAPIs_storeOneOfTenantOneOrAdmin,DeprecatedAPIs_applicationName,DeprecatedAPIs_tierType,DeprecatedAPIs_productionEndpoint,DeprecatedAPIs_sandboxEndpoint,DeprecatedAPIs_statusDeprecated,DeprecatedAPIs_applicationNameInvoke,DeprecatedAPIs_invokeTypeProduction,KeyWords_keyWordYes,KeyWords_keyWordPost,DeprecatedAPIs_postPayloadContext,DeprecatedAPIs_postCustomerNameFromPayloadContext,KeyWords_numericValueTwoHundred,DeprecatedAPIs_postResponseHeaders,KeyWords_keyWordGet,DeprecatedAPIs_getCustomerName,KeyWords_keyWordPut,DeprecatedAPIs_putCustomerName,KeyWords_keyWordNoContent,KeyWords_keyWordGet,DeprecatedAPIs_getCustomerNameForPutVerification,KeyWords_numericValueTwoHundred,DeprecatedAPIs_getResponseHeadersForPutVerification,KeyWords_keyWordHead,KeyWords_keyWordNoContent,KeyWords_keyWordNull,KeyWords_keyWordDelete,KeyWords_keyWordNoContent,DeprecatedAPIs_deleteResponseHeaders,KeyWords_keyWordGet,KeyWords_keyWordNoContent,KeyWords_numericValueTwoHundredAndFour,KeyWords_keyWordNull,KeyWords_keyWordNo,DeprecatedAPIs_changeProductionEndPoint,"null",PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_threeSeconds,PauseTimes_eightSeconds);
    	lib_Common.bc_DeleteAllApplicationsAndAPIsFromAllTenants(this, URLs_storeURL,DeleteAllApplicationsAndAPIsFromAllTenants_DomainOneTenantOrAdmin,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserTwo,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserOne,URLs_publisherURL,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOrAdminPublisherUser,DeleteAllApplicationsAndAPIsFromAllTenants_DefaultApplication,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserThree,DeleteAllApplicationsAndAPIsFromAllTenants_DomainTwoTenantOrAdmin,DeleteAllApplicationsAndAPIsFromAllTenants_DomainCondition,DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminStoreUserOne,DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminPublisherUserOne,DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserOne,DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserTwo,DeleteAllApplicationsAndAPIsFromAllTenants_AdminPublisherUserOne,PauseTimes_sixSeconds,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	writeToReport("EndOf of executing tc_DeprecatedAPIs");
    } 
    	

    /**
     * Data provider for Test case tc_Domain_And_Visibility_Based_Subscriptions.
     * @return data table
     */
    @DataProvider(name = "tc_Domain_And_Visibility_Based_Subscriptions")
    public Object[][] dataTable_tc_Domain_And_Visibility_Based_Subscriptions() {     	
    	return this.getDataTable("URLs","Domain_And_Visibility_Based_Subscriptions","DeleteAllApplicationsAndAPIsFromAllTenants","PauseTimes");
    }

    /**
     * Data driven test case tc_Domain_And_Visibility_Based_Subscriptions.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Domain_And_Visibility_Based_Subscriptions")
    public final void tc_Domain_And_Visibility_Based_Subscriptions(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Domain_And_Visibility_Based_Subscriptions_APIName, final String Domain_And_Visibility_Based_Subscriptions_subscriptionAvailableToCurrentTenantOnly, final String Domain_And_Visibility_Based_Subscriptions_aplicationName, final String Domain_And_Visibility_Based_Subscriptions_APIContext, final String Domain_And_Visibility_Based_Subscriptions_APIVersion, final String Domain_And_Visibility_Based_Subscriptions_tagName, final String Domain_And_Visibility_Based_Subscriptions_sandBoxEndpoint, final String Domain_And_Visibility_Based_Subscriptions_productionEndPoint, final String Domain_And_Visibility_Based_Subscriptions_subscriptionAvailableToAllTenants, final String Domain_And_Visibility_Based_Subscriptions_SubscriptionAvailableSpecificTenants, final String Domain_And_Visibility_Based_Subscriptions_domainOne, final String Domain_And_Visibility_Based_Subscriptions_tenantOneOrAdminPublisher, final String Domain_And_Visibility_Based_Subscriptions_tenantOneOrAdminStoreOne, final String Domain_And_Visibility_Based_Subscriptions_tenantOneOrAdminStoreTwo, final String Domain_And_Visibility_Based_Subscriptions_domainTwo, final String Domain_And_Visibility_Based_Subscriptions_tenanTwoOrAdminStore, final String Domain_And_Visibility_Based_Subscriptions_domainThree, final String Domain_And_Visibility_Based_Subscriptions_tenantThreeOrAdminStoreTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainOneTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOrAdminPublisherUser, final String DeleteAllApplicationsAndAPIsFromAllTenants_DefaultApplication, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserThree, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainTwoTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainCondition, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminPublisherUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminPublisherUserOne, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of executing tc_Domain_And_Visibility_Based_Subscriptions");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,Domain_And_Visibility_Based_Subscriptions_tenantOneOrAdminPublisher,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_67(this, Domain_And_Visibility_Based_Subscriptions_APIName,Domain_And_Visibility_Based_Subscriptions_subscriptionAvailableToCurrentTenantOnly,URLs_storeURL,Domain_And_Visibility_Based_Subscriptions_aplicationName,Domain_And_Visibility_Based_Subscriptions_APIContext,Domain_And_Visibility_Based_Subscriptions_APIVersion,Domain_And_Visibility_Based_Subscriptions_tagName,Domain_And_Visibility_Based_Subscriptions_productionEndPoint,Domain_And_Visibility_Based_Subscriptions_sandBoxEndpoint,Domain_And_Visibility_Based_Subscriptions_domainOne,Domain_And_Visibility_Based_Subscriptions_tenantOneOrAdminStoreOne,Domain_And_Visibility_Based_Subscriptions_tenantOneOrAdminStoreTwo,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	lib_TestCase.APIM_68(this, Domain_And_Visibility_Based_Subscriptions_APIName,URLs_storeURL,Domain_And_Visibility_Based_Subscriptions_aplicationName,Domain_And_Visibility_Based_Subscriptions_domainTwo,Domain_And_Visibility_Based_Subscriptions_tenanTwoOrAdminStore,Domain_And_Visibility_Based_Subscriptions_domainOne,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	lib_TestCase.APIM_71(this, URLs_publisherURL,Domain_And_Visibility_Based_Subscriptions_APIName,Domain_And_Visibility_Based_Subscriptions_subscriptionAvailableToAllTenants,URLs_storeURL,Domain_And_Visibility_Based_Subscriptions_domainTwo,Domain_And_Visibility_Based_Subscriptions_tenanTwoOrAdminStore,Domain_And_Visibility_Based_Subscriptions_domainOne,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	//Retrive Globe variable Server name Two from Tenant Creation
    	String varServerNameTwoAPIMSeventyTwo = retrieveString("keyServerNameTwo");
    	lib_TestCase.APIM_72(this, URLs_publisherURL,Domain_And_Visibility_Based_Subscriptions_APIName,Domain_And_Visibility_Based_Subscriptions_SubscriptionAvailableSpecificTenants,varServerNameTwoAPIMSeventyTwo,URLs_storeURL,Domain_And_Visibility_Based_Subscriptions_domainTwo,Domain_And_Visibility_Based_Subscriptions_tenanTwoOrAdminStore,Domain_And_Visibility_Based_Subscriptions_domainOne,Domain_And_Visibility_Based_Subscriptions_tenanTwoOrAdminStore,Domain_And_Visibility_Based_Subscriptions_domainThree,Domain_And_Visibility_Based_Subscriptions_tenantThreeOrAdminStoreTwo,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	lib_Common.bc_DeleteAllApplicationsAndAPIsFromAllTenants(this, URLs_storeURL,DeleteAllApplicationsAndAPIsFromAllTenants_DomainOneTenantOrAdmin,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserTwo,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserOne,URLs_publisherURL,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOrAdminPublisherUser,DeleteAllApplicationsAndAPIsFromAllTenants_DefaultApplication,DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserThree,DeleteAllApplicationsAndAPIsFromAllTenants_DomainTwoTenantOrAdmin,DeleteAllApplicationsAndAPIsFromAllTenants_DomainCondition,DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminStoreUserOne,DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminPublisherUserOne,DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserOne,DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserTwo,DeleteAllApplicationsAndAPIsFromAllTenants_AdminPublisherUserOne,PauseTimes_sixSeconds,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	/*
    	Retrieve
    	 key=keyAPIName
    	 var=varAPIName
    	 type=String
    	Retrieve
    	 key=keyAPIVersion
    	 var=varAPIVersion
    	 type=String
    	Retrieve
    	 key=keyAPPName
    	 var=varAPPName
    	 type=String
    	Call
    	 businessComponent=lib_Common.bc_UnSubscribeDeleteAPIMultiUser
    	 param_StoreURL=@URLs_storeURL
    	 param_APIName=@varAPIName
    	 param_APIVersion=@varAPIVersion
    	 param_PublisherURL=@URLs_publisherURL
    	 param_APPName=@varAPPName
    	 param_TenantOrAdmin=@Domain_And_Visibility_Based_Subscriptions_domainOne
    	 param_TenantOrAdminStoreUser=@Domain_And_Visibility_Based_Subscriptions_tenantOneOrAdminStoreOne
    	 param_pauseTwoSeconds=@PauseTimes_twoSeconds
    	 param_pauseFourSeconds=@PauseTimes_fourSeconds
    	*/
    	writeToReport("End of executing tc_Domain_And_Visibility_Based_Subscriptions");
    } 
    	

    /**
     * Data provider for Test case tc_SubscriptionBlocking.
     * @return data table
     */
    @DataProvider(name = "tc_SubscriptionBlocking")
    public Object[][] dataTable_tc_SubscriptionBlocking() {     	
    	return this.getDataTable("PauseTimes","URLs","SubscriptionBlocking","DeleteAllApplicationsAndAPIsFromAllTenants");
    }

    /**
     * Data driven test case tc_SubscriptionBlocking.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_SubscriptionBlocking")
    public final void tc_SubscriptionBlocking(final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String SubscriptionBlocking_APIName, final String SubscriptionBlocking_APIContext, final String SubscriptionBlocking_APIVersionOne, final String SubscriptionBlocking_APIvisibility, final String SubscriptionBlocking_APIImageName, final String SubscriptionBlocking_tagName, final String SubscriptionBlocking_urlPatternForPostAndPut, final String SubscriptionBlocking_urlPatternForGetDeleteAndHead, final String SubscriptionBlocking_productionEndpoint, final String SubscriptionBlocking_sandboxEndpoint, final String SubscriptionBlocking_serverNameDomainOne, final String SubscriptionBlocking_storeOneOfTenantOneOrAdmin, final String SubscriptionBlocking_applicationName, final String SubscriptionBlocking_keyWordProductionOnly, final String SubscriptionBlocking_keyWordBlock, final String SubscriptionBlocking_yes, final String SubscriptionBlocking_no, final String SubscriptionBlocking_buttonNamePost, final String SubscriptionBlocking_postResponseCodeFourHundredAndOne, final String SubscriptionBlocking_postPayloadContext, final String SubscriptionBlocking_TenantOneORAdminPublisher, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainOneTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOrAdminPublisherUser, final String DeleteAllApplicationsAndAPIsFromAllTenants_DefaultApplication, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserThree, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainTwoTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainCondition, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminPublisherUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminPublisherUserOne) throws Exception {	
    	writeToReport("Start of tc_SubscriptionBlocking");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,SubscriptionBlocking_TenantOneORAdminPublisher,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_615(this, URLs_publisherURL,URLs_storeURL,SubscriptionBlocking_APIName,SubscriptionBlocking_APIContext,SubscriptionBlocking_APIVersionOne,SubscriptionBlocking_APIvisibility,SubscriptionBlocking_APIImageName,SubscriptionBlocking_tagName,SubscriptionBlocking_urlPatternForPostAndPut,SubscriptionBlocking_urlPatternForGetDeleteAndHead,SubscriptionBlocking_productionEndpoint,SubscriptionBlocking_sandboxEndpoint,SubscriptionBlocking_serverNameDomainOne,SubscriptionBlocking_storeOneOfTenantOneOrAdmin,SubscriptionBlocking_applicationName,SubscriptionBlocking_keyWordProductionOnly,SubscriptionBlocking_keyWordBlock,SubscriptionBlocking_yes,SubscriptionBlocking_no,SubscriptionBlocking_buttonNamePost,SubscriptionBlocking_postResponseCodeFourHundredAndOne,SubscriptionBlocking_postPayloadContext,PauseTimes_twoSeconds,PauseTimes_threeSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	writeToReport("End of tc_SubscriptionBlocking");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}