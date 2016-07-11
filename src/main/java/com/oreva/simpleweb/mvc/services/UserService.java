package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.entities.Role;
import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.repositories.RoleRepository;
import com.oreva.simpleweb.mvc.repositories.UserRepository;
import com.oreva.simpleweb.mvc.web.dto.UserDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
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
    public UserRepository repository;
    @Inject
    public RoleService roleService;

    @Override
    public User findById(Long id) {
        return repository.findById(id);
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object user = (authentication != null) ? authentication.getPrincipal() :  null;
        if (user instanceof User) {
            return (User) user;
        }
        return null;
    }

    public User findById(Long id, boolean fetchMessages) {
        if (fetchMessages) {
            return repository.findByIdAndFetchMessagesEagerly(id);
        }
        return findById(id);
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

    public void initAdminUser(UserDetailsService userDetailsService) {
        UserDetails existingAdmin = userDetailsService.loadUserByUsername(User.ADMIN_USERNAME);
        if (null == existingAdmin) {
            User admin = User.admin;

            Role adminRole = roleService.findByName(Role.ADMIN_ROLE);
            if (null != adminRole) {
                admin.getRoles().add(adminRole);
            }
            repository.save(admin);
        }
    }

    //?crash??@PreAuthorize("hasAuthority('DELETE_USERS')")
    public void delete(Long userId) {

        repository.delete(userId);
    }

    public void updateUserRoles(User user, List<String> newRoleNames) {
        List<Role> rolesToRemove = new ArrayList<>();

        for (Role r: user.getRoles()) {
            if (newRoleNames.indexOf(r.getName()) < 0) {
                rolesToRemove.add(r);
            }
        }
        // Remove old roles
        for (Role r: rolesToRemove) {
            user.getRoles().remove(r);
        }

        List<String> roleNamesToAdd = new ArrayList<>();
        for (String roleName: newRoleNames) {
            boolean addRole = true;
            for (Role role: user.getRoles()) {
                if (role.getName().equals(roleName)) {
                    addRole = false;
                    break;
                }
            }
            if (addRole) {
                roleNamesToAdd.add(roleName);
            }
        }
        //Add new roles
        for (String roleName: roleNamesToAdd) {
            Role role = roleService.findByName(roleName);
            user.getRoles().add(role);
        }

        //Save
        repository.save(user);
    }
}
