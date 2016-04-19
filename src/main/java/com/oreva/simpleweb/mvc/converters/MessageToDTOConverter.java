package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.Message;
import com.oreva.simpleweb.mvc.entities.Tag;
import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.web.dto.MessageDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 4/19/16
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageToDTOConverter implements Converter<Message, MessageDTO> {
    @Override
    public MessageDTO convert(Message entity) {
        MessageDTO stub = new MessageDTO();
        stub.setId(entity.getId());
        stub.setText(entity.getText());

        // User-related attributes we push only to stub, because user-creation and
        // modification logic is not related to its messages.
        // So, we should not change user on message's change
        User user = entity.getUser();
        stub.setUserId(user.getId());
        stub.setUserMail(user.getMail());
        stub.setUserPhone(user.getPhone());
        stub.setUserName(user.getFirstName() + " " + user.getLastName());

        //Fill tag string attribute
        String tagString = "";
        int len = entity.getTags().size();
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                if (i > 0) {
                    tagString += ", ";
                }
                Tag tag = entity.getTags().get(i);
                tagString += tag.getText();
            }
        }
        stub.setTagString(tagString);
        return stub;
    }
}
