package com.oreva.simpleweb.mvc.web.stubs;

import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.entities.Tag;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/29/16
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TagStub extends Stub {
    private Long id;
    private String text;

    public TagStub() {

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
