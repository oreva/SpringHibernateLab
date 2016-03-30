package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.dao.UserDAO;
import com.oreva.simpleweb.mvc.entities.IEntity;
import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.web.stubs.IStub;
import com.oreva.simpleweb.mvc.web.stubs.UserStub;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/30/16
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class UserService extends EntityService {
    @Inject
    private UserDAO dao;

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public UserStub getCurrentUserStub() {
        return (UserStub) currentUser.convertToStub();
    }

    @Override
    public void save(IEntity entity) {
        dao.save(entity);
    }

    @Override
    public void saveFromStub(IStub stub) {
        User user = (User) stub.convertToEntity();
        dao.save(user);
    }
}
