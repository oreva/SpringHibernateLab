package com.oreva.simpleweb.mvc.repositories_spring_data_jpa;

import com.oreva.simpleweb.mvc.entities.Tag;

import java.util.List;

/**
 * Created by Olga on 4/26/2016.
 */
public interface TagRepositoryCustom {
    List<Tag> saveTagsFromString(String tagString);
}
