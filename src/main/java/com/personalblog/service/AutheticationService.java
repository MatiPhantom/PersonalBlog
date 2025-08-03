package com.personalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblog.exception.RegisterException;
import com.personalblog.persistence.dao.DAO;
import com.personalblog.persistence.dto.LoginRequestDto;
import com.personalblog.persistence.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AutheticationService {
    @Autowired
    private DAO<User> userDAO;

    public int isAuthenticate(LoginRequestDto loginRequest) {
        var users = userDAO.findAll();
        for (User user : users) {
            if (user.getEmail().equals(loginRequest.getEmail())
                    && user.getPassword().equals(loginRequest.getPassword())) {
                return user.getId();
            }
        }
        log.warn("Authentication failed for email: {}", loginRequest.getEmail());
        return 0;
    }

}
