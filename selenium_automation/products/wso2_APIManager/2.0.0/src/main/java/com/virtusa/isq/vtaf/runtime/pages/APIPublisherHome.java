package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIPublisherHome implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIPublisherHome {

        lnk_Browse(""), ele_lblAPIs("//*[text()='API Publisher']"), lnk_APIs("//a[@title='APIs']"), lnk_Add("//a[@href='/publisher/site/pages/add.jag']"), win_DefaultWindow("index=1"), tf_APISearch("css=input[name=\"query\"]"), btn_Search("//div[@class='input-group-btn']/button"), ele_lblApiNamewithVersion("//div[contains(text(),'<param_version>')]/../a[contains(text(),'<param_ApiName>')]"), ele_lblNoAPICreated("//div[contains(text(),'No APIs created yet. Click one of the buttons below to get started')]"), ele_lblAPIState("//div[@class='caption']//p[text()='<param_state>']"), lnk_Subscriptions("link=Subscriptions"), ele_lblApiNameWithVersionAndStatus("//h5[contains(text(),'<param_version>')]/../h4/a[text()='<param_ApiName>']/../../h5[contains(text(),'<param_ApiStatus>')]"), ele_lblAPISquare("//ul[@class='thumbnails']/li"), lnk_TierPermissions("link=Tier Permissions"), ele_lblSearchTermMissing("//b[contains(text(),'Search term is missing. Try again with valid search query')]"), ele_lblAPIWithName("//a[text()='<param_Name>' and @title='api name']"), btn_block("css=input[value=\"Block\"]"), ele_lblNoMatchingAPI("//b[contains(text(),'No matching APIs found')]"), ele_GotoNextPage("//a[text()='>>']"), ele_APIWindow("//div[@class='page-content']/div/div"), lnk_OpenOrCloseLeftMenuSidebar("//a[@aria-expanded='<param_IsExpandedTrueOrFalse>' and @data-toggle='sidebar']");

    private String searchPath;
  
    /**
    *  Page APIPublisherHome.
    */
    private APIPublisherHome(final String psearchPath) {
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