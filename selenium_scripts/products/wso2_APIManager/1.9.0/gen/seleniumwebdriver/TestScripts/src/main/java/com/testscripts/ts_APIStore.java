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
 *  Class ts_APIStore implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APIStore extends SeleniumTestBase {



    /**
     * Test case tc_Subscription.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_Subscription() throws Exception {
    } 
    	

    /**
     * Test case tc_APIConsole.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_APIConsole() throws Exception {
    } 
    	

    /**
     * Test case tc_API_Overview.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_API_Overview() throws Exception {
    } 
    	

    /**
     * Test case tc_API_Store_Types.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_API_Store_Types() throws Exception {
    } 
    	

    /**
     * Test case tc_Self_Signup.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_Self_Signup() throws Exception {
    } 
    	

    /**
     * Test case tc_List_Search_APIs_of_Store.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {})
    @Test
    public final void tc_List_Search_APIs_of_Store() throws Exception {
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}