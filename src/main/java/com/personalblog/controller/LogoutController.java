package com.personalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personalblog.service.SessionService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/logout")
@Slf4j
public class LogoutController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public String logout() {
        sessionService.clearSession();

        return "redirect:/";
    }

}
