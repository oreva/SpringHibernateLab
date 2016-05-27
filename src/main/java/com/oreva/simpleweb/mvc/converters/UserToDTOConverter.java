package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.web.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 4/19/16
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserToDTOConverter implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(User entity) {
        UserDTO stub = new UserDTO();
        stub.setId(entity.getId());
        stub.setFirstName(entity.getFirstName());
        stub.setLastName(entity.getLastName());
        stub.setMail(entity.getMail());
        stub.setPhone(entity.getPhone());
        return stub;
    }
}
