package com.oreva.simpleweb.mvc.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/24/16
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageDTO extends DTO {

    private Long id;

    @NotNull
    @Size(min = 1,
            max = 250,
            message = "Message must be between 1 and 250 characters long.")
    private String text;

    private Long userId;
    private String userName;
    private String userMail;
    private String userPhone;
    // comma-separated string of related tags
    @Pattern(regexp = "(([a-zA-Z0-9])+(\\,)*)+",
            message = "Tags must be comma separated")
    private String tagString = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getTagString() {
        return tagString;
    }

    public void setTagString(String tagString) {
        this.tagString = tagString;
    }
}
