package com.oreva.simpleweb.mvc.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Tag> tags = new ArrayList<Tag>();

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

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getMessages().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getMessages().remove( this );
    }

    public void addTags(List<Tag> tagList) {
        for (Tag t: tagList) {
            addTag(t);
        }
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
        try {
            if (null == obj && getClass() != obj.getClass()) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        Message m = (Message) obj;
        return Objects.equals(id, m.getId()) &&
                Objects.equals(text, m.getText()) &&
                Objects.equals(user, m.getUser());
    }
}
