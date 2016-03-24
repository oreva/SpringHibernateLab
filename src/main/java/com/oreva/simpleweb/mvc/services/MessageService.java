package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.beans.IEntity;
import com.oreva.simpleweb.mvc.beans.Message;
import com.oreva.simpleweb.mvc.dao.MessageDAO;
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
public class MessageService extends GenericEntityService {
    @Inject
    private MessageDAO dao;

    @Override
    public void save(IEntity entity) {
        Message message = (Message) entity;

        dao.saveMessage(message);
    }
}
