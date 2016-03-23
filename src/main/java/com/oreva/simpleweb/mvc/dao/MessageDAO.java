package com.oreva.simpleweb.mvc.dao;

import com.oreva.simpleweb.mvc.beans.Message;
import com.oreva.simpleweb.mvc.util.JPAUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/17/16
 * Time: 11:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
//@Transactional
public class MessageDAO {

    @PersistenceContext
    EntityManager entityManager;

    //@Inject
    //EntityManagerFactory entityManagerFactory;

    public void saveMessage(Message message) {
        /*EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin(); */

        entityManager.persist(message);

        /*transaction.commit();
        entityManager.close();*/
    }
}
