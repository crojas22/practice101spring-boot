package com.example.practice101.web.controller;

import com.example.practice101.model.Role;
import com.example.practice101.model.User;
import com.example.practice101.repository.UserDao;
import com.example.practice101.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthenticationController {

    @Autowired
    UserDao users;

    @RequestMapping("/register")
    public String getRegistrationPage(Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegistrationPage(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            redirectAttributes.addFlashAttribute("user",user);
            return "redirect:/register";
        }
        redirectAttributes.addFlashAttribute("flash", new FlashMessage("Successful registration", FlashMessage.Status.SUCCESS));

        Role role = new Role();
        role.setName("ROLE_USER");
        user.setRole(role);

        users.save(user);
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String getLoginPage(Model model, HttpServletRequest request) {
        try {
            Object flash = request.getSession().getAttribute("flash");
            model.addAttribute("flash", flash);
            // need to manually remove it
            request.getSession().removeAttribute("flash");
        } catch (Exception ex) {
            // flash attribute doesn't exist, no need to do anything
        }
        return "login";
    }
}
