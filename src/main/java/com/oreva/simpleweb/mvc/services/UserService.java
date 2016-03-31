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
public class UserService extends EntityService<User, UserStub> {
    @Inject
    private UserDAO dao;

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    @Override
    public void save(User entity) {
        dao.save(entity);
    }

    @Override
    public UserStub convertEntityToStub(User entity) {
        UserStub stub = new UserStub();
        stub.setId(entity.getId());
        stub.setFirstName(entity.getFirstName());
        stub.setLastName(entity.getLastName());
        stub.setMail(entity.getMail());
        stub.setPhone(entity.getPhone());
        return stub;
    }

    @Override
    public User convertStubToEntity(UserStub stub) {
        User user = new User();
        user.setId(stub.getId());
        user.setFirstName(stub.getFirstName());
        user.setLastName(stub.getLastName());
        user.setMail(stub.getMail());
        user.setPhone(stub.getPhone());
        return user;
    }
}
