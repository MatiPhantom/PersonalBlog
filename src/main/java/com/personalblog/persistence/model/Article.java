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
@Builder
public class Article {

    public static int COUNT = 1;

    private int id;
    private String title;
    private String content;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publishedDate;

    public Article(String title, String content, LocalDate publishedDate) {
        this.title = title;
        this.content = content;
        this.publishedDate = publishedDate;
        this.id = COUNT++;
    }

    public Article() {
        this.id = COUNT++;
    }

}
