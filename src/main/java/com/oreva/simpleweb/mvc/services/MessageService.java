package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.Message;
import com.oreva.simpleweb.mvc.dao.MessageDAO;
import com.oreva.simpleweb.mvc.entities.Tag;
import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.web.dto.MessageDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 1/18/16
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class MessageService extends EntityService<Message, MessageDTO> {
    @Inject
    private MessageDAO dao;

    @Inject
    private UserService userService;

    @Inject
    private TagService tagService;

    @Override
    public void save(Message entity) {
        dao.save(entity);
    }

    public List<Message> loadAllMessages() {
        return dao.loadAllMessages();
    }

    public void newMessage(MessageDTO messageStub, User user) {
        // Save tags
        List<Tag> tags = tagService.saveTagsFromString(messageStub.getTagString());
        //Add tags to message and save message
        Message message = convertStubToEntity(messageStub);
        message.addTags(tags);
        //Set user
        message.setUser(user);

        dao.save(message);
    }

    @Override
    public MessageDTO convertEntityToStub(Message entity) {
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

    @Override
    public Message convertStubToEntity(MessageDTO stub) {
        Message entity = new Message();
        entity.setId(stub.getId());
        entity.setText(stub.getText());
        return entity;
    }
}
