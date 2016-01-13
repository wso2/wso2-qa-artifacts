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
 *  Class ts_ManageAPIs implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_ManageAPIs extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_TagManagement.
     * @return data table
     */
    @DataProvider(name = "tc_TagManagement")
    public Object[][] dataTable_tc_TagManagement() {     	
    	return this.getDataTable("URLs","TagManagement");
    }

    /**
     * Data driven test case tc_TagManagement.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_TagManagement")
    public final void tc_TagManagement(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String TagManagement_domain, final String TagManagement_APIName, final String TagManagement_APIContext, final String TagManagement_tag, final String TagManagement_ProductionEndPontJaxRS, final String TagManagement_Description, final String TagManagement_indexTwo, final String TagManagement_indexFour) throws Exception {	
    	writeToReport("Start of the Test Suite Tag Management");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,TagManagement_domain);
    	lib_TestCase.APIM2_527(this, TagManagement_APIName,TagManagement_APIContext,TagManagement_tag,TagManagement_ProductionEndPontJaxRS,TagManagement_domain,URLs_storeURL,TagManagement_Description);
    	lib_TestCase.APIM2_528(this, TagManagement_APIName,TagManagement_APIContext,TagManagement_tag,TagManagement_ProductionEndPontJaxRS,TagManagement_domain,URLs_storeURL,TagManagement_Description,URLs_publisherURL);
    	lib_TestCase.APIM2_529(this, TagManagement_tag,TagManagement_domain,URLs_storeURL,URLs_publisherURL);
    	lib_TestCase.APIM2_530(this, TagManagement_domain,URLs_storeURL,URLs_publisherURL,TagManagement_indexFour);
    	lib_TestCase.APIM2_531(this, TagManagement_APIName,TagManagement_APIContext,TagManagement_tag,TagManagement_ProductionEndPontJaxRS,TagManagement_domain,URLs_storeURL,TagManagement_Description,URLs_publisherURL,TagManagement_indexTwo);
    	String varAPINameOneE = retrieveString("keyAPIName");
    	lib_Common.bc_DeleteAPI(this, varAPINameOneE,URLs_publisherURL);
    	String varAPINameTwoE = retrieveString("keyAPINameTwo");
    	lib_Common.bc_DeleteAPI(this, varAPINameTwoE,URLs_publisherURL);
    	String varAPINameThreeE = retrieveString("keyAPINameThree");
    	lib_Common.bc_DeleteAPI(this, varAPINameThreeE,URLs_publisherURL);
    	writeToReport("End Of Executing Tag Management");
    } 
    	

    /**
     * Data provider for Test case tc_APISearch_Of_Publisher.
     * @return data table
     */
    @DataProvider(name = "tc_APISearch_Of_Publisher")
    public Object[][] dataTable_tc_APISearch_Of_Publisher() {     	
    	return this.getDataTable("URLs","Tenant_UserCreation","APISearch_Publisher");
    }

    /**
     * Data driven test case tc_APISearch_Of_Publisher.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APISearch_Of_Publisher")
    public final void tc_APISearch_Of_Publisher(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Tenant_UserCreation_tenantOnePublisherUserNameOne, final String Tenant_UserCreation_tenantOnePublisherUserOnePassword, final String Tenant_UserCreation_tenantOneRoleNameOnePublisherUserOne, final String Tenant_UserCreation_tenantOneStoreUserNameOne, final String Tenant_UserCreation_tenantOneStoreUserOnePassword, final String Tenant_UserCreation_tenantOneRoleNameOneStoreUserOne, final String Tenant_UserCreation_tenantOnePublisherUserNameTwo, final String Tenant_UserCreation_tenantOnePublisherUserTwoPassword, final String Tenant_UserCreation_tenantOneRoleNameOnePublisherUserTwo, final String Tenant_UserCreation_tenantOneStoreUserNameTwo, final String Tenant_UserCreation_tenantOneStoreUserTwoPassword, final String Tenant_UserCreation_tenantOneRoleNameOneStoreUserTwo, final String Tenant_UserCreation_tenantTwoPublisherUserNameOne, final String Tenant_UserCreation_tenantTwoPublisherUserOnePassword, final String Tenant_UserCreation_tenantTwoRoleNameOnePublisherUserOne, final String Tenant_UserCreation_tenantTwoStoreUserNameOne, final String Tenant_UserCreation_tenantTwoStoreUserOnePassword, final String Tenant_UserCreation_tenantTwoRoleNameOneStoreUserOne, final String Tenant_UserCreation_tenantThreePublisherUserNameOne, final String Tenant_UserCreation_tenantThreePublisherUserOnePassword, final String Tenant_UserCreation_tenantThreeRoleNameOnePublisherUserOne, final String Tenant_UserCreation_tenantThreeStoreUserNameOne, final String Tenant_UserCreation_tenantThreeStoreUserOnePassword, final String Tenant_UserCreation_tenantThreeRoleNameOneStoreUserOne, final String Tenant_UserCreation_tenantThreeStoreUserNameTwo, final String Tenant_UserCreation_tenantThreeStoreUserTwoPassword, final String Tenant_UserCreation_tenantThreeRoleNameOneStoreUserTwo, final String APISearch_Publisher_APIName, final String APISearch_Publisher_APIContext, final String APISearch_Publisher_APIVersion, final String APISearch_Publisher_APIImagePath, final String APISearch_Publisher_APITag, final String APISearch_Publisher_searchAPIProvider, final String APISearch_Publisher_ProductionEndPontJaxRS, final String APISearch_Publisher_searchVersion, final String APISearch_Publisher_searchContext, final String APISearch_Publisher_statusCreated, final String APISearch_Publisher_statusPublished, final String APISearch_Publisher_statusBlocked, final String APISearch_Publisher_statusRetired, final String APISearch_Publisher_statusPrototyped, final String APISearch_Publisher_statusDeprecated, final String APISearch_Publisher_searchStatus, final String APISearch_Publisher_searchDescription, final String APISearch_Publisher_Description, final String APISearch_Publisher_searchSubContext, final String APISearch_Publisher_URLPattern, final String APISearch_Publisher_verbMethodGET, final String APISearch_Publisher_secrchDoc, final String APISearch_Publisher_userCount, final String APISearch_Publisher_PublisherOneOfTenantOneOrAdmin) throws Exception {	
    	//350,351,352,353,354,356,357,358,359,384.
    	writeToReport("Start Executing APISearch_Of_Publisher");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,APISearch_Publisher_PublisherOneOfTenantOneOrAdmin);
    	lib_TestCase.APIM_350(this, APISearch_Publisher_APIName,APISearch_Publisher_APIContext,APISearch_Publisher_APIVersion,APISearch_Publisher_APIImagePath,APISearch_Publisher_APITag,APISearch_Publisher_ProductionEndPontJaxRS,APISearch_Publisher_Description,APISearch_Publisher_URLPattern,APISearch_Publisher_verbMethodGET);
    	lib_TestCase.APIM_351(this, Tenant_UserCreation_tenantOnePublisherUserNameOne,APISearch_Publisher_APIName,APISearch_Publisher_searchAPIProvider,APISearch_Publisher_PublisherOneOfTenantOneOrAdmin);
    	lib_TestCase.APIM_352(this, APISearch_Publisher_searchVersion,APISearch_Publisher_APIVersion,APISearch_Publisher_APIName);
    	lib_TestCase.APIM_353(this, APISearch_Publisher_searchContext,APISearch_Publisher_APIContext,APISearch_Publisher_APIName);
    	lib_TestCase.APIM_354(this);
    	lib_TestCase.APIM_356(this, APISearch_Publisher_statusCreated,APISearch_Publisher_statusPublished,APISearch_Publisher_statusBlocked,APISearch_Publisher_statusRetired,APISearch_Publisher_statusPrototyped,APISearch_Publisher_statusDeprecated,APISearch_Publisher_APIName,APISearch_Publisher_searchStatus);
    	lib_TestCase.APIM_357(this, APISearch_Publisher_searchDescription,APISearch_Publisher_Description,APISearch_Publisher_APIName);
    	lib_TestCase.APIM_358(this, APISearch_Publisher_searchSubContext,APISearch_Publisher_APIName,APISearch_Publisher_URLPattern);
    	lib_TestCase.APIM_359(this, APISearch_Publisher_APIName,APISearch_Publisher_secrchDoc);
    	lib_TestCase.APIM_384(this, APISearch_Publisher_APIName,APISearch_Publisher_statusPublished,APISearch_Publisher_APIVersion,Tenant_UserCreation_tenantOnePublisherUserNameOne,APISearch_Publisher_userCount,APISearch_Publisher_PublisherOneOfTenantOneOrAdmin);
    	String varAPINameD = retrieveString("keyAPIName");
    	lib_Common.bc_DeleteAPI(this, varAPINameD,URLs_publisherURL);
    	writeToReport("End Of Executing APISearch_Of_Publisher");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}