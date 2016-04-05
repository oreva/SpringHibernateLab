package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.services.MessageService;
import com.oreva.simpleweb.mvc.services.UserService;
import com.oreva.simpleweb.mvc.web.stubs.UserStub;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 1/18/16
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping({"/","/home"})
public class HomeController {
    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(Model model) {
        model.addAttribute(new UserStub());
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processUserLogin(Model model,
                                   @Valid UserStub userStub,
                                   Errors errors) {
        String currentPage = "home";
        String nextPage = "messages/result";//"redirect:messages?new=";

        Long enteredID = userStub.getId();
        if (null != enteredID && 0 < enteredID && 100 > enteredID) {
            if (loginAsExistingUser(enteredID)) {
                //model.addAttribute("userId", enteredID);
                return nextPage;
            }
            model.addAttribute("errorStr", "There is no registered user with entered id");
            return currentPage;
        }
        model.addAttribute("errorStr", "");
        if (errors.hasErrors()) {
            return currentPage;
        }
        //Save user information
        User user = userService.convertStubToEntity(userStub);
        userService.save(user);
        userService.setCurrentUser(user);

        //model.addAttribute("userId", user.getId());

        return nextPage;
    }

    private Boolean loginAsExistingUser(Long userID) {
        User user = userService.getById(userID);
        if (null != user) {
            userService.setCurrentUser(user);
            return true;
        }
        return false;
    }
}
