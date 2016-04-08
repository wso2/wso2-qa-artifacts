package com.testscripts;

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
    public final static void bc_Login_APIPublisher(final SeleniumTestBase caller, final String param_UserName, final String param_Password, final String param_publisherURL, final String param_pauseFourSeconds) throws Exception {
        //login to API publisher
        caller.writeToReport("Start of BC Login_APIPublisher");
        //Log into AI Publisher
        caller.open("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,param_pauseFourSeconds);
        //Waiting for content to load
        caller.waitForElement("APIPublisherLogin.tf_UserName",param_pauseFourSeconds);
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserName);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_Password);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.writeToReport("End of BC Login_APIPublisher");	
    }
    /**
     *  Business component bc_SelectUser.
     * 
     */
    public final static void bc_SelectUser(final SeleniumTestBase caller, final String param_TenantOrAdmin) throws Exception {
        /*
        //Select if the Tenant user or Admin user to log
        If
         expression=@param_TenantOrAdmin.="Tenant"
         Retrieve
          key=keyTenantOnePublisherUserOne
          var=@varTenantOnePublisherUserOne
          type=String
        Else
         Retrieve
          key=e
          var=s
          type=String
        EndIf
        */	
    }
    /**
     *  Business component bc_CreateAPI_Design.
     * 
     */
    public final static void bc_CreateAPI_Design(final SeleniumTestBase caller, final String param_APIVersion, final String param_InvalidAPIImagePath, final String param_APIImagePath, final String param_URLPattern, final String param_APIName, final String param_pauseFourSeconds, final String param_pauseSixSeconds) throws Exception {
        //create API design witout navigating to implement
        caller.writeToReport("Start of BC CreateAPI_Design");
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.ele_lblDesignAPI",param_pauseFourSeconds);
        //Verify design API page apears
        caller.checkElementPresent("APIPublisherAdd.ele_lblDesignAPI",false,"");
        caller.type("APIPublisherAdd.tf_APIName",param_APIName);
        //Type API contest
        String APIcontest = "api"+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        caller.waitForElement("APIPublisherAdd.btn_BrowseImage",param_pauseFourSeconds);
        //Type non image path and verify error
        caller.type("APIPublisherAdd.btn_BrowseImage",param_InvalidAPIImagePath);
        //Waiting for content to load
        caller.waitForElement("APIPublisherBrowse.btn_Save",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_Save");
        //Waiting for content to load
        caller.waitForElement("APIPublisherAdd.ele_lblNonImageFileError",param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherAdd.ele_lblNonImageFileError",false,"");
        //Type valid image path
        caller.type("APIPublisherAdd.btn_BrowseImage",param_APIImagePath);
        for(int i=0;i<15;i++){
        String tag = "tag"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_Tags",tag);
        caller.type("APIPublisherAdd.tf_Tags",tag+org.openqa.selenium.Keys.ENTER);
        }
        caller.waitForElement("APIPublisherAdd.tf_URLPattern",param_pauseSixSeconds);
        //Type URL pattern and resource and did not choose any Verb
        caller.type("APIPublisherAdd.tf_URLPattern",param_URLPattern);
        caller.click("APIPublisherAdd.btn_Add");
        caller.waitForElement("APIPublisherAdd.ele_lblErrorMessageURLPattern",param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherAdd.ele_lblErrorMessageURLPattern",false,"");
        caller.click("APIPublisherAdd.btn_OkErrorMessage");
        //remove URL and resource
        caller.type("APIPublisherAdd.tf_URLPattern","");
        //click save and verify warning
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_Save");
        caller.waitForElement("APIPublisherBrowse.btn_No",param_pauseFourSeconds);
        caller.checkElementPresent("APIPublisherBrowse.btn_No",false,"");
        caller.click("APIPublisherBrowse.btn_No");
        caller.waitForElement("APIPublisherAdd.tf_APIName",param_pauseSixSeconds);
        //Remove API Name
        caller.type("APIPublisherAdd.tf_APIName","");
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseFourSeconds);
        caller.click("APIPublisherAdd.btn_Save");
        caller.waitForElement("APIPublisherAdd.ele_lblWarningMessageAPIName",param_pauseFourSeconds);
        caller.checkElementPresent("APIPublisherAdd.ele_lblWarningMessageAPIName",false,"");
        //Type API name
        caller.type("APIPublisherAdd.tf_APIName",param_APIName);
        //Empty the API context and save
        caller.type("APIPublisherAdd.tf_APIContext","");
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseFourSeconds);
        caller.click("APIPublisherAdd.btn_Save");
        caller.waitForElement("APIPublisherAdd.ele_lblWarningMessageAPIContest",param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherAdd.ele_lblWarningMessageAPIContest",false,"");
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        //Empty the API Version and verify error
        caller.type("APIPublisherAdd.tf_APIVersion","");
        caller.click("APIPublisherAdd.btn_Save");
        caller.waitForElement("APIPublisherAdd.ele_lblWarningMessageAPIVersion",param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherAdd.ele_lblWarningMessageAPIVersion",false,"");
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseFourSeconds);
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Yes",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.lnk_NextImplement",param_pauseSixSeconds);
        //Verify whether goes to  genaral detail page
        caller.checkElementPresent("APIPublisherAdd.lnk_NextImplement",false,"");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.img_ThubmnailImage",param_pauseFourSeconds);
        caller.checkElementPresent("APIPublisherAdd.img_ThubmnailImage",false,"");
        caller.writeToReport("End of BC CreateAPI_Design");	
    }
    /**
     *  Business component bc_CreateAPI_DesignStage.
     * 
     */
    public final static void bc_CreateAPI_DesignStage(final SeleniumTestBase caller, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_APIName, final String param_pauseFourSeconds, final String param_pauseSixSeconds) throws Exception {
        //create a new API upto design stage
        caller.writeToReport("Start of BC CreateAPI_DesignStage");
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_APIName",param_pauseFourSeconds);
        //Type API Name
        caller.type("APIPublisherAdd.tf_APIName",param_APIName);
        //Type API contest
        String APIcontest = "api"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //Type valid image path
        caller.type("APIPublisherAdd.btn_BrowseImage",param_APIImagePath);
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.type("APIPublisherAdd.tf_Tags",param_tagName+org.openqa.selenium.Keys.ENTER);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseSixSeconds);
        //click save and verify warning
        caller.doubleClick("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.ele_lblDefaultResourceMessage",param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage",false,"");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Yes",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.lnk_NextImplement",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.writeToReport("End of BC CreateAPI_DesignStage");	
    }
    /**
     *  Business component bc_VerifyAPIDesignStage.
     * 
     */
    public final static void bc_VerifyAPIDesignStage(final SeleniumTestBase caller, final String param_APIName, final String param_pauseFourSeconds) throws Exception {
        //verify API design stage
        caller.writeToReport("Start of BC VerifyAPIDesignStage");
        caller.checkElementPresent("APIPublisherHome.lnk_Add",false,"");
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_Lifecycle",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.ele_ddState",param_pauseFourSeconds);
        //Verify PROTOTYPED and PUBLISHED are not in Drop down
        caller.checkObjectProperty("APIPublisherBrowse.ele_ddState","MISSINGOPTION","PROTOTYPED",false,"");
        caller.checkObjectProperty("APIPublisherBrowse.ele_ddState","MISSINGOPTION","PUBLISHED",false,"");
        caller.writeToReport("End of BC VerifyAPIDesignStage");	
    }
    /**
     *  Business component bc_DeployAsPrototype.
     * 
     */
    public final static void bc_DeployAsPrototype(final SeleniumTestBase caller, final String param_APIName, final String param_pauseFourSeconds, final String param_pauseSixSeconds) throws Exception {
        //Deploy API as a prototype
        caller.writeToReport("Start of BC DeployAsPrototype");
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.waitForElement("APIPublisherHome.tf_APISearch",param_pauseFourSeconds);
        //Obtain the searched api name
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.waitForElement("APIPublisherBrowse.lnk_Edit",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.waitForElement("APIPublisherAdd.lnk_NextImplement",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.lnk_NextImplement");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Twenty Seconds");
        }
        }
        caller.pause(param_pauseFourSeconds);
        }
        caller.waitForElement("APIPublisherBrowse.ele_lblPrototype",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.ele_lblPrototype");
        caller.waitForElement("APIPublisherBrowse.btn_SavePrototype",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_SavePrototype");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Twenty Seconds");
        }
        }
        caller.pause(param_pauseFourSeconds);
        }
        //Waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_DeployAsPrototype",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_DeployAsPrototype");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Twenty Seconds");
        }
        }
        caller.pause(param_pauseFourSeconds);
        }
        //Waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_Close",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_Close");
        //Waiting for content load
        caller.waitForElement("APIPublisherHome.lnk_Browse",param_pauseFourSeconds);
        caller.click("APIPublisherHome.lnk_Browse");
        caller.writeToReport("End of BC DeployAsPrototype");	
    }
    /**
     *  Business component bc_AddTiersToAPI.
     * 
     */
    public final static void bc_AddTiersToAPI(final SeleniumTestBase caller, final String param_APIName, final String param_ProductionEndPont, final String param_SandBoxEndPont, final String param_pauseFourSeconds, final String param_pauseSixSeconds) throws Exception {
        //Add tiers to API
        caller.writeToReport("Start of BC AddTiersToAPI");
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndPont);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_NextManage",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.ele_ddTierAvilability",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        caller.click("APIPublisherBrowse.chk_Unlimited");
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        caller.click("APIPublisherBrowse.chk_Bronze");
        caller.writeToReport("End of BC AddTiersToAPI");	
    }
    /**
     *  Business component bc_LogOut_APIPublisher.
     * 
     */
    public final static void bc_LogOut_APIPublisher(final SeleniumTestBase caller, final String param_userName) throws Exception {
        //API publisher logout
        caller.writeToReport("Start of BC LogOut_APIPublisher");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_userName);
        caller.click("APIPublisherLogOut.btn_LogOut");
        caller.writeToReport("End of BC LogOut_APIPublisher");	
    }
    /**
     *  Business component bc_PrototypeAPI.
     * 
     */
    public final static void bc_PrototypeAPI(final SeleniumTestBase caller, final String param_pauseSixSeconds) throws Exception {
        //Deploying API as prototype
        caller.writeToReport("Start of BC PrototypeAPI");
        caller.click("APIPublisherBrowse.ele_lblPrototype");
        caller.click("APIPublisherBrowse.btn_SavePrototype");
        caller.click("APIPublisherBrowse.btn_DeployAsPrototype");
        caller.click("APIPublisherBrowse.btn_Close");
        caller.writeToReport("End of BC PrototypeAPI");	
    }
    /**
     *  Business component bc_ManagedAPI.
     * 
     */
    public final static void bc_ManagedAPI(final SeleniumTestBase caller, final String param_APIName, final String param_ProductionEndPont, final String param_SandBoxEndpoint, final String param_pauseEightSeconds) throws Exception {
        //Managed API
        caller.writeToReport("Start of BC ManagedAPI");
        caller.waitForElement("APIPublisherHome.lnk_Browse",param_pauseEightSeconds);
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //Search API in Publisher
        caller.click("APIPublisherHome.lnk_Browse");
        //wait for content load
        caller.waitForElement("APIPublisherHome.tf_APISearch",param_pauseEightSeconds);
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        caller.waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,param_pauseEightSeconds);
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_NextManage",param_pauseEightSeconds);
        caller.click("APIPublisherBrowse.btn_NextManage");
        caller.writeToReport("End of BC ManagedAPI");	
    }
    /**
     *  Business component bc_NavigateToStore.
     * 
     */
    public final static void bc_NavigateToStore(final SeleniumTestBase caller, final String param_serverName, final String param_storeURL, final String param_pauseFourSeconds) throws Exception {
        //Navigate to store
        caller.writeToReport("Start of BC NavigateToStore");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,param_pauseFourSeconds);
        //Waiting for content load
        caller.waitForElement("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName,param_pauseFourSeconds);
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);
        caller.writeToReport("End of BC NavigateToStore");	
    }
    /**
     *  Business component bc_SwitchUser.
     * 
     */
    /**
     *  Business component bc_SwitchUser.
     * 
     */
    public final static void bc_SwitchUser(final SeleniumTestBase caller) throws Exception {
        //Switch user
        caller.writeToReport("Start of BC SwitchUser");
        caller.switchUser("default");
        caller.fireEvent("KEY%key=alt+F4","2000");
        //Waiting for content load
        caller.pause("3000");
        caller.writeToReport("End of BC SwitchUser");	
    }
    /**
     *  Business component bc_EditAPI.
     * 
     */
    public final static void bc_EditAPI(final SeleniumTestBase caller, final String param_APIName) throws Exception {
        //Edit an API
        caller.writeToReport("Start of BC EditAPI");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblGeneralDetails",false,"");
        caller.writeToReport("End of BC EditAPI");	
    }
    /**
     *  Business component bc_NavigateToPrototypedAPI.
     * 
     */
    /**
     *  Business component bc_NavigateToPrototypedAPI.
     * 
     */
    public final static void bc_NavigateToPrototypedAPI(final SeleniumTestBase caller) throws Exception {
        //Navigate to prototyped API
        caller.writeToReport("Start of BC NavigateToPrototypedAPI");
        caller.click("APIStoreHome.lnk_PrototypedAPIs");
        caller.writeToReport("End of BC NavigateToPrototypedAPI");	
    }
    /**
     *  Business component bc_APIStoreLogin.
     * 
     */
    public final static void bc_APIStoreLogin(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_pauseFourSeconds) throws Exception {
        //Login to API store
        caller.writeToReport("Start of BC APIStoreLogin");
        //Login To API Store
        caller.click("APIStoreHome.lnk_login");
        caller.waitForElement("APIStoreHome.tf_username",param_pauseFourSeconds);
        caller.type("APIStoreHome.tf_username",param_username);
        caller.waitForElement("APIStoreHome.tf_password",param_pauseFourSeconds);
        caller.type("APIStoreHome.tf_password",param_password);
        caller.waitForElement("APIStoreHome.btn_login",param_pauseFourSeconds);
        caller.click("APIStoreHome.btn_login");
        caller.writeToReport("End of BC APIStoreLogin");	
    }
    /**
     *  Business component bc_APIcarbonLogin.
     * 
     */
    public final static void bc_APIcarbonLogin(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_carbonURL, final String param_pauseFourSeconds) throws Exception {
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
     *  Business component bc_CreateCarbonUser.
     * 
     */
    public final static void bc_CreateCarbonUser(final SeleniumTestBase caller, final String param_newUserName, final String param_newPassword, final String param_retypePassword, final String param_role, final String param_pauseTwoSeconds) throws Exception {
        //create a new carbon user
        caller.writeToReport("Start of BC CreateCarbonUser");
        caller.click("APICarbonHome.btn_Configure");
        caller.waitForElement("APICarbonHome.lnk_UserandRoles",param_pauseTwoSeconds);
        caller.click("APICarbonHome.lnk_UserandRoles");
        caller.waitForElement("APICarbonHome.lnk_User",param_pauseTwoSeconds);
        caller.click("APICarbonHome.lnk_User");
        caller.waitForElement("APICarbonHome.lnk_AddNewUser",param_pauseTwoSeconds);
        caller.click("APICarbonHome.lnk_AddNewUser");
        caller.waitForElement("CarbonAddUser.tf_UserName",param_pauseTwoSeconds);
        caller.type("CarbonAddUser.tf_UserName",param_newUserName);
        caller.type("CarbonAddUser.tf_password",param_newPassword);
        caller.type("CarbonAddUser.tf_retypePassword",param_retypePassword);
        caller.click("CarbonAddUser.btn_next");
        caller.waitForElement("CarbonAddUser.btn_finish",param_pauseTwoSeconds);
        caller.click("CarbonAddUser.btn_finish");
        caller.waitForElement("CarbonAddUser.btn_Ok",param_pauseTwoSeconds);
        caller.click("CarbonAddUser.btn_Ok");
        caller.writeToReport("End of BC CreateCarbonUser");	
    }
    /**
     *  Business component bc_APIManageStage.
     * 
     */
    public final static void bc_APIManageStage(final SeleniumTestBase caller, final String param_pauseTwoSeconds) throws Exception {
        //manage API stage completion
        caller.writeToReport("Start of BC APIManageStage");
        caller.waitForElement("APIPublisherBrowse.ele_ddTierAvilability",param_pauseTwoSeconds);
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        caller.waitForElement("APIPublisherBrowse.btn_SaveManageAPI",param_pauseTwoSeconds);
        caller.click("APIPublisherBrowse.btn_SaveManageAPI");
        caller.waitForElement("APIPublisherBrowse.btn_SaveAndPublish",param_pauseTwoSeconds);
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        caller.waitForElement("APIPublisherBrowse.btn_Close",param_pauseTwoSeconds);
        caller.click("APIPublisherBrowse.btn_Close");
        caller.writeToReport("End of BC APIManageStage");	
    }
    /**
     *  Business component bc_UserRoleAndAssign.
     * 
     */
    public final static void bc_UserRoleAndAssign(final SeleniumTestBase caller, final String param_RoleName, final String param_UserName, final String param_pauseTwoSeconds) throws Exception {
        //add new roles and assign it to users
        caller.writeToReport("Start of BC UserRoleAndAssign");
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleName);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create");
        caller.click("CarbonUserRole.chk_Publish");
        caller.click("CarbonUserRole.chk_Subscribe");
        }
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserName,param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.writeToReport("End of BC UserRoleAndAssign");	
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
     *  Business component bc_Select_LifeCycleState.
     * 
     */
    public final static void bc_Select_LifeCycleState(final SeleniumTestBase caller, final String param_Stage, final String param_APIName, final String param_pauseTwoSeconds) throws Exception {
        //select lifecycle state
        caller.writeToReport("Start of BC Select_LifeCycleState");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        caller.checkElementPresent("browseLifecycle.ele_ddSelectState",false,"");
        caller.waitForElement("browseLifecycle.ele_ddSelectState",param_pauseTwoSeconds);
        caller.select("browseLifecycle.ele_ddSelectState",param_Stage);
        caller.click("browseLifecycle.btn_Update");
        caller.checkElementPresent("browseLifecycle.ele_lblUpdateSuccessMessage",false,"");
        //Wait for content load
        caller.writeToReport("End of BC Select_LifeCycleState");	
    }
    /**
     *  Business component bc_CreateNewVersion_VerifyDetails.
     * 
     */
    public final static void bc_CreateNewVersion_VerifyDetails(final SeleniumTestBase caller, final String param_newVersion, final String param_creater, final String param_APIName, final String param_status, final String param_users, final String param_pauseTwoSeconds) throws Exception {
        //create a new version from overview and verify it
        caller.writeToReport("Start of BC CreateNewVersion_VerifyDetails");
        caller.click("APIPublisherBrowse.lnk_Overview");
        //Wait for content load
        caller.waitForElement("Browse_Overview.btn_CreateNewVersion",param_pauseTwoSeconds);
        caller.click("Browse_Overview.btn_CreateNewVersion");
        //Wait for content load
        caller.waitForElement("Browse_Overview.tf_ToVersion",param_pauseTwoSeconds);
        //Verify Expand the text field
        caller.checkElementPresent("Browse_Overview.tf_ToVersion",false,"");
        caller.type("Browse_Overview.tf_ToVersion",param_newVersion);
        caller.click("Browse_Overview.btn_Done");
        //Wait for content load
        caller.waitForElement("APIPublisherBrowse.ele_lblVersionAndUser","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion + "_PARAM," + "param_creater_PARAM:" + param_creater,param_pauseTwoSeconds);
        //Verify API name version and creator
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVersionAndUser","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion + "_PARAM," + "param_creater_PARAM:" + param_creater,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblUsers","param_version_PARAM:" + param_newVersion + "_PARAM," + "param_users_PARAM:" + param_users,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIStatus","param_status_PARAM:" + param_status,false,"");
        caller.writeToReport("End of BC CreateNewVersion_VerifyDetails");	
    }
    /**
     *  Business component bc_SelectAllTiers.
     * 
     */
    public final static void bc_SelectAllTiers(final SeleniumTestBase caller, final String param_pauseOneSecond) throws Exception {
        //selection of tiers
        caller.writeToReport("Start of BC SelectAllTiers");
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        caller.waitForElement("APIPublisherBrowse.chk_Unlimited",param_pauseOneSecond);
        caller.click("APIPublisherBrowse.chk_Unlimited");
        caller.waitForElement("APIPublisherBrowse.chk_Gold",param_pauseOneSecond);
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.waitForElement("APIPublisherBrowse.chk_Silver",param_pauseOneSecond);
        caller.click("APIPublisherBrowse.chk_Silver");
        caller.waitForElement("APIPublisherBrowse.chk_Bronze",param_pauseOneSecond);
        caller.click("APIPublisherBrowse.chk_Bronze");
        caller.waitForElement("APIPublisherBrowse.chk_CustomTier",param_pauseOneSecond);
        caller.click("APIPublisherBrowse.chk_CustomTier");
        caller.writeToReport("End of BC SelectAllTiers");	
    }
    /**
     *  Business component bc_LogOut_APIStore.
     * 
     */
    public final static void bc_LogOut_APIStore(final SeleniumTestBase caller, final String param_userName, final String param_pauseTwoSeconds) throws Exception {
        //log out of API store
        caller.writeToReport("Start of BC LogOut_APIStore");
        caller.waitForElement("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_userName,param_pauseTwoSeconds);
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_userName);
        caller.waitForElement("APIStoreHome.btn_Logout",param_pauseTwoSeconds);
        caller.click("APIStoreHome.btn_Logout");
        caller.writeToReport("End of BC LogOut_APIStore");	
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
     *  Business component bc_ImplementStage.
     * 
     */
    public final static void bc_ImplementStage(final SeleniumTestBase caller, final String param_productionEndpoint, final String param_sandboxEndpoint, final String param_pauseTwoSeconds) throws Exception {
        //Implement stage completion
        caller.writeToReport("Start of BC ImplementStage");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblManagedAPI",false,"");
        caller.waitForElementEnable("APIPublisherBrowse.ele_lblManagedAPI");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.waitForElement("APIPublisherBrowse.ele_lblEndpoints",param_pauseTwoSeconds);
        //Verify the navigated page
        caller.checkElementPresent("APIPublisherBrowse.ele_lblEndpoints",false,"");
        //Enter production and sandbox endpoints
        caller.click("APIPublisherBrowse.tf_productionEndpoint");
        caller.type("APIPublisherBrowse.tf_productionEndpoint",param_productionEndpoint);
        caller.waitForElement("APIPublisherBrowse.tf_sandboxEndpoint",param_pauseTwoSeconds);
        caller.click("APIPublisherBrowse.tf_sandboxEndpoint");
        caller.type("APIPublisherBrowse.tf_sandboxEndpoint",param_sandboxEndpoint);
        caller.waitForElement("APIPublisherBrowse.btn_SaveManagedAPI",param_pauseTwoSeconds);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        for(;caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner");){
        //waiting for content load
        caller.pause(param_pauseTwoSeconds);
        }
        caller.click("APIPublisherBrowse.btn_NextManage");
        for(;caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner");){
        //waiting for content load
        caller.pause(param_pauseTwoSeconds);
        }
        caller.writeToReport("End of BC ImplementStage");	
    }
    /**
     *  Business component bc_DeleteSubcription.
     * 
     */
    public final static void bc_DeleteSubcription(final SeleniumTestBase caller, final String param_APIName, final String param_Version, final String param_pauseFourSeconds) throws Exception {
        //delete subscription
        caller.writeToReport("Start of BC DeleteSubcription");
        if(!caller.checkElementPresent("APIStoreMySubcription.img_API","APIName_PARAM:" + param_APIName + "_PARAM," + "Version_PARAM:" + param_Version)){
        caller.click("APIStoreMySubcription.ele_lblSubcribedAPIs");
        }
        caller.checkElementPresent("APIStoreMySubcription.img_API","APIName_PARAM:" + param_APIName + "_PARAM," + "Version_PARAM:" + param_Version,false,"");
        caller.click("APIStoreMySubcription.btn_deleteAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "Param_APIVersion_PARAM:" + param_Version);
        caller.waitForElement("APIStoreMySubcription.btn_Yes",param_pauseFourSeconds);
        caller.click("APIStoreMySubcription.btn_Yes");
        caller.waitForElement("CarbonAddUser.btn_finish",param_pauseFourSeconds);
        caller.writeToReport("End of BC DeleteSubcription");	
    }
    /**
     *  Business component bc_CreateTennon.
     * 
     */
    public final static void bc_CreateTennon(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_Domain, final String param_FirstName, final String param_LastName, final String param_AdminUserName, final String param_AdminPassword, final String param_Email, final String param_carbonURL, final String param_pauseTwoSeconds) throws Exception {
        //create a new tennant
        caller.writeToReport("Start of BC CreateTennon");
        lib_Common.bc_APIcarbonLogin(caller, param_username,param_password,param_carbonURL,"");
        //Waiting for content load
        caller.waitForElement("APICarbonHome.btn_Configure",param_pauseTwoSeconds);
        caller.click("APICarbonHome.btn_Configure");
        caller.click("APICarbonHome.link_AddNewTenant");
        caller.type("APICarbonHome.tf_Domain",param_Domain);
        caller.type("APICarbonHome.tf_FirstName",param_FirstName);
        caller.type("APICarbonHome.tf_LastName",param_LastName);
        caller.type("APICarbonHome.tf_AdminUserName",param_AdminUserName);
        caller.type("APICarbonHome.tf_AdminPassword",param_AdminPassword);
        caller.type("APICarbonHome.tfAdminPasswordRepeat",param_AdminPassword);
        caller.type("APICarbonHome.tf_Email",param_Email);
        //Waiting for content load
        caller.waitForElement("APICarbonHome.btn_Save",param_pauseTwoSeconds);
        caller.click("APICarbonHome.btn_Save");
        //Waiting for content load
        caller.pause("2000");
        caller.click("APICarbonHome.btn_OkPopUp");
        //Waiting for content load
        caller.waitForElement("APICarbonHome.lnk_SignOut",param_pauseTwoSeconds);
        caller.click("APICarbonHome.lnk_SignOut");
        String tenantAdminName = param_AdminUserName;
        String tenantDomain = param_Domain;
        caller.store("keyTenantAdmin","String",tenantAdminName);
        caller.store("keyDomain","String",tenantDomain);
        String newTenantUsername = tenantAdminName+"@"+tenantDomain;
        caller.store("keynewTenantUsername","String",newTenantUsername);
        caller.writeToReport("End of BC CreateTennon");	
    }
    /**
     *  Business component bc_CreateUserAndAssignRoles.
     * 
     */
    public final static void bc_CreateUserAndAssignRoles(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_newUserName, final String param_retypePassword, final String param_newPassword, final String param_RoleName, final String param_role, final String param_carbonURL) throws Exception {
        //create users and assign roles
        caller.writeToReport("Start of BC CreateUserAndAssignRoles");
        lib_Common.bc_APIcarbonLogin(caller, param_username,param_password,param_carbonURL,"");
        lib_Common.bc_CreateCarbonUser(caller, param_newUserName,param_newPassword,param_retypePassword,param_role,"");
        lib_Common.bc_UserRoleAndAssign(caller, param_RoleName,param_newUserName,"");
        caller.writeToReport("End of BC CreateUserAndAssignRoles");	
    }
    /**
     *  Business component bc_CreateTenant.
     * 
     */
    public final static void bc_CreateTenant(final SeleniumTestBase caller, final String param_Username, final String param_Password, final String param_FirstName, final String param_LastName, final String param_AdminUserName, final String param_AdminPassword, final String param_Email, final String param_CarbonURL, final String param_DomainName, final String param_pauseTwoSeconds) throws Exception {
        //Create a tenant
        caller.writeToReport("Start of BC CreateTenant");
        //Logged in to carbon
        lib_Common.bc_APIcarbonLogin(caller, param_Username,param_Password,param_CarbonURL,param_pauseTwoSeconds);
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
     *  Business component bc_createSuperUser.
     * 
     */
    public final static void bc_createSuperUser(final SeleniumTestBase caller, final String param_RoleName, final String param_usernameAdmin, final String param_passwordAdmin, final String param_carbonURL, final String param_newUserName, final String param_newPassword, final String param_retypePassword, final String param_role, final String param_newUserName1, final String param_newPassword1, final String param_retypePassword1, final String param_RoleName1, final String param_pauseTwoSeconds) throws Exception {
        //Create super users
        caller.writeToReport("Start of BC createSuperUser");
        lib_Common.bc_APIcarbonLogin(caller, param_usernameAdmin,param_passwordAdmin,param_carbonURL,param_pauseTwoSeconds);
        caller.waitForElement("APICarbonHome.btn_Configure",param_pauseTwoSeconds);
        lib_Common.bc_CreateCarbonUser(caller, param_newUserName,param_newPassword,param_retypePassword,param_role,param_pauseTwoSeconds);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        caller.waitForElement("CarbonUserRole.lnk_AddNewRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleName);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create");
        caller.click("CarbonUserRole.chk_Publish");
        }
        caller.click("CarbonUserRole.chk_governance");
        caller.waitForElement("CarbonUserRole.chk_govern",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_govern");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_newUserName,param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_newUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        //API Store User Creation
        caller.waitForElement("APICarbonHome.btn_Configure",param_pauseTwoSeconds);
        lib_Common.bc_CreateCarbonUser(caller, param_newUserName1,param_newPassword1,param_retypePassword1,param_role,param_pauseTwoSeconds);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        caller.waitForElement("CarbonUserRole.lnk_AddNewRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleName1);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe");
        }
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_newUserName1,param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_newUserName1);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.waitForElement("APICarbonHome.lnk_SignOut",param_pauseTwoSeconds);
        caller.click("APICarbonHome.lnk_SignOut");
        caller.writeToReport("End of BC createSuperUser");	
    }
    /**
     *  Business component bc_CreateSuperUsers.
     * 
     */
    public final static void bc_CreateSuperUsers(final SeleniumTestBase caller, final String param_publisherRoleName, final String param_usernameAdmin, final String param_passwordAdmin, final String param_carbonURL, final String param_PublisherUserName, final String param_PublishernewPassword, final String param_retypePublisherPassword, final String param_role, final String param_StoreNewUserName, final String param_StoreNewPassword, final String param_retypeStorePassword, final String param_StoreRoleName, final String param_pauseTwoSeconds) throws Exception {
        //Create super users
        caller.writeToReport("Start of BC CreateSuperUser");
        lib_Common.bc_APIcarbonLogin(caller, param_usernameAdmin,param_passwordAdmin,param_carbonURL,"");
        //API Publisher User Creation
        lib_Common.bc_CreateCarbonUser(caller, param_PublisherUserName,param_PublishernewPassword,param_retypePublisherPassword,param_role,"");
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_publisherRoleName);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create");
        caller.click("CarbonUserRole.chk_Publish");
        }
        caller.click("CarbonUserRole.chk_governance");
        caller.waitForElement("CarbonUserRole.chk_govern",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_govern");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_PublisherUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        lib_Common.bc_CreateCarbonUser(caller, param_StoreNewUserName,param_StoreNewPassword,param_StoreNewPassword,param_role,"");
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_StoreRoleName);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe");
        }
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_StoreNewUserName,param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_StoreNewUserName);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.waitForElement("APICarbonHome.lnk_SignOut",param_pauseTwoSeconds);
        caller.click("APICarbonHome.lnk_SignOut");
        caller.writeToReport("End of BC CreateSuperUser");	
    }
    /**
     *  Business component bc_createTenantUser.
     * 
     */
    public final static void bc_createTenantUser(final SeleniumTestBase caller, final String param_usernameTenant, final String param_passwordTenant, final String param_carbonURL, final String param_newPassword, final String param_retypePassword, final String param_role, final String param_RoleName, final String param_UserName1, final String param_newPassword1, final String param_retypePassword1, final String param_role1, final String param_RoleName1, final String param_UserName2, final String param_pauseTwoSeconds) throws Exception {
        //Create tenant users
        caller.writeToReport("Start of BC createTenantUser");
        lib_Common.bc_APIcarbonLogin(caller, param_usernameTenant,param_passwordTenant,param_carbonURL,"");
        //API Publisher User Creation
        lib_Common.bc_CreateCarbonUser(caller, param_UserName1,param_newPassword,param_retypePassword,param_role,"");
        //Waiting for content load
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
        }
        caller.click("CarbonUserRole.chk_governance1");
        caller.waitForElement("CarbonUserRole.chk_govern1",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_govern1");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserName1,param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserName1);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        //API Store User Creation
        lib_Common.bc_CreateCarbonUser(caller, param_UserName2,param_newPassword1,param_retypePassword1,param_role1,"");
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleName1);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login1",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe1");
        }
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserName2,param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserName2);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.writeToReport("End of BC createTenantUser");	
    }
    /**
     *  Business component bc_CreateTenantUsers.
     * 
     */
    public final static void bc_CreateTenantUsers(final SeleniumTestBase caller, final String param_usernameTenant, final String param_passwordTenant, final String param_carbonURL, final String param_newPassword, final String param_retypePassword, final String param_role, final String param_RoleNamePublisher, final String param_UserNameCreateAndPublisher, final String param_newPasswordStoreUser, final String param_retypePasswordStoreUser, final String param_role1, final String param_RoleNameSubscriber, final String param_UserNameSubscriber, final String param_pauseTwoSeconds) throws Exception {
        //Create tenant users
        caller.writeToReport("Start of BC CreateTenantUsers");
        lib_Common.bc_APIcarbonLogin(caller, param_usernameTenant,param_passwordTenant,param_carbonURL,"");
        //API Publisher User Creation
        lib_Common.bc_CreateCarbonUser(caller, param_UserNameCreateAndPublisher,param_newPassword,param_retypePassword,param_role,"");
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleNamePublisher);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login1",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create1");
        caller.click("CarbonUserRole.chk_Publish1");
        }
        caller.click("CarbonUserRole.chk_governance1");
        caller.waitForElement("CarbonUserRole.chk_govern1",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_govern1");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserNameCreateAndPublisher,param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserNameCreateAndPublisher);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        //API Store User Creation
        lib_Common.bc_CreateCarbonUser(caller, param_UserNameSubscriber,param_newPasswordStoreUser,param_retypePasswordStoreUser,param_role1,"");
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleNameSubscriber);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login1",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe1");
        }
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserNameSubscriber,param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserNameSubscriber);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.writeToReport("End of BC CreateTenantUsers");	
    }
    /**
     *  Business component bc_DeleteAPI.
     * 
     */
    public final static void bc_DeleteAPI(final SeleniumTestBase caller, final String param_APIName, final String param_publisherURL, final String param_pauseTwoSeconds, final String param_pauseFourSeconds, final String param_pauseSixSeconds) throws Exception {
        //Delete a created API
        caller.writeToReport("Start of BC DeleteAPI");
        //Navigate to API Publisher to delete the API
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,param_pauseFourSeconds);
        caller.click("APIPublisherHome.lnk_Browse");
        caller.waitForElement("APIPublisherHome.tf_APISearch",param_pauseTwoSeconds);
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,param_pauseTwoSeconds);
        //Verify API is searched successfully
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        //Delete Multiple similar API names
        int TotalCount = caller.getObjectCount("APIPublisherBrowse.lnk_APINameMultiple","param_APIName_PARAM:" + param_APIName);      
        for(;TotalCount>0;TotalCount--){
        caller.click("APIPublisherBrowse.btn_deleteAPI","APIName_PARAM:" + param_APIName);
        caller.waitForElement("APIPublisherBrowse.btn_Yes",param_pauseTwoSeconds);
        caller.click("APIPublisherBrowse.btn_Yes");
        for(;caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIDeletePleaseWait");){
        caller.pause(param_pauseTwoSeconds);
        }
        }
        //Verify the API names are deleted
        caller.checkObjectProperty("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","false",false,"");
        caller.writeToReport("End of BC DeleteAPI");	
    }
    /**
     *  Business component bc_CreateAPIAndPublish.
     * 
     */
    public final static void bc_CreateAPIAndPublish(final SeleniumTestBase caller, final String param_publisherUserName, final String param_publisherPassword, final String param_APIName, final String param_APIcontest, final String param_APIVersion, final String param_APIImagePath, final String param_Discription, final String param_ProductionEndPont, final String param_SandBoxEndpoint, final String param_publisherURL, final String param_URLPattern, final String param_pauseTwoSeconds, final String param_pauseFourSeconds) throws Exception {
        //Create a new API and pubilish it
        caller.writeToReport("Start of BC CreateAPIAndPublish");
        lib_Common.bc_Login_APIPublisher(caller, param_publisherUserName,param_publisherPassword,param_publisherURL,param_pauseFourSeconds);
        caller.waitForElement("APIPublisherHome.lnk_Add",param_pauseTwoSeconds);
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.waitForElement("APIPublisherAdd.rdo_DesignNewAPI",param_pauseFourSeconds);
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.waitForElement("APIPublisherAdd.btn_StartCreating",param_pauseFourSeconds);
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_APIName",param_pauseTwoSeconds);
        caller.type("APIPublisherAdd.tf_APIName",param_APIName);
        caller.type("APIPublisherAdd.tf_APIContext",param_APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //Type valid image path
        caller.type("APIPublisherAdd.btn_BrowseImage",param_APIImagePath);
        caller.type("APIPublisherAdd.tf_Discription",param_Discription);
        //Type API SCope
        String varTagName = "tag"+caller.generateData("String",3);
        caller.type("APIPublisherAdd.tf_Tags",varTagName);
        caller.type("APIPublisherAdd.tf_Tags",varTagName+org.openqa.selenium.Keys.ENTER);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_URLPattern",param_pauseTwoSeconds);
        //Type URL pattern
        caller.type("APIPublisherAdd.tf_URLPattern",param_URLPattern);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.chk_Get",param_pauseTwoSeconds);
        caller.click("APIPublisherAdd.chk_Get");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.chk_Get",param_pauseTwoSeconds);
        caller.click("APIPublisherAdd.chk_Post");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Add",param_pauseTwoSeconds);
        caller.click("APIPublisherAdd.btn_Add");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseTwoSeconds);
        //click save and verify warning
        caller.doubleClick("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseFourSeconds);
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        lib_Common.bc_PrototypeAPI(caller, param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_Save1");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_NextManage",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.ele_ddTierAvilability",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.chk_Gold",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        //Wait for content load
        caller.waitForElement("APIPublisherBrowse.btn_SaveAndPublish",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        caller.waitForElement("APIPublisherBrowse.btn_Close",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_Close");
        lib_Common.bc_LogOut_APIPublisher(caller, param_publisherUserName);
        caller.writeToReport("End of BC CreateAPIAndPublish");	
    }
    /**
     *  Business component bc_CreateStoreUser.
     * 
     */
    public final static void bc_CreateStoreUser(final SeleniumTestBase caller, final String param_usernameTenant, final String param_passwordTenant, final String param_carbonURL, final String param_UserNameSubscriber, final String param_newPasswordStoreUser, final String param_retypePasswordStoreUser, final String param_role1, final String param_RoleNameSubscriber, final String param_pauseTwoSeconds) throws Exception {
        //create a new store user
        caller.writeToReport("Start of BC CreateStoreUser");
        //loging to carbon and crate store user
        lib_Common.bc_APIcarbonLogin(caller, param_usernameTenant,param_passwordTenant,param_carbonURL,"");
        //API Store User Creation
        lib_Common.bc_CreateCarbonUser(caller, param_UserNameSubscriber,param_newPasswordStoreUser,param_retypePasswordStoreUser,param_role1,"");
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleNameSubscriber);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_Login1",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe1");
        }
        caller.waitForElement("CarbonUserRole.btn_NextPermissions",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserNameSubscriber,param_pauseTwoSeconds);
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserNameSubscriber);
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_FinishAddRole",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.btn_OkPopUp",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.writeToReport("End of BC CreateStoreUser");	
    }
    /**
     *  Business component bc_CreateAPI_DesignNew.
     * 
     */
    public final static void bc_CreateAPI_DesignNew(final SeleniumTestBase caller, final String param_APIName, final String param_APIContext, final String param_APIVersion, final String param_APIImagePath, final String param_TagName, final String param_pauseTwoSeconds, final String param_pauseSixSeconds, final String param_pauseFourSeconds) throws Exception {
        //CreateAPI upto design Stage
        caller.writeToReport("Start of BC CreateAPI_DesignNew");
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
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
        //Type valid image path
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator +param_APIImagePath);
        String entirePath = file.getAbsolutePath();
        caller.type("APIPublisherAdd.btn_BrowseImage",entirePath);
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
        caller.waitForElement("APIPublisherAdd.btn_Yes",param_pauseFourSeconds);
        caller.click("APIPublisherAdd.btn_Yes");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.lnk_NextImplement",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.writeToReport("End of BC CreateAPI_DesignNew");	
    }
    /**
     *  Business component bc_createAndPublishAPI.
     * 
     */
    public final static void bc_createAndPublishAPI(final SeleniumTestBase caller, final String param_APIName, final String param_APIContext, final String param_APIVersion, final String param_ImagePath, final String param_TagName, final String param_ProductionEndPont, final String param_SandBoxEndpoint, final String param_pauseTwoSeconds, final String param_pauseSixSeconds, final String param_pauseFourSeconds) throws Exception {
        //Creating and publishing API
        caller.writeToReport("Start of BC createAndPublishAPI");
        caller.click("APIPublisherHome.lnk_Add");
        caller.waitForElement("APIPublisherAdd.rdo_DesignNewAPI",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
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
        //Type valid image path
         java.io.File file = new java.io.File("src" +java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "Images"+ java.io.File.separator + param_ImagePath);
        String entirePath = file.getAbsolutePath();
        caller.type("APIPublisherAdd.btn_BrowseImage",entirePath);
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
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_Save1");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_NextManage",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_NextManage");
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
     *  Business component bc_Create_Carbon_User.
     * 
     */
    public final static void bc_Create_Carbon_User(final SeleniumTestBase caller, final String param_TenantUserName, final String param_TenantUserPassword, final String param_retypeTenantUserPassword, final String param_pauseTwoSeconds) throws Exception {
        //Create Carbon user from Tenant User
        caller.writeToReport("Start of BC Create_Carbon_User");
        caller.checkElementPresent("APICarbonHome.btn_Configure",false,"");
        //Click on Configure
        caller.click("APICarbonHome.btn_Configure");
        caller.waitForElement("APICarbonHome.lnk_UserandRoles",param_pauseTwoSeconds);
        //Click User and Roles
        caller.click("APICarbonHome.lnk_UserandRoles");
        caller.waitForElement("APICarbonHome.lnk_User",param_pauseTwoSeconds);
        //Click User
        caller.click("APICarbonHome.lnk_User");
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
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseThreeSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
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
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseFourSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
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
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseTwoSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
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
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseFourSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
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
        caller.waitForElement("APICarbonHome.lnk_UserandRoles",param_pauseFourSeconds);
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseFourSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
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
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseFourSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
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
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseFourSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
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
     *  Business component bc_UnSubscribeDeleteAPI.
     * 
     */
    public final static void bc_UnSubscribeDeleteAPI(final SeleniumTestBase caller, final String param_StoreURL, final String param_APIName, final String param_APIVersion, final String param_PublisherURL, final String param_APPName, final String param_TenantOrAdmin, final String param_pauseTwoSeconds, final String param_pauseFourSeconds) throws Exception {
        //unscribe from an API and delete that  API
        caller.writeToReport("Start of BC UnSubscribeDeleteAPI");
        //Go to API Store to relese the bind API from the APP.
        //publish API without  subscribers  and  check whether user can delete
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,"3000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        caller.waitForElement("APIStoreHome.lnk_MySubcription",param_pauseFourSeconds);
        caller.click("APIStoreHome.lnk_MySubcription");
        caller.waitForElement("APIStoreMySubcription.ele_ddApplicationWithSubscription",param_pauseFourSeconds);
        caller.select("APIStoreMySubcription.ele_ddApplicationWithSubscription",param_APPName);
        caller.checkElementPresent("APIStoreMySubcription.btn_deleteAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "Param_APIVersion_PARAM:" + param_APIVersion,false,"");
        caller.waitForElement("APIStoreMySubcription.btn_deleteAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "Param_APIVersion_PARAM:" + param_APIVersion,param_pauseFourSeconds);
        caller.click("APIStoreMySubcription.btn_deleteAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "Param_APIVersion_PARAM:" + param_APIVersion);
        caller.waitForElement("APIStoreMySubcription.btn_Yes",param_pauseFourSeconds);
        caller.click("APIStoreMySubcription.btn_Yes");
        //Navigate to API Publisher to delete the API
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"4000");
        caller.waitForElement("APIPublisherHome.lnk_Browse",param_pauseTwoSeconds);
        caller.click("APIPublisherHome.lnk_Browse");
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.waitForElement("APIPublisherHome.tf_APISearch",param_pauseFourSeconds);
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,param_pauseTwoSeconds);
        //Verify API is searched successfully
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.waitForElement("APIPublisherBrowse.btn_deleteAPI","APIName_PARAM:" + param_APIName,param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_deleteAPI","APIName_PARAM:" + param_APIName);
        caller.waitForElement("APIPublisherBrowse.btn_Yes",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_Yes");
        caller.waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,param_pauseFourSeconds);
        caller.checkObjectProperty("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","false",false,"");
        caller.writeToReport("End of BC UnSubscribeDeleteAPI");	
    }
    /**
     *  Business component bc_PublisherLogin.
     * 
     */
    public final static void bc_PublisherLogin(final SeleniumTestBase caller, final String param_publisherURL, final String param_TenantOrAdmin, final String param_pauseThreeSeconds, final String param_pauseFourSeconds) throws Exception {
        //Log into AI Publisher
        caller.writeToReport("Start of BC PublisherLogin");
        caller.open("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,param_pauseFourSeconds);
        if(caller.checkElementPresent("APIPublisherLogin.btn_Login")){
        //Waiting for content to load
        caller.waitForElement("APIPublisherLogin.tf_UserName",param_pauseFourSeconds);
        //Below condition handles multiple user logins
        if(param_TenantOrAdmin.equals("TenantOnePublisherOne")){
        String varPublisherUserName = caller.retrieveString("keyTenantOnePublisherUserOne");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyTenantOnePublisherOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("Tenant")){
        String varPublisherUserName = caller.retrieveString("keyTenantOnePublisherUserOne");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyTenantOnePublisherOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("TenantOnePublisherTwo")){
        String varPublisherUserName = caller.retrieveString("keyTenantOnePublisherUserTwo");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyTenantOnePublisherTwoPassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("TenantTwoPublisherOne")){
        String varPublisherUserName = caller.retrieveString("keyTenantTwoPublisherUserOne");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyTenantTwoPublisherOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("TenantThreePublisherOne")){
        String varPublisherUserName = caller.retrieveString("keyTenantThreePublisherUserOne");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyTenantThreePublisherOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("AdminPublisherOne")){
        String varPublisherUserName = caller.retrieveString("keyAdminPublisherUserOne");
        //Type username of admin one
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyAdminPublisherUserOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("carbon.super")){
        String varPublisherUserName = caller.retrieveString("keyAdminPublisherUserOne");
        //Type username of admin one
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyAdminPublisherUserOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("AdminPublisherTwo")){
        String varPublisherUserName = caller.retrieveString("keyAdminPublisherUserTwo");
        //Type username of admin one
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyAdminPublisherUserTwoPassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        }
        //click login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.waitForElement("APIPublisherHome.lnk_Browse",param_pauseThreeSeconds);
        } else if(caller.checkElementPresent("APIPublisherLogOut.btn_SignOut")){
        caller.click("APIPublisherLogOut.btn_SignOut");
        //Waiting for content to load
        caller.waitForElement("APIPublisherLogOut.btn_LogOut",param_pauseThreeSeconds);
        caller.click("APIPublisherLogOut.btn_LogOut");
        //Waiting for content to load
        caller.waitForElement("APIPublisherLogin.tf_UserName",param_pauseThreeSeconds);
        //Below condition handles multiple user logins
        if(param_TenantOrAdmin.equals("TenantOnePublisherOne")){
        String varPublisherUserName = caller.retrieveString("keyTenantOnePublisherUserOne");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyTenantOnePublisherOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("Tenant")){
        String varPublisherUserName = caller.retrieveString("keyTenantOnePublisherUserOne");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyTenantOnePublisherOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("TenantOnePublisherTwo")){
        String varPublisherUserName = caller.retrieveString("keyTenantOnePublisherUserTwo");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyTenantOnePublisherTwoPassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("TenantTwoPublisherOne")){
        String varPublisherUserName = caller.retrieveString("keyTenantTwoPublisherUserOne");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyTenantTwoPublisherOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("TenantThreePublisherOne")){
        String varPublisherUserName = caller.retrieveString("keyTenantThreePublisherUserOne");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyTenantThreePublisherOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("AdminPublisherOne")){
        String varPublisherUserName = caller.retrieveString("keyAdminPublisherUserOne");
        //Type username of admin one
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyAdminPublisherUserOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("carbon.super")){
        String varPublisherUserName = caller.retrieveString("keyAdminPublisherUserOne");
        //Type username of admin one
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyAdminPublisherUserOnePassword");
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        } else if(param_TenantOrAdmin.equals("AdminPublisherTwo")){
        String varPublisherUserName = caller.retrieveString("keyAdminPublisherUserTwo");
        //Type username of admin one
        caller.type("APIPublisherLogin.tf_UserName",varPublisherUserName);
        String varPublisherPassword = caller.retrieveString("keyAdminPublisherUserTwoPassword");
        //Type password.
        caller.type("APIPublisherLogin.tf_PassWord",varPublisherPassword);
        }
        //click login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.waitForElement("APIPublisherHome.lnk_Browse",param_pauseThreeSeconds);
        }
        caller.writeToReport("End of BC PublisherLogin");	
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
        caller.waitForElement("APICarbonHome.lnk_UserandRoles",param_pauseSixSeconds);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseSixSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
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
        caller.waitForElement("APICarbonHome.lnk_UserandRoles",param_pauseSixSeconds);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseSixSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
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
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles",param_pauseSixSeconds);
        caller.click("CarbonUserRole.lnk_Roles");
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
     *  Business component bc_UnSubscribeDeleteAPIMultiUser.
     * 
     */
    public final static void bc_UnSubscribeDeleteAPIMultiUser(final SeleniumTestBase caller, final String param_StoreURL, final String param_APIName, final String param_APIVersion, final String param_PublisherURL, final String param_APPName, final String param_TenantOrAdmin, final String param_TenantOrAdminStoreUser, final String param_pauseTwoSeconds, final String param_pauseFourSeconds) throws Exception {
        //unscribe from an API with multiuser and delete that  API
        caller.writeToReport("Start of BC UnSubscribeDeleteAPIMultiUser");
        //Go to API Store to relese the bind API from the APP
        //publish API without  subscribers  and  check whether user can delete
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,"3000");
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantOrAdminStoreUser,param_pauseFourSeconds,param_pauseFourSeconds,param_pauseFourSeconds,param_pauseFourSeconds);
        caller.waitForElement("APIStoreHome.lnk_MySubcription",param_pauseFourSeconds);
        caller.click("APIStoreHome.lnk_MySubcription");
        caller.waitForElement("APIStoreMySubcription.ele_ddApplicationWithSubscription",param_pauseFourSeconds);
        caller.select("APIStoreMySubcription.ele_ddApplicationWithSubscription",param_APPName);
        caller.waitForElement("APIStoreMySubcription.btn_deleteAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "Param_APIVersion_PARAM:" + param_APIVersion,param_pauseFourSeconds);
        caller.checkElementPresent("APIStoreMySubcription.btn_deleteAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "Param_APIVersion_PARAM:" + param_APIVersion,false,"");
        caller.click("APIStoreMySubcription.btn_deleteAPI","param_APIName_PARAM:" + param_APIName + "_PARAM," + "Param_APIVersion_PARAM:" + param_APIVersion);
        caller.waitForElement("APIStoreMySubcription.btn_Yes",param_pauseFourSeconds);
        caller.click("APIStoreMySubcription.btn_Yes");
        //Navigate to API Publisher to delete the API
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,"4000");
        caller.click("APIPublisherHome.lnk_Browse");
        caller.waitForElement("APIPublisherHome.tf_APISearch",param_pauseFourSeconds);
        caller.checkElementPresent("APIPublisherHome.tf_APISearch",false,"");
        caller.type("APIPublisherHome.tf_APISearch",param_APIName);
        caller.click("APIPublisherHome.btn_Search");
        caller.waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,param_pauseFourSeconds);
        //Verify API is searched successfully
        caller.checkElementPresent("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,false,"");
        caller.waitForElement("APIPublisherBrowse.btn_deleteAPI","APIName_PARAM:" + param_APIName,param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_deleteAPI","APIName_PARAM:" + param_APIName);
        caller.waitForElement("APIPublisherBrowse.btn_Yes",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_Yes");
        caller.waitForElement("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,param_pauseFourSeconds);
        caller.checkObjectProperty("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName,"ELEMENTPRESENT","false",false,"");
        caller.writeToReport("End of BC UnSubscribeDeleteAPIMultiUser");	
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
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.waitForElement("CarbonUserRole.lnk_Roles","");
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
        caller.waitForElement("APICarbonHome.lnk_UserandRoles",param_pauseSixSeconds);
        caller.click("APICarbonHome.lnk_UserandRoles");
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
     *  Business component bc_CreateAPIStateCreated.
     * 
     */
    public final static void bc_CreateAPIStateCreated(final SeleniumTestBase caller, final String param_APIName, final String param_APIContext, final String param_APIVersion, final String param_tagName, final String param_APIStateCreated, final String param_ProductionEndPoint, final String param_SandBoxEndpoint, final String param_pauseThreeSeconds, final String param_pauseFourSeconds, final String param_pauseSixSeconds, final String param_pauseEightSeconds) throws Exception {
        caller.writeToReport("Start of BC CreateAPIStateCreated");
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_StartCreating",param_pauseSixSeconds);
        //start design stage
        caller.click("APIPublisherAdd.btn_StartCreating");
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
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.type("APIPublisherAdd.tf_Tags",param_tagName+org.openqa.selenium.Keys.ENTER);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_URLPattern",param_pauseSixSeconds);
        //click save and verify warning
        caller.type("APIPublisherAdd.tf_URLPattern",varAPIName+"/"+varAPIContext);
        caller.click("APIPublisherAdd.chk_Post");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Add",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_Add");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.lnk_NextImplement",param_pauseEightSeconds);
        //Go to implement stage
        caller.checkElementPresent("APIPublisherAdd.lnk_NextImplement",false,"");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.lnk_NextImplement",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.ele_lblManagedAPI",param_pauseEightSeconds);
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.waitForElement("APIPublisherBrowse.tf_ProductionEndPoint",param_pauseSixSeconds);
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPoint);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_NextManage",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.dd_tireAvailabilityConfig",param_pauseSixSeconds);
        //Start manage stage
        caller.click("APIPublisherAdd.dd_tireAvailabilityConfig");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.chk_tireSelectionUnlimited",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.chk_tireSelectionUnlimited");
        caller.click("APIPublisherAdd.btn_SaveManagePage");
        //waiting for content load
        caller.waitForElement("APIPublisherHome.lnk_Browse",param_pauseSixSeconds);
        //verify API is in design stage and the state is equal to 'CREATED'
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.waitForElement("APIPublisherHome.tf_APISearch",param_pauseSixSeconds);
        caller.type("APIPublisherHome.tf_APISearch",varAPIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.waitForElement("APIPublisherHome.ele_lblAPIState","param_state_PARAM:" + param_APIStateCreated,param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherHome.ele_lblAPIState","param_state_PARAM:" + param_APIStateCreated,false,"");
        caller.writeToReport("End of BC CreateAPIStateCreated");	
    }
    /**
     *  Business component bc_CreateAPIStatePublished.
     * 
     */
    public final static void bc_CreateAPIStatePublished(final SeleniumTestBase caller, final String param_APIName, final String param_APIContext, final String param_APIVersion, final String param_tagName, final String param_ProductionEndPoint, final String param_SandBoxEndpoint, final String param_APIStatePublished, final String param_pauseThreeSeconds, final String param_pauseFourSeconds, final String param_pauseSixSeconds, final String param_pauseEightSeconds) throws Exception {
        caller.writeToReport("Start of BC CreateAPIStatePublished");
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_StartCreating",param_pauseSixSeconds);
        //start design stage
        caller.click("APIPublisherAdd.btn_StartCreating");
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
        caller.type("APIPublisherAdd.tf_Tags",param_tagName);
        caller.type("APIPublisherAdd.tf_Tags",param_tagName+org.openqa.selenium.Keys.ENTER);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_URLPattern",param_pauseEightSeconds);
        //click save and verify warning
        caller.type("APIPublisherAdd.tf_URLPattern",varAPIName+"/"+varAPIContext);
        caller.click("APIPublisherAdd.chk_Post");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Add",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_Add");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.btn_Save",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.lnk_NextImplement",param_pauseEightSeconds);
        //Go to implement stage
        caller.checkElementPresent("APIPublisherAdd.lnk_NextImplement",false,"");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.lnk_NextImplement",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.ele_lblManagedAPI",param_pauseEightSeconds);
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.waitForElement("APIPublisherBrowse.tf_ProductionEndPoint",param_pauseSixSeconds);
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPoint);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndpoint);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_NextManage",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.dd_tireAvailabilityConfig",param_pauseSixSeconds);
        //Start manage stage
        caller.click("APIPublisherAdd.dd_tireAvailabilityConfig");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.chk_tireSelectionUnlimited",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.chk_tireSelectionUnlimited");
        caller.click("APIPublisherAdd.btn_SaveManagePage");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_SaveAndPublish",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        //waiting for content load
        caller.waitForElement("APIPublisherHome.lnk_Browse",param_pauseSixSeconds);
        //verify API is in design stage and the state is equal to 'Published'
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.waitForElement("APIPublisherHome.tf_APISearch",param_pauseSixSeconds);
        caller.type("APIPublisherHome.tf_APISearch",varAPIName);
        caller.click("APIPublisherHome.btn_Search");
        //waiting for content load
        caller.waitForElement("APIPublisherHome.ele_lblAPIState","param_state_PARAM:" + param_APIStatePublished,param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherHome.ele_lblAPIState","param_state_PARAM:" + param_APIStatePublished,false,"");
        caller.writeToReport("End of BC CreateAPIStatePublished");	
    }
    /**
     *  Business component bc_StoreLogin.
     * 
     */
    public final static void bc_StoreLogin(final SeleniumTestBase caller, final String param_TenanrOrAdmin, final String param_pauseThreeSeconds, final String param_pauseFourSeconds, final String param_pauseSixSeconds, final String param_pauseEightSeconds) throws Exception {
        //log into store
        caller.writeToReport("Start of BC StoreLogin");
        if(caller.checkElementPresent("APIStoreHome.lnk_login")){
        //Login To API Store
        caller.click("APIStoreHome.lnk_login");
        //Below condition handles multiple user logins
        if(param_TenanrOrAdmin.equals("TenantOneStoreOne")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("Tenant")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantOneStoreTwo")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserTwo");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserTwoPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantOneStoreThree")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserThree");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserThreePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantOneStoreFour")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserFour");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserFourPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantOneStoreFive")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserFive");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserFivePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantOneStoreSix")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserSix");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserSixPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantTwoStoreOne")){
        String varStoreUserName = caller.retrieveString("keyTenantTwoStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantTwoStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantThreeStoreOne")){
        String varStoreUserName = caller.retrieveString("keyTenantThreeStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantThreeStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantThreeStoreTwo")){
        String varStoreUserName = caller.retrieveString("keyTenantThreeStoreUserTwo");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantThreeStoreUserTwoPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreOne")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("carbon.super")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreTwo")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserTwo");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserTwoPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreWithoutSubscription")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserThree");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserThreePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreFour")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserFour");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserFourPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreFive")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserFive");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserFivePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreSix")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserSix");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserSixPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreSeven")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserSeven");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserSevenPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        }
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
        if(param_TenanrOrAdmin.equals("TenantOneStoreOne")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("Tenant")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantOneStoreTwo")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserTwo");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserTwoPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantOneStoreThree")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserThree");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserThreePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantOneStoreFour")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserFour");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserFourPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantOneStoreFive")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserFive");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserFivePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantOneStoreSix")){
        String varStoreUserName = caller.retrieveString("keyTenantOneStoreUserSix");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantOneStoreUserSixPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantTwoStoreOne")){
        String varStoreUserName = caller.retrieveString("keyTenantTwoStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantTwoStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantThreeStoreOne")){
        String varStoreUserName = caller.retrieveString("keyTenantThreeStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantThreeStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("TenantThreeStoreTwo")){
        String varStoreUserName = caller.retrieveString("keyTenantThreeStoreUserTwo");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyTenantThreeStoreUserTwoPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreOne")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("carbon.super")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserOne");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserOnePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreTwo")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserTwo");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserTwoPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreWithoutSubscription")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserThree");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserThreePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreFour")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserFour");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserFourPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreFive")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserFive");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserFivePassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreSix")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserSix");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserSixPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        } else if(param_TenanrOrAdmin.equals("AdminStoreSeven")){
        String varStoreUserName = caller.retrieveString("keyAdminStoreUserSeven");
        caller.type("APIStoreHome.tf_username",varStoreUserName);
        String varStoreUsePassword = caller.retrieveString("keyAdminStoreUserSevenPassword");
        caller.type("APIStoreHome.tf_password",varStoreUsePassword);
        }
        caller.waitForElement("APIStoreHome.btn_login",param_pauseThreeSeconds);
        caller.click("APIStoreHome.btn_login");
        }
        caller.writeToReport("End of BC StoreLogin");	
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
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
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
     *  Business component bc_APIStore_CreateApplication.
     * 
     */
    public final static void bc_APIStore_CreateApplication(final SeleniumTestBase caller, final String param_applicationName, final String param_discription, final String param_IsRequiedThrottlingTier, final String param_throttlingTier, final String param_IsRequiedCallBackURL, final String param_callBackURL, final String param_pauseThreeSeconds, final String param_pauseFourSeconds, final String param_pauseSixSeconds, final String param_pauseEightSeconds) throws Exception {
        //below BC could be invoked only when logged into API store page
        caller.click("APIStoreHome.lnk_MyApplication");
        //verify the navigated my application page
        caller.checkElementPresent("APIStoreMyApllication.ele_lblNewAppliacation",false,"");
        caller.type("APIStoreMyApllication.tf_ApplicationName",param_applicationName);
        if(param_IsRequiedThrottlingTier.equals("yes")){
        caller.select("APIStoreMyApllication.ele_ddThrottlingTier",param_throttlingTier);
        }
        if(param_IsRequiedCallBackURL.equals("yes")){
        caller.type("APIStoreMyApllication.tf_CallBackURL",param_callBackURL);
        }
        caller.type("APIStoreMyApllication.tf_Discription",param_discription);
        caller.click("APIStoreMyApllication.btn_AddApplication");
        //verify the application is been added sucessfully
        caller.checkElementPresent("APIStoreMyApllication.ele_lblSuccessAddMesage",false,"");
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_applicationName,false,"");	
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
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Could not find the object 'APIPublisherBrowse.ele_lblManagedAPI'");
        }
        }
        }
        //wait for content load
        caller.waitForElement("APIPublisherBrowse.ele_lblEndpoints",param_pauseSixSeconds);
        //Verify the navigated page
        caller.checkElementPresent("APIPublisherBrowse.ele_lblEndpoints",false,"");
        //Enter production and sandbox endpoints
        caller.click("APIPublisherBrowse.tf_productionEndpoint");
        caller.type("APIPublisherBrowse.tf_productionEndpoint",param_productionEndpoint);
        if(param_IsSandBoxURLRequired.equals("yes")){
        caller.click("APIPublisherBrowse.tf_sandboxEndpoint");
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
     *  Business component bc_APIStore_MySubscription.
     * 
     */
    public final static void bc_APIStore_MySubscription(final SeleniumTestBase caller, final String param_applicationName, final String param_APIName, final String param_versionNumber, final String param_pauseSixSeconds) throws Exception {
        //Go to My Subcription window to Generate keys
        caller.click("APIStoreHome.lnk_MySubcription");
        //verify that the landed page is My Subscriptions
        caller.checkElementPresent("APIStoreMySubcription.ele_ddApplicationWithSubscription",false,"");
        caller.select("APIStoreMySubcription.ele_ddApplicationWithSubscription",param_applicationName);
        if(caller.checkElementPresent("APIStoreMySubcription.btn_generateKeyProduction")){
        caller.click("APIStoreMySubcription.btn_generateKeyProduction");
        } else if(caller.checkElementPresent("APIStoreMySubcription.btn_RegenarateProduction")){
        caller.click("APIStoreMySubcription.btn_RegenarateProduction");
        }
        if(caller.checkElementPresent("APIStoreMySubcription.btn_GenarateKeySandBox")){
        caller.click("APIStoreMySubcription.btn_GenarateKeySandBox");
        } else if(caller.checkElementPresent("APIStoreMySubcription.btn_RegenarateSandBox")){
        caller.click("APIStoreMySubcription.btn_RegenarateSandBox");
        }
        //wait for content load
        caller.waitForElement("APIStoreMySubcription.ele_lblSubcribedAPIsPublished","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_versionNumber,param_pauseSixSeconds);
        //verify that the api is visible under subscriptions
        caller.checkElementPresent("APIStoreMySubcription.ele_lblSubcribedAPIsPublished","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_versionNumber,false,"");	
    }
    /**
     *  Business component bc_APIStore_APIs_SubscribeAPI.
     * 
     */
    public final static void bc_APIStore_APIs_SubscribeAPI(final SeleniumTestBase caller, final String param_APIName, final String param_versionNumber, final String param_applicationName, final String param_IsTierTypeChanged, final String param_tiertype, final String param_pauseSixSeconds) throws Exception {
        //The below BC is used to subscribe an api to an application and ultimately lands on home page
        //select the created API
        caller.type("APIStoreHome.tf_APISearchStore",param_APIName);
        caller.click("APIStoreHome.btn_SearchButtonStore");
        caller.checkElementPresent("APIStoreHome.lnk_APINameStoreWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_versionNumber_PARAM:" + param_versionNumber,false,"");
        caller.click("APIStoreHome.lnk_APINameStoreWithVersion","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_versionNumber_PARAM:" + param_versionNumber);
        //wait for content load
        //verify subscription page
        caller.checkElementPresent("APIStoreAPIs.ele_ddSelectAplicationToSubscribe",false,"");
        caller.select("APIStoreAPIs.ele_ddSelectAplicationToSubscribe",param_applicationName);
        if(param_IsTierTypeChanged.equals("yes")){
        caller.select("APIStoreAPIs.ele_ddtierToSubscribe",param_tiertype);
        } else {
        }
        caller.click("APIStoreAPIs.btn_Subscribe");
        //waiting for content load
        caller.waitForElement("APIStoreAPIs.btn_StayOnThisPage",param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreAPIs.btn_StayOnThisPage",false,"");
        caller.click("APIStoreAPIs.btn_StayOnThisPage");
        //verify that the popup dissapeared
        caller.checkElementPresent("APIStoreAPIs.btn_Subscribe",false,"");
        //navigate to API home page
        caller.click("APIStoreHome.lnk_APIs");	
    }
    /**
     *  Business component bc_APICreatedStatus.
     * 
     */
    public final static void bc_APICreatedStatus(final SeleniumTestBase caller, final String param_IsAPIDefault, final String param_IsSubscriptionsAvailable, final String param_subscription) throws Exception {
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
        //End of creation of API	
    }
    /**
     *  Business component bc_APIPublisher_AddAPI_DesignPhase_WitoutAutoGenAPINameAndContext.
     * 
     */
    public final static void bc_APIPublisher_AddAPI_DesignPhase_WitoutAutoGenAPINameAndContext(final SeleniumTestBase caller, final String param_APIName, final String param_APIContext, final String param_APIVersionOne, final String param_APIvisibility, final String param_APIImageName, final String param_TagName, final String param_urlPatternForPostAndPut, final String param_urlPatternForGetDeleteAndHead, final String param_pauseThreeSeconds, final String param_pauseFourSeconds, final String param_pauseSixSeconds, final String param_pauseEightSeconds) throws Exception {
        //Creation of API
        //Loging to the publisher using the created credentials
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.waitForElement("APIPublisherAdd.btn_StartCreating",param_pauseSixSeconds);
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_APIName",param_pauseSixSeconds);
        //Type API Name
        caller.type("APIPublisherAdd.tf_APIName",param_APIName);
        //Type API context
        /*
        SetVariable
         name=APIcontext
         type=String
         paramValue="{version}"+"/"+param_APIName
        */
        caller.type("APIPublisherAdd.tf_APIContext",param_APIContext);
        //Type API version as default
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersionOne);
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
        caller.type("APIPublisherAdd.tf_Tags",TagName);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_Tags",param_pauseSixSeconds);
        caller.type("APIPublisherAdd.tf_Tags",TagName+org.openqa.selenium.Keys.ENTER);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.tf_URLPattern",param_pauseSixSeconds);
        //Type the URL pattern for post and put
        caller.type("APIPublisherAdd.tf_URLPattern",param_urlPatternForPostAndPut);
        //waiting for content load
        caller.waitForElement("APIPublisherAdd.chk_Post",param_pauseSixSeconds);
        /*
        //************************* Obtain the soap values to verify *********************************
        SetVarProperty
         var=var_get
         type=String
         object=APIPublisherAdd.chk_Get
         property=TEXT
        SetVarProperty
         var=var_post
         type=String
         object=APIPublisherAdd.chk_Post
         property=VALUE
        SetVarProperty
         var=var_put
         type=String
         object=APIPublisherAdd.chk_Put
         property=VALUE
        SetVarProperty
         var=var_delete
         type=String
         object=APIPublisherAdd.chk_Delete
         property=VALUE
        SetVarProperty
         var=var_head
         type=String
         object=APIPublisherAdd.chk_Head
         property=VALUE
        //************************************************************************************
        */
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
        /*
        //verify the added soap commands post,put and the url pattern
        CheckTable
         object=APIPublisherAdd.tbl_APIDefinition
         validationType=TABLEDATA
         expectedValue=@var_post
         stopOnFailure=false
         customErrorMessage=
        CheckTable
         object=APIPublisherAdd.tbl_APIDefinition
         validationType=TABLEDATA
         expectedValue=@var_put
         stopOnFailure=false
         customErrorMessage=
        CheckTable
         object=APIPublisherAdd.tbl_APIDefinition
         validationType=TABLEDATA
         expectedValue=@param_urlPatternForPostAndPut
         stopOnFailure=false
         customErrorMessage=
        */
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
        /*
        CheckTable
         object=APIPublisherAdd.tbl_APIDefinition
         validationType=TABLEDATA
         expectedValue=@var_get
         stopOnFailure=false
         customErrorMessage=
        CheckTable
         object=APIPublisherAdd.tbl_APIDefinition
         validationType=TABLEDATA
         expectedValue=@var_delete
         stopOnFailure=false
         customErrorMessage=
        CheckTable
         object=APIPublisherAdd.tbl_APIDefinition
         validationType=TABLEDATA
         expectedValue=@var_head
         stopOnFailure=false
         customErrorMessage=
        CheckTable
         object=APIPublisherAdd.tbl_APIDefinition
         validationType=TABLEDATA
         expectedValue=@param_urlPatternForGetDeleteAndHead
         stopOnFailure=false
         customErrorMessage=
        */
        //waiting for content load and
        //check the button availability
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(caller.checkElementPresent("APIPublisherAdd.btn_Save")){
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
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Twenty Seconds");
        }
        }
        caller.pause(param_pauseFourSeconds);
        }
        //waiting for content load and
        //check the popup availability
        /*
        Loop
         expression=int TotalCount=5;TotalCount>0;TotalCount--
         If
          expression=caller.checkElementPresent("APIPublisherAdd.ele_lblDefaultResourceMessage")
          Click
           object=APIPublisherAdd.btn_Yes
          EditVariable
           name=TotalCount
           paramValue=0
          Break
         Else
          If
           expression=TotalCount==1
           Fail
            message=Could not find the object 'APIPublisherAdd.ele_lblDefaultResourceMessage'
          EndIf
         EndIf
        EndLoop
        */
        caller.click("APIPublisherAdd.lnk_NextImplement");
        for(int TotalCount=5;TotalCount>0;TotalCount--){
        if(!caller.checkElementPresent("APIPublisherAdd.ele_lblLoadSpinner")){
        TotalCount = 0;
        break;
        } else {
        if(TotalCount==1){
        caller.fail("Load Time Was Above Twenty Seconds");
        }
        }
        caller.pause(param_pauseFourSeconds);
        }	
    }
    /**
     *  Business component bc_StoreSignUpUserWithMoreDetails.
     * 
     */
    public final static void bc_StoreSignUpUserWithMoreDetails(final SeleniumTestBase caller, final String param_userName, final String param_password, final String param_firstName, final String param_lastName, final String param_email, final String param_organizationName, final String param_address, final String param_Country, final String param_LandPhone, final String param_MobilePhone, final String param_IM, final String param_URL, final String param_pauseFourSeconds) throws Exception {
        caller.writeToReport("Start  Executing bc_StoreSignUpUserWithMoreDetails");
        caller.click("APIStoreHome.btn_SignUp");
        //type user name
        caller.type("APIStoreSignUp.tf_UserName",param_userName);
        caller.type("APIStoreSignUp.tf_Password",param_password);
        caller.type("APIStoreSignUp.tf_ReTypePassword",param_password);
        caller.type("APIStoreSignUp.tf_FirstName",param_firstName);
        caller.type("APIStoreSignUp.tf_LastName",param_lastName);
        caller.type("APIStoreSignUp.tf_Email",param_email);
        caller.click("APIStoreSignUp.ele_lblMoreDetails");
        //Wait for Content load
        caller.waitForElement("APIStoreSignUp.tf_Organization",param_pauseFourSeconds);
        caller.checkElementPresent("APIStoreSignUp.tf_Organization",false,"");
        //Waiting for content load
        caller.waitForElement("APIStoreSignUp.tf_Organization",param_pauseFourSeconds);
        caller.type("APIStoreSignUp.tf_Organization",param_organizationName);
        caller.type("APIStoreSignUp.tf_Address",param_address);
        caller.type("APIStoreSignUp.tf_Country",param_Country);
        //Waiting for content load
        caller.waitForElement("APIStoreSignUp.tf_LandPhone",param_pauseFourSeconds);
        caller.type("APIStoreSignUp.tf_LandPhone",param_LandPhone);
        caller.type("APIStoreSignUp.tf_MobliePhone",param_MobilePhone);
        caller.type("APIStoreSignUp.tf_IM",param_IM);
        //Waiting for content load
        caller.waitForElement("APIStoreSignUp.tf_URL",param_pauseFourSeconds);
        caller.type("APIStoreSignUp.tf_URL",param_URL);
        caller.click("APIStoreSignUp.btn_Submit");
        //Waiting for content load
        caller.waitForElement("APIStoreSignUp.lnk_Ok",param_pauseFourSeconds);
        caller.pause(param_pauseFourSeconds);
        caller.click("APIStoreSignUp.lnk_Ok");
        caller.writeToReport("End Of  Executing bc_StoreSignUpUserWithMoreDetails");	
    }
    /**
     *  Business component bc_APIStore_InvokeAPI.
     * 
     */
    public final static void bc_APIStore_InvokeAPI(final SeleniumTestBase caller, final String param_APIName, final String param_versionNumber, final String param_applicationName, final String param_keyTypeToInvoke, final String param_IsPostExecuted, final String param_buttonNamePost, final String param_postPayloadContext, final String param_postCustomerNameFromPayloadContext, final String param_postResponseCodeTwoHundred, final String param_postResponseHeaders, final String param_IsGetExecuted, final String param_buttonNameGet, final String param_getCustomerName, final String param_getResponseCodeTwoHundred, final String param_getResponseHeaders, final String param_IsPutExecuted, final String param_buttonNamePut, final String param_putCustomerName, final String param_putResponseBodyNoContent, final String param_putResponseCodeTwoHundred, final String param_buttonNameGetForPutVerification, final String param_getCustomerNameForPutVerification, final String param_getResponseCodeTwoHundredForPutVerification, final String param_getResponseHeadersForPutVerification, final String param_IsHeadExecuted, final String param_buttonNameHead, final String param_headResponseBodyNoContent, final String param_headResponseCodeTwoHundred, final String param_headResponseHeadersNull, final String param_IsDeleteExecuted, final String param_buttonNameDelete, final String param_deleteResponseBodyNoContent, final String param_deleteResponseCodeTwoHundred, final String param_deleteResponseHeaders, final String param_buttonNameGetForDeleteVerification, final String param_getResponseBodyNoContentForDeleteVerification, final String param_getResponseCodeTwoHundredAndFourForDeleteVerification, final String param_getResponseHeadersNullForDeleteVerification, final String param_pauseFourSeconds, final String param_pauseSixSeconds, final String param_pauseEightSeconds) throws Exception {
        caller.writeToReport("Start of BC APIStore_InvokeAPI");
        //requies to pre-run bc_AddAPI_DesignPhaseToInvoke, bc_AddAPI_ImplementationPhaseToInvoke, bc_AddAPI_ManageToInvoke, bc_APIStore_CreateApplication, bc_APIStore_APIs_SubscribeAPI and bc_APIStore_MySubscription OR similar requirements executed
        //Search API i the subscribed list
        if(caller.checkElementPresent("APIStoreHome.ele_lblPaginationVisible")){
        caller.click("APIStoreHome.ele_lblPagination");
        }
        caller.click("APIStoreMySubcription.ele_lblSubcribedAPIsPublished","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_APIVersion_PARAM:" + param_versionNumber);
        //check the availability of api console tab in API
        caller.checkElementPresent("APIStoreAPIs.ele_tabAPIConsole",false,"");
        caller.click("APIStoreAPIs.ele_tabAPIConsole");
        //verify that the landed page is relavent api
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblAPIName","param_APIName_PARAM:" + param_APIName,false,"");
        int actualDropdownCount = caller.getObjectCount("APIStoreAPIConsole.ele_ddApplicationName");          
        if(actualDropdownCount==1){
        } else {
        //select the relavent details to invoke api
        caller.select("APIStoreAPIConsole.ele_ddApplicationName",param_applicationName);
        }
        caller.select("APIStoreAPIConsole.ele_ddKeyType",param_keyTypeToInvoke);
        //Invoking the commands depending on user inputs
        if(param_IsPostExecuted.equals("yes")){
        caller.writeToReport("Start Of Execution Of Post Command");
        //Execution and verification of post command
        caller.checkElementPresent("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNamePost,false,"");
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNamePost);
        //wait for content load
        //verify that the view is expanded
        caller.checkElementPresent("APIStoreAPIConsole.tf_postPayload",false,"");
        caller.type("APIStoreAPIConsole.tf_postPayload",param_postPayloadContext);
        //wait for content load
        caller.waitForElement("APIStoreAPIConsole.btn_postTryOut",param_pauseSixSeconds);
        caller.click("APIStoreAPIConsole.btn_postTryOut");
        //wait for content load
        //store and retreive the customer id to verify
        String var_CustomerIdPost = caller.getStringProperty("APIStoreAPIConsole.ele_lblPostResponseBodyRetriveId","TEXT:");
        caller.store("key_CustomerId","String",var_CustomerIdPost);
        //verify the response body
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblPostResponseBody","param_idNumber_PARAM:" + var_CustomerIdPost + "_PARAM," + "param_customerName_PARAM:" + param_postCustomerNameFromPayloadContext,false,"");
        //verify the response code
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblPostResponseCode","param_responseCode_PARAM:" + param_postResponseCodeTwoHundred,false,"");
        //verify the response headers
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblPostResponseHeaders","param_responseHeaders_PARAM:" + param_postResponseHeaders,false,"");
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNamePost);
        //wait for content load
        caller.writeToReport("End Of Execution Of Post Command");
        }
        if(param_IsGetExecuted.equals("yes")){
        caller.writeToReport("Start Of Execution Of Get Command");
        //Execution and verification of get command
        //retrive the stored id
        String var_CustomerIdGet = caller.retrieveString("key_CustomerId");
        caller.checkElementPresent("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameGet,false,"");
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameGet);
        //wait for content load
        //verify that the view is expanded
        caller.checkElementPresent("APIStoreAPIConsole.tf_getId",false,"");
        //type retrived id in the text space
        caller.type("APIStoreAPIConsole.tf_getId",var_CustomerIdGet);
        //wait for content load
        caller.waitForElement("APIStoreAPIConsole.btn_getTryOut",param_pauseSixSeconds);
        caller.click("APIStoreAPIConsole.btn_getTryOut");
        //wait for content load
        //verify the response body
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblGetResponseBody","param_idNumber_PARAM:" + var_CustomerIdGet + "_PARAM," + "param_customerName_PARAM:" + param_getCustomerName,false,"");
        //verify the response code
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblGetResponseCode","param_responseCode_PARAM:" + param_getResponseCodeTwoHundred,false,"");
        //verify the response headers
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblGetResponseHeaders","param_responseHeaders_PARAM:" + param_getResponseHeaders,false,"");
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameGet);
        //wait for content load
        caller.writeToReport("End Of Execution Of Get Command");
        }
        if(param_IsPutExecuted.equals("yes")){
        caller.writeToReport("Start Of Execution Of Put Command");
        //Execution and verification of put command
        caller.checkElementPresent("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNamePut,false,"");
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNamePut);
        //retrive the stored id
        String var_CustomerIdPut = caller.retrieveString("key_CustomerId");
        caller.checkElementPresent("APIStoreAPIConsole.tf_putPayload",false,"");
        caller.type("APIStoreAPIConsole.tf_putPayload","{\"Customer\":{\"id\":\""+var_CustomerIdPut+"\",\"name\":\""+param_putCustomerName+"\"}}");
        //wait for content load
        caller.waitForElement("APIStoreAPIConsole.btn_putTryOut",param_pauseSixSeconds);
        caller.click("APIStoreAPIConsole.btn_putTryOut");
        //wait for content load
        //verify the response body
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblPutResponseBody","param_noContent_PARAM:" + param_putResponseBodyNoContent,false,"");
        //verify the response code
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblPutResponseCode","param_responseCode_PARAM:" + param_putResponseCodeTwoHundred,false,"");
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNamePut);
        //wait for content load
        caller.checkElementPresent("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameGetForPutVerification,false,"");
        caller.writeToReport("Start Of Execution Of Get Command To Verify Succesful Execution Of Put Command");
        //Execution and verification of get command to verify valid put has occoured
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameGetForPutVerification);
        //wait for content load
        //verify that the view is expanded
        caller.checkElementPresent("APIStoreAPIConsole.tf_getId",false,"");
        //type retrived id in the text space
        caller.type("APIStoreAPIConsole.tf_getId",var_CustomerIdPut);
        //wait for content load
        caller.waitForElement("APIStoreAPIConsole.btn_getTryOut",param_pauseSixSeconds);
        caller.click("APIStoreAPIConsole.btn_getTryOut");
        //wait for content load
        //verify the response body
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblGetResponseBody","param_idNumber_PARAM:" + var_CustomerIdPut + "_PARAM," + "param_customerName_PARAM:" + param_getCustomerNameForPutVerification,false,"");
        //verify the response code
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblGetResponseCode","param_responseCode_PARAM:" + param_getResponseCodeTwoHundredForPutVerification,false,"");
        //verify the response headers
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblGetResponseHeaders","param_responseHeaders_PARAM:" + param_getResponseHeadersForPutVerification,false,"");
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameGetForPutVerification);
        //wait for content load
        caller.writeToReport("End Of Execution Of Get Command To Verify Succesful Execution Of Put Command");
        caller.writeToReport("End Of Execution Of Put Command");
        }
        if(param_IsHeadExecuted.equals("yes")){
        //Execution and verification of head command
        caller.writeToReport("Start Of Execution Of Head Command");
        //Execution and verification of Head command
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameHead);
        //retrive the stored id
        String var_CustomerIdHead = caller.retrieveString("key_CustomerId");
        //wait for content load
        //verify that the view is expanded
        caller.checkElementPresent("APIStoreAPIConsole.tf_headId",false,"");
        //type retrived id in the text space
        caller.type("APIStoreAPIConsole.tf_headId",var_CustomerIdHead);
        //wait for content load
        caller.waitForElement("APIStoreAPIConsole.btn_headTryOut",param_pauseSixSeconds);
        caller.click("APIStoreAPIConsole.btn_headTryOut");
        //wait for content load
        //verify the response body
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblHeadResponseBody","param_nocontent_PARAM:" + param_headResponseBodyNoContent,false,"");
        //verify the response code
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblHeadResponseCode","param_responseCode_PARAM:" + param_headResponseCodeTwoHundred,false,"");
        //verify the response headers
        //header response is different to what is expected
        /*
        CheckElementPresent
          object=APIStoreAPIConsole.ele_lblHeadResponseHeaders
          param_responseHeaders=@param_headResponseHeadersNull
          stopOnFailure=false
          customErrorMessage=
        */
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameHead);
        caller.writeToReport("End Of Execution Of Head Command");
        }
        if(param_IsDeleteExecuted.equals("yes")){
        //Execution and verification of delete command
        caller.writeToReport("Start Of Execution Of Delete Command");
        //Execution and verification of Head command
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameDelete);
        //retrive the stored id
        String var_CustomerIdDelete = caller.retrieveString("key_CustomerId");
        caller.type("APIStoreAPIConsole.tf_deleteId",var_CustomerIdDelete);
        //wait for content load
        caller.waitForElement("APIStoreAPIConsole.btn_deleteTryOut",param_pauseSixSeconds);
        caller.click("APIStoreAPIConsole.btn_deleteTryOut");
        //wait for content load
        //verify the response body
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblDeleteResponseBody","param_noContent_PARAM:" + param_deleteResponseBodyNoContent,false,"");
        //verify the response code
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblDeleteResponseCode","param_responseCode_PARAM:" + param_deleteResponseCodeTwoHundred,false,"");
        //verify the response headers
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblDeleteResponseHeaders","param_responseHeaders_PARAM:" + param_deleteResponseHeaders,false,"");
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameDelete);
        //wait for content load
        caller.writeToReport("Start Of Execution Of Get Command To Verify Succesful Execution Of Delete Command");
        //Execution and verification of get command to verify valid put has occoured
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameGetForDeleteVerification);
        //wait for content load
        //verify that the view is expanded
        caller.checkElementPresent("APIStoreAPIConsole.tf_getId",false,"");
        //type retrived id in the text space
        caller.type("APIStoreAPIConsole.tf_getId",var_CustomerIdDelete);
        //wait for content load
        caller.waitForElement("APIStoreAPIConsole.btn_getTryOut",param_pauseSixSeconds);
        caller.click("APIStoreAPIConsole.btn_getTryOut");
        //wait for content load
        //verify the response body
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblGetResponseBodyNoContent","param_noContent_PARAM:" + param_getResponseBodyNoContentForDeleteVerification,false,"");
        //verify the response code
        caller.checkElementPresent("APIStoreAPIConsole.ele_lblGetResponseCode","param_responseCode_PARAM:" + param_getResponseCodeTwoHundredAndFourForDeleteVerification,false,"");
        //verify the response headers
        //header response is different to what is expected
        /*
        CheckElementPresent
          object=APIStoreAPIConsole.ele_lblGetResponseHeaders
          param_responseHeaders=@param_getResponseHeadersNullForDeleteVerification
          stopOnFailure=false
          customErrorMessage=
        */
        caller.click("APIStoreAPIConsole.btn_mainCommandButtons","param_buttonName_PARAM:" + param_buttonNameGetForDeleteVerification);
        //wait for content load
        caller.writeToReport("End Of Execution Of Get Command To Verify Succesful Execution Of Delete Command");
        caller.writeToReport("End Of Execution Of Delete Command");
        }
        caller.writeToReport("End of BC APIStore_InvokeAPI");	
    }
    /**
     *  Business component bc_DeleteAllApplicationsAndAPIs.
     * 
     */
    public final static void bc_DeleteAllApplicationsAndAPIs(final SeleniumTestBase caller, final String param_StoreURL, final String param_TenantOrAdmin, final String param_TenantOrAdminStoreUser, final String param_PublisherURL, final String param_TenantOrAdminPublisherUser, final String param_DefaultApplication, final String param_pauseFourSeconds, final String param_pauseThreeSeconds, final String param_pauseTenSeconds) throws Exception {
        caller.writeToReport("Start of bc_DeleteAllApplicationsAndAPIs");
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantOrAdminStoreUser,param_pauseFourSeconds,param_pauseFourSeconds,param_pauseTenSeconds,param_pauseTenSeconds);
        //waiting for content load
        caller.waitForElement("APIStoreHome.lnk_MyApplication",param_pauseFourSeconds);
        caller.checkElementPresent("APIStoreHome.lnk_MyApplication",false,"");
        caller.click("APIStoreHome.lnk_MyApplication");
        if(caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp")){
        for(;caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp");){
        caller.pause(param_pauseThreeSeconds);
        caller.waitForElement("APIStoreMyApllication.btn_DeleteApp",param_pauseThreeSeconds);
        caller.click("APIStoreMyApllication.btn_DeleteApp");
        //waiting for content load
        /*
        WaitForElement
           object=APIStoreMyApllication.btn_yes
           ms=@param_pauseFourSeconds
        */
        caller.pause(param_pauseThreeSeconds);
        caller.checkElementPresent("APIStoreMyApllication.btn_yes",false,"");
        caller.click("APIStoreMyApllication.btn_yes");
        caller.pause(param_pauseThreeSeconds);
        }
        }
        //Navigate to publisher for delete APIs
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,param_pauseFourSeconds);
        lib_Common.bc_PublisherLogin(caller, param_PublisherURL,param_TenantOrAdminPublisherUser,param_pauseThreeSeconds,param_pauseFourSeconds);
        caller.checkElementPresent("APIPublisherHome.lnk_Browse",false,"");
        caller.click("APIPublisherHome.lnk_Browse");
        if(caller.checkElementPresent("APIPublisherBrowse.ele_lblDeleteAPI")){
        for(;caller.checkElementPresent("APIPublisherBrowse.ele_lblDeleteAPI");){
        caller.click("APIPublisherBrowse.ele_lblDeleteAPI");
        caller.waitForElement("APIPublisherBrowse.btn_Yes",param_pauseTenSeconds);
        caller.click("APIPublisherBrowse.btn_Yes");
        for(;caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIDeletePleaseWait");){
        }
        }
        }
        //Go to API Store for create DefaultApplication
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_TenantOrAdmin);
        lib_Common.bc_APIStore_CreateApplication(caller, param_DefaultApplication,"","","","","",param_pauseFourSeconds,param_pauseFourSeconds,param_pauseTenSeconds,param_pauseTenSeconds);
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_DefaultApplication,false,"");
        caller.writeToReport("End of bc_DeleteAllApplicationsAndAPIs");	
    }
    /**
     *  Business component bc_DeleteAllApplicationsAndAPIsFromAllTenants.
     * 
     */
    public final static void bc_DeleteAllApplicationsAndAPIsFromAllTenants(final SeleniumTestBase caller, final String param_StoreURL, final String param_DomainOneTenantOrAdmin, final String param_TenantOneOrAdminStoreUserTwo, final String param_TenantOneOrAdminStoreUserOne, final String param_PublisherURL, final String param_TenantOrAdminPublisherUser, final String param_DefaultApplication, final String param_TenantOneOrAdminStoreUserThree, final String param_DomainTwoTenantOrAdmin, final String param_DomainCondition, final String param_TenantTwoOrAdminStoreUserOne, final String param_TenantTwoOrAdminPublisherUserOne, final String param_AdminStoreUserOne, final String param_AdminStoreUserTwo, final String param_AdminPublisherUserOne, final String param_pauseSixSeconds, final String param_pauseThreeSeconds, final String param_pauseFourSeconds) throws Exception {
        caller.writeToReport("Start of executing bc_DeleteAllApplicationsAndAPIsFromAllTenants");
        if(param_DomainCondition.equals("tenant")){
        //Delete applications from------------------------------------------------------- T1S1
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseSixSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainOneTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantOneOrAdminStoreUserOne,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        //waiting for content load
        caller.waitForElement("APIStoreHome.lnk_MyApplication",param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreHome.lnk_MyApplication",false,"");
        caller.click("APIStoreHome.lnk_MyApplication");
        if(caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp")){
        for(;caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp");){
        caller.click("APIStoreMyApllication.btn_DeleteApp");
        //waiting for content load
        /*
        WaitForElement
            object=APIStoreMyApllication.btn_yes
            ms=@param_pauseSixSeconds
        */
        caller.checkElementPresent("APIStoreMyApllication.btn_yes",false,"");
        caller.click("APIStoreMyApllication.btn_yes");
        //waiting for content load
        caller.pause(param_pauseThreeSeconds);
        }
        }
        //Delete applications from---------------------------------------------------------- T1S2
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainOneTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantOneOrAdminStoreUserTwo,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        //waiting for content load
        caller.waitForElement("APIStoreHome.lnk_MyApplication",param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreHome.lnk_MyApplication",false,"");
        caller.click("APIStoreHome.lnk_MyApplication");
        if(caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp")){
        for(;caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp");){
        caller.click("APIStoreMyApllication.btn_DeleteApp");
        //waiting for content load
        /*
        WaitForElement
            object=APIStoreMyApllication.btn_yes
            ms=@param_pauseThreeSeconds
        */
        caller.checkElementPresent("APIStoreMyApllication.btn_yes",false,"");
        caller.click("APIStoreMyApllication.btn_yes");
        //waiting for content load
        caller.pause(param_pauseThreeSeconds);
        }
        }
        //End of Delete applications from T1S2
        //Delete applications from --------------------------------------------------- T1S3
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainOneTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantOneOrAdminStoreUserThree,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        caller.waitForElement("APIStoreHome.lnk_MyApplication",param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreHome.lnk_MyApplication",false,"");
        caller.click("APIStoreHome.lnk_MyApplication");
        if(caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp")){
        for(;caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp");){
        caller.click("APIStoreMyApllication.btn_DeleteApp");
        //waiting for content load
        /*
        WaitForElement
            object=APIStoreMyApllication.btn_yes
            ms=@param_pauseThreeSeconds
        */
        caller.checkElementPresent("APIStoreMyApllication.btn_yes",false,"");
        caller.click("APIStoreMyApllication.btn_yes");
        //waiting for content load
        caller.pause(param_pauseThreeSeconds);
        }
        }
        //End of Delete applications from T1S3
        //Delete app from  ----------------------------------  T2S1
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainTwoTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantTwoOrAdminStoreUserOne,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        //waiting for content load
        caller.waitForElement("APIStoreHome.lnk_MyApplication",param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreHome.lnk_MyApplication",false,"");
        caller.click("APIStoreHome.lnk_MyApplication");
        if(caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp")){
        for(;caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp");){
        caller.click("APIStoreMyApllication.btn_DeleteApp");
        //waiting for content load
        /*
        WaitForElement
            object=APIStoreMyApllication.btn_yes
            ms=@param_pauseThreeSeconds
        */
        caller.checkElementPresent("APIStoreMyApllication.btn_yes",false,"");
        caller.click("APIStoreMyApllication.btn_yes");
        //waiting for content load
        caller.pause(param_pauseThreeSeconds);
        }
        }
        //************************************************************** Delete API *******************************************************************
        //----------------------------------------------------------------------Delete publisher API from T1P1
        //Navigate to publisher for delete APIs
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,param_pauseThreeSeconds);
        lib_Common.bc_PublisherLogin(caller, param_PublisherURL,param_TenantOrAdminPublisherUser,param_pauseSixSeconds,param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherHome.lnk_Browse",false,"");
        caller.click("APIPublisherHome.lnk_Browse");
        if(caller.checkElementPresent("APIPublisherBrowse.ele_lblDeleteAPI")){
        for(;caller.checkElementPresent("APIPublisherBrowse.ele_lblDeleteAPI");){
        caller.click("APIPublisherBrowse.ele_lblDeleteAPI");
        caller.waitForElementEnable("APIPublisherBrowse.btn_Yes");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_Yes",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_Yes");
        for(;caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIDeletePleaseWait");){
        //waiting for content load - Can not remove the pause
        caller.pause(param_pauseThreeSeconds);
        }
        }
        }
        //--------------------------------------------------------------------------------------
        //----------------------------------------------------------------------   Delete publisher API from T2P1
        //Navigate to publisher for delete APIs
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,param_pauseThreeSeconds);
        lib_Common.bc_PublisherLogin(caller, param_PublisherURL,param_TenantTwoOrAdminPublisherUserOne,param_pauseThreeSeconds,param_pauseFourSeconds);
        caller.checkElementPresent("APIPublisherHome.lnk_Browse",false,"");
        caller.click("APIPublisherHome.lnk_Browse");
        if(caller.checkElementPresent("APIPublisherBrowse.ele_lblDeleteAPI")){
        for(;caller.checkElementPresent("APIPublisherBrowse.ele_lblDeleteAPI");){
        caller.click("APIPublisherBrowse.ele_lblDeleteAPI");
        caller.waitForElementEnable("APIPublisherBrowse.btn_Yes");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_Yes",param_pauseSixSeconds);
        caller.click("APIPublisherBrowse.btn_Yes");
        for(;caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIDeletePleaseWait");){
        //waiting for content load
        caller.pause(param_pauseThreeSeconds);
        }
        }
        }
        //--------------------------------------------------------------------------------------
        //****************************************************** Create Default Applications ********************************************************
        //------------------------------------T1S1
        //Go to API Store user three for create DefaultApplication
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainOneTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantOneOrAdminStoreUserOne,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        lib_Common.bc_APIStore_CreateApplication(caller, param_DefaultApplication,"","","","","",param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_DefaultApplication,false,"");
        //------------------------------------T1S2
        //Go to API Store user three for create DefaultApplication
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainOneTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantOneOrAdminStoreUserTwo,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        lib_Common.bc_APIStore_CreateApplication(caller, param_DefaultApplication,"","","","","",param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_DefaultApplication,false,"");
        //------------------------------------T1S3
        //Go to API Store user three for create DefaultApplication
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainOneTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantOneOrAdminStoreUserThree,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        lib_Common.bc_APIStore_CreateApplication(caller, param_DefaultApplication,"","","","","",param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_DefaultApplication,false,"");
        //------------------------------------T1S3
        //Go to API Store user three for create DefaultApplication
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainTwoTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_TenantTwoOrAdminStoreUserOne,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        lib_Common.bc_APIStore_CreateApplication(caller, param_DefaultApplication,"","","","","",param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_DefaultApplication,false,"");
        } else if(param_DomainCondition.equals("admin")){
        //Delete applications from------------------------------------------------------- AS1
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainOneTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_AdminStoreUserOne,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreHome.lnk_MyApplication",false,"");
        caller.click("APIStoreHome.lnk_MyApplication");
        if(caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp")){
        for(;caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp");){
        caller.click("APIStoreMyApllication.btn_DeleteApp");
        caller.checkElementPresent("APIStoreMyApllication.btn_yes",false,"");
        caller.click("APIStoreMyApllication.btn_yes");
        //waiting for content load
        caller.pause(param_pauseThreeSeconds);
        }
        }
        //Delete applications from------------------------------------------------------- AS2
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainOneTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_AdminStoreUserTwo,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        caller.waitForElement("APIStoreHome.lnk_MyApplication",param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreHome.lnk_MyApplication",false,"");
        caller.click("APIStoreHome.lnk_MyApplication");
        if(caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp")){
        for(;caller.checkElementPresent("APIStoreMyApllication.btn_DeleteApp");){
        caller.click("APIStoreMyApllication.btn_DeleteApp");
        //waiting for content load
        /*
        WaitForElement
            object=APIStoreMyApllication.btn_yes
            ms=@param_pauseFourSeconds
        */
        caller.checkElementPresent("APIStoreMyApllication.btn_yes",false,"");
        caller.click("APIStoreMyApllication.btn_yes");
        //waiting for content load
        caller.pause(param_pauseThreeSeconds);
        }
        }
        //----------------------------------------------------------------------Delete publisher API from T1P1
        //Navigate to publisher for delete APIs
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_PublisherURL,param_pauseThreeSeconds);
        lib_Common.bc_PublisherLogin(caller, param_PublisherURL,param_AdminPublisherUserOne,param_pauseSixSeconds,param_pauseSixSeconds);
        caller.checkElementPresent("APIPublisherHome.lnk_Browse",false,"");
        caller.click("APIPublisherHome.lnk_Browse");
        if(caller.checkElementPresent("APIPublisherBrowse.ele_lblDeleteAPI")){
        for(;caller.checkElementPresent("APIPublisherBrowse.ele_lblDeleteAPI");){
        caller.click("APIPublisherBrowse.ele_lblDeleteAPI");
        caller.waitForElementEnable("APIPublisherBrowse.btn_Yes");
        //waiting for content load
        caller.waitForElement("APIPublisherBrowse.btn_Yes",param_pauseFourSeconds);
        caller.click("APIPublisherBrowse.btn_Yes");
        for(;caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIDeletePleaseWait");){
        //waiting for content load
        caller.pause(param_pauseThreeSeconds);
        }
        }
        }
        //--------------------------------------------------------------------------------------
        //------------------------------------Create default application AS1
        //Go to API Store user three for create DefaultApplication
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseThreeSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainOneTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_AdminStoreUserOne,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        lib_Common.bc_APIStore_CreateApplication(caller, param_DefaultApplication,"","","","","",param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_DefaultApplication,false,"");
        //------------------------------------Create default application AS2
        //Go to API Store user three for create DefaultApplication
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_StoreURL,param_pauseFourSeconds);
        lib_Common.bc_SelectServer(caller, param_DomainOneTenantOrAdmin);
        lib_Common.bc_StoreLogin(caller, param_AdminStoreUserTwo,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        lib_Common.bc_APIStore_CreateApplication(caller, param_DefaultApplication,"","","","","",param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds,param_pauseSixSeconds);
        caller.checkElementPresent("APIStoreMyApllication.ele_lblTableAppName","param_AppName_PARAM:" + param_DefaultApplication,false,"");
        }
        caller.writeToReport("End of executing bc_DeleteAllApplicationsAndAPIsFromAllTenants");	
    }
    /**
     *  Business component bc_APIPublisherSearch.
     * 
     */
    public final static void bc_APIPublisherSearch(final SeleniumTestBase caller, final String param_SearchContent, final String param_APIName, final String param_APIVersion, final String param_pauseFourSeconds) throws Exception {
        //API Publisher Search
        caller.writeToReport("Start Of API Publisher Search");
        caller.waitForElement("APIPublisherHome.lnk_Browse",param_pauseFourSeconds);
        caller.click("APIPublisherHome.lnk_Browse");
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
     *  Business component bc_APIPublisher_TierPermissions_VerifyPage_SingleRow.
     * 
     */
    public final static void bc_APIPublisher_TierPermissions_VerifyPage_SingleRow(final SeleniumTestBase caller, final String paramTierName) throws Exception {
        caller.writeToReport("Start Of APIPublisher_TierPermissions_VerifyPage_SingleRow");
        caller.checkElementPresent("APIPublisherTierPermissions.ele_lblTierName","param_TierName_PARAM:" + paramTierName,false,"");
        caller.checkElementPresent("APIPublisherTierPermissions.chk_Allow","param_TierName_PARAM:" + paramTierName,false,"");
        caller.checkElementPresent("APIPublisherTierPermissions.chk_Deny","param_TierName_PARAM:" + paramTierName,false,"");
        caller.checkElementPresent("APIPublisherTierPermissions.tf_InputRole","param_TierName_PARAM:" + paramTierName,false,"");
        caller.checkElementPresent("APIPublisherTierPermissions.btn_UpdatePermissions","param_TierName_PARAM:" + paramTierName,false,"");
        caller.writeToReport("End Of API APIPublisher_TierPermissions_VerifyPage_SingleRow");	
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
     *  Business component bc_APIPublisher_TierPermission_AllowAll.
     * 
     */
    public final static void bc_APIPublisher_TierPermission_AllowAll(final SeleniumTestBase caller, final String param_publisherURL, final String param_publisherTwoOfTenentOneOrAdmin, final String param_TierNameGold, final String param_TierNameSilver, final String param_TierNameBronze, final String param_TierNameUnlimited, final String param_internalOrEveryone, final String param_TierNameCustom, final String param_pauseThreeSeconds, final String param_pauseFourSeconds) throws Exception {
        caller.writeToReport("Start Of APIPublisher_TierPermission_AllowAll");
        lib_Common.bc_PublisherLogin(caller, param_publisherURL,param_publisherTwoOfTenentOneOrAdmin,param_pauseThreeSeconds,param_pauseFourSeconds);
        caller.checkObjectProperty("APIPublisherHome.lnk_TierPermissions","ELEMENTPRESENT","true",false,"");
        //Navigate to tier permissions
        caller.click("APIPublisherHome.lnk_TierPermissions");
        //verify the landed page has a tier row which contains the name gold
        caller.checkElementPresent("APIPublisherTierPermissions.tf_InputRole","param_TierName_PARAM:" + param_TierNameGold,false,"");
        //reset the content of the row gold
        caller.type("APIPublisherTierPermissions.tf_InputRole","param_TierName_PARAM:" + param_TierNameGold,param_internalOrEveryone);
        caller.checkElementPresent("APIPublisherTierPermissions.chk_Allow","param_TierName_PARAM:" + param_TierNameGold,false,"");
        caller.click("APIPublisherTierPermissions.chk_Allow","param_TierName_PARAM:" + param_TierNameGold);
        caller.checkElementPresent("APIPublisherTierPermissions.btn_UpdatePermissions","param_TierName_PARAM:" + param_TierNameGold,false,"");
        caller.click("APIPublisherTierPermissions.btn_UpdatePermissions","param_TierName_PARAM:" + param_TierNameGold);
        caller.checkElementPresent("APIPublisherTierPermissions.ele_lblUpdateSuccessMessage","param_TierName_PARAM:" + param_TierNameGold,false,"");
        //reset the content of the row silver
        caller.type("APIPublisherTierPermissions.tf_InputRole","param_TierName_PARAM:" + param_TierNameSilver,param_internalOrEveryone);
        caller.checkElementPresent("APIPublisherTierPermissions.chk_Allow","param_TierName_PARAM:" + param_TierNameSilver,false,"");
        caller.click("APIPublisherTierPermissions.chk_Allow","param_TierName_PARAM:" + param_TierNameSilver);
        caller.checkElementPresent("APIPublisherTierPermissions.btn_UpdatePermissions","param_TierName_PARAM:" + param_TierNameSilver,false,"");
        caller.click("APIPublisherTierPermissions.btn_UpdatePermissions","param_TierName_PARAM:" + param_TierNameSilver);
        caller.checkElementPresent("APIPublisherTierPermissions.ele_lblUpdateSuccessMessage","param_TierName_PARAM:" + param_TierNameSilver,false,"");
        //reset the content of the row bronze
        caller.type("APIPublisherTierPermissions.tf_InputRole","param_TierName_PARAM:" + param_TierNameBronze,param_internalOrEveryone);
        caller.checkElementPresent("APIPublisherTierPermissions.chk_Allow","param_TierName_PARAM:" + param_TierNameBronze,false,"");
        caller.click("APIPublisherTierPermissions.chk_Allow","param_TierName_PARAM:" + param_TierNameBronze);
        caller.checkElementPresent("APIPublisherTierPermissions.btn_UpdatePermissions","param_TierName_PARAM:" + param_TierNameBronze,false,"");
        caller.click("APIPublisherTierPermissions.btn_UpdatePermissions","param_TierName_PARAM:" + param_TierNameBronze);
        caller.checkElementPresent("APIPublisherTierPermissions.ele_lblUpdateSuccessMessage","param_TierName_PARAM:" + param_TierNameBronze,false,"");
        //reset the content of the row Unlimited
        caller.type("APIPublisherTierPermissions.tf_InputRole","param_TierName_PARAM:" + param_TierNameUnlimited,param_internalOrEveryone);
        caller.checkElementPresent("APIPublisherTierPermissions.chk_Allow","param_TierName_PARAM:" + param_TierNameUnlimited,false,"");
        caller.click("APIPublisherTierPermissions.chk_Allow","param_TierName_PARAM:" + param_TierNameUnlimited);
        caller.checkElementPresent("APIPublisherTierPermissions.btn_UpdatePermissions","param_TierName_PARAM:" + param_TierNameUnlimited,false,"");
        caller.click("APIPublisherTierPermissions.btn_UpdatePermissions","param_TierName_PARAM:" + param_TierNameUnlimited);
        caller.checkElementPresent("APIPublisherTierPermissions.ele_lblUpdateSuccessMessage","param_TierName_PARAM:" + param_TierNameUnlimited,false,"");
        //reset the content of the row custom
        caller.type("APIPublisherTierPermissions.tf_InputRole","param_TierName_PARAM:" + param_TierNameCustom,param_internalOrEveryone);
        caller.checkElementPresent("APIPublisherTierPermissions.chk_Allow","param_TierName_PARAM:" + param_TierNameCustom,false,"");
        caller.click("APIPublisherTierPermissions.chk_Allow","param_TierName_PARAM:" + param_TierNameCustom);
        caller.checkElementPresent("APIPublisherTierPermissions.btn_UpdatePermissions","param_TierName_PARAM:" + param_TierNameCustom,false,"");
        caller.click("APIPublisherTierPermissions.btn_UpdatePermissions","param_TierName_PARAM:" + param_TierNameCustom);
        caller.checkElementPresent("APIPublisherTierPermissions.ele_lblUpdateSuccessMessage","param_TierName_PARAM:" + param_TierNameCustom,false,"");
        caller.writeToReport("End Of APIPublisher_TierPermission_AllowAll");	
    }
    /**
     *  Business component bc_APIPublisherSearchWithNameVersionAndStatus.
     * 
     */
    public final static void bc_APIPublisherSearchWithNameVersionAndStatus(final SeleniumTestBase caller, final String param_pauseFourSeconds, final String param_SearchContent, final String param_ApiName, final String param_APIVersion, final String param_ApiStatus) throws Exception {
        //API Publisher Search
        caller.writeToReport("Start Of API Publisher Search");
        caller.click("APIPublisherHome.lnk_Browse");
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
