package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Olga on 7/6/2016.
 */
@Component
public class RoleToStringConverter implements Converter<Role, String> {
    @Override
    public String convert(Role role) {
        return role.toString();
    }
}
