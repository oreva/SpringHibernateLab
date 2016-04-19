package com.oreva.simpleweb.mvc.dao;

import com.oreva.simpleweb.mvc.entities.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/17/16
 * Time: 11:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class MessageDAO extends EntityDAO<Message> {

    public List<Message> loadAllMessages() {
        Query query = entityManager.createQuery("FROM Message");
        return query.getResultList();
    }
}
