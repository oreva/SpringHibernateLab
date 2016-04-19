package com.oreva.simpleweb.mvc.dao;

import com.oreva.simpleweb.mvc.entities.Entity;
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
public abstract class EntityDAO<E extends Entity> implements IEntityDAO<E> {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public E getById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(E entity) {
        entityManager.persist(entity);
    }
}
