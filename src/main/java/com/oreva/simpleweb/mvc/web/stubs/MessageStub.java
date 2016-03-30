package com.oreva.simpleweb.mvc.web.stubs;

import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.entities.Message;
import com.oreva.simpleweb.mvc.entities.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/24/16
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageStub extends Stub {

    private Long id;

    /*@NotNull
    @Size(min = 2, max = 10,
            message = "User phone must be between 2 and 10 characters long.")
    @Pattern(regexp = "[0-9]+",
            message = "User phone must contain only digit characters.")
    private String phone;

    @NotNull
    @Size(min = 5, max = 50,
            message = "User email must be between 5 and 50 character long.")
    @Pattern(regexp = "(\\w)+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+",
            message = "Invalid email format.")
    private String mail;   */

    @NotNull
    @Size(min = 1,
            max = 300,
            message = "Message must be between 1 and 300 characters long.")
    private String text;

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

    @Override
    public IEntity convertToEntity() {
        Message entity = new Message();
        entity.setId(id);
        entity.setText(text);
        return entity;
    }
}
