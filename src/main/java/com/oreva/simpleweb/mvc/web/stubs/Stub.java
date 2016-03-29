package com.oreva.simpleweb.mvc.web.stubs;

import com.oreva.simpleweb.mvc.entities.IEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/28/16
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Stub implements IStub {
    /**
     *
     * @return null if there is no way to convert to IEntity
     */
    @Override
    public IEntity convertToEntity() {
        return null;
    }
}
