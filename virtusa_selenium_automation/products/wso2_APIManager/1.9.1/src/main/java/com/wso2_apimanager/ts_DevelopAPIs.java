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
 *  Class ts_DevelopAPIs implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_DevelopAPIs extends SeleniumTestBase {

    String keySampleJasonURL;


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
    public final void tc_DesignNewAPI(final String DesignNewAPI_domain, final String DesignNewAPI_APIName, final String DesignNewAPI_APIContext, final String DesignNewAPI_APIVersion, final String DesignNewAPI_APITagName, final String DesignNewAPI_nonImagePath, final String DesignNewAPI_APIImagepath, final String DesignNewAPI_APIURLPattern, final String DesignNewAPI_VisibilityRestrictedByRole, final String DesignNewAPI_ProductionEndpointUrl, final String DesignNewAPI_SandboxEndpointUrl, final String DesignNewAPI_InvalidUrl, final String DesignNewAPI_validUrl, final String DesignNewAPI_EndpointSecurityScheme, final String DesignNewAPI_endpointUsername, final String DesignNewAPI_endpointPassword, final String DesignNewAPI_EndPointType_Http, final String DesignNewAPI_publisherUserOne, final String DesignNewAPI_storeUserOne, final String DesignNewAPI_DefaultApplication, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	//Precondition
    	writeToReport("Start of test suite design API");
    	lib_Common.bc_DeleteAllApplicationsAndAPIs(this, URLs_storeURL,DesignNewAPI_domain,DesignNewAPI_storeUserOne,URLs_publisherURL,DesignNewAPI_publisherUserOne,DesignNewAPI_DefaultApplication);
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,DesignNewAPI_publisherUserOne);
    	pause("4000");
    	lib_TestCase.APIM2_757(this, DesignNewAPI_APIName,DesignNewAPI_APIVersion,DesignNewAPI_APITagName);
    	lib_TestCase.APIM2_758(this);
    	lib_Common.bc_DeleteAllApplicationsAndAPIs(this, URLs_storeURL,DesignNewAPI_domain,DesignNewAPI_storeUserOne,URLs_publisherURL,DesignNewAPI_publisherUserOne,DesignNewAPI_DefaultApplication);
    	writeToReport("End of test suite design API");
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
    	//Retrive API one name
    	String APIName = retrieveString("var_APINameOne");
    	lib_Common.bc_DeleteAPI(this, APIName,URLs_publisherURL);
    	writeToReport("End of test suite design API");
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
    	

    /**
     * Data provider for Test case tc_SwaggerEditorFunctionality.
     * @return data table
     */
    @DataProvider(name = "tc_SwaggerEditorFunctionality")
    public Object[][] dataTable_tc_SwaggerEditorFunctionality() {     	
    	return this.getDataTable("URLs","SwaggerEditorFunctionality");
    }

    /**
     * Data driven test case tc_SwaggerEditorFunctionality.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_SwaggerEditorFunctionality")
    public final void tc_SwaggerEditorFunctionality(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String SwaggerEditorFunctionality_downImage, final String SwaggerEditorFunctionality_APIName, final String SwaggerEditorFunctionality_APIContext, final String SwaggerEditorFunctionality_APIVersion, final String SwaggerEditorFunctionality_APITag, final String SwaggerEditorFunctionality_Description, final String SwaggerEditorFunctionality_DownloadFilePath, final String SwaggerEditorFunctionality_tenantOrAdminPublisherOne, final String SwaggerEditorFunctionality_DownloadFilePathJason) throws Exception {	
    	writeToReport("start executing SwaggerEditorFunctionality");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,SwaggerEditorFunctionality_tenantOrAdminPublisherOne);
    	lib_TestCase.APIM2_730(this, SwaggerEditorFunctionality_downImage,SwaggerEditorFunctionality_APIName,SwaggerEditorFunctionality_APIContext,SwaggerEditorFunctionality_APIVersion,SwaggerEditorFunctionality_APITag,SwaggerEditorFunctionality_Description,SwaggerEditorFunctionality_DownloadFilePath);
    	lib_TestCase.APIM2_731(this, SwaggerEditorFunctionality_downImage,SwaggerEditorFunctionality_DownloadFilePath,URLs_publisherURL,SwaggerEditorFunctionality_DownloadFilePathJason);
    	String varAPINameOne = retrieveString("keyAPIName");
    	//Delete created API
    	lib_Common.bc_DeleteAPI(this, varAPINameOne,URLs_publisherURL);
    	writeToReport("End of executing SwaggerEditorFunctionality");
    } 
    	

    /**
     * Data provider for Test case tc_CustomAttributeHandling.
     * @return data table
     */
    @DataProvider(name = "tc_CustomAttributeHandling")
    public Object[][] dataTable_tc_CustomAttributeHandling() {     	
    	return this.getDataTable("URLs","CustomAttributeHandling","KeyWords");
    }

    /**
     * Data driven test case tc_CustomAttributeHandling.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_CustomAttributeHandling")
    public final void tc_CustomAttributeHandling(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String CustomAttributeHandling_tenantOrAdminPublisherOne, final String CustomAttributeHandling_APIName, final String CustomAttributeHandling_APIContext, final String CustomAttributeHandling_APITag, final String CustomAttributeHandling_Description, final String CustomAttributeHandling_URLPattern, final String CustomAttributeHandling_verbMethodGET, final String CustomAttributeHandling_ProductionEndPontJaxRS, final String CustomAttributeHandling_SandboxEndpoint, final String CustomAttributeHandling_ResponseCaching, final String CustomAttributeHandling_jasonFileName, final String CustomAttributeHandling_APIVersionOne, final String CustomAttributeHandling_APIvisibility, final String CustomAttributeHandling_APIImageName, final String CustomAttributeHandling_urlPatternForPostAndPut, final String CustomAttributeHandling_urlPatternForGetDeleteAndHead, final String CustomAttributeHandling_cacheTimeForTimeOut, final String CustomAttributeHandling_StoreOneOfTenanrOrAdmin, final String CustomAttributeHandling_serverNameDomainOne, final String CustomAttributeHandling_keywordEnabled, final String KeyWords_keyWordYes, final String KeyWords_keyWordNo, final String KeyWords_keyWordPost, final String KeyWords_keyWordGet, final String KeyWords_keyWordPut, final String KeyWords_keyWordHead, final String KeyWords_keyWordDelete, final String KeyWords_numericValueTwoHundred, final String KeyWords_numericValueTwoHundredAndFour, final String KeyWords_numericValueOne, final String KeyWords_keyWordNull, final String KeyWords_keyWordNoContent, final String KeyWords_keyWordTrue, final String KeyWords_keyWordFalse) throws Exception {	
    	writeToReport("start executing CustomAttributeHandling");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,CustomAttributeHandling_tenantOrAdminPublisherOne);
    	lib_TestCase.APIM2_702(this, CustomAttributeHandling_APIName,CustomAttributeHandling_APIContext,CustomAttributeHandling_APITag,CustomAttributeHandling_Description,CustomAttributeHandling_URLPattern,CustomAttributeHandling_verbMethodGET,CustomAttributeHandling_ProductionEndPontJaxRS);
    	lib_TestCase.APIM2_709(this, URLs_publisherURL,CustomAttributeHandling_SandboxEndpoint,CustomAttributeHandling_ProductionEndPontJaxRS);
    	lib_TestCase.APIM2_717(this, URLs_publisherURL,CustomAttributeHandling_ResponseCaching);
    	String varAPINameOne = retrieveString("keyAPIName");
    	//Delete created API
    	lib_Common.bc_DeleteAPI(this, varAPINameOne,URLs_publisherURL);
    	lib_TestCase.APIM2_690(this, URLs_publisherURL,CustomAttributeHandling_tenantOrAdminPublisherOne,CustomAttributeHandling_jasonFileName,CustomAttributeHandling_APIName,CustomAttributeHandling_APIContext,CustomAttributeHandling_APIVersionOne,CustomAttributeHandling_APIvisibility,CustomAttributeHandling_APIImageName,CustomAttributeHandling_APITag,CustomAttributeHandling_urlPatternForPostAndPut,CustomAttributeHandling_urlPatternForGetDeleteAndHead,CustomAttributeHandling_ProductionEndPontJaxRS,KeyWords_keyWordYes,CustomAttributeHandling_SandboxEndpoint,KeyWords_keyWordNo,KeyWords_keyWordYes,KeyWords_keyWordNo,KeyWords_keyWordNull,CustomAttributeHandling_cacheTimeForTimeOut,KeyWords_keyWordPut,KeyWords_keyWordPost,KeyWords_keyWordGet,KeyWords_keyWordHead,URLs_storeURL,CustomAttributeHandling_StoreOneOfTenanrOrAdmin,CustomAttributeHandling_serverNameDomainOne,KeyWords_keyWordDelete,CustomAttributeHandling_keywordEnabled);
    	String var_SampleJasonURL = retrieveString("key_jasonURL");
    	store("keySampleJasonURL","String",var_SampleJasonURL);
    	lib_TestCase.APIM2_688(this, URLs_publisherURL,CustomAttributeHandling_tenantOrAdminPublisherOne,var_SampleJasonURL,CustomAttributeHandling_APIName,CustomAttributeHandling_APIContext,CustomAttributeHandling_APIVersionOne,CustomAttributeHandling_APIvisibility,CustomAttributeHandling_APIImageName,CustomAttributeHandling_APITag,CustomAttributeHandling_urlPatternForPostAndPut,CustomAttributeHandling_urlPatternForGetDeleteAndHead,CustomAttributeHandling_ProductionEndPontJaxRS,KeyWords_keyWordYes,CustomAttributeHandling_SandboxEndpoint,KeyWords_keyWordNo,KeyWords_keyWordNo,KeyWords_keyWordNull,KeyWords_keyWordYes,CustomAttributeHandling_cacheTimeForTimeOut,KeyWords_keyWordPut,KeyWords_keyWordPost,KeyWords_keyWordGet,KeyWords_keyWordHead,KeyWords_keyWordDelete,CustomAttributeHandling_keywordEnabled);
    	writeToReport("End of executing CustomAttributeHandling");
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
     * Test case tc_DesignAPIFromSOAPEndpoint.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_DesignAPIFromSOAPEndpoint() throws Exception {
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}