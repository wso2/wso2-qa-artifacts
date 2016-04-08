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
 *  Class ts_UserCreation implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_UserCreation extends SeleniumTestBase {

    String varTenantOnePublisherUserOne;
    String varTenantOneStoreUserOne;
    String varAdminPublisherUserOne;
    String varAdminStoreUserOne;
    String varServerNameOne;
    String varServerNameCarbonSuper;
    String varTenantOnePublisherOnePassword;
    String varTenantOneStoreUserOnePassword;
    String varAdminPublisherUserOnePassword;
    String varAdminStoreUserOnePassword;
    String varTenantOneRoleNameOneStoreUserOne;
    String varAdminRoleNameOneStoreUserOne;
    String varServerNameTwo;
    String varServerNameThree;
    String varTenantOnePublisherUserTwo;
    String varTenantTwoPublisherUserOne;
    String varTenantThreePublisherUserOne;
    String varTenantOnePublisherTwoPassword;
    String varTenantTwoPublisherOnePassword;
    String varTenantThreePublisherOnePassword;
    String varTenantOneStoreUserTwo;
    String varTenantTwoStoreUserOne;
    String varTenantThreeStoreUserOne;
    String varTenantOneStoreUserTwoPassword;
    String varTenantTwoStoreUserOnePassword;
    String varTenantThreeStoreUserOnePassword;
    String varTenantOneRoleNameOneStoreUserTwo;
    String varTenantTwoRoleNameOneStoreUserOne;
    String varTenantThreeRoleNameOneStoreUserOne;
    String varAdminPublisherUserTwo;
    String varAdminPublisherUserTwoPassword;
    String varAdminStoreUserTwo;
    String varAdminStoreUserTwoPassword;
    String varAdminRoleNameOneStoreUserTwo;
    String varAdminStoreUserThree;
    String varAdminStoreUserThreePassword;
    String varTenantThreeRoleNameOneStoreUserTwo;
    String varTenantThreeStoreUserTwo;
    String varTenantThreeStoreUserTwoPassword;
    String varTenantOneRoleNameThreeStoreUserThree;
    String varTenantOneStoreUserThree;
    String varTenantOneStoreUserThreePassword;
    String varTenantOneRoleNameFourStoreUserFour;
    String varTenantOneStoreUserFour;
    String varTenantOneStoreUserFourPassword;
    String varTenantOneRoleNameFiveStoreUserFive;
    String varTenantOneStoreUserFive;
    String varTenantOneStoreUserFivePassword;
    String varTenantOneStoreUserSix;
    String varTenantOneStoreUserSixPassword;
    String varAdminStoreUserFour;
    String varAdminStoreUserFourPassword;
    String varAdminStoreUserFive;
    String varAdminStoreUserFivePassword;
    String varAdminStoreUserSix;
    String varAdminStoreUserSixPassword;
    String varAdminStoreUserSeven;
    String varAdminStoreUserSevenPassword;
    String varAdminStoreUserFourRoleOne;
    String varAdminStoreUserFiveRoleOne;
    String varAdminStoreUserSixRoleOne;


    /**
     * Data provider for Test case tc_Tenant_Creation.
     * @return data table
     */
    @DataProvider(name = "tc_Tenant_Creation")
    public Object[][] dataTable_tc_Tenant_Creation() {     	
    	return this.getDataTable("TenantCreation","Common");
    }

    /**
     * Data driven test case tc_Tenant_Creation.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Tenant_Creation")
    public final void tc_Tenant_Creation(final String TenantCreation_tenantOneDomainName, final String TenantCreation_tenantOneFirstName, final String TenantCreation_tenantOneLastName, final String TenantCreation_adminUsernameTenantOne, final String TenantCreation_adminPasswordTenantOne, final String TenantCreation_emailAddressTenantDomainOne, final String TenantCreation_tenantTwoDomainName, final String TenantCreation_tenantTwoFirstName, final String TenantCreation_tenantTwoLastName, final String TenantCreation_adminUsernameTenantTwo, final String TenantCreation_adminPasswordTenantTwo, final String TenantCreation_emailAddressTenantDomainTwo, final String TenantCreation_tenantThreeDomainName, final String TenantCreation_tenantThreeFirstName, final String TenantCreation_tenantThreeLastName, final String TenantCreation_adminUsernameTenantThree, final String TenantCreation_adminPasswordTenantThree, final String TenantCreation_emailAddressTenantDomainThree, final String TenantCreation_twoSeconds, final String TenantCreation_fourSeconds, final String TenantCreation_sixSeconds, final String TenantCreation_eightSeconds, final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL) throws Exception {	
    	writeToReport("Start Of Tenant One Creation");
    	//Create primary tennant
    	lib_Common.bc_CreateTenant(this, Common_superAdminUserName,Common_superAdminPassword,TenantCreation_tenantOneFirstName,TenantCreation_tenantOneLastName,TenantCreation_adminUsernameTenantOne,TenantCreation_adminPasswordTenantOne,TenantCreation_emailAddressTenantDomainOne,Common_carbonURL,TenantCreation_tenantOneDomainName,TenantCreation_fourSeconds);
    	//Store tenant one admin user name into variable with domain
    	String varTenantOneAdminUser = TenantCreation_adminUsernameTenantOne+"@"+TenantCreation_tenantOneDomainName;
    	store("keyTenantOneAdminUser","String",varTenantOneAdminUser);
    	//Set variable for tenant user password
    	String varTenantOneAdminUserPassword = TenantCreation_adminPasswordTenantOne;
    	//Store tenant password into variable
    	store("keyTenantOneAdminUserPassword","String",varTenantOneAdminUserPassword);
    	//Globe variable Server name one
    	varServerNameOne = TenantCreation_tenantOneDomainName;
    	//store Globe variable Server name one
    	store("keyServerNameOne","String",varServerNameOne);
    	varServerNameCarbonSuper = "carbon.super";
    	store("keyServerNameCarbonSuper","String",varServerNameCarbonSuper);
    	writeToReport("End Of Tenant One Creation");
    	writeToReport("Start Of Tenant Two Creation");
    	//Create secondary tennant
    	lib_Common.bc_CreateTenant(this, Common_superAdminUserName,Common_superAdminPassword,TenantCreation_tenantTwoFirstName,TenantCreation_tenantTwoLastName,TenantCreation_adminUsernameTenantTwo,TenantCreation_adminPasswordTenantTwo,TenantCreation_emailAddressTenantDomainTwo,Common_carbonURL,TenantCreation_tenantTwoDomainName,TenantCreation_fourSeconds);
    	//Store tenant two admin user name into variable with domain
    	String varTenantTwoAdminUser = TenantCreation_adminUsernameTenantTwo+"@"+TenantCreation_tenantTwoDomainName;
    	store("keyTenantTwoAdminUser","String",varTenantTwoAdminUser);
    	//Set variable for tenant two user password
    	String varTenantTwoAdminUserPassword = TenantCreation_adminPasswordTenantTwo;
    	//Store tenant two password into variable
    	store("keyTenantTwoAdminUserPassword","String",varTenantTwoAdminUserPassword);
    	//Globe variable Server name Two
    	varServerNameTwo = TenantCreation_tenantTwoDomainName;
    	//store Globe variable Server name Two
    	store("keyServerNameTwo","String",varServerNameTwo);
    	writeToReport("End Of Tenant Two Creation");
    	writeToReport("Start Of Tenant Three Creation");
    	//Create tertiary tennant
    	lib_Common.bc_CreateTenant(this, Common_superAdminUserName,Common_superAdminPassword,TenantCreation_tenantThreeFirstName,TenantCreation_tenantThreeLastName,TenantCreation_adminUsernameTenantThree,TenantCreation_adminPasswordTenantThree,TenantCreation_emailAddressTenantDomainThree,Common_carbonURL,TenantCreation_tenantThreeDomainName,TenantCreation_fourSeconds);
    	//Store tenant three admin user name into variable with domain
    	String varTenantThreeAdminUser = TenantCreation_adminUsernameTenantThree+"@"+TenantCreation_tenantThreeDomainName;
    	store("keyTenantThreeAdminUser","String",varTenantThreeAdminUser);
    	//Set variable for tenant three user password
    	String varTenantThreeAdminUserPassword = TenantCreation_adminPasswordTenantThree;
    	//Store tenant three password into variable.
    	store("keyTenantThreeAdminUserPassword","String",varTenantThreeAdminUserPassword);
    	//Globe variable Server name Three
    	varServerNameThree = TenantCreation_tenantThreeDomainName;
    	//store Globe variable Server name Three
    	store("keyServerNameThree","String",varServerNameThree);
    	writeToReport("End Of Tenant Three Creation");
    } 
    	

    /**
     * Data provider for Test case tc_Tenant_UserCreation.
     * @return data table
     */
    @DataProvider(name = "tc_Tenant_UserCreation")
    public Object[][] dataTable_tc_Tenant_UserCreation() {     	
    	return this.getDataTable("TenantCreation","Common","Tenant_UserCreation");
    }

    /**
     * Data driven test case tc_Tenant_UserCreation.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Tenant_UserCreation")
    public final void tc_Tenant_UserCreation(final String TenantCreation_tenantOneDomainName, final String TenantCreation_tenantOneFirstName, final String TenantCreation_tenantOneLastName, final String TenantCreation_adminUsernameTenantOne, final String TenantCreation_adminPasswordTenantOne, final String TenantCreation_emailAddressTenantDomainOne, final String TenantCreation_tenantTwoDomainName, final String TenantCreation_tenantTwoFirstName, final String TenantCreation_tenantTwoLastName, final String TenantCreation_adminUsernameTenantTwo, final String TenantCreation_adminPasswordTenantTwo, final String TenantCreation_emailAddressTenantDomainTwo, final String TenantCreation_tenantThreeDomainName, final String TenantCreation_tenantThreeFirstName, final String TenantCreation_tenantThreeLastName, final String TenantCreation_adminUsernameTenantThree, final String TenantCreation_adminPasswordTenantThree, final String TenantCreation_emailAddressTenantDomainThree, final String TenantCreation_twoSeconds, final String TenantCreation_fourSeconds, final String TenantCreation_sixSeconds, final String TenantCreation_eightSeconds, final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String Tenant_UserCreation_tenantOnePublisherUserNameOne, final String Tenant_UserCreation_tenantOnePublisherUserOnePassword, final String Tenant_UserCreation_tenantOneRoleNameOnePublisherUserOne, final String Tenant_UserCreation_tenantOneStoreUserNameOne, final String Tenant_UserCreation_tenantOneStoreUserOnePassword, final String Tenant_UserCreation_tenantOneRoleNameOneStoreUserOne, final String Tenant_UserCreation_tenantOnePublisherUserNameTwo, final String Tenant_UserCreation_tenantOnePublisherUserTwoPassword, final String Tenant_UserCreation_tenantOneRoleNameOnePublisherUserTwo, final String Tenant_UserCreation_tenantOneStoreUserNameTwo, final String Tenant_UserCreation_tenantOneStoreUserTwoPassword, final String Tenant_UserCreation_tenantOneRoleNameOneStoreUserTwo, final String Tenant_UserCreation_tenantOneRoleNameThreeStoreUserThree, final String Tenant_UserCreation_tenantOneStoreUserNameThree, final String Tenant_UserCreation_tenantOneStoreUserThreePassword, final String Tenant_UserCreation_tenantOneRoleNameFourStoreUserFour, final String Tenant_UserCreation_tenantOneStoreUserNameFour, final String Tenant_UserCreation_tenantOneStoreUserFourPassword, final String Tenant_UserCreation_tenantOneRoleNameFiveStoreUserFive, final String Tenant_UserCreation_tenantOneStoreUserNameFive, final String Tenant_UserCreation_tenantOneStoreUserFivePassword, final String Tenant_UserCreation_tenantOneStoreUserNameSix, final String Tenant_UserCreation_tenantOneStoreUserSixPassword, final String Tenant_UserCreation_tenantTwoPublisherUserNameOne, final String Tenant_UserCreation_tenantTwoPublisherUserOnePassword, final String Tenant_UserCreation_tenantTwoRoleNameOnePublisherUserOne, final String Tenant_UserCreation_tenantTwoStoreUserNameOne, final String Tenant_UserCreation_tenantTwoStoreUserOnePassword, final String Tenant_UserCreation_tenantTwoRoleNameOneStoreUserOne, final String Tenant_UserCreation_tenantThreePublisherUserNameOne, final String Tenant_UserCreation_tenantThreePublisherUserOnePassword, final String Tenant_UserCreation_tenantThreeRoleNameOnePublisherUserOne, final String Tenant_UserCreation_tenantThreeStoreUserNameOne, final String Tenant_UserCreation_tenantThreeStoreUserOnePassword, final String Tenant_UserCreation_tenantThreeRoleNameOneStoreUserOne, final String Tenant_UserCreation_tenantThreeStoreUserNameTwo, final String Tenant_UserCreation_tenantThreeStoreUserTwoPassword, final String Tenant_UserCreation_tenantThreeRoleNameOneStoreUserTwo, final String Tenant_UserCreation_twoSeconds, final String Tenant_UserCreation_fourSeconds, final String Tenant_UserCreation_sixSeconds, final String Tenant_UserCreation_eightSeconds) throws Exception {	
    	//----------------------------------------------------------------------------------------------------------------------------------------T1U1
    	writeToReport("Start Of Tenant One User One Creation And Assign Roles");
    	//Log into Carbon from retrived user name
    	String varTenantOneAdminUserName = retrieveString("keyTenantOneAdminUser");
    	lib_Common.bc_APIcarbonLogin(this, varTenantOneAdminUserName,TenantCreation_adminPasswordTenantOne,Common_carbonURL,TenantCreation_sixSeconds);
    	//Create Tenant User Using creted tenant and  assign roles
    	varTenantOneRoleNameOneStoreUserOne = Tenant_UserCreation_tenantOneRoleNameOneStoreUserOne;
    	//store variable tenant one publisher user one passord
    	store("KeyVisibilityRole","String",varTenantOneRoleNameOneStoreUserOne);
    	String varRoleNameTenant = retrieveString("KeyVisibilityRole");
    	lib_Common.bc_TenantUser_CreateRoles_And_AssignRoles(this, Tenant_UserCreation_tenantOnePublisherUserNameOne,Tenant_UserCreation_tenantOnePublisherUserOnePassword,Tenant_UserCreation_tenantOnePublisherUserOnePassword,Tenant_UserCreation_tenantOneRoleNameOnePublisherUserOne,Tenant_UserCreation_tenantOneStoreUserNameOne,Tenant_UserCreation_tenantOneStoreUserOnePassword,Tenant_UserCreation_tenantOneStoreUserOnePassword,varRoleNameTenant,TenantCreation_twoSeconds,TenantCreation_twoSeconds,TenantCreation_fourSeconds,TenantCreation_sixSeconds);
    	//Globle variable tenant one publisher user one
    	varTenantOnePublisherUserOne = Tenant_UserCreation_tenantOnePublisherUserNameOne+"@"+TenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one publisher user one
    	store("keyTenantOnePublisherUserOne","String",varTenantOnePublisherUserOne);
    	//Globle variable tenant one publisher user one passord
    	varTenantOnePublisherOnePassword = Tenant_UserCreation_tenantOnePublisherUserOnePassword;
    	//store variable tenant one publisher user one passord
    	store("keyTenantOnePublisherOnePassword","String",varTenantOnePublisherOnePassword);
    	//Globle variable tenant one store user one
    	varTenantOneStoreUserOne = Tenant_UserCreation_tenantOneStoreUserNameOne+"@"+TenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user one
    	store("keyTenantOneStoreUserOne","String",varTenantOneStoreUserOne);
    	//Globle variable tenant one store user one password
    	varTenantOneStoreUserOnePassword = Tenant_UserCreation_tenantOneStoreUserOnePassword;
    	//store Globle variable tenant one store user passord
    	store("keyTenantOneStoreUserOnePassword","String",varTenantOneStoreUserOnePassword);
    	writeToReport("End Of Tenant One User One Creation And Assign Roles");
    	writeToReport("Start Of Tenant One User Two Creation And Assign Roles");
    	//----------------------------------------------------------------------------------------------------------------------------------------T1U2
    	//Log into Carbon from retrived user name to create User two
    	String varTenantOneAdminUserNameTwo = retrieveString("keyTenantOneAdminUser");
    	lib_Common.bc_APIcarbonLogin(this, varTenantOneAdminUserNameTwo,TenantCreation_adminPasswordTenantOne,Common_carbonURL,TenantCreation_sixSeconds);
    	//Create Tenant User two Using creted tenant and  assign roles
    	varTenantOneRoleNameOneStoreUserTwo = Tenant_UserCreation_tenantOneRoleNameOneStoreUserTwo;
    	//store variable tenant one publisher user two passord
    	store("KeyVisibilityT1RoleNameOneStoreUserTwo","String",varTenantOneRoleNameOneStoreUserTwo);
    	String varT1RoleNameOneStoreUserTwo = retrieveString("KeyVisibilityT1RoleNameOneStoreUserTwo");
    	lib_Common.bc_TenantUser_CreateRoles_And_AssignRoles_WithManageTierPermission(this, Tenant_UserCreation_tenantOnePublisherUserNameTwo,Tenant_UserCreation_tenantOnePublisherUserTwoPassword,Tenant_UserCreation_tenantOnePublisherUserTwoPassword,Tenant_UserCreation_tenantOneRoleNameOnePublisherUserTwo,Tenant_UserCreation_tenantOneStoreUserNameTwo,Tenant_UserCreation_tenantOneStoreUserTwoPassword,Tenant_UserCreation_tenantOneStoreUserTwoPassword,varT1RoleNameOneStoreUserTwo,TenantCreation_fourSeconds,TenantCreation_sixSeconds);
    	//Globle variable tenant one publisher user two
    	varTenantOnePublisherUserTwo = Tenant_UserCreation_tenantOnePublisherUserNameTwo+"@"+TenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one publisher user two
    	store("keyTenantOnePublisherUserTwo","String",varTenantOnePublisherUserTwo);
    	//Globle variable tenant one publisher user two passord
    	varTenantOnePublisherTwoPassword = Tenant_UserCreation_tenantOnePublisherUserTwoPassword;
    	//store variable tenant one publisher user two passord
    	store("keyTenantOnePublisherTwoPassword","String",varTenantOnePublisherTwoPassword);
    	//Globle variable tenant one store user two
    	varTenantOneStoreUserTwo = Tenant_UserCreation_tenantOneStoreUserNameTwo+"@"+TenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user two
    	store("keyTenantOneStoreUserTwo","String",varTenantOneStoreUserTwo);
    	//Globle variable tenant one store user two password
    	varTenantOneStoreUserTwoPassword = Tenant_UserCreation_tenantOneStoreUserTwoPassword;
    	//store Globle variable tenant one store user two password
    	store("keyTenantOneStoreUserTwoPassword","String",varTenantOneStoreUserTwoPassword);
    	writeToReport("End Of Tenant One User Two Creation And Assign Roles");
    	//************************* Start of creation of  T1  store user three and role 3
    	//----------------------------------------------------------------------API Store Normal User Creation---------------------------------------------------------------------------
    	writeToReport("Start Of Tenant One User Three Creation And Assign Roles");
    	//Create Store User Three Using created tenant One and assign roles
    	varTenantOneRoleNameThreeStoreUserThree = Tenant_UserCreation_tenantOneRoleNameThreeStoreUserThree;
    	//store variable tenant one store user three password
    	store("KeyVisibilityT1RoleNameThreeStoreUserThree","String",varTenantOneRoleNameThreeStoreUserThree);
    	String varT1RoleNameThreeStoreUserThree = retrieveString("KeyVisibilityT1RoleNameThreeStoreUserThree");
    	waitForElement("APICarbonHome.btn_Configure",TenantCreation_fourSeconds);
    	lib_Common.bc_Create_Carbon_User(this, Tenant_UserCreation_tenantOneStoreUserNameThree,Tenant_UserCreation_tenantOneStoreUserThreePassword,Tenant_UserCreation_tenantOneStoreUserThreePassword,TenantCreation_fourSeconds);
    	//Waiting for content load
    	click("APICarbonHome.lnk_UserandRoles");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.lnk_Roles",TenantCreation_fourSeconds);
    	click("CarbonUserRole.lnk_Roles");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",TenantCreation_fourSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",TenantCreation_fourSeconds);
    	type("CarbonUserRole.tf_RoleName",varT1RoleNameThreeStoreUserThree);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",TenantCreation_fourSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.chk_Subscribe1");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantOneStoreUserNameThree,TenantCreation_eightSeconds);
    	//Click the tenent one store user three username
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantOneStoreUserNameThree);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//Waiting for content load
    	//--------------------------Store global variables to tenant one store user three
    	//Globle variable tenant One store user Three
    	varTenantOneStoreUserThree = Tenant_UserCreation_tenantOneStoreUserNameThree+"@"+TenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user three
    	store("keyTenantOneStoreUserThree","String",varTenantOneStoreUserThree);
    	//Globle variable tenant one store user Three password
    	varTenantOneStoreUserThreePassword = Tenant_UserCreation_tenantOneStoreUserThreePassword;
    	//store Globle variable tenant one store user three passord
    	store("keyTenantOneStoreUserThreePassword","String",varTenantOneStoreUserThreePassword);
    	writeToReport("End Of Tenant One User Three Creation And Assign Roles");
    	//************************* End of creation of  T1  store user and role 3
    	//************************* Start of creation of T1  store user and role 4
    	//----------------------------------------------------------------------API Store Normal User Creation---------------------------------------------------------------------------
    	writeToReport("Start Of Tenant One User Four Creation And Assign Roles");
    	//Create Store User Four Using created tenant One and assign roles
    	varTenantOneRoleNameFourStoreUserFour = Tenant_UserCreation_tenantOneRoleNameFourStoreUserFour;
    	//store variable tenant one store user four password
    	store("KeyVisibilityT1RoleNameFourStoreUserFour","String",varTenantOneRoleNameFourStoreUserFour);
    	String varT1RoleNameFourStoreUserFour = retrieveString("KeyVisibilityT1RoleNameFourStoreUserFour");
    	waitForElement("APICarbonHome.btn_Configure",TenantCreation_eightSeconds);
    	lib_Common.bc_Create_Carbon_User(this, Tenant_UserCreation_tenantOneStoreUserNameFour,Tenant_UserCreation_tenantOneStoreUserFourPassword,Tenant_UserCreation_tenantOneStoreUserFourPassword,TenantCreation_fourSeconds);
    	//Waiting for content load
    	click("APICarbonHome.lnk_UserandRoles");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.lnk_Roles",TenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_Roles");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",TenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",TenantCreation_eightSeconds);
    	type("CarbonUserRole.tf_RoleName",varT1RoleNameFourStoreUserFour);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",TenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.chk_Subscribe1");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantOneStoreUserNameFour,TenantCreation_eightSeconds);
    	//Click the tenent one store user three username
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantOneStoreUserNameFour);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//Waiting for content load
    	//--------------------------Store global variables to tenant one store user four
    	//Globle variable tenant One store user Four
    	varTenantOneStoreUserFour = Tenant_UserCreation_tenantOneStoreUserNameFour+"@"+TenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user four
    	store("keyTenantOneStoreUserFour","String",varTenantOneStoreUserFour);
    	//Globle variable tenant one store user Four password
    	varTenantOneStoreUserFourPassword = Tenant_UserCreation_tenantOneStoreUserFourPassword;
    	//store Globle variable tenant one store user four password
    	store("keyTenantOneStoreUserFourPassword","String",varTenantOneStoreUserFourPassword);
    	writeToReport("End Of Tenant One User Four Creation And Assign Roles");
    	//************************* End of creation of  T1  store user and role 4
    	//************************* Start of creation of T1  store user and role 5
    	//----------------------------------------------------------------------API Store Normal User Creation---------------------------------------------------------------------------
    	writeToReport("Start Of Tenant One User Five Creation And Assign Roles");
    	//Create Store User Five Using created tenant One and assign roles
    	varTenantOneRoleNameFiveStoreUserFive = Tenant_UserCreation_tenantOneRoleNameFiveStoreUserFive;
    	//store variable tenant one store user five password
    	store("KeyVisibilityT1RoleNameFiveStoreUserFive","String",varTenantOneRoleNameFiveStoreUserFive);
    	String varT1RoleNameFiveStoreUserFive = retrieveString("KeyVisibilityT1RoleNameFiveStoreUserFive");
    	waitForElement("APICarbonHome.btn_Configure",TenantCreation_eightSeconds);
    	lib_Common.bc_Create_Carbon_User(this, Tenant_UserCreation_tenantOneStoreUserNameFive,Tenant_UserCreation_tenantOneStoreUserFivePassword,Tenant_UserCreation_tenantOneStoreUserFivePassword,TenantCreation_fourSeconds);
    	//Waiting for content load
    	click("APICarbonHome.lnk_UserandRoles");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.lnk_Roles",TenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_Roles");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",TenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",TenantCreation_eightSeconds);
    	type("CarbonUserRole.tf_RoleName",varT1RoleNameFiveStoreUserFive);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",TenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.chk_Subscribe1");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantOneStoreUserNameFive,TenantCreation_eightSeconds);
    	//Click the tenent one store user five username
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantOneStoreUserNameFive);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//Waiting for content load
    	//--------------------------Store global variables to tenant one store user five
    	//Globle variable tenant One store user Five
    	varTenantOneStoreUserFive = Tenant_UserCreation_tenantOneStoreUserNameFive+"@"+TenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user five
    	store("keyTenantOneStoreUserFive","String",varTenantOneStoreUserFive);
    	//Globle variable tenant one store user Five password
    	varTenantOneStoreUserFivePassword = Tenant_UserCreation_tenantOneStoreUserFivePassword;
    	//store Globle variable tenant one store user five password
    	store("keyTenantOneStoreUserFivePassword","String",varTenantOneStoreUserFivePassword);
    	writeToReport("End Of Tenant One User Five Creation And Assign Roles");
    	//************************* End of creation of  T1  store user five and role 5
    	//************************* Start of creation of T1  store user six and role 1,2,3,4,5
    	//----------------------------------------------------------------------API Store Normal User Creation---------------------------------------------------------------------------
    	writeToReport("Start Of Tenant One User Six Creation And Assign Roles");
    	//Create Store User Six Using created tenant One and assign roles
    	waitForElement("APICarbonHome.btn_Configure",TenantCreation_eightSeconds);
    	//Create Carbon user from Tenant User
    	writeToReport("Start of Create_Carbon_User");
    	//Click on Configure
    	click("APICarbonHome.btn_Configure");
    	waitForElement("APICarbonHome.lnk_UserandRoles",TenantCreation_eightSeconds);
    	//Click User and Roles
    	click("APICarbonHome.lnk_UserandRoles");
    	waitForElement("APICarbonHome.lnk_User",TenantCreation_eightSeconds);
    	//Click User
    	click("APICarbonHome.lnk_User");
    	waitForElement("APICarbonHome.lnk_AddNewUser",TenantCreation_eightSeconds);
    	click("APICarbonHome.lnk_AddNewUser");
    	//Type new Tenant creating Username
    	type("CarbonAddUser.tf_UserName",Tenant_UserCreation_tenantOneStoreUserNameSix);
    	//Type new Tenant creating password
    	type("CarbonAddUser.tf_password",Tenant_UserCreation_tenantOneStoreUserSixPassword);
    	//Re type new Tenant creating password
    	type("CarbonAddUser.tf_retypePassword",Tenant_UserCreation_tenantOneStoreUserSixPassword);
    	//Click on Next
    	click("CarbonAddUser.btn_next");
    	if(checkElementPresent("CarbonAddUser.ele_LblUserCreationFailedPopup")){
    	fail("User Creation Failed Please Re-run With Valid Fied Names");
    	}
    	//Wait for content load
    	waitForElement("CarbonAddUser.chk_Role","userRole_PARAM:" + varTenantOneRoleNameOneStoreUserOne,TenantCreation_eightSeconds);
    	//adding role1
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + varTenantOneRoleNameOneStoreUserOne);
    	//adding role2
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + varTenantOneRoleNameOneStoreUserTwo);
    	//adding role3
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + varTenantOneRoleNameThreeStoreUserThree);
    	//adding role4
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + varTenantOneRoleNameFourStoreUserFour);
    	//adding role5
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + varTenantOneRoleNameFiveStoreUserFive);
    	//wait for content load
    	waitForElement("CarbonAddUser.btn_finish",TenantCreation_eightSeconds);
    	click("CarbonAddUser.btn_finish");
    	//wait for content load
    	waitForElement("CarbonAddUser.btn_Ok",TenantCreation_eightSeconds);
    	click("CarbonAddUser.btn_Ok");
    	writeToReport("End of BC Create_Carbon_User");
    	//--------------------------Store global variables to tenant one store user five
    	//Globle variable tenant One store user Five
    	varTenantOneStoreUserSix = Tenant_UserCreation_tenantOneStoreUserNameSix+"@"+TenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user six
    	store("keyTenantOneStoreUserSix","String",varTenantOneStoreUserSix);
    	//Globle variable tenant one store user Six password
    	varTenantOneStoreUserSixPassword = Tenant_UserCreation_tenantOneStoreUserSixPassword;
    	//store Globle variable tenant one store user six password
    	store("keyTenantOneStoreUserSixPassword","String",varTenantOneStoreUserSixPassword);
    	writeToReport("End Of Tenant One User Five Creation And Assign Roles");
    	//************************* End of creation of  T1  store user six and role 1,2,3,4,5
    	writeToReport("Start Of Tenant Two User One Creation And Assign Roles");
    	//----------------------------------------------------------------------------------------------------------------------------------------T2U1
    	//Log into Carbon from retrived user name
    	String varTenantTwoAdminUserName = retrieveString("keyTenantTwoAdminUser");
    	lib_Common.bc_APIcarbonLogin(this, varTenantTwoAdminUserName,TenantCreation_adminPasswordTenantTwo,Common_carbonURL,TenantCreation_eightSeconds);
    	//Create Tenant User One Using creted tenant Two and  assign roles
    	varTenantTwoRoleNameOneStoreUserOne = Tenant_UserCreation_tenantTwoRoleNameOneStoreUserOne;
    	//store variable tenant two publisher user one passord
    	store("KeyVisibilityT2RoleNameOneStoreUserOne","String",varTenantTwoRoleNameOneStoreUserOne);
    	String varT2RoleNameOneStoreUserOne = retrieveString("KeyVisibilityT2RoleNameOneStoreUserOne");
    	lib_Common.bc_TenantUser_CreateRoles_And_AssignRoles(this, Tenant_UserCreation_tenantTwoPublisherUserNameOne,Tenant_UserCreation_tenantTwoPublisherUserOnePassword,Tenant_UserCreation_tenantTwoPublisherUserOnePassword,Tenant_UserCreation_tenantTwoRoleNameOnePublisherUserOne,Tenant_UserCreation_tenantTwoStoreUserNameOne,Tenant_UserCreation_tenantTwoStoreUserOnePassword,Tenant_UserCreation_tenantTwoStoreUserOnePassword,varT2RoleNameOneStoreUserOne,TenantCreation_twoSeconds,TenantCreation_twoSeconds,TenantCreation_fourSeconds,TenantCreation_fourSeconds);
    	//Globle variable tenant two publisher user one
    	varTenantTwoPublisherUserOne = Tenant_UserCreation_tenantTwoPublisherUserNameOne+"@"+TenantCreation_tenantTwoDomainName;
    	//store Globle variable tenant two publisher user one
    	store("keyTenantTwoPublisherUserOne","String",varTenantTwoPublisherUserOne);
    	//Globle variable tenant two publisher user one passord
    	varTenantTwoPublisherOnePassword = Tenant_UserCreation_tenantTwoPublisherUserOnePassword;
    	//store variable tenant two publisher user one passord
    	store("keyTenantTwoPublisherOnePassword","String",varTenantTwoPublisherOnePassword);
    	//Globle variable tenant two store user one
    	varTenantTwoStoreUserOne = Tenant_UserCreation_tenantTwoStoreUserNameOne+"@"+TenantCreation_tenantTwoDomainName;
    	//store Globle variable tenant two store user one
    	store("keyTenantTwoStoreUserOne","String",varTenantTwoStoreUserOne);
    	//Globle variable tenant two store user one password
    	varTenantTwoStoreUserOnePassword = Tenant_UserCreation_tenantTwoStoreUserOnePassword;
    	//store Globle variable tenant two store user passord
    	store("keyTenantTwoStoreUserOnePassword","String",varTenantTwoStoreUserOnePassword);
    	writeToReport("End Of Tenant Two User One Creation And Assign Roles");
    	writeToReport("Start Of Tenant Three User One Creation And Assign Roles");
    	//----------------------------------------------------------------------------------------------------------------------------------------T3U1(Including A Special Store Role And A Normal Store Role)
    	//Log into Carbon from retrived user name
    	String varTenantThreeAdminUserName = retrieveString("keyTenantThreeAdminUser");
    	lib_Common.bc_APIcarbonLogin(this, varTenantThreeAdminUserName,TenantCreation_adminPasswordTenantThree,Common_carbonURL,TenantCreation_sixSeconds);
    	//Create Tenant User One Using creted tenant three and assign roles
    	varTenantThreeRoleNameOneStoreUserOne = Tenant_UserCreation_tenantThreeRoleNameOneStoreUserOne;
    	//store variable tenant three publisher user one passord
    	store("KeyVisibilityT3RoleNameOneStoreUserOne","String",varTenantThreeRoleNameOneStoreUserOne);
    	String varT3RoleNameOneStoreUserOne = retrieveString("KeyVisibilityT3RoleNameOneStoreUserOne");
    	//----------------------------------------------------------------API Publisher User Creation------------------------------------------------------------------------------
    	lib_Common.bc_Create_Carbon_User(this, Tenant_UserCreation_tenantThreePublisherUserNameOne,Tenant_UserCreation_tenantThreePublisherUserOnePassword,Tenant_UserCreation_tenantThreePublisherUserOnePassword,TenantCreation_fourSeconds);
    	//Waiting for content load
    	click("APICarbonHome.lnk_UserandRoles");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.lnk_Roles",TenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_Roles");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",TenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",TenantCreation_eightSeconds);
    	//Create role for publisher
    	type("CarbonUserRole.tf_RoleName",Tenant_UserCreation_tenantThreeRoleNameOnePublisherUserOne);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",TenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	//Click Check box create
    	click("CarbonUserRole.chk_Create1");
    	//Click Check box publish
    	click("CarbonUserRole.chk_Publish1");
    	}
    	//Click Check box Governance
    	click("CarbonUserRole.chk_governance1");
    	waitForElement("CarbonUserRole.chk_govern1",TenantCreation_eightSeconds);
    	//Click Check box govern
    	click("CarbonUserRole.chk_govern1");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_NextPermissions",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantThreePublisherUserNameOne,TenantCreation_eightSeconds);
    	//Check the username created in previously
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantThreePublisherUserNameOne);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//----------------------------------------------------------------------API Store Special User Creation---------------------------------------------------------------------------
    	waitForElement("APICarbonHome.btn_Configure",TenantCreation_eightSeconds);
    	lib_Common.bc_Create_Carbon_User(this, Tenant_UserCreation_tenantThreeStoreUserNameOne,Tenant_UserCreation_tenantThreeStoreUserOnePassword,Tenant_UserCreation_tenantThreeStoreUserOnePassword,TenantCreation_fourSeconds);
    	//Waiting for content load
    	click("APICarbonHome.lnk_UserandRoles");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.lnk_Roles",TenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_Roles");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",TenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",TenantCreation_eightSeconds);
    	type("CarbonUserRole.tf_RoleName",varT3RoleNameOneStoreUserOne);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",TenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	/*
    	Click
    	  object=CarbonUserRole.chk_Subscribe1
    	*/
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantThreeStoreUserNameOne,TenantCreation_eightSeconds);
    	//
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantThreeStoreUserNameOne);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//----------------------------------------------------------------------API Store Normal User Creation---------------------------------------------------------------------------
    	//Create Tenant User Two Using created tenant three and assign roles
    	varTenantThreeRoleNameOneStoreUserTwo = Tenant_UserCreation_tenantThreeRoleNameOneStoreUserTwo;
    	//store variable tenant three publisher user Two passord
    	store("KeyVisibilityT3RoleNameOneStoreUserTwo","String",varTenantThreeRoleNameOneStoreUserTwo);
    	String varT3RoleNameOneStoreUserTwo = retrieveString("KeyVisibilityT3RoleNameOneStoreUserTwo");
    	waitForElement("APICarbonHome.btn_Configure",TenantCreation_eightSeconds);
    	lib_Common.bc_Create_Carbon_User(this, Tenant_UserCreation_tenantThreeStoreUserNameTwo,Tenant_UserCreation_tenantThreeStoreUserTwoPassword,Tenant_UserCreation_tenantThreeStoreUserTwoPassword,TenantCreation_fourSeconds);
    	//Waiting for content load
    	waitForElement("APICarbonHome.lnk_UserandRoles",TenantCreation_eightSeconds);
    	click("APICarbonHome.lnk_UserandRoles");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.lnk_Roles",TenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_Roles");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",TenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",TenantCreation_eightSeconds);
    	type("CarbonUserRole.tf_RoleName",varT3RoleNameOneStoreUserTwo);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",TenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.chk_Subscribe1",TenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Subscribe1");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantThreeStoreUserNameTwo,TenantCreation_eightSeconds);
    	//Click the tenent three store user two username
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Tenant_UserCreation_tenantThreeStoreUserNameTwo);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",TenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	writeToReport("End Of Tenant Three User One Creation And Assign Roles");
    	//---------------------------------------------------------------------------------------------------------------------------------------------------
    	//Globle variable tenant three publisher user one
    	varTenantThreePublisherUserOne = Tenant_UserCreation_tenantThreePublisherUserNameOne+"@"+TenantCreation_tenantThreeDomainName;
    	//store Globle variable tenant three publisher user one
    	store("keyTenantThreePublisherUserOne","String",varTenantThreePublisherUserOne);
    	//Globle variable tenant three publisher user one passord
    	varTenantThreePublisherOnePassword = Tenant_UserCreation_tenantThreePublisherUserOnePassword;
    	//store variable tenant three publisher user one passord
    	store("keyTenantThreePublisherOnePassword","String",varTenantThreePublisherOnePassword);
    	//Globle variable tenant three store user one SPECIAL
    	varTenantThreeStoreUserOne = Tenant_UserCreation_tenantThreeStoreUserNameOne+"@"+TenantCreation_tenantThreeDomainName;
    	//store Globle variable tenant three store user one
    	store("keyTenantThreeStoreUserOne","String",varTenantThreeStoreUserOne);
    	//Globle variable tenant three store user one password
    	varTenantThreeStoreUserOnePassword = Tenant_UserCreation_tenantThreeStoreUserOnePassword;
    	//store Globle variable tenant three store user One passord
    	store("keyTenantThreeStoreUserOnePassword","String",varTenantThreeStoreUserOnePassword);
    	//Globle variable tenant three store user Two
    	varTenantThreeStoreUserTwo = Tenant_UserCreation_tenantThreeStoreUserNameTwo+"@"+TenantCreation_tenantThreeDomainName;
    	//store Globle variable tenant three store user Two
    	store("keyTenantThreeStoreUserTwo","String",varTenantThreeStoreUserTwo);
    	//Globle variable tenant three store user Two password
    	varTenantThreeStoreUserTwoPassword = Tenant_UserCreation_tenantThreeStoreUserTwoPassword;
    	//store Globle variable tenant three store user Two passord
    	store("keyTenantThreeStoreUserTwoPassword","String",varTenantThreeStoreUserTwoPassword);
    } 
    	

    /**
     * Data provider for Test case tc_Admin_UserCreation.
     * @return data table
     */
    @DataProvider(name = "tc_Admin_UserCreation")
    public Object[][] dataTable_tc_Admin_UserCreation() {     	
    	return this.getDataTable("Common","Admin_UserCreation");
    }

    /**
     * Data driven test case tc_Admin_UserCreation.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Admin_UserCreation")
    public final void tc_Admin_UserCreation(final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String Admin_UserCreation_adminPublisherUserNameOne, final String Admin_UserCreation_adminPublisherUserOnePassword, final String Admin_UserCreation_adminRoleNameOnePublisherUserOne, final String Admin_UserCreation_adminStoreUserNameOne, final String Admin_UserCreation_adminStoreUserOnePassword, final String Admin_UserCreation_adminRoleNameOneStoreUserOne, final String Admin_UserCreation_adminPublisherUserNameTwo, final String Admin_UserCreation_adminPublisherUserTwoPassword, final String Admin_UserCreation_adminRoleNameOnePublisherUserTwo, final String Admin_UserCreation_adminStoreUserNameTwo, final String Admin_UserCreation_adminStoreUserTwoPassword, final String Admin_UserCreation_adminRoleNameOneStoreUserTwo, final String Admin_UserCreation_adminRoleNameSpecialStoreOne, final String Admin_UserCreation_adminStoreUserNameThree, final String Admin_UserCreation_adminStoreUserThreePassword, final String Admin_UserCreation_adminStoreUserNameFour, final String Admin_UserCreation_adminStoreUserFourPassword, final String Admin_UserCreation_storeRoleNameFour, final String Admin_UserCreation_adminStoreUserNameFive, final String Admin_UserCreation_adminStoreUserFivePassword, final String Admin_UserCreation_storeRoleNameFive, final String Admin_UserCreation_adminStoreUserNameSix, final String Admin_UserCreation_adminStoreUserSixPassword, final String Admin_UserCreation_storeRoleNameSix, final String Admin_UserCreation_adminStoreUserNameSeven, final String Admin_UserCreation_adminStoreUserSevenPassword, final String Admin_UserCreation_twoSeconds, final String Admin_UserCreation_fourSeconds, final String Admin_UserCreation_sixSeconds, final String Admin_UserCreation_eightSeconds) throws Exception {	
    	//Admin User one
    	writeToReport("Start Of Admin User Creation One With Special Store User");
    	//Log into Carbon
    	lib_Common.bc_APIcarbonLogin(this, Common_superAdminUserName,Common_superAdminPassword,Common_carbonURL,Admin_UserCreation_sixSeconds);
    	//Create Admin User And Assign role
    	varAdminRoleNameOneStoreUserOne = Admin_UserCreation_adminRoleNameOneStoreUserOne;
    	//store variable tenant one publisher user one passord
    	store("KeyVisibilityRoleAdmin","String",varAdminRoleNameOneStoreUserOne);
    	String varRoleNameAdmin = retrieveString("KeyVisibilityRoleAdmin");
    	//In below the the roles are created and assigned to users except SPECIAL store where only the role is created
    	lib_Common.bc_AdminUser_CreateRoles_And_AssignRoles(this, Admin_UserCreation_adminPublisherUserNameOne,Admin_UserCreation_adminPublisherUserOnePassword,Admin_UserCreation_adminPublisherUserOnePassword,Admin_UserCreation_adminRoleNameOnePublisherUserOne,Admin_UserCreation_adminStoreUserNameOne,Admin_UserCreation_adminStoreUserOnePassword,Admin_UserCreation_adminStoreUserOnePassword,varRoleNameAdmin,Admin_UserCreation_adminRoleNameSpecialStoreOne,"yes",Admin_UserCreation_fourSeconds,Admin_UserCreation_sixSeconds);
    	//Globle variable  publisher user of admin
    	varAdminPublisherUserOne = Admin_UserCreation_adminPublisherUserNameOne;
    	//store Globle variable  publisher user of admin
    	store("keyAdminPublisherUserOne","String",varAdminPublisherUserOne);
    	//Globle variable  publisher user of admin password
    	varAdminPublisherUserOnePassword = Admin_UserCreation_adminPublisherUserOnePassword;
    	store("keyAdminPublisherUserOnePassword","String",varAdminPublisherUserOnePassword);
    	//Globle variable  store user of admin
    	varAdminStoreUserOne = Admin_UserCreation_adminStoreUserNameOne;
    	//store Globle variable  store user of admin
    	store("keyAdminStoreUserOne","String",varAdminStoreUserOne);
    	varAdminStoreUserOnePassword = Admin_UserCreation_adminStoreUserOnePassword;
    	store("keyAdminStoreUserOnePassword","String",Admin_UserCreation_adminStoreUserOnePassword);
    	writeToReport("End Of Admin User Creation One");
    	writeToReport("Start Of Admin User Creation Two Without Special Store User");
    	//Admin User 2
    	//Log into Carbon
    	lib_Common.bc_APIcarbonLogin(this, Common_superAdminUserName,Common_superAdminPassword,Common_carbonURL,Admin_UserCreation_sixSeconds);
    	//Create Admin User And Assign role
    	varAdminRoleNameOneStoreUserTwo = Admin_UserCreation_adminRoleNameOneStoreUserTwo;
    	//store variable tenant one publisher user two password
    	store("KeyVisibilityRoleAdminUserTwo","String",varAdminRoleNameOneStoreUserTwo);
    	String varRoleNameAdminUserTwo = retrieveString("KeyVisibilityRoleAdminUserTwo");
    	lib_Common.bc_AdminUser_CreateRoles_And_AssignRoles_WithManageTierPermission(this, Admin_UserCreation_adminPublisherUserNameTwo,Admin_UserCreation_adminPublisherUserTwoPassword,Admin_UserCreation_adminPublisherUserTwoPassword,Admin_UserCreation_adminRoleNameOnePublisherUserTwo,Admin_UserCreation_adminStoreUserNameTwo,Admin_UserCreation_adminStoreUserTwoPassword,Admin_UserCreation_adminStoreUserTwoPassword,varRoleNameAdminUserTwo,"","no",Admin_UserCreation_sixSeconds,Admin_UserCreation_eightSeconds);
    	/*
    	Call
    	 businessComponent=lib_Common.bc_AdminUser_CreateRoles_And_AssignRoles
    	 param_SuperAdminPublisherUserName=@Admin_UserCreation_adminPublisherUserNameTwo
    	 param_SuperAdminPublisherUserPassword=@Admin_UserCreation_adminPublisherUserTwoPassword
    	 param_retypeSuperAdminPublisherPassword=@Admin_UserCreation_adminPublisherUserTwoPassword
    	 param_PublisherRoleName=@Admin_UserCreation_adminRoleNameOnePublisherUserTwo
    	 param_SuperAdminStoreUserName=@Admin_UserCreation_adminStoreUserNameTwo
    	 param_SuperAdminStoreUserPassword=@Admin_UserCreation_adminStoreUserTwoPassword
    	 param_retypeSuperAdminStorePassword=@Admin_UserCreation_adminStoreUserTwoPassword
    	 param_StoreRoleName=@varRoleNameAdminUserTwo
    	 param_StoreRoleNameSpecialOne=
    	 param_IsThereASuperStoreUser=no
    	*/
    	//The below BC should be used only after creating a specific role for first user and be called for publisher and store seperately.
    	//In the below BC make sure that the ROLE name is given properly
    	/*
    	Call
    	 businessComponent=lib_Common.bc_AdminUser_AssignCreatedRolesToUser
    	 param_IsPublisherCondition=yes
    	 param_RoleNameStore=
    	 param_SuperAdminStoreUserName=
    	 param_SuperAdminStoreUserPassword=
    	 param_retypeSuperAdminStorePassword=
    	 param_RoleNamePublisher=@Admin_UserCreation_adminRoleNameOnePublisherUserOne
    	 param_SuperAdminPublisherUserName=@Admin_UserCreation_adminPublisherUserNameTwo
    	 param_SuperAdminPublisherUserPassword=@Admin_UserCreation_adminPublisherUserTwoPassword
    	 param_retypeSuperAdminPublisherPassword=@Admin_UserCreation_adminPublisherUserTwoPassword
    	//Log into Carbon
    	Call
    	 businessComponent=lib_Common.bc_APIcarbonLogin
    	 param_username=@Common_superAdminUserName
    	 param_password=@Common_superAdminPassword
    	 param_carbonURL=@Common_carbonURL
    	//In below the role name is changed to User two due to test case requirements
    	Call
    	 businessComponent=lib_Common.bc_AdminUser_AssignCreatedRolesToUser
    	 param_IsPublisherCondition=no
    	 param_RoleNameStore=@Admin_UserCreation_adminRoleNameOneStoreUserTwo
    	 param_SuperAdminStoreUserName=@Admin_UserCreation_adminStoreUserNameTwo
    	 param_SuperAdminStoreUserPassword=@Admin_UserCreation_adminStoreUserTwoPassword
    	 param_retypeSuperAdminStorePassword=@Admin_UserCreation_adminStoreUserTwoPassword
    	 param_RoleNamePublisher=
    	 param_SuperAdminPublisherUserName=
    	 param_SuperAdminPublisherUserPassword=
    	 param_retypeSuperAdminPublisherPassword=
    	*/
    	writeToReport("End Of Admin User Creation Two");
    	writeToReport("Start Of Assigning Special Store Role to Specific User");
    	//Log into Carbon
    	lib_Common.bc_APIcarbonLogin(this, Common_superAdminUserName,Common_superAdminPassword,Common_carbonURL,Admin_UserCreation_sixSeconds);
    	//------------------------------------------------------------------------------- Admin Store User With No Subscription permision
    	//Here role name created for SPECIAL store is assigned user which was created in bc_AdminUser_CreateRoles_And_AssignRoles
    	lib_Common.bc_AdminUser_AssignCreatedRolesToUser(this, "no",Admin_UserCreation_adminRoleNameSpecialStoreOne,Admin_UserCreation_adminStoreUserNameThree,Admin_UserCreation_adminStoreUserThreePassword,Admin_UserCreation_adminStoreUserThreePassword,"","","","",Admin_UserCreation_fourSeconds,Admin_UserCreation_sixSeconds,Admin_UserCreation_sixSeconds,Admin_UserCreation_eightSeconds);
    	writeToReport("End Of Assigning Special Store Role to Specific User");
    	//Globle variable  publisher user two of admin
    	varAdminPublisherUserTwo = Admin_UserCreation_adminPublisherUserNameTwo;
    	//store Globle variable  publisher user two of admin
    	store("keyAdminPublisherUserTwo","String",varAdminPublisherUserTwo);
    	//Globle variable  publisher user two of admin password
    	varAdminPublisherUserTwoPassword = Admin_UserCreation_adminPublisherUserTwoPassword;
    	store("keyAdminPublisherUserTwoPassword","String",varAdminPublisherUserTwoPassword);
    	//Globle variable  store user two of admin
    	varAdminStoreUserTwo = Admin_UserCreation_adminStoreUserNameTwo;
    	//store Globle variable  store user two of admin
    	store("keyAdminStoreUserTwo","String",varAdminStoreUserTwo);
    	varAdminStoreUserTwoPassword = Admin_UserCreation_adminStoreUserTwoPassword;
    	store("keyAdminStoreUserTwoPassword","String",Admin_UserCreation_adminStoreUserTwoPassword);
    	//Globle variable  store user three of admin
    	varAdminStoreUserThree = Admin_UserCreation_adminStoreUserNameThree;
    	//store Globle variable  store user three of admin
    	store("keyAdminStoreUserThree","String",varAdminStoreUserThree);
    	varAdminStoreUserThreePassword = Admin_UserCreation_adminStoreUserThreePassword;
    	store("keyAdminStoreUserThreePassword","String",Admin_UserCreation_adminStoreUserThreePassword);
    	//------------------------------Creation of Role 4 for store user 4
    	//Log into Carbon
    	lib_Common.bc_APIcarbonLogin(this, Common_superAdminUserName,Common_superAdminPassword,Common_carbonURL,Admin_UserCreation_sixSeconds);
    	waitForElement("APICarbonHome.btn_Configure",Admin_UserCreation_sixSeconds);
    	lib_Common.bc_Create_Carbon_User(this, Admin_UserCreation_adminStoreUserNameFour,Admin_UserCreation_adminStoreUserFourPassword,Admin_UserCreation_adminStoreUserFourPassword,Admin_UserCreation_sixSeconds);
    	//Waiting for content load
    	click("APICarbonHome.lnk_UserandRoles");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.lnk_Roles",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.lnk_Roles");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",Admin_UserCreation_sixSeconds);
    	type("CarbonUserRole.tf_RoleName",Admin_UserCreation_storeRoleNameFour);
    	click("CarbonUserRole.btn_Next");
    	//check role creation error popup
    	if(checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
    	fail("The Entered Role Name Does Not Meet With The Rules");
    	}
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Login");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.chk_Subscribe",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Subscribe");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Admin_UserCreation_adminStoreUserNameFour,Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Admin_UserCreation_adminStoreUserNameFour);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//-------------------------------End of creation of Role 4
    	//------------------------------Creation of Role 5 for store user 5
    	waitForElement("APICarbonHome.btn_Configure",Admin_UserCreation_sixSeconds);
    	lib_Common.bc_Create_Carbon_User(this, Admin_UserCreation_adminStoreUserNameFive,Admin_UserCreation_adminStoreUserFivePassword,Admin_UserCreation_adminStoreUserFivePassword,Admin_UserCreation_sixSeconds);
    	waitForElement("APICarbonHome.lnk_UserandRoles",Admin_UserCreation_sixSeconds);
    	//Waiting for content load
    	click("APICarbonHome.lnk_UserandRoles");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.lnk_Roles",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.lnk_Roles");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	type("CarbonUserRole.tf_RoleName",Admin_UserCreation_storeRoleNameFive);
    	click("CarbonUserRole.btn_Next");
    	//check role creation error popup
    	if(checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
    	fail("The Entered Role Name Does Not Meet With The Rules");
    	}
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Login");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.chk_Subscribe",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Subscribe");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Admin_UserCreation_adminStoreUserNameFive,Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Admin_UserCreation_adminStoreUserNameFive);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//-------------------------------End of creation of Role 5
    	//------------------------------Creation of Role 6 for store user 6
    	waitForElement("APICarbonHome.btn_Configure",Admin_UserCreation_sixSeconds);
    	lib_Common.bc_Create_Carbon_User(this, Admin_UserCreation_adminStoreUserNameSix,Admin_UserCreation_adminStoreUserSixPassword,Admin_UserCreation_adminStoreUserSixPassword,Admin_UserCreation_sixSeconds);
    	waitForElement("APICarbonHome.lnk_UserandRoles",Admin_UserCreation_sixSeconds);
    	//Waiting for content load
    	click("APICarbonHome.lnk_UserandRoles");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.lnk_Roles",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.lnk_Roles");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	type("CarbonUserRole.tf_RoleName",Admin_UserCreation_storeRoleNameSix);
    	click("CarbonUserRole.btn_Next");
    	//check role creation error popup
    	if(checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
    	fail("The Entered Role Name Does Not Meet With The Rules");
    	}
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Login");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.chk_Subscribe",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Subscribe");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Admin_UserCreation_adminStoreUserNameSix,Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + Admin_UserCreation_adminStoreUserNameSix);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",Admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//-------------------------------End of creation of Role 6
    	//------------------------------Creation of Role 7 for store user 7
    	waitForElement("APICarbonHome.btn_Configure",Admin_UserCreation_sixSeconds);
    	lib_Common.bc_Create_Carbon_User(this, Admin_UserCreation_adminStoreUserNameSeven,Admin_UserCreation_adminStoreUserSevenPassword,Admin_UserCreation_adminStoreUserSevenPassword,Admin_UserCreation_sixSeconds);
    	//Waiting for content load
    	waitForElement("APICarbonHome.lnk_UserandRoles",Admin_UserCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserandRoles");
    	//Waiting for content load
    	waitForElement("APICarbonHome.lnk_User",Admin_UserCreation_sixSeconds);
    	//****************************
    	click("APICarbonHome.lnk_User");
    	checkElementPresent("CarbonAddUser.lnk_AssignRoles","param_userName_PARAM:" + Admin_UserCreation_adminStoreUserNameSeven,false,"");
    	waitForElement("CarbonAddUser.lnk_AssignRoles","param_userName_PARAM:" + Admin_UserCreation_adminStoreUserNameSeven,Admin_UserCreation_sixSeconds);
    	click("CarbonAddUser.lnk_AssignRoles","param_userName_PARAM:" + Admin_UserCreation_adminStoreUserNameSeven);
    	//add role one
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + Admin_UserCreation_adminRoleNameOneStoreUserOne);
    	//add role two
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + Admin_UserCreation_adminRoleNameOneStoreUserTwo);
    	//add role three
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + Admin_UserCreation_storeRoleNameFour);
    	//add role four
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + Admin_UserCreation_storeRoleNameFive);
    	//add role five
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + Admin_UserCreation_storeRoleNameSix);
    	checkElementPresent("CarbonAddUser.btn_finish",false,"");
    	click("CarbonAddUser.btn_finish");
    	checkElementPresent("CarbonUserRole.btn_OkPopUp",false,"");
    	click("CarbonUserRole.btn_OkPopUp");
    	//****************************
    	/*
    	Click
    	 object=CarbonUserRole.lnk_Roles
    	Click
    	 object=CarbonUserRole.lnk_AddNewRole
    	Type
    	 object=CarbonUserRole.tf_RoleName
    	 text=@Admin_UserCreation_storeRoleNameSeven
    	Click
    	 object=CarbonUserRole.btn_Next
    	//check role creation error popup
    	If
    	 expression=checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")
    	 Fail
    	  message=The Entered Role Name Does Not Meet With The Rules
    	EndIf
    	//Waiting for content load
    	Pause
    	 ms=2000
    	Click
    	 object=CarbonUserRole.chk_Login
    	If
    	 expression=checkElementPresent("CarbonUserRole.chk_CheckedAPI")
    	 Click
    	  object=CarbonUserRole.btn_NextPermissions
    	ElseIf
    	 expression=!checkElementPresent("CarbonUserRole.chk_CheckedAPI")
    	 Click
    	  object=CarbonUserRole.chk_Subscribe
    	EndIf
    	Pause
    	 ms=2000
    	Click
    	 object=CarbonUserRole.btn_NextPermissions
    	//Waiting for content load
    	Pause
    	 ms=2000
    	Click
    	 object=CarbonUserRole.chk_UserName
    	 param_UserName=@Admin_UserCreation_adminStoreUserNameSeven
    	//Waiting for content load
    	Pause
    	 ms=2000
    	Click
    	 object=CarbonUserRole.btn_FinishAddRole
    	//Waiting for content load
    	Pause
    	 ms=2000
    	Click
    	 object=CarbonUserRole.btn_OkPopUp
    	//Waiting for content load
    	Pause
    	 ms=1000
    	Click
    	 object=APICarbonHome.lnk_UserandRoles
    	*/
    	//-------------------------------End of creation of Role 7
    	//store global variables to admin store user 4
    	//Globle variable  store user four role of admin
    	varAdminStoreUserFourRoleOne = Admin_UserCreation_storeRoleNameFour;
    	store("keyAdminStoreUserFourRoleOne","String",varAdminStoreUserFourRoleOne);
    	varAdminStoreUserFour = Admin_UserCreation_adminStoreUserNameFour;
    	//store Globle variable  store user four of admin
    	store("keyAdminStoreUserFour","String",varAdminStoreUserFour);
    	varAdminStoreUserFourPassword = Admin_UserCreation_adminStoreUserFourPassword;
    	store("keyAdminStoreUserFourPassword","String",Admin_UserCreation_adminStoreUserFourPassword);
    	//store global variables to admin store user 5
    	//Globle variable  store user five role of admin
    	varAdminStoreUserFiveRoleOne = Admin_UserCreation_storeRoleNameFive;
    	store("keyAdminStoreUserFiveRoleOne","String",varAdminStoreUserFiveRoleOne);
    	//Globle variable  store user five of admin
    	varAdminStoreUserFive = Admin_UserCreation_adminStoreUserNameFive;
    	//store Globle variable  store user four of admin
    	store("keyAdminStoreUserFive","String",varAdminStoreUserFive);
    	varAdminStoreUserFivePassword = Admin_UserCreation_adminStoreUserFivePassword;
    	store("keyAdminStoreUserFivePassword","String",Admin_UserCreation_adminStoreUserFivePassword);
    	//store global variables to admin store user 6
    	//Globle variable  store user six role of admin
    	varAdminStoreUserSixRoleOne = Admin_UserCreation_storeRoleNameSix;
    	store("keyAdminStoreUserSixRoleOne","String",varAdminStoreUserSixRoleOne);
    	//Globle variable  store user six of admin
    	varAdminStoreUserSix = Admin_UserCreation_adminStoreUserNameSix;
    	//store Globle variable  store user six of admin
    	store("keyAdminStoreUserSix","String",varAdminStoreUserSix);
    	varAdminStoreUserSixPassword = Admin_UserCreation_adminStoreUserSixPassword;
    	store("keyAdminStoreUserSixPassword","String",Admin_UserCreation_adminStoreUserSixPassword);
    	//store global variables to admin store user 7
    	//uncomment the below if another role is to be added
    	/*
    	//Globle variable  store user seven role of admin
    	EditVariable
    	 name=varAdminStoreUserSevenRoleOne
    	 paramValue=@Admin_UserCreation_storeRoleNameSeven
    	Store
    	 key=keyAdminStoreUserSevenRoleOne
    	 type=String
    	 value=@varAdminStoreUserSevenRoleOne
    	*/
    	//Globle variable  store user seven of admin
    	varAdminStoreUserSeven = Admin_UserCreation_adminStoreUserNameSeven;
    	//store Globle variable  store user seven of admin
    	store("keyAdminStoreUserSeven","String",varAdminStoreUserSeven);
    	varAdminStoreUserSevenPassword = Admin_UserCreation_adminStoreUserSevenPassword;
    	store("keyAdminStoreUserSevenPassword","String",Admin_UserCreation_adminStoreUserSevenPassword);
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}