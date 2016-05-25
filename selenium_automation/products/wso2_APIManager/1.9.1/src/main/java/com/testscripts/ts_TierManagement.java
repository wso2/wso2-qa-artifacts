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
 *  Class ts_TierManagement implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_TierManagement extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_TierPermission.
     * @return data table
     */
    @DataProvider(name = "tc_TierPermission")
    public Object[][] dataTable_tc_TierPermission() {     	
    	return this.getDataTable("URLs","KeyWords","TierPermissions","DeleteAllApplicationsAndAPIsFromAllTenants","PauseTimes");
    }

    /**
     * Data driven test case tc_TierPermission.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_TierPermission")
    public final void tc_TierPermission(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String KeyWords_keyWordYes, final String KeyWords_keyWordNo, final String KeyWords_keyWordPost, final String KeyWords_keyWordGet, final String KeyWords_keyWordPut, final String KeyWords_keyWordHead, final String KeyWords_keyWordDelete, final String KeyWords_numericValueTwoHundred, final String KeyWords_numericValueTwoHundredAndFour, final String KeyWords_numericValueOne, final String KeyWords_numericValueTwo, final String KeyWords_keyWordNull, final String KeyWords_keyWordNoContent, final String KeyWords_keyWordTrue, final String KeyWords_keyWordFalse, final String TierPermissions_APIName, final String TierPermissions_apiContext, final String TierPermissions_apiVersionOne, final String TierPermissions_apiVisibilityPublic, final String TierPermissions_apiImageName, final String TierPermissions_tagName, final String TierPermissions_urlPatternForPostAndPut, final String TierPermissions_urlPatternForGetDeleteAndHead, final String TierPermissions_productionEndpoint, final String TierPermissions_internalOrEveryoneKeyWord, final String TierPermissions_tenantOneOfDomainOne, final String TierPermissions_publisherOneOfTenentOneOrAdmin, final String TierPermissions_publisherTwoOfTenentOneOrAdmin, final String TierPermissions_storeOneOfTenanrOrAdmin, final String TierPermissions_storeTwoOfTenanrOrAdmin, final String TierPermissions_storeThreeOfTenanrOrAdmin, final String TierPermissions_storeFourOfTenanrOrAdmin, final String TierPermissions_storeFiveOfTenanrOrAdmin, final String TierPermissions_storeSixOfTenanrOrAdmin, final String TierPermissions_tierNameGold, final String TierPermissions_tierNameSilver, final String TierPermissions_tierNameBronze, final String TierPermissions_tierNameUnlimited, final String TierPermissions_tierNameCustom, final String TierPermissions_wrongRole, final String TierPermissions_errorMessageInvalidRoleName, final String TierPermissions_errorMessageThisFieldIsRequired, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainOneTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOrAdminPublisherUser, final String DeleteAllApplicationsAndAPIsFromAllTenants_DefaultApplication, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserThree, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainTwoTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainCondition, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminPublisherUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminPublisherUserOne, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of TS TierPermission");
    	//obtain provider while creating user
    	if(TierPermissions_tenantOneOfDomainOne.equals("TenantOne")){
    	String var_Provider = retrieveString("keyTenantOnePublisherUserTwo");
    	store("key_domain","String",var_Provider);
    	} else if(TierPermissions_tenantOneOfDomainOne.equals("Admin")){
    	String var_Provider = retrieveString("keyAdminPublisherUserTwo");
    	store("key_domain","String",var_Provider);
    	}
    	String var_providerOfAPI = retrieveString("key_domain");
    	lib_TestCase.APIM2_1074(this, URLs_publisherURL,TierPermissions_publisherOneOfTenentOneOrAdmin,TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_tierNameGold,TierPermissions_tierNameSilver,TierPermissions_tierNameBronze,TierPermissions_tierNameUnlimited,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_1075(this, URLs_publisherURL,URLs_storeURL,TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_storeOneOfTenanrOrAdmin,TierPermissions_storeTwoOfTenanrOrAdmin,TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_tierNameGold,TierPermissions_tierNameSilver,TierPermissions_tierNameBronze,TierPermissions_tierNameUnlimited,TierPermissions_tierNameCustom,TierPermissions_APIName,TierPermissions_apiContext,TierPermissions_apiVersionOne,TierPermissions_apiVisibilityPublic,TierPermissions_apiImageName,TierPermissions_tagName,TierPermissions_urlPatternForPostAndPut,TierPermissions_urlPatternForGetDeleteAndHead,TierPermissions_productionEndpoint,KeyWords_keyWordNo,TierPermissions_internalOrEveryoneKeyWord,TierPermissions_tenantOneOfDomainOne,PauseTimes_threeSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	String var_APIName = retrieveString("key_APINameDesign");
    	lib_TestCase.APIM2_1076(this, URLs_publisherURL,URLs_storeURL,TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_tierNameGold,TierPermissions_tierNameSilver,TierPermissions_tierNameBronze,TierPermissions_tierNameUnlimited,TierPermissions_tierNameCustom,TierPermissions_tenantOneOfDomainOne,TierPermissions_storeOneOfTenanrOrAdmin,TierPermissions_storeTwoOfTenanrOrAdmin,TierPermissions_storeThreeOfTenanrOrAdmin,TierPermissions_storeFourOfTenanrOrAdmin,TierPermissions_storeFiveOfTenanrOrAdmin,var_APIName,TierPermissions_internalOrEveryoneKeyWord,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM2_1077(this, URLs_publisherURL,URLs_storeURL,TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_tenantOneOfDomainOne,TierPermissions_storeOneOfTenanrOrAdmin,TierPermissions_storeTwoOfTenanrOrAdmin,TierPermissions_storeThreeOfTenanrOrAdmin,TierPermissions_storeFourOfTenanrOrAdmin,TierPermissions_storeFiveOfTenanrOrAdmin,TierPermissions_tierNameGold,TierPermissions_tierNameSilver,TierPermissions_tierNameBronze,TierPermissions_tierNameUnlimited,TierPermissions_internalOrEveryoneKeyWord,TierPermissions_tierNameCustom,var_APIName,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM2_1080(this, TierPermissions_publisherTwoOfTenentOneOrAdmin,URLs_publisherURL,URLs_storeURL,TierPermissions_tenantOneOfDomainOne,TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_tierNameGold,TierPermissions_tierNameSilver,TierPermissions_tierNameBronze,var_APIName,TierPermissions_tierNameCustom,TierPermissions_tierNameUnlimited,TierPermissions_storeOneOfTenanrOrAdmin,TierPermissions_storeTwoOfTenanrOrAdmin,TierPermissions_storeThreeOfTenanrOrAdmin,TierPermissions_storeFourOfTenanrOrAdmin,TierPermissions_storeFiveOfTenanrOrAdmin,TierPermissions_storeSixOfTenanrOrAdmin,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM2_1081(this, URLs_publisherURL,URLs_storeURL,TierPermissions_publisherTwoOfTenentOneOrAdmin,var_APIName,TierPermissions_tierNameBronze,TierPermissions_tierNameSilver,TierPermissions_tierNameGold,TierPermissions_tierNameUnlimited,TierPermissions_tierNameCustom,TierPermissions_tenantOneOfDomainOne,TierPermissions_storeOneOfTenanrOrAdmin,TierPermissions_storeTwoOfTenanrOrAdmin,TierPermissions_storeThreeOfTenanrOrAdmin,TierPermissions_storeFourOfTenanrOrAdmin,TierPermissions_storeFiveOfTenanrOrAdmin,TierPermissions_storeSixOfTenanrOrAdmin,TierPermissions_internalOrEveryoneKeyWord,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM2_1090(this, TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_tierNameBronze,TierPermissions_tierNameSilver,TierPermissions_tierNameGold,URLs_storeURL,URLs_publisherURL,TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_tenantOneOfDomainOne,TierPermissions_storeOneOfTenanrOrAdmin,TierPermissions_storeTwoOfTenanrOrAdmin,var_APIName,TierPermissions_tierNameUnlimited,TierPermissions_internalOrEveryoneKeyWord,TierPermissions_tierNameCustom,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_TestCase.APIM2_1078(this, URLs_publisherURL,TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_wrongRole,TierPermissions_errorMessageInvalidRoleName,TierPermissions_tierNameGold,TierPermissions_tierNameSilver,TierPermissions_tierNameBronze,TierPermissions_tierNameUnlimited,TierPermissions_tierNameCustom,TierPermissions_internalOrEveryoneKeyWord,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_1079(this, TierPermissions_publisherTwoOfTenentOneOrAdmin,URLs_publisherURL,TierPermissions_publisherTwoOfTenentOneOrAdmin,TierPermissions_tierNameGold,TierPermissions_tierNameSilver,TierPermissions_tierNameBronze,TierPermissions_tierNameUnlimited,TierPermissions_tierNameCustom,TierPermissions_errorMessageThisFieldIsRequired,URLs_storeURL,TierPermissions_tenantOneOfDomainOne,TierPermissions_storeOneOfTenanrOrAdmin,var_APIName,TierPermissions_apiVersionOne,TierPermissions_internalOrEveryoneKeyWord,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	writeToReport("End of TS TierPermission");
    } 
    	

    /**
     * Test case tc_TierPermision.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_TierPermision() throws Exception {
    	pause("200");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}