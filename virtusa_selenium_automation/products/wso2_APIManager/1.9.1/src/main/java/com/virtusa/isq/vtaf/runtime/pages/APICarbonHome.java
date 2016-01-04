package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APICarbonHome implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APICarbonHome {

        tf_UserName("//input[@id='txtUserName']"), tf_Password("//input[@id='txtPassword']"), btn_Login("//input[@value='Sign-in']"), lnk_UserandRoles("//a[contains(text(),'Users and Roles')]"), lnk_User("//a[@class='icon-link' and text()='Users']"), lnk_Role("//a[@class='icon-link' and text()='Roles']"), lnk_AddNewUser("//a[contains(text(),'Add New User')]"), link_AddNewTenant("link=Add New Tenant"), tf_Domain("//input[@id='domain']"), tf_FirstName("//input[@id='admin-firstname']"), tf_LastName("//input[@id='admin-lastname']"), tf_AdminUserName("//input[@id='admin']"), tf_AdminPassword("//input[@id='admin-password']"), tfAdminPasswordRepeat("//input[@id='admin-password-repeat']"), tf_Email("//input[@id='admin-email']"), btn_Save("//tr[@id=\"buttonRow\"]/td/input"), btn_OkPopUp("//button[contains(text(),'OK')]"), lnk_SignOut("link=Sign-out"), btn_Configure("//div[@id=\"menu-panel-button3\"]/span[contains(text(),\"Configure\")]"), ele_lblLoginFailedPopup("//div[@id=\"messagebox-warning\"]/p[contains(text(),\"Login failed! Please recheck the username and password and try again.\")]"), tf_SearchUser("//input[@name='org.wso2.carbon.user.filter']"), lnk_UserNameSearch("//td[contains(text(),'<param_UserName>')]"), btn_SearchUser("//input[@type='submit']"), btn_UserProfile("//a[@style='background-image:url(../userprofile/images/my-prof.gif);']"), tf_Organization("//input[@id='http://wso2.org/claims/organization']"), btn_UpdateProfile("//input[@name='updateprofile']");

    private String searchPath;
  
    /**
    *  Page APICarbonHome.
    */
    private APICarbonHome(final String psearchPath) {
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