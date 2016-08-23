package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIPublisherMyAPIs implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIPublisherMyAPIs {

        rdo_All("//input[@value='blockAll']"), rdo_Production("//input[@value='blockProduction']"), lnk_BlockStatus("//a[ contains(text(),'Block')]"), lnk_APIRelativeNameFirstRow("//tbody[@id='users']/tr/td[contains(text(),\"<param_provider>\")]/../td[contains(text(),\"<param_applicationName>\")]/../td/a[contains(text(),\"<param_apiName>\")]"), chk_ProductionOnlyFirstRow("//tbody[@id='users']/tr/td[contains(text(),\"<param_provider>\")]/../td[contains(text(),\"<param_applicationName>\")]/../td/a[contains(text(),\"<param_apiName>\")]/../../td/label[contains(text(),\"<param_keyWordProductionOnly>\")]/../input[1]"), chk_ProductionAndSandboxFirstRow("//tbody[@id='users']/tr/td[contains(text(),\"<param_provider>\")]/../td[contains(text(),\"<param_applicationName>\")]/../td/a[contains(text(),\"<param_apiName>\")]/../../td/label[contains(text(),\"<param_keyWordProductionAndSandbox>\")]/../input[2]"), lnk_BlockedOrUnblockedFirstRow("//tbody[@id='users']/tr/td[contains(text(),\"<param_provider>\")]/../td[contains(text(),\"<param_applicationName>\")]/../td/a[contains(text(),\"<param_apiName>\")]/../../td[4]/a[contains(normalize-space(),\"<param_kayWordBlockOrUnblock>\")]"), lnk_APIRelativeNameRestOfRows("//tbody[@id='users']/tr/td[contains(text(),\"<param_provider>\")]/../td[contains(text(),\"<param_applicationName>\")]/../../tr/td/a[contains(text(),\"<param_apiName>\")]"), chk_ProductionOnlyRestOfRows("//tbody[@id='users']/tr/td[contains(text(),\"<param_provider>\")]/../td[contains(text(),\"<param_applicationName>\")]/../../tr/td/a[contains(text(),\"<param_apiName>\")]/../../td/label[contains(text(),\"<param_keyWordProductionOnly>\")]/../input[1]"), chk_ProductionAndSandboxRestOfRows("//tbody[@id='users']/tr/td[contains(text(),\"<param_provider>\")]/../td[contains(text(),\"<param_applicationName>\")]/../../tr/td/a[contains(text(),\"<param_apiName>\")]/../../td/label[contains(text(),\"<param_keyWordProductionAndSandbox>\")]/../input[2]"), lnk_BlockedOrUnblockedRestOfRows("//tbody[@id='users']/tr/td[contains(text(),\"<param_provider>\")]/../td[contains(text(),\"<param_applicationName>\")]/../../tr/td/a[contains(text(),\"<param_apiName>\")]/../../td[2]/a[contains(normalize-space(),\"<param_kayWordBlockOrUnblock>\")]");

    private String searchPath;
  
    /**
    *  Page APIPublisherMyAPIs.
    */
    private APIPublisherMyAPIs(final String psearchPath) {
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