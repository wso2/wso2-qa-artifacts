package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class CarbonAddUser implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum CarbonAddUser {

        tf_UserName("//input[@name='username']"), tf_password("//input[@name='password']"), tf_retypePassword("//input[@name='retype']"), btn_next("//input[@value='Next >']"), chk_Role("//input[@value='<userRole>']"), btn_finish("//input[@value='Finish']"), btn_Ok("//button[text()='OK']"), lnk_ChangeMyPassword("link=Change My Password"), tf_CurrentPassword("//input[@name='currentPassword']"), tf_NewPassword("//input[@name='newPassword']"), tf_ReapeatPassword("//input[@name='checkPassword']"), btn_Change("//input[@type='submit']"), btn_OKChangePassword("//button[contains(text(),'OK')]"), ele_LblUserCreationFailedPopup("//div[@id=\"messagebox-warning\"]/p[contains(text(),\"Entered user name is not conforming to policy. Please enter a user name, which adheres to policy.\")]"), lnk_AssignRoles("//td[contains(text(),'<param_userName>')]/../td[2]/a[contains(text(),'Assign Roles')]"), btn_update("//td[@class='buttonRow']/input[1]");

    private String searchPath;
  
    /**
    *  Page CarbonAddUser.
    */
    private CarbonAddUser(final String psearchPath) {
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