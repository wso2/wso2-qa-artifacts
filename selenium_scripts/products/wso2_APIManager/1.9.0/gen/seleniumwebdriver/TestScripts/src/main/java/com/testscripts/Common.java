package com.testscripts;

import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;
import org.openqa.selenium.By;

/**
 *  Class Common contains reusable business components 
 *  Each method in this class correspond to a reusable business component.
 */
public class Common {

    /**
     *  Business component bc_Login_APIPublisher.
     */
    public final static void bc_Login_APIPublisher(final SeleniumTestBase caller, final String param_UserName, final String param_Password, final String param_publisherURL) throws Exception {
        //Log into AI Publisher
        caller.open("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Waiting for content to load
        caller.pause("7000");
        //Type username
        caller.type("APIPublisherLogin.tf_UserName",param_UserName);
        //Type password
        caller.type("APIPublisherLogin.tf_PassWord",param_Password);
        //clock login
        caller.click("APIPublisherLogin.btn_Login");
        //Waiting for content to load
        caller.pause("2000");	
    }
    /**
     *  Business component bc_CreateAPI_Design.
     */
    public final static void bc_CreateAPI_Design(final SeleniumTestBase caller, final String param_APIVersion, final String param_InvalidAPIImagePath, final String param_APIImagePath, final String param_URLPattern, final String param_APIName) throws Exception {
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        //Verify design API page apears
        caller.checkElementPresent("APIPublisherAdd.ele_lblDesignAPI",false,"");
        caller.type("APIPublisherAdd.tf_APIName",param_APIName);
        //Type API contest
        String APIcontest = "api"+caller.generateData("int",2);
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        caller.pause("6000");
        //Type non image path and verify error
        caller.type("APIPublisherAdd.btn_BrowseImage",param_InvalidAPIImagePath);
        //Waiting for content to load
        caller.pause("3000");
        caller.click("APIPublisherBrowse.btn_Save");
        //Waiting for content to load
        caller.pause("6000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblNonImageFileError",false,"");
        //Type valid image path
        caller.type("APIPublisherAdd.btn_BrowseImage",param_APIImagePath);
        for(int i=0;i<15;i++){
        String tag = "tag"+caller.generateData("int",3);
        caller.type("APIPublisherAdd.tf_Tags",tag);
        caller.fireEvent("KEY%key=\n","2000");
        }
        caller.pause("5000");
        //Type URL pattern and resource and did not choose any Verb
        caller.type("APIPublisherAdd.tf_URLPattern",param_URLPattern);
        caller.click("APIPublisherAdd.btn_Add");
        caller.pause("3000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblErrorMessageURLPattern",false,"");
        caller.click("APIPublisherAdd.btn_OkErrorMessage");
        //remove URL and resource
        caller.type("APIPublisherAdd.tf_URLPattern","");
        //click save and verify warning
        caller.pause("5000");
        caller.click("APIPublisherAdd.btn_Save");
        caller.pause("5000");
        caller.checkElementPresent("APIPublisherBrowse.btn_No",false,"");
        caller.click("APIPublisherBrowse.btn_No");
        caller.pause("6000");
        //Remove API Name
        caller.type("APIPublisherAdd.tf_APIName","");
        caller.pause("4000");
        caller.click("APIPublisherAdd.btn_Save");
        caller.pause("2000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblWarningMessageAPIName",false,"");
        //Type API name
        /*
        SetVariable
         name=APIName
         type=String
         paramValue="TestAPI"+caller.generateData("Alphanumeric",2)
        Store
         key=keyApiName
         type=String
         value=@APIName
        */
        caller.type("APIPublisherAdd.tf_APIName",param_APIName);
        //Empty the API context and save
        caller.type("APIPublisherAdd.tf_APIContext","");
        caller.pause("3000");
        caller.click("APIPublisherAdd.btn_Save");
        caller.pause("6000");
        caller.checkElementPresent("APIPublisherAdd.ele_lblWarningMessageAPIContest",false,"");
        caller.type("APIPublisherAdd.tf_APIContext",APIcontest);
        //Empty the API Version and verify error
        caller.type("APIPublisherAdd.tf_APIVersion","");
        caller.click("APIPublisherAdd.btn_Save");
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
    }
    /**
     *  Business component bc_CreateAPI_DesignStage.
     */
    public final static void bc_CreateAPI_DesignStage(final SeleniumTestBase caller, final String param_APIImagePath, final String param_APIVersion, final String param_tagName, final String param_APIName) throws Exception {
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
    }
    /**
     *  Business component be_VerifyAPIDesignStage.
     */
    public final static void be_VerifyAPIDesignStage(final SeleniumTestBase caller, final String param_APIName) throws Exception {
        /*
        SelectWindow
         object=APIPublisherHome.win_DefaultWindow
        */
        caller.checkElementPresent("APIPublisherHome.lnk_Add",false,"");
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        //waiting for content load
        caller.pause("4000");
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        //waiting for content load
        caller.pause("3000");
        //Verify PROTOTYPED and PUBLISHED are not in Drop down
        caller.checkObjectProperty("APIPublisherBrowse.ele_ddState","MISSINGOPTION","PROTOTYPED",false,"");
        caller.checkObjectProperty("APIPublisherBrowse.ele_ddState","MISSINGOPTION","PUBLISHED",false,"");	
    }
    /**
     *  Business component bc_DeployAsPrototype.
     */
    public final static void bc_DeployAsPrototype(final SeleniumTestBase caller, final String param_APIName) throws Exception {
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblPrototype");
        caller.click("APIPublisherBrowse.btn_SavePrototype");
        //Waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_DeployAsPrototype");
        //Waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_OkDeployAsPrototype");
        //Waiting for content load
        caller.pause("3000");
        caller.click("APIPublisherHome.lnk_Browse");
        //Waiting for content load
        caller.pause("2000");	
    }
    /**
     *  Business component bc_AddTiersToAPI.
     */
    public final static void bc_AddTiersToAPI(final SeleniumTestBase caller, final String param_APIName, final String param_ProductionEndPont, final String param_SandBoxEndPont) throws Exception {
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.type("APIPublisherBrowse.tf_ProductionEndPoint",param_ProductionEndPont);
        caller.type("APIPublisherBrowse.tf_SandBoxEndPoint",param_SandBoxEndPont);
        caller.click("APIPublisherBrowse.btn_SaveManagedAPI");
        //waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_NextManage");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        caller.click("APIPublisherBrowse.chk_Unlimited");
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        caller.click("APIPublisherBrowse.chk_Bronze");	
    }
    /**
     *  Business component bc_LogOut_APIPublisher.
     */
    public final static void bc_LogOut_APIPublisher(final SeleniumTestBase caller, final String param_userName) throws Exception {
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_userName);
        caller.click("APIPublisherLogOut.btn_LogOut");
        //waiting for content load
        caller.pause("2000");	
    }
    /**
     *  Business component bc_PrototypeAPI.
     */
    /**
     *  Business component bc_PrototypeAPI.
     */
    public final static void bc_PrototypeAPI(final SeleniumTestBase caller) throws Exception {
        caller.click("APIPublisherBrowse.ele_lblPrototype");
        caller.click("APIPublisherBrowse.btn_SavePrototype");
        //Waiting for content load
        caller.pause("5000");
        caller.click("APIPublisherBrowse.btn_DeployAsPrototype");
        caller.pause("6000");
        caller.click("APIPublisherBrowse.btn_Close");
        /*
        Click
         object=APIPublisherBrowse.btn_OkDeployAsPrototype
        */	
    }
    /**
     *  Business component bc_ManagedAPI.
     */
    public final static void bc_ManagedAPI(final SeleniumTestBase caller, final String param_APIName, final String param_ProductionEndPont, final String param_SandBoxEndpoint) throws Exception {
        caller.pause("8000");
        caller.click("APIPublisherHome.lnk_Browse");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
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
    }
    /**
     *  Business component bc_NavigateToStore.
     */
    public final static void bc_NavigateToStore(final SeleniumTestBase caller, final String param_serverName, final String param_storeURL) throws Exception {
        caller.navigateToURL("<param_storeURL>","param_storeURL_PARAM:" + param_storeURL,"3000");
        //Waiting for content load
        caller.pause("3000");
        caller.click("APIStoreHome.img_APIStoreAvailableServer","param_serverName_PARAM:" + param_serverName);	
    }
    /**
     *  Business component bc_SwitchUser.
     */
    /**
     *  Business component bc_SwitchUser.
     */
    public final static void bc_SwitchUser(final SeleniumTestBase caller) throws Exception {
        caller.switchUser("default");
        caller.fireEvent("KEY%key=alt+F4","2000");
        //Waiting for content load
        caller.pause("3000");	
    }
    /**
     *  Business component bc_EditAPI.
     */
    public final static void bc_EditAPI(final SeleniumTestBase caller, final String param_APIName) throws Exception {
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.lnk_Edit");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblGeneralDetails",false,"");	
    }
    /**
     *  Business component bc_NavigateToPrototypedAPI.
     */
    /**
     *  Business component bc_NavigateToPrototypedAPI.
     */
    public final static void bc_NavigateToPrototypedAPI(final SeleniumTestBase caller) throws Exception {
        caller.click("APIStoreHome.lnk_PrototypedAPIs");
        caller.pause("2000");	
    }
    /**
     *  Business component bc_APIStoreLogin.
     */
    public final static void bc_APIStoreLogin(final SeleniumTestBase caller, final String param_username, final String param_password) throws Exception {
        //Login To API Store
        caller.click("APIStoreHome.lnk_login");
        caller.pause("1000");
        caller.type("APIStoreHome.tf_username",param_username);
        caller.pause("2000");
        caller.type("APIStoreHome.tf_password",param_password);
        caller.pause("2000");
        caller.click("APIStoreHome.btn_login");	
    }
    /**
     *  Business component bc_APIcarbonLogin.
     */
    public final static void bc_APIcarbonLogin(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_carbonURL) throws Exception {
        caller.open("<param_carbonURL>","param_carbonURL_PARAM:" + param_carbonURL,"3000");
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
    }
    /**
     *  Business component bc_CreateCarbonUser.
     */
    public final static void bc_CreateCarbonUser(final SeleniumTestBase caller, final String param_newUserName, final String param_newPassword, final String param_retypePassword, final String param_role) throws Exception {
        caller.click("APICarbonHome.btn_Configure");
        caller.click("APICarbonHome.lnk_UserandRoles");
        caller.click("APICarbonHome.lnk_User");
        caller.click("APICarbonHome.lnk_AddNewUser");
        caller.type("CarbonAddUser.tf_UserName",param_newUserName);
        caller.type("CarbonAddUser.tf_password",param_newPassword);
        caller.type("CarbonAddUser.tf_retypePassword",param_retypePassword);
        caller.click("CarbonAddUser.btn_next");
        caller.pause("2000");
        /*
        If
         expression=caller.checkElementPresent("CarbonAddUser.chk_Role","userRole_PARAM:" + param_role)
         Click
          object=CarbonAddUser.chk_Role
          userRole=@param_role
        EndIf
        */
        caller.click("CarbonAddUser.btn_finish");
        caller.pause("2000");
        caller.click("CarbonAddUser.btn_Ok");	
    }
    /**
     *  Business component bc_APIManageStage.
     */
    /**
     *  Business component bc_APIManageStage.
     */
    public final static void bc_APIManageStage(final SeleniumTestBase caller) throws Exception {
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.click("APIPublisherBrowse.chk_Silver");
        caller.click("APIPublisherBrowse.btn_Save");
        caller.click("APIPublisherBrowse.btn_SaveAndPublish");
        caller.click("APIPublisherBrowse.btn_Close");	
    }
    /**
     *  Business component bc_UserRoleAndAssign.
     */
    public final static void bc_UserRoleAndAssign(final SeleniumTestBase caller, final String param_RoleName, final String param_UserName) throws Exception {
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleName);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create");
        caller.click("CarbonUserRole.chk_Publish");
        caller.click("CarbonUserRole.chk_Subscribe");
        }
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserName);
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_OkPopUp");	
    }
    /**
     *  Business component bc_SelectTiers.
     */
    /**
     *  Business component bc_SelectTiers.
     */
    public final static void bc_SelectTiers(final SeleniumTestBase caller) throws Exception {
        caller.click("APIPublisherBrowse.ele_ddTierAvilability");
        caller.pause("100");
        caller.click("APIPublisherBrowse.chk_Unlimited");
        caller.pause("100");
        caller.click("APIPublisherBrowse.chk_Gold");
        caller.pause("100");
        caller.click("APIPublisherBrowse.chk_Silver");
        caller.pause("100");
        caller.click("APIPublisherBrowse.chk_Bronze");
        caller.pause("100");	
    }
    /**
     *  Business component bc_Select_LifeCycleState.
     */
    public final static void bc_Select_LifeCycleState(final SeleniumTestBase caller, final String param_Stage, final String param_APIName) throws Exception {
        caller.click("APIPublisherHome.lnk_Browse");
        caller.click("APIPublisherBrowse.lnk_APIName","param_APIName_PARAM:" + param_APIName);
        caller.click("APIPublisherBrowse.btn_Lifecycle");
        caller.checkElementPresent("Browse_Lifecycle.ele_ddSelectState",false,"");
        caller.pause("4000");
        caller.select("Browse_Lifecycle.ele_ddSelectState",param_Stage);
        caller.click("Browse_Lifecycle.btn_Update");
        caller.checkElementPresent("Browse_Lifecycle.ele_lblUpdateSuccessMessage",false,"");
        //Wait for content load
        caller.pause("2000");	
    }
    /**
     *  Business component bc_CreateNewVersion_VerifyDetails.
     */
    public final static void bc_CreateNewVersion_VerifyDetails(final SeleniumTestBase caller, final String param_newVersion, final String param_creater, final String param_APIName, final String param_status, final String param_users) throws Exception {
        caller.click("APIPublisherBrowse.lnk_Overview");
        //Wait for content load
        caller.pause("2000");
        caller.click("Browse_Overview.btn_CreateNewVersion");
        //Wait for content load
        caller.pause("2000");
        //Verify Expand the text field
        caller.checkElementPresent("Browse_Overview.tf_ToVersion",false,"");
        caller.type("Browse_Overview.tf_ToVersion",param_newVersion);
        caller.click("Browse_Overview.btn_Done");
        //Wait for content load
        caller.pause("2000");
        //Verify API name version and creator
        caller.checkElementPresent("APIPublisherBrowse.ele_lblVersionAndUser","param_APIName_PARAM:" + param_APIName + "_PARAM," + "param_version_PARAM:" + param_newVersion + "_PARAM," + "param_creater_PARAM:" + param_creater,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblUsers","param_version_PARAM:" + param_newVersion + "_PARAM," + "param_users_PARAM:" + param_users,false,"");
        caller.checkElementPresent("APIPublisherBrowse.ele_lblAPIStatus","param_status_PARAM:" + param_status,false,"");
        //Wait for content load
        caller.pause("2000");	
    }
    /**
     *  Business component bc_LogOut_APIStore.
     */
    public final static void bc_LogOut_APIStore(final SeleniumTestBase caller, final String param_userName) throws Exception {
        caller.pause("2000");
        caller.click("APIPublisherLogOut.btn_UserName","param_userName_PARAM:" + param_userName);
        caller.pause("3000");
        caller.click("APIStoreHome.btn_Logout");
        //waiting for content load
        caller.pause("2000");	
    }
    /**
     *  Business component bc_AddScopes.
     */
    public final static void bc_AddScopes(final SeleniumTestBase caller, final String param_ScopeKey, final String param_ScopeName) throws Exception {
        caller.pause("2000");
        caller.click("Scopes.btn_AddScope");
        caller.type("Scopes.tf_ScopeKey",param_ScopeKey);
        caller.type("Scopes.tf_ScopeName",param_ScopeName);
        caller.pause("4000");
        caller.click("Scopes.btn_SubmitScope");	
    }
    /**
     *  Business component bc_SelectScope.
     */
    public final static void bc_SelectScope(final SeleniumTestBase caller, final String param_verbMethodName, final String param_ScopeName) throws Exception {
        caller.click("Scopes.btn_Scope","param_verbMethodName_PARAM:" + param_verbMethodName);
        caller.select("Scopes.ele_ddScope",param_ScopeName);
        caller.click("Scopes.btn_Right");	
    }
    /**
     *  Business component bc_ImplementStage.
     */
    /**
     *  Business component bc_ImplementStage.
     */
    public final static void bc_ImplementStage(final SeleniumTestBase caller) throws Exception {
        caller.click("APIPublisherBrowse.ele_lblManagedAPI");
        caller.click("APIPublisherBrowse.btn_NextManage");	
    }
    /**
     *  Business component bc_DeleteSubcription.
     */
    public final static void bc_DeleteSubcription(final SeleniumTestBase caller, final String param_APIName, final String param_Version) throws Exception {
        if(!caller.checkElementPresent("APIStoreMySubcription.img_API","APIName_PARAM:" + param_APIName + "_PARAM," + "Version_PARAM:" + param_Version)){
        caller.click("APIStoreMySubcription.ele_lblSubcribedAPIs");
        }
        caller.checkElementPresent("APIStoreMySubcription.img_API","APIName_PARAM:" + param_APIName + "_PARAM," + "Version_PARAM:" + param_Version,false,"");
        caller.click("APIStoreMySubcription.btn_deleteAPI");
        caller.click("APIStoreMySubcription.btn_Yes");
        caller.pause("4000");	
    }
    /**
     *  Business component bc_CreateTennon.
     */
    public final static void bc_CreateTennon(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_Domain, final String param_FirstName, final String param_LastName, final String param_AdminUserName, final String param_AdminPassword, final String param_Email, final String param_carbonURL) throws Exception {
        Common.bc_APIcarbonLogin(caller, param_username,param_password,param_carbonURL);
        //Waiting for content load
        caller.pause("3000");
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
        caller.pause("2000");
        caller.click("APICarbonHome.btn_Save");
        //Waiting for content load
        caller.pause("2000");
        caller.click("APICarbonHome.btn_OkPopUp");
        //Waiting for content load
        caller.pause("3000");
        caller.click("APICarbonHome.lnk_SignOut");
        //Waiting for content load
        caller.pause("2000");
        String tenantAdminName = param_AdminUserName;
        String tenantDomain = param_Domain;
        caller.store("keyTenantAdmin","String",tenantAdminName);
        caller.store("keyDomain","String",tenantDomain);
        String newTenantUsername = tenantAdminName+"@"+tenantDomain;
        caller.store("keynewTenantUsername","String",newTenantUsername);	
    }
    /**
     *  Business component bc_CreateTenant.
     */
    public final static void bc_CreateTenant(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_Domain, final String param_FirstName, final String param_LastName, final String param_AdminUserName, final String param_AdminPassword, final String param_Email, final String param_carbonURL) throws Exception {
        Common.bc_APIcarbonLogin(caller, param_username,param_password,param_carbonURL);
        //Waiting for content load
        caller.pause("3000");
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
        caller.pause("2000");
        caller.click("APICarbonHome.btn_Save");
        //Waiting for content load
        caller.pause("2000");
        caller.click("APICarbonHome.btn_OkPopUp");
        //Waiting for content load
        caller.pause("3000");
        caller.click("APICarbonHome.lnk_SignOut");
        //Waiting for content load
        caller.pause("2000");
        String tenantAdminName = param_AdminUserName;
        String tenantDomain = param_Domain;
        caller.store("keyTenantAdmin","String",tenantAdminName);
        caller.store("keyDomain","String",tenantDomain);
        String newTenantUsername = tenantAdminName+"@"+tenantDomain;
        caller.store("keynewTenantUsername","String",newTenantUsername);	
    }
    /**
     *  Business component bc_CreateUserAndAssignRoles.
     */
    public final static void bc_CreateUserAndAssignRoles(final SeleniumTestBase caller, final String param_username, final String param_password, final String param_newUserName, final String param_retypePassword, final String param_newPassword, final String param_RoleName, final String param_role, final String param_carbonURL) throws Exception {
        Common.bc_APIcarbonLogin(caller, param_username,param_password,param_carbonURL);
        //Waiting for content load
        caller.pause("3000");
        Common.bc_CreateCarbonUser(caller, param_newUserName,param_newPassword,param_retypePassword,param_role);
        //Waiting for content load
        caller.pause("3000");
        Common.bc_UserRoleAndAssign(caller, param_RoleName,param_newUserName);	
    }
    /**
     *  Business component bc_TenantUserRoleAndAssign.
     */
    public final static void bc_TenantUserRoleAndAssign(final SeleniumTestBase caller, final String param_RoleName, final String param_UserName) throws Exception {
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleName);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create1");
        caller.click("CarbonUserRole.chk_Publish1");
        caller.click("CarbonUserRole.chk_Subscribe1");
        }
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("4000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserName);
        //Waiting for content load
        caller.pause("4000");
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_OkPopUp");	
    }
    /**
     *  Business component bc_createSuperUser.
     */
    public final static void bc_createSuperUser(final SeleniumTestBase caller, final String param_RoleName, final String param_usernameAdmin, final String param_passwordAdmin, final String param_carbonURL, final String param_newUserName, final String param_newPassword, final String param_retypePassword, final String param_role, final String param_newUserName1, final String param_newPassword1, final String param_retypePassword1, final String param_RoleName1) throws Exception {
        Common.bc_APIcarbonLogin(caller, param_usernameAdmin,param_passwordAdmin,param_carbonURL);
        //Waiting for content load
        caller.pause("3000");
        //----------------------------------------------------------------API Publisher User Creation------------------------------------------------------------------------------
        Common.bc_CreateCarbonUser(caller, param_newUserName,param_newPassword,param_retypePassword,param_role);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleName);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create");
        caller.click("CarbonUserRole.chk_Publish");
        }
        caller.click("CarbonUserRole.chk_governance");
        caller.pause("500");
        caller.click("CarbonUserRole.chk_govern");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_newUserName);
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_OkPopUp");
        //----------------------------------------------------------------------API Store User Creation---------------------------------------------------------------------------
        caller.pause("3000");
        Common.bc_CreateCarbonUser(caller, param_newUserName1,param_newPassword1,param_retypePassword1,param_role);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleName1);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe");
        }
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_newUserName1);
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.pause("3000");
        caller.click("APICarbonHome.lnk_SignOut");
        caller.pause("3000");	
    }
    /**
     *  Business component bc_CreateSuperUsers.
     */
    public final static void bc_CreateSuperUsers(final SeleniumTestBase caller, final String param_publisherRoleName, final String param_usernameAdmin, final String param_passwordAdmin, final String param_carbonURL, final String param_PublisherUserName, final String param_PublishernewPassword, final String param_retypePublisherPassword, final String param_role, final String param_StoreNewUserName, final String param_StoreNewPassword, final String param_retypeStorePassword, final String param_StoreRoleName) throws Exception {
        Common.bc_APIcarbonLogin(caller, param_usernameAdmin,param_passwordAdmin,param_carbonURL);
        //Waiting for content load
        caller.pause("3000");
        //----------------------------------------------------------------API Publisher User Creation------------------------------------------------------------------------------
        Common.bc_CreateCarbonUser(caller, param_PublisherUserName,param_PublishernewPassword,param_retypePublisherPassword,param_role);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_publisherRoleName);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create");
        caller.click("CarbonUserRole.chk_Publish");
        }
        caller.click("CarbonUserRole.chk_governance");
        caller.pause("500");
        caller.click("CarbonUserRole.chk_govern");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_PublisherUserName);
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_OkPopUp");
        //----------------------------------------------------------------------API Store User Creation---------------------------------------------------------------------------
        caller.pause("3000");
        Common.bc_CreateCarbonUser(caller, param_StoreNewUserName,param_StoreNewPassword,param_StoreNewPassword,param_role);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_StoreRoleName);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_Login");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe");
        }
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_StoreNewUserName);
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_OkPopUp");
        caller.pause("3000");
        caller.click("APICarbonHome.lnk_SignOut");
        caller.pause("3000");	
    }
    /**
     *  Business component bc_createTenantUser.
     */
    public final static void bc_createTenantUser(final SeleniumTestBase caller, final String param_usernameTenant, final String param_passwordTenant, final String param_carbonURL, final String param_newPassword, final String param_retypePassword, final String param_role, final String param_RoleName, final String param_UserName1, final String param_newPassword1, final String param_retypePassword1, final String param_role1, final String param_RoleName1, final String param_UserName2) throws Exception {
        Common.bc_APIcarbonLogin(caller, param_usernameTenant,param_passwordTenant,param_carbonURL);
        //Waiting for content load
        caller.pause("3000");
        //----------------------------------------------------------------API Publisher User Creation------------------------------------------------------------------------------
        Common.bc_CreateCarbonUser(caller, param_UserName1,param_newPassword,param_retypePassword,param_role);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleName);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create1");
        caller.click("CarbonUserRole.chk_Publish1");
        }
        caller.click("CarbonUserRole.chk_governance1");
        caller.pause("500");
        caller.click("CarbonUserRole.chk_govern1");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserName1);
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_OkPopUp");
        //----------------------------------------------------------------------API Store User Creation---------------------------------------------------------------------------
        caller.pause("3000");
        Common.bc_CreateCarbonUser(caller, param_UserName2,param_newPassword1,param_retypePassword1,param_role1);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleName1);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe1");
        }
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserName2);
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_OkPopUp");	
    }
    /**
     *  Business component bc_CreateTenantUsers.
     */
    public final static void bc_CreateTenantUsers(final SeleniumTestBase caller, final String param_usernameTenant, final String param_passwordTenant, final String param_carbonURL, final String param_newPassword, final String param_retypePassword, final String param_role, final String param_RoleNamePublisher, final String param_UserNameCreateAndPublisher, final String param_newPasswordStoreUser, final String param_retypePasswordStoreUser, final String param_role1, final String param_RoleNameSubscriber, final String param_UserNameSubscriber) throws Exception {
        Common.bc_APIcarbonLogin(caller, param_usernameTenant,param_passwordTenant,param_carbonURL);
        //Waiting for content load
        caller.pause("3000");
        //----------------------------------------------------------------API Publisher User Creation------------------------------------------------------------------------------
        Common.bc_CreateCarbonUser(caller, param_UserNameCreateAndPublisher,param_newPassword,param_retypePassword,param_role);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleNamePublisher);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Create1");
        caller.click("CarbonUserRole.chk_Publish1");
        }
        caller.click("CarbonUserRole.chk_governance1");
        caller.pause("500");
        caller.click("CarbonUserRole.chk_govern1");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserNameCreateAndPublisher);
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_OkPopUp");
        //----------------------------------------------------------------------API Store User Creation---------------------------------------------------------------------------
        caller.pause("3000");
        Common.bc_CreateCarbonUser(caller, param_UserNameSubscriber,param_newPasswordStoreUser,param_retypePasswordStoreUser,param_role1);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleNameSubscriber);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe1");
        }
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserNameSubscriber);
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_OkPopUp");	
    }
    /**
     *  Business component bc_DeleteAPI.
     */
    public final static void bc_DeleteAPI(final SeleniumTestBase caller, final String param_APIName, final String param_publisherURL, final String param_tenantUserName, final String param_tenantPassword, final String param_adminUserName, final String param_adminPassword) throws Exception {
        //Delete APIs
        caller.navigateToURL("<param_publisherURL>","param_publisherURL_PARAM:" + param_publisherURL,"4000");
        //Loging as tenant create username
        Common.bc_Login_APIPublisher(caller, param_tenantUserName,param_tenantPassword,param_publisherURL);
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
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_deleteAPI","APIName_PARAM:" + param_APIName);
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Yes");
        caller.pause("2000");
        //logout
        Common.bc_LogOut_APIPublisher(caller, param_tenantUserName);
        //Loging as admin create username
        Common.bc_Login_APIPublisher(caller, param_adminUserName,param_adminPassword,param_publisherURL);
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
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_deleteAPI","APIName_PARAM:" + param_APIName);
        caller.pause("2000");
        caller.click("APIPublisherBrowse.btn_Yes");
        caller.pause("2000");	
    }
    /**
     *  Business component bc_CreateAPIAndPublish.
     */
    public final static void bc_CreateAPIAndPublish(final SeleniumTestBase caller, final String param_publisherUserName, final String param_publisherPassword, final String param_APIName, final String param_APIcontest, final String param_APIVersion, final String param_APIImagePath, final String param_Discription, final String param_ProductionEndPont, final String param_SandBoxEndpoint, final String param_publisherURL, final String param_URLPattern) throws Exception {
        Common.bc_Login_APIPublisher(caller, param_publisherUserName,param_publisherPassword,param_publisherURL);
        caller.pause("2000");
        //CreateAPI upto design Stage
        caller.click("APIPublisherHome.lnk_Add");
        caller.click("APIPublisherAdd.rdo_DesignNewAPI");
        caller.click("APIPublisherAdd.btn_StartCreating");
        //waiting for content load
        caller.pause("2000");
        caller.type("APIPublisherAdd.tf_APIName",param_APIName);
        caller.type("APIPublisherAdd.tf_APIContext",param_APIcontest);
        caller.type("APIPublisherAdd.tf_APIVersion",param_APIVersion);
        //Type valid image path
        caller.type("APIPublisherAdd.btn_BrowseImage",param_APIImagePath);
        caller.type("APIPublisherAdd.tf_Discription",param_Discription);
        //Type API SCope
        String varTagName = "tag"+caller.generateData("String",3);
        caller.type("APIPublisherAdd.tf_Tags",varTagName);
        caller.fireEvent("KEY%key=\n","2000");
        //waiting for content load
        caller.pause("6000");
        //Type URL pattern
        caller.type("APIPublisherAdd.tf_URLPattern",param_URLPattern);
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherAdd.chk_Get");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherAdd.chk_Post");
        //waiting for content load
        caller.pause("2000");
        caller.click("APIPublisherAdd.btn_Add");
        //waiting for content load
        caller.pause("2000");
        //click save and verify warning
        caller.doubleClick("APIPublisherAdd.btn_Save");
        //waiting for content load
        caller.pause("7000");
        caller.click("APIPublisherAdd.lnk_NextImplement");
        //waiting for content load
        caller.pause("4000");
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
        caller.pause("6000");
        caller.click("APIPublisherBrowse.btn_Close");
        caller.pause("4000");
        Common.bc_LogOut_APIPublisher(caller, param_publisherUserName);	
    }
    /**
     *  Business component bc_CreateStoreUser.
     */
    public final static void bc_CreateStoreUser(final SeleniumTestBase caller, final String param_usernameTenant, final String param_passwordTenant, final String param_carbonURL, final String param_UserNameSubscriber, final String param_newPasswordStoreUser, final String param_retypePasswordStoreUser, final String param_role1, final String param_RoleNameSubscriber) throws Exception {
        //loging to carbon and crate store user
        Common.bc_APIcarbonLogin(caller, param_usernameTenant,param_passwordTenant,param_carbonURL);
        //----------------------------------------------------------------------API Store User Creation---------------------------------------------------------------------------
        caller.pause("3000");
        Common.bc_CreateCarbonUser(caller, param_UserNameSubscriber,param_newPasswordStoreUser,param_retypePasswordStoreUser,param_role1);
        //Waiting for content load
        caller.click("APICarbonHome.lnk_UserandRoles");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.lnk_Roles");
        caller.click("CarbonUserRole.lnk_AddNewRole");
        caller.type("CarbonUserRole.tf_RoleName",param_RoleNameSubscriber);
        caller.click("CarbonUserRole.btn_Next");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_Login1");
        if(caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.btn_NextPermissions");
        } else if(!caller.checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
        caller.click("CarbonUserRole.chk_Subscribe1");
        }
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_NextPermissions");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + param_UserNameSubscriber);
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_FinishAddRole");
        //Waiting for content load
        caller.pause("2000");
        caller.click("CarbonUserRole.btn_OkPopUp");	
    }
}
