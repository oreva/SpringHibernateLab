package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.Tag;
import com.oreva.simpleweb.mvc.web.dto.TagDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 4/19/16
 * Time: 12:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TagFromDTOConverter implements Converter<TagDTO, Tag> {
    @Override
    public Tag convert(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setText(tagDTO.getText());
        return tag;
    }
}
