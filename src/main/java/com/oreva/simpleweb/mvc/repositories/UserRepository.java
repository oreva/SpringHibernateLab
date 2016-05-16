package com.oreva.simpleweb.mvc.repositories;

import com.oreva.simpleweb.mvc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Olga on 5/14/2016.
 * Spring Data JPA Repository for Users.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long id);
    User findByMail(String email);
}
