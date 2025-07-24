package com.personalblog.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.PostConstruct;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {

    public static int COUNT = 0;

    private int id = COUNT;
    private String title;
    private String content;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publishedDate;

    @PostConstruct
    public void init() {
        this.id = COUNT++;
    }

}
