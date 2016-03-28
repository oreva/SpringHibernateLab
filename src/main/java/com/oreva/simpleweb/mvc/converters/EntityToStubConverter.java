package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.Entity;
import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.web.stubs.IStub;
import com.oreva.simpleweb.mvc.web.stubs.Stub;
import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/28/16
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityToStubConverter implements Converter<Entity, Stub> {
    @Override
    public Stub convert(Entity source) {
        Converter converter = source.converter();
        return (Stub) converter.convert(source);
    }
}
