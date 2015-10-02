package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class CarbonUserRole implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum CarbonUserRole {

        lnk_Roles("link=Roles"), lnk_AddNewRole("link=Add New Role"), tf_RoleName("//input[@name='roleName']"), btn_Next("//th[contains(text(),'Enter role details')]/../../../tbody/tr[2]/td/input[1]"), btn_Finish("//th[contains(text(),'Enter role details')]/../../../tbody/tr[2]/td/input[2]"), btn_Cancel("//th[contains(text(),'Enter role details')]/../../../tbody/tr[2]/td/input[3]"), chk_Login("//span[contains(text(),'Login')]/../../td[5]/div"), chk_Create("//span[contains(text(),'Create')]/../../td[7]/div"), chk_Publish("//span[contains(text(),'Publish')]/../../td[7]/div"), chk_Subscribe("//span[contains(text(),'Subscribe')]/../../td[7]/div"), btn_NextPermissions("//td[@class=\"buttonRow\"]/input"), chk_UserName("//input[@value='<param_UserName>']"), btn_FinishAddRole("//input[@value='Finish']"), btn_OkPopUp("//button[text()='OK']"), chk_CheckedAPI("//span[contains(text(),'API')]/../../td[@class='ygtvcheck2']/div"), chk_Login1("//span[contains(text(),'Login')]/../../td[4]/div"), chk_Create1("//span[contains(text(),'Create')]/../../td[6]/div"), chk_Publish1("//span[contains(text(),'Publish')]/../../td[6]/div"), chk_Subscribe1("//span[contains(text(),'Subscribe')]/../../td[6]/div"), chk_governance("//span[contains(text(),'Governance')]/../../td[6]/div"), chk_govern("//span[contains(text(),'Govern')]/../../td[7]/div"), chk_governance1("//span[contains(text(),'Governance')]/../../td[5]/div"), chk_govern1("//span[contains(text(),'Govern')]/../../td[6]/div");

    private String searchPath;
  
    /**
    *  Page CarbonUserRole.
    */
    private CarbonUserRole(final String psearchPath) {
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