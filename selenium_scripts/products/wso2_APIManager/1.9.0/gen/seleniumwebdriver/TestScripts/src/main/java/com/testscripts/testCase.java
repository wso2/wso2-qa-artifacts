package com.testscripts;

import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;
import org.openqa.selenium.By;

/**
 *  Class testCase contains reusable business components 
 *  Each method in this class correspond to a reusable business component.
 */
public class testCase {

    /**
     *  Business component APIM_22.
     */
    public final static void APIM_22(final SeleniumTestBase caller, final String param_verbNamePost, final String param_urlPatterSC, final String param_verbNameDelete, final String param_verbNameGet, final String param_urlPattern, final String param_verbName, final String param_APIName, final String param_serverName, final String param_publisherURL, final String param_storeURL) throws Exception {
        //APIM-22: Editing an API---------------------
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        Common.bc_EditAPI(caller, param_APIName);
        caller.pause("4000");
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatterSC);
        caller.pause("4000");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNamePost);
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Add");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbNamePost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatterSC,false,"");
        caller.click("APIPublisherBrowse.img_deleteIcon","param_verbmethodPost_PARAM:" + param_verbNamePost + "_PARAM," + "param_UrlPattern_PARAM:" + param_urlPatterSC);
        caller.click("APIPublisherBrowse.btn_Yes");
        caller.pause("5000");
        caller.checkObjectProperty("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbNamePost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatterSC,"ELEMENTPRESENT","false",false,"");
        caller.pause("4000");
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatterSC);
        caller.pause("4000");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNameGet);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNamePost);
        caller.click("APIPublisherBrowse.btn_Add");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbNameGet + "_PARAM," + "urlPattern_PARAM:" + param_urlPatterSC,false,"");
        caller.pause("4000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbNamePost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatterSC,false,"");
        caller.pause("6000");
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPattern);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNamePost);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNameDelete);
        caller.click("APIPublisherBrowse.btn_Add");
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblpopupError",false,"");
        caller.click("APIPublisherBrowse.btn_Ok");
        caller.pause("6000");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNamePost);
        caller.click("APIPublisherBrowse.btn_Add");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbNameDelete + "_PARAM," + "urlPattern_PARAM:" + param_urlPatterSC,false,"");
        caller.click("APIPublisherBrowse.btn_Save");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        Common.bc_NavigateToPrototypedAPI(caller);
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.ele_tabAPIConsole");
        caller.pause("6000");
        caller.checkElementPresent("APIStoreAPIs.lnk_default","param_verb_PARAM:" + param_verbNamePost + "_PARAM," + "param_UrlPattern_PARAM:" + param_urlPattern,false,"");	
    }
    /**
     *  Business component APIM_21.
     */
    public final static void APIM_21(final SeleniumTestBase caller, final String param_APIName) throws Exception {
        //APIM-21: Try to change the lifecycle of an API in design stge---------------------
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        caller.checkObjectProperty("APIPublisherBrowse.ele_ddState","MISSINGOPTION","PROTOTYPED",false,"");
        caller.checkObjectProperty("APIPublisherBrowse.ele_ddState","MISSINGOPTION","PUBLISHED",false,"");	
    }
    /**
     *  Business component APIM_276.
     */
    public final static void APIM_276(final SeleniumTestBase caller, final String param_APIName, final String param_VisibilityPublic, final String param_serverName, final String param_username, final String param_password, final String param_publisherURL, final String param_storeURL) throws Exception {
        //APIM-276: Change the visibilty levels of the API to public and save it------------
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        Common.bc_EditAPI(caller, param_APIName);
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_VisibilityPublic);
        caller.click("APIPublisherBrowse.btn_Save");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        Common.bc_APIStoreLogin(caller, param_username,param_password);
        caller.click("APIStoreHome.lnk_PrototypedAPIs");
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_20.
     */
    public final static void APIM_20(final SeleniumTestBase caller, final String Login_userName, final String Login_password, final String param_APIVersion, final String param_nonImagrPath, final String param_APIImagePath, final String param_URLPattern, final String param_APIName, final String param_publisherURL) throws Exception {
        //--TC-APIM-20:Create API in design stage - Field validations
        //Precondition
        //Loging to API publisher Site
        Common.bc_Login_APIPublisher(caller, Login_userName,Login_password,param_publisherURL);
        //APIM-20:Create API in design stage - Field validations
        Common.bc_CreateAPI_Design(caller, param_APIVersion,param_nonImagrPath,param_APIImagePath,param_URLPattern,param_APIName);
        //Wait for content to load
        caller.pause("4000");	
    }
    /**
     *  Business component APIM_278.
     */
    public final static void APIM_278(final SeleniumTestBase caller, final String param_APIName, final String param_VisibilityRestrictedToRole, final String param_username, final String param_password, final String param_PublisherUserName, final String param_PublisherPassword, final String param_newUserName, final String param_newPassword, final String param_retypePassword, final String param_role, final String param_publisherURL) throws Exception {
        //APIM-278: Change the visibilty levels of the API to 'reststircted by role' and save it------------
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        /*
        Call
         businessComponent=Common.bc_APIcarbonLogin
         param_username=@param_username
         param_password=@param_password
        Call
         businessComponent=Common.bc_CreateCarbonUser
         param_newUserName=@param_newUserName
         param_newPassword=@param_newPassword
         param_retypePassword=@param_retypePassword
         param_role=@param_role
        Pause
         ms=3000
        NavigateToURL
         url=APIPublisherLogin
         ms=5000
        */
        Common.bc_EditAPI(caller, param_APIName);
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_VisibilityRestrictedToRole);
        caller.click("APIPublisherBrowse.btn_Ok");
        caller.click("APIPublisherBrowse.btn_Save");
        Common.bc_LogOut_APIPublisher(caller, param_username);
        Common.bc_Login_APIPublisher(caller, param_PublisherUserName,param_PublisherPassword,param_publisherURL);
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("4000");	
    }
    /**
     *  Business component APIM_280.
     */
    public final static void APIM_280(final SeleniumTestBase caller, final String param_APIName, final String param_VisibilityRestrictByRole, final String param_publisherURL) throws Exception {
        //Test case name-------APIM-280: Try to save without adding any resource------------
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        Common.bc_EditAPI(caller, param_APIName);
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_VisibilityRestrictByRole);
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_Ok");
        caller.checkElementPresent("APIPublisherBrowse.tf_VisibilityToRole",false,"");
        caller.click("APIPublisherBrowse.btn_Save");	
    }
    /**
     *  Business component APIM_23.
     */
    public final static void APIM_23(final SeleniumTestBase caller, final String param_UserName, final String param_Password, final String param_APIVersion, final String param_APIImagePath, final String param_URLPattern, final String param_APIName, final String param_serverName, final String param_tagName, final String param_publisherURL, final String param_storeURL) throws Exception {
        //Test case name------APIM-23: Create API from scratch and give necessary details and deploy as prototype------------
        Common.bc_Login_APIPublisher(caller, param_UserName,param_Password,param_publisherURL);
        Common.bc_CreateAPI_DesignStage(caller, param_APIImagePath,param_APIVersion,param_tagName,param_APIName);
        Common.bc_DeployAsPrototype(caller, param_APIName);
        caller.pause("4000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        Common.bc_NavigateToPrototypedAPI(caller);
        caller.pause("5000");
        caller.checkElementPresent("APIStorePrototypedAPIs.ele_lblAPIName","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_Virsion_PARAM:" + param_APIVersion,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_24.
     */
    public final static void APIM_24(final SeleniumTestBase caller, final String param_APIName, final String param_EndpointType, final String param_EndpointUrl, final String param_serverName, final String param_publisherURL, final String param_storeURL) throws Exception {
        //Test case name------APIM-24: Open an saved API in design stage and give the necessary details and deploy it as prototype------------
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.pause("3000");
        Common.bc_EditAPI(caller, param_APIName);
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        /*
        Select
         object=APIPublisherBrowse.ele_ddEndpointType
         selectLocator=@param_EndpointType
        */
        caller.type("APIPublisherBrowse.tf_productionEndpoint",param_EndpointUrl);
        Common.bc_PrototypeAPI(caller);
        caller.pause("3000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        Common.bc_NavigateToPrototypedAPI(caller);
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_27.
     */
    public final static void APIM_27(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_serverName, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_APIName, final String param_publisherURL, final String param_storeURL) throws Exception {
        //APIM-27: Tags of Prototype APIs should not be visible in the tags list
        caller.pause("3000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        Common.bc_CreateAPI_DesignStage(caller, param_APIImagePath,param_APIVersion,param_tagName,param_APIName);
        caller.click("APIPublisherBrowse.ele_lblPrototype");
        caller.click("APIPublisherBrowse.btn_DeployAsPrototype");
        caller.click("APIPublisherBrowse.btn_OkDeployAsPrototype");
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"5000");
        caller.pause("3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.checkObjectProperty("APIStoreAPIs.lnk_tagProtoType","param_tagName_PARAM:" + param_tagName,"ELEMENTPRESENT","false",false,"");
        caller.pause("4000");	
    }
    /**
     *  Business component APIM_25.
     */
    public final static void APIM_25(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_serverName, final String param_APIName, final String param_storeURL) throws Exception {
        //APIM-25: Prototype APIs should not be visible in general store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.pause("3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        Common.bc_APIStoreLogin(caller, param_username,param_password);
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","false",false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_26.
     */
    public final static void APIM_26(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_serverName, final String param_APIName, final String param_storeURL) throws Exception {
        //APIM-26: Prototype APIs should not be visible in the recently added list
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.pause("3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        if(!caller.checkElementPresent("APIStoreHome.lnk_login")){
        Common.bc_LogOut_APIStore(caller, param_username);
        }
        Common.bc_APIStoreLogin(caller, param_username,param_password);
        caller.checkObjectProperty("APIStoreAPIs.lnk_RecentlyViewedAPUI","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","false",false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_29.
     */
    public final static void APIM_29(final SeleniumTestBase caller, final String param_UserName, final String param_Password, final String param_APIName, final String param_ValidUrl, final String param_InvalidUrl, final String param_publisherURL) throws Exception {
        //APIM-29: Check the functionality of endpont "Test" button
        Common.bc_Login_APIPublisher(caller, param_UserName,param_Password,param_publisherURL);
        Common.bc_EditAPI(caller, param_APIName);
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblPrototype");
        caller.type("APIPublisherBrowse.tf_prototypeEndpoint",param_ValidUrl);
        caller.click("APIPublisherBrowse.btn_test");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblValid",false,"");
        caller.type("APIPublisherBrowse.tf_prototypeEndpoint",param_InvalidUrl);
        caller.click("APIPublisherBrowse.btn_test");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblInvalid",false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_33.
     */
    public final static void APIM_33(final SeleniumTestBase caller, final String param_validEndpointUrl, final String param_serverName, final String param_APIName, final String param_storeURL) throws Exception {
        //APIM-33: Give a valid Production endpoint URL and publish the API and invoke it
        caller.type("APIPublisherBrowse.tf_productionEndpoint",param_validEndpointUrl);
        caller.click("APIPublisherBrowse.btn_Save");
        caller.pause("3000");
        caller.doubleClick("APIPublisherBrowse.btn_NextManage");
        caller.pause("3000");
        /*
        Call
         businessComponent=Common.bc_SelectTiers
        */
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Close");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.pause("3000");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_34.
     */
    public final static void APIM_34(final SeleniumTestBase caller, final String param_UserName, final String param_Password, final String param_APIVersion, final String param_APIImagePath, final String param_URLPattern, final String param_APIName, final String param_tagName, final String param_publisherURL) throws Exception {
        //APIM-34: Give a valid sandbox endpoint URL and publish the API and invoke the API with sandbox token
        Common.bc_Login_APIPublisher(caller, param_UserName,param_Password,param_publisherURL);
        Common.bc_CreateAPI_DesignStage(caller, param_APIImagePath,param_APIVersion,param_tagName,param_APIName);
        Common.bc_DeployAsPrototype(caller, param_APIName);
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("3000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        Common.bc_EditAPI(caller, param_APIName);
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.pause("3000");
        Common.bc_SelectTiers(caller);
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        caller.pause("3000");
        caller.doubleClick("APIPublisherBrowse.btn_Close");
        caller.pause("4000");	
    }
    /**
     *  Business component APIM_32.
     */
    public final static void APIM_32(final SeleniumTestBase caller, final String param_SecuritySchemeSecured, final String param_endpointUsername, final String param_endpointPassword) throws Exception {
        //APIM-32: Apply Endpoint Security configuration to the API
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.click("APIPublisherBrowse.lnk_ShowmoreOption");
        caller.select("APIPublisherBrowse.ele_ddEndpointSecurityScheme",param_SecuritySchemeSecured);
        caller.type("APIPublisherBrowse.tf_endpointUserName","");
        caller.type("APIPublisherBrowse.tf_endPointPassword","");
        caller.click("APIPublisherBrowse.btn_Save");
        caller.checkElementPresent("APIPublisherBrowse.ele_lbl_credentialErrorMessege",false,"");
        caller.pause("3000");
        caller.type("APIPublisherBrowse.tf_endpointUserName",param_endpointUsername);
        caller.type("APIPublisherBrowse.tf_endPointPassword",param_endpointPassword);
        caller.click("APIPublisherBrowse.btn_Save");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_39.
     */
    public final static void APIM_39(final SeleniumTestBase caller, final String param_APIName, final String param_ValidSandboxEndpoint, final String param_ValidProductionEndPoint) throws Exception {
        //APIM-39: Set valid SOAP service endpoints for Production and Sandbox and check the "Test" button
        caller.click("APIPublisherHome.lnk_Browse");
        Common.bc_EditAPI(caller, param_APIName);
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ValidProductionEndPoint);
        caller.click("APIPublisherBrowse.btn_testProductionEndpoint");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblValid",false,"");
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_ValidSandboxEndpoint);
        caller.click("APIPublisherBrowse.btn_testSandBoxEndPoint");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblSandboxEndpointValid",false,"");
        caller.pause("4000");	
    }
    /**
     *  Business component APIM_52.
     */
    /**
     *  Business component APIM_52.
     */
    public final static void APIM_52(final SeleniumTestBase caller) throws Exception {
    	
    }
    /**
     *  Business component APIM_281.
     */
    /**
     *  Business component APIM_281.
     */
    public final static void APIM_281(final SeleniumTestBase caller) throws Exception {
    	
    }
    /**
     *  Business component APIM_70.
     */
    /**
     *  Business component APIM_70.
     */
    public final static void APIM_70(final SeleniumTestBase caller) throws Exception {
    	
    }
    /**
     *  Business component APIM_53.
     */
    public final static void APIM_53(final SeleniumTestBase caller, final String param_APIName) throws Exception {
        //APIM-53:Add throttling tires and other details to a prototyped API and save
        Common.bc_DeployAsPrototype(caller, param_APIName);
        Common.bc_EditAPI(caller, param_APIName);
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.click("APIPublisherBrowse.btn_NextManage");
        Common.bc_SelectTiers(caller);
        caller.click("APIPublisherBrowse.btn_Save1");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_55.
     */
    public final static void APIM_55(final SeleniumTestBase caller, final String param_APIName, final String param_ProductionEndpointUrl) throws Exception {
        //APIM-55: Save an API in manage stage.
        Common.bc_EditAPI(caller, param_APIName);
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndpointUrl);
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.pause("3000");
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        if(caller.checkElementPresent("APIPublisherBrowse.chk_ActiveUnlimited")){
        caller.click("APIPublisherBrowse.chk_Unlimited");
        }
        if(caller.checkElementPresent("APIPublisherBrowse.chk_ActiveGold")){
        caller.click("APIPublisherBrowse.chk_Gold");
        }
        if(caller.checkElementPresent("APIPublisherBrowse.chk_ActiveSilver")){
        caller.click("APIPublisherBrowse.chk_Silver");
        }
        if(caller.checkElementPresent("APIPublisherBrowse.chk_ActiveBronze")){
        caller.click("APIPublisherBrowse.chk_Bronze");
        }
        caller.click("APIPublisherBrowse.btn_Save1");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblThisFieldisRequired",false,"");
        caller.pause("4000");	
    }
    /**
     *  Business component APIM_217.
     */
    public final static void APIM_217(final SeleniumTestBase caller, final String param_APIName, final String param_ImagePath, final String param_txtPath, final String param_serverName, final String param_storeURL) throws Exception {
        //APIM-217: Check whether user can successfully edit icon.
        caller.click("APIPublisherHome.lnk_Browse");
        Common.bc_EditAPI(caller, param_APIName);
        caller.click("APIPublisherBrowse.lnk_ChangeIcon");
        caller.pause("2000");
        caller.type("APIPublisherBrowse.btn_BrowseImage",param_txtPath);
        caller.click("APIPublisherBrowse.btn_Save");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblInvalidImageError",false,"");
        caller.click("APIPublisherHome.lnk_Browse");
        Common.bc_EditAPI(caller, param_APIName);
        caller.click("APIPublisherBrowse.lnk_ChangeIcon");
        caller.pause("2000");
        caller.type("APIPublisherBrowse.btn_BrowseImage",param_ImagePath);
        caller.click("APIPublisherBrowse.btn_Save");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkImagePresent("APIStoreAPIs.img_Uploaded",false,false,"");
        caller.pause("4000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.pause("4000");
        caller.click("APIStoreHome.lnk_PrototypedAPIs");
        caller.pause("3000");
        caller.checkImagePresent("APIStoreAPIs.img_verificationStore",false,false,"");	
    }
    /**
     *  Business component APIM_2A.
     */
    public final static void APIM_2A(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_User, final String param_newPassword, final String param_retypePassword, final String param_APIName, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_serverName, final String param_storeURL, final String param_publisherURL, final String param_carbonURL, final String param_newUserName, final String param_role) throws Exception {
        //APIM-(2):publish  API with subscribers  and  check whether user can delete
        /*
        Call
         businessComponent=Common.bc_APIcarbonLogin
         param_username=@param_username
         param_password=@param_password
         param_carbonURL=@param_carbonURL
        Click
         object=APICarbonHome.btn_Configure
        Click
         object=APICarbonHome.lnk_UserandRoles
        Click
         object=APICarbonHome.lnk_User
        Click
         object=APICarbonHome.lnk_AddNewUser
        Type
         object=CarbonAddUser.tf_UserName
         text=@param_newUserName
        Type
         object=CarbonAddUser.tf_password
         text=@param_newPassword
        Type
         object=CarbonAddUser.tf_retypePassword
         text=@param_retypePassword
        Click
         object=CarbonAddUser.btn_next
        Pause
         ms=2000
        If
         expression=caller.checkElementPresent("CarbonAddUser.chk_Role","userRole_PARAM:" + param_role)
         Click
          object=CarbonAddUser.chk_Role
          userRole=@param_role
        EndIf
        Click
         object=CarbonAddUser.btn_finish
        Pause
         ms=2000
        Click
         object=CarbonAddUser.btn_Ok
        */
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        Common.bc_APIStoreLogin(caller, param_username,param_password);
        caller.pause("1000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.btn_Subscribe");
        caller.click("APIPublisherBrowse.btn_Close");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.btn_deleteAPI","APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.btn_Yes");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIdeleteError",false,"");
        caller.click("APIPublisherBrowse.btn_Ok");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_4A.
     */
    public final static void APIM_4A(final SeleniumTestBase caller, final String param_APIName, final String param_NewVersion, final String param_publisherURL) throws Exception {
        //APIM-(4):Create New Version of already exsist API
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Overview.btn_CreateNewVersion");
        caller.type("Browse_Overview.tf_ToVersion",param_NewVersion);
        caller.click("Browse_Overview.btn_Done");
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.checkElementPresent("APIPublisherBrowse.lnk_DuplicateAPI","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_5A.
     */
    public final static void APIM_5A(final SeleniumTestBase caller, final String param_APIName, final String param_alreadyExistingVersion) throws Exception {
        //APIM-(5):Create Same Version of already exsist API
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Overview.btn_CreateNewVersion");
        caller.type("Browse_Overview.tf_ToVersion",param_alreadyExistingVersion);
        caller.click("Browse_Overview.btn_Done");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblPopupPublisherError",false,"");
        caller.click("APIPublisherBrowse.btn_Ok");	
    }
    /**
     *  Business component APIM_363.
     */
    /**
     *  Business component APIM_363.
     */
    public final static void APIM_363(final SeleniumTestBase caller) throws Exception {
    	
    }
    /**
     *  Business component APIM_3A.
     */
    public final static void APIM_3A(final SeleniumTestBase caller, final String param_UserName, final String param_newPassword, final String param_APIName, final String param_serverName, final String param_Version, final String param_storeURL) throws Exception {
        //APIM-(3):publish API without  subscribers  and  check whether user can delete
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.pause("3000");
        if(!caller.checkElementPresent("APIStoreHome.lnk_login")){
        Common.bc_LogOut_APIStore(caller, param_UserName);
        }
        Common.bc_APIStoreLogin(caller, param_UserName,param_newPassword);
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreHome.lnk_MySubcription");
        Common.bc_DeleteSubcription(caller, param_APIName,param_Version);	
    }
    /**
     *  Business component APIM_127.
     */
    public final static void APIM_127(final SeleniumTestBase caller, final String param_UserName, final String param_Password, final String param_publisherURL, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_APIName, final String param_State, final String param_NewVersion, final String param_creater, final String param_users, final String param_status, final String param_ProductionEndPont, final String param_SandBoxEndpoint) throws Exception {
        //APIM-127: Check whether system allows to get a copy of an api which is in blocked state
        Common.bc_Login_APIPublisher(caller, param_UserName,param_Password,param_publisherURL);
        //Create API In Prtotype
        Common.bc_CreateAPI_DesignStage(caller, param_APIImagePath,param_APIVersion,param_tagName,param_APIName);
        Common.bc_PrototypeAPI(caller);
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_Save1");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        //Wait for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //Wait for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Close");
        //Wait for content load
        caller.pause("4000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //Wait for content load
        caller.pause("2000");
        caller.checkObjectProperty("APIPublisherBrowse.ele_ddState","SELECTEDOPTION","PUBLISHED",false,"");
        //Wait for content load
        caller.pause("2000");
        caller.select("APIPublisherBrowse.ele_ddState",param_State);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Lifecycle.btn_Update");
        //Wait for content load
        caller.pause("1000");
        caller.checkElementPresent("Browse_Lifecycle.ele_lblUpdateSuccessMessage",false,"");
        caller.click("APIPublisherBrowse.lnk_Overview");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Overview.btn_CreateNewVersion");
        //Verify Field will Expan
        caller.checkElementPresent("Browse_Overview.tf_ToVersion",false,"");
        //Wait for content load
        caller.pause("2000");
        //Type new version
        caller.type("Browse_Overview.tf_ToVersion",param_NewVersion);
        caller.click("Browse_Overview.btn_Done");
        //Wait for content load
        caller.pause("2000");
        //Verify redirected to browse page
        caller.checkElementPresent("APIPublisherHome.lnk_Browse",false,"");
        //Verify API  name with new version and creator
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVersionAndUser","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_NewVersion + "_PARAM," + "param_creater_PARAM:" + param_creater,false,"");
        //Verify subscriber numbers
        caller.checkElementPresent("APIPublisherBrowse.ele_lblUsers","param_version_PARAM:" + param_NewVersion + "_PARAM," + "param_users_PARAM:" + param_users,false,"");
        //Verify status
        caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIStatus","param_status_PARAM:" + param_status,false,"");
        //Wait for content load
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_122.
     */
    public final static void APIM_122(final SeleniumTestBase caller, final String param_stage, final String param_newVersion, final String param_creater, final String param_APIName, final String param_status, final String param_users) throws Exception {
        //APIM-122: Check whether system allows to get a copy of an api which is in created state.
        Common.bc_Select_LifeCycleState(caller, param_stage,param_APIName);
        Common.bc_CreateNewVersion_VerifyDetails(caller, param_newVersion,param_creater,param_APIName,param_status,param_users);	
    }
    /**
     *  Business component APIM_123.
     */
    public final static void APIM_123(final SeleniumTestBase caller, final String param_stage, final String param_newVersion, final String param_creater, final String param_APIName, final String param_status, final String param_users) throws Exception {
        //APIM-123: Check whether system allows to get a copy of an api which is in published state.
        Common.bc_Select_LifeCycleState(caller, param_stage,param_APIName);
        Common.bc_CreateNewVersion_VerifyDetails(caller, param_newVersion,param_creater,param_APIName,param_status,param_users);	
    }
    /**
     *  Business component APIM_124.
     */
    public final static void APIM_124(final SeleniumTestBase caller, final String param_stage, final String param_newVersion, final String param_creater, final String param_APIName, final String param_status, final String param_users) throws Exception {
        //APIM-124: Check whether system allows to get a copy of an api which is in prototyped state.
        Common.bc_Select_LifeCycleState(caller, param_stage,param_APIName);
        Common.bc_CreateNewVersion_VerifyDetails(caller, param_newVersion,param_creater,param_APIName,param_status,param_users);	
    }
    /**
     *  Business component APIM_125.
     */
    public final static void APIM_125(final SeleniumTestBase caller, final String param_stage, final String param_newVersion, final String param_creater, final String param_APIName, final String param_status, final String param_users) throws Exception {
        //APIM-125: Check whether system allows to get a copy of an api which is in deprecated state.
        Common.bc_Select_LifeCycleState(caller, param_stage,param_APIName);
        Common.bc_CreateNewVersion_VerifyDetails(caller, param_newVersion,param_creater,param_APIName,param_status,param_users);	
    }
    /**
     *  Business component APIM_126.
     */
    public final static void APIM_126(final SeleniumTestBase caller, final String param_stage, final String param_newVersion, final String param_creater, final String param_APIName, final String param_status, final String param_users) throws Exception {
        //APIM-126: Check whether system allows to get a copy of an api which is in retired stat
        Common.bc_Select_LifeCycleState(caller, param_stage,param_APIName);
        Common.bc_CreateNewVersion_VerifyDetails(caller, param_newVersion,param_creater,param_APIName,param_status,param_users);	
    }
    /**
     *  Business component APIM_419.
     */
    public final static void APIM_419(final SeleniumTestBase caller, final String param_APIName, final String param_docName, final String param_uploadDocLocation, final String param_summary, final String param_updateSummary, final String param_URLLink, final String param_newVersion, final String param_serverName, final String param_otherName, final String param_docName2, final String param_storeURL, final String param_state, final String param_publisherURL, final String param_DownloadFilePath, final String param_username, final String param_password) throws Exception {
        //APIM-419: Check whether user can edit and change content type of an existing hot to type document.
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //Wait for content load
        caller.pause("2000");
        caller.select("APIPublisherBrowse.ele_ddState",param_state);
        //Wait for content load
        caller.pause("4000");
        caller.click("Browse_Lifecycle.btn_Update");
        //Wait for content load
        caller.pause("4000");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.type("Browse_Doc.tf_Summary",param_summary);
        caller.click("Browse_Doc.rdo_HowTo");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_BrowseFile",param_uploadDocLocation);
        caller.pause("5000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("5000");
        caller.checkElementPresent("Browse_Doc.ele_lblCreatedDocName","param_DocName_PARAM:" + param_docName,false,"");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        //Wait for content load
        caller.pause("2000");
        //Verify summary field is editable
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        //Verify source field is editable
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        //Verify source field is editable
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        //Edit summaty
        caller.type("Browse_Doc.tf_Summary",param_updateSummary);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_URL");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_URLLink);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Verify whether the edited doc is still listed under the 'Docs' tab of the API
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_docName,false,"");
        //Wait for content load
        caller.pause("3000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        Common.bc_APIStoreLogin(caller, param_username,param_password);
        //Wait for content load
        caller.pause("5000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        //Wait for content load
        caller.pause("4000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkElementPresent("APIStoreDocumentation.lnk_HowTo",false,"");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_docName,false,"");
        //Wait for content load
        caller.pause("4000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_updateSummary,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_docName + "_PARAM," + "param_URLLink_PARAM:" + param_URLLink,false,"");
        //Wait for content load
        caller.pause("5000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        //Wait for content load
        caller.pause("5000");
        caller.click("Browse_Doc.rdo_Inline");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_docName,false,"");
        //Wait for content load
        caller.pause("2000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_docName,false,"");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_updateSummary,false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_File");
        caller.type("Browse_Doc.tf_BrowseFile",param_uploadDocLocation);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("6000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + param_docName,false,"");
        //Wait for content load
        caller.pause("2000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("4000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Samples",false,"");
        caller.click("APIStoreDocumentation.lnk_Samples");
        //Wait for content load
        caller.pause("2000");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_docName,false,"");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_updateSummary,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_docName);
        //Wait for content load
        caller.pause("4000");
        /*
        FireEvent
         event=KEY%key=\n
         waitTime=6000
        */
        //Wait for content load
        caller.pause("5000");
        caller.checkFileInfo(param_DownloadFilePath,"EXIST",false,"");
        //Wait for content load
        caller.pause("5000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_PublicForum");
        //Wait for content load
        caller.pause("2000");
        /*
        Click
         object=Browse_Doc.rdo_URL
        */
        caller.type("Browse_Doc.tf_URL",param_URLLink);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + param_docName,false,"");
        //Wait for content load
        caller.pause("2000");
        //Wait for content load
        caller.pause("2000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        //Wait for content load
        caller.pause("5000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_updateSummary,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_docName + "_PARAM," + "param_URLLink_PARAM:" + param_URLLink,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Other");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_Other",param_otherName);
        caller.click("Browse_Doc.rdo_Inline");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + param_docName,false,"");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_updateSummary,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_docName,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_DocName",param_docName2);
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_Summary",param_summary);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_HowTo");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_BrowseFile",param_uploadDocLocation);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblCreatedDocName","param_DocName_PARAM:" + param_docName2,false,"");
        //Wait for content load
        caller.pause("2000");
        //Wait for content load
        caller.pause("2000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_HowTo",false,"");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_docName2,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_docName2);
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherAdd.btn_Yes");
        //Waiting for content to load
        caller.pause("5000");
        if(!caller.checkElementPresent("Browse_Doc.ele_lblCreatedDocName","param_DocName_PARAM:" + param_docName2)){
        caller.writeToReport("Doc is deleted");
        } else {
        caller.writeToReport("Doc is  not deleted");
        }
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Verify doc is deleted
        if(!caller.checkElementPresent("APIStoreDocumentation.lnk_HowTo")){
        caller.writeToReport("Doc is deleted");
        } else {
        caller.writeToReport("Doc is  not deleted");
        }	
    }
    /**
     *  Business component APIM_418.
     */
    public final static void APIM_418(final SeleniumTestBase caller, final String param_DocName, final String param_summaryNew, final String param_NewURL, final String param_APIName, final String param_Other_Name, final String param_newVersion, final String param_serverName, final String param_storeURL, final String param_publisherURL, final String param_Other_Name2) throws Exception {
        //APIM-418: Check whether user can edit existing 'other' type docs which has URL content type.
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_URL");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_NewURL);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("5000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.type("Browse_Doc.tf_Summary",param_summaryNew);
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_NewURL);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + param_DocName,false,"");
        caller.pause("5000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_DocName + "_PARAM," + "param_URLLink_PARAM:" + param_NewURL,false,"");	
    }
    /**
     *  Business component APIM_417.
     */
    public final static void APIM_417(final SeleniumTestBase caller, final String param_publisherURL, final String param_DocName, final String param_URL, final String param_summaryNew, final String param_NewURL, final String param_serverName, final String param_APIName, final String param_newVersion, final String param_storeURL) throws Exception {
        //APIM-417: Check whether user can edit existing 'Support forum' type docs which has URL content type.
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_SupportForum");
        //Wait for content load
        caller.pause("4000");
        caller.type("Browse_Doc.tf_URL",param_URL);
        //Wait for content load
        caller.pause("4000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.type("Browse_Doc.tf_Summary",param_summaryNew);
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_NewURL);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_SupportForum","param_docName_PARAM:" + param_DocName,false,"");
        caller.pause("3000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_DocName + "_PARAM," + "param_URLLink_PARAM:" + param_NewURL,false,"");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");	
    }
    /**
     *  Business component APIM_416.
     */
    public final static void APIM_416(final SeleniumTestBase caller, final String param_DocName, final String param_URL, final String param_serverName, final String param_APIName, final String param_newVersion, final String param_summaryNew, final String param_NewURL, final String param_publisherURL, final String param_storeURL) throws Exception {
        //APIM-416: Check whether user can edit existing 'Public forum' type docs which has URL content type.
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        caller.click("Browse_Doc.rdo_PublicForum");
        //Wait for content load
        caller.pause("4000");
        caller.type("Browse_Doc.tf_URL",param_URL);
        //Wait for content load
        caller.pause("4000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.type("Browse_Doc.tf_Summary",param_summaryNew);
        caller.type("Browse_Doc.tf_URL",param_NewURL);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + param_DocName,false,"");
        caller.pause("3000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_DocName + "_PARAM," + "param_URLLink_PARAM:" + param_NewURL,false,"");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");	
    }
    /**
     *  Business component APIM_415.
     */
    public final static void APIM_415(final SeleniumTestBase caller, final String param_DocName, final String param_URL, final String param_summaryNew, final String param_NewURL, final String param_newVersion, final String param_APIName, final String param_serverName, final String param_publisherURL, final String param_storeURL) throws Exception {
        //APIM-415: Check whether user can edit existing 'Samples & SDK' type docs which has URL content type.
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_URL");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_URL);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.type("Browse_Doc.tf_Summary",param_summaryNew);
        /*
        Click
         object=Browse_Doc.rdo_URL
        */
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_NewURL);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + param_DocName,false,"");
        //Wait for content load
        caller.pause("2000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Samples");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_DocName + "_PARAM," + "param_URLLink_PARAM:" + param_NewURL,false,"");	
    }
    /**
     *  Business component APIM_413.
     */
    public final static void APIM_413(final SeleniumTestBase caller, final String param_other_Name, final String param_DocName, final String param_summaryNew, final String param_editContent, final String param_serverName, final String param_APIName, final String param_newVersion, final String param_storeURL, final String param_publisherURL) throws Exception {
        //APIM-413: Check whether user can edit existing 'other' type docs which has in-line content type.
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        caller.click("Browse_Doc.rdo_Other");
        //Wait for content load
        caller.pause("5000");
        caller.type("Browse_Doc.tf_Other",param_other_Name);
        //Wait for content load
        caller.pause("3000");
        /*
        Click
         object=Browse_Doc.rdo_Inline
        */
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + param_DocName,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_DocName);
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.pause("4000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_newVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","5000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("5000");
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + param_DocName,false,"");
        //Wait for content load
        caller.pause("2000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Wait for content load
        caller.pause("1000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_DocName,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_DocName,false,"");
        //Verify summary
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");	
    }
    /**
     *  Business component APIM_412.
     */
    public final static void APIM_412(final SeleniumTestBase caller, final String param_DocName, final String param_editContent, final String param_serverName, final String param_APIName, final String param_newVersion, final String param_publisherURL, final String param_storeURL, final String param_summaryNew) throws Exception {
        //APIM-412: Check whether user can edit existing 'samples & SDK' type docs which has in-line content type.
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        //Wait for content load
        caller.pause("2000");
        /*
        Click
         object=Browse_Doc.rdo_Inline
        */
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + param_DocName,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_DocName);
        caller.selectWindow("Browse_Doc.newWindow1");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_newVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","5000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + param_DocName,false,"");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Samples",false,"");
        caller.click("APIStoreDocumentation.lnk_Samples");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_DocName,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_DocName,false,"");
        //Verify summary
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");	
    }
    /**
     *  Business component APIM_411.
     */
    public final static void APIM_411(final SeleniumTestBase caller, final String param_DocName, final String param_editContent, final String param_APIName, final String param_serverName, final String param_newVersion, final String param_publisherURL, final String param_storeURL, final String param_summaryNew) throws Exception {
        //APIM-411: Check whether user can edit existing how to type docs which has in-line content type.
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        caller.click("Browse_Doc.rdo_HowTo");
        //Wait for content load
        caller.pause("2000");
        /*
        Click
         object=Browse_Doc.rdo_Inline
        */
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_DocName,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_DocName);
        //Wait for content load
        caller.pause("2000");
        caller.selectWindow("Browse_Doc.newWindow1");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_newVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","5000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        //Verify doc is under doc tab and doc name and type
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_DocName,false,"");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkElementPresent("APIStoreDocumentation.lnk_HowTo",false,"");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Wait for content load
        caller.pause("1000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_DocName,false,"");
        //Verify summary
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_DocName,false,"");	
    }
    /**
     *  Business component APIM_414.
     */
    public final static void APIM_414(final SeleniumTestBase caller, final String param_URL, final String param_DocName, final String param_summaryNew, final String param_NewURL, final String param_serverName, final String param_APIName, final String param_newVersion, final String param_publisherURL, final String param_storeURL) throws Exception {
        //APIM-414: Check whether user can edit existing 'how to' type docs which has URL content type.
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_HowTo");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_URL");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_URL);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_DocName,false,"");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_Summary",param_summaryNew);
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_NewURL);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("6000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_DocName + "_PARAM," + "param_URLLink_PARAM:" + param_NewURL,false,"");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");	
    }
    /**
     *  Business component APIM_159.
     */
    /**
     *  Business component APIM_159.
     */
    public final static void APIM_159(final SeleniumTestBase caller) throws Exception {
    	
    }
    /**
     *  Business component APIM_128.
     */
    public final static void APIM_128(final SeleniumTestBase caller, final String param_APIName, final String param_APIVersion, final String param_publisherURL) throws Exception {
        //APIM-128: Check whether system validate for existing versions of the same api
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Overview.btn_CreateNewVersion");
        caller.checkElementPresent("Browse_Overview.tf_ToVersion",false,"");
        caller.type("Browse_Overview.tf_ToVersion",param_APIVersion);
        caller.click("Browse_Overview.btn_Done");
        caller.checkElementPresent("Browse_Overview.ele_lblDuplicateVersionErrorMessage","param_APIVersion_PARAM:" + param_APIVersion,false,"");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Overview.btn_Ok");
        //Wait for content load
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_138.
     */
    /**
     *  Business component APIM_138.
     */
    public final static void APIM_138(final SeleniumTestBase caller) throws Exception {
    	
    }
    /**
     *  Business component APIM_131.
     */
    public final static void APIM_131(final SeleniumTestBase caller, final String param_APIName) throws Exception {
        //APIM-131: Check whether cancel button on add new version section is working.
        caller.click("APIPublisherHome.lnk_Browse");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Overview.btn_CreateNewVersion");
        caller.checkElementPresent("Browse_Overview.tf_ToVersion",false,"");
        caller.click("Browse_Overview.btn_CancelNewVersion");
        caller.checkElementPresent("Browse_Overview.btn_CreateNewVersion",false,"");	
    }
    /**
     *  Business component APIM_137.
     */
    /**
     *  Business component APIM_137.
     */
    public final static void APIM_137(final SeleniumTestBase caller) throws Exception {
    	
    }
    /**
     *  Business component APIM_175.
     */
    public final static void APIM_175(final SeleniumTestBase caller, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_APIName, final String param_ProductionEndPontJaxRS, final String param_URLPattern, final String param_verbMethodGET, final String param_verbMethodPOST, final String param_verbMethodPUT, final String param_verbMethodDELETE, final String param_ScopeKey1, final String param_ScopeName1, final String param_ScopeKey2, final String param_ScopeKey3, final String param_ScopeKey4, final String param_ScopeName2, final String param_ScopeName3, final String param_ScopeName4, final String param_User, final String param_newUserName, final String param_newPassword, final String param_retypePassword, final String param_role, final String param_UserName, final String param_Password, final String param_publisherURL, final String param_carbonUrl, final String param_userAdmin, final String param_AdminPasswd, final String roleName) throws Exception {
        //APIM-175: Check whether user can add different scopes for different resources.
        //CreateAPI upto design Stage
        Common.bc_Login_APIPublisher(caller, param_UserName,param_Password,param_publisherURL);
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        /*
        SetVariable
         name=APIName
         type=String
         paramValue="api"+caller.generateData("int",2)
        */
        caller.type("APIPublisherAdd.tf_APIName",param_APIName);
        //Type API contest
        String APIcontest = "api"+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //Type valid image path
        /*
        Type
         object=APIPublisherAdd.btn_BrowseImage
         text=@param_APIImagePath
        */
        caller.click("APIPublisherAdd.btn_BrowseImage");
        caller.pause("2000");
        String aaaa = param_APIImagePath;
        caller.fireEvent("KEY%type="+param_APIImagePath+"","3000");
        caller.pause("3000");
        caller.fireEvent("KEY%key=\n","2000");
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.fireEvent("KEY%key=\n","2000");
        caller.type("APIPublisherAdd.tf_URLPattern",param_URLPattern);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbMethodGET);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbMethodPOST);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbMethodPUT);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbMethodDELETE);
        caller.click("APIPublisherAdd.btn_Save");
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Yes");
        caller.pause("5000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        Common.bc_ManagedAPI(caller, param_APIName,param_ProductionEndPontJaxRS,"");
        Common.bc_SelectTiers(caller);
        caller.pause("500");
        Common.bc_AddScopes(caller, param_ScopeKey1,param_ScopeName1);
        caller.pause("1000");
        Common.bc_AddScopes(caller, param_ScopeKey2,param_ScopeName2);
        caller.pause("1000");
        Common.bc_AddScopes(caller, param_ScopeKey3,param_ScopeName3);
        caller.pause("1000");
        Common.bc_AddScopes(caller, param_ScopeKey4,param_ScopeName4);
        caller.pause("1000");
        Common.bc_SelectScope(caller, param_verbMethodGET,param_ScopeName1);
        caller.pause("500");
        Common.bc_SelectScope(caller, param_verbMethodPOST,param_ScopeName2);
        caller.pause("500");
        Common.bc_SelectScope(caller, param_verbMethodPUT,param_ScopeName3);
        caller.pause("500");
        Common.bc_SelectScope(caller, param_verbMethodDELETE,param_ScopeName4);
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_Close");
        caller.pause("4000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("500");
        Common.bc_CreateUserAndAssignRoles(caller, param_userAdmin,param_AdminPasswd,param_newUserName,param_newPassword,param_retypePassword,roleName,param_role,param_carbonUrl);
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        Common.bc_LogOut_APIPublisher(caller, param_userAdmin);
        caller.pause("1000");
        //Waiting for content to load
        caller.type("APIPublisherLogin.tf_UserName",param_newUserName);
        caller.type("APIPublisherLogin.tf_PassWord",param_newPassword);
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("1000");
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.pause("1000");
        caller.click("APIPublisherBrowse.btn_Manage");
        caller.pause("1000");
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + param_ScopeKey1,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + param_ScopeKey2,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + param_ScopeKey3,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + param_ScopeKey4,false,"");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_170.
     */
    public final static void APIM_170(final SeleniumTestBase caller, final String param_APIName, final String param_InvalidKey, final String param_ScopeName1, final String param_ScopeDescription) throws Exception {
        //APIM-170: User should get validation message for special characters.
        caller.click("APIPublisherHome.lnk_Browse");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.click("APIPublisherBrowse.btn_Manage");
        caller.click("Scopes.btn_AddScope");
        caller.checkElementPresent("Scopes.tf_ScopeKey",false,"");
        caller.pause("2000");
        caller.type("Scopes.tf_ScopeKey",param_InvalidKey);
        caller.pause("2000");
        caller.type("Scopes.tf_ScopeName",param_ScopeName1);
        caller.type("Scopes.tf_Description",param_ScopeDescription);
        caller.pause("4000");
        caller.click("Scopes.btn_SubmitScope");
        caller.pause("2000");
        caller.checkElementPresent("Scopes.ele_lblAlreadyExistError","scopeKey_PARAM:" + param_InvalidKey,false,"");
        caller.pause("4000");
        caller.click("Scopes.btn_OK");
        caller.pause("2000");
        /*
        CheckElementPresent
         object=Scopes.ele_lblSpecialCharactorErrorMsg
         param_SpecialCharactor=@param_InvalidKey
         stopOnFailure=false
         customErrorMessage=
        */
        caller.pause("4000");
        caller.click("Scopes.btn_Close");
        caller.pause("4000");	
    }
    /**
     *  Business component APIM_171.
     */
    public final static void APIM_171(final SeleniumTestBase caller, final String param_APIName, final String param_ScopeKey6, final String param_ScopeName6) throws Exception {
        //APIM-171: Check whether user gets an validation message when trying to add scopes with duplicate key.
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        Common.bc_EditAPI(caller, param_APIName);
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.pause("3000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.pause("2000");
        Common.bc_AddScopes(caller, param_ScopeKey6,param_ScopeName6);
        caller.checkElementPresent("Scopes.ele_lblAlreadyExistError","scopeKey_PARAM:" + param_ScopeKey6,false,"");
        caller.pause("4000");
        caller.click("Scopes.btn_OK");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_349.
     */
    public final static void APIM_349(final SeleniumTestBase caller, final String param_APIName) throws Exception {
        //APIM-349: User should not be create to add a document without document name
        caller.click("APIPublisherHome.lnk_Browse");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblNameRequiredWarningMessage",false,"");	
    }
    /**
     *  Business component APIM_173.
     */
    /**
     *  Business component APIM_173.
     */
    public final static void APIM_173(final SeleniumTestBase caller) throws Exception {
        //APIM-173: Check whether user can exit from the define scope window by clicking on the 'x' sign on the window
        caller.pause("3000");
        caller.click("Scopes.btn_topXClose");
        caller.pause("6000");
        caller.checkElementPresent("Scopes.ele_lblResources",false,"");
        caller.pause("1000");	
    }
    /**
     *  Business component APIM_168.
     */
    /**
     *  Business component APIM_168.
     */
    public final static void APIM_168(final SeleniumTestBase caller) throws Exception {
        //APIM-168: Check whether compulsory fields are marked with a red star.
        caller.pause("4000");
        caller.click("Scopes.btn_AddScope");
        caller.pause("4000");
        caller.checkElementPresent("Scopes.ele_lblscopeKeyRequiredAstrix",false,"");
        caller.checkElementPresent("Scopes.ele_lblScopeNameRequiredAstrix",false,"");
        caller.pause("4000");
        caller.click("Scopes.btn_Close");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_166.
     */
    public final static void APIM_166(final SeleniumTestBase caller, final String param_ScopeKey5, final String param_ScopeName5) throws Exception {
        //APIM-166: User should be able to add scopes in the manage stage when creating an API
        Common.bc_AddScopes(caller, param_ScopeKey5,param_ScopeName5);
        caller.pause("2000");
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + param_ScopeKey5,false,"");
        caller.pause("2000");	
    }
    /**
     *  Business component APIM_176.
     */
    public final static void APIM_176(final SeleniumTestBase caller, final String param_scopeName1, final String param_scopeName2, final String param_scopeName3, final String param_scopeName4, final String param_scopeName5, final String param_scopeName6, final String param_scopeKey1) throws Exception {
        //APIM-176: Check whether scopes get loaded successfully into the scope selection drop down in front of resource
        caller.click("Scopes.btn_ScopeParam","Scope_PARAM:" + param_scopeKey1);
        caller.click("Scopes.ele_ddScope");
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + param_scopeName1,false,"");
        caller.pause("500");
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + param_scopeName2,false,"");
        caller.pause("500");
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + param_scopeName3,false,"");
        caller.pause("500");
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + param_scopeName4,false,"");
        caller.pause("500");
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + param_scopeName5,false,"");
        caller.pause("500");
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + param_scopeName6,false,"");
        caller.pause("500");
        caller.pause("2000");	
    }
    /**
     *  Business component APIM_167.
     */
    public final static void APIM_167(final SeleniumTestBase caller, final String param_ScopeKey6, final String param_ScopeName6, final String param_APIName) throws Exception {
        //APIM-167: Check whether user can add scope to a created API using edit view.
        Common.bc_AddScopes(caller, param_ScopeKey6,param_ScopeName6);
        caller.pause("3000");
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + param_ScopeKey6,false,"");
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Save1");
        caller.pause("4000");
        caller.click("APIPublisherHome.lnk_Browse");
        Common.bc_EditAPI(caller, param_APIName);
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + param_ScopeKey6,false,"");	
    }
    /**
     *  Business component APIM_174.
     */
    public final static void APIM_174(final SeleniumTestBase caller, final String param_APIName) throws Exception {
        //APIM-174: Check whether user can exit from the define scope window by clicking
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        Common.bc_EditAPI(caller, param_APIName);
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.pause("1000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.click("Scopes.btn_AddScope");
        caller.checkElementPresent("Scopes.tf_ScopeKey",false,"");
        caller.pause("3000");
        caller.click("Scopes.btn_Close");
        caller.pause("2000");	
    }
    /**
     *  Business component APIM_169.
     */
    public final static void APIM_169(final SeleniumTestBase caller, final String param_scopeKey7, final String param_scopeName7) throws Exception {
        //APIM-169: Check whether user gets a validation message for empty compulsory fields.
        caller.click("Scopes.btn_AddScope");
        caller.pause("3000");
        caller.click("Scopes.btn_SubmitScope");
        caller.checkElementPresent("Scopes.ele_lblRequiredFieldError",false,"");
        caller.pause("3000");
        caller.checkElementPresent("Scopes.ele_lblRequiredFieldError2",false,"");
        caller.pause("3000");
        caller.type("Scopes.tf_ScopeKey",param_scopeKey7);
        caller.pause("4000");
        caller.click("Scopes.btn_SubmitScope");
        caller.checkElementPresent("Scopes.ele_lblRequiredFieldError2",false,"");
        caller.pause("3000");
        caller.type("Scopes.tf_ScopeKey",param_scopeKey7);
        caller.pause("3000");
        caller.type("Scopes.tf_ScopeName",param_scopeName7);
        caller.pause("4000");
        caller.click("Scopes.btn_SubmitScope");
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + param_scopeKey7,false,"");
        caller.pause("4000");
        caller.click("Scopes.btn_Close");
        caller.pause("2000");	
    }
    /**
     *  Business component APIM_177.
     */
    public final static void APIM_177(final SeleniumTestBase caller, final String param_verbMethodVerb, final String param_APIName, final String param_verbMethodGet, final String param_ScopeName5, final String param_ScopeName6, final String param_ScopeKey1, final String param_ScopeKey2) throws Exception {
        //APIM-177: Check whether user can edit and change scope already assigned to the resource into a different scope
        caller.click("APIPublisherHome.lnk_Browse");
        Common.bc_EditAPI(caller, param_APIName);
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.pause("1000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.pause("1000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.pause("2000");
        caller.click("Scopes.btn_ScopeParam","Scope_PARAM:" + param_ScopeKey1);
        caller.select("Scopes.ele_ddScope",param_ScopeName5);
        caller.pause("3000");
        caller.click("Scopes.btn_Right");
        caller.click("Scopes.btn_ScopeParam","Scope_PARAM:" + param_ScopeKey2);
        caller.select("Scopes.ele_ddScope",param_ScopeName6);
        caller.pause("3000");
        caller.click("Scopes.btn_Right");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_73.
     */
    public final static void APIM_73(final SeleniumTestBase caller, final String param_APIName, final String param_urlPatternSC, final String param_verbGet, final String param_verbPost) throws Exception {
        //APIM-73: Ability to define the templates in publisher
        caller.click("APIPublisherHome.lnk_Browse");
        Common.bc_EditAPI(caller, param_APIName);
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatternSC);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbGet);
        caller.pause("500");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPost);
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Add");
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbGet + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternSC,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbPost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternSC,false,"");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_74.
     */
    public final static void APIM_74(final SeleniumTestBase caller, final String param_APIName, final String param_urlPatternUriTemplate, final String param_verbGet, final String param_verbPost) throws Exception {
        //APIM-74: user should be able to define complex uri - templates having many parameters
        caller.click("APIPublisherHome.lnk_Browse");
        Common.bc_EditAPI(caller, param_APIName);
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatternUriTemplate);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbGet);
        caller.pause("500");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPost);
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Add");
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbGet + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternUriTemplate,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbPost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternUriTemplate,false,"");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_75.
     */
    public final static void APIM_75(final SeleniumTestBase caller, final String param_APIName, final String param_urlPatternUriTemplate, final String param_verbGet, final String param_verbPost, final String param_verbPut, final String param_verbDelete) throws Exception {
        //APIM-75: User should be able to define complex uri-templates with each HTTP verb
        caller.click("APIPublisherHome.lnk_Browse");
        Common.bc_EditAPI(caller, param_APIName);
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatternUriTemplate);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbGet);
        caller.pause("500");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPost);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPut);
        caller.pause("500");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbDelete);
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Add");
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbGet + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternUriTemplate,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbPost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternUriTemplate,false,"");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_78.
     */
    public final static void APIM_78(final SeleniumTestBase caller, final String param_urlPatternComplex, final String param_APIName, final String param_verbGet, final String param_verbPost) throws Exception {
        //APIM-78: Test with lengthy URL parameters
        caller.click("APIPublisherHome.lnk_Browse");
        Common.bc_EditAPI(caller, param_APIName);
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatternComplex);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbGet);
        caller.pause("3000");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPost);
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Add");
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbGet + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternComplex,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbPost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternComplex,false,"");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_6A.
     */
    public final static void APIM_6A(final SeleniumTestBase caller, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_APIName, final String param_ProductionEndPoint, final String param_docName, final String param_publisherURL, final String param_username, final String param_password) throws Exception {
        Common.bc_Login_APIPublisher(caller, param_username,param_password,param_publisherURL);
        Common.bc_CreateAPI_DesignStage(caller, param_APIImagePath,param_APIVersion,param_tagName,param_APIName);
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.pause("2000");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPoint);
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.pause("1000");
        Common.bc_SelectTiers(caller);
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Close");
        caller.pause("1000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.checkElementPresent("Browse_Doc.ele_ddVisibility",false,"");
        caller.checkElementPresent("Browse_Doc.ele_ddOption1",false,"");
        caller.checkElementPresent("Browse_Doc.ele_ddOption2",false,"");
        caller.checkElementPresent("Browse_Doc.ele_ddOption3",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_6A Successfully Passed");	
    }
    /**
     *  Business component APIM_116.
     */
    public final static void APIM_116(final SeleniumTestBase caller, final String param_APIName, final String param_DocName1, final String param_rdoHowTo, final String param_DocName2, final String param_rdoSampleSDK, final String param_DocName3, final String param_rdoPublicForum, final String param_DocName4, final String param_rdoSupportForum, final String param_DocName5, final String param_rdoOther, final String param_otherSpecify, final String param_Url, final String param_publisherURL, final String param_rdoOther1, final String param_rdoSupportForum1, final String param_rdoPublicForum1, final String param_rdoSampleSDK1, final String param_rdoHowTo1, final String param_rdoUrl) throws Exception {
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        //1st doc How To
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_DocName",param_DocName1);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoHowTo);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_DocName1 + "_PARAM," + "docType_PARAM:" + param_rdoHowTo1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_DocName1 + "_PARAM," + "docType_PARAM:" + param_rdoHowTo1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_DocName1 + "_PARAM," + "docType_PARAM:" + param_rdoHowTo1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_DocName1 + "_PARAM," + "docType_PARAM:" + param_rdoHowTo1,false,"");
        //2nd doc Sample & SDK
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_DocName",param_DocName2);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoSampleSDK);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_DocName2 + "_PARAM," + "docType_PARAM:" + param_rdoSampleSDK1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_DocName2 + "_PARAM," + "docType_PARAM:" + param_rdoSampleSDK1,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_DocName2 + "_PARAM," + "docType_PARAM:" + param_rdoSampleSDK1,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_DocName2 + "_PARAM," + "docType_PARAM:" + param_rdoSampleSDK1,false,"");
        //3nd doc Public Forum
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_DocName",param_DocName3);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoPublicForum);
        if(caller.checkElementPresent("Browse_Doc.tf_URL")){
        caller.type("Browse_Doc.tf_URL",param_Url);
        }
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_DocName3 + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_DocName3 + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_DocName3 + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_DocName3 + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        //4thd doc Support Forum
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_DocName",param_DocName4);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoSupportForum);
        if(caller.checkElementPresent("Browse_Doc.tf_URL")){
        caller.type("Browse_Doc.tf_URL",param_Url);
        }
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoUrl);
        caller.type("Browse_Doc.tf_URL",param_Url);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_DocName4 + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_DocName4 + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_DocName4 + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_DocName4 + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        //5th doc Other Type
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_DocName",param_DocName5);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoOther);
        if(caller.checkElementPresent("Browse_Doc.tf_Other")){
        caller.type("Browse_Doc.tf_Other",param_otherSpecify);
        }
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_DocName5 + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_DocName5 + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_DocName5 + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_DocName5 + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.pause("2000");
        caller.pause("2000");
        caller.writeToReport("APIM_116 Successfully Passed");	
    }
    /**
     *  Business component APIM_113.
     */
    public final static void APIM_113(final SeleniumTestBase caller, final String param_docName, final String param_URL, final String param_APIName) throws Exception {
        //Check whether system doesn't allow user to change source as 'in-line' for forum type documents.
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        //check edit document page visibility
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        //change type to public forum(pre condition)
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.pause("500");
        caller.click("Browse_Doc.rdo_URL");
        caller.type("Browse_Doc.tf_URL",param_URL);
        caller.pause("1000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("500");
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + param_docName,false,"");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        caller.pause("3000");
        //check the Document name should be visible in a non-editabe field
        caller.checkObjectProperty("Browse_Doc.tf_DocName","PROPERTYPRESENT","disabled|true",false,"");
        //check for non-selectable in-line radio button
        caller.checkObjectProperty("Browse_Doc.rdo_Inline","PROPERTYPRESENT","disabled|true",false,"");
        //change type to support forum
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_SupportForum");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("5000");
        caller.checkElementPresent("Browse_Doc.ele_SupportForum","param_docName_PARAM:" + param_docName,false,"");
        //check
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        //check the Document name should be visible in a non-editabe field
        caller.pause("3000");
        caller.checkObjectProperty("Browse_Doc.tf_DocName","PROPERTYPRESENT","disabled|true",false,"");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        //check for non-selectable in-line radio button
        caller.checkObjectProperty("Browse_Doc.rdo_Inline","PROPERTYPRESENT","disabled|true",false,"");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_105.
     */
    public final static void APIM_105(final SeleniumTestBase caller, final String param_DocName, final String param_Summary, final String param_rdoOther, final String param_other, final String param_rdoFile, final String param_fileToUpload, final String param_fileName, final String param_storeURL, final String param_APIName, final String param_publisherURL, final String param_rdoOther1, final String param_serverName, final String downImage, final String param_StoreuserName, final String param_Storepassword) throws Exception {
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_DocName",param_DocName);
        caller.type("Browse_Doc.tf_Summary",param_Summary);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoOther);
        if(caller.checkElementPresent("Browse_Doc.tf_Other")){
        caller.type("Browse_Doc.tf_Other",param_other);
        }
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoOther);
        caller.type("Browse_Doc.tf_Other",param_other);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoFile);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("500");
        caller.checkElementPresent("Browse_Doc.ele_lblThisFieldisRequired",false,"");
        caller.type("Browse_Doc.tf_DocName",param_DocName);
        caller.type("Browse_Doc.tf_Summary",param_Summary);
        caller.pause("2000");
        caller.type("Browse_Doc.tf_BrowseFile",param_fileToUpload);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_DocName + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_DocName + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_DocName + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_DocName + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + param_DocName);
        caller.pause("2000");
        String downImagePopup = downImage;
        if(caller.checkImagePresent(downImagePopup,false)){
        caller.fireEvent("KEY%key=alt+s","2000");
        caller.fireEvent("KEY%key=alt+a","2000");
        caller.fireEvent("KEY%key=\n","1000");
        }
        caller.checkFileInfo(param_fileName,"EXIST",false,"");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.pause("4000");
        Common.bc_APIStoreLogin(caller, param_StoreuserName,param_Storepassword);
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Other",false,"");
        caller.click("APIStoreDocumentation.lnk_Other");
        if(caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_fileName_PARAM:" + param_fileName)){
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_fileName);
        }
        caller.checkFileInfo(param_fileName,"EXIST",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_105 Successfully Passed");	
    }
    /**
     *  Business component APIM_104.
     */
    public final static void APIM_104(final SeleniumTestBase caller, final String param_invaliddocName1, final String param_APIName, final String param_rdoOther, final String param_invaliddocName2, final String param_docName, final String param_summary, final String param_rdoHowTo, final String param_rdoURL, final String param_other, final String param_url, final String param_publisherURL, final String param_rdoOther1) throws Exception {
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        //1st doc How To
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_DocName",param_invaliddocName1);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoOther);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblInvalidDocName",false,"");
        caller.type("Browse_Doc.tf_DocName",param_invaliddocName2);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoOther);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblInvalidDocName",false,"");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.type("Browse_Doc.tf_Summary",param_summary);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoHowTo);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoURL);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblThisFieldisRequired",false,"");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.type("Browse_Doc.tf_Summary",param_summary);
        caller.pause("500");
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoOther);
        caller.type("Browse_Doc.tf_Other",param_other);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoURL);
        caller.type("Browse_Doc.tf_URL",param_url);
        caller.pause("1000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + param_docName);
        caller.pause("2000");
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.fireEvent("KEY%key=ctrl+2","2000");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        caller.writeToReport("APIM_104 Successfully Passed");	
    }
    /**
     *  Business component APIM_112.
     */
    public final static void APIM_112(final SeleniumTestBase caller, final String param_docName, final String param_newVersion, final String param_editContent, final String param_summaryNew, final String param_publisherURL, final String param_APIName, final String param_serverName, final String param_storeURL, final String TableColumnType) throws Exception {
        //Check whether system doesn't allow user to change source as 'in-line' for forum type documents.
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        //check edit document page visibility
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        //change type to public forum(pre condition)
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("500");
        //Check whether document details are listed on the docs page of the API.
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_docName,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + TableColumnType,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + TableColumnType,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + TableColumnType,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + TableColumnType,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_docName);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_newVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\n","10");
        /*
        CheckElementPresent
         object=Browse_Doc.ele_lblSuccessful
         stopOnFailure=false
         customErrorMessage=
        */
        caller.pause("4000");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","5000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        //Verify doc is under doc tab and doc name and type
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_docName,false,"");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkElementPresent("APIStoreDocumentation.lnk_HowTo",false,"");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Wait for content load
        caller.pause("1000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_docName,false,"");
        //Verify summary
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_docName,false,"");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_docName);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + param_docName,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");	
    }
    /**
     *  Business component APIM_103.
     */
    public final static void APIM_103(final SeleniumTestBase caller, final String param_APIName, final String param_docNameWithSpace, final String param_summary, final String param_rdoOther, final String param_other, final String param_APIversion, final String param_editContent, final String param_storeURL, final String param_serverName, final String param_publisherURL, final String param_rdoOther1) throws Exception {
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_docNameWithSpace);
        caller.type("Browse_Doc.tf_Summary",param_summary);
        caller.pause("500");
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoOther);
        caller.type("Browse_Doc.tf_Other",param_other);
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_docNameWithSpace + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_docNameWithSpace + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_docNameWithSpace + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_docNameWithSpace + "_PARAM," + "docType_PARAM:" + param_rdoOther1,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_docNameWithSpace);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocNameEditContent","param_docName_PARAM:" + param_docNameWithSpace,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblVersion","param_APIversion_PARAM:" + param_APIversion,false,"");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_EditContenetCancel");
        caller.pause("1000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_docNameWithSpace);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","5000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("5000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Other");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_docNameWithSpace);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.checkElementPresent("Browse_Doc.ele_lblContentDocViewer","param_content_PARAM:" + param_editContent,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        caller.writeToReport("APIM_103 Successfully Passed");	
    }
    /**
     *  Business component APIM_114.
     */
    public final static void APIM_114(final SeleniumTestBase caller, final String param_summery, final String param_URL, final String param_visibilityValue, final String param_docName, final String param_APIName, final String param_serverName, final String param_visibilityValue2, final String param_summery2, final String param_visibilityValue3, final String param_uploadDocLocation2, final String param_storeURL, final String param_usernameStore, final String param_passwordStore, final String param_APIVersion, final String param_publisherURL, final String param_uploadDocLocation, final String param_DownloadFilePath2, final String param_DownloadFilePath) throws Exception {
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        //check edit document page visibility
        caller.pause("3000");
        caller.checkObjectProperty("Browse_Doc.tf_DocName","PROPERTYPRESENT","disabled",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.type("Browse_Doc.tf_Summary",param_summery2);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_URL");
        caller.type("Browse_Doc.tf_URL",param_URL);
        caller.select("Browse_Doc.ele_ddVisibility",param_visibilityValue);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("5000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Samples",false,"");
        caller.click("APIStoreDocumentation.lnk_Samples");
        //Wait for content load
        caller.pause("1000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_docName,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_docName + "_PARAM," + "param_URLLink_PARAM:" + param_URL,false,"");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summery2,false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("1000");
        caller.select("Browse_Doc.ele_ddVisibility",param_visibilityValue2);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("5000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Samples",false,"");
        caller.click("APIStoreDocumentation.lnk_Samples");
        //Wait for content load
        caller.pause("1000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_docName,false,"");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summery2,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_docName,false,"");
        caller.pause("3000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        caller.select("Browse_Doc.ele_ddVisibility",param_visibilityValue3);
        caller.click("Browse_Doc.rdo_File");
        caller.type("Browse_Doc.tf_BrowseFile",param_uploadDocLocation);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //wait till page load
        caller.click("APIStoreDocumentation.lnk_Samples");
        //Wait for content load
        caller.pause("1000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_docName,false,"");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summery2,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_docName,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_docName);
        caller.checkFileInfo(param_DownloadFilePath2,"EXIST",false,"");
        caller.pause("3000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        caller.select("Browse_Doc.ele_ddVisibility",param_visibilityValue);
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.click("Browse_Doc.rdo_File");
        caller.type("Browse_Doc.tf_BrowseFile",param_uploadDocLocation2);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        //Wait for content load
        caller.pause("1000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_docName,false,"");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summery2,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_docName,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_docName);
        caller.checkFileInfo(param_DownloadFilePath,"EXIST",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName);
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_SupportForum");
        caller.click("Browse_Doc.rdo_URL");
        caller.type("Browse_Doc.tf_URL",param_URL);
        caller.select("Browse_Doc.ele_ddVisibility",param_visibilityValue);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("5000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        Common.bc_APIStoreLogin(caller, param_usernameStore,param_passwordStore);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        //Wait for content load
        caller.pause("1000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_docName,false,"");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summery2,false,"");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_docName + "_PARAM," + "param_URLLink_PARAM:" + param_URL);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");	
    }
    /**
     *  Business component APIM_102.
     */
    public final static void APIM_102(final SeleniumTestBase caller, final String param_APIName, final String param_docName, final String param_Summary, final String param_rdoSupportForum, final String param_url, final String param_rdoUrl, final String param_rdoFile, final String param_fileToUpload, final String param_downloadedFile, final String param_storeURL, final String param_publisherURL, final String param_serverName, final String param_rdoSupportForum1) throws Exception {
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.type("Browse_Doc.tf_Summary",param_Summary);
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoSupportForum);
        caller.pause("100");
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoFile);
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblThisFieldisRequired",false,"");
        caller.pause("500");
        caller.type("Browse_Doc.tf_BrowseFile",param_fileToUpload);
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + param_docName);
        caller.checkFileInfo(param_downloadedFile,"EXIST",false,"");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("1000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_docName);
        caller.checkFileInfo(param_downloadedFile,"EXIST",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_102 Successfully Passed");	
    }
    /**
     *  Business component APIM_101.
     */
    public final static void APIM_101(final SeleniumTestBase caller, final String param_rdoUrl, final String param_APIName, final String param_docName, final String param_Summary, final String param_rdoSupportForum, final String param_url, final String param_publisherURL, final String param_serverName, final String param_storeURL, final String param_rdoSupportForum1) throws Exception {
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.type("Browse_Doc.tf_Summary",param_Summary);
        caller.pause("500");
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoSupportForum);
        caller.type("Browse_Doc.tf_URL",param_url);
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForum1,false,"");
        caller.click("Browse_Doc.btn_View","param_docName_PARAM:" + param_docName);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        //verify the Site
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("1000");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("1000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.lnk_link","param_docName_PARAM:" + param_docName,false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_101 Successfully Passed");	
    }
    /**
     *  Business component APIM_100.
     */
    public final static void APIM_100(final SeleniumTestBase caller, final String param_APIName, final String param_rdoPublicForum, final String param_rdoInline, final String param_publisherURL, final String param_docName, final String param_Summary, final String param_rdoPublicForum1) throws Exception {
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.type("Browse_Doc.tf_Summary",param_Summary);
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoPublicForum);
        caller.checkObjectProperty("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoInline,"PROPERTYPRESENT","disabled|true",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_100 Successfully Passed");	
    }
    /**
     *  Business component APIM_99.
     */
    public final static void APIM_99(final SeleniumTestBase caller, final String param_APIName, final String param_rdoPublicForum, final String param_Summary, final String param_docName, final String param_rdoFile, final String param_File, final String param_downloadedFile, final String param_serverName, final String param_publisherURL, final String param_storeURL, final String param_rdoPublicForum1) throws Exception {
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.type("Browse_Doc.tf_Summary",param_Summary);
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoPublicForum);
        caller.pause("500");
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoFile);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblThisFieldisRequired",false,"");
        caller.type("Browse_Doc.tf_BrowseFile",param_File);
        caller.doubleClick("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + param_docName);
        caller.checkFileInfo(param_downloadedFile,"EXIST",false,"");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("1000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_docName);
        caller.checkFileInfo(param_downloadedFile,"EXIST",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_99 Successfully Passed");	
    }
    /**
     *  Business component APIM_98.
     */
    public final static void APIM_98(final SeleniumTestBase caller, final String param_APIName, final String param_rdoUrl, final String param_docName, final String param_Summary, final String param_rdoPublicForum, final String param_url, final String param_serverName, final String param_storeURL, final String param_publisherURL, final String param_rdoPublicForum1) throws Exception {
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.type("Browse_Doc.tf_Summary",param_Summary);
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoPublicForum);
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_url);
        caller.pause("1000");
        caller.doubleClick("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForum1,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + param_docName);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("1000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_docName + "_PARAM," + "param_URLLink_PARAM:" + param_url,false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_98 Successfully Passed");	
    }
    /**
     *  Business component APIM_95.
     */
    public final static void APIM_95(final SeleniumTestBase caller, final String param_UserName, final String param_Password, final String param_publisherURL, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_APIName, final String param_ProductionEndPont, final String param_SandBoxEndpoint, final String param_docInvalidName, final String param_docName, final String param_docSummery, final String param_sourceUrl, final String param_storeURL, final String param_usernameStore, final String param_passwordStore, final String param_serverName) throws Exception {
        //APIM-95:Create a document given 'Samples & SDK' as the type and 'URL' as the source.
        Common.bc_Login_APIPublisher(caller, param_UserName,param_Password,param_publisherURL);
        //Create API In Prtotype
        Common.bc_CreateAPI_DesignStage(caller, param_APIImagePath,param_APIVersion,param_tagName,param_APIName);
        Common.bc_PrototypeAPI(caller);
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_Save1");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        //Wait for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_Close");
        caller.pause("4000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("1000");
        //check the visibility of ad new document feilds
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        //adding a document
        caller.type("Browse_Doc.tf_DocName",param_docInvalidName);
        caller.checkElementPresent("Browse_Doc.rdo_SampleAndSDK",false,"");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.rdo_URL",false,"");
        caller.click("Browse_Doc.rdo_URL");
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for error load
        caller.pause("6000");
        //check for error
        caller.checkElementPresent("Browse_Doc.ele_lblNameError",false,"");
        caller.pause("6000");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.type("Browse_Doc.tf_Summary",param_docSummery);
        caller.click("Browse_Doc.btn_AddDocument");
        //check for error
        caller.pause("6000");
        caller.checkElementPresent("Browse_Doc.ele_lblNameRequiredWarningMessage",false,"");
        caller.pause("6000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrl);
        caller.click("Browse_Doc.btn_AddDocument");
        //wait till page load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + param_docName,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + param_docName);
        //wait
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        Common.bc_APIStoreLogin(caller, param_usernameStore,param_passwordStore);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //wait for page load
        caller.click("APIStoreDocumentation.lnk_Samples");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_docName,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_docName + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrl,false,"");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_docName + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrl);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");	
    }
    /**
     *  Business component APIM_96.
     */
    public final static void APIM_96(final SeleniumTestBase caller, final String param_publisherURL, final String param_APIName, final String param_docName, final String param_summary, final String param_rdoSampleSdk, final String param_rdoSampleSdk1, final String param_fileDownloaded, final String param_serverName, final String param_storeURL, final String param_fileToUpload, final String param_rdoFile) throws Exception {
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.type("Browse_Doc.tf_Summary",param_summary);
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoSampleSdk);
        caller.pause("500");
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoFile);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblThisFieldisRequired",false,"");
        caller.type("Browse_Doc.tf_DocName",param_docName);
        caller.type("Browse_Doc.tf_Summary",param_summary);
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_typeAndSource","TypeOrSource_PARAM:" + param_rdoSampleSdk);
        caller.pause("500");
        caller.type("Browse_Doc.tf_BrowseFile",param_fileToUpload);
        caller.pause("1000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSampleSdk1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSampleSdk1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSampleSdk1,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_docName + "_PARAM," + "docType_PARAM:" + param_rdoSampleSdk1,false,"");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + param_docName);
        caller.pause("2000");
        caller.checkFileInfo(param_fileDownloaded,"EXIST",false,"");
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("1000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_docName);
        caller.checkFileInfo(param_fileDownloaded,"EXIST",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_96 Successfully Passed");	
    }
    /**
     *  Business component APIM_90.
     */
    public final static void APIM_90(final SeleniumTestBase caller, final String param_APIName) throws Exception {
        //APIM-90: Check whether system validates for empty fields in add new document page
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddDocument");
        //wait for validation message/verify the required field message
        caller.checkElementPresent("Browse_Doc.ele_lblNameRequiredWarningMessage",false,"");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_91.
     */
    public final static void APIM_91(final SeleniumTestBase caller, final String param_docName2, final String param_summery, final String param_serverName, final String param_usernameStore, final String param_passwordStore, final String param_APIName, final String param_APIVersion, final String param_editContent, final String param_storeURL, final String param_publisherURL) throws Exception {
        //APIM-91: Successfully add new in-line, 'how to' type document.
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.type("Browse_Doc.tf_DocName",param_docName2);
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.type("Browse_Doc.tf_Summary",param_summery);
        caller.checkElementPresent("Browse_Doc.rdo_HowTo",false,"");
        caller.click("Browse_Doc.rdo_HowTo");
        caller.checkElementPresent("Browse_Doc.rdo_Inline",false,"");
        caller.click("Browse_Doc.rdo_Inline");
        caller.click("Browse_Doc.btn_AddDocument");
        //wait till page load
        caller.pause("6000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_docName2,false,"");
        //check added document column names
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + param_docName2 + "_PARAM," + "docType_PARAM:How To",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + param_docName2 + "_PARAM," + "docType_PARAM:How To",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltablevisibility","docName_PARAM:" + param_docName2 + "_PARAM," + "docType_PARAM:How To",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + param_docName2 + "_PARAM," + "docType_PARAM:How To",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + param_docName2 + "_PARAM," + "docType_PARAM:How To",false,"");
        //check for action column links
        caller.checkElementPresent("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_docName2,false,"");
        caller.checkElementPresent("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_docName2,false,"");
        caller.checkElementPresent("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_docName2,false,"");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //wait till page load
        caller.click("APIStoreAPIs.lnk_HowTo");
        //check for added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_docName2,false,"");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_docName2);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblViewContentPageText","paramDocName_PARAM:" + param_docName2,false,"");
        caller.pause("6000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_docName2);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_APIVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.tf_EditContent1",false,"");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\t|key=\n","5000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("5000");
        //check for the document details
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_docName2,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_docName2);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_APIVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.tf_EditContent1",false,"");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\n","5000");
        /*
        CheckElementPresent
         object=Browse_Doc.ele_lblSuccessful
         stopOnFailure=false
         customErrorMessage=

        Pause
         ms=5000
        CheckElementPresent
         object=Browse_Doc.ele_lblVersion
         param_APIversion=@param_APIVersion
         stopOnFailure=false
         customErrorMessage=
        */
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","6000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("5000");
        //check for the document details
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_docName2,false,"");	
    }
    /**
     *  Business component APIM_92.
     */
    public final static void APIM_92(final SeleniumTestBase caller, final String param_docInvalidName, final String param_sourceURL, final String param_docInvalidName2, final String param_docName3, final String param_publisherURL, final String param_usernameStore, final String param_passwordStore, final String param_APIName, final String param_APIVersion, final String param_storeURL, final String param_serverName) throws Exception {
        //APIM-92: Create a document given 'How to' as the type and 'URL' as the source.
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //wait till page load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.type("Browse_Doc.tf_DocName",param_docInvalidName);
        caller.checkElementPresent("Browse_Doc.rdo_HowTo",false,"");
        caller.click("Browse_Doc.rdo_HowTo");
        caller.checkElementPresent("Browse_Doc.rdo_URL",false,"");
        caller.click("Browse_Doc.rdo_URL");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Validate for error messages
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblNameError",false,"");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_DocName",param_docInvalidName2);
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_URL");
        caller.click("Browse_Doc.btn_AddDocument");
        //validate the error message
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblNameError",false,"");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_DocName",param_docName3);
        caller.click("Browse_Doc.btn_AddDocument");
        //validate required fields
        caller.checkElementPresent("Browse_Doc.ele_lblNameRequiredWarningMessage",false,"");
        caller.type("Browse_Doc.tf_DocName",param_docName3);
        caller.click("Browse_Doc.rdo_URL");
        caller.type("Browse_Doc.tf_URL",param_sourceURL);
        caller.pause("1000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_docName3,false,"");
        //wait for page load
        caller.pause("5000");
        caller.click("Browse_Doc.btn_View","param_docName_PARAM:" + param_docName3);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        /*
        SelectWindow
         object=Browse_Doc.newWindow1
        //wait till page load
        Pause
         ms=6000
        Call
         businessComponent=Common.bc_SwitchUser
        SelectWindow
         object=Browse_Doc.defaultWindow
        */
        caller.pause("2000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreAPIs.lnk_HowTo");
        caller.pause("1000");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_docName3,false,"");
        caller.checkElementPresent("APIStoreAPIs.lnk_edditedUrl","EdditedUrl_PARAM:" + param_sourceURL,false,"");
        caller.click("APIStoreAPIs.lnk_edditedUrl","EdditedUrl_PARAM:" + param_sourceURL);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.pause("2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");	
    }
    /**
     *  Business component APIM_93.
     */
    public final static void APIM_93(final SeleniumTestBase caller, final String param_APIName, final String param_docName4, final String param_uploadDocLocation, final String param_Summery, final String param_storeURL, final String param_usernameStore, final String param_passwordStore, final String param_DownloadFilePath, final String param_serverName, final String param_APIVersion, final String param_publisherURL, final String param_downImage2) throws Exception {
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //wait for page load
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.type("Browse_Doc.tf_DocName",param_docName4);
        caller.type("Browse_Doc.tf_Summary",param_Summery);
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_File");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblNameRequiredWarningMessage",false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.type("Browse_Doc.tf_DocName",param_docName4);
        caller.type("Browse_Doc.tf_Summary",param_Summery);
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_File");
        caller.type("Browse_Doc.tf_BrowseFile",param_uploadDocLocation);
        caller.click("Browse_Doc.btn_AddDocument");
        //wait for page load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_docName4,false,"");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + param_docName4);
        //wait for download the file
        caller.pause("3000");
        caller.pause("2000");
        String downImagePopup1 = param_downImage2;
        if(caller.checkImagePresent(downImagePopup1,false)){
        caller.fireEvent("KEY%key=alt+s","2000");
        caller.fireEvent("KEY%key=alt+a","2000");
        caller.fireEvent("KEY%key=\n","1000");
        }
        //go to Store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreAPIs.lnk_HowTo");
        caller.pause("1000");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_docName4,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_docName4,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_docName4);
        caller.pause("1000");
        caller.checkFileInfo(param_DownloadFilePath,"EXIST",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");	
    }
    /**
     *  Business component APIM_94.
     */
    public final static void APIM_94(final SeleniumTestBase caller, final String param_APIName, final String param_DocName5, final String param_Summery, final String param_editContent, final String param_APIVersion, final String param_storeURL, final String param_serverName, final String param_usernameStore, final String param_passwordStore, final String param_publisherURL) throws Exception {
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //wait for page load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.type("Browse_Doc.tf_DocName",param_DocName5);
        caller.type("Browse_Doc.tf_Summary",param_Summery);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.pause("500");
        caller.click("Browse_Doc.rdo_Inline");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + param_DocName5,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_DocName5);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.pause("4000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_APIVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.tf_EditContent1",false,"");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\t|key=\n","5000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("5000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + param_DocName5,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_DocName5);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.pause("4000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_APIVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.tf_EditContent1",false,"");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","5000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + param_DocName5,false,"");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_Samples");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_DocName5);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.checkElementPresent("APIStoreDocumentation.ele_documentViewText","param_text_PARAM:" + param_editContent + "_PARAM," + "param_docName_PARAM:" + param_DocName5,false,"");
        caller.pause("6000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");	
    }
    /**
     *  Business component APIM_347.
     */
    public final static void APIM_347(final SeleniumTestBase caller, final String param_docName5, final String param_APIName) throws Exception {
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("4000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //wait for page load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.type("Browse_Doc.tf_DocName",param_docName5);
        caller.pause("1000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.ele_lblDuplicateDocName",false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_97.
     */
    public final static void APIM_97(final SeleniumTestBase caller, final String param_DocName6, final String param_APIName, final String param_Summery) throws Exception {
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //wait for page load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.type("Browse_Doc.tf_DocName",param_DocName6);
        caller.type("Browse_Doc.tf_Summary",param_Summery);
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.pause("1000");
        if(caller.checkElementPresent("Browse_Doc.rdo_DisableInline")){
        caller.writeToReport("Inline Radio button is disable");
        }
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("6000");	
    }
    /**
     *  Business component APIM_348.
     */
    public final static void APIM_348(final SeleniumTestBase caller, final String param_APIName, final String param_DocName7, final String param_Summery, final String param_storeURL, final String param_serverName, final String param_usernameStore, final String param_passwordStore, final String param_APIVersion) throws Exception {
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_APIVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //wait for page load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.type("Browse_Doc.tf_DocName",param_DocName7);
        caller.type("Browse_Doc.tf_Summary",param_Summery);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_DocName7,false,"");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreAPIs.lnk_HowTo");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocSummery","param_Summery_PARAM:" + param_Summery + "_PARAM," + "param_DocName_PARAM:" + param_DocName7,false,"");	
    }
    /**
     *  Business component APIM_115.
     */
    public final static void APIM_115(final SeleniumTestBase caller, final String param_UserName, final String param_Password, final String param_publisherURL, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_APIName, final String param_ProductionEndPont, final String param_DocName, final String param_SandBoxEndpoint) throws Exception {
        //APIM-115: User should get validation message when trying to update document having an empty source URL
        Common.bc_Login_APIPublisher(caller, param_UserName,param_Password,param_publisherURL);
        //Create API In Prtotype
        Common.bc_CreateAPI_DesignStage(caller, param_APIImagePath,param_APIVersion,param_tagName,param_APIName);
        Common.bc_PrototypeAPI(caller);
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_Save1");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        //Wait for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //Wait for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_GoToOverview");
        //Wait for content load
        caller.pause("5000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("3000");
        caller.type("Browse_Doc.tf_DocName",param_DocName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocName);
        //verify whether goes to  edit document page
        //Wait for content load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        //select URL
        caller.click("Browse_Doc.rdo_URL");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("3000");
        //Verify required field warning
        caller.checkElementPresent("Browse_Doc.ele_lblRequiredFieldWarning",false,"");
        //Wait for content load
        caller.pause("3000");
        //select file
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.checkElementPresent("Browse_Doc.ele_lblFileUploadingNullMessage",false,"");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_OkPopUp");
        //Wait for content load
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_165.
     */
    public final static void APIM_165(final SeleniumTestBase caller, final String param_DocName7, final String param_editContent2, final String param_APIName, final String param_APIVersion, final String param_serverName, final String param_usernameStore, final String param_passwordStore, final String param_storeURL, final String param_publisherURL) throws Exception {
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //wait for page load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.type("Browse_Doc.tf_DocName",param_DocName7);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_DocName7,false,"");
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_DocName7);
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.pause("4000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_APIVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.tf_EditContent1",false,"");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent2);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","5000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_DocName7,false,"");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_HowTo");
        caller.pause("6000");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_DocName7,false,"");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_DocName7);
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.checkElementPresent("APIStoreDocumentation.ele_documentViewText","param_text_PARAM:" + param_editContent2 + "_PARAM," + "param_docName_PARAM:" + param_DocName7,false,"");
        caller.pause("6000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");	
    }
    /**
     *  Business component APIM_121.
     */
    public final static void APIM_121(final SeleniumTestBase caller, final String param_APIName, final String param_OtherTypeDoc1, final String param_OtherTypeDoc2, final String param_OtherTypeDoc3, final String param_OtherName, final String param_URL1, final String param_DocLocationOtherType, final String param_serverName, final String param_storeURL, final String param_Storeusername, final String param_Storepassword, final String param_PublisherURL) throws Exception {
        //APIM-121: Check whether documents of type other get deleted successfully.
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_OtherTypeDoc1);
        caller.click("Browse_Doc.rdo_Other");
        caller.type("Browse_Doc.tf_Other",param_OtherName);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_DocName",param_OtherTypeDoc2);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Other");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_Other",param_OtherName);
        caller.click("Browse_Doc.rdo_URL");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_URL1);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("3000");
        caller.type("Browse_Doc.tf_DocName",param_OtherTypeDoc3);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Other");
        caller.type("Browse_Doc.tf_Other",param_OtherName);
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_BrowseFile",param_DocLocationOtherType);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("4000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_OtherTypeDoc1);
        //Wait for content load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_OtherTypeDoc1,false,"");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("3000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_OtherTypeDoc1,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("5000");
        Common.bc_APIStoreLogin(caller, param_Storeusername,param_Storepassword);
        //Wait for content load
        caller.pause("4000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Wait for content load
        caller.pause("2000");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_OtherTypeDoc1,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_OtherTypeDoc2);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_OtherTypeDoc2,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_OtherTypeDoc2,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_OtherTypeDoc2,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_OtherTypeDoc3);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_OtherTypeDoc3,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_OtherTypeDoc3,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("3000");
        caller.checkObjectProperty("APIStoreDocumentation.lnk_Other","ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.pause("2000");	
    }
    /**
     *  Business component APIM_120.
     */
    public final static void APIM_120(final SeleniumTestBase caller, final String param_APIName, final String param_SupportForumDoc1, final String param_SupportForumDoc2, final String param_URL2, final String param_docLocationSupport, final String param_serverName, final String param_storeURL, final String param_PublisherURL) throws Exception {
        //APIM-120: Check whether documents of type 'support forum' get deleted successfully.
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_SupportForumDoc1);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_SupportForum");
        caller.type("Browse_Doc.tf_URL",param_URL2);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_SupportForumDoc2);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_SupportForum");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_File");
        caller.type("Browse_Doc.tf_BrowseFile",param_docLocationSupport);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_SupportForumDoc1);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_SupportForumDoc1,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_SupportForumDoc1,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_SupportForumDoc1,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_SupportForumDoc2);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_SupportForumDoc2,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_SupportForumDoc2,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkObjectProperty("APIStoreDocumentation.lnk_SupportForum","ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_422.
     */
    public final static void APIM_422(final SeleniumTestBase caller, final String param_UserName, final String param_Password, final String param_publisherURL, final String param_APIName, final String param_APIVersion, final String param_APIImagePath, final String param_tagName, final String param_verbGet, final String param_verbPost, final String param_verbPut, final String param_verbOption, final String param_ProductionEndpointUrl, final String param_Application, final String param_ApplicationUser, final String param_ApplicationAndApplicationUser, final String param_None, final String param_newVersion) throws Exception {
        //APIM_422 Testcase
        Common.bc_Login_APIPublisher(caller, param_UserName,param_Password,param_publisherURL);
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        /*
        SetVariable
         name=APIName
         type=String
         paramValue="api"+caller.generateData("int",2)
        */
        caller.type("APIPublisherAdd.tf_APIName",param_APIName);
        //Type API contest
        String APIcontest = "api"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //Type valid image path
        caller.type("APIPublisherAdd.btn_BrowseImage",param_APIImagePath);
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("6000");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbGet);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPost);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPut);
        caller.click("APIPublisherBrowse.ele_lblMore");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbOption);
        caller.pause("2000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("1000");
        caller.click("APIPublisherBrowse.btn_Yes");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.pause("1000");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndpointUrl);
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_NextManage");
        Common.bc_SelectTiers(caller);
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ResourceLevelType","param_verbMethod_PARAM:" + param_verbGet);
        caller.pause("500");
        caller.select("APIPublisherBrowse.ele_ddResourseLevelType",param_Application);
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_right");
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbGet + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_Application,false,"");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ResourceLevelType","param_verbMethod_PARAM:" + param_verbPost);
        caller.pause("500");
        caller.select("APIPublisherBrowse.ele_ddResourseLevelType",param_ApplicationUser);
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_right");
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbPost + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationUser,false,"");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ResourceLevelType","param_verbMethod_PARAM:" + param_verbPut);
        caller.pause("500");
        caller.select("APIPublisherBrowse.ele_ddResourseLevelType",param_ApplicationAndApplicationUser);
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_right");
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbPut + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationAndApplicationUser,false,"");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ResourceLevelType","param_verbMethod_PARAM:" + param_verbOption);
        caller.pause("500");
        caller.select("APIPublisherBrowse.ele_ddResourseLevelType",param_None);
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_right");
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbOption + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_None,false,"");
        caller.click("APIPublisherBrowse.lnk_ResourceLevelType","param_verbMethod_PARAM:" + param_verbOption);
        caller.pause("500");
        caller.select("APIPublisherBrowse.ele_ddResourseLevelType",param_ApplicationUser);
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_right");
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbOption + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationUser,false,"");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        caller.pause("1000");
        caller.click("APIPublisherBrowse.btn_Close");
        caller.pause("1000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_APIVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.pause("2000");
        caller.click("Browse_Overview.btn_CreateNewVersion");
        caller.pause("500");
        caller.type("Browse_Overview.tf_ToVersion",param_newVersion);
        caller.click("Browse_Overview.btn_Done");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.ele_lblApiNamewithVersion","param_ApiName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion,false,"");
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherHome.ele_lblApiNamewithVersion","param_version_PARAM:" + param_newVersion + "_PARAM," + "param_ApiName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbGet + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_Application,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbPost + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationUser,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbPut + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationAndApplicationUser,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbOption + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationUser,false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_422 Successfully Passed");	
    }
    /**
     *  Business component APIM_119.
     */
    public final static void APIM_119(final SeleniumTestBase caller, final String param_PublicForumDoc1, final String param_PublicForumDoc2, final String param_URL3, final String param_docLocationPublic, final String param_serverName, final String param_storeURL, final String param_APIName, final String param_PublisherURL) throws Exception {
        //APIM-119: Check whether documents of type 'public forum' get deleted successfully.
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_DocName",param_PublicForumDoc1);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_PublicForum");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_URL3);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_DocName",param_PublicForumDoc2);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_PublicForum");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_BrowseFile",param_docLocationPublic);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_PublicForumDoc1);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_PublicForumDoc1,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_PublicForumDoc1,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_PublicForumDoc1,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_PublicForumDoc2);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_PublicForumDoc2,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_PublicForumDoc2,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.lnk_PublicForum","ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_196.
     */
    /**
     *  Business component APIM_196.
     */
    public final static void APIM_196(final SeleniumTestBase caller) throws Exception {
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblAddApplication",false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_ApplicationName",false,"");
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_CallBackURL",false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_Discription",false,"");
        caller.checkElementPresent("APIStoreMyApllication.btn_AddApplication",false,"");	
    }
    /**
     *  Business component APIM_118.
     */
    public final static void APIM_118(final SeleniumTestBase caller, final String param_SampleDoc1, final String param_SampleDoc2, final String param_SampleDoc3, final String param_URL4, final String param_DocLocationSample, final String param_serverName, final String param_storeURL, final String param_PublisherURL, final String param_APIName) throws Exception {
        //APIM-118: Check whether documents of type 'public forum' get deleted successfully.
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_DocName",param_SampleDoc1);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_SampleDoc2);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_URL");
        //Wait for content load
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_URL4);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_DocName",param_SampleDoc3);
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_BrowseFile",param_DocLocationSample);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_SampleDoc1);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_SampleDoc1,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_SampleDoc1,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_Samples");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_SampleDoc1,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_SampleDoc2);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_SampleDoc2,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_SampleDoc2,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_Samples");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_SampleDoc2,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_SampleDoc3);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_SampleDoc3,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_SampleDoc3,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.lnk_Samples","ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_117.
     */
    public final static void APIM_117(final SeleniumTestBase caller, final String param_howToDoc1, final String param_howToDoc2, final String param_howToDoc3, final String param_URL5, final String param_DocLocationHowTo, final String param_serverName, final String param_storeURL, final String param_APIName, final String param_PublisherURL) throws Exception {
        //APIM-117: Check whether documents of type how to get deleted successfully.
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_DocName",param_howToDoc1);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_DocName",param_howToDoc2);
        caller.click("Browse_Doc.rdo_URL");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_URL5);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",param_howToDoc3);
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_BrowseFile",param_DocLocationHowTo);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_howToDoc1);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_howToDoc1,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_howToDoc1,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_howToDoc1,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_howToDoc2);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_howToDoc2,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_howToDoc2,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_howToDoc2,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + param_howToDoc3);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + param_howToDoc3,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_DocName_PARAM:" + param_howToDoc3,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + param_howToDoc3,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_195.
     */
    public final static void APIM_195(final SeleniumTestBase caller, final String param_storeURL, final String param_serverName, final String param_username, final String param_password) throws Exception {
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.pause("3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.pause("3000");
        if(caller.checkElementPresent("APIStoreHome.lnk_MyApplication")){
        caller.click("APIStoreHome.lnk_MyApplication");
        }
        caller.click("APIStoreHome.lnk_iconMyApplication");
        caller.pause("1000");
        caller.type("APIStoreHome.tf_username",param_username);
        caller.pause("2000");
        caller.type("APIStoreHome.tf_password",param_password);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_login");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblAddApplication",false,"");
        caller.writeToReport("APIM_195 Succesfully Passed");	
    }
    /**
     *  Business component APIM_200.
     */
    public final static void APIM_200(final SeleniumTestBase caller, final String param_InvalidAppName, final String param_ThrottlingTier, final String param_CallBackURL, final String param_Description, final String param_ValidName2, final String param_ValidAppName3) throws Exception {
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("1000");
        //check for the content load correctly
        caller.checkElementPresent("APIStoreMyApllication.ele_lblAddApplication",false,"");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMyApllication.tf_ApplicationName",false,"");
        caller.type("APIStoreMyApllication.tf_ApplicationName",param_InvalidAppName);
        caller.pause("1000");
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_CallBackURL);
        caller.type("APIStoreMyApllication.tf_Discription",param_Description);
        caller.pause("2000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("1000");
        //wait for error load
        caller.checkElementPresent("APIStoreMyApllication.ele_lblInvalidCharacters",false,"");
        caller.pause("1000");
        caller.checkElementPresent("APIStoreMyApllication.tf_ApplicationName",false,"");
        caller.type("APIStoreMyApllication.tf_ApplicationName",param_ValidAppName3);
        caller.pause("1000");
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_CallBackURL);
        caller.type("APIStoreMyApllication.tf_Discription",param_Description);
        caller.pause("2000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("50");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblSuccessAddMesage",false,"");
        caller.pause("2000");	
    }
    /**
     *  Business component APIM_202.
     */
    public final static void APIM_202(final SeleniumTestBase caller, final String param_ApplicationName, final String param_ThrottlingTier, final String param_callBackUrl, final String param_descriprion, final String param_ApplicationWithSubscription) throws Exception {
        caller.click("APIStoreHome.lnk_APIs");
        caller.pause("1000");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("1000");
        caller.type("APIStoreMyApllication.tf_ApplicationName",param_ApplicationName);
        caller.fireEvent("KEY%key=ctrl+a","1000");
        caller.fireEvent("KEY%key=ctrl+c","1000");
        /*
        Select
         object=APIStoreMyApllication.ele_ddThrottlingTier
         selectLocator=@param_ThrottlingTier
        */
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_callBackUrl);
        caller.pause("1000");
        caller.type("APIStoreMyApllication.tf_Discription",param_descriprion);
        caller.pause("1000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_MySubcription");
        caller.pause("2000");
        caller.select("APIStoreMySubcription.ele_ddApplicationWithSubscription",param_ApplicationName);
        caller.click("APIStoreMySubcription.btn_generateKeyProduction");
        caller.pause("6000");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerKeyProduction",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerSecretTokenProduction",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblAccessTokenProduction",false,"");
        caller.pause("1000");
        caller.click("APIStoreMySubcription.btn_generateKeyProduction");
        caller.pause("6000");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerKeySandbox",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerSecretTokenSandBox",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblAccessTokenSandBox",false,"");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("2000");
        caller.click("APIStoreMyApllication.lnk_DeleteApplication","param_ApplicationName_PARAM:" + param_ApplicationName);
        caller.pause("1000");
        caller.click("APIStoreMyApllication.btn_yes");
        caller.pause("2000");
        caller.checkObjectProperty("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_ApplicationName,"ELEMENTPRESENT","false",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_202 is successfully Passed");	
    }
    /**
     *  Business component APIM_204.
     */
    public final static void APIM_204(final SeleniumTestBase caller, final String param_ApplicationName) throws Exception {
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("2000");
        caller.checkObjectProperty("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_ApplicationName,"ELEMENTPRESENT","false",false,"");
        caller.click("APIStoreHome.lnk_MySubcription");
        caller.pause("2000");
        caller.click("APIStoreMySubcription.btn_ApplicationWithSubscription");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+v","3000");
        caller.checkObjectProperty("APIStoreMySubcription.ele_lblddApplicationNames","param_ApplicationName_PARAM:" + param_ApplicationName,"ELEMENTPRESENT","false",false,"");
        caller.selectFrame("APIStoreMyApllication.frm_parent");
        caller.writeToReport("APIM_204 Successfully passed");	
    }
    /**
     *  Business component APIM_201.
     */
    /**
     *  Business component APIM_201.
     */
    public final static void APIM_201(final SeleniumTestBase caller) throws Exception {
        caller.clickAt("APIStoreHome.lnk_APIs","0,0");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("3000");
        caller.clickAt("APIStoreMyApllication.btn_UrlQuestionMark","0,0");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblCallbackUrlHelp",false,"");
        caller.writeToReport("APIM 201 Succesfully passed.");	
    }
    /**
     *  Business component APIM_206.
     */
    public final static void APIM_206(final SeleniumTestBase caller, final String param_AppName4, final String param_ThrottlingTier, final String param_CallBackURL, final String param_Description) throws Exception {
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("1000");
        //check for the content load correctly
        caller.checkElementPresent("APIStoreMyApllication.ele_lblAddApplication",false,"");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMyApllication.tf_ApplicationName",false,"");
        caller.type("APIStoreMyApllication.tf_ApplicationName",param_AppName4);
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_CallBackURL);
        caller.type("APIStoreMyApllication.tf_Discription",param_Description);
        caller.pause("2000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblSuccessAddMesage",false,"");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_AppName4,false,"");
        caller.checkElementPresent("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + param_AppName4,false,"");
        caller.click("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + param_AppName4);
        caller.pause("1000");
        caller.checkElementPresent("APIStoreMyApllication.tf_EditName","param_AppName_PARAM:" + param_AppName4,false,"");
        caller.checkObjectProperty("APIStoreMyApllication.ele_ddEditTier","param_AppName_PARAM:" + param_AppName4,"PROPERTYPRESENT","disabled|false",false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_EditCallBackURL","param_AppName_PARAM:" + param_AppName4,false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_EditDescription","param_AppName_PARAM:" + param_AppName4,false,"");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMyApllication.btn_EditCancel","param_AppName_PARAM:" + param_AppName4,false,"");
        caller.click("APIStoreMyApllication.btn_EditCancel","param_AppName_PARAM:" + param_AppName4);
        caller.pause("500");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_AppName4,false,"");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_205.
     */
    public final static void APIM_205(final SeleniumTestBase caller, final String param_AppName4, final String param_AppName5, final String param_EditTier, final String param_EditCallBackURL, final String param_EditDescription) throws Exception {
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("1000");
        //check for the content load correctly
        caller.checkElementPresent("APIStoreMyApllication.ele_lblAddApplication",false,"");
        caller.checkElementPresent("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + param_AppName4,false,"");
        caller.click("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + param_AppName4);
        caller.pause("1000");
        caller.checkElementPresent("APIStoreMyApllication.tf_EditName","param_AppName_PARAM:" + param_AppName4,false,"");
        caller.checkObjectProperty("APIStoreMyApllication.ele_ddEditTier","param_AppName_PARAM:" + param_AppName4,"PROPERTYPRESENT","disabled|false",false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_EditCallBackURL","param_AppName_PARAM:" + param_AppName4,false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_EditDescription","param_AppName_PARAM:" + param_AppName4,false,"");
        caller.pause("2000");
        caller.type("APIStoreMyApllication.tf_EditName","param_AppName_PARAM:" + param_AppName4,param_AppName5);
        caller.pause("1000");
        caller.click("APIStoreMyApllication.btn_EditSave","param_AppName_PARAM:" + param_AppName4);
        caller.pause("500");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_AppName5,false,"");
        caller.pause("1000");
        caller.click("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + param_AppName5);
        caller.pause("2000");
        caller.click("APIStoreMyApllication.ele_ddEditTier","param_AppName_PARAM:" + param_AppName5);
        caller.pause("500");
        caller.select("APIStoreMyApllication.ele_ddEditTier","param_AppName_PARAM:" + param_AppName5,param_EditTier);
        caller.pause("1000");
        caller.click("APIStoreMyApllication.btn_EditSave","param_AppName_PARAM:" + param_AppName5);
        caller.pause("2000");
        /*
        CheckObjectProperty
         object=APIStoreMyApllication.ele_ddEditTier
         param_AppName=@param_AppName5
         propertyname=ELEMENTPRESENT
         expectedValue=@selectedValue
         stopOnFailure=false
         customErrorMessage=
        */
        caller.pause("3000");
        caller.click("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + param_AppName5);
        caller.checkElementPresent("APIStoreMyApllication.tf_EditCallBackURL","param_AppName_PARAM:" + param_AppName5,false,"");
        caller.type("APIStoreMyApllication.tf_EditCallBackURL","param_AppName_PARAM:" + param_AppName5,param_EditCallBackURL);
        caller.pause("1000");
        caller.click("APIStoreMyApllication.btn_EditSave","param_AppName_PARAM:" + param_AppName5);
        caller.checkElementPresent("APIStoreMyApllication.ele_lblCallBackURL","param_AppName_PARAM:" + param_AppName5 + "_PARAM," + "param_CallBackURL_PARAM:" + param_EditCallBackURL,false,"");
        caller.pause("2000");
        caller.click("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + param_AppName5);
        caller.checkElementPresent("APIStoreMyApllication.tf_EditDescription","param_AppName_PARAM:" + param_AppName5,false,"");
        caller.type("APIStoreMyApllication.tf_EditDescription","param_AppName_PARAM:" + param_AppName5,param_EditDescription);
        caller.click("APIStoreMyApllication.btn_EditSave","param_AppName_PARAM:" + param_AppName5);
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblDescription","param_AppName_PARAM:" + param_AppName5 + "_PARAM," + "Description_PARAM:" + param_EditDescription,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_198.
     */
    /**
     *  Business component APIM_198.
     */
    public final static void APIM_198(final SeleniumTestBase caller) throws Exception {
        /*
        NavigateToURL
         url=APIStoreLogin
         param_storeURL=@param_storeURL
         ms=3000
        Click
         object=APIStoreHome.img_APIStoreAvailableServer
         param_serverName=@param_serverName
        Call
         businessComponent=Common.bc_APIStoreLogin
         param_username=@param_usernameStore
         param_password=@param_passwordStore
        //wait for page load
        Pause
         ms=3000
        */
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("6000");
        caller.checkElementPresent("APIStoreMyApllication.tf_ApplicationName",false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.pause("3000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("1000");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblNameRequired",false,"");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_197.
     */
    public final static void APIM_197(final SeleniumTestBase caller, final String param_ApplicationName, final String param_ThrottlingTier, final String param_CallBackURL, final String param_Description) throws Exception {
        caller.pause("4000");
        caller.checkElementPresent("APIStoreMyApllication.tf_ApplicationName",false,"");
        caller.type("APIStoreMyApllication.tf_ApplicationName",param_ApplicationName);
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_CallBackURL);
        caller.type("APIStoreMyApllication.tf_Discription",param_Description);
        caller.pause("1000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("100");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblSuccessAddMesage",false,"");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_ApplicationName,false,"");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblCallBackURL","param_AppName_PARAM:" + param_ApplicationName + "_PARAM," + "param_CallBackURL_PARAM:" + param_CallBackURL,false,"");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblDescription","param_AppName_PARAM:" + param_ApplicationName + "_PARAM," + "Description_PARAM:" + param_Description,false,"");
        caller.pause("4000");	
    }
    /**
     *  Business component APIM_199.
     */
    public final static void APIM_199(final SeleniumTestBase caller, final String param_ThrottlingTier, final String param_CallBackURL, final String param_Description, final String param_ApplicationName2) throws Exception {
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("1000");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblAddApplication",false,"");
        caller.pause("2000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblNameRequired",false,"");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_CallBackURL);
        caller.type("APIStoreMyApllication.tf_Discription",param_Description);
        caller.pause("2000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("100");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblNameRequired",false,"");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMyApllication.tf_ApplicationName",false,"");
        caller.type("APIStoreMyApllication.tf_ApplicationName",param_ApplicationName2);
        caller.pause("1000");
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_CallBackURL);
        caller.type("APIStoreMyApllication.tf_Discription",param_Description);
        caller.pause("2000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("50");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblSuccessAddMesage",false,"");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_207.
     */
    public final static void APIM_207(final SeleniumTestBase caller, final String param_AppName5, final String param_TokenValue1, final String param_TokenValue2) throws Exception {
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_MySubcription");
        caller.pause("3000");
        caller.select("APIStoreMySubcription.ele_ddApplicationWithSubscription",param_AppName5);
        //wait for page load
        caller.pause("6000");
        if(caller.checkElementPresent("APIStoreMySubcription.ele_lblAllowedDomains")){
        caller.doubleClick("APIStoreMySubcription.ele_lblKeysProduction");
        } else {
        caller.click("APIStoreMySubcription.ele_lblKeyProduction");
        }
        caller.pause("5000");
        caller.checkElementPresent("APIStoreMySubcription.tf_TokenValidity",false,"");
        caller.type("APIStoreMySubcription.tf_TokenValidity",param_TokenValue1);
        caller.click("APIStoreMySubcription.btn_generateKeyProduction");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerKeyProduction",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerSecretTokenProduction",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblAccessTokenProduction",false,"");
        //wait for load the page
        caller.pause("5000");
        caller.pause("500");
        caller.checkElementPresent("APIStoreMySubcription.tf_TokenValidity2",false,"");
        caller.type("APIStoreMySubcription.tf_TokenValidity2",param_TokenValue2);
        caller.pause("5000");
        caller.checkElementPresent("APIStoreMySubcription.btn_GenarateKeySandBox",false,"");
        caller.pause("2000");
        caller.pause("1000");
        caller.click("APIStoreMySubcription.btn_generateKeyProduction");
        caller.pause("6000");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerKeySandbox",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerSecretTokenSandBox",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblAccessTokenSandBox",false,"");
        caller.pause("6000");	
    }
    /**
     *  Business component APIM_350.
     */
    public final static void APIM_350(final SeleniumTestBase caller, final String param_UserName, final String param_Password, final String param_publisherURL, final String param_APIName) throws Exception {
        //APIM-350: User Search added API by name
        Common.bc_Login_APIPublisher(caller, param_UserName,param_Password,param_publisherURL);
        //search for created API
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //Verify API is searched successfully
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_351.
     */
    public final static void APIM_351(final SeleniumTestBase caller, final String param_APIProvider, final String param_APIName, final String param_searchNameProvider) throws Exception {
        //APIM-351: User Search added API by provider name
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_searchNameProvider+param_APIProvider);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //Verif API is Search properly
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");
        //APIM-367: Successfully logged in user should be able search with keywords that contains only part of the provider name
        //APIM_367  combined to here
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_searchNameProvider+param_APIProvider);
        //wait for content load
        caller.pause("2000");
        //Delete some partof the user name
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.click("APIPublisherHome.btn_Search");
        //wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_352.
     */
    public final static void APIM_352(final SeleniumTestBase caller, final String param_searchversion, final String param_APIVersion, final String param_APIName) throws Exception {
        //APIM-352: User Search added API by api version
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_searchversion+param_APIVersion);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //verify API is Visible
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_353.
     */
    public final static void APIM_353(final SeleniumTestBase caller, final String param_searchContext, final String param_APIContext, final String param_APIName) throws Exception {
        //APIM-353: User should be able to search added API by context
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_searchContext+param_APIContext);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //Delete some partof the context
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //verify API is Visible
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_354.
     */
    public final static void APIM_354(final SeleniumTestBase caller, final String param_APINameUpperCase, final String param_APIName, final String param_APINameLowerCase) throws Exception {
        //APIM-354: User search for API with upper case name
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APINameUpperCase);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");
        //APIM-355: User search for API with lower case name is also combined here as rquest
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APINameLowerCase);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //verify API is Visible
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_355.
     */
    public final static void APIM_355(final SeleniumTestBase caller, final String param_APINameLower, final String param_APIName) throws Exception {
        //APIM-355: User search for API with lower case name
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        //Type API name lowercase
        caller.type("APIPublisherHome.tf_APISearch",param_APINameLower);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //verify API is Visible
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_356.
     */
    public final static void APIM_356(final SeleniumTestBase caller, final String param_statusCreated, final String param_statusPublished, final String param_statusBlocked, final String param_statusRetired, final String param_statusPrototyped, final String param_statusDeprecated, final String param_APIName, final String param_searchStatus) throws Exception {
        //APIM-356: Successfully logged in user should be able search API by status
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("3000");
        //click on API
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //change the API status CREATED
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //wait for content load
        caller.pause("2000");
        //Serch for status created
        caller.select("APIPublisherBrowse.ele_ddState",param_statusCreated);
        //wait for content load
        caller.pause("2000");
        caller.click("Browse_Lifecycle.btn_Update");
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.type("APIPublisherHome.tf_APISearch",param_searchStatus+param_statusCreated);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");
        //click on API
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //change the API status BLOCKED
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //Serch for status blocked
        caller.select("APIPublisherBrowse.ele_ddState",param_statusBlocked);
        caller.pause("2000");
        caller.click("Browse_Lifecycle.btn_Update");
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.type("APIPublisherHome.tf_APISearch",param_searchStatus+param_statusBlocked);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");
        //click on API
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //change the API status RETIRED
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //Serch for status published
        caller.select("APIPublisherBrowse.ele_ddState",param_statusRetired);
        caller.pause("2000");
        caller.click("Browse_Lifecycle.btn_Update");
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.type("APIPublisherHome.tf_APISearch",param_searchStatus+param_statusRetired);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");
        //click on API
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //change the API status PROTOTYPED
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //Serch for status Prototyped
        caller.select("APIPublisherBrowse.ele_ddState",param_statusPrototyped);
        caller.pause("2000");
        caller.click("Browse_Lifecycle.btn_Update");
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.type("APIPublisherHome.tf_APISearch",param_searchStatus+param_statusPrototyped);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");
        //click on API
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //change the API status DEPERECATED
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //Serch for status deprecated
        caller.select("APIPublisherBrowse.ele_ddState",param_statusDeprecated);
        caller.pause("2000");
        caller.click("Browse_Lifecycle.btn_Update");
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.type("APIPublisherHome.tf_APISearch",param_searchStatus+param_statusDeprecated);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");
        //click on API
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //change the API status PUBLISHED
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //Serch for status published
        caller.select("APIPublisherBrowse.ele_ddState",param_statusPublished);
        caller.pause("2000");
        caller.click("Browse_Lifecycle.btn_Update");
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.type("APIPublisherHome.tf_APISearch",param_searchStatus+param_statusPublished);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //verify API is Visible
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_357.
     */
    public final static void APIM_357(final SeleniumTestBase caller, final String param_searchDiscription, final String param_Description, final String param_APIName) throws Exception {
        //APIM-357: Successfully logged in user should be able search API by description
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        //Type description
        caller.type("APIPublisherHome.tf_APISearch",param_searchDiscription+param_Description);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //verify API is Visible
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_358.
     */
    public final static void APIM_358(final SeleniumTestBase caller, final String param_searchSubContext, final String param_SubContext, final String param_APIName) throws Exception {
        //APIM-358: Successfully logged in user should be able search API by subcontext
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        //Type subcontext
        caller.type("APIPublisherHome.tf_APISearch",param_searchSubContext+param_SubContext);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //verify API is Visible
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_367.
     */
    public final static void APIM_367(final SeleniumTestBase caller, final String param_searchProvider, final String param_partOfProvider, final String param_APIName) throws Exception {
        //APIM-367: Successfully logged in user should be able search with keywords that contains only part of the provider name
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        //Type part of provider
        caller.type("APIPublisherHome.tf_APISearch",param_searchProvider+param_partOfProvider);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //verify API is Visible
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_368.
     */
    public final static void APIM_368(final SeleniumTestBase caller, final String param_searchContext, final String param_partOfContext, final String param_APIName) throws Exception {
        //APIM-368: Successfully logged in user should be able search with keywords that contains only part of the conte
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        //Type part of context
        caller.type("APIPublisherHome.tf_APISearch",param_searchContext+param_partOfContext);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //verify API is Visible
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_384.
     */
    public final static void APIM_384(final SeleniumTestBase caller, final String param_APIName, final String param_APIStatus, final String param_APIVersion, final String param_APICreater, final String param_APIUsers) throws Exception {
        //APIM-384: User should be able to see all API's in all stage on browse page
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        //Verify API version
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVersionAndUser","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion + "_PARAM," + "param_creater_PARAM:" + param_APICreater,false,"");
        //API status verify
        caller.checkElementPresent("APIPublisherBrowse.ele_lblAPILifeCycleStatus","param_version_PARAM:" + param_APIVersion + "_PARAM," + "param_status_PARAM:" + param_APIStatus,false,"");
        //Verify user Count
        caller.checkElementPresent("APIPublisherBrowse.ele_lblUsers","param_version_PARAM:" + param_APIVersion + "_PARAM," + "param_users_PARAM:" + param_APIUsers,false,"");
        //Verify delete icon
        caller.checkElementPresent("APIPublisherBrowse.btn_deleteAPI","APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_427.
     */
    public final static void APIM_427(final SeleniumTestBase caller, final String param_storeURL, final String param_serverName, final String param_usernamePublisher, final String param_passwordPublisher) throws Exception {
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        //Triying to log  to store with publisher user
        Common.bc_APIStoreLogin(caller, param_usernamePublisher,param_passwordPublisher);
        caller.pause("2000");
        //Verify user cannot log
        caller.checkElementPresent("APIStoreLogin.ele_lblLoggingErrorMessage",false,"");	
    }
    /**
     *  Business component APIM_404.
     */
    public final static void APIM_404(final SeleniumTestBase caller, final String param_Version, final String param_SearchVersion, final String param_APIName) throws Exception {
        //APIM-404:  User Search added API by api version
        caller.click("APIStoreHome.lnk_APIs");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        //Type version
        caller.type("APIStoreHome.tf_APISearchStore",param_SearchVersion+param_Version);
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        //verify API is Visible
        caller.checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_403.
     */
    public final static void APIM_403(final SeleniumTestBase caller, final String param_APIName) throws Exception {
        //APIM-403:  User Search added API by name
        caller.click("APIStoreHome.lnk_APIs");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",param_APIName);
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_402.
     */
    public final static void APIM_402(final SeleniumTestBase caller, final String param_SearchContext, final String param_Context, final String param_APIName) throws Exception {
        //APIM-402: (Tenant specific) User should be able to search added API by context
        caller.click("APIStoreHome.lnk_APIs");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",param_SearchContext+param_Context);
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_401.
     */
    public final static void APIM_401(final SeleniumTestBase caller, final String param_SearchNameUpper, final String param_APIName) throws Exception {
        //APIM-401: (Tenant specific) User search for API with upper case name
        caller.click("APIStoreHome.lnk_APIs");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",param_SearchNameUpper);
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_400.
     */
    public final static void APIM_400(final SeleniumTestBase caller, final String param_SearchNameLower, final String param_APIName) throws Exception {
        //APIM-400: (Tenant specific) User search for API with lower case name
        caller.click("APIStoreHome.lnk_APIs");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",param_SearchNameLower);
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_399.
     */
    public final static void APIM_399(final SeleniumTestBase caller, final String param_SearchDescription, final String param_Description, final String param_APIName) throws Exception {
        //APIM-399: (Tenant specific) Successfully logged in user should be able search API by description
        caller.click("APIStoreHome.lnk_APIs");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",param_SearchDescription+param_Description);
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_398.
     */
    public final static void APIM_398(final SeleniumTestBase caller, final String param_ProviderName, final String param_APIName, final String param_searchProvider) throws Exception {
        //APIM-398:  Successfully logged in user should be able search with keywords that contains only part of the provider name
        caller.type("APIStoreHome.tf_APISearchStore",param_searchProvider+param_ProviderName);
        //Delete part of context
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_106.
     */
    public final static void APIM_106(final SeleniumTestBase caller, final String param_UserNamePublisher, final String param_PasswordPublisher, final String param_publisherURL, final String param_DocSameAsApiVisibility, final String param_UserNamePublisherTwo, final String param_PasswordPublisherTwo, final String param_ApiVersion, final String param_serverNameTenantOne, final String param_serverNameTenantTwo, final String param_usernameStoreTwo, final String param_passwordStoreTwo, final String param_fileToUpload, final String param_DownloadFilePath, final String param_sourceUrl, final String param_APIName, final String param_usernameStoreOne, final String param_passwordStoreOne, final String param_sourceUrlTwo, final String param_storeURL, final String param_EditApiVisibility, final String param_downImage2) throws Exception {
        //Check document visibility when it's given same as api visibility when api visibility = public
        //Login into the publisher
        Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
        //Search for API Name
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.lnk_Browse",false,"");
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.pause("2000");
        caller.click("APIPublisherHome.btn_Search");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Edit the visibility level
        caller.checkElementPresent("APIPublisherBrowse.lnk_Edit",false,"");
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.pause("2000");
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_EditApiVisibility);
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Save");
        caller.pause("3000");
        //Check for API
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.pause("2000");
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("3000");
        //check the visibility of ad new document feilds
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.checkElementPresent("Browse_Doc.ele_ddVisibility",false,"");
        caller.pause("5000");
        String varDocOne = "Doc"+caller.generateData("int",4);
        //Fill the fields
        caller.type("Browse_Doc.tf_DocName",varDocOne);
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("2000");
        caller.select("Browse_Doc.ele_ddVisibility",param_DocSameAsApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check added document
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocOne,false,"");
        caller.pause("2000");
        //Logout first user
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        //Login another user
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //click login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        //Search for the API
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("2000");
        //Wait for content load
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("2000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocOne,false,"");
        caller.pause("2000");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocOne);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_ApiVersion,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocOne,false,"");
        //Logout second user
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("4000");
        //Goto the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        //Check document without logging
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocOne,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocOne,false,"");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocOne);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocOne,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        //Check the document after user logging.
        Common.bc_APIStoreLogin(caller, param_usernameStoreOne,param_passwordStoreOne);
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //wait for page load
        caller.click("APIStoreDocumentation.lnk_HowTo");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocOne,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocOne,false,"");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocOne);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocOne,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStoreOne);
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("4000");
        //Check for another tenant
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantTwo);
        Common.bc_APIStoreLogin(caller, param_usernameStoreTwo,param_passwordStoreTwo);
        caller.checkElementPresent("APIStoreHome.lnk_PublicApiStore",false,"");
        caller.click("APIStoreHome.lnk_PublicApiStore");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocOne,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocOne,false,"");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocOne);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocOne,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStoreTwo);
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("3000");
        //adding Sample SDK API Doc
        //Log into the publisher
        caller.pause("4000");
        Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
        //Search for API Name
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //Search for API name
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("2000");
        //Adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocTwo = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocTwo);
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.rdo_SampleAndSDK",false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_File");
        caller.pause("5000");
        caller.type("Browse_Doc.tf_BrowseFile",param_fileToUpload);
        caller.pause("4000");
        caller.select("Browse_Doc.ele_ddVisibility",param_DocSameAsApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check for added document
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + varDocTwo,false,"");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocTwo,false,"");
        caller.pause("2000");
        //Logout first user
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //click login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Check for added document
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + varDocTwo,false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocTwo);
        caller.pause("6000");
        String downImagePopup1 = param_downImage2;
        if(caller.checkImagePresent(downImagePopup1,false)){
        caller.fireEvent("KEY%key=alt+s","2000");
        caller.fireEvent("KEY%key=alt+a","2000");
        caller.fireEvent("KEY%key=\n","1000");
        }
        caller.checkFileInfo(param_DownloadFilePath,"EXIST",false,"");
        //Logout second user
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("4000");
        //Goto the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        //Check document without logging into the store
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Samples");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocTwo,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocTwo,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocTwo);
        caller.checkFileInfo(param_DownloadFilePath,"EXIST",false,"");
        caller.pause("3000");
        //Check document after loging into the store
        Common.bc_APIStoreLogin(caller, param_usernameStoreOne,param_passwordStoreOne);
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //wait for page load
        caller.click("APIStoreDocumentation.lnk_Samples");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocTwo,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocTwo,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocTwo);
        caller.checkFileInfo(param_DownloadFilePath,"EXIST",false,"");
        caller.pause("3000");
        //Check for another tenant
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStoreOne);
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("4000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantTwo);
        Common.bc_APIStoreLogin(caller, param_usernameStoreTwo,param_passwordStoreTwo);
        caller.checkElementPresent("APIStoreHome.lnk_PublicApiStore",false,"");
        caller.click("APIStoreHome.lnk_PublicApiStore");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Samples");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocTwo,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocTwo,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocTwo);
        caller.checkFileInfo(param_DownloadFilePath,"EXIST",false,"");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStoreTwo);
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("3000");
        //Adding Public Forum Type Doc
        caller.pause("4000");
        Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
        //Search for API Name
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocThree = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocThree);
        caller.checkElementPresent("Browse_Doc.rdo_PublicForum",false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.pause("4000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrl);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_DocSameAsApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + varDocThree,false,"");
        caller.pause("2000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        //Check document with another user
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //click login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("2000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + varDocThree,false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + varDocThree);
        //wait for load
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("4000");
        //Goto the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.pause("3000");
        //Check the document without logging into the store
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocThree,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocThree + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrl,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocThree + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrl);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Check the document after login into the store
        Common.bc_APIStoreLogin(caller, param_usernameStoreOne,param_passwordStoreOne);
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //wait for page load
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocThree,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocThree + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrl,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocThree + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrl);
        caller.pause("8000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        caller.pause("3000");
        //Check using  another tenant
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStoreOne);
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("4000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantTwo);
        Common.bc_APIStoreLogin(caller, param_usernameStoreTwo,param_passwordStoreTwo);
        caller.checkElementPresent("APIStoreHome.lnk_PublicApiStore",false,"");
        caller.click("APIStoreHome.lnk_PublicApiStore");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocThree,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocThree + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrl,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocThree + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrl);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStoreTwo);
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("4000");
        //Adding Doc  Support forum type
        caller.pause("3000");
        Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
        //Search for API Name
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //Adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocFour = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocFour);
        caller.checkElementPresent("Browse_Doc.rdo_SupportForum",false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_SupportForum");
        caller.pause("3000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrlTwo);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_DocSameAsApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblSupportForum","param_docName_PARAM:" + varDocFour,false,"");
        //Logout first publisher user
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        //Login second publisher user
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("2000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_SupportForum","param_docName_PARAM:" + varDocFour,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + varDocFour);
        //wait
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        //Logout the second user
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("5000");
        //Goto the Store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocFour,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocFour + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlTwo,false,"");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocFour + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlTwo);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Login to the stote to check the document
        Common.bc_APIStoreLogin(caller, param_usernameStoreOne,param_passwordStoreOne);
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //wait for page load
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocFour,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocFour + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlTwo,false,"");
        caller.pause("4000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocFour + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlTwo);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        caller.pause("3000");
        //Check for another tenant
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStoreOne);
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("4000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.pause("3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantTwo);
        Common.bc_APIStoreLogin(caller, param_usernameStoreTwo,param_passwordStoreTwo);
        caller.checkElementPresent("APIStoreHome.lnk_PublicApiStore",false,"");
        caller.click("APIStoreHome.lnk_PublicApiStore");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Check the added document
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocFour,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocFour + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlTwo,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocFour + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlTwo);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStoreTwo);
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("3000");
        //Adding Another Type Doc
        caller.pause("4000");
        Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
        //Search for API Name
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Adding new document
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocFive = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocFive);
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.rdo_Other",false,"");
        caller.click("Browse_Doc.rdo_Other");
        caller.pause("1000");
        String varOtherTypeText = "Othertype"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Other",varOtherTypeText);
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_DocSameAsApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocFive,false,"");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        //Login another publisher user
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("2000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocFive,false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocFive);
        caller.pause("3000");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_ApiVersion,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocFive,false,"");
        caller.pause("5000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("4000");
        //Goto the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.pause("3000");
        //Check the document without logging
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocFive,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocFive,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocFive);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocFive,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        //Log into the store and check the document
        Common.bc_APIStoreLogin(caller, param_usernameStoreOne,param_passwordStoreOne);
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //wait for page load
        caller.click("APIStoreDocumentation.lnk_Other");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocFive,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocFive,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocFive);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocFive,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Check for another tenant
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStoreOne);
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"4000");
        caller.pause("7000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantTwo);
        Common.bc_APIStoreLogin(caller, param_usernameStoreTwo,param_passwordStoreTwo);
        caller.checkElementPresent("APIStoreHome.lnk_PublicApiStore",false,"");
        caller.click("APIStoreHome.lnk_PublicApiStore");
        caller.pause("3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocFive,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocFive,false,"");
        caller.pause("5000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocFive);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocFive,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStoreTwo);
        caller.click("APIStoreHome.btn_Logout");
        caller.writeToReport("End of  the APIM_106");	
    }
    /**
     *  Business component APIM_393.
     */
    public final static void APIM_393(final SeleniumTestBase caller, final String param_storeURL, final String param_serverName, final String param_usernameStore, final String param_passwordStore, final String param_context, final String param_APIName, final String param_searchContext) throws Exception {
        //APIM-393: Successfully logged in user should be able search with keywords that contains only part of the context name
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        Common.bc_APIStoreLogin(caller, param_usernameStore,param_passwordStore);
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_APIs");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",param_searchContext+param_context);
        //Delete part of context
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + param_APIName,false,"");	
    }
    /**
     *  Business component APIM_107.
     */
    public final static void APIM_107(final SeleniumTestBase caller, final String param_UserNamePublisher, final String param_PasswordPublisher, final String param_publisherURL, final String param_APIName) throws Exception {
        //When user clicks on the '?' icon of the visibility field tip box should open.
        //Login into the publisher
        caller.pause("3000");
        Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
        //Search for API Name
        caller.click("APIPublisherHome.lnk_Browse");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("1000");
        //check the visibility of ad new document feilds
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.checkElementPresent("Browse_Doc.ele_ddVisibility",false,"");
        caller.checkElementPresent("Browse_Doc.ele_ddVisibility",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblQuectionMark",false,"");
        caller.click("Browse_Doc.ele_lblQuectionMark");
        caller.pause("3000");
        //Check the tip box details
        caller.checkElementPresent("Browse_Doc.ele_lblTipBoxSameAsVisibility",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblTopBoxVisibleToMyDomain",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblTopBoxPrivate",false,"");	
    }
    /**
     *  Business component APIM_359.
     */
    public final static void APIM_359(final SeleniumTestBase caller, final String param_APIName, final String param_searchDoc) throws Exception {
        //APIM-359: Successfully logged in user should be able search API by documentation content
        //Go to browse and search APIa
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("5000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("5000");
        String varDocName = "Doc"+caller.generateData("Alphanumeric",4);
        caller.pause("2000");
        caller.type("Browse_Doc.tf_DocName",varDocName);
        caller.pause("5000");
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocName);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.tf_EditContent1",false,"");
        caller.pause("2000");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        String varEditContent = "Content"+caller.generateData("Alphanumeric",4);
        caller.type("Browse_Doc.tf_EditContent1",varEditContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","5000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("5000");
        //check for the document details
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocName,false,"");
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_searchDoc+varEditContent);
        caller.pause("2000");
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_108.
     */
    public final static void APIM_108(final SeleniumTestBase caller, final String param_APIName, final String param_ApiVisibility, final String param_SameApiVisibility, final String param_ApiVersion, final String param_UserNamePublisher, final String param_UserNamePublisherTwo, final String param_PasswordPublisherTwo, final String param_serverNameTenantOne, final String param_usernameStore, final String param_passwordStore, final String param_publisherURL, final String param_PasswordPublisher, final String param_fileToUploadtwo, final String param_DownloadFilePathtwo, final String param_storeURL, final String param_sourceUrlThree, final String param_sourceUrlFour) throws Exception {
        //Check doc visibility when it's given same as api visibility; api visibility = visible to my domain.
        //Ckeck the APIName
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("300");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Edit the Visibility type to Visible to my domain in API
        caller.checkElementPresent("APIPublisherBrowse.lnk_Edit",false,"");
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.pause("3000");
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_ApiVisibility);
        caller.pause("3000");
        if(caller.checkElementPresent("APIPublisherBrowse.btn_Ok")){
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Ok");
        caller.pause("2000");
        }
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Save");
        caller.pause("3000");
        //Search for API name
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("300");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("1000");
        //check the visibility of ad new document feilds
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.checkElementPresent("Browse_Doc.ele_ddVisibility",false,"");
        caller.pause("3000");
        String varDocNameSix = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameSix);
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("2000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocNameSix,false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocNameSix);
        caller.pause("3000");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_ApiVersion,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocNameSix,false,"");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        //Login using anither user in same domain
        caller.pause("4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("300");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.lnk_Doc");
        //Checking for added document
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocNameSix,false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocNameSix);
        caller.pause("3000");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_ApiVersion,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocNameSix,false,"");
        caller.pause("3000");
        //Logging out second user
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.click("APIPublisherLogOut.btn_LogOut");
        //Goto store
        caller.pause("5000");
        //Goto the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        Common.bc_APIStoreLogin(caller, param_usernameStore,param_passwordStore);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameSix,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameSix,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameSix);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocNameSix,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        //Adding sample & SDK document
        //Login into the publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("300");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocNameSeven = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameSeven);
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.pause("5000");
        caller.click("Browse_Doc.rdo_File");
        caller.pause("3000");
        caller.type("Browse_Doc.tf_BrowseFile",param_fileToUploadtwo);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + varDocNameSeven,false,"");
        caller.pause("3000");
        //Log out first user
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        //Login using anither user in same domain
        caller.pause("4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("300");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Checking for added document
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + varDocNameSeven,false,"");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocNameSeven,false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocNameSeven);
        caller.checkFileInfo(param_DownloadFilePathtwo,"EXIST",false,"");
        //Logging out second user
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("3000");
        //Goto store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Samples");
        //Checking for added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameSeven,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocNameSeven,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocNameSeven,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocNameSeven);
        caller.checkFileInfo(param_DownloadFilePathtwo,"EXIST",false,"");
        //Adding public forum document
        //Login to the publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //click login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("300");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("3000");
        String varDocNameEight = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameEight);
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.rdo_PublicForum",false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrlThree);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + varDocNameEight,false,"");
        caller.pause("3000");
        //Log out first user
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        //Login using anither user in same domain
        caller.pause("4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("300");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Checking for added document
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + varDocNameEight,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + varDocNameEight);
        //wait
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        //Logging out second user
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("3000");
        //Goto store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameEight,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameEight + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlThree,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameEight + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlThree);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Adding support forum document type
        //Login into the publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("300");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("3000");
        String varDocNameNine = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameNine);
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.rdo_SupportForum",false,"");
        caller.click("Browse_Doc.rdo_SupportForum");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrlFour);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblSupportForum","param_docName_PARAM:" + varDocNameNine,false,"");
        caller.pause("3000");
        //Log out first user
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        //Login using anither user in same domain
        caller.pause("4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("300");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Checking for added document
        caller.checkElementPresent("Browse_Doc.ele_lblSupportForum","param_docName_PARAM:" + varDocNameNine,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + varDocNameNine);
        //wait
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        //Logging out second user
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        //Goto store
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameNine,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameNine + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlFour,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameNine + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlFour,false,"");
        caller.pause("4000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameNine + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlFour);
        caller.pause("4000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Adding other type document
        //login into the publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("300");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocNameTen = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameTen);
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.rdo_Other",false,"");
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Other");
        String varOtherTypeText = "Othertype"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Other",varOtherTypeText);
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocNameTen,false,"");
        caller.pause("3000");
        //Log out first user
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("4000");
        //Login using anither user in same domain
        caller.pause("4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("300");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Checking for added document
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocNameTen,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocNameTen);
        caller.pause("3000");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_ApiVersion,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocNameTen,false,"");
        //Logging out second user
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        //Goto store
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Other");
        caller.pause("2000");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameTen,false,"");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameTen,false,"");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameTen);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocNameTen,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("5000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStore);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("4000");
        //sdcsdc	
    }
    /**
     *  Business component APIM_109.
     */
    public final static void APIM_109(final SeleniumTestBase caller, final String param_UserNamePublisher, final String param_PasswordPublisher, final String param_publisherURL, final String param_APIName, final String param_Visibility, final String param_VisibilityRole, final String param_SameApiVisibility, final String param_ApiVersion, final String param_storeURL, final String param_serverNameTenantOne, final String param_fileToUploadThree, final String param_DownloadFilePathThree, final String param_sourceUrlFive, final String param_sourceUrlSix, final String param_usernameStore, final String param_passwordStore) throws Exception {
        //Check doc visibility when it's given same as api visibility; api visibility = restricted by role
        //Login into the publisher
        Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
        //Search for API Name
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Edit",false,"");
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.pause("3000");
        //Changing the API visibility
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_Visibility);
        caller.pause("2000");
        caller.pause("2000");
        //Adding a visibility role
        caller.type("APIPublisherBrowse.tf_VisibilityToRole",param_VisibilityRole);
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Save");
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Wait for content load
        caller.pause("3000");
        //check the visibility of ad new document feilds
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.checkElementPresent("Browse_Doc.ele_ddVisibility",false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("1000");
        String varDocNameEleven = "Doc"+caller.generateData("int",4);
        caller.pause("3000");
        caller.type("Browse_Doc.tf_DocName",varDocNameEleven);
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("2000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocNameEleven,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocNameEleven);
        caller.pause("3000");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_ApiVersion,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocNameEleven,false,"");
        caller.pause("4000");
        //Goto the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.pause("2000");
        Common.bc_APIStoreLogin(caller, param_usernameStore,param_passwordStore);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameEleven,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameEleven,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameEleven);
        caller.pause("3000");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocNameEleven,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        //Adding Sample & SDK document
        //Goto the publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocNameTwelve = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameTwelve);
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_File");
        caller.type("Browse_Doc.tf_BrowseFile",param_fileToUploadThree);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + varDocNameTwelve,false,"");
        caller.checkElementPresent("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocNameTwelve,false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocNameTwelve);
        caller.checkFileInfo(param_DownloadFilePathThree,"EXIST",false,"");
        caller.pause("3000");
        //Goto store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Samples");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameTwelve,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocNameTwelve,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocNameTwelve,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocNameTwelve);
        caller.checkFileInfo(param_DownloadFilePathThree,"EXIST",false,"");
        //Adding Public Forum Document
        //Goto the store
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocNameThirteen = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameThirteen);
        caller.checkElementPresent("Browse_Doc.rdo_PublicForum",false,"");
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrlFive);
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + varDocNameThirteen,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + varDocNameThirteen);
        //wait
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        //Goto store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameThirteen,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameThirteen + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlFive,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameThirteen + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlFive,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameThirteen + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlFive);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Adding support forum document
        //Goto the store
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocNameFourteen = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameFourteen);
        caller.checkElementPresent("Browse_Doc.rdo_SupportForum",false,"");
        caller.click("Browse_Doc.rdo_SupportForum");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrlSix);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblSupportForum","param_docName_PARAM:" + varDocNameFourteen,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + varDocNameFourteen);
        //wait
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Goto store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameFourteen,false,"");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameFourteen + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlSix,false,"");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameFourteen + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlSix);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Adding other type document
        //Goto the publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocNameFifteen = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameFifteen);
        caller.checkElementPresent("Browse_Doc.rdo_Other",false,"");
        caller.click("Browse_Doc.rdo_Other");
        caller.pause("1000");
        String varOtherTypeText = "Othertype"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Other",varOtherTypeText);
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocNameFifteen,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocNameFifteen);
        caller.pause("3000");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_ApiVersion,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocNameFifteen,false,"");
        caller.pause("6000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.pause("4000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("5000");
        //Goto store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameFifteen,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameFifteen,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameFifteen);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocNameFifteen,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_usernameStore);
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("5000");	
    }
    /**
     *  Business component APIM_362.
     */
    public final static void APIM_362(final SeleniumTestBase caller, final String param_publisherURL, final String param_APIName, final String param_serverName, final String param_storeURL, final String param_roleStore, final String param_verbMethodNameGet, final String param_userNamePublisher) throws Exception {
        //APIM-362: A user should be able to assign a scope to a subscribed application which the key is already generated and generate the token again for a scope
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //go to API
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("3000");
        //type API name
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Manage");
        //waiting for content load
        caller.pause("2000");
        //Add scope for particular role
        caller.click("Scopes.btn_AddScope");
        //Type API SCope
        String varScopeKeyThree = "ScopeKeyThree"+caller.generateData("String",3);
        caller.type("Scopes.tf_ScopeKey",varScopeKeyThree);
        //Store and type scope
        String varScopeNameThree = "ScopeNameThree"+caller.generateData("String",3);
        caller.type("Scopes.tf_ScopeName",varScopeNameThree);
        caller.type("Scopes.tf_Role",param_roleStore);
        caller.click("Scopes.btn_SubmitScope");
        //waiting for content load
        caller.pause("2000");
        //Select method GET
        caller.click("Scopes.btn_ScopeReSelect","param_verbMethodName_PARAM:" + param_verbMethodNameGet);
        caller.select("Scopes.ele_ddScope",varScopeNameThree);
        caller.click("Scopes.btn_Right");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_Close");
        Common.bc_LogOut_APIPublisher(caller, param_userNamePublisher);
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //go to my subscription
        caller.click("APIStoreHome.lnk_MySubcription");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreMySubcription.lnk_ScopeProductionKey");
        //waiting for content load
        caller.pause("2000");
        //Select scopes
        caller.fireEvent("KEY%key=\t|key=\t|key=\t|key= |key=\t|key= |wait=2000","5000");
        //waiting for content load
        caller.pause("5000");
        //Regenerate key
        caller.click("APIStoreMySubcription.btn_RegenarateProduction");
        //Retrive previous  generated Token
        String varAccssTokenGenProd = caller.retrieveString("keyAccssTokenGenProd");
        //Store Access token
        String varSingleScopeTokenReGenProd = caller.getStringProperty("APIStoreMySubcription.ele_lblAccessTokenProduction","TEXT:");
        //Verify access token is regenarated(acess token is different from previous)
        if(!(varAccssTokenGenProd.equals(varSingleScopeTokenReGenProd))){
        caller.writeToReport("Token is regenaerated");
        } else {
        caller.writeToReport("Token is not  regenaerated");
        }
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreMySubcription.lnk_ScopeSandBox");
        //waiting for content load
        caller.pause("2000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\t|key= |key=\t|key= |wait=2000","5000");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreMySubcription.btn_RegenarateSandBox");
        //waiting for content load
        caller.pause("5000");
        //Retrive previous  generated Token
        String varAccssTokenGenSand = caller.retrieveString("keyAccssTokenGenSand");
        //Store Access token
        String varSingleScopeTokenReGenSand = caller.getStringProperty("APIStoreMySubcription.ele_lblAccessTokenProduction","TEXT:");
        //Verify access token is regenarated(acess token is different from previous)
        if(!(varAccssTokenGenSand.equals(varSingleScopeTokenReGenSand))){
        caller.writeToReport("Token is regenaerated");
        } else {
        caller.writeToReport("Token is not  regenaerated");
        }
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");	
    }
    /**
     *  Business component APIM_110.
     */
    public final static void APIM_110(final SeleniumTestBase caller, final String param_UserNamePublisher, final String param_PasswordPublisher, final String param_publisherURL, final String param_APIName, final String param_VisibilityPrivate, final String param_UserNamePublisherTwo, final String param_PasswordPublisherTwo, final String param_ApiVersion, final String param_fileToUploadFour, final String param_DownloadFilePathFour, final String param_sourceUrlSeven, final String param_sourceUrlEight, final String param_storeURL, final String param_serverNameTenantOne, final String param_usernameStore, final String param_passwordStore) throws Exception {
        //Check document visibility when it's given as private.
        //Login into the publisher
        caller.pause("5000");
        Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("1000");
        //check the visibility of ad new document feilds
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.checkElementPresent("Browse_Doc.ele_ddVisibility",false,"");
        caller.pause("3000");
        String varDocSixteen = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocSixteen);
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("2000");
        caller.select("Browse_Doc.ele_ddVisibility",param_VisibilityPrivate);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocSixteen,false,"");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIStoreHome.btn_Logout");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocSixteen,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocSixteen);
        caller.pause("3000");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_ApiVersion,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocSixteen,false,"");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("4000");
        //Adding Sample & SDK Doc
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocSeventeen = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocSeventeen);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_File");
        caller.pause("3000");
        caller.type("Browse_Doc.tf_BrowseFile",param_fileToUploadFour);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_VisibilityPrivate);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + varDocSeventeen,false,"");
        caller.checkElementPresent("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocSeventeen,false,"");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + varDocSeventeen,false,"");
        caller.checkElementPresent("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocSeventeen,false,"");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocSeventeen);
        caller.checkFileInfo(param_DownloadFilePathFour,"EXIST",false,"");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("4000");
        //Adding public forum Doc
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocEighteen = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocEighteen);
        caller.checkElementPresent("Browse_Doc.rdo_PublicForum",false,"");
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrlSeven);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_VisibilityPrivate);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + varDocEighteen,false,"");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + varDocEighteen,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + varDocEighteen);
        //wait
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("4000");
        //Adding Support forum documnet
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocNineteen = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNineteen);
        caller.checkElementPresent("Browse_Doc.rdo_SupportForum",false,"");
        caller.click("Browse_Doc.rdo_SupportForum");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrlEight);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_VisibilityPrivate);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblSupportForum","param_docName_PARAM:" + varDocNineteen,false,"");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.checkElementPresent("Browse_Doc.ele_SupportForum","param_docName_PARAM:" + varDocNineteen,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + varDocNineteen);
        //wait
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_SupportForum","param_docName_PARAM:" + varDocNineteen,false,"");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("4000");
        //Adding other type document
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocTwenty = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocTwenty);
        caller.checkElementPresent("Browse_Doc.rdo_Other",false,"");
        caller.click("Browse_Doc.rdo_Other");
        caller.pause("1000");
        String varOtherTypeText = "Othertype"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Other",varOtherTypeText);
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_VisibilityPrivate);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocTwenty,false,"");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocTwenty,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocTwenty);
        caller.pause("3000");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_ApiVersion,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocTwenty,false,"");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_111.
     */
    public final static void APIM_111(final SeleniumTestBase caller, final String param_UserNamePublisher, final String param_PasswordPublisher, final String param_APIName, final String param_SameApiVisibility, final String param_UserNamePublisherTwo, final String param_PasswordPublisherTwo, final String param_ApiVersion, final String param_storeURL, final String param_serverNameTenantOne, final String param_usernameStore, final String param_passwordStore, final String param_publisherURL, final String param_fileToUploadFive, final String param_sourceUrlNine, final String param_sourceUrlTen, final String param_DownloadFilePathFive) throws Exception {
        //Check document visibility when it's given as 'Visible to my domain'.
        //Login into the publisher
        caller.pause("6000");
        Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Adding new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("1000");
        //check the visibility of ad new document feilds
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.checkElementPresent("Browse_Doc.ele_ddVisibility",false,"");
        caller.pause("3000");
        String varDocNameTwentyOne = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameTwentyOne);
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("2000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocNameTwentyOne,false,"");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        //Login using another user
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Adding new document
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocNameTwentyOne,false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocNameTwentyOne);
        caller.pause("3000");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_ApiVersion,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocNameTwentyOne,false,"");
        caller.pause("4000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("3000");
        //Goto the Store URL
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        Common.bc_APIStoreLogin(caller, param_usernameStore,param_passwordStore);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameTwentyOne,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameTwentyOne,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameTwentyOne);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocNameTwentyOne,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("4000");
        //Adding Sample & SDK Doc
        //login into the publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.pause("3000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocNameTwentyTwo = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameTwentyTwo);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.pause("4000");
        caller.click("Browse_Doc.rdo_File");
        caller.pause("2000");
        caller.type("Browse_Doc.tf_BrowseFile",param_fileToUploadFive);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + varDocNameTwentyTwo,false,"");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocNameTwentyTwo,false,"");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + varDocNameTwentyTwo,false,"");
        caller.checkElementPresent("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocNameTwentyTwo,false,"");
        caller.pause("3000");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + varDocNameTwentyTwo);
        caller.checkFileInfo(param_DownloadFilePathFive,"EXIST",false,"");
        caller.pause("4000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("3000");
        //Goto the store URL
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Samples");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameTwentyTwo,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocNameTwentyTwo,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocNameTwentyTwo,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocNameTwentyTwo);
        caller.checkFileInfo(param_DownloadFilePathFive,"EXIST",false,"");
        caller.pause("4000");
        //Adding public forum Doc
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocNameTwentyThree = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameTwentyThree);
        caller.checkElementPresent("Browse_Doc.rdo_PublicForum",false,"");
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrlNine);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + varDocNameTwentyThree,false,"");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        //Login with another user
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + varDocNameTwentyThree,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + varDocNameTwentyThree);
        //wait
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("4000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("3000");
        //Goto the store URL
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("4000");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.pause("4000");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameTwentyThree,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameTwentyThree + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlNine,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameTwentyThree + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlNine);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Adding Support forum documnet
        //Goto the publisher URL
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //click login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocNameTwentyFour = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameTwentyFour);
        caller.checkElementPresent("Browse_Doc.rdo_SupportForum",false,"");
        caller.click("Browse_Doc.rdo_SupportForum");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrlTen);
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblSupportForum","param_docName_PARAM:" + varDocNameTwentyFour,false,"");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.pause("2000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_SupportForum","param_docName_PARAM:" + varDocNameTwentyFour,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + varDocNameTwentyFour);
        //wait
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_SupportForum","param_docName_PARAM:" + varDocNameTwentyFour,false,"");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.pause("2000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("3000");
        //Goto the store URL
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameTwentyFour,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameTwentyFour + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlTen,false,"");
        caller.pause("3000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameTwentyFour + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlTen,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameTwentyFour + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrlTen);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Adding other type document
        //Goto the publisher URL
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisher);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisher);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        String varDocNameTwentyFive = "Doc"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",varDocNameTwentyFive);
        caller.checkElementPresent("Browse_Doc.rdo_Other",false,"");
        caller.click("Browse_Doc.rdo_Other");
        caller.pause("1000");
        String varOtherTypeText = "Othertype"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Other",varOtherTypeText);
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("3000");
        caller.select("Browse_Doc.ele_ddVisibility",param_SameApiVisibility);
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        //Check the added document
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocNameTwentyFive,false,"");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisher);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherLogin.tf_UserName",false,"");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserNamePublisherTwo);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_PasswordPublisherTwo);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocNameTwentyFive,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + varDocNameTwentyFive);
        caller.pause("3000");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + param_ApiVersion,false,"");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocNameTwentyFive,false,"");
        caller.pause("3000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_UserNamePublisherTwo);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameTenantOne);
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_ApiVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Check the added document
        caller.pause("3000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameTwentyFive,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameTwentyFive,false,"");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameTwentyFive);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + varDocNameTwentyFive,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("6000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameTwentyFive,false,"");
        caller.pause("6000");	
    }
    /**
     *  Business component APIM_361.
     */
    public final static void APIM_361(final SeleniumTestBase caller, final String param_APIName, final String param_serverName, final String param_storeURL, final String param_verbMethodNamePost, final String param_publisherURL, final String param_roleStore) throws Exception {
        //APIM-361: A user should be able to assign multiple scopes to a subscribed application and generate token
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //go to API
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Manage");
        //waiting for content load
        caller.pause("2000");
        //Add scope for particular role
        caller.click("Scopes.btn_AddScope");
        //Type API SCope
        String varScopeKeyTwo = "ScopeKeyTwo"+caller.generateData("String",3);
        caller.type("Scopes.tf_ScopeKey",varScopeKeyTwo);
        //Type API SCope name
        String varScopeNameTwo = "ScopeNameTwo"+caller.generateData("String",3);
        caller.type("Scopes.tf_ScopeName",varScopeNameTwo);
        caller.type("Scopes.tf_Role",param_roleStore);
        //waiting for content load
        caller.pause("3000");
        caller.click("Scopes.btn_SubmitScope");
        //waiting for content load
        caller.pause("3000");
        caller.click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + param_verbMethodNamePost);
        caller.select("Scopes.ele_ddScope",varScopeNameTwo);
        caller.click("Scopes.btn_Right");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_Close");
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //go to my subscription
        caller.click("APIStoreHome.lnk_MySubcription");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreMySubcription.lnk_ScopeProductionKey");
        //waiting for content load
        caller.pause("2000");
        String varScopeKeyOne = caller.retrieveString("keyScopeKeyOne");
        caller.pause("200");
        //Select scopes
        caller.fireEvent("KEY%key=\t|key= |key=\t|key=\t|key=\t|key= |wait=2000","5000");
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreMySubcription.btn_RegenarateProduction");
        //waiting for content load
        caller.pause("2000");
        //Retrive previous  generated Token
        String varAccssTokenGenProd = caller.retrieveString("keyAccssTokenGenProd");
        //Store Access token
        String varMultiScopeTokenReGenProd = caller.getStringProperty("APIStoreMySubcription.ele_lblAccessTokenProduction","TEXT:");
        //Verify access token is regenarated(acess token is different from previous)
        if(!(varAccssTokenGenProd.equals(varMultiScopeTokenReGenProd))){
        caller.writeToReport("Token is regenaerated");
        } else {
        caller.writeToReport("Token is not  regenaerated");
        }
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreMySubcription.lnk_ScopeSandBox");
        //waiting for content load
        caller.pause("200");
        //Select scopes
        caller.fireEvent("KEY%key=\t|key= |key=\t|key=\t|key=\t|key= |wait=2000","5000");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreMySubcription.btn_RegenarateSandBox");
        //waiting for content load
        caller.pause("2000");
        //Retrive previous  generated Token
        String varAccssTokenGenSand = caller.retrieveString("keyAccssTokenGenSand");
        //Store Access token
        String varMultiScopeTokenReGenSand = caller.getStringProperty("APIStoreMySubcription.ele_lblAccessTokenProduction","TEXT:");
        //Verify access token is regenarated(acess token is different from previous)
        if(!(varAccssTokenGenSand.equals(varMultiScopeTokenReGenSand))){
        caller.writeToReport("Token is regenaerated");
        } else {
        caller.writeToReport("Token is not  regenaerated");
        }	
    }
    /**
     *  Business component APIM_360.
     */
    public final static void APIM_360(final SeleniumTestBase caller, final String param_APIName, final String param_storeRole, final String param_verbMethodNameGet, final String param_serverName, final String param_storeURL, final String param_userNameStore, final String param_passwordStore, final String param_tier, final String param_publisherURL) throws Exception {
        //APIM-360: A user should be able to assign a scope to a subscribed application and generate a new access token to a paticular scope
        //go to API
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Manage");
        //waiting for content load
        caller.pause("2000");
        //Add scope for particular role
        caller.click("Scopes.btn_AddScope");
        //Type API SCope key
        String varScopeKeyOne = "ScopeKeyOne"+caller.generateData("String",3);
        //Store vatiable
        caller.store("keyScopeKeyOne","String","varScopeKeyOne");
        caller.type("Scopes.tf_ScopeKey",varScopeKeyOne);
        //Type API SCope
        String varScopeNameOne = "ScopeNameOne"+caller.generateData("String",4);
        caller.type("Scopes.tf_ScopeName",varScopeNameOne);
        //giving ROLE which logging to Store
        caller.type("Scopes.tf_Role",param_storeRole);
        //waiting for content load
        caller.pause("3000");
        caller.click("Scopes.btn_SubmitScope");
        //waiting for content load
        caller.pause("3000");
        //click GET method
        caller.click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + param_verbMethodNameGet);
        caller.select("Scopes.ele_ddScope",varScopeNameOne);
        caller.click("Scopes.btn_Right");
        //waiting for content load
        caller.pause("3000");
        //save and publish
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("5000");
        //Navigate to store with user with role given in selecting scope
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        /*
        Call
         businessComponent=Common.bc_APIStoreLogin
         param_username=@param_userNameStore
         param_password=@param_passwordStore
        */
        //waiting for content load
        caller.pause("5000");
        //create new aplication
        //Go to my app and create app
        caller.click("APIStoreHome.lnk_MyApplication");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblNewAppliacation",false,"");
        //Type aplication name
        //Type API SCope
        String varAppNameOne = "App"+caller.generateData("int",3);
        caller.type("APIStoreMyApllication.tf_ApplicationName",varAppNameOne);
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("4000");
        //Go to published  API
        caller.click("APIStoreHome.lnk_APIs");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //waiting for content load
        caller.pause("2000");
        //Subscribe API
        caller.select("APIStoreAPIs.ele_ddSelectAplicationToSubscribe",varAppNameOne);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.btn_Subscribe");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.btn_StayOnThisPage");
        //waiting for content load
        caller.pause("2000");
        //go to my subscription
        caller.click("APIStoreHome.lnk_MySubcription");
        //click genarate key of production
        caller.click("APIStoreMySubcription.btn_generateKeyProduction");
        //waiting for content load
        caller.pause("7000");
        //Store Access token
        String varAccessTokenProd = caller.getStringProperty("APIStoreMySubcription.ele_lblAccessTokenProduction","TEXT:");
        //waiting for content load
        caller.pause("2000");
        //Verify concumer key of production
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerKeyProduction",false,"");
        //waiting for content load
        caller.pause("2000");
        //Verify concumer secret key of production
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerSecretTokenProduction",false,"");
        //waiting for content load
        caller.pause("2000");
        //Verify Acsess Token of production
        caller.checkElementPresent("APIStoreMySubcription.ele_lblAccessTokenProduction",false,"");
        //waiting for content load
        caller.pause("2000");
        //Click generate button of sandbox
        caller.click("APIStoreMySubcription.btn_GenarateKeySandBox");
        //waiting for content load
        caller.pause("5000");
        //Store Access token
        String varAccessTokenSand = caller.getStringProperty("APIStoreMySubcription.ele_lblAccessTokenProduction","TEXT:");
        //Verify concumer key of production
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerKeySandbox",false,"");
        //waiting for content load
        caller.pause("2000");
        //Verify concumer secret key of production
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerSecretTokenSandBox",false,"");
        //waiting for content load
        caller.pause("2000");
        //Verify Acsess Token of production
        caller.checkElementPresent("APIStoreMySubcription.ele_lblAccessTokenSandBox",false,"");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIStoreMySubcription.lnk_ScopeProductionKey");
        //waiting for content load
        caller.pause("2000");
        //Select scopes
        caller.fireEvent("KEY%key=\t|key=\t|key= |key=\t|key= |wait=2000","5000");
        //waiting for content load
        caller.pause("2000");
        //Regenerate key
        caller.click("APIStoreMySubcription.btn_RegenarateProduction");
        //waiting for content load
        caller.pause("4000");
        //Store Access token
        String varAccessTokenReGenProd = caller.getStringProperty("APIStoreMySubcription.ele_lblAccessTokenProduction","TEXT:");
        caller.store("keyAccssTokenGenProd","String","varAccessTokenReGenProd");
        //Verify access token is regenarated(acess token is different from previous)
        if(!(varAccessTokenProd.equals(varAccessTokenReGenProd))){
        caller.writeToReport("Token is regenaerated");
        } else {
        caller.writeToReport("Token is not  regenaerated");
        }
        //waiting for content load
        caller.pause("4000");
        caller.click("APIStoreMySubcription.lnk_ScopeSandBox");
        caller.fireEvent("KEY%key=\t|key=\t|key= |key=\t|key= |wait=2000","5000");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreMySubcription.btn_RegenarateSandBox");
        //waiting for content load
        caller.pause("3000");
        //Store Access token
        String varAccessTokenReGenSand = caller.getStringProperty("APIStoreMySubcription.ele_lblAccessTokenProduction","TEXT:");
        //Store the value in variable
        caller.store("keyAccssTokenGenSand","String","varAccessTokenReGenSand");
        //Verify access token is regenarated(acess token is different from previous)
        if(!(varAccessTokenSand.equals(varAccessTokenReGenSand))){
        caller.writeToReport("Token is regenaerated");
        } else {
        caller.writeToReport("Token is not  regenaerated");
        }	
    }
    /**
     *  Business component APIM_60.
     */
    public final static void APIM_60(final SeleniumTestBase caller, final String param_serverName, final String param_storeURL, final String param_APIName, final String param_usernameCurrentDomain, final String param_passwordCurrentDomain, final String param_usernameOtherTenantDomain, final String param_passwordOtherTenantDomain, final String param_serverNameDomainTwo, final String param_serverNameDomainOne) throws Exception {
        //APIM-60: Published APIs with public visibility can be viewed by all users.
        //Previous API Already having PUBLIC visibility to  API
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Verify API is visible when not loging to store
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        //Verify API is visible when  loging  with current tenant domain user to store
        Common.bc_APIStoreLogin(caller, param_usernameCurrentDomain,param_passwordCurrentDomain);
        //Wait for content load
        caller.pause("3000");
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        //Verify API is visible when  loging  with other tenant domain user to store
        //Navigate to store
        Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //Wait for content load
        caller.pause("3000");
        Common.bc_APIStoreLogin(caller, param_usernameOtherTenantDomain,param_passwordOtherTenantDomain);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublicApiStore");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameDomainOne);
        //Wait for content load
        caller.pause("3000");
        //Verify API is Not visible for other tenants  when give API visibility as Public
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","true",false,"");	
    }
    /**
     *  Business component APIM_61.
     */
    public final static void APIM_61(final SeleniumTestBase caller, final String param_publisherURL, final String param_APIName, final String param_VisibilityToMyDomain, final String param_serverNameDomainTwo, final String param_storeURL, final String param_usernameOtherTenantDomain, final String param_passwordOtherTenantDomain, final String param_usernameDomainTwo, final String param_passwordDomainTwo, final String param_publisherUserNameOne, final String param_publisherPasswordOne, final String param_usernameDomainOne, final String param_serverName) throws Exception {
        //APIM-61: publish an API given 'visible to my domain' -users belong to other tenantsshould not be able to view
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        Common.bc_Login_APIPublisher(caller, param_publisherUserNameOne,param_publisherPasswordOne,param_publisherURL);
        //waiting for content load
        caller.pause("3000");
        //go to API
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("5000");
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_VisibilityToMyDomain);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Ok");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_Close");
        //waiting for content load
        caller.pause("5000");
        Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
        //Loging with other tenat domain user
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        Common.bc_APIStoreLogin(caller, param_usernameDomainTwo,param_passwordDomainTwo);
        caller.click("APIStoreHome.lnk_PublicApiStore");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        //Verify API is Not visible for other tenants  when give API visibility as my domain
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","false",false,"");	
    }
    /**
     *  Business component APIM_62.
     */
    public final static void APIM_62(final SeleniumTestBase caller, final String param_publisherURL, final String param_APIName, final String param_VisibilityRestrictedToRole, final String param_serverName, final String param_usernameSubscriberCurrentDomain, final String param_PasswordSubscriberCurrentDomain, final String param_usernameStoreOtherTenantDomain, final String param_passwordStoreOtherTenantDomain, final String param_role, final String param_storeURL, final String param_serverNameDomainTwo) throws Exception {
        //APIM-62: published api with visibility restricted to a role should visible to users with the particular role.
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //go to API
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("2000");
        //Select restricted to role
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_VisibilityRestrictedToRole);
        //waiting for content load
        caller.pause("2000");
        //type role
        caller.type("APIPublisherBrowse.tf_VisibilityToRole",param_role);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Close");
        //waiting for content load
        caller.pause("2000");
        //Loging user with role given in visibility
        Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //Verify API is visible when  loging  with user role given in API visibility
        Common.bc_APIStoreLogin(caller, param_usernameSubscriberCurrentDomain,param_PasswordSubscriberCurrentDomain);
        //waiting for content load
        caller.pause("2000");
        //Verify API is  visible fo ruser with  when give API visibility as my domain
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","true",false,"");
        //waiting for content load
        caller.pause("2000");
        Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //Verify API is not  visible when  loging when user not mention in select visibility to role user to store
        Common.bc_APIStoreLogin(caller, param_usernameStoreOtherTenantDomain,param_passwordStoreOtherTenantDomain);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublicApiStore");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        //Verify API is Not visible for other tenants  when give API visibility as my domain
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","false",false,"");	
    }
    /**
     *  Business component APIM_64.
     */
    public final static void APIM_64(final SeleniumTestBase caller, final String param_APIName, final String param_VisibilityRestrictedToRole, final String param_serverNameDomainTwo, final String param_storeURL, final String param_publisherURL, final String param_storeUsernameSameRoleDomainTwo, final String param_storePasswordDomainTwo, final String param_VisibilitySameRole, final String param_storeUsernameOneDomainOne, final String param_serverName) throws Exception {
        //APIM-64: API with visibility restricted to a role should not be visible to users belong to other tenants
        //Navigate to Store
        //Loging user with role given in visibility
        Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        //Verify API is not  visible when  loging  with  same user role given in API visibility with other tenant
        Common.bc_APIStoreLogin(caller, param_storeUsernameSameRoleDomainTwo,param_storePasswordDomainTwo);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublicApiStore");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        //waiting for content load
        caller.pause("2000");
        //Verify API is   not visible for user
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","false",false,"");	
    }
    /**
     *  Business component APIM_65.
     */
    public final static void APIM_65(final SeleniumTestBase caller, final String param_publisherURL, final String param_VisibilityRestrictedToRole, final String param_multipleVisibility, final String param_serverNameDomainOne, final String param_storeURL, final String param_storeUsernameOneDomainOne, final String param_storePasswordOneDomainOne, final String param_APIName, final String param_storeUsernameTwoDomainOne, final String param_storePasswordTwoDomainOne, final String param_storeUsernameOneDomainTwo) throws Exception {
        //APIM-65: publish an api with visibility restricted to multiple roles-only users with allowed roles can view.
        //Navigate to publisher URL
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //go to API
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("2000");
        //Type Multiple user roles
        caller.type("APIPublisherBrowse.tf_VisibilityToRole",param_multipleVisibility);
        caller.click("APIPublisherAdd.btn_Save");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Close");
        //waiting for content load
        caller.pause("2000");
        //Loging user with role one given in visibility
        Common.bc_NavigateToStore(caller, param_serverNameDomainOne,param_storeURL);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //Verify API is   visible when  loging  with   user role  given  in multiplr role in API visibility
        Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainOne,param_storePasswordOneDomainOne);
        //waiting for content load
        caller.pause("2000");
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","true",false,"");
        //Log out
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        //Verify API is not  visible when  loging  with   user role one given in API visibility with other tenant
        Common.bc_APIStoreLogin(caller, param_storeUsernameTwoDomainOne,param_storePasswordTwoDomainOne);
        //waiting for content load
        caller.pause("2000");
        //Verify API is  visible for user
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","true",false,"");	
    }
    /**
     *  Business component APIM_66.
     */
    public final static void APIM_66(final SeleniumTestBase caller, final String param_publisherURL, final String param_APIName, final String param_VisibileToMyDomain, final String param_serverNameDomainOne, final String param_storeURL, final String param_storeUsernameTwoDomainOne, final String param_storePasswordTwoDomainOne, final String param_storeUsernameOneDomainOne, final String param_storePasswordOneDomainOne) throws Exception {
        //APIM-66: Publish an API given 'visible to my domain' -users belong to same tenant should be able to view.
        //Navigate to publisher URL
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //go to API
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("2000");
        //Select restricted to role
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_VisibileToMyDomain);
        caller.click("APIPublisherAdd.btn_Save");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Close");
        //waiting for content load
        caller.pause("2000");
        //Loging user with Same domain
        Common.bc_NavigateToStore(caller, param_serverNameDomainOne,param_storeURL);
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        //Verify API visible
        Common.bc_APIStoreLogin(caller, param_storeUsernameTwoDomainOne,param_storePasswordTwoDomainOne);
        //waiting for content load
        caller.pause("2000");
        //Verify API is  visible fo ruser with  when give API visibility as my domain
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","true",false,"");
        //waiting for content load
        caller.pause("2000");
        //Loging user with Same domain
        Common.bc_NavigateToStore(caller, param_serverNameDomainOne,param_storeURL);
        //waiting for content load
        caller.pause("2000");
        //Log out
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        //Verify API visible
        Common.bc_APIStoreLogin(caller, param_storeUsernameTwoDomainOne,param_storePasswordTwoDomainOne);
        //waiting for content load
        caller.pause("2000");
        //Verify API is  visible fo ruser with  when give API visibility as my domain
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","true",false,"");	
    }
    /**
     *  Business component APIM_67.
     */
    public final static void APIM_67(final SeleniumTestBase caller, final String param_publisherURL, final String param_APIName, final String param_VisibilityPublic, final String param_subscriptionAvailableToCurrentTenantOnly, final String param_serverNameDomainOne, final String param_storeURL, final String param_storeUsernameOneDomainOne, final String param_storePasswordOneDomainOne, final String param_aplicationName, final String param_storeUsernameTwoDomainOne) throws Exception {
        //APIM-67: API with subscription available only to current tenant, allows current tenant user to subscribe
        //Navigate to publisher URL
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //go to API
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("2000");
        //Select public to role
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_VisibilityPublic);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Manage");
        //waiting for content load
        caller.pause("2000");
        caller.select("APIPublisherBrowse.ele_ddSubscription",param_subscriptionAvailableToCurrentTenantOnly);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Close");
        //waiting for content load
        caller.pause("2000");
        //Loging user with Same domain
        Common.bc_NavigateToStore(caller, param_serverNameDomainOne,param_storeURL);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        //Logging with current tenant domain user
        Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainOne,param_storePasswordOneDomainOne);
        //waiting for content load
        caller.pause("2000");
        //Click My Application
        caller.click("APIStoreHome.lnk_MyApplication");
        //waiting for content load
        caller.pause("2000");
        //Create new APP
        caller.type("APIStoreMyApllication.tf_ApplicationName",param_aplicationName);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        //waiting for content load
        caller.pause("2000");
        //Click on API
        caller.click("APIStoreHome.lnk_APIs");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //waiting for content load
        caller.pause("2000");
        caller.select("APIStoreAPIs.ele_ddSelectAplicationToSubscribe",param_aplicationName);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.btn_Subscribe");
        //waiting for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblSubscriptionSuccefulMssage",false,"");
        caller.click("APIStoreAPIs.btn_StayOnThisPage");
        //waiting for content load
        caller.pause("2000");	
    }
    /**
     *  Business component APIM_68.
     */
    public final static void APIM_68(final SeleniumTestBase caller, final String param_publisherURL, final String param_APIName, final String param_serverNameDomainTwo, final String param_storeURL, final String param_storeUsernameOneDomainTwo, final String param_storePasswordOneDomainTwo, final String param_serverNameDomainOne, final String param_storeUsernameOneDomainOne) throws Exception {
        //APIM-68: API with subscription available only to current tenant, not allow other tenant users to subscribe.
        //Loging user with other domain
        Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        //Verify API is not  visible when  loging  with   user role one given in API visibility with other tenant
        Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainTwo,param_storePasswordOneDomainTwo);
        //Go to Public API
        caller.click("APIStoreAPIs.lnk_PublicApiStore");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameDomainOne);
        //Go to API
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Verify Subscribe is not avilale
        caller.checkObjectProperty("APIStoreAPIs.btn_Subscribe","ELEMENTPRESENT","false",false,"");	
    }
    /**
     *  Business component APIM_71.
     */
    public final static void APIM_71(final SeleniumTestBase caller, final String param_publisherURL, final String param_APIName, final String param_subscriptionAvailableToAllTenantOnly, final String param_serverNameDomainTwo, final String param_storeURL, final String param_storeUsernameOneDomainTwo, final String param_storePasswordOneDomainTwo, final String param_serverName) throws Exception {
        //APIM-71: APIs with subscription available to all tenants should allow users in other tenants to subscribe.
        //Navigate to publisher URL
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //go to API
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Manage");
        //waiting for content load
        caller.pause("2000");
        caller.select("APIPublisherBrowse.ele_ddSubscription",param_subscriptionAvailableToAllTenantOnly);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Close");
        //waiting for content load
        caller.pause("2000");
        //Loging user with other domain
        Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        //Veirf any tenant ser can subscribe
        Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainTwo,param_storePasswordOneDomainTwo);
        //Go to Public API
        caller.click("APIStoreAPIs.lnk_PublicApiStore");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        //Go to API
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Verify Subscribe is avilale
        caller.checkObjectProperty("APIStoreAPIs.btn_Subscribe","ELEMENTPRESENT","true",false,"");	
    }
    /**
     *  Business component APIM_72.
     */
    public final static void APIM_72(final SeleniumTestBase caller, final String param_publisherURL, final String param_APIName, final String param_subscriptionAvailableToSpecificTenantOnly, final String param_specifiedTenanatName, final String param_serverNameDomainOne, final String param_storeURL, final String param_serverNameDomainTwo, final String param_storeUsernameOneDomainTwo, final String param_storePasswordOneDomainTwo, final String param_storeUsernameOneDomainOne, final String param_storePasswordOneDomainOne, final String param_publisherUserName) throws Exception {
        //APIM-72: API with subscription available to specific tenants should allow subscription to specified tenants
        //Navigate to publisher URL
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //go to API
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Manage");
        //waiting for content load
        caller.pause("2000");
        caller.select("APIPublisherBrowse.ele_ddSubscription",param_subscriptionAvailableToSpecificTenantOnly);
        //waiting for content load
        caller.pause("2000");
        caller.type("APIPublisherBrowse.tf_Tenantname",param_specifiedTenanatName);
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Close");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_publisherUserName);
        caller.pause("2000");
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.pause("2000");
        Common.bc_NavigateToStore(caller, param_serverNameDomainOne,param_storeURL);
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //Verify API is not  visible when  loging  with   user role one given in API visibility with other tenant
        Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainOne,param_storePasswordOneDomainOne);
        //waiting for content load
        caller.pause("2000");
        //Go to API
        caller.click("APIStoreHome.lnk_APIs");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Verify Subscribe is avilale
        caller.checkObjectProperty("APIStoreAPIs.btn_Subscribe","ELEMENTPRESENT","true",false,"");
        //waiting for content load
        caller.pause("2000");
        Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //Verify API is not  visible when  loging  with   user role one given in API visibility with other tenanT
        Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainTwo,param_storePasswordOneDomainTwo);
        //waiting for content load
        caller.pause("2000");
        //Go to Public API
        caller.click("APIStoreAPIs.lnk_PublicApiStore");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverNameDomainOne);
        //Go to API
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //Verify Subscribe is avilale
        caller.checkObjectProperty("APIStoreAPIs.btn_Subscribe","ELEMENTPRESENT","false",false,"");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");	
    }
}
