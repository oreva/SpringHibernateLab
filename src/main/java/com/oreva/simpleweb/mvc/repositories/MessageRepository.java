package com.oreva.simpleweb.mvc.repositories;

import com.oreva.simpleweb.mvc.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Olga on 5/14/2016.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findById(Long id);
}
