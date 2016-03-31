package com.oreva.simpleweb.mvc.entities;

import com.oreva.simpleweb.mvc.web.stubs.IStub;
import com.oreva.simpleweb.mvc.web.stubs.MessageStub;
import com.oreva.simpleweb.mvc.web.stubs.UserStub;

import javax.persistence.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/29/16
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Entity
@Table(name = "USERS")
public class User extends Entity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Message> messages = new LinkedList<Message>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message m) {
        messages.add(m);
        m.setUser(this);
    }

    public void removeMessage(Message m) {
        messages.remove(m);
        m.setUser(null);
    }

}
