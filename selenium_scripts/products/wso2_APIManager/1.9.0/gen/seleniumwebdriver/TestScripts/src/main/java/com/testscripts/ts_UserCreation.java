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
    public final void tc_Tenant_Creation(final String TenantCreation_tenantOneDomainName, final String TenantCreation_tenantOneFirstName, final String TenantCreation_tenantOneLastName, final String TenantCreation_adminUsernameTenantOne, final String TenantCreation_adminPasswordTenantOne, final String TenantCreation_emailAddressTenantDomainOne, final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL) throws Exception {	
    	lib_Common.bc_CreateTenant(this, Common_superAdminUserName,Common_superAdminPassword,TenantCreation_tenantOneFirstName,TenantCreation_tenantOneLastName,TenantCreation_adminUsernameTenantOne,TenantCreation_adminPasswordTenantOne,TenantCreation_emailAddressTenantDomainOne,Common_carbonURL,TenantCreation_tenantOneDomainName);
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
    public final void tc_Tenant_UserCreation(final String TenantCreation_tenantOneDomainName, final String TenantCreation_tenantOneFirstName, final String TenantCreation_tenantOneLastName, final String TenantCreation_adminUsernameTenantOne, final String TenantCreation_adminPasswordTenantOne, final String TenantCreation_emailAddressTenantDomainOne, final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String Tenant_UserCreation_tenantOnePublisherUserNameOne, final String Tenant_UserCreation_tenantOnePublisherUserOnePassword, final String Tenant_UserCreation_tenantOneRoleNameOnePublisherUserOne, final String Tenant_UserCreation_tenantOneStoreUserNameOne, final String Tenant_UserCreation_tenantOneStoreUserOnePassword, final String Tenant_UserCreation_tenantOneRoleNameOneStoreUserOne) throws Exception {	
    	//Log into Carbon
    	String varTenantOneAdminUserName = retrieveString("keyTenantOneAdminUser");
    	lib_Common.bc_APIcarbonLogin(this, varTenantOneAdminUserName,TenantCreation_adminPasswordTenantOne,Common_carbonURL);
    	//Create Tenant User Using creted tenant and  assign roles
    	varTenantOneRoleNameOneStoreUserOne = Tenant_UserCreation_tenantOneRoleNameOneStoreUserOne;
    	//store variable tenant one publisher user one passord
    	store("KeyVisibilityRole","String",varTenantOneRoleNameOneStoreUserOne);
    	String varRoleNameTenant = retrieveString("KeyVisibilityRole");
    	lib_Common.bc_TenantUser_CreateRoles_And_AssignRoles(this, Tenant_UserCreation_tenantOnePublisherUserNameOne,Tenant_UserCreation_tenantOnePublisherUserOnePassword,Tenant_UserCreation_tenantOnePublisherUserOnePassword,Tenant_UserCreation_tenantOneRoleNameOnePublisherUserOne,Tenant_UserCreation_tenantOneStoreUserNameOne,Tenant_UserCreation_tenantOneStoreUserOnePassword,Tenant_UserCreation_tenantOneStoreUserOnePassword,varRoleNameTenant);
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
    public final void tc_Admin_UserCreation(final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String Admin_UserCreation_adminPublisherUserNameOne, final String Admin_UserCreation_adminPublisherUserOnePassword, final String Admin_UserCreation_adminRoleNameOnePublisherUserOne, final String Admin_UserCreation_adminStoreUserNameOne, final String Admin_UserCreation_adminStoreUserOnePassword, final String Admin_UserCreation_adminRoleNameOneStoreUserOne) throws Exception {	
    	//Log into Carbon
    	lib_Common.bc_APIcarbonLogin(this, Common_superAdminUserName,Common_superAdminPassword,Common_carbonURL);
    	//Create Admin User And Assign role
    	varAdminRoleNameOneStoreUserOne = Admin_UserCreation_adminRoleNameOneStoreUserOne;
    	//store variable tenant one publisher user one passord
    	store("KeyVisibilityRoleAdmin","String",varAdminRoleNameOneStoreUserOne);
    	String varRoleNameAdmin = retrieveString("KeyVisibilityRoleAdmin");
    	lib_Common.bc_AdminUser_CreateRoles_And_AssignRoles(this, Admin_UserCreation_adminPublisherUserNameOne,Admin_UserCreation_adminPublisherUserOnePassword,Admin_UserCreation_adminPublisherUserOnePassword,Admin_UserCreation_adminRoleNameOnePublisherUserOne,Admin_UserCreation_adminStoreUserNameOne,Admin_UserCreation_adminStoreUserOnePassword,Admin_UserCreation_adminStoreUserOnePassword,varRoleNameAdmin);
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
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}