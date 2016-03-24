package com.oreva.simpleweb.mvc.beans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/9/16
 * Time: 8:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MESSAGE")
public class Message extends GenericEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 2, max = 10,
        message = "User phone must be between 2 and 10 characters long.")
    @Pattern(regexp = "[0-9]+",
        message = "User phone must contain only digit characters.")
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Size(min = 5, max = 50,
        message = "User email must be between 5 and 50 character long.")
    @Pattern(regexp = "(\\w)+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+",
        message = "Invalid email format.")
    @Column(name = "mail")
    private String mail;

    @NotNull
    @Size(min = 1,
        max = 300,
        message = "Message must be between 1 and 300 characters long.")
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
