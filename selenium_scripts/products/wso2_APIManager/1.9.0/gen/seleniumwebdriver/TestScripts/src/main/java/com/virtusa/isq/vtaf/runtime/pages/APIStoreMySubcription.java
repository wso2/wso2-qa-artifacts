package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIStoreMySubcription implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIStoreMySubcription {

        img_API("//div/a[@title='<APIName>-<Version>']"), btn_deleteAPI("//img[@class='closeBtn']"), ele_lblSubcribedAPIs("//h3[contains(text(),'Subscribed APIs ')]"), btn_Yes("//a[contains(text(),'Yes')]"), ele_ddApplicationWithSubscription("//select[@id='appListSelected']"), ele_lblConsumerKeyProduction("//b[text()='Consumer Key :']/../../div/div[@class='consumerKey token']"), ele_lblConsumerSecretTokenProduction("//b[text()='Consumer Secret :']/../../div/div[@class='consumerSecret token']"), ele_lblAccessTokenProduction("//b[text()='Access Token: ']/../../div/div/div[@class='token access']/span"), btn_generateKeyProduction("//button[contains(text(),'Generate keys')]"), ele_lblConsumerKeySandbox("xpath=(//b[text()='Consumer Key :']/../../div/div[@class='consumerKey token'])[2]"), ele_lblConsumerSecretTokenSandBox("xpath=(//b[text()='Consumer Secret :']/../../div/div[@class='consumerSecret token'])[2]"), ele_lblAccessTokenSandBox("xpath=(//b[text()='Access Token: ']/../../div/div/div[@class='token access'])[2]"), btn_generateKeySandBox("xpath=(//button[contains(text(),'Generate keys')])[2]"), btn_ApplicationWithSubscription("//div[@id='s2id_appListSelected']/a"), tf_ApplicationWithSubcription("//input[@class='select2-input']"), ele_lblddApplicationNames("//div[@class='select2-result-label'][contains(text(),'<param_ApplicationName>')]"), ele_lblKeyProduction("//*[text()='Keys - Production ']"), ele_lblSandBox("//*[text()='Keys - Sandbox ']"), tf_TokenValidity("//input[@id='refreshProdValidityTime']"), tf_TokenValidity2("//input[@id='refreshSandValidityTime']"), btn_GenarateKeySandBox("//div[@class='defaultBtnSetForSandBox']/button"), ele_lblAllowedDomains("//h5[contains(text(),'Allowed Domains')]"), ele_lblKeysProduction("//div[@class='container-fluid']/div[@class='span6']"), lnk_ScopeProductionKey("xpath=(//a[text()='Select Scopes'])[1]"), lnk_ScopeSandBox("xpath=(//a[text()='Select Scopes'])[2]"), chk_ScopeProduction("//input[@class='CheckboxProd' and @value='<param_scopeKey>']"), chk_ScopeSandBox("//div[@id=\"scopePopupSand\" and @aria-hidden=\"false\"]/div[2]/ul/li/input[@id='<para_ScopeName>']"), btn_SelectProd("//div[@id=\"scopePopup\" and @aria-hidden=\"false\"]/div[3]/input[@id=\"scopeSelectButtonPop\"]"), btn_SelectSand("//div[@id=\"scopePopupSand\" and @aria-hidden=\"false\"]/div[3]/input[@id=\"scopeSelectButtonPopSand\"]"), btn_RegenarateProduction("xpath=(//button[text()=' Re-generate'])[1]"), btn_RegenarateSandBox("xpath=(//button[text()=' Re-generate'])[2]");

    private String searchPath;
  
    /**
    *  Page APIStoreMySubcription.
    */
    private APIStoreMySubcription(final String psearchPath) {
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