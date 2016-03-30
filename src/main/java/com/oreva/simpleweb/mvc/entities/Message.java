package com.oreva.simpleweb.mvc.entities;

import com.oreva.simpleweb.mvc.web.stubs.IStub;
import com.oreva.simpleweb.mvc.web.stubs.MessageStub;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/9/16
 * Time: 8:56 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Entity
@Table(name = "MESSAGE")
public class Message extends Entity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public IStub convertToStub() {
        MessageStub stub = new MessageStub();
        stub.setId(id);
        stub.setText(text);
        return stub;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj && getClass() != obj.getClass()) {
            return false;
        }
        Message m = (Message) obj;
        return Objects.equals(id, m.getId()) &&
                Objects.equals(text, m.getText()) &&
                Objects.equals(user, m.getUser());
    }
}
