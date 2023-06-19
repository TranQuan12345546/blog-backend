package com.example.blog.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {
    @GetMapping("/api/v1/login")
    public String login() {
        return "admin/blog/create-user";
    }
}
