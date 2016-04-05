package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.entities.Message;
import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.services.MessageService;
import com.oreva.simpleweb.mvc.services.UserService;
import com.oreva.simpleweb.mvc.web.stubs.MessageStub;
import com.oreva.simpleweb.mvc.web.stubs.UserStub;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

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
    @Inject
    private MessageService messageService;
    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String storeMessage(Model model) {
        model.addAttribute(new MessageStub());

        return "messages/edit";
    }

    @RequestMapping(method = RequestMethod.GET, params = "listCurrent")
    public String showCurrentUserMessages(Model model) {
        return showUserMessages(userService.getCurrentUser().getId(), model);
    }

    @RequestMapping(method = RequestMethod.GET, params = "list")
    public String showMessages(Model model, HttpServletRequest request) {
        String userIdString = request.getParameter("list");
        try {
            Long userId = Long.valueOf(userIdString);
            return showUserMessages(userId, model);
        } catch (Exception e) {
            //do nothing
        }

        // Show all messages
        List<Message> sources = messageService.loadAllMessages();
        List<MessageStub> messages = messageService.convertListOfEntities(sources);
        model.addAttribute("messages", messages);
        return "messages/list";
    }

    public String showUserMessages(Long userId, Model model) {
        User user = userService.getUserWithMessages(userId);
        List<Message> sources = (null != user) ? user.getMessages() : new LinkedList<Message>();
        List<MessageStub> messages = messageService.convertListOfEntities(sources);
        model.addAttribute("messages", messages);
        return "messages/list";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addMessageFromForm(@Valid MessageStub messageStub,
                                     Errors errors) {
        if(errors.hasErrors()) {
            return "messages/edit";
        }

        Message message = messageService.convertStubToEntity(messageStub);
        messageService.newMessage(message);

        return "messages/result";
    }

    /*@RequestMapping(value = "/result", method = RequestMethod.GET)
    public String showResultPage(Model model) {
        model.addAttribute("userId", userService.getCurrentUser().getId());
        return "messages/result";
    }*/
}
