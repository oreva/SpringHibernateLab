package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.Role;
import com.oreva.simpleweb.mvc.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Olga on 7/1/2016.
 */
@Service
@Transactional
public class RoleService extends EntityService<Role> {
    @Autowired
    public RoleRepository repository;

    public List<Role> findAll() {
        List<Role> roles = repository.findAll();
        return roles;
    }

    public void initRoles() {
        Map rolesByNames = Role.roleByNamesMap;
        Iterator iterator = rolesByNames.keySet().iterator();
        while (iterator.hasNext()){
            String roleName = (String) iterator.next();
            Role role = repository.findByName(roleName);
            if (null == role) {
                role = (Role) rolesByNames.get(roleName);
                repository.save(role);
            }
        }
    }

    public Role findByName(String roleName) {
        return repository.findByName(roleName);
    }
}
