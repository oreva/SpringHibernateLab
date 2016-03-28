package com.oreva.simpleweb.mvc.converters;

import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/28/16
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IConvertible<SourceType extends IConvertible, TargetType> {
    Converter<SourceType, TargetType> converter();
}
