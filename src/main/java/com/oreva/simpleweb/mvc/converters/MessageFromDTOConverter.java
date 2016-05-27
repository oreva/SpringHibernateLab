package com.oreva.simpleweb.mvc.converters;

import com.oreva.simpleweb.mvc.entities.Message;
import com.oreva.simpleweb.mvc.services.MessageService;
import com.oreva.simpleweb.mvc.web.dto.MessageDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 4/19/16
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MessageFromDTOConverter implements Converter<MessageDTO, Message> {
    @Inject
    private MessageService messageService;

    @Override
    public Message convert(MessageDTO messageDTO) {
        Message entity = messageService.findById(messageDTO.getId());
        if (null == entity) {
            entity = new Message();
        }
        entity.setText(messageDTO.getText());
        return entity;
    }
}
