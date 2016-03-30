package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.web.stubs.IStub;
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
public abstract class EntityService implements IEntityService {
    @Override
    public IEntity getById() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(IEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void saveFromStub(IStub stub) {
        throw new UnsupportedOperationException();
    }
}
