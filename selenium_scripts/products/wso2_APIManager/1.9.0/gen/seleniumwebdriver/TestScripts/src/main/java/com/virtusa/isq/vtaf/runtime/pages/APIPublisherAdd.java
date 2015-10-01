package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIPublisherAdd implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIPublisherAdd {

        rdo_DesignNewAPI("//input[@id='create-new-api']"), btn_StartCreating("//button[@id='designNewAPI']"), ele_lblDesignAPI("//*[text()='Design API']"), tf_APIName("//input[@id='name']"), tf_APIContext("//input[@id='context']"), tf_APIVersion("//input[@id='version']"), btn_BrowseImage("//input[@id='apiThumb']"), ele_lblNonImageFileError("//label[contains(text(),'File must be in image file format')]"), tf_Tags("//div[@class='controls tagContainer']/div/input"), tf_URLPattern("//input[@id='resource_url_pattern']"), btn_Add("//button[@id='add_resource']"), ele_lblErrorMessageURLPattern("//span[text()='You should select at least one HTTP verb.']"), btn_OkErrorMessage("//a[text()='OK']"), btn_Save("//button[@id='saveBtn']"), btn_Yes("//a[contains(text(),'Yes')]"), lnk_NextImplement("link=Next: Implement >"), ele_lblWarningMessageAPIContest("//label[contains(text(),'This field is required.')]"), ele_lblWarningMessageAPIName("//label[contains(text(),'This field is required.')]"), ele_lblWarningMessageAPIVersion("//label[contains(text(),'This field is required.')]"), ele_lblDefaultResourceMessage("//div[text()='At least one resource should be specified. Do you want to add a wildcard resource (/*).']"), img_ThubmnailImage("//img[@id='apiEditThumb']"), tf_Discription("//textarea[@class='input-xlarge']"), btn_SaveManagePage("//button[@id='save_api']"), chk_Get("//input[@value='get']"), chk_Post("//input[@value='post']"), lnk_NextManage("//button[@id='go_to_manage']"), btn_SavePublish("//a[text()='Save & Publish']"), dd_tireAvailabilityConfig("//form[@id='manage_form']//button"), chk_tireSelectionUnlimited("//form[@id='manage_form']//button/..//input"), ele_lblFinalClose("//div[@id='publish-success']//button");

    private String searchPath;
  
    /**
    *  Page APIPublisherAdd.
    */
    private APIPublisherAdd(final String psearchPath) {
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