package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIPublisherLogin implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIPublisherLogin {

        tf_UserName("//input[@id='username']"), tf_PassWord("//input[@id='pass']"), btn_Login("//input[@id='loginButton']");

    private String searchPath;
  
    /**
    *  Page APIPublisherLogin.
    */
    private APIPublisherLogin(final String psearchPath) {
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