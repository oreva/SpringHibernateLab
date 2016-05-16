package com.oreva.simpleweb.mvc.repositories;

import com.oreva.simpleweb.mvc.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Olga on 5/5/2016.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
