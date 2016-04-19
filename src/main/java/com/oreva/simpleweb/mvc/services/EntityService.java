package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.Entity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/23/16
 * Time: 12:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public abstract class EntityService<E extends Entity> implements IEntityService<E> {
    @Override
    public E getById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(E entity) {
        throw new UnsupportedOperationException();
    }
}
