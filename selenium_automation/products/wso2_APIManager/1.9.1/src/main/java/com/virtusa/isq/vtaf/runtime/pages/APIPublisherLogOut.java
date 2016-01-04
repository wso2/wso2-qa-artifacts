package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIPublisherLogOut implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIPublisherLogOut {

        btn_UserName("link=<param_userName>"), btn_LogOut("//button[text()=' Logout']"), btn_SignOut("//a[@id='userMenu']");

    private String searchPath;
  
    /**
    *  Page APIPublisherLogOut.
    */
    private APIPublisherLogOut(final String psearchPath) {
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