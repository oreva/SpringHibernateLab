package com.oreva.simpleweb.mvc.repositories_spring_data_jpa;

import com.oreva.simpleweb.mvc.entities.Tag;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 4/26/2016.
 */
public class TagRepositoryImpl implements TagRepositoryCustom {
    @Inject
    TagRepository tagRepository;

    @Override
    public List<Tag> saveTagsFromString(String tagString) {
        String[] tagStrings = tagString.split("\\,");
        List<Tag> result = new ArrayList<Tag>();
        for (String ts: tagStrings) {
            Tag tag = tagRepository.findByText(ts.trim());
            if (null == tag) {
                //save new tag
                tag = new Tag(ts);
                tagRepository.save(tag);
            }
            result.add(tag);
        }
        return result;
    }
}
