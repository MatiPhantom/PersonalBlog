package com.personalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.personalblog.persistence.dao.DAO;
import com.personalblog.persistence.model.User;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SessionService {

    @Autowired
    private DAO<User> userDAO;

    private final HttpSession session;

    public SessionService(HttpSession session) {
        this.session = session;
    }

    public void setUser(Integer userId) {
        session.setAttribute("userLogedId", userId);
    }

    public int getUserLogedId() {
        Integer userId = (Integer) session.getAttribute("userLogedId");
        return userId != null ? userId : 0;
    }

    public User getUserLoged() {
        Integer userId = getUserLogedId();
        if (session.getAttribute("userLogedId") != null) {
            return userDAO.findById(userId);
        }
        log.error("The attribute userLogedId is null");
        return new User();
    }

    public boolean isUserLoggedIn() {
        return getUserLogedId() != 0;
    }

    public void clearSession() {
        session.invalidate();
        log.info("Session cleared");
    }

}
