package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class BrowseLifecycle implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum browseLifecycle {

        ele_ddSelectState("//select[@id=\"editStatus\"]"), btn_Update("//input[@id='updateStateButton']"), ele_lblUpdateSuccessMessage("//div[contains(text(),'Successfully updated the API status')]"), chk_PropagateChangesToAPIGateway("//div[@class=\"controls publishCheckBoxes\"]/label[1]/input[@value=\"false\"]"), chk_deprecateOldVersions("//div[@class=\"controls publishCheckBoxes\"]/label[2]/input[@value=\"false\"]"), chk_requireResubscription("//div[@class=\"controls publishCheckBoxes\"]/label[3]/input[@value=\"false\"]"), chk_lifeCycleRelative("//div[@class=\"controls publishCheckBoxes\"]/label[<param_relativeCheckBoxNumberLifeCycle>]/input[@value=\"<param_trueFalse>\"]"), chk_deprecateOldVersionsTrueOrFalse("//label[@id=\"deprecateOldVersionsDiv\"]/input[@value='<param_TrueOrFalse>'] "), chk_requireResubscriptionTrueOrFalse("//label[@id=\"requireResubscriptionDiv\"]/input[@value='<param_TrueOrFalse>']"), chk_PropagateChangesToAPIGatewayTrueOrFalse("//label[@id=\"publishToGatewayDiv\"]/input[@value='<param_TrueOrFalse>']");

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