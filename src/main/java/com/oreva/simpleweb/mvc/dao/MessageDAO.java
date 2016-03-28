package com.oreva.simpleweb.mvc.dao;

import com.oreva.simpleweb.mvc.entities.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/17/16
 * Time: 11:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
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
