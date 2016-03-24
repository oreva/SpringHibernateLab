package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.beans.IEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/23/16
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IEntityService {

    IEntity getById();

    void save(IEntity entity);
}
