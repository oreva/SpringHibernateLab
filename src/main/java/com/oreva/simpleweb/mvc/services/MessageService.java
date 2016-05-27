package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.Message;
import com.oreva.simpleweb.mvc.entities.Tag;
import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.repositories.MessageRepository;
import com.oreva.simpleweb.mvc.web.dto.MessageDTO;
import org.springframework.core.convert.ConversionService;
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
public class MessageService extends EntityService<Message> {
    @Inject
    private MessageRepository repository;
    @Inject
    private TagService tagService;
    @Inject
    private UserService userService;

    @Override
    public Message findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Message entity) {
        repository.save(entity);
    }

    public List<Message> loadAllMessages() {
        return repository.findAll();
    }

    public void newMessage(MessageDTO messageStub, User user,
                           ConversionService conversionService) {
        // Save tags
        List<Tag> tags = tagService.saveTagsFromString(messageStub.getTagString());
        //Add tags to message and save message
        Message message = conversionService.convert(messageStub, Message.class);
        message.addTags(tags);

        user.getMessages().add(message);
        message.setUser(user);

        userService.save(user);
    }
}
