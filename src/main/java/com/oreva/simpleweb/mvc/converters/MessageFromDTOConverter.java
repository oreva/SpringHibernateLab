package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.Message;
import com.oreva.simpleweb.mvc.web.dto.MessageDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 4/19/16
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageFromDTOConverter implements Converter<MessageDTO, Message> {
    @Override
    public Message convert(MessageDTO messageDTO) {
        Message entity = new Message();
        entity.setId(messageDTO.getId());
        entity.setText(messageDTO.getText());
        return entity;
    }
}
