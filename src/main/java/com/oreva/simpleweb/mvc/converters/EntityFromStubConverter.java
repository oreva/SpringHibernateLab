package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.Entity;
import com.oreva.simpleweb.mvc.web.stubs.Stub;
import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/28/16
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityFromStubConverter implements Converter<Stub, Entity> {
    @Override
    public Entity convert(Stub stub) {
        Converter c = stub.converter();
        return (Entity) c.convert(stub);
    }
}
