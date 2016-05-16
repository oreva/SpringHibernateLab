package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.services.UserService;
import com.oreva.simpleweb.mvc.web.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 1/18/16
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
@RequestMapping({"/","/home"})
@SessionAttributes({"user"})
public class HomeController {
    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(Model model) {
        model.addAttribute("userStub", new UserDTO());
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST, params = "login")
    public String login(Model model,
                       @Valid UserDTO userStub,
                       Errors errors) {
        String currentPage = "home";
        String nextPage = "redirect:/messages/result";

        Long enteredID = userStub.getId();
        if (null != enteredID && 0 < enteredID && 100 > enteredID) {
            User user = userService.findById(enteredID); //userService.getById(enteredID);
            if (null != user) {
                model.addAttribute("user", user);
                return nextPage;
            } else {
                model.addAttribute("errorStr", "There is no registered user with entered id");
            }
        }
        return currentPage;
    }
}
