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
 *  Class ts_KeyGeneration implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_KeyGeneration extends SeleniumTestBase {



    /**
     * Test case tc_Key_Generation_With_Scopes.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_Key_Generation_With_Scopes() throws Exception {
    } 
    	

    /**
     * Test case tc_Regenerate_Keys.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_Regenerate_Keys() throws Exception {
    } 
    	

    /**
     * Test case tc_Key_Generation_With_Domains.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_Key_Generation_With_Domains() throws Exception {
    } 
    	

    /**
     * Test case tc_Key_Expiration_Verification.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_Key_Expiration_Verification() throws Exception {
    } 
    	

    /**
     * Data provider for Test case tc_New_Key_Generation.
     * @return data table
     */
    @DataProvider(name = "tc_New_Key_Generation")
    public Object[][] dataTable_tc_New_Key_Generation() {     	
    	return this.getDataTable("URLs","NewKeyGeneration");
    }

    /**
     * Data driven test case tc_New_Key_Generation.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_New_Key_Generation")
    public final void tc_New_Key_Generation(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String NewKeyGeneration_domain, final String NewKeyGeneration_APINameOne, final String NewKeyGeneration_APIOneContext, final String NewKeyGeneration_APIOneVersion, final String NewKeyGeneration_APIOneTagName, final String NewKeyGeneration_APIOneImagePath, final String NewKeyGeneration_APIOneDescription, final String NewKeyGeneration_APIOneURLPattern, final String NewKeyGeneration_productionEndPoint, final String NewKeyGeneration_sandBoxEndPoint, final String NewKeyGeneration_appName, final String NewKeyGeneration_tokenValue, final String NewKeyGeneration_throttlingTier) throws Exception {	
    	writeToReport("Start of ts_NewKeyGeneration");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,NewKeyGeneration_domain);
    	lib_TestCase.APIM_207(this, NewKeyGeneration_APINameOne,NewKeyGeneration_productionEndPoint,NewKeyGeneration_APIOneContext,NewKeyGeneration_APIOneTagName,NewKeyGeneration_APIOneImagePath,NewKeyGeneration_APIOneVersion,NewKeyGeneration_sandBoxEndPoint,NewKeyGeneration_appName,NewKeyGeneration_tokenValue,NewKeyGeneration_tokenValue,URLs_storeURL,NewKeyGeneration_throttlingTier,NewKeyGeneration_domain);
    	String varAPIName = retrieveString("keyAPIName");
    	String varAPIVersion = retrieveString("keyAPIVersion");
    	String varAPPName = retrieveString("keyAPPName");
    	lib_Common.bc_UnSubscribeDeleteAPI(this, URLs_storeURL,varAPIName,varAPIVersion,URLs_publisherURL,varAPPName,NewKeyGeneration_domain);
    	writeToReport("End of ts_NewKeyGeneration.");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}