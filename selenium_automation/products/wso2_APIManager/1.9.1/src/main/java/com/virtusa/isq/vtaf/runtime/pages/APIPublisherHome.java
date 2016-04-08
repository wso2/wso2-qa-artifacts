package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIPublisherHome implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIPublisherHome {

        ele_lblAPIs("//li[text()='APIs']"), lnk_Browse("link=Browse"), lnk_Add("link=Add"), win_DefaultWindow("index=1"), tf_APISearch("css=input[name=\"query\"]"), btn_Search("//button[@class='btn btn-primary']"), ele_lblApiNamewithVersion("//div[contains(text(),'<param_version>')]/../a[contains(text(),'<param_ApiName>')]"), ele_lblNoAPICreated("//div[contains(text(),'No APIs created yet. Click one of the buttons below to get started')]"), ele_lblAPIState("//div[@class='caption']//p[text()='<param_state>']"), lnk_Subscriptions("link=Subscriptions"), ele_lblApiNameWithVersionAndStatus("//div[contains(text(),'<param_version>')]/../a[contains(text(),'<param_ApiName>')]/../p[contains(text(),'<param_ApiStatus>')]/../a"), ele_lblAPISquare("//ul[@class='thumbnails']/li"), lnk_TierPermissions("link=Tier Permissions");

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