package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.services.UserService;
import com.oreva.simpleweb.mvc.web.dto.UserDTO;
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
@RequestMapping("/users")
public class UserController {
    @Inject
    public UserService userService;
    @Inject
    public ConversionService conversionService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(Model model) {
        model.addAttribute("userStub", new UserDTO());
        return "users/edit";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveNewUser(Model model,
                            @ModelAttribute("userStub") @Valid UserDTO userStub,
                            Errors errors) {
        String currentPage = "users/edit";
        String nextPage = "redirect:/home";

        if (errors.hasErrors()) {
            return currentPage;
        }
        //Save user information
        User user = conversionService.convert(userStub, User.class);
        userService.save(user);

        //Save user in session when register
        //model.addAttribute("user", user);

        return nextPage;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveUser(Model model,
                            @ModelAttribute("userStub") @Valid UserDTO userStub,
                            Errors errors) {

        String currentPage = "users/edit";
        String nextPage = "redirect:/home";

        if (errors.hasErrors()) {
            return currentPage;
        }
        //Save user information
        User user = conversionService.convert(userStub, User.class);
        userService.save(user);

        return nextPage;
    }



    @RequestMapping(value = "/edit", method = RequestMethod.GET, params = "user")
    @PreAuthorize("hasAuthority('EDIT_USERS')")
    public String editUser(Model model, HttpServletRequest request) {
        Long userId = Long.valueOf(request.getParameter("user"));
        User user = userService.findById(userId); //userService.getById(userId);
        UserDTO userStub = conversionService.convert(user, UserDTO.class);

        model.addAttribute("userStub", userStub);
        return "users/edit";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('VIEW_ALL_USERS')")
    public String listAllUsers(Model model) {
        List<User> sources = userService.findAllUsers(); //userService.loadAllUsers();
        List<UserDTO> users = (List<UserDTO>) conversionService.convert(sources,
                TypeDescriptor.forObject(sources),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDTO.class)));
        model.addAttribute("users", users);
        return "users/list";
    }
}
