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
    @Inject
    private MessageService messageService;
    @Inject
    private UserService userService;

    //@RequestMapping(method = RequestMethod.GET, params = "new")
    //@RequestMapping(value = "/edit", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String storeMessage(Model model) {
        model.addAttribute(new MessageStub());

        //new user (temp code)
        User user = new User();
        user.setMail("oreva@gmail.com");
        user.setPhone("3510975");
        user.setFirstName("Olga");
        user.setLastName("Reva");
        userService.save(user);
        userService.setCurrentUser(user);

        return "messages/edit";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addMessageFromForm(@Valid MessageStub messageStub,
                                     Errors errors) {
        if(errors.hasErrors()) {
            return "messages/edit";
        }

        User user = userService.getCurrentUser();
        Message message = (Message) messageStub.convertToEntity();
        user.addMessage(message);
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
