package com.oreva.simpleweb.mvc.config.security;

import com.oreva.simpleweb.mvc.entities.Role;
import com.oreva.simpleweb.mvc.services.RoleService;
import com.oreva.simpleweb.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;

/**
 * Created by Olga on 4/26/2016.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    public RoleService roleService;
    @Autowired
    public UserService userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Setup all roles first
        roleService.initRoles();
        // Init admin user
        userService.initAdminUser(userDetailsService);

        // Set userDetailsService for all other users
        /*auth
            .inMemoryAuthentication()
            .withUser("admin").password("admin").roles(Role.ADMIN_ROLE);*/

        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.userDetailsService(userDetailsService);

        http.authorizeRequests()
                .antMatchers("/users/register/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    /*@Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }*/
}