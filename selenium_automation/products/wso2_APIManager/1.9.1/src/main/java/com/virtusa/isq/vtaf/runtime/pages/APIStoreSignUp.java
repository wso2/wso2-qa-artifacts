package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIStoreSignUp implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIStoreSignUp {

        tf_UserName("//input[@id='newUsername']"), tf_Password("//input[@id='newPassword']"), tf_ReTypePassword("//input[@id='newPasswordConfirm']"), tf_FirstName("//input[@id='0.0cliamUri']"), tf_LastName("//input[@id='1.0cliamUri']"), tf_Email("//input[@id='5.0cliamUri']"), btn_Submit("//input[@class='submit btn btn-primary']"), lnk_Ok("link=OK"), tf_userNameLogIn("//input[@id='username']"), tf_PasswordLogIn("//input[@id='password']"), lnk_Login("link=Login"), btn_Forum("//a[@class='link-forum']"), ele_lblMoreDetails("//div[@id='moreFieldsLink']/a"), tf_Organization("//input[@id='2.0cliamUri']"), tf_Address("//input[@id='3.0cliamUri']"), tf_Country("//input[@id='4.0cliamUri']"), tf_LandPhone("//input[@id='6.0cliamUri']"), tf_MobliePhone("//input[@id='7.0cliamUri']"), tf_IM("//input[@id='8.0cliamUri']"), tf_URL("//input[@id='9.0cliamUri']"), ele_lblFirstNameRequired("//div[@class='control-group'][4]/div/label[text()='This field is required.']"), ele_lblLastNameRequired("//div[@class='control-group'][5]/div/label[text()='This field is required.']"), ele_lblEmailNameRequired("//div[@class='control-group'][6]/div/label[text()='This field is required.']"), ele_lblErrorMsgPassword("//div[@class='control-group'][2]//label[contains(text(),'<param_ErrorMessage>')]"), ele_lblUserNameError("//label[text()='Please enter at least 5 characters.']");

    private String searchPath;
  
    /**
    *  Page APIStoreSignUp.
    */
    private APIStoreSignUp(final String psearchPath) {
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