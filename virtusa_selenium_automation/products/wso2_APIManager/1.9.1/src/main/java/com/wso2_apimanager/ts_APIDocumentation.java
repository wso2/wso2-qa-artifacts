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
 *  Class ts_APIDocumentation implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APIDocumentation extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_AddVerify_Documents.
     * @return data table
     */
    @DataProvider(name = "tc_AddVerify_Documents")
    public Object[][] dataTable_tc_AddVerify_Documents() {     	
    	return this.getDataTable("URLs","AddVerifyDocuments");
    }

    /**
     * Data driven test case tc_AddVerify_Documents.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_AddVerify_Documents")
    public final void tc_AddVerify_Documents(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String AddVerifyDocuments_domain, final String AddVerifyDocuments_apiName, final String AddVerifyDocuments_apiVersion, final String AddVerifyDocuments_apiTagName, final String AddVerifyDocuments_ProductionEndPoint, final String AddVerifyDocuments_SandBoxEndPoint, final String AddVerifyDocuments_docName, final String AddVerifyDocuments_docNameInvalid, final String AddVerifyDocuments_docSummery, final String AddVerifyDocuments_SourseUrl, final String AddVerifyDocuments_apiContext, final String AddVerifyDocuments_UploadFilePath, final String AddVerifyDocuments_DownloadFilePath, final String AddVerifyDocuments_downImag, final String AddVerifyDocuments_otherType, final String AddVerifyDocuments_labelOther, final String AddVerifyDocuments_labelSupport, final String AddVerifyDocuments_labelPublic, final String AddVerifyDocuments_labelSample, final String AddVerifyDocuments_labelHowTo, final String AddVerifyDocuments_editContent, final String AddVerifyDocuments_ImageName) throws Exception {	
    	//Precondition
    	//Loging to API publisher Site
    	writeToReport("Start Executing tc_AddVerify_Documents");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_95(this, AddVerifyDocuments_ImageName,AddVerifyDocuments_apiVersion,AddVerifyDocuments_apiTagName,AddVerifyDocuments_apiName,AddVerifyDocuments_ProductionEndPoint,AddVerifyDocuments_SandBoxEndPoint,AddVerifyDocuments_docNameInvalid,AddVerifyDocuments_docName,AddVerifyDocuments_docSummery,AddVerifyDocuments_SourseUrl,URLs_storeURL,AddVerifyDocuments_apiContext,URLs_publisherURL,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_90(this);
    	lib_TestCase.APIM_91(this, AddVerifyDocuments_docSummery,URLs_storeURL,URLs_publisherURL,AddVerifyDocuments_docName,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_92(this, AddVerifyDocuments_docNameInvalid,AddVerifyDocuments_SourseUrl,AddVerifyDocuments_docNameInvalid,URLs_publisherURL,URLs_storeURL,AddVerifyDocuments_docName,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_93(this, AddVerifyDocuments_docName,AddVerifyDocuments_UploadFilePath,AddVerifyDocuments_docSummery,URLs_storeURL,AddVerifyDocuments_DownloadFilePath,AddVerifyDocuments_apiVersion,URLs_publisherURL,AddVerifyDocuments_downImag,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_94(this, AddVerifyDocuments_docName,AddVerifyDocuments_docSummery,URLs_storeURL,URLs_publisherURL,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_97(this, AddVerifyDocuments_docName,AddVerifyDocuments_docSummery);
    	lib_TestCase.APIM_347(this);
    	lib_TestCase.APIM_349(this);
    	lib_TestCase.APIM_116(this, AddVerifyDocuments_otherType,AddVerifyDocuments_SourseUrl,URLs_publisherURL,AddVerifyDocuments_labelOther,AddVerifyDocuments_labelSupport,AddVerifyDocuments_labelPublic,AddVerifyDocuments_labelSample,AddVerifyDocuments_labelHowTo,AddVerifyDocuments_docName);
    	lib_TestCase.APIM_105(this, AddVerifyDocuments_docName,AddVerifyDocuments_docSummery,AddVerifyDocuments_otherType,AddVerifyDocuments_UploadFilePath,AddVerifyDocuments_DownloadFilePath,URLs_storeURL,URLs_publisherURL,AddVerifyDocuments_labelOther,AddVerifyDocuments_downImag,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_104(this, AddVerifyDocuments_docName,AddVerifyDocuments_docSummery,AddVerifyDocuments_otherType,AddVerifyDocuments_SourseUrl,URLs_publisherURL,AddVerifyDocuments_labelOther);
    	lib_TestCase.APIM_103(this, AddVerifyDocuments_docName,AddVerifyDocuments_docSummery,AddVerifyDocuments_otherType,AddVerifyDocuments_editContent,URLs_storeURL,URLs_publisherURL,AddVerifyDocuments_labelOther,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_102(this, AddVerifyDocuments_docName,AddVerifyDocuments_docSummery,AddVerifyDocuments_UploadFilePath,AddVerifyDocuments_DownloadFilePath,URLs_storeURL,URLs_publisherURL,AddVerifyDocuments_labelSupport,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_101(this, AddVerifyDocuments_docName,AddVerifyDocuments_docSummery,AddVerifyDocuments_SourseUrl,URLs_publisherURL,URLs_storeURL,AddVerifyDocuments_labelSupport,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_100(this, URLs_publisherURL,AddVerifyDocuments_docName,AddVerifyDocuments_docSummery);
    	lib_TestCase.APIM_99(this, AddVerifyDocuments_docSummery,AddVerifyDocuments_docName,AddVerifyDocuments_UploadFilePath,AddVerifyDocuments_DownloadFilePath,URLs_publisherURL,URLs_storeURL,AddVerifyDocuments_labelPublic,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_98(this, AddVerifyDocuments_docName,AddVerifyDocuments_docSummery,AddVerifyDocuments_SourseUrl,URLs_storeURL,URLs_publisherURL,AddVerifyDocuments_labelPublic,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_96(this, URLs_publisherURL,AddVerifyDocuments_docName,AddVerifyDocuments_docSummery,AddVerifyDocuments_labelSample,AddVerifyDocuments_DownloadFilePath,URLs_storeURL,AddVerifyDocuments_UploadFilePath,AddVerifyDocuments_domain);
    	lib_TestCase.APIM_6A(this, URLs_publisherURL);
    	String APIName = retrieveString("var_APIName");
    	lib_Common.bc_DeleteAPI(this, APIName,URLs_publisherURL);
    	writeToReport("End of tc_AddVerify_Documents");
    } 
    	

    /**
     * Data provider for Test case tc_UpdateDocuments.
     * @return data table
     */
    @DataProvider(name = "tc_UpdateDocuments")
    public Object[][] dataTable_tc_UpdateDocuments() {     	
    	return this.getDataTable("URLs","UpdateDocuments");
    }

    /**
     * Data driven test case tc_UpdateDocuments.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_UpdateDocuments")
    public final void tc_UpdateDocuments(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String UpdateDocuments_domain, final String UpdateDocuments_apiName, final String UpdateDocuments_apiContext, final String UpdateDocuments_apiVersion, final String UpdateDocuments_apiTagName, final String UpdateDocuments_docName, final String UpdateDocuments_ProductionEndPoint, final String UpdateDocuments_SandBoxEndPoint, final String UpdateDocuments_editContent, final String UpdateDocuments_sourseUrl, final String UpdateDocuments_TableColumnType, final String UpdateDocuments_imageName, final String UpdateDocuments_uploadFilePath, final String UpdateDocuments_docSameAsAPIVisibility, final String UpdateDocuments_otherText, final String UpdateDocuments_uploadFilePathTwo, final String UpdateDocuments_downloadFilePath, final String UpdateDocuments_docSummery, final String UpdateDocuments_docSummeryTwo, final String UpdateDocuments_docVisibilityPrivate, final String UpdateDocuments_docVisibilityMyDomain, final String UpdateDocuments_popupImage) throws Exception {	
    	//Precondition
    	//Loging to API publisher Site
    	writeToReport("Start Executing tc_Update Documents");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,UpdateDocuments_domain);
    	lib_Common.bc_createAndPublishAPI(this, UpdateDocuments_apiName,UpdateDocuments_apiContext,UpdateDocuments_apiVersion,UpdateDocuments_imageName,UpdateDocuments_apiTagName,UpdateDocuments_ProductionEndPoint,UpdateDocuments_SandBoxEndPoint);
    	lib_TestCase.APIM_165(this, UpdateDocuments_docName,UpdateDocuments_editContent,URLs_storeURL,URLs_publisherURL,UpdateDocuments_domain);
    	lib_TestCase.APIM_113(this, UpdateDocuments_docName,UpdateDocuments_sourseUrl);
    	lib_TestCase.APIM_112(this, UpdateDocuments_editContent,URLs_publisherURL,UpdateDocuments_domain,URLs_storeURL,UpdateDocuments_TableColumnType);
    	lib_TestCase.APIM_115(this, UpdateDocuments_docName);
    	lib_TestCase.APIM2_1010(this, UpdateDocuments_docName,UpdateDocuments_uploadFilePath,UpdateDocuments_docSameAsAPIVisibility,UpdateDocuments_otherText,UpdateDocuments_editContent,URLs_publisherURL,UpdateDocuments_domain,URLs_storeURL);
    	lib_TestCase.APIM2_1009(this, UpdateDocuments_docName,UpdateDocuments_uploadFilePath,UpdateDocuments_docSameAsAPIVisibility,UpdateDocuments_sourseUrl,UpdateDocuments_domain,URLs_publisherURL,URLs_storeURL);
    	lib_TestCase.APIM2_475(this, UpdateDocuments_docName,UpdateDocuments_uploadFilePath,UpdateDocuments_docSameAsAPIVisibility,UpdateDocuments_uploadFilePathTwo,UpdateDocuments_popupImage,UpdateDocuments_downloadFilePath,UpdateDocuments_domain,URLs_publisherURL,URLs_storeURL,UpdateDocuments_docSummery);
    	lib_TestCase.APIM2_1005(this, UpdateDocuments_docName,UpdateDocuments_sourseUrl,UpdateDocuments_docSameAsAPIVisibility,UpdateDocuments_uploadFilePath,UpdateDocuments_popupImage,UpdateDocuments_downloadFilePath,UpdateDocuments_domain,URLs_storeURL,URLs_publisherURL,UpdateDocuments_docSummery,"");
    	lib_TestCase.APIM2_474(this, UpdateDocuments_docName,UpdateDocuments_uploadFilePath,UpdateDocuments_docSameAsAPIVisibility,UpdateDocuments_editContent,URLs_storeURL,UpdateDocuments_domain,URLs_publisherURL,UpdateDocuments_sourseUrl,UpdateDocuments_otherText);
    	lib_TestCase.APIM2_419(this, UpdateDocuments_docName,UpdateDocuments_uploadFilePath,UpdateDocuments_docSameAsAPIVisibility,URLs_storeURL,UpdateDocuments_domain,UpdateDocuments_sourseUrl,URLs_publisherURL);
    	lib_TestCase.APIM2_997(this, UpdateDocuments_docName,UpdateDocuments_docSummery,UpdateDocuments_docSameAsAPIVisibility,URLs_storeURL,UpdateDocuments_domain,UpdateDocuments_sourseUrl,URLs_publisherURL);
    	lib_TestCase.APIM2_1002(this, UpdateDocuments_docName,UpdateDocuments_docSummery,UpdateDocuments_docSameAsAPIVisibility,UpdateDocuments_uploadFilePath,UpdateDocuments_popupImage,UpdateDocuments_downloadFilePath,URLs_storeURL,UpdateDocuments_domain,URLs_publisherURL);
    	lib_TestCase.APIM2_100(this, UpdateDocuments_docName,UpdateDocuments_docSummery,URLs_publisherURL);
    	String APIName = retrieveString("var_APIName");
    	lib_Common.bc_DeleteAPI(this, APIName,URLs_publisherURL);
    	writeToReport("End of Executing tc_Update Documents");
    } 
    	

    /**
     * Data provider for Test case tc_DeleteDocuments.
     * @return data table
     */
    @DataProvider(name = "tc_DeleteDocuments")
    public Object[][] dataTable_tc_DeleteDocuments() {     	
    	return this.getDataTable("URLs","DeleteDocuments");
    }

    /**
     * Data driven test case tc_DeleteDocuments.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_DeleteDocuments")
    public final void tc_DeleteDocuments(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String DeleteDocuments_domain, final String DeleteDocuments_APIName, final String DeleteDocuments_APIContext, final String DeleteDocuments_APIVersion, final String DeleteDocuments_APITagName, final String DeleteDocuments_ProductionEndPoint, final String DeleteDocuments_SandBoxEndPoint, final String DeleteDocuments_TypeOther, final String DeleteDocuments_UploadFilePath, final String DeleteDocuments_docName, final String DeleteDocuments_sourseUrl, final String DeleteDocuments_imageName) throws Exception {	
    	//Precondition
    	//Loging to API publisher Site
    	writeToReport("Start Executing tc_Update Documents");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,DeleteDocuments_domain);
    	lib_Common.bc_createAndPublishAPI(this, DeleteDocuments_APIName,DeleteDocuments_APIContext,DeleteDocuments_APIVersion,DeleteDocuments_imageName,DeleteDocuments_APITagName,DeleteDocuments_ProductionEndPoint,DeleteDocuments_SandBoxEndPoint);
    	lib_TestCase.APIM_121(this, DeleteDocuments_TypeOther,DeleteDocuments_sourseUrl,DeleteDocuments_UploadFilePath,URLs_storeURL,URLs_publisherURL,DeleteDocuments_docName,DeleteDocuments_domain);
    	lib_TestCase.APIM_120(this, DeleteDocuments_sourseUrl,DeleteDocuments_UploadFilePath,DeleteDocuments_domain,URLs_storeURL,URLs_publisherURL,DeleteDocuments_docName);
    	lib_TestCase.APIM_119(this, DeleteDocuments_sourseUrl,DeleteDocuments_UploadFilePath,DeleteDocuments_domain,URLs_storeURL,URLs_publisherURL,DeleteDocuments_docName);
    	lib_TestCase.APIM_118(this, DeleteDocuments_sourseUrl,DeleteDocuments_UploadFilePath,DeleteDocuments_domain,URLs_storeURL,URLs_publisherURL,DeleteDocuments_docName);
    	lib_TestCase.APIM_117(this, DeleteDocuments_sourseUrl,DeleteDocuments_UploadFilePath,DeleteDocuments_domain,URLs_storeURL,URLs_publisherURL,DeleteDocuments_docName);
    	String APIName = retrieveString("var_APIName");
    	lib_Common.bc_DeleteAPI(this, APIName,URLs_publisherURL);
    	writeToReport("End of Executing tc_Delete Documents");
    } 
    	

    /**
     * Data provider for Test case tc_Edit_Existing_DocContent.
     * @return data table
     */
    @DataProvider(name = "tc_Edit_Existing_DocContent")
    public Object[][] dataTable_tc_Edit_Existing_DocContent() {     	
    	return this.getDataTable("URLs","EditExistingDocContent");
    }

    /**
     * Data driven test case tc_Edit_Existing_DocContent.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Edit_Existing_DocContent")
    public final void tc_Edit_Existing_DocContent(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String EditExistingDocContent_domain, final String EditExistingDocContent_APIName, final String EditExistingDocContent_docNameOne, final String EditExistingDocContent_uploadDocLocation, final String EditExistingDocContent_docSummary, final String EditExistingDocContent_updateSummaryOne, final String EditExistingDocContent_URLLinkOne, final String EditExistingDocContent_newVersionOne, final String EditExistingDocContent_newVersionTwo, final String EditExistingDocContent_documentOtherNameOne, final String EditExistingDocContent_docNameTwo, final String EditExistingDocContent_statePublished, final String EditExistingDocContent_downloadFilePath, final String EditExistingDocContent_updateSummaryTwo, final String EditExistingDocContent_URLLinkTwo, final String EditExistingDocContent_documentOtherNameTwo, final String EditExistingDocContent_updateSummaryThree, final String EditExistingDocContent_editContentOne, final String EditExistingDocContent_editContentTwo, final String EditExistingDocContent_editContentThree, final String EditExistingDocContent_imagePath, final String EditExistingDocContent_productionEndpoint, final String EditExistingDocContent_sandboxEndpoint, final String EditExistingDocContent_downImagePopup) throws Exception {	
    	writeToReport("Start of TS Edit Existing Doc Content");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,EditExistingDocContent_domain);
    	//Retrive the user name to check the creator
    	String varUserNameFinal = null;
    	if(EditExistingDocContent_domain.equals("Tenant")){
    	String varUserNameRetrived = retrieveString("keyTenantOnePublisherUserOne");
    	varUserNameFinal = varUserNameRetrived;
    	} else {
    	String varUserNameRetrived = retrieveString("keyAdminPublisherUserOne");
    	varUserNameFinal = varUserNameRetrived;
    	}
    	lib_TestCase.APIM_419(this, EditExistingDocContent_APIName,EditExistingDocContent_docNameOne,EditExistingDocContent_uploadDocLocation,EditExistingDocContent_docSummary,EditExistingDocContent_updateSummaryOne,EditExistingDocContent_URLLinkOne,EditExistingDocContent_newVersionTwo,EditExistingDocContent_documentOtherNameOne,EditExistingDocContent_docNameTwo,URLs_storeURL,EditExistingDocContent_statePublished,URLs_publisherURL,EditExistingDocContent_downloadFilePath,EditExistingDocContent_imagePath,EditExistingDocContent_newVersionOne,varUserNameFinal,EditExistingDocContent_productionEndpoint,EditExistingDocContent_sandboxEndpoint,EditExistingDocContent_domain,EditExistingDocContent_downImagePopup);
    	//Retriew value of API Name
    	String varAPINameRetrived = retrieveString("keyAPINameEditChange");
    	//Retriew value of doc name one
    	String varDocumentOne = retrieveString("keyDocNameOne");
    	lib_TestCase.APIM_418(this, varDocumentOne,EditExistingDocContent_updateSummaryTwo,EditExistingDocContent_URLLinkTwo,varAPINameRetrived,EditExistingDocContent_documentOtherNameOne,EditExistingDocContent_newVersionTwo,URLs_storeURL,URLs_publisherURL,EditExistingDocContent_domain);
    	lib_TestCase.APIM_417(this, URLs_publisherURL,varDocumentOne,EditExistingDocContent_URLLinkOne,EditExistingDocContent_updateSummaryThree,EditExistingDocContent_URLLinkTwo,varAPINameRetrived,EditExistingDocContent_newVersionTwo,URLs_storeURL,EditExistingDocContent_domain);
    	lib_TestCase.APIM_416(this, varDocumentOne,EditExistingDocContent_URLLinkOne,varAPINameRetrived,EditExistingDocContent_newVersionTwo,EditExistingDocContent_updateSummaryTwo,EditExistingDocContent_URLLinkTwo,URLs_publisherURL,URLs_storeURL,EditExistingDocContent_domain);
    	lib_TestCase.APIM_415(this, varDocumentOne,EditExistingDocContent_URLLinkOne,EditExistingDocContent_updateSummaryTwo,EditExistingDocContent_URLLinkTwo,EditExistingDocContent_newVersionTwo,varAPINameRetrived,URLs_publisherURL,URLs_storeURL,EditExistingDocContent_domain);
    	lib_TestCase.APIM_414(this, EditExistingDocContent_URLLinkOne,varDocumentOne,EditExistingDocContent_updateSummaryThree,EditExistingDocContent_URLLinkTwo,varAPINameRetrived,EditExistingDocContent_newVersionTwo,URLs_publisherURL,URLs_storeURL,EditExistingDocContent_domain);
    	lib_TestCase.APIM_413(this, EditExistingDocContent_documentOtherNameOne,varDocumentOne,EditExistingDocContent_updateSummaryThree,EditExistingDocContent_editContentOne,varAPINameRetrived,EditExistingDocContent_newVersionTwo,URLs_storeURL,URLs_publisherURL,EditExistingDocContent_domain);
    	lib_TestCase.APIM_412(this, varDocumentOne,EditExistingDocContent_editContentTwo,varAPINameRetrived,EditExistingDocContent_newVersionTwo,URLs_publisherURL,URLs_storeURL,EditExistingDocContent_updateSummaryThree,EditExistingDocContent_domain);
    	lib_TestCase.APIM_411(this, varDocumentOne,EditExistingDocContent_editContentThree,varAPINameRetrived,EditExistingDocContent_newVersionTwo,URLs_publisherURL,URLs_storeURL,EditExistingDocContent_updateSummaryThree,EditExistingDocContent_domain);
    	lib_Common.bc_DeleteAPI(this, varAPINameRetrived,URLs_publisherURL);
    	writeToReport("End of TS Edit Existing Doc Content");
    } 
    	

    /**
     * Data provider for Test case tc_DocumentVisibility.
     * @return data table
     */
    @DataProvider(name = "tc_DocumentVisibility")
    public Object[][] dataTable_tc_DocumentVisibility() {     	
    	return this.getDataTable("DocumentVisibility","URLs");
    }

    /**
     * Data driven test case tc_DocumentVisibility.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_DocumentVisibility")
    public final void tc_DocumentVisibility(final String DocumentVisibility_domain, final String DocumentVisibility_APIName, final String DocumentVisibility_APIVersion, final String DocumentVisibility_APITagName, final String DocumentVisibility_APIContext, final String DocumentVisibility_DocName, final String DocumentVisibility_DocVisibilitySameAsAPI, final String DocumentVisibility_DocVisibilityPrivate, final String DocumentVisibility_DocVisibilityVisibleToMyDomain, final String DocumentVisibility_APIVisibilityPublic, final String DocumentVisibility_APIVisibilityVisibleToMyDomain, final String DocumentVisibility_APIVisibilityRestrictedToRole, final String DocumentVisibility_UploadFilePath, final String DocumentVisibility_DownloadFilePath, final String DocumentVisibility_SourceURL, final String DocumentVisibility_PopupImage, final String DocumentVisibility_OtherTypeText, final String DocumentVisibility_sandboxEndPoint, final String DocumentVisibility_productionEndPoint, final String DocumentVisibility_tenantOne, final String DocumentVisibility_tenantOneOrAdminPublisherOne, final String DocumentVisibility_tenantOneOrAdminPublisherTwo, final String DocumentVisibility_tenantOneOrAdminStoreOne, final String DocumentVisibility_tenantOneOrAdminStoreTwo, final String DocumentVisibility_tenantTwo, final String DocumentVisibility_imageName, final String DocumentVisibility_APIDiscription, final String DocumentVisibility_URLPattern, final String DocumentVisibility_tagName, final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL) throws Exception {	
    	writeToReport("Start of ts_DocumentVisibility");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,DocumentVisibility_tenantOneOrAdminPublisherOne);
    	lib_TestCase.APIM_106(this, DocumentVisibility_APIVisibilityPublic,DocumentVisibility_DocName,DocumentVisibility_domain,DocumentVisibility_DocVisibilitySameAsAPI,URLs_storeURL,URLs_publisherURL,DocumentVisibility_DownloadFilePath,DocumentVisibility_PopupImage,DocumentVisibility_UploadFilePath,DocumentVisibility_SourceURL,DocumentVisibility_SourceURL,DocumentVisibility_OtherTypeText,DocumentVisibility_APIName,DocumentVisibility_APIContext,DocumentVisibility_APIVersion,DocumentVisibility_imageName,DocumentVisibility_APIDiscription,DocumentVisibility_productionEndPoint,DocumentVisibility_sandboxEndPoint,DocumentVisibility_URLPattern,DocumentVisibility_tagName);
    	lib_TestCase.APIM_107(this, URLs_publisherURL,DocumentVisibility_domain);
    	lib_TestCase.APIM_108(this, DocumentVisibility_APIVisibilityVisibleToMyDomain,DocumentVisibility_DocVisibilitySameAsAPI,URLs_publisherURL,URLs_storeURL,DocumentVisibility_tenantOne,DocumentVisibility_DocName,DocumentVisibility_UploadFilePath,DocumentVisibility_PopupImage,DocumentVisibility_DownloadFilePath,DocumentVisibility_SourceURL,DocumentVisibility_OtherTypeText);
    	lib_TestCase.APIM_109(this, URLs_publisherURL,DocumentVisibility_APIVisibilityRestrictedToRole,DocumentVisibility_DocVisibilitySameAsAPI,URLs_storeURL,DocumentVisibility_tenantOne,DocumentVisibility_DocName,DocumentVisibility_UploadFilePath,DocumentVisibility_PopupImage,DocumentVisibility_DownloadFilePath,DocumentVisibility_SourceURL,DocumentVisibility_OtherTypeText);
    	lib_TestCase.APIM_110(this, URLs_publisherURL,URLs_storeURL,DocumentVisibility_DocVisibilityPrivate,DocumentVisibility_DocName,DocumentVisibility_UploadFilePath,DocumentVisibility_PopupImage,DocumentVisibility_DownloadFilePath,DocumentVisibility_SourceURL,DocumentVisibility_OtherTypeText,DocumentVisibility_tenantOne);
    	lib_TestCase.APIM_111(this, URLs_storeURL,URLs_publisherURL,DocumentVisibility_DocVisibilityVisibleToMyDomain,DocumentVisibility_UploadFilePath,DocumentVisibility_DocName,DocumentVisibility_PopupImage,DocumentVisibility_DownloadFilePath,DocumentVisibility_SourceURL,DocumentVisibility_OtherTypeText,DocumentVisibility_tenantOne);
    	String APIName = retrieveString("var_APIName");
    	lib_Common.bc_DeleteAPI(this, APIName,URLs_publisherURL);
    	writeToReport("End of Executing ts_Document Visibility");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}