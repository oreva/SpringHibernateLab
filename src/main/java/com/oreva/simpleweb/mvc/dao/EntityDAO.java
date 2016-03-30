package com.oreva.simpleweb.mvc.dao;

import com.oreva.simpleweb.mvc.entities.IEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/30/16
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public abstract class EntityDAO implements IEntityDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(IEntity entity) {
        entityManager.persist(entity);
    }
}