package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.services.MessageService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 1/18/16
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {
    private MessageService messageService;

    @Inject
    public HomeController(MessageService service) {
        this.messageService = service;
    }

    @RequestMapping({"/","/home"})
    public String showHomePage() {
        return "home";
    }

    /*@RequestMapping({"/","/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("spittles", spitterService.getRecentSpittles(
                DEFAULT_SPITTLES_PER_PAGE));
        return "home";
    } */
}
