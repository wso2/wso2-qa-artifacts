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
 *  Class ts_APIStore implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APIStore extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_Subscription.
     * @return data table
     */
    @DataProvider(name = "tc_Subscription")
    public Object[][] dataTable_tc_Subscription() {     	
    	return this.getDataTable("URLs","Subscription","DeleteAllApplicationsAndAPIsFromAllTenants","PauseTimes");
    }

    /**
     * Data driven test case tc_Subscription.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Subscription")
    public final void tc_Subscription(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Subscription_APIName, final String Subscription_APIContext, final String Subscription_tagName, final String Subscription_productionEndPoint, final String Subscription_sandBoxEndpoint, final String Subscription_APIVersion, final String Subscription_domainThreeOrAdminStore, final String Subscription_domainName, final String Subscription_domainThreeOrAdminPublisher, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainOneTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOrAdminPublisherUser, final String DeleteAllApplicationsAndAPIsFromAllTenants_DefaultApplication, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserThree, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainTwoTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainCondition, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminPublisherUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminPublisherUserOne, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of ts_Subscription");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,Subscription_domainThreeOrAdminPublisher,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_427(this, URLs_storeURL,Subscription_APIName,Subscription_APIContext,Subscription_tagName,Subscription_productionEndPoint,Subscription_sandBoxEndpoint,Subscription_APIVersion,Subscription_domainName,Subscription_domainName,Subscription_domainThreeOrAdminStore,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_threeSeconds,PauseTimes_eightSeconds);
    	String varAPIName = retrieveString("keyAPIName");
    	lib_Common.bc_DeleteAPI(this, varAPIName,URLs_publisherURL,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	writeToReport("End of ts_Subscription");
    } 
    	

    /**
     * Data provider for Test case tc_Self_Signup.
     * @return data table
     */
    @DataProvider(name = "tc_Self_Signup")
    public Object[][] dataTable_tc_Self_Signup() {     	
    	return this.getDataTable("Common","SelfSignUp");
    }

    /**
     * Data driven test case tc_Self_Signup.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Self_Signup")
    public final void tc_Self_Signup(final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String SelfSignUp_userName, final String SelfSignUp_password, final String SelfSignUp_firstName, final String SelfSignUp_lastName, final String SelfSignUp_email, final String SelfSignUp_serverName, final String SelfSignUp_pauseFourSeconds, final String SelfSignUp_pauseSixSeconds) throws Exception {	
    	writeToReport("Start Executing tc_SelfSignUp");
    	lib_TestCase.APIM_787(this, SelfSignUp_serverName,Common_storeURL,SelfSignUp_userName,SelfSignUp_password,SelfSignUp_firstName,SelfSignUp_lastName,SelfSignUp_email,SelfSignUp_pauseFourSeconds,SelfSignUp_pauseSixSeconds);
    	writeToReport("End Of Executing tc_SelfSignUp");
    } 
    	

    /**
     * Data provider for Test case tc_Search_APIs_of_Store.
     * @return data table
     */
    @DataProvider(name = "tc_Search_APIs_of_Store")
    public Object[][] dataTable_tc_Search_APIs_of_Store() {     	
    	return this.getDataTable("URLs","Search_APIs_of_Store","PauseTimes");
    }

    /**
     * Data driven test case tc_Search_APIs_of_Store.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Search_APIs_of_Store")
    public final void tc_Search_APIs_of_Store(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Search_APIs_of_Store_domain, final String Search_APIs_of_Store_APIName, final String Search_APIs_of_Store_APIContest, final String Search_APIs_of_Store_tag, final String Search_APIs_of_Store_ProductionEndPontJaxRS, final String Search_APIs_of_Store_storeURL, final String Search_APIs_of_Store_publisherURL, final String Search_APIs_of_Store_apiVersion, final String Search_APIs_of_Store_SearchContext, final String Search_APIs_of_Store_Description, final String Search_APIs_of_Store_SearchDescription, final String Search_APIs_of_Store_searchProvider, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of the Test Suite Search_APIs_of_Store");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,Search_APIs_of_Store_domain,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_404(this, Search_APIs_of_Store_APIName,Search_APIs_of_Store_APIContest,Search_APIs_of_Store_tag,Search_APIs_of_Store_ProductionEndPontJaxRS,URLs_storeURL,Search_APIs_of_Store_domain,URLs_publisherURL,Search_APIs_of_Store_apiVersion,Search_APIs_of_Store_Description,PauseTimes_fiveSeconds,PauseTimes_eightSeconds,PauseTimes_oneSecond);
    	lib_TestCase.APIM_403(this, Search_APIs_of_Store_APIName,URLs_storeURL,Search_APIs_of_Store_domain,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	lib_TestCase.APIM_402(this, Search_APIs_of_Store_APIName,Search_APIs_of_Store_domain,URLs_storeURL,Search_APIs_of_Store_SearchContext,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	lib_TestCase.APIM_401(this, Search_APIs_of_Store_APIName,Search_APIs_of_Store_domain,URLs_storeURL);
    	lib_TestCase.APIM_400(this, Search_APIs_of_Store_APIName,Search_APIs_of_Store_domain,URLs_storeURL,PauseTimes_fiveSeconds);
    	lib_TestCase.APIM_399(this, Search_APIs_of_Store_SearchDescription,Search_APIs_of_Store_Description,Search_APIs_of_Store_APIName,Search_APIs_of_Store_domain,URLs_storeURL,PauseTimes_fiveSeconds);
    	lib_TestCase.APIM_398(this, Search_APIs_of_Store_APIName,Search_APIs_of_Store_searchProvider,URLs_storeURL,Search_APIs_of_Store_domain,PauseTimes_fiveSeconds);
    	lib_TestCase.APIM_393(this, URLs_storeURL,Search_APIs_of_Store_APIName,Search_APIs_of_Store_domain,Search_APIs_of_Store_SearchContext,PauseTimes_fiveSeconds);
    	String varAPINamey = retrieveString("keyAPIName");
    	//Delete created API
    	lib_Common.bc_DeleteAPI(this, varAPINamey,URLs_publisherURL,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	writeToReport("End of the Test Suite Search_APIs_of_Store");
    } 
    	

    /**
     * Data provider for Test case tc_SocialNetworking.
     * @return data table
     */
    @DataProvider(name = "tc_SocialNetworking")
    public Object[][] dataTable_tc_SocialNetworking() {     	
    	return this.getDataTable("URLs","socialNetworking","PauseTimes");
    }

    /**
     * Data driven test case tc_SocialNetworking.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_SocialNetworking")
    public final void tc_SocialNetworking(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String socialNetworking_APIName, final String socialNetworking_APIContest, final String socialNetworking_APITag, final String socialNetworking_productionEndPoint, final String socialNetworking_tenantOrAdmin, final String socialNetworking_tenantOneOrAdminStoreOne, final String socialNetworking_publisherOneOfTenantOneOrAdmin, final String socialNetworking_faceBookUserName, final String socialNetworking_faceBookPassword, final String socialNetworking_twitterUserName, final String socialNetworking_twitterPassword, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start Executing tc_SocialNetworking");
    	//Log in to publisher
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,socialNetworking_publisherOneOfTenantOneOrAdmin,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_800(this, socialNetworking_APIName,socialNetworking_APIContest,socialNetworking_APITag,socialNetworking_productionEndPoint,URLs_storeURL,socialNetworking_tenantOrAdmin,socialNetworking_tenantOneOrAdminStoreOne,socialNetworking_faceBookUserName,socialNetworking_faceBookPassword,PauseTimes_threeSeconds,PauseTimes_eightSeconds,PauseTimes_oneSecond,PauseTimes_sixSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM2_801(this, socialNetworking_twitterUserName,socialNetworking_twitterPassword,URLs_storeURL,socialNetworking_tenantOrAdmin,PauseTimes_threeSeconds);
    	writeToReport("End of Executing tc_SocialNetworking");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}