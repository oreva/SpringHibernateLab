package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.Role;
import com.oreva.simpleweb.mvc.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Olga on 7/6/2016.
 */
@Component
public class RoleFromStringConverter implements Converter<String, Role> {
    @Autowired
    public RoleService roleService;

    @Override
    public Role convert(String s) {
        return roleService.findByName(s);
    }
}
