package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIStoreDocumentation implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIStoreDocumentation {

        lnk_ViewContent("//p[text()='<param_DocName>']/../div/div/a[text()='View Content']"), lnk_Samples("//a[contains(text(),'Samples')]"), lnk_HowTo("//a[contains(text(),'How To')]"), lnk_Download("//p[text()='<param_docName>']/../div/p/a[contains(text(),'Download')]"), lnk_PublicForum("//a[contains(text(),'Public Forum')]"), lnk_URL("//p[text()='<param_docName>']/../div/p/a[contains(text(),'<param_URLLink>')]"), lnk_Other("//a[contains(text(),'Other')]"), lnk_SupportForum("//a[contains(text(),'Support Forum')]"), ele_lblDocumentName("//p[text()='<param_docName>']"), ele_lblDocumentSummary("//div[@class='documentaion-body']/p[text()='<param_docSummery>']"), ele_txtContent("//div[@class=\"span11\"]/../..//h2[1][contains(text(),'<param_docName>')]"), lnk_viewContent2("//div/p[contains(text(),'<param_docName>')]/..//../../div/a[contains(text(),'View Content')]"), ele_lblViewContentPageText("//div[contains(text(),'No document content have been added yet.')]/../../h2[1][contains(text(),'<paramDocName>')]"), ele_documentViewText("//div[@class=\"span11\"]/p[contains(text(),'<param_text>')]/../../../h2[1][contains(text(),'<param_docName>')]");

    private String searchPath;
  
    /**
    *  Page APIStoreDocumentation.
    */
    private APIStoreDocumentation(final String psearchPath) {
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