package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.services.UserService;
import com.oreva.simpleweb.mvc.web.dto.UserDTO;
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
import java.util.List;

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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    private String registerUser(Model model) {
        model.addAttribute("userStub", new UserDTO());
        return "users/edit";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private String saveNewUser(Model model,
                            @ModelAttribute("userStub") @Valid UserDTO userStub,
                            Errors errors) {
        String currentPage = "users/edit";
        String nextPage = "redirect:/messages/result";

        if (errors.hasErrors()) {
            return currentPage;
        }
        //Save user information
        User user = userService.convertStubToEntity(userStub);
        userService.save(user);

        //Save user in session when register
        model.addAttribute("user", user);

        return nextPage;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    private String saveUser(Model model,
                            @ModelAttribute("userStub") @Valid UserDTO userStub,
                            Errors errors) {

        String currentPage = "users/edit";
        String nextPage = "redirect:/messages/result";

        if (errors.hasErrors()) {
            return currentPage;
        }
        //Save user information
        User user = userService.convertStubToEntity(userStub);
        userService.save(user);

        return nextPage;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET, params = "user")
    private String editUser(Model model, HttpServletRequest request) {
        Long userId = Long.valueOf(request.getParameter("user"));
        User user = userService.getById(userId);
        UserDTO userStub = userService.convertEntityToStub(user);
        model.addAttribute("userStub", userStub);
        return "users/edit";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String listAllUsers(Model model) {
        List<User> sources = userService.loadAllUsers();
        List<UserDTO> users = userService.convertListOfEntities(sources);
        model.addAttribute("users", users);
        return "users/list";
    }
}
