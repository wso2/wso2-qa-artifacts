package com.wso2_apimanager;

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
    	return this.getDataTable("URLs","Subscription");
    }

    /**
     * Data driven test case tc_Subscription.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Subscription")
    public final void tc_Subscription(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Subscription_APIName, final String Subscription_APIContext, final String Subscription_tagName, final String Subscription_productionEndPoint, final String Subscription_sandBoxEndpoint, final String Subscription_APIVersion, final String Subscription_domainThreeOrAdminStore, final String Subscription_domainName, final String Subscription_domainThreeOrAdminPublisher) throws Exception {	
    	writeToReport("Start of ts_Subscription");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,Subscription_domainThreeOrAdminPublisher);
    	lib_TestCase.APIM_427(this, URLs_storeURL,Subscription_APIName,Subscription_APIContext,Subscription_tagName,Subscription_productionEndPoint,Subscription_sandBoxEndpoint,Subscription_APIVersion,Subscription_domainName,Subscription_domainName,Subscription_domainThreeOrAdminStore);
    	String varAPIName = retrieveString("keyAPIName");
    	lib_Common.bc_DeleteAPI(this, varAPIName,URLs_publisherURL);
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
    public final void tc_Self_Signup(final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String SelfSignUp_userName, final String SelfSignUp_password, final String SelfSignUp_firstName, final String SelfSignUp_lastName, final String SelfSignUp_email, final String SelfSignUp_serverName) throws Exception {	
    	writeToReport("Start Executing tc_SelfSignUp");
    	lib_TestCase.APIM_787(this, SelfSignUp_serverName,Common_storeURL,SelfSignUp_userName,SelfSignUp_password,SelfSignUp_firstName,SelfSignUp_lastName,SelfSignUp_email);
    	writeToReport("End Of Executing tc_SelfSignUp");
    } 
    	

    /**
     * Data provider for Test case tc_Search_APIs_of_Store.
     * @return data table
     */
    @DataProvider(name = "tc_Search_APIs_of_Store")
    public Object[][] dataTable_tc_Search_APIs_of_Store() {     	
    	return this.getDataTable("URLs","Search_APIs_of_Store");
    }

    /**
     * Data driven test case tc_Search_APIs_of_Store.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Search_APIs_of_Store")
    public final void tc_Search_APIs_of_Store(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Search_APIs_of_Store_domain, final String Search_APIs_of_Store_APIName, final String Search_APIs_of_Store_APIContest, final String Search_APIs_of_Store_tag, final String Search_APIs_of_Store_ProductionEndPontJaxRS, final String Search_APIs_of_Store_storeURL, final String Search_APIs_of_Store_publisherURL, final String Search_APIs_of_Store_apiVersion, final String Search_APIs_of_Store_SearchContext, final String Search_APIs_of_Store_Description, final String Search_APIs_of_Store_SearchDescription, final String Search_APIs_of_Store_searchProvider) throws Exception {	
    	writeToReport("Start of the Test Suite Search_APIs_of_Store");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,Search_APIs_of_Store_domain);
    	lib_TestCase.APIM_404(this, Search_APIs_of_Store_APIName,Search_APIs_of_Store_APIContest,Search_APIs_of_Store_tag,Search_APIs_of_Store_ProductionEndPontJaxRS,URLs_storeURL,Search_APIs_of_Store_domain,URLs_publisherURL,Search_APIs_of_Store_apiVersion,Search_APIs_of_Store_Description);
    	lib_TestCase.APIM_403(this, Search_APIs_of_Store_APIName,URLs_storeURL,Search_APIs_of_Store_domain);
    	lib_TestCase.APIM_402(this, Search_APIs_of_Store_APIName,Search_APIs_of_Store_domain,URLs_storeURL,Search_APIs_of_Store_SearchContext);
    	lib_TestCase.APIM_401(this, Search_APIs_of_Store_APIName,Search_APIs_of_Store_domain,URLs_storeURL);
    	lib_TestCase.APIM_400(this, Search_APIs_of_Store_APIName,Search_APIs_of_Store_domain,URLs_storeURL);
    	lib_TestCase.APIM_399(this, Search_APIs_of_Store_SearchDescription,Search_APIs_of_Store_Description,Search_APIs_of_Store_APIName,Search_APIs_of_Store_domain,URLs_storeURL);
    	lib_TestCase.APIM_398(this, Search_APIs_of_Store_APIName,Search_APIs_of_Store_searchProvider,URLs_storeURL,Search_APIs_of_Store_domain);
    	lib_TestCase.APIM_393(this, URLs_storeURL,Search_APIs_of_Store_APIName,Search_APIs_of_Store_domain,Search_APIs_of_Store_SearchContext);
    	String varAPINamey = retrieveString("keyAPIName");
    	//Delete created API
    	lib_Common.bc_DeleteAPI(this, varAPINamey,URLs_publisherURL);
    	writeToReport("End of the Test Suite Search_APIs_of_Store");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}