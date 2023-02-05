package com.example.BazaClients.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class UserController {

    @GetMapping("admin")
    public String getAdminPage() {
        return "baza";
    }

    @GetMapping("user")
    public String ShowUser() {
        return "user";
    }

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }
}
