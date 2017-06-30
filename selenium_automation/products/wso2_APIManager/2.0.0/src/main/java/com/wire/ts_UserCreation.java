package com.wire;

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
    String varTenantOnePublisherUserThree;
    String varTenantOnePublisherThreePassword;
    String varTenantOneSpecialRolePublisherThree;
    String varAdminPublisherUserThree;
    String varAdminPublisherUserThreePassword;
    String varAdminRoleNameOnePublisherUserThree;


    /**
     * Data provider for Test case tc_Tenant_Creation.
     * @return data table
     */
    @DataProvider(name = "tc_Tenant_Creation")
    public Object[][] dataTable_tc_Tenant_Creation() {     	
    	return this.getDataTable("common","tenantCreation");
    }

    /**
     * Data driven test case tc_Tenant_Creation.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Tenant_Creation")
    public final void tc_Tenant_Creation(final String common_superAdminUserName, final String common_superAdminPassword, final String common_carbonURL, final String common_PublisherURL, final String common_storeURL, final String tenantCreation_tenantOneDomainName, final String tenantCreation_tenantOneFirstName, final String tenantCreation_tenantOneLastName, final String tenantCreation_adminUsernameTenantOne, final String tenantCreation_adminPasswordTenantOne, final String tenantCreation_emailAddressTenantDomainOne, final String tenantCreation_tenantTwoDomainName, final String tenantCreation_tenantTwoFirstName, final String tenantCreation_tenantTwoLastName, final String tenantCreation_adminUsernameTenantTwo, final String tenantCreation_adminPasswordTenantTwo, final String tenantCreation_emailAddressTenantDomainTwo, final String tenantCreation_tenantThreeDomainName, final String tenantCreation_tenantThreeFirstName, final String tenantCreation_tenantThreeLastName, final String tenantCreation_adminUsernameTenantThree, final String tenantCreation_adminPasswordTenantThree, final String tenantCreation_emailAddressTenantDomainThree, final String tenantCreation_twoSeconds, final String tenantCreation_fourSeconds, final String tenantCreation_sixSeconds, final String tenantCreation_eightSeconds) throws Exception {	
    	writeToReport("Start Of Tenant One Creation");
    	//Create primary tennant
    	lib_Common.bc_Carbon_CreateTenant(this, common_superAdminUserName,common_superAdminPassword,tenantCreation_tenantOneFirstName,tenantCreation_tenantOneLastName,tenantCreation_adminUsernameTenantOne,tenantCreation_adminPasswordTenantOne,tenantCreation_emailAddressTenantDomainOne,common_carbonURL,tenantCreation_tenantOneDomainName,tenantCreation_fourSeconds);
    	//Store tenant one admin user name into variable with domain
    	String varTenantOneAdminUser = tenantCreation_adminUsernameTenantOne+"@"+tenantCreation_tenantOneDomainName;
    	store("keyTenantOneAdminUser","String",varTenantOneAdminUser);
    	//Set variable for tenant user password
    	String varTenantOneAdminUserPassword = tenantCreation_adminPasswordTenantOne;
    	//Store tenant password into variable
    	store("keyTenantOneAdminUserPassword","String",varTenantOneAdminUserPassword);
    	//Globe variable Server name one
    	varServerNameOne = tenantCreation_tenantOneDomainName;
    	//store Globe variable Server name one
    	store("keyServerNameOne","String",varServerNameOne);
    	varServerNameCarbonSuper = "carbon.super";
    	store("keyServerNameCarbonSuper","String",varServerNameCarbonSuper);
    	writeToReport("End Of Tenant One Creation");
    	writeToReport("Start Of Tenant Two Creation");
    	//Create secondary tennant
    	lib_Common.bc_Carbon_CreateTenant(this, common_superAdminUserName,common_superAdminPassword,tenantCreation_tenantTwoFirstName,tenantCreation_tenantTwoLastName,tenantCreation_adminUsernameTenantTwo,tenantCreation_adminPasswordTenantTwo,tenantCreation_emailAddressTenantDomainTwo,common_carbonURL,tenantCreation_tenantTwoDomainName,tenantCreation_fourSeconds);
    	//Store tenant two admin user name into variable with domain
    	String varTenantTwoAdminUser = tenantCreation_adminUsernameTenantTwo+"@"+tenantCreation_tenantTwoDomainName;
    	store("keyTenantTwoAdminUser","String",varTenantTwoAdminUser);
    	//Set variable for tenant two user password
    	String varTenantTwoAdminUserPassword = tenantCreation_adminPasswordTenantTwo;
    	//Store tenant two password into variable
    	store("keyTenantTwoAdminUserPassword","String",varTenantTwoAdminUserPassword);
    	//Globe variable Server name Two
    	varServerNameTwo = tenantCreation_tenantTwoDomainName;
    	//store Globe variable Server name Two
    	store("keyServerNameTwo","String",varServerNameTwo);
    	writeToReport("End Of Tenant Two Creation");
    	writeToReport("Start Of Tenant Three Creation");
    	//Create tertiary tennant
    	lib_Common.bc_Carbon_CreateTenant(this, common_superAdminUserName,common_superAdminPassword,tenantCreation_tenantThreeFirstName,tenantCreation_tenantThreeLastName,tenantCreation_adminUsernameTenantThree,tenantCreation_adminPasswordTenantThree,tenantCreation_emailAddressTenantDomainThree,common_carbonURL,tenantCreation_tenantThreeDomainName,tenantCreation_fourSeconds);
    	//Store tenant three admin user name into variable with domain
    	String varTenantThreeAdminUser = tenantCreation_adminUsernameTenantThree+"@"+tenantCreation_tenantThreeDomainName;
    	store("keyTenantThreeAdminUser","String",varTenantThreeAdminUser);
    	//Set variable for tenant three user password
    	String varTenantThreeAdminUserPassword = tenantCreation_adminPasswordTenantThree;
    	//Store tenant three password into variable.
    	store("keyTenantThreeAdminUserPassword","String",varTenantThreeAdminUserPassword);
    	//Globe variable Server name Three
    	varServerNameThree = tenantCreation_tenantThreeDomainName;
    	//store Globe variable Server name Three
    	store("keyServerNameThree","String",varServerNameThree);
    	writeToReport("End Of Tenant Three Creation..sdfghj");
    } 
    	

    /**
     * Data provider for Test case tc_Tenant_UserCreation.
     * @return data table
     */
    @DataProvider(name = "tc_Tenant_UserCreation")
    public Object[][] dataTable_tc_Tenant_UserCreation() {     	
    	return this.getDataTable("common","tenant_UserCreation","tenantCreation");
    }

    /**
     * Data driven test case tc_Tenant_UserCreation.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Tenant_UserCreation")
    public final void tc_Tenant_UserCreation(final String common_superAdminUserName, final String common_superAdminPassword, final String common_carbonURL, final String common_PublisherURL, final String common_storeURL, final String tenant_UserCreation_tenantOnePublisherUserNameOne, final String tenant_UserCreation_tenantOnePublisherUserOnePassword, final String tenant_UserCreation_tenantOneRoleNameOnePublisherUserOne, final String tenant_UserCreation_tenantOneStoreUserNameOne, final String tenant_UserCreation_tenantOneStoreUserOnePassword, final String tenant_UserCreation_tenantOneRoleNameOneStoreUserOne, final String tenant_UserCreation_tenantOnePublisherUserNameTwo, final String tenant_UserCreation_tenantOnePublisherUserTwoPassword, final String tenant_UserCreation_tenantOneRoleNameOnePublisherUserTwo, final String tenant_UserCreation_tenantOnePublisherUserNameThree, final String tenant_UserCreation_tenantOnePublisherUserThreePassword, final String tenant_UserCreation_tenantOneRoleNameOnePublisherUserThree, final String tenant_UserCreation_tenantOneStoreUserNameTwo, final String tenant_UserCreation_tenantOneStoreUserTwoPassword, final String tenant_UserCreation_tenantOneRoleNameOneStoreUserTwo, final String tenant_UserCreation_tenantOneRoleNameThreeStoreUserThree, final String tenant_UserCreation_tenantOneStoreUserNameThree, final String tenant_UserCreation_tenantOneStoreUserThreePassword, final String tenant_UserCreation_tenantOneRoleNameFourStoreUserFour, final String tenant_UserCreation_tenantOneStoreUserNameFour, final String tenant_UserCreation_tenantOneStoreUserFourPassword, final String tenant_UserCreation_tenantOneRoleNameFiveStoreUserFive, final String tenant_UserCreation_tenantOneStoreUserNameFive, final String tenant_UserCreation_tenantOneStoreUserFivePassword, final String tenant_UserCreation_tenantOneStoreUserNameSix, final String tenant_UserCreation_tenantOneStoreUserSixPassword, final String tenant_UserCreation_tenantTwoPublisherUserNameOne, final String tenant_UserCreation_tenantTwoPublisherUserOnePassword, final String tenant_UserCreation_tenantTwoRoleNameOnePublisherUserOne, final String tenant_UserCreation_tenantTwoStoreUserNameOne, final String tenant_UserCreation_tenantTwoStoreUserOnePassword, final String tenant_UserCreation_tenantTwoRoleNameOneStoreUserOne, final String tenant_UserCreation_tenantThreePublisherUserNameOne, final String tenant_UserCreation_tenantThreePublisherUserOnePassword, final String tenant_UserCreation_tenantThreeRoleNameOnePublisherUserOne, final String tenant_UserCreation_tenantThreeStoreUserNameOne, final String tenant_UserCreation_tenantThreeStoreUserOnePassword, final String tenant_UserCreation_tenantThreeRoleNameOneStoreUserOne, final String tenant_UserCreation_tenantThreeStoreUserNameTwo, final String tenant_UserCreation_tenantThreeStoreUserTwoPassword, final String tenant_UserCreation_tenantThreeRoleNameOneStoreUserTwo, final String tenant_UserCreation_twoSeconds, final String tenant_UserCreation_fourSeconds, final String tenant_UserCreation_sixSeconds, final String tenant_UserCreation_eightSeconds, final String tenantCreation_tenantOneDomainName, final String tenantCreation_tenantOneFirstName, final String tenantCreation_tenantOneLastName, final String tenantCreation_adminUsernameTenantOne, final String tenantCreation_adminPasswordTenantOne, final String tenantCreation_emailAddressTenantDomainOne, final String tenantCreation_tenantTwoDomainName, final String tenantCreation_tenantTwoFirstName, final String tenantCreation_tenantTwoLastName, final String tenantCreation_adminUsernameTenantTwo, final String tenantCreation_adminPasswordTenantTwo, final String tenantCreation_emailAddressTenantDomainTwo, final String tenantCreation_tenantThreeDomainName, final String tenantCreation_tenantThreeFirstName, final String tenantCreation_tenantThreeLastName, final String tenantCreation_adminUsernameTenantThree, final String tenantCreation_adminPasswordTenantThree, final String tenantCreation_emailAddressTenantDomainThree, final String tenantCreation_twoSeconds, final String tenantCreation_fourSeconds, final String tenantCreation_sixSeconds, final String tenantCreation_eightSeconds) throws Exception {	
    	//----------------------------------------------------------------------------------------------------------------------------------------T1U1
    	writeToReport("Start Of Tenant One User One Creation And Assign Roles");
    	//Log into Carbon from retrived user name
    	String varTenantOneAdminUserName = retrieveString("keyTenantOneAdminUser");
    	lib_Common.bc_APICarbonLogin(this, varTenantOneAdminUserName,tenantCreation_adminPasswordTenantOne,common_carbonURL,tenantCreation_sixSeconds);
    	//Create Tenant User Using creted tenant and  assign roles
    	varTenantOneRoleNameOneStoreUserOne = tenant_UserCreation_tenantOneRoleNameOneStoreUserOne;
    	//store variable tenant one publisher user one passord
    	store("KeyVisibilityRole","String",varTenantOneRoleNameOneStoreUserOne);
    	String varRoleNameTenant = retrieveString("KeyVisibilityRole");
    	lib_Common.bc_TenantUser_CreateRoles_And_AssignRoles(this, tenant_UserCreation_tenantOnePublisherUserNameOne,tenant_UserCreation_tenantOnePublisherUserOnePassword,tenant_UserCreation_tenantOnePublisherUserOnePassword,tenant_UserCreation_tenantOneRoleNameOnePublisherUserOne,tenant_UserCreation_tenantOneStoreUserNameOne,tenant_UserCreation_tenantOneStoreUserOnePassword,tenant_UserCreation_tenantOneStoreUserOnePassword,varRoleNameTenant,tenantCreation_twoSeconds,tenantCreation_twoSeconds,tenantCreation_fourSeconds,tenantCreation_sixSeconds);
    	//Globle variable tenant one publisher user one
    	varTenantOnePublisherUserOne = tenant_UserCreation_tenantOnePublisherUserNameOne+"@"+tenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one publisher user one
    	store("keyTenantOnePublisherUserOne","String",varTenantOnePublisherUserOne);
    	//Globle variable tenant one publisher user one passord
    	varTenantOnePublisherOnePassword = tenant_UserCreation_tenantOnePublisherUserOnePassword;
    	//store variable tenant one publisher user one passord
    	store("keyTenantOnePublisherOnePassword","String",varTenantOnePublisherOnePassword);
    	//Globle variable tenant one store user one
    	varTenantOneStoreUserOne = tenant_UserCreation_tenantOneStoreUserNameOne+"@"+tenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user one
    	store("keyTenantOneStoreUserOne","String",varTenantOneStoreUserOne);
    	//Globle variable tenant one store user one password
    	varTenantOneStoreUserOnePassword = tenant_UserCreation_tenantOneStoreUserOnePassword;
    	//store Globle variable tenant one store user passord
    	store("keyTenantOneStoreUserOnePassword","String",varTenantOneStoreUserOnePassword);
    	writeToReport("End Of Tenant One User One Creation And Assign Roles");
    	writeToReport("Start Of Tenant One User Two Creation And Assign Roles");
    	//----------------------------------------------------------------------------------------------------------------------------------------T1U2
    	//Log into Carbon from retrived user name to create User two
    	String varTenantOneAdminUserNameTwo = retrieveString("keyTenantOneAdminUser");
    	lib_Common.bc_APICarbonLogin(this, varTenantOneAdminUserNameTwo,tenantCreation_adminPasswordTenantOne,common_carbonURL,tenantCreation_sixSeconds);
    	//Create Tenant User two Using creted tenant and  assign roles
    	varTenantOneRoleNameOneStoreUserTwo = tenant_UserCreation_tenantOneRoleNameOneStoreUserTwo;
    	//store variable tenant one publisher user two passord
    	store("KeyVisibilityT1RoleNameOneStoreUserTwo","String",varTenantOneRoleNameOneStoreUserTwo);
    	String varT1RoleNameOneStoreUserTwo = retrieveString("KeyVisibilityT1RoleNameOneStoreUserTwo");
    	lib_Common.bc_TenantUser_CreateRoles_And_AssignRoles_WithManageTierPermission(this, tenant_UserCreation_tenantOnePublisherUserNameTwo,tenant_UserCreation_tenantOnePublisherUserTwoPassword,tenant_UserCreation_tenantOnePublisherUserTwoPassword,tenant_UserCreation_tenantOneRoleNameOnePublisherUserTwo,tenant_UserCreation_tenantOneStoreUserNameTwo,tenant_UserCreation_tenantOneStoreUserTwoPassword,tenant_UserCreation_tenantOneStoreUserTwoPassword,varT1RoleNameOneStoreUserTwo,tenantCreation_fourSeconds,tenantCreation_sixSeconds);
    	//Globle variable tenant one publisher user two
    	varTenantOnePublisherUserTwo = tenant_UserCreation_tenantOnePublisherUserNameTwo+"@"+tenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one publisher user two
    	store("keyTenantOnePublisherUserTwo","String",varTenantOnePublisherUserTwo);
    	//Globle variable tenant one publisher user two passord
    	varTenantOnePublisherTwoPassword = tenant_UserCreation_tenantOnePublisherUserTwoPassword;
    	//store variable tenant one publisher user two passord
    	store("keyTenantOnePublisherTwoPassword","String",varTenantOnePublisherTwoPassword);
    	//Globle variable tenant one store user two
    	varTenantOneStoreUserTwo = tenant_UserCreation_tenantOneStoreUserNameTwo+"@"+tenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user two
    	store("keyTenantOneStoreUserTwo","String",varTenantOneStoreUserTwo);
    	//Globle variable tenant one store user two password
    	varTenantOneStoreUserTwoPassword = tenant_UserCreation_tenantOneStoreUserTwoPassword;
    	//store Globle variable tenant one store user two password
    	store("keyTenantOneStoreUserTwoPassword","String",varTenantOneStoreUserTwoPassword);
    	writeToReport("End Of Tenant One User Two Creation And Assign Roles");
    	//------------------------------------------------------------------------------------------------------------------------------------T1U3-Special Publisher
    	writeToReport("Start Of Tenant One User One Creation And Assign Roles");
    	//Log into Carbon from retrived user name
    	String varTenantOneAdminUserNameThree = retrieveString("keyTenantOneAdminUser");
    	lib_Common.bc_APICarbonLogin(this, varTenantOneAdminUserNameThree,tenantCreation_adminPasswordTenantOne,common_carbonURL,tenantCreation_sixSeconds);
    	//
    	varTenantOneSpecialRolePublisherThree = tenant_UserCreation_tenantOneRoleNameOnePublisherUserThree;
    	store("KeySpecialRoleNoPublisherPermission","String",varTenantOneSpecialRolePublisherThree);
    	//Create Tenant User Using creted tenant and  assign roles
    	//store variable tenant one publisher user one passord
    	//*********************************************************************
    	writeToReport("Start of creation of TenantUser_CreateRoles_And_AssignRoles_T1_Publisher_Three");
    	//----------------------------------------------------------------API Publisher User Creation------------------------------------------------------------------------------
    	lib_Common.bc_Create_Carbon_User(this, tenant_UserCreation_tenantOnePublisherUserNameThree,tenant_UserCreation_tenantOnePublisherUserThreePassword,tenant_UserCreation_tenantOnePublisherUserThreePassword,tenant_UserCreation_twoSeconds);
    	//Waiting for content load
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",tenantCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",tenant_UserCreation_fourSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",tenant_UserCreation_fourSeconds);
    	//Create role for publisher
    	type("CarbonUserRole.tf_RoleName",varTenantOneSpecialRolePublisherThree);
    	waitForElement("CarbonUserRole.btn_Next",tenant_UserCreation_fourSeconds);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",tenant_UserCreation_fourSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	//Click Check box create
    	click("CarbonUserRole.chk_Create1");
    	//Click Check box publish
    	/*
    	Click
    	  object=CarbonUserRole.chk_Publish1
    	*/
    	}
    	//Click Check box Governance
    	click("CarbonUserRole.chk_governance1");
    	waitForElement("CarbonUserRole.chk_govern1",tenant_UserCreation_fourSeconds);
    	//Click Check box govern
    	click("CarbonUserRole.chk_govern1");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_NextPermissions",tenant_UserCreation_fourSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantOnePublisherUserNameThree,tenant_UserCreation_fourSeconds);
    	//Check the username created in previously
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantOnePublisherUserNameThree);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",tenant_UserCreation_fourSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",tenant_UserCreation_fourSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//***********************************************************************
    	//Globle variable tenant one publisher user one
    	varTenantOnePublisherUserThree = tenant_UserCreation_tenantOnePublisherUserNameThree+"@"+tenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one publisher user one
    	store("keyTenantOnePublisherUserThree","String",varTenantOnePublisherUserThree);
    	//Globle variable tenant one publisher user one passord
    	varTenantOnePublisherThreePassword = tenant_UserCreation_tenantOnePublisherUserThreePassword;
    	//store variable tenant one publisher user one passord
    	store("keyTenantOnePublisherThreePassword","String",varTenantOnePublisherThreePassword);
    	writeToReport("End Of TenantUser_CreateRoles_And_AssignRoles_T1_Publisher_Three");
    	//------------------------------------------------------------------------------------------------------------------------------------------------------------------
    	//************************* Start of creation of  T1  store user three and role 3
    	//----------------------------------------------------------------------API Store Normal User Creation---------------------------------------------------------------------------
    	writeToReport("Start Of Tenant One User Three Creation And Assign Roles");
    	//Create Store User Three Using created tenant One and assign roles
    	varTenantOneRoleNameThreeStoreUserThree = tenant_UserCreation_tenantOneRoleNameThreeStoreUserThree;
    	//store variable tenant one store user three password
    	store("KeyVisibilityT1RoleNameThreeStoreUserThree","String",varTenantOneRoleNameThreeStoreUserThree);
    	String varT1RoleNameThreeStoreUserThree = retrieveString("KeyVisibilityT1RoleNameThreeStoreUserThree");
    	waitForElement("APICarbonHome.btn_Configure",tenantCreation_fourSeconds);
    	lib_Common.bc_Create_Carbon_User(this, tenant_UserCreation_tenantOneStoreUserNameThree,tenant_UserCreation_tenantOneStoreUserThreePassword,tenant_UserCreation_tenantOneStoreUserThreePassword,tenantCreation_fourSeconds);
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",tenantCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",tenantCreation_fourSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",tenantCreation_fourSeconds);
    	type("CarbonUserRole.tf_RoleName",varT1RoleNameThreeStoreUserThree);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",tenantCreation_fourSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.chk_Subscribe1");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantOneStoreUserNameThree,tenantCreation_eightSeconds);
    	//Click the tenent one store user three username
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantOneStoreUserNameThree);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//Waiting for content load
    	//--------------------------Store global variables to tenant one store user three
    	//Globle variable tenant One store user Three
    	varTenantOneStoreUserThree = tenant_UserCreation_tenantOneStoreUserNameThree+"@"+tenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user three
    	store("keyTenantOneStoreUserThree","String",varTenantOneStoreUserThree);
    	//Globle variable tenant one store user Three password
    	varTenantOneStoreUserThreePassword = tenant_UserCreation_tenantOneStoreUserThreePassword;
    	//store Globle variable tenant one store user three passord
    	store("keyTenantOneStoreUserThreePassword","String",varTenantOneStoreUserThreePassword);
    	writeToReport("End Of Tenant One User Three Creation And Assign Roles");
    	//************************* End of creation of  T1  store user and role 3
    	//************************* Start of creation of T1  store user and role 4
    	//----------------------------------------------------------------------API Store Normal User Creation---------------------------------------------------------------------------
    	writeToReport("Start Of Tenant One User Four Creation And Assign Roles");
    	//Create Store User Four Using created tenant One and assign roles
    	varTenantOneRoleNameFourStoreUserFour = tenant_UserCreation_tenantOneRoleNameFourStoreUserFour;
    	//store variable tenant one store user four password
    	store("KeyVisibilityT1RoleNameFourStoreUserFour","String",varTenantOneRoleNameFourStoreUserFour);
    	String varT1RoleNameFourStoreUserFour = retrieveString("KeyVisibilityT1RoleNameFourStoreUserFour");
    	waitForElement("APICarbonHome.btn_Configure",tenantCreation_eightSeconds);
    	lib_Common.bc_Create_Carbon_User(this, tenant_UserCreation_tenantOneStoreUserNameFour,tenant_UserCreation_tenantOneStoreUserFourPassword,tenant_UserCreation_tenantOneStoreUserFourPassword,tenantCreation_fourSeconds);
    	//Waiting for content load
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",tenantCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",tenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",tenantCreation_eightSeconds);
    	type("CarbonUserRole.tf_RoleName",varT1RoleNameFourStoreUserFour);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",tenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.chk_Subscribe1");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantOneStoreUserNameFour,tenantCreation_eightSeconds);
    	//Click the tenent one store user three username
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantOneStoreUserNameFour);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//Waiting for content load
    	//--------------------------Store global variables to tenant one store user four
    	//Globle variable tenant One store user Four
    	varTenantOneStoreUserFour = tenant_UserCreation_tenantOneStoreUserNameFour+"@"+tenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user four
    	store("keyTenantOneStoreUserFour","String",varTenantOneStoreUserFour);
    	//Globle variable tenant one store user Four password
    	varTenantOneStoreUserFourPassword = tenant_UserCreation_tenantOneStoreUserFourPassword;
    	//store Globle variable tenant one store user four password
    	store("keyTenantOneStoreUserFourPassword","String",varTenantOneStoreUserFourPassword);
    	writeToReport("End Of Tenant One User Four Creation And Assign Roles");
    	//************************* End of creation of  T1  store user and role 4
    	//************************* Start of creation of T1  store user and role 5
    	//----------------------------------------------------------------------API Store Normal User Creation---------------------------------------------------------------------------
    	writeToReport("Start Of Tenant One User Five Creation And Assign Roles");
    	//Create Store User Five Using created tenant One and assign roles
    	varTenantOneRoleNameFiveStoreUserFive = tenant_UserCreation_tenantOneRoleNameFiveStoreUserFive;
    	//store variable tenant one store user five password
    	store("KeyVisibilityT1RoleNameFiveStoreUserFive","String",varTenantOneRoleNameFiveStoreUserFive);
    	String varT1RoleNameFiveStoreUserFive = retrieveString("KeyVisibilityT1RoleNameFiveStoreUserFive");
    	waitForElement("APICarbonHome.btn_Configure",tenantCreation_eightSeconds);
    	lib_Common.bc_Create_Carbon_User(this, tenant_UserCreation_tenantOneStoreUserNameFive,tenant_UserCreation_tenantOneStoreUserFivePassword,tenant_UserCreation_tenantOneStoreUserFivePassword,tenantCreation_fourSeconds);
    	//Waiting for content load
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",tenantCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",tenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",tenantCreation_eightSeconds);
    	type("CarbonUserRole.tf_RoleName",varT1RoleNameFiveStoreUserFive);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",tenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.chk_Subscribe1");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantOneStoreUserNameFive,tenantCreation_eightSeconds);
    	//Click the tenent one store user five username
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantOneStoreUserNameFive);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//Waiting for content load
    	//--------------------------Store global variables to tenant one store user five
    	//Globle variable tenant One store user Five
    	varTenantOneStoreUserFive = tenant_UserCreation_tenantOneStoreUserNameFive+"@"+tenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user five
    	store("keyTenantOneStoreUserFive","String",varTenantOneStoreUserFive);
    	//Globle variable tenant one store user Five password
    	varTenantOneStoreUserFivePassword = tenant_UserCreation_tenantOneStoreUserFivePassword;
    	//store Globle variable tenant one store user five password
    	store("keyTenantOneStoreUserFivePassword","String",varTenantOneStoreUserFivePassword);
    	writeToReport("End Of Tenant One User Five Creation And Assign Roles");
    	//************************* End of creation of  T1  store user five and role 5
    	//************************* Start of creation of T1  store user six and role 1,2,3,4,5
    	//----------------------------------------------------------------------API Store Normal User Creation---------------------------------------------------------------------------
    	writeToReport("Start Of Tenant One User Six Creation And Assign Roles");
    	//Create Store User Six Using created tenant One and assign roles
    	waitForElement("APICarbonHome.btn_Configure",tenantCreation_eightSeconds);
    	//Create Carbon user from Tenant User
    	writeToReport("Start of Create_Carbon_User");
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",tenantCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	waitForElement("APICarbonHome.lnk_AddNewUser",tenantCreation_eightSeconds);
    	click("APICarbonHome.lnk_AddNewUser");
    	//Type new Tenant creating Username
    	type("CarbonAddUser.tf_UserName",tenant_UserCreation_tenantOneStoreUserNameSix);
    	//Type new Tenant creating password
    	type("CarbonAddUser.tf_password",tenant_UserCreation_tenantOneStoreUserSixPassword);
    	//Re type new Tenant creating password
    	type("CarbonAddUser.tf_retypePassword",tenant_UserCreation_tenantOneStoreUserSixPassword);
    	//Click on Next
    	click("CarbonAddUser.btn_next");
    	if(checkElementPresent("CarbonAddUser.ele_LblUserCreationFailedPopup")){
    	fail("User Creation Failed Please Re-run With Valid Fied Names");
    	}
    	//Wait for content load
    	waitForElement("CarbonAddUser.chk_Role","userRole_PARAM:" + varTenantOneRoleNameOneStoreUserOne,tenantCreation_eightSeconds);
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
    	waitForElement("CarbonAddUser.btn_finish",tenantCreation_eightSeconds);
    	click("CarbonAddUser.btn_finish");
    	//wait for content load
    	waitForElement("CarbonAddUser.btn_Ok",tenantCreation_eightSeconds);
    	click("CarbonAddUser.btn_Ok");
    	writeToReport("End of BC Create_Carbon_User");
    	//--------------------------Store global variables to tenant one store user five
    	//Globle variable tenant One store user Five
    	varTenantOneStoreUserSix = tenant_UserCreation_tenantOneStoreUserNameSix+"@"+tenantCreation_tenantOneDomainName;
    	//store Globle variable tenant one store user six
    	store("keyTenantOneStoreUserSix","String",varTenantOneStoreUserSix);
    	//Globle variable tenant one store user Six password
    	varTenantOneStoreUserSixPassword = tenant_UserCreation_tenantOneStoreUserSixPassword;
    	//store Globle variable tenant one store user six password
    	store("keyTenantOneStoreUserSixPassword","String",varTenantOneStoreUserSixPassword);
    	writeToReport("End Of Tenant One User Five Creation And Assign Roles");
    	//************************* End of creation of  T1  store user six and role 1,2,3,4,5
    	writeToReport("Start Of Tenant Two User One Creation And Assign Roles");
    	//----------------------------------------------------------------------------------------------------------------------------------------T2U1
    	//Log into Carbon from retrived user name
    	String varTenantTwoAdminUserName = retrieveString("keyTenantTwoAdminUser");
    	lib_Common.bc_APICarbonLogin(this, varTenantTwoAdminUserName,tenantCreation_adminPasswordTenantTwo,common_carbonURL,tenantCreation_eightSeconds);
    	//Create Tenant User One Using creted tenant Two and  assign roles
    	varTenantTwoRoleNameOneStoreUserOne = tenant_UserCreation_tenantTwoRoleNameOneStoreUserOne;
    	//store variable tenant two publisher user one passord
    	store("KeyVisibilityT2RoleNameOneStoreUserOne","String",varTenantTwoRoleNameOneStoreUserOne);
    	String varT2RoleNameOneStoreUserOne = retrieveString("KeyVisibilityT2RoleNameOneStoreUserOne");
    	lib_Common.bc_TenantUser_CreateRoles_And_AssignRoles(this, tenant_UserCreation_tenantTwoPublisherUserNameOne,tenant_UserCreation_tenantTwoPublisherUserOnePassword,tenant_UserCreation_tenantTwoPublisherUserOnePassword,tenant_UserCreation_tenantTwoRoleNameOnePublisherUserOne,tenant_UserCreation_tenantTwoStoreUserNameOne,tenant_UserCreation_tenantTwoStoreUserOnePassword,tenant_UserCreation_tenantTwoStoreUserOnePassword,varT2RoleNameOneStoreUserOne,tenantCreation_twoSeconds,tenantCreation_twoSeconds,tenantCreation_fourSeconds,tenantCreation_fourSeconds);
    	//Globle variable tenant two publisher user one
    	varTenantTwoPublisherUserOne = tenant_UserCreation_tenantTwoPublisherUserNameOne+"@"+tenantCreation_tenantTwoDomainName;
    	//store Globle variable tenant two publisher user one
    	store("keyTenantTwoPublisherUserOne","String",varTenantTwoPublisherUserOne);
    	//Globle variable tenant two publisher user one passord
    	varTenantTwoPublisherOnePassword = tenant_UserCreation_tenantTwoPublisherUserOnePassword;
    	//store variable tenant two publisher user one passord
    	store("keyTenantTwoPublisherOnePassword","String",varTenantTwoPublisherOnePassword);
    	//Globle variable tenant two store user one
    	varTenantTwoStoreUserOne = tenant_UserCreation_tenantTwoStoreUserNameOne+"@"+tenantCreation_tenantTwoDomainName;
    	//store Globle variable tenant two store user one
    	store("keyTenantTwoStoreUserOne","String",varTenantTwoStoreUserOne);
    	//Globle variable tenant two store user one password
    	varTenantTwoStoreUserOnePassword = tenant_UserCreation_tenantTwoStoreUserOnePassword;
    	//store Globle variable tenant two store user passord
    	store("keyTenantTwoStoreUserOnePassword","String",varTenantTwoStoreUserOnePassword);
    	writeToReport("End Of Tenant Two User One Creation And Assign Roles");
    	writeToReport("Start Of Tenant Three User One Creation And Assign Roles");
    	//----------------------------------------------------------------------------------------------------------------------------------------T3U1(Including A Special Store Role And A Normal Store Role)
    	//Log into Carbon from retrived user name
    	String varTenantThreeAdminUserName = retrieveString("keyTenantThreeAdminUser");
    	lib_Common.bc_APICarbonLogin(this, varTenantThreeAdminUserName,tenantCreation_adminPasswordTenantThree,common_carbonURL,tenantCreation_sixSeconds);
    	//Create Tenant User One Using creted tenant three and assign roles
    	varTenantThreeRoleNameOneStoreUserOne = tenant_UserCreation_tenantThreeRoleNameOneStoreUserOne;
    	//store variable tenant three publisher user one passord
    	store("KeyVisibilityT3RoleNameOneStoreUserOne","String",varTenantThreeRoleNameOneStoreUserOne);
    	String varT3RoleNameOneStoreUserOne = retrieveString("KeyVisibilityT3RoleNameOneStoreUserOne");
    	//----------------------------------------------------------------API Publisher User Creation------------------------------------------------------------------------------
    	lib_Common.bc_Create_Carbon_User(this, tenant_UserCreation_tenantThreePublisherUserNameOne,tenant_UserCreation_tenantThreePublisherUserOnePassword,tenant_UserCreation_tenantThreePublisherUserOnePassword,tenantCreation_fourSeconds);
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",tenantCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",tenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",tenantCreation_eightSeconds);
    	//Create role for publisher
    	type("CarbonUserRole.tf_RoleName",tenant_UserCreation_tenantThreeRoleNameOnePublisherUserOne);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",tenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	//Click Check box create
    	click("CarbonUserRole.chk_Create1");
    	//Click Check box publish
    	click("CarbonUserRole.chk_Publish1");
    	}
    	//Click Check box Governance
    	click("CarbonUserRole.chk_governance1");
    	waitForElement("CarbonUserRole.chk_govern1",tenantCreation_eightSeconds);
    	//Click Check box govern
    	click("CarbonUserRole.chk_govern1");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_NextPermissions",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantThreePublisherUserNameOne,tenantCreation_eightSeconds);
    	//Check the username created in previously
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantThreePublisherUserNameOne);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//----------------------------------------------------------------------API Store Special User Creation---------------------------------------------------------------------------
    	waitForElement("APICarbonHome.btn_Configure",tenantCreation_eightSeconds);
    	lib_Common.bc_Create_Carbon_User(this, tenant_UserCreation_tenantThreeStoreUserNameOne,tenant_UserCreation_tenantThreeStoreUserOnePassword,tenant_UserCreation_tenantThreeStoreUserOnePassword,tenantCreation_fourSeconds);
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",tenantCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",tenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",tenantCreation_eightSeconds);
    	type("CarbonUserRole.tf_RoleName",varT3RoleNameOneStoreUserOne);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",tenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantThreeStoreUserNameOne,tenantCreation_eightSeconds);
    	//
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantThreeStoreUserNameOne);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//----------------------------------------------------------------------API Store Normal User Creation---------------------------------------------------------------------------
    	//Create Tenant User Two Using created tenant three and assign roles
    	varTenantThreeRoleNameOneStoreUserTwo = tenant_UserCreation_tenantThreeRoleNameOneStoreUserTwo;
    	//store variable tenant three publisher user Two passord
    	store("KeyVisibilityT3RoleNameOneStoreUserTwo","String",varTenantThreeRoleNameOneStoreUserTwo);
    	String varT3RoleNameOneStoreUserTwo = retrieveString("KeyVisibilityT3RoleNameOneStoreUserTwo");
    	waitForElement("APICarbonHome.btn_Configure",tenantCreation_eightSeconds);
    	lib_Common.bc_Create_Carbon_User(this, tenant_UserCreation_tenantThreeStoreUserNameTwo,tenant_UserCreation_tenantThreeStoreUserTwoPassword,tenant_UserCreation_tenantThreeStoreUserTwoPassword,tenantCreation_fourSeconds);
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",tenantCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",tenantCreation_eightSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",tenantCreation_eightSeconds);
    	type("CarbonUserRole.tf_RoleName",varT3RoleNameOneStoreUserTwo);
    	click("CarbonUserRole.btn_Next");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login1",tenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Login1");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.chk_Subscribe1",tenantCreation_eightSeconds);
    	click("CarbonUserRole.chk_Subscribe1");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantThreeStoreUserNameTwo,tenantCreation_eightSeconds);
    	//Click the tenent three store user two username
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + tenant_UserCreation_tenantThreeStoreUserNameTwo);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",tenantCreation_eightSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	writeToReport("End Of Tenant Three User One Creation And Assign Roles");
    	//---------------------------------------------------------------------------------------------------------------------------------------------------
    	//Globle variable tenant three publisher user one
    	varTenantThreePublisherUserOne = tenant_UserCreation_tenantThreePublisherUserNameOne+"@"+tenantCreation_tenantThreeDomainName;
    	//store Globle variable tenant three publisher user one
    	store("keyTenantThreePublisherUserOne","String",varTenantThreePublisherUserOne);
    	//Globle variable tenant three publisher user one passord
    	varTenantThreePublisherOnePassword = tenant_UserCreation_tenantThreePublisherUserOnePassword;
    	//store variable tenant three publisher user one passord
    	store("keyTenantThreePublisherOnePassword","String",varTenantThreePublisherOnePassword);
    	//Globle variable tenant three store user one SPECIAL
    	varTenantThreeStoreUserOne = tenant_UserCreation_tenantThreeStoreUserNameOne+"@"+tenantCreation_tenantThreeDomainName;
    	//store Globle variable tenant three store user one
    	store("keyTenantThreeStoreUserOne","String",varTenantThreeStoreUserOne);
    	//Globle variable tenant three store user one password
    	varTenantThreeStoreUserOnePassword = tenant_UserCreation_tenantThreeStoreUserOnePassword;
    	//store Globle variable tenant three store user One passord
    	store("keyTenantThreeStoreUserOnePassword","String",varTenantThreeStoreUserOnePassword);
    	//Globle variable tenant three store user Two
    	varTenantThreeStoreUserTwo = tenant_UserCreation_tenantThreeStoreUserNameTwo+"@"+tenantCreation_tenantThreeDomainName;
    	//store Globle variable tenant three store user Two
    	store("keyTenantThreeStoreUserTwo","String",varTenantThreeStoreUserTwo);
    	//Globle variable tenant three store user Two password
    	varTenantThreeStoreUserTwoPassword = tenant_UserCreation_tenantThreeStoreUserTwoPassword;
    	//store Globle variable tenant three store user Two passord
    	store("keyTenantThreeStoreUserTwoPassword","String",varTenantThreeStoreUserTwoPassword);
    } 
    	

    /**
     * Data provider for Test case tc_Admin_UserCreation.
     * @return data table
     */
    @DataProvider(name = "tc_Admin_UserCreation")
    public Object[][] dataTable_tc_Admin_UserCreation() {     	
    	return this.getDataTable("common","admin_UserCreation");
    }

    /**
     * Data driven test case tc_Admin_UserCreation.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Admin_UserCreation")
    public final void tc_Admin_UserCreation(final String common_superAdminUserName, final String common_superAdminPassword, final String common_carbonURL, final String common_PublisherURL, final String common_storeURL, final String admin_UserCreation_adminPublisherUserNameOne, final String admin_UserCreation_adminPublisherUserOnePassword, final String admin_UserCreation_adminRoleNameOnePublisherUserOne, final String admin_UserCreation_adminStoreUserNameOne, final String admin_UserCreation_adminStoreUserOnePassword, final String admin_UserCreation_adminRoleNameOneStoreUserOne, final String admin_UserCreation_adminPublisherUserNameTwo, final String admin_UserCreation_adminPublisherUserTwoPassword, final String admin_UserCreation_adminRoleNameOnePublisherUserTwo, final String admin_UserCreation_adminPublisherUserNameThree, final String admin_UserCreation_adminPublisherUserThreePassword, final String admin_UserCreation_adminRoleNameOnePublisherUserThree, final String admin_UserCreation_adminStoreUserNameTwo, final String admin_UserCreation_adminStoreUserTwoPassword, final String admin_UserCreation_adminRoleNameOneStoreUserTwo, final String admin_UserCreation_adminRoleNameSpecialStoreOne, final String admin_UserCreation_adminStoreUserNameThree, final String admin_UserCreation_adminStoreUserThreePassword, final String admin_UserCreation_adminStoreUserNameFour, final String admin_UserCreation_adminStoreUserFourPassword, final String admin_UserCreation_storeRoleNameFour, final String admin_UserCreation_adminStoreUserNameFive, final String admin_UserCreation_adminStoreUserFivePassword, final String admin_UserCreation_storeRoleNameFive, final String admin_UserCreation_adminStoreUserNameSix, final String admin_UserCreation_adminStoreUserSixPassword, final String admin_UserCreation_storeRoleNameSix, final String admin_UserCreation_adminStoreUserNameSeven, final String admin_UserCreation_adminStoreUserSevenPassword, final String admin_UserCreation_twoSeconds, final String admin_UserCreation_fourSeconds, final String admin_UserCreation_sixSeconds, final String admin_UserCreation_eightSeconds) throws Exception {	
    	//Admin User one
    	writeToReport("Start Of Admin User Creation One With Special Store User");
    	//Log into Carbon
    	lib_Common.bc_APICarbonLogin(this, common_superAdminUserName,common_superAdminPassword,common_carbonURL,admin_UserCreation_sixSeconds);
    	//Create Admin User And Assign role
    	varAdminRoleNameOneStoreUserOne = admin_UserCreation_adminRoleNameOneStoreUserOne;
    	//store variable tenant one publisher user one passord
    	store("KeyVisibilityRoleAdmin","String",varAdminRoleNameOneStoreUserOne);
    	String varRoleNameAdmin = retrieveString("KeyVisibilityRoleAdmin");
    	//In below the the roles are created and assigned to users except SPECIAL store where only the role is created
    	lib_Common.bc_AdminUser_CreateRoles_And_AssignRoles(this, admin_UserCreation_adminPublisherUserNameOne,admin_UserCreation_adminPublisherUserOnePassword,admin_UserCreation_adminPublisherUserOnePassword,admin_UserCreation_adminRoleNameOnePublisherUserOne,admin_UserCreation_adminStoreUserNameOne,admin_UserCreation_adminStoreUserOnePassword,admin_UserCreation_adminStoreUserOnePassword,varRoleNameAdmin,admin_UserCreation_adminRoleNameSpecialStoreOne,"yes",admin_UserCreation_fourSeconds,admin_UserCreation_sixSeconds);
    	//Globle variable  publisher user of admin
    	varAdminPublisherUserOne = admin_UserCreation_adminPublisherUserNameOne;
    	//store Globle variable  publisher user of admin
    	store("keyAdminPublisherUserOne","String",varAdminPublisherUserOne);
    	//Globle variable  publisher user of admin password
    	varAdminPublisherUserOnePassword = admin_UserCreation_adminPublisherUserOnePassword;
    	store("keyAdminPublisherUserOnePassword","String",varAdminPublisherUserOnePassword);
    	//Globle variable  store user of admin
    	varAdminStoreUserOne = admin_UserCreation_adminStoreUserNameOne;
    	//store Globle variable  store user of admin
    	store("keyAdminStoreUserOne","String",varAdminStoreUserOne);
    	varAdminStoreUserOnePassword = admin_UserCreation_adminStoreUserOnePassword;
    	store("keyAdminStoreUserOnePassword","String",admin_UserCreation_adminStoreUserOnePassword);
    	writeToReport("End Of Admin User Creation One");
    	writeToReport("Start Of Admin User Creation Two Without Special Store User");
    	//Admin User 2
    	//Log into Carbon
    	lib_Common.bc_APICarbonLogin(this, common_superAdminUserName,common_superAdminPassword,common_carbonURL,admin_UserCreation_sixSeconds);
    	//Create Admin User And Assign role
    	varAdminRoleNameOneStoreUserTwo = admin_UserCreation_adminRoleNameOneStoreUserTwo;
    	//store variable tenant one publisher user two password
    	store("KeyVisibilityRoleAdminUserTwo","String",varAdminRoleNameOneStoreUserTwo);
    	String varRoleNameAdminUserTwo = retrieveString("KeyVisibilityRoleAdminUserTwo");
    	lib_Common.bc_AdminUser_CreateRoles_And_AssignRoles_WithManageTierPermission(this, admin_UserCreation_adminPublisherUserNameTwo,admin_UserCreation_adminPublisherUserTwoPassword,admin_UserCreation_adminPublisherUserTwoPassword,admin_UserCreation_adminRoleNameOnePublisherUserTwo,admin_UserCreation_adminStoreUserNameTwo,admin_UserCreation_adminStoreUserTwoPassword,admin_UserCreation_adminStoreUserTwoPassword,varRoleNameAdminUserTwo,"","no",admin_UserCreation_sixSeconds,admin_UserCreation_eightSeconds);
    	//The below BC should be used only after creating a specific role for first user and be called for publisher and store seperately.
    	//In the below BC make sure that the ROLE name is given properly
    	writeToReport("End Of Admin User Creation Two");
    	//start of Admin publisher user three
    	//*******************************************************************************************************************************
    	//Log into Carbon
    	lib_Common.bc_APICarbonLogin(this, common_superAdminUserName,common_superAdminPassword,common_carbonURL,admin_UserCreation_sixSeconds);
    	lib_Common.bc_Create_Carbon_User(this, admin_UserCreation_adminPublisherUserNameThree,admin_UserCreation_adminPublisherUserThreePassword,admin_UserCreation_adminPublisherUserThreePassword,admin_UserCreation_fourSeconds);
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",admin_UserCreation_fourSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	click("CarbonUserRole.lnk_AddNewRole");
    	type("CarbonUserRole.tf_RoleName",admin_UserCreation_adminRoleNameOnePublisherUserThree);
    	click("CarbonUserRole.btn_Next");
    	//check role creation error popup
    	if(checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
    	fail("The Entered Role Name Does Not Meet With The Rules");
    	}
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login",admin_UserCreation_fourSeconds);
    	click("CarbonUserRole.chk_Login");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	click("CarbonUserRole.chk_Create");
    	}
    	click("CarbonUserRole.chk_governance");
    	waitForElement("CarbonUserRole.chk_govern",admin_UserCreation_fourSeconds);
    	click("CarbonUserRole.chk_govern");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_NextPermissions",admin_UserCreation_fourSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + admin_UserCreation_adminPublisherUserNameThree,admin_UserCreation_fourSeconds);
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + admin_UserCreation_adminPublisherUserNameThree);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",admin_UserCreation_fourSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",admin_UserCreation_fourSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//Globle variable  publisher user three of admin
    	varTenantOnePublisherUserThree = admin_UserCreation_adminPublisherUserNameOne;
    	//Globle variable  publisher user three of admin password
    	varAdminPublisherUserThreePassword = admin_UserCreation_adminPublisherUserThreePassword;
    	store("keyAdminPublisherUserThreePassword","String",varAdminPublisherUserThreePassword);
    	//Globle variable role one of publisher user three of admin
    	varAdminPublisherUserThree = admin_UserCreation_adminPublisherUserNameThree;
    	store("keyAdminPublisherUserThree","String",varAdminPublisherUserThree);
    	varAdminRoleNameOnePublisherUserThree = admin_UserCreation_adminRoleNameOnePublisherUserThree;
    	//*******************************************************************************************************************************
    	//End of Admin publisher user three
    	writeToReport("Start Of Assigning Special Store Role to Specific User");
    	//Log into Carbon
    	lib_Common.bc_APICarbonLogin(this, common_superAdminUserName,common_superAdminPassword,common_carbonURL,admin_UserCreation_sixSeconds);
    	//------------------------------------------------------------------------------- Admin Store User With No Subscription permision
    	//Here role name created for SPECIAL store is assigned user which was created in bc_AdminUser_CreateRoles_And_AssignRoles
    	lib_Common.bc_AdminUser_AssignCreatedRolesToUser(this, "no",admin_UserCreation_adminRoleNameSpecialStoreOne,admin_UserCreation_adminStoreUserNameThree,admin_UserCreation_adminStoreUserThreePassword,admin_UserCreation_adminStoreUserThreePassword,"","","","",admin_UserCreation_fourSeconds,admin_UserCreation_sixSeconds,admin_UserCreation_sixSeconds,admin_UserCreation_eightSeconds);
    	writeToReport("End Of Assigning Special Store Role to Specific User");
    	//Globle variable  publisher user two of admin
    	varAdminPublisherUserTwo = admin_UserCreation_adminPublisherUserNameTwo;
    	//store Globle variable  publisher user two of admin
    	store("keyAdminPublisherUserTwo","String",varAdminPublisherUserTwo);
    	//Globle variable  publisher user two of admin password
    	varAdminPublisherUserTwoPassword = admin_UserCreation_adminPublisherUserTwoPassword;
    	store("keyAdminPublisherUserTwoPassword","String",varAdminPublisherUserTwoPassword);
    	//Globle variable  store user two of admin
    	varAdminStoreUserTwo = admin_UserCreation_adminStoreUserNameTwo;
    	//store Globle variable  store user two of admin
    	store("keyAdminStoreUserTwo","String",varAdminStoreUserTwo);
    	varAdminStoreUserTwoPassword = admin_UserCreation_adminStoreUserTwoPassword;
    	store("keyAdminStoreUserTwoPassword","String",admin_UserCreation_adminStoreUserTwoPassword);
    	//Globle variable  store user three of admin
    	varAdminStoreUserThree = admin_UserCreation_adminStoreUserNameThree;
    	//store Globle variable  store user three of admin
    	store("keyAdminStoreUserThree","String",varAdminStoreUserThree);
    	varAdminStoreUserThreePassword = admin_UserCreation_adminStoreUserThreePassword;
    	store("keyAdminStoreUserThreePassword","String",admin_UserCreation_adminStoreUserThreePassword);
    	//------------------------------Creation of Role 4 for store user 4
    	//Log into Carbon
    	lib_Common.bc_APICarbonLogin(this, common_superAdminUserName,common_superAdminPassword,common_carbonURL,admin_UserCreation_sixSeconds);
    	waitForElement("APICarbonHome.btn_Configure",admin_UserCreation_sixSeconds);
    	lib_Common.bc_Create_Carbon_User(this, admin_UserCreation_adminStoreUserNameFour,admin_UserCreation_adminStoreUserFourPassword,admin_UserCreation_adminStoreUserFourPassword,admin_UserCreation_sixSeconds);
    	//Waiting for content load
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",admin_UserCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	waitForElement("CarbonUserRole.tf_RoleName",admin_UserCreation_sixSeconds);
    	type("CarbonUserRole.tf_RoleName",admin_UserCreation_storeRoleNameFour);
    	click("CarbonUserRole.btn_Next");
    	//check role creation error popup
    	if(checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
    	fail("The Entered Role Name Does Not Meet With The Rules");
    	}
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Login");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.chk_Subscribe",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Subscribe");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + admin_UserCreation_adminStoreUserNameFour,admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + admin_UserCreation_adminStoreUserNameFour);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//-------------------------------End of creation of Role 4
    	//------------------------------Creation of Role 5 for store user 5
    	waitForElement("APICarbonHome.btn_Configure",admin_UserCreation_sixSeconds);
    	lib_Common.bc_Create_Carbon_User(this, admin_UserCreation_adminStoreUserNameFive,admin_UserCreation_adminStoreUserFivePassword,admin_UserCreation_adminStoreUserFivePassword,admin_UserCreation_sixSeconds);
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",admin_UserCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	type("CarbonUserRole.tf_RoleName",admin_UserCreation_storeRoleNameFive);
    	click("CarbonUserRole.btn_Next");
    	//check role creation error popup
    	if(checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
    	fail("The Entered Role Name Does Not Meet With The Rules");
    	}
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Login");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.chk_Subscribe",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Subscribe");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + admin_UserCreation_adminStoreUserNameFive,admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + admin_UserCreation_adminStoreUserNameFive);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//-------------------------------End of creation of Role 5
    	//------------------------------Creation of Role 6 for store user 6
    	waitForElement("APICarbonHome.btn_Configure",admin_UserCreation_sixSeconds);
    	lib_Common.bc_Create_Carbon_User(this, admin_UserCreation_adminStoreUserNameSix,admin_UserCreation_adminStoreUserSixPassword,admin_UserCreation_adminStoreUserSixPassword,admin_UserCreation_sixSeconds);
    	waitForElement("APICarbonHome.lnk_UserAndRoles_Add",admin_UserCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_Add");
    	waitForElement("CarbonUserRole.lnk_AddNewRole",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.lnk_AddNewRole");
    	type("CarbonUserRole.tf_RoleName",admin_UserCreation_storeRoleNameSix);
    	click("CarbonUserRole.btn_Next");
    	//check role creation error popup
    	if(checkElementPresent("CarbonUserRole.ele_LblRoleNameErrorPopup")){
    	fail("The Entered Role Name Does Not Meet With The Rules");
    	}
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_Login",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Login");
    	if(checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.btn_NextPermissions",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	} else if(!checkElementPresent("CarbonUserRole.chk_CheckedAPI")){
    	waitForElement("CarbonUserRole.chk_Subscribe",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_Subscribe");
    	}
    	waitForElement("CarbonUserRole.btn_NextPermissions",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_NextPermissions");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + admin_UserCreation_adminStoreUserNameSix,admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.chk_UserName","param_UserName_PARAM:" + admin_UserCreation_adminStoreUserNameSix);
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_FinishAddRole",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_FinishAddRole");
    	//Waiting for content load
    	waitForElement("CarbonUserRole.btn_OkPopUp",admin_UserCreation_sixSeconds);
    	click("CarbonUserRole.btn_OkPopUp");
    	//-------------------------------End of creation of Role 6
    	//------------------------------Creation of Role 7 for store user 7
    	waitForElement("APICarbonHome.btn_Configure",admin_UserCreation_sixSeconds);
    	lib_Common.bc_Create_Carbon_User(this, admin_UserCreation_adminStoreUserNameSeven,admin_UserCreation_adminStoreUserSevenPassword,admin_UserCreation_adminStoreUserSevenPassword,admin_UserCreation_sixSeconds);
    	//Waiting for content load
    	waitForElement("APICarbonHome.lnk_UserAndRoles_List",admin_UserCreation_sixSeconds);
    	click("APICarbonHome.lnk_UserAndRoles_List");
    	//Waiting for content load
    	waitForElement("APICarbonHome.lnk_User",admin_UserCreation_sixSeconds);
    	//****************************
    	click("APICarbonHome.lnk_User");
    	checkElementPresent("CarbonAddUser.lnk_AssignRoles","param_userName_PARAM:" + admin_UserCreation_adminStoreUserNameSeven,false,"");
    	waitForElement("CarbonAddUser.lnk_AssignRoles","param_userName_PARAM:" + admin_UserCreation_adminStoreUserNameSeven,admin_UserCreation_sixSeconds);
    	click("CarbonAddUser.lnk_AssignRoles","param_userName_PARAM:" + admin_UserCreation_adminStoreUserNameSeven);
    	//add role one
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + admin_UserCreation_adminRoleNameOneStoreUserOne);
    	//add role two
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + admin_UserCreation_adminRoleNameOneStoreUserTwo);
    	//add role three
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + admin_UserCreation_storeRoleNameFour);
    	//add role four
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + admin_UserCreation_storeRoleNameFive);
    	//add role five
    	click("CarbonAddUser.chk_Role","userRole_PARAM:" + admin_UserCreation_storeRoleNameSix);
    	checkElementPresent("CarbonAddUser.btn_finish",false,"");
    	click("CarbonAddUser.btn_finish");
    	checkElementPresent("CarbonUserRole.btn_OkPopUp",false,"");
    	click("CarbonUserRole.btn_OkPopUp");
    	//-------------------------------End of creation of Role 7
    	//store global variables to admin store user 4
    	//Globle variable  store user four role of admin
    	varAdminStoreUserFourRoleOne = admin_UserCreation_storeRoleNameFour;
    	store("keyAdminStoreUserFourRoleOne","String",varAdminStoreUserFourRoleOne);
    	varAdminStoreUserFour = admin_UserCreation_adminStoreUserNameFour;
    	//store Globle variable  store user four of admin
    	store("keyAdminStoreUserFour","String",varAdminStoreUserFour);
    	varAdminStoreUserFourPassword = admin_UserCreation_adminStoreUserFourPassword;
    	store("keyAdminStoreUserFourPassword","String",admin_UserCreation_adminStoreUserFourPassword);
    	//store global variables to admin store user 5
    	//Globle variable  store user five role of admin
    	varAdminStoreUserFiveRoleOne = admin_UserCreation_storeRoleNameFive;
    	store("keyAdminStoreUserFiveRoleOne","String",varAdminStoreUserFiveRoleOne);
    	//Globle variable  store user five of admin
    	varAdminStoreUserFive = admin_UserCreation_adminStoreUserNameFive;
    	//store Globle variable  store user four of admin
    	store("keyAdminStoreUserFive","String",varAdminStoreUserFive);
    	varAdminStoreUserFivePassword = admin_UserCreation_adminStoreUserFivePassword;
    	store("keyAdminStoreUserFivePassword","String",admin_UserCreation_adminStoreUserFivePassword);
    	//store global variables to admin store user 6
    	//Globle variable  store user six role of admin
    	varAdminStoreUserSixRoleOne = admin_UserCreation_storeRoleNameSix;
    	store("keyAdminStoreUserSixRoleOne","String",varAdminStoreUserSixRoleOne);
    	//Globle variable  store user six of admin
    	varAdminStoreUserSix = admin_UserCreation_adminStoreUserNameSix;
    	//store Globle variable  store user six of admin
    	store("keyAdminStoreUserSix","String",varAdminStoreUserSix);
    	varAdminStoreUserSixPassword = admin_UserCreation_adminStoreUserSixPassword;
    	store("keyAdminStoreUserSixPassword","String",admin_UserCreation_adminStoreUserSixPassword);
    	//store global variables to admin store user 7
    	//uncomment the below if another role is to be added
    	//Globle variable  store user seven of admin
    	varAdminStoreUserSeven = admin_UserCreation_adminStoreUserNameSeven;
    	//store Globle variable  store user seven of admin
    	store("keyAdminStoreUserSeven","String",varAdminStoreUserSeven);
    	varAdminStoreUserSevenPassword = admin_UserCreation_adminStoreUserSevenPassword;
    	store("keyAdminStoreUserSevenPassword","String",admin_UserCreation_adminStoreUserSevenPassword);
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}