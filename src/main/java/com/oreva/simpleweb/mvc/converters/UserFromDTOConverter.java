package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.web.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 4/19/16
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserFromDTOConverter implements Converter<UserDTO, User> {
    @Override
    public User convert(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMail(userDTO.getMail());
        user.setPhone(userDTO.getPhone());
        return user;
    }
}
