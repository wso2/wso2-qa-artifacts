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
    	return this.getDataTable("URLs","APILifecycleManagement");
    }

    /**
     * Data driven test case tc_APILifeCycleManagement.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_APILifeCycleManagement")
    public final void tc_APILifeCycleManagement(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String APILifecycleManagement_domain, final String APILifecycleManagement_APINameOne, final String APILifecycleManagement_APIOneContext, final String APILifecycleManagement_APIOneVersion, final String APILifecycleManagement_APIOneTagName, final String APILifecycleManagement_APIOneImagePath, final String APILifecycleManagement_APIOneDescription, final String APILifecycleManagement_APIOneURLPattern, final String APILifecycleManagement_productionEndPoint, final String APILifecycleManagement_sandBoxEndPoint) throws Exception {	
    	writeToReport("Start of ts_APILifeCycleManagement");
    	//login to the publisher
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,APILifecycleManagement_domain);
    	lib_TestCase.APIM_21(this, APILifecycleManagement_APINameOne,APILifecycleManagement_APIOneContext,APILifecycleManagement_APIOneVersion,APILifecycleManagement_APIOneImagePath,APILifecycleManagement_APIOneTagName,APILifecycleManagement_APIOneURLPattern);
    	String varAPINameTwo = retrieveString("keyAPINameOne");
    	lib_Common.bc_DeleteAPI(this, varAPINameTwo,URLs_publisherURL);
    	writeToReport("End of ts_APILifeCycleManagement");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}