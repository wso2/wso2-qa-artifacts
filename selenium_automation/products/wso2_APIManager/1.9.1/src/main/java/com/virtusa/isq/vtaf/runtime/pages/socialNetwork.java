package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class SocialNetwork implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum socialNetwork {

        tf_FaceBookUserName("//input[@id='email']"), tf_FaceBookPassword("//input[@id='pass']"), btn_LoginFaceBook("//input[@name='login']"), btn_ShareFaceBook("//button[@type='submit']"), btn_ShareTweet("//input[@class='button selected submit']"), ele_lblTweeterFailureMessage("//*[contains(text(),'Your Tweet was over 140 characters')]"), ele_lblFaceBookFailureMessage("//div[contains(text(),'An error occurred while processing this request.')]"), tf_TwitterUserName("//input[@id='username_or_email']"), tf_TwitterPassWord("//input[@id='password']"), btn_LoginAndTweet("//input[@class='button selected submit']");

    private String searchPath;
  
    /**
    *  Page socialNetwork.
    */
    private socialNetwork(final String psearchPath) {
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