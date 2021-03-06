package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.entities.Message;
import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.services.MessageService;
import com.oreva.simpleweb.mvc.services.UserService;
import com.oreva.simpleweb.mvc.web.dto.MessageDTO;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 3/8/16
 * Time: 9:24 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
@RequestMapping("/messages")
public class MessageController {
    @Inject
    public MessageService messageService;
    @Inject
    public UserService userService;
    @Inject
    public ConversionService conversionService;

    //@RequestMapping(method = RequestMethod.GET, params = "new")
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String storeMessage(Model model) {
        model.addAttribute("messageStub", new MessageDTO());

        return "messages/edit";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET, params = "listCurrent")
    public String showCurrentUserMessages(Model model) {//, @ModelAttribute User user) {
        return showUserMessages(userService.getCurrentUser().getId(), model);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET, params = "list")
    @PreAuthorize("hasAuthority('VIEW_ALL_MESSAGES')")
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
        List<MessageDTO> messages = (List<MessageDTO>) conversionService.convert(
                sources,
                TypeDescriptor.forObject(sources),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MessageDTO.class))
        );
        model.addAttribute("messages", messages);
        return "messages/list";
    }

    public String showUserMessages(Long userId, Model model) {
        User user = userService.findById(userId, true); //userService.getUserWithMessages(userId);
        List<Message> sources = (null != user) ? user.getMessages() : new ArrayList<Message>();
        List<MessageDTO> messages = (List<MessageDTO>) conversionService.convert(
                sources,
                TypeDescriptor.forObject(sources),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MessageDTO.class))
        );
        model.addAttribute("messages", messages);
        return "messages/list";
    }

    @RequestMapping(value = "/new", method=RequestMethod.POST)
    public String addMessageFromForm(Model model,
                                     @ModelAttribute("messageStub") @Valid MessageDTO messageStub,
                                     Errors errors) {
        if(errors.hasErrors()) {
            return "messages/edit";
        }
        User currentUser = userService.getCurrentUser();
        User user = userService.findById(currentUser.getId(), true);
        //Create new message when collection of messages will be created
        messageService.newMessage(messageStub, user, conversionService);

        return "redirect:/home";
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "/result")
    public String showResultPage() {
        return "messages/result";
    }*/
}
