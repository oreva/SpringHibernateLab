package com.oreva.simpleweb.mvc.security;

import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Olga on 5/3/2016.
 */
@Service("userDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Inject
    private UserService localUserService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = localUserService.findByMail(email); //localUserService.getByEmail(email);
        return user;
    }
}
