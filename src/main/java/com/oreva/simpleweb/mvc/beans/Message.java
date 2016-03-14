package com.oreva.simpleweb.mvc.beans;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/9/16
 * Time: 8:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MESSAGE")
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "text")
    private String text;

    public Message() {
    }

    public Message(String phone, String mail, String text) {
        this.phone = phone;
        this.mail = mail;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
