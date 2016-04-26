package com.oreva.simpleweb.mvc.dao;

import com.oreva.simpleweb.mvc.entities.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 4/5/16
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class delete_TagDAO extends EntityDAO<Tag> {

    public Tag getByName(String tagName) {
        Query query = entityManager.createQuery("FROM Tag where text = :nameParam")
                .setParameter("nameParam", tagName);
        Object result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return (Tag) result;
    }
}
