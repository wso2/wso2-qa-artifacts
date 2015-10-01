package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class BrowseLifecycle implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum browseLifecycle {

        ele_ddSelectState("//select[@id=\"editStatus\"]"), btn_Update("//input[@id='updateStateButton']"), ele_lblUpdateSuccessMessage("//div[contains(text(),'Successfully updated the API status')]");

    private String searchPath;
  
    /**
    *  Page browseLifecycle.
    */
    private browseLifecycle(final String psearchPath) {
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