package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.services.UserService;
import com.oreva.simpleweb.mvc.web.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 4/19/16
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserFromDTOConverter implements Converter<UserDTO, User> {
    @Inject
    private UserService userService;

    @Override
    public User convert(UserDTO userDTO) {
        User user = userService.findById(userDTO.getId());
        if (null == user) {
            user = new User();
        }
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMail(userDTO.getMail());
        user.setPhone(userDTO.getPhone());
        return user;
    }
}
