package com.oreva.simpleweb.mvc.dao;

import com.oreva.simpleweb.mvc.beans.Message;
import com.oreva.simpleweb.mvc.util.JPAUtil;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/17/16
 * Time: 11:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MessageDAO {
    public void saveMessage(Message message) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(message);

        transaction.commit();
        entityManager.close();
    }
}
