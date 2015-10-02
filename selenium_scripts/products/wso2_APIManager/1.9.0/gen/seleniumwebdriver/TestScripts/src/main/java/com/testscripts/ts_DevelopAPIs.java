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
 *  Class ts_DevelopAPIs implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_DevelopAPIs extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_DesignNewAPI.
     * @return data table
     */
    @DataProvider(name = "tc_DesignNewAPI")
    public Object[][] dataTable_tc_DesignNewAPI() {     	
    	return this.getDataTable("DesignNewAPI","URLs");
    }

    /**
     * Data driven test case tc_DesignNewAPI.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_DesignNewAPI")
    public final void tc_DesignNewAPI(final String DesignNewAPI_domain, final String DesignNewAPI_APIName, final String DesignNewAPI_APIContext, final String DesignNewAPI_APIVersion, final String DesignNewAPI_APITagName, final String DesignNewAPI_nonImagePath, final String DesignNewAPI_APIImagepath, final String DesignNewAPI_APIURLPattern, final String DesignNewAPI_VisibilityRestrictedByRole, final String DesignNewAPI_ProductionEndpointUrl, final String DesignNewAPI_SandboxEndpointUrl, final String DesignNewAPI_InvalidUrl, final String DesignNewAPI_validUrl, final String DesignNewAPI_EndpointSecurityScheme, final String DesignNewAPI_endpointUsername, final String DesignNewAPI_endpointPassword, final String DesignNewAPI_EndPointType_Http, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//Precondition
    	writeToReport("Start of test suite design API");
    	//Loging to API publisher Site
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,DesignNewAPI_domain);
    	lib_TestCase.APIM_20(this, DesignNewAPI_APIVersion,DesignNewAPI_nonImagePath,DesignNewAPI_APIImagepath,DesignNewAPI_APIURLPattern,DesignNewAPI_APIName,DesignNewAPI_APIContext,DesignNewAPI_APITagName);
    	lib_TestCase.APIM_280(this, DesignNewAPI_VisibilityRestrictedByRole);
    	lib_TestCase.APIM_278(this, DesignNewAPI_VisibilityRestrictedByRole,DesignNewAPI_domain,URLs_storeURL,DesignNewAPI_APIVersion,DesignNewAPI_ProductionEndpointUrl,DesignNewAPI_SandboxEndpointUrl,DesignNewAPI_domain);
    	lib_TestCase.APIM_55(this, DesignNewAPI_APIName,DesignNewAPI_ProductionEndpointUrl,DesignNewAPI_APIContext,DesignNewAPI_APIVersion,DesignNewAPI_APIImagepath,DesignNewAPI_APITagName,URLs_publisherURL,DesignNewAPI_domain,URLs_storeURL);
    	lib_TestCase.APIM_29(this, DesignNewAPI_validUrl,DesignNewAPI_InvalidUrl,URLs_publisherURL,DesignNewAPI_validUrl,DesignNewAPI_InvalidUrl);
    	lib_TestCase.APIM_32(this, DesignNewAPI_EndpointSecurityScheme,DesignNewAPI_endpointUsername,DesignNewAPI_endpointPassword);
    	lib_TestCase.APIM_33(this, DesignNewAPI_validUrl,DesignNewAPI_domain,URLs_storeURL);
    	lib_TestCase.APIM_24(this, DesignNewAPI_EndPointType_Http,DesignNewAPI_ProductionEndpointUrl,DesignNewAPI_domain,URLs_publisherURL,URLs_storeURL);
    	String APIName = retrieveString("var_APINameOne");
    	lib_Common.bc_DeleteAPI(this, APIName,URLs_publisherURL);
    	writeToReport("End of test suite design API");
    } 
    	

    /**
     * Test case tc_DesignAPIFromSOAPEndpoint.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_DesignAPIFromSOAPEndpoint() throws Exception {
    } 
    	

    /**
     * Test case tc_DesignAPIFromSwaggerDefinition.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_DesignAPIFromSwaggerDefinition() throws Exception {
    } 
    	

    /**
     * Test case tc_DeleteAPIs.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_DeleteAPIs() throws Exception {
    } 
    	

    /**
     * Data provider for Test case tc_UpdateAPIs.
     * @return data table
     */
    @DataProvider(name = "tc_UpdateAPIs")
    public Object[][] dataTable_tc_UpdateAPIs() {     	
    	return this.getDataTable("URLs","UpdateAPIs");
    }

    /**
     * Data driven test case tc_UpdateAPIs.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_UpdateAPIs")
    public final void tc_UpdateAPIs(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String UpdateAPIs_domain, final String UpdateAPIs_APIName, final String UpdateAPIs_ImagePath, final String UpdateAPIs_txtPath, final String UpdateAPIs_verbNamePost, final String UpdateAPIs_urlPatterSC, final String UpdateAPIs_verbNameDelete, final String UpdateAPIs_verbNameGet, final String UpdateAPIs_urlPattern, final String UpdateAPIs_verbName, final String UpdateAPIs_VisibilityPublic, final String UpdateAPIs_APIContext, final String UpdateAPIs_APIVersion) throws Exception {	
    	writeToReport("Start Executing Test suit UpdateAPIs");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,UpdateAPIs_domain);
    	lib_TestCase.APIM_217(this, UpdateAPIs_APIName,UpdateAPIs_ImagePath,UpdateAPIs_txtPath,URLs_storeURL,UpdateAPIs_APIContext,UpdateAPIs_APIVersion,UpdateAPIs_domain);
    	lib_TestCase.APIM_22(this, UpdateAPIs_verbNamePost,UpdateAPIs_urlPatterSC,UpdateAPIs_verbNameDelete,UpdateAPIs_verbNameGet,UpdateAPIs_urlPattern,UpdateAPIs_verbNameGet,UpdateAPIs_APIName,URLs_publisherURL,URLs_storeURL,UpdateAPIs_domain);
    	lib_TestCase.APIM_276(this, UpdateAPIs_APIName,UpdateAPIs_VisibilityPublic,URLs_publisherURL,URLs_storeURL,UpdateAPIs_domain);
    	String varUpdateAPI = retrieveString("keyUpdateAPIs");
    	lib_Common.bc_DeleteAPI(this, varUpdateAPI,URLs_publisherURL);
    	writeToReport("End Of Executing Test suit UpdateAPIs");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}