package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIPublisherLogin implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIPublisherLogin {

        tf_UserName("//input[@id='username']"), tf_PassWord("//input[@id='pass']"), btn_SignIn("//input[@id='tenant']/../button[contains(text(),'Sign In')]"), btn_Reset("//input[@id='tenant']/../button[contains(text(),'Reset')]");

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