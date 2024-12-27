package com.alexey.crud.controller;

import com.alexey.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping(value = "")
    public String getAdminPage(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByEmail(principal.getName()));
        return "/admin";
    }
}
