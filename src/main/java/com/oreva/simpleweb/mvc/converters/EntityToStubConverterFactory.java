package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.Entity;
import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.web.stubs.IStub;
import com.oreva.simpleweb.mvc.web.stubs.Stub;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/29/16
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class EntityToStubConverterFactory implements ConverterFactory<IEntity, IStub> {
    @Override
    public <T extends IStub> Converter<IEntity, T> getConverter(Class<T> targetType) {
        return new EntityToStubConverter(targetType);
    }

    private final class EntityToStubConverter<T extends IStub> implements Converter<IEntity, T> {
        private Class<T> stubType;

        public EntityToStubConverter(Class<T> stubType) {
            this.stubType = stubType;
        }

        public T convert(IEntity source) {
            return (T) source.convertToStub();
        }
    }
}
