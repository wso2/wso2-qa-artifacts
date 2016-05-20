package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIStoreAPIs implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIStoreAPIs {

        ele_lblNoAPIPulisheWarningMessage("//strong[contains(text(),'No APIs published yet')]"), ele_tabAPIConsole("//a[contains(text(),'API Console')]"), lnk_default("//h3/span/a[contains(text(),'<param_verb>')]/../../span[2]/a[contains(text(),'<param_UrlPattern>')]"), lnk_APIName("//a[@title='<param_APIName>']"), lnk_RecentlyViewedAPUI("//a[@class='title' and contains(text(),'<param_APIName>')]"), lnk_tags("//div[@id='tag-content']/a[text()='<param_tags>']"), lnk_Documentations("//a[text()='Documentation']"), lnk_HowTo("//a[contains(text(),'How To')]"), lnk_tagProtoType("//div/a[contains(text(),'<param_tagName>')]"), img_Uploaded("verification.JPG"), img_verificationStore("verificationStore.JPG"), ele_lblDocumentName("//p[text()='<param_docName>']"), ele_lblDocumentSummary("//div[@class='documentaion-body']/p[text()='<param_docSummery>']"), lnk_edditedUrl("link=<EdditedUrl>"), ele_ddSelectAplicationToSubscribe("//select[@id='application-list']"), btn_Subscribe("//button[@id='subscribe-button']"), btn_StayOnThisPage("//a[contains(text(),'Stay on this page')]"), lnk_PublicApiStore("link=Public API Store"), ele_lblProductionUrlWithVersion("//div[@id=\"overview\"]/div[contains(text(),\"/<param_versionNumber>/<param_APIName>\")]"), ele_lblProductionDefaultUrl("//div[@id=\"overview\"]/div[contains(normalize-space(),\"<param_provider>/<param_APIName>\")]"), ele_lblSandboxUrlWithVersion("//div[@id=\"overview\"]/div[contains(text(),\"/<param_versionNumber>/<param_APIName>\")][2]"), ele_lblSandboxDefaultUrl("//div[@id=\"overview\"]/div[contains(normalize-space(),\"<param_provider>/<param_APIName>\")][2]"), lnk_APINameSearch("//a[text()='<param_APIName>']"), btn_GoToMySubscriptions("//a[text()='Go to My Subscriptions']"), ele_ddtierToSubscribe("//select[@id='tiers-list']"), ele_lblProductionUrlGeneral("//div[@id=\"overview\"]/h5[contains(text(),\"Production and Sandbox URLs\")]/../div[contains(text(),\"<param_rearUrlPattern>\")][1]"), ele_lblSandboxUrlGeneral("//div[@id=\"overview\"]/h5[contains(text(),\"Production and Sandbox URLs\")]/../div[contains(text(),\"<param_rearUrlPattern>\")][2]"), ele_lblNoTierAvailableMessage("//span[@id='subsBtnDesc' and contains(text(),'You may not be entitled to any of the available tiers')]"), ele_lblProductionDefaultUrlAdmin("//div[@id=\"overview\"]/div[contains(normalize-space(),\"/<param_APIName>\")]"), ele_lblSandboxDefaultUrlAdmin("//div[@id=\"overview\"]/div[contains(normalize-space(),\"/<param_APIName>\")][2]");

    private String searchPath;
  
    /**
    *  Page APIStoreAPIs.
    */
    private APIStoreAPIs(final String psearchPath) {
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