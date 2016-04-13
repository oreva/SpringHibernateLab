package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.services.UserService;
import com.oreva.simpleweb.mvc.web.stubs.UserStub;
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
 * Date: 4/13/16
 * Time: 12:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
@SessionAttributes({"user"})
@RequestMapping("/users")
public class UserController {
    @Inject
    private UserService userService;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    private String editUser(Model model) {
        model.addAttribute(new UserStub());
        return "users/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    private String saveUser(Model model, @Valid UserStub userStub, Errors errors) {

        String currentPage = "users/edit";
        String nextPage = "redirect:/messages/result";

        if (errors.hasErrors()) {
            return currentPage;
        }
        //Save user information
        User user = userService.convertStubToEntity(userStub);
        userService.save(user);
        model.addAttribute("user", user);

        return nextPage;
    }
}
