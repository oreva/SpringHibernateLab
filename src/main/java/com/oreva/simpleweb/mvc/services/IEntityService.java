package com.oreva.simpleweb.mvc.services;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/23/16
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IEntityService<E> {

    E getById(Long id);

    void save(E entity);


}
