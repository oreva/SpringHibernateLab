package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.repositories.UserRepository;
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
    private UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id);
    }

    public User findByMail(String email) {
        return repository.findByMail(email);
    }

    /*public User getUserWithMessages(Long userId) {
        return dao.getUserWithMessages(userId);
    }*/

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public void save(User entity) {
        repository.save(entity);
    }
}
