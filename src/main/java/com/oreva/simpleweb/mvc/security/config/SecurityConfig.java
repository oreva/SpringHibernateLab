package com.oreva.simpleweb.mvc.security.config;

import com.oreva.simpleweb.mvc.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Olga on 4/26/2016.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*auth
            .inMemoryAuthentication()
            .withUser("user").password("password").roles("USER");*/

        auth.userDetailsService(userDetailsService);
        //JdbcUserDetailsManagerConfigurer configurer = auth.jdbcAuthentication();

        //test
        //UserDetailsService service = configurer.getUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.userDetailsService(userDetailsService);

        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/register/**").permitAll()
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