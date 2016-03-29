package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.web.stubs.IStub;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/29/16
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityFromStubConverterFactory implements ConverterFactory<IStub, IEntity> {
    @Override
    public <T extends IEntity> Converter<IStub, T> getConverter(Class<T> targetType) {
        return new EntityFromStubConverter(targetType);
    }

    private final class EntityFromStubConverter<T extends IEntity> implements Converter<IStub, T> {
        private Class<T> entityType;

        public EntityFromStubConverter(Class<T> entityType) {
            this.entityType = entityType;
        }

        public T convert(IStub source) {
            return (T) source.convertToEntity();
        }
    }
}
