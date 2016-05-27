package com.oreva.simpleweb.mvc.converters;

import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Olga on 5/18/2016.
 */
@Component
public class CustomConversionServiceFactoryBean extends ConversionServiceFactoryBean {
    @Inject
    private UserFromDTOConverter userFromDTOConverter;
    @Inject
    private UserToDTOConverter userToDTOConverter;
    @Inject
    private MessageFromDTOConverter messageFromDTOConverter;
    @Inject
    private MessageToDTOConverter messageToDTOConverter;
    @Inject
    private TagToDTOConverter tagToDTOConverter;
    @Inject
    private TagFromDTOConverter tagFromDTOConverter;

    @Override
    public void afterPropertiesSet() {
        Set<Converter> converters = new HashSet<>();
        converters.addAll(Arrays.asList(userFromDTOConverter, userToDTOConverter,
                messageFromDTOConverter, messageToDTOConverter,
                tagFromDTOConverter, tagToDTOConverter));
        setConverters(converters);

        super.afterPropertiesSet();
    }
}
