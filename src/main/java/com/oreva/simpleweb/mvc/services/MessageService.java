package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.entities.Message;
import com.oreva.simpleweb.mvc.dao.MessageDAO;
import com.oreva.simpleweb.mvc.web.stubs.IStub;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 1/18/16
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class MessageService extends EntityService {
    @Inject
    private MessageDAO dao;

    @Inject
    private ConversionService conversionService;

    @Override
    public void save(IEntity entity) {
        dao.save(entity);
    }

    @Override
    public void saveFromStub(IStub stub) {
        Message message = conversionService.convert(stub, Message.class);

        dao.save(message);
    }
}
