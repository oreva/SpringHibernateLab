package com.oreva.simpleweb.mvc.controllers;

import com.oreva.simpleweb.mvc.entities.Role;
import com.oreva.simpleweb.mvc.entities.User;
import com.oreva.simpleweb.mvc.services.RoleService;
import com.oreva.simpleweb.mvc.services.UserService;
import com.oreva.simpleweb.mvc.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    public UserService userService;
    @Autowired
    public ConversionService conversionService;
    @Autowired
    public RoleService roleService;

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

    @RequestMapping(value = {"/edit", "/editProfile"}, method = RequestMethod.POST)
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

    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public String editUserProfile(Model model, HttpServletRequest request) {
        User currentUser = userService.getCurrentUser();
        UserDTO userStub = conversionService.convert(currentUser, UserDTO.class);

        model.addAttribute("userStub", userStub);
        return "users/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET, params = "user")
    @PreAuthorize("hasAuthority('EDIT_USERS')")
    public String editUser(Model model, HttpServletRequest request) {
        Long userId = Long.valueOf(request.getParameter("user"));
        User user = userService.findById(userId);
        UserDTO userStub = conversionService.convert(user, UserDTO.class);

        model.addAttribute("userStub", userStub);
        return "users/edit";
    }

    @RequestMapping(value = "/editUserRoles", method = RequestMethod.GET, params = "user")
    @PreAuthorize("hasAuthority('EDIT_USER_ROLES')")
    public String editUserRoles(Model model, HttpServletRequest request) {
        Long userId = Long.valueOf(request.getParameter("user"));
        User user = userService.findById(userId);
        UserDTO userDTO = conversionService.convert(user, UserDTO.class);

        String[] allRoles = Role.allRoleNames;
        List<String> userRoles = (List<String>) conversionService.convert(
                user.getRoles(),
                TypeDescriptor.forObject(user.getRoles()),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class))
        );

        userDTO.setRoles(userRoles);
        //model.addAttribute("userRoles", userRoles.toArray());
        model.addAttribute("roles", allRoles);
        //model.addAttribute("userId", userId);
        model.addAttribute("userDTO", userDTO);
        return "users/editUserRoles";
    }

    @RequestMapping(value = "/editUserRoles", method = RequestMethod.POST,
            params = {"cancel=true"})
    public String cancelEditUserRoles(Model model,
                                      @ModelAttribute("userDTO") UserDTO userDTO) {
        return "redirect:list";
    }

    @RequestMapping(value = "/editUserRoles", method = RequestMethod.POST,
        params = {"cancel!=true"})
    @PreAuthorize("hasAuthority('EDIT_USER_ROLES')")
    public String editUserRoles(Model model,
                                //@RequestParam("userId") Long userId,
                                @ModelAttribute("userDTO") UserDTO userDTO) {
                                //@RequestParam("newRoles") String[] newRoles) {
        User user = userService.findById(userDTO.getId());
        userService.updateUserRoles(user, userDTO.getRoles());

        return "redirect:list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, params = "user")
    @PreAuthorize("hasAuthority('DELETE_USERS')")
    public String deleteUser(Model model, HttpServletRequest request) {
        Long userId = Long.valueOf(request.getParameter("user"));
        User user = userService.findById(userId);
        UserDTO userStub = conversionService.convert(user, UserDTO.class);

        model.addAttribute("userStub", userStub);
        return "users/confirmDelete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('DELETE_USERS')")
    public String doDeleteUser(Model model,
                           @ModelAttribute("userStub") UserDTO userStub) {

        //Here we have a dirty hack: we use user's firstName field to store there information about the action we want to do: to delete or cancel deletion of the user
        String action = userStub.getFirstName();
        if (!action.equals("cancel")) {
            userService.delete(userStub.getId());
        }
        return "redirect:list";
    }

    /*@RequestMapping(value = "/delete", method = RequestMethod.POST,
            params = {"cancel=true"})
    public String cancelDeleteUser(Model model,
                               @ModelAttribute("userStub") UserDTO userStub,
                                   HttpServletRequest request) {

        return "redirect:list";
    }*/

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('VIEW_ALL_USERS')")
    public String listAllUsers(Model model) {
        List<User> sources = userService.findAllUsers();
        List<UserDTO> users = (List<UserDTO>) conversionService.convert(sources,
                TypeDescriptor.forObject(sources),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDTO.class)));
        model.addAttribute("users", users);
        return "users/list";
    }
}
