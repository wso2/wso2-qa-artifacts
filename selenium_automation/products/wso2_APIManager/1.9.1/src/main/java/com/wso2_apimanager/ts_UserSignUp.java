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
 *  Class ts_UserSignUp implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_UserSignUp extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_UserSignUp.
     * @return data table
     */
    @DataProvider(name = "tc_UserSignUp")
    public Object[][] dataTable_tc_UserSignUp() {     	
    	return this.getDataTable("Common","UserSignUp");
    }

    /**
     * Data driven test case tc_UserSignUp.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_UserSignUp")
    public final void tc_UserSignUp(final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String UserSignUp_userName, final String UserSignUp_password, final String UserSignUp_passwordShort, final String UserSignUp_passwordLong, final String UserSignUp_longPasswordError, final String UserSignUp_shortPasswordError, final String UserSignUp_adminOrTenantOne, final String UserSignUp_firstName, final String UserSignUp_lastName, final String UserSignUp_email, final String UserSignUp_organizationName, final String UserSignUp_address, final String UserSignUp_country, final String UserSignUp_landPhone, final String UserSignUp_mobilePhone, final String UserSignUp_IM, final String UserSignUp_URL, final String UserSignUp_userNameShort) throws Exception {	
    	writeToReport("Start of ts_UserSignUp");
    	lib_TestCase.APIM2_1036(this, Common_storeURL,UserSignUp_adminOrTenantOne,UserSignUp_userName,UserSignUp_password);
    	lib_TestCase.APIM2_1034(this, Common_storeURL,UserSignUp_adminOrTenantOne,UserSignUp_userName,UserSignUp_passwordShort,UserSignUp_passwordLong,UserSignUp_longPasswordError,UserSignUp_shortPasswordError);
    	lib_TestCase.APIM2_1032(this, Common_storeURL,UserSignUp_adminOrTenantOne,UserSignUp_userName,UserSignUp_password,UserSignUp_firstName,UserSignUp_lastName,UserSignUp_email,UserSignUp_organizationName,UserSignUp_address,UserSignUp_country,UserSignUp_landPhone,UserSignUp_mobilePhone,UserSignUp_IM,UserSignUp_URL);
    	lib_TestCase.APIM2_1031(this, Common_storeURL,UserSignUp_adminOrTenantOne,UserSignUp_userNameShort);
    	writeToReport("End of ts_UserSignUp");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}