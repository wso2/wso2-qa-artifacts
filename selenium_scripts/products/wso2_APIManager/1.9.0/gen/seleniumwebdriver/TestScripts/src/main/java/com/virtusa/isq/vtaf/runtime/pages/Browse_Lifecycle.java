package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class Browse_Lifecycle implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum Browse_Lifecycle {

        ele_ddSelectState("//select[@id=\"editStatus\"]"), btn_Update("//input[@id='updateStateButton']"), ele_lblUpdateSuccessMessage("//div[contains(text(),'Successfully updated the API status')]");

    private String searchPath;
  
    /**
    *  Page Browse_Lifecycle.
    */
    private Browse_Lifecycle(final String psearchPath) {
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