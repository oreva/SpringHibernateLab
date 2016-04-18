package com.oreva.simpleweb.mvc.services;

import com.oreva.simpleweb.mvc.dao.TagDAO;
import com.oreva.simpleweb.mvc.entities.Tag;
import com.oreva.simpleweb.mvc.web.dto.TagDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 4/5/16
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class TagService extends EntityService<Tag, TagDTO> {
    @Inject
    TagDAO dao;

    @Override
    public TagDTO convertEntityToStub(Tag entity) {
        TagDTO stub = new TagDTO();
        stub.setText(entity.getText());
        return stub;
    }

    @Override
    public Tag convertStubToEntity(TagDTO stub) {
        Tag tag = new Tag();
        tag.setText(stub.getText());
        return tag;
    }

    /**
     *
     * @param tagString comma separated string with tags
     * @return
     */
    public List<Tag> saveTagsFromString(String tagString) {
        String[] tagStrings = tagString.split("\\,");
        List<Tag> result = new ArrayList<Tag>();
        for (String ts: tagStrings) {
            Tag tag = dao.getByName(ts.trim());
            if (null == tag) {
                //save new tag
                tag = new Tag(ts);
                dao.save(tag);
            }
            result.add(tag);
        }
        return result;
    }
}
