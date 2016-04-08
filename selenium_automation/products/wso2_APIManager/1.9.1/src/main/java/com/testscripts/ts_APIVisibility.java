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
 *  Class ts_APIVisibility implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APIVisibility extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_Visible_To_Everyone.
     * @return data table
     */
    @DataProvider(name = "tc_Visible_To_Everyone")
    public Object[][] dataTable_tc_Visible_To_Everyone() {     	
    	return this.getDataTable("URLs","VisibleToEveryone","PauseTimes");
    }

    /**
     * Data driven test case tc_Visible_To_Everyone.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Visible_To_Everyone")
    public final void tc_Visible_To_Everyone(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String VisibleToEveryone_apiName, final String VisibleToEveryone_apiContext, final String VisibleToEveryone_apiVersion, final String VisibleToEveryone_tagName, final String VisibleToEveryone_productionEndpoint, final String VisibleToEveryone_sandboxEndpoint, final String VisibleToEveryone_apiVisibility, final String VisibleToEveryone_serverNameDomainOne, final String VisibleToEveryone_serverNameDomainTwo, final String VisibleToEveryone_apiImagePath, final String VisibleToEveryone_tenantOrAdminStoreOne, final String VisibleToEveryone_tenantOrAdminStoreTwo, final String VisibleToEveryone_tenantOrAdminPublisherOne, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of TS Visible_To_Everyone");
    	lib_TestCase.APIM_60(this, URLs_storeURL,VisibleToEveryone_apiName,VisibleToEveryone_serverNameDomainTwo,VisibleToEveryone_serverNameDomainOne,VisibleToEveryone_apiVisibility,VisibleToEveryone_apiContext,VisibleToEveryone_apiVersion,VisibleToEveryone_apiImagePath,VisibleToEveryone_tagName,VisibleToEveryone_productionEndpoint,VisibleToEveryone_sandboxEndpoint,URLs_publisherURL,VisibleToEveryone_tenantOrAdminStoreOne,VisibleToEveryone_tenantOrAdminPublisherOne,VisibleToEveryone_tenantOrAdminStoreTwo,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	String var_APINameToDelete = retrieveString("key_APIName");
    	lib_Common.bc_DeleteAPI(this, var_APINameToDelete,URLs_publisherURL,PauseTimes_threeSeconds,PauseTimes_fiveSeconds,PauseTimes_sevenSeconds);
    	writeToReport("End of TS Visible_To_Everyone");
    } 
    	

    /**
     * Data provider for Test case tc_Visible_To_All_Users_In_specific_Domain.
     * @return data table
     */
    @DataProvider(name = "tc_Visible_To_All_Users_In_specific_Domain")
    public Object[][] dataTable_tc_Visible_To_All_Users_In_specific_Domain() {     	
    	return this.getDataTable("URLs","VisibleToAllUsersInSpecificDomain","PauseTimes");
    }

    /**
     * Data driven test case tc_Visible_To_All_Users_In_specific_Domain.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Visible_To_All_Users_In_specific_Domain")
    public final void tc_Visible_To_All_Users_In_specific_Domain(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String VisibleToAllUsersInSpecificDomain_apiName, final String VisibleToAllUsersInSpecificDomain_apiContext, final String VisibleToAllUsersInSpecificDomain_apiVersion, final String VisibleToAllUsersInSpecificDomain_apiVisibility, final String VisibleToAllUsersInSpecificDomain_tagName, final String VisibleToAllUsersInSpecificDomain_serverNameDomainOne, final String VisibleToAllUsersInSpecificDomain_serverNameDomainTwo, final String VisibleToAllUsersInSpecificDomain_tenantOrAdminStoreOne, final String VisibleToAllUsersInSpecificDomain_tenantOrAdminStoreTwo, final String VisibleToAllUsersInSpecificDomain_tenantOrAdminPublisherOne, final String VisibleToAllUsersInSpecificDomain_productionEndpoint, final String VisibleToAllUsersInSpecificDomain_sandboxEndpoint, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of TS Visible_To_All_Users_In_specific_Domain");
    	lib_TestCase.APIM_61(this, URLs_publisherURL,VisibleToAllUsersInSpecificDomain_apiName,VisibleToAllUsersInSpecificDomain_serverNameDomainTwo,URLs_storeURL,VisibleToAllUsersInSpecificDomain_serverNameDomainOne,VisibleToAllUsersInSpecificDomain_tenantOrAdminStoreOne,VisibleToAllUsersInSpecificDomain_apiContext,VisibleToAllUsersInSpecificDomain_apiVersion,VisibleToAllUsersInSpecificDomain_apiVisibility,VisibleToAllUsersInSpecificDomain_tagName,VisibleToAllUsersInSpecificDomain_tenantOrAdminStoreTwo,VisibleToAllUsersInSpecificDomain_tenantOrAdminPublisherOne,VisibleToAllUsersInSpecificDomain_productionEndpoint,VisibleToAllUsersInSpecificDomain_sandboxEndpoint,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_sixSeconds);
    	String var_APINameSpecificDomain = retrieveString("key_APIName");
    	lib_Common.bc_DeleteAPI(this, var_APINameSpecificDomain,URLs_publisherURL,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	writeToReport("End of TS Visible_To_All_Users_In_specific_Domain");
    } 
    	

    /**
     * Data provider for Test case tc_Visible_Only_To_Specified_Roles_In_Tenant_Domain.
     * @return data table
     */
    @DataProvider(name = "tc_Visible_Only_To_Specified_Roles_In_Tenant_Domain")
    public Object[][] dataTable_tc_Visible_Only_To_Specified_Roles_In_Tenant_Domain() {     	
    	return this.getDataTable("URLs","VisibleOnlyToSpecifiedRolesInTenantDomain","DeleteAllApplicationsAndAPIsFromAllTenants","PauseTimes");
    }

    /**
     * Data driven test case tc_Visible_Only_To_Specified_Roles_In_Tenant_Domain.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Visible_Only_To_Specified_Roles_In_Tenant_Domain")
    public final void tc_Visible_Only_To_Specified_Roles_In_Tenant_Domain(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String VisibleOnlyToSpecifiedRolesInTenantDomain_apiName, final String VisibleOnlyToSpecifiedRolesInTenantDomain_apiContext, final String VisibleOnlyToSpecifiedRolesInTenantDomain_apiVersion, final String VisibleOnlyToSpecifiedRolesInTenantDomain_apiVisibility, final String VisibleOnlyToSpecifiedRolesInTenantDomain_tagName, final String VisibleOnlyToSpecifiedRolesInTenantDomain_productionEndpoint, final String VisibleOnlyToSpecifiedRolesInTenantDomain_sandboxEndpoint, final String VisibleOnlyToSpecifiedRolesInTenantDomain_serverNameDomainOne, final String VisibleOnlyToSpecifiedRolesInTenantDomain_serverNameDomainTwo, final String VisibleOnlyToSpecifiedRolesInTenantDomain_storeOneOfTenantOneOrAdmin, final String VisibleOnlyToSpecifiedRolesInTenantDomain_storeOneOfTenantTwoOrAdmin, final String VisibleOnlyToSpecifiedRolesInTenantDomain_publisherOneOfTenantOneOrAdmin, final String VisibleOnlyToSpecifiedRolesInTenantDomain_storeTwoOfTenantOneOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainOneTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOrAdminPublisherUser, final String DeleteAllApplicationsAndAPIsFromAllTenants_DefaultApplication, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantOneOrAdminStoreUserThree, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainTwoTenantOrAdmin, final String DeleteAllApplicationsAndAPIsFromAllTenants_DomainCondition, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_TenantTwoOrAdminPublisherUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserOne, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminStoreUserTwo, final String DeleteAllApplicationsAndAPIsFromAllTenants_AdminPublisherUserOne, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start of TS Visible_Only_To_Specified_Roles_In_Tenant_Domain");
    	String varRoleNameOfTenantOneStoreOneAPIMSixtyTwo = retrieveString("KeyVisibilityRole");
    	String varRoleNameOfAdminStoreOneAPIMSixtyTwo = retrieveString("KeyVisibilityRoleAdmin");
    	String varRoleNameOfAdminStoreTwoAPIMSixtyTwo = retrieveString("KeyVisibilityRoleAdminUserTwo");
    	String varRoleNameOfTenantOneStoreTwoAPIMSixtyTwo = retrieveString("KeyVisibilityT1RoleNameOneStoreUserTwo");
    	if(VisibleOnlyToSpecifiedRolesInTenantDomain_publisherOneOfTenantOneOrAdmin.equals("TenantOnePublisherOne")){
    	lib_TestCase.APIM_62(this, URLs_publisherURL,VisibleOnlyToSpecifiedRolesInTenantDomain_apiName,URLs_storeURL,VisibleOnlyToSpecifiedRolesInTenantDomain_publisherOneOfTenantOneOrAdmin,VisibleOnlyToSpecifiedRolesInTenantDomain_apiContext,VisibleOnlyToSpecifiedRolesInTenantDomain_apiVersion,VisibleOnlyToSpecifiedRolesInTenantDomain_apiVisibility,VisibleOnlyToSpecifiedRolesInTenantDomain_tagName,VisibleOnlyToSpecifiedRolesInTenantDomain_productionEndpoint,VisibleOnlyToSpecifiedRolesInTenantDomain_sandboxEndpoint,VisibleOnlyToSpecifiedRolesInTenantDomain_serverNameDomainOne,VisibleOnlyToSpecifiedRolesInTenantDomain_storeOneOfTenantOneOrAdmin,varRoleNameOfTenantOneStoreOneAPIMSixtyTwo,VisibleOnlyToSpecifiedRolesInTenantDomain_storeTwoOfTenantOneOrAdmin,PauseTimes_twoSeconds,PauseTimes_fiveSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	String varAPINameVisibleOnlyToSpecifiedRolesInTenantDomain = retrieveString("key_APIName");
    	//Below TC has two tenants
    	lib_TestCase.APIM_64(this, varAPINameVisibleOnlyToSpecifiedRolesInTenantDomain,VisibleOnlyToSpecifiedRolesInTenantDomain_serverNameDomainTwo,URLs_storeURL,URLs_publisherURL,VisibleOnlyToSpecifiedRolesInTenantDomain_serverNameDomainOne,VisibleOnlyToSpecifiedRolesInTenantDomain_storeOneOfTenantOneOrAdmin,VisibleOnlyToSpecifiedRolesInTenantDomain_storeOneOfTenantTwoOrAdmin,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds,VisibleOnlyToSpecifiedRolesInTenantDomain_apiVersion);
    	lib_TestCase.APIM_65(this, URLs_publisherURL,varRoleNameOfTenantOneStoreOneAPIMSixtyTwo+","+varRoleNameOfTenantOneStoreTwoAPIMSixtyTwo,URLs_storeURL,varAPINameVisibleOnlyToSpecifiedRolesInTenantDomain,VisibleOnlyToSpecifiedRolesInTenantDomain_storeOneOfTenantOneOrAdmin,VisibleOnlyToSpecifiedRolesInTenantDomain_storeTwoOfTenantOneOrAdmin,VisibleOnlyToSpecifiedRolesInTenantDomain_serverNameDomainOne,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_Common.bc_DeleteAPI(this, varAPINameVisibleOnlyToSpecifiedRolesInTenantDomain,URLs_publisherURL,PauseTimes_twoSeconds,PauseTimes_fiveSeconds,PauseTimes_sixSeconds);
    	} else if(VisibleOnlyToSpecifiedRolesInTenantDomain_publisherOneOfTenantOneOrAdmin.equals("AdminPublisherOne")){
    	lib_TestCase.APIM_62(this, URLs_publisherURL,VisibleOnlyToSpecifiedRolesInTenantDomain_apiName,URLs_storeURL,VisibleOnlyToSpecifiedRolesInTenantDomain_publisherOneOfTenantOneOrAdmin,VisibleOnlyToSpecifiedRolesInTenantDomain_apiContext,VisibleOnlyToSpecifiedRolesInTenantDomain_apiVersion,VisibleOnlyToSpecifiedRolesInTenantDomain_apiVisibility,VisibleOnlyToSpecifiedRolesInTenantDomain_tagName,VisibleOnlyToSpecifiedRolesInTenantDomain_productionEndpoint,VisibleOnlyToSpecifiedRolesInTenantDomain_sandboxEndpoint,VisibleOnlyToSpecifiedRolesInTenantDomain_serverNameDomainOne,VisibleOnlyToSpecifiedRolesInTenantDomain_storeOneOfTenantOneOrAdmin,varRoleNameOfAdminStoreOneAPIMSixtyTwo,VisibleOnlyToSpecifiedRolesInTenantDomain_storeTwoOfTenantOneOrAdmin,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	String varAPINameVisibleOnlyToSpecifiedRolesInTenantDomain = retrieveString("key_APIName");
    	//Below TC has two tenants
    	lib_TestCase.APIM_64(this, varAPINameVisibleOnlyToSpecifiedRolesInTenantDomain,VisibleOnlyToSpecifiedRolesInTenantDomain_serverNameDomainTwo,URLs_storeURL,URLs_publisherURL,VisibleOnlyToSpecifiedRolesInTenantDomain_serverNameDomainOne,VisibleOnlyToSpecifiedRolesInTenantDomain_storeOneOfTenantOneOrAdmin,VisibleOnlyToSpecifiedRolesInTenantDomain_storeOneOfTenantTwoOrAdmin,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds,VisibleOnlyToSpecifiedRolesInTenantDomain_apiVersion);
    	lib_TestCase.APIM_65(this, URLs_publisherURL,varRoleNameOfAdminStoreOneAPIMSixtyTwo+","+varRoleNameOfAdminStoreTwoAPIMSixtyTwo,URLs_storeURL,varAPINameVisibleOnlyToSpecifiedRolesInTenantDomain,VisibleOnlyToSpecifiedRolesInTenantDomain_storeOneOfTenantOneOrAdmin,VisibleOnlyToSpecifiedRolesInTenantDomain_storeTwoOfTenantOneOrAdmin,VisibleOnlyToSpecifiedRolesInTenantDomain_serverNameDomainOne,PauseTimes_fourSeconds,PauseTimes_sixSeconds,PauseTimes_eightSeconds);
    	lib_Common.bc_DeleteAPI(this, varAPINameVisibleOnlyToSpecifiedRolesInTenantDomain,URLs_publisherURL,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	}
    	writeToReport("End of TS Visible_Only_To_Specified_Roles_In_Tenant_Domain");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}