package com.oreva.simpleweb.mvc.repositories;

import com.oreva.simpleweb.mvc.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Olga on 5/14/2016.
 * Spring Data JPA Repository for Users.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long id);
    User findByMail(String email);


    //We could use EntityGraph instead of the @Query, but our problem is "how to define 2 methods findById for user without messages and with messages? JpaRepository's naming convensions don't allow us to do so.":
    //@EntityGraph(value = "userWithMessagesEntityGraph", type = EntityGraph.EntityGraphType.FETCH)
    //User findById(Long id);
    @Query("SELECT u FROM User u JOIN FETCH u.messages WHERE u.id = (:id)")
    User findByIdAndFetchMessagesEagerly(@Param("id") Long id);
}
