package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIStoreHome implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIStoreHome {

        lnk_PrototypedAPIs("link=Prototyped APIs"), lnk_APIs("link=APIs"), img_APIStoreAvailableServer("//h3[contains(text(),'<param_serverName>')]"), lnk_login("//a[@id='login-link']"), tf_username("//input[@id='username'][1]"), tf_password("//input[@id='password'][1]"), btn_login("//a[@id='loginBtn']"), lnk_PublishedAPI("//a[contains(text(),'<param_APIName>-<param_version>')]"), btn_Logout("//button[contains(text(),'Logout')]"), lnk_MySubcription("//a[@class='link-mysubscriptions']"), lnk_MyApplication("//a[@class='link-myapplications']"), lnk_iconMyApplication("//a[@class='link-myapplications need-login']"), tf_APISearchStore("//input[@name='query']"), btn_SearchButtonStore("//button[@class='btn btn-primary search-button']"), lnk_APINameStore("//div[@class=\"caption\"]/a[@title='<param_APIName>']"), lnk_PublicApiStore("//a[text()='Public API Store']"), lnk_LogOutDropDown("//a[@class='link-to-user dropdown-toggle']"), btn_cancel("//a[text()='Cancel']"), ele_lblNoMatchingAPI("//strong[text()='No matching results']"), lnk_APINameStoreWithVersion("//div[@class=\"caption\"]/a[@title=\"<param_APIName>\"]/../div[contains(text(),\"<param_versionNumber>\")]/../a[1]"), btn_SignUp("//a[@id='register-link']"), tf_CommentsOfAPI("//textarea[@id='comment-text']"), btn_AddComment("//button[@id='comment-add-button']"), ele_StoreUserName("//strong[text()='<param_storeUserName>']"), ele_CommentText("//div[text()='<param_comments>']"), ele_lblComments("//*[text()='Comments:']"), btn_RemoveRatingsOfAPI("css=a[class=\"remove-rating\"]"), btn_nextSubscribed("//a[contains(text(),'>>')]"), ele_lblPagination("xpath=(//div[@class='pagination']/ul/li)[last()-1]//a"), ele_lblPaginationVisible("xpath=//div[@class='pagination']/ul/li/a[contains(text(),'>>')]"), lnk_APINameStoreWithVersionAndProvider("//a[contains(text(),'<param_APIName>-<param_APIVersion>')]/../div/a[contains(text(),'<param_provider>')]"), lnk_Statistics("link=Statistics"), ele_lblStoreStatistics("//*[text()='Store Statistics']"), ele_ddSelectStatistics("//a[contains(text(),'<param_Statistics>')]"), img_facebook("//img[@alt='Facebook']");

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