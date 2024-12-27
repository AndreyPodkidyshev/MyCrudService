package com.alexey.crud.controller;

import com.alexey.crud.model.User;
import com.alexey.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value = {("/login"), ("/index"), ("/")})
    public String login(Model model) {
        return "/login";
    }

    @GetMapping(value = "/user")
    public String getUserPage(Model model, Principal principal) {
        User user = userService.getUserByEmail(principal.getName());
        model.addAttribute("user", user);
        return "/user";
    }
}
