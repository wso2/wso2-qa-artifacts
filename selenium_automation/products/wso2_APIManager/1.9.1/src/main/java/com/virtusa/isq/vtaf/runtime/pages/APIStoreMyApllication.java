package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIStoreMyApllication implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIStoreMyApllication {

        ele_lblNewAppliacation("//form[@id=\"appAddForm\"]/h3[contains(text(),\"Add New Application\")]"), tf_ApplicationName("//input[@id='application-name']"), tf_CallBackURL("//input[@id='callback-url']"), tf_Discription("//textarea[@id='description']"), ele_lblSuccessAddMesage("//div[@id='appAddMessage']"), ele_lblTableAppName("//td[contains(text(),'<param_AppName>')]/../../../thead[1]/tr[@class=\"alt first last\"]/th[contains(text(),'Name')]"), ele_lblTableCallBackURL("//td[contains(text(),'<param_CallbackURL>')]/../../../thead/tr[@class=\"alt first last\"]/th[contains(text(),'Callback URL')]"), ele_lblTableDiscription("//td[contains(text(),'<param_Description>')]/../../../thead/tr[@class=\"alt first last\"]/th[contains(text(),'Description')]"), ele_lblCallBackURL("//td[contains(text(),'<param_AppName>')]/../td[contains(text(),'<param_CallBackURL>')]"), ele_lblCallbackUrlHelp("//div[@id='callback_help']"), ele_lblDescription("//td[contains(text(),'<param_AppName>')]/../td[contains(text(),'<Description>')]"), lnk_DeleteApplication("//td[contains(text(),'<param_ApplicationName>')]/../td/a[contains(text(),' Delete')]"), btn_yes("//a[text()='Yes']"), ele_ddThrottlingTier("//select[@id='appTier']"), btn_AddApplication("//input[@id='application-add-button']"), ele_lblNameRequired("//label[@class='error'][@for='application-name']"), ele_lblStatus("//td[contains(text(),'<param_AppName>')]/../td[contains(text(),'<param_Status>')]"), ele_lblAddApplication("//h3[contains(text(),'Add New Application')]"), ele_lblInvalidCharacters("//label[contains(text(),'The Name contains one or more illegal characters')]"), lnk_EditActionColumn("//td[1][contains(text(),'<param_AppName>')]/../td[6]/a[contains(text(),'Edit')]"), tf_EditName("//tr[@data-value='<param_AppName>']//input[@class='app_name_new']"), ele_ddEditTier("//tr[@data-value='<param_AppName>']//select[@class='applicationTierSelect']"), tf_EditCallBackURL("//tr[@data-value='<param_AppName>']//input[@class='callback_new validInput']"), tf_EditDescription("//tr[@data-value='<param_AppName>']//input[@class='description-new']"), btn_EditCancel("//tr[@data-value='<param_AppName>']//button[@class='btn']"), btn_EditSave("//tr[@data-value='<param_AppName>']//button[@class='btn btn-primary']"), btn_UrlQuestionMark("//a[@class='icon-question-sign help_popup']"), frm_parent("parent"), ele_lblSubscriptionSuccefulMssage("//*[text()='Subscription Successful']"), ele_lblSubscribedAppDeleteWarningMessage("//div[contains(text(),'This application is subscribed')]"), ele_lblVerifingAPPDataInGrid("//tr/td[contains(text(),'<param_AppName>')]/../td[contains(text(),'ACTIVE')]/../td[contains(text(),'<param_CallbackURL>')]/../td[contains(text(),'<param_Description>')]/../td[6]/a[contains(text(),'Edit')]/../../td[7]/a[contains(text(),'Delete')]"), btn_EditApplication("//tr/td[contains(text(),'<param_AppName>')]/../td[contains(text(),'ACTIVE')]/../td[contains(text(),'<param_CallbackURL>')]/../td[contains(text(),'<param_Description>')]/../td[6]/a[contains(text(),'Edit')]"), tf_NewApplicationName("//input[@class='app_name_new']"), ele_ddSelectTier("//select[@id='tiers0']"), tf_NewEditedCallbackURL("//input[@class='callback_new validInput']"), tf_NewEditedDescription("//input[@class='description-new']"), btn_SaveEditedApplicationDetails("//button[text()='Save']"), btn_cancelEditApplication("//input[@class='app_name_new']/../../../../td[6]/div/button[@class='btn']"), lnk_Yes("link=Yes"), btn_DeleteApp("//tr/td[contains(text(),'')]/../td[contains(text(),'ACTIVE')]/../td[contains(text(),'')]/../td[contains(text(),'')]/../td[7]/a[contains(text(),'Delete')]"), lnk_deleteApplicationLink("//a[text()=' Delete']"), ele_rowCount("//table[@id='applicationTable']/tbody/tr"), btn_saveEditApplication("//input[@class='app_name_new']/../../../../td[6]/div/button[@class='btn btn-primary']"), ele_lblAPPNameGrid("//tr/td[contains(text(),'<param_ApplicationName>')]"), ele_lblAPPNameWithSharedLBL("//td[contains(text(),'Shared') and contains(text(),'<param_APPName>')]");

    private String searchPath;
  
    /**
    *  Page APIStoreMyApllication.
    */
    private APIStoreMyApllication(final String psearchPath) {
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