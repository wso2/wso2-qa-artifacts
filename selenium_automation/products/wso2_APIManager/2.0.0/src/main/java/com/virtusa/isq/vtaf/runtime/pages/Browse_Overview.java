package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class Browse_Overview implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum Browse_Overview {

        btn_CreateNewVersion("//button[contains(text(),'Create New Version')]"), tf_ToVersion("//input[@id='new-version']"), btn_Done("//button[contains(text(),'Done')]"), rdo_HowTo("//div[@class=\"controls\"]/label/input[@id=\"optionsRadios1\"]"), rdo_SampleAndSDK("//div[@class=\"controls\"]/label/input[@id=\"optionsRadios2\"]"), rdo_PublicForum("//div[@class=\"controls\"]/label/input[@id=\"optionsRadios3\"]"), rdo_SupportForum("//div[@class=\"controls\"]/label/input[@id=\"optionsRadios4\"]"), rdo_Other("//div[@class=\"controls\"]/label/input[@id=\"optionsRadios5\"]"), rdo_Inline("//div[@class=\"controls\"]/label/input[@id=\"optionsRadios6\"]"), rdo_URL("//div[@class=\"controls\"]/label/input[@id=\"optionsRadios7\"]"), rdo_File("//div[@class=\"controls\"]/label/input[@id=\"optionsRadios8\"]"), ele_lblDuplicateVersionErrorMessage("//span[text()=' Error occurred while creating a new API version- <param_APIVersion>']"), btn_CancelNewVersion("//div[@id='saveButtons']/button[contains(text(),'Cancel')]"), btn_Ok("link=OK"), chk_DefaultVersion("//input[@id='default_version_cp']");

    private String searchPath;
  
    /**
    *  Page Browse_Overview.
    */
    private Browse_Overview(final String psearchPath) {
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