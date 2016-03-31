package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.web.stubs.IStub;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/31/16
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IEntityConversionProvider<E extends IEntity, S extends IStub> {

    S convertEntityToStub(E entity);
    E convertStubToEntity(S stub);

    List<S> convertListOfEntities(List<E> entities);
    List<E> convertListOfStubs(List<S> stubs);
}
