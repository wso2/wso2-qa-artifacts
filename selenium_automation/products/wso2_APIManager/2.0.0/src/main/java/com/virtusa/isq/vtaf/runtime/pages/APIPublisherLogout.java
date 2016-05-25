package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIPublisherLogout implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIPublisherLogout {

        lnk_UserName("link=<param_userName>"), btn_LogOut("//a[contains(text(),'Logout')]"), lnk_Caret("//span[@class='caret']");

    private String searchPath;
  
    /**
    *  Page APIPublisherLogout.
    */
    private APIPublisherLogout(final String psearchPath) {
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