package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.entities.Message;
import com.oreva.simpleweb.mvc.dao.MessageDAO;
import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.web.stubs.IStub;
import com.oreva.simpleweb.mvc.web.stubs.MessageStub;
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
public class MessageService extends EntityService<Message, MessageStub> {
    @Inject
    private MessageDAO dao;

    @Inject
    private ConversionService conversionService;

    @Override
    public void save(Message entity) {
        dao.save(entity);
    }

    public List<Message> loadAllMessages() {
        return dao.loadAllMessages();
    }

    @Override
    public MessageStub convertEntityToStub(Message entity) {
        MessageStub stub = new MessageStub();
        stub.setId(entity.getId());
        stub.setText(entity.getText());

        User user = entity.getUser();
        stub.setUserMail(user.getMail());
        stub.setUserPhone(user.getPhone());
        stub.setUserName(user.getFirstName() + " " + user.getLastName());
        return stub;
    }

    @Override
    public Message convertStubToEntity(MessageStub stub) {
        Message entity = new Message();
        entity.setId(stub.getId());
        entity.setText(stub.getText());
        return entity;
    }
}
