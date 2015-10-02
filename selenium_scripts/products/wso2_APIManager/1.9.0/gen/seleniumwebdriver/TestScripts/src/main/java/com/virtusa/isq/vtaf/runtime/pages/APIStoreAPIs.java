package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIStoreAPIs implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIStoreAPIs {

        ele_lblNoAPIPulisheWarningMessage("//strong[contains(text(),'No APIs published yet')]"), ele_tabAPIConsole("//a[contains(text(),'API Console')]"), lnk_default("//h3/span/a[contains(text(),'<param_verb>')]/../../span[2]/a[contains(text(),'<param_UrlPattern>')]"), lnk_APIName("//a[@title='<param_APIName>']"), lnk_RecentlyViewedAPUI("//a[@class='title' and contains(text(),'<param_APIName>')]"), lnk_tags("link=<tags>"), lnk_Documentations("//a[text()='Documentation']"), lnk_HowTo("//a[contains(text(),'How To')]"), lnk_tagProtoType("//div/a[contains(text(),'<param_tagName>')]"), img_Uploaded("verification.JPG"), img_verificationStore("verificationStore.JPG"), ele_lblDocumentName("//p[text()='<param_docName>']"), ele_lblDocumentSummary("//div[@class='documentaion-body']/p[text()='<param_docSummery>']"), lnk_edditedUrl("link=<EdditedUrl>"), ele_ddSelectAplicationToSubscribe("//select[@id='application-list']"), btn_Subscribe("//button[@id='subscribe-button']"), btn_StayOnThisPage("//a[contains(text(),'Stay on this page')]"), lnk_PublicApiStore("link=Public API Store");

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