package com.oreva.simpleweb.mvc.repositories_spring_data_jpa;

import com.oreva.simpleweb.mvc.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Olga on 4/26/2016.
 * Spring Data JPA Repository for Tags.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByText(String text);
}
