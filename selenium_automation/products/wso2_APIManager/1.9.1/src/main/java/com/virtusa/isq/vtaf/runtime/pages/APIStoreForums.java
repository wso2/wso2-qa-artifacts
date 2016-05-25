package com.virtusa.isq.vtaf.runtime.pages;

/**
 *  Class APIStoreForums implements corresponding UI page
 *  UI objects in the page are stored in the class.
 */

public enum APIStoreForums {

        btn_CreateNewTopic("//a[@class='btn btn-primary pull-left  ']"), tf_TopicSubject("//input[@id='subject']"), tf_TopicDescription("//div[@class='note-editable']"), btn_CreateTopic("//a[@id='add-forum-topic']"), lnk_CreatedTopic("//th[contains(text(),\" Topic \")]/../../../tbody/tr/td/a/strong[contains(text(),\"<param_TopicName>\")]"), tf_ReplyTopicField("//div[@class='note-editable']"), btn_ReplyToThread("//a[@id='forum_add_reply_button']"), img_Ratings("//div[@class='average-rating']"), ele_lblReplies("//*[text()='Replies']"), ele_lblRepliedUser("//tbody[@id=\"reply_list_tbody\"]/tr[2]/td[contains(normalize-space(),'<param_repliedUser>')]"), btn_ReplyDelete("//i[@class='icon-trash forum_delete_reply_icon']"), btn_ReplyEdit("//i[@class='icon-edit forum_edit_reply_icon']"), ele_lblRepliedUserDetails("//td[@id='forum_reply_content_cell_60f6a9f0-a8c9-4f2c-93aa-42d4d136a0db']"), ele_lblReplyMessageBody("//td[contains(text(),'<param_replyMessageBody>')]"), btn_ReplyEditSave("link=Save"), btn_NoToDeleteReply("//a[text()='No']"), btn_YesToDeleteReply("//a[text()='Yes']"), ele_RateStarLevel("//div[@class='star-ratings']/div/span[2]/a[<param_RateStarLevel>]"), ele_lblStarVerify("//div[@class='dynamic-rating']/a[text()='<param_StarVerify>']"), btn_DeleteTopic("//i[@class='icon-trash pull-right forum_delete_topic_icon']"), ele_lblDeleteErrorIcon("//i[@class='icon-big-error']"), btn_OK("link=OK"), ele_lblVerifyDelete("//div[text()='Do you want to remove the topic \"fgd\" ?']");

    private String searchPath;
  
    /**
    *  Page APIStoreForums.
    */
    private APIStoreForums(final String psearchPath) {
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