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
 *  Class ts_Community_Features implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_Community_Features extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_Forums.
     * @return data table
     */
    @DataProvider(name = "tc_Forums")
    public Object[][] dataTable_tc_Forums() {     	
    	return this.getDataTable("Common","SelfSignUp","Forums");
    }

    /**
     * Data driven test case tc_Forums.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Forums")
    public final void tc_Forums(final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String SelfSignUp_userName, final String SelfSignUp_password, final String SelfSignUp_firstName, final String SelfSignUp_lastName, final String SelfSignUp_email, final String SelfSignUp_serverName, final String Forums_serverName, final String Forums_userNameAdmin, final String Forums_passwordAdmin, final String Forums_topicSubject, final String Forums_topicDescription, final String Forums_storeOneOfAdmin, final String Forums_storeTwoOfAdmin, final String Forums_topicSubjectAdminUser, final String Forums_topicDescriptionAdminUser, final String Forums_topicSubject1, final String Forums_topicDescription1, final String Forums_topicSubject2, final String Forums_topicDescription2, final String Forums_topicSubject3, final String Forums_topicDescription3, final String Forums_replyContentEdit, final String Forums_replyMessageBody, final String Forums_rateStarLevelFour, final String Forums_rateStarLevelTwo) throws Exception {	
    	writeToReport("Start Executing tc_Forums.");
    	lib_TestCase.APIM_774(this, Forums_userNameAdmin,Forums_passwordAdmin,Forums_topicSubject,Forums_topicDescription,Common_storeURL,Forums_serverName);
    	lib_TestCase.APIM_775(this, Forums_storeOneOfAdmin,Common_storeURL,Forums_topicSubjectAdminUser,Forums_topicDescriptionAdminUser,Forums_serverName);
    	lib_TestCase.APIM_776(this, Common_storeURL,Forums_storeOneOfAdmin,Forums_topicDescription1,Forums_topicDescription2,Forums_topicDescription3,Forums_serverName);
    	lib_TestCase.APIM_780(this, Forums_replyMessageBody,Common_storeURL,Forums_serverName,Forums_serverName);
    	lib_TestCase.APIM_781(this, Common_storeURL,Forums_replyMessageBody,Forums_serverName);
    	lib_TestCase.APIM_782(this, Forums_storeOneOfAdmin,Forums_serverName,Forums_replyContentEdit,Common_storeURL);
    	lib_TestCase.APIM_783(this, Common_storeURL,Forums_serverName,Forums_storeOneOfAdmin);
    	lib_TestCase.APIM_784(this, Common_storeURL,Forums_serverName,Forums_storeTwoOfAdmin,Forums_rateStarLevelFour,Forums_rateStarLevelFour,Forums_rateStarLevelTwo,Forums_rateStarLevelTwo);
    	lib_TestCase.APIM2_786(this, Common_storeURL,Forums_serverName,Forums_storeTwoOfAdmin,Common_superAdminUserName,Common_superAdminPassword,Forums_storeOneOfAdmin,Forums_replyMessageBody);
    	writeToReport("End Executing tc_Forums");
    } 
    	

    /**
     * Data provider for Test case tc_Comments.
     * @return data table
     */
    @DataProvider(name = "tc_Comments")
    public Object[][] dataTable_tc_Comments() {     	
    	return this.getDataTable("URLs","Common","Comments");
    }

    /**
     * Data driven test case tc_Comments.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Comments")
    public final void tc_Comments(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String Comments_APIName, final String Comments_APIContext, final String Comments_APITag, final String Comments_Description, final String Comments_URLPattern, final String Comments_verbMethodGET, final String Comments_ProductionEndPontJaxRS, final String Comments_Comments, final String Comments_tenantOrAdminStoreOne, final String Comments_tenantOrAdminPublisherOne, final String Comments_serverNameDomainOne) throws Exception {	
    	//788,789
    	writeToReport("start executing Comments");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,Comments_tenantOrAdminPublisherOne);
    	lib_TestCase.APIM2_788(this, Comments_APIName,Comments_APIContext,Comments_APITag,Comments_Description,Comments_URLPattern,Comments_verbMethodGET,Comments_ProductionEndPontJaxRS,Comments_Comments,Comments_tenantOrAdminStoreOne,Comments_tenantOrAdminPublisherOne,Comments_serverNameDomainOne,URLs_storeURL);
    	lib_TestCase.APIM2_789(this, URLs_storeURL,Comments_serverNameDomainOne);
    	String varAPINameOne = retrieveString("keyAPIName");
    	//Delete created API
    	lib_Common.bc_DeleteAPI(this, varAPINameOne,URLs_publisherURL);
    	writeToReport("End of executing Comments");
    } 
    	

    /**
     * Data provider for Test case tc_Ratings.
     * @return data table
     */
    @DataProvider(name = "tc_Ratings")
    public Object[][] dataTable_tc_Ratings() {     	
    	return this.getDataTable("URLs","Common","Ratings");
    }

    /**
     * Data driven test case tc_Ratings.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_Ratings")
    public final void tc_Ratings(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String Common_superAdminUserName, final String Common_superAdminPassword, final String Common_carbonURL, final String Common_PublisherURL, final String Common_storeURL, final String Ratings_tenantOrAdminPublisherOne, final String Ratings_APIName, final String Ratings_APIContext, final String Ratings_APITag, final String Ratings_Description, final String Ratings_URLPattern, final String Ratings_verbMethodGET, final String Ratings_ProductionEndPontJaxRS, final String Ratings_tenantOrAdminStoreOne, final String Ratings_serverNameDomainOne, final String Ratings_RateStarLevelThree, final String Ratings_RateStarLevelFour, final String Ratings_RateStarLevelTwo, final String Ratings_tenantOrAdminStoreTwo) throws Exception {	
    	//794,798,799
    	writeToReport("start executing Ratings");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,Ratings_tenantOrAdminPublisherOne);
    	lib_TestCase.APIM2_794(this, Ratings_APIName,Ratings_APIContext,Ratings_APITag,Ratings_URLPattern,Ratings_verbMethodGET,Ratings_ProductionEndPontJaxRS,URLs_storeURL,Ratings_serverNameDomainOne,Ratings_tenantOrAdminStoreOne,Ratings_RateStarLevelThree,Ratings_RateStarLevelFour,Ratings_RateStarLevelTwo,Ratings_tenantOrAdminStoreTwo,Ratings_Description);
    	String varAPINameOne = retrieveString("keyAPIName");
    	//Delete created API
    	lib_Common.bc_DeleteAPI(this, varAPINameOne,URLs_publisherURL);
    	writeToReport("End of executing Ratings");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}