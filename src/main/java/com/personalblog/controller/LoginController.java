package com.personalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.personalblog.persistence.dto.LoginRequestDto;
import com.personalblog.service.AutheticationService;
import com.personalblog.service.SessionService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private SessionService sessionService;

    @Autowired
    private AutheticationService authService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("loginRequest", new LoginRequestDto());
        return "login/index";
    }

    @PostMapping
    public String login(@ModelAttribute("loginRequest") LoginRequestDto loginRequest,
            RedirectAttributes redirect) {
        int response = authService.isAuthenticate(loginRequest);
        if (response == 0) {
            redirect.addFlashAttribute("errorMessage", "Invalid email or password");
            return "redirect:/login";
        } else {
            sessionService.setUser(response);
            return "redirect:/blog";
        }

    }

}
