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
 *  Class ts_APIVersioning implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APIVersioning extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_LifeCycle.
     * @return data table
     */
    @DataProvider(name = "tc_LifeCycle")
    public Object[][] dataTable_tc_LifeCycle() {     	
    	return this.getDataTable("URLs","LifeCycle");
    }

    /**
     * Data driven test case tc_LifeCycle.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_LifeCycle")
    public final void tc_LifeCycle(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String LifeCycle_domain, final String LifeCycle_imagePath, final String LifeCycle_APIVersion, final String LifeCycle_tagName, final String LifeCycle_APIName, final String LifeCycle_stateBlocked, final String LifeCycle_newVersionOne, final String LifeCycle_usersCount, final String LifeCycle_APIstatus, final String LifeCycle_productionEndpoint, final String LifeCycle_sandBoxEndpoint, final String LifeCycle_stateCreated, final String LifeCycle_newVersionTwo, final String LifeCycle_statePublished, final String LifeCycle_newVersionThree, final String LifeCycle_stateDeprecated, final String LifeCycle_newVersionFive, final String LifeCycle_stateRetired, final String LifeCycle_newVersionSix, final String LifeCycle_statePrototyped, final String LifeCycle_newVersionFour, final String LifeCycle_NewVersionForAddNewVersion) throws Exception {	
    	writeToReport("Start of TS API Versioning.");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,LifeCycle_domain);
    	//Retrive the creator using domain
    	String varPublisherUserNameFinal = null;
    	if(LifeCycle_domain.equals("Tenant")){
    	String varUserNameRetrived = retrieveString("keyTenantOnePublisherUserOne");
    	varPublisherUserNameFinal = varUserNameRetrived;
    	} else {
    	String varUserNameRetrived = retrieveString("keyAdminPublisherUserOne");
    	varPublisherUserNameFinal = varUserNameRetrived;
    	}
    	lib_TestCase.APIM_127(this, LifeCycle_imagePath,LifeCycle_APIVersion,LifeCycle_tagName,LifeCycle_APIName,LifeCycle_stateBlocked,LifeCycle_newVersionOne,varPublisherUserNameFinal,LifeCycle_usersCount,LifeCycle_APIstatus,LifeCycle_productionEndpoint,LifeCycle_sandBoxEndpoint);
    	//Retrieving API Name from APIM-127
    	String varAPINameOne = retrieveString("keyAPINameVersioning");
    	lib_TestCase.APIM_122(this, LifeCycle_stateCreated,LifeCycle_newVersionTwo,varPublisherUserNameFinal,LifeCycle_APIstatus,LifeCycle_usersCount,varAPINameOne);
    	lib_TestCase.APIM_123(this, LifeCycle_statePublished,LifeCycle_newVersionThree,varPublisherUserNameFinal,varAPINameOne,LifeCycle_APIstatus,LifeCycle_usersCount);
    	lib_TestCase.APIM_124(this, LifeCycle_statePrototyped,LifeCycle_newVersionFour,varPublisherUserNameFinal,varAPINameOne,LifeCycle_APIstatus,LifeCycle_usersCount);
    	lib_TestCase.APIM_125(this, LifeCycle_stateDeprecated,LifeCycle_newVersionFive,varPublisherUserNameFinal,varAPINameOne,LifeCycle_APIstatus,LifeCycle_usersCount);
    	lib_TestCase.APIM_126(this, LifeCycle_stateRetired,LifeCycle_newVersionSix,varPublisherUserNameFinal,varAPINameOne,LifeCycle_APIstatus,LifeCycle_usersCount);
    	lib_TestCase.APIM_128(this, varAPINameOne,LifeCycle_APIVersion,URLs_publisherURL);
    	lib_TestCase.APIM_131(this, varAPINameOne);
    	lib_TestCase.APIM_4A(this, varAPINameOne,LifeCycle_NewVersionForAddNewVersion,URLs_publisherURL);
    	lib_TestCase.APIM_5A(this, varAPINameOne,LifeCycle_APIVersion);
    	lib_Common.bc_DeleteAPI(this, varAPINameOne,URLs_publisherURL);
    	writeToReport("End of TS API Versioning");
    } 
    	

    /**
     * Test case tc_API_Versionin.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_API_Versionin() throws Exception {
    } 
    	

    /**
     * Test case tc_default_Version.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_default_Version() throws Exception {
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}