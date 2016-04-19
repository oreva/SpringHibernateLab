package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.Tag;
import com.oreva.simpleweb.mvc.web.dto.TagDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 4/19/16
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TagToDTOConverter implements Converter<Tag, TagDTO> {
    @Override
    public TagDTO convert(Tag entity) {
        TagDTO stub = new TagDTO();
        stub.setText(entity.getText());
        return stub;
    }
}
