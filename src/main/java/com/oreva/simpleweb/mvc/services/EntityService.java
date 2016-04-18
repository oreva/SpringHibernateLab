package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.web.dto.IDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/23/16
 * Time: 12:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public abstract class EntityService<E extends IEntity, S extends IDTO>
        implements IEntityService<E, S>, IEntityConversionProvider<E, S> {
    @Override
    public E getById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(E entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void saveFromStub(S stub) {
        E entity = convertStubToEntity(stub);
        save(entity);
    }

    @Override
    public S convertEntityToStub(E entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E convertStubToEntity(S stub) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<S> convertListOfEntities(List<E> entities) {
        List<S> result = new ArrayList<S>();
        for (E entity: entities) {
            result.add(convertEntityToStub(entity));
        }
        return result;
    }

    @Override
    public List<E> convertListOfStubs(List<S> stubs) {
        List<E> result = new ArrayList<E>();
        for (S stub: stubs) {
            result.add(convertStubToEntity(stub));
        }
        return result;
    }
}
