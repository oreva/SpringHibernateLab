package com.oreva.simpleweb.mvc.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/30/16
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IEntityDAO<E> {

    E getById(Long id);
    void save(E entity);
}
