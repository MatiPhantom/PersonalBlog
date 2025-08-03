package com.personalblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblog.exception.RegisterException;
import com.personalblog.persistence.dao.DAO;
import com.personalblog.persistence.model.User;

@Service
public class UserService {

    @Autowired
    private DAO<User> userDAO;

    public User findUserById(int id) {
        return userDAO.findById(id);
    }

    public List<User> findAllUsers() {
        return userDAO.findAll();
    }

    public boolean registerUser(User user) throws RegisterException {
        try {
            userDAO.save(user);
            return true;
        } catch (Exception e) {
            throw new RegisterException("Registration failed: " + e.getMessage());
        }

    }

}
