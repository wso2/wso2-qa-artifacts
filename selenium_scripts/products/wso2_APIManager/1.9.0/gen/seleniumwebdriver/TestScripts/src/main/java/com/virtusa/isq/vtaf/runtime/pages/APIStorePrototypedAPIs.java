package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIStorePrototypedAPIs implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIStorePrototypedAPIs {

        ele_lblAPIName("//a[text()='<param_APIName> (<param_Virsion>)']"), ele_lblNoPrototypeAPIMessage("//strong[text()='No Prototyped APIs available']");

    private String searchPath;
  
    /**
    *  Page APIStorePrototypedAPIs.
    */
    private APIStorePrototypedAPIs(final String psearchPath) {
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