package com.oreva.simpleweb.mvc.dao;

import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/30/16
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDAO extends EntityDAO<User> {
    @Override
    public User getById(Long id) {
        Query query = entityManager.createQuery("FROM User where id = :idParam")
                .setParameter("idParam", id);
        Object result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return (User) result;
    }

    public User getUserWithMessages(Long userId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        root.fetch("messages", JoinType.LEFT);
        query.select(root).where(
                builder.and(
                        builder.equal(root.get("id"), userId)
                )
        );
        User user;
        try {
            user = entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }
        return user;
    }
}
