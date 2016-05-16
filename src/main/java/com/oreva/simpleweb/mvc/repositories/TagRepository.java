package com.oreva.simpleweb.mvc.repositories;

import com.oreva.simpleweb.mvc.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Olga on 4/26/2016.
 * Spring Data JPA Repository for Tags.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByText(String text);
}
