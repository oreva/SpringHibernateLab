package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.beans.Message;
import com.oreva.simpleweb.mvc.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 3/8/16
 * Time: 9:24 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    @Inject
    public MessageController(MessageService service) {

        this.messageService = service;
    }

    //@RequestMapping(method = RequestMethod.GET, params = "new")
    //@RequestMapping(value = "/edit", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String storeMessage(Model model) {
        model.addAttribute(new Message());
        return "messages/edit";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addMessageFromForm(@Valid Message message,
                                     Errors errors) {
        if(errors.hasErrors()) {
            return "messages/edit";
        }
        messageService.save(message);
        return "messages/result";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String showResultPage(Model model) {
        return "messages/result";
    }

    /*@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAllMessages(Model model) {
        return "messages/list";
    }     */
}
