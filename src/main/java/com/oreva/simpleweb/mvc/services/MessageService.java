package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.beans.Message;
import com.oreva.simpleweb.mvc.dao.MessageDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 1/18/16
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MessageService {
    private final MessageDAO dao;

    @Inject
    public MessageService(MessageDAO dao) {
        this.dao = dao;
    }

    public void saveMessage(Message message) {
        dao.saveMessage(message);
    }
}
