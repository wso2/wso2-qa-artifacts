package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class Scopes implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum Scopes {

        btn_AddScope("id=define_scopes"), tf_ScopeKey("//input[@id='scopeKey']"), tf_ScopeName("//input[@id='scopeName']"), btn_ScopeReSelect("//span[text()='<param_verbMethodName>']/../../td[6]/a"), tf_Role("//input[@id='scopeRoles']"), btn_SubmitScope("id=scope_submit"), btn_Scope("//span[text()='<param_verbMethodName>']/../../td[6]/a[text()='+ Scope']"), ele_ddScope("//select[@class='input-medium']"), btn_Right("//button[@class='btn btn-primary editable-submit']"), ele_lblAddedScopes("//strong[contains(text(),\"Roles\")]/../h6[contains(text(),\"<param_ScopeKey>\")]"), tf_Description("//textarea[@id='scopeDescription']"), ele_lblSpecialCharactorErrorMsg("//span[contains(text(),'Scope <param_SpecialCharactor> already exists')]"), btn_OK("xpath=(//a[text()='OK'])[2]"), ele_lblAlreadyExistError("//span[contains(text(),'Scope <scopeKey> already exists')]"), ele_lblscopeKeyRequiredAstrix("//label[@for='scopeKey']/span[@class='requiredAstrix']"), ele_lblScopeNameRequiredAstrix("//label[@for='scopeName']/span[@class='requiredAstrix']"), btn_Close("//a[contains(text(),'Close')]"), ele_lblRequiredFieldError("//label[contains(text(),'This field is required.')]"), ele_lblRequiredFieldError2("xpath=(//label[contains(text(),'This field is required.')])[2]"), btn_topXClose("//div[@id=\"define_scope_modal\"]/div/button"), ele_lblResources("//legend[contains(text(),'Resources')]"), ele_ddOptions("//select[@class='input-medium']/option[contains(text(),'<scopeName>')]"), btn_ScopeParam("link=<Scope>");

    private String searchPath;
  
    /**
    *  Page Scopes.
    */
    private Scopes(final String psearchPath) {
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