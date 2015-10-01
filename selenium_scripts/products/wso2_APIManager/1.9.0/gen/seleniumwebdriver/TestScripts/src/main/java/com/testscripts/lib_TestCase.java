package com.testscripts;

import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;
import org.openqa.selenium.By;

/**
 *  Class lib_TestCase contains reusable business components 
 *  Each method in this class correspond to a reusable business component.
 */
public class lib_TestCase {

    /**
     *  Business component APIM_22.
     */
    public final static void APIM_22(final SeleniumTestBase caller, final String param_verbNamePost, final String param_urlPatterSC, final String param_verbNameDelete, final String param_verbNameGet, final String param_urlPattern, final String param_verbName, final String param_APIName, final String param_publisherURL, final String param_storeURL, final String param_TenanrOrAdmin) throws Exception {
        //APIM-22: Editing an API---------------------
        caller.writeToReport("Start Executing APIM-22");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        String varUpdateAPIsThree = caller.retrieveString("keyUpdateAPIs");
        lib_Common.bc_EditAPI(caller, varUpdateAPIsThree);
        //waiting for content load
        caller.pause("4000");
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatterSC);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNamePost);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Add");
        //waiting for content load
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbNamePost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatterSC,false,"");
        caller.click("APIPublisherBrowse.img_deleteIcon","param_verbmethodPost_PARAM:" + param_verbNamePost + "_PARAM," + "param_UrlPattern_PARAM:" + param_urlPatterSC);
        caller.click("APIPublisherBrowse.btn_Yes");
        //waiting for content load
        caller.pause("5000");
        caller.checkObjectProperty("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbNamePost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatterSC,"ELEMENTPRESENT","false",false,"");
        //waiting for content load
        caller.pause("4000");
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatterSC);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNameGet);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNamePost);
        caller.click("APIPublisherBrowse.btn_Add");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbNameGet + "_PARAM," + "urlPattern_PARAM:" + param_urlPatterSC,false,"");
        //waiting for content load
        caller.pause("4000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbNamePost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatterSC,false,"");
        //waiting for content load
        caller.pause("6000");
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPattern);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNamePost);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNameDelete);
        caller.click("APIPublisherBrowse.btn_Add");
        //waiting for content load
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblpopupError",false,"");
        caller.click("APIPublisherBrowse.btn_Ok");
        //waiting for content load
        caller.pause("6000");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbNamePost);
        caller.click("APIPublisherBrowse.btn_Add");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbNameDelete + "_PARAM," + "urlPattern_PARAM:" + param_urlPatterSC,false,"");
        caller.click("APIPublisherBrowse.btn_Save");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        lib_Common.bc_PrototypeAPI(caller);
        //Wait for content load
        caller.pause("6000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_TenanrOrAdmin);
        //waiting for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PrototypedAPIs");
        //waiting for content load
        caller.pause("6000");
        String varUpdateAPIsFour = caller.retrieveString("keyUpdateAPIs");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + varUpdateAPIsFour);
        caller.click("APIStoreAPIs.ele_tabAPIConsole");
        //waiting for content load
        caller.pause("6000");
        caller.checkElementPresent("APIStoreAPIs.lnk_default","param_verb_PARAM:" + param_verbNamePost + "_PARAM," + "param_UrlPattern_PARAM:" + param_urlPattern,false,"");
        caller.writeToReport("End of Executing APIM-22");	
    }
    /**
     *  Business component APIM_21.
     */
    public final static void APIM_21(final SeleniumTestBase caller, final String param_APIName, final String param_APIcontest, final String param_APIVersion, final String param_APIImagePath, final String param_tagName, final String param_URLPattern) throws Exception {
        caller.writeToReport("Start of executing APIM_21");
        //Go for create new API up to create state
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //CreateAPI upto design Stage
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        String varAPIName = param_APIName+caller.generateData("int",5);
        caller.store("keyAPINameOne","String",varAPIName);
        caller.type("APIPublisherAdd.tf_APIName",varAPIName);
        //Type API contest
        String varAPIcontest = param_APIcontest+caller.generateData("int",5);
        caller.type("APIPublisherAdd.tf_APIContext",varAPIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion+caller.generateData("int",3));
        //Type valid image path
        //Type
        //object=APIPublisherAdd.btn_BrowseImage
        //text=@param_APIImagePath
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("2000");
        //click save and verify warning
        caller.type("APIPublisherAdd.tf_URLPattern",varAPIName+"/"+varAPIcontest);
        caller.click("APIPublisherAdd.chk_Post");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Add");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("8000");
        //Go to implement stage
        caller.checkElementPresent("APIPublisherAdd.lnk_NextImplement",false,"");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("4000");
        //waiting for content load
        caller.pause("4000");
        //APIM-21: Try to change the lifecycle of an API in design stge
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",varAPIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        //Click
        //object=APIPublisherBrowse.lnk_APIName
        //API_No=@varAPIName
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPIName);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //Verify the unavailability of "PROTOTYPED"
        caller.checkObjectProperty("APIPublisherBrowse.ele_ddState","MISSINGOPTION","PROTOTYPED",false,"");
        //Verify the unavailability of "PUBLISHED"
        caller.checkObjectProperty("APIPublisherBrowse.ele_ddState","MISSINGOPTION","PUBLISHED",false,"");
        caller.writeToReport("End of executing APIM_21");	
    }
    /**
     *  Business component APIM_276.
     */
    public final static void APIM_276(final SeleniumTestBase caller, final String param_APIName, final String param_VisibilityPublic, final String param_publisherURL, final String param_storeURL, final String param_TenanrOrAdmin) throws Exception {
        //APIM-276: Change the visibilty levels of the API to public and save it------------
        caller.writeToReport("Start Executing APIM-276");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        String varUpdateAPIsFive = caller.retrieveString("keyUpdateAPIs");
        lib_Common.bc_EditAPI(caller, varUpdateAPIsFive);
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_VisibilityPublic);
        caller.click("APIPublisherBrowse.btn_Save");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenanrOrAdmin);
        //waiting for content load
        caller.pause("5000");
        caller.click("APIStoreHome.lnk_PrototypedAPIs");
        String varkeyUpdateAPIs = caller.retrieveString("keyUpdateAPIs");
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + varkeyUpdateAPIs,false,"");
        //log out store
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIStoreHome.lnk_PrototypedAPIs");
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + varkeyUpdateAPIs,false,"");
        caller.writeToReport("End of Executing APIM-276");	
    }
    /**
     *  Business component APIM_20.
     */
    public final static void APIM_20(final SeleniumTestBase caller, final String param_APIVersion, final String param_nonImagrPath, final String param_APIImagePath, final String param_URLPattern, final String param_APIName, final String param_APIContext, final String param_TagName) throws Exception {
        caller.writeToReport("Srart of executing APIM_20");
        //APIM-20:Create API in design stage - Field validations
        //CreateAPI upto design Stage
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Verify design API page apears
        caller.checkElementPresent("APIPublisherAdd.ele_lblDesignAPI",false,"");
        //genarate api name
        String APIName = param_APIName+"_"+caller.generateData("int",3);
        caller.store("var_APIName","String",APIName);
        caller.store("var_APINameOne","String",APIName);
        caller.type("APIPublisherAdd.tf_APIName",APIName);
        //Type API contest
        String APIcontest = param_APIContext+"_"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //waiting for content load
        caller.pause("6000");
        //Type non image path and verify error
        //Type valid image path
         java.io.File fileOne = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_nonImagrPath);
        String entirePathInvalid = fileOne.getAbsolutePath();
        caller.type("APIPublisherAdd.btn_BrowseImage",entirePathInvalid);
        //Waiting for content to load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Save");
        //Waiting for content to load
        caller.pause("6000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblNonImageFileError",false,"");
        //Type valid image path
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_APIImagePath);
        String entirePath = file.getAbsolutePath();
        caller.type("APIPublisherAdd.btn_BrowseImage",entirePath);
        for(int i=0;i<15;i++){
        String TagName = param_TagName+"_"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_Tags",TagName);
        caller.fireEvent("KEY%key=\n","2000");
        }
        //waiting for content load
        caller.pause("5000");
        //Type URL pattern and resource and did not choose any Verb
        caller.type("APIPublisherAdd.tf_URLPattern",param_URLPattern);
        caller.click("APIPublisherAdd.btn_Add");
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblErrorMessageURLPattern",false,"");
        caller.click("APIPublisherAdd.btn_OkErrorMessage");
        //remove URL and resource
        caller.type("APIPublisherAdd.tf_URLPattern","");
        //click save and verify warning
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherBrowse.btn_No",false,"");
        caller.click("APIPublisherBrowse.btn_No");
        //waiting for content load
        caller.pause("6000");
        //Remove API Name
        caller.type("APIPublisherAdd.tf_APIName","");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblWarningMessageAPIName",false,"");
        //Type API name
        caller.type("APIPublisherAdd.tf_APIName",APIName);
        //Empty the API context and save
        caller.type("APIPublisherAdd.tf_APIContext","");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("6000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblWarningMessageAPIContest",false,"");
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        //Empty the API Version and verify error
        caller.type("APIPublisherAdd.tf_APIVersion","");
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("6000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblWarningMessageAPIVersion",false,"");
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.pause("3000");
        //Verify whether goes to  genaral detail page
        caller.checkElementPresent("APIPublisherAdd.lnk_NextImplement",false,"");
        //waiting for content load
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherAdd.img_ThubmnailImage",false,"");
        caller.writeToReport("End of executing APIM_20");	
    }
    /**
     *  Business component APIM_278.
     */
    public final static void APIM_278(final SeleniumTestBase caller, final String param_VisibilityRestrictedToRole, final String param_TenantOrAdmin, final String param_storeURL, final String param_APIVersion, final String param_ProductionEndPont, final String param_SandBoxEndpoint, final String param_Domain) throws Exception {
        caller.writeToReport("Srart of executing APIM_278");
        //APIM-278: Change the visibilty levels of the API to 'reststircted by role' and save it------------
        caller.click("APIPublisherHome.lnk_Browse");
        String APIName = caller.retrieveString("var_APIName");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblGeneralDetails",false,"");
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_VisibilityRestrictedToRole);
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_Ok");
        caller.checkElementPresent("APIPublisherBrowse.tf_VisibilityToRole",false,"");
        if(param_TenantOrAdmin.equals("Tenant")){
        String var_RoleName = caller.retrieveString("KeyVisibilityRole");
        //Type username
        caller.type("APIPublisherBrowse.tf_VisibilityToRole",var_RoleName);
        } else {
        String var_RoleName = caller.retrieveString("KeyVisibilityRoleAdmin");
        //Type username
        caller.type("APIPublisherBrowse.tf_VisibilityToRole",var_RoleName);
        }
        caller.click("APIPublisherBrowse.btn_Save");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        caller.click("APIPublisherBrowse.btn_Save1");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_Close");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName,false,"");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        lib_Common.bc_StoreLogin(caller, param_Domain);
        //Wait for content load
        caller.pause("3000");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        //Wait for content load
        caller.pause("3000");
        lib_Common.bc_NavigateToPrototypedAPI(caller);
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName,false,"");
        caller.writeToReport("End of executing APIM_278");	
    }
    /**
     *  Business component APIM_280.
     */
    public final static void APIM_280(final SeleniumTestBase caller, final String param_VisibilityRestrictByRole) throws Exception {
        caller.writeToReport("Srart of executing APIM_280");
        //Test case name-------APIM-280: Try to save without adding any resource------------
        caller.click("APIPublisherHome.lnk_Browse");
        String APIName = caller.retrieveString("var_APIName");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for load content
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblGeneralDetails",false,"");
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_VisibilityRestrictByRole);
        //Wait for load content
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_Ok");
        caller.checkElementPresent("APIPublisherBrowse.tf_VisibilityToRole",false,"");
        caller.click("APIPublisherBrowse.btn_Save");
        caller.writeToReport("End of executing APIM_280");	
    }
    /**
     *  Business component APIM_23.
     */
    public final static void APIM_23(final SeleniumTestBase caller, final String param_APIVersion, final String param_URLPattern, final String param_APIName, final String param_tagName, final String param_storeURL, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of TC APIM-23");
        //Test case name------APIM-23: Create API from scratch and give necessary details and deploy as prototype------------
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        String varAPINamePrototype = param_APIName+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_APIName",varAPINamePrototype);
        //Store API name for furthur use
        caller.store("keyAPINamePrototype","String",varAPINamePrototype);
        //Type API contest
        String APIcontest = "api"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("6000");
        //click save and verify warning
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.pause("7000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("4000");
        lib_Common.bc_DeployAsPrototype(caller, varAPINamePrototype);
        caller.pause("4000");
        //Navigate to store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        lib_Common.bc_NavigateToPrototypedAPI(caller);
        caller.pause("5000");
        caller.checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + varAPINamePrototype,false,"");
        caller.pause("5000");
        caller.writeToReport("End of TC APIM-23");	
    }
    /**
     *  Business component APIM_24.
     */
    public final static void APIM_24(final SeleniumTestBase caller, final String param_EndpointType, final String param_EndpointUrl, final String param_Domain, final String param_publisherURL, final String param_storeURL) throws Exception {
        caller.writeToReport("End of executing APIM_24");
        //Test case name------APIM-24: Open an saved API in design stage and give the necessary details and deploy it as prototype------------
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //Wait for content load
        caller.pause("3000");
        String APINameTwo = caller.retrieveString("var_APIName");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",APINameTwo);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APINameTwo);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblGeneralDetails",false,"");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        //Wait for content load
        caller.pause("5000");
        if(!caller.checkElementPresent("APIPublisherBrowse.tf_productionEndpoint")){
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        //Wait for content load
        caller.pause("3000");
        } else if(caller.checkElementPresent("APIPublisherBrowse.tf_productionEndpoint")){
        caller.type("APIPublisherBrowse.tf_productionEndpoint",param_EndpointUrl);
        //Wait for content load
        caller.pause("3000");
        }
        //Wait for content load
        caller.pause("3000");
        lib_Common.bc_PrototypeAPI(caller);
        //Wait for content load
        caller.pause("3000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        lib_Common.bc_NavigateToPrototypedAPI(caller);
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APINameTwo,false,"");
        caller.writeToReport("End of executing APIM_24");	
    }
    /**
     *  Business component APIM_27.
     */
    public final static void APIM_27(final SeleniumTestBase caller, final String param_tagName, final String param_storeURL, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of TC APIM-27");
        //APIM-27: Tags of Prototype APIs should not be visible in the tags list
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"5000");
        caller.pause("3000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        caller.pause("4000");
        caller.checkObjectProperty("APIStoreAPIs.lnk_tagProtoType","param_tagName_PARAM:" + param_tagName,"ELEMENTPRESENT","false",false,"");
        caller.writeToReport("End of TC APIM-27");	
    }
    /**
     *  Business component APIM_25.
     */
    public final static void APIM_25(final SeleniumTestBase caller, final String param_APIName, final String param_storeURL, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of TC APIM-25");
        //APIM-25: Prototype APIs should not be visible in general store
        //Navigate to store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.pause("3000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantOrAdmin);
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","false",false,"");
        caller.pause("5000");
        caller.writeToReport("End of TC APIM-25");	
    }
    /**
     *  Business component APIM_26.
     */
    public final static void APIM_26(final SeleniumTestBase caller, final String param_TenantOrAdmin, final String param_APIName, final String param_storeURL) throws Exception {
        caller.writeToReport("Start of TC APIM-26");
        //APIM-26: Prototype APIs should not be visible in the recently added list
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.pause("3000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        if(!caller.checkElementPresent("APIStoreHome.lnk_login")){
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        caller.pause("3000");
        caller.click("APIStoreHome.btn_Logout");
        }
        lib_Common.bc_StoreLogin(caller, param_TenantOrAdmin);
        caller.checkObjectProperty("APIStoreAPIs.lnk_RecentlyViewedAPUI","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","false",false,"");
        caller.pause("5000");
        caller.writeToReport("End of TC APIM-26");	
    }
    /**
     *  Business component APIM_29.
     */
    public final static void APIM_29(final SeleniumTestBase caller, final String param_ValidUrl, final String param_InvalidUrl, final String param_APIPublisherUrl, final String param_ValidUrlSandBox, final String param_InvalidUrlSandBox) throws Exception {
        caller.writeToReport("Start of executing APIM_29");
        //APIM-29: Check the functionality of endpont "Test" button
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_APIPublisherUrl,"3000");
        String APINameTwo = caller.retrieveString("var_APIName");
        caller.type("APIPublisherHome.tf_APISearch",APINameTwo);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APINameTwo);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblPrototype");
        caller.type("APIPublisherBrowse.tf_prototypeEndpoint",param_ValidUrl);
        caller.click("APIPublisherBrowse.btn_test");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblValid",false,"");
        caller.type("APIPublisherBrowse.tf_prototypeEndpoint",param_InvalidUrl);
        caller.click("APIPublisherBrowse.btn_test");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblInvalid",false,"");
        //Wait for content load
        caller.pause("5000");
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_ValidUrlSandBox);
        caller.doubleClick("APIPublisherBrowse.btn_testSandBoxEndPoint");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblSandboxEndpointValid",false,"");
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_InvalidUrlSandBox);
        caller.click("APIPublisherBrowse.btn_testSandBoxEndPoint");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblInvalid",false,"");
        //Wait for content load
        caller.pause("4000");
        caller.writeToReport("End of executing APIM_29");	
    }
    /**
     *  Business component APIM_33.
     */
    public final static void APIM_33(final SeleniumTestBase caller, final String param_validEndpointUrl, final String param_Domain, final String param_storeURL) throws Exception {
        caller.writeToReport("Start of executing APIM_33");
        //APIM-33: Give a valid Production endpoint URL and publish the API and invoke it
        caller.type("APIPublisherBrowse.tf_productionEndpoint",param_validEndpointUrl);
        caller.click("APIPublisherBrowse.btn_Save");
        //Wait for content load
        caller.pause("3000");
        caller.doubleClick("APIPublisherBrowse.btn_NextManage");
        //Wait for content load
        caller.pause("6000");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Close");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        //Wait for content load
        caller.pause("3000");
        String APINameTwo = caller.retrieveString("var_APIName");
        //Wait for content load
        caller.pause("2000");
        caller.type("APIStoreHome.tf_APISearchStore",APINameTwo);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APINameTwo,false,"");
        caller.writeToReport("End of executing APIM_33");	
    }
    /**
     *  Business component APIM_34.
     */
    public final static void APIM_34(final SeleniumTestBase caller, final String param_APIVersion, final String param_APIImagePath, final String param_APIName, final String param_tagName, final String param_APIContext, final String param_storeURL, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of executing APIM_34");
        //Go for create new API up to create state
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        //start design stage
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        String varAPIName = param_APIName+caller.generateData("int",5);
        caller.store("keyAPIName","String",varAPIName);
        caller.type("APIPublisherAdd.tf_APIName",varAPIName);
        //Type API contest
        String varAPIContext = param_APIContext+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",varAPIContext);
        String varAPIVersion = param_APIVersion+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_APIVersion",varAPIVersion);
        //Type valid image path
        //Type
        //object=APIPublisherAdd.btn_BrowseImage
        //text=@param_APIImagePath
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("3000");
        //click save and verify warning
        caller.type("APIPublisherAdd.tf_URLPattern",varAPIName+"/"+varAPIContext);
        caller.click("APIPublisherAdd.chk_Post");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Add");
        caller.checkElementPresent("APIPublisherAdd.btn_Save",false,"");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("3000");
        //Go to implement stage
        caller.checkElementPresent("APIPublisherAdd.lnk_NextImplement",false,"");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.ele_lblPrototype");
        caller.click("APIPublisherBrowse.btn_SavePrototype");
        //Waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_DeployAsPrototype");
        //Waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Close");
        //waiting for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //waiting for content load
        caller.pause("5000");
        caller.click("APIStoreHome.lnk_PrototypedAPIs");
        //waiting for content load
        caller.pause("4000");
        caller.checkElementPresent("APIStorePrototypedAPIs.lnk_APIName","param_APIName_PARAM:" + varAPIName,false,"");
        caller.writeToReport("End of executing APIM_34");	
    }
    /**
     *  Business component APIM_32.
     */
    public final static void APIM_32(final SeleniumTestBase caller, final String param_SecuritySchemeSecured, final String param_endpointUsername, final String param_endpointPassword) throws Exception {
        caller.writeToReport("Start of executing APIM_32");
        //APIM-32: Apply Endpoint Security configuration to the API
        caller.click("APIPublisherBrowse.lnk_ShowmoreOption");
        caller.select("APIPublisherBrowse.ele_ddEndpointSecurityScheme",param_SecuritySchemeSecured);
        caller.type("APIPublisherBrowse.tf_endpointUserName","");
        caller.type("APIPublisherBrowse.tf_endPointPassword","");
        caller.click("APIPublisherBrowse.btn_Save");
        caller.checkElementPresent("APIPublisherBrowse.ele_lbl_credentialErrorMessege",false,"");
        //Wait for content load
        caller.pause("3000");
        caller.type("APIPublisherBrowse.tf_endpointUserName",param_endpointUsername);
        caller.type("APIPublisherBrowse.tf_endPointPassword",param_endpointPassword);
        caller.click("APIPublisherBrowse.btn_Save");
        //Wait for content load
        caller.pause("3000");
        caller.writeToReport("End of executing APIM_32");	
    }
    /**
     *  Business component APIM_39.
     */
    public final static void APIM_39(final SeleniumTestBase caller, final String param_APIName, final String param_ValidSandboxEndpoint, final String param_ValidProductionEndPoint, final String param_PublisherURL, final String param_APIContext, final String param_APIVersion, final String param_APIImagePath, final String param_tagName) throws Exception {
        caller.writeToReport("Start of executing APIM_39");
        //APIM-39: Set valid SOAP service endpoints for Production and Sandbox and check the "Test" button
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        String varAPINameOne = caller.retrieveString("keyAPIName");
        caller.type("APIPublisherHome.tf_APISearch",varAPINameOne);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPINameOne,false,"");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPINameOne);
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.lnk_Edit",false,"");
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("2000");
        //Go to implement stage
        caller.checkElementPresent("APIPublisherAdd.lnk_NextImplement",false,"");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ValidProductionEndPoint);
        caller.click("APIPublisherBrowse.btn_testProductionEndpoint");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblValid",false,"");
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_ValidSandboxEndpoint);
        caller.click("APIPublisherBrowse.btn_testSandBoxEndPoint");
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblValid",false,"");
        caller.writeToReport("End of executing APIM_39");	
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
        lib_Common.bc_DeployAsPrototype(caller, param_APIName);
        lib_Common.bc_EditAPI(caller, param_APIName);
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.click("APIPublisherBrowse.btn_NextManage");
        lib_Common.bc_SelectTiers(caller);
        caller.click("APIPublisherBrowse.btn_Save1");
        caller.pause("3000");	
    }
    /**
     *  Business component APIM_55.
     */
    public final static void APIM_55(final SeleniumTestBase caller, final String param_APIName, final String param_ProductionEndpointUrl, final String param_APIContext, final String param_APIVersion, final String param_APIImagePath, final String param_APITagName, final String param_APIPublisherUrl, final String param_Domain, final String param_storeURL) throws Exception {
        caller.writeToReport("Start of executing APIM_55");
        //APIM-55: Save an API in manage stage.
        //CreateAPI upto design Stage
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_APIPublisherUrl,"3000");
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        String APINameTwo = param_APIName+"_"+caller.generateData("int",3);
        caller.store("var_APIName","String",APINameTwo);
        caller.store("var_APINameTwo","String",APINameTwo);
        caller.type("APIPublisherAdd.tf_APIName",APINameTwo);
        //Type API contest
        String APIContextTwo = param_APIContext+"_"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",APIContextTwo);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //Type valid image path
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_APIImagePath);
        String entirePath = file.getAbsolutePath();
        caller.type("APIPublisherAdd.btn_BrowseImage",entirePath);
        String APITagNameTwo = param_APITagName+"_"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_Tags",APITagNameTwo);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("6000");
        //click save and verify warning
        caller.doubleClick("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.pause("7000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndpointUrl);
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Save1");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblThisFieldisRequired",false,"");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Save1");
        //waiting for content load
        caller.pause("4000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        //waiting for content load
        caller.pause("3000");
        caller.type("APIStoreHome.tf_APISearchStore",APINameTwo);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        //waiting for content load
        caller.pause("2000");
        if(!caller.checkElementPresent("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + APINameTwo + "_PARAM," + "param_version_PARAM:" + param_APIVersion)){
        caller.writeToReport("API not in Store");
        }
        caller.writeToReport("End of executing APIM_55");	
    }
    /**
     *  Business component APIM_217.
     */
    public final static void APIM_217(final SeleniumTestBase caller, final String param_APIName, final String param_ImagePath, final String param_txtPath, final String param_storeURL, final String param_APIContext, final String param_APIVersion, final String param_TenantOrAdmin) throws Exception {
        //APIM-217: Check whether user can successfully edit icon.
        caller.writeToReport("Start Executing APIM-217");
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Take API name as a parameter
        String varUpdateAPIs = param_APIName+caller.generateData("int",3);
        //storing API name
        caller.store("keyUpdateAPIs","String",varUpdateAPIs);
        caller.type("APIPublisherAdd.tf_APIName",varUpdateAPIs);
        //Take API context as a variable and Type
        String varAPIContext = param_APIContext+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",varAPIContext);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //Auto genarate tag
        String varAPITag = "@param_APITag"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_Tags",varAPITag);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("6000");
        //click save and verify warning
        caller.doubleClick("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.pause("7000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherHome.lnk_Browse");
        String varUpdateAPIsOne = caller.retrieveString("keyUpdateAPIs");
        caller.type("APIPublisherHome.tf_APISearch",varUpdateAPIsOne);
        //waiting for content load
        caller.pause("3000");
        lib_Common.bc_EditAPI(caller, varUpdateAPIsOne);
        caller.click("APIPublisherBrowse.lnk_ChangeIcon");
        //Type invalid image path
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_txtPath);
        String entirePathInvalidOne = file.getAbsolutePath();
        caller.type("APIPublisherAdd.btn_BrowseImage",entirePathInvalidOne);
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Save");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblInvalidImageError",false,"");
        caller.click("APIPublisherHome.lnk_Browse");
        lib_Common.bc_EditAPI(caller, varUpdateAPIs);
        caller.click("APIPublisherBrowse.lnk_ChangeIcon");
        //waiting for content load
        caller.pause("2000");
        //Type invalid image path
         java.io.File fileOne = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_ImagePath);
        String entirePathInvalid = fileOne.getAbsolutePath();
        caller.type("APIPublisherAdd.btn_BrowseImage",entirePathInvalid);
        caller.click("APIPublisherBrowse.btn_Save");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        lib_Common.bc_PrototypeAPI(caller);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("3000");
        caller.checkImagePresent("APIStoreAPIs.img_Uploaded",false,false,"");
        caller.pause("4000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantOrAdmin);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIStoreHome.lnk_PrototypedAPIs");
        //waiting for content load
        caller.pause("3000");
        caller.checkImagePresent("APIStoreAPIs.img_verificationStore",false,false,"");
        caller.writeToReport("End of  Executing APIM-217");	
    }
    /**
     *  Business component APIM_2A.
     */
    public final static void APIM_2A(final SeleniumTestBase caller, final String param_APIName, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_storeURL, final String param_publisherURL, final String param_APIContext, final String param_productionEndPoint, final String param_sandBoxEndPoint, final String param_appName, final String param_TenanrOrAdmin, final String param_ThrottlingTier) throws Exception {
        caller.writeToReport("Start of executing APIM_2A");
        //Go for create new API up to create state
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        //start design stage
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        String varAPIName = param_APIName+caller.generateData("int",3);
        caller.store("keyAPIName","String","varAPIName");
        caller.type("APIPublisherAdd.tf_APIName",varAPIName);
        //Type API contest
        String varAPIContext = param_APIContext+caller.generateData("int",4);
        caller.type("APIPublisherAdd.tf_APIContext",varAPIContext);
        String varAPIVersion = param_APIVersion+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_APIVersion",varAPIVersion);
        //Type valid image path
        //Type
        //object=APIPublisherAdd.btn_BrowseImage
        //text=@param_APIImagePath
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("6000");
        //click save and verify warning
        caller.type("APIPublisherAdd.tf_URLPattern",varAPIName+"/"+varAPIContext);
        caller.click("APIPublisherAdd.chk_Post");
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Add");
        caller.checkElementPresent("APIPublisherAdd.btn_Save",false,"");
        caller.pause("2000");
        caller.click("APIPublisherAdd.btn_Save");
        caller.pause("4000");
        //Go to implement stage
        caller.checkElementPresent("APIPublisherAdd.lnk_NextImplement",false,"");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("6000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        //waiting for content load
        caller.pause("3000");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_productionEndPoint);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_sandBoxEndPoint);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("4000");
        //Start manage stage
        caller.click("APIPublisherAdd.dd_tireAvailabilityConfig");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherAdd.chk_tireSelectionUnlimited");
        caller.click("APIPublisherAdd.btn_SavePublish");
        //waiting for content load
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblFinalClose",false,"");
        caller.click("APIPublisherAdd.ele_lblFinalClose");
        //APIM-(2):publish  API with subscribers  and  check whether user can delete
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        //waiting for content load
        caller.pause("3000");
        lib_Common.bc_SelectServer(caller, param_TenanrOrAdmin);
        //Login to API Store
        lib_Common.bc_StoreLogin(caller, param_TenanrOrAdmin);
        //Create new Application
        //waiting for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_MyApplication");
        String varAppName = param_appName+caller.generateData("int",3);
        caller.type("APIStoreMyApllication.tf_ApplicationName",varAppName);
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL","application/x-www-form-urlencoded");
        caller.type("APIStoreMyApllication.tf_Discription","test_dec");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        //waiting for content load
        caller.pause("8000");
        //Go to API window to Subscribe API to an application
        caller.click("APIStoreHome.lnk_APIs");
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + varAPIName,false,"");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + varAPIName);
        //waiting for content load
        caller.pause("3000");
        caller.select("APIStoreAPIs.ele_ddSelectAplicationToSubscribe",varAppName);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.btn_Subscribe");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.btn_StayOnThisPage");
        caller.checkElementPresent("APIStoreAPIs.btn_Subscribe",false,"");
        //Again navigate to store and try to delete the creted API
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",varAPIName);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        //Verify API is searched successfully
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPIName,false,"");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_deleteAPI","APIName_PARAM:" + varAPIName);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Yes");
        //waiting for content load
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIdeleteError",false,"");
        //Go to API Store to relese the bind API from the APP
        //APIM-(3):publish API without  subscribers  and  check whether user can delete
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_TenanrOrAdmin);
        //waiting for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_MySubcription");
        //waiting for content load
        caller.pause("4000");
        caller.select("APIStoreMySubcription.ele_ddApplicationWithSubscription",varAppName);
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIStoreMySubcription.btn_deleteAPI","param_APIName_PARAM:" + varAPIName + "_PARAM," + "Param_APIVersion_PARAM:" + varAPIVersion,false,"");
        caller.click("APIStoreMySubcription.btn_deleteAPI","param_APIName_PARAM:" + varAPIName + "_PARAM," + "Param_APIVersion_PARAM:" + varAPIVersion);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreMySubcription.btn_Yes");
        //waiting for content load
        caller.pause("2000");
        //Navigate to API Publisher to delete the API
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",varAPIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        //Verify API is searched successfully
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPIName,false,"");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_deleteAPI","APIName_PARAM:" + varAPIName);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Yes");
        //waiting for content load
        caller.pause("5000");
        caller.checkObjectProperty("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPIName,"ELEMENTPRESENT","false",false,"");
        caller.writeToReport("End of executing APIM_2A");	
    }
    /**
     *  Business component APIM_4A.
     */
    public final static void APIM_4A(final SeleniumTestBase caller, final String param_APIName, final String param_NewVersion, final String param_publisherURL) throws Exception {
        caller.writeToReport("Start of TC APIM-4A");
        //APIM-(4):Create New Version of already exsist API
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //create a new version
        caller.click("Browse_Overview.btn_CreateNewVersion");
        //insert a new version
        caller.type("Browse_Overview.tf_ToVersion",param_NewVersion);
        caller.click("Browse_Overview.btn_Done");
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.checkElementPresent("APIPublisherBrowse.lnk_DuplicateAPI","param_APIName_PARAM:" + param_APIName,false,"");
        caller.writeToReport("End of TC APIM-4A");	
    }
    /**
     *  Business component APIM_5A.
     */
    public final static void APIM_5A(final SeleniumTestBase caller, final String param_APIName, final String param_alreadyExistingVersion) throws Exception {
        caller.writeToReport("Start of TC APIM-5A");
        //APIM-(5):Create Same Version of already exsist API
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("Browse_Overview.btn_CreateNewVersion");
        caller.type("Browse_Overview.tf_ToVersion",param_alreadyExistingVersion);
        caller.click("Browse_Overview.btn_Done");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblPopupPublisherError",false,"");
        caller.click("APIPublisherBrowse.btn_Ok");
        caller.writeToReport("End of TC APIM-5A");	
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
        lib_Common.bc_LogOut_APIStore(caller, param_UserName);
        }
        lib_Common.bc_APIStoreLogin(caller, param_UserName,param_newPassword);
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIStoreHome.lnk_MySubcription");
        lib_Common.bc_DeleteSubcription(caller, param_APIName,param_Version);	
    }
    /**
     *  Business component APIM_127.
     */
    public final static void APIM_127(final SeleniumTestBase caller, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_APIName, final String param_State, final String param_NewVersion, final String param_creater, final String param_users, final String param_status, final String param_ProductionEndPont, final String param_SandBoxEndpoint) throws Exception {
        caller.writeToReport("Start of TC APIM-127");
        //APIM-127: Check whether system allows to get a copy of an api which is in blocked state
        //Create API In Prtotype
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        String varAPINameVersioning = param_APIName+caller.generateData("int",2);
        //Store in to variable
        caller.store("keyAPINameVersioning","String",varAPINameVersioning);
        caller.type("APIPublisherAdd.tf_APIName",varAPINameVersioning);
        //Type API contest
        String APIcontest = "api"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //Type valid image path
        /*
        Type
         object=APIPublisherAdd.btn_BrowseImage
         text=@param_APIImagePath
        */
        //Type API tag
        String varAPITag = param_tagName+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_Tags",varAPITag);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("6000");
        //click save and verify warning
        caller.doubleClick("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.pause("7000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("4000");
        lib_Common.bc_PrototypeAPI(caller);
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
        caller.click("browseLifecycle.btn_Update");
        //Wait for content load
        caller.pause("1000");
        caller.checkElementPresent("browseLifecycle.ele_lblUpdateSuccessMessage",false,"");
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
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVersionAndUser","param_APIName_PARAM:" + varAPINameVersioning + "_PARAM," + "param_version_PARAM:" + param_NewVersion + "_PARAM," + "param_creater_PARAM:" + param_creater,false,"");
        //Verify subscriber numbers
        caller.checkElementPresent("APIPublisherBrowse.ele_lblUsers","param_version_PARAM:" + param_NewVersion + "_PARAM," + "param_users_PARAM:" + param_users,false,"");
        //Verify status
        caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIStatus","param_status_PARAM:" + param_status,false,"");
        //Wait for content load
        caller.pause("5000");
        caller.writeToReport("End of TC APIM-127");	
    }
    /**
     *  Business component APIM_122.
     */
    public final static void APIM_122(final SeleniumTestBase caller, final String param_stage, final String param_newVersion, final String param_creater, final String param_status, final String param_users, final String param_APIName) throws Exception {
        caller.writeToReport("Start of TC APIM-122");
        //APIM-122: Check whether system allows to get a copy of an api which is in created state
        //Retriew API Name
        lib_Common.bc_Select_LifeCycleState(caller, param_stage,param_APIName);
        lib_Common.bc_CreateNewVersion_VerifyDetails(caller, param_newVersion,param_creater,param_APIName,param_status,param_users);
        caller.writeToReport("End of TC APIM-122");	
    }
    /**
     *  Business component APIM_123.
     */
    public final static void APIM_123(final SeleniumTestBase caller, final String param_stage, final String param_newVersion, final String param_creater, final String param_APIName, final String param_status, final String param_users) throws Exception {
        caller.writeToReport("Start of TC APIM-123");
        //APIM-123: Check whether system allows to get a copy of an api which is in published state.
        lib_Common.bc_Select_LifeCycleState(caller, param_stage,param_APIName);
        lib_Common.bc_CreateNewVersion_VerifyDetails(caller, param_newVersion,param_creater,param_APIName,param_status,param_users);
        caller.writeToReport("End of TC APIM-123");	
    }
    /**
     *  Business component APIM_124.
     */
    public final static void APIM_124(final SeleniumTestBase caller, final String param_stage, final String param_newVersion, final String param_creater, final String param_APIName, final String param_status, final String param_users) throws Exception {
        caller.writeToReport("Start of TC APIM-124");
        //APIM-124: Check whether system allows to get a copy of an api which is in prototyped state
        lib_Common.bc_Select_LifeCycleState(caller, param_stage,param_APIName);
        lib_Common.bc_CreateNewVersion_VerifyDetails(caller, param_newVersion,param_creater,param_APIName,param_status,param_users);
        caller.writeToReport("End of TC APIM-124");	
    }
    /**
     *  Business component APIM_125.
     */
    public final static void APIM_125(final SeleniumTestBase caller, final String param_stage, final String param_newVersion, final String param_creater, final String param_APIName, final String param_status, final String param_users) throws Exception {
        caller.writeToReport("Start of TC APIM-125");
        //APIM-125: Check whether system allows to get a copy of an api which is in deprecated state
        lib_Common.bc_Select_LifeCycleState(caller, param_stage,param_APIName);
        lib_Common.bc_CreateNewVersion_VerifyDetails(caller, param_newVersion,param_creater,param_APIName,param_status,param_users);
        caller.writeToReport("End of TC APIM-125");	
    }
    /**
     *  Business component APIM_126.
     */
    public final static void APIM_126(final SeleniumTestBase caller, final String param_stage, final String param_newVersion, final String param_creater, final String param_APIName, final String param_status, final String param_users) throws Exception {
        caller.writeToReport("Start of TC APIM-126");
        //APIM-126: Check whether system allows to get a copy of an api which is in retired state
        lib_Common.bc_Select_LifeCycleState(caller, param_stage,param_APIName);
        lib_Common.bc_CreateNewVersion_VerifyDetails(caller, param_newVersion,param_creater,param_APIName,param_status,param_users);
        caller.writeToReport("End of TC APIM-126");	
    }
    /**
     *  Business component APIM_419.
     */
    public final static void APIM_419(final SeleniumTestBase caller, final String param_APIName, final String param_docNameOne, final String param_uploadDocLocation, final String param_summary, final String param_updateSummary, final String param_URLLink, final String param_newVersion, final String param_otherName, final String param_docNameTwo, final String param_storeURL, final String param_state, final String param_publisherURL, final String param_DownloadFilePath, final String param_APIImagePath, final String param_oldVersion, final String param_createrDomain, final String param_productionEndpoint, final String param_sandboxEndpoint, final String param_TenantOrAdmin, final String param_downImagePopup) throws Exception {
        caller.writeToReport("Start of TC APIM_419");
        //APIM-419: Check whether user can edit and change content type of an existing hot to type document.
        //-------------------------------------------------------------- Start of precondition
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        String varAPINameEditChange = param_APIName+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIName",varAPINameEditChange);
        //Store API name for furthur use
        caller.store("keyAPINameEditChange","String",varAPINameEditChange);
        //Type API contest
        String APIcontest = "api"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_oldVersion);
        //Type valid image path
        String TagName = "tag"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_Tags",TagName);
        caller.pause("2000");
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("4000");
        //click save and verify warning
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.pause("7000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("4000");
        //To Navigate to publisher homepage to change API version
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("2000");
        caller.click("APIPublisherHome.tf_APISearch");
        caller.type("APIPublisherHome.tf_APISearch",varAPINameEditChange);
        caller.pause("2000");
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //select the created old version api
        caller.click("APIPublisherBrowse.ele_lblVersionAndUser","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_version_PARAM:" + param_oldVersion + "_PARAM," + "param_creater_PARAM:" + param_createrDomain);
        caller.pause("2000");
        //Upgrade API version no.
        caller.click("Browse_Overview.btn_CreateNewVersion");
        caller.click("Browse_Overview.tf_ToVersion");
        caller.type("Browse_Overview.tf_ToVersion",param_newVersion);
        caller.click("Browse_Overview.btn_Done");
        caller.pause("3000");
        caller.click("APIPublisherHome.tf_APISearch");
        caller.type("APIPublisherHome.tf_APISearch",varAPINameEditChange);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        //select the created old version api
        caller.click("APIPublisherBrowse.ele_lblVersionAndUser","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_version_PARAM:" + param_newVersion + "_PARAM," + "param_creater_PARAM:" + param_createrDomain);
        caller.pause("3000");
        //Deploy the API
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.pause("2000");
        lib_Common.bc_ImplementStage(caller, param_productionEndpoint,param_sandboxEndpoint);
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        caller.click("APIPublisherBrowse.chk_Unlimited");
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIManagePopupSuccess",false,"");
        caller.click("APIPublisherBrowse.btn_Close");
        caller.pause("2000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("4000");
        //---------- End of precondition
        caller.click("APIPublisherHome.tf_APISearch");
        caller.type("APIPublisherHome.tf_APISearch",varAPINameEditChange);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + varAPINameEditChange);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //Wait for content load
        caller.pause("2000");
        caller.select("APIPublisherBrowse.ele_ddState",param_state);
        //Wait for content load
        caller.pause("4000");
        caller.click("browseLifecycle.btn_Update");
        //Wait for content load
        caller.pause("4000");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        //genarate docName
        String varDocNameOne = param_docNameOne+"_"+caller.generateData("int",4);
        caller.pause("2000");
        //Store the Document name one
        caller.store("keyDocNameOne","String",varDocNameOne);
        caller.type("Browse_Doc.tf_DocName",varDocNameOne);
        caller.type("Browse_Doc.tf_Summary",param_summary);
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_HowTo");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("2000");
        //upload document  doc name
         java.io.File fileOne = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_uploadDocLocation);
        String entirePathOne = fileOne.getAbsolutePath();
        //type doc name
        caller.type("Browse_Doc.tf_BrowseFile",entirePathOne);
        caller.pause("5000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("5000");
        caller.checkElementPresent("Browse_Doc.ele_lblCreatedDocName","param_DocName_PARAM:" + varDocNameOne,false,"");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + varDocNameOne);
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
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("5000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        //Wait for content load
        caller.pause("4000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkElementPresent("APIStoreDocumentation.lnk_HowTo",false,"");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameOne,false,"");
        //Wait for content load
        caller.pause("4000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_updateSummary,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameOne + "_PARAM," + "param_URLLink_PARAM:" + param_URLLink,false,"");
        //Wait for content load
        caller.pause("5000");
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + varAPINameEditChange);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + varDocNameOne);
        //Wait for content load
        caller.pause("5000");
        caller.click("Browse_Doc.rdo_Inline");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + varDocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        //navigate to store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameOne,false,"");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_updateSummary,false,"");
        //navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + varAPINameEditChange);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + varDocNameOne);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_File");
        //upload document  doc name
         java.io.File fileTwo = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_uploadDocLocation);
        String entirePathTwo = fileTwo.getAbsolutePath();
        //type doc name
        caller.type("Browse_Doc.tf_BrowseFile",entirePathTwo);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("6000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + varDocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_version_PARAM:" + param_newVersion);
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
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocNameOne,false,"");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_updateSummary,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + varDocNameOne);
        //wait for download the file
        caller.pause("3000");
        caller.pause("2000");
        //Download image verification for firefox browser
        String downImagePopup1 = param_downImagePopup;
        if(caller.checkImagePresent(downImagePopup1,false)){
        caller.fireEvent("KEY%key=alt+s","2000");
        caller.fireEvent("KEY%key=alt+a","2000");
        caller.fireEvent("KEY%key=\n","1000");
        }
        //Wait for content load
        caller.pause("8000");
        caller.checkFileInfo(param_DownloadFilePath,"EXIST",false,"");
        //Wait for content load
        caller.pause("5000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + varAPINameEditChange);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + varDocNameOne);
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
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + varDocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        //Wait for content load
        caller.pause("5000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_updateSummary,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + varDocNameOne + "_PARAM," + "param_URLLink_PARAM:" + param_URLLink,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + varAPINameEditChange);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + varDocNameOne);
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
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + varDocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_updateSummary,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + varDocNameOne,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + varAPINameEditChange);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        //genarate docName
        String varDocNameTwo = param_docNameTwo+"_"+caller.generateData("int",4);
        //Store doc name two
        caller.store("keyDocNameTwo","String",varDocNameTwo);
        caller.type("Browse_Doc.tf_DocName",varDocNameTwo);
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
        //upload document  doc name
         java.io.File fileThree = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_uploadDocLocation);
        String entirePathThree = fileThree.getAbsolutePath();
        //type doc name
        caller.type("Browse_Doc.tf_BrowseFile",entirePathThree);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblCreatedDocName","param_DocName_PARAM:" + varDocNameTwo,false,"");
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("APIStoreDocumentation.lnk_HowTo",false,"");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + varDocNameTwo,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + varAPINameEditChange);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + varDocNameTwo);
        //Waiting for content to load
        caller.pause("2000");
        caller.click("APIPublisherAdd.btn_Yes");
        //Waiting for content to load
        caller.pause("5000");
        //verify doc is deleted
        if(!caller.checkElementPresent("Browse_Doc.ele_lblCreatedDocName","param_DocName_PARAM:" + varDocNameTwo)){
        caller.writeToReport("Doc is deleted");
        } else {
        caller.writeToReport("Doc is  not deleted");
        }
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + varAPINameEditChange + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Verify doc is deleted
        if(!caller.checkElementPresent("APIStoreDocumentation.lnk_HowTo")){
        caller.writeToReport("Doc is deleted");
        } else {
        caller.writeToReport("Doc is  not deleted");
        }
        caller.writeToReport("End of TC APIM_419");	
    }
    /**
     *  Business component APIM_418.
     */
    public final static void APIM_418(final SeleniumTestBase caller, final String param_DocNameOne, final String param_summaryNew, final String param_NewURL, final String param_APIName, final String param_Other_Name, final String param_newVersion, final String param_storeURL, final String param_publisherURL, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of TC APIM_418");
        //APIM-418: Check whether user can edit existing 'other' type docs which has URL content type.
        //navigate to publisher
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
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
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
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
        //verify summery,type,source
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
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + param_DocNameOne,false,"");
        caller.pause("5000");
        //Wait for content load
        caller.pause("3000");
        //navigate to store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Wait for content load
        caller.pause("2000");
        //verify the new summery and new url
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_DocNameOne + "_PARAM," + "param_URLLink_PARAM:" + param_NewURL,false,"");
        caller.writeToReport("End of TC APIM_418");	
    }
    /**
     *  Business component APIM_417.
     */
    public final static void APIM_417(final SeleniumTestBase caller, final String param_publisherURL, final String param_DocNameOne, final String param_URL, final String param_summaryNew, final String param_NewURL, final String param_APIName, final String param_newVersion, final String param_storeURL, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of TC APIM_417");
        //APIM-417: Check whether user can edit existing 'Support forum' type docs which has URL content type.
        //navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_SupportForum");
        //Wait for content load
        caller.pause("4000");
        caller.type("Browse_Doc.tf_URL",param_URL);
        //Wait for content load
        caller.pause("4000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("2000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
        //Wait for content load
        caller.pause("2000");
        //verify summery,type,source
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
        //verify support forum
        caller.checkElementPresent("Browse_Doc.ele_SupportForum","param_docName_PARAM:" + param_DocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        //Wait for content load
        caller.pause("2000");
        //verify  url link and document summery
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_DocNameOne + "_PARAM," + "param_URLLink_PARAM:" + param_NewURL,false,"");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.writeToReport("End of TC APIM_417");	
    }
    /**
     *  Business component APIM_416.
     */
    public final static void APIM_416(final SeleniumTestBase caller, final String param_DocNameOne, final String param_URL, final String param_APIName, final String param_newVersion, final String param_summaryNew, final String param_NewURL, final String param_publisherURL, final String param_storeURL, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of TC APIM_416");
        //APIM-416: Check whether user can edit existing 'Public forum' type docs which has URL content type.
        //navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_PublicForum");
        //Wait for content load
        caller.pause("4000");
        caller.type("Browse_Doc.tf_URL",param_URL);
        //Wait for content load
        caller.pause("4000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
        //verify summery,type,source
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        caller.type("Browse_Doc.tf_Summary",param_summaryNew);
        caller.type("Browse_Doc.tf_URL",param_NewURL);
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("2000");
        //verify public forum
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + param_DocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        //verify url link and document summery
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_DocNameOne + "_PARAM," + "param_URLLink_PARAM:" + param_NewURL,false,"");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.writeToReport("End of TC APIM_416");	
    }
    /**
     *  Business component APIM_415.
     */
    public final static void APIM_415(final SeleniumTestBase caller, final String param_DocNameOne, final String param_URL, final String param_summaryNew, final String param_NewURL, final String param_newVersion, final String param_APIName, final String param_publisherURL, final String param_storeURL, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of TC APIM_415");
        //APIM-415: Check whether user can edit existing 'Samples & SDK' type docs which has URL content type.
        //navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Wait for content load
        caller.pause("5000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_newVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
        caller.pause("2000");
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
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
        //Wait for content load
        caller.pause("2000");
        //verify summery,type and source
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
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + param_DocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        //navigate to store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_Samples");
        //verify document summery and url link
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_DocNameOne + "_PARAM," + "param_URLLink_PARAM:" + param_NewURL,false,"");
        caller.writeToReport("End of TC APIM_415");	
    }
    /**
     *  Business component APIM_413.
     */
    public final static void APIM_413(final SeleniumTestBase caller, final String param_other_Name, final String param_DocNameOne, final String param_summaryNew, final String param_editContent, final String param_APIName, final String param_newVersion, final String param_storeURL, final String param_publisherURL, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of TC APIM_413");
        //APIM-413: Check whether user can edit existing 'other' type docs which has in-line content type.
        //navigate to publisher
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
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
        caller.click("Browse_Doc.rdo_Other");
        //Wait for content load
        caller.pause("5000");
        caller.type("Browse_Doc.tf_Other",param_other_Name);
        //Wait for content load
        caller.pause("3000");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("3000");
        //verify lable other
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + param_DocNameOne,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_DocNameOne);
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
        //navigate to default window
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("5000");
        //verify lable other
        caller.checkElementPresent("Browse_Doc.ele_lblOther","param_docName_PARAM:" + param_DocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        //navigate to store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Wait for content load
        caller.pause("1000");
        //verify document name, view content and document summery
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_DocNameOne,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_DocNameOne,false,"");
        //Verify summary
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.writeToReport("End of TC APIM_413");	
    }
    /**
     *  Business component APIM_412.
     */
    public final static void APIM_412(final SeleniumTestBase caller, final String param_DocNameOne, final String param_editContent, final String param_APIName, final String param_newVersion, final String param_publisherURL, final String param_storeURL, final String param_summaryNew, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of TC APIM_412");
        //APIM-412: Check whether user can edit existing 'samples & SDK' type docs which has in-line content type.
        //navigate to publisher
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
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        //Wait for content load
        caller.pause("2000");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("2000");
        //verify lable samples
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + param_DocNameOne,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_DocNameOne);
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
        //verify lable samples
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + param_DocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        //navigate to store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Samples",false,"");
        caller.click("APIStoreDocumentation.lnk_Samples");
        caller.pause("2000");
        //verify document name, view content and socument summery
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_DocNameOne,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_DocNameOne,false,"");
        //Verify summary
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.writeToReport("End of TC APIM_412");	
    }
    /**
     *  Business component APIM_411.
     */
    public final static void APIM_411(final SeleniumTestBase caller, final String param_DocNameOne, final String param_editContent, final String param_APIName, final String param_newVersion, final String param_publisherURL, final String param_storeURL, final String param_summaryNew, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of TC APIM_411");
        //APIM-411: Check whether user can edit existing how to type docs which has in-line content type.
        //navigate to publisher
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
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
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
        //verify lable howto
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_DocNameOne,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + param_DocNameOne);
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
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_DocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //verify link how to
        caller.checkElementPresent("APIStoreDocumentation.lnk_HowTo",false,"");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Wait for content load
        caller.pause("1000");
        //verify document name, document summery and view content
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + param_DocNameOne,false,"");
        //Verify summary
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + param_DocNameOne,false,"");
        caller.writeToReport("End of TC APIM_411");	
    }
    /**
     *  Business component APIM_414.
     */
    public final static void APIM_414(final SeleniumTestBase caller, final String param_URL, final String param_DocNameOne, final String param_summaryNew, final String param_NewURL, final String param_APIName, final String param_newVersion, final String param_publisherURL, final String param_storeURL, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of TC APIM_414");
        //APIM-414: Check whether user can edit existing 'how to' type docs which has URL content type.
        //navigate to publisher
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
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
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
        //verify lable how to
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + param_DocNameOne,false,"");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + param_DocNameOne);
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_Summary",param_summaryNew);
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_NewURL);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"2000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion);
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //verify link url and document summery
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + param_DocNameOne + "_PARAM," + "param_URLLink_PARAM:" + param_NewURL,false,"");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentSummary","param_docSummery_PARAM:" + param_summaryNew,false,"");
        caller.writeToReport("End of TC APIM_414");	
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
        caller.writeToReport("Start of TC APIM-131");
        //APIM-131: Check whether cancel button on add new version section is working.
        caller.click("APIPublisherHome.lnk_Browse");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Overview.btn_CreateNewVersion");
        caller.checkElementPresent("Browse_Overview.tf_ToVersion",false,"");
        caller.click("Browse_Overview.btn_CancelNewVersion");
        caller.checkElementPresent("Browse_Overview.btn_CreateNewVersion",false,"");
        caller.writeToReport("End of TC APIM-131");	
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
    public final static void APIM_175(final SeleniumTestBase caller, final String param_ProductionEndPontJaxRS, final String param_URLPattern, final String param_verbMethodGET, final String param_verbMethodPOST, final String param_verbMethodPUT, final String param_verbMethodDELETE, final String param_User, final String param_publisherURL, final String param_AdminUserAdmin, final String param_AdminPassword, final String param_scopeKeyOne, final String param_tag, final String param_scopeNameOne, final String param_scopeKeyTwo, final String param_scopeNameTwo, final String param_scopeKeyThree, final String param_scopeNameThree, final String param_scopeKeyFour, final String param_scopeNameFour, final String param_APIName, final String paramAPIContest, final String param_TenantOrAdmin) throws Exception {
        //APIM-175: Check whether user can add different scopes for different resources.
        caller.writeToReport("Start of executing APIM_175");
        //CreateAPI up to design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        String varAPIName = param_APIName+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_APIName",varAPIName);
        caller.store("keyAPIName","String",varAPIName);
        //Type API contest
        String APIcontest = paramAPIContest+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        String APIversion = "v1.0."+caller.generateData("int",1);
        caller.type("APIPublisherAdd.tf_APIVersion",APIversion);
        //Type valid image path
        String APItag = param_tag+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_Tags",APItag);
        //waiting for content load
        caller.pause("2000");
        caller.fireEvent("KEY%key=\n","2000");
        caller.type("APIPublisherAdd.tf_URLPattern",param_URLPattern);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbMethodGET);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbMethodPOST);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbMethodPUT);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbMethodDELETE);
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Yes");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //API Manage Section
        lib_Common.bc_ManagedAPI(caller, varAPIName,param_ProductionEndPontJaxRS,"");
        lib_Common.bc_SelectTiers(caller);
        //waiting for content load
        caller.pause("500");
        String varScopeKeyOne = param_scopeKeyOne+caller.generateData("int",3);
        String varScopeNameOne = param_scopeNameOne+caller.generateData("int",3);
        caller.store("keyScopeKeyOne","String",varScopeKeyOne);
        caller.store("keyScopeOne","String",varScopeNameOne);
        //Add Scope Section
        lib_Common.bc_AddScopes(caller, varScopeKeyOne,varScopeNameOne);
        //waiting for content load
        caller.pause("2000");
        String varScopeKeyTwo = param_scopeKeyTwo+caller.generateData("int",3);
        String varScopeNameTwo = param_scopeNameTwo+caller.generateData("int",3);
        caller.store("keyScopeKeyTwo","String",varScopeKeyTwo);
        caller.store("keyScopeTwo","String",varScopeNameTwo);
        lib_Common.bc_AddScopes(caller, varScopeKeyTwo,varScopeNameTwo);
        //waiting for content load
        caller.pause("2000");
        String varScopeKeyThree = param_scopeKeyThree+caller.generateData("int",3);
        String varScopeNameThree = param_scopeNameThree+caller.generateData("int",3);
        caller.store("keyScopeThree","String",varScopeNameThree);
        lib_Common.bc_AddScopes(caller, varScopeKeyThree,varScopeNameThree);
        caller.pause("2000");
        String varScopeKeyFour = param_scopeKeyFour+caller.generateData("int",3);
        String varScopeNameFour = param_scopeNameFour+caller.generateData("int",3);
        caller.store("keyScopeFour","String",varScopeNameFour);
        lib_Common.bc_AddScopes(caller, varScopeKeyFour,varScopeNameFour);
        //waiting for content load
        caller.pause("2000");
        //Selecting already added Scope
        lib_Common.bc_SelectScope(caller, param_verbMethodGET,varScopeNameOne);
        //waiting for content load
        caller.pause("500");
        lib_Common.bc_SelectScope(caller, param_verbMethodPOST,varScopeNameTwo);
        //waiting for content load
        caller.pause("500");
        lib_Common.bc_SelectScope(caller, param_verbMethodPUT,varScopeNameThree);
        caller.pause("500");
        lib_Common.bc_SelectScope(caller, param_verbMethodDELETE,varScopeNameFour);
        //waiting for content load
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_Close");
        //waiting for content load
        caller.pause("4000");
        //Log out from current user
        caller.click("APIPublisherLogOut.btn_SignOut");
        caller.click("APIPublisherLogOut.btn_LogOut");
        if(param_TenantOrAdmin.equals("Tenant")){
        String varPublisherUserName = caller.retrieveString("keyTenantOneAdminUser");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        } else {
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_AdminUserAdmin);
        }
        caller.pause("2000");
        if(param_TenantOrAdmin.equals("Tenant")){
        String varPublisherPassword = caller.retrieveString("keyTenantOneAdminUserPassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else {
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_AdminPassword);
        }
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");
        //================
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPIName);
        caller.pause("1000");
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.pause("1000");
        caller.click("APIPublisherBrowse.btn_Manage");
        caller.pause("1000");
        //Verify Added Scopes
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyOne,false,"");
        caller.pause("1000");
        //Verify Added Scopes
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyTwo,false,"");
        caller.pause("1000");
        //Verify Added Scopes
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyThree,false,"");
        caller.pause("1000");
        //Verify Added Scopes
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyFour,false,"");
        caller.writeToReport("End of Execution APIM_175");	
    }
    /**
     *  Business component APIM_170.
     */
    public final static void APIM_170(final SeleniumTestBase caller, final String param_InvalidKey, final String param_ScopeDescription, final String param_publisherURL, final String param_TenantOrAdmin) throws Exception {
        //APIM-170: User should get validation message for special characters.
        caller.writeToReport("Start of executing APIM_170");
        //Log out from user
        caller.click("APIPublisherLogOut.btn_SignOut");
        caller.click("APIPublisherLogOut.btn_LogOut");
        //Login to publisher
        lib_Common.bc_PublisherLogin(caller, param_publisherURL,param_TenantOrAdmin);
        caller.click("APIPublisherHome.lnk_Browse");
        String varAPINameOne = caller.retrieveString("keyAPIName");
        //Navigate to an existing API
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPINameOne);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.click("APIPublisherBrowse.btn_Manage");
        caller.click("Scopes.btn_AddScope");
        caller.checkElementPresent("Scopes.tf_ScopeKey",false,"");
        caller.pause("2000");
        String varScopeKeyOne2 = caller.retrieveString("keyScopeKeyOne");
        //Add Different Scope keys and Names
        caller.type("Scopes.tf_ScopeKey",varScopeKeyOne2);
        caller.pause("2000");
        String varScopeNameOne3 = caller.retrieveString("keyScopeOne");
        caller.type("Scopes.tf_ScopeName",varScopeNameOne3);
        caller.type("Scopes.tf_Description",param_ScopeDescription);
        caller.pause("4000");
        caller.click("Scopes.btn_SubmitScope");
        caller.pause("2000");
        //Verify Already Exist Error
        caller.checkElementPresent("Scopes.ele_lblAlreadyExistError","scopeKey_PARAM:" + varScopeKeyOne2,false,"");
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
        caller.writeToReport("End of Execution APIM_170");	
    }
    /**
     *  Business component APIM_171.
     */
    public final static void APIM_171(final SeleniumTestBase caller, final String param_ScopeKeySix, final String param_ScopeNameSix) throws Exception {
        //APIM-171: Check whether user gets an validation message when trying to add scopes with duplicate key.
        caller.writeToReport("Start of executing APIM_171");
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        String varAPINameOne = caller.retrieveString("keyAPIName");
        //Navigate to API edit Section
        lib_Common.bc_EditAPI(caller, varAPINameOne);
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.pause("3000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.pause("2000");
        String varScopeKeySix = param_ScopeKeySix+caller.generateData("int",3);
        String varScopeNameSix = param_ScopeNameSix+caller.generateData("int",3);
        caller.pause("1000");
        //Adding a Same Scope Key and Name to Verify Already Exist Error
        caller.click("Scopes.btn_AddScope");
        caller.pause("4000");
        caller.type("Scopes.tf_ScopeKey",varScopeKeySix);
        caller.type("Scopes.tf_ScopeName",varScopeNameSix);
        caller.pause("2000");
        caller.click("Scopes.btn_SubmitScope");
        caller.pause("1000");
        caller.click("Scopes.btn_AddScope");
        caller.pause("4000");
        caller.type("Scopes.tf_ScopeKey",varScopeKeySix);
        caller.type("Scopes.tf_ScopeName",varScopeNameSix);
        caller.pause("2000");
        caller.click("Scopes.btn_SubmitScope");
        caller.pause("1000");
        caller.checkElementPresent("Scopes.ele_lblAlreadyExistError","scopeKey_PARAM:" + varScopeKeySix,false,"");
        caller.pause("4000");
        caller.click("Scopes.btn_OK");
        caller.pause("3000");
        caller.writeToReport("endTestCase");
        caller.writeToReport("End of Execution APIM_171");	
    }
    /**
     *  Business component APIM_349.
     */
    /**
     *  Business component APIM_349.
     */
    public final static void APIM_349(final SeleniumTestBase caller) throws Exception {
        //APIM-349: User should not be create to add a document without document name
        caller.writeToReport("Start of APIM_349");
        caller.click("APIPublisherHome.lnk_Browse");
        //Retrieve the  stored API name
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Click on add new document
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblNameRequiredWarningMessage",false,"");
        caller.writeToReport("End of APIM_349");	
    }
    /**
     *  Business component APIM_173.
     */
    /**
     *  Business component APIM_173.
     */
    public final static void APIM_173(final SeleniumTestBase caller) throws Exception {
        //APIM-173: Check whether user can exit from the define scope window by clicking on the 'x' sign on the window
        caller.writeToReport("Start of executing APIM_173");
        caller.pause("3000");
        caller.click("Scopes.btn_topXClose");
        caller.pause("6000");
        caller.checkElementPresent("Scopes.ele_lblResources",false,"");
        caller.pause("1000");
        caller.writeToReport("End of Execution APIM_173");	
    }
    /**
     *  Business component APIM_168.
     */
    /**
     *  Business component APIM_168.
     */
    public final static void APIM_168(final SeleniumTestBase caller) throws Exception {
        //APIM-168: Check whether compulsory fields are marked with a red star.
        caller.writeToReport("Start of executing APIM_168");
        caller.pause("4000");
        caller.click("Scopes.btn_AddScope");
        caller.pause("4000");
        caller.checkElementPresent("Scopes.ele_lblscopeKeyRequiredAstrix",false,"");
        caller.checkElementPresent("Scopes.ele_lblScopeNameRequiredAstrix",false,"");
        caller.pause("4000");
        caller.click("Scopes.btn_Close");
        caller.pause("3000");
        caller.writeToReport("End of Execution APIM_168");	
    }
    /**
     *  Business component APIM_166.
     */
    public final static void APIM_166(final SeleniumTestBase caller, final String param_ScopeKeyFive, final String param_ScopeNameFive) throws Exception {
        //APIM-166: User should be able to add scopes in the manage stage when creating an API
        caller.writeToReport("Start of executing APIM_166");
        String varScopeKeyFive = param_ScopeKeyFive+caller.generateData("int",3);
        caller.store("keyScopeKeyFive","String",varScopeKeyFive);
        caller.pause("2000");
        String varScopeNameFive = param_ScopeNameFive+caller.generateData("int",3);
        caller.store("keyScopeFive","String",varScopeNameFive);
        caller.pause("2000");
        caller.click("Scopes.btn_AddScope");
        caller.pause("4000");
        caller.type("Scopes.tf_ScopeKey",varScopeKeyFive);
        caller.type("Scopes.tf_ScopeName",varScopeNameFive);
        caller.pause("3000");
        caller.click("Scopes.btn_SubmitScope");
        caller.pause("2000");
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeyFive,false,"");
        caller.pause("3000");
        caller.writeToReport("End of Execution APIM_166");	
    }
    /**
     *  Business component APIM_176.
     */
    /**
     *  Business component APIM_176.
     */
    public final static void APIM_176(final SeleniumTestBase caller) throws Exception {
        //APIM-176: Check whether scopes get loaded successfully into the scope selection drop down in front of resource
        caller.writeToReport("Start of executing APIM_176");
        String varScopeKeyOne = caller.retrieveString("keyScopeKeyOne");
        String varScopeNameOne = caller.retrieveString("keyScopeOne");
        String varScopeNameTwo = caller.retrieveString("keyScopeTwo");
        String varScopeNameThree = caller.retrieveString("keyScopeThree");
        String varScopeNameFour = caller.retrieveString("keyScopeFour");
        String varScopeNameFive = caller.retrieveString("keyScopeFive");
        String varScopeNameSix = caller.retrieveString("keyScopeName");
        caller.click("Scopes.btn_ScopeParam","Scope_PARAM:" + varScopeKeyOne);
        caller.click("Scopes.ele_ddScope");
        //Verify already added Scope names
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameOne,false,"");
        caller.pause("500");
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameTwo,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameThree,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFour,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameFive,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Scopes.ele_ddOptions","scopeName_PARAM:" + varScopeNameSix,false,"");
        caller.pause("500");
        caller.pause("2000");
        caller.writeToReport("End of Execution APIM_176");	
    }
    /**
     *  Business component APIM_167.
     */
    public final static void APIM_167(final SeleniumTestBase caller, final String param_ScopeKeySix, final String param_ScopeNameSix) throws Exception {
        //APIM-167: Check whether user can add scope to a created API using edit view
        caller.writeToReport("Start of executing APIM_167");
        String varScopeKeySix = param_ScopeKeySix+caller.generateData("int",3);
        String varScopeNameSix = param_ScopeNameSix+caller.generateData("int",3);
        caller.store("keyScopeName","String",varScopeNameSix);
        caller.pause("1000");
        //Adding Scope Key and Name
        caller.click("Scopes.btn_AddScope");
        caller.pause("4000");
        caller.type("Scopes.tf_ScopeKey",varScopeKeySix);
        caller.type("Scopes.tf_ScopeName",varScopeNameSix);
        caller.pause("4000");
        caller.click("Scopes.btn_SubmitScope");
        caller.pause("3000");
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeySix,false,"");
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Save1");
        caller.pause("4000");
        caller.click("APIPublisherHome.lnk_Browse");
        String varAPINameOne = caller.retrieveString("keyAPIName");
        //Navigate to API Edit Section
        lib_Common.bc_EditAPI(caller, varAPINameOne);
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //Verify Already added Scopes
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeySix,false,"");
        caller.writeToReport("End of Execution APIM_167");	
    }
    /**
     *  Business component APIM_174.
     */
    /**
     *  Business component APIM_174.
     */
    public final static void APIM_174(final SeleniumTestBase caller) throws Exception {
        //APIM-174: Check whether user can exit from the define scope window by clicking
        caller.writeToReport("Start of executing APIM_174");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        String varAPINameOne = caller.retrieveString("keyAPIName");
        //Navigate to Api Edit Section
        lib_Common.bc_EditAPI(caller, varAPINameOne);
        caller.pause("1000");
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
        caller.writeToReport("End of Execution APIM_174");	
    }
    /**
     *  Business component APIM_169.
     */
    public final static void APIM_169(final SeleniumTestBase caller, final String param_scopeKeySeven, final String param_scopeNameSeven) throws Exception {
        //APIM-169: Check whether user gets a validation message for empty compulsory fields.
        caller.writeToReport("Start of executing APIM_169");
        caller.click("Scopes.btn_AddScope");
        caller.pause("3000");
        caller.click("Scopes.btn_SubmitScope");
        //Verify the Field Errors
        caller.checkElementPresent("Scopes.ele_lblRequiredFieldError",false,"");
        caller.pause("3000");
        caller.checkElementPresent("Scopes.ele_lblRequiredFieldError2",false,"");
        caller.pause("3000");
        String varScopeKeySeven = param_scopeKeySeven+caller.generateData("int",2);
        caller.type("Scopes.tf_ScopeKey",varScopeKeySeven);
        caller.pause("4000");
        caller.click("Scopes.btn_SubmitScope");
        caller.checkElementPresent("Scopes.ele_lblRequiredFieldError2",false,"");
        caller.pause("3000");
        caller.type("Scopes.tf_ScopeKey",varScopeKeySeven);
        caller.pause("3000");
        String varScopeNameSeven = param_scopeNameSeven+caller.generateData("int",2);
        caller.type("Scopes.tf_ScopeName",varScopeNameSeven);
        caller.pause("4000");
        caller.click("Scopes.btn_SubmitScope");
        //Verify Submitted Scopes
        caller.checkElementPresent("Scopes.ele_lblAddedScopes","param_ScopeKey_PARAM:" + varScopeKeySeven,false,"");
        caller.pause("4000");
        caller.click("Scopes.btn_Close");
        caller.pause("2000");
        caller.writeToReport("End of Execution APIM_169");	
    }
    /**
     *  Business component APIM_177.
     */
    /**
     *  Business component APIM_177.
     */
    public final static void APIM_177(final SeleniumTestBase caller) throws Exception {
        //APIM-177: Check whether user can edit and change scope already assigned to the resource into a different scope
        caller.writeToReport("Start of executing APIM_177");
        caller.click("APIPublisherHome.lnk_Browse");
        String varAPINameOne = caller.retrieveString("keyAPIName");
        //Navigate to Edit API section
        lib_Common.bc_EditAPI(caller, varAPINameOne);
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.pause("1000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.pause("1000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.pause("2000");
        String varScopeKeyOne3 = caller.retrieveString("keyScopeKeyOne");
        caller.click("Scopes.btn_ScopeParam","Scope_PARAM:" + varScopeKeyOne3);
        String varScopeNameFive4 = caller.retrieveString("keyScopeFive");
        caller.select("Scopes.ele_ddScope",varScopeNameFive4);
        caller.pause("3000");
        caller.click("Scopes.btn_Right");
        String varScopeKeyTwo8 = caller.retrieveString("keyScopeKeyTwo");
        caller.click("Scopes.btn_ScopeParam","Scope_PARAM:" + varScopeKeyTwo8);
        String varScopeNameSix2 = caller.retrieveString("keyScopeName");
        caller.select("Scopes.ele_ddScope",varScopeNameSix2);
        caller.pause("3000");
        caller.click("Scopes.btn_Right");
        caller.pause("3000");
        caller.writeToReport("End of Execution APIM_177");	
    }
    /**
     *  Business component APIM_73.
     */
    public final static void APIM_73(final SeleniumTestBase caller, final String param_APIName, final String param_urlPatternSC, final String param_verbGet, final String param_verbPost, final String param_APIContext, final String param_APITag, final String param_URLPatternSandbox, final String param_APIVersion) throws Exception {
        //APIM-73: Ability to define the templates in publisher
        caller.writeToReport("Start Executing APIM-73");
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Take API name as a parameter
        String varAPINameURITemplate = param_APIName+caller.generateData("int",3);
        //storing API name
        caller.store("keyAPINameURITemplate","String",varAPINameURITemplate);
        caller.type("APIPublisherAdd.tf_APIName",varAPINameURITemplate);
        //Take API context as a variable and Type
        String varAPIContext = param_APIContext+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",varAPIContext);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //adding an image
        /*
        //Type valid image path
        Type
        object=APIPublisherAdd.btn_BrowseImage
         text=@param_APIImagePath
        */
        String varAPITag = param_APITag+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_Tags",varAPITag);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("6000");
        //click save and verify warning
        caller.doubleClick("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.pause("7000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("4000");
        //browse for the API
        caller.click("APIPublisherHome.lnk_Browse");
        //starting to edit the API
        lib_Common.bc_EditAPI(caller, param_APIName);
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatternSC);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbGet);
        //waiting for content load
        caller.pause("500");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPost);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Add");
        //waiting for content load
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbGet + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternSC,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbPost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternSC,false,"");
        caller.writeToReport("End of  Executing APIM-73");	
    }
    /**
     *  Business component APIM_74.
     */
    public final static void APIM_74(final SeleniumTestBase caller, final String param_urlPatternUriTemplate, final String param_verbGet, final String param_verbPost) throws Exception {
        //APIM-74: user should be able to define complex uri - templates having many parameters
        caller.writeToReport("Start Executing APIM-74");
        caller.click("APIPublisherHome.lnk_Browse");
        //Retrieving the created API name
        String varAPINameOneURITemplateOne = caller.retrieveString("keyAPINameURITemplate");
        //Editing the API
        lib_Common.bc_EditAPI(caller, varAPINameOneURITemplateOne);
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatternUriTemplate);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbGet);
        //waiting for content load
        caller.pause("500");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPost);
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Add");
        //waiting for content load
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbGet + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternUriTemplate,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbPost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternUriTemplate,false,"");
        //waiting for content load
        caller.pause("3000");
        caller.writeToReport("End of  Executing APIM-74");	
    }
    /**
     *  Business component APIM_75.
     */
    public final static void APIM_75(final SeleniumTestBase caller, final String param_urlPatternUriTemplate, final String param_verbGet, final String param_verbPost, final String param_verbPut, final String param_verbDelete) throws Exception {
        //APIM-75: User should be able to define complex uri-templates with each HTTP verb
        caller.writeToReport("Start Executing APIM-75");
        caller.click("APIPublisherHome.lnk_Browse");
        String varAPINameOneURITemplate = caller.retrieveString("keyAPINameURITemplate");
        lib_Common.bc_EditAPI(caller, varAPINameOneURITemplate);
        caller.pause("2000");
        //Add uri for GET
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatternUriTemplate);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbGet);
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Add");
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbGet + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternUriTemplate,false,"");
        //waiting for content load
        caller.pause("1000");
        //Add uri for POST
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatternUriTemplate);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPost);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Add");
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbPost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternUriTemplate,false,"");
        //waiting for content load
        caller.pause("1000");
        //Add uri for PUT
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatternUriTemplate);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPut);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Add");
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbPut + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternUriTemplate,false,"");
        //waiting for content load
        caller.pause("1000");
        //Add uri for DELETE
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatternUriTemplate);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbDelete);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Add");
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbDelete + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternUriTemplate,false,"");
        //waiting for content load
        caller.pause("1000");
        caller.writeToReport("End of  Executing APIM-75");	
    }
    /**
     *  Business component APIM_78.
     */
    public final static void APIM_78(final SeleniumTestBase caller, final String param_urlPatternComplex, final String param_verbGet, final String param_verbPost) throws Exception {
        //APIM-78: Test with lengthy URL parameters
        caller.writeToReport("Start Executing APIM-78");
        caller.click("APIPublisherHome.lnk_Browse");
        //Retrieving created API name
        String varAPINameOneURITemplate = caller.retrieveString("keyAPINameURITemplate");
        lib_Common.bc_EditAPI(caller, varAPINameOneURITemplate);
        caller.type("APIPublisherBrowse.tf_UrlPattern",param_urlPatternComplex);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbGet);
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPost);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Add");
        //waiting for content load
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbGet + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternComplex,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVerbMethod","verb_PARAM:" + param_verbPost + "_PARAM," + "urlPattern_PARAM:" + param_urlPatternComplex,false,"");
        //waiting for content load
        caller.pause("3000");
        caller.writeToReport("End of  Executing APIM-78");	
    }
    /**
     *  Business component APIM_6A.
     */
    public final static void APIM_6A(final SeleniumTestBase caller, final String param_publisherURL) throws Exception {
        //APIM-6A: check whether Visibility Dropdown is there
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //Retrieve API name and the version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("4000");
        //Checking drop down selections availability
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
    public final static void APIM_116(final SeleniumTestBase caller, final String param_otherSpecify, final String param_Url, final String param_publisherURL, final String param_rdoOtherOne, final String param_rdoSupportForumOne, final String param_rdoPublicForumOne, final String param_rdoSampleSDKOne, final String param_rdoHowToOne, final String param_docName) throws Exception {
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //genarate docName & Summery
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("5000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        //Search for the API name
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        //1st doc How To
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        String DocNameOne = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameOne);
        caller.click("Browse_Doc.rdo_HowTo");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocNameOne + "_PARAM," + "docType_PARAM:" + param_rdoHowToOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocNameOne + "_PARAM," + "docType_PARAM:" + param_rdoHowToOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocNameOne + "_PARAM," + "docType_PARAM:" + param_rdoHowToOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocNameOne + "_PARAM," + "docType_PARAM:" + param_rdoHowToOne,false,"");
        //2nd doc Sample & SDK
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        String DocNametwo = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNametwo);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocNametwo + "_PARAM," + "docType_PARAM:" + param_rdoSampleSDKOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocNametwo + "_PARAM," + "docType_PARAM:" + param_rdoSampleSDKOne,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocNametwo + "_PARAM," + "docType_PARAM:" + param_rdoSampleSDKOne,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocNametwo + "_PARAM," + "docType_PARAM:" + param_rdoSampleSDKOne,false,"");
        //3nd doc Public Forum
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        //genarate docName
        String DocNameThree = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameThree);
        caller.click("Browse_Doc.rdo_PublicForum");
        if(caller.checkElementPresent("Browse_Doc.tf_URL")){
        caller.type("Browse_Doc.tf_URL",param_Url);
        }
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocNameThree + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocNameThree + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocNameThree + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocNameThree + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        //4thd doc Support Forum
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        //genarate docName
        String DocNameFour = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameFour);
        caller.click("Browse_Doc.rdo_SupportForum");
        if(caller.checkElementPresent("Browse_Doc.tf_URL")){
        caller.type("Browse_Doc.tf_URL",param_Url);
        }
        caller.click("Browse_Doc.rdo_URL");
        caller.type("Browse_Doc.tf_URL",param_Url);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocNameFour + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocNameFour + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocNameFour + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocNameFour + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        //5th doc Other Type
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        //genarate docName
        String DocNameFive = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameFive);
        caller.click("Browse_Doc.rdo_Other");
        if(caller.checkElementPresent("Browse_Doc.tf_Other")){
        caller.type("Browse_Doc.tf_Other",param_otherSpecify);
        }
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocNameFive + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocNameFive + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocNameFive + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocNameFive + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.pause("2000");
        caller.pause("2000");
        caller.writeToReport("APIM_116 Successfully Passed");	
    }
    /**
     *  Business component APIM_113.
     */
    public final static void APIM_113(final SeleniumTestBase caller, final String param_docName, final String param_URL) throws Exception {
        //APIM-113: Check whether system doesn't allow user to change source as 'in-line' for forum type documents.
        caller.writeToReport("Start  Executing APIM-113");
        caller.click("APIPublisherHome.lnk_Browse");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("3000");
        //Search for the API name
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("1000");
        String DocName = caller.retrieveString("var_DocName");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + DocName);
        //check edit document page visibility
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        //change type to public forum(pre condition)
        caller.pause("4000");
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.pause("1000");
        /*
        Click
         object=Browse_Doc.rdo_URL
        */
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_URL);
        caller.pause("1000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblPublicForum","param_docName_PARAM:" + DocName,false,"");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + DocName);
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
        caller.checkElementPresent("Browse_Doc.ele_SupportForum","param_docName_PARAM:" + DocName,false,"");
        //check
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + DocName);
        //check the Document name should be visible in a non-editabe field
        caller.pause("3000");
        caller.checkObjectProperty("Browse_Doc.tf_DocName","PROPERTYPRESENT","disabled|true",false,"");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        //check for non-selectable in-line radio button
        caller.checkObjectProperty("Browse_Doc.rdo_Inline","PROPERTYPRESENT","disabled|true",false,"");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("3000");
        caller.writeToReport("End of  Executing APIM-113");	
    }
    /**
     *  Business component APIM_105.
     */
    public final static void APIM_105(final SeleniumTestBase caller, final String param_docName, final String param_docSummery, final String param_other, final String param_fileToUpload, final String param_fileName, final String param_storeURL, final String param_publisherURL, final String param_rdoOtherOne, final String downImage, final String param_Domain) throws Exception {
        //APIM-105: Create a document given 'other' as the type and 'file' as the source.
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //Retrieve API name and the version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        //Search for the API
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("5000");
        //Adding new Doc
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        //genarate docName & Summery
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.click("Browse_Doc.rdo_Other");
        caller.pause("2000");
        if(caller.checkElementPresent("Browse_Doc.tf_Other")){
        caller.type("Browse_Doc.tf_Other",param_other);
        } else {
        caller.click("Browse_Doc.rdo_Other");
        caller.type("Browse_Doc.tf_Other",param_other);
        }
        caller.click("Browse_Doc.rdo_File");
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("500");
        //Check for the validation error
        caller.checkElementPresent("Browse_Doc.ele_lblThisFieldisRequired",false,"");
        caller.type("Browse_Doc.tf_DocName",DocName);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.pause("6000");
        caller.checkElementPresent("Browse_Doc.tf_BrowseFile",false,"");
        caller.pause("2000");
        //Addign file to the sourse
        //Type docname
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_fileToUpload);
        String entirePath = file.getAbsolutePath();
        caller.type("Browse_Doc.tf_BrowseFile",entirePath);
        caller.pause("6000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        //Checking the table column names
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + DocName);
        caller.pause("2000");
        //Handle save popup
        String downImagePopup = downImage;
        if(caller.checkImagePresent(downImagePopup,false)){
        caller.fireEvent("KEY%key=alt+s","2000");
        caller.fireEvent("KEY%key=alt+a","2000");
        caller.fireEvent("KEY%key=\n","1000");
        }
        caller.checkFileInfo(param_fileName,"EXIST",false,"");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        caller.pause("3000");
        //Search for the API name
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Ckeck the added document
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Other",false,"");
        caller.click("APIStoreDocumentation.lnk_Other");
        if(caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_fileName_PARAM:" + param_fileName)){
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + param_fileName);
        }
        //Checking download path
        caller.checkFileInfo(param_fileName,"EXIST",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_105 Successfully Passed");	
    }
    /**
     *  Business component APIM_104.
     */
    public final static void APIM_104(final SeleniumTestBase caller, final String param_docName, final String param_docSummery, final String param_other, final String param_url, final String param_publisherURL, final String param_rdoOtherOne) throws Exception {
        //APIM-104: Create a document given 'other' as the type and 'URL' as the source
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //Retrieve API name and the version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.click("APIPublisherHome.lnk_Browse");
        //Check for the API
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        //1st doc How To
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("1000");
        //genarate docNameInvalid
        String DocNameInvalid = param_docName+"_"+"@!123"+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameInvalid);
        caller.click("Browse_Doc.rdo_Other");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblInvalidDocName",false,"");
        //genarate docNameInvalid
        String DocNameInvalidTwo = param_docName+"_"+"DocDifferent@!123"+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameInvalidTwo);
        caller.click("Browse_Doc.rdo_Other");
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblInvalidDocName",false,"");
        //genarate docName & Summery
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_URL");
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblThisFieldisRequired",false,"");
        caller.type("Browse_Doc.tf_DocName",DocName);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.pause("500");
        caller.click("Browse_Doc.rdo_Other");
        caller.type("Browse_Doc.tf_Other",param_other);
        caller.click("Browse_Doc.rdo_URL");
        caller.type("Browse_Doc.tf_URL",param_url);
        caller.pause("1000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + DocName);
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
    public final static void APIM_112(final SeleniumTestBase caller, final String param_editContent, final String param_publisherURL, final String param_Domain, final String param_storeURL, final String TableColumnType) throws Exception {
        //APIM-112: Check whether system allows user to edit content of already created in-line documents.
        caller.writeToReport("Start  Executing APIM-112");
        caller.click("APIPublisherHome.lnk_Browse");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        //Search for the API name
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("1000");
        String DocName = caller.retrieveString("var_DocName");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + DocName);
        //check edit document page visibility
        caller.checkElementPresent("Browse_Doc.ele_lblType",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lblSource",false,"");
        //change type to public forum(pre condition)
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_UpdateCreatedDoc");
        caller.pause("500");
        //Check whether document details are listed on the docs page of the API.
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + DocName,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + TableColumnType,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + TableColumnType,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + TableColumnType,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + TableColumnType,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + DocName);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + APIVersion,false,"");
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
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + DocName,false,"");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkElementPresent("APIStoreDocumentation.lnk_HowTo",false,"");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Wait for content load
        caller.pause("1000");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + DocName,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + DocName,false,"");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + DocName);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("5000");
        caller.checkElementPresent("APIStoreDocumentation.ele_txtContent","param_docName_PARAM:" + DocName,false,"");
        caller.pause("5000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.writeToReport("End of  Executing APIM-112");	
    }
    /**
     *  Business component APIM_103.
     */
    public final static void APIM_103(final SeleniumTestBase caller, final String param_docName, final String param_docSummery, final String param_other, final String param_editContent, final String param_storeURL, final String param_publisherURL, final String param_rdoOtherOne, final String param_Domain) throws Exception {
        //APIM-103: Create a document given 'other' as the type and in-line as the source.
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //Retrieve API name and the version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //genarate docName & Summery
        String DocNameWithSpace = param_docName+" "+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameWithSpace);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.pause("500");
        caller.click("Browse_Doc.rdo_Other");
        caller.type("Browse_Doc.tf_Other",param_other);
        caller.click("Browse_Doc.rdo_Inline");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocNameWithSpace + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocNameWithSpace + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocNameWithSpace + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocNameWithSpace + "_PARAM," + "docType_PARAM:" + param_rdoOtherOne,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + DocNameWithSpace);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocNameEditContent","param_docName_PARAM:" + DocNameWithSpace,false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblVersion","param_APIversion_PARAM:" + APIVersion,false,"");
        caller.pause("1000");
        caller.click("Browse_Doc.btn_EditContenetCancel");
        caller.pause("1000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + DocNameWithSpace);
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
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Other");
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + DocNameWithSpace);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStore,param_passwordStore);
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
    public final static void APIM_102(final SeleniumTestBase caller, final String param_docName, final String param_docSummery, final String param_fileToUpload, final String param_downloadedFile, final String param_storeURL, final String param_publisherURL, final String param_rdoSupportForumOne, final String param_Domain) throws Exception {
        //APIM-102: Create a document given 'support forum' as the type and 'file' as the source.
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.click("APIPublisherHome.lnk_Browse");
        //Search for the API name
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("3000");
        //genarate docName & Summery
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_SupportForum");
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_File");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblThisFieldisRequired",false,"");
        caller.pause("500");
        //Type docname
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_fileToUpload);
        String entirePath = file.getAbsolutePath();
        caller.type("Browse_Doc.tf_BrowseFile",entirePath);
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + DocName);
        //Check for downloaded file
        caller.checkFileInfo(param_downloadedFile,"EXIST",false,"");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("1000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + DocName);
        //Check for downloaded file
        caller.checkFileInfo(param_downloadedFile,"EXIST",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_102 Successfully Passed");	
    }
    /**
     *  Business component APIM_101.
     */
    public final static void APIM_101(final SeleniumTestBase caller, final String param_docName, final String param_docSummery, final String param_url, final String param_publisherURL, final String param_storeURL, final String param_rdoSupportForumOne, final String param_Domain) throws Exception {
        //APIM-101: Create a document given 'support forums' as the type and 'URL' as the source
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //genarate docName & Summery
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.pause("500");
        caller.click("Browse_Doc.rdo_SupportForum");
        caller.type("Browse_Doc.tf_URL",param_url);
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSupportForumOne,false,"");
        caller.click("Browse_Doc.btn_View","param_docName_PARAM:" + DocName);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        //verify the Site
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("1000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("1000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.lnk_link","param_docName_PARAM:" + DocName,false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_101 Successfully Passed");	
    }
    /**
     *  Business component APIM_100.
     */
    public final static void APIM_100(final SeleniumTestBase caller, final String param_publisherURL, final String param_docName, final String param_docSummery) throws Exception {
        //APIM-100: System should not allow to select 'in-line' source type given 'support forum' as the type
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //Retrieve API name and the version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("2000");
        //genarate docName & Summery
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.click("Browse_Doc.rdo_PublicForum");
        //Check the disabled radio button
        caller.checkObjectProperty("Browse_Doc.rdo_Inline","PROPERTYPRESENT","disabled|true",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_100 Successfully Passed");	
    }
    /**
     *  Business component APIM_99.
     */
    public final static void APIM_99(final SeleniumTestBase caller, final String param_docSummery, final String param_docName, final String param_File, final String param_downloadedFile, final String param_publisherURL, final String param_storeURL, final String param_rdoPublicForumOne, final String param_Domain) throws Exception {
        //APIM-99: Create a document given 'public forum' as the type and 'file' as the source.
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        //Search for the API name
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //genarate docName & Summery
        String DocName = param_docName+"_"+caller.generateData("int",3);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.pause("500");
        caller.click("Browse_Doc.rdo_File");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.checkElementPresent("Browse_Doc.ele_lblThisFieldisRequired",false,"");
        //Upload the file
        //Type docname
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_File);
        String entirePath = file.getAbsolutePath();
        caller.type("Browse_Doc.tf_BrowseFile",entirePath);
        caller.doubleClick("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + DocName);
        caller.checkFileInfo(param_downloadedFile,"EXIST",false,"");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("1000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + DocName);
        //Check for downloaded file
        caller.checkFileInfo(param_downloadedFile,"EXIST",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_99 Successfully Passed");	
    }
    /**
     *  Business component APIM_98.
     */
    public final static void APIM_98(final SeleniumTestBase caller, final String param_docName, final String param_docSummery, final String param_url, final String param_storeURL, final String param_publisherURL, final String param_rdoPublicForumOne, final String param_Domain) throws Exception {
        //APIM-98: Create a document given 'public forums' as the type and 'URL' as the source.
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //Retrieve API name and the version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        //Search for the API name
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_url);
        caller.pause("1000");
        caller.doubleClick("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoPublicForumOne,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + DocName);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("1000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + DocName + "_PARAM," + "param_URLLink_PARAM:" + param_url,false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_98 Successfully Passed");	
    }
    /**
     *  Business component APIM_95.
     */
    public final static void APIM_95(final SeleniumTestBase caller, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_APIName, final String param_ProductionEndPont, final String param_SandBoxEndpoint, final String param_docInvalidName, final String param_docName, final String param_docSummery, final String param_sourceUrl, final String param_storeURL, final String param_APIContext, final String param_publisherURL, final String param_Domain) throws Exception {
        //APIM-95: Create a document given 'Samples & SDK' as the type and 'URL' as the source.
        //Craeting new API
        lib_Common.bc_CreateAPI_DesignNew(caller, param_APIName,param_APIContext,param_APIVersion,param_APIImagePath,param_tagName);
        lib_Common.bc_PrototypeAPI(caller);
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
        //retrieving API name
        String APIName = caller.retrieveString("var_APIName");
        caller.click("APIPublisherHome.lnk_Browse");
        //Search for the API
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
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
        //adding a document Using Invalid name
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
        //genarate docName
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        //genarate docSummery
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.click("Browse_Doc.btn_AddDocument");
        //check for warning
        caller.pause("6000");
        caller.checkElementPresent("Browse_Doc.ele_lblNameRequiredWarningMessage",false,"");
        caller.pause("6000");
        caller.type("Browse_Doc.tf_URL",param_sourceUrl);
        caller.click("Browse_Doc.btn_AddDocument");
        //wait till page load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + DocName,false,"");
        caller.click("Browse_Doc.lnk_view","param_docName_PARAM:" + DocName);
        //wait
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        lib_Common.bc_StoreLogin(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + param_APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //wait for page load
        caller.click("APIStoreDocumentation.lnk_Samples");
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + DocName,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + DocName + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrl,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_URL","param_docName_PARAM:" + DocName + "_PARAM," + "param_URLLink_PARAM:" + param_sourceUrl);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("3000");
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        caller.writeToReport("APIM_95 Successfully Passed");	
    }
    /**
     *  Business component APIM_96.
     */
    public final static void APIM_96(final SeleniumTestBase caller, final String param_publisherURL, final String param_docName, final String param_docSummery, final String param_rdoSampleSdkOne, final String param_fileDownloaded, final String param_storeURL, final String param_fileToUpload, final String param_Domain) throws Exception {
        //APIM-96: Create a document given 'Samples and SDK' as the type and 'file' as the source.
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        //Retrieve API name and the version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("3000");
        //Search for the API name
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("500");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("500");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //genarate docName & Summery
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.pause("500");
        caller.click("Browse_Doc.rdo_File");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblThisFieldisRequired",false,"");
        caller.type("Browse_Doc.tf_DocName",DocName);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.pause("500");
        //Type docname
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_fileToUpload);
        String entirePath = file.getAbsolutePath();
        caller.type("Browse_Doc.tf_BrowseFile",entirePath);
        caller.pause("1000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSampleSdkOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSampleSdkOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSampleSdkOne,false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableAction","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:" + param_rdoSampleSdkOne,false,"");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + DocName);
        caller.pause("2000");
        //Check for downloaded file
        caller.checkFileInfo(param_fileDownloaded,"EXIST",false,"");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.pause("1000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + DocName);
        //Check for downloaded file
        caller.checkFileInfo(param_fileDownloaded,"EXIST",false,"");
        caller.pause("2000");
        caller.writeToReport("APIM_96 Successfully Passed");	
    }
    /**
     *  Business component APIM_90.
     */
    /**
     *  Business component APIM_90.
     */
    public final static void APIM_90(final SeleniumTestBase caller) throws Exception {
        //APIM-90: Check whether system validates for empty fields in add new document page
        caller.click("APIPublisherHome.lnk_Browse");
        //Retriev Stored API name
        String APIName = caller.retrieveString("var_APIName");
        //Search for the API name
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
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
        caller.writeToReport("APIM_90 Successfully Passed");	
    }
    /**
     *  Business component APIM_91.
     */
    public final static void APIM_91(final SeleniumTestBase caller, final String param_docSummery, final String param_storeURL, final String param_publisherURL, final String param_docName, final String param_Domain) throws Exception {
        //APIM-91: Successfully add new in-line, 'how to' type document.
        //Retrieve the  stored API name
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        //genarate docName
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        caller.checkElementPresent("Browse_Doc.tf_Summary",false,"");
        //genarate docSummery
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.checkElementPresent("Browse_Doc.rdo_HowTo",false,"");
        caller.click("Browse_Doc.rdo_HowTo");
        caller.checkElementPresent("Browse_Doc.rdo_Inline",false,"");
        caller.click("Browse_Doc.rdo_Inline");
        caller.click("Browse_Doc.btn_AddDocument");
        //wait till page load
        caller.pause("6000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + DocName,false,"");
        //check added document column names
        caller.checkElementPresent("Browse_Doc.ele_lbltableName","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:How To",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableType","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:How To",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltablevisibility","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:How To",false,"");
        caller.checkElementPresent("Browse_Doc.ele_lbltableModifiedOn","docName_PARAM:" + DocName + "_PARAM," + "docType_PARAM:How To",false,"");
        //check for action column links
        caller.checkElementPresent("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + DocName,false,"");
        caller.checkElementPresent("Browse_Doc.btn_Update","param_DocName_PARAM:" + DocName,false,"");
        caller.checkElementPresent("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocName,false,"");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //wait till page load
        caller.click("APIStoreAPIs.lnk_HowTo");
        //check for added document
        caller.checkElementPresent("APIStoreAPIs.ele_lblDocumentName","param_docName_PARAM:" + DocName,false,"");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + DocName);
        caller.pause("6000");
        //Open new window or tab
        caller.selectWindow("Browse_Doc.window");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblViewContentPageText","paramDocName_PARAM:" + DocName,false,"");
        caller.pause("6000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Search for the API name
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        caller.pause("3000");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + DocName);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("2000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + APIVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.tf_EditContent1",false,"");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        //Genarate Edit Content
        String EditContent = "Content"+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_EditContent1",EditContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\t|key=\n","5000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("5000");
        //check for the document details
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + DocName,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + DocName);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + APIVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.tf_EditContent1",false,"");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",EditContent);
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
         param_APIversion=@APIVersion
         stopOnFailure=false
         customErrorMessage=
        */
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("1000");
        caller.type("Browse_Doc.tf_EditContent1",EditContent);
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","6000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("5000");
        //check for the document details
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + DocName,false,"");
        caller.writeToReport("APIM_91 Successfully Passed");	
    }
    /**
     *  Business component APIM_92.
     */
    public final static void APIM_92(final SeleniumTestBase caller, final String param_docInvalidName, final String param_sourceURL, final String param_docInvalidNameTwo, final String param_publisherURL, final String param_storeURL, final String param_docName, final String param_Domain) throws Exception {
        //APIM-92: Create a document given 'How to' as the type and 'URL' as the source.
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
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
        caller.type("Browse_Doc.tf_DocName",param_docInvalidNameTwo);
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("3000");
        caller.click("Browse_Doc.rdo_URL");
        caller.click("Browse_Doc.btn_AddDocument");
        //validate the error message
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblNameError",false,"");
        caller.pause("1000");
        //genarate docName
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        caller.click("Browse_Doc.btn_AddDocument");
        //validate required fields
        caller.checkElementPresent("Browse_Doc.ele_lblNameRequiredWarningMessage",false,"");
        caller.type("Browse_Doc.tf_DocName",DocName);
        caller.click("Browse_Doc.rdo_URL");
        caller.type("Browse_Doc.tf_URL",param_sourceURL);
        caller.pause("1000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + DocName,false,"");
        //wait for page load
        caller.pause("5000");
        caller.click("Browse_Doc.btn_View","param_docName_PARAM:" + DocName);
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
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreAPIs.lnk_HowTo");
        caller.pause("1000");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocName,false,"");
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
        caller.writeToReport("APIM_92 Successfully Passed");	
    }
    /**
     *  Business component APIM_93.
     */
    public final static void APIM_93(final SeleniumTestBase caller, final String param_docName, final String param_uploadDocLocation, final String param_docSummery, final String param_storeURL, final String param_DownloadFilePath, final String param_APIVersion, final String param_publisherURL, final String param_downImagePopup, final String param_Domain) throws Exception {
        //APIM-93: Create a document given 'How To' as the type and 'file' as the source.
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        //adding new document
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //wait for page load
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        //genarate docName & Summery
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_File");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblNameRequiredWarningMessage",false,"");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.tf_DocName",false,"");
        caller.type("Browse_Doc.tf_DocName",DocName);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.click("Browse_Doc.rdo_HowTo");
        caller.pause("1000");
        caller.click("Browse_Doc.rdo_File");
        //Type docname
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_uploadDocLocation);
        String entirePath = file.getAbsolutePath();
        caller.type("Browse_Doc.tf_BrowseFile",entirePath);
        caller.click("Browse_Doc.btn_AddDocument");
        //wait for page load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + DocName,false,"");
        caller.click("Browse_Doc.lnk_open","param_docName_PARAM:" + DocName);
        //wait for download the file
        caller.pause("3000");
        caller.pause("2000");
        String downImagePopup1 = param_downImagePopup;
        if(caller.checkImagePresent(downImagePopup1,false)){
        caller.fireEvent("KEY%key=alt+s","2000");
        caller.fireEvent("KEY%key=alt+a","2000");
        caller.fireEvent("KEY%key=\n","1000");
        }
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreAPIs.lnk_HowTo");
        caller.pause("1000");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocName,false,"");
        caller.checkElementPresent("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + DocName,false,"");
        caller.click("APIStoreDocumentation.lnk_Download","param_docName_PARAM:" + DocName);
        caller.pause("1000");
        //Check downloaded Document
        caller.checkFileInfo(param_DownloadFilePath,"EXIST",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.writeToReport("APIM_93 Successfully Passed");	
    }
    /**
     *  Business component APIM_94.
     */
    public final static void APIM_94(final SeleniumTestBase caller, final String param_docName, final String param_docSummery, final String param_storeURL, final String param_publisherURL, final String param_Domain) throws Exception {
        //APIM-94: Create a document given 'samples & sdk' as the type and in-line as the source.
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Search for the API name
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
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
        //genarate docName & Summery
        String DocName = param_docName+"_"+caller.generateData("int",3);
        caller.store("var_DaocName","String",DocName);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",3);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.pause("500");
        caller.click("Browse_Doc.rdo_Inline");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + DocName,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + DocName);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.pause("4000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + APIVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.tf_EditContent1",false,"");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        String EditContent = "Content"+"_"+caller.generateData("int",3);
        caller.type("Browse_Doc.tf_EditContent1",EditContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\t|key=\n","5000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("5000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + DocName,false,"");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + DocName);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.pause("4000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + APIVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.tf_EditContent1",false,"");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",EditContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","5000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblSamples","param_docName_PARAM:" + DocName,false,"");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_Samples");
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + DocName);
        caller.pause("3000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.checkElementPresent("APIStoreDocumentation.ele_documentViewText","param_text_PARAM:" + EditContent + "_PARAM," + "param_docName_PARAM:" + DocName,false,"");
        caller.pause("6000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.pause("2000");
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.writeToReport("APIM_94 Successfully Passed");	
    }
    /**
     *  Business component APIM_347.
     */
    /**
     *  Business component APIM_347.
     */
    public final static void APIM_347(final SeleniumTestBase caller) throws Exception {
        //APIM-347: User should not be able to Create a document with the same name that already added
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String DocName = caller.retrieveString("var_DaocName");
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Search for the API name
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
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
        caller.type("Browse_Doc.tf_DocName",DocName);
        caller.pause("1000");
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.ele_lblDuplicateDocName",false,"");
        caller.pause("5000");
        caller.writeToReport("APIM_347 Successfully Passed");	
    }
    /**
     *  Business component APIM_97.
     */
    public final static void APIM_97(final SeleniumTestBase caller, final String param_docName, final String param_docSummery) throws Exception {
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.pause("5000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
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
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.click("Browse_Doc.rdo_PublicForum");
        caller.pause("1000");
        if(caller.checkElementPresent("Browse_Doc.rdo_DisableInline")){
        caller.writeToReport("Inline Radio button is disable");
        }
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.pause("6000");
        caller.writeToReport("APIM_97 Successfully Passed");	
    }
    /**
     *  Business component APIM_348.
     */
    public final static void APIM_348(final SeleniumTestBase caller, final String param_docName, final String param_docSummery, final String param_storeURL, final String param_serverName, final String param_usernameStore, final String param_passwordStore) throws Exception {
        //APIM-348: User added a document with summary
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Search for the API name
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + APIName + "_PARAM," + "param_APIVersion_PARAM:" + APIVersion + "_PARAM," + "param_APIName_PARAM:" + APIName);
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
        //genarate docName & Summery
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        String DocSummery = param_docSummery+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_Summary",DocSummery);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + DocName,false,"");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreAPIs.lnk_HowTo");
        caller.pause("1000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocSummery","param_Summery_PARAM:" + DocSummery + "_PARAM," + "param_DocName_PARAM:" + DocName,false,"");
        caller.writeToReport("APIM_348 Successfully Passed");	
    }
    /**
     *  Business component APIM_115.
     */
    public final static void APIM_115(final SeleniumTestBase caller, final String param_docName) throws Exception {
        //APIM-115: User should get validation message when trying to update document having an empty source URL
        caller.writeToReport("Start  Executing APIM-115");
        caller.click("APIPublisherHome.lnk_Browse");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("3000");
        //Search for the API name
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("3000");
        //genarate docName
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Update","param_DocName_PARAM:" + DocName);
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
        caller.writeToReport("End of  Executing APIM-165");	
    }
    /**
     *  Business component APIM_165.
     */
    public final static void APIM_165(final SeleniumTestBase caller, final String param_docName, final String param_editContent, final String param_storeURL, final String param_publisherURL, final String param_Domain) throws Exception {
        //APIM-165: Check whether system save changes when user adds special characters to the content of inline docs
        caller.writeToReport("Start  Executing APIM-165");
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
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
        //genarate docName
        String DocName = param_docName+"_"+caller.generateData("int",4);
        caller.store("var_DocName","String",DocName);
        caller.type("Browse_Doc.tf_DocName",DocName);
        caller.click("Browse_Doc.btn_AddDocument");
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + DocName,false,"");
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.checkElementPresent("APIPublisherBrowse.lnk_Overview",false,"");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_EditContent","param_DocName_PARAM:" + DocName);
        caller.pause("6000");
        caller.selectWindow("Browse_Doc.newWindow1");
        caller.pause("4000");
        //Verify API Version
        caller.checkElementPresent("Browse_Doc.ele_lblApiVersionInEditContent","param_APIVersion_PARAM:" + APIVersion,false,"");
        caller.selectFrame("Browse_Doc.frame1");
        caller.pause("4000");
        caller.checkElementPresent("Browse_Doc.tf_EditContent1",false,"");
        caller.click("Browse_Doc.tf_EditContent1");
        caller.pause("500");
        caller.type("Browse_Doc.tf_EditContent1",param_editContent);
        caller.pause("4000");
        caller.fireEvent("KEY%key=\t|key=\t|key=\n","5000");
        caller.selectWindow("Browse_Doc.defaultWindow");
        caller.checkElementPresent("Browse_Doc.ele_lblHowTo","param_docName_PARAM:" + DocName,false,"");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        lib_Common.bc_StoreLogin(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_PublishedAPI","param_APIName_PARAM:" + APIName + "_PARAM," + "param_version_PARAM:" + APIVersion);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_HowTo");
        caller.pause("6000");
        caller.checkElementPresent("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocName,false,"");
        caller.click("APIStoreDocumentation.lnk_ViewContent","param_DocName_PARAM:" + DocName);
        caller.pause("4000");
        caller.selectWindow("Browse_Doc.window");
        caller.pause("4000");
        caller.checkElementPresent("APIStoreDocumentation.ele_documentViewText","param_text_PARAM:" + param_editContent + "_PARAM," + "param_docName_PARAM:" + DocName,false,"");
        caller.pause("6000");
        caller.fireEvent("KEY%key=ctrl+w","2000");
        caller.switchUser("default");
        caller.selectWindow("Browse_Doc.defaultWindow");
        //Navigate to publisher
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"3000");
        caller.writeToReport("End of  Executing APIM-165");	
    }
    /**
     *  Business component APIM_121.
     */
    public final static void APIM_121(final SeleniumTestBase caller, final String param_OtherName, final String param_URL, final String param_DocLocation, final String param_storeURL, final String param_PublisherURL, final String param_docName, final String param_Domain) throws Exception {
        //APIM-121: Check whether documents of type other get deleted successfully.
        caller.writeToReport("Start  Executing APIM-121");
        caller.click("APIPublisherHome.lnk_Browse");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("3000");
        //Search for the API name
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //genarate docName one
        String DocNameOne = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameOne);
        caller.click("Browse_Doc.rdo_Other");
        caller.type("Browse_Doc.tf_Other",param_OtherName);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        //genarate docName Two
        String DocNameTwo = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameTwo);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Other");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_Other",param_OtherName);
        caller.click("Browse_Doc.rdo_URL");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_URL);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("3000");
        //genarate docName Three
        String DocNameThree = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameThree);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_Other");
        caller.type("Browse_Doc.tf_Other",param_OtherName);
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("2000");
        //Type docname
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_DocLocation);
        String entirePath = file.getAbsolutePath();
        caller.type("Browse_Doc.tf_BrowseFile",entirePath);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("4000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameOne);
        //Wait for content load
        caller.pause("3000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameOne,false,"");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("3000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameOne,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        lib_Common.bc_StoreLogin(caller, param_Domain);
        //Wait for content load
        caller.pause("4000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Wait for content load
        caller.pause("2000");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocNameOne,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameTwo);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameTwo,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameTwo,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.click("APIStoreDocumentation.lnk_Other");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocNameTwo,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("3000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameThree);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameThree,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameThree,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("3000");
        caller.checkObjectProperty("APIStoreDocumentation.lnk_Other","ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("3000");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.pause("2000");
        caller.writeToReport("End of  Executing APIM-121");	
    }
    /**
     *  Business component APIM_120.
     */
    public final static void APIM_120(final SeleniumTestBase caller, final String param_URL, final String param_docLocation, final String param_Domain, final String param_storeURL, final String param_PublisherURL, final String param_docName) throws Exception {
        //APIM-120: Check whether documents of type 'support forum' get deleted successfully.
        caller.writeToReport("Start  Executing APIM-120");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("2000");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //genarate docName
        String DocNameOne = param_docName+"_"+caller.generateData("int",3);
        caller.type("Browse_Doc.tf_DocName",DocNameOne);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_SupportForum");
        caller.type("Browse_Doc.tf_URL",param_URL);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //genarate docName
        String DocNameTwo = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameTwo);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_SupportForum");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_File");
        //Type docname
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_docLocation);
        String entirePath = file.getAbsolutePath();
        caller.type("Browse_Doc.tf_BrowseFile",entirePath);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameOne);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameOne,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameOne,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Wait for content load
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("3000");
        caller.click("APIStoreDocumentation.lnk_SupportForum");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocNameOne,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameTwo);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameTwo,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameTwo,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.checkObjectProperty("APIStoreDocumentation.lnk_SupportForum","ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.writeToReport("End of  Executing APIM-120");	
    }
    /**
     *  Business component APIM_422.
     */
    public final static void APIM_422(final SeleniumTestBase caller, final String param_APIName, final String param_APIVersion, final String param_APIImagePath, final String param_tagName, final String param_verbGet, final String param_verbPost, final String param_verbPut, final String param_verbOption, final String param_ProductionEndpointUrl, final String param_Application, final String param_ApplicationUser, final String param_ApplicationAndApplicationUser, final String param_None, final String param_newVersion) throws Exception {
        //APIM_422 Testcase
        caller.writeToReport("Start Executing APIM-422");
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name as a variable
        String varAPINameResourceLevelSecurity = param_APIName+caller.generateData("int",3);
        //storing API name
        caller.store("keyAPINameResourceLevelSecurity","String",varAPINameResourceLevelSecurity);
        caller.type("APIPublisherAdd.tf_APIName",varAPINameResourceLevelSecurity);
        //Type API context
        String APIcontest = "api"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //Type valid image path
        /*
        Type
         object=APIPublisherAdd.btn_BrowseImage
         text=@param_APIImagePath
        */
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("6000");
        //ticks relevant fields
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbGet);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPost);
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbPut);
        caller.click("APIPublisherBrowse.ele_lblMore");
        caller.click("APIPublisherBrowse.chk_verbMethod","verb_PARAM:" + param_verbOption);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("1000");
        caller.click("APIPublisherBrowse.btn_Yes");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        //waiting for content load
        caller.pause("1000");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndpointUrl);
        //waiting for content load
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_NextManage");
        lib_Common.bc_SelectTiers(caller);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ResourceLevelType","param_verbMethod_PARAM:" + param_verbGet);
        //waiting for content load
        caller.pause("500");
        caller.select("APIPublisherBrowse.ele_ddResourseLevelType",param_Application);
        //waiting for content load
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_right");
        //waiting for content load
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbGet + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_Application,false,"");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ResourceLevelType","param_verbMethod_PARAM:" + param_verbPost);
        //waiting for content load
        caller.pause("500");
        caller.select("APIPublisherBrowse.ele_ddResourseLevelType",param_ApplicationUser);
        //waiting for content load
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_right");
        //waiting for content load
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbPost + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationUser,false,"");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ResourceLevelType","param_verbMethod_PARAM:" + param_verbPut);
        //waiting for content load
        caller.pause("500");
        caller.select("APIPublisherBrowse.ele_ddResourseLevelType",param_ApplicationAndApplicationUser);
        //waiting for content load
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_right");
        //waiting for content load
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbPut + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationAndApplicationUser,false,"");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ResourceLevelType","param_verbMethod_PARAM:" + param_verbOption);
        //waiting for content load
        caller.pause("500");
        caller.select("APIPublisherBrowse.ele_ddResourseLevelType",param_None);
        //waiting for content load
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_right");
        //waiting for content load
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbOption + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_None,false,"");
        caller.click("APIPublisherBrowse.lnk_ResourceLevelType","param_verbMethod_PARAM:" + param_verbOption);
        //waiting for content load
        caller.pause("500");
        caller.select("APIPublisherBrowse.ele_ddResourseLevelType",param_ApplicationUser);
        caller.pause("500");
        caller.click("APIPublisherBrowse.btn_right");
        //waiting for content load
        caller.pause("1000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbOption + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationUser,false,"");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.pause("1000");
        caller.click("APIPublisherBrowse.btn_Close");
        //waiting for content load
        caller.pause("1000");
        caller.click("APIPublisherHome.lnk_Browse");
        String varAPINameResourceLevelSecurityOne = caller.retrieveString("keyAPINameResourceLevelSecurity");
        caller.type("APIPublisherHome.tf_APISearch",varAPINameResourceLevelSecurityOne);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_APIVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName);
        //waiting for content load
        caller.pause("2000");
        caller.click("Browse_Overview.btn_CreateNewVersion");
        //waiting for content load
        caller.pause("500");
        caller.type("Browse_Overview.tf_ToVersion",param_newVersion);
        caller.click("Browse_Overview.btn_Done");
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherHome.ele_lblApiNamewithVersion","param_ApiName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion,false,"");
        //waiting for content load
        caller.pause("2000");
        //retrieving API name
        String varAPINameResourceLevelSecurityTwo = caller.retrieveString("keyAPINameResourceLevelSecurity");
        caller.type("APIPublisherHome.tf_APISearch",varAPINameResourceLevelSecurityTwo);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherHome.ele_lblApiNamewithVersion","param_version_PARAM:" + param_newVersion + "_PARAM," + "param_ApiName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbGet + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_Application,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbPost + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationUser,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbPut + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationAndApplicationUser,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblResourceLevelType1","param_verbType_PARAM:" + param_verbOption + "_PARAM," + "param_ResourceLevelType_PARAM:" + param_ApplicationUser,false,"");
        caller.writeToReport("End of  Executing APIM-422");	
    }
    /**
     *  Business component APIM_119.
     */
    public final static void APIM_119(final SeleniumTestBase caller, final String param_URL, final String param_docLocation, final String param_Domain, final String param_storeURL, final String param_PublisherURL, final String param_docName) throws Exception {
        //APIM-119: Check whether documents of type 'public forum' get deleted successfully.
        caller.writeToReport("Start  Executing APIM-119");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        //genarate docName
        String DocNameOne = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameOne);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_PublicForum");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_URL);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        //genarate docName
        String DocNameTwo = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameTwo);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_PublicForum");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("2000");
        //Type docname
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_docLocation);
        String entirePath = file.getAbsolutePath();
        caller.type("Browse_Doc.tf_BrowseFile",entirePath);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameOne);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameOne,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameOne,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Wait for content load
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_PublicForum");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocNameOne,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameTwo);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameTwo,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameTwo,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.lnk_PublicForum","ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.writeToReport("End of  Executing APIM-119");	
    }
    /**
     *  Business component APIM_196.
     */
    /**
     *  Business component APIM_196.
     */
    public final static void APIM_196(final SeleniumTestBase caller) throws Exception {
        //User who is successfully logged into the API store should be able to access my applications page by clicking on the my applications menu item.
        caller.writeToReport("Start  Executing APIM-196");
        //Go to my application
        caller.click("APIStoreHome.lnk_APIs");
        if(caller.checkElementPresent("APIStoreHome.lnk_MyApplication")){
        caller.click("APIStoreHome.lnk_MyApplication");
        } else {
        caller.click("APIStoreHome.lnk_iconMyApplication");
        }
        //verifications of application cretion feilds
        caller.checkElementPresent("APIStoreMyApllication.ele_lblAddApplication",false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_ApplicationName",false,"");
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_CallBackURL",false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_Discription",false,"");
        caller.checkElementPresent("APIStoreMyApllication.btn_AddApplication",false,"");
        caller.writeToReport("End of Execution APIM_196");	
    }
    /**
     *  Business component APIM_118.
     */
    public final static void APIM_118(final SeleniumTestBase caller, final String param_URL, final String param_DocLocation, final String param_Domain, final String param_storeURL, final String param_PublisherURL, final String param_docName) throws Exception {
        //APIM-118: Check whether documents of type 'public forum' get deleted successfully.
        caller.writeToReport("Start  Executing APIM-118");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        //genarate docName
        String DocNameOne = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameOne);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //genarate docName
        String DocNameTwo = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameTwo);
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.rdo_URL");
        //Wait for content load
        caller.pause("1000");
        caller.type("Browse_Doc.tf_URL",param_URL);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.click("Browse_Doc.rdo_SampleAndSDK");
        //Wait for content load
        caller.pause("2000");
        //genarate docName
        String DocNameThree = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameThree);
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("2000");
        //Type docname
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_DocLocation);
        String entirePath = file.getAbsolutePath();
        caller.type("Browse_Doc.tf_BrowseFile",entirePath);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameOne);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameOne,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameOne,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_Samples");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocNameOne,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameTwo);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameTwo,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameTwo,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_Samples");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocNameTwo,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Wait for content load
        caller.pause("2000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameThree);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameThree,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameThree,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
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
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.writeToReport("End of  Executing APIM-118");	
    }
    /**
     *  Business component APIM_117.
     */
    public final static void APIM_117(final SeleniumTestBase caller, final String param_URL, final String param_DocLocation, final String param_Domain, final String param_storeURL, final String param_PublisherURL, final String param_docName) throws Exception {
        //APIM-117: Check whether documents of type how to get deleted successfully.
        caller.writeToReport("Start  Executing APIM-117");
        //Retrieve the  stored API name && the Version
        String APIName = caller.retrieveString("var_APIName");
        String APIVersion = caller.retrieveString("var_APIVersion");
        caller.pause("3000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        //genarate docName
        String DocNameOne = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameOne);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddNewDocument");
        //Wait for content load
        caller.pause("2000");
        //genarate docName
        String DocNameTwo = param_docName+"_"+caller.generateData("int",4);
        caller.type("Browse_Doc.tf_DocName",DocNameTwo);
        caller.click("Browse_Doc.rdo_URL");
        //Wait for content load
        caller.pause("2000");
        caller.type("Browse_Doc.tf_URL",param_URL);
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        //genarate docName
        String DocNameThree = param_docName+"_"+caller.generateData("int",4);
        caller.click("Browse_Doc.btn_AddNewDocument");
        caller.type("Browse_Doc.tf_DocName",DocNameThree);
        caller.click("Browse_Doc.rdo_File");
        //Wait for content load
        caller.pause("2000");
        //Type docname
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_DocLocation);
        String entirePath = file.getAbsolutePath();
        caller.type("Browse_Doc.tf_BrowseFile",entirePath);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_AddDocument");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameOne);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameOne,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameOne,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("4000");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocNameOne,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameTwo);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameTwo,false,"");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameTwo,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Wait for content load
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIStoreDocumentation.lnk_HowTo");
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocNameTwo,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.click("Browse_Doc.btn_Delete","param_DocName_PARAM:" + DocNameThree);
        //Wait for content load
        caller.pause("2000");
        caller.checkElementPresent("Browse_Doc.ele_lblDocDeleteConfirmationMessage","param_docName_PARAM:" + DocNameThree,false,"");
        caller.click("Browse_Doc.lnk_Yes");
        //Wait for content load
        caller.pause("2000");
        //Verify whether doc is not under document tab
        caller.checkObjectProperty("Browse_Doc.ele_lblDocNameDocsTab","param_APIName_PARAM:" + APIName + "_PARAM," + "param_DocName_PARAM:" + DocNameThree,"ELEMENTPRESENT","false",false,"");
        //Wait for content load
        caller.pause("2000");
        //Navigate to the store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        lib_Common.bc_SelectServer(caller, param_Domain);
        caller.pause("3000");
        //Search for the API name
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",APIName);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + APIName);
        caller.click("APIStoreAPIs.lnk_Documentations");
        caller.pause("4000");
        /*
        Click
         object=APIStoreDocumentation.lnk_HowTo
        */
        //Verify doc is not uner documentation
        caller.checkObjectProperty("APIStoreDocumentation.ele_lblDocumentName","param_docName_PARAM:" + DocNameThree,"ELEMENTPRESENT","false",false,"");
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"3000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.type("APIPublisherHome.tf_APISearch",APIName);
        caller.click("APIPublisherHome.btn_Search");
        //Wait for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + APIName);
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Doc.lnk_Doc");
        //Wait for content load
        caller.pause("3000");
        caller.writeToReport("End of  Executing APIM-117");	
    }
    /**
     *  Business component APIM_195.
     */
    public final static void APIM_195(final SeleniumTestBase caller, final String param_APIName, final String paramAPIContest, final String param_tag, final String param_ProductionEndPontJaxRS, final String param_storeURL, final String param_TenantOrAdmin, final String param_publisherURL) throws Exception {
        //User who is not logged in to the the system should not be able to access api store > applications page
        caller.writeToReport("Start  Executing APIM-195");
        //create API
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        String varAPIName = param_APIName+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_APIName",varAPIName);
        //Store API name in to variables
        caller.store("keyAPIName","String",varAPIName);
        //auto generate contest
        //Type API contest
        String APIcontest = paramAPIContest+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        //Setting variable for API version
        String APIversion = "v1.0."+caller.generateData("int",1);
        //Type API Version
        caller.type("APIPublisherAdd.tf_APIVersion",APIversion);
        String APItag = param_tag+caller.generateData("int",3);
        //Type API tags
        caller.type("APIPublisherAdd.tf_Tags",APItag);
        caller.pause("2000");
        caller.fireEvent("KEY%key=\n","2000");
        caller.click("APIPublisherAdd.btn_Save");
        //waite for content load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Yes");
        //waite for content load
        caller.pause("5000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //API Manage Section
        caller.pause("8000");
        //Go to browse page
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + varAPIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPontJaxRS);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("2000");
        lib_Common.bc_SelectTiers(caller);
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_Close");
        caller.pause("4000");
        //Navigate to store
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        //waite for content load
        caller.pause("3000");
        //Select the domain
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        caller.pause("3000");
        //go to my application
        if(caller.checkElementPresent("APIStoreHome.lnk_MyApplication")){
        caller.click("APIStoreHome.lnk_MyApplication");
        }
        caller.click("APIStoreHome.lnk_iconMyApplication");
        //Verify the loggin promt
        caller.checkElementPresent("APIStoreHome.tf_username",false,"");
        caller.pause("2000");
        caller.click("APIStoreHome.btn_cancel");
        caller.pause("2000");
        //log in to store
        lib_Common.bc_StoreLogin(caller, param_TenantOrAdmin);
        caller.writeToReport("End of Execution APIM_195");	
    }
    /**
     *  Business component APIM_200.
     */
    public final static void APIM_200(final SeleniumTestBase caller, final String param_InvalidAppName, final String param_ThrottlingTier, final String param_CallBackURL, final String param_Description, final String param_ValidName2, final String param_ValidAppName3) throws Exception {
        //User who is successfully logged into the API store should get a validation message when trying to add an application given special characters in the name field
        caller.writeToReport("Start  Executing APIM-200");
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
        String var_AppName = param_ValidAppName3+"_"+caller.generateData("int",4);
        caller.type("APIStoreMyApllication.tf_ApplicationName",var_AppName);
        caller.pause("1000");
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_CallBackURL);
        caller.type("APIStoreMyApllication.tf_Discription",param_Description);
        caller.pause("2000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("50");
        //Verify Successfully added Message
        caller.checkElementPresent("APIStoreMyApllication.ele_lblSuccessAddMesage",false,"");
        caller.pause("2000");
        caller.writeToReport("End of Execution APIM_200");	
    }
    /**
     *  Business component APIM_202.
     */
    public final static void APIM_202(final SeleniumTestBase caller, final String param_ApplicationName, final String param_ThrottlingTier, final String param_callBackUrl, final String param_descriprion, final String param_ApplicationWithSubscription) throws Exception {
        //Successfully logged in user to API store should be able to delete created applications successfully
        caller.writeToReport("Start  Executing APIM-202");
        caller.click("APIStoreHome.lnk_APIs");
        caller.pause("1000");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("1000");
        caller.type("APIStoreMyApllication.tf_ApplicationName",param_ApplicationName);
        //Copy the application name
        caller.fireEvent("KEY%key=ctrl+a","1000");
        caller.fireEvent("KEY%key=ctrl+c","1000");
        //select the tier
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        //Type callback URL
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_callBackUrl);
        caller.pause("1000");
        caller.type("APIStoreMyApllication.tf_Discription",param_descriprion);
        caller.pause("1000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_MySubcription");
        caller.pause("2000");
        //select the application
        caller.select("APIStoreMySubcription.ele_ddApplicationWithSubscription",param_ApplicationName);
        //generate keys
        caller.click("APIStoreMySubcription.btn_generateKeyProduction");
        caller.pause("6000");
        //Checking the ConsumerKey production and Key Genaration
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerKeyProduction",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerSecretTokenProduction",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblAccessTokenProduction",false,"");
        caller.pause("1000");
        caller.click("APIStoreMySubcription.btn_generateKeyProduction");
        caller.pause("6000");
        //Checking the ConsumerKey production and Key Genaration in sandbox
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerKeySandbox",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerSecretTokenSandBox",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblAccessTokenSandBox",false,"");
        caller.click("APIStoreHome.lnk_MyApplication");
        //retriew API name
        String varAPIName = caller.retrieveString("keyAPIName");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + varAPIName);
        caller.pause("2000");
        //select application for subscribe
        caller.select("APIStoreAPIs.ele_ddSelectAplicationToSubscribe",param_ApplicationName);
        caller.pause("2000");
        caller.click("APIStoreAPIs.btn_Subscribe");
        caller.click("APIStoreAPIs.btn_StayOnThisPage");
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("2000");
        //deldete application
        caller.click("APIStoreMyApllication.lnk_DeleteApplication","param_ApplicationName_PARAM:" + param_ApplicationName);
        caller.pause("1000");
        //Verify warning message of subscription
        caller.checkElementPresent("APIStoreMyApllication.ele_lblSubscribedAppDeleteWarningMessage",false,"");
        caller.click("APIStoreMyApllication.btn_yes");
        caller.pause("2000");
        //Verify no applications under the application
        caller.checkObjectProperty("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_ApplicationName,"ELEMENTPRESENT","false",false,"");
        caller.pause("2000");
        caller.writeToReport("End of Execution APIM_202");	
    }
    /**
     *  Business component APIM_204.
     */
    public final static void APIM_204(final SeleniumTestBase caller, final String param_ApplicationName) throws Exception {
        //When Application user deletes an application which has already generated consumenr key and consumer secret, access token, user should no longer use them to generate user tokens
        caller.writeToReport("Start  Executing APIM-204");
        caller.click("APIStoreHome.lnk_APIs");
        if(caller.checkElementPresent("APIStoreHome.lnk_MyApplication")){
        caller.click("APIStoreHome.lnk_MyApplication");
        } else {
        caller.click("APIStoreHome.lnk_iconMyApplication");
        }
        caller.pause("2000");
        //Verify the Application to Subscribe
        caller.checkObjectProperty("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_ApplicationName,"ELEMENTPRESENT","false",false,"");
        caller.click("APIStoreHome.lnk_MySubcription");
        caller.pause("2000");
        caller.click("APIStoreMySubcription.btn_ApplicationWithSubscription");
        caller.pause("4000");
        caller.fireEvent("KEY%key=ctrl+v","3000");
        //Verify no applications to generate keys
        caller.checkObjectProperty("APIStoreMySubcription.ele_lblddApplicationNames","param_ApplicationName_PARAM:" + param_ApplicationName,"ELEMENTPRESENT","false",false,"");
        caller.selectFrame("APIStoreMyApllication.frm_parent");
        caller.writeToReport("End of Execution APIM_204");	
    }
    /**
     *  Business component APIM_201.
     */
    /**
     *  Business component APIM_201.
     */
    public final static void APIM_201(final SeleniumTestBase caller) throws Exception {
        //Successfully logged in user to API store should be able to view callback url usage by clicking on the '?' icon infront of the callback RUL field on API store > my applicartion > add new application page.
        caller.writeToReport("Start  Executing APIM-201");
        caller.clickAt("APIStoreHome.lnk_APIs","0,0");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("3000");
        caller.clickAt("APIStoreMyApllication.btn_UrlQuestionMark","0,0");
        caller.pause("3000");
        //Verify the Help icon
        caller.checkElementPresent("APIStoreMyApllication.ele_lblCallbackUrlHelp",false,"");
        caller.writeToReport("End of Execution APIM 201");	
    }
    /**
     *  Business component APIM_206.
     */
    public final static void APIM_206(final SeleniumTestBase caller, final String param_AppName4, final String param_ThrottlingTier, final String param_CallBackURL, final String param_Description) throws Exception {
        //User who is successfully logged into the api store should be able to click on cancel button on the edit view and exit from the edit view.
        caller.writeToReport("Start  Executing APIM-206");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("1000");
        //check for the content load correctly
        caller.checkElementPresent("APIStoreMyApllication.ele_lblAddApplication",false,"");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMyApllication.tf_ApplicationName",false,"");
        //generate app name
        String var_AppName = param_AppName4+"_"+caller.generateData("int",4);
        //store API NAme
        caller.store("key_AppName","String",var_AppName);
        caller.type("APIStoreMyApllication.tf_ApplicationName",var_AppName);
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_CallBackURL);
        caller.type("APIStoreMyApllication.tf_Discription",param_Description);
        caller.pause("2000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblSuccessAddMesage",false,"");
        //Verify app name
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + var_AppName,false,"");
        caller.checkElementPresent("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + var_AppName,false,"");
        caller.click("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + var_AppName);
        caller.pause("1000");
        //verify edit name
        caller.checkElementPresent("APIStoreMyApllication.tf_EditName","param_AppName_PARAM:" + var_AppName,false,"");
        //verify edit tier
        caller.checkObjectProperty("APIStoreMyApllication.ele_ddEditTier","param_AppName_PARAM:" + var_AppName,"PROPERTYPRESENT","disabled|false",false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_EditCallBackURL","param_AppName_PARAM:" + var_AppName,false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_EditDescription","param_AppName_PARAM:" + var_AppName,false,"");
        caller.pause("2000");
        //cancel button verify
        caller.checkElementPresent("APIStoreMyApllication.btn_EditCancel","param_AppName_PARAM:" + var_AppName,false,"");
        caller.click("APIStoreMyApllication.btn_EditCancel","param_AppName_PARAM:" + var_AppName);
        caller.pause("500");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + var_AppName,false,"");
        caller.pause("3000");
        caller.writeToReport("End of Execution APIM_206");	
    }
    /**
     *  Business component APIM_205.
     */
    public final static void APIM_205(final SeleniumTestBase caller, final String param_AppName4, final String param_AppName5, final String param_EditTier, final String param_EditCallBackURL, final String param_EditDescription) throws Exception {
        //User who is successfully logged into the api store should be able to edit existing appliation name, throttling tier, callback url, description and save changes successfully.
        caller.writeToReport("Start  Executing APIM-205");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("1000");
        //Retriew API NAme
        String var_ApplicationName = caller.retrieveString("key_AppName");
        //Verify before edit App
        caller.checkElementPresent("APIStoreMyApllication.ele_lblAddApplication",false,"");
        caller.checkElementPresent("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + var_ApplicationName,false,"");
        //edit action column
        caller.click("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + var_ApplicationName);
        caller.pause("1000");
        //Verifications of application edit sucessfully
        caller.checkElementPresent("APIStoreMyApllication.tf_EditName","param_AppName_PARAM:" + var_ApplicationName,false,"");
        caller.checkObjectProperty("APIStoreMyApllication.ele_ddEditTier","param_AppName_PARAM:" + var_ApplicationName,"PROPERTYPRESENT","disabled|false",false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_EditCallBackURL","param_AppName_PARAM:" + var_ApplicationName,false,"");
        caller.checkElementPresent("APIStoreMyApllication.tf_EditDescription","param_AppName_PARAM:" + var_ApplicationName,false,"");
        caller.pause("2000");
        //Generate app five
        String var_AppNameFive = param_AppName5+"_"+caller.generateData("int",4);
        //type new app name
        caller.type("APIStoreMyApllication.tf_EditName","param_AppName_PARAM:" + var_ApplicationName,var_AppNameFive);
        caller.pause("1000");
        caller.click("APIStoreMyApllication.btn_EditSave","param_AppName_PARAM:" + var_ApplicationName);
        caller.pause("500");
        //verify new app name
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + var_AppNameFive,false,"");
        caller.pause("1000");
        caller.click("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + var_AppNameFive);
        caller.pause("2000");
        caller.click("APIStoreMyApllication.ele_ddEditTier","param_AppName_PARAM:" + var_AppNameFive);
        caller.pause("500");
        caller.select("APIStoreMyApllication.ele_ddEditTier","param_AppName_PARAM:" + var_AppNameFive,param_EditTier);
        caller.pause("1000");
        caller.click("APIStoreMyApllication.btn_EditSave","param_AppName_PARAM:" + var_AppNameFive);
        caller.pause("2000");
        caller.pause("3000");
        caller.click("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + var_AppNameFive);
        caller.checkElementPresent("APIStoreMyApllication.tf_EditCallBackURL","param_AppName_PARAM:" + var_AppNameFive,false,"");
        caller.type("APIStoreMyApllication.tf_EditCallBackURL","param_AppName_PARAM:" + var_AppNameFive,param_EditCallBackURL);
        caller.pause("1000");
        caller.click("APIStoreMyApllication.btn_EditSave","param_AppName_PARAM:" + var_AppNameFive);
        caller.checkElementPresent("APIStoreMyApllication.ele_lblCallBackURL","param_AppName_PARAM:" + var_AppNameFive + "_PARAM," + "param_CallBackURL_PARAM:" + param_EditCallBackURL,false,"");
        caller.pause("2000");
        caller.click("APIStoreMyApllication.lnk_EditActionColumn","param_AppName_PARAM:" + var_AppNameFive);
        caller.checkElementPresent("APIStoreMyApllication.tf_EditDescription","param_AppName_PARAM:" + var_AppNameFive,false,"");
        //type new app name
        caller.type("APIStoreMyApllication.tf_EditDescription","param_AppName_PARAM:" + var_AppNameFive,param_EditDescription);
        //save app name
        caller.click("APIStoreMyApllication.btn_EditSave","param_AppName_PARAM:" + var_AppNameFive);
        caller.pause("2000");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblDescription","param_AppName_PARAM:" + var_AppNameFive + "_PARAM," + "Description_PARAM:" + param_EditDescription,false,"");
        caller.pause("5000");
        caller.writeToReport("End of Execution APIM_205");	
    }
    /**
     *  Business component APIM_198.
     */
    /**
     *  Business component APIM_198.
     */
    public final static void APIM_198(final SeleniumTestBase caller) throws Exception {
        //User who is successfully logged into API store, should be able to see compulsory fields of 'add new application' form are marcked with a red asterisks
        caller.writeToReport("Start  Executing APIM-198");
        caller.click("APIStoreHome.lnk_APIs");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("6000");
        //Verify the Application Name
        caller.checkElementPresent("APIStoreMyApllication.tf_ApplicationName",false,"");
        caller.pause("3000");
        //Verify the tier Name
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.pause("3000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("1000");
        //Verify Required Name Field
        caller.checkElementPresent("APIStoreMyApllication.ele_lblNameRequired",false,"");
        caller.pause("3000");
        caller.writeToReport("End of Execution APIM_198");	
    }
    /**
     *  Business component APIM_197.
     */
    public final static void APIM_197(final SeleniumTestBase caller, final String param_ApplicationName, final String param_ThrottlingTier, final String param_CallBackURL, final String param_Description) throws Exception {
        //Successfully logged in user to API store, should be able to add a new application successfully.
        caller.writeToReport("Start  Executing APIM-197");
        caller.pause("4000");
        //Verify the name field to add application
        caller.checkElementPresent("APIStoreMyApllication.tf_ApplicationName",false,"");
        //generaete application name
        String var_AppName = param_ApplicationName+"_"+caller.generateData("int",4);
        //type app name
        caller.type("APIStoreMyApllication.tf_ApplicationName",var_AppName);
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_CallBackURL);
        caller.type("APIStoreMyApllication.tf_Discription",param_Description);
        caller.pause("1000");
        //add the application
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("100");
        //Verify Successfully added Message
        caller.checkElementPresent("APIStoreMyApllication.ele_lblSuccessAddMesage",false,"");
        //Verify the all added values in table
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + var_AppName,false,"");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblCallBackURL","param_AppName_PARAM:" + var_AppName + "_PARAM," + "param_CallBackURL_PARAM:" + param_CallBackURL,false,"");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblDescription","param_AppName_PARAM:" + var_AppName + "_PARAM," + "Description_PARAM:" + param_Description,false,"");
        caller.pause("4000");
        caller.writeToReport("End of execution APIM_197");	
    }
    /**
     *  Business component APIM_199.
     */
    public final static void APIM_199(final SeleniumTestBase caller, final String param_ThrottlingTier, final String param_CallBackURL, final String param_Description, final String param_ApplicationName2) throws Exception {
        //User who is successfully logged into the API store should get a validation message when trying to add an application without specifying compulsory fields.
        caller.writeToReport("Start  Executing APIM-199");
        caller.click("APIStoreHome.lnk_MyApplication");
        caller.pause("1000");
        //Verify added application
        caller.checkElementPresent("APIStoreMyApllication.ele_lblAddApplication",false,"");
        caller.pause("2000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("2000");
        //Verify required name field
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
        //generate app name
        String var_AppName = param_ApplicationName2+"_"+caller.generateData("int",4);
        caller.type("APIStoreMyApllication.tf_ApplicationName",var_AppName);
        caller.pause("1000");
        caller.checkElementPresent("APIStoreMyApllication.ele_ddThrottlingTier",false,"");
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_CallBackURL);
        caller.type("APIStoreMyApllication.tf_Discription",param_Description);
        caller.pause("2000");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        caller.pause("50");
        //Verify Successfully added Message
        caller.checkElementPresent("APIStoreMyApllication.ele_lblSuccessAddMesage",false,"");
        caller.pause("3000");
        caller.writeToReport("End of Execution APIM_199");	
    }
    /**
     *  Business component APIM_207.
     */
    public final static void APIM_207(final SeleniumTestBase caller, final String param_APIName, final String param_ProductionEndPoint, final String param_APIContext, final String param_tagName, final String param_APIImagePath, final String param_APIVersion, final String param_SandBoxEndpoint, final String param_AppName, final String param_TokenValueOne, final String param_TokenValueTwo, final String param_StoreURL, final String param_ThrottlingTier, final String param_TenantOrAdmin) throws Exception {
        caller.writeToReport("Start of executing APIM_207");
        //Go for create new API up to create state
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        //start design stage
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        String varAPIName = param_APIName+caller.generateData("int",3);
        caller.store("keyAPIName","String",varAPIName);
        caller.type("APIPublisherAdd.tf_APIName",varAPIName);
        //Type API contest
        String varAPIContext = param_APIContext+caller.generateData("int",4);
        caller.type("APIPublisherAdd.tf_APIContext",varAPIContext);
        String varAPIVersion = param_APIVersion+caller.generateData("int",2);
        caller.store("keyAPIVersion","String",varAPIVersion);
        caller.type("APIPublisherAdd.tf_APIVersion",varAPIVersion);
        //Type valid image path
        //Type
        //object=APIPublisherAdd.btn_BrowseImage
        //text=@param_APIImagePath
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("6000");
        //click save and verify warning
        caller.type("APIPublisherAdd.tf_URLPattern",varAPIName+"/"+varAPIContext);
        caller.click("APIPublisherAdd.chk_Post");
        //waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Add");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("5000");
        //Go to implement stage
        caller.checkElementPresent("APIPublisherAdd.lnk_NextImplement",false,"");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("7000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.pause("3000");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPoint);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("4000");
        //Start manage stage
        caller.click("APIPublisherAdd.dd_tireAvailabilityConfig");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherAdd.chk_tireSelectionUnlimited");
        caller.click("APIPublisherAdd.btn_SavePublish");
        //waiting for content load
        caller.pause("4000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblFinalClose",false,"");
        caller.click("APIPublisherAdd.ele_lblFinalClose");
        //Go to API Store
        //waiting for content load
        caller.pause("3000");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,"3000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        //Login to API Store
        lib_Common.bc_StoreLogin(caller, param_TenantOrAdmin);
        //waiting for content load
        caller.pause("5000");
        //Create new Application
        caller.click("APIStoreHome.lnk_MyApplication");
        String varAPPName = param_AppName+caller.generateData("int",5);
        caller.store("keyAPPName","String",varAPPName);
        caller.type("APIStoreMyApllication.tf_ApplicationName",varAPPName);
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_ThrottlingTier);
        caller.type("APIStoreMyApllication.tf_CallBackURL","application/x-www-form-urlencoded");
        caller.type("APIStoreMyApllication.tf_Discription","test_dec");
        caller.click("APIStoreMyApllication.btn_AddApplication");
        //waiting for content load
        caller.pause("7000");
        //Go to API window to Subscribe API to an application
        caller.click("APIStoreHome.lnk_APIs");
        //waiting for content load
        caller.pause("4000");
        caller.type("APIStoreHome.tf_APISearchStore",varAPIName);
        caller.click("APIStoreHome.btn_SearchButtonStore");
        //waiting for content load
        caller.pause("3000");
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + varAPIName,false,"");
        caller.click("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + varAPIName);
        //waiting for content load
        caller.pause("7000");
        caller.checkElementPresent("APIStoreAPIs.ele_ddSelectAplicationToSubscribe",false,"");
        caller.select("APIStoreAPIs.ele_ddSelectAplicationToSubscribe",varAPPName);
        //waiting for content load
        caller.pause("3000");
        caller.click("APIStoreAPIs.btn_Subscribe");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreAPIs.btn_StayOnThisPage");
        caller.checkElementPresent("APIStoreAPIs.btn_Subscribe",false,"");
        //Go to Subcription window to Generate keys
        caller.click("APIStoreHome.lnk_MySubcription");
        caller.checkElementPresent("APIStoreMySubcription.ele_ddApplicationWithSubscription",false,"");
        caller.select("APIStoreMySubcription.ele_ddApplicationWithSubscription",varAPPName);
        //wait for page load
        caller.pause("4000");
        if(caller.checkElementPresent("APIStoreMySubcription.ele_lblAllowedDomains")){
        caller.doubleClick("APIStoreMySubcription.ele_lblKeysProduction");
        } else {
        caller.click("APIStoreMySubcription.ele_lblKeyProduction");
        }
        //waiting for content load
        caller.pause("5000");
        caller.checkElementPresent("APIStoreMySubcription.tf_TokenValidity",false,"");
        caller.type("APIStoreMySubcription.tf_TokenValidity",param_TokenValueOne);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreMySubcription.btn_generateKeyProduction");
        //waiting for content load
        caller.pause("6000");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerKeyProduction",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerSecretTokenProduction",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblAccessTokenProduction",false,"");
        caller.checkElementPresent("APIStoreMySubcription.tf_TokenValidity2",false,"");
        caller.type("APIStoreMySubcription.tf_TokenValidity2",param_TokenValueTwo);
        //waiting for content load
        caller.pause("6000");
        caller.checkElementPresent("APIStoreMySubcription.btn_GenarateKeySandBox",false,"");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIStoreMySubcription.btn_generateKeyProduction");
        //waiting for content load
        caller.pause("7000");
        //Verification of sand box generated keys
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerKeySandbox",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerSecretTokenSandBox",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblAccessTokenSandBox",false,"");
        //Verifications on production box
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerKeyProduction",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblAccessTokenProduction",false,"");
        caller.checkElementPresent("APIStoreMySubcription.ele_lblConsumerSecretTokenProduction",false,"");
        //waiting for content load
        caller.pause("2000");
        caller.writeToReport("End of executing APIM_207");	
    }
    /**
     *  Business component APIM_350.
     */
    public final static void APIM_350(final SeleniumTestBase caller, final String param_UserName, final String param_Password, final String param_publisherURL, final String param_APIName) throws Exception {
        //APIM-350: User Search added API by name
        lib_Common.bc_Login_APIPublisher(caller, param_UserName,param_Password,param_publisherURL);
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
        caller.click("browseLifecycle.btn_Update");
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
        caller.click("browseLifecycle.btn_Update");
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
        caller.click("browseLifecycle.btn_Update");
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
        caller.click("browseLifecycle.btn_Update");
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
        caller.click("browseLifecycle.btn_Update");
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
        caller.click("browseLifecycle.btn_Update");
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
        lib_Common.bc_APIStoreLogin(caller, param_usernamePublisher,param_passwordPublisher);
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
        lib_Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStoreOne,param_passwordStoreOne);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStoreTwo,param_passwordStoreTwo);
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
        lib_Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStoreOne,param_passwordStoreOne);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStoreTwo,param_passwordStoreTwo);
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
        lib_Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStoreOne,param_passwordStoreOne);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStoreTwo,param_passwordStoreTwo);
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
        lib_Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStoreOne,param_passwordStoreOne);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStoreTwo,param_passwordStoreTwo);
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
        lib_Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStoreOne,param_passwordStoreOne);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStoreTwo,param_passwordStoreTwo);
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
    public final static void APIM_393(final SeleniumTestBase caller, final String param_storeURL, final String param_serverName, final String param_usernameStore, final String param_passwordStore, final String param_APIName, final String param_searchContext, final String param_APIContext, final String param_APIVersion, final String param_APIImagePath, final String param_tagName, final String param_ProductionEndPoint, final String param_SandBoxEndpoint, final String param_publisherURL) throws Exception {
        caller.writeToReport("Start of executing APIM_393");
        //Go for create new API up to create state
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        //start design stage
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Type API Name
        String varAPIName = param_APIName+caller.generateData("int",3);
        //hhh
        caller.store("keyAPIName","String",varAPIName);
        caller.type("APIPublisherAdd.tf_APIName",varAPIName);
        //Type API contest
        String varAPIContext = param_APIContext+caller.generateData("int",4);
        caller.type("APIPublisherAdd.tf_APIContext",varAPIContext);
        String varAPIVersion = param_APIVersion+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_APIVersion",varAPIVersion);
        //Type valid image path
        caller.type("APIPublisherAdd.btn_BrowseImage",param_APIImagePath);
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("6000");
        //click save and verify warning
        caller.type("APIPublisherAdd.tf_URLPattern",varAPIName+"/"+varAPIContext);
        caller.click("APIPublisherAdd.chk_Post");
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Add");
        caller.checkElementPresent("APIPublisherAdd.btn_Save",false,"");
        caller.pause("2000");
        caller.click("APIPublisherAdd.btn_Save");
        //Go to implement stage
        //waiting for content load
        caller.pause("4000");
        caller.checkElementPresent("APIPublisherAdd.lnk_NextImplement",false,"");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPoint);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("4000");
        //Start manage stage
        caller.click("APIPublisherAdd.dd_tireAvailabilityConfig");
        caller.pause("2000");
        caller.click("APIPublisherAdd.chk_tireSelectionUnlimited");
        caller.click("APIPublisherAdd.btn_SavePublish");
        caller.checkElementPresent("APIPublisherAdd.ele_lblFinalClose",false,"");
        caller.click("APIPublisherAdd.ele_lblFinalClose");
        //APIM-393: Successfully logged in user should be able search with keywords that contains only part of the context name
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        lib_Common.bc_APIStoreLogin(caller, param_usernameStore,param_passwordStore);
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_APIs");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.tf_APISearchStore",false,"");
        caller.type("APIStoreHome.tf_APISearchStore",param_searchContext+varAPIContext);
        //Delete part of context
        caller.fireEvent("KEY%key=backspace","2000");
        caller.fireEvent("KEY%key=backspace","2000");
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.pause("2000");
        caller.checkElementPresent("APIStoreHome.lnk_APINameStore","param_APIName_PARAM:" + varAPIName,false,"xxxx");
        caller.pause("2000");
        caller.writeToReport("End of executing APIM_393");	
    }
    /**
     *  Business component APIM_107.
     */
    public final static void APIM_107(final SeleniumTestBase caller, final String param_UserNamePublisher, final String param_PasswordPublisher, final String param_publisherURL, final String param_APIName) throws Exception {
        //When user clicks on the '?' icon of the visibility field tip box should open.
        //Login into the publisher
        caller.pause("3000");
        lib_Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStore,param_passwordStore);
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
        lib_Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStore,param_passwordStore);
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
        lib_Common.bc_LogOut_APIPublisher(caller, param_userNamePublisher);
        //Navigate to store
        lib_Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
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
        lib_Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
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
        lib_Common.bc_Login_APIPublisher(caller, param_UserNamePublisher,param_PasswordPublisher,param_publisherURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_usernameStore,param_passwordStore);
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
        lib_Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
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
        lib_Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
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
        lib_Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        //Verify API is visible when not loging to store
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        //Verify API is visible when  loging  with current tenant domain user to store
        lib_Common.bc_APIStoreLogin(caller, param_usernameCurrentDomain,param_passwordCurrentDomain);
        //Wait for content load
        caller.pause("3000");
        caller.checkElementPresent("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        //Verify API is visible when  loging  with other tenant domain user to store
        //Navigate to store
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //Wait for content load
        caller.pause("3000");
        lib_Common.bc_APIStoreLogin(caller, param_usernameOtherTenantDomain,param_passwordOtherTenantDomain);
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
        lib_Common.bc_Login_APIPublisher(caller, param_publisherUserNameOne,param_publisherPasswordOne,param_publisherURL);
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
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
        //Loging with other tenat domain user
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        lib_Common.bc_APIStoreLogin(caller, param_usernameDomainTwo,param_passwordDomainTwo);
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
        lib_Common.bc_NavigateToStore(caller, param_serverName,param_storeURL);
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //Verify API is visible when  loging  with user role given in API visibility
        lib_Common.bc_APIStoreLogin(caller, param_usernameSubscriberCurrentDomain,param_PasswordSubscriberCurrentDomain);
        //waiting for content load
        caller.pause("2000");
        //Verify API is  visible fo ruser with  when give API visibility as my domain
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","true",false,"");
        //waiting for content load
        caller.pause("2000");
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //Verify API is not  visible when  loging when user not mention in select visibility to role user to store
        lib_Common.bc_APIStoreLogin(caller, param_usernameStoreOtherTenantDomain,param_passwordStoreOtherTenantDomain);
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
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_storeUsernameSameRoleDomainTwo,param_storePasswordDomainTwo);
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
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainOne,param_storeURL);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //Verify API is   visible when  loging  with   user role  given  in multiplr role in API visibility
        lib_Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainOne,param_storePasswordOneDomainOne);
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
        lib_Common.bc_APIStoreLogin(caller, param_storeUsernameTwoDomainOne,param_storePasswordTwoDomainOne);
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
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainOne,param_storeURL);
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //waiting for content load
        caller.pause("2000");
        //Verify API visible
        lib_Common.bc_APIStoreLogin(caller, param_storeUsernameTwoDomainOne,param_storePasswordTwoDomainOne);
        //waiting for content load
        caller.pause("2000");
        //Verify API is  visible fo ruser with  when give API visibility as my domain
        caller.checkObjectProperty("APIStoreAPIs.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","true",false,"");
        //waiting for content load
        caller.pause("2000");
        //Loging user with Same domain
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainOne,param_storeURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_storeUsernameTwoDomainOne,param_storePasswordTwoDomainOne);
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
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainOne,param_storeURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainOne,param_storePasswordOneDomainOne);
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
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainTwo,param_storePasswordOneDomainTwo);
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
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
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
        lib_Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainTwo,param_storePasswordOneDomainTwo);
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
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainOne,param_storeURL);
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //Verify API is not  visible when  loging  with   user role one given in API visibility with other tenant
        lib_Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainOne,param_storePasswordOneDomainOne);
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
        lib_Common.bc_NavigateToStore(caller, param_serverNameDomainTwo,param_storeURL);
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");
        //Verify API is not  visible when  loging  with   user role one given in API visibility with other tenanT
        lib_Common.bc_APIStoreLogin(caller, param_storeUsernameOneDomainTwo,param_storePasswordOneDomainTwo);
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
