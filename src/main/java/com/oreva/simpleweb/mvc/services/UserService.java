package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.dao.UserDAO;
import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.web.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/30/16
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class UserService extends EntityService<User> {
    @Inject
    private UserDAO dao;

    @Override
    public User getById(Long id) {
        return dao.getById(id);
    }

    public User getUserWithMessages(Long userId) {
        return dao.getUserWithMessages(userId);
    }

    public List<User> loadAllUsers() {
        return dao.loadAllUsers();
    }

    @Override
    public void save(User entity) {
        dao.save(entity);
    }
}
