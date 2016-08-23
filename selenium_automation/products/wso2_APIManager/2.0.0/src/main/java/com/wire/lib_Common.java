package com.wire;

import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;
import org.openqa.selenium.By;
import com.virtusa.isq.vtaf.utils.PropertyHandler;

/**
 *  Class lib_Common contains reusable business components 
 *  Each method in this class correspond to a reusable business component.
 */
public class lib_Common {

    /**
     *  Business component bc_Login_APIPublisher.
     * 
     */
    public final static void bc_Login_APIPublisher(final SeleniumTestBase caller, final String param_publisherURL, final String param_keyUserName, final String param_keyPassword, final String param_pauseFourSeconds) throws Exception {
        //login to API publisher
        caller.writeToReport("Start of BC Login_APIPublisher");
        //Log into AI Publisher
        caller.open("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,param_pauseFourSeconds);
        if(caller.checkElementPresent("APIPublisherLogin.btn_SignIn")){
        //Waiting for content to load
        caller.waitForElement("APIPublisherLogin.tf_UserName",param_pauseFourSeconds);
        String var_UserName = caller.retrieveString(param_keyUserName);
        String var_Password = caller.retrieveString(param_keyPassword);
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",var_UserName);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",var_Password);
        //clock login
        caller.click("APIPublisherLogin.btn_SignIn");
        //Waiting for content to load
        caller.waitForElement("APIPublisherHome.lnk_APIs",param_pauseFourSeconds);
        } else if(caller.checkElementPresent("APIPublisherLogout.btn_LogOut")){
        caller.click("APIPublisherLogout.lnk_Caret");
        //Waiting for content to load
        caller.waitForElement("APIPublisherLogout.btn_LogOut",param_pauseFourSeconds);
        caller.click("APIPublisherLogout.btn_LogOut");
        //Waiting for content to load
        caller.waitForElement("APIPublisherLogin.tf_UserName",param_pauseFourSeconds);
        String var_UserName = caller.retrieveString(param_keyUserName);
        String var_Password = caller.retrieveString(param_keyPassword);
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",var_UserName);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",var_Password);
        //clock login
        caller.click("APIPublisherLogin.btn_SignIn");
        //Waiting for content to load
        caller.waitForElement("APIPublisherHome.lnk_APIs",param_pauseFourSeconds);
        }
        caller.writeToReport("End of BC Login_APIPublisher");	
    }
    /**
     *  Business component bc_Login_APIStore.
     * 
     */
    public final static void bc_Login_APIStore(final SeleniumTestBase caller, final String param_keyUserName, final String param_keyPassword, final String param_pauseThreeSeconds, final String param_pauseSixSeconds) throws Exception {
        //log into store
        caller.writeToReport("Start of BC StoreLogin");
        if(caller.checkElementPresent("APIStoreHome.lnk_login")){
        //Login To API Store
        caller.click("APIStoreHome.lnk_login");
        //Below condition handles multiple user logins
        String varStoreUserName = caller.retrieveString(param_keyUserName);
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString(param_keyPassword);
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        caller.waitForElement("APIStoreHome.btn_login",param_pauseThreeSeconds);
        caller.click("APIStoreHome.btn_login");
        } else if(caller.checkElementPresent("APIStoreHome.lnk_LogOutDropDown")){
        //log out store
        caller.click("APIStoreHome.lnk_LogOutDropDown");
        caller.waitForElement("APIStoreHome.btn_Logout",param_pauseSixSeconds);
        caller.click("APIStoreHome.btn_Logout");
        caller.waitForElement("APIStoreHome.lnk_login",param_pauseSixSeconds);
        //Login To API Store
        caller.click("APIStoreHome.lnk_login");
        //Below condition handles multiple user logins
        String varStoreUserName = caller.retrieveString(param_keyUserName);
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString(param_keyPassword);
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        caller.waitForElement("APIStoreHome.btn_login",param_pauseThreeSeconds);
        caller.click("APIStoreHome.btn_login");
        }
        caller.writeToReport("End of BC StoreLogin");	
    }
    /**
     *  Business component bc_APICarbonLogin.
     * 
     */
    public final static void bc_APICarbonLogin(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_carbonURL, final String param_pauseFourSeconds) throws Exception {
        //API carbon login
        caller.writeToReport("Start of BC APIcarbonLogin");
        caller.open("<param_carbonURL>","param_carbonURL_PARAM:" + param_carbonURL,param_pauseFourSeconds);
        //Wait for content load
        //Verify the carbon home page
        if(caller.checkElementPresent("APICarbonHome.tf_UserName")){
        caller.type("APICarbonHome.tf_UserName",param_username);
        caller.type("APICarbonHome.tf_Password",param_password);
        caller.click("APICarbonHome.btn_Login");
        } else {
        caller.click("APICarbonHome.lnk_SignOut");
        caller.type("APICarbonHome.tf_UserName",param_username);
        caller.type("APICarbonHome.tf_Password",param_password);
        caller.click("APICarbonHome.btn_Login");
        }
        //Check for login failiure
        if(caller.checkElementPresent("APICarbonHome.ele_lblLoginFailedPopup")){
        caller.fail("Carbon Login Failed Please Alter UserName In Datatable Or Delete The Existing User With Current Name");
        }
        caller.writeToReport("End of BC APIcarbonLogin");	
    }
    /**
     *  Business component bc_CreateAndPublishAPINew.
     * 
     */
    public final static void bc_CreateAndPublishAPINew(final SeleniumTestBase caller, final String param_APIName, final String param_APIContext, final String param_APIVersion, final String param_ImagePath, final String param_TagName, final String param_ProductionEndPont, final String param_SandBoxEndpoint, final String param_pauseTwoSeconds, final String param_pauseSixSeconds, final String param_pauseFourSeconds) throws Exception {
        //Creating and publishing API
        caller.writeToReport("Start of BC createAndPublishAPI");
        caller.click("APIPublisherHome.lnk_Add");
        caller.waitForElement("APIPublisherAdd.rdo_DesignNewAPI",param_pauseSixSeconds);
        caller.clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
        caller.waitForElement("APIPublisherAdd.btn_StartCreating",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_APIName",param_pauseTwoSeconds);
        //genarate api name
        String APIName = param_APIName+"_"+caller.generateData("int",3);
        caller.store("var_APIName","String",APIName);
        caller.type("APIPublisherAdd.tf_APIName",APIName);
        //Type API contest
        String APIcontest = param_APIContext+"_"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //storeAPI version
        caller.store("var_APIVersion","String",param_APIVersion);
        //Genarate Tag Name
        String TagName = param_TagName+"_"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_Tags",TagName);
        caller.type("APIPublisherAdd.tf_Tags",TagName+org.openqa.selenium.Keys.ENTER);
        caller.click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true");
        caller.pause(param_pauseTwoSeconds);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseSixSeconds);
        //click save and verify warning
        caller.doubleClick("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Yes",param_pauseTwoSeconds);
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.pause(param_pauseSixSeconds);
        caller.click("APIPublisherAdd.lnk_NextImplement");
        lib_Common.bc_PrototypeAPI(caller, param_pauseSixSeconds);
        caller.pause(param_pauseFourSeconds);
        caller.clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
        caller.pause(param_pauseFourSeconds);
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.pause(param_pauseFourSeconds);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true");
        caller.pause(param_pauseTwoSeconds);
        caller.click("APIPublisherBrowse.btn_Save");
        caller.pause(param_pauseSixSeconds);
        caller.pause(param_pauseSixSeconds);
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_NextManage",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.pause(param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.chk_Gold",param_pauseTwoSeconds);
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        //Wait for content load
        caller.waitForElement("APIPublisherBrowse.btn_SaveAndPublish",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        caller.pause(param_pauseSixSeconds);
        //Wait for content load
        caller.waitForElement("APIPublisherBrowse.btn_Close",param_pauseSixSeconds);
        caller.clickAt("APIPublisherBrowse.btn_Close","0,0");
        caller.pause(param_pauseFourSeconds);
        caller.writeToReport("End of BC createAndPublishAPI");	
    }
    /**
     *  Business component bc_CreateAPI_DesignStage.
     * 
     */
    public final static void bc_CreateAPI_DesignStage(final SeleniumTestBase caller, final String param_APIName, final String param_APIContext, final String param_APIVersion, final String param_TagName, final String param_pauseTwoSeconds, final String param_pauseSixSeconds) throws Exception {
        //Creating and publishing API
        caller.writeToReport("Start of BC CreateAPI_DesignStage");
        caller.click("APIPublisherHome.lnk_Add");
        caller.waitForElement("APIPublisherAdd.rdo_DesignNewAPI",param_pauseSixSeconds);
        caller.clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
        caller.waitForElement("APIPublisherAdd.btn_StartCreating",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_APIName",param_pauseTwoSeconds);
        //genarate api name
        String APIName = param_APIName+"_"+caller.generateData("int",3);
        caller.store("var_APIName","String",APIName);
        caller.type("APIPublisherAdd.tf_APIName",APIName);
        //Type API contest
        String APIcontest = param_APIContext+"_"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //storeAPI version
        caller.store("var_APIVersion","String",param_APIVersion);
        //Genarate Tag Name
        String TagName = param_TagName+"_"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_Tags",TagName);
        caller.type("APIPublisherAdd.tf_Tags",TagName+org.openqa.selenium.Keys.ENTER);
        if(caller.checkElementPresent("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true")){
        caller.click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true");
        caller.pause(param_pauseTwoSeconds);
        }
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseSixSeconds);
        //click save and verify warning
        caller.doubleClick("APIPublisherAdd.btn_Save");
        for(int TotalCount=8;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Fifteen Seconds");
        }
        }
        caller.pause(param_pauseTwoSeconds);
        }
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Yes",param_pauseTwoSeconds);
        caller.click("APIPublisherAdd.btn_Yes");
        caller.writeToReport("End of BC CreateAPI_DesignStage");	
    }
    /**
     *  Business component bc_CreateAndPublishAPI.
     * 
     */
    public final static void bc_CreateAndPublishAPI(final SeleniumTestBase caller, final String param_APIName, final String param_APIContext, final String param_APIVersion, final String param_ImagePath, final String param_TagName, final String param_ProductionEndPont, final String param_SandBoxEndpoint, final String param_pauseTwoSeconds, final String param_pauseSixSeconds, final String param_pauseFourSeconds) throws Exception {
        //Creating and publishing API
        caller.writeToReport("Start of BC createAndPublishAPI");
        caller.click("APIPublisherHome.lnk_Add");
        caller.waitForElement("APIPublisherAdd.rdo_DesignNewAPI",param_pauseSixSeconds);
        caller.clickAt("APIPublisherAdd.rdo_DesignNewAPI","0,0");
        caller.waitForElement("APIPublisherAdd.btn_StartCreating",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_APIName",param_pauseTwoSeconds);
        //genarate api name
        String APIName = param_APIName+"_"+caller.generateData("int",3);
        caller.store("var_APIName","String",APIName);
        caller.type("APIPublisherAdd.tf_APIName",APIName);
        //Type API contest
        String APIcontest = param_APIContext+"_"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //storeAPI version
        caller.store("var_APIVersion","String",param_APIVersion);
        //Genarate Tag Name
        String TagName = param_TagName+"_"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_Tags",TagName);
        caller.type("APIPublisherAdd.tf_Tags",TagName+org.openqa.selenium.Keys.ENTER);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseSixSeconds);
        //click save and verify warning
        caller.doubleClick("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Yes",param_pauseTwoSeconds);
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.lnk_NextImplement",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.lnk_NextImplement");
        lib_Common.bc_PrototypeAPI(caller, param_pauseSixSeconds);
        caller.waitForElement("APIPublisherBrowse.ele_lblManagedAPI",param_pauseSixSeconds);
        caller.clickAt("APIPublisherBrowse.ele_lblManagedAPI","0,0");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_Save1");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_NextManage",param_pauseSixSeconds);
        caller.pause(param_pauseSixSeconds);
        caller.doubleClick("APIPublisherBrowse.btn_NextManage");
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.chk_Gold",param_pauseTwoSeconds);
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        //Wait for content load
        caller.waitForElement("APIPublisherBrowse.btn_SaveAndPublish",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //Wait for content load
        caller.waitForElement("APIPublisherBrowse.btn_Close",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_Close");
        caller.writeToReport("End of BC createAndPublishAPI");	
    }
    /**
     *  Business component bc_PrototypeAPI.
     * 
     */
    public final static void bc_PrototypeAPI(final SeleniumTestBase caller, final String param_pauseSixSeconds) throws Exception {
        //Deploying API as prototype
        caller.writeToReport("Start of BC PrototypeAPI");
        caller.clickAt("APIPublisherBrowse.ele_lblPrototype","0,0");
        caller.pause(param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_SavePrototype");
        caller.pause(param_pauseSixSeconds);
        caller.pause(param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_DeployAsPrototype");
        caller.pause(param_pauseSixSeconds);
        caller.pause(param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_Close");
        caller.writeToReport("End of BC PrototypeAPI");	
    }
    /**
     *  Business component bc_DeleteAPI.
     * 
     */
    public final static void bc_DeleteAPI(final SeleniumTestBase caller, final String param_pauseThreeSeconds) throws Exception {
        caller.writeToReport("Start of BC DeleteAPI");
        //Navigate to publisher for delete APIs
        caller.checkElementPresent("APIPublisherHome.lnk_APIs",false,"");
        if(caller.checkElementPresent("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:false")){
        caller.click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:false");
        caller.pause(param_pauseThreeSeconds);
        }
        caller.click("APIPublisherHome.lnk_APIs");
        caller.pause(param_pauseThreeSeconds);
        if(caller.checkElementPresent("APIPublisherBrowse.ele_lblDeleteAPI")){
        for(;caller.checkElementPresent("APIPublisherBrowse.ele_lblDeleteAPI");){
        caller.click("APIPublisherBrowse.ele_lblDeleteAPI");
        caller.waitForElementEnable("APIPublisherBrowse.btn_Yes");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_Yes",param_pauseThreeSeconds);
        caller.click("APIPublisherBrowse.btn_Yes");
        for(;caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIDeletePleaseWait");){
        //waiting for content load
        caller.pause(param_pauseThreeSeconds);
        }
        //waiting for content load
        caller.pause(param_pauseThreeSeconds);
        }
        }
        caller.writeToReport("End of BC DeleteAPI");	
    }
    /**
     *  Business component bc_AddScopes.
     * 
     */
    public final static void bc_AddScopes(final SeleniumTestBase caller, final String param_ScopeKey, final String param_ScopeName, final String param_pauseTwoSeconds) throws Exception {
        //addition of new scopes
        caller.writeToReport("Start of BC AddScopes");
        caller.pause(param_pauseTwoSeconds);
        caller.click("Scopes.btn_AddScope");
        caller.pause(param_pauseTwoSeconds);
        caller.type("Scopes.tf_ScopeKey",param_ScopeKey);
        caller.pause(param_pauseTwoSeconds);
        caller.type("Scopes.tf_ScopeName",param_ScopeName);
        caller.pause(param_pauseTwoSeconds);
        caller.click("Scopes.btn_SubmitScope");
        caller.pause(param_pauseTwoSeconds);
        caller.writeToReport("End of BC AddScopes");	
    }
    /**
     *  Business component bc_ManagedAPI.
     * 
     */
    public final static void bc_ManagedAPI(final SeleniumTestBase caller, final String param_APIName, final String param_ProductionEndPont, final String param_SandBoxEndpoint, final String param_pauseEightSeconds) throws Exception {
        //Managed API
        caller.writeToReport("Start of BC ManagedAPI");
        caller.waitForElement("APIPublisherHome.lnk_APIs",param_pauseEightSeconds);
        caller.click("APIPublisherHome.lnk_APIs");
        //waiting for content load
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //Search API in Publisher
        //wait for content load
        caller.waitForElement("APIPublisherHome.tf_APISearch",param_pauseEightSeconds);
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        caller.waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,param_pauseEightSeconds);
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.waitForElement("APIPublisherAdd.lnk_NextImplement",param_pauseEightSeconds);
        caller.click("APIPublisherAdd.lnk_NextImplement");
        caller.waitForElement("APIPublisherBrowse.ele_lblManagedAPI",param_pauseEightSeconds);
        caller.clickAt("APIPublisherBrowse.ele_lblManagedAPI","10,1");
        /*
        Click
         object=APIPublisherBrowse.ele_lblManagedAPI
        */
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        for(int TotalCount=3;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Fifteen Seconds");
        }
        }
        caller.pause(param_pauseEightSeconds);
        }
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_NextManage",param_pauseEightSeconds);
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.writeToReport("End of BC ManagedAPI");	
    }
    /**
     *  Business component bc_SelectScope.
     * 
     */
    public final static void bc_SelectScope(final SeleniumTestBase caller, final String param_verbMethodName, final String param_ScopeName) throws Exception {
        //selection of scopes
        caller.writeToReport("Start of BC SelectScope");
        caller.click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + param_verbMethodName);
        caller.select("Scopes.ele_ddScope",param_ScopeName);
        caller.click("Scopes.btn_Right");
        caller.writeToReport("End of BC SelectScope");	
    }
    /**
     *  Business component bc_SelectTiers.
     * 
     */
    public final static void bc_SelectTiers(final SeleniumTestBase caller, final String param_pauseOneSecond) throws Exception {
        //selection of tiers
        caller.writeToReport("Start of BC SelectTiers");
        caller.waitForElementEnable("APIPublisherBrowse.ele_ddTierAvilability");
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        caller.waitForElement("APIPublisherBrowse.chk_Unlimited",param_pauseOneSecond);
        caller.click("APIPublisherBrowse.chk_Unlimited");
        caller.waitForElement("APIPublisherBrowse.chk_Gold",param_pauseOneSecond);
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.waitForElement("APIPublisherBrowse.chk_Silver",param_pauseOneSecond);
        caller.click("APIPublisherBrowse.chk_Silver");
        caller.waitForElement("APIPublisherBrowse.chk_Bronze",param_pauseOneSecond);
        caller.click("APIPublisherBrowse.chk_Bronze");
        caller.waitForElement("APIPublisherBrowse.ele_ddTierAvilability",param_pauseOneSecond);
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        caller.writeToReport("End of BC SelectTiers");	
    }
    /**
     *  Business component bc_Carbon_CreateTenant.
     * 
     */
    public final static void bc_Carbon_CreateTenant(final SeleniumTestBase caller, final String param_Username, final String param_Password, final String param_FirstName, final String param_LastName, final String param_AdminUserName, final String param_AdminPassword, final String param_Email, final String param_CarbonURL, final String param_DomainName, final String param_pauseTwoSeconds) throws Exception {
        //Create a tenant
        caller.writeToReport("Start of BC CreateTenant");
        //Logged in to carbon
        lib_Common.bc_APICarbonLogin(caller, param_Username,param_Password,param_CarbonURL,param_pauseTwoSeconds);
        //Waiting for content load
        caller.waitForElement("APICarbonHome.btn_Configure",param_pauseTwoSeconds);
        //Go to Configure tab
        caller.click("APICarbonHome.btn_Configure");
        caller.click("APICarbonHome.link_AddNewTenant");
        //Type the tenant domain
        caller.type("APICarbonHome.tf_Domain",param_DomainName);
        //type tenant first name
        caller.type("APICarbonHome.tf_FirstName",param_FirstName);
        //type tenant last name
        caller.type("APICarbonHome.tf_LastName",param_LastName);
        //type admin user name
        caller.type("APICarbonHome.tf_AdminUserName",param_AdminUserName);
        //type adminpassword
        caller.type("APICarbonHome.tf_AdminPassword",param_AdminPassword);
        caller.type("APICarbonHome.tfAdminPasswordRepeat",param_AdminPassword);
        //type email address
        caller.type("APICarbonHome.tf_Email",param_Email);
        //Waiting for content load
        caller.waitForElement("APICarbonHome.btn_Save",param_pauseTwoSeconds);
        caller.click("APICarbonHome.btn_Save");
        //Waiting for content load
        caller.waitForElement("APICarbonHome.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("APICarbonHome.btn_OkPopUp");
        //Waiting for content load
        caller.waitForElement("APICarbonHome.lnk_SignOut",param_pauseTwoSeconds);
        //Sign out from carbon
        caller.click("APICarbonHome.lnk_SignOut");
        caller.writeToReport("End of BC CreateTenant");	
    }
    /**
     *  Business component bc_TenantUserRoleAndAssign.
     * 
     */
    public final static void bc_TenantUserRoleAndAssign(final SeleniumTestBase caller, final String param_RoleName, final String param_UserName, final String param_pauseTwoSeconds) throws Exception {
        //Create a tenant user and assign role to it
        caller.writeToReport("Start of BC TenantUserRoleAndAssign");
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleName);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login1",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create1");
        caller.click("CarbonUserRole.chk_Publish1");
        caller.click("CarbonUserRole.chk_Subscribe1");
        }
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("4000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.writeToReport("End of BC TenantUserRoleAndAssign");	
    }
    /**
     *  Business component bc_Create_Carbon_User.
     * 
     */
    public final static void bc_Create_Carbon_User(final SeleniumTestBase caller, final String param_TenantUserName, final String param_TenantUserPassword, final String param_retypeTenantUserPassword, final String param_pauseTwoSeconds) throws Exception {
        //Create Carbon user from Tenant User
        caller.writeToReport("Start of BC Create_Carbon_User");
        caller.checkElementPresent("APICarbonHome.btn_Configure",false,"");
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        /*
        //Click on Configure

        Click
         object=APICarbonHome.btn_Configure

        WaitForElement
         object=APICarbonHome.lnk_UserandRoles
         ms=@param_pauseTwoSeconds
        //Click User and Roles
        Click
         object=APICarbonHome.lnk_UserandRoles

        WaitForElement
         object=APICarbonHome.lnk_User
         ms=@param_pauseTwoSeconds
        //Click User
        Click
         object=APICarbonHome.lnk_User
        */
        //Add link at users and roles tab
        caller.waitForElement("APICarbonHome.lnk_UserAndRoles_Add",param_pauseTwoSeconds);
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        caller.waitForElement("APICarbonHome.lnk_AddNewUser",param_pauseTwoSeconds);
        caller.click("APICarbonHome.lnk_AddNewUser");
        //Type new Tenant creating Username
        caller.type("CarbonAddUser.tf_UserName",param_TenantUserName);
        //Type new Tenant creating password
        caller.type("CarbonAddUser.tf_password",param_TenantUserPassword);
        //Re type new Tenant creating password
        caller.type("CarbonAddUser.tf_retypePassword",param_retypeTenantUserPassword);
        //Click on Next
        caller.click("CarbonAddUser.btn_next");
        if(caller.checkElementPresent("CarbonAddUser.ele_LblUserCreationFailedPopup")){
        caller.fail("User Creation Failed Please Re-run With Valid Fied Names");
        }
        //Wait for content load
        caller.checkElementPresent("CarbonAddUser.btn_finish",false,"");
        caller.click("CarbonAddUser.btn_finish");
        caller.checkElementPresent("CarbonAddUser.btn_Ok",false,"");
        caller.click("CarbonAddUser.btn_Ok");
        caller.writeToReport("End of BC Create_Carbon_User.");	
    }
    /**
     *  Business component bc_TenantUser_CreateRoles_And_AssignRoles.
     * 
     */
    public final static void bc_TenantUser_CreateRoles_And_AssignRoles(final SeleniumTestBase caller, final String param_TenantPublisherUserName, final String param_TenantPublisherPassword, final String param_retypeTenantPublisherPassword, final String param_RoleNamePublisher, final String param_TenantStoreUserName, final String param_TenantStorePassword, final String param_retypeTenantStorePassword, final String param_RoleNameSubscriber, final String param_pauseOneSecond, final String param_pauseTwoSeconds, final String param_pauseThreeSeconds, final String param_pauseFourSeconds) throws Exception {
        //Create tenant users and assign roles to the created users
        caller.writeToReport("Start of BC TenantUser_CreateRoles_And_AssignRoles");
        //----------------------------------------------------------------API Publisher User Creation------------------------------------------------------------------------------
        lib_Common.bc_Create_Carbon_User(caller, param_TenantPublisherUserName,param_TenantPublisherPassword,param_retypeTenantPublisherPassword,param_pauseThreeSeconds);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        /*
        Click
         object=APICarbonHome.lnk_UserandRoles

        //Waiting for content load
        WaitForElement
         object=CarbonUserRole.lnk_Roles
         ms=@param_pauseThreeSeconds
        Click
         object=CarbonUserRole.lnk_Roles
        */
        caller.waitForElement("CarbonUserRole.lnk_AddNewRole",param_pauseThreeSeconds);
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.waitForElement("CarbonUserRole.tf_RoleName",param_pauseTwoSeconds);
        //Create role for publisher
        caller.type("CarbonUserRole.tf_RoleName",param_RoleNamePublisher);
        caller.waitForElement("CarbonUserRole.btn_Next",param_pauseOneSecond);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login1",param_pauseThreeSeconds);
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        //Click Check box create
        caller.click("CarbonUserRole.chk_Create1");
        //Click Check box publish
        caller.click("CarbonUserRole.chk_Publish1");
        }
        //Click Check box Governance
        caller.click("CarbonUserRole.chk_governance1");
        caller.waitForElement("CarbonUserRole.chk_govern1",param_pauseOneSecond);
        //Click Check box govern
        caller.click("CarbonUserRole.chk_govern1");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_TenantPublisherUserName,param_pauseFourSeconds);
        //Check the username created in previously
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_TenantPublisherUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        //----------------------------------------------------------------------API Store User Creation---------------------------------------------------------------------------
        caller.waitForElement("APICarbonHome.btn_Configure",param_pauseFourSeconds);
        lib_Common.bc_Create_Carbon_User(caller, param_TenantStoreUserName,param_TenantStorePassword,param_retypeTenantStorePassword,param_pauseThreeSeconds);
        //Waiting for content load
        caller.waitForElement("APICarbonHome.lnk_UserAndRoles_Add",param_pauseFourSeconds);
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        /*
        Click
         object=APICarbonHome.lnk_UserandRoles
        //Waiting for content load
        WaitForElement
         object=CarbonUserRole.lnk_Roles
         ms=@param_pauseFourSeconds
        Click
         object=CarbonUserRole.lnk_Roles
        */
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleNameSubscriber);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login1",param_pauseFourSeconds);
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe1");
        }
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_TenantStoreUserName,param_pauseFourSeconds);
        //
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_TenantStoreUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.writeToReport("End of BC TenantUser_CreateRoles_And_AssignRoles");	
    }
    /**
     *  Business component bc_AdminUser_CreateRoles_And_AssignRoles.
     * 
     */
    public final static void bc_AdminUser_CreateRoles_And_AssignRoles(final SeleniumTestBase caller, final String param_SuperAdminPublisherUserName, final String param_SuperAdminPublisherUserPassword, final String param_retypeSuperAdminPublisherPassword, final String param_PublisherRoleName, final String param_SuperAdminStoreUserName, final String param_SuperAdminStoreUserPassword, final String param_retypeSuperAdminStorePassword, final String param_StoreRoleName, final String param_StoreRoleNameSpecialOne, final String param_IsThereASuperStoreUser, final String param_pauseTwoSeconds, final String param_pauseFourSeconds) throws Exception {
        //Create admin users and assign roles to the created users
        caller.writeToReport("Start of BC AdminUser_CreateRoles_And_AssignRoles");
        //----------------------------------------------------------------API Publisher User Creation-------------------------------------------------------------------------------
        lib_Common.bc_Create_Carbon_User(caller, param_SuperAdminPublisherUserName,param_SuperAdminPublisherUserPassword,param_retypeSuperAdminPublisherPassword,param_pauseFourSeconds);
        caller.waitForElement("APICarbonHome.lnk_UserAndRoles_Add",param_pauseFourSeconds);
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        /*
        //Waiting for content load
        Click
         object=APICarbonHome.lnk_UserandRoles
        //Waiting for content load
        WaitForElement
         object=CarbonUserRole.lnk_Roles
         ms=@param_pauseTwoSeconds
        Click
         object=CarbonUserRole.lnk_Roles
        */
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_PublisherRoleName);
        caller.click("CarbonUserRole.btn_Next");
        //check role creation error popup
        if(caller.checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
        caller.fail("The Entered Role Name Does Not Meet With The Rules");
        }
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login",param_pauseFourSeconds);
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create");
        caller.click("CarbonUserRole.chk_Publish");
        }
        caller.click("CarbonUserRole.chk_governance");
        caller.waitForElement("CarbonUserRole.chk_govern",param_pauseFourSeconds);
        caller.click("CarbonUserRole.chk_govern");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminPublisherUserName,param_pauseFourSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminPublisherUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        //----------------------------------------------------------------------API Store User Creation---------------------------------------------------------------------------
        caller.waitForElement("APICarbonHome.btn_Configure",param_pauseFourSeconds);
        lib_Common.bc_Create_Carbon_User(caller, param_SuperAdminStoreUserName,param_SuperAdminStoreUserPassword,param_retypeSuperAdminStorePassword,param_pauseFourSeconds);
        //Waiting for content load
        caller.waitForElement("APICarbonHome.lnk_UserAndRoles_Add",param_pauseFourSeconds);
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        /*
        Click
         object=APICarbonHome.lnk_UserandRoles
        //Waiting for content load
        WaitForElement
         object=CarbonUserRole.lnk_Roles
         ms=@param_pauseFourSeconds
        Click
         object=CarbonUserRole.lnk_Roles
        */
        caller.waitForElement("CarbonUserRole.lnk_AddNewRole",param_pauseFourSeconds);
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.waitForElement("CarbonUserRole.tf_RoleName",param_pauseFourSeconds);
        caller.type("CarbonUserRole.tf_RoleName",param_StoreRoleName);
        caller.waitForElement("CarbonUserRole.btn_Next",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_Next");
        //check role creation error popup
        if(caller.checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
        caller.fail("The Entered Role Name Does Not Meet With The Rules");
        }
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login",param_pauseFourSeconds);
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe");
        }
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminStoreUserName,param_pauseFourSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminStoreUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        //----------------------------------------------------------------------API Store User Creation witout subscription privilages---------------------------------------------------------------------------
        if(param_IsThereASuperStoreUser.equals("yes")){
        /*
        Call
         businessComponent=lib_Common.bc_Create_Carbon_User
         param_TenantUserName=@param_SuperAdminStoreUserName
         param_TenantUserPassword=@param_SuperAdminStoreUserPassword
         param_retypeTenantUserPassword=@param_retypeSuperAdminStorePassword
        */
        caller.waitForElement("APICarbonHome.lnk_UserAndRoles_Add",param_pauseFourSeconds);
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        /*
        WaitForElement
          object=APICarbonHome.lnk_UserandRoles
          ms=@param_pauseFourSeconds
         Click
          object=APICarbonHome.lnk_UserandRoles
        //Waiting for content load
         WaitForElement
          object=CarbonUserRole.lnk_Roles
          ms=@param_pauseFourSeconds
         Click
          object=CarbonUserRole.lnk_Roles
        */
        caller.waitForElement("CarbonUserRole.lnk_AddNewRole",param_pauseFourSeconds);
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.waitForElement("CarbonUserRole.tf_RoleName",param_pauseTwoSeconds);
        caller.type("CarbonUserRole.tf_RoleName",param_StoreRoleNameSpecialOne);
        caller.click("CarbonUserRole.btn_Next");
        //check role creation error popup
        if(caller.checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
        caller.fail("The Entered Role Name Does Not Meet With The Rules");
        }
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login",param_pauseFourSeconds);
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        /*
        Click
          object=CarbonUserRole.chk_Subscribe
        */
        }
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminStoreUserName,param_pauseFourSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminStoreUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        }
        caller.waitForElement("APICarbonHome.lnk_SignOut",param_pauseFourSeconds);
        caller.click("APICarbonHome.lnk_SignOut");
        caller.writeToReport("End of BC AdminUser_CreateRoles_And_AssignRoles");	
    }
    /**
     *  Business component bc_SelectServer.
     * 
     */
    public final static void bc_SelectServer(final SeleniumTestBase caller, final String param_TenantOrAdmin) throws Exception {
        //Select the desired domain
        caller.writeToReport("Start of BC SelectServer");
        //Below condition handles multiple user logins
        if(param_TenantOrAdmin.equals("TenantOne")){
        String varServerName = caller.retrieveString("keyServerNameOne");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + varServerName);
        } else if(param_TenantOrAdmin.equals("Tenant")){
        String varServerName = caller.retrieveString("keyServerNameOne");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + varServerName);
        /*
        ElseIf
         expression=@param_TenantOrAdmin.equals("TenantOneServerTwo")
         Retrieve
          key=keyServerNameOne
          var=varServerName
          type=String
         Click
          object=APIStoreHome.img_APIStoreAvailableServer
          param_serverName=@varServerName
        */
        } else if(param_TenantOrAdmin.equals("TenantTwo")){
        String varServerName = caller.retrieveString("keyServerNameTwo");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + varServerName);
        } else if(param_TenantOrAdmin.equals("TenantThree")){
        String varServerName = caller.retrieveString("keyServerNameThree");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + varServerName);
        } else if(param_TenantOrAdmin.equals("Admin")){
        String varServerName = caller.retrieveString("keyServerNameCarbonSuper");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + varServerName);
        } else if(param_TenantOrAdmin.equals("carbon.super")){
        String varServerName = caller.retrieveString("keyServerNameCarbonSuper");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + varServerName);
        /*
        ElseIf
         expression=@param_TenantOrAdmin.equals("AdminServerTwo")
         Retrieve
          key=keyServerNameCarbonSuper
          var=varServerName
          type=String
         Click
          object=APIStoreHome.img_APIStoreAvailableServer
          param_serverName=@varServerName
        */
        }
        caller.writeToReport("End of BC SelectServer");	
    }
    /**
     *  Business component bc_TenantUser_CreateRoles_And_AssignRoles_WithManageTierPermission.
     * 
     */
    public final static void bc_TenantUser_CreateRoles_And_AssignRoles_WithManageTierPermission(final SeleniumTestBase caller, final String param_TenantPublisherUserName, final String param_TenantPublisherPassword, final String param_retypeTenantPublisherPassword, final String param_RoleNamePublisher, final String param_TenantStoreUserName, final String param_TenantStorePassword, final String param_retypeTenantStorePassword, final String param_RoleNameSubscriber, final String param_pauseTwoSeconds, final String param_pauseFourSeconds) throws Exception {
        //Create tenant users and assign roles to the created users
        caller.writeToReport("Start of BC TenantUser_CreateRoles_And_AssignRoles");
        //----------------------------------------------------------------API Publisher User Creation------------------------------------------------------------------------------
        lib_Common.bc_Create_Carbon_User(caller, param_TenantPublisherUserName,param_TenantPublisherPassword,param_retypeTenantPublisherPassword,param_pauseTwoSeconds);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        /*
        Click
         object=APICarbonHome.lnk_UserandRoles
        //Waiting for content load
        WaitForElement
         object=CarbonUserRole.lnk_Roles
         ms=@param_pauseFourSeconds
        Click
         object=CarbonUserRole.lnk_Roles
        */
        caller.click("CarbonUserRole.lnk_AddNewRole");
        //Create role for publisher
        caller.type("CarbonUserRole.tf_RoleName",param_RoleNamePublisher);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login1",param_pauseFourSeconds);
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        //Click Check box create
        caller.click("CarbonUserRole.chk_Create1");
        //Click Check box publish
        caller.click("CarbonUserRole.chk_Publish1");
        }
        //Click Check box Governance
        caller.click("CarbonUserRole.chk_governance1");
        caller.waitForElement("CarbonUserRole.chk_govern1",param_pauseTwoSeconds);
        //Click Check box govern
        caller.click("CarbonUserRole.chk_govern1");
        caller.waitForElement("CarbonUserRole.chk_ManageTiersForTenant",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_ManageTiersForTenant");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_TenantPublisherUserName,param_pauseFourSeconds);
        //Check the username created in previously
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_TenantPublisherUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        //----------------------------------------------------------------------API Store User Creation---------------------------------------------------------------------------
        caller.waitForElement("APICarbonHome.btn_Configure",param_pauseFourSeconds);
        lib_Common.bc_Create_Carbon_User(caller, param_TenantStoreUserName,param_TenantStorePassword,param_retypeTenantStorePassword,param_pauseFourSeconds);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        /*
        Click
         object=APICarbonHome.lnk_UserandRoles
        //Waiting for content load
        WaitForElement
         object=CarbonUserRole.lnk_Roles
         ms=@param_pauseFourSeconds
        Click
         object=CarbonUserRole.lnk_Roles
        */
        caller.waitForElement("CarbonUserRole.lnk_AddNewRole",param_pauseFourSeconds);
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.waitForElement("CarbonUserRole.tf_RoleName",param_pauseTwoSeconds);
        caller.type("CarbonUserRole.tf_RoleName",param_RoleNameSubscriber);
        caller.waitForElement("CarbonUserRole.btn_Next",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login1",param_pauseFourSeconds);
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe1");
        }
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_TenantStoreUserName,param_pauseFourSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_TenantStoreUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseFourSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.writeToReport("End of BC TenantUser_CreateRoles_And_AssignRoles");	
    }
    /**
     *  Business component bc_AdminUser_CreateRoles_And_AssignRoles_WithManageTierPermission.
     * 
     */
    public final static void bc_AdminUser_CreateRoles_And_AssignRoles_WithManageTierPermission(final SeleniumTestBase caller, final String param_SuperAdminPublisherUserName, final String param_SuperAdminPublisherUserPassword, final String param_retypeSuperAdminPublisherPassword, final String param_PublisherRoleName, final String param_SuperAdminStoreUserName, final String param_SuperAdminStoreUserPassword, final String param_retypeSuperAdminStorePassword, final String param_StoreRoleName, final String param_StoreRoleNameSpecialOne, final String param_IsThereASuperStoreUser, final String param_pauseSixSeconds, final String param_pauseEightSeconds) throws Exception {
        //Create admin users and assign roles to the created users
        caller.writeToReport("Start of BC AdminUser_CreateRoles_And_AssignRoles");
        //----------------------------------------------------------------API Publisher User Creation-------------------------------------------------------------------------------
        lib_Common.bc_Create_Carbon_User(caller, param_SuperAdminPublisherUserName,param_SuperAdminPublisherUserPassword,param_retypeSuperAdminPublisherPassword,param_pauseSixSeconds);
        caller.waitForElement("APICarbonHome.lnk_UserAndRoles_Add",param_pauseSixSeconds);
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        /*
        WaitForElement
         object=APICarbonHome.lnk_UserandRoles
         ms=@param_pauseSixSeconds
        //Waiting for content load
        Click
         object=APICarbonHome.lnk_UserandRoles
        //Waiting for content load
        WaitForElement
         object=CarbonUserRole.lnk_Roles
         ms=@param_pauseSixSeconds
        Click
         object=CarbonUserRole.lnk_Roles
        */
        caller.waitForElement("CarbonUserRole.lnk_AddNewRole",param_pauseSixSeconds);
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_PublisherRoleName);
        caller.click("CarbonUserRole.btn_Next");
        //check role creation error popup
        if(caller.checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
        caller.fail("The Entered Role Name Does Not Meet With The Rules");
        }
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login",param_pauseEightSeconds);
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create");
        caller.waitForElement("CarbonUserRole.chk_Publish",param_pauseSixSeconds);
        caller.click("CarbonUserRole.chk_Publish");
        }
        caller.click("CarbonUserRole.chk_governance");
        caller.waitForElement("CarbonUserRole.chk_govern",param_pauseSixSeconds);
        caller.click("CarbonUserRole.chk_govern");
        caller.waitForElement("CarbonUserRole.chk_ManageTiers",param_pauseSixSeconds);
        caller.click("CarbonUserRole.chk_ManageTiers");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminPublisherUserName,param_pauseSixSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminPublisherUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        //----------------------------------------------------------------------API Store User Creation---------------------------------------------------------------------------
        lib_Common.bc_Create_Carbon_User(caller, param_SuperAdminStoreUserName,param_SuperAdminStoreUserPassword,param_retypeSuperAdminStorePassword,param_pauseSixSeconds);
        caller.waitForElement("APICarbonHome.lnk_UserAndRoles_Add",param_pauseSixSeconds);
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        /*
        WaitForElement
         object=APICarbonHome.lnk_UserandRoles
         ms=@param_pauseSixSeconds
        //Waiting for content load
        Click
         object=APICarbonHome.lnk_UserandRoles
        //Waiting for content load
        WaitForElement
         object=CarbonUserRole.lnk_Roles
         ms=@param_pauseSixSeconds
        Click
         object=CarbonUserRole.lnk_Roles
        */
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_StoreRoleName);
        caller.click("CarbonUserRole.btn_Next");
        //check role creation error popup
        if(caller.checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
        caller.fail("The Entered Role Name Does Not Meet With The Rules");
        }
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login",param_pauseSixSeconds);
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe");
        }
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminStoreUserName,param_pauseSixSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminStoreUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        //----------------------------------------------------------------------API Store User Creation witout subscription privilages---------------------------------------------------------------------------
        if(param_IsThereASuperStoreUser.equals("yes")){
        /*
        Call
         businessComponent=lib_Common.bc_Create_Carbon_User
         param_TenantUserName=@param_SuperAdminStoreUserName
         param_TenantUserPassword=@param_SuperAdminStoreUserPassword
         param_retypeTenantUserPassword=@param_retypeSuperAdminStorePassword
        */
        caller.waitForElement("APICarbonHome.lnk_UserAndRoles_Add",param_pauseSixSeconds);
        caller.click("APICarbonHome.lnk_UserAndRoles_Add");
        /*
        Click
          object=APICarbonHome.lnk_UserandRoles
        //Waiting for content load
         WaitForElement
          object=CarbonUserRole.lnk_Roles
          ms=@param_pauseSixSeconds
         Click
          object=CarbonUserRole.lnk_Roles
        */
        caller.waitForElement("CarbonUserRole.lnk_AddNewRole",param_pauseSixSeconds);
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.waitForElement("CarbonUserRole.tf_RoleName",param_pauseSixSeconds);
        caller.type("CarbonUserRole.tf_RoleName",param_StoreRoleNameSpecialOne);
        caller.click("CarbonUserRole.btn_Next");
        //check role creation error popup
        if(caller.checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
        caller.fail("The Entered Role Name Does Not Meet With The Rules");
        }
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login",param_pauseSixSeconds);
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        /*
        Click
          object=CarbonUserRole.chk_Subscribe
        */
        }
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminStoreUserName,param_pauseSixSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminStoreUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        }
        caller.click("APICarbonHome.lnk_SignOut");
        caller.writeToReport("End of BC AdminUser_CreateRoles_And_AssignRoles");	
    }
    /**
     *  Business component bc_AdminUser_AssignCreatedRolesToUser.
     * 
     */
    public final static void bc_AdminUser_AssignCreatedRolesToUser(final SeleniumTestBase caller, final String param_IsPublisherCondition, final String param_RoleNameStore, final String param_SuperAdminStoreUserName, final String param_SuperAdminStoreUserPassword, final String param_retypeSuperAdminStorePassword, final String param_RoleNamePublisher, final String param_SuperAdminPublisherUserName, final String param_SuperAdminPublisherUserPassword, final String param_retypeSuperAdminPublisherPassword, final String param_pauseThreeSeconds, final String param_pauseFourSeconds, final String param_pauseSixSeconds, final String param_pauseEightSeconds) throws Exception {
        //Create user and assign roles to user
        caller.writeToReport("Start of BC AdminUser_AssignCreatedRolesToUser");
        //----------------------------------------------------------------API Publisher User Creation------------------------------------------------------------------------------
        if(param_IsPublisherCondition.equals("yes")){
        lib_Common.bc_Create_Carbon_User(caller, param_SuperAdminPublisherUserName,param_SuperAdminPublisherUserPassword,param_retypeSuperAdminPublisherPassword,param_pauseSixSeconds);
        /*
        Click
          object=APICarbonHome.lnk_UserandRoles
        */
        caller.click("APICarbonHome.lnk_UserAndRoles_List");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseSixSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        //In order to assign multiple users to the same role
        caller.click("CarbonUserRole.lnk_AssignUser","param_RoleName_PARAM:" + param_RoleNamePublisher);
        caller.checkElementPresent("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminPublisherUserName,false,"");
        //Waiting for content load
        /*
        WaitForElement
          object=CarbonUserRole.chk_UserName
          param_UserName=@param_SuperAdminPublisherUserName
          ms=@param_pauseSixSeconds
        */
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminPublisherUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.waitForElement("APICarbonHome.lnk_SignOut",param_pauseSixSeconds);
        caller.click("APICarbonHome.lnk_SignOut");
        } else if(param_IsPublisherCondition.equals("no")){
        //----------------------------------------------------------------------API Store User Creation---------------------------------------------------------------------------
        lib_Common.bc_Create_Carbon_User(caller, param_SuperAdminStoreUserName,param_SuperAdminStoreUserPassword,param_retypeSuperAdminStorePassword,param_pauseSixSeconds);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserAndRoles_List");
        /*
        WaitForElement
          object=APICarbonHome.lnk_UserandRoles
          ms=@param_pauseSixSeconds
         Click
          object=APICarbonHome.lnk_UserandRoles
        */
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseSixSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        //In order to assiggn multiple users to the same role
        caller.click("CarbonUserRole.lnk_AssignUser","param_RoleName_PARAM:" + param_RoleNameStore);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminStoreUserName,param_pauseSixSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_SuperAdminStoreUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseSixSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.waitForElement("APICarbonHome.lnk_SignOut",param_pauseSixSeconds);
        caller.click("APICarbonHome.lnk_SignOut");
        }
        caller.writeToReport("End of BC AdminUser_AssignCreatedRolesToUser");	
    }
    /**
     *  Business component bc_APIPublisher_AddAPI_DesignPhaseToInvoke.
     * 
     */
    public final static void bc_APIPublisher_AddAPI_DesignPhaseToInvoke(final SeleniumTestBase caller, final String param_APIName, final String param_APIContext, final String param_APIVersionOne, final String param_APIvisibility, final String param_APIImageName, final String param_TagName, final String param_urlPatternForPostAndPut, final String param_urlPatternForGetDeleteAndHead, final String param_pauseThreeSeconds, final String param_pauseFourSeconds, final String param_pauseSixSeconds, final String param_pauseEightSeconds) throws Exception {
        //Creation of API
        //Loging to the publisher using the created credentials
        //click the add area and to check the object loaded
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(caller.checkElementPresent("APIPublisherHome.lnk_Add")){
        caller.click("APIPublisherHome.lnk_Add");
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Could not find the object 'APIPublisherHome.lnk_Add'");
        }
        }
        }
        caller.clickAt("APIPublisherAdd.rdo_DesignNewAPI","10,1");
        caller.waitForElement("APIPublisherAdd.btn_StartCreating",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_StartCreating");
        //genarate api name
        String APIName = param_APIName+"_"+caller.generateData("int",3);
        caller.store("key_APINameDesign","String",APIName);
        //Type API Name
        caller.type("APIPublisherAdd.tf_APIName",APIName);
        //Type API context
        String APIcontext = "{version}"+"/"+APIName;
        caller.type("APIPublisherAdd.tf_APIContext",APIcontext);
        //Type API version as default
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersionOne);
        caller.store("key_APIVersion","String",param_APIVersionOne);
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.ele_ddVisibility",param_pauseSixSeconds);
        caller.select("APIPublisherBrowse.ele_ddVisibility",param_APIvisibility);
        //uploading image optional
        /*
        //Type valid image path
        SetVariable
         name=java.io.File file
         type=java.io.File file
         paramValue=new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_APIImageName)
        SetVariable
         name=entirePath
         type=String
         paramValue=file.getAbsolutePath()

        //Select the location of the image
        Type
         object=APIPublisherAdd.btn_BrowseImage
         text=@entirePath
        */
        //Genarate Tag Name
        String TagName = param_TagName+"_"+caller.generateData("int",3);
        //Type API tag
        /*
        Type
         object=APIPublisherAdd.tf_Tags
         text=@TagName
        */
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_Tags",param_pauseSixSeconds);
        caller.type("APIPublisherAdd.tf_Tags",TagName+org.openqa.selenium.Keys.ENTER);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_URLPattern",param_pauseSixSeconds);
        //Type the URL pattern for post and put
        caller.type("APIPublisherAdd.tf_URLPattern",param_urlPatternForPostAndPut);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.chk_Post",param_pauseSixSeconds);
        //check the availability of post and put check boxes
        caller.checkElementPresent("APIPublisherAdd.chk_Post",false,"");
        caller.checkElementPresent("APIPublisherAdd.chk_Put",false,"");
        caller.click("APIPublisherAdd.chk_Post");
        caller.click("APIPublisherAdd.chk_Put");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Add",param_pauseSixSeconds);
        //add the soap url
        caller.click("APIPublisherAdd.btn_Add");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_URLPattern",param_pauseSixSeconds);
        //Type the URL pattern for post and put
        caller.type("APIPublisherAdd.tf_URLPattern",param_urlPatternForGetDeleteAndHead);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.chk_Get",param_pauseSixSeconds);
        //check the availability of get,delete&head check boxes
        caller.checkElementPresent("APIPublisherAdd.chk_Get",false,"");
        caller.checkElementPresent("APIPublisherAdd.chk_Delete",false,"");
        caller.checkElementPresent("APIPublisherAdd.chk_Head",false,"");
        caller.click("APIPublisherAdd.chk_Get");
        caller.click("APIPublisherAdd.chk_Delete");
        caller.click("APIPublisherAdd.chk_Head");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Add",param_pauseSixSeconds);
        //add the soap url
        caller.click("APIPublisherAdd.btn_Add");
        //verify the added soap commands get,delete,head and the url pattern
        //check the button availability
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(caller.checkElementPresent("APIPublisherAdd.btn_Save")){
        caller.waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true",param_pauseSixSeconds);
        caller.click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true");
        caller.pause(param_pauseThreeSeconds);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseSixSeconds);
        //click save and verify warning
        caller.clickAt("APIPublisherAdd.btn_Save","0,0");
        //click save and verify warning
        caller.click("APIPublisherAdd.btn_Save");
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Could not find the object 'APIPublisherAdd.btn_Save'");
        }
        }
        }
        //waiting for content load and
        //check the load time
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Fifteen Seconds");
        }
        }
        caller.pause(param_pauseThreeSeconds);
        }
        //check the popup availability
        caller.click("APIPublisherAdd.lnk_NextImplement");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Fifteen Seconds");
        }
        }
        caller.pause(param_pauseThreeSeconds);
        }	
    }
    /**
     *  Business component bc_APIPublisher_AddAPI_ManageToInvoke.
     * 
     */
    public final static void bc_APIPublisher_AddAPI_ManageToInvoke(final SeleniumTestBase caller, final String param_IsAPIDefault, final String param_IsSubscriptionsAvailable, final String param_subscription, final String param_pauseThreeSeconds, final String param_pauseFourSeconds, final String param_pauseSixSeconds, final String param_pauseEightSeconds) throws Exception {
        //verify that the manage page is loaded
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(caller.checkElementPresent("APIPublisherBrowse.ele_ddTierAvilability")){
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Could not find the object 'APIPublisherBrowse.ele_ddTierAvilability'");
        }
        }
        }
        caller.click("APIPublisherBrowse.chk_Unlimited");
        //if the created API version is the default version
        if(param_IsAPIDefault.equals("yes")){
        //Create the new API with a default version
        caller.click("APIPublisherBrowse.chk_ConfigurationDefaultVersion");
        } else {
        }
        //if subscription is diffenet from current tenant which is default value
        if(param_IsSubscriptionsAvailable.equals("yes")){
        caller.select("APIPublisherBrowse.ele_ddSubscription",param_subscription);
        } else {
        }
        caller.click("APIPublisherBrowse.btn_SaveManageAPI");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Fifteen Seconds");
        }
        }
        caller.pause(param_pauseThreeSeconds);
        }
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Fifteen Seconds");
        }
        }
        caller.pause(param_pauseThreeSeconds);
        }
        caller.checkElementPresent("APIPublisherBrowse.btn_Close",false,"");
        caller.waitForElement("APIPublisherBrowse.btn_Close",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_Close");
        //End of creation of API	
    }
    /**
     *  Business component bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke.
     * 
     */
    public final static void bc_APIPublisher_AddAPI_ImplementationPhaseToInvoke(final SeleniumTestBase caller, final String param_productionEndpoint, final String param_IsSandBoxURLRequired, final String param_sandboxEndpoint, final String param_IsEndpointSecuritySchemeRequired, final String param_textEndpointSecurityScheme, final String param_pauseThreeSeconds, final String param_pauseFourSeconds, final String param_pauseSixSeconds, final String param_pauseEightSeconds) throws Exception {
        //verify the manage page
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(caller.checkElementPresent("APIPublisherBrowse.ele_lblManagedAPI")){
        //waiting for content load
        caller.checkElementPresent("APIPublisherBrowse.ele_lblManagedAPI",false,"");
        /*
        Click
           object=APIPublisherBrowse.ele_lblManagedAPI
        */
        caller.clickAt("APIPublisherBrowse.ele_lblManagedAPI","10,1");
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Could not find the object 'APIPublisherBrowse.ele_lblManagedAPI'");
        }
        }
        }
        caller.pause(param_pauseThreeSeconds);
        //wait for content load
        caller.waitForElement("APIPublisherBrowse.ele_lblManagedAPI",param_pauseSixSeconds);
        //Verify the navigated page
        caller.checkElementPresent("APIPublisherBrowse.ele_lblManagedAPI",false,"");
        /*
        Click
         object=APIPublisherBrowse.ele_lblManagedAPI
        */
        caller.pause(param_pauseThreeSeconds);
        //Enter production and sandbox endpoints
        /*
        Click
         object=APIPublisherBrowse.tf_productionEndpoint
        */
        caller.type("APIPublisherBrowse.tf_productionEndpoint",param_productionEndpoint);
        if(param_IsSandBoxURLRequired.equals("yes")){
        /*
        Click
          object=APIPublisherBrowse.tf_sandboxEndpoint
        */
        caller.type("APIPublisherBrowse.tf_sandboxEndpoint",param_sandboxEndpoint);
        }
        if(param_IsEndpointSecuritySchemeRequired.equals("yes")){
        //expand the show more option
        caller.click("APIPublisherBrowse.lnk_ShowmoreOption");
        //wait for content load
        caller.waitForElement("APIPublisherBrowse.ele_ddEndpointSecurityScheme",param_pauseSixSeconds);
        //validate the expanded content
        caller.checkElementPresent("APIPublisherBrowse.ele_ddEndpointSecurityScheme",false,"");
        //select option from the dropdown
        caller.select("APIPublisherBrowse.ele_ddEndpointSecurityScheme",param_textEndpointSecurityScheme);
        }
        caller.pause(param_pauseThreeSeconds);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Fifteen Seconds");
        }
        }
        caller.pause(param_pauseThreeSeconds);
        }
        caller.pause(param_pauseThreeSeconds);
        caller.waitForElement("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true",param_pauseSixSeconds);
        caller.click("APIPublisherHome.lnk_OpenOrCloseLeftMenuSidebar","param_IsExpandedTrueOrFalse_PARAM:true");
        caller.click("APIPublisherBrowse.btn_NextManage");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Fifteen Seconds");
        }
        }
        caller.pause(param_pauseThreeSeconds);
        }	
    }
    /**
     *  Business component bc_APIPublisherSearch.
     * 
     */
    public final static void bc_APIPublisherSearch(final SeleniumTestBase caller, final String param_SearchContent, final String param_APIName, final String param_APIVersion, final String param_pauseFourSeconds) throws Exception {
        //API Publisher Search
        caller.writeToReport("Start Of API Publisher Search");
        caller.waitForElement("APIPublisherHome.lnk_APIs",param_pauseFourSeconds);
        caller.click("APIPublisherHome.lnk_APIs");
        //wait for content load
        caller.waitForElement("APIPublisherHome.tf_APISearch",param_pauseFourSeconds);
        caller.type("APIPublisherHome.tf_APISearch",param_SearchContent);
        //wait for content load
        caller.waitForElement("APIPublisherHome.btn_Search",param_pauseFourSeconds);
        caller.click("APIPublisherHome.btn_Search");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(caller.checkElementPresent("APIPublisherBrowse.lnk_ApiNameWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_APIVersion + "_PARAM," + "param_APIName_PARAM:" + param_APIName)){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Twenty Seconds Hence The API :"+param_APIName+ "  Version :"+param_APIVersion+" Didn't Appear");
        }
        caller.click("APIPublisherHome.btn_Search");
        }
        caller.pause(param_pauseFourSeconds);
        }
        caller.writeToReport("End Of API Publisher Search");	
    }
    /**
     *  Business component bc_APIStoreSearch.
     * 
     */
    public final static void bc_APIStoreSearch(final SeleniumTestBase caller, final String param_APIContent, final String param_APIName, final String param_APIVersion, final String param_pauseFourSeconds) throws Exception {
        //API Store Search
        caller.writeToReport("Start Of API Store Search");
        caller.waitForElement("APIStoreHome.lnk_APIs",param_pauseFourSeconds);
        caller.click("APIStoreHome.lnk_APIs");
        //wait for content load
        caller.waitForElement("APIStoreHome.tf_APISearchStore",param_pauseFourSeconds);
        caller.type("APIStoreHome.tf_APISearchStore",param_APIContent);
        //wait for content load
        caller.waitForElement("APIStoreHome.btn_SearchButtonStore",param_pauseFourSeconds);
        caller.click("APIStoreHome.btn_SearchButtonStore");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(caller.checkElementPresent("APIStoreHome.lnk_APINameStoreWithVersion","param_APIName_PARAM:" +param_APIName + "_PARAM," + "param_versionNumber_PARAM:" + param_APIVersion)){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Twenty Seconds Hence The API :"+param_APIName+ "  Version :"+param_APIVersion+" Didn't Appear");
        }
        caller.click("APIStoreHome.btn_SearchButtonStore");
        }
        caller.pause(param_pauseFourSeconds);
        }
        caller.writeToReport("End Of API Store Search");	
    }
    /**
     *  Business component bc_APIPublisherSearchWithNameVersionAndStatus.
     * 
     */
    public final static void bc_APIPublisherSearchWithNameVersionAndStatus(final SeleniumTestBase caller, final String param_pauseFourSeconds, final String param_SearchContent, final String param_ApiName, final String param_APIVersion, final String param_ApiStatus) throws Exception {
        //API Publisher Search
        caller.writeToReport("Start Of API Publisher Search");
        caller.click("APIPublisherHome.lnk_APIs");
        //wait for content load
        caller.waitForElement("APIPublisherHome.tf_APISearch",param_pauseFourSeconds);
        caller.type("APIPublisherHome.tf_APISearch",param_SearchContent);
        //wait for content load
        caller.waitForElement("APIPublisherHome.btn_Search",param_pauseFourSeconds);
        caller.click("APIPublisherHome.btn_Search");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(caller.checkElementPresent("APIPublisherHome.ele_lblApiNameWithVersionAndStatus","param_version_PARAM:" + param_APIVersion + "_PARAM," + "param_ApiName_PARAM:" + param_ApiName + "_PARAM," + "param_ApiStatus_PARAM:" + param_ApiStatus)){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Twenty Seconds Hence The API :"+param_ApiName+ "  Version :"+param_APIVersion+" Of Status :"+param_ApiStatus+"  Didn't Appear");
        }
        caller.click("APIPublisherHome.btn_Search");
        }
        caller.pause(param_pauseFourSeconds);
        }
        caller.writeToReport("End Of API Publisher Search");	
    }
}
