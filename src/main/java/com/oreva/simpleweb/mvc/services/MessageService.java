package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.beans.Message;
import com.oreva.simpleweb.mvc.util.JPAUtil;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 1/18/16
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MessageService {
    public void saveMessage(Message message) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(message);

        transaction.commit();
        entityManager.close();
    }
}
