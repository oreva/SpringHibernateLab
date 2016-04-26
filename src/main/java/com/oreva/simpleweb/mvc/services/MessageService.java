package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.Message;
import com.oreva.simpleweb.mvc.dao.MessageDAO;
import com.oreva.simpleweb.mvc.entities.Tag;
import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.repositories_spring_data_jpa.TagRepository;
import com.oreva.simpleweb.mvc.repositories_spring_data_jpa.TagRepositoryImpl;
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
    private MessageDAO dao;
    @Inject
    private TagRepositoryImpl tagRepository;//TagService tagService;
    @Inject
    private ConversionService conversionService;

    @Override
    public void save(Message entity) {
        dao.save(entity);
    }

    public List<Message> loadAllMessages() {
        return dao.loadAllMessages();
    }

    public void newMessage(MessageDTO messageStub, User user) {
        // Save tags
        List<Tag> tags = tagRepository.saveTagsFromString(messageStub.getTagString());
        //Add tags to message and save message
        Message message = conversionService.convert(messageStub, Message.class);
        message.addTags(tags);
        //Set user
        message.setUser(user);

        dao.save(message);
    }
}
