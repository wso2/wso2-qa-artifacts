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
 *  Class ts_ErrorHandling implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_ErrorHandling extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_ErrorHandling.
     * @return data table
     */
    @DataProvider(name = "tc_ErrorHandling")
    public Object[][] dataTable_tc_ErrorHandling() {     	
    	return this.getDataTable("URLs","ErrorHandling");
    }

    /**
     * Data driven test case tc_ErrorHandling.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_ErrorHandling")
    public final void tc_ErrorHandling(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String ErrorHandling_APIName, final String ErrorHandling_APIContext, final String ErrorHandling_APIVersionOne, final String ErrorHandling_APIvisibility, final String ErrorHandling_tagName, final String ErrorHandling_urlPatternForPostAndPut, final String ErrorHandling_urlPatternForGetDeleteAndHead, final String ErrorHandling_ProductionEndPoint, final String ErrorHandling_sandboxEndpoint, final String ErrorHandling_yes, final String ErrorHandling_no, final String ErrorHandling_TenantOrAdmin, final String ErrorHandling_TenantOrAdminStoreOne, final String ErrorHandling_defaultApplication, final String ErrorHandling_APIStateBlocked, final String ErrorHandling_keyTypeToInvoke, final String ErrorHandling_buttonNamePost, final String ErrorHandling_postPayloadContext, final String ErrorHandling_postCustomerNameFromPayloadContext, final String ErrorHandling_postResponseCode700700, final String ErrorHandling_postResponseCodeERROR900901, final String ErrorHandling_tenantOrAdminPublisherOne, final String ErrorHandling_responseHeader, final String ErrorHandling_APIStateBlockedSimple) throws Exception {	
    	writeToReport("Start of executing ts_ErrorHandling");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,ErrorHandling_tenantOrAdminPublisherOne);
    	lib_TestCase.APIM2_891(this, ErrorHandling_APIName,ErrorHandling_APIContext,ErrorHandling_APIVersionOne,ErrorHandling_APIvisibility,ErrorHandling_tagName,ErrorHandling_urlPatternForPostAndPut,ErrorHandling_urlPatternForGetDeleteAndHead,ErrorHandling_ProductionEndPoint,ErrorHandling_yes,ErrorHandling_no,ErrorHandling_sandboxEndpoint,URLs_storeURL,ErrorHandling_TenantOrAdmin,ErrorHandling_TenantOrAdminStoreOne,ErrorHandling_defaultApplication,ErrorHandling_keyTypeToInvoke,ErrorHandling_buttonNamePost,ErrorHandling_postPayloadContext,ErrorHandling_postCustomerNameFromPayloadContext,ErrorHandling_postResponseCodeERROR900901,ErrorHandling_responseHeader);
    	navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + URLs_publisherURL,"3000");
    	lib_TestCase.APIM2_905(this, ErrorHandling_APIName,ErrorHandling_APIContext,ErrorHandling_APIVersionOne,ErrorHandling_APIvisibility,ErrorHandling_tagName,ErrorHandling_urlPatternForPostAndPut,ErrorHandling_urlPatternForGetDeleteAndHead,ErrorHandling_ProductionEndPoint,ErrorHandling_sandboxEndpoint,ErrorHandling_yes,ErrorHandling_no,URLs_storeURL,ErrorHandling_TenantOrAdmin,ErrorHandling_TenantOrAdminStoreOne,ErrorHandling_defaultApplication,URLs_publisherURL,ErrorHandling_APIStateBlocked,ErrorHandling_keyTypeToInvoke,ErrorHandling_buttonNamePost,ErrorHandling_postPayloadContext,ErrorHandling_postCustomerNameFromPayloadContext,ErrorHandling_postResponseCode700700,ErrorHandling_responseHeader,ErrorHandling_APIStateBlockedSimple);
    	lib_Common.bc_DeleteAllApplicationsAndAPIs(this, URLs_storeURL,ErrorHandling_TenantOrAdmin,ErrorHandling_TenantOrAdminStoreOne,URLs_publisherURL,ErrorHandling_tenantOrAdminPublisherOne,ErrorHandling_defaultApplication);
    	writeToReport("End of executing ts_ErrorHandling");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}