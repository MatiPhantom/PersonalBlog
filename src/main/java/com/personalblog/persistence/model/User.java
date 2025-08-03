package com.personalblog.persistence.model;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
public class User {

    public static int COUNT = 1;

    private int id;
    private String name;
    private String role = "USER";
    private String lastName;
    private String email;
    private String password;

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.id = COUNT++;
    }

    public User() {
        this.id = COUNT++;
        this.role = "USER";
    }

}
