package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.web.dto.IDTO;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/23/16
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IEntityService<E extends IEntity, S extends IDTO> {

    E getById(Long id);

    void save(E entity);
    void saveFromStub(S entity);


}
