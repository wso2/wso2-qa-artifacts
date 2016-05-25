package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIPublisherTierPermissions implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIPublisherTierPermissions {

        ele_lblTierName("//tbody/tr/td[contains(text(),'<param_TierName>')]"), chk_Allow("//tbody/tr/td[contains(text(),'<param_TierName>')]/../td[2]/div/div/label/input[@id='y']"), chk_Deny("//tbody/tr/td[contains(text(),'<param_TierName>')]/../td[2]/div/div/label/input[@id='z']"), tf_InputRole("//tbody/tr/td[contains(text(),'<param_TierName>')]/../td[2]/div/div/input[@class='input rolesInput']"), btn_UpdatePermissions("//tbody/tr/td[contains(text(),'<param_TierName>')]/../td[2]/div[@id='saveButtons']/button"), ele_lblUpdateSuccessMessage("//tbody/tr/td[contains(text(),'<param_TierName>')]/../td[2]/div[@class='alert alert-success' and contains(text(),'Successfully updated Tier Permission')]"), ele_lblErrorMessages("//tbody/tr/td[contains(text(),'<param_TierName>')]/../td[2]/div/div[2]/label[contains(text(),'<param_ErrorMessage>')]");

    private String searchPath;
  
    /**
    *  Page APIPublisherTierPermissions.
    */
    private APIPublisherTierPermissions(final String psearchPath) {
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