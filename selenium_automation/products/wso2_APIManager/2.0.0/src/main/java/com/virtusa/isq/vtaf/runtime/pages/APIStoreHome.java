package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIStoreHome implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIStoreHome {

        lnk_PrototypedAPIs("link=Prototyped APIs"), lnk_APIs("//span[@class='left-menu-item ' and contains(text(),'APIs')]"), img_APIStoreAvailableServer("//h3[contains(text(),'<param_serverName>')]"), lnk_login("//a[@id='login-link']"), tf_username("//input[@id='username'][1]"), tf_password("//input[@id='password'][1]"), btn_login("//button[@id='loginBtn']"), lnk_PublishedAPI("//a[contains(text(),'<param_APIName>-<param_version>')]"), btn_Logout("//a[@id='logout-link']"), lnk_MySubcription("//a[@class='link-mysubscriptions']"), lnk_MyApplication("//a[@class='link-myapplications']"), lnk_iconMyApplication("//a[@class='link-myapplications need-login']"), tf_APISearchStore("//input[@name='query']"), btn_SearchButtonStore("//button[@class='btn btn-default wrap-input-right']"), lnk_APINameStore("xpath=(//a[contains(text(),'<param_APIName>')])[2]"), lnk_PublicApiStore("//a[text()='Public API Store']"), lnk_LogOutDropDown("//span[@class='caret']"), btn_cancel("//a[text()='Cancel']"), ele_lblNoMatchingAPI("//*[contains(text(),'No matching results')]"), lnk_APINameStoreWithVersion("//a[contains(text(),'<param_APIName>')]/../../h5/a[contains(text(),'<param_versionNumber>')]"), btn_SignUp("//a[@id='register-link']"), tf_CommentsOfAPI("//textarea[@id='comment-text']"), btn_AddComment("//button[@id='comment-add-button']"), ele_StoreUserName("//strong[text()='<param_storeUserName>']"), ele_CommentText("//div[text()='<param_comments>']"), ele_lblComments("//*[text()='Comments:']"), btn_RemoveRatingsOfAPI("css=a[class=\"remove-rating\"]"), btn_nextSubscribed("//a[contains(text(),'>>')]"), ele_lblPagination("xpath=(//div[@class='pagination']/ul/li)[last()-1]//a"), ele_lblPaginationVisible("xpath=//div[@class='pagination']/ul/li/a[contains(text(),'>>')]"), lnk_APINameStoreWithVersionAndProvider("//a[contains(text(),'<param_APIName>-<param_APIVersion>')]/../div/a[contains(text(),'<param_provider>')]"), lnk_Statistics("link=Statistics"), ele_lblStoreStatistics("//*[text()='Store Statistics']"), ele_ddSelectStatistics("//a[contains(text(),'<param_Statistics>')]"), img_facebook("//img[@alt='Facebook']"), img_Twitter("//img[@alt='Twitter']"), ele_lblSearchTermIsMissing("//div/h4[contains(text(),\"<param_searchTermIsMissing>\")]"), ele_lblDocumentSearchResult_documentName("//div/li/div/h5[contains(text(),'<param_documentName>')]"), ele_lblDocumentSearchResult_documentSummary("//div/li/div/h5[contains(text(),'<param_documentName>')]/../h6[contains(text(),'Summary')]/../p[contains(text(),'<param_summaryContent>')][1]"), lnk_documentSearchResult_viewContent("//div/li/div/h5[contains(text(),'<param_documentName>')]/../div/a"), lnk_documentSearchResult_download("//ul[@class='thumbnails']/div/li/div/h5[contains(text(),'<param_documentName>')]/../p/a"), lnk_documentSearchResult_APINameOrVersion("//div/li/div/h5[contains(text(),'<param_documentName>')]/../../div[2]/div/a[contains(text(),'<param_APINameOrVersion>')]"), ele_lblDocumentSearchResult_provider("//div/li/div/h5[contains(text(),'<param_documentName>')]/../../div[2]/div[2]/a[contains(text(),'<param_provider>')]"), ele_lblSearchMissing("//strong[contains(text(),' Search term is missing. Try again with valid search query.')]"), lnk_Documents("//a[text()='Documentation']");

    private String searchPath;
  
    /**
    *  Page APIStoreHome.
    */
    private APIStoreHome(final String psearchPath) {
        this.searchPath = psearchPath;
    }
    
    /**
     *  Get search path.
     * @param searchPath search path.
     */
    public final String getSearchPath() {
        return searchPath;
    }
}