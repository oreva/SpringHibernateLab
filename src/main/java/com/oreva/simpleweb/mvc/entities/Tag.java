package com.oreva.simpleweb.mvc.entities;

import com.oreva.simpleweb.mvc.web.stubs.IStub;
import com.oreva.simpleweb.mvc.web.stubs.TagStub;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/29/16
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Entity
@Table(name = "TAG")
public class Tag extends Entity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    public Tag() {}

    public Tag(TagStub stub) {
        id = stub.getId();
        text = stub.getText();
    }

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

}
