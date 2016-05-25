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
 *  Class ts_APIResources implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_APIResources extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_URLTemplates.
     * @return data table
     */
    @DataProvider(name = "tc_URLTemplates")
    public Object[][] dataTable_tc_URLTemplates() {     	
    	return this.getDataTable("URLs","URLTemplate","PauseTimes");
    }

    /**
     * Data driven test case tc_URLTemplates.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_URLTemplates")
    public final void tc_URLTemplates(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String URLTemplate_domain, final String URLTemplate_APIName, final String URLTemplate_urlPatternSC, final String URLTemplate_verbGet, final String URLTemplate_verbPost, final String URLTemplate_APIContext, final String URLTemplate_APITag, final String URLTemplate_URLPatternSandbox, final String URLTemplate_APIVersion, final String URLTemplate_urlPatternUriTemplate, final String URLTemplate_verbPut, final String URLTemplate_verbDelete, final String URLTemplate_urlPatternComplex, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start Executing Test suit URLTemplates");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,URLTemplate_domain,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_73(this, URLTemplate_APIName,URLTemplate_urlPatternSC,URLTemplate_verbGet,URLTemplate_verbPost,URLTemplate_APIContext,URLTemplate_APITag,URLTemplate_URLPatternSandbox,URLTemplate_APIVersion,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	lib_TestCase.APIM_74(this, URLTemplate_urlPatternUriTemplate,URLTemplate_verbGet,URLTemplate_verbPost,PauseTimes_fiveSeconds);
    	lib_TestCase.APIM_75(this, URLTemplate_urlPatternUriTemplate,URLTemplate_verbGet,URLTemplate_verbPost,URLTemplate_verbPut,URLTemplate_verbDelete,PauseTimes_fiveSeconds);
    	lib_TestCase.APIM_78(this, URLTemplate_urlPatternComplex,URLTemplate_verbGet,URLTemplate_verbPost,PauseTimes_fiveSeconds);
    	//Retrieving the created API name
    	String varAPINameOneURITemplateOne = retrieveString("keyAPINameURITemplate");
    	lib_Common.bc_DeleteAPI(this, varAPINameOneURITemplateOne,URLs_publisherURL,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	writeToReport("End of  Executing Test suit URLTemplates");
    } 
    	

    /**
     * Data provider for Test case tc_Resource_level_Security.
     * @return data table
     */
    @DataProvider(name = "tc_Resource_level_Security")
    public Object[][] dataTable_tc_Resource_level_Security() {     	
    	return this.getDataTable("URLs","Resourcelevelsecurity","PauseTimes");
    }

    /**
     * Data driven test case tc_Resource_level_Security.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Resource_level_Security")
    public final void tc_Resource_level_Security(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Resourcelevelsecurity_domain, final String Resourcelevelsecurity_APIName, final String Resourcelevelsecurity_APIVersion, final String Resourcelevelsecurity_APIImagePath, final String Resourcelevelsecurity_tagName, final String Resourcelevelsecurity_verbGet, final String Resourcelevelsecurity_verbPost, final String Resourcelevelsecurity_verbPut, final String Resourcelevelsecurity_verbOption, final String Resourcelevelsecurity_ProductionEndpointUrl, final String Resourcelevelsecurity_Application, final String Resourcelevelsecurity_ApplicationUser, final String Resourcelevelsecurity_ApplicationAndApplicationUse, final String Resourcelevelsecurity_None, final String Resourcelevelsecurity_newVersion, final String PauseTimes_oneSecond, final String PauseTimes_twoSeconds, final String PauseTimes_threeSeconds, final String PauseTimes_fourSeconds, final String PauseTimes_fiveSeconds, final String PauseTimes_sixSeconds, final String PauseTimes_sevenSeconds, final String PauseTimes_eightSeconds, final String PauseTimes_nineSeconds, final String PauseTimes_tenSeconds, final String PauseTimes_elevenSeconds, final String PauseTimes_twelveSeconds, final String PauseTimes_thirteenSeconds, final String PauseTimes_fourteenSeconds, final String PauseTimes_fifteenSeconds) throws Exception {	
    	writeToReport("Start Executing Test suit Resourcelevelsecurity");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,Resourcelevelsecurity_domain,PauseTimes_threeSeconds,PauseTimes_fourSeconds);
    	lib_TestCase.APIM_422(this, Resourcelevelsecurity_APIName,Resourcelevelsecurity_APIVersion,Resourcelevelsecurity_APIImagePath,Resourcelevelsecurity_tagName,Resourcelevelsecurity_verbGet,Resourcelevelsecurity_verbPost,Resourcelevelsecurity_verbPut,Resourcelevelsecurity_verbOption,Resourcelevelsecurity_ProductionEndpointUrl,Resourcelevelsecurity_Application,Resourcelevelsecurity_ApplicationUser,Resourcelevelsecurity_ApplicationAndApplicationUse,Resourcelevelsecurity_None,Resourcelevelsecurity_newVersion,PauseTimes_oneSecond,PauseTimes_twoSeconds,PauseTimes_threeSeconds,PauseTimes_fiveSeconds,PauseTimes_sevenSeconds);
    	String varAPINameResourceLevelSecurity = retrieveString("keyAPINameResourceLevelSecurity");
    	lib_Common.bc_DeleteAPI(this, varAPINameResourceLevelSecurity,URLs_publisherURL,PauseTimes_twoSeconds,PauseTimes_fourSeconds,PauseTimes_sixSeconds);
    	writeToReport("End of  Executing Test suit Resourcelevelsecurity");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}