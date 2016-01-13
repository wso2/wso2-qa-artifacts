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
 *  Class ts_EndpointManagement implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_EndpointManagement extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_EndPointTypes.
     * @return data table
     */
    @DataProvider(name = "tc_EndPointTypes")
    public Object[][] dataTable_tc_EndPointTypes() {     	
    	return this.getDataTable("URLs","EndPointTypes");
    }

    /**
     * Data driven test case tc_EndPointTypes.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_EndPointTypes")
    public final void tc_EndPointTypes(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String EndPointTypes_domain, final String EndPointTypes_APIVersion, final String EndPointTypes_APIImagePath, final String EndPointTypes_APIName, final String EndPointTypes_tagName, final String EndPointTypes_APIContext, final String EndPointTypes_validSandboxEndpoint, final String EndPointTypes_validProductionEndPoint) throws Exception {	
    	writeToReport("Start of executing tc_EndPointTypes");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,EndPointTypes_domain);
    	lib_TestCase.APIM_34(this, EndPointTypes_APIVersion,EndPointTypes_APIImagePath,EndPointTypes_APIName,EndPointTypes_tagName,EndPointTypes_APIContext,URLs_storeURL,EndPointTypes_domain);
    	lib_TestCase.APIM_39(this, EndPointTypes_APIName,EndPointTypes_validSandboxEndpoint,EndPointTypes_validProductionEndPoint,URLs_publisherURL,EndPointTypes_APIContext,EndPointTypes_APIVersion,EndPointTypes_APIImagePath,EndPointTypes_tagName);
    	//Delete API
    	String varAPIName = retrieveString("keyAPIName");
    	lib_Common.bc_DeleteAPI(this, varAPIName,URLs_publisherURL);
    	writeToReport("End of executing tc_EndPointTypes");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}