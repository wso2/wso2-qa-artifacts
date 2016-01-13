package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIStoreLogin implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIStoreLogin {

        ele_lblLoggingErrorMessage("//strong[contains(text(),'Unable to log you in')]");

    private String searchPath;
  
    /**
    *  Page APIStoreLogin.
    */
    private APIStoreLogin(final String psearchPath) {
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